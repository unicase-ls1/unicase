/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge;

import scrm.SCRMModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scientific Knowledge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.knowledge.ScientificKnowledge#getContainingKnowledgeSpace <em>Containing Knowledge Space</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.knowledge.KnowledgePackage#getScientificKnowledge()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ScientificKnowledge extends SCRMModelElement {
	/**
	 * Returns the value of the '<em><b>Containing Knowledge Space</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.KnowledgeSpace#getContainedScientificKnowledge <em>Contained Scientific Knowledge</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Knowledge Space</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Knowledge Space</em>' container reference.
	 * @see #setContainingKnowledgeSpace(KnowledgeSpace)
	 * @see scrm.knowledge.KnowledgePackage#getScientificKnowledge_ContainingKnowledgeSpace()
	 * @see scrm.knowledge.KnowledgeSpace#getContainedScientificKnowledge
	 * @model opposite="containedScientificKnowledge" transient="false"
	 *        annotation="org.eclipse.emf.ecp.editor position='left' priority='10'"
	 * @generated
	 */
	KnowledgeSpace getContainingKnowledgeSpace();

	/**
	 * Sets the value of the '{@link scrm.knowledge.ScientificKnowledge#getContainingKnowledgeSpace <em>Containing Knowledge Space</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Knowledge Space</em>' container reference.
	 * @see #getContainingKnowledgeSpace()
	 * @generated
	 */
	void setContainingKnowledgeSpace(KnowledgeSpace value);

} // ScientificKnowledge
