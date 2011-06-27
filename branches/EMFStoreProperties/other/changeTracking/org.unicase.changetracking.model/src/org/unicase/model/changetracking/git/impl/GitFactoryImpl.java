/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 */
package org.unicase.model.changetracking.git.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.model.changetracking.git.*;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitBranchChangePackage;
import org.unicase.model.changetracking.git.GitFactory;
import org.unicase.model.changetracking.git.GitPackage;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.model.changetracking.git.GitRevision;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GitFactoryImpl extends EFactoryImpl implements GitFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GitFactory init() {
		try {
			GitFactory theGitFactory = (GitFactory) EPackage.Registry.INSTANCE.getEFactory("http://unicase.org/model/changetracking/git");
			if (theGitFactory != null) {
				return theGitFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GitFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GitFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case GitPackage.GIT_BRANCH_CHANGE_PACKAGE:
			return createGitBranchChangePackage();
		case GitPackage.GIT_BRANCH:
			return createGitBranch();
		case GitPackage.GIT_REVISION:
			return createGitRevision();
		case GitPackage.GIT_REPOSITORY:
			return createGitRepository();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GitBranchChangePackage createGitBranchChangePackage() {
		GitBranchChangePackageImpl gitBranchChangePackage = new GitBranchChangePackageImpl();
		return gitBranchChangePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GitBranch createGitBranch() {
		GitBranchImpl gitBranch = new GitBranchImpl();
		return gitBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GitRevision createGitRevision() {
		GitRevisionImpl gitRevision = new GitRevisionImpl();
		return gitRevision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GitRepository createGitRepository() {
		GitRepositoryImpl gitRepository = new GitRepositoryImpl();
		return gitRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GitPackage getGitPackage() {
		return (GitPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GitPackage getPackage() {
		return GitPackage.eINSTANCE;
	}

} //GitFactoryImpl
