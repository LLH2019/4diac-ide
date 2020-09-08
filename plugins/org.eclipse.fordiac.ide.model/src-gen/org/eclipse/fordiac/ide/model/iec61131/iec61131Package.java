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
package org.eclipse.fordiac.ide.model.iec61131;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.fordiac.ide.model.iec61131.iec61131Factory
 * @model kind="package"
 * @generated
 */
public interface iec61131Package extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNAME = "iec61131"; //$NON-NLS-1$

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_URI = "org.fordiac.ide.model.iec61131-3"; //$NON-NLS-1$

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_PREFIX = "iec61131"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	iec61131Package eINSTANCE = org.eclipse.fordiac.ide.model.iec61131.impl.iec61131PackageImpl.init();

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.fordiac.ide.model.iec61131.impl.ProgramImpl
	 * <em>Program</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.fordiac.ide.model.iec61131.impl.ProgramImpl
	 * @see org.eclipse.fordiac.ide.model.iec61131.impl.iec61131PackageImpl#getProgram()
	 * @generated
	 */
	int PROGRAM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROGRAM__NAME = LibraryElementPackage.FB_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROGRAM__COMMENT = LibraryElementPackage.FB_TYPE__COMMENT;

	/**
	 * The feature id for the '<em><b>Version Info</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROGRAM__VERSION_INFO = LibraryElementPackage.FB_TYPE__VERSION_INFO;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROGRAM__IDENTIFICATION = LibraryElementPackage.FB_TYPE__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Palette Entry</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROGRAM__PALETTE_ENTRY = LibraryElementPackage.FB_TYPE__PALETTE_ENTRY;

	/**
	 * The feature id for the '<em><b>Compiler Info</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROGRAM__COMPILER_INFO = LibraryElementPackage.FB_TYPE__COMPILER_INFO;

	/**
	 * The feature id for the '<em><b>Interface List</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROGRAM__INTERFACE_LIST = LibraryElementPackage.FB_TYPE__INTERFACE_LIST;

	/**
	 * The feature id for the '<em><b>Service</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROGRAM__SERVICE = LibraryElementPackage.FB_TYPE__SERVICE;

	/**
	 * The feature id for the '<em><b>Fb Network</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROGRAM__FB_NETWORK = LibraryElementPackage.FB_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Program</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROGRAM_FEATURE_COUNT = LibraryElementPackage.FB_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.fordiac.ide.model.iec61131.impl.ProgramInstanceImpl
	 * <em>Program Instance</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see org.eclipse.fordiac.ide.model.iec61131.impl.ProgramInstanceImpl
	 * @see org.eclipse.fordiac.ide.model.iec61131.impl.iec61131PackageImpl#getProgramInstance()
	 * @generated
	 */
	int PROGRAM_INSTANCE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROGRAM_INSTANCE__NAME = LibraryElementPackage.FB__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROGRAM_INSTANCE__COMMENT = LibraryElementPackage.FB__COMMENT;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROGRAM_INSTANCE__ATTRIBUTES = LibraryElementPackage.FB__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Palette Entry</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROGRAM_INSTANCE__PALETTE_ENTRY = LibraryElementPackage.FB__PALETTE_ENTRY;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROGRAM_INSTANCE__X = LibraryElementPackage.FB__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROGRAM_INSTANCE__Y = LibraryElementPackage.FB__Y;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROGRAM_INSTANCE__INTERFACE = LibraryElementPackage.FB__INTERFACE;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROGRAM_INSTANCE__MAPPING = LibraryElementPackage.FB__MAPPING;

	/**
	 * The number of structural features of the '<em>Program Instance</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROGRAM_INSTANCE_FEATURE_COUNT = LibraryElementPackage.FB_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.fordiac.ide.model.iec61131.Program <em>Program</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Program</em>'.
	 * @see org.eclipse.fordiac.ide.model.iec61131.Program
	 * @generated
	 */
	EClass getProgram();

	/**
	 * Returns the meta object for the containment reference
	 * '{@link org.eclipse.fordiac.ide.model.iec61131.Program#getFbNetwork <em>Fb
	 * Network</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference '<em>Fb Network</em>'.
	 * @see org.eclipse.fordiac.ide.model.iec61131.Program#getFbNetwork()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_FbNetwork();

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.fordiac.ide.model.iec61131.ProgramInstance <em>Program
	 * Instance</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Program Instance</em>'.
	 * @see org.eclipse.fordiac.ide.model.iec61131.ProgramInstance
	 * @generated
	 */
	EClass getProgramInstance();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	iec61131Factory getiec61131Factory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.fordiac.ide.model.iec61131.impl.ProgramImpl
		 * <em>Program</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.fordiac.ide.model.iec61131.impl.ProgramImpl
		 * @see org.eclipse.fordiac.ide.model.iec61131.impl.iec61131PackageImpl#getProgram()
		 * @generated
		 */
		EClass PROGRAM = eINSTANCE.getProgram();

		/**
		 * The meta object literal for the '<em><b>Fb Network</b></em>' containment
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference PROGRAM__FB_NETWORK = eINSTANCE.getProgram_FbNetwork();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.fordiac.ide.model.iec61131.impl.ProgramInstanceImpl
		 * <em>Program Instance</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 *
		 * @see org.eclipse.fordiac.ide.model.iec61131.impl.ProgramInstanceImpl
		 * @see org.eclipse.fordiac.ide.model.iec61131.impl.iec61131PackageImpl#getProgramInstance()
		 * @generated
		 */
		EClass PROGRAM_INSTANCE = eINSTANCE.getProgramInstance();

	}

} // iec61131Package
