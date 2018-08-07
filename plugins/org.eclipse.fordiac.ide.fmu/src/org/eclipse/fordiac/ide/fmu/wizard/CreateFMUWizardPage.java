/*******************************************************************************
 * Copyright (c) 2007 - 2013 4DIAC - consortium.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.fordiac.ide.fmu.wizard;

import org.eclipse.fordiac.ide.fmu.Activator;
import org.eclipse.fordiac.ide.fmu.Messages;
import org.eclipse.fordiac.ide.fmu.Preferences.FMUPreferencePage;
import org.eclipse.fordiac.ide.fmu.Preferences.PreferenceConstants;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.fordiac.ide.deployment.ui.views.DownloadSelectionTree;
import org.eclipse.fordiac.ide.model.libraryElement.AutomationSystem;
import org.eclipse.fordiac.ide.model.libraryElement.Device;
import org.eclipse.fordiac.ide.model.libraryElement.Resource;
import org.eclipse.fordiac.ide.ui.controls.DirectoryChooserControl;
import org.eclipse.fordiac.ide.ui.controls.IDirectoryChanged;

public class CreateFMUWizardPage extends WizardPage {

	private IStructuredSelection selection;
	private DirectoryChooserControl dcc;
	private DownloadSelectionTree systemTree;
	private Group librariesGroup;
	private Button win32Field;
	public Button getWin32Field() {
		return win32Field;
	}

	public Button getWin64Field() {
		return win64Field;
	}

	public Button getLinux32Field() {
		return linux32Field;
	}


	public Button getLinux64Field() {
		return linux64Field;
	}

	public Button getStoreSelectedLibaries() {
		return storeSelectedLibaries;
	}

	private Button win64Field;
	private Button linux32Field;
	private Button linux64Field;
	private Button storeSelectedLibaries;
	
	public CreateFMUWizardPage(IStructuredSelection selection) {
		super(Messages.FordiacCreateFMUWizard_PageName);
		
		this.selection = selection;
		
		setDescription(Messages.FordiacCreateFMUWizard_PageDESCRIPTION);
		setTitle(Messages.FordiacCreateFMUWizard_PageTITLE);
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setFont(parent.getFont());

		initializeDialogUnits(parent);

		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		createSystemsContainer(composite);
		createDestinationGroup(composite);
		createSelectionLibrariesGroup(composite);
		
		setPageComplete(validatePage());
		// Show description on opening
		setErrorMessage(null);
		setMessage(null);
		setControl(composite);

	}
	
	
	public Object[] getSelectedElements(){
		return systemTree.getCheckedElements();
	}


	private void createSystemsContainer(Composite composite) {
		systemTree = new DownloadSelectionTree( composite, SWT.FULL_SELECTION
						| SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL);
		
		GridData fillBoth = new GridData();
		fillBoth.horizontalAlignment = GridData.FILL;
		fillBoth.grabExcessHorizontalSpace = true;
		fillBoth.verticalAlignment = GridData.FILL;
		fillBoth.grabExcessVerticalSpace = true;
		systemTree.getTree().setLayoutData(fillBoth);
		
		
		systemTree.setInput(this); //the systemTree needs this only as reference
		
		systemTree.addCheckStateListener(new ICheckStateListener() {
			@Override
			public void checkStateChanged(final CheckStateChangedEvent event) {
				setPageComplete(validatePage());
			}
		});
		
		
		checkSelectedElements();
	}
	
	/**
	 * Creates the file name group.
	 * 
	 * @param composite
	 *          the composite
	 */
	private void createDestinationGroup(final Composite composite) {

		GridData stretch = new GridData();
		// stretch.horizontalSpan = 2;
		stretch.grabExcessHorizontalSpace = true;
		stretch.horizontalAlignment = SWT.FILL;

		dcc = new DirectoryChooserControl(composite, SWT.NONE, "Destination: ");
		dcc.addDirectoryChangedListener(new IDirectoryChanged() {

			@Override
			public void directoryChanged(String newDirectory) {
				saveDir(newDirectory);
				setPageComplete(validatePage());
			}
		});

		dcc.setLayoutData(stretch);
		loadDir();
	}
	
	
	/**
	 * Creates the selection libraries group.
	 * 
	 * @param composite
	 *          the composite
	 */
	private void createSelectionLibrariesGroup(final Composite composite) {
		
		librariesGroup = new Group(composite, SWT.NONE);
		librariesGroup.setText("Include the following libraries in exported FMU");
		
		GridLayout gridLayout = new GridLayout(1, false);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 1;

		// Add the fields to the group
		win32Field = new Button(librariesGroup, SWT.CHECK); 
		win32Field.setText("win32");
		win32Field.setEnabled(false);
		win32Field.setSelection(false);
		
		win64Field = new Button(librariesGroup, SWT.CHECK); 
		win64Field.setText("win64");
		win64Field.setEnabled(false);
		win64Field.setSelection(false);
		
		linux32Field = new Button(librariesGroup, SWT.CHECK); 
		linux32Field.setText("linux32");
		linux32Field.setEnabled(false);
		linux32Field.setSelection(false);
		
		linux64Field = new Button(librariesGroup, SWT.CHECK); 
		linux64Field.setText("linux64");
		linux64Field.setEnabled(false);
		linux64Field.setSelection(false);
		
		storeSelectedLibaries = new Button(librariesGroup, SWT.CHECK);
		storeSelectedLibaries.setText("Save selected libraries for future FMU exports");
		storeSelectedLibaries.setEnabled(true);
		storeSelectedLibaries.setSelection(false);
		
		//Enable the found libraries
		for (String found : FMUPreferencePage.getFoundLibraries()){
			if (found.equals(PreferenceConstants.P_FMU_WIN32)){
				win32Field.setEnabled(true);
			}else if(found.equals(PreferenceConstants.P_FMU_WIN64)){
				win64Field.setEnabled(true);
			}
			else if(found.equals(PreferenceConstants.P_FMU_LIN32)){
				linux32Field.setEnabled(true);
			}
			else if(found.equals(PreferenceConstants.P_FMU_LIN64)){
				linux64Field.setEnabled(true);
			}
		}
		
		//Check the selected libraries from preferences
		win32Field.setSelection(Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_FMU_WIN32));
		win64Field.setSelection(Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_FMU_WIN64));
		linux32Field.setSelection(Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_FMU_LIN32));
		linux64Field.setSelection(Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_FMU_LIN64));
		
		
		librariesGroup.setLayoutData(gridData);
		librariesGroup.setLayout(gridLayout);
	}
	
	/**
	 * Returns whether this page's controls currently all contain valid values.
	 * 
	 * @return <code>true</code> if all controls are valid, and <code>false</code>
	 *         if at least one is invalid
	 */
	private boolean validatePage() {
		if (dcc.getDirectory() == null || dcc.getDirectory().equals("")) {
			setErrorMessage("Destination not selected!");
			return false;
		}
				
		if(0 == systemTree.getCheckedElements().length){
			setErrorMessage("Nothing selected for FMU generation!");
			return false;
		}
		
		if ((!win32Field.isEnabled() || !win32Field.getSelection()) 
				&& (!win64Field.isEnabled() || !win64Field.getSelection()) 
				&& (!linux32Field.isEnabled() || !linux32Field.getSelection())
				&& (!linux64Field.isEnabled() && !linux64Field.getSelection())){
			setErrorMessage("No libraries selected to include");
			return false;
		}

		setErrorMessage(null);
		return true;
	}
	
	/**
	 * Loads cached directory, if available.
	 */
	private void loadDir() {
		if (getDialogSettings() != null) {
			String cachedDir = getDialogSettings().get("currentDir");
			if (cachedDir != null) {
				setDirectory(cachedDir);
			}
		}
	}
	
	/**
	 * Sets the directory.
	 * 
	 * @param dir the new directory
	 */
	public void setDirectory(final String dir) {
		dcc.setDirectory(dir);
	}
	
	public String getDirectory() {
		return dcc.getDirectory();
	}
	
	/**
	 * Saves current directory for next session.
	 * 
	 * @param currentDir
	 *          the current dir
	 */
	private void saveDir(final String currentDir) {
		getDialogSettings().put("currentDir", currentDir);
	}

	
	private void checkSelectedElements() {
		
		//first expand all selected elements
		for (Object obj : selection.toArray()) {
			if(obj instanceof AutomationSystem){
				expandSystem((AutomationSystem)obj);
			}else if(obj instanceof Device){
				expandDevice((Device)obj);
			}else if(obj instanceof Resource){
				expandResource((Resource)obj);
			}			
		}
		
		//second select them and then check them.
		systemTree.setSelection(selection);

		systemTree.setCheckedElements(selection.toArray());
	}

	private void expandResource(Resource obj) {
		expandDevice(obj.getDevice());
		//systemTree.setExpandedState(obj, true);
	}

	private void expandDevice(Device obj) {
		expandSystem(obj.getAutomationSystem());
		systemTree.setExpandedState(obj, true);
	}

	private void expandSystem(Object obj) {
		systemTree.setExpandedState(obj, true);
	}

	
}