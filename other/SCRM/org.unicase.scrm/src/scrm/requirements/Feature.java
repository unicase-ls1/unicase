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
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.Feature#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link scrm.requirements.Feature#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link scrm.requirements.Feature#getRequiredUserInterface <em>Required User Interface</em>}</li>
 *   <li>{@link scrm.requirements.Feature#getProvidedUserInterfaces <em>Provided User Interfaces</em>}</li>
 *   <li>{@link scrm.requirements.Feature#getRequiredSoftwareInterface <em>Required Software Interface</em>}</li>
 *   <li>{@link scrm.requirements.Feature#getProvidedSoftwareInterfaces <em>Provided Software Interfaces</em>}</li>
 *   <li>{@link scrm.requirements.Feature#getDetailedRequirements <em>Detailed Requirements</em>}</li>
 *   <li>{@link scrm.requirements.Feature#getSubFeatures <em>Sub Features</em>}</li>
 *   <li>{@link scrm.requirements.Feature#getContainingFeature <em>Containing Feature</em>}</li>
 *   <li>{@link scrm.requirements.Feature#getRequiredFeatures <em>Required Features</em>}</li>
 *   <li>{@link scrm.requirements.Feature#getRequiringFeatures <em>Requiring Features</em>}</li>
 *   <li>{@link scrm.requirements.Feature#getExcludedFeatures <em>Excluded Features</em>}</li>
 *   <li>{@link scrm.requirements.Feature#getExcludingFeatures <em>Excluding Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends IRequirement {
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link scrm.requirements.Constraint}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Constraint#getRestrictedFeature <em>Restricted Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see scrm.requirements.RequirementsPackage#getFeature_Constraints()
	 * @see scrm.requirements.Constraint#getRestrictedFeature
	 * @model opposite="restrictedFeature" containment="true"
	 * @generated
	 */
	EList<Constraint> getConstraints();

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' containment reference list.
	 * The list contents are of type {@link scrm.requirements.Hardware}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Hardware#getDependingFeature <em>Depending Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' containment reference list.
	 * @see scrm.requirements.RequirementsPackage#getFeature_Dependencies()
	 * @see scrm.requirements.Hardware#getDependingFeature
	 * @model opposite="dependingFeature" containment="true"
	 * @generated
	 */
	EList<Hardware> getDependencies();

	/**
	 * Returns the value of the '<em><b>Required User Interface</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.UserInterface#getRequiringFeature <em>Requiring Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required User Interface</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required User Interface</em>' containment reference.
	 * @see #setRequiredUserInterface(UserInterface)
	 * @see scrm.requirements.RequirementsPackage#getFeature_RequiredUserInterface()
	 * @see scrm.requirements.UserInterface#getRequiringFeature
	 * @model opposite="requiringFeature" containment="true"
	 * @generated
	 */
	UserInterface getRequiredUserInterface();

	/**
	 * Sets the value of the '{@link scrm.requirements.Feature#getRequiredUserInterface <em>Required User Interface</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required User Interface</em>' containment reference.
	 * @see #getRequiredUserInterface()
	 * @generated
	 */
	void setRequiredUserInterface(UserInterface value);

	/**
	 * Returns the value of the '<em><b>Provided User Interfaces</b></em>' containment reference list.
	 * The list contents are of type {@link scrm.requirements.UserInterface}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.UserInterface#getProvidingFeature <em>Providing Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided User Interfaces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided User Interfaces</em>' containment reference list.
	 * @see scrm.requirements.RequirementsPackage#getFeature_ProvidedUserInterfaces()
	 * @see scrm.requirements.UserInterface#getProvidingFeature
	 * @model opposite="providingFeature" containment="true"
	 * @generated
	 */
	EList<UserInterface> getProvidedUserInterfaces();

	/**
	 * Returns the value of the '<em><b>Required Software Interface</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.SoftwareInterface#getRequiringFeature <em>Requiring Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Software Interface</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Software Interface</em>' containment reference.
	 * @see #setRequiredSoftwareInterface(SoftwareInterface)
	 * @see scrm.requirements.RequirementsPackage#getFeature_RequiredSoftwareInterface()
	 * @see scrm.requirements.SoftwareInterface#getRequiringFeature
	 * @model opposite="requiringFeature" containment="true"
	 * @generated
	 */
	SoftwareInterface getRequiredSoftwareInterface();

	/**
	 * Sets the value of the '{@link scrm.requirements.Feature#getRequiredSoftwareInterface <em>Required Software Interface</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Software Interface</em>' containment reference.
	 * @see #getRequiredSoftwareInterface()
	 * @generated
	 */
	void setRequiredSoftwareInterface(SoftwareInterface value);

	/**
	 * Returns the value of the '<em><b>Provided Software Interfaces</b></em>' containment reference list.
	 * The list contents are of type {@link scrm.requirements.SoftwareInterface}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.SoftwareInterface#getProvidingFeature <em>Providing Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Software Interfaces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Software Interfaces</em>' containment reference list.
	 * @see scrm.requirements.RequirementsPackage#getFeature_ProvidedSoftwareInterfaces()
	 * @see scrm.requirements.SoftwareInterface#getProvidingFeature
	 * @model opposite="providingFeature" containment="true"
	 * @generated
	 */
	EList<SoftwareInterface> getProvidedSoftwareInterfaces();

	/**
	 * Returns the value of the '<em><b>Detailed Requirements</b></em>' containment reference list.
	 * The list contents are of type {@link scrm.requirements.Requirement}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Requirement#getSpecifiedFeature <em>Specified Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Detailed Requirements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Detailed Requirements</em>' containment reference list.
	 * @see scrm.requirements.RequirementsPackage#getFeature_DetailedRequirements()
	 * @see scrm.requirements.Requirement#getSpecifiedFeature
	 * @model opposite="specifiedFeature" containment="true"
	 * @generated
	 */
	EList<Requirement> getDetailedRequirements();

	/**
	 * Returns the value of the '<em><b>Sub Features</b></em>' containment reference list.
	 * The list contents are of type {@link scrm.requirements.Feature}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getContainingFeature <em>Containing Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Features</em>' containment reference list.
	 * @see scrm.requirements.RequirementsPackage#getFeature_SubFeatures()
	 * @see scrm.requirements.Feature#getContainingFeature
	 * @model opposite="containingFeature" containment="true"
	 * @generated
	 */
	EList<Feature> getSubFeatures();

	/**
	 * Returns the value of the '<em><b>Containing Feature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getSubFeatures <em>Sub Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Feature</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Feature</em>' container reference.
	 * @see #setContainingFeature(Feature)
	 * @see scrm.requirements.RequirementsPackage#getFeature_ContainingFeature()
	 * @see scrm.requirements.Feature#getSubFeatures
	 * @model opposite="subFeatures" transient="false"
	 * @generated
	 */
	Feature getContainingFeature();

	/**
	 * Sets the value of the '{@link scrm.requirements.Feature#getContainingFeature <em>Containing Feature</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Feature</em>' container reference.
	 * @see #getContainingFeature()
	 * @generated
	 */
	void setContainingFeature(Feature value);

	/**
	 * Returns the value of the '<em><b>Required Features</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.Feature}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getRequiringFeatures <em>Requiring Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Features</em>' reference list.
	 * @see scrm.requirements.RequirementsPackage#getFeature_RequiredFeatures()
	 * @see scrm.requirements.Feature#getRequiringFeatures
	 * @model opposite="requiringFeatures"
	 * @generated
	 */
	EList<Feature> getRequiredFeatures();

	/**
	 * Returns the value of the '<em><b>Requiring Features</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.Feature}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getRequiredFeatures <em>Required Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requiring Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiring Features</em>' reference list.
	 * @see scrm.requirements.RequirementsPackage#getFeature_RequiringFeatures()
	 * @see scrm.requirements.Feature#getRequiredFeatures
	 * @model opposite="requiredFeatures"
	 * @generated
	 */
	EList<Feature> getRequiringFeatures();

	/**
	 * Returns the value of the '<em><b>Excluded Features</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.Feature}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getExcludingFeatures <em>Excluding Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Excluded Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Excluded Features</em>' reference list.
	 * @see scrm.requirements.RequirementsPackage#getFeature_ExcludedFeatures()
	 * @see scrm.requirements.Feature#getExcludingFeatures
	 * @model opposite="excludingFeatures"
	 * @generated
	 */
	EList<Feature> getExcludedFeatures();

	/**
	 * Returns the value of the '<em><b>Excluding Features</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.Feature}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getExcludedFeatures <em>Excluded Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Excluding Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Excluding Features</em>' reference list.
	 * @see scrm.requirements.RequirementsPackage#getFeature_ExcludingFeatures()
	 * @see scrm.requirements.Feature#getExcludedFeatures
	 * @model opposite="excludedFeatures"
	 * @generated
	 */
	EList<Feature> getExcludingFeatures();

} // Feature
