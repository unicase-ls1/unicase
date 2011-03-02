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
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getUsedKnowledge <em>Used Knowledge</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getRequiredUserInterface <em>Required User Interface</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getProvidedUserInterfaces <em>Provided User Interfaces</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getRequiredSoftwareInterface <em>Required Software Interface</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getProvidedSoftwareInterfaces <em>Provided Software Interfaces</em>}</li>
 *   <li>{@link scrm.requirements.impl.FeatureImpl#getDetailedRequirements <em>Detailed Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureImpl extends EObjectImpl implements Feature {
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
		}
		return super.eIsSet(featureID);
	}

} //FeatureImpl
