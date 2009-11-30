/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.implementation.operations;

import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;

import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;

import org.unicase.model.classes.Attribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Push Down Attribute Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.implementation.operations.PushDownAttributeOperation#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.implementation.operations.OperationsPackage#getPushDownAttributeOperation()
 * @model
 * @generated
 */
public interface PushDownAttributeOperation extends SemanticCompositeOperation {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference.
	 * @see #setAttribute(ModelElementId)
	 * @see org.unicase.implementation.operations.OperationsPackage#getPushDownAttributeOperation_Attribute()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ModelElementId getAttribute();

	/**
	 * Sets the value of the '{@link org.unicase.implementation.operations.PushDownAttributeOperation#getAttribute <em>Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' containment reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(ModelElementId value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElement(project, getAttribute());'"
	 * @generated
	 */
	Attribute getAttribute(Project project);

} // PushDownAttributeOperation
