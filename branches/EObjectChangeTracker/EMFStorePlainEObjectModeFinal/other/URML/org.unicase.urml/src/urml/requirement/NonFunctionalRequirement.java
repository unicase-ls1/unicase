/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package urml.requirement;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.urml.Feature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Non Functional Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link urml.requirement.NonFunctionalRequirement#getConstrainedFeatures <em>Constrained Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see urml.requirement.RequirementPackage#getNonFunctionalRequirement()
 * @model
 * @generated
 */
public interface NonFunctionalRequirement extends Requirement {
	/**
	 * Returns the value of the '<em><b>Constrained Features</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.urml.Feature}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.urml.Feature#getConstrainingNonFunctionalRequirements <em>Constraining Non Functional Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constrained Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constrained Features</em>' reference list.
	 * @see urml.requirement.RequirementPackage#getNonFunctionalRequirement_ConstrainedFeatures()
	 * @see org.unicase.model.urml.Feature#getConstrainingNonFunctionalRequirements
	 * @model opposite="constrainingNonFunctionalRequirements" keys="identifier"
	 * @generated
	 */
	EList<Feature> getConstrainedFeatures();

} // NonFunctionalRequirement
