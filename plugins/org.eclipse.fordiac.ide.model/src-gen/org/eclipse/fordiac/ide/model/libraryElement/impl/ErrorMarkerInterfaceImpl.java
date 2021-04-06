/**
 * *******************************************************************************
 * Copyright (c) 2008 - 2018 Profactor GmbH, TU Wien ACIN, fortiss GmbH
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
package org.eclipse.fordiac.ide.model.libraryElement.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.fordiac.ide.model.data.DataType;

import org.eclipse.fordiac.ide.model.libraryElement.Connection;
import org.eclipse.fordiac.ide.model.libraryElement.ErrorMarkerInterface;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.IInterfaceElement;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage;

/** <!-- begin-user-doc --> An implementation of the model object '<em><b>Error Marker Interface</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.ErrorMarkerInterfaceImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.ErrorMarkerInterfaceImpl#getComment
 * <em>Comment</em>}</li>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.ErrorMarkerInterfaceImpl#isIsInput <em>Is
 * Input</em>}</li>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.ErrorMarkerInterfaceImpl#getInputConnections <em>Input
 * Connections</em>}</li>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.ErrorMarkerInterfaceImpl#getOutputConnections <em>Output
 * Connections</em>}</li>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.ErrorMarkerInterfaceImpl#getType <em>Type</em>}</li>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.ErrorMarkerInterfaceImpl#getTypeName <em>Type
 * Name</em>}</li>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.ErrorMarkerInterfaceImpl#getRepairedEndpoint
 * <em>Repaired Endpoint</em>}</li>
 * </ul>
 *
 * @generated */
public class ErrorMarkerInterfaceImpl extends EObjectImpl implements ErrorMarkerInterface {
	/** The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered */
	protected static final String NAME_EDEFAULT = ""; //$NON-NLS-1$

	/** The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered */
	protected String name = NAME_EDEFAULT;

	/** The default value of the '{@link #getComment() <em>Comment</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getComment()
	 * @generated
	 * @ordered */
	protected static final String COMMENT_EDEFAULT = ""; //$NON-NLS-1$

	/** The cached value of the '{@link #getComment() <em>Comment</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getComment()
	 * @generated
	 * @ordered */
	protected String comment = COMMENT_EDEFAULT;

	/** The default value of the '{@link #isIsInput() <em>Is Input</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isIsInput()
	 * @generated
	 * @ordered */
	protected static final boolean IS_INPUT_EDEFAULT = false;

	/** The cached value of the '{@link #isIsInput() <em>Is Input</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isIsInput()
	 * @generated
	 * @ordered */
	protected boolean isInput = IS_INPUT_EDEFAULT;

	/** The cached value of the '{@link #getInputConnections() <em>Input Connections</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInputConnections()
	 * @generated
	 * @ordered */
	protected EList<Connection> inputConnections;

	/** The cached value of the '{@link #getOutputConnections() <em>Output Connections</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOutputConnections()
	 * @generated
	 * @ordered */
	protected EList<Connection> outputConnections;

	/** The cached value of the '{@link #getType() <em>Type</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered */
	protected DataType type;

	/** The default value of the '{@link #getTypeName() <em>Type Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTypeName()
	 * @generated
	 * @ordered */
	protected static final String TYPE_NAME_EDEFAULT = null;

	/** The cached value of the '{@link #getTypeName() <em>Type Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTypeName()
	 * @generated
	 * @ordered */
	protected String typeName = TYPE_NAME_EDEFAULT;

