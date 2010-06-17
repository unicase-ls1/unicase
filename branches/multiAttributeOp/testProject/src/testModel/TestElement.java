/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package testModel;

import org.eclipse.emf.common.util.EList;
import org.unicase.metamodel.ModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Test Element</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link testModel.TestElement#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 * 
 * @see testModel.TestModelPackage#getTestElement()
 * @model
 * @generated
 */
public interface TestElement extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list. The
	 * list contents are of type {@link java.lang.String}. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see testModel.TestModelPackage#getTestElement_Values()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getValues();

} // TestElement
