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

import org.unicase.model.classes.Association;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inline Class Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.implementation.operations.InlineClassOperation#getAssociation <em>Association</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.implementation.operations.OperationsPackage#getInlineClassOperation()
 * @model
 * @generated
 */
public interface InlineClassOperation extends SemanticCompositeOperation {
	/**
	 * Returns the value of the '<em><b>Association</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association</em>' containment reference.
	 * @see #setAssociation(ModelElementId)
	 * @see org.unicase.implementation.operations.OperationsPackage#getInlineClassOperation_Association()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ModelElementId getAssociation();

	/**
	 * Sets the value of the '{@link org.unicase.implementation.operations.InlineClassOperation#getAssociation <em>Association</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association</em>' containment reference.
	 * @see #getAssociation()
	 * @generated
	 */
	void setAssociation(ModelElementId value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElement(project, getAssociation());'"
	 * @generated
	 */
	Association getAssociation(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore documentation='The association must be a composition.'"
	 * @generated
	 */
	boolean validateAssociationComposition(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore documentation='The multiplicity of the association must be 1-to-1.'"
	 * @generated
	 */
	boolean validateAssociationMultiplicity(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore documentation='The class to be inlined must not have sub classes.'"
	 * @generated
	 */
	boolean validateInlineClassSubClasses(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore documentation='The class to be inlined must not be target of another association.'"
	 * @generated
	 */
	boolean validateInlineClassAssociationTarget(Project project);

} // InlineClassOperation
