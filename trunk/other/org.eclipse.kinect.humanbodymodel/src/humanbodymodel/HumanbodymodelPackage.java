/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package humanbodymodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see humanbodymodel.HumanbodymodelFactory
 * @model kind="package"
 * @generated
 */
public interface HumanbodymodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "humanbodymodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org/eclipse/kinect/humanbodymodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.kinect.humanbodymodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HumanbodymodelPackage eINSTANCE = humanbodymodel.impl.HumanbodymodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link humanbodymodel.impl.PositionedElementImpl <em>Positioned Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see humanbodymodel.impl.PositionedElementImpl
	 * @see humanbodymodel.impl.HumanbodymodelPackageImpl#getPositionedElement()
	 * @generated
	 */
	int POSITIONED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITIONED_ELEMENT__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITIONED_ELEMENT__Y = 1;

	/**
	 * The feature id for the '<em><b>Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITIONED_ELEMENT__Z = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITIONED_ELEMENT__NAME = 3;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITIONED_ELEMENT__INCOMING_LINKS = 4;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITIONED_ELEMENT__OUTGOING_LINKS = 5;

	/**
	 * The feature id for the '<em><b>Color r</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITIONED_ELEMENT__COLOR_R = 6;

	/**
	 * The feature id for the '<em><b>Color g</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITIONED_ELEMENT__COLOR_G = 7;

	/**
	 * The feature id for the '<em><b>Color b</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITIONED_ELEMENT__COLOR_B = 8;

	/**
	 * The number of structural features of the '<em>Positioned Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITIONED_ELEMENT_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link humanbodymodel.impl.HumanImpl <em>Human</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see humanbodymodel.impl.HumanImpl
	 * @see humanbodymodel.impl.HumanbodymodelPackageImpl#getHuman()
	 * @generated
	 */
	int HUMAN = 0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__X = POSITIONED_ELEMENT__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__Y = POSITIONED_ELEMENT__Y;

	/**
	 * The feature id for the '<em><b>Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__Z = POSITIONED_ELEMENT__Z;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__NAME = POSITIONED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__INCOMING_LINKS = POSITIONED_ELEMENT__INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__OUTGOING_LINKS = POSITIONED_ELEMENT__OUTGOING_LINKS;

	/**
	 * The feature id for the '<em><b>Color r</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__COLOR_R = POSITIONED_ELEMENT__COLOR_R;

	/**
	 * The feature id for the '<em><b>Color g</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__COLOR_G = POSITIONED_ELEMENT__COLOR_G;

	/**
	 * The feature id for the '<em><b>Color b</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__COLOR_B = POSITIONED_ELEMENT__COLOR_B;

	/**
	 * The number of structural features of the '<em>Human</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_FEATURE_COUNT = POSITIONED_ELEMENT_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link humanbodymodel.impl.HumanContainerImpl <em>Human Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see humanbodymodel.impl.HumanContainerImpl
	 * @see humanbodymodel.impl.HumanbodymodelPackageImpl#getHumanContainer()
	 * @generated
	 */
	int HUMAN_CONTAINER = 2;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_CONTAINER__ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_CONTAINER__LINKS = 1;

	/**
	 * The number of structural features of the '<em>Human Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_CONTAINER_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link humanbodymodel.impl.HumanLinkImpl <em>Human Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see humanbodymodel.impl.HumanLinkImpl
	 * @see humanbodymodel.impl.HumanbodymodelPackageImpl#getHumanLink()
	 * @generated
	 */
	int HUMAN_LINK = 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_LINK__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_LINK__TARGET = 1;

	/**
	 * The number of structural features of the '<em>Human Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_LINK_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link humanbodymodel.Human <em>Human</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Human</em>'.
	 * @see humanbodymodel.Human
	 * @generated
	 */
	EClass getHuman();

	/**
	 * Returns the meta object for class '{@link humanbodymodel.PositionedElement <em>Positioned Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Positioned Element</em>'.
	 * @see humanbodymodel.PositionedElement
	 * @generated
	 */
	EClass getPositionedElement();

	/**
	 * Returns the meta object for the attribute '{@link humanbodymodel.PositionedElement#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see humanbodymodel.PositionedElement#getX()
	 * @see #getPositionedElement()
	 * @generated
	 */
	EAttribute getPositionedElement_X();

	/**
	 * Returns the meta object for the attribute '{@link humanbodymodel.PositionedElement#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see humanbodymodel.PositionedElement#getY()
	 * @see #getPositionedElement()
	 * @generated
	 */
	EAttribute getPositionedElement_Y();

	/**
	 * Returns the meta object for the attribute '{@link humanbodymodel.PositionedElement#getZ <em>Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Z</em>'.
	 * @see humanbodymodel.PositionedElement#getZ()
	 * @see #getPositionedElement()
	 * @generated
	 */
	EAttribute getPositionedElement_Z();

	/**
	 * Returns the meta object for the attribute '{@link humanbodymodel.PositionedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see humanbodymodel.PositionedElement#getName()
	 * @see #getPositionedElement()
	 * @generated
	 */
	EAttribute getPositionedElement_Name();

	/**
	 * Returns the meta object for the reference list '{@link humanbodymodel.PositionedElement#getIncomingLinks <em>Incoming Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Links</em>'.
	 * @see humanbodymodel.PositionedElement#getIncomingLinks()
	 * @see #getPositionedElement()
	 * @generated
	 */
	EReference getPositionedElement_IncomingLinks();

	/**
	 * Returns the meta object for the reference list '{@link humanbodymodel.PositionedElement#getOutgoingLinks <em>Outgoing Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Links</em>'.
	 * @see humanbodymodel.PositionedElement#getOutgoingLinks()
	 * @see #getPositionedElement()
	 * @generated
	 */
	EReference getPositionedElement_OutgoingLinks();

	/**
	 * Returns the meta object for the attribute '{@link humanbodymodel.PositionedElement#getColor_r <em>Color r</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color r</em>'.
	 * @see humanbodymodel.PositionedElement#getColor_r()
	 * @see #getPositionedElement()
	 * @generated
	 */
	EAttribute getPositionedElement_Color_r();

	/**
	 * Returns the meta object for the attribute '{@link humanbodymodel.PositionedElement#getColor_g <em>Color g</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color g</em>'.
	 * @see humanbodymodel.PositionedElement#getColor_g()
	 * @see #getPositionedElement()
	 * @generated
	 */
	EAttribute getPositionedElement_Color_g();

	/**
	 * Returns the meta object for the attribute '{@link humanbodymodel.PositionedElement#getColor_b <em>Color b</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color b</em>'.
	 * @see humanbodymodel.PositionedElement#getColor_b()
	 * @see #getPositionedElement()
	 * @generated
	 */
	EAttribute getPositionedElement_Color_b();

	/**
	 * Returns the meta object for class '{@link humanbodymodel.HumanContainer <em>Human Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Human Container</em>'.
	 * @see humanbodymodel.HumanContainer
	 * @generated
	 */
	EClass getHumanContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link humanbodymodel.HumanContainer#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see humanbodymodel.HumanContainer#getElements()
	 * @see #getHumanContainer()
	 * @generated
	 */
	EReference getHumanContainer_Elements();

	/**
	 * Returns the meta object for the reference list '{@link humanbodymodel.HumanContainer#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Links</em>'.
	 * @see humanbodymodel.HumanContainer#getLinks()
	 * @see #getHumanContainer()
	 * @generated
	 */
	EReference getHumanContainer_Links();

	/**
	 * Returns the meta object for class '{@link humanbodymodel.HumanLink <em>Human Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Human Link</em>'.
	 * @see humanbodymodel.HumanLink
	 * @generated
	 */
	EClass getHumanLink();

	/**
	 * Returns the meta object for the reference '{@link humanbodymodel.HumanLink#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see humanbodymodel.HumanLink#getSource()
	 * @see #getHumanLink()
	 * @generated
	 */
	EReference getHumanLink_Source();

	/**
	 * Returns the meta object for the reference '{@link humanbodymodel.HumanLink#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see humanbodymodel.HumanLink#getTarget()
	 * @see #getHumanLink()
	 * @generated
	 */
	EReference getHumanLink_Target();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HumanbodymodelFactory getHumanbodymodelFactory();

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
		 * The meta object literal for the '{@link humanbodymodel.impl.HumanImpl <em>Human</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see humanbodymodel.impl.HumanImpl
		 * @see humanbodymodel.impl.HumanbodymodelPackageImpl#getHuman()
		 * @generated
		 */
		EClass HUMAN = eINSTANCE.getHuman();

		/**
		 * The meta object literal for the '{@link humanbodymodel.impl.PositionedElementImpl <em>Positioned Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see humanbodymodel.impl.PositionedElementImpl
		 * @see humanbodymodel.impl.HumanbodymodelPackageImpl#getPositionedElement()
		 * @generated
		 */
		EClass POSITIONED_ELEMENT = eINSTANCE.getPositionedElement();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSITIONED_ELEMENT__X = eINSTANCE.getPositionedElement_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSITIONED_ELEMENT__Y = eINSTANCE.getPositionedElement_Y();

		/**
		 * The meta object literal for the '<em><b>Z</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSITIONED_ELEMENT__Z = eINSTANCE.getPositionedElement_Z();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSITIONED_ELEMENT__NAME = eINSTANCE.getPositionedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Incoming Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POSITIONED_ELEMENT__INCOMING_LINKS = eINSTANCE.getPositionedElement_IncomingLinks();

		/**
		 * The meta object literal for the '<em><b>Outgoing Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POSITIONED_ELEMENT__OUTGOING_LINKS = eINSTANCE.getPositionedElement_OutgoingLinks();

		/**
		 * The meta object literal for the '<em><b>Color r</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSITIONED_ELEMENT__COLOR_R = eINSTANCE.getPositionedElement_Color_r();

		/**
		 * The meta object literal for the '<em><b>Color g</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSITIONED_ELEMENT__COLOR_G = eINSTANCE.getPositionedElement_Color_g();

		/**
		 * The meta object literal for the '<em><b>Color b</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSITIONED_ELEMENT__COLOR_B = eINSTANCE.getPositionedElement_Color_b();

		/**
		 * The meta object literal for the '{@link humanbodymodel.impl.HumanContainerImpl <em>Human Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see humanbodymodel.impl.HumanContainerImpl
		 * @see humanbodymodel.impl.HumanbodymodelPackageImpl#getHumanContainer()
		 * @generated
		 */
		EClass HUMAN_CONTAINER = eINSTANCE.getHumanContainer();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HUMAN_CONTAINER__ELEMENTS = eINSTANCE.getHumanContainer_Elements();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HUMAN_CONTAINER__LINKS = eINSTANCE.getHumanContainer_Links();

		/**
		 * The meta object literal for the '{@link humanbodymodel.impl.HumanLinkImpl <em>Human Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see humanbodymodel.impl.HumanLinkImpl
		 * @see humanbodymodel.impl.HumanbodymodelPackageImpl#getHumanLink()
		 * @generated
		 */
		EClass HUMAN_LINK = eINSTANCE.getHumanLink();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HUMAN_LINK__SOURCE = eINSTANCE.getHumanLink_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HUMAN_LINK__TARGET = eINSTANCE.getHumanLink_Target();

	}

} //HumanbodymodelPackage
