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
 *   <li>{@link scrm.requirements.Requirement#getDefiningData <em>Defining Data</em>}</li>
 *   <li>{@link scrm.requirements.Requirement#getRealizedMethod <em>Realized Method</em>}</li>
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
	 * @model opposite="refinedRequirement" containment="true"
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
	 * Returns the value of the '<em><b>Defining Data</b></em>' containment reference list.
	 * The list contents are of type {@link scrm.requirements.DataDefinition}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.DataDefinition#getDefinedRequirement <em>Defined Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defining Data</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defining Data</em>' containment reference list.
	 * @see scrm.requirements.RequirementsPackage#getRequirement_DefiningData()
	 * @see scrm.requirements.DataDefinition#getDefinedRequirement
	 * @model opposite="definedRequirement" containment="true"
	 * @generated
	 */
	EList<DataDefinition> getDefiningData();

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

} // Requirement
