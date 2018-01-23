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
package org.eclipse.fordiac.ide.model.monitoring;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.fordiac.ide.model.monitoring.MonitoringFactory
 * @model kind="package"
 * @generated
 */
public interface MonitoringPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "monitoring";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.eclipse.fordiac";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "monitoring";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MonitoringPackage eINSTANCE = org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringBaseElementImpl <em>Base Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringBaseElementImpl
	 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringPackageImpl#getMonitoringBaseElement()
	 * @generated
	 */
	int MONITORING_BASE_ELEMENT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringElementImpl
	 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringPackageImpl#getMonitoringElement()
	 * @generated
	 */
	int MONITORING_ELEMENT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringAdapterElementImpl <em>Adapter Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringAdapterElementImpl
	 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringPackageImpl#getMonitoringAdapterElement()
	 * @generated
	 */
	int MONITORING_ADAPTER_ELEMENT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.fordiac.ide.model.monitoring.impl.BreakpointsImpl <em>Breakpoints</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.fordiac.ide.model.monitoring.impl.BreakpointsImpl
	 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringPackageImpl#getBreakpoints()
	 * @generated
	 */
	int BREAKPOINTS = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.fordiac.ide.gef.editparts.IEditPartCreator <em>IEdit Part Creator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.fordiac.ide.gef.editparts.IEditPartCreator
	 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringPackageImpl#getIEditPartCreator()
	 * @generated
	 */
	int IEDIT_PART_CREATOR = 4;

	/**
	 * The number of structural features of the '<em>IEdit Part Creator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IEDIT_PART_CREATOR_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_BASE_ELEMENT__PORT = IEDIT_PART_CREATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Offline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_BASE_ELEMENT__OFFLINE = IEDIT_PART_CREATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Base Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_BASE_ELEMENT_FEATURE_COUNT = IEDIT_PART_CREATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_ELEMENT__PORT = MONITORING_BASE_ELEMENT__PORT;

	/**
	 * The feature id for the '<em><b>Offline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_ELEMENT__OFFLINE = MONITORING_BASE_ELEMENT__OFFLINE;

	/**
	 * The feature id for the '<em><b>Force</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_ELEMENT__FORCE = MONITORING_BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Force Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_ELEMENT__FORCE_VALUE = MONITORING_BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Breakpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_ELEMENT__BREAKPOINT = MONITORING_BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Breakpoint Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_ELEMENT__BREAKPOINT_ACTIVE = MONITORING_BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Breakpoint Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_ELEMENT__BREAKPOINT_CONDITION = MONITORING_BASE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_ELEMENT__CURRENT_VALUE = MONITORING_BASE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_ELEMENT__SEC = MONITORING_BASE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Usec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_ELEMENT__USEC = MONITORING_BASE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_ELEMENT_FEATURE_COUNT = MONITORING_BASE_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_ADAPTER_ELEMENT__PORT = MONITORING_BASE_ELEMENT__PORT;

	/**
	 * The feature id for the '<em><b>Offline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_ADAPTER_ELEMENT__OFFLINE = MONITORING_BASE_ELEMENT__OFFLINE;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_ADAPTER_ELEMENT__ELEMENTS = MONITORING_BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Monitored Adapter FB</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_ADAPTER_ELEMENT__MONITORED_ADAPTER_FB = MONITORING_BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Adapter Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_ADAPTER_ELEMENT_FEATURE_COUNT = MONITORING_BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Breakpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKPOINTS__BREAKPOINTS = 0;

	/**
	 * The number of structural features of the '<em>Breakpoints</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKPOINTS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.fordiac.ide.model.monitoring.impl.PortElementImpl <em>Port Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.fordiac.ide.model.monitoring.impl.PortElementImpl
	 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringPackageImpl#getPortElement()
	 * @generated
	 */
	int PORT_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Fb</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ELEMENT__FB = 0;

	/**
	 * The feature id for the '<em><b>Interface Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ELEMENT__INTERFACE_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ELEMENT__RESOURCE = 2;

	/**
	 * The feature id for the '<em><b>Device</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ELEMENT__DEVICE = 3;

	/**
	 * The feature id for the '<em><b>System</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ELEMENT__SYSTEM = 4;

	/**
	 * The feature id for the '<em><b>Hierarchy</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ELEMENT__HIERARCHY = 5;

	/**
	 * The number of structural features of the '<em>Port Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ELEMENT_FEATURE_COUNT = 6;


	/**
	 * The meta object id for the '{@link org.eclipse.fordiac.ide.model.monitoring.impl.AdapterPortElementImpl <em>Adapter Port Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.fordiac.ide.model.monitoring.impl.AdapterPortElementImpl
	 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringPackageImpl#getAdapterPortElement()
	 * @generated
	 */
	int ADAPTER_PORT_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Fb</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_PORT_ELEMENT__FB = PORT_ELEMENT__FB;

	/**
	 * The feature id for the '<em><b>Interface Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_PORT_ELEMENT__INTERFACE_ELEMENT = PORT_ELEMENT__INTERFACE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_PORT_ELEMENT__RESOURCE = PORT_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Device</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_PORT_ELEMENT__DEVICE = PORT_ELEMENT__DEVICE;

	/**
	 * The feature id for the '<em><b>System</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_PORT_ELEMENT__SYSTEM = PORT_ELEMENT__SYSTEM;

	/**
	 * The feature id for the '<em><b>Hierarchy</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_PORT_ELEMENT__HIERARCHY = PORT_ELEMENT__HIERARCHY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_PORT_ELEMENT__PORTS = PORT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Adapter Port Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_PORT_ELEMENT_FEATURE_COUNT = PORT_ELEMENT_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.fordiac.ide.model.monitoring.impl.AdapterMonitoringEventImpl <em>Adapter Monitoring Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.fordiac.ide.model.monitoring.impl.AdapterMonitoringEventImpl
	 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringPackageImpl#getAdapterMonitoringEvent()
	 * @generated
	 */
	int ADAPTER_MONITORING_EVENT = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_EVENT__ANNOTATIONS = IEDIT_PART_CREATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_EVENT__NAME = IEDIT_PART_CREATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_EVENT__COMMENT = IEDIT_PART_CREATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_EVENT__ATTRIBUTES = IEDIT_PART_CREATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Attribute Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_EVENT__ATTRIBUTE_DECLARATIONS = IEDIT_PART_CREATOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Is Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_EVENT__IS_INPUT = IEDIT_PART_CREATOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Input Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_EVENT__INPUT_CONNECTIONS = IEDIT_PART_CREATOR_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Output Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_EVENT__OUTPUT_CONNECTIONS = IEDIT_PART_CREATOR_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_EVENT__TYPE = IEDIT_PART_CREATOR_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_EVENT__VALUE = IEDIT_PART_CREATOR_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_EVENT__TYPE_NAME = IEDIT_PART_CREATOR_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>With</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_EVENT__WITH = IEDIT_PART_CREATOR_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Adapter Monitoring Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_EVENT_FEATURE_COUNT = IEDIT_PART_CREATOR_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link org.eclipse.fordiac.ide.model.monitoring.impl.AdapterMonitoringVarDeclarationImpl <em>Adapter Monitoring Var Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.fordiac.ide.model.monitoring.impl.AdapterMonitoringVarDeclarationImpl
	 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringPackageImpl#getAdapterMonitoringVarDeclaration()
	 * @generated
	 */
	int ADAPTER_MONITORING_VAR_DECLARATION = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_VAR_DECLARATION__ANNOTATIONS = IEDIT_PART_CREATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_VAR_DECLARATION__NAME = IEDIT_PART_CREATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_VAR_DECLARATION__COMMENT = IEDIT_PART_CREATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_VAR_DECLARATION__ATTRIBUTES = IEDIT_PART_CREATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Attribute Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_VAR_DECLARATION__ATTRIBUTE_DECLARATIONS = IEDIT_PART_CREATOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Is Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_VAR_DECLARATION__IS_INPUT = IEDIT_PART_CREATOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Input Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_VAR_DECLARATION__INPUT_CONNECTIONS = IEDIT_PART_CREATOR_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Output Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_VAR_DECLARATION__OUTPUT_CONNECTIONS = IEDIT_PART_CREATOR_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_VAR_DECLARATION__TYPE = IEDIT_PART_CREATOR_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_VAR_DECLARATION__VALUE = IEDIT_PART_CREATOR_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_VAR_DECLARATION__TYPE_NAME = IEDIT_PART_CREATOR_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Array Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_VAR_DECLARATION__ARRAY_SIZE = IEDIT_PART_CREATOR_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Var Initialization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_VAR_DECLARATION__VAR_INITIALIZATION = IEDIT_PART_CREATOR_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Withs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_VAR_DECLARATION__WITHS = IEDIT_PART_CREATOR_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Adapter Monitoring Var Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MONITORING_VAR_DECLARATION_FEATURE_COUNT = IEDIT_PART_CREATOR_FEATURE_COUNT + 14;

	/**
	 * Returns the meta object for class '{@link org.eclipse.fordiac.ide.model.monitoring.MonitoringBaseElement <em>Base Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Element</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.MonitoringBaseElement
	 * @generated
	 */
	EClass getMonitoringBaseElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.fordiac.ide.model.monitoring.MonitoringBaseElement#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.MonitoringBaseElement#getPort()
	 * @see #getMonitoringBaseElement()
	 * @generated
	 */
	EReference getMonitoringBaseElement_Port();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.fordiac.ide.model.monitoring.MonitoringBaseElement#isOffline <em>Offline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offline</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.MonitoringBaseElement#isOffline()
	 * @see #getMonitoringBaseElement()
	 * @generated
	 */
	EAttribute getMonitoringBaseElement_Offline();

	/**
	 * Returns the meta object for class '{@link org.eclipse.fordiac.ide.model.monitoring.MonitoringElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.MonitoringElement
	 * @generated
	 */
	EClass getMonitoringElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.fordiac.ide.model.monitoring.MonitoringElement#isForce <em>Force</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Force</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.MonitoringElement#isForce()
	 * @see #getMonitoringElement()
	 * @generated
	 */
	EAttribute getMonitoringElement_Force();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.fordiac.ide.model.monitoring.MonitoringElement#getForceValue <em>Force Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Force Value</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.MonitoringElement#getForceValue()
	 * @see #getMonitoringElement()
	 * @generated
	 */
	EAttribute getMonitoringElement_ForceValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.fordiac.ide.model.monitoring.MonitoringElement#isBreakpoint <em>Breakpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Breakpoint</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.MonitoringElement#isBreakpoint()
	 * @see #getMonitoringElement()
	 * @generated
	 */
	EAttribute getMonitoringElement_Breakpoint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.fordiac.ide.model.monitoring.MonitoringElement#isBreakpointActive <em>Breakpoint Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Breakpoint Active</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.MonitoringElement#isBreakpointActive()
	 * @see #getMonitoringElement()
	 * @generated
	 */
	EAttribute getMonitoringElement_BreakpointActive();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.fordiac.ide.model.monitoring.MonitoringElement#getBreakpointCondition <em>Breakpoint Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Breakpoint Condition</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.MonitoringElement#getBreakpointCondition()
	 * @see #getMonitoringElement()
	 * @generated
	 */
	EAttribute getMonitoringElement_BreakpointCondition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.fordiac.ide.model.monitoring.MonitoringElement#getCurrentValue <em>Current Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Value</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.MonitoringElement#getCurrentValue()
	 * @see #getMonitoringElement()
	 * @generated
	 */
	EAttribute getMonitoringElement_CurrentValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.fordiac.ide.model.monitoring.MonitoringElement#getSec <em>Sec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sec</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.MonitoringElement#getSec()
	 * @see #getMonitoringElement()
	 * @generated
	 */
	EAttribute getMonitoringElement_Sec();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.fordiac.ide.model.monitoring.MonitoringElement#getUsec <em>Usec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usec</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.MonitoringElement#getUsec()
	 * @see #getMonitoringElement()
	 * @generated
	 */
	EAttribute getMonitoringElement_Usec();

	/**
	 * Returns the meta object for class '{@link org.eclipse.fordiac.ide.model.monitoring.MonitoringAdapterElement <em>Adapter Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adapter Element</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.MonitoringAdapterElement
	 * @generated
	 */
	EClass getMonitoringAdapterElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.fordiac.ide.model.monitoring.MonitoringAdapterElement#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.MonitoringAdapterElement#getElements()
	 * @see #getMonitoringAdapterElement()
	 * @generated
	 */
	EReference getMonitoringAdapterElement_Elements();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.fordiac.ide.model.monitoring.MonitoringAdapterElement#getMonitoredAdapterFB <em>Monitored Adapter FB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Monitored Adapter FB</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.MonitoringAdapterElement#getMonitoredAdapterFB()
	 * @see #getMonitoringAdapterElement()
	 * @generated
	 */
	EReference getMonitoringAdapterElement_MonitoredAdapterFB();

	/**
	 * Returns the meta object for class '{@link org.eclipse.fordiac.ide.model.monitoring.Breakpoints <em>Breakpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Breakpoints</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.Breakpoints
	 * @generated
	 */
	EClass getBreakpoints();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.fordiac.ide.model.monitoring.Breakpoints#getBreakpoints <em>Breakpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Breakpoints</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.Breakpoints#getBreakpoints()
	 * @see #getBreakpoints()
	 * @generated
	 */
	EReference getBreakpoints_Breakpoints();

	/**
	 * Returns the meta object for class '{@link org.eclipse.fordiac.ide.gef.editparts.IEditPartCreator <em>IEdit Part Creator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IEdit Part Creator</em>'.
	 * @see org.eclipse.fordiac.ide.gef.editparts.IEditPartCreator
	 * @model instanceClass="org.eclipse.fordiac.ide.gef.editparts.IEditPartCreator"
	 * @generated
	 */
	EClass getIEditPartCreator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.fordiac.ide.model.monitoring.PortElement <em>Port Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Element</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.PortElement
	 * @generated
	 */
	EClass getPortElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.fordiac.ide.model.monitoring.PortElement#getFb <em>Fb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Fb</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.PortElement#getFb()
	 * @see #getPortElement()
	 * @generated
	 */
	EReference getPortElement_Fb();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.fordiac.ide.model.monitoring.PortElement#getInterfaceElement <em>Interface Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Interface Element</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.PortElement#getInterfaceElement()
	 * @see #getPortElement()
	 * @generated
	 */
	EReference getPortElement_InterfaceElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.fordiac.ide.model.monitoring.PortElement#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.PortElement#getResource()
	 * @see #getPortElement()
	 * @generated
	 */
	EReference getPortElement_Resource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.fordiac.ide.model.monitoring.PortElement#getDevice <em>Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Device</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.PortElement#getDevice()
	 * @see #getPortElement()
	 * @generated
	 */
	EReference getPortElement_Device();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.fordiac.ide.model.monitoring.PortElement#getSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>System</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.PortElement#getSystem()
	 * @see #getPortElement()
	 * @generated
	 */
	EReference getPortElement_System();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.fordiac.ide.model.monitoring.PortElement#getHierarchy <em>Hierarchy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Hierarchy</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.PortElement#getHierarchy()
	 * @see #getPortElement()
	 * @generated
	 */
	EAttribute getPortElement_Hierarchy();

	/**
	 * Returns the meta object for class '{@link org.eclipse.fordiac.ide.model.monitoring.AdapterPortElement <em>Adapter Port Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adapter Port Element</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.AdapterPortElement
	 * @generated
	 */
	EClass getAdapterPortElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.fordiac.ide.model.monitoring.AdapterPortElement#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.AdapterPortElement#getPorts()
	 * @see #getAdapterPortElement()
	 * @generated
	 */
	EReference getAdapterPortElement_Ports();

	/**
	 * Returns the meta object for class '{@link org.eclipse.fordiac.ide.model.monitoring.AdapterMonitoringEvent <em>Adapter Monitoring Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adapter Monitoring Event</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.AdapterMonitoringEvent
	 * @generated
	 */
	EClass getAdapterMonitoringEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.fordiac.ide.model.monitoring.AdapterMonitoringVarDeclaration <em>Adapter Monitoring Var Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adapter Monitoring Var Declaration</em>'.
	 * @see org.eclipse.fordiac.ide.model.monitoring.AdapterMonitoringVarDeclaration
	 * @generated
	 */
	EClass getAdapterMonitoringVarDeclaration();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MonitoringFactory getMonitoringFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringBaseElementImpl <em>Base Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringBaseElementImpl
		 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringPackageImpl#getMonitoringBaseElement()
		 * @generated
		 */
		EClass MONITORING_BASE_ELEMENT = eINSTANCE.getMonitoringBaseElement();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONITORING_BASE_ELEMENT__PORT = eINSTANCE.getMonitoringBaseElement_Port();

		/**
		 * The meta object literal for the '<em><b>Offline</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONITORING_BASE_ELEMENT__OFFLINE = eINSTANCE.getMonitoringBaseElement_Offline();

		/**
		 * The meta object literal for the '{@link org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringElementImpl
		 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringPackageImpl#getMonitoringElement()
		 * @generated
		 */
		EClass MONITORING_ELEMENT = eINSTANCE.getMonitoringElement();

		/**
		 * The meta object literal for the '<em><b>Force</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONITORING_ELEMENT__FORCE = eINSTANCE.getMonitoringElement_Force();

		/**
		 * The meta object literal for the '<em><b>Force Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONITORING_ELEMENT__FORCE_VALUE = eINSTANCE.getMonitoringElement_ForceValue();

		/**
		 * The meta object literal for the '<em><b>Breakpoint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONITORING_ELEMENT__BREAKPOINT = eINSTANCE.getMonitoringElement_Breakpoint();

		/**
		 * The meta object literal for the '<em><b>Breakpoint Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONITORING_ELEMENT__BREAKPOINT_ACTIVE = eINSTANCE.getMonitoringElement_BreakpointActive();

		/**
		 * The meta object literal for the '<em><b>Breakpoint Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONITORING_ELEMENT__BREAKPOINT_CONDITION = eINSTANCE.getMonitoringElement_BreakpointCondition();

		/**
		 * The meta object literal for the '<em><b>Current Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONITORING_ELEMENT__CURRENT_VALUE = eINSTANCE.getMonitoringElement_CurrentValue();

		/**
		 * The meta object literal for the '<em><b>Sec</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONITORING_ELEMENT__SEC = eINSTANCE.getMonitoringElement_Sec();

		/**
		 * The meta object literal for the '<em><b>Usec</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONITORING_ELEMENT__USEC = eINSTANCE.getMonitoringElement_Usec();

		/**
		 * The meta object literal for the '{@link org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringAdapterElementImpl <em>Adapter Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringAdapterElementImpl
		 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringPackageImpl#getMonitoringAdapterElement()
		 * @generated
		 */
		EClass MONITORING_ADAPTER_ELEMENT = eINSTANCE.getMonitoringAdapterElement();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONITORING_ADAPTER_ELEMENT__ELEMENTS = eINSTANCE.getMonitoringAdapterElement_Elements();

		/**
		 * The meta object literal for the '<em><b>Monitored Adapter FB</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONITORING_ADAPTER_ELEMENT__MONITORED_ADAPTER_FB = eINSTANCE.getMonitoringAdapterElement_MonitoredAdapterFB();

		/**
		 * The meta object literal for the '{@link org.eclipse.fordiac.ide.model.monitoring.impl.BreakpointsImpl <em>Breakpoints</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.fordiac.ide.model.monitoring.impl.BreakpointsImpl
		 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringPackageImpl#getBreakpoints()
		 * @generated
		 */
		EClass BREAKPOINTS = eINSTANCE.getBreakpoints();

		/**
		 * The meta object literal for the '<em><b>Breakpoints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BREAKPOINTS__BREAKPOINTS = eINSTANCE.getBreakpoints_Breakpoints();

		/**
		 * The meta object literal for the '{@link org.eclipse.fordiac.ide.gef.editparts.IEditPartCreator <em>IEdit Part Creator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.fordiac.ide.gef.editparts.IEditPartCreator
		 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringPackageImpl#getIEditPartCreator()
		 * @generated
		 */
		EClass IEDIT_PART_CREATOR = eINSTANCE.getIEditPartCreator();

		/**
		 * The meta object literal for the '{@link org.eclipse.fordiac.ide.model.monitoring.impl.PortElementImpl <em>Port Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.fordiac.ide.model.monitoring.impl.PortElementImpl
		 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringPackageImpl#getPortElement()
		 * @generated
		 */
		EClass PORT_ELEMENT = eINSTANCE.getPortElement();

		/**
		 * The meta object literal for the '<em><b>Fb</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_ELEMENT__FB = eINSTANCE.getPortElement_Fb();

		/**
		 * The meta object literal for the '<em><b>Interface Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_ELEMENT__INTERFACE_ELEMENT = eINSTANCE.getPortElement_InterfaceElement();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_ELEMENT__RESOURCE = eINSTANCE.getPortElement_Resource();

		/**
		 * The meta object literal for the '<em><b>Device</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_ELEMENT__DEVICE = eINSTANCE.getPortElement_Device();

		/**
		 * The meta object literal for the '<em><b>System</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_ELEMENT__SYSTEM = eINSTANCE.getPortElement_System();

		/**
		 * The meta object literal for the '<em><b>Hierarchy</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_ELEMENT__HIERARCHY = eINSTANCE.getPortElement_Hierarchy();

		/**
		 * The meta object literal for the '{@link org.eclipse.fordiac.ide.model.monitoring.impl.AdapterPortElementImpl <em>Adapter Port Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.fordiac.ide.model.monitoring.impl.AdapterPortElementImpl
		 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringPackageImpl#getAdapterPortElement()
		 * @generated
		 */
		EClass ADAPTER_PORT_ELEMENT = eINSTANCE.getAdapterPortElement();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER_PORT_ELEMENT__PORTS = eINSTANCE.getAdapterPortElement_Ports();

		/**
		 * The meta object literal for the '{@link org.eclipse.fordiac.ide.model.monitoring.impl.AdapterMonitoringEventImpl <em>Adapter Monitoring Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.fordiac.ide.model.monitoring.impl.AdapterMonitoringEventImpl
		 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringPackageImpl#getAdapterMonitoringEvent()
		 * @generated
		 */
		EClass ADAPTER_MONITORING_EVENT = eINSTANCE.getAdapterMonitoringEvent();

		/**
		 * The meta object literal for the '{@link org.eclipse.fordiac.ide.model.monitoring.impl.AdapterMonitoringVarDeclarationImpl <em>Adapter Monitoring Var Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.fordiac.ide.model.monitoring.impl.AdapterMonitoringVarDeclarationImpl
		 * @see org.eclipse.fordiac.ide.model.monitoring.impl.MonitoringPackageImpl#getAdapterMonitoringVarDeclaration()
		 * @generated
		 */
		EClass ADAPTER_MONITORING_VAR_DECLARATION = eINSTANCE.getAdapterMonitoringVarDeclaration();

	}

} //MonitoringPackage
