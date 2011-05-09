/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.usecase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.unicase.model.ModelPackage;

import org.unicase.model.requirement.RequirementPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.model.usecase.UsecaseFactory
 * @model kind="package"
 * @generated
 */
public interface UsecasePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "usecase";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/usecase";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.usecase";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UsecasePackage eINSTANCE = org.unicase.model.usecase.impl.UsecasePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.usecase.impl.UseCaseImpl <em>Use Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.usecase.impl.UseCaseImpl
	 * @see org.unicase.model.usecase.impl.UsecasePackageImpl#getUseCase()
	 * @generated
	 */
	int USE_CASE = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__IDENTIFIER = RequirementPackage.USE_CASE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__CREATOR = RequirementPackage.USE_CASE__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__CREATION_DATE = RequirementPackage.USE_CASE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__NAME = RequirementPackage.USE_CASE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__DESCRIPTION = RequirementPackage.USE_CASE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__ANNOTATIONS = RequirementPackage.USE_CASE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__ATTACHMENTS = RequirementPackage.USE_CASE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__INCOMING_DOCUMENT_REFERENCES = RequirementPackage.USE_CASE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__LEAF_SECTION = RequirementPackage.USE_CASE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__STATE = RequirementPackage.USE_CASE__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__APPLIED_STEREOTYPE_INSTANCES = RequirementPackage.USE_CASE__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__COMMENTS = RequirementPackage.USE_CASE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Initiating Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__INITIATING_ACTOR = RequirementPackage.USE_CASE__INITIATING_ACTOR;

	/**
	 * The feature id for the '<em><b>Participating Actors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__PARTICIPATING_ACTORS = RequirementPackage.USE_CASE__PARTICIPATING_ACTORS;

	/**
	 * The feature id for the '<em><b>Realized User Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__REALIZED_USER_TASK = RequirementPackage.USE_CASE__REALIZED_USER_TASK;

	/**
	 * The feature id for the '<em><b>Precondition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__PRECONDITION = RequirementPackage.USE_CASE__PRECONDITION;

	/**
	 * The feature id for the '<em><b>Use Case Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__USE_CASE_STEPS = RequirementPackage.USE_CASE__USE_CASE_STEPS;

	/**
	 * The feature id for the '<em><b>Postcondition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__POSTCONDITION = RequirementPackage.USE_CASE__POSTCONDITION;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__RULES = RequirementPackage.USE_CASE__RULES;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__EXCEPTION = RequirementPackage.USE_CASE__EXCEPTION;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__SCENARIOS = RequirementPackage.USE_CASE__SCENARIOS;

	/**
	 * The feature id for the '<em><b>Functional Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__FUNCTIONAL_REQUIREMENTS = RequirementPackage.USE_CASE__FUNCTIONAL_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Non Functional Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__NON_FUNCTIONAL_REQUIREMENTS = RequirementPackage.USE_CASE__NON_FUNCTIONAL_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Identified Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__IDENTIFIED_CLASSES = RequirementPackage.USE_CASE__IDENTIFIED_CLASSES;

	/**
	 * The feature id for the '<em><b>Included Use Cases</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__INCLUDED_USE_CASES = RequirementPackage.USE_CASE__INCLUDED_USE_CASES;

	/**
	 * The feature id for the '<em><b>Extended Use Cases</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__EXTENDED_USE_CASES = RequirementPackage.USE_CASE__EXTENDED_USE_CASES;

	/**
	 * The feature id for the '<em><b>System Functions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__SYSTEM_FUNCTIONS = RequirementPackage.USE_CASE__SYSTEM_FUNCTIONS;

	/**
	 * The feature id for the '<em><b>Actor Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__ACTOR_STEPS = RequirementPackage.USE_CASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>System Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__SYSTEM_STEPS = RequirementPackage.USE_CASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Precon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__PRECON = RequirementPackage.USE_CASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Postcon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__POSTCON = RequirementPackage.USE_CASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Rul</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__RUL = RequirementPackage.USE_CASE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Exc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__EXC = RequirementPackage.USE_CASE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Sync</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__SYNC = RequirementPackage.USE_CASE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Use Cases</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__USE_CASES = RequirementPackage.USE_CASE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Use Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_FEATURE_COUNT = RequirementPackage.USE_CASE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.unicase.model.usecase.impl.OptionImpl <em>Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.usecase.impl.OptionImpl
	 * @see org.unicase.model.usecase.impl.UsecasePackageImpl#getOption()
	 * @generated
	 */
	int OPTION = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__IDENTIFIER = ModelPackage.UNICASE_MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__CREATOR = ModelPackage.UNICASE_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__CREATION_DATE = ModelPackage.UNICASE_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__NAME = ModelPackage.UNICASE_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__DESCRIPTION = ModelPackage.UNICASE_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__ANNOTATIONS = ModelPackage.UNICASE_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__ATTACHMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__INCOMING_DOCUMENT_REFERENCES = ModelPackage.UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__LEAF_SECTION = ModelPackage.UNICASE_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__STATE = ModelPackage.UNICASE_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__COMMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Target Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__TARGET_STEP = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Step</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__SOURCE_STEP = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Included Use Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__INCLUDED_USE_CASE = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_FEATURE_COUNT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.model.usecase.impl.ActorStepImpl <em>Actor Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.usecase.impl.ActorStepImpl
	 * @see org.unicase.model.usecase.impl.UsecasePackageImpl#getActorStep()
	 * @generated
	 */
	int ACTOR_STEP = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP__IDENTIFIER = ModelPackage.UNICASE_MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP__CREATOR = ModelPackage.UNICASE_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP__CREATION_DATE = ModelPackage.UNICASE_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP__NAME = ModelPackage.UNICASE_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP__DESCRIPTION = ModelPackage.UNICASE_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP__ANNOTATIONS = ModelPackage.UNICASE_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP__ATTACHMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP__INCOMING_DOCUMENT_REFERENCES = ModelPackage.UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP__LEAF_SECTION = ModelPackage.UNICASE_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP__STATE = ModelPackage.UNICASE_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP__COMMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP__OPTIONS = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP__USE_CASE = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Actor Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STEP_FEATURE_COUNT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.model.usecase.impl.SystemStepImpl <em>System Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.usecase.impl.SystemStepImpl
	 * @see org.unicase.model.usecase.impl.UsecasePackageImpl#getSystemStep()
	 * @generated
	 */
	int SYSTEM_STEP = 3;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_STEP__IDENTIFIER = ModelPackage.UNICASE_MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_STEP__CREATOR = ModelPackage.UNICASE_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_STEP__CREATION_DATE = ModelPackage.UNICASE_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_STEP__NAME = ModelPackage.UNICASE_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_STEP__DESCRIPTION = ModelPackage.UNICASE_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_STEP__ANNOTATIONS = ModelPackage.UNICASE_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_STEP__ATTACHMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_STEP__INCOMING_DOCUMENT_REFERENCES = ModelPackage.UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_STEP__LEAF_SECTION = ModelPackage.UNICASE_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_STEP__STATE = ModelPackage.UNICASE_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_STEP__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_STEP__COMMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_STEP__EXCEPTION = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Included System Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_STEP__INCLUDED_SYSTEM_FUNCTION = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Linked Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_STEP__LINKED_STEP = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_STEP__USE_CASE = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>System Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_STEP_FEATURE_COUNT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link org.unicase.model.usecase.UseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case</em>'.
	 * @see org.unicase.model.usecase.UseCase
	 * @generated
	 */
	EClass getUseCase();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.usecase.UseCase#getActorSteps <em>Actor Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actor Steps</em>'.
	 * @see org.unicase.model.usecase.UseCase#getActorSteps()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_ActorSteps();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.usecase.UseCase#getSystemSteps <em>System Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>System Steps</em>'.
	 * @see org.unicase.model.usecase.UseCase#getSystemSteps()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_SystemSteps();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.usecase.UseCase#getPrecon <em>Precon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Precon</em>'.
	 * @see org.unicase.model.usecase.UseCase#getPrecon()
	 * @see #getUseCase()
	 * @generated
	 */
	EAttribute getUseCase_Precon();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.usecase.UseCase#getPostcon <em>Postcon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Postcon</em>'.
	 * @see org.unicase.model.usecase.UseCase#getPostcon()
	 * @see #getUseCase()
	 * @generated
	 */
	EAttribute getUseCase_Postcon();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.usecase.UseCase#getRul <em>Rul</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rul</em>'.
	 * @see org.unicase.model.usecase.UseCase#getRul()
	 * @see #getUseCase()
	 * @generated
	 */
	EAttribute getUseCase_Rul();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.usecase.UseCase#getExc <em>Exc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exc</em>'.
	 * @see org.unicase.model.usecase.UseCase#getExc()
	 * @see #getUseCase()
	 * @generated
	 */
	EAttribute getUseCase_Exc();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.usecase.UseCase#getSync <em>Sync</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sync</em>'.
	 * @see org.unicase.model.usecase.UseCase#getSync()
	 * @see #getUseCase()
	 * @generated
	 */
	EAttribute getUseCase_Sync();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.usecase.UseCase#getUseCases <em>Use Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Use Cases</em>'.
	 * @see org.unicase.model.usecase.UseCase#getUseCases()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_UseCases();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.usecase.Option <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option</em>'.
	 * @see org.unicase.model.usecase.Option
	 * @generated
	 */
	EClass getOption();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.usecase.Option#getTargetStep <em>Target Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Step</em>'.
	 * @see org.unicase.model.usecase.Option#getTargetStep()
	 * @see #getOption()
	 * @generated
	 */
	EReference getOption_TargetStep();

	/**
	 * Returns the meta object for the container reference '{@link org.unicase.model.usecase.Option#getSourceStep <em>Source Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source Step</em>'.
	 * @see org.unicase.model.usecase.Option#getSourceStep()
	 * @see #getOption()
	 * @generated
	 */
	EReference getOption_SourceStep();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.usecase.Option#getIncludedUseCase <em>Included Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Included Use Case</em>'.
	 * @see org.unicase.model.usecase.Option#getIncludedUseCase()
	 * @see #getOption()
	 * @generated
	 */
	EReference getOption_IncludedUseCase();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.usecase.ActorStep <em>Actor Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Step</em>'.
	 * @see org.unicase.model.usecase.ActorStep
	 * @generated
	 */
	EClass getActorStep();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.usecase.ActorStep#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Options</em>'.
	 * @see org.unicase.model.usecase.ActorStep#getOptions()
	 * @see #getActorStep()
	 * @generated
	 */
	EReference getActorStep_Options();

	/**
	 * Returns the meta object for the container reference '{@link org.unicase.model.usecase.ActorStep#getUseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Use Case</em>'.
	 * @see org.unicase.model.usecase.ActorStep#getUseCase()
	 * @see #getActorStep()
	 * @generated
	 */
	EReference getActorStep_UseCase();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.usecase.SystemStep <em>System Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Step</em>'.
	 * @see org.unicase.model.usecase.SystemStep
	 * @generated
	 */
	EClass getSystemStep();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.usecase.SystemStep#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception</em>'.
	 * @see org.unicase.model.usecase.SystemStep#getException()
	 * @see #getSystemStep()
	 * @generated
	 */
	EAttribute getSystemStep_Exception();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.usecase.SystemStep#getIncludedSystemFunction <em>Included System Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Included System Function</em>'.
	 * @see org.unicase.model.usecase.SystemStep#getIncludedSystemFunction()
	 * @see #getSystemStep()
	 * @generated
	 */
	EReference getSystemStep_IncludedSystemFunction();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.usecase.SystemStep#getLinkedStep <em>Linked Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Linked Step</em>'.
	 * @see org.unicase.model.usecase.SystemStep#getLinkedStep()
	 * @see #getSystemStep()
	 * @generated
	 */
	EReference getSystemStep_LinkedStep();

	/**
	 * Returns the meta object for the container reference '{@link org.unicase.model.usecase.SystemStep#getUseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Use Case</em>'.
	 * @see org.unicase.model.usecase.SystemStep#getUseCase()
	 * @see #getSystemStep()
	 * @generated
	 */
	EReference getSystemStep_UseCase();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UsecaseFactory getUsecaseFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.model.usecase.impl.UseCaseImpl <em>Use Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.usecase.impl.UseCaseImpl
		 * @see org.unicase.model.usecase.impl.UsecasePackageImpl#getUseCase()
		 * @generated
		 */
		EClass USE_CASE = eINSTANCE.getUseCase();

		/**
		 * The meta object literal for the '<em><b>Actor Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__ACTOR_STEPS = eINSTANCE.getUseCase_ActorSteps();

		/**
		 * The meta object literal for the '<em><b>System Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__SYSTEM_STEPS = eINSTANCE.getUseCase_SystemSteps();

		/**
		 * The meta object literal for the '<em><b>Precon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CASE__PRECON = eINSTANCE.getUseCase_Precon();

		/**
		 * The meta object literal for the '<em><b>Postcon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CASE__POSTCON = eINSTANCE.getUseCase_Postcon();

		/**
		 * The meta object literal for the '<em><b>Rul</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CASE__RUL = eINSTANCE.getUseCase_Rul();

		/**
		 * The meta object literal for the '<em><b>Exc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CASE__EXC = eINSTANCE.getUseCase_Exc();

		/**
		 * The meta object literal for the '<em><b>Sync</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CASE__SYNC = eINSTANCE.getUseCase_Sync();

		/**
		 * The meta object literal for the '<em><b>Use Cases</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__USE_CASES = eINSTANCE.getUseCase_UseCases();

		/**
		 * The meta object literal for the '{@link org.unicase.model.usecase.impl.OptionImpl <em>Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.usecase.impl.OptionImpl
		 * @see org.unicase.model.usecase.impl.UsecasePackageImpl#getOption()
		 * @generated
		 */
		EClass OPTION = eINSTANCE.getOption();

		/**
		 * The meta object literal for the '<em><b>Target Step</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTION__TARGET_STEP = eINSTANCE.getOption_TargetStep();

		/**
		 * The meta object literal for the '<em><b>Source Step</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTION__SOURCE_STEP = eINSTANCE.getOption_SourceStep();

		/**
		 * The meta object literal for the '<em><b>Included Use Case</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTION__INCLUDED_USE_CASE = eINSTANCE.getOption_IncludedUseCase();

		/**
		 * The meta object literal for the '{@link org.unicase.model.usecase.impl.ActorStepImpl <em>Actor Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.usecase.impl.ActorStepImpl
		 * @see org.unicase.model.usecase.impl.UsecasePackageImpl#getActorStep()
		 * @generated
		 */
		EClass ACTOR_STEP = eINSTANCE.getActorStep();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_STEP__OPTIONS = eINSTANCE.getActorStep_Options();

		/**
		 * The meta object literal for the '<em><b>Use Case</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_STEP__USE_CASE = eINSTANCE.getActorStep_UseCase();

		/**
		 * The meta object literal for the '{@link org.unicase.model.usecase.impl.SystemStepImpl <em>System Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.usecase.impl.SystemStepImpl
		 * @see org.unicase.model.usecase.impl.UsecasePackageImpl#getSystemStep()
		 * @generated
		 */
		EClass SYSTEM_STEP = eINSTANCE.getSystemStep();

		/**
		 * The meta object literal for the '<em><b>Exception</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_STEP__EXCEPTION = eINSTANCE.getSystemStep_Exception();

		/**
		 * The meta object literal for the '<em><b>Included System Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_STEP__INCLUDED_SYSTEM_FUNCTION = eINSTANCE.getSystemStep_IncludedSystemFunction();

		/**
		 * The meta object literal for the '<em><b>Linked Step</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_STEP__LINKED_STEP = eINSTANCE.getSystemStep_LinkedStep();

		/**
		 * The meta object literal for the '<em><b>Use Case</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_STEP__USE_CASE = eINSTANCE.getSystemStep_UseCase();

	}

} //UsecasePackage
