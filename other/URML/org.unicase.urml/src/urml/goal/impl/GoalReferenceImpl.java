/**
 * <copyright> </copyright> $Id$
 */
package urml.goal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.urml.impl.UrmlModelElementImpl;

import urml.goal.Goal;
import urml.goal.GoalPackage;
import urml.goal.GoalReference;
import urml.goal.GoalReferenceType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link urml.goal.impl.GoalReferenceImpl#getSource <em>Source</em>}</li>
 * <li>{@link urml.goal.impl.GoalReferenceImpl#getTarget <em>Target</em>}</li>
 * <li>{@link urml.goal.impl.GoalReferenceImpl#getWeight <em>Weight</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GoalReferenceImpl extends UrmlModelElementImpl implements GoalReference {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Goal source;

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
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject) source;
			source = (Goal) eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GoalPackage.GOAL_REFERENCE__SOURCE,
						oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Goal basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetSource(Goal newSource, NotificationChain msgs) {
		Goal oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				GoalPackage.GOAL_REFERENCE__SOURCE, oldSource, newSource);
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
	public void setSource(Goal newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject) source).eInverseRemove(this, GoalPackage.GOAL__INFLUENCED_GOALS, Goal.class,
					msgs);
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
			if (source != null)
				msgs = ((InternalEObject) source).eInverseRemove(this, GoalPackage.GOAL__INFLUENCED_GOALS, Goal.class,
					msgs);
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
			return source != null;
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

} // GoalReferenceImpl
