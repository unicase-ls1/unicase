/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel.changemanagment.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.change.ChangePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.unicase.esmodel.EsmodelPackage;

import org.unicase.esmodel.accesscontrol.AccesscontrolPackage;

import org.unicase.esmodel.accesscontrol.impl.AccesscontrolPackageImpl;

import org.unicase.esmodel.changemanagment.ChangemanagmentFactory;
import org.unicase.esmodel.changemanagment.ChangemanagmentPackage;
import org.unicase.esmodel.changemanagment.DateVersionSpec;
import org.unicase.esmodel.changemanagment.HistoryInfo;
import org.unicase.esmodel.changemanagment.LogMessage;
import org.unicase.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.esmodel.changemanagment.TagVersionSpec;
import org.unicase.esmodel.changemanagment.Version;
import org.unicase.esmodel.changemanagment.VersionSpec;

import org.unicase.esmodel.impl.EsmodelPackageImpl;

import org.unicase.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ChangemanagmentPackageImpl extends EPackageImpl implements ChangemanagmentPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagVersionSpecEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dateVersionSpecEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primaryVersionSpecEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass versionSpecEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logMessageEClass = null;

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
	private EClass historyInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass versionEClass = null;

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
	 * @see org.unicase.esmodel.changemanagment.ChangemanagmentPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ChangemanagmentPackageImpl() {
		super(eNS_URI, ChangemanagmentFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ChangemanagmentPackage init() {
		if (isInited) return (ChangemanagmentPackage)EPackage.Registry.INSTANCE.getEPackage(ChangemanagmentPackage.eNS_URI);

		// Obtain or create and register package
		ChangemanagmentPackageImpl theChangemanagmentPackage = (ChangemanagmentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ChangemanagmentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ChangemanagmentPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ChangePackage.eINSTANCE.eClass();
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EsmodelPackageImpl theEsmodelPackage = (EsmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EsmodelPackage.eNS_URI) instanceof EsmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EsmodelPackage.eNS_URI) : EsmodelPackage.eINSTANCE);
		AccesscontrolPackageImpl theAccesscontrolPackage = (AccesscontrolPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AccesscontrolPackage.eNS_URI) instanceof AccesscontrolPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AccesscontrolPackage.eNS_URI) : AccesscontrolPackage.eINSTANCE);

		// Create package meta-data objects
		theChangemanagmentPackage.createPackageContents();
		theEsmodelPackage.createPackageContents();
		theAccesscontrolPackage.createPackageContents();

		// Initialize created meta-data
		theChangemanagmentPackage.initializePackageContents();
		theEsmodelPackage.initializePackageContents();
		theAccesscontrolPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theChangemanagmentPackage.freeze();

		return theChangemanagmentPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTagVersionSpec() {
		return tagVersionSpecEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTagVersionSpec_Name() {
		return (EAttribute)tagVersionSpecEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDateVersionSpec() {
		return dateVersionSpecEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDateVersionSpec_Date() {
		return (EAttribute)dateVersionSpecEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimaryVersionSpec() {
		return primaryVersionSpecEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimaryVersionSpec_Identifier() {
		return (EAttribute)primaryVersionSpecEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVersionSpec() {
		return versionSpecEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogMessage() {
		return logMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogMessage_Message() {
		return (EAttribute)logMessageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogMessage_Author() {
		return (EReference)logMessageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogMessage_Date() {
		return (EAttribute)logMessageEClass.getEStructuralFeatures().get(2);
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
	public EReference getChangePackage_FowardDelta() {
		return (EReference)changePackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChangePackage_BackwardDelta() {
		return (EReference)changePackageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHistoryInfo() {
		return historyInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHistoryInfo_PrimerySpec() {
		return (EReference)historyInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVersion() {
		return versionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVersion_ProjectState() {
		return (EReference)versionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVersion_PrimarySpec() {
		return (EReference)versionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVersion_TagSpecs() {
		return (EReference)versionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVersion_NextVersion() {
		return (EReference)versionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVersion_PreviousVersion() {
		return (EReference)versionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVersion_Changes() {
		return (EReference)versionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVersion_LogMessage() {
		return (EReference)versionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangemanagmentFactory getChangemanagmentFactory() {
		return (ChangemanagmentFactory)getEFactoryInstance();
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
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		tagVersionSpecEClass = createEClass(TAG_VERSION_SPEC);
		createEAttribute(tagVersionSpecEClass, TAG_VERSION_SPEC__NAME);

		dateVersionSpecEClass = createEClass(DATE_VERSION_SPEC);
		createEAttribute(dateVersionSpecEClass, DATE_VERSION_SPEC__DATE);

		primaryVersionSpecEClass = createEClass(PRIMARY_VERSION_SPEC);
		createEAttribute(primaryVersionSpecEClass, PRIMARY_VERSION_SPEC__IDENTIFIER);

		versionSpecEClass = createEClass(VERSION_SPEC);

		logMessageEClass = createEClass(LOG_MESSAGE);
		createEAttribute(logMessageEClass, LOG_MESSAGE__MESSAGE);
		createEReference(logMessageEClass, LOG_MESSAGE__AUTHOR);
		createEAttribute(logMessageEClass, LOG_MESSAGE__DATE);

		changePackageEClass = createEClass(CHANGE_PACKAGE);
		createEReference(changePackageEClass, CHANGE_PACKAGE__FOWARD_DELTA);
		createEReference(changePackageEClass, CHANGE_PACKAGE__BACKWARD_DELTA);

		historyInfoEClass = createEClass(HISTORY_INFO);
		createEReference(historyInfoEClass, HISTORY_INFO__PRIMERY_SPEC);

		versionEClass = createEClass(VERSION);
		createEReference(versionEClass, VERSION__PROJECT_STATE);
		createEReference(versionEClass, VERSION__PRIMARY_SPEC);
		createEReference(versionEClass, VERSION__TAG_SPECS);
		createEReference(versionEClass, VERSION__NEXT_VERSION);
		createEReference(versionEClass, VERSION__PREVIOUS_VERSION);
		createEReference(versionEClass, VERSION__CHANGES);
		createEReference(versionEClass, VERSION__LOG_MESSAGE);
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
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		AccesscontrolPackage theAccesscontrolPackage = (AccesscontrolPackage)EPackage.Registry.INSTANCE.getEPackage(AccesscontrolPackage.eNS_URI);
		ChangePackage theChangePackage = (ChangePackage)EPackage.Registry.INSTANCE.getEPackage(ChangePackage.eNS_URI);
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		tagVersionSpecEClass.getESuperTypes().add(this.getVersionSpec());
		dateVersionSpecEClass.getESuperTypes().add(this.getVersionSpec());
		primaryVersionSpecEClass.getESuperTypes().add(this.getVersionSpec());

		// Initialize classes and features; add operations and parameters
		initEClass(tagVersionSpecEClass, TagVersionSpec.class, "TagVersionSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTagVersionSpec_Name(), ecorePackage.getEString(), "name", null, 1, 1, TagVersionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dateVersionSpecEClass, DateVersionSpec.class, "DateVersionSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDateVersionSpec_Date(), ecorePackage.getEDate(), "date", null, 1, 1, DateVersionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primaryVersionSpecEClass, PrimaryVersionSpec.class, "PrimaryVersionSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimaryVersionSpec_Identifier(), ecorePackage.getEInt(), "identifier", null, 1, 1, PrimaryVersionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(versionSpecEClass, VersionSpec.class, "VersionSpec", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(logMessageEClass, LogMessage.class, "LogMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLogMessage_Message(), ecorePackage.getEString(), "message", null, 1, 1, LogMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLogMessage_Author(), theAccesscontrolPackage.getUser(), null, "author", null, 1, 1, LogMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogMessage_Date(), ecorePackage.getEDate(), "date", null, 1, 1, LogMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(changePackageEClass, org.unicase.esmodel.changemanagment.ChangePackage.class, "ChangePackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChangePackage_FowardDelta(), theChangePackage.getChangeDescription(), null, "fowardDelta", null, 1, 1, org.unicase.esmodel.changemanagment.ChangePackage.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChangePackage_BackwardDelta(), theChangePackage.getChangeDescription(), null, "backwardDelta", null, 1, 1, org.unicase.esmodel.changemanagment.ChangePackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(changePackageEClass, this.getChangePackage(), "reverse", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(historyInfoEClass, HistoryInfo.class, "HistoryInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHistoryInfo_PrimerySpec(), this.getPrimaryVersionSpec(), null, "primerySpec", null, 0, 1, HistoryInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(versionEClass, Version.class, "Version", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVersion_ProjectState(), theModelPackage.getProject(), null, "projectState", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersion_PrimarySpec(), this.getPrimaryVersionSpec(), null, "primarySpec", null, 1, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersion_TagSpecs(), this.getTagVersionSpec(), null, "tagSpecs", null, 0, -1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersion_NextVersion(), this.getVersion(), null, "nextVersion", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersion_PreviousVersion(), this.getVersion(), null, "previousVersion", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersion_Changes(), this.getChangePackage(), null, "changes", null, 1, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersion_LogMessage(), this.getLogMessage(), null, "logMessage", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //ChangemanagmentPackageImpl
