/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 *
 * $Id$
 */
package org.unicase.model.changetracking.git.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.unicase.model.ModelPackage;

import org.unicase.model.changetracking.ChangetrackingPackage;

import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitBranchChangePackage;
import org.unicase.model.changetracking.git.GitFactory;
import org.unicase.model.changetracking.git.GitPackage;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.model.changetracking.git.GitRevision;

import org.unicase.model.changetracking.impl.ChangetrackingPackageImpl;

import org.unicase.model.changetracking.patch.PatchPackage;

import org.unicase.model.changetracking.patch.impl.PatchPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GitPackageImpl extends EPackageImpl implements GitPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "<copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>\r";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gitBranchChangePackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gitBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gitRevisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gitRepositoryEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.model.changetracking.git.GitPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GitPackageImpl() {
		super(eNS_URI, GitFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link GitPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GitPackage init() {
		if (isInited)
			return (GitPackage) EPackage.Registry.INSTANCE
					.getEPackage(GitPackage.eNS_URI);

		// Obtain or create and register package
		GitPackageImpl theGitPackage = (GitPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof GitPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI)
				: new GitPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ChangetrackingPackageImpl theChangetrackingPackage = (ChangetrackingPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(ChangetrackingPackage.eNS_URI) instanceof ChangetrackingPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(ChangetrackingPackage.eNS_URI)
				: ChangetrackingPackage.eINSTANCE);
		PatchPackageImpl thePatchPackage = (PatchPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(PatchPackage.eNS_URI) instanceof PatchPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(PatchPackage.eNS_URI)
				: PatchPackage.eINSTANCE);

		// Create package meta-data objects
		theGitPackage.createPackageContents();
		theChangetrackingPackage.createPackageContents();
		thePatchPackage.createPackageContents();

		// Initialize created meta-data
		theGitPackage.initializePackageContents();
		theChangetrackingPackage.initializePackageContents();
		thePatchPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGitPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GitPackage.eNS_URI, theGitPackage);
		return theGitPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGitBranchChangePackage() {
		return gitBranchChangePackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGitBranchChangePackage_Branch() {
		return (EReference) gitBranchChangePackageEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGitBranch() {
		return gitBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGitBranch_ReferringChangePackages() {
		return (EReference) gitBranchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGitBranch_BranchName() {
		return (EAttribute) gitBranchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGitRevision() {
		return gitRevisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGitRevision_Hash() {
		return (EAttribute) gitRevisionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGitRepository() {
		return gitRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGitRepository_Url() {
		return (EAttribute) gitRepositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGitRepository_IdentifyingCommitHash() {
		return (EAttribute) gitRepositoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GitFactory getGitFactory() {
		return (GitFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		gitBranchChangePackageEClass = createEClass(GIT_BRANCH_CHANGE_PACKAGE);
		createEReference(gitBranchChangePackageEClass,
				GIT_BRANCH_CHANGE_PACKAGE__BRANCH);

		gitBranchEClass = createEClass(GIT_BRANCH);
		createEReference(gitBranchEClass, GIT_BRANCH__REFERRING_CHANGE_PACKAGES);
		createEAttribute(gitBranchEClass, GIT_BRANCH__BRANCH_NAME);

		gitRevisionEClass = createEClass(GIT_REVISION);
		createEAttribute(gitRevisionEClass, GIT_REVISION__HASH);

		gitRepositoryEClass = createEClass(GIT_REPOSITORY);
		createEAttribute(gitRepositoryEClass, GIT_REPOSITORY__URL);
		createEAttribute(gitRepositoryEClass,
				GIT_REPOSITORY__IDENTIFYING_COMMIT_HASH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ChangetrackingPackage theChangetrackingPackage = (ChangetrackingPackage) EPackage.Registry.INSTANCE
				.getEPackage(ChangetrackingPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		gitBranchChangePackageEClass.getESuperTypes().add(
				theChangetrackingPackage.getChangePackage());
		gitBranchEClass.getESuperTypes().add(
				theChangetrackingPackage.getRepositoryStream());
		gitRevisionEClass.getESuperTypes().add(
				theChangetrackingPackage.getRepositoryRevision());
		gitRepositoryEClass.getESuperTypes().add(
				theChangetrackingPackage.getRepositoryLocation());

		// Initialize classes and features; add operations and parameters
		initEClass(gitBranchChangePackageEClass, GitBranchChangePackage.class,
				"GitBranchChangePackage", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGitBranchChangePackage_Branch(), this.getGitBranch(),
				this.getGitBranch_ReferringChangePackages(), "branch", null, 0,
				1, GitBranchChangePackage.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(gitBranchEClass, GitBranch.class, "GitBranch", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGitBranch_ReferringChangePackages(), this
				.getGitBranchChangePackage(), this
				.getGitBranchChangePackage_Branch(), "referringChangePackages",
				null, 0, -1, GitBranch.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGitBranch_BranchName(), theEcorePackage.getEString(),
				"branchName", null, 0, 1, GitBranch.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(gitRevisionEClass, GitRevision.class, "GitRevision",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGitRevision_Hash(), theEcorePackage.getEString(),
				"hash", null, 0, 1, GitRevision.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(gitRepositoryEClass, GitRepository.class, "GitRepository",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGitRepository_Url(), theEcorePackage.getEString(),
				"url", null, 0, 1, GitRepository.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getGitRepository_IdentifyingCommitHash(),
				theEcorePackage.getEString(), "identifyingCommitHash", null, 0,
				1, GitRepository.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
	}

} //GitPackageImpl
