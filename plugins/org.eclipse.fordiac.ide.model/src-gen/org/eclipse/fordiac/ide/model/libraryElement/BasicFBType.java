/********************************************************************************
 * Copyright (c) 2008 - 2017 Profactor GmbH, TU Wien ACIN, fortiss GmbH
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Gerhard Ebenhofer, Alois Zoitl, Ingo Hegny, Monika Wenger
 *    - initial API and implementation and/or initial documentation
 ********************************************************************************/
package org.eclipse.fordiac.ide.model.libraryElement;

import org.eclipse.emf.common.util.EList;

/** <!-- begin-user-doc --> A representation of the model object '<em><b>Basic FB Type</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.BasicFBType#getECC <em>ECC</em>}</li>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.BasicFBType#getAlgorithm <em>Algorithm</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage#getBasicFBType()
 * @model
 * @generated */
public interface BasicFBType extends BaseFBType {
	/** Returns the value of the '<em><b>ECC</b></em>' containment reference. It is bidirectional and its opposite is
	 * '{@link org.eclipse.fordiac.ide.model.libraryElement.ECC#getBasicFBType <em>Basic FB Type</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ECC</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>ECC</em>' containment reference.
	 * @see #setECC(ECC)
	 * @see org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage#getBasicFBType_ECC()
	 * @see org.eclipse.fordiac.ide.model.libraryElement.ECC#getBasicFBType
	 * @model opposite="basicFBType" containment="true" extendedMetaData="kind='element' name='ECC'
	 *        namespace='##targetNamespace'"
	 * @generated */
	ECC getECC();

	/** Sets the value of the '{@link org.eclipse.fordiac.ide.model.libraryElement.BasicFBType#getECC <em>ECC</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>ECC</em>' containment reference.
	 * @see #getECC()
	 * @generated */
	void setECC(ECC value);

	/** Returns the value of the '<em><b>Algorithm</b></em>' containment reference list. The list contents are of type
	 * {@link org.eclipse.fordiac.ide.model.libraryElement.Algorithm}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithm</em>' containment reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Algorithm</em>' containment reference list.
	 * @see org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage#getBasicFBType_Algorithm()
	 * @model containment="true" extendedMetaData="kind='element' name='Algorithm' namespace='##targetNamespace'"
	 * @generated */
	EList<Algorithm> getAlgorithm();

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model required="true" nameRequired="true"
	 * @generated */
	Algorithm getAlgorithmNamed(String name);

} // BasicFBType
