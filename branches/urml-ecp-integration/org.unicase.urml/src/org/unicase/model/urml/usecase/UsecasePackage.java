/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.usecase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.danger.DangerPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.model.urml.usecase.UsecaseFactory
 * @model kind="package"
 * @generated
 */
public interface UsecasePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "usecase";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/urml/usecase";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.urml.usecase";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	UsecasePackage eINSTANCE = org.unicase.model.urml.usecase.impl.UsecasePackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.urml.usecase.impl.UseCaseImpl <em>Use Case</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.urml.usecase.impl.UseCaseImpl
	 * @see org.unicase.model.urml.usecase.impl.UsecasePackageImpl#getUseCase()
	 * @generated
	 */
	int USE_CASE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__NAME = UrmlPackage.URML_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__DESCRIPTION = UrmlPackage.URML_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USE_CASE__ANNOTATIONS = UrmlPackage.URML_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USE_CASE__ATTACHMENTS = UrmlPackage.URML_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__INCOMING_DOCUMENT_REFERENCES = UrmlPackage.URML_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__LEAF_SECTION = UrmlPackage.URML_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__STATE = UrmlPackage.URML_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USE_CASE__APPLIED_STEREOTYPE_INSTANCES = UrmlPackage.URML_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__COMMENTS = UrmlPackage.URML_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__CREATION_DATE = UrmlPackage.URML_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__CREATOR = UrmlPackage.URML_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__STEPS = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__ACTORS = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Use Case</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_FEATURE_COUNT = UrmlPackage.URML_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.model.urml.usecase.impl.ApplicationDomainUseCaseImpl <em>Application Domain Use Case</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.urml.usecase.impl.ApplicationDomainUseCaseImpl
	 * @see org.unicase.model.urml.usecase.impl.UsecasePackageImpl#getApplicationDomainUseCase()
	 * @generated
	 */
	int APPLICATION_DOMAIN_USE_CASE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DOMAIN_USE_CASE__NAME = USE_CASE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DOMAIN_USE_CASE__DESCRIPTION = USE_CASE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DOMAIN_USE_CASE__ANNOTATIONS = USE_CASE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DOMAIN_USE_CASE__ATTACHMENTS = USE_CASE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DOMAIN_USE_CASE__INCOMING_DOCUMENT_REFERENCES = USE_CASE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DOMAIN_USE_CASE__LEAF_SECTION = USE_CASE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DOMAIN_USE_CASE__STATE = USE_CASE__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DOMAIN_USE_CASE__APPLIED_STEREOTYPE_INSTANCES = USE_CASE__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DOMAIN_USE_CASE__COMMENTS = USE_CASE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DOMAIN_USE_CASE__CREATION_DATE = USE_CASE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DOMAIN_USE_CASE__CREATOR = USE_CASE__CREATOR;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DOMAIN_USE_CASE__STEPS = USE_CASE__STEPS;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DOMAIN_USE_CASE__ACTORS = USE_CASE__ACTORS;

	/**
	 * The feature id for the '<em><b>Detailed Goal</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DOMAIN_USE_CASE__DETAILED_GOAL = USE_CASE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Application Domain Use Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_DOMAIN_USE_CASE_FEATURE_COUNT = USE_CASE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.model.urml.usecase.impl.SolutionDomainUseCaseImpl <em>Solution Domain Use Case</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.urml.usecase.impl.SolutionDomainUseCaseImpl
	 * @see org.unicase.model.urml.usecase.impl.UsecasePackageImpl#getSolutionDomainUseCase()
	 * @generated
	 */
	int SOLUTION_DOMAIN_USE_CASE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_DOMAIN_USE_CASE__NAME = USE_CASE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_DOMAIN_USE_CASE__DESCRIPTION = USE_CASE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOLUTION_DOMAIN_USE_CASE__ANNOTATIONS = USE_CASE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOLUTION_DOMAIN_USE_CASE__ATTACHMENTS = USE_CASE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_DOMAIN_USE_CASE__INCOMING_DOCUMENT_REFERENCES = USE_CASE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_DOMAIN_USE_CASE__LEAF_SECTION = USE_CASE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_DOMAIN_USE_CASE__STATE = USE_CASE__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOLUTION_DOMAIN_USE_CASE__APPLIED_STEREOTYPE_INSTANCES = USE_CASE__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_DOMAIN_USE_CASE__COMMENTS = USE_CASE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_DOMAIN_USE_CASE__CREATION_DATE = USE_CASE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_DOMAIN_USE_CASE__CREATOR = USE_CASE__CREATOR;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_DOMAIN_USE_CASE__STEPS = USE_CASE__STEPS;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_DOMAIN_USE_CASE__ACTORS = USE_CASE__ACTORS;

	/**
	 * The feature id for the '<em><b>Detailed Feature</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOLUTION_DOMAIN_USE_CASE__DETAILED_FEATURE = USE_CASE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Solution Domain Use Case</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_DOMAIN_USE_CASE_FEATURE_COUNT = USE_CASE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.model.urml.usecase.impl.ActorImpl <em>Actor</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.urml.usecase.impl.ActorImpl
	 * @see org.unicase.model.urml.usecase.impl.UsecasePackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__NAME = DangerPackage.ASSET__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__DESCRIPTION = DangerPackage.ASSET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTOR__ANNOTATIONS = DangerPackage.ASSET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTOR__ATTACHMENTS = DangerPackage.ASSET__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__INCOMING_DOCUMENT_REFERENCES = DangerPackage.ASSET__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__LEAF_SECTION = DangerPackage.ASSET__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__STATE = DangerPackage.ASSET__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTOR__APPLIED_STEREOTYPE_INSTANCES = DangerPackage.ASSET__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__COMMENTS = DangerPackage.ASSET__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__CREATION_DATE = DangerPackage.ASSET__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__CREATOR = DangerPackage.ASSET__CREATOR;

	/**
	 * The feature id for the '<em><b>Triggered Dangers</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__TRIGGERED_DANGERS = DangerPackage.ASSET__TRIGGERED_DANGERS;

	/**
	 * The feature id for the '<em><b>Harming Dangers</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__HARMING_DANGERS = DangerPackage.ASSET__HARMING_DANGERS;

	/**
	 * The feature id for the '<em><b>Use Cases</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__USE_CASES = DangerPackage.ASSET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = DangerPackage.ASSET_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.unicase.model.urml.usecase.UseCase <em>Use Case</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Use Case</em>'.
	 * @see org.unicase.model.urml.usecase.UseCase
	 * @generated
	 */
	EClass getUseCase();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.urml.usecase.UseCase#getSteps <em>Steps</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Steps</em>'.
	 * @see org.unicase.model.urml.usecase.UseCase#getSteps()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_Steps();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.urml.usecase.UseCase#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actors</em>'.
	 * @see org.unicase.model.urml.usecase.UseCase#getActors()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_Actors();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.urml.usecase.ApplicationDomainUseCase <em>Application Domain Use Case</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application Domain Use Case</em>'.
	 * @see org.unicase.model.urml.usecase.ApplicationDomainUseCase
	 * @generated
	 */
	EClass getApplicationDomainUseCase();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.urml.usecase.ApplicationDomainUseCase#getDetailedGoal <em>Detailed Goal</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Detailed Goal</em>'.
	 * @see org.unicase.model.urml.usecase.ApplicationDomainUseCase#getDetailedGoal()
	 * @see #getApplicationDomainUseCase()
	 * @generated
	 */
	EReference getApplicationDomainUseCase_DetailedGoal();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.urml.usecase.SolutionDomainUseCase <em>Solution Domain Use Case</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solution Domain Use Case</em>'.
	 * @see org.unicase.model.urml.usecase.SolutionDomainUseCase
	 * @generated
	 */
	EClass getSolutionDomainUseCase();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.unicase.model.urml.usecase.SolutionDomainUseCase#getDetailedFeature <em>Detailed Feature</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Detailed Feature</em>'.
	 * @see org.unicase.model.urml.usecase.SolutionDomainUseCase#getDetailedFeature()
	 * @see #getSolutionDomainUseCase()
	 * @generated
	 */
	EReference getSolutionDomainUseCase_DetailedFeature();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.urml.usecase.Actor <em>Actor</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see org.unicase.model.urml.usecase.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.urml.usecase.Actor#getUseCases <em>Use Cases</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Use Cases</em>'.
	 * @see org.unicase.model.urml.usecase.Actor#getUseCases()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_UseCases();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UsecaseFactory getUsecaseFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.model.urml.usecase.impl.UseCaseImpl <em>Use Case</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.urml.usecase.impl.UseCaseImpl
		 * @see org.unicase.model.urml.usecase.impl.UsecasePackageImpl#getUseCase()
		 * @generated
		 */
		EClass USE_CASE = eINSTANCE.getUseCase();

		/**
		 * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference USE_CASE__STEPS = eINSTANCE.getUseCase_Steps();

		/**
		 * The meta object literal for the '<em><b>Actors</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__ACTORS = eINSTANCE.getUseCase_Actors();

		/**
		 * The meta object literal for the '{@link org.unicase.model.urml.usecase.impl.ApplicationDomainUseCaseImpl <em>Application Domain Use Case</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.urml.usecase.impl.ApplicationDomainUseCaseImpl
		 * @see org.unicase.model.urml.usecase.impl.UsecasePackageImpl#getApplicationDomainUseCase()
		 * @generated
		 */
		EClass APPLICATION_DOMAIN_USE_CASE = eINSTANCE
				.getApplicationDomainUseCase();

		/**
		 * The meta object literal for the '<em><b>Detailed Goal</b></em>' reference list feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_DOMAIN_USE_CASE__DETAILED_GOAL = eINSTANCE
				.getApplicationDomainUseCase_DetailedGoal();

		/**
		 * The meta object literal for the '{@link org.unicase.model.urml.usecase.impl.SolutionDomainUseCaseImpl <em>Solution Domain Use Case</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.urml.usecase.impl.SolutionDomainUseCaseImpl
		 * @see org.unicase.model.urml.usecase.impl.UsecasePackageImpl#getSolutionDomainUseCase()
		 * @generated
		 */
		EClass SOLUTION_DOMAIN_USE_CASE = eINSTANCE.getSolutionDomainUseCase();

		/**
		 * The meta object literal for the '<em><b>Detailed Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLUTION_DOMAIN_USE_CASE__DETAILED_FEATURE = eINSTANCE
				.getSolutionDomainUseCase_DetailedFeature();

		/**
		 * The meta object literal for the '{@link org.unicase.model.urml.usecase.impl.ActorImpl <em>Actor</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.urml.usecase.impl.ActorImpl
		 * @see org.unicase.model.urml.usecase.impl.UsecasePackageImpl#getActor()
		 * @generated
		 */
		EClass ACTOR = eINSTANCE.getActor();

		/**
		 * The meta object literal for the '<em><b>Use Cases</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__USE_CASES = eINSTANCE.getActor_UseCases();

	}

} // UsecasePackage
