/*******************************************************************************
 * Copyright (c) 2012, 2013, 2015 - 2017 Profactor GmbH, fortiss GmbH
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Gerhard Ebenhofer, Alois Zoitl, Gerd Kainz
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.model.monitoring.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.fordiac.ide.model.data.DataType;
import org.eclipse.fordiac.ide.model.libraryElement.Annotation;
import org.eclipse.fordiac.ide.model.libraryElement.Attribute;
import org.eclipse.fordiac.ide.model.libraryElement.AttributeDeclaration;
import org.eclipse.fordiac.ide.model.libraryElement.ConfigurableObject;
import org.eclipse.fordiac.ide.model.libraryElement.Connection;
import org.eclipse.fordiac.ide.model.libraryElement.Event;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.I4DIACElement;
import org.eclipse.fordiac.ide.model.libraryElement.IInterfaceElement;
import org.eclipse.fordiac.ide.model.libraryElement.INamedElement;
import org.eclipse.fordiac.ide.model.libraryElement.InheritableAttribute;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage;
import org.eclipse.fordiac.ide.model.libraryElement.Value;
import org.eclipse.fordiac.ide.model.libraryElement.With;
import org.eclipse.fordiac.ide.model.monitoring.AdapterMonitoringEvent;
import org.eclipse.fordiac.ide.model.monitoring.MonitoringPackage;
import org.eclipse.fordiac.ide.monitoring.editparts.MonitoringAdapterInterfaceEditPart;
import org.eclipse.gef.EditPart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Adapter Monitoring Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fordiac.ide.model.monitoring.impl.AdapterMonitoringEventImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.monitoring.impl.AdapterMonitoringEventImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.monitoring.impl.AdapterMonitoringEventImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.monitoring.impl.AdapterMonitoringEventImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.monitoring.impl.AdapterMonitoringEventImpl#getAttributeDeclarations <em>Attribute Declarations</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.monitoring.impl.AdapterMonitoringEventImpl#isIsInput <em>Is Input</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.monitoring.impl.AdapterMonitoringEventImpl#getInputConnections <em>Input Connections</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.monitoring.impl.AdapterMonitoringEventImpl#getOutputConnections <em>Output Connections</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.monitoring.impl.AdapterMonitoringEventImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.monitoring.impl.AdapterMonitoringEventImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.monitoring.impl.AdapterMonitoringEventImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.monitoring.impl.AdapterMonitoringEventImpl#getWith <em>With</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdapterMonitoringEventImpl extends EObjectImpl implements AdapterMonitoringEvent {
	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<Annotation> annotations;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

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
	 * The default value of the '{@link #isIsInput() <em>Is Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInput()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INPUT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsInput() <em>Is Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInput()
	 * @generated
	 * @ordered
	 */
	protected boolean isInput = IS_INPUT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInputConnections() <em>Input Connections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<Connection> inputConnections;

	/**
	 * The cached value of the '{@link #getOutputConnections() <em>Output Connections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<Connection> outputConnections;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected DataType type;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Value value;

	/**
	 * The default value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeName()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeName()
	 * @generated
	 * @ordered
	 */
	protected String typeName = TYPE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWith() <em>With</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWith()
	 * @generated
	 * @ordered
	 */
	protected EList<With> with;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdapterMonitoringEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MonitoringPackage.Literals.ADAPTER_MONITORING_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Annotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectResolvingEList<Annotation>(Annotation.class, this, MonitoringPackage.ADAPTER_MONITORING_EVENT__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringPackage.ADAPTER_MONITORING_EVENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringPackage.ADAPTER_MONITORING_EVENT__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList.Resolving<Attribute>(Attribute.class, this, MonitoringPackage.ADAPTER_MONITORING_EVENT__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsInput() {
		return isInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsInput(boolean newIsInput) {
		boolean oldIsInput = isInput;
		isInput = newIsInput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringPackage.ADAPTER_MONITORING_EVENT__IS_INPUT, oldIsInput, isInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value getValue() {
		if (value != null && value.eIsProxy()) {
			InternalEObject oldValue = (InternalEObject)value;
			value = (Value)eResolveProxy(oldValue);
			if (value != oldValue) {
				InternalEObject newValue = (InternalEObject)value;
				NotificationChain msgs = oldValue.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MonitoringPackage.ADAPTER_MONITORING_EVENT__VALUE, null, null);
				if (newValue.eInternalContainer() == null) {
					msgs = newValue.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MonitoringPackage.ADAPTER_MONITORING_EVENT__VALUE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MonitoringPackage.ADAPTER_MONITORING_EVENT__VALUE, oldValue, value));
			}
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value basicGetValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(Value newValue, NotificationChain msgs) {
		Value oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MonitoringPackage.ADAPTER_MONITORING_EVENT__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(Value newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MonitoringPackage.ADAPTER_MONITORING_EVENT__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MonitoringPackage.ADAPTER_MONITORING_EVENT__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringPackage.ADAPTER_MONITORING_EVENT__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeName(String newTypeName) {
		String oldTypeName = typeName;
		typeName = newTypeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringPackage.ADAPTER_MONITORING_EVENT__TYPE_NAME, oldTypeName, typeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeDeclaration> getAttributeDeclarations() {
		if (attributeDeclarations == null) {
			attributeDeclarations = new EObjectContainmentEList.Resolving<AttributeDeclaration>(AttributeDeclaration.class, this, MonitoringPackage.ADAPTER_MONITORING_EVENT__ATTRIBUTE_DECLARATIONS);
		}
		return attributeDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Connection> getInputConnections() {
		if (inputConnections == null) {
			inputConnections = new EObjectWithInverseResolvingEList<Connection>(Connection.class, this, MonitoringPackage.ADAPTER_MONITORING_EVENT__INPUT_CONNECTIONS, LibraryElementPackage.CONNECTION__DESTINATION);
		}
		return inputConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Connection> getOutputConnections() {
		if (outputConnections == null) {
			outputConnections = new EObjectWithInverseResolvingEList<Connection>(Connection.class, this, MonitoringPackage.ADAPTER_MONITORING_EVENT__OUTPUT_CONNECTIONS, LibraryElementPackage.CONNECTION__SOURCE);
		}
		return outputConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (DataType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MonitoringPackage.ADAPTER_MONITORING_EVENT__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(DataType newType) {
		DataType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MonitoringPackage.ADAPTER_MONITORING_EVENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<With> getWith() {
		if (with == null) {
			with = new EObjectContainmentEList<With>(With.class, this, MonitoringPackage.ADAPTER_MONITORING_EVENT__WITH);
		}
		return with;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBNetworkElement getFBNetworkElement() {
		return org.eclipse.fordiac.ide.model.Annotations.GEN.getFBNetworkElement(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeDeclaration(final String name, final String type, final String initialValue, final String comment) {
		org.eclipse.fordiac.ide.model.Annotations.GEN.setAttributeDeclaration((InheritableAttribute)this, name, type, initialValue, comment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeDeclaration getAttributeDeclaration(final String name) {
		return org.eclipse.fordiac.ide.model.Annotations.GEN.getAttributeDeclaration((InheritableAttribute)this, name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute(final String attributeName, final String type, final String value, final String comment) {
		org.eclipse.fordiac.ide.model.Annotations.GEN.setAttribute(this, attributeName, type, value, comment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute getAttribute(final String attributeName) {
		return org.eclipse.fordiac.ide.model.Annotations.GEN.getAttribute(this, attributeName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttributeValue(final String attributeName) {
		return org.eclipse.fordiac.ide.model.Annotations.GEN.getAttributeValue(this, attributeName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation createAnnotation(final String name) {
		return org.eclipse.fordiac.ide.model.Annotations.GEN.createAnnotation(this, name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeAnnotation(final Annotation annotation) {
		org.eclipse.fordiac.ide.model.Annotations.GEN.removeAnnotation(this, annotation);
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
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__INPUT_CONNECTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputConnections()).basicAdd(otherEnd, msgs);
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__OUTPUT_CONNECTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputConnections()).basicAdd(otherEnd, msgs);
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
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__ATTRIBUTE_DECLARATIONS:
				return ((InternalEList<?>)getAttributeDeclarations()).basicRemove(otherEnd, msgs);
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__INPUT_CONNECTIONS:
				return ((InternalEList<?>)getInputConnections()).basicRemove(otherEnd, msgs);
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__OUTPUT_CONNECTIONS:
				return ((InternalEList<?>)getOutputConnections()).basicRemove(otherEnd, msgs);
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__VALUE:
				return basicSetValue(null, msgs);
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__WITH:
				return ((InternalEList<?>)getWith()).basicRemove(otherEnd, msgs);
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
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__ANNOTATIONS:
				return getAnnotations();
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__NAME:
				return getName();
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__COMMENT:
				return getComment();
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__ATTRIBUTES:
				return getAttributes();
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__ATTRIBUTE_DECLARATIONS:
				return getAttributeDeclarations();
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__IS_INPUT:
				return isIsInput();
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__INPUT_CONNECTIONS:
				return getInputConnections();
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__OUTPUT_CONNECTIONS:
				return getOutputConnections();
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__VALUE:
				if (resolve) return getValue();
				return basicGetValue();
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__TYPE_NAME:
				return getTypeName();
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__WITH:
				return getWith();
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
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__NAME:
				setName((String)newValue);
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__COMMENT:
				setComment((String)newValue);
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__ATTRIBUTE_DECLARATIONS:
				getAttributeDeclarations().clear();
				getAttributeDeclarations().addAll((Collection<? extends AttributeDeclaration>)newValue);
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__IS_INPUT:
				setIsInput((Boolean)newValue);
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__INPUT_CONNECTIONS:
				getInputConnections().clear();
				getInputConnections().addAll((Collection<? extends Connection>)newValue);
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__OUTPUT_CONNECTIONS:
				getOutputConnections().clear();
				getOutputConnections().addAll((Collection<? extends Connection>)newValue);
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__TYPE:
				setType((DataType)newValue);
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__VALUE:
				setValue((Value)newValue);
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__TYPE_NAME:
				setTypeName((String)newValue);
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__WITH:
				getWith().clear();
				getWith().addAll((Collection<? extends With>)newValue);
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
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__ATTRIBUTES:
				getAttributes().clear();
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__ATTRIBUTE_DECLARATIONS:
				getAttributeDeclarations().clear();
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__IS_INPUT:
				setIsInput(IS_INPUT_EDEFAULT);
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__INPUT_CONNECTIONS:
				getInputConnections().clear();
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__OUTPUT_CONNECTIONS:
				getOutputConnections().clear();
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__TYPE:
				setType((DataType)null);
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__VALUE:
				setValue((Value)null);
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__TYPE_NAME:
				setTypeName(TYPE_NAME_EDEFAULT);
				return;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__WITH:
				getWith().clear();
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
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__ATTRIBUTE_DECLARATIONS:
				return attributeDeclarations != null && !attributeDeclarations.isEmpty();
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__IS_INPUT:
				return isInput != IS_INPUT_EDEFAULT;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__INPUT_CONNECTIONS:
				return inputConnections != null && !inputConnections.isEmpty();
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__OUTPUT_CONNECTIONS:
				return outputConnections != null && !outputConnections.isEmpty();
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__TYPE:
				return type != null;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__VALUE:
				return value != null;
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__TYPE_NAME:
				return TYPE_NAME_EDEFAULT == null ? typeName != null : !TYPE_NAME_EDEFAULT.equals(typeName);
			case MonitoringPackage.ADAPTER_MONITORING_EVENT__WITH:
				return with != null && !with.isEmpty();
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
		if (baseClass == I4DIACElement.class) {
			switch (derivedFeatureID) {
				case MonitoringPackage.ADAPTER_MONITORING_EVENT__ANNOTATIONS: return LibraryElementPackage.I4DIAC_ELEMENT__ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == INamedElement.class) {
			switch (derivedFeatureID) {
				case MonitoringPackage.ADAPTER_MONITORING_EVENT__NAME: return LibraryElementPackage.INAMED_ELEMENT__NAME;
				case MonitoringPackage.ADAPTER_MONITORING_EVENT__COMMENT: return LibraryElementPackage.INAMED_ELEMENT__COMMENT;
				default: return -1;
			}
		}
		if (baseClass == ConfigurableObject.class) {
			switch (derivedFeatureID) {
				case MonitoringPackage.ADAPTER_MONITORING_EVENT__ATTRIBUTES: return LibraryElementPackage.CONFIGURABLE_OBJECT__ATTRIBUTES;
				default: return -1;
			}
		}
		if (baseClass == InheritableAttribute.class) {
			switch (derivedFeatureID) {
				case MonitoringPackage.ADAPTER_MONITORING_EVENT__ATTRIBUTE_DECLARATIONS: return LibraryElementPackage.INHERITABLE_ATTRIBUTE__ATTRIBUTE_DECLARATIONS;
				default: return -1;
			}
		}
		if (baseClass == IInterfaceElement.class) {
			switch (derivedFeatureID) {
				case MonitoringPackage.ADAPTER_MONITORING_EVENT__IS_INPUT: return LibraryElementPackage.IINTERFACE_ELEMENT__IS_INPUT;
				case MonitoringPackage.ADAPTER_MONITORING_EVENT__INPUT_CONNECTIONS: return LibraryElementPackage.IINTERFACE_ELEMENT__INPUT_CONNECTIONS;
				case MonitoringPackage.ADAPTER_MONITORING_EVENT__OUTPUT_CONNECTIONS: return LibraryElementPackage.IINTERFACE_ELEMENT__OUTPUT_CONNECTIONS;
				case MonitoringPackage.ADAPTER_MONITORING_EVENT__TYPE: return LibraryElementPackage.IINTERFACE_ELEMENT__TYPE;
				case MonitoringPackage.ADAPTER_MONITORING_EVENT__VALUE: return LibraryElementPackage.IINTERFACE_ELEMENT__VALUE;
				case MonitoringPackage.ADAPTER_MONITORING_EVENT__TYPE_NAME: return LibraryElementPackage.IINTERFACE_ELEMENT__TYPE_NAME;
				default: return -1;
			}
		}
		if (baseClass == Event.class) {
			switch (derivedFeatureID) {
				case MonitoringPackage.ADAPTER_MONITORING_EVENT__WITH: return LibraryElementPackage.EVENT__WITH;
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
		if (baseClass == I4DIACElement.class) {
			switch (baseFeatureID) {
				case LibraryElementPackage.I4DIAC_ELEMENT__ANNOTATIONS: return MonitoringPackage.ADAPTER_MONITORING_EVENT__ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == INamedElement.class) {
			switch (baseFeatureID) {
				case LibraryElementPackage.INAMED_ELEMENT__NAME: return MonitoringPackage.ADAPTER_MONITORING_EVENT__NAME;
				case LibraryElementPackage.INAMED_ELEMENT__COMMENT: return MonitoringPackage.ADAPTER_MONITORING_EVENT__COMMENT;
				default: return -1;
			}
		}
		if (baseClass == ConfigurableObject.class) {
			switch (baseFeatureID) {
				case LibraryElementPackage.CONFIGURABLE_OBJECT__ATTRIBUTES: return MonitoringPackage.ADAPTER_MONITORING_EVENT__ATTRIBUTES;
				default: return -1;
			}
		}
		if (baseClass == InheritableAttribute.class) {
			switch (baseFeatureID) {
				case LibraryElementPackage.INHERITABLE_ATTRIBUTE__ATTRIBUTE_DECLARATIONS: return MonitoringPackage.ADAPTER_MONITORING_EVENT__ATTRIBUTE_DECLARATIONS;
				default: return -1;
			}
		}
		if (baseClass == IInterfaceElement.class) {
			switch (baseFeatureID) {
				case LibraryElementPackage.IINTERFACE_ELEMENT__IS_INPUT: return MonitoringPackage.ADAPTER_MONITORING_EVENT__IS_INPUT;
				case LibraryElementPackage.IINTERFACE_ELEMENT__INPUT_CONNECTIONS: return MonitoringPackage.ADAPTER_MONITORING_EVENT__INPUT_CONNECTIONS;
				case LibraryElementPackage.IINTERFACE_ELEMENT__OUTPUT_CONNECTIONS: return MonitoringPackage.ADAPTER_MONITORING_EVENT__OUTPUT_CONNECTIONS;
				case LibraryElementPackage.IINTERFACE_ELEMENT__TYPE: return MonitoringPackage.ADAPTER_MONITORING_EVENT__TYPE;
				case LibraryElementPackage.IINTERFACE_ELEMENT__VALUE: return MonitoringPackage.ADAPTER_MONITORING_EVENT__VALUE;
				case LibraryElementPackage.IINTERFACE_ELEMENT__TYPE_NAME: return MonitoringPackage.ADAPTER_MONITORING_EVENT__TYPE_NAME;
				default: return -1;
			}
		}
		if (baseClass == Event.class) {
			switch (baseFeatureID) {
				case LibraryElementPackage.EVENT__WITH: return MonitoringPackage.ADAPTER_MONITORING_EVENT__WITH;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", comment: ");
		result.append(comment);
		result.append(", isInput: ");
		result.append(isInput);
		result.append(", typeName: ");
		result.append(typeName);
		result.append(')');
		return result.toString();
	}
	
	@Override
	public EditPart createEditPart() {
		return new MonitoringAdapterInterfaceEditPart();
	}

} //AdapterMonitoringEventImpl
