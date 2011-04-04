/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;

import scrm.SCRMModelElement;

import scrm.knowledge.ScientificKnowledge;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IRequirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.IRequirement#getContainingRequirementSpace <em>Containing Requirement Space</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getIRequirement()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IRequirement extends SCRMModelElement {
	/**
	 * Returns the value of the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.RequirementSpace#getContainedInformationofRequirements <em>Contained Informationof Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Requirement Space</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Requirement Space</em>' container reference.
	 * @see #setContainingRequirementSpace(RequirementSpace)
	 * @see scrm.requirements.RequirementsPackage#getIRequirement_ContainingRequirementSpace()
	 * @see scrm.requirements.RequirementSpace#getContainedInformationofRequirements
	 * @model opposite="containedInformationofRequirements" transient="false"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='10'"
	 * @generated
	 */
	RequirementSpace getContainingRequirementSpace();

	/**
	 * Sets the value of the '{@link scrm.requirements.IRequirement#getContainingRequirementSpace <em>Containing Requirement Space</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Requirement Space</em>' container reference.
	 * @see #getContainingRequirementSpace()
	 * @generated
	 */
	void setContainingRequirementSpace(RequirementSpace value);

} // IRequirement
