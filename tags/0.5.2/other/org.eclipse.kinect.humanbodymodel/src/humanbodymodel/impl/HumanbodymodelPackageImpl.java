/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package humanbodymodel.impl;

import humanbodymodel.Human;
import humanbodymodel.HumanContainer;
import humanbodymodel.HumanLink;
import humanbodymodel.HumanbodymodelFactory;
import humanbodymodel.HumanbodymodelPackage;
import humanbodymodel.PositionedElement;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HumanbodymodelPackageImpl extends EPackageImpl implements HumanbodymodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass humanEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass positionedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass humanContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass humanLinkEClass = null;

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
	 * @see humanbodymodel.HumanbodymodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private HumanbodymodelPackageImpl() {
		super(eNS_URI, HumanbodymodelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link HumanbodymodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static HumanbodymodelPackage init() {
		if (isInited) return (HumanbodymodelPackage)EPackage.Registry.INSTANCE.getEPackage(HumanbodymodelPackage.eNS_URI);

		// Obtain or create and register package
		HumanbodymodelPackageImpl theHumanbodymodelPackage = (HumanbodymodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof HumanbodymodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new HumanbodymodelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theHumanbodymodelPackage.createPackageContents();

		// Initialize created meta-data
		theHumanbodymodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theHumanbodymodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(HumanbodymodelPackage.eNS_URI, theHumanbodymodelPackage);
		return theHumanbodymodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHuman() {
		return humanEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPositionedElement() {
		return positionedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPositionedElement_X() {
		return (EAttribute)positionedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPositionedElement_Y() {
		return (EAttribute)positionedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPositionedElement_Z() {
		return (EAttribute)positionedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPositionedElement_Name() {
		return (EAttribute)positionedElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPositionedElement_IncomingLinks() {
		return (EReference)positionedElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPositionedElement_OutgoingLinks() {
		return (EReference)positionedElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPositionedElement_Color_r() {
		return (EAttribute)positionedElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPositionedElement_Color_g() {
		return (EAttribute)positionedElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPositionedElement_Color_b() {
		return (EAttribute)positionedElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHumanContainer() {
		return humanContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHumanContainer_Elements() {
		return (EReference)humanContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHumanContainer_Links() {
		return (EReference)humanContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHumanLink() {
		return humanLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHumanLink_Source() {
		return (EReference)humanLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHumanLink_Target() {
		return (EReference)humanLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HumanbodymodelFactory getHumanbodymodelFactory() {
		return (HumanbodymodelFactory)getEFactoryInstance();
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
		humanEClass = createEClass(HUMAN);

		positionedElementEClass = createEClass(POSITIONED_ELEMENT);
		createEAttribute(positionedElementEClass, POSITIONED_ELEMENT__X);
		createEAttribute(positionedElementEClass, POSITIONED_ELEMENT__Y);
		createEAttribute(positionedElementEClass, POSITIONED_ELEMENT__Z);
		createEAttribute(positionedElementEClass, POSITIONED_ELEMENT__NAME);
		createEReference(positionedElementEClass, POSITIONED_ELEMENT__INCOMING_LINKS);
		createEReference(positionedElementEClass, POSITIONED_ELEMENT__OUTGOING_LINKS);
		createEAttribute(positionedElementEClass, POSITIONED_ELEMENT__COLOR_R);
		createEAttribute(positionedElementEClass, POSITIONED_ELEMENT__COLOR_G);
		createEAttribute(positionedElementEClass, POSITIONED_ELEMENT__COLOR_B);

		humanContainerEClass = createEClass(HUMAN_CONTAINER);
		createEReference(humanContainerEClass, HUMAN_CONTAINER__ELEMENTS);
		createEReference(humanContainerEClass, HUMAN_CONTAINER__LINKS);

		humanLinkEClass = createEClass(HUMAN_LINK);
		createEReference(humanLinkEClass, HUMAN_LINK__SOURCE);
		createEReference(humanLinkEClass, HUMAN_LINK__TARGET);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		humanEClass.getESuperTypes().add(this.getPositionedElement());

		// Initialize classes and features; add operations and parameters
		initEClass(humanEClass, Human.class, "Human", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(positionedElementEClass, PositionedElement.class, "PositionedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPositionedElement_X(), ecorePackage.getEFloat(), "x", null, 0, 1, PositionedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPositionedElement_Y(), ecorePackage.getEFloat(), "y", null, 0, 1, PositionedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPositionedElement_Z(), ecorePackage.getEFloat(), "z", null, 0, 1, PositionedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPositionedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, PositionedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPositionedElement_IncomingLinks(), this.getHumanLink(), null, "incomingLinks", null, 0, -1, PositionedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPositionedElement_OutgoingLinks(), this.getHumanLink(), null, "outgoingLinks", null, 0, -1, PositionedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPositionedElement_Color_r(), ecorePackage.getEInt(), "color_r", null, 0, 1, PositionedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPositionedElement_Color_g(), ecorePackage.getEInt(), "color_g", null, 0, 1, PositionedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPositionedElement_Color_b(), ecorePackage.getEInt(), "color_b", null, 0, 1, PositionedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(humanContainerEClass, HumanContainer.class, "HumanContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHumanContainer_Elements(), this.getPositionedElement(), null, "elements", null, 0, -1, HumanContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHumanContainer_Links(), this.getHumanLink(), null, "links", null, 0, -1, HumanContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(humanLinkEClass, HumanLink.class, "HumanLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHumanLink_Source(), this.getPositionedElement(), null, "source", null, 0, 1, HumanLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHumanLink_Target(), this.getPositionedElement(), null, "target", null, 0, 1, HumanLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //HumanbodymodelPackageImpl
