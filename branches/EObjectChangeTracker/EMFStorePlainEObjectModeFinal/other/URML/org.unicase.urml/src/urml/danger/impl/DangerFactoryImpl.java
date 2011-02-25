/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package urml.danger.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import urml.danger.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DangerFactoryImpl extends EFactoryImpl implements DangerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DangerFactory init() {
		try {
			DangerFactory theDangerFactory = (DangerFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://unicase.org/model/urml/danger");
			if (theDangerFactory != null) {
				return theDangerFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DangerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DangerFactoryImpl() {
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
		case DangerPackage.DANGER:
			return createDanger();
		case DangerPackage.PROCEDURAL_MITIGATION:
			return createProceduralMitigation();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Danger createDanger() {
		DangerImpl danger = new DangerImpl();
		return danger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProceduralMitigation createProceduralMitigation() {
		ProceduralMitigationImpl proceduralMitigation = new ProceduralMitigationImpl();
		return proceduralMitigation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DangerPackage getDangerPackage() {
		return (DangerPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DangerPackage getPackage() {
		return DangerPackage.eINSTANCE;
	}

} //DangerFactoryImpl
