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
import org.eclipse.fordiac.ide.model.iec61131.ProgramInstance;
import org.eclipse.fordiac.ide.model.iec61131.iec61131Package;
import org.eclipse.fordiac.ide.model.libraryElement.impl.FBImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Program
 * Instance</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class ProgramInstanceImpl extends FBImpl implements ProgramInstance {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ProgramInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return iec61131Package.Literals.PROGRAM_INSTANCE;
	}

} // ProgramInstanceImpl
