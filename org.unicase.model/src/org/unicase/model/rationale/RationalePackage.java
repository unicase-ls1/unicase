/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian K�gel All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.rationale;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.unicase.model.ModelPackage;

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
 * 
 * @see org.unicase.model.rationale.RationaleFactory
 * @model kind="package"
 * @generated
 */
public interface RationalePackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "rationale";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/rationale";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.rationale";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	RationalePackage eINSTANCE = org.unicase.model.rationale.impl.RationalePackageImpl
			.init();

	/**
	 * The meta object id for the '
	 * {@link org.unicase.model.rationale.impl.IssueImpl <em>Issue</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.rationale.impl.IssueImpl
	 * @see org.unicase.model.rationale.impl.RationalePackageImpl#getIssue()
	 * @generated
	 */
	int ISSUE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISSUE__NAME = ModelPackage.ANNOTATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISSUE__DESCRIPTION = ModelPackage.ANNOTATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISSUE__IDENTIFIER = ModelPackage.ANNOTATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISSUE__READER_INFOS = ModelPackage.ANNOTATION__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISSUE__ANNOTATIONS = ModelPackage.ANNOTATION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISSUE__INCOMING_DOCUMENT_REFERENCES = ModelPackage.ANNOTATION__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISSUE__LEAF_SECTION = ModelPackage.ANNOTATION__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>Annotated Model Elements</b></em>'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISSUE__ANNOTATED_MODEL_ELEMENTS = ModelPackage.ANNOTATION__ANNOTATED_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Proposals</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISSUE__PROPOSALS = ModelPackage.ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Solution</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISSUE__SOLUTION = ModelPackage.ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Criteria</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISSUE__CRITERIA = ModelPackage.ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Refining Issues</b></em>' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISSUE__REFINING_ISSUES = ModelPackage.ANNOTATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Refined Issue</b></em>' container
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISSUE__REFINED_ISSUE = ModelPackage.ANNOTATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Facilitator</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISSUE__FACILITATOR = ModelPackage.ANNOTATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Participants</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISSUE__PARTICIPANTS = ModelPackage.ANNOTATION_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Issue</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISSUE_FEATURE_COUNT = ModelPackage.ANNOTATION_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.model.rationale.impl.ProposalImpl <em>Proposal</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.rationale.impl.ProposalImpl
	 * @see org.unicase.model.rationale.impl.RationalePackageImpl#getProposal()
	 * @generated
	 */
	int PROPOSAL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPOSAL__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPOSAL__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPOSAL__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPOSAL__READER_INFOS = ModelPackage.MODEL_ELEMENT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPOSAL__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPOSAL__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPOSAL__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>Assessments</b></em>' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPOSAL__ASSESSMENTS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Issue</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPOSAL__ISSUE = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Proposal</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPOSAL_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.model.rationale.impl.SolutionImpl <em>Solution</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.rationale.impl.SolutionImpl
	 * @see org.unicase.model.rationale.impl.RationalePackageImpl#getSolution()
	 * @generated
	 */
	int SOLUTION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOLUTION__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOLUTION__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOLUTION__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOLUTION__READER_INFOS = ModelPackage.MODEL_ELEMENT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOLUTION__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOLUTION__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOLUTION__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>Underlying Proposals</b></em>' reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOLUTION__UNDERLYING_PROPOSALS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Issue</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOLUTION__ISSUE = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Solution</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOLUTION_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.model.rationale.impl.CriterionImpl <em>Criterion</em>}
	 * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.rationale.impl.CriterionImpl
	 * @see org.unicase.model.rationale.impl.RationalePackageImpl#getCriterion()
	 * @generated
	 */
	int CRITERION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CRITERION__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CRITERION__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CRITERION__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CRITERION__READER_INFOS = ModelPackage.MODEL_ELEMENT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CRITERION__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CRITERION__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CRITERION__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>Assessments</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CRITERION__ASSESSMENTS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Criterion</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CRITERION_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.model.rationale.impl.AssessmentImpl
	 * <em>Assessment</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.unicase.model.rationale.impl.AssessmentImpl
	 * @see org.unicase.model.rationale.impl.RationalePackageImpl#getAssessment()
	 * @generated
	 */
	int ASSESSMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT__READER_INFOS = ModelPackage.MODEL_ELEMENT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>Proposal</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT__PROPOSAL = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Criterion</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT__CRITERION = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT__VALUE = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assessment</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.model.rationale.impl.CommentImpl <em>Comment</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.rationale.impl.CommentImpl
	 * @see org.unicase.model.rationale.impl.RationalePackageImpl#getComment()
	 * @generated
	 */
	int COMMENT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMENT__NAME = ModelPackage.ANNOTATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMENT__DESCRIPTION = ModelPackage.ANNOTATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMENT__IDENTIFIER = ModelPackage.ANNOTATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMENT__READER_INFOS = ModelPackage.ANNOTATION__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMENT__ANNOTATIONS = ModelPackage.ANNOTATION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMENT__INCOMING_DOCUMENT_REFERENCES = ModelPackage.ANNOTATION__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMENT__LEAF_SECTION = ModelPackage.ANNOTATION__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>Annotated Model Elements</b></em>'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMENT__ANNOTATED_MODEL_ELEMENTS = ModelPackage.ANNOTATION__ANNOTATED_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Replies</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMENT__REPLIES = ModelPackage.ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Comment</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMENT_FEATURE_COUNT = ModelPackage.ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.model.rationale.Issue <em>Issue</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Issue</em>'.
	 * @see org.unicase.model.rationale.Issue
	 * @generated
	 */
	EClass getIssue();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.model.rationale.Issue#getProposals <em>Proposals</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Proposals</em>'.
	 * @see org.unicase.model.rationale.Issue#getProposals()
	 * @see #getIssue()
	 * @generated
	 */
	EReference getIssue_Proposals();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.model.rationale.Issue#getSolution <em>Solution</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Solution</em>
	 *         '.
	 * @see org.unicase.model.rationale.Issue#getSolution()
	 * @see #getIssue()
	 * @generated
	 */
	EReference getIssue_Solution();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.rationale.Issue#getCriteria <em>Criteria</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Criteria</em>'.
	 * @see org.unicase.model.rationale.Issue#getCriteria()
	 * @see #getIssue()
	 * @generated
	 */
	EReference getIssue_Criteria();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.model.rationale.Issue#getRefiningIssues
	 * <em>Refining Issues</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Refining Issues</em>'.
	 * @see org.unicase.model.rationale.Issue#getRefiningIssues()
	 * @see #getIssue()
	 * @generated
	 */
	EReference getIssue_RefiningIssues();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.unicase.model.rationale.Issue#getRefinedIssue
	 * <em>Refined Issue</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '
	 *         <em>Refined Issue</em>'.
	 * @see org.unicase.model.rationale.Issue#getRefinedIssue()
	 * @see #getIssue()
	 * @generated
	 */
	EReference getIssue_RefinedIssue();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.unicase.model.rationale.Issue#getFacilitator
	 * <em>Facilitator</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Facilitator</em>'.
	 * @see org.unicase.model.rationale.Issue#getFacilitator()
	 * @see #getIssue()
	 * @generated
	 */
	EReference getIssue_Facilitator();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.rationale.Issue#getParticipants
	 * <em>Participants</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Participants</em>'.
	 * @see org.unicase.model.rationale.Issue#getParticipants()
	 * @see #getIssue()
	 * @generated
	 */
	EReference getIssue_Participants();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.model.rationale.Proposal <em>Proposal</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Proposal</em>'.
	 * @see org.unicase.model.rationale.Proposal
	 * @generated
	 */
	EClass getProposal();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.model.rationale.Proposal#getAssessments
	 * <em>Assessments</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Assessments</em>'.
	 * @see org.unicase.model.rationale.Proposal#getAssessments()
	 * @see #getProposal()
	 * @generated
	 */
	EReference getProposal_Assessments();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.unicase.model.rationale.Proposal#getIssue <em>Issue</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Issue</em>'.
	 * @see org.unicase.model.rationale.Proposal#getIssue()
	 * @see #getProposal()
	 * @generated
	 */
	EReference getProposal_Issue();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.model.rationale.Solution <em>Solution</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Solution</em>'.
	 * @see org.unicase.model.rationale.Solution
	 * @generated
	 */
	EClass getSolution();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.rationale.Solution#getUnderlyingProposals
	 * <em>Underlying Proposals</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the reference list '
	 *         <em>Underlying Proposals</em>'.
	 * @see org.unicase.model.rationale.Solution#getUnderlyingProposals()
	 * @see #getSolution()
	 * @generated
	 */
	EReference getSolution_UnderlyingProposals();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.unicase.model.rationale.Solution#getIssue <em>Issue</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Issue</em>'.
	 * @see org.unicase.model.rationale.Solution#getIssue()
	 * @see #getSolution()
	 * @generated
	 */
	EReference getSolution_Issue();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.model.rationale.Criterion <em>Criterion</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Criterion</em>'.
	 * @see org.unicase.model.rationale.Criterion
	 * @generated
	 */
	EClass getCriterion();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.rationale.Criterion#getAssessments
	 * <em>Assessments</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Assessments</em>'.
	 * @see org.unicase.model.rationale.Criterion#getAssessments()
	 * @see #getCriterion()
	 * @generated
	 */
	EReference getCriterion_Assessments();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.model.rationale.Assessment <em>Assessment</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Assessment</em>'.
	 * @see org.unicase.model.rationale.Assessment
	 * @generated
	 */
	EClass getAssessment();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.unicase.model.rationale.Assessment#getProposal
	 * <em>Proposal</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Proposal</em>'.
	 * @see org.unicase.model.rationale.Assessment#getProposal()
	 * @see #getAssessment()
	 * @generated
	 */
	EReference getAssessment_Proposal();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.unicase.model.rationale.Assessment#getCriterion
	 * <em>Criterion</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Criterion</em>'.
	 * @see org.unicase.model.rationale.Assessment#getCriterion()
	 * @see #getAssessment()
	 * @generated
	 */
	EReference getAssessment_Criterion();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.model.rationale.Assessment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.unicase.model.rationale.Assessment#getValue()
	 * @see #getAssessment()
	 * @generated
	 */
	EAttribute getAssessment_Value();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.model.rationale.Comment <em>Comment</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Comment</em>'.
	 * @see org.unicase.model.rationale.Comment
	 * @generated
	 */
	EClass getComment();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.rationale.Comment#getReplies <em>Replies</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Replies</em>'.
	 * @see org.unicase.model.rationale.Comment#getReplies()
	 * @see #getComment()
	 * @generated
	 */
	EReference getComment_Replies();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RationaleFactory getRationaleFactory();

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
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '
		 * {@link org.unicase.model.rationale.impl.IssueImpl <em>Issue</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.rationale.impl.IssueImpl
		 * @see org.unicase.model.rationale.impl.RationalePackageImpl#getIssue()
		 * @generated
		 */
		EClass ISSUE = eINSTANCE.getIssue();

		/**
		 * The meta object literal for the '<em><b>Proposals</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ISSUE__PROPOSALS = eINSTANCE.getIssue_Proposals();

		/**
		 * The meta object literal for the '<em><b>Solution</b></em>'
		 * containment reference feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ISSUE__SOLUTION = eINSTANCE.getIssue_Solution();

		/**
		 * The meta object literal for the '<em><b>Criteria</b></em>' reference
		 * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ISSUE__CRITERIA = eINSTANCE.getIssue_Criteria();

		/**
		 * The meta object literal for the '<em><b>Refining Issues</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ISSUE__REFINING_ISSUES = eINSTANCE.getIssue_RefiningIssues();

		/**
		 * The meta object literal for the '<em><b>Refined Issue</b></em>'
		 * container reference feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ISSUE__REFINED_ISSUE = eINSTANCE.getIssue_RefinedIssue();

		/**
		 * The meta object literal for the '<em><b>Facilitator</b></em>'
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ISSUE__FACILITATOR = eINSTANCE.getIssue_Facilitator();

		/**
		 * The meta object literal for the '<em><b>Participants</b></em>'
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ISSUE__PARTICIPANTS = eINSTANCE.getIssue_Participants();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.model.rationale.impl.ProposalImpl
		 * <em>Proposal</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.unicase.model.rationale.impl.ProposalImpl
		 * @see org.unicase.model.rationale.impl.RationalePackageImpl#getProposal()
		 * @generated
		 */
		EClass PROPOSAL = eINSTANCE.getProposal();

		/**
		 * The meta object literal for the '<em><b>Assessments</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROPOSAL__ASSESSMENTS = eINSTANCE.getProposal_Assessments();

		/**
		 * The meta object literal for the '<em><b>Issue</b></em>' container
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROPOSAL__ISSUE = eINSTANCE.getProposal_Issue();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.model.rationale.impl.SolutionImpl
		 * <em>Solution</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.unicase.model.rationale.impl.SolutionImpl
		 * @see org.unicase.model.rationale.impl.RationalePackageImpl#getSolution()
		 * @generated
		 */
		EClass SOLUTION = eINSTANCE.getSolution();

		/**
		 * The meta object literal for the '<em><b>Underlying Proposals</b></em>
		 * ' reference list feature. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @generated
		 */
		EReference SOLUTION__UNDERLYING_PROPOSALS = eINSTANCE
				.getSolution_UnderlyingProposals();

		/**
		 * The meta object literal for the '<em><b>Issue</b></em>' container
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SOLUTION__ISSUE = eINSTANCE.getSolution_Issue();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.model.rationale.impl.CriterionImpl
		 * <em>Criterion</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.unicase.model.rationale.impl.CriterionImpl
		 * @see org.unicase.model.rationale.impl.RationalePackageImpl#getCriterion()
		 * @generated
		 */
		EClass CRITERION = eINSTANCE.getCriterion();

		/**
		 * The meta object literal for the '<em><b>Assessments</b></em>'
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CRITERION__ASSESSMENTS = eINSTANCE
				.getCriterion_Assessments();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.model.rationale.impl.AssessmentImpl
		 * <em>Assessment</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.unicase.model.rationale.impl.AssessmentImpl
		 * @see org.unicase.model.rationale.impl.RationalePackageImpl#getAssessment()
		 * @generated
		 */
		EClass ASSESSMENT = eINSTANCE.getAssessment();

		/**
		 * The meta object literal for the '<em><b>Proposal</b></em>' container
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ASSESSMENT__PROPOSAL = eINSTANCE.getAssessment_Proposal();

		/**
		 * The meta object literal for the '<em><b>Criterion</b></em>' reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ASSESSMENT__CRITERION = eINSTANCE.getAssessment_Criterion();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ASSESSMENT__VALUE = eINSTANCE.getAssessment_Value();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.model.rationale.impl.CommentImpl <em>Comment</em>}
		 * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.rationale.impl.CommentImpl
		 * @see org.unicase.model.rationale.impl.RationalePackageImpl#getComment()
		 * @generated
		 */
		EClass COMMENT = eINSTANCE.getComment();

		/**
		 * The meta object literal for the '<em><b>Replies</b></em>' reference
		 * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMMENT__REPLIES = eINSTANCE.getComment_Replies();

	}

} // RationalePackage
