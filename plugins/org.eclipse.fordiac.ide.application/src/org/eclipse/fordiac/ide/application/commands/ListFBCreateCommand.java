/*******************************************************************************
 * Copyright (c) 2011 - 2017 Profactor GmbH, TU Wien ACIN, fortiss GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Michael Hofmann, Gerhard Ebenhofer, Alois Zoitl, Monika Wenger
 *   - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.application.commands;

import org.eclipse.fordiac.ide.application.Messages;
import org.eclipse.fordiac.ide.application.utilities.CreationPopupDialog;
import org.eclipse.fordiac.ide.application.utilities.ICreationExecutor;
import org.eclipse.fordiac.ide.model.Palette.FBTypePaletteEntry;
import org.eclipse.fordiac.ide.model.commands.create.FBCreateCommand;
import org.eclipse.fordiac.ide.model.libraryElement.AutomationSystem;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.fordiac.ide.model.libraryElement.IInterfaceElement;
import org.eclipse.fordiac.ide.model.libraryElement.Value;
import org.eclipse.fordiac.ide.model.libraryElement.VarDeclaration;
import org.eclipse.fordiac.ide.ui.errormessages.ErrorMessenger;
import org.eclipse.fordiac.ide.ui.imageprovider.FordiacImage;
import org.eclipse.fordiac.ide.util.dnd.TransferDataSelectionFBParameter;
import org.eclipse.fordiac.ide.util.dnd.TransferDataSelectionOfFb;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class ListFBCreateCommand extends FBCreateCommand {
	private FBTypePaletteEntry[] typeList;
	private TransferDataSelectionOfFb[] selectionList;
	private AutomationSystem system;

	/**
	 * Instantiates a new fB create command.
	 *
	 * @param type   the type
	 * @param parent the parent
	 * @param bounds the bounds
	 */
	public ListFBCreateCommand(final FBTypePaletteEntry[] type, final FBNetwork parent, int x, int y) {
		super(null, parent, x, y); // values will be set in execute()
		typeList = type.clone();
		selectionList = null;
		system = parent.getAutomationSystem();
	}

	public ListFBCreateCommand(final TransferDataSelectionOfFb[] fbList, final FBNetwork parent, int x, int y) {
		super(null, parent, x, y); // values will be set in execute()
		typeList = null;
		selectionList = fbList.clone();
		this.system = parent.getAutomationSystem();
	}

	@Override
	public boolean canExecute() {
		if (typeList != null) {
			return typeList.length != 0;
		} else if (selectionList != null) {
			return selectionList.length != 0;
		}
		return false;
	}

	private void executeTransferData() {

		CreationPopupDialog pd = new CreationPopupDialog(Display.getCurrent().getActiveShell(),
				PopupDialog.HOVER_SHELLSTYLE, true, false, false, false, false, null, null, typeList,
				new LabelProvider() {
					@Override
					public String getText(Object element) {
						if (element instanceof FBTypePaletteEntry) {
							return ((FBTypePaletteEntry) element).getLabel();
						}
						return super.getText(element);
					}

					@Override
					public Image getImage(Object element) {
						if (element instanceof FBTypePaletteEntry) {
							return FordiacImage.ICON_FB.getImage();
						}
						return super.getImage(element);
					}
				}, new ICreationExecutor() {

					@Override
					public void execute(Object res) {
						if (res instanceof TransferDataSelectionOfFb) {
							TransferDataSelectionOfFb element = ((TransferDataSelectionOfFb) res);
							// get PaletteEntry for fbTypeName
							FBTypePaletteEntry entry = system.getPalette().getFBTypeEntry(element.getFbTypeName());
							if (null != entry) {
								element.setTypePaletteEntry(entry);
								ListFBCreateCommand.this.setPaletteEntry(element.getTypePaletteEntry());
								ListFBCreateCommand.super.execute();

								for (TransferDataSelectionFBParameter fbParametert : element.getFbParameters()) {
									IInterfaceElement fbInterfaceElement = ListFBCreateCommand.this.getElement()
											.getInterfaceElement(fbParametert.getName());
									if (fbInterfaceElement instanceof VarDeclaration) {
										Value val = ((VarDeclaration) fbInterfaceElement).getValue();
										val.setValue(fbParametert.getValue());
									}
								}
							} else {
								// warning/info in statusline that fbtype can not be found
								ErrorMessenger.popUpErrorMessage(Messages.ListFBCreateCommand_FBTypeNotFound);
							}
						}

					}
				}) {

		};
		pd.open();

	}

	private void executeFBTypePalette() {

		CreationPopupDialog pd = new CreationPopupDialog(Display.getCurrent().getActiveShell(),
				PopupDialog.HOVER_SHELLSTYLE, true, false, false, false, false, null, null, typeList,
				new LabelProvider() {
					@Override
					public String getText(Object element) {
						if (element instanceof FBTypePaletteEntry) {
							return ((FBTypePaletteEntry) element).getLabel();
						}
						return super.getText(element);
					}

					@Override
					public Image getImage(Object element) {
						if (element instanceof FBTypePaletteEntry) {
							return FordiacImage.ICON_FB.getImage();
						}
						return super.getImage(element);
					}
				}, new ICreationExecutor() {

					@Override
					public void execute(Object res) {
						if (res instanceof FBTypePaletteEntry) {
							ListFBCreateCommand.this.setPaletteEntry((FBTypePaletteEntry) res);
							ListFBCreateCommand.super.execute();
						}
					}
				}) {

		};
		pd.open();

	}

	@Override
	public void execute() {
		if (selectionList != null && system != null) {
			executeTransferData();
		}
		if (typeList != null) {
			executeFBTypePalette();
		}

	}

}
