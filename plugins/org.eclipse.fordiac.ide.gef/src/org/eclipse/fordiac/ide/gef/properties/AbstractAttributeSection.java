/*******************************************************************************
 * Copyright (c) 2017 fortiss GmbH
 * 
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 3
 *******************************************************************************/
package org.eclipse.fordiac.ide.gef.properties;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.fordiac.ide.gef.DiagramEditorWithFlyoutPalette;
import org.eclipse.fordiac.ide.model.commands.change.AttributeChangeCommand;
import org.eclipse.fordiac.ide.model.commands.create.AttributeCreateCommand;
import org.eclipse.fordiac.ide.model.commands.delete.AttributeDeleteCommand;
import org.eclipse.fordiac.ide.model.data.BaseType1;
import org.eclipse.fordiac.ide.model.libraryElement.Application;
import org.eclipse.fordiac.ide.model.libraryElement.Attribute;
import org.eclipse.fordiac.ide.model.libraryElement.AttributeDeclaration;
import org.eclipse.fordiac.ide.model.libraryElement.ConfigurableObject;
import org.eclipse.fordiac.ide.model.libraryElement.Device;
import org.eclipse.fordiac.ide.model.libraryElement.IInterfaceElement;
import org.eclipse.fordiac.ide.model.libraryElement.Segment;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public abstract class AbstractAttributeSection extends AbstractSection {
	protected static boolean isInheritable = false;
	protected final String VALUE = "value"; //$NON-NLS-1$
	protected final String INITVALUE = "initial value"; //$NON-NLS-1$
	private TableViewer attributeViewer;
	private final String NAME = "name"; //$NON-NLS-1$
	private final String TYPE = "type"; //$NON-NLS-1$
	private final String COMMENT = "comment"; //$NON-NLS-1$
	private Button attributeNew;
	private Button attributeDelete;
	
	protected abstract ConfigurableObject getInputType(Object input);
	@Override
	protected abstract EObject getType();
	
	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage tabbedPropertySheetPage) {
		createSuperControls = false;
		super.createControls(parent, tabbedPropertySheetPage);	
		parent.setLayout(new GridLayout(2, false));
		parent.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
		createInputInfoGroup(parent);
		createNewDeleteButton(parent);
	}
	
	private void createNewDeleteButton(Composite parent) {
		Composite composite = getWidgetFactory().createComposite(parent);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(SWT.NONE, SWT.FILL, false, true));
		attributeNew = getWidgetFactory().createButton(composite, "", SWT.PUSH);
		attributeNew.setToolTipText("create attribute");
		attributeNew.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ADD));	
		attributeNew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {	
				if(type instanceof ConfigurableObject){
					executeCommand(new AttributeCreateCommand((ConfigurableObject) type, isInheritable));
					attributeViewer.refresh();
				}
			}
		});
		attributeDelete = getWidgetFactory().createButton(composite, "", SWT.PUSH);
		attributeDelete.setToolTipText("delete selected attribute");
		attributeDelete.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
		attributeDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				executeCommand(new AttributeDeleteCommand((ConfigurableObject) type, (Attribute)((IStructuredSelection) attributeViewer.getSelection()).getFirstElement()));
				attributeViewer.refresh();
			}
		});
	}

	private String[] getDataTypes() {
		List<BaseType1> list = Arrays.asList(BaseType1.values()); 
		Collections.sort(list);
		String types[] = new String[list.size()];
		int i = 0; 
		for(BaseType1 type : list) {
			types[i++] = type.getName();
		}	
		return types;
	}
	
	private void createInputInfoGroup(Composite parent) {		
		attributeViewer = new TableViewer(parent, SWT.FULL_SELECTION | SWT.MULTI | SWT.H_SCROLL | SWT.FILL);
		GridData gridDataVersionViewer = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridDataVersionViewer.minimumHeight = 80;
		gridDataVersionViewer.widthHint = 400;
		attributeViewer.getControl().setLayoutData(gridDataVersionViewer);
		final Table table = attributeViewer.getTable();
		table.setLinesVisible(true);		
		table.setHeaderVisible(true);
		TableColumn column1 = new TableColumn(attributeViewer.getTable(), SWT.LEFT);
		column1.setText(NAME);
		TableColumn column2 = new TableColumn(attributeViewer.getTable(), SWT.LEFT);
		column2.setText(TYPE); 
		TableColumn column3 = new TableColumn(attributeViewer.getTable(), SWT.LEFT);
		if(isInheritable) {	
			column3.setText(INITVALUE); 
		}else {			
			column3.setText(VALUE); 
		}
		TableColumn column4 = new TableColumn(attributeViewer.getTable(), SWT.LEFT);
		column4.setText(COMMENT);
		TableLayout layout = new TableLayout();
		layout.addColumnData(new ColumnWeightData(20, 70));
		layout.addColumnData(new ColumnWeightData(30, 70));
		layout.addColumnData(new ColumnWeightData(30, 70));
		layout.addColumnData(new ColumnWeightData(50, 90));
		table.setLayout(layout);	
		attributeViewer.setContentProvider(new InputContentProvider(isInheritable));
		attributeViewer.setLabelProvider(new InputLabelProvider());		
		attributeViewer.setCellEditors(new CellEditor[] {
				new TextCellEditor(table), 
				new ComboBoxCellEditor(table, getDataTypes(), SWT.READ_ONLY),
				new TextCellEditor(table, SWT.MULTI | SWT.V_SCROLL), 
				new TextCellEditor(table)
		});
		if(isInheritable) {			
			attributeViewer.setColumnProperties(new String[] {NAME, TYPE, INITVALUE, COMMENT});
		}else {
			attributeViewer.setColumnProperties(new String[] {NAME, TYPE, VALUE, COMMENT});
		}
		attributeViewer.setCellModifier(new ICellModifier() {
			public boolean canModify(final Object element, final String property) {
				if(element instanceof Attribute && property == TYPE && null != ((Attribute)element).getAttributeDeclaration()) {
					return false;
				}
				return true;
			}
			public Object getValue(final Object element, final String property) {
				if(element instanceof Attribute) {					
					switch (property) {
					case NAME:
						return ((Attribute) element).getName();
					case VALUE:
						return ((Attribute) element).getValue();
					case TYPE:
						return ((Attribute) element).getType().getValue();
					case COMMENT:
						return ((Attribute) element).getComment();
					default:
						return null;
					}
				}
				if(element instanceof AttributeDeclaration) {					
					switch (property) {
					case NAME:
						return ((AttributeDeclaration) element).getName();
					case INITVALUE:
						return ((AttributeDeclaration) element).getInitialValue();
					case TYPE:
						return ((AttributeDeclaration) element).getType().getValue();
					case COMMENT:
						return ((AttributeDeclaration) element).getComment();
					default:
						return null;
					}
				}
				return null;
			}
			public void modify(final Object element, final String property, final Object value) {
				Object data = ((TableItem) element).getData();
				AttributeChangeCommand cmd = null;
				if(data instanceof Attribute) {							
					switch (property) {
					case NAME:
						cmd = new AttributeChangeCommand((Attribute)data, value.toString(), null, null, null);
						break;
					case VALUE:
						cmd = new AttributeChangeCommand((Attribute)data, null, value.toString(), null, null);
						break;
					case TYPE:
						cmd = new AttributeChangeCommand((Attribute)data, null, null, BaseType1.get((Integer)value), null);
						break;
					case COMMENT:
						cmd = new AttributeChangeCommand((Attribute)data, null, null, null, value.toString());
						break;
					}
				}
				if(data instanceof AttributeDeclaration) {							
					switch (property) {
					case NAME:
						cmd = new AttributeChangeCommand((AttributeDeclaration)data, value.toString(), null, null, null);
						break;
					case INITVALUE:
						cmd = new AttributeChangeCommand((AttributeDeclaration)data, null, value.toString(), null, null);
						break;
					case TYPE:
						cmd = new AttributeChangeCommand((AttributeDeclaration)data, null, null, BaseType1.get((Integer)value), null);
						break;
					case COMMENT:
						cmd = new AttributeChangeCommand((AttributeDeclaration)data, null, null, null, value.toString());
						break;
					}
				}
				executeCommand(cmd);
				attributeViewer.refresh(data);
			}
		});
	}
	
	@Override
	public void refresh() {
		super.refresh();
		if(null != type) {
			attributeViewer.setInput(getType());
		}
	}


	@Override
	protected CommandStack getCommandStack(IWorkbenchPart part, Object input) {
		if(part instanceof DiagramEditorWithFlyoutPalette){
			return ((DiagramEditorWithFlyoutPalette)part).getCommandStack();
		}
		return null;
	}

	@Override
	protected void setInputCode() {	
		attributeViewer.setCellModifier(null);
	}
	
	@Override
	protected void setInputInit() {
		//nothing to do
	}
	
	public class InputContentProvider implements IStructuredContentProvider {
		private boolean isInheritable;
		
		public InputContentProvider(boolean isInheritable) {
			this.isInheritable = isInheritable;
		}
		
		@Override
		public Object[] getElements(final Object inputElement) {
			if(isInheritable) {
				if(inputElement instanceof IInterfaceElement){
					return ((IInterfaceElement)inputElement).getAttributeDeclarations().toArray();
				}
			}else {				
				if(inputElement instanceof Application){
					return ((Application)inputElement).getAttributes().toArray();
				}
				if(inputElement instanceof Device){
					return ((Device)inputElement).getAttributes().toArray();
				}
				if(inputElement instanceof Segment){
					return ((Segment)inputElement).getAttributes().toArray();
				}
				if(inputElement instanceof IInterfaceElement){
					return ((IInterfaceElement)inputElement).getAttributes().toArray();
				}
			}
			return new Object[] {};
		}
	}
	
	public class InputLabelProvider extends LabelProvider implements ITableLabelProvider {
		@Override
		public Image getColumnImage(final Object element, final int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(final Object element, final int columnIndex) {
			if (element instanceof Attribute) {
				switch (columnIndex) {
				case 0:
					return ((Attribute) element).getName();
				case 1:
					return ((Attribute) element).getType().getName();
				case 2:
					return ((Attribute) element).getValue();
				case 3:
					return ((Attribute) element).getComment() != null ? ((Attribute) element).getComment() : ""; //$NON-NLS-1$
				default:
					break;
				}
			}
			if (element instanceof AttributeDeclaration) {
				switch (columnIndex) {
				case 0:
					return ((AttributeDeclaration) element).getName();
				case 1:
					return ((AttributeDeclaration) element).getType().getName();
				case 2:
					return ((AttributeDeclaration) element).getInitialValue();
				case 3:
					return ((AttributeDeclaration) element).getComment() != null ? ((AttributeDeclaration) element).getComment() : ""; //$NON-NLS-1$
				default:
					break;
				}
			}
			return element.toString();
		}
	}
}

