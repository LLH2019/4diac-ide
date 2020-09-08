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
package org.eclipse.fordiac.ide.model.iec61131.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fordiac.ide.model.iec61131.Program;
import org.eclipse.fordiac.ide.model.iec61131.ProgramInstance;
import org.eclipse.fordiac.ide.model.iec61131.iec61131Package;
import org.eclipse.fordiac.ide.model.libraryElement.CompilableType;
import org.eclipse.fordiac.ide.model.libraryElement.ConfigurableObject;
import org.eclipse.fordiac.ide.model.libraryElement.FB;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.FBType;
import org.eclipse.fordiac.ide.model.libraryElement.INamedElement;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElement;
import org.eclipse.fordiac.ide.model.libraryElement.PositionableElement;
import org.eclipse.fordiac.ide.model.libraryElement.TypedConfigureableObject;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 *
 * @see org.eclipse.fordiac.ide.model.iec61131.iec61131Package
 * @generated
 */
public class iec61131AdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected static iec61131Package modelPackage;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	public iec61131AdapterFactory() {
		if (modelPackage == null) {
			modelPackage = iec61131Package.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object. <!--
	 * begin-user-doc --> This implementation returns <code>true</code> if the
	 * object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 *
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected iec61131Switch<Adapter> modelSwitch = new iec61131Switch<>() {
		@Override
		public Adapter caseProgram(Program object) {
			return createProgramAdapter();
		}

		@Override
		public Adapter caseProgramInstance(ProgramInstance object) {
			return createProgramInstanceAdapter();
		}

		@Override
		public Adapter caseINamedElement(INamedElement object) {
			return createINamedElementAdapter();
		}

		@Override
		public Adapter caseLibraryElement(LibraryElement object) {
			return createLibraryElementAdapter();
		}

		@Override
		public Adapter caseCompilableType(CompilableType object) {
			return createCompilableTypeAdapter();
		}

		@Override
		public Adapter caseFBType(FBType object) {
			return createFBTypeAdapter();
		}

		@Override
		public Adapter caseConfigurableObject(ConfigurableObject object) {
			return createConfigurableObjectAdapter();
		}

		@Override
		public Adapter caseTypedConfigureableObject(TypedConfigureableObject object) {
			return createTypedConfigureableObjectAdapter();
		}

		@Override
		public Adapter casePositionableElement(PositionableElement object) {
			return createPositionableElementAdapter();
		}

		@Override
		public Adapter caseFBNetworkElement(FBNetworkElement object) {
			return createFBNetworkElementAdapter();
		}

		@Override
		public Adapter caseFB(FB object) {
			return createFBAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link org.eclipse.fordiac.ide.model.iec61131.Program <em>Program</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.fordiac.ide.model.iec61131.Program
	 * @generated
	 */
	public Adapter createProgramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link org.eclipse.fordiac.ide.model.iec61131.ProgramInstance <em>Program
	 * Instance</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.fordiac.ide.model.iec61131.ProgramInstance
	 * @generated
	 */
	public Adapter createProgramInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link org.eclipse.fordiac.ide.model.libraryElement.INamedElement <em>INamed
	 * Element</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.fordiac.ide.model.libraryElement.INamedElement
	 * @generated
	 */
	public Adapter createINamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link org.eclipse.fordiac.ide.model.libraryElement.LibraryElement
	 * <em>Library Element</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.fordiac.ide.model.libraryElement.LibraryElement
	 * @generated
	 */
	public Adapter createLibraryElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link org.eclipse.fordiac.ide.model.libraryElement.CompilableType
	 * <em>Compilable Type</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.fordiac.ide.model.libraryElement.CompilableType
	 * @generated
	 */
	public Adapter createCompilableTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link org.eclipse.fordiac.ide.model.libraryElement.FBType <em>FB
	 * Type</em>}'. <!-- begin-user-doc --> This default implementation returns null
	 * so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.fordiac.ide.model.libraryElement.FBType
	 * @generated
	 */
	public Adapter createFBTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link org.eclipse.fordiac.ide.model.libraryElement.ConfigurableObject
	 * <em>Configurable Object</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.fordiac.ide.model.libraryElement.ConfigurableObject
	 * @generated
	 */
	public Adapter createConfigurableObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link org.eclipse.fordiac.ide.model.libraryElement.TypedConfigureableObject
	 * <em>Typed Configureable Object</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.fordiac.ide.model.libraryElement.TypedConfigureableObject
	 * @generated
	 */
	public Adapter createTypedConfigureableObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link org.eclipse.fordiac.ide.model.libraryElement.PositionableElement
	 * <em>Positionable Element</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.fordiac.ide.model.libraryElement.PositionableElement
	 * @generated
	 */
	public Adapter createPositionableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement <em>FB
	 * Network Element</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a case
	 * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement
	 * @generated
	 */
	public Adapter createFBNetworkElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class
	 * '{@link org.eclipse.fordiac.ide.model.libraryElement.FB <em>FB</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.fordiac.ide.model.libraryElement.FB
	 * @generated
	 */
	public Adapter createFBAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case. <!-- begin-user-doc --> This
	 * default implementation returns null. <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // iec61131AdapterFactory
