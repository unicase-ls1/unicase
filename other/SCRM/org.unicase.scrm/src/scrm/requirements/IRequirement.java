/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;

import org.eclipse.emf.common.util.EList;

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
	 * Returns the value of the '<em><b>Used Knowledge</b></em>' reference list.
	 * The list contents are of type {@link scrm.knowledge.ScientificKnowledge}.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.ScientificKnowledge#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Knowledge</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Knowledge</em>' reference list.
	 * @see scrm.requirements.RequirementsPackage#getIRequirement_UsedKnowledge()
	 * @see scrm.knowledge.ScientificKnowledge#getRequirements
	 * @model opposite="requirements"
	 * @generated
	 */
	EList<ScientificKnowledge> getUsedKnowledge();

} // IRequirement
