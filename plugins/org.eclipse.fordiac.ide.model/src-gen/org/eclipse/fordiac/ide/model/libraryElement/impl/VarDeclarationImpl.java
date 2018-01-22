/********************************************************************************
 * Copyright (c) 2008 - 2017 Profactor GmbH, TU Wien ACIN, fortiss GmbH
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.fordiac.ide.model.NameRepository;
import org.eclipse.fordiac.ide.model.data.DataType;
import org.eclipse.fordiac.ide.model.data.VarInitialization;
import org.eclipse.fordiac.ide.model.libraryElement.Connection;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage;
import org.eclipse.fordiac.ide.model.libraryElement.Value;
import org.eclipse.fordiac.ide.model.libraryElement.VarDeclaration;
import org.eclipse.fordiac.ide.model.libraryElement.With;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Var Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.VarDeclarationImpl#getArraySize <em>Array Size</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.VarDeclarationImpl#getVarInitialization <em>Var Initialization</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.VarDeclarationImpl#getWiths <em>Withs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VarDeclarationImpl extends IInterfaceElementImpl implements VarDeclaration {
	/**
	 * The default value of the '{@link #getArraySize() <em>Array Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArraySize()
	 * @generated
	 * @ordered
	 */
	protected static final int ARRAY_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getArraySize() <em>Array Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArraySize()
	 * @generated
	 * @ordered
	 */
	protected int arraySize = ARRAY_SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVarInitialization() <em>Var Initialization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarInitialization()
	 * @generated
	 * @ordered
	 */
	protected VarInitialization varInitialization;

	/**
	 * The cached value of the '{@link #getWiths() <em>Withs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWiths()
	 * @generated
	 * @ordered
	 */
	protected EList<With> withs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VarDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryElementPackage.Literals.VAR_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getArraySize() {
		return arraySize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArraySize(int newArraySize) {
		int oldArraySize = arraySize;
		arraySize = newArraySize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryElementPackage.VAR_DECLARATION__ARRAY_SIZE, oldArraySize, arraySize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		NameRepository.checkNameIdentifier(this);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryElementPackage.VAR_DECLARATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VarInitialization getVarInitialization() {
		if (varInitialization != null && varInitialization.eIsProxy()) {
			InternalEObject oldVarInitialization = (InternalEObject)varInitialization;
			varInitialization = (VarInitialization)eResolveProxy(oldVarInitialization);
			if (varInitialization != oldVarInitialization) {
				InternalEObject newVarInitialization = (InternalEObject)varInitialization;
				NotificationChain msgs = oldVarInitialization.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LibraryElementPackage.VAR_DECLARATION__VAR_INITIALIZATION, null, null);
				if (newVarInitialization.eInternalContainer() == null) {
					msgs = newVarInitialization.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LibraryElementPackage.VAR_DECLARATION__VAR_INITIALIZATION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LibraryElementPackage.VAR_DECLARATION__VAR_INITIALIZATION, oldVarInitialization, varInitialization));
			}
		}
		return varInitialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VarInitialization basicGetVarInitialization() {
		return varInitialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVarInitialization(VarInitialization newVarInitialization, NotificationChain msgs) {
		VarInitialization oldVarInitialization = varInitialization;
		varInitialization = newVarInitialization;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LibraryElementPackage.VAR_DECLARATION__VAR_INITIALIZATION, oldVarInitialization, newVarInitialization);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarInitialization(VarInitialization newVarInitialization) {
		if (newVarInitialization != varInitialization) {
			NotificationChain msgs = null;
			if (varInitialization != null)
				msgs = ((InternalEObject)varInitialization).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LibraryElementPackage.VAR_DECLARATION__VAR_INITIALIZATION, null, msgs);
			if (newVarInitialization != null)
				msgs = ((InternalEObject)newVarInitialization).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LibraryElementPackage.VAR_DECLARATION__VAR_INITIALIZATION, null, msgs);
			msgs = basicSetVarInitialization(newVarInitialization, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryElementPackage.VAR_DECLARATION__VAR_INITIALIZATION, newVarInitialization, newVarInitialization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<With> getWiths() {
		if (withs == null) {
			withs = new EObjectWithInverseResolvingEList<With>(With.class, this, LibraryElementPackage.VAR_DECLARATION__WITHS, LibraryElementPackage.WITH__VARIABLES);
		}
		return withs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isArray() {
		return org.eclipse.fordiac.ide.model.Annotations.GEN.isArray(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LibraryElementPackage.VAR_DECLARATION__WITHS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getWiths()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LibraryElementPackage.VAR_DECLARATION__VAR_INITIALIZATION:
				return basicSetVarInitialization(null, msgs);
			case LibraryElementPackage.VAR_DECLARATION__WITHS:
				return ((InternalEList<?>)getWiths()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LibraryElementPackage.VAR_DECLARATION__ARRAY_SIZE:
				return getArraySize();
			case LibraryElementPackage.VAR_DECLARATION__VAR_INITIALIZATION:
				if (resolve) return getVarInitialization();
				return basicGetVarInitialization();
			case LibraryElementPackage.VAR_DECLARATION__WITHS:
				return getWiths();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LibraryElementPackage.VAR_DECLARATION__ARRAY_SIZE:
				setArraySize((Integer)newValue);
				return;
			case LibraryElementPackage.VAR_DECLARATION__VAR_INITIALIZATION:
				setVarInitialization((VarInitialization)newValue);
				return;
			case LibraryElementPackage.VAR_DECLARATION__WITHS:
				getWiths().clear();
				getWiths().addAll((Collection<? extends With>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LibraryElementPackage.VAR_DECLARATION__ARRAY_SIZE:
				setArraySize(ARRAY_SIZE_EDEFAULT);
				return;
			case LibraryElementPackage.VAR_DECLARATION__VAR_INITIALIZATION:
				setVarInitialization((VarInitialization)null);
				return;
			case LibraryElementPackage.VAR_DECLARATION__WITHS:
				getWiths().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LibraryElementPackage.VAR_DECLARATION__ARRAY_SIZE:
				return arraySize != ARRAY_SIZE_EDEFAULT;
			case LibraryElementPackage.VAR_DECLARATION__VAR_INITIALIZATION:
				return varInitialization != null;
			case LibraryElementPackage.VAR_DECLARATION__WITHS:
				return withs != null && !withs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (arraySize: ");
		result.append(arraySize);
		result.append(')');
		return result.toString();
	}


} //VarDeclarationImpl
