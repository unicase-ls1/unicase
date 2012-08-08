/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;

import org.eclipse.emf.common.util.EList;

import scrm.SCRMModelElement;
import scrm.SCRMSpace;
import scrm.lists.SCRMSpaceContainedModelElementsList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.RequirementSpace#getContainedInformationofRequirements <em>Contained Informationof Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getRequirementSpace()
 * @model
 * @generated
 */
public interface RequirementSpace extends SCRMSpace, IRequirement {
	/**
	 * Returns the value of the '<em><b>Contained Information of Requirements</b></em>' containment reference list.
	 * The list contents are of type {@link scrm.requirements.IRequirement}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.IRequirement#getContainingRequirementSpace <em>Containing Requirement Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Information of Requirements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Information of Requirements</em>' containment reference list.
	 * @see scrm.requirements.RequirementsPackage#getRequirementSpace_ContainedInformationofRequirements()
	 * @see scrm.requirements.IRequirement#getContainingRequirementSpace
	 * @model opposite="containingRequirementSpace" containment="true" resolveProxies="true"
	 *        annotation="org.unicase.ui.meeditor position='right' priority='10'"
	 * @generated NOT: changed type parameter
	 */
	SCRMSpaceContainedModelElementsList<SCRMModelElement> getContainedInformationofRequirements();

} // RequirementSpace
