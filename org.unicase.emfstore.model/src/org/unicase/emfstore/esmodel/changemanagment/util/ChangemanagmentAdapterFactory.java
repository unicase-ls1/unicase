/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.changemanagment.ChangePackage;
import org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentPackage;
import org.unicase.emfstore.esmodel.changemanagment.DateVersionSpec;
import org.unicase.emfstore.esmodel.changemanagment.HeadVersionSpec;
import org.unicase.emfstore.esmodel.changemanagment.HistoryInfo;
import org.unicase.emfstore.esmodel.changemanagment.LogMessage;
import org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.changemanagment.TagVersionSpec;
import org.unicase.emfstore.esmodel.changemanagment.Version;
import org.unicase.emfstore.esmodel.changemanagment.VersionSpec;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentPackage
 * @generated
 */
public class ChangemanagmentAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ChangemanagmentPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangemanagmentAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ChangemanagmentPackage.eINSTANCE;
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
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangemanagmentSwitch<Adapter> modelSwitch =
		new ChangemanagmentSwitch<Adapter>() {
			@Override
			public Adapter caseTagVersionSpec(TagVersionSpec object) {
				return createTagVersionSpecAdapter();
			}
			@Override
			public Adapter caseDateVersionSpec(DateVersionSpec object) {
				return createDateVersionSpecAdapter();
			}
			@Override
			public Adapter casePrimaryVersionSpec(PrimaryVersionSpec object) {
				return createPrimaryVersionSpecAdapter();
			}
			@Override
			public Adapter caseVersionSpec(VersionSpec object) {
				return createVersionSpecAdapter();
			}
			@Override
			public Adapter caseLogMessage(LogMessage object) {
				return createLogMessageAdapter();
			}
			@Override
			public Adapter caseChangePackage(ChangePackage object) {
				return createChangePackageAdapter();
			}
			@Override
			public Adapter caseHistoryInfo(HistoryInfo object) {
				return createHistoryInfoAdapter();
			}
			@Override
			public Adapter caseVersion(Version object) {
				return createVersionAdapter();
			}
			@Override
			public Adapter caseHeadVersionSpec(HeadVersionSpec object) {
				return createHeadVersionSpecAdapter();
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
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.esmodel.changemanagment.TagVersionSpec <em>Tag Version Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.changemanagment.TagVersionSpec
	 * @generated
	 */
	public Adapter createTagVersionSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.esmodel.changemanagment.DateVersionSpec <em>Date Version Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.changemanagment.DateVersionSpec
	 * @generated
	 */
	public Adapter createDateVersionSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec <em>Primary Version Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec
	 * @generated
	 */
	public Adapter createPrimaryVersionSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.esmodel.changemanagment.VersionSpec <em>Version Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.changemanagment.VersionSpec
	 * @generated
	 */
	public Adapter createVersionSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.esmodel.changemanagment.LogMessage <em>Log Message</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.changemanagment.LogMessage
	 * @generated
	 */
	public Adapter createLogMessageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.esmodel.changemanagment.ChangePackage <em>Change Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.changemanagment.ChangePackage
	 * @generated
	 */
	public Adapter createChangePackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.esmodel.changemanagment.HistoryInfo <em>History Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.changemanagment.HistoryInfo
	 * @generated
	 */
	public Adapter createHistoryInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.esmodel.changemanagment.Version <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.changemanagment.Version
	 * @generated
	 */
	public Adapter createVersionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.emfstore.esmodel.changemanagment.HeadVersionSpec <em>Head Version Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.emfstore.esmodel.changemanagment.HeadVersionSpec
	 * @generated
	 */
	public Adapter createHeadVersionSpecAdapter() {
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

} //ChangemanagmentAdapterFactory
