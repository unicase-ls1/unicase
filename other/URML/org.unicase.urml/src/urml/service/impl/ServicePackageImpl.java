/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package urml.service.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.unicase.metamodel.MetamodelPackage;

import org.unicase.model.ModelPackage;

import org.unicase.model.urml.UrmlPackage;

import org.unicase.model.urml.impl.UrmlPackageImpl;

import urml.danger.DangerPackage;

import urml.danger.impl.DangerPackageImpl;

import urml.goal.GoalPackage;

import urml.goal.impl.GoalPackageImpl;

import urml.requirement.RequirementPackage;

import urml.requirement.impl.RequirementPackageImpl;

import urml.service.Service;
import urml.service.ServiceFactory;
import urml.service.ServicePackage;
import urml.service.ServiceProvider;

import urml.usecase.UsecasePackage;

import urml.usecase.impl.UsecasePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ServicePackageImpl extends EPackageImpl implements ServicePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceProviderEClass = null;

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
	 * @see urml.service.ServicePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ServicePackageImpl() {
		super(eNS_URI, ServiceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ServicePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ServicePackage init() {
		if (isInited)
			return (ServicePackage) EPackage.Registry.INSTANCE
					.getEPackage(ServicePackage.eNS_URI);

		// Obtain or create and register package
		ServicePackageImpl theServicePackage = (ServicePackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof ServicePackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI)
				: new ServicePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		UrmlPackageImpl theUrmlPackage = (UrmlPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(UrmlPackage.eNS_URI) instanceof UrmlPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(UrmlPackage.eNS_URI)
				: UrmlPackage.eINSTANCE);
		GoalPackageImpl theGoalPackage = (GoalPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(GoalPackage.eNS_URI) instanceof GoalPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(GoalPackage.eNS_URI)
				: GoalPackage.eINSTANCE);
		RequirementPackageImpl theRequirementPackage = (RequirementPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(RequirementPackage.eNS_URI) instanceof RequirementPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(RequirementPackage.eNS_URI)
				: RequirementPackage.eINSTANCE);
		UsecasePackageImpl theUsecasePackage = (UsecasePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(UsecasePackage.eNS_URI) instanceof UsecasePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(UsecasePackage.eNS_URI)
				: UsecasePackage.eINSTANCE);
		DangerPackageImpl theDangerPackage = (DangerPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(DangerPackage.eNS_URI) instanceof DangerPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(DangerPackage.eNS_URI)
				: DangerPackage.eINSTANCE);

		// Create package meta-data objects
		theServicePackage.createPackageContents();
		theUrmlPackage.createPackageContents();
		theGoalPackage.createPackageContents();
		theRequirementPackage.createPackageContents();
		theUsecasePackage.createPackageContents();
		theDangerPackage.createPackageContents();

		// Initialize created meta-data
		theServicePackage.initializePackageContents();
		theUrmlPackage.initializePackageContents();
		theGoalPackage.initializePackageContents();
		theRequirementPackage.initializePackageContents();
		theUsecasePackage.initializePackageContents();
		theDangerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theServicePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ServicePackage.eNS_URI,
				theServicePackage);
		return theServicePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getService() {
		return serviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_ServiceProvider() {
		return (EReference) serviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_SatisfiedRequirements() {
		return (EReference) serviceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceProvider() {
		return serviceProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceProvider_ProvidedServices() {
		return (EReference) serviceProviderEClass.getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceFactory getServiceFactory() {
		return (ServiceFactory) getEFactoryInstance();
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
		serviceEClass = createEClass(SERVICE);
		createEReference(serviceEClass, SERVICE__SERVICE_PROVIDER);
		createEReference(serviceEClass, SERVICE__SATISFIED_REQUIREMENTS);

		serviceProviderEClass = createEClass(SERVICE_PROVIDER);
		createEReference(serviceProviderEClass,
				SERVICE_PROVIDER__PROVIDED_SERVICES);
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
		DangerPackage theDangerPackage = (DangerPackage) EPackage.Registry.INSTANCE
				.getEPackage(DangerPackage.eNS_URI);
		MetamodelPackage theMetamodelPackage = (MetamodelPackage) EPackage.Registry.INSTANCE
				.getEPackage(MetamodelPackage.eNS_URI);
		RequirementPackage theRequirementPackage = (RequirementPackage) EPackage.Registry.INSTANCE
				.getEPackage(RequirementPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		serviceEClass.getESuperTypes().add(theDangerPackage.getMitigation());
		serviceProviderEClass.getESuperTypes().add(theDangerPackage.getAsset());

		// Initialize classes and features; add operations and parameters
		initEClass(serviceEClass, Service.class, "Service", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getService_ServiceProvider(), this.getServiceProvider(),
				this.getServiceProvider_ProvidedServices(), "serviceProvider",
				null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getService_ServiceProvider().getEKeys().add(
				theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getService_SatisfiedRequirements(),
				theRequirementPackage.getRequirement(), theRequirementPackage
						.getRequirement_ImplementingServices(),
				"satisfiedRequirements", null, 0, -1, Service.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		getService_SatisfiedRequirements().getEKeys().add(
				theMetamodelPackage.getIdentifiableElement_Identifier());

		initEClass(serviceProviderEClass, ServiceProvider.class,
				"ServiceProvider", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceProvider_ProvidedServices(),
				this.getService(), this.getService_ServiceProvider(),
				"providedServices", null, 0, -1, ServiceProvider.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		getServiceProvider_ProvidedServices().getEKeys().add(
				theMetamodelPackage.getIdentifiableElement_Identifier());
	}

} //ServicePackageImpl