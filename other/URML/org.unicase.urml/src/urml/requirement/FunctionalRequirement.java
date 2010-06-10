/**
 * <copyright> </copyright> $Id$
 */
package urml.requirement;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.urml.Feature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Functional Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link urml.requirement.FunctionalRequirement#getDetailedFeatures <em>Detailed Features</em>}</li>
 *   <li>{@link urml.requirement.FunctionalRequirement#getSubRequirements <em>Sub Requirements</em>}</li>
 *   <li>{@link urml.requirement.FunctionalRequirement#getParentRequirement <em>Parent Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @see urml.requirement.RequirementPackage#getFunctionalRequirement()
 * @model
 * @generated
 */
public interface FunctionalRequirement extends Requirement {
	/**
	 * Returns the value of the '<em><b>Detailed Features</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.urml.Feature}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.urml.Feature#getDetailingFunctionalRequirements <em>Detailing Functional Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Detailed Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Detailed Features</em>' reference list.
	 * @see urml.requirement.RequirementPackage#getFunctionalRequirement_DetailedFeatures()
	 * @see org.unicase.model.urml.Feature#getDetailingFunctionalRequirements
	 * @model opposite="detailingFunctionalRequirements" keys="identifier"
	 * @generated
	 */
	EList<Feature> getDetailedFeatures();

	/**
	 * Returns the value of the '<em><b>Sub Requirements</b></em>' containment reference list.
	 * The list contents are of type {@link urml.requirement.FunctionalRequirement}.
	 * It is bidirectional and its opposite is '{@link urml.requirement.FunctionalRequirement#getParentRequirement <em>Parent Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Requirements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Requirements</em>' containment reference list.
	 * @see urml.requirement.RequirementPackage#getFunctionalRequirement_SubRequirements()
	 * @see urml.requirement.FunctionalRequirement#getParentRequirement
	 * @model opposite="parentRequirement" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<FunctionalRequirement> getSubRequirements();

	/**
	 * Returns the value of the '<em><b>Parent Requirement</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link urml.requirement.FunctionalRequirement#getSubRequirements <em>Sub Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Requirement</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Requirement</em>' container reference.
	 * @see #setParentRequirement(FunctionalRequirement)
	 * @see urml.requirement.RequirementPackage#getFunctionalRequirement_ParentRequirement()
	 * @see urml.requirement.FunctionalRequirement#getSubRequirements
	 * @model opposite="subRequirements" keys="identifier" transient="false"
	 * @generated
	 */
	FunctionalRequirement getParentRequirement();

	/**
	 * Sets the value of the '{@link urml.requirement.FunctionalRequirement#getParentRequirement <em>Parent Requirement</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Requirement</em>' container reference.
	 * @see #getParentRequirement()
	 * @generated
	 */
	void setParentRequirement(FunctionalRequirement value);

} // FunctionalRequirement
