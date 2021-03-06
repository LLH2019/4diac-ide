/*******************************************************************************
 * Copyright (c) 2015 - 2017 fortiss GmbH
 * 				 2019 Johannes Kepler University Linz
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Monika Wenger, Alois Zoitl
 *     - initial API and implementation and/or initial documentation
 *   Alois Zoitl - cleaned command stack handling for property sections
 *******************************************************************************/
package org.eclipse.fordiac.ide.gef.properties;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.fordiac.ide.model.data.provider.DataItemProviderAdapterFactory;
import org.eclipse.fordiac.ide.model.libraryElement.provider.LibraryElementItemProviderAdapterFactory;
import org.eclipse.fordiac.ide.ui.widget.CommandExecutor;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public abstract class AbstractSection extends AbstractPropertySection implements CommandExecutor {

	protected Object type;
	protected CommandStack commandStack;
	private Composite rightComposite;
	private Composite leftComposite;
	protected boolean createSuperControls = true;
	private ComposedAdapterFactory adapterFactory;

	// block updates triggered by any command
	protected boolean blockRefresh = false;

	protected abstract EObject getType();

	protected abstract Object getInputType(Object input);

	protected abstract void setInputCode();

	protected abstract void setInputInit();

	protected void setType(Object input) {
		type = getInputType(input);
		addContentAdapter();
	}

	@SuppressWarnings("static-method") // this method should be overrideable by subclasses
	protected CommandStack getCommandStack(IWorkbenchPart part, Object input) {
		return part.getAdapter(CommandStack.class);
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		Assert.isTrue(selection instanceof IStructuredSelection);
		Object input = ((IStructuredSelection) selection).getFirstElement();
		commandStack = getCommandStack(part, input);
		if (null == commandStack) { // disable all fields
			setInputCode();
		}
		setType(input);
		setInputInit();
	}

	private final Adapter contentAdapter = new EContentAdapter() {
		@Override
		public void notifyChanged(Notification notification) {
			if (null != getType() && getType().eAdapters().contains(contentAdapter) && !blockRefresh) {
				leftComposite.getDisplay().asyncExec(() -> {
					if (!leftComposite.isDisposed()) {
						refresh();
					}
				});
			}
		}
	};

	@Override
	public void dispose() {
		removeContentAdapter();
		super.dispose();
	}

	protected void removeContentAdapter() {
		if (getType() != null && getType().eAdapters().contains(contentAdapter)) {
			getType().eAdapters().remove(contentAdapter);
		}
	}

	protected void addContentAdapter() {
		if (null != getType() && !getType().eAdapters().contains(contentAdapter)) {
			getType().eAdapters().add(contentAdapter);
		}
	}

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		if (createSuperControls) {
			parent.setLayout(new GridLayout(2, true));
			parent.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
			leftComposite = createComposite(parent);
			rightComposite = createComposite(parent);
		} else {
			leftComposite = parent; // store the parent to be used in the content adapter
			parent.setLayout(new GridLayout(1, true));
			parent.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
		}
	}

	private Composite createComposite(final Composite parent) {
		Composite composite = getWidgetFactory().createComposite(parent);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
		return composite;
	}

	@Override
	public void executeCommand(Command cmd) {
		if (null != type && null != commandStack && null != cmd && cmd.canExecute()) {
			blockRefresh = true;
			commandStack.execute(cmd);
			blockRefresh = false;
		}
	}

	protected Text createGroupText(Composite group, boolean editable) {
		Text text = getWidgetFactory().createText(group, "", SWT.BORDER); //$NON-NLS-1$
		text.setLayoutData(new GridData(SWT.FILL, 0, true, false));
		text.setEditable(editable);
		text.setEnabled(editable);
		return text;
	}

	protected ComposedAdapterFactory getAdapterFactory() {
		if (null == adapterFactory) {
			adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new LibraryElementItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new DataItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		}
		return adapterFactory;
	}

	protected Composite getLeftComposite() {
		return leftComposite;
	}

	protected void setLeftComposite(Composite leftComposite) {
		this.leftComposite = leftComposite;
	}

	protected Composite getRightComposite() {
		return rightComposite;
	}

	protected void setRightComposite(Composite rightComposite) {
		this.rightComposite = rightComposite;
	}
}
