/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import scrm.requirements.ComputionalHardware;
import scrm.requirements.Constraint;
import scrm.requirements.Feature;
import scrm.requirements.HardwareInterface;
import scrm.requirements.Performance;
import scrm.requirements.RegulatoryPolicy;
import scrm.requirements.Requirement;
import scrm.requirements.RequirementsFactory;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.SoftwareInterface;
import scrm.requirements.UserInterface;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RequirementsFactoryImpl extends EFactoryImpl implements
		RequirementsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RequirementsFactory init() {
		try {
			RequirementsFactory theRequirementsFactory = (RequirementsFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://unicase.org/model/scrm/requirements");
			if (theRequirementsFactory != null) {
				return theRequirementsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RequirementsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementsFactoryImpl() {
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
		case RequirementsPackage.REQUIREMENT:
			return createRequirement();
		case RequirementsPackage.FEATURE:
			return createFeature();
		case RequirementsPackage.COMPUTIONAL_HARDWARE:
			return createComputionalHardware();
		case RequirementsPackage.CONSTRAINT:
			return createConstraint();
		case RequirementsPackage.USER_INTERFACE:
			return createUserInterface();
		case RequirementsPackage.SOFTWARE_INTERFACE:
			return createSoftwareInterface();
		case RequirementsPackage.PERFORMANCE:
			return createPerformance();
		case RequirementsPackage.HARDWARE_INTERFACE:
			return createHardwareInterface();
		case RequirementsPackage.REGULATORY_POLICY:
			return createRegulatoryPolicy();
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
	public Feature createFeature() {
		FeatureImpl feature = new FeatureImpl();
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputionalHardware createComputionalHardware() {
		ComputionalHardwareImpl computionalHardware = new ComputionalHardwareImpl();
		return computionalHardware;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint createConstraint() {
		ConstraintImpl constraint = new ConstraintImpl();
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement createRequirement() {
		RequirementImpl requirement = new RequirementImpl();
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserInterface createUserInterface() {
		UserInterfaceImpl userInterface = new UserInterfaceImpl();
		return userInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwareInterface createSoftwareInterface() {
		SoftwareInterfaceImpl softwareInterface = new SoftwareInterfaceImpl();
		return softwareInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Performance createPerformance() {
		PerformanceImpl performance = new PerformanceImpl();
		return performance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HardwareInterface createHardwareInterface() {
		HardwareInterfaceImpl hardwareInterface = new HardwareInterfaceImpl();
		return hardwareInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegulatoryPolicy createRegulatoryPolicy() {
		RegulatoryPolicyImpl regulatoryPolicy = new RegulatoryPolicyImpl();
		return regulatoryPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementsPackage getRequirementsPackage() {
		return (RequirementsPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RequirementsPackage getPackage() {
		return RequirementsPackage.eINSTANCE;
	}

} //RequirementsFactoryImpl
