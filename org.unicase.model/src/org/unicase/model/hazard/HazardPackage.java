/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.model.hazard;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.unicase.model.ModelPackage;

/*
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul> <li>each class,</li> <li>each feature of each class,</li> <li>each enum,</li> <li>and each data type</li> </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.model.hazard.HazardFactory
 * @model kind="package"
 * @generated
 */
public interface HazardPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "hazard";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/hazard";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.hazard";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	HazardPackage eINSTANCE = org.unicase.model.hazard.impl.HazardPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.hazard.impl.HazardImpl <em>Hazard</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.hazard.impl.HazardImpl
	 * @see org.unicase.model.hazard.impl.HazardPackageImpl#getHazard()
	 * @generated
	 */
	int HAZARD = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__CREATOR = ModelPackage.MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__CREATION_DATE = ModelPackage.MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARD__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARD__ATTACHMENTS = ModelPackage.MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__STATE = ModelPackage.MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARD__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__SEVERITY = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Involved Classes</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__INVOLVED_CLASSES = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Targeted Actors</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__TARGETED_ACTORS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD__CAUSES = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Mitigations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARD__MITIGATIONS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Hazard</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.unicase.model.hazard.impl.MitigationImpl <em>Mitigation</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.hazard.impl.MitigationImpl
	 * @see org.unicase.model.hazard.impl.HazardPackageImpl#getMitigation()
	 * @generated
	 */
	int MITIGATION = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__CREATOR = ModelPackage.MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__CREATION_DATE = ModelPackage.MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MITIGATION__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MITIGATION__ATTACHMENTS = ModelPackage.MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__STATE = ModelPackage.MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MITIGATION__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Technique</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__TECHNIQUE = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Evaluation Status</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MITIGATION__EVALUATION_STATUS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__CAUSES = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Hazards</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__HAZARDS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MITIGATION__REQUIREMENTS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Mitigation</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MITIGATION_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.unicase.model.hazard.impl.HazardCauseImpl <em>Cause</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.hazard.impl.HazardCauseImpl
	 * @see org.unicase.model.hazard.impl.HazardPackageImpl#getHazardCause()
	 * @generated
	 */
	int HAZARD_CAUSE = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD_CAUSE__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD_CAUSE__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD_CAUSE__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD_CAUSE__CREATOR = ModelPackage.MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD_CAUSE__CREATION_DATE = ModelPackage.MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARD_CAUSE__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARD_CAUSE__ATTACHMENTS = ModelPackage.MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD_CAUSE__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD_CAUSE__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD_CAUSE__STATE = ModelPackage.MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARD_CAUSE__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Hazards</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD_CAUSE__HAZARDS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Hazardous Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD_CAUSE__HAZARDOUS_MODEL_ELEMENTS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Evaluation Status</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARD_CAUSE__EVALUATION_STATUS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Likelihood</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD_CAUSE__LIKELIHOOD = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Mitigations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARD_CAUSE__MITIGATIONS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Cause</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAZARD_CAUSE_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.unicase.model.hazard.EvalStatus <em>Eval Status</em>}' enum. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.hazard.EvalStatus
	 * @see org.unicase.model.hazard.impl.HazardPackageImpl#getEvalStatus()
	 * @generated
	 */
	int EVAL_STATUS = 3;

	/**
	 * Returns the meta object for class '{@link org.unicase.model.hazard.Hazard <em>Hazard</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hazard</em>'.
	 * @see org.unicase.model.hazard.Hazard
	 * @generated
	 */
	EClass getHazard();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.hazard.Hazard#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.unicase.model.hazard.Hazard#getSeverity()
	 * @see #getHazard()
	 * @generated
	 */
	EAttribute getHazard_Severity();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.hazard.Hazard#getInvolvedClasses <em>Involved Classes</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Involved Classes</em>'.
	 * @see org.unicase.model.hazard.Hazard#getInvolvedClasses()
	 * @see #getHazard()
	 * @generated
	 */
	EReference getHazard_InvolvedClasses();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.hazard.Hazard#getTargetedActors <em>Targeted Actors</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Targeted Actors</em>'.
	 * @see org.unicase.model.hazard.Hazard#getTargetedActors()
	 * @see #getHazard()
	 * @generated
	 */
	EReference getHazard_TargetedActors();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.hazard.Hazard#getCauses <em>Causes</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Causes</em>'.
	 * @see org.unicase.model.hazard.Hazard#getCauses()
	 * @see #getHazard()
	 * @generated
	 */
	EReference getHazard_Causes();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.hazard.Hazard#getMitigations <em>Mitigations</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mitigations</em>'.
	 * @see org.unicase.model.hazard.Hazard#getMitigations()
	 * @see #getHazard()
	 * @generated
	 */
	EReference getHazard_Mitigations();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.hazard.Mitigation <em>Mitigation</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Mitigation</em>'.
	 * @see org.unicase.model.hazard.Mitigation
	 * @generated
	 */
	EClass getMitigation();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.hazard.Mitigation#getTechnique <em>Technique</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Technique</em>'.
	 * @see org.unicase.model.hazard.Mitigation#getTechnique()
	 * @see #getMitigation()
	 * @generated
	 */
	EAttribute getMitigation_Technique();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.hazard.Mitigation#getEvaluationStatus <em>Evaluation Status</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Evaluation Status</em>'.
	 * @see org.unicase.model.hazard.Mitigation#getEvaluationStatus()
	 * @see #getMitigation()
	 * @generated
	 */
	EAttribute getMitigation_EvaluationStatus();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.hazard.Mitigation#getCauses <em>Causes</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Causes</em>'.
	 * @see org.unicase.model.hazard.Mitigation#getCauses()
	 * @see #getMitigation()
	 * @generated
	 */
	EReference getMitigation_Causes();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.hazard.Mitigation#getHazards <em>Hazards</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Hazards</em>'.
	 * @see org.unicase.model.hazard.Mitigation#getHazards()
	 * @see #getMitigation()
	 * @generated
	 */
	EReference getMitigation_Hazards();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.hazard.Mitigation#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requirements</em>'.
	 * @see org.unicase.model.hazard.Mitigation#getRequirements()
	 * @see #getMitigation()
	 * @generated
	 */
	EReference getMitigation_Requirements();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.hazard.HazardCause <em>Cause</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Cause</em>'.
	 * @see org.unicase.model.hazard.HazardCause
	 * @generated
	 */
	EClass getHazardCause();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.hazard.HazardCause#getHazards <em>Hazards</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Hazards</em>'.
	 * @see org.unicase.model.hazard.HazardCause#getHazards()
	 * @see #getHazardCause()
	 * @generated
	 */
	EReference getHazardCause_Hazards();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.hazard.HazardCause#getHazardousModelElements <em>Hazardous Model Elements</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Hazardous Model Elements</em>'.
	 * @see org.unicase.model.hazard.HazardCause#getHazardousModelElements()
	 * @see #getHazardCause()
	 * @generated
	 */
	EReference getHazardCause_HazardousModelElements();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.hazard.HazardCause#getEvaluationStatus <em>Evaluation Status</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Evaluation Status</em>'.
	 * @see org.unicase.model.hazard.HazardCause#getEvaluationStatus()
	 * @see #getHazardCause()
	 * @generated
	 */
	EAttribute getHazardCause_EvaluationStatus();

	/**
	 * Returns the meta object for the attribute list '{@link org.unicase.model.hazard.HazardCause#getLikelihood <em>Likelihood</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Likelihood</em>'.
	 * @see org.unicase.model.hazard.HazardCause#getLikelihood()
	 * @see #getHazardCause()
	 * @generated
	 */
	EAttribute getHazardCause_Likelihood();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.hazard.HazardCause#getMitigations <em>Mitigations</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mitigations</em>'.
	 * @see org.unicase.model.hazard.HazardCause#getMitigations()
	 * @see #getHazardCause()
	 * @generated
	 */
	EReference getHazardCause_Mitigations();

	/**
	 * Returns the meta object for enum '{@link org.unicase.model.hazard.EvalStatus <em>Eval Status</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Eval Status</em>'.
	 * @see org.unicase.model.hazard.EvalStatus
	 * @generated
	 */
	EEnum getEvalStatus();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HazardFactory getHazardFactory();

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
		 * The meta object literal for the '{@link org.unicase.model.hazard.impl.HazardImpl <em>Hazard</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.hazard.impl.HazardImpl
		 * @see org.unicase.model.hazard.impl.HazardPackageImpl#getHazard()
		 * @generated
		 */
		EClass HAZARD = eINSTANCE.getHazard();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute HAZARD__SEVERITY = eINSTANCE.getHazard_Severity();

		/**
		 * The meta object literal for the '<em><b>Involved Classes</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HAZARD__INVOLVED_CLASSES = eINSTANCE.getHazard_InvolvedClasses();

		/**
		 * The meta object literal for the '<em><b>Targeted Actors</b></em>' reference list feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAZARD__TARGETED_ACTORS = eINSTANCE.getHazard_TargetedActors();

		/**
		 * The meta object literal for the '<em><b>Causes</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference HAZARD__CAUSES = eINSTANCE.getHazard_Causes();

		/**
		 * The meta object literal for the '<em><b>Mitigations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAZARD__MITIGATIONS = eINSTANCE.getHazard_Mitigations();

		/**
		 * The meta object literal for the '{@link org.unicase.model.hazard.impl.MitigationImpl <em>Mitigation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.hazard.impl.MitigationImpl
		 * @see org.unicase.model.hazard.impl.HazardPackageImpl#getMitigation()
		 * @generated
		 */
		EClass MITIGATION = eINSTANCE.getMitigation();

		/**
		 * The meta object literal for the '<em><b>Technique</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute MITIGATION__TECHNIQUE = eINSTANCE.getMitigation_Technique();

		/**
		 * The meta object literal for the '<em><b>Evaluation Status</b></em>' attribute feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MITIGATION__EVALUATION_STATUS = eINSTANCE.getMitigation_EvaluationStatus();

		/**
		 * The meta object literal for the '<em><b>Causes</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference MITIGATION__CAUSES = eINSTANCE.getMitigation_Causes();

		/**
		 * The meta object literal for the '<em><b>Hazards</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MITIGATION__HAZARDS = eINSTANCE.getMitigation_Hazards();

		/**
		 * The meta object literal for the '<em><b>Requirements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MITIGATION__REQUIREMENTS = eINSTANCE.getMitigation_Requirements();

		/**
		 * The meta object literal for the '{@link org.unicase.model.hazard.impl.HazardCauseImpl <em>Cause</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.hazard.impl.HazardCauseImpl
		 * @see org.unicase.model.hazard.impl.HazardPackageImpl#getHazardCause()
		 * @generated
		 */
		EClass HAZARD_CAUSE = eINSTANCE.getHazardCause();

		/**
		 * The meta object literal for the '<em><b>Hazards</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAZARD_CAUSE__HAZARDS = eINSTANCE.getHazardCause_Hazards();

		/**
		 * The meta object literal for the '<em><b>Hazardous Model Elements</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HAZARD_CAUSE__HAZARDOUS_MODEL_ELEMENTS = eINSTANCE.getHazardCause_HazardousModelElements();

		/**
		 * The meta object literal for the '<em><b>Evaluation Status</b></em>' attribute feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HAZARD_CAUSE__EVALUATION_STATUS = eINSTANCE.getHazardCause_EvaluationStatus();

		/**
		 * The meta object literal for the '<em><b>Likelihood</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HAZARD_CAUSE__LIKELIHOOD = eINSTANCE.getHazardCause_Likelihood();

		/**
		 * The meta object literal for the '<em><b>Mitigations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAZARD_CAUSE__MITIGATIONS = eINSTANCE.getHazardCause_Mitigations();

		/**
		 * The meta object literal for the '{@link org.unicase.model.hazard.EvalStatus <em>Eval Status</em>}' enum. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.hazard.EvalStatus
		 * @see org.unicase.model.hazard.impl.HazardPackageImpl#getEvalStatus()
		 * @generated
		 */
		EEnum EVAL_STATUS = eINSTANCE.getEvalStatus();

	}

} // HazardPackage
