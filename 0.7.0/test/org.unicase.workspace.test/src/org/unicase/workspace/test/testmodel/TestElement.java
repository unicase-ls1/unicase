/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.testmodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Test Element</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.workspace.test.testmodel.TestElement#getStrings <em>Strings</em>}</li>
 *   <li>{@link org.unicase.workspace.test.testmodel.TestElement#getReferences <em>References</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.workspace.test.testmodel.TestmodelPackage#getTestElement()
 * @model
 * @generated
 */
public interface TestElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Strings</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strings</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strings</em>' attribute list.
	 * @see org.unicase.workspace.test.testmodel.TestmodelPackage#getTestElement_Strings()
	 * @model
	 * @generated
	 */
	EList<String> getStrings();

	/**
	 * Returns the value of the '<em><b>References</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.workspace.test.testmodel.TestElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' reference list.
	 * @see org.unicase.workspace.test.testmodel.TestmodelPackage#getTestElement_References()
	 * @model
	 * @generated
	 */
	EList<TestElement> getReferences();

} // TestElement
