/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import org.unicase.model.UnicaseModelElement;
import scrm.SCRMModelElement;
import scrm.requirements.*;
import scrm.SCRMSpace;
import scrm.requirements.Constraint;
import scrm.requirements.Feature;
import scrm.requirements.Hardware;
import scrm.requirements.IRequirement;
import scrm.requirements.Interface;
import scrm.requirements.Performance;
import scrm.requirements.Requirement;
import scrm.requirements.RequirementSpace;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.SoftwareInterface;
import scrm.requirements.UserInterface;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see scrm.requirements.RequirementsPackage
 * @generated
 */
public class RequirementsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RequirementsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = RequirementsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementsSwitch<Adapter> modelSwitch = new RequirementsSwitch<Adapter>() {
		@Override
		public Adapter caseIRequirement(IRequirement object) {
			return createIRequirementAdapter();
		}

		@Override
		public Adapter caseInterface(Interface object) {
			return createInterfaceAdapter();
		}

		@Override
		public Adapter caseRequirement(Requirement object) {
			return createRequirementAdapter();
		}

		@Override
		public Adapter caseFeature(Feature object) {
			return createFeatureAdapter();
		}

		@Override
		public Adapter caseHardware(Hardware object) {
			return createHardwareAdapter();
		}

		@Override
		public Adapter caseConstraint(Constraint object) {
			return createConstraintAdapter();
		}

		@Override
		public Adapter caseUserInterface(UserInterface object) {
			return createUserInterfaceAdapter();
		}

		@Override
		public Adapter caseSoftwareInterface(SoftwareInterface object) {
			return createSoftwareInterfaceAdapter();
		}

		@Override
		public Adapter casePerformance(Performance object) {
			return createPerformanceAdapter();
		}

		@Override
		public Adapter caseUnicaseModelElement(UnicaseModelElement object) {
			return createUnicaseModelElementAdapter();
		}

		@Override
		public Adapter caseSCRMModelElement(SCRMModelElement object) {
			return createSCRMModelElementAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.IRequirement <em>IRequirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.IRequirement
	 * @generated
	 */
	public Adapter createIRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.Interface
	 * @generated
	 */
	public Adapter createInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.Feature
	 * @generated
	 */
	public Adapter createFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.Hardware <em>Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.Hardware
	 * @generated
	 */
	public Adapter createHardwareAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.Requirement
	 * @generated
	 */
	public Adapter createRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.UserInterface <em>User Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.UserInterface
	 * @generated
	 */
	public Adapter createUserInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.SoftwareInterface <em>Software Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.SoftwareInterface
	 * @generated
	 */
	public Adapter createSoftwareInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.Performance <em>Performance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.Performance
	 * @generated
	 */
	public Adapter createPerformanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.model.UnicaseModelElement <em>Unicase Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.model.UnicaseModelElement
	 * @generated
	 */
	public Adapter createUnicaseModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.SCRMModelElement <em>SCRM Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.SCRMModelElement
	 * @generated
	 */
	public Adapter createSCRMModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //RequirementsAdapterFactory
