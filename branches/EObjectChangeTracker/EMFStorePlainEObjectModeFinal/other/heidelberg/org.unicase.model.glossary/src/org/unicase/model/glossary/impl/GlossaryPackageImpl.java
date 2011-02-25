/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.glossary.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.unicase.model.ModelPackage;

import org.unicase.model.glossary.GlossaryEntry;
import org.unicase.model.glossary.GlossaryFactory;
import org.unicase.model.glossary.GlossaryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GlossaryPackageImpl extends EPackageImpl implements GlossaryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass glossaryEntryEClass = null;

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
	 * @see org.unicase.model.glossary.GlossaryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GlossaryPackageImpl() {
		super(eNS_URI, GlossaryFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link GlossaryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GlossaryPackage init() {
		if (isInited) return (GlossaryPackage)EPackage.Registry.INSTANCE.getEPackage(GlossaryPackage.eNS_URI);

		// Obtain or create and register package
		GlossaryPackageImpl theGlossaryPackage = (GlossaryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GlossaryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GlossaryPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGlossaryPackage.createPackageContents();

		// Initialize created meta-data
		theGlossaryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGlossaryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GlossaryPackage.eNS_URI, theGlossaryPackage);
		return theGlossaryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlossaryEntry() {
		return glossaryEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlossaryFactory getGlossaryFactory() {
		return (GlossaryFactory)getEFactoryInstance();
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
		glossaryEntryEClass = createEClass(GLOSSARY_ENTRY);
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
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		glossaryEntryEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());

		// Initialize classes and features; add operations and parameters
		initEClass(glossaryEntryEClass, GlossaryEntry.class, "GlossaryEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //GlossaryPackageImpl
