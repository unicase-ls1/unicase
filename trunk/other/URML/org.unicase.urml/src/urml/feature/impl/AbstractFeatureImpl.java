/**
 * <copyright> </copyright> $Id$
 */
package urml.feature.impl;

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
import org.unicase.model.urml.impl.UrmlModelElementImpl;

import urml.feature.AbstractFeature;
import urml.feature.FeaturePackage;
import urml.feature.VariationPoint;
import urml.feature.VariationPointInstance;
import urml.goal.Goal;
import urml.goal.GoalPackage;
import urml.requirement.FunctionalRequirement;
import urml.requirement.NonFunctionalRequirement;
import urml.requirement.RequirementPackage;
import urml.usecase.SolutionDomainUseCase;
import urml.usecase.UsecasePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Abstract Feature</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link urml.feature.impl.AbstractFeatureImpl#getGoals <em>Goals</em>}</li>
 * <li>{@link urml.feature.impl.AbstractFeatureImpl#getDetailingFunctionalRequirements <em>Detailing Functional
 * Requirements</em>}</li>
 * <li>{@link urml.feature.impl.AbstractFeatureImpl#getConstrainingNonFunctionalRequirements <em>Constraining Non
 * Functional Requirements</em>}</li>
 * <li>{@link urml.feature.impl.AbstractFeatureImpl#getDetailingUseCases <em>Detailing Use Cases</em>}</li>
 * <li>{@link urml.feature.impl.AbstractFeatureImpl#getParentFeature <em>Parent Feature</em>}</li>
 * <li>{@link urml.feature.impl.AbstractFeatureImpl#getSubFeatures <em>Sub Features</em>}</li>
 * <li>{@link urml.feature.impl.AbstractFeatureImpl#getExcludingFeatures <em>Excluding Features</em>}</li>
 * <li>{@link urml.feature.impl.AbstractFeatureImpl#getExcludedFeatures <em>Excluded Features</em>}</li>
 * <li>{@link urml.feature.impl.AbstractFeatureImpl#getRequieringFeatures <em>Requiering Features</em>}</li>
 * <li>{@link urml.feature.impl.AbstractFeatureImpl#getRequieredFeatures <em>Requiered Features</em>}</li>
 * <li>{@link urml.feature.impl.AbstractFeatureImpl#getVariationPoint <em>Variation Point</em>}</li>
 * <li>{@link urml.feature.impl.AbstractFeatureImpl#getVariationPointInstances <em>Variation Point Instances</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class AbstractFeatureImpl extends UrmlModelElementImpl implements AbstractFeature {
	/**
	 * The cached value of the '{@link #getGoals() <em>Goals</em>}' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getGoals()
	 * @generated
	 * @ordered
	 */
	protected EList<Goal> goals;

	/**
	 * The cached value of the '{@link #getDetailingFunctionalRequirements() <em>Detailing Functional Requirements</em>}
	 * ' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDetailingFunctionalRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionalRequirement> detailingFunctionalRequirements;

	/**
	 * The cached value of the '{@link #getConstrainingNonFunctionalRequirements()
	 * <em>Constraining Non Functional Requirements</em>}' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConstrainingNonFunctionalRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<NonFunctionalRequirement> constrainingNonFunctionalRequirements;

	/**
	 * The cached value of the '{@link #getDetailingUseCases() <em>Detailing Use Cases</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDetailingUseCases()
	 * @generated
	 * @ordered
	 */
	protected EList<SolutionDomainUseCase> detailingUseCases;

	/**
	 * The cached value of the '{@link #getSubFeatures() <em>Sub Features</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFeature> subFeatures;

	/**
	 * The cached value of the '{@link #getExcludingFeatures() <em>Excluding Features</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExcludingFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFeature> excludingFeatures;

	/**
	 * The cached value of the '{@link #getExcludedFeatures() <em>Excluded Features</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExcludedFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFeature> excludedFeatures;

	/**
	 * The cached value of the '{@link #getRequieringFeatures() <em>Requiering Features</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRequieringFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFeature> requieringFeatures;

	/**
	 * The cached value of the '{@link #getRequieredFeatures() <em>Requiered Features</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRequieredFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFeature> requieredFeatures;

	/**
	 * The cached value of the '{@link #getVariationPoint() <em>Variation Point</em>}' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getVariationPoint()
	 * @generated
	 * @ordered
	 */
	protected VariationPoint variationPoint;

	/**
	 * The cached value of the '{@link #getVariationPointInstances() <em>Variation Point Instances</em>}' reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVariationPointInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<VariationPointInstance> variationPointInstances;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AbstractFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FeaturePackage.Literals.ABSTRACT_FEATURE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Goal> getGoals() {
		if (goals == null) {
			goals = new EObjectWithInverseResolvingEList.ManyInverse<Goal>(Goal.class, this,
				FeaturePackage.ABSTRACT_FEATURE__GOALS, GoalPackage.GOAL__REALIZED_FEATURES);
		}
		return goals;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<FunctionalRequirement> getDetailingFunctionalRequirements() {
		if (detailingFunctionalRequirements == null) {
			detailingFunctionalRequirements = new EObjectWithInverseResolvingEList.ManyInverse<FunctionalRequirement>(
				FunctionalRequirement.class, this, FeaturePackage.ABSTRACT_FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS,
				RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES);
		}
		return detailingFunctionalRequirements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<NonFunctionalRequirement> getConstrainingNonFunctionalRequirements() {
		if (constrainingNonFunctionalRequirements == null) {
			constrainingNonFunctionalRequirements = new EObjectWithInverseResolvingEList.ManyInverse<NonFunctionalRequirement>(
				NonFunctionalRequirement.class, this,
				FeaturePackage.ABSTRACT_FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS,
				RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FEATURES);
		}
		return constrainingNonFunctionalRequirements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<SolutionDomainUseCase> getDetailingUseCases() {
		if (detailingUseCases == null) {
			detailingUseCases = new EObjectWithInverseResolvingEList<SolutionDomainUseCase>(
				SolutionDomainUseCase.class, this, FeaturePackage.ABSTRACT_FEATURE__DETAILING_USE_CASES,
				UsecasePackage.SOLUTION_DOMAIN_USE_CASE__DETAILED_FEATURE);
		}
		return detailingUseCases;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AbstractFeature getParentFeature() {
		if (eContainerFeatureID() != FeaturePackage.ABSTRACT_FEATURE__PARENT_FEATURE)
			return null;
		return (AbstractFeature) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AbstractFeature basicGetParentFeature() {
		if (eContainerFeatureID() != FeaturePackage.ABSTRACT_FEATURE__PARENT_FEATURE)
			return null;
		return (AbstractFeature) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetParentFeature(AbstractFeature newParentFeature, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentFeature, FeaturePackage.ABSTRACT_FEATURE__PARENT_FEATURE,
			msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParentFeature(AbstractFeature newParentFeature) {
		if (newParentFeature != eInternalContainer()
			|| (eContainerFeatureID() != FeaturePackage.ABSTRACT_FEATURE__PARENT_FEATURE && newParentFeature != null)) {
			if (EcoreUtil.isAncestor(this, newParentFeature))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentFeature != null)
				msgs = ((InternalEObject) newParentFeature).eInverseAdd(this,
					FeaturePackage.ABSTRACT_FEATURE__SUB_FEATURES, AbstractFeature.class, msgs);
			msgs = basicSetParentFeature(newParentFeature, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturePackage.ABSTRACT_FEATURE__PARENT_FEATURE,
				newParentFeature, newParentFeature));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AbstractFeature> getSubFeatures() {
		if (subFeatures == null) {
			subFeatures = new EObjectContainmentWithInverseEList.Resolving<AbstractFeature>(AbstractFeature.class,
				this, FeaturePackage.ABSTRACT_FEATURE__SUB_FEATURES, FeaturePackage.ABSTRACT_FEATURE__PARENT_FEATURE);
		}
		return subFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AbstractFeature> getExcludingFeatures() {
		if (excludingFeatures == null) {
			excludingFeatures = new EObjectWithInverseResolvingEList.ManyInverse<AbstractFeature>(
				AbstractFeature.class, this, FeaturePackage.ABSTRACT_FEATURE__EXCLUDING_FEATURES,
				FeaturePackage.ABSTRACT_FEATURE__EXCLUDED_FEATURES);
		}
		return excludingFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AbstractFeature> getExcludedFeatures() {
		if (excludedFeatures == null) {
			excludedFeatures = new EObjectWithInverseResolvingEList.ManyInverse<AbstractFeature>(AbstractFeature.class,
				this, FeaturePackage.ABSTRACT_FEATURE__EXCLUDED_FEATURES,
				FeaturePackage.ABSTRACT_FEATURE__EXCLUDING_FEATURES);
		}
		return excludedFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AbstractFeature> getRequieringFeatures() {
		if (requieringFeatures == null) {
			requieringFeatures = new EObjectWithInverseResolvingEList.ManyInverse<AbstractFeature>(
				AbstractFeature.class, this, FeaturePackage.ABSTRACT_FEATURE__REQUIERING_FEATURES,
				FeaturePackage.ABSTRACT_FEATURE__REQUIERED_FEATURES);
		}
		return requieringFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AbstractFeature> getRequieredFeatures() {
		if (requieredFeatures == null) {
			requieredFeatures = new EObjectWithInverseResolvingEList.ManyInverse<AbstractFeature>(
				AbstractFeature.class, this, FeaturePackage.ABSTRACT_FEATURE__REQUIERED_FEATURES,
				FeaturePackage.ABSTRACT_FEATURE__REQUIERING_FEATURES);
		}
		return requieredFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VariationPoint getVariationPoint() {
		if (variationPoint != null && variationPoint.eIsProxy()) {
			InternalEObject oldVariationPoint = (InternalEObject) variationPoint;
			variationPoint = (VariationPoint) eResolveProxy(oldVariationPoint);
			if (variationPoint != oldVariationPoint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						FeaturePackage.ABSTRACT_FEATURE__VARIATION_POINT, oldVariationPoint, variationPoint));
			}
		}
		return variationPoint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VariationPoint basicGetVariationPoint() {
		return variationPoint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetVariationPoint(VariationPoint newVariationPoint, NotificationChain msgs) {
		VariationPoint oldVariationPoint = variationPoint;
		variationPoint = newVariationPoint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				FeaturePackage.ABSTRACT_FEATURE__VARIATION_POINT, oldVariationPoint, newVariationPoint);
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
	public void setVariationPoint(VariationPoint newVariationPoint) {
		if (newVariationPoint != variationPoint) {
			NotificationChain msgs = null;
			if (variationPoint != null)
				msgs = ((InternalEObject) variationPoint).eInverseRemove(this, FeaturePackage.VARIATION_POINT__VARIETY,
					VariationPoint.class, msgs);
			if (newVariationPoint != null)
				msgs = ((InternalEObject) newVariationPoint).eInverseAdd(this, FeaturePackage.VARIATION_POINT__VARIETY,
					VariationPoint.class, msgs);
			msgs = basicSetVariationPoint(newVariationPoint, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturePackage.ABSTRACT_FEATURE__VARIATION_POINT,
				newVariationPoint, newVariationPoint));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<VariationPointInstance> getVariationPointInstances() {
		if (variationPointInstances == null) {
			variationPointInstances = new EObjectWithInverseResolvingEList.ManyInverse<VariationPointInstance>(
				VariationPointInstance.class, this, FeaturePackage.ABSTRACT_FEATURE__VARIATION_POINT_INSTANCES,
				FeaturePackage.VARIATION_POINT_INSTANCE__SELECTED_FEATURES);
		}
		return variationPointInstances;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case FeaturePackage.ABSTRACT_FEATURE__GOALS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getGoals()).basicAdd(otherEnd, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDetailingFunctionalRequirements()).basicAdd(
				otherEnd, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getConstrainingNonFunctionalRequirements())
				.basicAdd(otherEnd, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__DETAILING_USE_CASES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDetailingUseCases())
				.basicAdd(otherEnd, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__PARENT_FEATURE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentFeature((AbstractFeature) otherEnd, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__SUB_FEATURES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSubFeatures()).basicAdd(otherEnd, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__EXCLUDING_FEATURES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getExcludingFeatures())
				.basicAdd(otherEnd, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__EXCLUDED_FEATURES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getExcludedFeatures()).basicAdd(otherEnd, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__REQUIERING_FEATURES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRequieringFeatures()).basicAdd(otherEnd,
				msgs);
		case FeaturePackage.ABSTRACT_FEATURE__REQUIERED_FEATURES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRequieredFeatures())
				.basicAdd(otherEnd, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__VARIATION_POINT:
			if (variationPoint != null)
				msgs = ((InternalEObject) variationPoint).eInverseRemove(this, FeaturePackage.VARIATION_POINT__VARIETY,
					VariationPoint.class, msgs);
			return basicSetVariationPoint((VariationPoint) otherEnd, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__VARIATION_POINT_INSTANCES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getVariationPointInstances()).basicAdd(
				otherEnd, msgs);
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
		case FeaturePackage.ABSTRACT_FEATURE__GOALS:
			return ((InternalEList<?>) getGoals()).basicRemove(otherEnd, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS:
			return ((InternalEList<?>) getDetailingFunctionalRequirements()).basicRemove(otherEnd, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS:
			return ((InternalEList<?>) getConstrainingNonFunctionalRequirements()).basicRemove(otherEnd, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__DETAILING_USE_CASES:
			return ((InternalEList<?>) getDetailingUseCases()).basicRemove(otherEnd, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__PARENT_FEATURE:
			return basicSetParentFeature(null, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__SUB_FEATURES:
			return ((InternalEList<?>) getSubFeatures()).basicRemove(otherEnd, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__EXCLUDING_FEATURES:
			return ((InternalEList<?>) getExcludingFeatures()).basicRemove(otherEnd, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__EXCLUDED_FEATURES:
			return ((InternalEList<?>) getExcludedFeatures()).basicRemove(otherEnd, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__REQUIERING_FEATURES:
			return ((InternalEList<?>) getRequieringFeatures()).basicRemove(otherEnd, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__REQUIERED_FEATURES:
			return ((InternalEList<?>) getRequieredFeatures()).basicRemove(otherEnd, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__VARIATION_POINT:
			return basicSetVariationPoint(null, msgs);
		case FeaturePackage.ABSTRACT_FEATURE__VARIATION_POINT_INSTANCES:
			return ((InternalEList<?>) getVariationPointInstances()).basicRemove(otherEnd, msgs);
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
		case FeaturePackage.ABSTRACT_FEATURE__PARENT_FEATURE:
			return eInternalContainer().eInverseRemove(this, FeaturePackage.ABSTRACT_FEATURE__SUB_FEATURES,
				AbstractFeature.class, msgs);
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
		case FeaturePackage.ABSTRACT_FEATURE__GOALS:
			return getGoals();
		case FeaturePackage.ABSTRACT_FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS:
			return getDetailingFunctionalRequirements();
		case FeaturePackage.ABSTRACT_FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS:
			return getConstrainingNonFunctionalRequirements();
		case FeaturePackage.ABSTRACT_FEATURE__DETAILING_USE_CASES:
			return getDetailingUseCases();
		case FeaturePackage.ABSTRACT_FEATURE__PARENT_FEATURE:
			if (resolve)
				return getParentFeature();
			return basicGetParentFeature();
		case FeaturePackage.ABSTRACT_FEATURE__SUB_FEATURES:
			return getSubFeatures();
		case FeaturePackage.ABSTRACT_FEATURE__EXCLUDING_FEATURES:
			return getExcludingFeatures();
		case FeaturePackage.ABSTRACT_FEATURE__EXCLUDED_FEATURES:
			return getExcludedFeatures();
		case FeaturePackage.ABSTRACT_FEATURE__REQUIERING_FEATURES:
			return getRequieringFeatures();
		case FeaturePackage.ABSTRACT_FEATURE__REQUIERED_FEATURES:
			return getRequieredFeatures();
		case FeaturePackage.ABSTRACT_FEATURE__VARIATION_POINT:
			if (resolve)
				return getVariationPoint();
			return basicGetVariationPoint();
		case FeaturePackage.ABSTRACT_FEATURE__VARIATION_POINT_INSTANCES:
			return getVariationPointInstances();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case FeaturePackage.ABSTRACT_FEATURE__GOALS:
			getGoals().clear();
			getGoals().addAll((Collection<? extends Goal>) newValue);
			return;
		case FeaturePackage.ABSTRACT_FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS:
			getDetailingFunctionalRequirements().clear();
			getDetailingFunctionalRequirements().addAll((Collection<? extends FunctionalRequirement>) newValue);
			return;
		case FeaturePackage.ABSTRACT_FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS:
			getConstrainingNonFunctionalRequirements().clear();
			getConstrainingNonFunctionalRequirements()
				.addAll((Collection<? extends NonFunctionalRequirement>) newValue);
			return;
		case FeaturePackage.ABSTRACT_FEATURE__DETAILING_USE_CASES:
			getDetailingUseCases().clear();
			getDetailingUseCases().addAll((Collection<? extends SolutionDomainUseCase>) newValue);
			return;
		case FeaturePackage.ABSTRACT_FEATURE__PARENT_FEATURE:
			setParentFeature((AbstractFeature) newValue);
			return;
		case FeaturePackage.ABSTRACT_FEATURE__SUB_FEATURES:
			getSubFeatures().clear();
			getSubFeatures().addAll((Collection<? extends AbstractFeature>) newValue);
			return;
		case FeaturePackage.ABSTRACT_FEATURE__EXCLUDING_FEATURES:
			getExcludingFeatures().clear();
			getExcludingFeatures().addAll((Collection<? extends AbstractFeature>) newValue);
			return;
		case FeaturePackage.ABSTRACT_FEATURE__EXCLUDED_FEATURES:
			getExcludedFeatures().clear();
			getExcludedFeatures().addAll((Collection<? extends AbstractFeature>) newValue);
			return;
		case FeaturePackage.ABSTRACT_FEATURE__REQUIERING_FEATURES:
			getRequieringFeatures().clear();
			getRequieringFeatures().addAll((Collection<? extends AbstractFeature>) newValue);
			return;
		case FeaturePackage.ABSTRACT_FEATURE__REQUIERED_FEATURES:
			getRequieredFeatures().clear();
			getRequieredFeatures().addAll((Collection<? extends AbstractFeature>) newValue);
			return;
		case FeaturePackage.ABSTRACT_FEATURE__VARIATION_POINT:
			setVariationPoint((VariationPoint) newValue);
			return;
		case FeaturePackage.ABSTRACT_FEATURE__VARIATION_POINT_INSTANCES:
			getVariationPointInstances().clear();
			getVariationPointInstances().addAll((Collection<? extends VariationPointInstance>) newValue);
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
		case FeaturePackage.ABSTRACT_FEATURE__GOALS:
			getGoals().clear();
			return;
		case FeaturePackage.ABSTRACT_FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS:
			getDetailingFunctionalRequirements().clear();
			return;
		case FeaturePackage.ABSTRACT_FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS:
			getConstrainingNonFunctionalRequirements().clear();
			return;
		case FeaturePackage.ABSTRACT_FEATURE__DETAILING_USE_CASES:
			getDetailingUseCases().clear();
			return;
		case FeaturePackage.ABSTRACT_FEATURE__PARENT_FEATURE:
			setParentFeature((AbstractFeature) null);
			return;
		case FeaturePackage.ABSTRACT_FEATURE__SUB_FEATURES:
			getSubFeatures().clear();
			return;
		case FeaturePackage.ABSTRACT_FEATURE__EXCLUDING_FEATURES:
			getExcludingFeatures().clear();
			return;
		case FeaturePackage.ABSTRACT_FEATURE__EXCLUDED_FEATURES:
			getExcludedFeatures().clear();
			return;
		case FeaturePackage.ABSTRACT_FEATURE__REQUIERING_FEATURES:
			getRequieringFeatures().clear();
			return;
		case FeaturePackage.ABSTRACT_FEATURE__REQUIERED_FEATURES:
			getRequieredFeatures().clear();
			return;
		case FeaturePackage.ABSTRACT_FEATURE__VARIATION_POINT:
			setVariationPoint((VariationPoint) null);
			return;
		case FeaturePackage.ABSTRACT_FEATURE__VARIATION_POINT_INSTANCES:
			getVariationPointInstances().clear();
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
		case FeaturePackage.ABSTRACT_FEATURE__GOALS:
			return goals != null && !goals.isEmpty();
		case FeaturePackage.ABSTRACT_FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS:
			return detailingFunctionalRequirements != null && !detailingFunctionalRequirements.isEmpty();
		case FeaturePackage.ABSTRACT_FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS:
			return constrainingNonFunctionalRequirements != null && !constrainingNonFunctionalRequirements.isEmpty();
		case FeaturePackage.ABSTRACT_FEATURE__DETAILING_USE_CASES:
			return detailingUseCases != null && !detailingUseCases.isEmpty();
		case FeaturePackage.ABSTRACT_FEATURE__PARENT_FEATURE:
			return basicGetParentFeature() != null;
		case FeaturePackage.ABSTRACT_FEATURE__SUB_FEATURES:
			return subFeatures != null && !subFeatures.isEmpty();
		case FeaturePackage.ABSTRACT_FEATURE__EXCLUDING_FEATURES:
			return excludingFeatures != null && !excludingFeatures.isEmpty();
		case FeaturePackage.ABSTRACT_FEATURE__EXCLUDED_FEATURES:
			return excludedFeatures != null && !excludedFeatures.isEmpty();
		case FeaturePackage.ABSTRACT_FEATURE__REQUIERING_FEATURES:
			return requieringFeatures != null && !requieringFeatures.isEmpty();
		case FeaturePackage.ABSTRACT_FEATURE__REQUIERED_FEATURES:
			return requieredFeatures != null && !requieredFeatures.isEmpty();
		case FeaturePackage.ABSTRACT_FEATURE__VARIATION_POINT:
			return variationPoint != null;
		case FeaturePackage.ABSTRACT_FEATURE__VARIATION_POINT_INSTANCES:
			return variationPointInstances != null && !variationPointInstances.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // AbstractFeatureImpl
