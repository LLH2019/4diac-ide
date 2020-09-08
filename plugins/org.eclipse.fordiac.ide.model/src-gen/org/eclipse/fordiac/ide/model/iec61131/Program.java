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

import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.fordiac.ide.model.libraryElement.FBType;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Program</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.fordiac.ide.model.iec61131.Program#getFbNetwork <em>Fb
 * Network</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fordiac.ide.model.iec61131.iec61131Package#getProgram()
 * @model
 * @generated
 */
public interface Program extends FBType {
	/**
	 * Returns the value of the '<em><b>Fb Network</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Fb Network</em>' containment reference.
	 * @see #setFbNetwork(FBNetwork)
	 * @see org.eclipse.fordiac.ide.model.iec61131.iec61131Package#getProgram_FbNetwork()
	 * @model containment="true"
	 * @generated
	 */
	FBNetwork getFbNetwork();

	/**
	 * Sets the value of the
	 * '{@link org.eclipse.fordiac.ide.model.iec61131.Program#getFbNetwork <em>Fb
	 * Network</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @param value the new value of the '<em>Fb Network</em>' containment
	 *              reference.
	 * @see #getFbNetwork()
	 * @generated
	 */
	void setFbNetwork(FBNetwork value);

} // Program
