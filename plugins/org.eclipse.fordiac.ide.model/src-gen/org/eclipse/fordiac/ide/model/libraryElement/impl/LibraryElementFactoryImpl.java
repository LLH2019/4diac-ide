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

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.fordiac.ide.model.libraryElement.AdapterConnection;
import org.eclipse.fordiac.ide.model.libraryElement.AdapterDeclaration;
import org.eclipse.fordiac.ide.model.libraryElement.AdapterEvent;
import org.eclipse.fordiac.ide.model.libraryElement.AdapterFB;
import org.eclipse.fordiac.ide.model.libraryElement.AdapterFBType;
import org.eclipse.fordiac.ide.model.libraryElement.AdapterType;
import org.eclipse.fordiac.ide.model.libraryElement.Annotation;
import org.eclipse.fordiac.ide.model.libraryElement.Application;
import org.eclipse.fordiac.ide.model.libraryElement.Attribute;
import org.eclipse.fordiac.ide.model.libraryElement.AttributeDeclaration;
import org.eclipse.fordiac.ide.model.libraryElement.AutomationSystem;
import org.eclipse.fordiac.ide.model.libraryElement.BasicFBType;
import org.eclipse.fordiac.ide.model.libraryElement.Color;
import org.eclipse.fordiac.ide.model.libraryElement.ColorizableElement;
import org.eclipse.fordiac.ide.model.libraryElement.CompilableType;
import org.eclipse.fordiac.ide.model.libraryElement.CompilerInfo;
import org.eclipse.fordiac.ide.model.libraryElement.CompositeFBType;
import org.eclipse.fordiac.ide.model.libraryElement.ConfigurableObject;
import org.eclipse.fordiac.ide.model.libraryElement.DataConnection;
import org.eclipse.fordiac.ide.model.libraryElement.Device;
import org.eclipse.fordiac.ide.model.libraryElement.DeviceType;
import org.eclipse.fordiac.ide.model.libraryElement.ECAction;
import org.eclipse.fordiac.ide.model.libraryElement.ECC;
import org.eclipse.fordiac.ide.model.libraryElement.ECState;
import org.eclipse.fordiac.ide.model.libraryElement.ECTransition;
import org.eclipse.fordiac.ide.model.libraryElement.Event;
import org.eclipse.fordiac.ide.model.libraryElement.EventConnection;
import org.eclipse.fordiac.ide.model.libraryElement.FB;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.FBType;
import org.eclipse.fordiac.ide.model.libraryElement.IInterfaceElement;
import org.eclipse.fordiac.ide.model.libraryElement.Identification;
import org.eclipse.fordiac.ide.model.libraryElement.InputPrimitive;
import org.eclipse.fordiac.ide.model.libraryElement.InterfaceList;
import org.eclipse.fordiac.ide.model.libraryElement.Language;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElement;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementFactory;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage;
import org.eclipse.fordiac.ide.model.libraryElement.Link;
import org.eclipse.fordiac.ide.model.libraryElement.Mapping;
import org.eclipse.fordiac.ide.model.libraryElement.OtherAlgorithm;
import org.eclipse.fordiac.ide.model.libraryElement.OutputPrimitive;
import org.eclipse.fordiac.ide.model.libraryElement.PositionableElement;
import org.eclipse.fordiac.ide.model.libraryElement.Primitive;
import org.eclipse.fordiac.ide.model.libraryElement.Resource;
import org.eclipse.fordiac.ide.model.libraryElement.ResourceType;
import org.eclipse.fordiac.ide.model.libraryElement.ResourceTypeFB;
import org.eclipse.fordiac.ide.model.libraryElement.ResourceTypeName;
import org.eclipse.fordiac.ide.model.libraryElement.STAlgorithm;
import org.eclipse.fordiac.ide.model.libraryElement.Segment;
import org.eclipse.fordiac.ide.model.libraryElement.SegmentType;
import org.eclipse.fordiac.ide.model.libraryElement.Service;
import org.eclipse.fordiac.ide.model.libraryElement.ServiceInterface;
import org.eclipse.fordiac.ide.model.libraryElement.ServiceInterfaceFBType;
import org.eclipse.fordiac.ide.model.libraryElement.ServiceSequence;
import org.eclipse.fordiac.ide.model.libraryElement.ServiceTransaction;
import org.eclipse.fordiac.ide.model.libraryElement.SubApp;
import org.eclipse.fordiac.ide.model.libraryElement.SubAppType;
import org.eclipse.fordiac.ide.model.libraryElement.SystemConfiguration;
import org.eclipse.fordiac.ide.model.libraryElement.TypedConfigureableObject;
import org.eclipse.fordiac.ide.model.libraryElement.Value;
import org.eclipse.fordiac.ide.model.libraryElement.VarDeclaration;
import org.eclipse.fordiac.ide.model.libraryElement.VersionInfo;
import org.eclipse.fordiac.ide.model.libraryElement.With;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class LibraryElementFactoryImpl extends EFactoryImpl implements
		LibraryElementFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static LibraryElementFactory init() {
		try {
			LibraryElementFactory theLibraryElementFactory = (LibraryElementFactory)EPackage.Registry.INSTANCE.getEFactory(LibraryElementPackage.eNS_URI);
			if (theLibraryElementFactory != null) {
				return theLibraryElementFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LibraryElementFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public LibraryElementFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case LibraryElementPackage.ADAPTER_DECLARATION: return createAdapterDeclaration();
			case LibraryElementPackage.ADAPTER_TYPE: return createAdapterType();
			case LibraryElementPackage.APPLICATION: return createApplication();
			case LibraryElementPackage.BASIC_FB_TYPE: return createBasicFBType();
			case LibraryElementPackage.COMPILER_INFO: return createCompilerInfo();
			case LibraryElementPackage.COMPILER: return createCompiler();
			case LibraryElementPackage.DEVICE: return createDevice();
			case LibraryElementPackage.DEVICE_TYPE: return createDeviceType();
			case LibraryElementPackage.EC_ACTION: return createECAction();
			case LibraryElementPackage.ECC: return createECC();
			case LibraryElementPackage.EC_STATE: return createECState();
			case LibraryElementPackage.EC_TRANSITION: return createECTransition();
			case LibraryElementPackage.EVENT: return createEvent();
			case LibraryElementPackage.FB: return createFB();
			case LibraryElementPackage.FB_NETWORK_ELEMENT: return createFBNetworkElement();
			case LibraryElementPackage.SUB_APP: return createSubApp();
			case LibraryElementPackage.FB_TYPE: return createFBType();
			case LibraryElementPackage.IDENTIFICATION: return createIdentification();
			case LibraryElementPackage.INPUT_PRIMITIVE: return createInputPrimitive();
			case LibraryElementPackage.INTERFACE_LIST: return createInterfaceList();
			case LibraryElementPackage.LINK: return createLink();
			case LibraryElementPackage.MAPPING: return createMapping();
			case LibraryElementPackage.OTHER_ALGORITHM: return createOtherAlgorithm();
			case LibraryElementPackage.OUTPUT_PRIMITIVE: return createOutputPrimitive();
			case LibraryElementPackage.ATTRIBUTE: return createAttribute();
			case LibraryElementPackage.RESOURCE: return createResource();
			case LibraryElementPackage.RESOURCE_TYPE_NAME: return createResourceTypeName();
			case LibraryElementPackage.RESOURCE_TYPE: return createResourceType();
			case LibraryElementPackage.SEGMENT: return createSegment();
			case LibraryElementPackage.SERVICE_SEQUENCE: return createServiceSequence();
			case LibraryElementPackage.SERVICE_TRANSACTION: return createServiceTransaction();
			case LibraryElementPackage.SERVICE_INTERFACE_FB_TYPE: return createServiceInterfaceFBType();
			case LibraryElementPackage.ST_ALGORITHM: return createSTAlgorithm();
			case LibraryElementPackage.FB_NETWORK: return createFBNetwork();
			case LibraryElementPackage.SUB_APP_TYPE: return createSubAppType();
			case LibraryElementPackage.AUTOMATION_SYSTEM: return createAutomationSystem();
			case LibraryElementPackage.VAR_DECLARATION: return createVarDeclaration();
			case LibraryElementPackage.VERSION_INFO: return createVersionInfo();
			case LibraryElementPackage.WITH: return createWith();
			case LibraryElementPackage.LIBRARY_ELEMENT: return createLibraryElement();
			case LibraryElementPackage.COMPILABLE_TYPE: return createCompilableType();
			case LibraryElementPackage.CONFIGURABLE_OBJECT: return createConfigurableObject();
			case LibraryElementPackage.COMPOSITE_FB_TYPE: return createCompositeFBType();
			case LibraryElementPackage.DATA_CONNECTION: return createDataConnection();
			case LibraryElementPackage.EVENT_CONNECTION: return createEventConnection();
			case LibraryElementPackage.ADAPTER_CONNECTION: return createAdapterConnection();
			case LibraryElementPackage.SERVICE_INTERFACE: return createServiceInterface();
			case LibraryElementPackage.IINTERFACE_ELEMENT: return createIInterfaceElement();
			case LibraryElementPackage.VALUE: return createValue();
			case LibraryElementPackage.SYSTEM_CONFIGURATION: return createSystemConfiguration();
			case LibraryElementPackage.RESOURCE_TYPE_FB: return createResourceTypeFB();
			case LibraryElementPackage.SEGMENT_TYPE: return createSegmentType();
			case LibraryElementPackage.ADAPTER_FB_TYPE: return createAdapterFBType();
			case LibraryElementPackage.ANNOTATION: return createAnnotation();
			case LibraryElementPackage.ADAPTER_EVENT: return createAdapterEvent();
			case LibraryElementPackage.SERVICE: return createService();
			case LibraryElementPackage.TYPED_CONFIGUREABLE_OBJECT: return createTypedConfigureableObject();
			case LibraryElementPackage.ADAPTER_FB: return createAdapterFB();
			case LibraryElementPackage.PRIMITIVE: return createPrimitive();
			case LibraryElementPackage.POSITIONABLE_ELEMENT: return createPositionableElement();
			case LibraryElementPackage.COLOR: return createColor();
			case LibraryElementPackage.COLORIZABLE_ELEMENT: return createColorizableElement();
			case LibraryElementPackage.ATTRIBUTE_DECLARATION: return createAttributeDeclaration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case LibraryElementPackage.LANGUAGE:
				return createLanguageFromString(eDataType, initialValue);
			case LibraryElementPackage.IPROJECT:
				return createIProjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case LibraryElementPackage.LANGUAGE:
				return convertLanguageToString(eDataType, instanceValue);
			case LibraryElementPackage.IPROJECT:
				return convertIProjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AdapterDeclaration createAdapterDeclaration() {
		AdapterDeclarationImpl adapterDeclaration = new AdapterDeclarationImpl();
		return adapterDeclaration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AdapterType createAdapterType() {
		AdapterTypeImpl adapterType = new AdapterTypeImpl();
		return adapterType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Application createApplication() {
		ApplicationImpl application = new ApplicationImpl();
		return application;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BasicFBType createBasicFBType() {
		BasicFBTypeImpl basicFBType = new BasicFBTypeImpl();
		return basicFBType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompilerInfo createCompilerInfo() {
		CompilerInfoImpl compilerInfo = new CompilerInfoImpl();
		return compilerInfo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.fordiac.ide.model.libraryElement.Compiler createCompiler() {
		CompilerImpl compiler = new CompilerImpl();
		return compiler;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Device createDevice() {
		DeviceImpl device = new DeviceImpl();
		return device;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeviceType createDeviceType() {
		DeviceTypeImpl deviceType = new DeviceTypeImpl();
		return deviceType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ECAction createECAction() {
		ECActionImpl ecAction = new ECActionImpl();
		return ecAction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ECC createECC() {
		ECCImpl ecc = new ECCImpl();
		return ecc;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ECState createECState() {
		ECStateImpl ecState = new ECStateImpl();
		return ecState;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ECTransition createECTransition() {
		ECTransitionImpl ecTransition = new ECTransitionImpl();
		return ecTransition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Event createEvent() {
		EventImpl event = new EventImpl();
		return event;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FBNetwork createFBNetwork() {
		FBNetworkImpl fbNetwork = new FBNetworkImpl();
		return fbNetwork;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FB createFB() {
		FBImpl fb = new FBImpl();
		return fb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FBNetworkElement createFBNetworkElement() {
		FBNetworkElementImpl fbNetworkElement = new FBNetworkElementImpl();
		return fbNetworkElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FBType createFBType() {
		FBTypeImpl fbType = new FBTypeImpl();
		return fbType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Identification createIdentification() {
		IdentificationImpl identification = new IdentificationImpl();
		return identification;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InputPrimitive createInputPrimitive() {
		InputPrimitiveImpl inputPrimitive = new InputPrimitiveImpl();
		return inputPrimitive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InterfaceList createInterfaceList() {
		InterfaceListImpl interfaceList = new InterfaceListImpl();
		return interfaceList;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Link createLink() {
		LinkImpl link = new LinkImpl();
		return link;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Mapping createMapping() {
		MappingImpl mapping = new MappingImpl();
		return mapping;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OtherAlgorithm createOtherAlgorithm() {
		OtherAlgorithmImpl otherAlgorithm = new OtherAlgorithmImpl();
		return otherAlgorithm;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OutputPrimitive createOutputPrimitive() {
		OutputPrimitiveImpl outputPrimitive = new OutputPrimitiveImpl();
		return outputPrimitive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Resource createResource() {
		ResourceImpl resource = new ResourceImpl();
		return resource;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceTypeName createResourceTypeName() {
		ResourceTypeNameImpl resourceTypeName = new ResourceTypeNameImpl();
		return resourceTypeName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceType createResourceType() {
		ResourceTypeImpl resourceType = new ResourceTypeImpl();
		return resourceType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Segment createSegment() {
		SegmentImpl segment = new SegmentImpl();
		return segment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ServiceSequence createServiceSequence() {
		ServiceSequenceImpl serviceSequence = new ServiceSequenceImpl();
		return serviceSequence;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ServiceTransaction createServiceTransaction() {
		ServiceTransactionImpl serviceTransaction = new ServiceTransactionImpl();
		return serviceTransaction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ServiceInterfaceFBType createServiceInterfaceFBType() {
		ServiceInterfaceFBTypeImpl serviceInterfaceFBType = new ServiceInterfaceFBTypeImpl();
		return serviceInterfaceFBType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public STAlgorithm createSTAlgorithm() {
		STAlgorithmImpl stAlgorithm = new STAlgorithmImpl();
		return stAlgorithm;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubApp createSubApp() {
		SubAppImpl subApp = new SubAppImpl();
		return subApp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubAppType createSubAppType() {
		SubAppTypeImpl subAppType = new SubAppTypeImpl();
		return subAppType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AutomationSystem createAutomationSystem() {
		AutomationSystemImpl automationSystem = new AutomationSystemImpl();
		return automationSystem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VarDeclaration createVarDeclaration() {
		VarDeclarationImpl varDeclaration = new VarDeclarationImpl();
		return varDeclaration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VersionInfo createVersionInfo() {
		VersionInfoImpl versionInfo = new VersionInfoImpl();
		return versionInfo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public With createWith() {
		WithImpl with = new WithImpl();
		return with;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LibraryElement createLibraryElement() {
		LibraryElementImpl libraryElement = new LibraryElementImpl();
		return libraryElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompilableType createCompilableType() {
		CompilableTypeImpl compilableType = new CompilableTypeImpl();
		return compilableType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConfigurableObject createConfigurableObject() {
		ConfigurableObjectImpl configurableObject = new ConfigurableObjectImpl();
		return configurableObject;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeFBType createCompositeFBType() {
		CompositeFBTypeImpl compositeFBType = new CompositeFBTypeImpl();
		return compositeFBType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataConnection createDataConnection() {
		DataConnectionImpl dataConnection = new DataConnectionImpl();
		return dataConnection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventConnection createEventConnection() {
		EventConnectionImpl eventConnection = new EventConnectionImpl();
		return eventConnection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AdapterConnection createAdapterConnection() {
		AdapterConnectionImpl adapterConnection = new AdapterConnectionImpl();
		return adapterConnection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ServiceInterface createServiceInterface() {
		ServiceInterfaceImpl serviceInterface = new ServiceInterfaceImpl();
		return serviceInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInterfaceElement createIInterfaceElement() {
		IInterfaceElementImpl iInterfaceElement = new IInterfaceElementImpl();
		return iInterfaceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Value createValue() {
		ValueImpl value = new ValueImpl();
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SystemConfiguration createSystemConfiguration() {
		SystemConfigurationImpl systemConfiguration = new SystemConfigurationImpl();
		return systemConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceTypeFB createResourceTypeFB() {
		ResourceTypeFBImpl resourceTypeFB = new ResourceTypeFBImpl();
		return resourceTypeFB;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SegmentType createSegmentType() {
		SegmentTypeImpl segmentType = new SegmentTypeImpl();
		return segmentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AdapterFBType createAdapterFBType() {
		AdapterFBTypeImpl adapterFBType = new AdapterFBTypeImpl();
		return adapterFBType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Annotation createAnnotation() {
		AnnotationImpl annotation = new AnnotationImpl();
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AdapterEvent createAdapterEvent() {
		AdapterEventImpl adapterEvent = new AdapterEventImpl();
		return adapterEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Service createService() {
		ServiceImpl service = new ServiceImpl();
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedConfigureableObject createTypedConfigureableObject() {
		TypedConfigureableObjectImpl typedConfigureableObject = new TypedConfigureableObjectImpl();
		return typedConfigureableObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AdapterFB createAdapterFB() {
		AdapterFBImpl adapterFB = new AdapterFBImpl();
		return adapterFB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Primitive createPrimitive() {
		PrimitiveImpl primitive = new PrimitiveImpl();
		return primitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PositionableElement createPositionableElement() {
		PositionableElementImpl positionableElement = new PositionableElementImpl();
		return positionableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Color createColor() {
		ColorImpl color = new ColorImpl();
		return color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ColorizableElement createColorizableElement() {
		ColorizableElementImpl colorizableElement = new ColorizableElementImpl();
		return colorizableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributeDeclaration createAttributeDeclaration() {
		AttributeDeclarationImpl attributeDeclaration = new AttributeDeclarationImpl();
		return attributeDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Language createLanguageFromString(EDataType eDataType,
			String initialValue) {
		Language result = Language.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLanguageToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IProject createIProjectFromString(EDataType eDataType, String initialValue) {
		return (IProject)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIProjectToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LibraryElementPackage getLibraryElementPackage() {
		return (LibraryElementPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LibraryElementPackage getPackage() {
		return LibraryElementPackage.eINSTANCE;
	}

} // LibraryElementFactoryImpl
