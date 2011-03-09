/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.UserInterface#getRequiringFeature <em>Requiring Feature</em>}</li>
 *   <li>{@link scrm.requirements.UserInterface#getProvidingFeature <em>Providing Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getUserInterface()
 * @model
 * @generated
 */
public interface UserInterface extends IRequirement {
	/**
	 * Returns the value of the '<em><b>Requiring Feature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getRequiredUserInterface <em>Required User Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requiring Feature</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiring Feature</em>' container reference.
	 * @see #setRequiringFeature(Feature)
	 * @see scrm.requirements.RequirementsPackage#getUserInterface_RequiringFeature()
	 * @see scrm.requirements.Feature#getRequiredUserInterface
	 * @model opposite="requiredUserInterface" transient="false"
	 * @generated
	 */
	Feature getRequiringFeature();

	/**
	 * Sets the value of the '{@link scrm.requirements.UserInterface#getRequiringFeature <em>Requiring Feature</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requiring Feature</em>' container reference.
	 * @see #getRequiringFeature()
	 * @generated
	 */
	void setRequiringFeature(Feature value);

	/**
	 * Returns the value of the '<em><b>Providing Feature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getProvidedUserInterfaces <em>Provided User Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Providing Feature</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Providing Feature</em>' container reference.
	 * @see #setProvidingFeature(Feature)
	 * @see scrm.requirements.RequirementsPackage#getUserInterface_ProvidingFeature()
	 * @see scrm.requirements.Feature#getProvidedUserInterfaces
	 * @model opposite="providedUserInterfaces" transient="false"
	 * @generated
	 */
	Feature getProvidingFeature();

	/**
	 * Sets the value of the '{@link scrm.requirements.UserInterface#getProvidingFeature <em>Providing Feature</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Providing Feature</em>' container reference.
	 * @see #getProvidingFeature()
	 * @generated
	 */
	void setProvidingFeature(Feature value);

} // UserInterface
