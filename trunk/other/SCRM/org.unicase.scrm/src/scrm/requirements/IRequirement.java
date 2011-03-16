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
 *   <li>{@link scrm.requirements.IRequirement#getUsedKnowledge <em>Used Knowledge</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getIRequirement()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IRequirement extends SCRMModelElement {
	/**
	 * Returns the value of the '<em><b>Used Knowledge</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.ScientificKnowledge#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Knowledge</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Knowledge</em>' container reference.
	 * @see #setUsedKnowledge(ScientificKnowledge)
	 * @see scrm.requirements.RequirementsPackage#getIRequirement_UsedKnowledge()
	 * @see scrm.knowledge.ScientificKnowledge#getRequirements
	 * @model opposite="requirements" transient="false"
	 * @generated
	 */
	ScientificKnowledge getUsedKnowledge();

	/**
	 * Sets the value of the '{@link scrm.requirements.IRequirement#getUsedKnowledge <em>Used Knowledge</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Used Knowledge</em>' container reference.
	 * @see #getUsedKnowledge()
	 * @generated
	 */
	void setUsedKnowledge(ScientificKnowledge value);

} // IRequirement
