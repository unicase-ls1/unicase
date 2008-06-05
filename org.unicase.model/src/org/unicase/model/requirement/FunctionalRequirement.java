/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.requirement;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Functional Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.requirement.FunctionalRequirement#isReviewed <em>Reviewed</em>}</li>
 *   <li>{@link org.unicase.model.requirement.FunctionalRequirement#getStoryPoints <em>Story Points</em>}</li>
 *   <li>{@link org.unicase.model.requirement.FunctionalRequirement#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.unicase.model.requirement.FunctionalRequirement#getRefiningRequirements <em>Refining Requirements</em>}</li>
 *   <li>{@link org.unicase.model.requirement.FunctionalRequirement#getRefinedRequirement <em>Refined Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.requirement.RequirementPackage#getFunctionalRequirement()
 * @model
 * @generated
 */
public interface FunctionalRequirement extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Reviewed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reviewed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reviewed</em>' attribute.
	 * @see #setReviewed(boolean)
	 * @see org.unicase.model.requirement.RequirementPackage#getFunctionalRequirement_Reviewed()
	 * @model
	 * @generated
	 */
	boolean isReviewed();

	/**
	 * Sets the value of the '{@link org.unicase.model.requirement.FunctionalRequirement#isReviewed <em>Reviewed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reviewed</em>' attribute.
	 * @see #isReviewed()
	 * @generated
	 */
	void setReviewed(boolean value);

	/**
	 * Returns the value of the '<em><b>Story Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Story Points</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Story Points</em>' attribute.
	 * @see #setStoryPoints(int)
	 * @see org.unicase.model.requirement.RequirementPackage#getFunctionalRequirement_StoryPoints()
	 * @model
	 * @generated
	 */
	int getStoryPoints();

	/**
	 * Sets the value of the '{@link org.unicase.model.requirement.FunctionalRequirement#getStoryPoints <em>Story Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Story Points</em>' attribute.
	 * @see #getStoryPoints()
	 * @generated
	 */
	void setStoryPoints(int value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see org.unicase.model.requirement.RequirementPackage#getFunctionalRequirement_Priority()
	 * @model
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link org.unicase.model.requirement.FunctionalRequirement#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

	/**
	 * Returns the value of the '<em><b>Refining Requirements</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.FunctionalRequirement}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.requirement.FunctionalRequirement#getRefinedRequirement <em>Refined Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refining Requirements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refining Requirements</em>' containment reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getFunctionalRequirement_RefiningRequirements()
	 * @see org.unicase.model.requirement.FunctionalRequirement#getRefinedRequirement
	 * @model opposite="refinedRequirement" containment="true"
	 * @generated
	 */
	EList<FunctionalRequirement> getRefiningRequirements();

	/**
	 * Returns the value of the '<em><b>Refined Requirement</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.requirement.FunctionalRequirement#getRefiningRequirements <em>Refining Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refined Requirement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refined Requirement</em>' container reference.
	 * @see #setRefinedRequirement(FunctionalRequirement)
	 * @see org.unicase.model.requirement.RequirementPackage#getFunctionalRequirement_RefinedRequirement()
	 * @see org.unicase.model.requirement.FunctionalRequirement#getRefiningRequirements
	 * @model opposite="refiningRequirements" transient="false"
	 * @generated
	 */
	FunctionalRequirement getRefinedRequirement();

	/**
	 * Sets the value of the '{@link org.unicase.model.requirement.FunctionalRequirement#getRefinedRequirement <em>Refined Requirement</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refined Requirement</em>' container reference.
	 * @see #getRefinedRequirement()
	 * @generated
	 */
	void setRefinedRequirement(FunctionalRequirement value);

} // FunctionalRequirement
