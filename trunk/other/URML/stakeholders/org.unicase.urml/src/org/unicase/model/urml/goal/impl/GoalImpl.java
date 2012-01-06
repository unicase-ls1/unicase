/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.goal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.urml.Stakeholder;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.feature.AbstractFeature;
import org.unicase.model.urml.feature.FeaturePackage;
import org.unicase.model.urml.goal.Goal;
import org.unicase.model.urml.goal.GoalPackage;
import org.unicase.model.urml.goal.GoalReference;
import org.unicase.model.urml.goal.GoalType;
import org.unicase.model.urml.impl.UrmlModelElementImpl;
import org.unicase.model.urml.usecase.ApplicationDomainUseCase;
import org.unicase.model.urml.usecase.UsecasePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Goal</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.urml.goal.impl.GoalImpl#isSoft <em>Soft</em>}</li>
 *   <li>{@link org.unicase.model.urml.goal.impl.GoalImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.unicase.model.urml.goal.impl.GoalImpl#getStakeholders <em>Stakeholders</em>}</li>
 *   <li>{@link org.unicase.model.urml.goal.impl.GoalImpl#getRealizedFeatures <em>Realized Features</em>}</li>
 *   <li>{@link org.unicase.model.urml.goal.impl.GoalImpl#getDetailingUseCases <em>Detailing Use Cases</em>}</li>
 *   <li>{@link org.unicase.model.urml.goal.impl.GoalImpl#getSubGoals <em>Sub Goals</em>}</li>
 *   <li>{@link org.unicase.model.urml.goal.impl.GoalImpl#getParentGoal <em>Parent Goal</em>}</li>
 *   <li>{@link org.unicase.model.urml.goal.impl.GoalImpl#getInfluencingGoals <em>Influencing Goals</em>}</li>
 *   <li>{@link org.unicase.model.urml.goal.impl.GoalImpl#getInfluencedGoals <em>Influenced Goals</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GoalImpl extends UrmlModelElementImpl implements Goal {
	/**
	 * The default value of the '{@link #isSoft() <em>Soft</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #isSoft()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SOFT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSoft() <em>Soft</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #isSoft()
	 * @generated
	 * @ordered
	 */
	protected boolean soft = SOFT_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final GoalType TYPE_EDEFAULT = GoalType.BUSINESS_GOAL;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected GoalType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStakeholders() <em>Stakeholders</em>}' reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getStakeholders()
	 * @generated
	 * @ordered
	 */
	protected EList<Stakeholder> stakeholders;

	/**
	 * The cached value of the '{@link #getRealizedFeatures() <em>Realized Features</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRealizedFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFeature> realizedFeatures;

	/**
	 * The cached value of the '{@link #getDetailingUseCases() <em>Detailing Use Cases</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDetailingUseCases()
	 * @generated
	 * @ordered
	 */
	protected ApplicationDomainUseCase detailingUseCases;

	/**
	 * The cached value of the '{@link #getSubGoals() <em>Sub Goals</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubGoals()
	 * @generated
	 * @ordered
	 */
	protected EList<Goal> subGoals;

	/**
	 * The cached value of the '{@link #getInfluencingGoals() <em>Influencing Goals</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInfluencingGoals()
	 * @generated
	 * @ordered
	 */
	protected EList<GoalReference> influencingGoals;

	/**
	 * The cached value of the '{@link #getInfluencedGoals() <em>Influenced Goals</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInfluencedGoals()
	 * @generated
	 * @ordered
	 */
	protected EList<GoalReference> influencedGoals;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected GoalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GoalPackage.Literals.GOAL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSoft() {
		return soft;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSoft(boolean newSoft) {
		boolean oldSoft = soft;
		soft = newSoft;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GoalPackage.GOAL__SOFT, oldSoft, soft));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public GoalType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(GoalType newType) {
		GoalType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GoalPackage.GOAL__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Stakeholder> getStakeholders() {
		if (stakeholders == null) {
			stakeholders = new EObjectWithInverseResolvingEList.ManyInverse<Stakeholder>(
					Stakeholder.class, this, GoalPackage.GOAL__STAKEHOLDERS,
					UrmlPackage.STAKEHOLDER__GOALS);
		}
		return stakeholders;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractFeature> getRealizedFeatures() {
		if (realizedFeatures == null) {
			realizedFeatures = new EObjectWithInverseResolvingEList.ManyInverse<AbstractFeature>(
					AbstractFeature.class, this,
					GoalPackage.GOAL__REALIZED_FEATURES,
					FeaturePackage.ABSTRACT_FEATURE__GOALS);
		}
		return realizedFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationDomainUseCase getDetailingUseCases() {
		if (detailingUseCases != null && detailingUseCases.eIsProxy()) {
			InternalEObject oldDetailingUseCases = (InternalEObject) detailingUseCases;
			detailingUseCases = (ApplicationDomainUseCase) eResolveProxy(oldDetailingUseCases);
			if (detailingUseCases != oldDetailingUseCases) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							GoalPackage.GOAL__DETAILING_USE_CASES,
							oldDetailingUseCases, detailingUseCases));
			}
		}
		return detailingUseCases;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationDomainUseCase basicGetDetailingUseCases() {
		return detailingUseCases;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDetailingUseCases(
			ApplicationDomainUseCase newDetailingUseCases,
			NotificationChain msgs) {
		ApplicationDomainUseCase oldDetailingUseCases = detailingUseCases;
		detailingUseCases = newDetailingUseCases;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, GoalPackage.GOAL__DETAILING_USE_CASES,
					oldDetailingUseCases, newDetailingUseCases);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDetailingUseCases(
			ApplicationDomainUseCase newDetailingUseCases) {
		if (newDetailingUseCases != detailingUseCases) {
			NotificationChain msgs = null;
			if (detailingUseCases != null)
				msgs = ((InternalEObject) detailingUseCases)
						.eInverseRemove(
								this,
								UsecasePackage.APPLICATION_DOMAIN_USE_CASE__DETAILED_GOAL,
								ApplicationDomainUseCase.class, msgs);
			if (newDetailingUseCases != null)
				msgs = ((InternalEObject) newDetailingUseCases)
						.eInverseAdd(
								this,
								UsecasePackage.APPLICATION_DOMAIN_USE_CASE__DETAILED_GOAL,
								ApplicationDomainUseCase.class, msgs);
			msgs = basicSetDetailingUseCases(newDetailingUseCases, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GoalPackage.GOAL__DETAILING_USE_CASES,
					newDetailingUseCases, newDetailingUseCases));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Goal> getSubGoals() {
		if (subGoals == null) {
			subGoals = new EObjectContainmentWithInverseEList.Resolving<Goal>(
					Goal.class, this, GoalPackage.GOAL__SUB_GOALS,
					GoalPackage.GOAL__PARENT_GOAL);
		}
		return subGoals;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Goal getParentGoal() {
		if (eContainerFeatureID() != GoalPackage.GOAL__PARENT_GOAL)
			return null;
		return (Goal) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Goal basicGetParentGoal() {
		if (eContainerFeatureID() != GoalPackage.GOAL__PARENT_GOAL)
			return null;
		return (Goal) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentGoal(Goal newParentGoal,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentGoal,
				GoalPackage.GOAL__PARENT_GOAL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentGoal(Goal newParentGoal) {
		if (newParentGoal != eInternalContainer()
				|| (eContainerFeatureID() != GoalPackage.GOAL__PARENT_GOAL && newParentGoal != null)) {
			if (EcoreUtil.isAncestor(this, newParentGoal))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentGoal != null)
				msgs = ((InternalEObject) newParentGoal).eInverseAdd(this,
						GoalPackage.GOAL__SUB_GOALS, Goal.class, msgs);
			msgs = basicSetParentGoal(newParentGoal, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GoalPackage.GOAL__PARENT_GOAL, newParentGoal, newParentGoal));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GoalReference> getInfluencingGoals() {
		if (influencingGoals == null) {
			influencingGoals = new EObjectWithInverseResolvingEList<GoalReference>(
					GoalReference.class, this,
					GoalPackage.GOAL__INFLUENCING_GOALS,
					GoalPackage.GOAL_REFERENCE__TARGET);
		}
		return influencingGoals;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GoalReference> getInfluencedGoals() {
		if (influencedGoals == null) {
			influencedGoals = new EObjectContainmentWithInverseEList.Resolving<GoalReference>(
					GoalReference.class, this,
					GoalPackage.GOAL__INFLUENCED_GOALS,
					GoalPackage.GOAL_REFERENCE__SOURCE);
		}
		return influencedGoals;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case GoalPackage.GOAL__STAKEHOLDERS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getStakeholders())
					.basicAdd(otherEnd, msgs);
		case GoalPackage.GOAL__REALIZED_FEATURES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRealizedFeatures())
					.basicAdd(otherEnd, msgs);
		case GoalPackage.GOAL__DETAILING_USE_CASES:
			if (detailingUseCases != null)
				msgs = ((InternalEObject) detailingUseCases)
						.eInverseRemove(
								this,
								UsecasePackage.APPLICATION_DOMAIN_USE_CASE__DETAILED_GOAL,
								ApplicationDomainUseCase.class, msgs);
			return basicSetDetailingUseCases(
					(ApplicationDomainUseCase) otherEnd, msgs);
		case GoalPackage.GOAL__SUB_GOALS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSubGoals())
					.basicAdd(otherEnd, msgs);
		case GoalPackage.GOAL__PARENT_GOAL:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentGoal((Goal) otherEnd, msgs);
		case GoalPackage.GOAL__INFLUENCING_GOALS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getInfluencingGoals())
					.basicAdd(otherEnd, msgs);
		case GoalPackage.GOAL__INFLUENCED_GOALS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getInfluencedGoals())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case GoalPackage.GOAL__STAKEHOLDERS:
			return ((InternalEList<?>) getStakeholders()).basicRemove(otherEnd,
					msgs);
		case GoalPackage.GOAL__REALIZED_FEATURES:
			return ((InternalEList<?>) getRealizedFeatures()).basicRemove(
					otherEnd, msgs);
		case GoalPackage.GOAL__DETAILING_USE_CASES:
			return basicSetDetailingUseCases(null, msgs);
		case GoalPackage.GOAL__SUB_GOALS:
			return ((InternalEList<?>) getSubGoals()).basicRemove(otherEnd,
					msgs);
		case GoalPackage.GOAL__PARENT_GOAL:
			return basicSetParentGoal(null, msgs);
		case GoalPackage.GOAL__INFLUENCING_GOALS:
			return ((InternalEList<?>) getInfluencingGoals()).basicRemove(
					otherEnd, msgs);
		case GoalPackage.GOAL__INFLUENCED_GOALS:
			return ((InternalEList<?>) getInfluencedGoals()).basicRemove(
					otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case GoalPackage.GOAL__PARENT_GOAL:
			return eInternalContainer().eInverseRemove(this,
					GoalPackage.GOAL__SUB_GOALS, Goal.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case GoalPackage.GOAL__SOFT:
			return isSoft();
		case GoalPackage.GOAL__TYPE:
			return getType();
		case GoalPackage.GOAL__STAKEHOLDERS:
			return getStakeholders();
		case GoalPackage.GOAL__REALIZED_FEATURES:
			return getRealizedFeatures();
		case GoalPackage.GOAL__DETAILING_USE_CASES:
			if (resolve)
				return getDetailingUseCases();
			return basicGetDetailingUseCases();
		case GoalPackage.GOAL__SUB_GOALS:
			return getSubGoals();
		case GoalPackage.GOAL__PARENT_GOAL:
			if (resolve)
				return getParentGoal();
			return basicGetParentGoal();
		case GoalPackage.GOAL__INFLUENCING_GOALS:
			return getInfluencingGoals();
		case GoalPackage.GOAL__INFLUENCED_GOALS:
			return getInfluencedGoals();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case GoalPackage.GOAL__SOFT:
			setSoft((Boolean) newValue);
			return;
		case GoalPackage.GOAL__TYPE:
			setType((GoalType) newValue);
			return;
		case GoalPackage.GOAL__STAKEHOLDERS:
			getStakeholders().clear();
			getStakeholders().addAll(
					(Collection<? extends Stakeholder>) newValue);
			return;
		case GoalPackage.GOAL__REALIZED_FEATURES:
			getRealizedFeatures().clear();
			getRealizedFeatures().addAll(
					(Collection<? extends AbstractFeature>) newValue);
			return;
		case GoalPackage.GOAL__DETAILING_USE_CASES:
			setDetailingUseCases((ApplicationDomainUseCase) newValue);
			return;
		case GoalPackage.GOAL__SUB_GOALS:
			getSubGoals().clear();
			getSubGoals().addAll((Collection<? extends Goal>) newValue);
			return;
		case GoalPackage.GOAL__PARENT_GOAL:
			setParentGoal((Goal) newValue);
			return;
		case GoalPackage.GOAL__INFLUENCING_GOALS:
			getInfluencingGoals().clear();
			getInfluencingGoals().addAll(
					(Collection<? extends GoalReference>) newValue);
			return;
		case GoalPackage.GOAL__INFLUENCED_GOALS:
			getInfluencedGoals().clear();
			getInfluencedGoals().addAll(
					(Collection<? extends GoalReference>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case GoalPackage.GOAL__SOFT:
			setSoft(SOFT_EDEFAULT);
			return;
		case GoalPackage.GOAL__TYPE:
			setType(TYPE_EDEFAULT);
			return;
		case GoalPackage.GOAL__STAKEHOLDERS:
			getStakeholders().clear();
			return;
		case GoalPackage.GOAL__REALIZED_FEATURES:
			getRealizedFeatures().clear();
			return;
		case GoalPackage.GOAL__DETAILING_USE_CASES:
			setDetailingUseCases((ApplicationDomainUseCase) null);
			return;
		case GoalPackage.GOAL__SUB_GOALS:
			getSubGoals().clear();
			return;
		case GoalPackage.GOAL__PARENT_GOAL:
			setParentGoal((Goal) null);
			return;
		case GoalPackage.GOAL__INFLUENCING_GOALS:
			getInfluencingGoals().clear();
			return;
		case GoalPackage.GOAL__INFLUENCED_GOALS:
			getInfluencedGoals().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case GoalPackage.GOAL__SOFT:
			return soft != SOFT_EDEFAULT;
		case GoalPackage.GOAL__TYPE:
			return type != TYPE_EDEFAULT;
		case GoalPackage.GOAL__STAKEHOLDERS:
			return stakeholders != null && !stakeholders.isEmpty();
		case GoalPackage.GOAL__REALIZED_FEATURES:
			return realizedFeatures != null && !realizedFeatures.isEmpty();
		case GoalPackage.GOAL__DETAILING_USE_CASES:
			return detailingUseCases != null;
		case GoalPackage.GOAL__SUB_GOALS:
			return subGoals != null && !subGoals.isEmpty();
		case GoalPackage.GOAL__PARENT_GOAL:
			return basicGetParentGoal() != null;
		case GoalPackage.GOAL__INFLUENCING_GOALS:
			return influencingGoals != null && !influencingGoals.isEmpty();
		case GoalPackage.GOAL__INFLUENCED_GOALS:
			return influencedGoals != null && !influencedGoals.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (soft: ");
		result.append(soft);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} // GoalImpl
