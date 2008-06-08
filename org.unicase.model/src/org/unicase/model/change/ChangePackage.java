/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.change;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.unicase.model.ModelPackage;
import org.unicase.model.rationale.RationalePackage;

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
 * @see org.unicase.model.change.ChangeFactory
 * @model kind="package"
 * @generated
 */
public interface ChangePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "change";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/change";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.rationale";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ChangePackage eINSTANCE = org.unicase.model.change.impl.ChangePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.change.impl.ModelChangePackageImpl <em>Model Change Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.change.impl.ModelChangePackageImpl
	 * @see org.unicase.model.change.impl.ChangePackageImpl#getModelChangePackage()
	 * @generated
	 */
	int MODEL_CHANGE_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__READER_INFOS = ModelPackage.MODEL_ELEMENT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Action Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__ACTION_ITEMS = ModelPackage.MODEL_ELEMENT__ACTION_ITEMS;

	/**
	 * The feature id for the '<em><b>Source Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__SOURCE_VERSION = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__TARGET_VERSION = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model Change Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.unicase.model.change.impl.MergingIssueImpl <em>Merging Issue</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.change.impl.MergingIssueImpl
	 * @see org.unicase.model.change.impl.ChangePackageImpl#getMergingIssue()
	 * @generated
	 */
	int MERGING_ISSUE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__NAME = RationalePackage.ISSUE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__DESCRIPTION = RationalePackage.ISSUE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__IDENTIFIER = RationalePackage.ISSUE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__READER_INFOS = RationalePackage.ISSUE__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Action Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__ACTION_ITEMS = RationalePackage.ISSUE__ACTION_ITEMS;

	/**
	 * The feature id for the '<em><b>Proposals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__PROPOSALS = RationalePackage.ISSUE__PROPOSALS;

	/**
	 * The feature id for the '<em><b>Solution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__SOLUTION = RationalePackage.ISSUE__SOLUTION;

	/**
	 * The feature id for the '<em><b>Criteria</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__CRITERIA = RationalePackage.ISSUE__CRITERIA;

	/**
	 * The feature id for the '<em><b>Refining Issues</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__REFINING_ISSUES = RationalePackage.ISSUE__REFINING_ISSUES;

	/**
	 * The feature id for the '<em><b>Refined Issue</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__REFINED_ISSUE = RationalePackage.ISSUE__REFINED_ISSUE;

	/**
	 * The feature id for the '<em><b>Resolving Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__RESOLVING_REVISION = RationalePackage.ISSUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Merging Issue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE_FEATURE_COUNT = RationalePackage.ISSUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.model.change.impl.MergingProposalImpl <em>Merging Proposal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.change.impl.MergingProposalImpl
	 * @see org.unicase.model.change.impl.ChangePackageImpl#getMergingProposal()
	 * @generated
	 */
	int MERGING_PROPOSAL = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__NAME = RationalePackage.PROPOSAL__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__DESCRIPTION = RationalePackage.PROPOSAL__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__IDENTIFIER = RationalePackage.PROPOSAL__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__READER_INFOS = RationalePackage.PROPOSAL__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Action Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__ACTION_ITEMS = RationalePackage.PROPOSAL__ACTION_ITEMS;

	/**
	 * The feature id for the '<em><b>Assessments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__ASSESSMENTS = RationalePackage.PROPOSAL__ASSESSMENTS;

	/**
	 * The feature id for the '<em><b>Conflicting Proposals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__CONFLICTING_PROPOSALS = RationalePackage.PROPOSAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pending Changes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__PENDING_CHANGES = RationalePackage.PROPOSAL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Merging Proposal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL_FEATURE_COUNT = RationalePackage.PROPOSAL_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.unicase.model.change.ModelChangePackage <em>Model Change Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Change Package</em>'.
	 * @see org.unicase.model.change.ModelChangePackage
	 * @generated
	 */
	EClass getModelChangePackage();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.change.ModelChangePackage#getSourceVersion <em>Source Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Version</em>'.
	 * @see org.unicase.model.change.ModelChangePackage#getSourceVersion()
	 * @see #getModelChangePackage()
	 * @generated
	 */
	EAttribute getModelChangePackage_SourceVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.change.ModelChangePackage#getTargetVersion <em>Target Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Version</em>'.
	 * @see org.unicase.model.change.ModelChangePackage#getTargetVersion()
	 * @see #getModelChangePackage()
	 * @generated
	 */
	EAttribute getModelChangePackage_TargetVersion();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.change.MergingIssue <em>Merging Issue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Merging Issue</em>'.
	 * @see org.unicase.model.change.MergingIssue
	 * @generated
	 */
	EClass getMergingIssue();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.change.MergingIssue#getResolvingRevision <em>Resolving Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolving Revision</em>'.
	 * @see org.unicase.model.change.MergingIssue#getResolvingRevision()
	 * @see #getMergingIssue()
	 * @generated
	 */
	EAttribute getMergingIssue_ResolvingRevision();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.change.MergingProposal <em>Merging Proposal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Merging Proposal</em>'.
	 * @see org.unicase.model.change.MergingProposal
	 * @generated
	 */
	EClass getMergingProposal();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.change.MergingProposal#getConflictingProposals <em>Conflicting Proposals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Conflicting Proposals</em>'.
	 * @see org.unicase.model.change.MergingProposal#getConflictingProposals()
	 * @see #getMergingProposal()
	 * @generated
	 */
	EReference getMergingProposal_ConflictingProposals();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.change.MergingProposal#getPendingChanges <em>Pending Changes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pending Changes</em>'.
	 * @see org.unicase.model.change.MergingProposal#getPendingChanges()
	 * @see #getMergingProposal()
	 * @generated
	 */
	EReference getMergingProposal_PendingChanges();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ChangeFactory getChangeFactory();

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
		 * The meta object literal for the '{@link org.unicase.model.change.impl.ModelChangePackageImpl <em>Model Change Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.change.impl.ModelChangePackageImpl
		 * @see org.unicase.model.change.impl.ChangePackageImpl#getModelChangePackage()
		 * @generated
		 */
		EClass MODEL_CHANGE_PACKAGE = eINSTANCE.getModelChangePackage();

		/**
		 * The meta object literal for the '<em><b>Source Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CHANGE_PACKAGE__SOURCE_VERSION = eINSTANCE.getModelChangePackage_SourceVersion();

		/**
		 * The meta object literal for the '<em><b>Target Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CHANGE_PACKAGE__TARGET_VERSION = eINSTANCE.getModelChangePackage_TargetVersion();

		/**
		 * The meta object literal for the '{@link org.unicase.model.change.impl.MergingIssueImpl <em>Merging Issue</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.change.impl.MergingIssueImpl
		 * @see org.unicase.model.change.impl.ChangePackageImpl#getMergingIssue()
		 * @generated
		 */
		EClass MERGING_ISSUE = eINSTANCE.getMergingIssue();

		/**
		 * The meta object literal for the '<em><b>Resolving Revision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MERGING_ISSUE__RESOLVING_REVISION = eINSTANCE.getMergingIssue_ResolvingRevision();

		/**
		 * The meta object literal for the '{@link org.unicase.model.change.impl.MergingProposalImpl <em>Merging Proposal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.change.impl.MergingProposalImpl
		 * @see org.unicase.model.change.impl.ChangePackageImpl#getMergingProposal()
		 * @generated
		 */
		EClass MERGING_PROPOSAL = eINSTANCE.getMergingProposal();

		/**
		 * The meta object literal for the '<em><b>Conflicting Proposals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MERGING_PROPOSAL__CONFLICTING_PROPOSALS = eINSTANCE.getMergingProposal_ConflictingProposals();

		/**
		 * The meta object literal for the '<em><b>Pending Changes</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MERGING_PROPOSAL__PENDING_CHANGES = eINSTANCE.getMergingProposal_PendingChanges();

	}

} //ChangePackage
