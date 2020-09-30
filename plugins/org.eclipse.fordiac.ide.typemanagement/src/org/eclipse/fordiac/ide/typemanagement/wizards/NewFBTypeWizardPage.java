/*******************************************************************************
 * Copyright (c) 2010 - 2020 Profactor GmbH, TU Wien ACIN, fortiss GmbH,
 * 							 Johannes Kepler University
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Gerhard Ebenhofer, Alois Zoitl, Gerd Kainz
 *     - initial API and implementation and/or initial documentation
 *   Alois Zoitl - reworked type selection to a type list with description
 *   Bianca Wiesmayr - extracted TableViewer creation
 *   Daniel Lindhuber - added Data Type
 *   Lisa Sonnleithner - added duplicate check
 *   Martin Melik Merkumians - fixed Comment regex to accept score and underscore,
 *                         added case when description is null
 *                         replaced magic strings with constants for file endings
 *******************************************************************************/
package org.eclipse.fordiac.ide.typemanagement.wizards;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.fordiac.ide.model.IdentifierVerifyer;
import org.eclipse.fordiac.ide.model.typelibrary.TypeLibrary;
import org.eclipse.fordiac.ide.model.typelibrary.TypeLibraryTags;
import org.eclipse.fordiac.ide.typemanagement.Activator;
import org.eclipse.fordiac.ide.typemanagement.Messages;
import org.eclipse.fordiac.ide.ui.FordiacMessages;
import org.eclipse.fordiac.ide.ui.widget.TableWidgetFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class NewFBTypeWizardPage extends WizardNewFileCreationPage {
	private static final Pattern NAME_PATTERN = Pattern.compile("Name=\"\\w+\""); //$NON-NLS-1$
	private static final Pattern COMMENT_PATTERN = Pattern.compile("Comment=\"[\\w\\s-_]+\""); //$NON-NLS-1$

	private Button openTypeCheckbox;
	private int openTypeParentHeight = -1;
	private boolean openType = true;
	private TableViewer templateTableViewer;

	private static class TemplateInfo {
		private File templateFile;
		private String templateName;
		private String templateDescription;

		public TemplateInfo(File templateFile, String templateName, String templateDescription) {
			this.templateFile = templateFile;
			this.templateName = templateName;
			this.templateDescription = templateDescription;
		}
	}

	private TemplateInfo[] templateList;

	private static class TypeTemplatesLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof TemplateInfo) {
				switch (columnIndex) {
				case 0:
					return ((TemplateInfo) element).templateName;
				case 1:
					return ((TemplateInfo) element).templateDescription;
				default:
					break;
				}
			}
			return ""; //$NON-NLS-1$
		}
	}

	public NewFBTypeWizardPage(IStructuredSelection selection) {
		super(Messages.NewFBTypeWizardPage_NewTypePage, selection);
		this.setTitle(Messages.NewFBTypeWizardPage_CreateNewType);
		this.setDescription(Messages.NewFBTypeWizardPage_CreateNewTypeFromTemplateType);
		this.setAllowExistingResources(true); // needed for correct duplicate type check
		loadTypeTemplates();
	}

	@Override
	public void createControl(final Composite parent) {
		super.createControl(parent);
		Composite composite = (Composite) getControl();
		// Show description on opening
		setErrorMessage(null);
		setMessage(null);
		setControl(composite);
	}

	@Override
	protected boolean validatePage() {
		if ((null == templateList) || (0 == templateList.length)) {
			setErrorMessage(Messages.NewFBTypeWizardPage_NoTypeTemplatesFoundCheckTemplatesDirectory);
			return false;
		}
		if (super.getFileName().isEmpty()) {
			setErrorMessage(Messages.NewFBTypeWizardPage_EmptyTypenameIsNotValid);
			return false;
		}

		// use super.getFileName here to get the type name without extension
		String errorMessage = IdentifierVerifyer.isValidIdentifierWithErrorMessage(super.getFileName());
		if (null != errorMessage) {
			setErrorMessage(errorMessage);
			return false;
		}

		if (null == getTemplate()) {
			setErrorMessage(Messages.NewFBTypeWizardPage_NoTypeSelected);
			return false;
		}

		// Check for duplicates in typelib if a project is selected
		if (null != getContainerFullPath() && isDuplicate()) {
			setErrorMessage(MessageFormat.format(Messages.NewFBTypeWizardPage_TypeAlreadyExists, getFileName()));
			return false;
		}

		return super.validatePage();
	}

	private boolean isDuplicate() {
		// here: getContainerFullPath().segment(0) --> name of the selected project
		TypeLibrary lib = TypeLibrary
				.getTypeLibrary(ResourcesPlugin.getWorkspace().getRoot().getProject(getContainerFullPath().segment(0)));

		String[] s = getTemplate().getName().split("\\."); //$NON-NLS-1$
		String fileExtension = s[s.length - 1].toUpperCase();
		if (fileExtension.equals(TypeLibraryTags.DATA_TYPE_FILE_ENDING)) {
			return isDtpDuplicate(lib);
		} else {
			return isSubFbtAdpDuplicate(lib, fileExtension);
		}

	}

	private boolean isSubFbtAdpDuplicate(TypeLibrary lib, String fileExtension) {
		EMap<String, ?> map = null;

		switch (fileExtension) {
		case TypeLibraryTags.SUBAPP_TYPE_FILE_ENDING:
			map = lib.getBlockTypeLib().getSubAppTypes();
			break;
		case TypeLibraryTags.FB_TYPE_FILE_ENDING:
			map = lib.getBlockTypeLib().getFbTypes();
			break;
		case TypeLibraryTags.ADAPTER_TYPE_FILE_ENDING:
			map = lib.getBlockTypeLib().getAdapterTypes();
			break;
		default:
			break;
		}
		return (null != map) && (map.containsKey(super.getFileName()));
	}

	private boolean isDtpDuplicate(TypeLibrary lib) {
		Map<String, ?> map = lib.getDataTypeLibrary().getDerivedDataTypes();
		return map.containsKey(super.getFileName());
	}

	public File getTemplate() {
		if (templateTableViewer.getSelection() instanceof StructuredSelection) {
			Object selection = templateTableViewer.getStructuredSelection().getFirstElement();
			return (selection instanceof TemplateInfo) ? ((TemplateInfo) selection).templateFile : null;
		}
		return null;
	}

	@Override
	protected String getNewFileLabel() {
		return FordiacMessages.TypeName + ":"; //$NON-NLS-1$
	}

	@Override
	public String getFileName() {
		String retval = super.getFileName();
		if (null != getTemplate()) {
			String[] splited = getTemplate().getName().split("\\."); //$NON-NLS-1$
			if (2 == splited.length) {
				retval = retval + "." + splited[1]; //$NON-NLS-1$
			}
		}
		return retval;
	}

	public boolean getOpenType() {
		return openType;
	}

	@Override
	protected void createAdvancedControls(Composite parent) {
		createTemplateTypeSelection(parent);
		super.createAdvancedControls(parent);
	}

	private void createTemplateTypeSelection(Composite parent) {
		Label fbTypeTypeLabel = new Label(parent, SWT.NONE);
		fbTypeTypeLabel.setText(FordiacMessages.SelectType + ":"); //$NON-NLS-1$
		fbTypeTypeLabel.setFont(parent.getFont());

		templateTableViewer = TableWidgetFactory.createPropertyTableViewer(parent, SWT.SINGLE);
		configureTypeTableLayout(templateTableViewer.getTable());

		templateTableViewer.setContentProvider(new ArrayContentProvider());
		templateTableViewer.setLabelProvider(new TypeTemplatesLabelProvider());

		templateTableViewer.setInput(templateList);

		templateTableViewer.addSelectionChangedListener(ev -> handleEvent(null));

		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
		data.widthHint = 250;
		templateTableViewer.getControl().setLayoutData(data);
	}

	private static void configureTypeTableLayout(Table table) {
		TableColumn tc = new TableColumn(table, SWT.LEFT);
		tc.setText(FordiacMessages.Name);

		tc = new TableColumn(table, SWT.LEFT);
		tc.setText(FordiacMessages.Description);

		TableLayout tabLayout = new TableLayout();
		tabLayout.addColumnData(new ColumnWeightData(1, 30));
		tabLayout.addColumnData(new ColumnWeightData(2, 70));
		table.setLayout(tabLayout);
	}

	private void loadTypeTemplates() {
		String templateFolderPath = Platform.getInstallLocation().getURL().getFile();
		File templateFolder = new File(templateFolderPath + File.separatorChar + "template"); //$NON-NLS-1$
		FileFilter ff = createTemplatesFileFilter();
		if (templateFolder.isDirectory()) {
			File[] files = templateFolder.listFiles(ff);
			if (null != files) {
				Arrays.sort(files);
				templateList = new TemplateInfo[files.length];
				for (int i = 0; i < files.length; i++) {
					templateList[i] = createTemplateFileInfo(files[i]);
				}
			}
		}
	}

	@SuppressWarnings("static-method") // this method is need to allow sub-classes to override it with specific filters
	protected FileFilter createTemplatesFileFilter() {
		return pathname -> pathname.getName().toUpperCase().endsWith(TypeLibraryTags.FB_TYPE_FILE_ENDING_WITH_DOT)
				|| pathname.getName().toUpperCase().endsWith(TypeLibraryTags.ADAPTER_TYPE_FILE_ENDING_WITH_DOT)
				|| pathname.getName().toUpperCase().endsWith(TypeLibraryTags.DATA_TYPE_FILE_ENDING_WITH_DOT)
				|| pathname.getName().toUpperCase().endsWith(TypeLibraryTags.PROGRAM_TYPE_FILE_ENDING_WITH_DOT)
				|| pathname.getName().toUpperCase().endsWith(TypeLibraryTags.SUBAPP_TYPE_FILE_ENDING_WITH_DOT);
	}

	private static TemplateInfo createTemplateFileInfo(File f) {
		Scanner scanner = null;
		String name = f.getName();
		String description = ""; //$NON-NLS-1$
		try {
			// we need a new scanner
			scanner = new Scanner(f);
			name = scanner.findWithinHorizon(NAME_PATTERN, 0);
			name = name.substring(6, name.length() - 1);
			scanner.close();
			// we need a new scanner as name and comment may be in arbitrary order
			scanner = new Scanner(f);
			description = scanner.findWithinHorizon(COMMENT_PATTERN, 0);
			if (null == description) {
				description = Messages.NewFBTypeWizardPage_InvalidOrNoComment;
			} else {
				description = description.substring(9, description.length() - 1);
			}
		} catch (FileNotFoundException e) {
			Activator.getDefault().logError(Messages.NewFBTypeWizardPage_CouldNotFindTemplateFiles, e);
		} finally {
			if (null != scanner) {
				scanner.close();
			}
		}
		return new TemplateInfo(f, name, description);
	}

	@Override
	protected void handleAdvancedButtonSelect() {
		Shell shell = getShell();
		Point shellSize = shell.getSize();
		Composite composite = (Composite) getControl();

		if (null != openTypeCheckbox) {
			openTypeCheckbox.dispose();
			openTypeCheckbox = null;
			shell.setSize(shellSize.x, shellSize.y - openTypeParentHeight);
		} else {
			openTypeCheckbox = createOpenTypeGroup(composite);
			if (-1 == openTypeParentHeight) {
				Point groupSize = openTypeCheckbox.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
				openTypeParentHeight = groupSize.y;
			}
			shell.setSize(shellSize.x, shellSize.y + openTypeParentHeight);
		}
		super.handleAdvancedButtonSelect();
	}

	private Button createOpenTypeGroup(Composite parent) {
		openTypeCheckbox = new Button(parent, SWT.CHECK);
		openTypeCheckbox.setText(Messages.NewFBTypeWizardPage_OpenTypeForEditingWhenDone);
		openTypeCheckbox.setSelection(true);
		setPageComplete(validatePage());
		openTypeCheckbox.addListener(SWT.Selection, ev -> openType = openTypeCheckbox.getSelection());
		return openTypeCheckbox;
	}

}
