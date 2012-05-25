/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcess;

import scrm.SCRMModelElement;
import scrm.SCRMSpace;
import scrm.lists.SCRMSpaceContainedModelElementsList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.dataProcess.DataProcessSpace#getContainedDataProcessSteps <em>Contained Data Process Steps</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.dataProcess.DataProcessPackage#getDataProcessSpace()
 * @model
 * @generated
 */
public interface DataProcessSpace extends SCRMSpace,
		scrm.requirements.dataProcess.Process {
	/**
	 * Returns the value of the '<em><b>Contained Data Process Steps</b></em>' containment reference list.
	 * The list contents are of type {@link scrm.requirements.dataProcess.Process}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.dataProcess.Process#getContainingDataProcessSpace <em>Containing Data Process Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Data Process Steps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Data Process Steps</em>' containment reference list.
	 * @see scrm.requirements.dataProcess.DataProcessPackage#getDataProcessSpace_ContainedDataProcessSteps()
	 * @see scrm.requirements.dataProcess.Process#getContainingDataProcessSpace
	 * @model opposite="containingDataProcessSpace" containment="true" resolveProxies="true"
	 *        annotation="org.unicase.ui.meeditor position='right' priority='5'"
	 * @generated NOT: changed type parameter
	 */
	SCRMSpaceContainedModelElementsList<SCRMModelElement> getContainedDataProcessSteps();

} // DataProcessSpace
