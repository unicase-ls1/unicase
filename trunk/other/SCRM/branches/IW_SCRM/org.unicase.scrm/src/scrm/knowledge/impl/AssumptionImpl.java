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

import scrm.impl.SCRMModelElementImpl;
import scrm.knowledge.Assumption;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.Method;
import scrm.knowledge.Model;

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
	protected Model dependingModel;

	/**
	 * The cached value of the '{@link #getDependingMethod() <em>Depending Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependingMethod()
	 * @generated
	 * @ordered
	 */
	protected Method dependingMethod;

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
	public Model getDependingModel() {
		if (dependingModel != null && dependingModel.eIsProxy()) {
			InternalEObject oldDependingModel = (InternalEObject) dependingModel;
			dependingModel = (Model) eResolveProxy(oldDependingModel);
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
	public Model basicGetDependingModel() {
		return dependingModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependingModel(Model newDependingModel,
			NotificationChain msgs) {
		Model oldDependingModel = dependingModel;
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
	public void setDependingModel(Model newDependingModel) {
		if (newDependingModel != dependingModel) {
			NotificationChain msgs = null;
			if (dependingModel != null)
				msgs = ((InternalEObject) dependingModel)
						.eInverseRemove(this,
								KnowledgePackage.MODEL__DEPENDENCIES,
								Model.class, msgs);
			if (newDependingModel != null)
				msgs = ((InternalEObject) newDependingModel)
						.eInverseAdd(this,
								KnowledgePackage.MODEL__DEPENDENCIES,
								Model.class, msgs);
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
	public Method getDependingMethod() {
		if (dependingMethod != null && dependingMethod.eIsProxy()) {
			InternalEObject oldDependingMethod = (InternalEObject) dependingMethod;
			dependingMethod = (Method) eResolveProxy(oldDependingMethod);
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
	public Method basicGetDependingMethod() {
		return dependingMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependingMethod(Method newDependingMethod,
			NotificationChain msgs) {
		Method oldDependingMethod = dependingMethod;
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
	public void setDependingMethod(Method newDependingMethod) {
		if (newDependingMethod != dependingMethod) {
			NotificationChain msgs = null;
			if (dependingMethod != null)
				msgs = ((InternalEObject) dependingMethod).eInverseRemove(this,
						KnowledgePackage.METHOD__DEPENDENCIES, Method.class,
						msgs);
			if (newDependingMethod != null)
				msgs = ((InternalEObject) newDependingMethod).eInverseAdd(this,
						KnowledgePackage.METHOD__DEPENDENCIES, Method.class,
						msgs);
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
						.eInverseRemove(this,
								KnowledgePackage.MODEL__DEPENDENCIES,
								Model.class, msgs);
			return basicSetDependingModel((Model) otherEnd, msgs);
		case KnowledgePackage.ASSUMPTION__DEPENDING_METHOD:
			if (dependingMethod != null)
				msgs = ((InternalEObject) dependingMethod).eInverseRemove(this,
						KnowledgePackage.METHOD__DEPENDENCIES, Method.class,
						msgs);
			return basicSetDependingMethod((Method) otherEnd, msgs);
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
			setDependingModel((Model) newValue);
			return;
		case KnowledgePackage.ASSUMPTION__DEPENDING_METHOD:
			setDependingMethod((Method) newValue);
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
			setDependingModel((Model) null);
			return;
		case KnowledgePackage.ASSUMPTION__DEPENDING_METHOD:
			setDependingMethod((Method) null);
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
