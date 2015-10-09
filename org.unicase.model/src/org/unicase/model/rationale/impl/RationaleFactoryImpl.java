/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.rationale.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.model.rationale.*;
import org.unicase.model.rationale.Assessment;
import org.unicase.model.rationale.AudioComment;
import org.unicase.model.rationale.Comment;
import org.unicase.model.rationale.Criterion;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.Proposal;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.rationale.Solution;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class RationaleFactoryImpl extends EFactoryImpl implements
		RationaleFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RationaleFactory init() {
		try {
			RationaleFactory theRationaleFactory = (RationaleFactory) EPackage.Registry.INSTANCE
					.getEFactory(RationalePackage.eNS_URI);
			if (theRationaleFactory != null) {
				return theRationaleFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RationaleFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RationaleFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case RationalePackage.ISSUE:
			return createIssue();
		case RationalePackage.PROPOSAL:
			return createProposal();
		case RationalePackage.SOLUTION:
			return createSolution();
		case RationalePackage.CRITERION:
			return createCriterion();
		case RationalePackage.ASSESSMENT:
			return createAssessment();
		case RationalePackage.COMMENT:
			return createComment();
		case RationalePackage.AUDIO_COMMENT:
			return createAudioComment();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Issue createIssue() {
		IssueImpl issue = new IssueImpl();
		return issue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Proposal createProposal() {
		ProposalImpl proposal = new ProposalImpl();
		return proposal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Solution createSolution() {
		SolutionImpl solution = new SolutionImpl();
		return solution;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Criterion createCriterion() {
		CriterionImpl criterion = new CriterionImpl();
		return criterion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Assessment createAssessment() {
		AssessmentImpl assessment = new AssessmentImpl();
		return assessment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Comment createComment() {
		CommentImpl comment = new CommentImpl();
		return comment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AudioComment createAudioComment() {
		AudioCommentImpl audioComment = new AudioCommentImpl();
		return audioComment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RationalePackage getRationalePackage() {
		return (RationalePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RationalePackage getPackage() {
		return RationalePackage.eINSTANCE;
	}

} // RationaleFactoryImpl
