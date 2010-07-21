/**
 * <copyright> </copyright> $Id$
 */
package urml.feature;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.urml.UrmlModelElement;

import urml.goal.Goal;
import urml.requirement.FunctionalRequirement;
import urml.requirement.NonFunctionalRequirement;
import urml.usecase.SolutionDomainUseCase;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Abstract Feature</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link urml.feature.AbstractFeature#getGoals <em>Goals</em>}</li>
 * <li>{@link urml.feature.AbstractFeature#getDetailingFunctionalRequirements <em>Detailing Functional Requirements
 * </em>}</li>
 * <li>{@link urml.feature.AbstractFeature#getConstrainingNonFunctionalRequirements <em>Constraining Non Functional
 * Requirements</em>}</li>
 * <li>{@link urml.feature.AbstractFeature#getDetailingUseCases <em>Detailing Use Cases</em>}</li>
 * <li>{@link urml.feature.AbstractFeature#getParentFeature <em>Parent Feature</em>}</li>
 * <li>{@link urml.feature.AbstractFeature#getSubFeatures <em>Sub Features</em>}</li>
 * <li>{@link urml.feature.AbstractFeature#getExcludingFeatures <em>Excluding Features</em>}</li>
 * <li>{@link urml.feature.AbstractFeature#getExcludedFeatures <em>Excluded Features</em>}</li>
 * <li>{@link urml.feature.AbstractFeature#getRequieringFeatures <em>Requiering Features</em>}</li>
 * <li>{@link urml.feature.AbstractFeature#getRequieredFeatures <em>Requiered Features</em>}</li>
 * <li>{@link urml.feature.AbstractFeature#getVariationPoints <em>Variation Points</em>}</li>
 * <li>{@link urml.feature.AbstractFeature#getVariationPointInstances <em>Variation Point Instances</em>}</li>
 * </ul>
 * </p>
 * 
 * @see urml.feature.FeaturePackage#getAbstractFeature()
 * @model abstract="true"
 * @generated
 */
public interface AbstractFeature extends UrmlModelElement {
	/**
	 * Returns the value of the '<em><b>Goals</b></em>' reference list.
	 * The list contents are of type {@link urml.goal.Goal}.
	 * It is bidirectional and its opposite is '{@link urml.goal.Goal#getRealizedFeatures <em>Realized Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goals</em>' reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goals</em>' reference list.
	 * @see urml.feature.FeaturePackage#getAbstractFeature_Goals()
	 * @see urml.goal.Goal#getRealizedFeatures
	 * @model opposite="realizedFeatures" keys="identifier"
	 * @generated
	 */
	EList<Goal> getGoals();

	/**
	 * Returns the value of the '<em><b>Detailing Functional Requirements</b></em>' reference list. The list contents
	 * are of type {@link urml.requirement.FunctionalRequirement}. It is bidirectional and its opposite is '
	 * {@link urml.requirement.FunctionalRequirement#getDetailedFeatures <em>Detailed Features</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Detailing Functional Requirements</em>' reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Detailing Functional Requirements</em>' reference list.
	 * @see urml.feature.FeaturePackage#getAbstractFeature_DetailingFunctionalRequirements()
	 * @see urml.requirement.FunctionalRequirement#getDetailedFeatures
	 * @model opposite="detailedFeatures" keys="identifier"
	 * @generated
	 */
	EList<FunctionalRequirement> getDetailingFunctionalRequirements();

	/**
	 * Returns the value of the '<em><b>Constraining Non Functional Requirements</b></em>' reference list. The list
	 * contents are of type {@link urml.requirement.NonFunctionalRequirement}. It is bidirectional and its opposite is '
	 * {@link urml.requirement.NonFunctionalRequirement#getConstrainedFeatures <em>Constrained Features</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraining Non Functional Requirements</em>' reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraining Non Functional Requirements</em>' reference list.
	 * @see urml.feature.FeaturePackage#getAbstractFeature_ConstrainingNonFunctionalRequirements()
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
	 * If the meaning of the '<em>Detailing Use Cases</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Detailing Use Cases</em>' reference list.
	 * @see urml.feature.FeaturePackage#getAbstractFeature_DetailingUseCases()
	 * @see urml.usecase.SolutionDomainUseCase#getDetailedFeature
	 * @model opposite="detailedFeature" keys="identifier"
	 * @generated
	 */
	EList<SolutionDomainUseCase> getDetailingUseCases();

	/**
	 * Returns the value of the '<em><b>Parent Feature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link urml.feature.AbstractFeature#getSubFeatures <em>Sub Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Feature</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Feature</em>' container reference.
	 * @see #setParentFeature(AbstractFeature)
	 * @see urml.feature.FeaturePackage#getAbstractFeature_ParentFeature()
	 * @see urml.feature.AbstractFeature#getSubFeatures
	 * @model opposite="subFeatures" keys="identifier" transient="false"
	 * @generated
	 */
	AbstractFeature getParentFeature();

	/**
	 * Sets the value of the '{@link urml.feature.AbstractFeature#getParentFeature <em>Parent Feature</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Feature</em>' container reference.
	 * @see #getParentFeature()
	 * @generated
	 */
	void setParentFeature(AbstractFeature value);

	/**
	 * Returns the value of the '<em><b>Sub Features</b></em>' containment reference list.
	 * The list contents are of type {@link urml.feature.AbstractFeature}.
	 * It is bidirectional and its opposite is '{@link urml.feature.AbstractFeature#getParentFeature <em>Parent Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Features</em>' containment reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Features</em>' containment reference list.
	 * @see urml.feature.FeaturePackage#getAbstractFeature_SubFeatures()
	 * @see urml.feature.AbstractFeature#getParentFeature
	 * @model opposite="parentFeature" containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<AbstractFeature> getSubFeatures();

	/**
	 * Returns the value of the '<em><b>Excluding Features</b></em>' reference list.
	 * The list contents are of type {@link urml.feature.AbstractFeature}.
	 * It is bidirectional and its opposite is '{@link urml.feature.AbstractFeature#getExcludedFeatures <em>Excluded Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Excluding Features</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Excluding Features</em>' reference list.
	 * @see urml.feature.FeaturePackage#getAbstractFeature_ExcludingFeatures()
	 * @see urml.feature.AbstractFeature#getExcludedFeatures
	 * @model opposite="excludedFeatures" keys="identifier"
	 * @generated
	 */
	EList<AbstractFeature> getExcludingFeatures();

	/**
	 * Returns the value of the '<em><b>Excluded Features</b></em>' reference list.
	 * The list contents are of type {@link urml.feature.AbstractFeature}.
	 * It is bidirectional and its opposite is '{@link urml.feature.AbstractFeature#getExcludingFeatures <em>Excluding Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Excluded Features</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Excluded Features</em>' reference list.
	 * @see urml.feature.FeaturePackage#getAbstractFeature_ExcludedFeatures()
	 * @see urml.feature.AbstractFeature#getExcludingFeatures
	 * @model opposite="excludingFeatures" keys="identifier"
	 * @generated
	 */
	EList<AbstractFeature> getExcludedFeatures();

	/**
	 * Returns the value of the '<em><b>Requiering Features</b></em>' reference list.
	 * The list contents are of type {@link urml.feature.AbstractFeature}.
	 * It is bidirectional and its opposite is '{@link urml.feature.AbstractFeature#getRequieredFeatures <em>Requiered Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requiering Features</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiering Features</em>' reference list.
	 * @see urml.feature.FeaturePackage#getAbstractFeature_RequieringFeatures()
	 * @see urml.feature.AbstractFeature#getRequieredFeatures
	 * @model opposite="requieredFeatures" keys="identifier"
	 * @generated
	 */
	EList<AbstractFeature> getRequieringFeatures();

	/**
	 * Returns the value of the '<em><b>Requiered Features</b></em>' reference list.
	 * The list contents are of type {@link urml.feature.AbstractFeature}.
	 * It is bidirectional and its opposite is '{@link urml.feature.AbstractFeature#getRequieringFeatures <em>Requiering Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requiered Features</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiered Features</em>' reference list.
	 * @see urml.feature.FeaturePackage#getAbstractFeature_RequieredFeatures()
	 * @see urml.feature.AbstractFeature#getRequieringFeatures
	 * @model opposite="requieringFeatures" keys="identifier"
	 * @generated
	 */
	EList<AbstractFeature> getRequieredFeatures();

	/**
	 * Returns the value of the '<em><b>Variation Point Instances</b></em>' reference list.
	 * The list contents are of type {@link urml.feature.VariationPointInstance}.
	 * It is bidirectional and its opposite is '{@link urml.feature.VariationPointInstance#getSelectedFeatures <em>Selected Features</em>}'.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Variation Point Instances</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variation Point Instances</em>' reference list.
	 * @see urml.feature.FeaturePackage#getAbstractFeature_VariationPointInstances()
	 * @see urml.feature.VariationPointInstance#getSelectedFeatures
	 * @model opposite="selectedFeatures" keys="identifier"
	 * @generated
	 */
	EList<VariationPointInstance> getVariationPointInstances();

} // AbstractFeature
