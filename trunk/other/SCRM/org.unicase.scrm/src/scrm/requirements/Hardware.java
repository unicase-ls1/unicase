/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hardware</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.Hardware#getDependingFeature <em>Depending Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getHardware()
 * @model
 * @generated
 */
public interface Hardware extends IRequirement {
	/**
	 * Returns the value of the '<em><b>Depending Feature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depending Feature</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depending Feature</em>' container reference.
	 * @see #setDependingFeature(Feature)
	 * @see scrm.requirements.RequirementsPackage#getHardware_DependingFeature()
	 * @see scrm.requirements.Feature#getDependencies
	 * @model opposite="dependencies" transient="false"
	 * @generated
	 */
	Feature getDependingFeature();

	/**
	 * Sets the value of the '{@link scrm.requirements.Hardware#getDependingFeature <em>Depending Feature</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depending Feature</em>' container reference.
	 * @see #getDependingFeature()
	 * @generated
	 */
	void setDependingFeature(Feature value);

} // Hardware
