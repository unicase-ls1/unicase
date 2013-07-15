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
import scrm.knowledge.MathematicalModel;
import scrm.knowledge.NumericalMethod;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assumption</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.knowledge.impl.AssumptionImpl#getContainingKnowledgeSpace <em>Containing Knowledge Space</em>}</li>
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
	protected MathematicalModel dependingModel;

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
	public KnowledgeSpace getContainingKnowledgeSpace() {
		if (eContainerFeatureID() != KnowledgePackage.ASSUMPTION__CONTAINING_KNOWLEDGE_SPACE)
			return null;
		return (KnowledgeSpace) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KnowledgeSpace basicGetContainingKnowledgeSpace() {
		if (eContainerFeatureID() != KnowledgePackage.ASSUMPTION__CONTAINING_KNOWLEDGE_SPACE)
			return null;
		return (KnowledgeSpace) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingKnowledgeSpace(
			KnowledgeSpace newContainingKnowledgeSpace, NotificationChain msgs) {
		msgs = eBasicSetContainer(
				(InternalEObject) newContainingKnowledgeSpace,
				KnowledgePackage.ASSUMPTION__CONTAINING_KNOWLEDGE_SPACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingKnowledgeSpace(
			KnowledgeSpace newContainingKnowledgeSpace) {
		if (newContainingKnowledgeSpace != eInternalContainer()
				|| (eContainerFeatureID() != KnowledgePackage.ASSUMPTION__CONTAINING_KNOWLEDGE_SPACE && newContainingKnowledgeSpace != null)) {
			if (EcoreUtil.isAncestor(this, newContainingKnowledgeSpace))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingKnowledgeSpace != null)
				msgs = ((InternalEObject) newContainingKnowledgeSpace)
						.eInverseAdd(
								this,
								KnowledgePackage.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_KNOWLEDGE,
								KnowledgeSpace.class, msgs);
			msgs = basicSetContainingKnowledgeSpace(
					newContainingKnowledgeSpace, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					KnowledgePackage.ASSUMPTION__CONTAINING_KNOWLEDGE_SPACE,
					newContainingKnowledgeSpace, newContainingKnowledgeSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MathematicalModel getDependingModel() {
		if (dependingModel != null && dependingModel.eIsProxy()) {
			InternalEObject oldDependingModel = (InternalEObject) dependingModel;
			dependingModel = (MathematicalModel) eResolveProxy(oldDependingModel);
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
	public MathematicalModel basicGetDependingModel() {
		return dependingModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependingModel(
			MathematicalModel newDependingModel, NotificationChain msgs) {
		MathematicalModel oldDependingModel = dependingModel;
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
	public void setDependingModel(MathematicalModel newDependingModel) {
		if (newDependingModel != dependingModel) {
			NotificationChain msgs = null;
			if (dependingModel != null)
				msgs = ((InternalEObject) dependingModel).eInverseRemove(this,
						KnowledgePackage.MATHEMATICAL_MODEL__DEPENDENCIES,
						MathematicalModel.class, msgs);
			if (newDependingModel != null)
				msgs = ((InternalEObject) newDependingModel).eInverseAdd(this,
						KnowledgePackage.MATHEMATICAL_MODEL__DEPENDENCIES,
						MathematicalModel.class, msgs);
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
		case KnowledgePackage.ASSUMPTION__CONTAINING_KNOWLEDGE_SPACE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContainingKnowledgeSpace((KnowledgeSpace) otherEnd,
					msgs);
		case KnowledgePackage.ASSUMPTION__DEPENDING_MODEL:
			if (dependingModel != null)
				msgs = ((InternalEObject) dependingModel).eInverseRemove(this,
						KnowledgePackage.MATHEMATICAL_MODEL__DEPENDENCIES,
						MathematicalModel.class, msgs);
			return basicSetDependingModel((MathematicalModel) otherEnd, msgs);
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
		case KnowledgePackage.ASSUMPTION__CONTAINING_KNOWLEDGE_SPACE:
			return basicSetContainingKnowledgeSpace(null, msgs);
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
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case KnowledgePackage.ASSUMPTION__CONTAINING_KNOWLEDGE_SPACE:
			return eInternalContainer()
					.eInverseRemove(
							this,
							KnowledgePackage.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_KNOWLEDGE,
							KnowledgeSpace.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case KnowledgePackage.ASSUMPTION__CONTAINING_KNOWLEDGE_SPACE:
			if (resolve)
				return getContainingKnowledgeSpace();
			return basicGetContainingKnowledgeSpace();
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
		case KnowledgePackage.ASSUMPTION__CONTAINING_KNOWLEDGE_SPACE:
			setContainingKnowledgeSpace((KnowledgeSpace) newValue);
			return;
		case KnowledgePackage.ASSUMPTION__DEPENDING_MODEL:
			setDependingModel((MathematicalModel) newValue);
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
		case KnowledgePackage.ASSUMPTION__CONTAINING_KNOWLEDGE_SPACE:
			setContainingKnowledgeSpace((KnowledgeSpace) null);
			return;
		case KnowledgePackage.ASSUMPTION__DEPENDING_MODEL:
			setDependingModel((MathematicalModel) null);
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
		case KnowledgePackage.ASSUMPTION__CONTAINING_KNOWLEDGE_SPACE:
			return basicGetContainingKnowledgeSpace() != null;
		case KnowledgePackage.ASSUMPTION__DEPENDING_MODEL:
			return dependingModel != null;
		case KnowledgePackage.ASSUMPTION__DEPENDING_METHOD:
			return dependingMethod != null;
		}
		return super.eIsSet(featureID);
	}

} //AssumptionImpl