	/** The cached value of the '{@link #getRepairedEndpoint() <em>Repaired Endpoint</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRepairedEndpoint()
	 * @generated
	 * @ordered */
	protected IInterfaceElement repairedEndpoint;

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	protected ErrorMarkerInterfaceImpl() {
		super();
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	protected EClass eStaticClass() {
		return LibraryElementPackage.Literals.ERROR_MARKER_INTERFACE;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public String getName() {
		return name;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryElementPackage.ERROR_MARKER_INTERFACE__NAME,
					oldName, name));
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public String getComment() {
		return comment;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryElementPackage.ERROR_MARKER_INTERFACE__COMMENT,
					oldComment, comment));
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public boolean isIsInput() {
		return isInput;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public void setIsInput(boolean newIsInput) {
		boolean oldIsInput = isInput;
		isInput = newIsInput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					LibraryElementPackage.ERROR_MARKER_INTERFACE__IS_INPUT, oldIsInput, isInput));
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public EList<Connection> getInputConnections() {
		if (inputConnections == null) {
			inputConnections = new EObjectWithInverseResolvingEList<Connection>(Connection.class, this,
					LibraryElementPackage.ERROR_MARKER_INTERFACE__INPUT_CONNECTIONS,
					LibraryElementPackage.CONNECTION__DESTINATION);
		}
		return inputConnections;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public EList<Connection> getOutputConnections() {
		if (outputConnections == null) {
			outputConnections = new EObjectWithInverseResolvingEList<Connection>(Connection.class, this,
					LibraryElementPackage.ERROR_MARKER_INTERFACE__OUTPUT_CONNECTIONS,
					LibraryElementPackage.CONNECTION__SOURCE);
		}
		return outputConnections;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public DataType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject) type;
			type = (DataType) eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	public DataType basicGetType() {
		return type;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public void setType(DataType newType) {
		DataType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE,
					oldType, type));
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public String getTypeName() {
		return typeName;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public void setTypeName(String newTypeName) {
		String oldTypeName = typeName;
		typeName = newTypeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE_NAME, oldTypeName, typeName));
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public IInterfaceElement getRepairedEndpoint() {
		if (repairedEndpoint != null && repairedEndpoint.eIsProxy()) {
			InternalEObject oldRepairedEndpoint = (InternalEObject) repairedEndpoint;
			repairedEndpoint = (IInterfaceElement) eResolveProxy(oldRepairedEndpoint);
			if (repairedEndpoint != oldRepairedEndpoint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							LibraryElementPackage.ERROR_MARKER_INTERFACE__REPAIRED_ENDPOINT, oldRepairedEndpoint,
							repairedEndpoint));
			}
		}
		return repairedEndpoint;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	public IInterfaceElement basicGetRepairedEndpoint() {
		return repairedEndpoint;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public void setRepairedEndpoint(IInterfaceElement newRepairedEndpoint) {
		IInterfaceElement oldRepairedEndpoint = repairedEndpoint;
		repairedEndpoint = newRepairedEndpoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					LibraryElementPackage.ERROR_MARKER_INTERFACE__REPAIRED_ENDPOINT, oldRepairedEndpoint,
					repairedEndpoint));
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public FBNetworkElement getFBNetworkElement() {
		return org.eclipse.fordiac.ide.model.Annotations.getFBNetworkElement(this);
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__INPUT_CONNECTIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getInputConnections()).basicAdd(otherEnd, msgs);
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__OUTPUT_CONNECTIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOutputConnections()).basicAdd(otherEnd,
					msgs);
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
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__INPUT_CONNECTIONS:
			return ((InternalEList<?>) getInputConnections()).basicRemove(otherEnd, msgs);
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__OUTPUT_CONNECTIONS:
			return ((InternalEList<?>) getOutputConnections()).basicRemove(otherEnd, msgs);
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
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__NAME:
			return getName();
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__COMMENT:
			return getComment();
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__IS_INPUT:
			return isIsInput();
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__INPUT_CONNECTIONS:
			return getInputConnections();
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__OUTPUT_CONNECTIONS:
			return getOutputConnections();
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE:
			if (resolve)
				return getType();
			return basicGetType();
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE_NAME:
			return getTypeName();
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__REPAIRED_ENDPOINT:
			if (resolve)
				return getRepairedEndpoint();
			return basicGetRepairedEndpoint();
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
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__NAME:
			setName((String) newValue);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__COMMENT:
			setComment((String) newValue);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__IS_INPUT:
			setIsInput((Boolean) newValue);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__INPUT_CONNECTIONS:
			getInputConnections().clear();
			getInputConnections().addAll((Collection<? extends Connection>) newValue);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__OUTPUT_CONNECTIONS:
			getOutputConnections().clear();
			getOutputConnections().addAll((Collection<? extends Connection>) newValue);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE:
			setType((DataType) newValue);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE_NAME:
			setTypeName((String) newValue);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__REPAIRED_ENDPOINT:
			setRepairedEndpoint((IInterfaceElement) newValue);
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
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__COMMENT:
			setComment(COMMENT_EDEFAULT);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__IS_INPUT:
			setIsInput(IS_INPUT_EDEFAULT);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__INPUT_CONNECTIONS:
			getInputConnections().clear();
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__OUTPUT_CONNECTIONS:
			getOutputConnections().clear();
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE:
			setType((DataType) null);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE_NAME:
			setTypeName(TYPE_NAME_EDEFAULT);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__REPAIRED_ENDPOINT:
			setRepairedEndpoint((IInterfaceElement) null);
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
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__COMMENT:
			return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__IS_INPUT:
			return isInput != IS_INPUT_EDEFAULT;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__INPUT_CONNECTIONS:
			return inputConnections != null && !inputConnections.isEmpty();
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__OUTPUT_CONNECTIONS:
			return outputConnections != null && !outputConnections.isEmpty();
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE:
			return type != null;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE_NAME:
			return TYPE_NAME_EDEFAULT == null ? typeName != null : !TYPE_NAME_EDEFAULT.equals(typeName);
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__REPAIRED_ENDPOINT:
			return repairedEndpoint != null;
		default:
			return super.eIsSet(featureID);
		}
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", comment: "); //$NON-NLS-1$
		result.append(comment);
		result.append(", isInput: "); //$NON-NLS-1$
		result.append(isInput);
		result.append(", typeName: "); //$NON-NLS-1$
		result.append(typeName);
		result.append(')');
		return result.toString();
	}

} // ErrorMarkerInterfaceImpl