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
package org.eclipse.fordiac.ide.model.iec61131.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.fordiac.ide.model.Palette.PalettePackage;
import org.eclipse.fordiac.ide.model.Palette.impl.PalettePackageImpl;
import org.eclipse.fordiac.ide.model.data.DataPackage;
import org.eclipse.fordiac.ide.model.data.impl.DataPackageImpl;
import org.eclipse.fordiac.ide.model.iec61131.Program;
import org.eclipse.fordiac.ide.model.iec61131.ProgramInstance;
import org.eclipse.fordiac.ide.model.iec61131.iec61131Factory;
import org.eclipse.fordiac.ide.model.iec61131.iec61131Package;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage;
import org.eclipse.fordiac.ide.model.libraryElement.impl.LibraryElementPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class iec61131PackageImpl extends EPackageImpl implements iec61131Package {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass programEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass programInstanceEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method
	 * {@link #init init()}, which also performs initialization of the package, or
	 * returns the registered package, if one already exists. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.fordiac.ide.model.iec61131.iec61131Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private iec61131PackageImpl() {
		super(eNS_URI, iec61131Factory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and
	 * for any others upon which it depends.
	 *
	 * <p>
	 * This method is used to initialize {@link iec61131Package#eINSTANCE} when that
	 * field is accessed. Clients should not invoke it directly. Instead, they
	 * should simply access that field to obtain the package. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static iec61131Package init() {
		if (isInited)
			return (iec61131Package) EPackage.Registry.INSTANCE.getEPackage(iec61131Package.eNS_URI);

		// Obtain or create and register package
		Object registerediec61131Package = EPackage.Registry.INSTANCE.get(eNS_URI);
		iec61131PackageImpl theiec61131Package = registerediec61131Package instanceof iec61131PackageImpl
				? (iec61131PackageImpl) registerediec61131Package
				: new iec61131PackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PalettePackage.eNS_URI);
		PalettePackageImpl thePalettePackage = (PalettePackageImpl) (registeredPackage instanceof PalettePackageImpl
				? registeredPackage
				: PalettePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DataPackage.eNS_URI);
		DataPackageImpl theDataPackage = (DataPackageImpl) (registeredPackage instanceof DataPackageImpl
				? registeredPackage
				: DataPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(LibraryElementPackage.eNS_URI);
		LibraryElementPackageImpl theLibraryElementPackage = (LibraryElementPackageImpl) (registeredPackage instanceof LibraryElementPackageImpl
				? registeredPackage
				: LibraryElementPackage.eINSTANCE);

		// Create package meta-data objects
		theiec61131Package.createPackageContents();
		thePalettePackage.createPackageContents();
		theDataPackage.createPackageContents();
		theLibraryElementPackage.createPackageContents();

		// Initialize created meta-data
		theiec61131Package.initializePackageContents();
		thePalettePackage.initializePackageContents();
		theDataPackage.initializePackageContents();
		theLibraryElementPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theiec61131Package.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(iec61131Package.eNS_URI, theiec61131Package);
		return theiec61131Package;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getProgram() {
		return programEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getProgram_FbNetwork() {
		return (EReference) programEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getProgramInstance() {
		return programInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public iec61131Factory getiec61131Factory() {
		return (iec61131Factory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to
	 * have no affect on any invocation but its first. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		programEClass = createEClass(PROGRAM);
		createEReference(programEClass, PROGRAM__FB_NETWORK);

		programInstanceEClass = createEClass(PROGRAM_INSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This method is
	 * guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		LibraryElementPackage theLibraryElementPackage = (LibraryElementPackage) EPackage.Registry.INSTANCE
				.getEPackage(LibraryElementPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		programEClass.getESuperTypes().add(theLibraryElementPackage.getFBType());
		programInstanceEClass.getESuperTypes().add(theLibraryElementPackage.getFB());

		// Initialize classes and features; add operations and parameters
		initEClass(programEClass, Program.class, "Program", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getProgram_FbNetwork(), theLibraryElementPackage.getFBNetwork(), null, "fbNetwork", null, 0, 1, //$NON-NLS-1$
				Program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(programInstanceEClass, ProgramInstance.class, "ProgramInstance", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} // iec61131PackageImpl
