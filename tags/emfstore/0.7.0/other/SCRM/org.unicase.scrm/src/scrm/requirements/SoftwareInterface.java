/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Software Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.SoftwareInterface#getRequiringFeature <em>Requiring Feature</em>}</li>
 *   <li>{@link scrm.requirements.SoftwareInterface#getProvidingFeature <em>Providing Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getSoftwareInterface()
 * @model
 * @generated
 */
public interface SoftwareInterface extends IRequirement {
	/**
	 * Returns the value of the '<em><b>Requiring Feature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getRequiredSoftwareInterface <em>Required Software Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requiring Feature</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiring Feature</em>' container reference.
	 * @see #setRequiringFeature(Feature)
	 * @see scrm.requirements.RequirementsPackage#getSoftwareInterface_RequiringFeature()
	 * @see scrm.requirements.Feature#getRequiredSoftwareInterface
	 * @model opposite="requiredSoftwareInterface" transient="false"
	 * @generated
	 */
	Feature getRequiringFeature();

	/**
	 * Sets the value of the '{@link scrm.requirements.SoftwareInterface#getRequiringFeature <em>Requiring Feature</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requiring Feature</em>' container reference.
	 * @see #getRequiringFeature()
	 * @generated
	 */
	void setRequiringFeature(Feature value);

	/**
	 * Returns the value of the '<em><b>Providing Feature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getProvidedSoftwareInterfaces <em>Provided Software Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Providing Feature</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Providing Feature</em>' container reference.
	 * @see #setProvidingFeature(Feature)
	 * @see scrm.requirements.RequirementsPackage#getSoftwareInterface_ProvidingFeature()
	 * @see scrm.requirements.Feature#getProvidedSoftwareInterfaces
	 * @model opposite="providedSoftwareInterfaces" transient="false"
	 * @generated
	 */
	Feature getProvidingFeature();

	/**
	 * Sets the value of the '{@link scrm.requirements.SoftwareInterface#getProvidingFeature <em>Providing Feature</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Providing Feature</em>' container reference.
	 * @see #getProvidingFeature()
	 * @generated
	 */
	void setProvidingFeature(Feature value);

} // SoftwareInterface
