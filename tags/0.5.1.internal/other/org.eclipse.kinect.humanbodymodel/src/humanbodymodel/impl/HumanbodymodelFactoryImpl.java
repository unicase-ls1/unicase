/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package humanbodymodel.impl;

import humanbodymodel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HumanbodymodelFactoryImpl extends EFactoryImpl implements HumanbodymodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HumanbodymodelFactory init() {
		try {
			HumanbodymodelFactory theHumanbodymodelFactory = (HumanbodymodelFactory)EPackage.Registry.INSTANCE.getEFactory("http://org/eclipse/kinect/humanbodymodel"); 
			if (theHumanbodymodelFactory != null) {
				return theHumanbodymodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new HumanbodymodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HumanbodymodelFactoryImpl() {
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
			case HumanbodymodelPackage.HUMAN: return createHuman();
			case HumanbodymodelPackage.POSITIONED_ELEMENT: return createPositionedElement();
			case HumanbodymodelPackage.HUMAN_CONTAINER: return createHumanContainer();
			case HumanbodymodelPackage.HUMAN_LINK: return createHumanLink();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Human createHuman() {
		HumanImpl human = new HumanImpl();
		return human;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PositionedElement createPositionedElement() {
		PositionedElementImpl positionedElement = new PositionedElementImpl();
		return positionedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HumanContainer createHumanContainer() {
		HumanContainerImpl humanContainer = new HumanContainerImpl();
		return humanContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HumanLink createHumanLink() {
		HumanLinkImpl humanLink = new HumanLinkImpl();
		return humanLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HumanbodymodelPackage getHumanbodymodelPackage() {
		return (HumanbodymodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static HumanbodymodelPackage getPackage() {
		return HumanbodymodelPackage.eINSTANCE;
	}

} //HumanbodymodelFactoryImpl
