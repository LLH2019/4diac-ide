/**
 * *******************************************************************************
 *  Copyright (c) 2008 - 2017 Profactor GmbH, TU Wien ACIN, fortiss GmbH
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *    Gerhard Ebenhofer, Alois Zoitl, Ingo Hegny, Monika Wenger, Martin Jobst
 *      - initial API and implementation and/or initial documentation
 * *******************************************************************************
 */
package org.eclipse.fordiac.ide.model.libraryElement.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage;
import org.eclipse.fordiac.ide.model.libraryElement.TextAlgorithm;

/** This is the item provider adapter for a {@link org.eclipse.fordiac.ide.model.libraryElement.TextAlgorithm} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated */
public class TextAlgorithmItemProvider extends AlgorithmItemProvider {
	/** This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	public TextAlgorithmItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/** This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addTextPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/** This adds a property descriptor for the Text feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	protected void addTextPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_TextAlgorithm_text_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_TextAlgorithm_text_feature", //$NON-NLS-1$ //$NON-NLS-2$
								"_UI_TextAlgorithm_type"),  //$NON-NLS-1$
						LibraryElementPackage.Literals.TEXT_ALGORITHM__TEXT, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/** This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public String getText(Object object) {
		String label = ((TextAlgorithm) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_TextAlgorithm_type") : //$NON-NLS-1$
				getString("_UI_TextAlgorithm_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/** This handles model notifications by calling {@link #updateChildren} to update any cached children and by
	 * creating a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(TextAlgorithm.class)) {
		case LibraryElementPackage.TEXT_ALGORITHM__TEXT:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		default:
			super.notifyChanged(notification);
			return;
		}
	}

	/** This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that can be created
	 * under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
