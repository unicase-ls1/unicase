/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import scrm.requirements.IRequirement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scientific Knowledge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.knowledge.ScientificKnowledge#getRequirements <em>Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.knowledge.KnowledgePackage#getScientificKnowledge()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ScientificKnowledge extends EObject {
	/**
	 * Returns the value of the '<em><b>Requirements</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.IRequirement}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.IRequirement#getUsedKnowledge <em>Used Knowledge</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirements</em>' reference list.
	 * @see scrm.knowledge.KnowledgePackage#getScientificKnowledge_Requirements()
	 * @see scrm.requirements.IRequirement#getUsedKnowledge
	 * @model opposite="usedKnowledge"
	 * @generated
	 */
	EList<IRequirement> getRequirements();

} // ScientificKnowledge
