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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.fordiac.ide.model.libraryElement.Algorithm;
import org.eclipse.fordiac.ide.model.libraryElement.BasicFBType;
import org.eclipse.fordiac.ide.model.libraryElement.ECC;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage;

/** <!-- begin-user-doc --> An implementation of the model object '<em><b>Basic FB Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.BasicFBTypeImpl#getECC <em>ECC</em>}</li>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.BasicFBTypeImpl#getAlgorithm <em>Algorithm</em>}</li>
 * </ul>
 *
 * @generated */
public class BasicFBTypeImpl extends BaseFBTypeImpl implements BasicFBType {
	/** The cached value of the '{@link #getECC() <em>ECC</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getECC()
	 * @generated
	 * @ordered */
	protected ECC eCC;

	/** The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered */
	protected EList<Algorithm> algorithm;

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	protected BasicFBTypeImpl() {
		super();
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	protected EClass eStaticClass() {
		return LibraryElementPackage.Literals.BASIC_FB_TYPE;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public ECC getECC() {
		return eCC;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	public NotificationChain basicSetECC(ECC newECC, NotificationChain msgs) {
		ECC oldECC = eCC;
		eCC = newECC;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					LibraryElementPackage.BASIC_FB_TYPE__ECC, oldECC, newECC);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public void setECC(ECC newECC) {
		if (newECC != eCC) {
			NotificationChain msgs = null;
			if (eCC != null)
				msgs = ((InternalEObject) eCC).eInverseRemove(this, LibraryElementPackage.ECC__BASIC_FB_TYPE, ECC.class,
						msgs);
			if (newECC != null)
				msgs = ((InternalEObject) newECC).eInverseAdd(this, LibraryElementPackage.ECC__BASIC_FB_TYPE, ECC.class,
						msgs);
			msgs = basicSetECC(newECC, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryElementPackage.BASIC_FB_TYPE__ECC, newECC,
					newECC));
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public EList<Algorithm> getAlgorithm() {
		if (algorithm == null) {
			algorithm = new EObjectContainmentEList<Algorithm>(Algorithm.class, this,
					LibraryElementPackage.BASIC_FB_TYPE__ALGORITHM);
		}
		return algorithm;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public Algorithm getAlgorithmNamed(final String name) {
		return org.eclipse.fordiac.ide.model.Annotations.getAlgorithmNamed(this, name);
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case LibraryElementPackage.BASIC_FB_TYPE__ECC:
			if (eCC != null)
				msgs = ((InternalEObject) eCC).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - LibraryElementPackage.BASIC_FB_TYPE__ECC, null, msgs);
			return basicSetECC((ECC) otherEnd, msgs);
		default:
			return super.eInverseAdd(otherEnd, featureID, msgs);
		}
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case LibraryElementPackage.BASIC_FB_TYPE__ECC:
			return basicSetECC(null, msgs);
		case LibraryElementPackage.BASIC_FB_TYPE__ALGORITHM:
			return ((InternalEList<?>) getAlgorithm()).basicRemove(otherEnd, msgs);
		default:
			return super.eInverseRemove(otherEnd, featureID, msgs);
		}
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case LibraryElementPackage.BASIC_FB_TYPE__ECC:
			return getECC();
		case LibraryElementPackage.BASIC_FB_TYPE__ALGORITHM:
			return getAlgorithm();
		default:
			return super.eGet(featureID, resolve, coreType);
		}
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case LibraryElementPackage.BASIC_FB_TYPE__ECC:
			setECC((ECC) newValue);
			return;
		case LibraryElementPackage.BASIC_FB_TYPE__ALGORITHM:
			getAlgorithm().clear();
			getAlgorithm().addAll((Collection<? extends Algorithm>) newValue);
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
		case LibraryElementPackage.BASIC_FB_TYPE__ECC:
			setECC((ECC) null);
			return;
		case LibraryElementPackage.BASIC_FB_TYPE__ALGORITHM:
			getAlgorithm().clear();
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
		case LibraryElementPackage.BASIC_FB_TYPE__ECC:
			return eCC != null;
		case LibraryElementPackage.BASIC_FB_TYPE__ALGORITHM:
			return algorithm != null && !algorithm.isEmpty();
		default:
			return super.eIsSet(featureID);
		}
	}

} // BasicFBTypeImpl
