/**
 * *******************************************************************************
 * Copyright (c) 2020 TU Wien/ACIN
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Martin Melik Merkumians - initial API and implementation and/or initial documentation
 * *******************************************************************************
 */
package org.eclipse.fordiac.ide.model.iec61131.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.fordiac.ide.model.iec61131.Program;
import org.eclipse.fordiac.ide.model.iec61131.iec61131Package;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.fordiac.ide.model.libraryElement.impl.FBTypeImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Program</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.fordiac.ide.model.iec61131.impl.ProgramImpl#getFbNetwork
 * <em>Fb Network</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProgramImpl extends FBTypeImpl implements Program {
	/**
	 * The cached value of the '{@link #getFbNetwork() <em>Fb Network</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getFbNetwork()
	 * @generated
	 * @ordered
	 */
	protected FBNetwork fbNetwork;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ProgramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return iec61131Package.Literals.PROGRAM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public FBNetwork getFbNetwork() {
		return fbNetwork;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetFbNetwork(FBNetwork newFbNetwork, NotificationChain msgs) {
		FBNetwork oldFbNetwork = fbNetwork;
		fbNetwork = newFbNetwork;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					iec61131Package.PROGRAM__FB_NETWORK, oldFbNetwork, newFbNetwork);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setFbNetwork(FBNetwork newFbNetwork) {
		if (newFbNetwork != fbNetwork) {
			NotificationChain msgs = null;
			if (fbNetwork != null)
				msgs = ((InternalEObject) fbNetwork).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - iec61131Package.PROGRAM__FB_NETWORK, null, msgs);
			if (newFbNetwork != null)
				msgs = ((InternalEObject) newFbNetwork).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - iec61131Package.PROGRAM__FB_NETWORK, null, msgs);
			msgs = basicSetFbNetwork(newFbNetwork, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, iec61131Package.PROGRAM__FB_NETWORK, newFbNetwork,
					newFbNetwork));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case iec61131Package.PROGRAM__FB_NETWORK:
			return basicSetFbNetwork(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case iec61131Package.PROGRAM__FB_NETWORK:
			return getFbNetwork();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case iec61131Package.PROGRAM__FB_NETWORK:
			setFbNetwork((FBNetwork) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case iec61131Package.PROGRAM__FB_NETWORK:
			setFbNetwork((FBNetwork) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case iec61131Package.PROGRAM__FB_NETWORK:
			return fbNetwork != null;
		}
		return super.eIsSet(featureID);
	}

} // ProgramImpl
