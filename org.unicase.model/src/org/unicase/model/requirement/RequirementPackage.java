/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.requirement;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.unicase.model.ModelPackage;
import org.unicase.model.rationale.RationalePackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.model.requirement.RequirementFactory
 * @model kind="package"
 * @generated
 */
public interface RequirementPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "requirement";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/requirement";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.requirement";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	RequirementPackage eINSTANCE = org.unicase.model.requirement.impl.RequirementPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.requirement.impl.NonFunctionalRequirementImpl <em>Non Functional Requirement</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.unicase.model.requirement.impl.NonFunctionalRequirementImpl
	 * @see org.unicase.model.requirement.impl.RequirementPackageImpl#getNonFunctionalRequirement()
	 * @generated
	 */
	int NON_FUNCTIONAL_REQUIREMENT = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__IDENTIFIER = RationalePackage.CRITERION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__NAME = RationalePackage.CRITERION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__DESCRIPTION = RationalePackage.CRITERION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__READER_INFOS = RationalePackage.CRITERION__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__ANNOTATIONS = RationalePackage.CRITERION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__INCOMING_DOCUMENT_REFERENCES = RationalePackage.CRITERION__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__LEAF_SECTION = RationalePackage.CRITERION__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>Assessments</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__ASSESSMENTS = RationalePackage.CRITERION__ASSESSMENTS;

	/**
	 * The feature id for the '<em><b>Restricted Scenarios</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_SCENARIOS = RationalePackage.CRITERION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Restricted Use Cases</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_USE_CASES = RationalePackage.CRITERION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Non Functional Requirement</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT_FEATURE_COUNT = RationalePackage.CRITERION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.model.requirement.impl.FunctionalRequirementImpl <em>Functional Requirement</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.unicase.model.requirement.impl.FunctionalRequirementImpl
	 * @see org.unicase.model.requirement.impl.RequirementPackageImpl#getFunctionalRequirement()
	 * @generated
	 */
	int FUNCTIONAL_REQUIREMENT = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__READER_INFOS = ModelPackage.MODEL_ELEMENT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>Story Points</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__STORY_POINTS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__PRIORITY = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Refining Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Use Cases</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__USE_CASES = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__SCENARIOS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Reviewed</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__REVIEWED = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Functional Requirement</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.unicase.model.requirement.impl.UseCaseImpl <em>Use Case</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.requirement.impl.UseCaseImpl
	 * @see org.unicase.model.requirement.impl.RequirementPackageImpl#getUseCase()
	 * @generated
	 */
	int USE_CASE = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USE_CASE__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USE_CASE__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__READER_INFOS = ModelPackage.MODEL_ELEMENT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USE_CASE__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__STEPS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initiating Actor</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USE_CASE__INITIATING_ACTOR = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Participating Actors</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__PARTICIPATING_ACTORS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USE_CASE__SCENARIOS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Functional Requirements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__FUNCTIONAL_REQUIREMENTS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Non Functional Requirements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__NON_FUNCTIONAL_REQUIREMENTS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Identified Classes</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__IDENTIFIED_CLASSES = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Use Case</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USE_CASE_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.unicase.model.requirement.impl.ScenarioImpl <em>Scenario</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.requirement.impl.ScenarioImpl
	 * @see org.unicase.model.requirement.impl.RequirementPackageImpl#getScenario()
	 * @generated
	 */
	int SCENARIO = 3;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCENARIO__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCENARIO__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__READER_INFOS = ModelPackage.MODEL_ELEMENT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCENARIO__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__STEPS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initiating Actor Instance</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__INITIATING_ACTOR_INSTANCE = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Participating Actor Instances</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__PARTICIPATING_ACTOR_INSTANCES = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Instantiated Use Cases</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__INSTANTIATED_USE_CASES = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Functional Requirements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__FUNCTIONAL_REQUIREMENTS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Non Functional Requirements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__NON_FUNCTIONAL_REQUIREMENTS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Scenario</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCENARIO_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.unicase.model.requirement.impl.ActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.requirement.impl.ActorImpl
	 * @see org.unicase.model.requirement.impl.RequirementPackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 4;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTOR__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTOR__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__READER_INFOS = ModelPackage.MODEL_ELEMENT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTOR__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>Initiated Use Cases</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__INITIATED_USE_CASES = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Participated Use Cases</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__PARTICIPATED_USE_CASES = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTOR__INSTANCES = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Actor</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.model.requirement.impl.ActorInstanceImpl <em>Actor Instance</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.unicase.model.requirement.impl.ActorInstanceImpl
	 * @see org.unicase.model.requirement.impl.RequirementPackageImpl#getActorInstance()
	 * @generated
	 */
	int ACTOR_INSTANCE = 5;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__READER_INFOS = ModelPackage.MODEL_ELEMENT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>Initiated Scenarios</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__INITIATED_SCENARIOS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Participated Scenarios</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__PARTICIPATED_SCENARIOS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Instantiated Actor</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__INSTANTIATED_ACTOR = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Actor Instance</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.model.requirement.impl.StepImpl <em>Step</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.requirement.impl.StepImpl
	 * @see org.unicase.model.requirement.impl.RequirementPackageImpl#getStep()
	 * @generated
	 */
	int STEP = 6;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEP__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEP__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP__READER_INFOS = ModelPackage.MODEL_ELEMENT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEP__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>User Step</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEP__USER_STEP = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Step</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEP_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.unicase.model.requirement.NonFunctionalRequirement <em>Non Functional Requirement</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for class '<em>Non Functional Requirement</em>'.
	 * @see org.unicase.model.requirement.NonFunctionalRequirement
	 * @generated
	 */
	EClass getNonFunctionalRequirement();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.requirement.NonFunctionalRequirement#getRestrictedScenarios <em>Restricted Scenarios</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the reference list '<em>Restricted Scenarios</em>'.
	 * @see org.unicase.model.requirement.NonFunctionalRequirement#getRestrictedScenarios()
	 * @see #getNonFunctionalRequirement()
	 * @generated
	 */
	EReference getNonFunctionalRequirement_RestrictedScenarios();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.requirement.NonFunctionalRequirement#getRestrictedUseCases <em>Restricted Use Cases</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the reference list '<em>Restricted Use Cases</em>'.
	 * @see org.unicase.model.requirement.NonFunctionalRequirement#getRestrictedUseCases()
	 * @see #getNonFunctionalRequirement()
	 * @generated
	 */
	EReference getNonFunctionalRequirement_RestrictedUseCases();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.requirement.FunctionalRequirement <em>Functional Requirement</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for class '<em>Functional Requirement</em>'.
	 * @see org.unicase.model.requirement.FunctionalRequirement
	 * @generated
	 */
	EClass getFunctionalRequirement();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.requirement.FunctionalRequirement#isReviewed <em>Reviewed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reviewed</em>'.
	 * @see org.unicase.model.requirement.FunctionalRequirement#isReviewed()
	 * @see #getFunctionalRequirement()
	 * @generated
	 */
	EAttribute getFunctionalRequirement_Reviewed();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.requirement.FunctionalRequirement#getStoryPoints <em>Story Points</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Story Points</em>'.
	 * @see org.unicase.model.requirement.FunctionalRequirement#getStoryPoints()
	 * @see #getFunctionalRequirement()
	 * @generated
	 */
	EAttribute getFunctionalRequirement_StoryPoints();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.requirement.FunctionalRequirement#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.unicase.model.requirement.FunctionalRequirement#getPriority()
	 * @see #getFunctionalRequirement()
	 * @generated
	 */
	EAttribute getFunctionalRequirement_Priority();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.requirement.FunctionalRequirement#getRefiningRequirements <em>Refining Requirements</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Refining Requirements</em>'.
	 * @see org.unicase.model.requirement.FunctionalRequirement#getRefiningRequirements()
	 * @see #getFunctionalRequirement()
	 * @generated
	 */
	EReference getFunctionalRequirement_RefiningRequirements();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.unicase.model.requirement.FunctionalRequirement#getRefinedRequirement
	 * <em>Refined Requirement</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the container reference '
	 *         <em>Refined Requirement</em>'.
	 * @see org.unicase.model.requirement.FunctionalRequirement#getRefinedRequirement()
	 * @see #getFunctionalRequirement()
	 * @generated
	 */
	EReference getFunctionalRequirement_RefinedRequirement();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.requirement.FunctionalRequirement#getUseCases <em>Use Cases</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Use Cases</em>'.
	 * @see org.unicase.model.requirement.FunctionalRequirement#getUseCases()
	 * @see #getFunctionalRequirement()
	 * @generated
	 */
	EReference getFunctionalRequirement_UseCases();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.requirement.FunctionalRequirement#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Scenarios</em>'.
	 * @see org.unicase.model.requirement.FunctionalRequirement#getScenarios()
	 * @see #getFunctionalRequirement()
	 * @generated
	 */
	EReference getFunctionalRequirement_Scenarios();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.model.requirement.UseCase <em>Use Case</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Use Case</em>'.
	 * @see org.unicase.model.requirement.UseCase
	 * @generated
	 */
	EClass getUseCase();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.requirement.UseCase#getSteps <em>Steps</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Steps</em>'.
	 * @see org.unicase.model.requirement.UseCase#getSteps()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_Steps();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.unicase.model.requirement.UseCase#getInitiatingActor
	 * <em>Initiating Actor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference '<em>Initiating Actor</em>'.
	 * @see org.unicase.model.requirement.UseCase#getInitiatingActor()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_InitiatingActor();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.requirement.UseCase#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Scenarios</em>'.
	 * @see org.unicase.model.requirement.UseCase#getScenarios()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_Scenarios();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.requirement.UseCase#getFunctionalRequirements <em>Functional Requirements</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the reference list '<em>Functional Requirements</em>'.
	 * @see org.unicase.model.requirement.UseCase#getFunctionalRequirements()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_FunctionalRequirements();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.requirement.UseCase#getNonFunctionalRequirements <em>Non Functional Requirements</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the reference list '<em>Non Functional Requirements</em>'.
	 * @see org.unicase.model.requirement.UseCase#getNonFunctionalRequirements()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_NonFunctionalRequirements();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.requirement.UseCase#getIdentifiedClasses
	 * <em>Identified Classes</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference list '
	 *         <em>Identified Classes</em>'.
	 * @see org.unicase.model.requirement.UseCase#getIdentifiedClasses()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_IdentifiedClasses();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.requirement.UseCase#getParticipatingActors <em>Participating Actors</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the reference list '<em>Participating Actors</em>'.
	 * @see org.unicase.model.requirement.UseCase#getParticipatingActors()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_ParticipatingActors();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.model.requirement.Scenario <em>Scenario</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Scenario</em>'.
	 * @see org.unicase.model.requirement.Scenario
	 * @generated
	 */
	EClass getScenario();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.requirement.Scenario#getSteps <em>Steps</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Steps</em>'.
	 * @see org.unicase.model.requirement.Scenario#getSteps()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Steps();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.requirement.Scenario#getInitiatingActorInstance <em>Initiating Actor Instance</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the reference '<em>Initiating Actor Instance</em>'.
	 * @see org.unicase.model.requirement.Scenario#getInitiatingActorInstance()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_InitiatingActorInstance();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.requirement.Scenario#getParticipatingActorInstances <em>Participating Actor Instances</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the reference list '<em>Participating Actor Instances</em>'.
	 * @see org.unicase.model.requirement.Scenario#getParticipatingActorInstances()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_ParticipatingActorInstances();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.requirement.Scenario#getInstantiatedUseCases <em>Instantiated Use Cases</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the reference list '<em>Instantiated Use Cases</em>'.
	 * @see org.unicase.model.requirement.Scenario#getInstantiatedUseCases()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_InstantiatedUseCases();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.requirement.Scenario#getFunctionalRequirements <em>Functional Requirements</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the reference list '<em>Functional Requirements</em>'.
	 * @see org.unicase.model.requirement.Scenario#getFunctionalRequirements()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_FunctionalRequirements();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.requirement.Scenario#getNonFunctionalRequirements <em>Non Functional Requirements</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the reference list '<em>Non Functional Requirements</em>'.
	 * @see org.unicase.model.requirement.Scenario#getNonFunctionalRequirements()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_NonFunctionalRequirements();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.model.requirement.Actor <em>Actor</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see org.unicase.model.requirement.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.requirement.Actor#getInitiatedUseCases
	 * <em>Initiated Use Cases</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference list '
	 *         <em>Initiated Use Cases</em>'.
	 * @see org.unicase.model.requirement.Actor#getInitiatedUseCases()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_InitiatedUseCases();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.requirement.Actor#getParticipatedUseCases <em>Participated Use Cases</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the reference list '<em>Participated Use Cases</em>'.
	 * @see org.unicase.model.requirement.Actor#getParticipatedUseCases()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_ParticipatedUseCases();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.requirement.Actor#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Instances</em>'.
	 * @see org.unicase.model.requirement.Actor#getInstances()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Instances();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.requirement.ActorInstance <em>Actor Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Instance</em>'.
	 * @see org.unicase.model.requirement.ActorInstance
	 * @generated
	 */
	EClass getActorInstance();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.requirement.ActorInstance#getInitiatedScenarios
	 * <em>Initiated Scenarios</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference list '
	 *         <em>Initiated Scenarios</em>'.
	 * @see org.unicase.model.requirement.ActorInstance#getInitiatedScenarios()
	 * @see #getActorInstance()
	 * @generated
	 */
	EReference getActorInstance_InitiatedScenarios();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.requirement.ActorInstance#getParticipatedScenarios <em>Participated Scenarios</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the reference list '<em>Participated Scenarios</em>'.
	 * @see org.unicase.model.requirement.ActorInstance#getParticipatedScenarios()
	 * @see #getActorInstance()
	 * @generated
	 */
	EReference getActorInstance_ParticipatedScenarios();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.unicase.model.requirement.ActorInstance#getInstantiatedActor
	 * <em>Instantiated Actor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference '<em>Instantiated Actor</em>'.
	 * @see org.unicase.model.requirement.ActorInstance#getInstantiatedActor()
	 * @see #getActorInstance()
	 * @generated
	 */
	EReference getActorInstance_InstantiatedActor();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.model.requirement.Step <em>Step</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Step</em>'.
	 * @see org.unicase.model.requirement.Step
	 * @generated
	 */
	EClass getStep();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.requirement.Step#isUserStep <em>User Step</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Step</em>'.
	 * @see org.unicase.model.requirement.Step#isUserStep()
	 * @see #getStep()
	 * @generated
	 */
	EAttribute getStep_UserStep();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RequirementFactory getRequirementFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
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
		 * The meta object literal for the '{@link org.unicase.model.requirement.impl.NonFunctionalRequirementImpl <em>Non Functional Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.requirement.impl.NonFunctionalRequirementImpl
		 * @see org.unicase.model.requirement.impl.RequirementPackageImpl#getNonFunctionalRequirement()
		 * @generated
		 */
		EClass NON_FUNCTIONAL_REQUIREMENT = eINSTANCE
				.getNonFunctionalRequirement();
		/**
		 * The meta object literal for the '<em><b>Restricted Scenarios</b></em>
		 * ' reference list feature. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @generated
		 */
		EReference NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_SCENARIOS = eINSTANCE
				.getNonFunctionalRequirement_RestrictedScenarios();
		/**
		 * The meta object literal for the '<em><b>Restricted Use Cases</b></em>
		 * ' reference list feature. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @generated
		 */
		EReference NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_USE_CASES = eINSTANCE
				.getNonFunctionalRequirement_RestrictedUseCases();
		/**
		 * The meta object literal for the '{@link org.unicase.model.requirement.impl.FunctionalRequirementImpl <em>Functional Requirement</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.unicase.model.requirement.impl.FunctionalRequirementImpl
		 * @see org.unicase.model.requirement.impl.RequirementPackageImpl#getFunctionalRequirement()
		 * @generated
		 */
		EClass FUNCTIONAL_REQUIREMENT = eINSTANCE.getFunctionalRequirement();
		/**
		 * The meta object literal for the '<em><b>Reviewed</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTIONAL_REQUIREMENT__REVIEWED = eINSTANCE
				.getFunctionalRequirement_Reviewed();
		/**
		 * The meta object literal for the '<em><b>Story Points</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTIONAL_REQUIREMENT__STORY_POINTS = eINSTANCE
				.getFunctionalRequirement_StoryPoints();
		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTIONAL_REQUIREMENT__PRIORITY = eINSTANCE
				.getFunctionalRequirement_Priority();
		/**
		 * The meta object literal for the '<em><b>Refining Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS = eINSTANCE
				.getFunctionalRequirement_RefiningRequirements();
		/**
		 * The meta object literal for the '<em><b>Refined Requirement</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT = eINSTANCE
				.getFunctionalRequirement_RefinedRequirement();
		/**
		 * The meta object literal for the '<em><b>Use Cases</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONAL_REQUIREMENT__USE_CASES = eINSTANCE
				.getFunctionalRequirement_UseCases();
		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONAL_REQUIREMENT__SCENARIOS = eINSTANCE
				.getFunctionalRequirement_Scenarios();
		/**
		 * The meta object literal for the '
		 * {@link org.unicase.model.requirement.impl.UseCaseImpl
		 * <em>Use Case</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.unicase.model.requirement.impl.UseCaseImpl
		 * @see org.unicase.model.requirement.impl.RequirementPackageImpl#getUseCase()
		 * @generated
		 */
		EClass USE_CASE = eINSTANCE.getUseCase();
		/**
		 * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__STEPS = eINSTANCE.getUseCase_Steps();
		/**
		 * The meta object literal for the '<em><b>Initiating Actor</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__INITIATING_ACTOR = eINSTANCE
				.getUseCase_InitiatingActor();
		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__SCENARIOS = eINSTANCE.getUseCase_Scenarios();
		/**
		 * The meta object literal for the '
		 * <em><b>Functional Requirements</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference USE_CASE__FUNCTIONAL_REQUIREMENTS = eINSTANCE
				.getUseCase_FunctionalRequirements();
		/**
		 * The meta object literal for the '<em><b>Non Functional Requirements</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__NON_FUNCTIONAL_REQUIREMENTS = eINSTANCE
				.getUseCase_NonFunctionalRequirements();
		/**
		 * The meta object literal for the '<em><b>Identified Classes</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__IDENTIFIED_CLASSES = eINSTANCE
				.getUseCase_IdentifiedClasses();
		/**
		 * The meta object literal for the '<em><b>Participating Actors</b></em>
		 * ' reference list feature. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @generated
		 */
		EReference USE_CASE__PARTICIPATING_ACTORS = eINSTANCE
				.getUseCase_ParticipatingActors();
		/**
		 * The meta object literal for the '
		 * {@link org.unicase.model.requirement.impl.ScenarioImpl
		 * <em>Scenario</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.unicase.model.requirement.impl.ScenarioImpl
		 * @see org.unicase.model.requirement.impl.RequirementPackageImpl#getScenario()
		 * @generated
		 */
		EClass SCENARIO = eINSTANCE.getScenario();
		/**
		 * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__STEPS = eINSTANCE.getScenario_Steps();
		/**
		 * The meta object literal for the '
		 * <em><b>Initiating Actor Instance</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SCENARIO__INITIATING_ACTOR_INSTANCE = eINSTANCE
				.getScenario_InitiatingActorInstance();
		/**
		 * The meta object literal for the '<em><b>Participating Actor Instances</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__PARTICIPATING_ACTOR_INSTANCES = eINSTANCE
				.getScenario_ParticipatingActorInstances();
		/**
		 * The meta object literal for the '
		 * <em><b>Instantiated Use Cases</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SCENARIO__INSTANTIATED_USE_CASES = eINSTANCE
				.getScenario_InstantiatedUseCases();
		/**
		 * The meta object literal for the '
		 * <em><b>Functional Requirements</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SCENARIO__FUNCTIONAL_REQUIREMENTS = eINSTANCE
				.getScenario_FunctionalRequirements();
		/**
		 * The meta object literal for the '<em><b>Non Functional Requirements</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__NON_FUNCTIONAL_REQUIREMENTS = eINSTANCE
				.getScenario_NonFunctionalRequirements();
		/**
		 * The meta object literal for the '{@link org.unicase.model.requirement.impl.ActorImpl <em>Actor</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.requirement.impl.ActorImpl
		 * @see org.unicase.model.requirement.impl.RequirementPackageImpl#getActor()
		 * @generated
		 */
		EClass ACTOR = eINSTANCE.getActor();
		/**
		 * The meta object literal for the '<em><b>Initiated Use Cases</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__INITIATED_USE_CASES = eINSTANCE
				.getActor_InitiatedUseCases();
		/**
		 * The meta object literal for the '
		 * <em><b>Participated Use Cases</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ACTOR__PARTICIPATED_USE_CASES = eINSTANCE
				.getActor_ParticipatedUseCases();
		/**
		 * The meta object literal for the '<em><b>Instances</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__INSTANCES = eINSTANCE.getActor_Instances();
		/**
		 * The meta object literal for the '{@link org.unicase.model.requirement.impl.ActorInstanceImpl <em>Actor Instance</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.unicase.model.requirement.impl.ActorInstanceImpl
		 * @see org.unicase.model.requirement.impl.RequirementPackageImpl#getActorInstance()
		 * @generated
		 */
		EClass ACTOR_INSTANCE = eINSTANCE.getActorInstance();
		/**
		 * The meta object literal for the '<em><b>Initiated Scenarios</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_INSTANCE__INITIATED_SCENARIOS = eINSTANCE
				.getActorInstance_InitiatedScenarios();
		/**
		 * The meta object literal for the '
		 * <em><b>Participated Scenarios</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ACTOR_INSTANCE__PARTICIPATED_SCENARIOS = eINSTANCE
				.getActorInstance_ParticipatedScenarios();
		/**
		 * The meta object literal for the '<em><b>Instantiated Actor</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_INSTANCE__INSTANTIATED_ACTOR = eINSTANCE
				.getActorInstance_InstantiatedActor();
		/**
		 * The meta object literal for the '{@link org.unicase.model.requirement.impl.StepImpl <em>Step</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.requirement.impl.StepImpl
		 * @see org.unicase.model.requirement.impl.RequirementPackageImpl#getStep()
		 * @generated
		 */
		EClass STEP = eINSTANCE.getStep();
		/**
		 * The meta object literal for the '<em><b>User Step</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEP__USER_STEP = eINSTANCE.getStep_UserStep();

	}

} // RequirementPackage
