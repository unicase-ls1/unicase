/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;

import org.eclipse.emf.common.util.EList;

import scrm.knowledge.NumericalMethod;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.Requirement#getRefinements <em>Refinements</em>}</li>
 *   <li>{@link scrm.requirements.Requirement#getRefinedRequirement <em>Refined Requirement</em>}</li>
 *   <li>{@link scrm.requirements.Requirement#getSpecifiedFeature <em>Specified Feature</em>}</li>
 *   <li>{@link scrm.requirements.Requirement#getHandlingData <em>Handling Data</em>}</li>
 *   <li>{@link scrm.requirements.Requirement#getRealizedMethod <em>Realized Method</em>}</li>
 *   <li>{@link scrm.requirements.Requirement#getProvidedInterface <em>Provided Interface</em>}</li>
 *   <li>{@link scrm.requirements.Requirement#getRequiredInterface <em>Required Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getRequirement()
 * @model
 * @generated
 */
public interface Requirement extends IRequirement {
	/**
	 * Returns the value of the '<em><b>Refinements</b></em>' containment reference list.
	 * The list contents are of type {@link scrm.requirements.Requirement}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Requirement#getRefinedRequirement <em>Refined Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refinements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refinements</em>' containment reference list.
	 * @see scrm.requirements.RequirementsPackage#getRequirement_Refinements()
	 * @see scrm.requirements.Requirement#getRefinedRequirement
	 * @model opposite="refinedRequirement" containment="true" resolveProxies="true"
	 *        annotation="org.unicase.ui.meeditor position='right' priority='5'"
	 * @generated
	 */
	EList<Requirement> getRefinements();

	/**
	 * Returns the value of the '<em><b>Refined Requirement</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Requirement#getRefinements <em>Refinements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refined Requirement</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refined Requirement</em>' container reference.
	 * @see #setRefinedRequirement(Requirement)
	 * @see scrm.requirements.RequirementsPackage#getRequirement_RefinedRequirement()
	 * @see scrm.requirements.Requirement#getRefinements
	 * @model opposite="refinements" transient="false"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='15'"
	 * @generated
	 */
	Requirement getRefinedRequirement();

	/**
	 * Sets the value of the '{@link scrm.requirements.Requirement#getRefinedRequirement <em>Refined Requirement</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refined Requirement</em>' container reference.
	 * @see #getRefinedRequirement()
	 * @generated
	 */
	void setRefinedRequirement(Requirement value);

	/**
	 * Returns the value of the '<em><b>Specified Feature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getDetailedRequirements <em>Detailed Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specified Feature</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specified Feature</em>' container reference.
	 * @see #setSpecifiedFeature(Feature)
	 * @see scrm.requirements.RequirementsPackage#getRequirement_SpecifiedFeature()
	 * @see scrm.requirements.Feature#getDetailedRequirements
	 * @model opposite="detailedRequirements" transient="false"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='20'"
	 * @generated
	 */
	Feature getSpecifiedFeature();

	/**
	 * Sets the value of the '{@link scrm.requirements.Requirement#getSpecifiedFeature <em>Specified Feature</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specified Feature</em>' container reference.
	 * @see #getSpecifiedFeature()
	 * @generated
	 */
	void setSpecifiedFeature(Feature value);

	/**
	 * Returns the value of the '<em><b>Handling Data</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.DataDefinition}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.DataDefinition#getDefinedRequirement <em>Defined Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handling Data</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Handling Data</em>' reference list.
	 * @see scrm.requirements.RequirementsPackage#getRequirement_HandlingData()
	 * @see scrm.requirements.DataDefinition#getDefinedRequirement
	 * @model opposite="definedRequirement"
	 *        annotation="org.unicase.ui.meeditor position='right' priority='10'"
	 * @generated
	 */
	EList<DataDefinition> getHandlingData();

	/**
	 * Returns the value of the '<em><b>Realized Method</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.NumericalMethod#getRealizingRequirement <em>Realizing Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realized Method</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realized Method</em>' reference.
	 * @see #setRealizedMethod(NumericalMethod)
	 * @see scrm.requirements.RequirementsPackage#getRequirement_RealizedMethod()
	 * @see scrm.knowledge.NumericalMethod#getRealizingRequirement
	 * @model opposite="realizingRequirement"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='25'"
	 * @generated
	 */
	NumericalMethod getRealizedMethod();

	/**
	 * Sets the value of the '{@link scrm.requirements.Requirement#getRealizedMethod <em>Realized Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Realized Method</em>' reference.
	 * @see #getRealizedMethod()
	 * @generated
	 */
	void setRealizedMethod(NumericalMethod value);

	/**
	 * Returns the value of the '<em><b>Provided Interface</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Interface#getDetailsOfProvidingFunctionsAndProperties <em>Details Of Providing Functions And Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Interface</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Interface</em>' reference.
	 * @see #setProvidedInterface(Interface)
	 * @see scrm.requirements.RequirementsPackage#getRequirement_ProvidedInterface()
	 * @see scrm.requirements.Interface#getDetailsOfProvidingFunctionsAndProperties
	 * @model opposite="detailsOfProvidingFunctionsAndProperties"
	 * @generated
	 */
	Interface getProvidedInterface();

	/**
	 * Sets the value of the '{@link scrm.requirements.Requirement#getProvidedInterface <em>Provided Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provided Interface</em>' reference.
	 * @see #getProvidedInterface()
	 * @generated
	 */
	void setProvidedInterface(Interface value);

	/**
	 * Returns the value of the '<em><b>Required Interface</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Interface#getDetailsOfRequiringFunctionsAndProperties <em>Details Of Requiring Functions And Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Interface</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Interface</em>' reference.
	 * @see #setRequiredInterface(Interface)
	 * @see scrm.requirements.RequirementsPackage#getRequirement_RequiredInterface()
	 * @see scrm.requirements.Interface#getDetailsOfRequiringFunctionsAndProperties
	 * @model opposite="detailsOfRequiringFunctionsAndProperties"
	 * @generated
	 */
	Interface getRequiredInterface();

	/**
	 * Sets the value of the '{@link scrm.requirements.Requirement#getRequiredInterface <em>Required Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Interface</em>' reference.
	 * @see #getRequiredInterface()
	 * @generated
	 */
	void setRequiredInterface(Interface value);

} // Requirement
