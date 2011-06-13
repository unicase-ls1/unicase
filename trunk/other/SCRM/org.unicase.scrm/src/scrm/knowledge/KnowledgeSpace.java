/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge;

import org.eclipse.emf.common.util.EList;

import scrm.SCRMModelElement;
import scrm.SCRMSpace;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.knowledge.KnowledgeSpace#getContainedScientificKnowledge <em>Contained Scientific Knowledge</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.knowledge.KnowledgePackage#getKnowledgeSpace()
 * @model
 * @generated
 */
public interface KnowledgeSpace extends SCRMSpace, ScientificKnowledge {
	/**
	 * Returns the value of the '<em><b>Contained Scientific Knowledge</b></em>' containment reference list.
	 * The list contents are of type {@link scrm.knowledge.ScientificKnowledge}.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.ScientificKnowledge#getContainingKnowledgeSpace <em>Containing Knowledge Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Scientific Knowledge</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Scientific Knowledge</em>' containment reference list.
	 * @see scrm.knowledge.KnowledgePackage#getKnowledgeSpace_ContainedScientificKnowledge()
	 * @see scrm.knowledge.ScientificKnowledge#getContainingKnowledgeSpace
	 * @model opposite="containingKnowledgeSpace" containment="true" resolveProxies="true"
	 *        annotation="org.unicase.ui.meeditor position='right' priority='10'"
	 * @generated NOT
	 */
	EList<SCRMModelElement> getContainedScientificKnowledge();

} // KnowledgeSpace
