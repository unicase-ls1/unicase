/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;

import org.eclipse.emf.common.util.EList;

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
public interface RequirementSpace extends IRequirement {
	/**
	 * Returns the value of the '<em><b>Contained Informationof Requirements</b></em>' containment reference list.
	 * The list contents are of type {@link scrm.requirements.IRequirement}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.IRequirement#getContainingRequirementSpace <em>Containing Requirement Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Informationof Requirements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Informationof Requirements</em>' containment reference list.
	 * @see scrm.requirements.RequirementsPackage#getRequirementSpace_ContainedInformationofRequirements()
	 * @see scrm.requirements.IRequirement#getContainingRequirementSpace
	 * @model opposite="containingRequirementSpace" containment="true"
	 * @generated
	 */
	EList<IRequirement> getContainedInformationofRequirements();

} // RequirementSpace
