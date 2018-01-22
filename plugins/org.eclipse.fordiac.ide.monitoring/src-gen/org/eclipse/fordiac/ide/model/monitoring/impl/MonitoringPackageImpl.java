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


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.fordiac.ide.gef.editparts.IEditPartCreator;
import org.eclipse.fordiac.ide.model.Palette.PalettePackage;
import org.eclipse.fordiac.ide.model.data.DataPackage;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage;
import org.eclipse.fordiac.ide.model.monitoring.AdapterMonitoringEvent;
import org.eclipse.fordiac.ide.model.monitoring.AdapterMonitoringVarDeclaration;
import org.eclipse.fordiac.ide.model.monitoring.AdapterPortElement;
import org.eclipse.fordiac.ide.model.monitoring.Breakpoints;
import org.eclipse.fordiac.ide.model.monitoring.MonitoringAdapterElement;
import org.eclipse.fordiac.ide.model.monitoring.MonitoringBaseElement;
import org.eclipse.fordiac.ide.model.monitoring.MonitoringElement;
import org.eclipse.fordiac.ide.model.monitoring.MonitoringFactory;
import org.eclipse.fordiac.ide.model.monitoring.MonitoringPackage;
import org.eclipse.fordiac.ide.model.monitoring.PortElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MonitoringPackageImpl extends EPackageImpl implements MonitoringPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass monitoringBaseElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass monitoringElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass monitoringAdapterElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass breakpointsEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iEditPartCreatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adapterPortElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adapterMonitoringEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adapterMonitoringVarDeclarationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.fordiac.ide.model.monitoring.MonitoringPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MonitoringPackageImpl() {
		super(eNS_URI, MonitoringFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MonitoringPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MonitoringPackage init() {
		if (isInited) return (MonitoringPackage)EPackage.Registry.INSTANCE.getEPackage(MonitoringPackage.eNS_URI);

		// Obtain or create and register package
		MonitoringPackageImpl theMonitoringPackage = (MonitoringPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MonitoringPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MonitoringPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		PalettePackage.eINSTANCE.eClass();
		LibraryElementPackage.eINSTANCE.eClass();
		DataPackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theMonitoringPackage.createPackageContents();

		// Initialize created meta-data
		theMonitoringPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMonitoringPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MonitoringPackage.eNS_URI, theMonitoringPackage);
		return theMonitoringPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMonitoringBaseElement() {
		return monitoringBaseElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMonitoringBaseElement_Port() {
		return (EReference)monitoringBaseElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMonitoringBaseElement_Offline() {
		return (EAttribute)monitoringBaseElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMonitoringElement() {
		return monitoringElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMonitoringElement_Force() {
		return (EAttribute)monitoringElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMonitoringElement_ForceValue() {
		return (EAttribute)monitoringElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMonitoringElement_Breakpoint() {
		return (EAttribute)monitoringElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMonitoringElement_BreakpointActive() {
		return (EAttribute)monitoringElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMonitoringElement_BreakpointCondition() {
		return (EAttribute)monitoringElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMonitoringElement_CurrentValue() {
		return (EAttribute)monitoringElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMonitoringElement_Sec() {
		return (EAttribute)monitoringElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMonitoringElement_Usec() {
		return (EAttribute)monitoringElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMonitoringAdapterElement() {
		return monitoringAdapterElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMonitoringAdapterElement_Elements() {
		return (EReference)monitoringAdapterElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMonitoringAdapterElement_MonitoredAdapterFB() {
		return (EReference)monitoringAdapterElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBreakpoints() {
		return breakpointsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBreakpoints_Breakpoints() {
		return (EReference)breakpointsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIEditPartCreator() {
		return iEditPartCreatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortElement() {
		return portElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortElement_Fb() {
		return (EReference)portElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortElement_InterfaceElement() {
		return (EReference)portElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortElement_Resource() {
		return (EReference)portElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortElement_Device() {
		return (EReference)portElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortElement_System() {
		return (EReference)portElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPortElement_Hierarchy() {
		return (EAttribute)portElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdapterPortElement() {
		return adapterPortElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdapterPortElement_Ports() {
		return (EReference)adapterPortElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdapterMonitoringEvent() {
		return adapterMonitoringEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdapterMonitoringVarDeclaration() {
		return adapterMonitoringVarDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MonitoringFactory getMonitoringFactory() {
		return (MonitoringFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		monitoringBaseElementEClass = createEClass(MONITORING_BASE_ELEMENT);
		createEReference(monitoringBaseElementEClass, MONITORING_BASE_ELEMENT__PORT);
		createEAttribute(monitoringBaseElementEClass, MONITORING_BASE_ELEMENT__OFFLINE);

		monitoringElementEClass = createEClass(MONITORING_ELEMENT);
		createEAttribute(monitoringElementEClass, MONITORING_ELEMENT__FORCE);
		createEAttribute(monitoringElementEClass, MONITORING_ELEMENT__FORCE_VALUE);
		createEAttribute(monitoringElementEClass, MONITORING_ELEMENT__BREAKPOINT);
		createEAttribute(monitoringElementEClass, MONITORING_ELEMENT__BREAKPOINT_ACTIVE);
		createEAttribute(monitoringElementEClass, MONITORING_ELEMENT__BREAKPOINT_CONDITION);
		createEAttribute(monitoringElementEClass, MONITORING_ELEMENT__CURRENT_VALUE);
		createEAttribute(monitoringElementEClass, MONITORING_ELEMENT__SEC);
		createEAttribute(monitoringElementEClass, MONITORING_ELEMENT__USEC);

		monitoringAdapterElementEClass = createEClass(MONITORING_ADAPTER_ELEMENT);
		createEReference(monitoringAdapterElementEClass, MONITORING_ADAPTER_ELEMENT__ELEMENTS);
		createEReference(monitoringAdapterElementEClass, MONITORING_ADAPTER_ELEMENT__MONITORED_ADAPTER_FB);

		breakpointsEClass = createEClass(BREAKPOINTS);
		createEReference(breakpointsEClass, BREAKPOINTS__BREAKPOINTS);

		iEditPartCreatorEClass = createEClass(IEDIT_PART_CREATOR);

		portElementEClass = createEClass(PORT_ELEMENT);
		createEReference(portElementEClass, PORT_ELEMENT__FB);
		createEReference(portElementEClass, PORT_ELEMENT__INTERFACE_ELEMENT);
		createEReference(portElementEClass, PORT_ELEMENT__RESOURCE);
		createEReference(portElementEClass, PORT_ELEMENT__DEVICE);
		createEReference(portElementEClass, PORT_ELEMENT__SYSTEM);
		createEAttribute(portElementEClass, PORT_ELEMENT__HIERARCHY);

		adapterPortElementEClass = createEClass(ADAPTER_PORT_ELEMENT);
		createEReference(adapterPortElementEClass, ADAPTER_PORT_ELEMENT__PORTS);

		adapterMonitoringEventEClass = createEClass(ADAPTER_MONITORING_EVENT);

		adapterMonitoringVarDeclarationEClass = createEClass(ADAPTER_MONITORING_VAR_DECLARATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		LibraryElementPackage theLibraryElementPackage = (LibraryElementPackage)EPackage.Registry.INSTANCE.getEPackage(LibraryElementPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		monitoringBaseElementEClass.getESuperTypes().add(this.getIEditPartCreator());
		monitoringElementEClass.getESuperTypes().add(this.getMonitoringBaseElement());
		monitoringAdapterElementEClass.getESuperTypes().add(this.getMonitoringBaseElement());
		adapterPortElementEClass.getESuperTypes().add(this.getPortElement());
		adapterMonitoringEventEClass.getESuperTypes().add(this.getIEditPartCreator());
		adapterMonitoringEventEClass.getESuperTypes().add(theLibraryElementPackage.getEvent());
		adapterMonitoringVarDeclarationEClass.getESuperTypes().add(this.getIEditPartCreator());
		adapterMonitoringVarDeclarationEClass.getESuperTypes().add(theLibraryElementPackage.getVarDeclaration());

		// Initialize classes and features; add operations and parameters
		initEClass(monitoringBaseElementEClass, MonitoringBaseElement.class, "MonitoringBaseElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMonitoringBaseElement_Port(), this.getPortElement(), null, "port", null, 0, 1, MonitoringBaseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMonitoringBaseElement_Offline(), theXMLTypePackage.getBoolean(), "offline", "true", 0, 1, MonitoringBaseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(monitoringBaseElementEClass, theXMLTypePackage.getString(), "getPortString", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(monitoringBaseElementEClass, theXMLTypePackage.getString(), "getResourceString", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(monitoringBaseElementEClass, theXMLTypePackage.getString(), "getFBString", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(monitoringBaseElementEClass, theXMLTypePackage.getString(), "getQualifiedString", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(monitoringElementEClass, MonitoringElement.class, "MonitoringElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMonitoringElement_Force(), theXMLTypePackage.getBoolean(), "force", "false", 0, 1, MonitoringElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMonitoringElement_ForceValue(), theXMLTypePackage.getString(), "forceValue", null, 0, 1, MonitoringElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMonitoringElement_Breakpoint(), theXMLTypePackage.getBoolean(), "breakpoint", null, 0, 1, MonitoringElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMonitoringElement_BreakpointActive(), theXMLTypePackage.getBoolean(), "breakpointActive", null, 0, 1, MonitoringElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMonitoringElement_BreakpointCondition(), theXMLTypePackage.getString(), "breakpointCondition", null, 0, 1, MonitoringElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMonitoringElement_CurrentValue(), theXMLTypePackage.getString(), "currentValue", null, 0, 1, MonitoringElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMonitoringElement_Sec(), theXMLTypePackage.getLong(), "sec", null, 0, 1, MonitoringElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMonitoringElement_Usec(), theXMLTypePackage.getLong(), "usec", null, 0, 1, MonitoringElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(monitoringElementEClass, null, "forceValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theXMLTypePackage.getString(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(monitoringAdapterElementEClass, MonitoringAdapterElement.class, "MonitoringAdapterElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMonitoringAdapterElement_Elements(), this.getMonitoringElement(), null, "elements", null, 0, -1, MonitoringAdapterElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMonitoringAdapterElement_MonitoredAdapterFB(), theLibraryElementPackage.getAdapterFB(), null, "monitoredAdapterFB", null, 0, 1, MonitoringAdapterElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(breakpointsEClass, Breakpoints.class, "Breakpoints", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBreakpoints_Breakpoints(), this.getMonitoringElement(), null, "breakpoints", null, 0, -1, Breakpoints.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iEditPartCreatorEClass, IEditPartCreator.class, "IEditPartCreator", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(portElementEClass, PortElement.class, "PortElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPortElement_Fb(), theLibraryElementPackage.getFB(), null, "fb", null, 0, 1, PortElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPortElement_InterfaceElement(), theLibraryElementPackage.getIInterfaceElement(), null, "interfaceElement", null, 0, 1, PortElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPortElement_Resource(), theLibraryElementPackage.getResource(), null, "resource", null, 0, 1, PortElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPortElement_Device(), theLibraryElementPackage.getDevice(), null, "device", null, 0, 1, PortElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPortElement_System(), theLibraryElementPackage.getAutomationSystem(), null, "system", null, 0, 1, PortElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPortElement_Hierarchy(), theXMLTypePackage.getString(), "hierarchy", null, 0, -1, PortElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(portElementEClass, theXMLTypePackage.getString(), "getPortString", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(adapterPortElementEClass, AdapterPortElement.class, "AdapterPortElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdapterPortElement_Ports(), this.getPortElement(), null, "ports", null, 0, -1, AdapterPortElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adapterMonitoringEventEClass, AdapterMonitoringEvent.class, "AdapterMonitoringEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(adapterMonitoringVarDeclarationEClass, AdapterMonitoringVarDeclaration.class, "AdapterMonitoringVarDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //MonitoringPackageImpl
