/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml;

import org.eclipse.emf.common.util.EList;

import urml.goal.Goal;

import urml.requirement.FunctionalRequirement;
import urml.requirement.NonFunctionalRequirement;

import urml.usecase.SolutionDomainUseCase;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.urml.Feature#getGoals <em>Goals</em>}</li>
 *   <li>{@link org.unicase.model.urml.Feature#getDetailingFunctionalRequirements <em>Detailing Functional Requirements</em>}</li>
 *   <li>{@link org.unicase.model.urml.Feature#getConstrainingNonFunctionalRequirements <em>Constraining Non Functional Requirements</em>}</li>
 *   <li>{@link org.unicase.model.urml.Feature#getDetailingUseCases <em>Detailing Use Cases</em>}</li>
 *   <li>{@link org.unicase.model.urml.Feature#getParentFeature <em>Parent Feature</em>}</li>
 *   <li>{@link org.unicase.model.urml.Feature#getSubFeatures <em>Sub Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.urml.UrmlPackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends UrmlModelElement {
	/**
	 * Returns the value of the '<em><b>Goals</b></em>' reference list.
	 * The list contents are of type {@link urml.goal.Goal}.
	 * It is bidirectional and its opposite is '{@link urml.goal.Goal#getRealizedFeatures <em>Realized Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goals</em>' reference list.
	 * @see org.unicase.model.urml.UrmlPackage#getFeature_Goals()
	 * @see urml.goal.Goal#getRealizedFeatures
	 * @model opposite="realizedFeatures" keys="identifier"
	 * @generated
	 */
	EList<Goal> getGoals();

	/**
	 * Returns the value of the '<em><b>Detailing Functional Requirements</b></em>' reference list.
	 * The list contents are of type {@link urml.requirement.FunctionalRequirement}.
	 * It is bidirectional and its opposite is '{@link urml.requirement.FunctionalRequirement#getDetailedFeatures <em>Detailed Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Detailing Functional Requirements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Detailing Functional Requirements</em>' reference list.
	 * @see org.unicase.model.urml.UrmlPackage#getFeature_DetailingFunctionalRequirements()
	 * @see urml.requirement.FunctionalRequirement#getDetailedFeatures
	 * @model opposite="detailedFeatures" keys="identifier"
	 * @generated
	 */
	EList<FunctionalRequirement> getDetailingFunctionalRequirements();

	/**
	 * Returns the value of the '<em><b>Constraining Non Functional Requirements</b></em>' reference list.
	 * The list contents are of type {@link urml.requirement.NonFunctionalRequirement}.
	 * It is bidirectional and its opposite is '{@link urml.requirement.NonFunctionalRequirement#getConstrainedFeatures <em>Constrained Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraining Non Functional Requirements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraining Non Functional Requirements</em>' reference list.
	 * @see org.unicase.model.urml.UrmlPackage#getFeature_ConstrainingNonFunctionalRequirements()
	 * @see urml.requirement.NonFunctionalRequirement#getConstrainedFeatures
	 * @model opposite="constrainedFeatures" keys="identifier"
	 * @generated
	 */
	EList<NonFunctionalRequirement> getConstrainingNonFunctionalRequirements();

	/**
	 * Returns the value of the '<em><b>Detailing Use Cases</b></em>' reference list.
	 * The list contents are of type {@link urml.usecase.SolutionDomainUseCase}.
	 * It is bidirectional and its opposite is '{@link urml.usecase.SolutionDomainUseCase#getDetailedFeature <em>Detailed Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Detailing Use Cases</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Detailing Use Cases</em>' reference list.
	 * @see org.unicase.model.urml.UrmlPackage#getFeature_DetailingUseCases()
	 * @see urml.usecase.SolutionDomainUseCase#getDetailedFeature
	 * @model opposite="detailedFeature" keys="identifier"
	 * @generated
	 */
	EList<SolutionDomainUseCase> getDetailingUseCases();

	/**
	 * Returns the value of the '<em><b>Parent Feature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.urml.Feature#getSubFeatures <em>Sub Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Feature</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Feature</em>' container reference.
	 * @see #setParentFeature(Feature)
	 * @see org.unicase.model.urml.UrmlPackage#getFeature_ParentFeature()
	 * @see org.unicase.model.urml.Feature#getSubFeatures
	 * @model opposite="subFeatures" keys="identifier" transient="false"
	 * @generated
	 */
	Feature getParentFeature();

	/**
	 * Sets the value of the '{@link org.unicase.model.urml.Feature#getParentFeature <em>Parent Feature</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Feature</em>' container reference.
	 * @see #getParentFeature()
	 * @generated
	 */
	void setParentFeature(Feature value);

	/**
	 * Returns the value of the '<em><b>Sub Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.urml.Feature}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.urml.Feature#getParentFeature <em>Parent Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Features</em>' containment reference list.
	 * @see org.unicase.model.urml.UrmlPackage#getFeature_SubFeatures()
	 * @see org.unicase.model.urml.Feature#getParentFeature
	 * @model opposite="parentFeature" containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<Feature> getSubFeatures();

} // Feature
