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

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import scrm.impl.SCRMModelElementImpl;

import scrm.requirements.Feature;
import scrm.requirements.RequirementSpace;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.UserInterface;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.impl.UserInterfaceImpl#getContainingRequirementSpace <em>Containing Requirement Space</em>}</li>
 *   <li>{@link scrm.requirements.impl.UserInterfaceImpl#getProvidingFeature <em>Providing Feature</em>}</li>
 *   <li>{@link scrm.requirements.impl.UserInterfaceImpl#getRequiringFeatures <em>Requiring Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserInterfaceImpl extends SCRMModelElementImpl implements
		UserInterface {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.USER_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementSpace getContainingRequirementSpace() {
		if (eContainerFeatureID() != RequirementsPackage.USER_INTERFACE__CONTAINING_REQUIREMENT_SPACE)
			return null;
		return (RequirementSpace) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementSpace basicGetContainingRequirementSpace() {
		if (eContainerFeatureID() != RequirementsPackage.USER_INTERFACE__CONTAINING_REQUIREMENT_SPACE)
			return null;
		return (RequirementSpace) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingRequirementSpace(
			RequirementSpace newContainingRequirementSpace,
			NotificationChain msgs) {
		msgs = eBasicSetContainer(
				(InternalEObject) newContainingRequirementSpace,
				RequirementsPackage.USER_INTERFACE__CONTAINING_REQUIREMENT_SPACE,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingRequirementSpace(
			RequirementSpace newContainingRequirementSpace) {
		if (newContainingRequirementSpace != eInternalContainer()
				|| (eContainerFeatureID() != RequirementsPackage.USER_INTERFACE__CONTAINING_REQUIREMENT_SPACE && newContainingRequirementSpace != null)) {
			if (EcoreUtil.isAncestor(this, newContainingRequirementSpace))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingRequirementSpace != null)
				msgs = ((InternalEObject) newContainingRequirementSpace)
						.eInverseAdd(
								this,
								RequirementsPackage.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
								RequirementSpace.class, msgs);
			msgs = basicSetContainingRequirementSpace(
					newContainingRequirementSpace, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					RequirementsPackage.USER_INTERFACE__CONTAINING_REQUIREMENT_SPACE,
					newContainingRequirementSpace,
					newContainingRequirementSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getProvidingFeature() {
		if (eContainerFeatureID() != RequirementsPackage.USER_INTERFACE__PROVIDING_FEATURE)
			return null;
		return (Feature) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetProvidingFeature() {
		if (eContainerFeatureID() != RequirementsPackage.USER_INTERFACE__PROVIDING_FEATURE)
			return null;
		return (Feature) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProvidingFeature(
			Feature newProvidingFeature, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newProvidingFeature,
				RequirementsPackage.USER_INTERFACE__PROVIDING_FEATURE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidingFeature(Feature newProvidingFeature) {
		if (newProvidingFeature != eInternalContainer()
				|| (eContainerFeatureID() != RequirementsPackage.USER_INTERFACE__PROVIDING_FEATURE && newProvidingFeature != null)) {
			if (EcoreUtil.isAncestor(this, newProvidingFeature))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newProvidingFeature != null)
				msgs = ((InternalEObject) newProvidingFeature).eInverseAdd(
						this, RequirementsPackage.FEATURE__PROVIDED_INTERFACES,
						Feature.class, msgs);
			msgs = basicSetProvidingFeature(newProvidingFeature, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementsPackage.USER_INTERFACE__PROVIDING_FEATURE,
					newProvidingFeature, newProvidingFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getRequiringFeatures() {
		if (requiringFeatures == null) {
			requiringFeatures = new EObjectWithInverseResolvingEList.ManyInverse<Feature>(
					Feature.class, this,
					RequirementsPackage.USER_INTERFACE__REQUIRING_FEATURES,
					RequirementsPackage.FEATURE__REQUIRED_INTERFACES);
		}
		return requiringFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementsPackage.USER_INTERFACE__CONTAINING_REQUIREMENT_SPACE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContainingRequirementSpace(
					(RequirementSpace) otherEnd, msgs);
		case RequirementsPackage.USER_INTERFACE__PROVIDING_FEATURE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetProvidingFeature((Feature) otherEnd, msgs);
		case RequirementsPackage.USER_INTERFACE__REQUIRING_FEATURES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRequiringFeatures())
					.basicAdd(otherEnd, msgs);
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
		case RequirementsPackage.USER_INTERFACE__CONTAINING_REQUIREMENT_SPACE:
			return basicSetContainingRequirementSpace(null, msgs);
		case RequirementsPackage.USER_INTERFACE__PROVIDING_FEATURE:
			return basicSetProvidingFeature(null, msgs);
		case RequirementsPackage.USER_INTERFACE__REQUIRING_FEATURES:
			return ((InternalEList<?>) getRequiringFeatures()).basicRemove(
					otherEnd, msgs);
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
		case RequirementsPackage.USER_INTERFACE__CONTAINING_REQUIREMENT_SPACE:
			return eInternalContainer()
					.eInverseRemove(
							this,
							RequirementsPackage.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
							RequirementSpace.class, msgs);
		case RequirementsPackage.USER_INTERFACE__PROVIDING_FEATURE:
			return eInternalContainer().eInverseRemove(this,
					RequirementsPackage.FEATURE__PROVIDED_INTERFACES,
					Feature.class, msgs);
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
		case RequirementsPackage.USER_INTERFACE__CONTAINING_REQUIREMENT_SPACE:
			if (resolve)
				return getContainingRequirementSpace();
			return basicGetContainingRequirementSpace();
		case RequirementsPackage.USER_INTERFACE__PROVIDING_FEATURE:
			if (resolve)
				return getProvidingFeature();
			return basicGetProvidingFeature();
		case RequirementsPackage.USER_INTERFACE__REQUIRING_FEATURES:
			return getRequiringFeatures();
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
		case RequirementsPackage.USER_INTERFACE__CONTAINING_REQUIREMENT_SPACE:
			setContainingRequirementSpace((RequirementSpace) newValue);
			return;
		case RequirementsPackage.USER_INTERFACE__PROVIDING_FEATURE:
			setProvidingFeature((Feature) newValue);
			return;
		case RequirementsPackage.USER_INTERFACE__REQUIRING_FEATURES:
			getRequiringFeatures().clear();
			getRequiringFeatures().addAll(
					(Collection<? extends Feature>) newValue);
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
		case RequirementsPackage.USER_INTERFACE__CONTAINING_REQUIREMENT_SPACE:
			setContainingRequirementSpace((RequirementSpace) null);
			return;
		case RequirementsPackage.USER_INTERFACE__PROVIDING_FEATURE:
			setProvidingFeature((Feature) null);
			return;
		case RequirementsPackage.USER_INTERFACE__REQUIRING_FEATURES:
			getRequiringFeatures().clear();
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
		case RequirementsPackage.USER_INTERFACE__CONTAINING_REQUIREMENT_SPACE:
			return basicGetContainingRequirementSpace() != null;
		case RequirementsPackage.USER_INTERFACE__PROVIDING_FEATURE:
			return basicGetProvidingFeature() != null;
		case RequirementsPackage.USER_INTERFACE__REQUIRING_FEATURES:
			return requiringFeatures != null && !requiringFeatures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //UserInterfaceImpl
