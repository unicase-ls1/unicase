/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.feature;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.goal.Goal;
import org.unicase.model.urml.requirement.FunctionalRequirement;
import org.unicase.model.urml.requirement.NonFunctionalRequirement;
import org.unicase.model.urml.usecase.SolutionDomainUseCase;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Abstract Feature</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.urml.feature.AbstractFeature#getGoals <em>Goals</em>}</li>
 * <li>{@link org.unicase.model.urml.feature.AbstractFeature#getDetailingFunctionalRequirements <em>Detailing Functional
 * Requirements </em>}</li>
 * <li>{@link org.unicase.model.urml.feature.AbstractFeature#getConstrainingNonFunctionalRequirements <em>Constraining
 * Non Functional Requirements</em>}</li>
 * <li>{@link org.unicase.model.urml.feature.AbstractFeature#getDetailingUseCases <em>Detailing Use Cases</em>}</li>
 * <li>{@link org.unicase.model.urml.feature.AbstractFeature#getParentFeature <em>Parent Feature</em>}</li>
 * <li>{@link org.unicase.model.urml.feature.AbstractFeature#getSubFeatures <em>Sub Features</em>}</li>
 * <li>{@link org.unicase.model.urml.feature.AbstractFeature#getExcludingFeatures <em>Excluding Features</em>}</li>
 * <li>{@link org.unicase.model.urml.feature.AbstractFeature#getExcludedFeatures <em>Excluded Features</em>}</li>
 * <li>{@link org.unicase.model.urml.feature.AbstractFeature#getRequieringFeatures <em>Requiering Features</em>}</li>
 * <li>{@link org.unicase.model.urml.feature.AbstractFeature#getRequieredFeatures <em>Requiered Features</em>}</li>
 * <li>{@link org.unicase.model.urml.feature.AbstractFeature#getVariationPoint <em>Variation Point</em>}</li>
 * <li>{@link org.unicase.model.urml.feature.AbstractFeature#getVariationPointInstances <em>Variation Point Instances
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.urml.feature.FeaturePackage#getAbstractFeature()
 * @model abstract="true"
 * @generated
 */
public interface AbstractFeature extends UrmlModelElement {
	/**
	 * Returns the value of the '<em><b>Goals</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.urml.goal.Goal}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.urml.goal.Goal#getRealizedFeatures <em>Realized Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goals</em>' reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goals</em>' reference list.
	 * @see org.unicase.model.urml.feature.FeaturePackage#getAbstractFeature_Goals()
	 * @see org.unicase.model.urml.goal.Goal#getRealizedFeatures
	 * @model opposite="realizedFeatures"
	 * @generated
	 */
	EList<Goal> getGoals();

	/**
	 * Returns the value of the '<em><b>Detailing Functional Requirements</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.urml.requirement.FunctionalRequirement}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.urml.requirement.FunctionalRequirement#getDetailedFeatures <em>Detailed Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Detailing Functional Requirements</em>' reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Detailing Functional Requirements</em>' reference list.
	 * @see org.unicase.model.urml.feature.FeaturePackage#getAbstractFeature_DetailingFunctionalRequirements()
	 * @see org.unicase.model.urml.requirement.FunctionalRequirement#getDetailedFeatures
	 * @model opposite="detailedFeatures"
	 * @generated
	 */
	EList<FunctionalRequirement> getDetailingFunctionalRequirements();

	/**
	 * Returns the value of the '<em><b>Constraining Non Functional Requirements</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.urml.requirement.NonFunctionalRequirement}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.urml.requirement.NonFunctionalRequirement#getConstrainedFeatures <em>Constrained Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraining Non Functional Requirements</em>' reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraining Non Functional Requirements</em>' reference list.
	 * @see org.unicase.model.urml.feature.FeaturePackage#getAbstractFeature_ConstrainingNonFunctionalRequirements()
	 * @see org.unicase.model.urml.requirement.NonFunctionalRequirement#getConstrainedFeatures
	 * @model opposite="constrainedFeatures"
	 * @generated
	 */
	EList<NonFunctionalRequirement> getConstrainingNonFunctionalRequirements();

	/**
	 * Returns the value of the '<em><b>Detailing Use Cases</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.urml.usecase.SolutionDomainUseCase}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.usecase.SolutionDomainUseCase#getDetailedFeature <em>Detailed Feature</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Detailing Use Cases</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Detailing Use Cases</em>' reference list.
	 * @see org.unicase.model.urml.feature.FeaturePackage#getAbstractFeature_DetailingUseCases()
	 * @see org.unicase.model.urml.usecase.SolutionDomainUseCase#getDetailedFeature
	 * @model opposite="detailedFeature" keys="identifier"
	 * @generated
	 */
	EList<SolutionDomainUseCase> getDetailingUseCases();

	/**
	 * Returns the value of the '<em><b>Parent Feature</b></em>' container reference. It is bidirectional and its
	 * opposite is '{@link org.unicase.model.urml.feature.AbstractFeature#getSubFeatures <em>Sub Features</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Feature</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent Feature</em>' container reference.
	 * @see #setParentFeature(AbstractFeature)
	 * @see org.unicase.model.urml.feature.FeaturePackage#getAbstractFeature_ParentFeature()
	 * @see org.unicase.model.urml.feature.AbstractFeature#getSubFeatures
	 * @model opposite="subFeatures" keys="identifier" transient="false"
	 * @generated
	 */
	AbstractFeature getParentFeature();

	/**
	 * Sets the value of the '{@link org.unicase.model.urml.feature.AbstractFeature#getParentFeature <em>Parent Feature</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Feature</em>' container reference.
	 * @see #getParentFeature()
	 * @generated
	 */
	void setParentFeature(AbstractFeature value);

	/**
	 * Returns the value of the '<em><b>Sub Features</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.model.urml.feature.AbstractFeature}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getParentFeature <em>Parent Feature</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Features</em>' containment reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sub Features</em>' containment reference list.
	 * @see org.unicase.model.urml.feature.FeaturePackage#getAbstractFeature_SubFeatures()
	 * @see org.unicase.model.urml.feature.AbstractFeature#getParentFeature
	 * @model opposite="parentFeature" containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<AbstractFeature> getSubFeatures();

	/**
	 * Returns the value of the '<em><b>Excluding Features</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.urml.feature.AbstractFeature}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getExcludedFeatures <em>Excluded Features</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Excluding Features</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Excluding Features</em>' reference list.
	 * @see org.unicase.model.urml.feature.FeaturePackage#getAbstractFeature_ExcludingFeatures()
	 * @see org.unicase.model.urml.feature.AbstractFeature#getExcludedFeatures
	 * @model opposite="excludedFeatures" keys="identifier"
	 * @generated
	 */
	EList<AbstractFeature> getExcludingFeatures();

	/**
	 * Returns the value of the '<em><b>Excluded Features</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.urml.feature.AbstractFeature}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getExcludingFeatures <em>Excluding Features</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Excluded Features</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Excluded Features</em>' reference list.
	 * @see org.unicase.model.urml.feature.FeaturePackage#getAbstractFeature_ExcludedFeatures()
	 * @see org.unicase.model.urml.feature.AbstractFeature#getExcludingFeatures
	 * @model opposite="excludingFeatures" keys="identifier"
	 * @generated
	 */
	EList<AbstractFeature> getExcludedFeatures();

	/**
	 * Returns the value of the '<em><b>Requiring Features</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.urml.feature.AbstractFeature}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getRequiredFeatures <em>Required Features</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requiring Features</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Requiring Features</em>' reference list.
	 * @see org.unicase.model.urml.feature.FeaturePackage#getAbstractFeature_RequiringFeatures()
	 * @see org.unicase.model.urml.feature.AbstractFeature#getRequiredFeatures
	 * @model opposite="requiredFeatures" keys="identifier"
	 * @generated
	 */
	EList<AbstractFeature> getRequiringFeatures();

	/**
	 * Returns the value of the '<em><b>Required Features</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.urml.feature.AbstractFeature}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getRequiringFeatures <em>Requiring Features</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Features</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Required Features</em>' reference list.
	 * @see org.unicase.model.urml.feature.FeaturePackage#getAbstractFeature_RequiredFeatures()
	 * @see org.unicase.model.urml.feature.AbstractFeature#getRequiringFeatures
	 * @model opposite="requiringFeatures" keys="identifier"
	 * @generated
	 */
	EList<AbstractFeature> getRequiredFeatures();

	/**
	 * Returns the value of the '<em><b>Optional Parent Variation Point</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.urml.feature.VariationPoint#getOptionalSubFeatures <em>Optional Sub Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional Parent Variation Point</em>' container reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional Parent Variation Point</em>' container reference.
	 * @see #setOptionalParentVariationPoint(VariationPoint)
	 * @see org.unicase.model.urml.feature.FeaturePackage#getAbstractFeature_OptionalParentVariationPoint()
	 * @see org.unicase.model.urml.feature.VariationPoint#getOptionalSubFeatures
	 * @model opposite="optionalSubFeatures" transient="false"
	 * @generated
	 */
	VariationPoint getOptionalParentVariationPoint();

	/**
	 * Sets the value of the '{@link org.unicase.model.urml.feature.AbstractFeature#getOptionalParentVariationPoint <em>Optional Parent Variation Point</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional Parent Variation Point</em>' container reference.
	 * @see #getOptionalParentVariationPoint()
	 * @generated
	 */
	void setOptionalParentVariationPoint(VariationPoint value);

	/**
	 * Returns the value of the '<em><b>Variation Point Instances</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.urml.feature.VariationPointInstance}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.urml.feature.VariationPointInstance#getSelectedFeatures <em>Selected Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variation Point Instances</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variation Point Instances</em>' reference list.
	 * @see org.unicase.model.urml.feature.FeaturePackage#getAbstractFeature_VariationPointInstances()
	 * @see org.unicase.model.urml.feature.VariationPointInstance#getSelectedFeatures
	 * @model opposite="selectedFeatures"
	 * @generated
	 */
	EList<VariationPointInstance> getVariationPointInstances();

} // AbstractFeature
