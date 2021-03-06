/********************************************************************************
 * Copyright (c) 2008 - 2017 Profactor GmbH, TU Wien ACIN, fortiss GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Gerhard Ebenhofer, Alois Zoitl, Ingo Hegny, Monika Wenger
 *    - initial API and implementation and/or initial documentation
 ********************************************************************************/
package org.eclipse.fordiac.ide.model.libraryElement.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.fordiac.ide.model.Palette.PaletteEntry;
import org.eclipse.fordiac.ide.model.data.impl.DataTypeImpl;
import org.eclipse.fordiac.ide.model.libraryElement.AdapterFBType;
import org.eclipse.fordiac.ide.model.libraryElement.AdapterType;
import org.eclipse.fordiac.ide.model.libraryElement.InterfaceList;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage;

/** <!-- begin-user-doc --> An implementation of the model object '<em><b>Adapter Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.AdapterTypeImpl#getAdapterFBType <em>Adapter FB
 * Type</em>}</li>
 * </ul>
 *
 * @generated */
public class AdapterTypeImpl extends DataTypeImpl implements AdapterType {
	/** The cached value of the '{@link #getAdapterFBType() <em>Adapter FB Type</em>}' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getAdapterFBType()
	 * @generated
	 * @ordered */
	protected AdapterFBType adapterFBType;

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	protected AdapterTypeImpl() {
		super();
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	protected EClass eStaticClass() {
		return LibraryElementPackage.Literals.ADAPTER_TYPE;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public InterfaceList getInterfaceList() {
		return org.eclipse.fordiac.ide.model.Annotations.getInterfaceList(this);
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public AdapterFBType getAdapterFBType() {
		return adapterFBType;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public void setAdapterFBType(AdapterFBType newAdapterFBType) {
		AdapterFBType oldAdapterFBType = adapterFBType;
		adapterFBType = newAdapterFBType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryElementPackage.ADAPTER_TYPE__ADAPTER_FB_TYPE,
					oldAdapterFBType, adapterFBType));
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public AdapterFBType getPlugType() {
		return org.eclipse.fordiac.ide.model.Annotations.getPlugType(this);
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public AdapterFBType getSocketType() {
		return org.eclipse.fordiac.ide.model.Annotations.getSocketType(this);
	}

	@Override
	public NotificationChain basicSetPaletteEntry(PaletteEntry newPaletteEntry, NotificationChain msgs) {
		if (null != adapterFBType) {
			adapterFBType.setPaletteEntry(newPaletteEntry);
		}
		return super.basicSetPaletteEntry(newPaletteEntry, msgs);
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case LibraryElementPackage.ADAPTER_TYPE__ADAPTER_FB_TYPE:
			return getAdapterFBType();
		default:
			return super.eGet(featureID, resolve, coreType);
		}
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case LibraryElementPackage.ADAPTER_TYPE__ADAPTER_FB_TYPE:
			setAdapterFBType((AdapterFBType) newValue);
			return;
		default:
			super.eSet(featureID, newValue);
			return;
		}
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case LibraryElementPackage.ADAPTER_TYPE__ADAPTER_FB_TYPE:
			setAdapterFBType((AdapterFBType) null);
			return;
		default:
			super.eUnset(featureID);
			return;
		}
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case LibraryElementPackage.ADAPTER_TYPE__ADAPTER_FB_TYPE:
			return adapterFBType != null;
		default:
			return super.eIsSet(featureID);
		}
	}

	// TODO move to model and annotations
	@Override
	public void setName(String value) {
		super.setName(value);
		if (null != getAdapterFBType()) {
			getAdapterFBType().setName(value);
		}
	}

	// TODO move to model and annotations
	@Override
	public void setComment(String value) {
		super.setComment(value);
		if (null != getAdapterFBType()) {
			getAdapterFBType().setComment(value);
		}
	}

} // AdapterTypeImpl
