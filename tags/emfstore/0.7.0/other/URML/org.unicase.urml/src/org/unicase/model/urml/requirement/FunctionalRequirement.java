/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.requirement;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.urml.feature.AbstractFeature;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Functional Requirement</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.urml.requirement.FunctionalRequirement#getDetailedFeatures <em>Detailed Features</em>}</li>
 * <li>{@link org.unicase.model.urml.requirement.FunctionalRequirement#getSubFunctionalRequirements <em>Sub Functional
 * Requirements</em>}</li>
 * <li>{@link org.unicase.model.urml.requirement.FunctionalRequirement#getParentFunctionalRequirement <em>Parent
 * Functional Requirement</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.urml.requirement.RequirementPackage#getFunctionalRequirement()
 * @model
 * @generated
 */
public interface FunctionalRequirement extends Requirement {
	/**
	 * Returns the value of the '<em><b>Detailed Features</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.urml.feature.AbstractFeature}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getDetailingFunctionalRequirements
	 * <em>Detailing Functional Requirements</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Detailed Features</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Detailed Features</em>' reference list.
	 * @see org.unicase.model.urml.requirement.RequirementPackage#getFunctionalRequirement_DetailedFeatures()
	 * @see org.unicase.model.urml.feature.AbstractFeature#getDetailingFunctionalRequirements
	 * @model opposite="detailingFunctionalRequirements"
	 * @generated
	 */
	EList<AbstractFeature> getDetailedFeatures();

	/**
	 * Returns the value of the '<em><b>Sub Functional Requirements</b></em>' containment reference list. The list
	 * contents are of type {@link org.unicase.model.urml.requirement.FunctionalRequirement}. It is bidirectional and
	 * its opposite is '{@link org.unicase.model.urml.requirement.FunctionalRequirement#getParentFunctionalRequirement
	 * <em>Parent Functional Requirement</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Functional Requirements</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sub Functional Requirements</em>' containment reference list.
	 * @see org.unicase.model.urml.requirement.RequirementPackage#getFunctionalRequirement_SubFunctionalRequirements()
	 * @see org.unicase.model.urml.requirement.FunctionalRequirement#getParentFunctionalRequirement
	 * @model opposite="parentFunctionalRequirement" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<FunctionalRequirement> getSubFunctionalRequirements();

	/**
	 * Returns the value of the '<em><b>Parent Functional Requirement</b></em>' container reference. It is bidirectional
	 * and its opposite is '
	 * {@link org.unicase.model.urml.requirement.FunctionalRequirement#getSubFunctionalRequirements
	 * <em>Sub Functional Requirements</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Functional Requirement</em>' container reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent Functional Requirement</em>' container reference.
	 * @see #setParentFunctionalRequirement(FunctionalRequirement)
	 * @see org.unicase.model.urml.requirement.RequirementPackage#getFunctionalRequirement_ParentFunctionalRequirement()
	 * @see org.unicase.model.urml.requirement.FunctionalRequirement#getSubFunctionalRequirements
	 * @model opposite="subFunctionalRequirements" transient="false"
	 * @generated
	 */
	FunctionalRequirement getParentFunctionalRequirement();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.model.urml.requirement.FunctionalRequirement#getParentFunctionalRequirement
	 * <em>Parent Functional Requirement</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Parent Functional Requirement</em>' container reference.
	 * @see #getParentFunctionalRequirement()
	 * @generated
	 */
	void setParentFunctionalRequirement(FunctionalRequirement value);

} // FunctionalRequirement
