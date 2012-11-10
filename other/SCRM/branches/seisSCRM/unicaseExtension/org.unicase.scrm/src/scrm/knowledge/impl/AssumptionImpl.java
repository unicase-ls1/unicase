/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import scrm.impl.SCRMModelElementImpl;
import scrm.knowledge.Assumption;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.KnowledgeSpace;
import scrm.knowledge.Mathematical_GeophysicalModel;
import scrm.knowledge.NumericalMethod;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assumption</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.knowledge.impl.AssumptionImpl#getDependingModel <em>Depending Model</em>}</li>
 *   <li>{@link scrm.knowledge.impl.AssumptionImpl#getDependingMethod <em>Depending Method</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssumptionImpl extends SCRMModelElementImpl implements Assumption {
	/**
	 * The cached value of the '{@link #getDependingModel() <em>Depending Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependingModel()
	 * @generated
	 * @ordered
	 */
	protected Mathematical_GeophysicalModel dependingModel;

	/**
	 * The cached value of the '{@link #getDependingMethod() <em>Depending Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependingMethod()
	 * @generated
	 * @ordered
	 */
	protected NumericalMethod dependingMethod;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssumptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KnowledgePackage.Literals.ASSUMPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mathematical_GeophysicalModel getDependingModel() {
		if (dependingModel != null && dependingModel.eIsProxy()) {
			InternalEObject oldDependingModel = (InternalEObject) dependingModel;
			dependingModel = (Mathematical_GeophysicalModel) eResolveProxy(oldDependingModel);
			if (dependingModel != oldDependingModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							KnowledgePackage.ASSUMPTION__DEPENDING_MODEL,
							oldDependingModel, dependingModel));
			}
		}
		return dependingModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mathematical_GeophysicalModel basicGetDependingModel() {
		return dependingModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependingModel(
			Mathematical_GeophysicalModel newDependingModel,
			NotificationChain msgs) {
		Mathematical_GeophysicalModel oldDependingModel = dependingModel;
		dependingModel = newDependingModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					KnowledgePackage.ASSUMPTION__DEPENDING_MODEL,
					oldDependingModel, newDependingModel);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependingModel(
			Mathematical_GeophysicalModel newDependingModel) {
		if (newDependingModel != dependingModel) {
			NotificationChain msgs = null;
			if (dependingModel != null)
				msgs = ((InternalEObject) dependingModel)
						.eInverseRemove(
								this,
								KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__DEPENDENCIES,
								Mathematical_GeophysicalModel.class, msgs);
			if (newDependingModel != null)
				msgs = ((InternalEObject) newDependingModel)
						.eInverseAdd(
								this,
								KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__DEPENDENCIES,
								Mathematical_GeophysicalModel.class, msgs);
			msgs = basicSetDependingModel(newDependingModel, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					KnowledgePackage.ASSUMPTION__DEPENDING_MODEL,
					newDependingModel, newDependingModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericalMethod getDependingMethod() {
		if (dependingMethod != null && dependingMethod.eIsProxy()) {
			InternalEObject oldDependingMethod = (InternalEObject) dependingMethod;
			dependingMethod = (NumericalMethod) eResolveProxy(oldDependingMethod);
			if (dependingMethod != oldDependingMethod) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							KnowledgePackage.ASSUMPTION__DEPENDING_METHOD,
							oldDependingMethod, dependingMethod));
			}
		}
		return dependingMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericalMethod basicGetDependingMethod() {
		return dependingMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependingMethod(
			NumericalMethod newDependingMethod, NotificationChain msgs) {
		NumericalMethod oldDependingMethod = dependingMethod;
		dependingMethod = newDependingMethod;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					KnowledgePackage.ASSUMPTION__DEPENDING_METHOD,
					oldDependingMethod, newDependingMethod);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependingMethod(NumericalMethod newDependingMethod) {
		if (newDependingMethod != dependingMethod) {
			NotificationChain msgs = null;
			if (dependingMethod != null)
				msgs = ((InternalEObject) dependingMethod).eInverseRemove(this,
						KnowledgePackage.NUMERICAL_METHOD__DEPENDENCIES,
						NumericalMethod.class, msgs);
			if (newDependingMethod != null)
				msgs = ((InternalEObject) newDependingMethod).eInverseAdd(this,
						KnowledgePackage.NUMERICAL_METHOD__DEPENDENCIES,
						NumericalMethod.class, msgs);
			msgs = basicSetDependingMethod(newDependingMethod, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					KnowledgePackage.ASSUMPTION__DEPENDING_METHOD,
					newDependingMethod, newDependingMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case KnowledgePackage.ASSUMPTION__DEPENDING_MODEL:
			if (dependingModel != null)
				msgs = ((InternalEObject) dependingModel)
						.eInverseRemove(
								this,
								KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__DEPENDENCIES,
								Mathematical_GeophysicalModel.class, msgs);
			return basicSetDependingModel(
					(Mathematical_GeophysicalModel) otherEnd, msgs);
		case KnowledgePackage.ASSUMPTION__DEPENDING_METHOD:
			if (dependingMethod != null)
				msgs = ((InternalEObject) dependingMethod).eInverseRemove(this,
						KnowledgePackage.NUMERICAL_METHOD__DEPENDENCIES,
						NumericalMethod.class, msgs);
			return basicSetDependingMethod((NumericalMethod) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case KnowledgePackage.ASSUMPTION__DEPENDING_MODEL:
			return basicSetDependingModel(null, msgs);
		case KnowledgePackage.ASSUMPTION__DEPENDING_METHOD:
			return basicSetDependingMethod(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case KnowledgePackage.ASSUMPTION__DEPENDING_MODEL:
			if (resolve)
				return getDependingModel();
			return basicGetDependingModel();
		case KnowledgePackage.ASSUMPTION__DEPENDING_METHOD:
			if (resolve)
				return getDependingMethod();
			return basicGetDependingMethod();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case KnowledgePackage.ASSUMPTION__DEPENDING_MODEL:
			setDependingModel((Mathematical_GeophysicalModel) newValue);
			return;
		case KnowledgePackage.ASSUMPTION__DEPENDING_METHOD:
			setDependingMethod((NumericalMethod) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case KnowledgePackage.ASSUMPTION__DEPENDING_MODEL:
			setDependingModel((Mathematical_GeophysicalModel) null);
			return;
		case KnowledgePackage.ASSUMPTION__DEPENDING_METHOD:
			setDependingMethod((NumericalMethod) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case KnowledgePackage.ASSUMPTION__DEPENDING_MODEL:
			return dependingModel != null;
		case KnowledgePackage.ASSUMPTION__DEPENDING_METHOD:
			return dependingMethod != null;
		}
		return super.eIsSet(featureID);
	}

} //AssumptionImpl
