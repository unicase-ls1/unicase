/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 *
 * $Id$
 */
package org.unicase.model.changetracking.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.model.ModelPackage;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.changetracking.ChangetrackingFactory;
import org.unicase.model.changetracking.ChangetrackingPackage;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.RepositoryRevision;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.changetracking.Stream;
import org.unicase.model.changetracking.git.GitPackage;
import org.unicase.model.changetracking.git.impl.GitPackageImpl;
import org.unicase.model.changetracking.patch.PatchPackage;
import org.unicase.model.changetracking.patch.impl.PatchPackageImpl;
import org.unicase.model.release.ReleasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ChangetrackingPackageImpl extends EPackageImpl implements
		ChangetrackingPackage {
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
	private EClass changeTrackingReleaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass streamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass changePackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repositoryRevisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repositoryStreamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repositoryLocationEClass = null;

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
	 * @see org.unicase.model.changetracking.ChangetrackingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ChangetrackingPackageImpl() {
		super(eNS_URI, ChangetrackingFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ChangetrackingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ChangetrackingPackage init() {
		if (isInited)
			return (ChangetrackingPackage) EPackage.Registry.INSTANCE
					.getEPackage(ChangetrackingPackage.eNS_URI);

		// Obtain or create and register package
		ChangetrackingPackageImpl theChangetrackingPackage = (ChangetrackingPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof ChangetrackingPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new ChangetrackingPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		GitPackageImpl theGitPackage = (GitPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(GitPackage.eNS_URI) instanceof GitPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(GitPackage.eNS_URI) : GitPackage.eINSTANCE);
		PatchPackageImpl thePatchPackage = (PatchPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(PatchPackage.eNS_URI) instanceof PatchPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(PatchPackage.eNS_URI) : PatchPackage.eINSTANCE);

		// Create package meta-data objects
		theChangetrackingPackage.createPackageContents();
		theGitPackage.createPackageContents();
		thePatchPackage.createPackageContents();

		// Initialize created meta-data
		theChangetrackingPackage.initializePackageContents();
		theGitPackage.initializePackageContents();
		thePatchPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theChangetrackingPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ChangetrackingPackage.eNS_URI,
				theChangetrackingPackage);
		return theChangetrackingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChangeTrackingRelease() {
		return changeTrackingReleaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChangeTrackingRelease_Stream() {
		return (EReference) changeTrackingReleaseEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChangeTrackingRelease_Built() {
		return (EAttribute) changeTrackingReleaseEClass
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChangeTrackingRelease_BuiltRevision() {
		return (EReference) changeTrackingReleaseEClass
				.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChangeTrackingRelease_BuildDate() {
		return (EAttribute) changeTrackingReleaseEClass
				.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChangeTrackingRelease_Successor() {
		return (EReference) changeTrackingReleaseEClass
				.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChangeTrackingRelease_Predecessor() {
		return (EReference) changeTrackingReleaseEClass
				.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStream() {
		return streamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStream_Releases() {
		return (EReference) streamEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStream_RepositoryStream() {
		return (EReference) streamEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChangePackage() {
		return changePackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChangePackage_ShortDescription() {
		return (EAttribute) changePackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepositoryRevision() {
		return repositoryRevisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepositoryRevision_RepositoryStream() {
		return (EReference) repositoryRevisionEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepositoryRevision_BuiltWithReleases() {
		return (EReference) repositoryRevisionEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepositoryStream() {
		return repositoryStreamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepositoryStream_Location() {
		return (EReference) repositoryStreamEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepositoryStream_Revisions() {
		return (EReference) repositoryStreamEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepositoryStream_UsingStreams() {
		return (EReference) repositoryStreamEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepositoryLocation() {
		return repositoryLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepositoryLocation_Streams() {
		return (EReference) repositoryLocationEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangetrackingFactory getChangetrackingFactory() {
		return (ChangetrackingFactory) getEFactoryInstance();
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
		changeTrackingReleaseEClass = createEClass(CHANGE_TRACKING_RELEASE);
		createEReference(changeTrackingReleaseEClass,
				CHANGE_TRACKING_RELEASE__STREAM);
		createEAttribute(changeTrackingReleaseEClass,
				CHANGE_TRACKING_RELEASE__BUILT);
		createEReference(changeTrackingReleaseEClass,
				CHANGE_TRACKING_RELEASE__BUILT_REVISION);
		createEAttribute(changeTrackingReleaseEClass,
				CHANGE_TRACKING_RELEASE__BUILD_DATE);
		createEReference(changeTrackingReleaseEClass,
				CHANGE_TRACKING_RELEASE__SUCCESSOR);
		createEReference(changeTrackingReleaseEClass,
				CHANGE_TRACKING_RELEASE__PREDECESSOR);

		streamEClass = createEClass(STREAM);
		createEReference(streamEClass, STREAM__RELEASES);
		createEReference(streamEClass, STREAM__REPOSITORY_STREAM);

		changePackageEClass = createEClass(CHANGE_PACKAGE);
		createEAttribute(changePackageEClass, CHANGE_PACKAGE__SHORT_DESCRIPTION);

		repositoryRevisionEClass = createEClass(REPOSITORY_REVISION);
		createEReference(repositoryRevisionEClass,
				REPOSITORY_REVISION__REPOSITORY_STREAM);
		createEReference(repositoryRevisionEClass,
				REPOSITORY_REVISION__BUILT_WITH_RELEASES);

		repositoryStreamEClass = createEClass(REPOSITORY_STREAM);
		createEReference(repositoryStreamEClass, REPOSITORY_STREAM__LOCATION);
		createEReference(repositoryStreamEClass, REPOSITORY_STREAM__REVISIONS);
		createEReference(repositoryStreamEClass,
				REPOSITORY_STREAM__USING_STREAMS);

		repositoryLocationEClass = createEClass(REPOSITORY_LOCATION);
		createEReference(repositoryLocationEClass, REPOSITORY_LOCATION__STREAMS);
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
		GitPackage theGitPackage = (GitPackage) EPackage.Registry.INSTANCE
				.getEPackage(GitPackage.eNS_URI);
		PatchPackage thePatchPackage = (PatchPackage) EPackage.Registry.INSTANCE
				.getEPackage(PatchPackage.eNS_URI);
		ReleasePackage theReleasePackage = (ReleasePackage) EPackage.Registry.INSTANCE
				.getEPackage(ReleasePackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);
		ModelPackage theModelPackage = (ModelPackage) EPackage.Registry.INSTANCE
				.getEPackage(ModelPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theGitPackage);
		getESubpackages().add(thePatchPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		changeTrackingReleaseEClass.getESuperTypes().add(
				theReleasePackage.getRelease());
		streamEClass.getESuperTypes().add(
				theModelPackage.getUnicaseModelElement());
		changePackageEClass.getESuperTypes().add(
				theModelPackage.getAttachment());
		repositoryRevisionEClass.getESuperTypes().add(
				theModelPackage.getUnicaseModelElement());
		repositoryStreamEClass.getESuperTypes().add(
				theModelPackage.getUnicaseModelElement());
		repositoryLocationEClass.getESuperTypes().add(
				theModelPackage.getUnicaseModelElement());

		// Initialize classes and features; add operations and parameters
		initEClass(changeTrackingReleaseEClass, ChangeTrackingRelease.class,
				"ChangeTrackingRelease", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChangeTrackingRelease_Stream(), this.getStream(),
				this.getStream_Releases(), "stream", null, 0, 1,
				ChangeTrackingRelease.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getChangeTrackingRelease_Built(),
				theEcorePackage.getEBoolean(), "built", null, 0, 1,
				ChangeTrackingRelease.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getChangeTrackingRelease_BuiltRevision(),
				this.getRepositoryRevision(),
				this.getRepositoryRevision_BuiltWithReleases(),
				"builtRevision", null, 0, 1, ChangeTrackingRelease.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getChangeTrackingRelease_BuildDate(),
				theEcorePackage.getEDate(), "buildDate", null, 0, 1,
				ChangeTrackingRelease.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getChangeTrackingRelease_Successor(),
				this.getChangeTrackingRelease(),
				this.getChangeTrackingRelease_Predecessor(), "successor", null,
				0, 1, ChangeTrackingRelease.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChangeTrackingRelease_Predecessor(),
				this.getChangeTrackingRelease(),
				this.getChangeTrackingRelease_Successor(), "predecessor", null,
				0, 1, ChangeTrackingRelease.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(streamEClass, Stream.class, "Stream", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStream_Releases(), this.getChangeTrackingRelease(),
				this.getChangeTrackingRelease_Stream(), "releases", null, 0,
				-1, Stream.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getStream_RepositoryStream(),
				this.getRepositoryStream(),
				this.getRepositoryStream_UsingStreams(), "repositoryStream",
				null, 0, 1, Stream.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(changePackageEClass, ChangePackage.class, "ChangePackage",
				IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChangePackage_ShortDescription(),
				theEcorePackage.getEString(), "shortDescription", null, 0, 1,
				ChangePackage.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(repositoryRevisionEClass, RepositoryRevision.class,
				"RepositoryRevision", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepositoryRevision_RepositoryStream(),
				this.getRepositoryStream(),
				this.getRepositoryStream_Revisions(), "repositoryStream", null,
				0, 1, RepositoryRevision.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRepositoryRevision_BuiltWithReleases(),
				this.getChangeTrackingRelease(),
				this.getChangeTrackingRelease_BuiltRevision(),
				"builtWithReleases", null, 0, -1, RepositoryRevision.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(repositoryStreamEClass, RepositoryStream.class,
				"RepositoryStream", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepositoryStream_Location(),
				this.getRepositoryLocation(),
				this.getRepositoryLocation_Streams(), "location", null, 0, 1,
				RepositoryStream.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRepositoryStream_Revisions(),
				this.getRepositoryRevision(),
				this.getRepositoryRevision_RepositoryStream(), "revisions",
				null, 0, -1, RepositoryStream.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRepositoryStream_UsingStreams(), this.getStream(),
				this.getStream_RepositoryStream(), "usingStreams", null, 0, -1,
				RepositoryStream.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(repositoryLocationEClass, RepositoryLocation.class,
				"RepositoryLocation", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepositoryLocation_Streams(),
				this.getRepositoryStream(),
				this.getRepositoryStream_Location(), "streams", null, 0, -1,
				RepositoryLocation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ChangetrackingPackageImpl
