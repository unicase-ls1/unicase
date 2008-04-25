/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Functional Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.FunctionalRequirement#isReviewed <em>Reviewed</em>}</li>
 *   <li>{@link org.unicase.model.FunctionalRequirement#getStoryPoints <em>Story Points</em>}</li>
 *   <li>{@link org.unicase.model.FunctionalRequirement#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.unicase.model.FunctionalRequirement#getDate <em>Date</em>}</li>
 *   <li>{@link org.unicase.model.FunctionalRequirement#getRefiningRequirements <em>Refining Requirements</em>}</li>
 *   <li>{@link org.unicase.model.FunctionalRequirement#getRefinedRequirement <em>Refined Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.ModelPackage#getFunctionalRequirement()
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
	 * @see org.unicase.model.ModelPackage#getFunctionalRequirement_Reviewed()
	 * @model
	 * @generated
	 */
	boolean isReviewed();

	/**
	 * Sets the value of the '{@link org.unicase.model.FunctionalRequirement#isReviewed <em>Reviewed</em>}' attribute.
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
	 * @see org.unicase.model.ModelPackage#getFunctionalRequirement_StoryPoints()
	 * @model
	 * @generated
	 */
	int getStoryPoints();

	/**
	 * Sets the value of the '{@link org.unicase.model.FunctionalRequirement#getStoryPoints <em>Story Points</em>}' attribute.
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
	 * @see org.unicase.model.ModelPackage#getFunctionalRequirement_Priority()
	 * @model
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link org.unicase.model.FunctionalRequirement#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see org.unicase.model.ModelPackage#getFunctionalRequirement_Date()
	 * @model
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link org.unicase.model.FunctionalRequirement#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Refining Requirements</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.FunctionalRequirement}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.FunctionalRequirement#getRefinedRequirement <em>Refined Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refining Requirements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refining Requirements</em>' reference list.
	 * @see org.unicase.model.ModelPackage#getFunctionalRequirement_RefiningRequirements()
	 * @see org.unicase.model.FunctionalRequirement#getRefinedRequirement
	 * @model opposite="refinedRequirement"
	 * @generated
	 */
	EList<FunctionalRequirement> getRefiningRequirements();

	/**
	 * Returns the value of the '<em><b>Refined Requirement</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.FunctionalRequirement#getRefiningRequirements <em>Refining Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refined Requirement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refined Requirement</em>' reference.
	 * @see #setRefinedRequirement(FunctionalRequirement)
	 * @see org.unicase.model.ModelPackage#getFunctionalRequirement_RefinedRequirement()
	 * @see org.unicase.model.FunctionalRequirement#getRefiningRequirements
	 * @model opposite="refiningRequirements"
	 * @generated
	 */
	FunctionalRequirement getRefinedRequirement();

	/**
	 * Sets the value of the '{@link org.unicase.model.FunctionalRequirement#getRefinedRequirement <em>Refined Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refined Requirement</em>' reference.
	 * @see #getRefinedRequirement()
	 * @generated
	 */
	void setRefinedRequirement(FunctionalRequirement value);

} // FunctionalRequirement
