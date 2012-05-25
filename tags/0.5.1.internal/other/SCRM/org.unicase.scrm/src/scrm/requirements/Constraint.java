/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.Constraint#getRestrictedFeature <em>Restricted Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends IRequirement {
	/**
	 * Returns the value of the '<em><b>Restricted Feature</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restricted Feature</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restricted Feature</em>' reference.
	 * @see #setRestrictedFeature(Feature)
	 * @see scrm.requirements.RequirementsPackage#getConstraint_RestrictedFeature()
	 * @see scrm.requirements.Feature#getConstraints
	 * @model opposite="constraints"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='15'"
	 * @generated
	 */
	Feature getRestrictedFeature();

	/**
	 * Sets the value of the '{@link scrm.requirements.Constraint#getRestrictedFeature <em>Restricted Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restricted Feature</em>' reference.
	 * @see #getRestrictedFeature()
	 * @generated
	 */
	void setRestrictedFeature(Feature value);

} // Constraint
