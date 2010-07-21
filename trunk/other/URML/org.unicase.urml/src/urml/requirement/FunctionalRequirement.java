/**
 * <copyright> </copyright> $Id$
 */
package urml.requirement;

import org.eclipse.emf.common.util.EList;

import urml.feature.AbstractFeature;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Functional Requirement</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link urml.requirement.FunctionalRequirement#getDetailedFeatures <em>Detailed Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see urml.requirement.RequirementPackage#getFunctionalRequirement()
 * @model
 * @generated
 */
public interface FunctionalRequirement extends Requirement {
	/**
	 * Returns the value of the '<em><b>Detailed Features</b></em>' reference list.
	 * The list contents are of type {@link urml.feature.AbstractFeature}.
	 * It is bidirectional and its opposite is '{@link urml.feature.AbstractFeature#getDetailingFunctionalRequirements <em>Detailing Functional Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Detailed Features</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Detailed Features</em>' reference list.
	 * @see urml.requirement.RequirementPackage#getFunctionalRequirement_DetailedFeatures()
	 * @see urml.feature.AbstractFeature#getDetailingFunctionalRequirements
	 * @model opposite="detailingFunctionalRequirements" keys="identifier"
	 * @generated
	 */
	EList<AbstractFeature> getDetailedFeatures();

} // FunctionalRequirement
