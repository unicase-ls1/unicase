/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.impl;

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

import scrm.impl.SCRMModelElementImpl;

import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.ScientificKnowledge;
import scrm.knowledge.ScientificProblem;

import scrm.requirements.Constraint;
import scrm.requirements.Feature;
import scrm.requirements.Hardware;
import scrm.requirements.Interface;
import scrm.requirements.Requirement;
import scrm.requirements.RequirementSpace;
import scrm.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getContainingRequirementSpace <em>Containing Requirement Space</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getDetailedRequirements <em>Detailed Requirements</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getSubFeatures <em>Sub Features</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getSuperFeature <em>Super Feature</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getRequiredInterfaces <em>Required Interfaces</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getProvidedInterfaces <em>Provided Interfaces</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getInfluencingProblem <em>Influencing Problem</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getRequiredFeatures <em>Required Features</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getRequiringFeatures <em>Requiring Features</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getExcludedFeatures <em>Excluded Features</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getExcludingFeatures <em>Excluding Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureImpl extends SCRMModelElementImpl implements Feature {
	/**
	 * The cached value of the '{@link #getDetailedRequirements() <em>Detailed Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetailedRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> detailedRequirements;

	/**
	 * The cached value of the '{@link #getSubFeatures() <em>Sub Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> subFeatures;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> constraints;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Hardware> dependencies;

	/**
	 * The cached value of the '{@link #getRequiredInterfaces() <em>Required Interfaces</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> requiredInterfaces;

	/**
	 * The cached value of the '{@link #getProvidedInterfaces() <em>Provided Interfaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> providedInterfaces;

	/**
	 * The cached value of the '{@link #getInfluencingProblem() <em>Influencing Problem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfluencingProblem()
	 * @generated
	 * @ordered
	 */
	protected ScientificProblem influencingProblem;

	/**
	 * The cached value of the '{@link #getRequiredFeatures() <em>Required Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> requiredFeatures;

	/**
	 * The cached value of the '{@link #getRequiringFeatures() <em>Requiring Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiringFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> requiringFeatures;

	/**
	 * The cached value of the '{@link #getExcludedFeatures() <em>Excluded Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExcludedFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> excludedFeatures;

	/**
	 * The cached value of the '{@link #getExcludingFeatures() <em>Excluding Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExcludingFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> excludingFeatures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementSpace getContainingRequirementSpace() {
		if (eContainerFeatureID() != RequirementsPackage.FEATURE__CONTAINING_REQUIREMENT_SPACE) return null;
		return (RequirementSpace)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementSpace basicGetContainingRequirementSpace() {
		if (eContainerFeatureID() != RequirementsPackage.FEATURE__CONTAINING_REQUIREMENT_SPACE) return null;
		return (RequirementSpace)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingRequirementSpace(RequirementSpace newContainingRequirementSpace, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainingRequirementSpace, RequirementsPackage.FEATURE__CONTAINING_REQUIREMENT_SPACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingRequirementSpace(RequirementSpace newContainingRequirementSpace) {
		if (newContainingRequirementSpace != eInternalContainer() || (eContainerFeatureID() != RequirementsPackage.FEATURE__CONTAINING_REQUIREMENT_SPACE && newContainingRequirementSpace != null)) {
			if (EcoreUtil.isAncestor(this, newContainingRequirementSpace))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingRequirementSpace != null)
				msgs = ((InternalEObject)newContainingRequirementSpace).eInverseAdd(this, RequirementsPackage.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS, RequirementSpace.class, msgs);
			msgs = basicSetContainingRequirementSpace(newContainingRequirementSpace, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.FEATURE__CONTAINING_REQUIREMENT_SPACE, newContainingRequirementSpace, newContainingRequirementSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectWithInverseResolvingEList<Constraint>(Constraint.class, this, RequirementsPackage.FEATURE__CONSTRAINTS, RequirementsPackage.CONSTRAINT__RESTRICTED_FEATURE);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Hardware> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectWithInverseResolvingEList<Hardware>(Hardware.class, this, RequirementsPackage.FEATURE__DEPENDENCIES, RequirementsPackage.HARDWARE__DEPENDING_FEATURE);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interface> getRequiredInterfaces() {
		if (requiredInterfaces == null) {
			requiredInterfaces = new EObjectWithInverseResolvingEList.ManyInverse<Interface>(Interface.class, this, RequirementsPackage.FEATURE__REQUIRED_INTERFACES, RequirementsPackage.INTERFACE__REQUIRING_FEATURES);
		}
		return requiredInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interface> getProvidedInterfaces() {
		if (providedInterfaces == null) {
			providedInterfaces = new EObjectContainmentWithInverseEList.Resolving<Interface>(Interface.class, this, RequirementsPackage.FEATURE__PROVIDED_INTERFACES, RequirementsPackage.INTERFACE__PROVIDING_FEATURE);
		}
		return providedInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getDetailedRequirements() {
		if (detailedRequirements == null) {
			detailedRequirements = new EObjectContainmentWithInverseEList.Resolving<Requirement>(Requirement.class, this, RequirementsPackage.FEATURE__DETAILED_REQUIREMENTS, RequirementsPackage.REQUIREMENT__SPECIFIED_FEATURE);
		}
		return detailedRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScientificProblem getInfluencingProblem() {
		if (influencingProblem != null && influencingProblem.eIsProxy()) {
			InternalEObject oldInfluencingProblem = (InternalEObject)influencingProblem;
			influencingProblem = (ScientificProblem)eResolveProxy(oldInfluencingProblem);
			if (influencingProblem != oldInfluencingProblem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementsPackage.FEATURE__INFLUENCING_PROBLEM, oldInfluencingProblem, influencingProblem));
			}
		}
		return influencingProblem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScientificProblem basicGetInfluencingProblem() {
		return influencingProblem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInfluencingProblem(ScientificProblem newInfluencingProblem, NotificationChain msgs) {
		ScientificProblem oldInfluencingProblem = influencingProblem;
		influencingProblem = newInfluencingProblem;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RequirementsPackage.FEATURE__INFLUENCING_PROBLEM, oldInfluencingProblem, newInfluencingProblem);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfluencingProblem(ScientificProblem newInfluencingProblem) {
		if (newInfluencingProblem != influencingProblem) {
			NotificationChain msgs = null;
			if (influencingProblem != null)
				msgs = ((InternalEObject)influencingProblem).eInverseRemove(this, KnowledgePackage.SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE, ScientificProblem.class, msgs);
			if (newInfluencingProblem != null)
				msgs = ((InternalEObject)newInfluencingProblem).eInverseAdd(this, KnowledgePackage.SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE, ScientificProblem.class, msgs);
			msgs = basicSetInfluencingProblem(newInfluencingProblem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.FEATURE__INFLUENCING_PROBLEM, newInfluencingProblem, newInfluencingProblem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getSubFeatures() {
		if (subFeatures == null) {
			subFeatures = new EObjectContainmentWithInverseEList.Resolving<Feature>(Feature.class, this, RequirementsPackage.FEATURE__SUB_FEATURES, RequirementsPackage.FEATURE__SUPER_FEATURE);
		}
		return subFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getSuperFeature() {
		if (eContainerFeatureID() != RequirementsPackage.FEATURE__SUPER_FEATURE) return null;
		return (Feature)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetSuperFeature() {
		if (eContainerFeatureID() != RequirementsPackage.FEATURE__SUPER_FEATURE) return null;
		return (Feature)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuperFeature(Feature newSuperFeature, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSuperFeature, RequirementsPackage.FEATURE__SUPER_FEATURE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperFeature(Feature newSuperFeature) {
		if (newSuperFeature != eInternalContainer() || (eContainerFeatureID() != RequirementsPackage.FEATURE__SUPER_FEATURE && newSuperFeature != null)) {
			if (EcoreUtil.isAncestor(this, newSuperFeature))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSuperFeature != null)
				msgs = ((InternalEObject)newSuperFeature).eInverseAdd(this, RequirementsPackage.FEATURE__SUB_FEATURES, Feature.class, msgs);
			msgs = basicSetSuperFeature(newSuperFeature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.FEATURE__SUPER_FEATURE, newSuperFeature, newSuperFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getRequiredFeatures() {
		if (requiredFeatures == null) {
			requiredFeatures = new EObjectWithInverseResolvingEList.ManyInverse<Feature>(Feature.class, this, RequirementsPackage.FEATURE__REQUIRED_FEATURES, RequirementsPackage.FEATURE__REQUIRING_FEATURES);
		}
		return requiredFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getRequiringFeatures() {
		if (requiringFeatures == null) {
			requiringFeatures = new EObjectWithInverseResolvingEList.ManyInverse<Feature>(Feature.class, this, RequirementsPackage.FEATURE__REQUIRING_FEATURES, RequirementsPackage.FEATURE__REQUIRED_FEATURES);
		}
		return requiringFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getExcludedFeatures() {
		if (excludedFeatures == null) {
			excludedFeatures = new EObjectWithInverseResolvingEList.ManyInverse<Feature>(Feature.class, this, RequirementsPackage.FEATURE__EXCLUDED_FEATURES, RequirementsPackage.FEATURE__EXCLUDING_FEATURES);
		}
		return excludedFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getExcludingFeatures() {
		if (excludingFeatures == null) {
			excludingFeatures = new EObjectWithInverseResolvingEList.ManyInverse<Feature>(Feature.class, this, RequirementsPackage.FEATURE__EXCLUDING_FEATURES, RequirementsPackage.FEATURE__EXCLUDED_FEATURES);
		}
		return excludingFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RequirementsPackage.FEATURE__CONTAINING_REQUIREMENT_SPACE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainingRequirementSpace((RequirementSpace)otherEnd, msgs);
			case RequirementsPackage.FEATURE__DETAILED_REQUIREMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDetailedRequirements()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.FEATURE__SUB_FEATURES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubFeatures()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.FEATURE__SUPER_FEATURE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSuperFeature((Feature)otherEnd, msgs);
			case RequirementsPackage.FEATURE__CONSTRAINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstraints()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.FEATURE__DEPENDENCIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependencies()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.FEATURE__REQUIRED_INTERFACES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequiredInterfaces()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.FEATURE__PROVIDED_INTERFACES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProvidedInterfaces()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.FEATURE__INFLUENCING_PROBLEM:
				if (influencingProblem != null)
					msgs = ((InternalEObject)influencingProblem).eInverseRemove(this, KnowledgePackage.SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE, ScientificProblem.class, msgs);
				return basicSetInfluencingProblem((ScientificProblem)otherEnd, msgs);
			case RequirementsPackage.FEATURE__REQUIRED_FEATURES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequiredFeatures()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.FEATURE__REQUIRING_FEATURES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequiringFeatures()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.FEATURE__EXCLUDED_FEATURES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExcludedFeatures()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.FEATURE__EXCLUDING_FEATURES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExcludingFeatures()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RequirementsPackage.FEATURE__CONTAINING_REQUIREMENT_SPACE:
				return basicSetContainingRequirementSpace(null, msgs);
			case RequirementsPackage.FEATURE__DETAILED_REQUIREMENTS:
				return ((InternalEList<?>)getDetailedRequirements()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.FEATURE__SUB_FEATURES:
				return ((InternalEList<?>)getSubFeatures()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.FEATURE__SUPER_FEATURE:
				return basicSetSuperFeature(null, msgs);
			case RequirementsPackage.FEATURE__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.FEATURE__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.FEATURE__REQUIRED_INTERFACES:
				return ((InternalEList<?>)getRequiredInterfaces()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.FEATURE__PROVIDED_INTERFACES:
				return ((InternalEList<?>)getProvidedInterfaces()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.FEATURE__INFLUENCING_PROBLEM:
				return basicSetInfluencingProblem(null, msgs);
			case RequirementsPackage.FEATURE__REQUIRED_FEATURES:
				return ((InternalEList<?>)getRequiredFeatures()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.FEATURE__REQUIRING_FEATURES:
				return ((InternalEList<?>)getRequiringFeatures()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.FEATURE__EXCLUDED_FEATURES:
				return ((InternalEList<?>)getExcludedFeatures()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.FEATURE__EXCLUDING_FEATURES:
				return ((InternalEList<?>)getExcludingFeatures()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case RequirementsPackage.FEATURE__CONTAINING_REQUIREMENT_SPACE:
				return eInternalContainer().eInverseRemove(this, RequirementsPackage.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS, RequirementSpace.class, msgs);
			case RequirementsPackage.FEATURE__SUPER_FEATURE:
				return eInternalContainer().eInverseRemove(this, RequirementsPackage.FEATURE__SUB_FEATURES, Feature.class, msgs);
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
			case RequirementsPackage.FEATURE__CONTAINING_REQUIREMENT_SPACE:
				if (resolve) return getContainingRequirementSpace();
				return basicGetContainingRequirementSpace();
			case RequirementsPackage.FEATURE__DETAILED_REQUIREMENTS:
				return getDetailedRequirements();
			case RequirementsPackage.FEATURE__SUB_FEATURES:
				return getSubFeatures();
			case RequirementsPackage.FEATURE__SUPER_FEATURE:
				if (resolve) return getSuperFeature();
				return basicGetSuperFeature();
			case RequirementsPackage.FEATURE__CONSTRAINTS:
				return getConstraints();
			case RequirementsPackage.FEATURE__DEPENDENCIES:
				return getDependencies();
			case RequirementsPackage.FEATURE__REQUIRED_INTERFACES:
				return getRequiredInterfaces();
			case RequirementsPackage.FEATURE__PROVIDED_INTERFACES:
				return getProvidedInterfaces();
			case RequirementsPackage.FEATURE__INFLUENCING_PROBLEM:
				if (resolve) return getInfluencingProblem();
				return basicGetInfluencingProblem();
			case RequirementsPackage.FEATURE__REQUIRED_FEATURES:
				return getRequiredFeatures();
			case RequirementsPackage.FEATURE__REQUIRING_FEATURES:
				return getRequiringFeatures();
			case RequirementsPackage.FEATURE__EXCLUDED_FEATURES:
				return getExcludedFeatures();
			case RequirementsPackage.FEATURE__EXCLUDING_FEATURES:
				return getExcludingFeatures();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RequirementsPackage.FEATURE__CONTAINING_REQUIREMENT_SPACE:
				setContainingRequirementSpace((RequirementSpace)newValue);
				return;
			case RequirementsPackage.FEATURE__DETAILED_REQUIREMENTS:
				getDetailedRequirements().clear();
				getDetailedRequirements().addAll((Collection<? extends Requirement>)newValue);
				return;
			case RequirementsPackage.FEATURE__SUB_FEATURES:
				getSubFeatures().clear();
				getSubFeatures().addAll((Collection<? extends Feature>)newValue);
				return;
			case RequirementsPackage.FEATURE__SUPER_FEATURE:
				setSuperFeature((Feature)newValue);
				return;
			case RequirementsPackage.FEATURE__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends Constraint>)newValue);
				return;
			case RequirementsPackage.FEATURE__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends Hardware>)newValue);
				return;
			case RequirementsPackage.FEATURE__REQUIRED_INTERFACES:
				getRequiredInterfaces().clear();
				getRequiredInterfaces().addAll((Collection<? extends Interface>)newValue);
				return;
			case RequirementsPackage.FEATURE__PROVIDED_INTERFACES:
				getProvidedInterfaces().clear();
				getProvidedInterfaces().addAll((Collection<? extends Interface>)newValue);
				return;
			case RequirementsPackage.FEATURE__INFLUENCING_PROBLEM:
				setInfluencingProblem((ScientificProblem)newValue);
				return;
			case RequirementsPackage.FEATURE__REQUIRED_FEATURES:
				getRequiredFeatures().clear();
				getRequiredFeatures().addAll((Collection<? extends Feature>)newValue);
				return;
			case RequirementsPackage.FEATURE__REQUIRING_FEATURES:
				getRequiringFeatures().clear();
				getRequiringFeatures().addAll((Collection<? extends Feature>)newValue);
				return;
			case RequirementsPackage.FEATURE__EXCLUDED_FEATURES:
				getExcludedFeatures().clear();
				getExcludedFeatures().addAll((Collection<? extends Feature>)newValue);
				return;
			case RequirementsPackage.FEATURE__EXCLUDING_FEATURES:
				getExcludingFeatures().clear();
				getExcludingFeatures().addAll((Collection<? extends Feature>)newValue);
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
			case RequirementsPackage.FEATURE__CONTAINING_REQUIREMENT_SPACE:
				setContainingRequirementSpace((RequirementSpace)null);
				return;
			case RequirementsPackage.FEATURE__DETAILED_REQUIREMENTS:
				getDetailedRequirements().clear();
				return;
			case RequirementsPackage.FEATURE__SUB_FEATURES:
				getSubFeatures().clear();
				return;
			case RequirementsPackage.FEATURE__SUPER_FEATURE:
				setSuperFeature((Feature)null);
				return;
			case RequirementsPackage.FEATURE__CONSTRAINTS:
				getConstraints().clear();
				return;
			case RequirementsPackage.FEATURE__DEPENDENCIES:
				getDependencies().clear();
				return;
			case RequirementsPackage.FEATURE__REQUIRED_INTERFACES:
				getRequiredInterfaces().clear();
				return;
			case RequirementsPackage.FEATURE__PROVIDED_INTERFACES:
				getProvidedInterfaces().clear();
				return;
			case RequirementsPackage.FEATURE__INFLUENCING_PROBLEM:
				setInfluencingProblem((ScientificProblem)null);
				return;
			case RequirementsPackage.FEATURE__REQUIRED_FEATURES:
				getRequiredFeatures().clear();
				return;
			case RequirementsPackage.FEATURE__REQUIRING_FEATURES:
				getRequiringFeatures().clear();
				return;
			case RequirementsPackage.FEATURE__EXCLUDED_FEATURES:
				getExcludedFeatures().clear();
				return;
			case RequirementsPackage.FEATURE__EXCLUDING_FEATURES:
				getExcludingFeatures().clear();
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
			case RequirementsPackage.FEATURE__CONTAINING_REQUIREMENT_SPACE:
				return basicGetContainingRequirementSpace() != null;
			case RequirementsPackage.FEATURE__DETAILED_REQUIREMENTS:
				return detailedRequirements != null && !detailedRequirements.isEmpty();
			case RequirementsPackage.FEATURE__SUB_FEATURES:
				return subFeatures != null && !subFeatures.isEmpty();
			case RequirementsPackage.FEATURE__SUPER_FEATURE:
				return basicGetSuperFeature() != null;
			case RequirementsPackage.FEATURE__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case RequirementsPackage.FEATURE__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case RequirementsPackage.FEATURE__REQUIRED_INTERFACES:
				return requiredInterfaces != null && !requiredInterfaces.isEmpty();
			case RequirementsPackage.FEATURE__PROVIDED_INTERFACES:
				return providedInterfaces != null && !providedInterfaces.isEmpty();
			case RequirementsPackage.FEATURE__INFLUENCING_PROBLEM:
				return influencingProblem != null;
			case RequirementsPackage.FEATURE__REQUIRED_FEATURES:
				return requiredFeatures != null && !requiredFeatures.isEmpty();
			case RequirementsPackage.FEATURE__REQUIRING_FEATURES:
				return requiringFeatures != null && !requiringFeatures.isEmpty();
			case RequirementsPackage.FEATURE__EXCLUDED_FEATURES:
				return excludedFeatures != null && !excludedFeatures.isEmpty();
			case RequirementsPackage.FEATURE__EXCLUDING_FEATURES:
				return excludingFeatures != null && !excludingFeatures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FeatureImpl
