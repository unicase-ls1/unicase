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
import scrm.requirements.DataDefinition;
import scrm.requirements.Feature;
import scrm.requirements.Requirement;
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
 *   <li>{@link scrm.requirements.impl.UserInterfaceImpl#getProvidingData <em>Providing Data</em>}</li>
 *   <li>{@link scrm.requirements.impl.UserInterfaceImpl#getRequiringData <em>Requiring Data</em>}</li>
 *   <li>{@link scrm.requirements.impl.UserInterfaceImpl#getDetailsOfProvidingFunctionsAndProperties <em>Details Of Providing Functions And Properties</em>}</li>
 *   <li>{@link scrm.requirements.impl.UserInterfaceImpl#getDetailsOfRequiringFunctionsAndProperties <em>Details Of Requiring Functions And Properties</em>}</li>
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
	 * The cached value of the '{@link #getProvidingData() <em>Providing Data</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidingData()
	 * @generated
	 * @ordered
	 */
	protected EList<DataDefinition> providingData;
	/**
	 * The cached value of the '{@link #getRequiringData() <em>Requiring Data</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiringData()
	 * @generated
	 * @ordered
	 */
	protected EList<DataDefinition> requiringData;
	/**
	 * The cached value of the '{@link #getDetailsOfProvidingFunctionsAndProperties() <em>Details Of Providing Functions And Properties</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetailsOfProvidingFunctionsAndProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> detailsOfProvidingFunctionsAndProperties;

	/**
	 * The cached value of the '{@link #getDetailsOfRequiringFunctionsAndProperties() <em>Details Of Requiring Functions And Properties</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetailsOfRequiringFunctionsAndProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> detailsOfRequiringFunctionsAndProperties;

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
	public EList<DataDefinition> getProvidingData() {
		if (providingData == null) {
			providingData = new EObjectWithInverseResolvingEList<DataDefinition>(
					DataDefinition.class, this,
					RequirementsPackage.USER_INTERFACE__PROVIDING_DATA,
					RequirementsPackage.DATA_DEFINITION__PROVIDED_INTERFACE);
		}
		return providingData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataDefinition> getRequiringData() {
		if (requiringData == null) {
			requiringData = new EObjectWithInverseResolvingEList<DataDefinition>(
					DataDefinition.class, this,
					RequirementsPackage.USER_INTERFACE__REQUIRING_DATA,
					RequirementsPackage.DATA_DEFINITION__REQUIRED_INTERFACE);
		}
		return requiringData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getDetailsOfProvidingFunctionsAndProperties() {
		if (detailsOfProvidingFunctionsAndProperties == null) {
			detailsOfProvidingFunctionsAndProperties = new EObjectWithInverseResolvingEList<Requirement>(
					Requirement.class,
					this,
					RequirementsPackage.USER_INTERFACE__DETAILS_OF_PROVIDING_FUNCTIONS_AND_PROPERTIES,
					RequirementsPackage.REQUIREMENT__PROVIDED_INTERFACE);
		}
		return detailsOfProvidingFunctionsAndProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getDetailsOfRequiringFunctionsAndProperties() {
		if (detailsOfRequiringFunctionsAndProperties == null) {
			detailsOfRequiringFunctionsAndProperties = new EObjectWithInverseResolvingEList<Requirement>(
					Requirement.class,
					this,
					RequirementsPackage.USER_INTERFACE__DETAILS_OF_REQUIRING_FUNCTIONS_AND_PROPERTIES,
					RequirementsPackage.REQUIREMENT__REQUIRED_INTERFACE);
		}
		return detailsOfRequiringFunctionsAndProperties;
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
		case RequirementsPackage.USER_INTERFACE__PROVIDING_DATA:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getProvidingData())
					.basicAdd(otherEnd, msgs);
		case RequirementsPackage.USER_INTERFACE__REQUIRING_DATA:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRequiringData())
					.basicAdd(otherEnd, msgs);
		case RequirementsPackage.USER_INTERFACE__DETAILS_OF_PROVIDING_FUNCTIONS_AND_PROPERTIES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDetailsOfProvidingFunctionsAndProperties())
					.basicAdd(otherEnd, msgs);
		case RequirementsPackage.USER_INTERFACE__DETAILS_OF_REQUIRING_FUNCTIONS_AND_PROPERTIES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDetailsOfRequiringFunctionsAndProperties())
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
		case RequirementsPackage.USER_INTERFACE__PROVIDING_DATA:
			return ((InternalEList<?>) getProvidingData()).basicRemove(
					otherEnd, msgs);
		case RequirementsPackage.USER_INTERFACE__REQUIRING_DATA:
			return ((InternalEList<?>) getRequiringData()).basicRemove(
					otherEnd, msgs);
		case RequirementsPackage.USER_INTERFACE__DETAILS_OF_PROVIDING_FUNCTIONS_AND_PROPERTIES:
			return ((InternalEList<?>) getDetailsOfProvidingFunctionsAndProperties())
					.basicRemove(otherEnd, msgs);
		case RequirementsPackage.USER_INTERFACE__DETAILS_OF_REQUIRING_FUNCTIONS_AND_PROPERTIES:
			return ((InternalEList<?>) getDetailsOfRequiringFunctionsAndProperties())
					.basicRemove(otherEnd, msgs);
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
		case RequirementsPackage.USER_INTERFACE__PROVIDING_DATA:
			return getProvidingData();
		case RequirementsPackage.USER_INTERFACE__REQUIRING_DATA:
			return getRequiringData();
		case RequirementsPackage.USER_INTERFACE__DETAILS_OF_PROVIDING_FUNCTIONS_AND_PROPERTIES:
			return getDetailsOfProvidingFunctionsAndProperties();
		case RequirementsPackage.USER_INTERFACE__DETAILS_OF_REQUIRING_FUNCTIONS_AND_PROPERTIES:
			return getDetailsOfRequiringFunctionsAndProperties();
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
		case RequirementsPackage.USER_INTERFACE__PROVIDING_DATA:
			getProvidingData().clear();
			getProvidingData().addAll(
					(Collection<? extends DataDefinition>) newValue);
			return;
		case RequirementsPackage.USER_INTERFACE__REQUIRING_DATA:
			getRequiringData().clear();
			getRequiringData().addAll(
					(Collection<? extends DataDefinition>) newValue);
			return;
		case RequirementsPackage.USER_INTERFACE__DETAILS_OF_PROVIDING_FUNCTIONS_AND_PROPERTIES:
			getDetailsOfProvidingFunctionsAndProperties().clear();
			getDetailsOfProvidingFunctionsAndProperties().addAll(
					(Collection<? extends Requirement>) newValue);
			return;
		case RequirementsPackage.USER_INTERFACE__DETAILS_OF_REQUIRING_FUNCTIONS_AND_PROPERTIES:
			getDetailsOfRequiringFunctionsAndProperties().clear();
			getDetailsOfRequiringFunctionsAndProperties().addAll(
					(Collection<? extends Requirement>) newValue);
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
		case RequirementsPackage.USER_INTERFACE__PROVIDING_DATA:
			getProvidingData().clear();
			return;
		case RequirementsPackage.USER_INTERFACE__REQUIRING_DATA:
			getRequiringData().clear();
			return;
		case RequirementsPackage.USER_INTERFACE__DETAILS_OF_PROVIDING_FUNCTIONS_AND_PROPERTIES:
			getDetailsOfProvidingFunctionsAndProperties().clear();
			return;
		case RequirementsPackage.USER_INTERFACE__DETAILS_OF_REQUIRING_FUNCTIONS_AND_PROPERTIES:
			getDetailsOfRequiringFunctionsAndProperties().clear();
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
		case RequirementsPackage.USER_INTERFACE__PROVIDING_DATA:
			return providingData != null && !providingData.isEmpty();
		case RequirementsPackage.USER_INTERFACE__REQUIRING_DATA:
			return requiringData != null && !requiringData.isEmpty();
		case RequirementsPackage.USER_INTERFACE__DETAILS_OF_PROVIDING_FUNCTIONS_AND_PROPERTIES:
			return detailsOfProvidingFunctionsAndProperties != null
					&& !detailsOfProvidingFunctionsAndProperties.isEmpty();
		case RequirementsPackage.USER_INTERFACE__DETAILS_OF_REQUIRING_FUNCTIONS_AND_PROPERTIES:
			return detailsOfRequiringFunctionsAndProperties != null
					&& !detailsOfRequiringFunctionsAndProperties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //UserInterfaceImpl
