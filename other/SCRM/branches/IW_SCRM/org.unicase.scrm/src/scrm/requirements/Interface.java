/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;

import org.eclipse.emf.common.util.EList;

import scrm.requirements.dataObject.Data;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.Interface#getProvidingFeatures <em>Providing Features</em>}</li>
 *   <li>{@link scrm.requirements.Interface#getRequiringFeatures <em>Requiring Features</em>}</li>
 *   <li>{@link scrm.requirements.Interface#getProvidingData <em>Providing Data</em>}</li>
 *   <li>{@link scrm.requirements.Interface#getRequiringData <em>Requiring Data</em>}</li>
 *   <li>{@link scrm.requirements.Interface#getDetailsOfProvidingFunctionsAndProperties <em>Details Of Providing Functions And Properties</em>}</li>
 *   <li>{@link scrm.requirements.Interface#getDetailsOfRequiringFunctionsAndProperties <em>Details Of Requiring Functions And Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getInterface()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Interface extends IRequirement {
	/**
	 * Returns the value of the '<em><b>Providing Features</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.Feature}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getProvidedInterfaces <em>Provided Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Providing Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Providing Features</em>' reference list.
	 * @see scrm.requirements.RequirementsPackage#getInterface_ProvidingFeatures()
	 * @see scrm.requirements.Feature#getProvidedInterfaces
	 * @model opposite="providedInterfaces"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='15'"
	 * @generated
	 */
	EList<Feature> getProvidingFeatures();

	/**
	 * Returns the value of the '<em><b>Requiring Features</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.Feature}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getRequiredInterfaces <em>Required Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requiring Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiring Features</em>' reference list.
	 * @see scrm.requirements.RequirementsPackage#getInterface_RequiringFeatures()
	 * @see scrm.requirements.Feature#getRequiredInterfaces
	 * @model opposite="requiredInterfaces"
	 *        annotation="org.unicase.ui.meeditor position='right' priority='10'"
	 * @generated
	 */
	EList<Feature> getRequiringFeatures();

	/**
	 * Returns the value of the '<em><b>Providing Data</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.dataObject.Data}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.dataObject.Data#getProvidedInterface <em>Provided Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Providing Data</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Providing Data</em>' reference list.
	 * @see scrm.requirements.RequirementsPackage#getInterface_ProvidingData()
	 * @see scrm.requirements.dataObject.Data#getProvidedInterface
	 * @model opposite="providedInterface"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='20'"
	 * @generated
	 */
	EList<Data> getProvidingData();

	/**
	 * Returns the value of the '<em><b>Requiring Data</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.dataObject.Data}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.dataObject.Data#getRequiredInterface <em>Required Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requiring Data</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiring Data</em>' reference list.
	 * @see scrm.requirements.RequirementsPackage#getInterface_RequiringData()
	 * @see scrm.requirements.dataObject.Data#getRequiredInterface
	 * @model opposite="requiredInterface"
	 *        annotation="org.unicase.ui.meeditor position='right' priority='15'"
	 * @generated
	 */
	EList<Data> getRequiringData();

	/**
	 * Returns the value of the '<em><b>Details Of Providing Functions And Properties</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.Requirement}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Requirement#getProvidedInterface <em>Provided Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Details Of Providing Functions And Properties</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Details Of Providing Functions And Properties</em>' reference list.
	 * @see scrm.requirements.RequirementsPackage#getInterface_DetailsOfProvidingFunctionsAndProperties()
	 * @see scrm.requirements.Requirement#getProvidedInterface
	 * @model opposite="providedInterface"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='25'"
	 * @generated
	 */
	EList<Requirement> getDetailsOfProvidingFunctionsAndProperties();

	/**
	 * Returns the value of the '<em><b>Details Of Requiring Functions And Properties</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.Requirement}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Requirement#getRequiredInterface <em>Required Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Details Of Requiring Functions And Properties</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Details Of Requiring Functions And Properties</em>' reference list.
	 * @see scrm.requirements.RequirementsPackage#getInterface_DetailsOfRequiringFunctionsAndProperties()
	 * @see scrm.requirements.Requirement#getRequiredInterface
	 * @model opposite="requiredInterface"
	 *        annotation="org.unicase.ui.meeditor position='right' priority='20'"
	 * @generated
	 */
	EList<Requirement> getDetailsOfRequiringFunctionsAndProperties();

} // Interface
