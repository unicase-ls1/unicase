/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.requirement;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.urml.feature.AbstractFeature;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Non Functional Requirement</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.urml.requirement.NonFunctionalRequirement#getConstrainedFeatures <em>Constrained
 * Features</em>}</li>
 * <li>{@link org.unicase.model.urml.requirement.NonFunctionalRequirement#getSubNonFunctionalRequirements <em>Sub Non
 * Functional Requirements</em>}</li>
 * <li>{@link org.unicase.model.urml.requirement.NonFunctionalRequirement#getParentNonFunctionalRequirement <em>Parent
 * Non Functional Requirement</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.urml.requirement.RequirementPackage#getNonFunctionalRequirement()
 * @model
 * @generated
 */
public interface NonFunctionalRequirement extends Requirement {
	/**
	 * Returns the value of the '<em><b>Constrained Features</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.urml.feature.AbstractFeature}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getConstrainingNonFunctionalRequirements
	 * <em>Constraining Non Functional Requirements</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constrained Features</em>' reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constrained Features</em>' reference list.
	 * @see org.unicase.model.urml.requirement.RequirementPackage#getNonFunctionalRequirement_ConstrainedFeatures()
	 * @see org.unicase.model.urml.feature.AbstractFeature#getConstrainingNonFunctionalRequirements
	 * @model opposite="constrainingNonFunctionalRequirements" keys="identifier"
	 * @generated
	 */
	EList<AbstractFeature> getConstrainedFeatures();

	/**
	 * Returns the value of the '<em><b>Sub Non Functional Requirements</b></em>' containment reference list. The list
	 * contents are of type {@link org.unicase.model.urml.requirement.NonFunctionalRequirement}. It is bidirectional and
	 * its opposite is '
	 * {@link org.unicase.model.urml.requirement.NonFunctionalRequirement#getParentNonFunctionalRequirement
	 * <em>Parent Non Functional Requirement</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Non Functional Requirements</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sub Non Functional Requirements</em>' containment reference list.
	 * @see org.unicase.model.urml.requirement.RequirementPackage#getNonFunctionalRequirement_SubNonFunctionalRequirements()
	 * @see org.unicase.model.urml.requirement.NonFunctionalRequirement#getParentNonFunctionalRequirement
	 * @model opposite="parentNonFunctionalRequirement" containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<NonFunctionalRequirement> getSubNonFunctionalRequirements();

	/**
	 * Returns the value of the '<em><b>Parent Non Functional Requirement</b></em>' container reference. It is
	 * bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.requirement.NonFunctionalRequirement#getSubNonFunctionalRequirements
	 * <em>Sub Non Functional Requirements</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Non Functional Requirement</em>' container reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent Non Functional Requirement</em>' container reference.
	 * @see #setParentNonFunctionalRequirement(NonFunctionalRequirement)
	 * @see org.unicase.model.urml.requirement.RequirementPackage#getNonFunctionalRequirement_ParentNonFunctionalRequirement()
	 * @see org.unicase.model.urml.requirement.NonFunctionalRequirement#getSubNonFunctionalRequirements
	 * @model opposite="subNonFunctionalRequirements" keys="identifier" transient="false"
	 * @generated
	 */
	NonFunctionalRequirement getParentNonFunctionalRequirement();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.model.urml.requirement.NonFunctionalRequirement#getParentNonFunctionalRequirement
	 * <em>Parent Non Functional Requirement</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Parent Non Functional Requirement</em>' container reference.
	 * @see #getParentNonFunctionalRequirement()
	 * @generated
	 */
	void setParentNonFunctionalRequirement(NonFunctionalRequirement value);

} // NonFunctionalRequirement
