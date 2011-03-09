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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.ScientificKnowledge;

import scrm.requirements.Constraint;
import scrm.requirements.Feature;
import scrm.requirements.Hardware;
import scrm.requirements.Requirement;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.SoftwareInterface;
import scrm.requirements.UserInterface;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getName <em>Name</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getUsedKnowledge <em>Used Knowledge</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getRequiredUserInterface <em>Required User Interface</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getProvidedUserInterfaces <em>Provided User Interfaces</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getRequiredSoftwareInterface <em>Required Software Interface</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getProvidedSoftwareInterfaces <em>Provided Software Interfaces</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getDetailedRequirements <em>Detailed Requirements</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getSubFeatures <em>Sub Features</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getContainingFeature <em>Containing Feature</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getRequiredFeatures <em>Required Features</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getRequiringFeatures <em>Requiring Features</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getExcludedFeatures <em>Excluded Features</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getExcludingFeatures <em>Excluding Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureImpl extends EObjectImpl implements Feature {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String identifier = IDENTIFIER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUsedKnowledge() <em>Used Knowledge</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedKnowledge()
	 * @generated
	 * @ordered
	 */
	protected EList<ScientificKnowledge> usedKnowledge;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> constraints;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Hardware> dependencies;

	/**
	 * The cached value of the '{@link #getRequiredUserInterface() <em>Required User Interface</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredUserInterface()
	 * @generated
	 * @ordered
	 */
	protected UserInterface requiredUserInterface;

	/**
	 * The cached value of the '{@link #getProvidedUserInterfaces() <em>Provided User Interfaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedUserInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<UserInterface> providedUserInterfaces;

	/**
	 * The cached value of the '{@link #getRequiredSoftwareInterface() <em>Required Software Interface</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredSoftwareInterface()
	 * @generated
	 * @ordered
	 */
	protected SoftwareInterface requiredSoftwareInterface;

	/**
	 * The cached value of the '{@link #getProvidedSoftwareInterfaces() <em>Provided Software Interfaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedSoftwareInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<SoftwareInterface> providedSoftwareInterfaces;

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
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.FEATURE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.FEATURE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(String newIdentifier) {
		String oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.FEATURE__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ScientificKnowledge> getUsedKnowledge() {
		if (usedKnowledge == null) {
			usedKnowledge = new EObjectWithInverseResolvingEList.ManyInverse<ScientificKnowledge>(ScientificKnowledge.class, this, RequirementsPackage.FEATURE__USED_KNOWLEDGE, KnowledgePackage.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS);
		}
		return usedKnowledge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentWithInverseEList<Constraint>(Constraint.class, this, RequirementsPackage.FEATURE__CONSTRAINTS, RequirementsPackage.CONSTRAINT__RESTRICTED_FEATURE);
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
			dependencies = new EObjectContainmentWithInverseEList<Hardware>(Hardware.class, this, RequirementsPackage.FEATURE__DEPENDENCIES, RequirementsPackage.HARDWARE__DEPENDING_FEATURE);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserInterface getRequiredUserInterface() {
		return requiredUserInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequiredUserInterface(UserInterface newRequiredUserInterface, NotificationChain msgs) {
		UserInterface oldRequiredUserInterface = requiredUserInterface;
		requiredUserInterface = newRequiredUserInterface;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RequirementsPackage.FEATURE__REQUIRED_USER_INTERFACE, oldRequiredUserInterface, newRequiredUserInterface);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredUserInterface(UserInterface newRequiredUserInterface) {
		if (newRequiredUserInterface != requiredUserInterface) {
			NotificationChain msgs = null;
			if (requiredUserInterface != null)
				msgs = ((InternalEObject)requiredUserInterface).eInverseRemove(this, RequirementsPackage.USER_INTERFACE__REQUIRING_FEATURE, UserInterface.class, msgs);
			if (newRequiredUserInterface != null)
				msgs = ((InternalEObject)newRequiredUserInterface).eInverseAdd(this, RequirementsPackage.USER_INTERFACE__REQUIRING_FEATURE, UserInterface.class, msgs);
			msgs = basicSetRequiredUserInterface(newRequiredUserInterface, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.FEATURE__REQUIRED_USER_INTERFACE, newRequiredUserInterface, newRequiredUserInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UserInterface> getProvidedUserInterfaces() {
		if (providedUserInterfaces == null) {
			providedUserInterfaces = new EObjectContainmentWithInverseEList<UserInterface>(UserInterface.class, this, RequirementsPackage.FEATURE__PROVIDED_USER_INTERFACES, RequirementsPackage.USER_INTERFACE__PROVIDING_FEATURE);
		}
		return providedUserInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwareInterface getRequiredSoftwareInterface() {
		return requiredSoftwareInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequiredSoftwareInterface(SoftwareInterface newRequiredSoftwareInterface, NotificationChain msgs) {
		SoftwareInterface oldRequiredSoftwareInterface = requiredSoftwareInterface;
		requiredSoftwareInterface = newRequiredSoftwareInterface;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RequirementsPackage.FEATURE__REQUIRED_SOFTWARE_INTERFACE, oldRequiredSoftwareInterface, newRequiredSoftwareInterface);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredSoftwareInterface(SoftwareInterface newRequiredSoftwareInterface) {
		if (newRequiredSoftwareInterface != requiredSoftwareInterface) {
			NotificationChain msgs = null;
			if (requiredSoftwareInterface != null)
				msgs = ((InternalEObject)requiredSoftwareInterface).eInverseRemove(this, RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURE, SoftwareInterface.class, msgs);
			if (newRequiredSoftwareInterface != null)
				msgs = ((InternalEObject)newRequiredSoftwareInterface).eInverseAdd(this, RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURE, SoftwareInterface.class, msgs);
			msgs = basicSetRequiredSoftwareInterface(newRequiredSoftwareInterface, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.FEATURE__REQUIRED_SOFTWARE_INTERFACE, newRequiredSoftwareInterface, newRequiredSoftwareInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SoftwareInterface> getProvidedSoftwareInterfaces() {
		if (providedSoftwareInterfaces == null) {
			providedSoftwareInterfaces = new EObjectContainmentWithInverseEList<SoftwareInterface>(SoftwareInterface.class, this, RequirementsPackage.FEATURE__PROVIDED_SOFTWARE_INTERFACES, RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE);
		}
		return providedSoftwareInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getDetailedRequirements() {
		if (detailedRequirements == null) {
			detailedRequirements = new EObjectContainmentWithInverseEList<Requirement>(Requirement.class, this, RequirementsPackage.FEATURE__DETAILED_REQUIREMENTS, RequirementsPackage.REQUIREMENT__SPECIFIED_FEATURE);
		}
		return detailedRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getSubFeatures() {
		if (subFeatures == null) {
			subFeatures = new EObjectContainmentWithInverseEList<Feature>(Feature.class, this, RequirementsPackage.FEATURE__SUB_FEATURES, RequirementsPackage.FEATURE__CONTAINING_FEATURE);
		}
		return subFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getContainingFeature() {
		if (eContainerFeatureID() != RequirementsPackage.FEATURE__CONTAINING_FEATURE) return null;
		return (Feature)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingFeature(Feature newContainingFeature, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainingFeature, RequirementsPackage.FEATURE__CONTAINING_FEATURE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingFeature(Feature newContainingFeature) {
		if (newContainingFeature != eInternalContainer() || (eContainerFeatureID() != RequirementsPackage.FEATURE__CONTAINING_FEATURE && newContainingFeature != null)) {
			if (EcoreUtil.isAncestor(this, newContainingFeature))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingFeature != null)
				msgs = ((InternalEObject)newContainingFeature).eInverseAdd(this, RequirementsPackage.FEATURE__SUB_FEATURES, Feature.class, msgs);
			msgs = basicSetContainingFeature(newContainingFeature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.FEATURE__CONTAINING_FEATURE, newContainingFeature, newContainingFeature));
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
			case RequirementsPackage.FEATURE__USED_KNOWLEDGE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUsedKnowledge()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.FEATURE__CONSTRAINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstraints()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.FEATURE__DEPENDENCIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependencies()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.FEATURE__REQUIRED_USER_INTERFACE:
				if (requiredUserInterface != null)
					msgs = ((InternalEObject)requiredUserInterface).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RequirementsPackage.FEATURE__REQUIRED_USER_INTERFACE, null, msgs);
				return basicSetRequiredUserInterface((UserInterface)otherEnd, msgs);
			case RequirementsPackage.FEATURE__PROVIDED_USER_INTERFACES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProvidedUserInterfaces()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.FEATURE__REQUIRED_SOFTWARE_INTERFACE:
				if (requiredSoftwareInterface != null)
					msgs = ((InternalEObject)requiredSoftwareInterface).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RequirementsPackage.FEATURE__REQUIRED_SOFTWARE_INTERFACE, null, msgs);
				return basicSetRequiredSoftwareInterface((SoftwareInterface)otherEnd, msgs);
			case RequirementsPackage.FEATURE__PROVIDED_SOFTWARE_INTERFACES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProvidedSoftwareInterfaces()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.FEATURE__DETAILED_REQUIREMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDetailedRequirements()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.FEATURE__SUB_FEATURES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubFeatures()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.FEATURE__CONTAINING_FEATURE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainingFeature((Feature)otherEnd, msgs);
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
			case RequirementsPackage.FEATURE__USED_KNOWLEDGE:
				return ((InternalEList<?>)getUsedKnowledge()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.FEATURE__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.FEATURE__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.FEATURE__REQUIRED_USER_INTERFACE:
				return basicSetRequiredUserInterface(null, msgs);
			case RequirementsPackage.FEATURE__PROVIDED_USER_INTERFACES:
				return ((InternalEList<?>)getProvidedUserInterfaces()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.FEATURE__REQUIRED_SOFTWARE_INTERFACE:
				return basicSetRequiredSoftwareInterface(null, msgs);
			case RequirementsPackage.FEATURE__PROVIDED_SOFTWARE_INTERFACES:
				return ((InternalEList<?>)getProvidedSoftwareInterfaces()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.FEATURE__DETAILED_REQUIREMENTS:
				return ((InternalEList<?>)getDetailedRequirements()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.FEATURE__SUB_FEATURES:
				return ((InternalEList<?>)getSubFeatures()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.FEATURE__CONTAINING_FEATURE:
				return basicSetContainingFeature(null, msgs);
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
			case RequirementsPackage.FEATURE__CONTAINING_FEATURE:
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
			case RequirementsPackage.FEATURE__NAME:
				return getName();
			case RequirementsPackage.FEATURE__DESCRIPTION:
				return getDescription();
			case RequirementsPackage.FEATURE__IDENTIFIER:
				return getIdentifier();
			case RequirementsPackage.FEATURE__USED_KNOWLEDGE:
				return getUsedKnowledge();
			case RequirementsPackage.FEATURE__CONSTRAINTS:
				return getConstraints();
			case RequirementsPackage.FEATURE__DEPENDENCIES:
				return getDependencies();
			case RequirementsPackage.FEATURE__REQUIRED_USER_INTERFACE:
				return getRequiredUserInterface();
			case RequirementsPackage.FEATURE__PROVIDED_USER_INTERFACES:
				return getProvidedUserInterfaces();
			case RequirementsPackage.FEATURE__REQUIRED_SOFTWARE_INTERFACE:
				return getRequiredSoftwareInterface();
			case RequirementsPackage.FEATURE__PROVIDED_SOFTWARE_INTERFACES:
				return getProvidedSoftwareInterfaces();
			case RequirementsPackage.FEATURE__DETAILED_REQUIREMENTS:
				return getDetailedRequirements();
			case RequirementsPackage.FEATURE__SUB_FEATURES:
				return getSubFeatures();
			case RequirementsPackage.FEATURE__CONTAINING_FEATURE:
				return getContainingFeature();
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
			case RequirementsPackage.FEATURE__NAME:
				setName((String)newValue);
				return;
			case RequirementsPackage.FEATURE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case RequirementsPackage.FEATURE__IDENTIFIER:
				setIdentifier((String)newValue);
				return;
			case RequirementsPackage.FEATURE__USED_KNOWLEDGE:
				getUsedKnowledge().clear();
				getUsedKnowledge().addAll((Collection<? extends ScientificKnowledge>)newValue);
				return;
			case RequirementsPackage.FEATURE__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends Constraint>)newValue);
				return;
			case RequirementsPackage.FEATURE__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends Hardware>)newValue);
				return;
			case RequirementsPackage.FEATURE__REQUIRED_USER_INTERFACE:
				setRequiredUserInterface((UserInterface)newValue);
				return;
			case RequirementsPackage.FEATURE__PROVIDED_USER_INTERFACES:
				getProvidedUserInterfaces().clear();
				getProvidedUserInterfaces().addAll((Collection<? extends UserInterface>)newValue);
				return;
			case RequirementsPackage.FEATURE__REQUIRED_SOFTWARE_INTERFACE:
				setRequiredSoftwareInterface((SoftwareInterface)newValue);
				return;
			case RequirementsPackage.FEATURE__PROVIDED_SOFTWARE_INTERFACES:
				getProvidedSoftwareInterfaces().clear();
				getProvidedSoftwareInterfaces().addAll((Collection<? extends SoftwareInterface>)newValue);
				return;
			case RequirementsPackage.FEATURE__DETAILED_REQUIREMENTS:
				getDetailedRequirements().clear();
				getDetailedRequirements().addAll((Collection<? extends Requirement>)newValue);
				return;
			case RequirementsPackage.FEATURE__SUB_FEATURES:
				getSubFeatures().clear();
				getSubFeatures().addAll((Collection<? extends Feature>)newValue);
				return;
			case RequirementsPackage.FEATURE__CONTAINING_FEATURE:
				setContainingFeature((Feature)newValue);
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
			case RequirementsPackage.FEATURE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RequirementsPackage.FEATURE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case RequirementsPackage.FEATURE__IDENTIFIER:
				setIdentifier(IDENTIFIER_EDEFAULT);
				return;
			case RequirementsPackage.FEATURE__USED_KNOWLEDGE:
				getUsedKnowledge().clear();
				return;
			case RequirementsPackage.FEATURE__CONSTRAINTS:
				getConstraints().clear();
				return;
			case RequirementsPackage.FEATURE__DEPENDENCIES:
				getDependencies().clear();
				return;
			case RequirementsPackage.FEATURE__REQUIRED_USER_INTERFACE:
				setRequiredUserInterface((UserInterface)null);
				return;
			case RequirementsPackage.FEATURE__PROVIDED_USER_INTERFACES:
				getProvidedUserInterfaces().clear();
				return;
			case RequirementsPackage.FEATURE__REQUIRED_SOFTWARE_INTERFACE:
				setRequiredSoftwareInterface((SoftwareInterface)null);
				return;
			case RequirementsPackage.FEATURE__PROVIDED_SOFTWARE_INTERFACES:
				getProvidedSoftwareInterfaces().clear();
				return;
			case RequirementsPackage.FEATURE__DETAILED_REQUIREMENTS:
				getDetailedRequirements().clear();
				return;
			case RequirementsPackage.FEATURE__SUB_FEATURES:
				getSubFeatures().clear();
				return;
			case RequirementsPackage.FEATURE__CONTAINING_FEATURE:
				setContainingFeature((Feature)null);
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
			case RequirementsPackage.FEATURE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RequirementsPackage.FEATURE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case RequirementsPackage.FEATURE__IDENTIFIER:
				return IDENTIFIER_EDEFAULT == null ? identifier != null : !IDENTIFIER_EDEFAULT.equals(identifier);
			case RequirementsPackage.FEATURE__USED_KNOWLEDGE:
				return usedKnowledge != null && !usedKnowledge.isEmpty();
			case RequirementsPackage.FEATURE__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case RequirementsPackage.FEATURE__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case RequirementsPackage.FEATURE__REQUIRED_USER_INTERFACE:
				return requiredUserInterface != null;
			case RequirementsPackage.FEATURE__PROVIDED_USER_INTERFACES:
				return providedUserInterfaces != null && !providedUserInterfaces.isEmpty();
			case RequirementsPackage.FEATURE__REQUIRED_SOFTWARE_INTERFACE:
				return requiredSoftwareInterface != null;
			case RequirementsPackage.FEATURE__PROVIDED_SOFTWARE_INTERFACES:
				return providedSoftwareInterfaces != null && !providedSoftwareInterfaces.isEmpty();
			case RequirementsPackage.FEATURE__DETAILED_REQUIREMENTS:
				return detailedRequirements != null && !detailedRequirements.isEmpty();
			case RequirementsPackage.FEATURE__SUB_FEATURES:
				return subFeatures != null && !subFeatures.isEmpty();
			case RequirementsPackage.FEATURE__CONTAINING_FEATURE:
				return getContainingFeature() != null;
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", identifier: ");
		result.append(identifier);
		result.append(')');
		return result.toString();
	}

} //FeatureImpl
