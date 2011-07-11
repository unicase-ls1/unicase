/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.goal.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.ecp.model.workSpaceModel.util.AssociationClassHelper;
import org.unicase.model.urml.goal.Goal;
import org.unicase.model.urml.goal.GoalPackage;
import org.unicase.model.urml.goal.GoalReference;
import org.unicase.model.urml.goal.GoalReferenceType;
import org.unicase.model.urml.impl.UrmlModelElementImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.urml.goal.impl.GoalReferenceImpl#getSource <em>Source</em>}</li>
 * <li>{@link org.unicase.model.urml.goal.impl.GoalReferenceImpl#getTarget <em>Target</em>}</li>
 * <li>{@link org.unicase.model.urml.goal.impl.GoalReferenceImpl#getWeight <em>Weight</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GoalReferenceImpl extends UrmlModelElementImpl implements GoalReference {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Goal target;

	/**
	 * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected static final GoalReferenceType WEIGHT_EDEFAULT = GoalReferenceType.PLUS_PLUS;

	/**
	 * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected GoalReferenceType weight = WEIGHT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected GoalReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GoalPackage.Literals.GOAL_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Goal getSource() {
		if (eContainerFeatureID() != GoalPackage.GOAL_REFERENCE__SOURCE)
			return null;
		return (Goal) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Goal basicGetSource() {
		if (eContainerFeatureID() != GoalPackage.GOAL_REFERENCE__SOURCE)
			return null;
		return (Goal) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetSource(Goal newSource, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newSource, GoalPackage.GOAL_REFERENCE__SOURCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSource(Goal newSource) {
		if (newSource != eInternalContainer()
			|| (eContainerFeatureID() != GoalPackage.GOAL_REFERENCE__SOURCE && newSource != null)) {
			if (EcoreUtil.isAncestor(this, newSource))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSource != null)
				msgs = ((InternalEObject) newSource).eInverseAdd(this, GoalPackage.GOAL__INFLUENCED_GOALS, Goal.class,
					msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalPackage.GOAL_REFERENCE__SOURCE, newSource,
				newSource));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Goal getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject) target;
			target = (Goal) eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GoalPackage.GOAL_REFERENCE__TARGET,
						oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Goal basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetTarget(Goal newTarget, NotificationChain msgs) {
		Goal oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				GoalPackage.GOAL_REFERENCE__TARGET, oldTarget, newTarget);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTarget(Goal newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject) target).eInverseRemove(this, GoalPackage.GOAL__INFLUENCING_GOALS, Goal.class,
					msgs);
			if (newTarget != null)
				msgs = ((InternalEObject) newTarget).eInverseAdd(this, GoalPackage.GOAL__INFLUENCING_GOALS, Goal.class,
					msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalPackage.GOAL_REFERENCE__TARGET, newTarget,
				newTarget));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GoalReferenceType getWeight() {
		return weight;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setWeight(GoalReferenceType newWeight) {
		GoalReferenceType oldWeight = weight;
		weight = newWeight == null ? WEIGHT_EDEFAULT : newWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GoalPackage.GOAL_REFERENCE__WEIGHT, oldWeight, weight));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case GoalPackage.GOAL_REFERENCE__SOURCE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetSource((Goal) otherEnd, msgs);
		case GoalPackage.GOAL_REFERENCE__TARGET:
			if (target != null)
				msgs = ((InternalEObject) target).eInverseRemove(this, GoalPackage.GOAL__INFLUENCING_GOALS, Goal.class,
					msgs);
			return basicSetTarget((Goal) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case GoalPackage.GOAL_REFERENCE__SOURCE:
			return basicSetSource(null, msgs);
		case GoalPackage.GOAL_REFERENCE__TARGET:
			return basicSetTarget(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case GoalPackage.GOAL_REFERENCE__SOURCE:
			return eInternalContainer().eInverseRemove(this, GoalPackage.GOAL__INFLUENCED_GOALS, Goal.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case GoalPackage.GOAL_REFERENCE__SOURCE:
			if (resolve)
				return getSource();
			return basicGetSource();
		case GoalPackage.GOAL_REFERENCE__TARGET:
			if (resolve)
				return getTarget();
			return basicGetTarget();
		case GoalPackage.GOAL_REFERENCE__WEIGHT:
			return getWeight();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case GoalPackage.GOAL_REFERENCE__SOURCE:
			setSource((Goal) newValue);
			return;
		case GoalPackage.GOAL_REFERENCE__TARGET:
			setTarget((Goal) newValue);
			return;
		case GoalPackage.GOAL_REFERENCE__WEIGHT:
			setWeight((GoalReferenceType) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case GoalPackage.GOAL_REFERENCE__SOURCE:
			setSource((Goal) null);
			return;
		case GoalPackage.GOAL_REFERENCE__TARGET:
			setTarget((Goal) null);
			return;
		case GoalPackage.GOAL_REFERENCE__WEIGHT:
			setWeight(WEIGHT_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case GoalPackage.GOAL_REFERENCE__SOURCE:
			return basicGetSource() != null;
		case GoalPackage.GOAL_REFERENCE__TARGET:
			return target != null;
		case GoalPackage.GOAL_REFERENCE__WEIGHT:
			return weight != WEIGHT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (weight: ");
		result.append(weight);
		result.append(')');
		return result.toString();
	}

	public List<EStructuralFeature> getAssociationFeatures() {
		return AssociationClassHelper.getAssociationFeatures(GoalPackage.eINSTANCE.getGoalReference(),
			getSourceFeature(), getTargetFeature());
	}

	public EReference getSourceFeature() {
		return GoalPackage.eINSTANCE.getGoalReference_Source();
	}

	public EReference getTargetFeature() {
		return GoalPackage.eINSTANCE.getGoalReference_Target();
	}

} // GoalReferenceImpl
