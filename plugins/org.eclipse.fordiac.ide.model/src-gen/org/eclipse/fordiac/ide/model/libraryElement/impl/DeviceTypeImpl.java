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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.fordiac.ide.model.libraryElement.AttributeDeclaration;
import org.eclipse.fordiac.ide.model.libraryElement.DeviceType;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.fordiac.ide.model.libraryElement.InheritableAttribute;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage;
import org.eclipse.fordiac.ide.model.libraryElement.Resource;
import org.eclipse.fordiac.ide.model.libraryElement.ResourceTypeName;
import org.eclipse.fordiac.ide.model.libraryElement.VarDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Device Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.DeviceTypeImpl#getAttributeDeclarations <em>Attribute Declarations</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.DeviceTypeImpl#getVarDeclaration <em>Var Declaration</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.DeviceTypeImpl#getResourceTypeName <em>Resource Type Name</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.DeviceTypeImpl#getResource <em>Resource</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.DeviceTypeImpl#getFBNetwork <em>FB Network</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.DeviceTypeImpl#getProfile <em>Profile</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeviceTypeImpl extends CompilableTypeImpl implements DeviceType {
	/**
	 * The cached value of the '{@link #getAttributeDeclarations() <em>Attribute Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeDeclaration> attributeDeclarations;

	/**
	 * The cached value of the '{@link #getVarDeclaration() <em>Var Declaration</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarDeclaration()
	 * @generated
	 * @ordered
	 */
	protected EList<VarDeclaration> varDeclaration;

	/**
	 * The cached value of the '{@link #getResourceTypeName() <em>Resource Type Name</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceTypeName()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceTypeName> resourceTypeName;

	/**
	 * The cached value of the '{@link #getResource() <em>Resource</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> resource;

	/**
	 * The cached value of the '{@link #getFBNetwork() <em>FB Network</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFBNetwork()
	 * @generated
	 * @ordered
	 */
	protected FBNetwork fBNetwork;

	/**
	 * The default value of the '{@link #getProfile() <em>Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfile()
	 * @generated
	 * @ordered
	 */
	protected static final String PROFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProfile() <em>Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfile()
	 * @generated
	 * @ordered
	 */
	protected String profile = PROFILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeviceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryElementPackage.Literals.DEVICE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VarDeclaration> getVarDeclaration() {
		if (varDeclaration == null) {
			varDeclaration = new EObjectContainmentEList<VarDeclaration>(VarDeclaration.class, this, LibraryElementPackage.DEVICE_TYPE__VAR_DECLARATION);
		}
		return varDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ResourceTypeName> getResourceTypeName() {
		if (resourceTypeName == null) {
			resourceTypeName = new EObjectContainmentEList<ResourceTypeName>(ResourceTypeName.class, this, LibraryElementPackage.DEVICE_TYPE__RESOURCE_TYPE_NAME);
		}
		return resourceTypeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Resource> getResource() {
		if (resource == null) {
			resource = new EObjectContainmentEList<Resource>(Resource.class, this, LibraryElementPackage.DEVICE_TYPE__RESOURCE);
		}
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FBNetwork getFBNetwork() {
		return fBNetwork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFBNetwork(FBNetwork newFBNetwork, NotificationChain msgs) {
		FBNetwork oldFBNetwork = fBNetwork;
		fBNetwork = newFBNetwork;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LibraryElementPackage.DEVICE_TYPE__FB_NETWORK, oldFBNetwork, newFBNetwork);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFBNetwork(FBNetwork newFBNetwork) {
		if (newFBNetwork != fBNetwork) {
			NotificationChain msgs = null;
			if (fBNetwork != null)
				msgs = ((InternalEObject)fBNetwork).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LibraryElementPackage.DEVICE_TYPE__FB_NETWORK, null, msgs);
			if (newFBNetwork != null)
				msgs = ((InternalEObject)newFBNetwork).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LibraryElementPackage.DEVICE_TYPE__FB_NETWORK, null, msgs);
			msgs = basicSetFBNetwork(newFBNetwork, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryElementPackage.DEVICE_TYPE__FB_NETWORK, newFBNetwork, newFBNetwork));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getProfile() {
		return profile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProfile(String newProfile) {
		String oldProfile = profile;
		profile = newProfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryElementPackage.DEVICE_TYPE__PROFILE, oldProfile, profile));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAttributeDeclaration(final String name, final String type, final String initialValue, final String comment) {
		org.eclipse.fordiac.ide.model.Annotations.setAttributeDeclaration(this, name, type, initialValue, comment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributeDeclaration getAttributeDeclaration(final String name) {
		return org.eclipse.fordiac.ide.model.Annotations.getAttributeDeclaration(this, name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttributeDeclaration> getAttributeDeclarations() {
		if (attributeDeclarations == null) {
			attributeDeclarations = new EObjectContainmentEList.Resolving<AttributeDeclaration>(AttributeDeclaration.class, this, LibraryElementPackage.DEVICE_TYPE__ATTRIBUTE_DECLARATIONS);
		}
		return attributeDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LibraryElementPackage.DEVICE_TYPE__ATTRIBUTE_DECLARATIONS:
				return ((InternalEList<?>)getAttributeDeclarations()).basicRemove(otherEnd, msgs);
			case LibraryElementPackage.DEVICE_TYPE__VAR_DECLARATION:
				return ((InternalEList<?>)getVarDeclaration()).basicRemove(otherEnd, msgs);
			case LibraryElementPackage.DEVICE_TYPE__RESOURCE_TYPE_NAME:
				return ((InternalEList<?>)getResourceTypeName()).basicRemove(otherEnd, msgs);
			case LibraryElementPackage.DEVICE_TYPE__RESOURCE:
				return ((InternalEList<?>)getResource()).basicRemove(otherEnd, msgs);
			case LibraryElementPackage.DEVICE_TYPE__FB_NETWORK:
				return basicSetFBNetwork(null, msgs);
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
			case LibraryElementPackage.DEVICE_TYPE__ATTRIBUTE_DECLARATIONS:
				return getAttributeDeclarations();
			case LibraryElementPackage.DEVICE_TYPE__VAR_DECLARATION:
				return getVarDeclaration();
			case LibraryElementPackage.DEVICE_TYPE__RESOURCE_TYPE_NAME:
				return getResourceTypeName();
			case LibraryElementPackage.DEVICE_TYPE__RESOURCE:
				return getResource();
			case LibraryElementPackage.DEVICE_TYPE__FB_NETWORK:
				return getFBNetwork();
			case LibraryElementPackage.DEVICE_TYPE__PROFILE:
				return getProfile();
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
			case LibraryElementPackage.DEVICE_TYPE__ATTRIBUTE_DECLARATIONS:
				getAttributeDeclarations().clear();
				getAttributeDeclarations().addAll((Collection<? extends AttributeDeclaration>)newValue);
				return;
			case LibraryElementPackage.DEVICE_TYPE__VAR_DECLARATION:
				getVarDeclaration().clear();
				getVarDeclaration().addAll((Collection<? extends VarDeclaration>)newValue);
				return;
			case LibraryElementPackage.DEVICE_TYPE__RESOURCE_TYPE_NAME:
				getResourceTypeName().clear();
				getResourceTypeName().addAll((Collection<? extends ResourceTypeName>)newValue);
				return;
			case LibraryElementPackage.DEVICE_TYPE__RESOURCE:
				getResource().clear();
				getResource().addAll((Collection<? extends Resource>)newValue);
				return;
			case LibraryElementPackage.DEVICE_TYPE__FB_NETWORK:
				setFBNetwork((FBNetwork)newValue);
				return;
			case LibraryElementPackage.DEVICE_TYPE__PROFILE:
				setProfile((String)newValue);
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
			case LibraryElementPackage.DEVICE_TYPE__ATTRIBUTE_DECLARATIONS:
				getAttributeDeclarations().clear();
				return;
			case LibraryElementPackage.DEVICE_TYPE__VAR_DECLARATION:
				getVarDeclaration().clear();
				return;
			case LibraryElementPackage.DEVICE_TYPE__RESOURCE_TYPE_NAME:
				getResourceTypeName().clear();
				return;
			case LibraryElementPackage.DEVICE_TYPE__RESOURCE:
				getResource().clear();
				return;
			case LibraryElementPackage.DEVICE_TYPE__FB_NETWORK:
				setFBNetwork((FBNetwork)null);
				return;
			case LibraryElementPackage.DEVICE_TYPE__PROFILE:
				setProfile(PROFILE_EDEFAULT);
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
			case LibraryElementPackage.DEVICE_TYPE__ATTRIBUTE_DECLARATIONS:
				return attributeDeclarations != null && !attributeDeclarations.isEmpty();
			case LibraryElementPackage.DEVICE_TYPE__VAR_DECLARATION:
				return varDeclaration != null && !varDeclaration.isEmpty();
			case LibraryElementPackage.DEVICE_TYPE__RESOURCE_TYPE_NAME:
				return resourceTypeName != null && !resourceTypeName.isEmpty();
			case LibraryElementPackage.DEVICE_TYPE__RESOURCE:
				return resource != null && !resource.isEmpty();
			case LibraryElementPackage.DEVICE_TYPE__FB_NETWORK:
				return fBNetwork != null;
			case LibraryElementPackage.DEVICE_TYPE__PROFILE:
				return PROFILE_EDEFAULT == null ? profile != null : !PROFILE_EDEFAULT.equals(profile);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == InheritableAttribute.class) {
			switch (derivedFeatureID) {
				case LibraryElementPackage.DEVICE_TYPE__ATTRIBUTE_DECLARATIONS: return LibraryElementPackage.INHERITABLE_ATTRIBUTE__ATTRIBUTE_DECLARATIONS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == InheritableAttribute.class) {
			switch (baseFeatureID) {
				case LibraryElementPackage.INHERITABLE_ATTRIBUTE__ATTRIBUTE_DECLARATIONS: return LibraryElementPackage.DEVICE_TYPE__ATTRIBUTE_DECLARATIONS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (profile: "); //$NON-NLS-1$
		result.append(profile);
		result.append(')');
		return result.toString();
	}

} //DeviceTypeImpl
