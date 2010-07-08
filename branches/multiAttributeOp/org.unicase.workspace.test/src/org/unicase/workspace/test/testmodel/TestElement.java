/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.test.testmodel;

import org.eclipse.emf.common.util.EList;
import org.unicase.metamodel.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Element</b></em>'.
 * <!-- end-user-doc -->
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
public interface TestElement extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Strings</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strings</em>' attribute isn't clear,
	 * there really should be more of a description here...
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
	 * If the meaning of the '<em>References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' reference list.
	 * @see org.unicase.workspace.test.testmodel.TestmodelPackage#getTestElement_References()
	 * @model
	 * @generated
	 */
	EList<TestElement> getReferences();

} // TestElement
