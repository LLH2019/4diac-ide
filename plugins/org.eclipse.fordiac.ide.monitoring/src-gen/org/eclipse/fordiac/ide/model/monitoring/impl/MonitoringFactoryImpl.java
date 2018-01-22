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


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.fordiac.ide.model.monitoring.*;
import org.eclipse.fordiac.ide.model.monitoring.AdapterMonitoringEvent;
import org.eclipse.fordiac.ide.model.monitoring.AdapterMonitoringVarDeclaration;
import org.eclipse.fordiac.ide.model.monitoring.AdapterPortElement;
import org.eclipse.fordiac.ide.model.monitoring.Breakpoints;
import org.eclipse.fordiac.ide.model.monitoring.MonitoringAdapterElement;
import org.eclipse.fordiac.ide.model.monitoring.MonitoringElement;
import org.eclipse.fordiac.ide.model.monitoring.MonitoringFactory;
import org.eclipse.fordiac.ide.model.monitoring.MonitoringPackage;
import org.eclipse.fordiac.ide.model.monitoring.PortElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MonitoringFactoryImpl extends EFactoryImpl implements MonitoringFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MonitoringFactory init() {
		try {
			MonitoringFactory theMonitoringFactory = (MonitoringFactory)EPackage.Registry.INSTANCE.getEFactory(MonitoringPackage.eNS_URI);
			if (theMonitoringFactory != null) {
				return theMonitoringFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MonitoringFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MonitoringFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MonitoringPackage.MONITORING_ELEMENT: return createMonitoringElement();
			case MonitoringPackage.MONITORING_ADAPTER_ELEMENT: return createMonitoringAdapterElement();
			case MonitoringPackage.BREAKPOINTS: return createBreakpoints();
			case MonitoringPackage.PORT_ELEMENT: return createPortElement();
			case MonitoringPackage.ADAPTER_PORT_ELEMENT: return createAdapterPortElement();
			case MonitoringPackage.ADAPTER_MONITORING_EVENT: return createAdapterMonitoringEvent();
			case MonitoringPackage.ADAPTER_MONITORING_VAR_DECLARATION: return createAdapterMonitoringVarDeclaration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MonitoringElement createMonitoringElement() {
		MonitoringElementImpl monitoringElement = new MonitoringElementImpl();
		return monitoringElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MonitoringAdapterElement createMonitoringAdapterElement() {
		MonitoringAdapterElementImpl monitoringAdapterElement = new MonitoringAdapterElementImpl();
		return monitoringAdapterElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Breakpoints createBreakpoints() {
		BreakpointsImpl breakpoints = new BreakpointsImpl();
		return breakpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortElement createPortElement() {
		PortElementImpl portElement = new PortElementImpl();
		return portElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdapterPortElement createAdapterPortElement() {
		AdapterPortElementImpl adapterPortElement = new AdapterPortElementImpl();
		return adapterPortElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdapterMonitoringEvent createAdapterMonitoringEvent() {
		AdapterMonitoringEventImpl adapterMonitoringEvent = new AdapterMonitoringEventImpl();
		return adapterMonitoringEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdapterMonitoringVarDeclaration createAdapterMonitoringVarDeclaration() {
		AdapterMonitoringVarDeclarationImpl adapterMonitoringVarDeclaration = new AdapterMonitoringVarDeclarationImpl();
		return adapterMonitoringVarDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MonitoringPackage getMonitoringPackage() {
		return (MonitoringPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MonitoringPackage getPackage() {
		return MonitoringPackage.eINSTANCE;
	}

} //MonitoringFactoryImpl
