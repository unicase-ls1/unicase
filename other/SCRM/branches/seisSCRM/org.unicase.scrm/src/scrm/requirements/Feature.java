/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;

import org.eclipse.emf.common.util.EList;

import scrm.knowledge.ScientificProblem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.Feature#getDetailedRequirements <em>Detailed Requirements</em>}</li>
 *   <li>{@link scrm.requirements.Feature#getSubFeatures <em>Sub Features</em>}</li>
 *   <li>{@link scrm.requirements.Feature#getSuperFeature <em>Super Feature</em>}</li>
 *   <li>{@link scrm.requirements.Feature#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link scrm.requirements.Feature#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link scrm.requirements.Feature#getRequiredInterfaces <em>Required Interfaces</em>}</li>
 *   <li>{@link scrm.requirements.Feature#getProvidedInterfaces <em>Provided Interfaces</em>}</li>
 *   <li>{@link scrm.requirements.Feature#getInfluencingProblem <em>Influencing Problem</em>}</li>
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
	 * Returns the value of the '<em><b>Constraints</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.Constraint}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Constraint#getRestrictedFeature <em>Restricted Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' reference list.
	 * @see scrm.requirements.RequirementsPackage#getFeature_Constraints()
	 * @see scrm.requirements.Constraint#getRestrictedFeature
	 * @model opposite="restrictedFeature"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='26'"
	 * @generated
	 */
	EList<Constraint> getConstraints();

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.Hardware}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Hardware#getDependingFeature <em>Depending Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' reference list.
	 * @see scrm.requirements.RequirementsPackage#getFeature_Dependencies()
	 * @see scrm.requirements.Hardware#getDependingFeature
	 * @model opposite="dependingFeature"
	 *        annotation="org.unicase.ui.meeditor position='right' priority='15'"
	 * @generated
	 */
	EList<Hardware> getDependencies();

	/**
	 * Returns the value of the '<em><b>Required Interfaces</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.Interface}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Interface#getRequiringFeatures <em>Requiring Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Interfaces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Interfaces</em>' reference list.
	 * @see scrm.requirements.RequirementsPackage#getFeature_RequiredInterfaces()
	 * @see scrm.requirements.Interface#getRequiringFeatures
	 * @model opposite="requiringFeatures"
	 *        annotation="org.unicase.ui.meeditor position='right' priority='1'"
	 * @generated
	 */
	EList<Interface> getRequiredInterfaces();

	/**
	 * Returns the value of the '<em><b>Provided Interfaces</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.Interface}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Interface#getProvidingFeatures <em>Providing Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Interfaces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Interfaces</em>' reference list.
	 * @see scrm.requirements.RequirementsPackage#getFeature_ProvidedInterfaces()
	 * @see scrm.requirements.Interface#getProvidingFeatures
	 * @model opposite="providingFeatures"
	 *        annotation="org.unicase.ui.meeditor position='right' priority='1'"
	 * @generated
	 */
	EList<Interface> getProvidedInterfaces();

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
	 * @model opposite="specifiedFeature" containment="true" resolveProxies="true"
	 *        annotation="org.unicase.ui.meeditor position='right' priority='5'"
	 * @generated
	 */
	EList<Requirement> getDetailedRequirements();

	/**
	 * Returns the value of the '<em><b>Influencing Problem</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.ScientificProblem#getInfluencedFeature <em>Influenced Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Influencing Problem</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Influencing Problem</em>' reference.
	 * @see #setInfluencingProblem(ScientificProblem)
	 * @see scrm.requirements.RequirementsPackage#getFeature_InfluencingProblem()
	 * @see scrm.knowledge.ScientificProblem#getInfluencedFeature
	 * @model opposite="influencedFeature"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='25'"
	 * @generated
	 */
	ScientificProblem getInfluencingProblem();

	/**
	 * Sets the value of the '{@link scrm.requirements.Feature#getInfluencingProblem <em>Influencing Problem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Influencing Problem</em>' reference.
	 * @see #getInfluencingProblem()
	 * @generated
	 */
	void setInfluencingProblem(ScientificProblem value);

	/**
	 * Returns the value of the '<em><b>Sub Features</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.Feature}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getSuperFeature <em>Super Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Features</em>' reference list.
	 * @see scrm.requirements.RequirementsPackage#getFeature_SubFeatures()
	 * @see scrm.requirements.Feature#getSuperFeature
	 * @model opposite="superFeature"
	 *        annotation="org.unicase.ui.meeditor position='right' priority='7'"
	 * @generated
	 */
	EList<Feature> getSubFeatures();

	/**
	 * Returns the value of the '<em><b>Super Feature</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.Feature}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getSubFeatures <em>Sub Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Feature</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Feature</em>' reference list.
	 * @see scrm.requirements.RequirementsPackage#getFeature_SuperFeature()
	 * @see scrm.requirements.Feature#getSubFeatures
	 * @model opposite="subFeatures"
	 *        annotation="org.unicase.ui.meeditor position='right' priority='7'"
	 * @generated
	 */
	EList<Feature> getSuperFeature();

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
	 *        annotation="org.unicase.ui.meeditor position='right' priority='30'"
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
	 *        annotation="org.unicase.ui.meeditor position='right' priority='35'"
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
	 *        annotation="org.unicase.ui.meeditor position='right' priority='40'"
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
	 *        annotation="org.unicase.ui.meeditor position='right' priority='45'"
	 * @generated
	 */
	EList<Feature> getExcludingFeatures();

} // Feature
