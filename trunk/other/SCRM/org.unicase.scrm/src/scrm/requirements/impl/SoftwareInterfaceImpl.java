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

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.ScientificKnowledge;

import scrm.requirements.Feature;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.SoftwareInterface;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Software Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.impl.SoftwareInterfaceImpl#getName <em>Name</em>}</li>
 *   <li>{@link scrm.requirements.impl.SoftwareInterfaceImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link scrm.requirements.impl.SoftwareInterfaceImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link scrm.requirements.impl.SoftwareInterfaceImpl#getUsedKnowledge <em>Used Knowledge</em>}</li>
 *   <li>{@link scrm.requirements.impl.SoftwareInterfaceImpl#getRequiringFeature <em>Requiring Feature</em>}</li>
 *   <li>{@link scrm.requirements.impl.SoftwareInterfaceImpl#getProvidingFeature <em>Providing Feature</em>}</li>
 *   <li>{@link scrm.requirements.impl.SoftwareInterfaceImpl#getDataTypes <em>Data Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SoftwareInterfaceImpl extends EObjectImpl implements SoftwareInterface {
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
	 * The default value of the '{@link #getDataTypes() <em>Data Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataTypes()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_TYPES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataTypes() <em>Data Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataTypes()
	 * @generated
	 * @ordered
	 */
	protected String dataTypes = DATA_TYPES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SoftwareInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.SOFTWARE_INTERFACE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.SOFTWARE_INTERFACE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.SOFTWARE_INTERFACE__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.SOFTWARE_INTERFACE__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ScientificKnowledge> getUsedKnowledge() {
		if (usedKnowledge == null) {
			usedKnowledge = new EObjectWithInverseResolvingEList.ManyInverse<ScientificKnowledge>(ScientificKnowledge.class, this, RequirementsPackage.SOFTWARE_INTERFACE__USED_KNOWLEDGE, KnowledgePackage.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS);
		}
		return usedKnowledge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getRequiringFeature() {
		if (eContainerFeatureID() != RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURE) return null;
		return (Feature)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequiringFeature(Feature newRequiringFeature, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRequiringFeature, RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiringFeature(Feature newRequiringFeature) {
		if (newRequiringFeature != eInternalContainer() || (eContainerFeatureID() != RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURE && newRequiringFeature != null)) {
			if (EcoreUtil.isAncestor(this, newRequiringFeature))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRequiringFeature != null)
				msgs = ((InternalEObject)newRequiringFeature).eInverseAdd(this, RequirementsPackage.FEATURE__REQUIRED_SOFTWARE_INTERFACE, Feature.class, msgs);
			msgs = basicSetRequiringFeature(newRequiringFeature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURE, newRequiringFeature, newRequiringFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getProvidingFeature() {
		if (eContainerFeatureID() != RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE) return null;
		return (Feature)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProvidingFeature(Feature newProvidingFeature, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newProvidingFeature, RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidingFeature(Feature newProvidingFeature) {
		if (newProvidingFeature != eInternalContainer() || (eContainerFeatureID() != RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE && newProvidingFeature != null)) {
			if (EcoreUtil.isAncestor(this, newProvidingFeature))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newProvidingFeature != null)
				msgs = ((InternalEObject)newProvidingFeature).eInverseAdd(this, RequirementsPackage.FEATURE__PROVIDED_SOFTWARE_INTERFACES, Feature.class, msgs);
			msgs = basicSetProvidingFeature(newProvidingFeature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE, newProvidingFeature, newProvidingFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataTypes() {
		return dataTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataTypes(String newDataTypes) {
		String oldDataTypes = dataTypes;
		dataTypes = newDataTypes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.SOFTWARE_INTERFACE__DATA_TYPES, oldDataTypes, dataTypes));
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
			case RequirementsPackage.SOFTWARE_INTERFACE__USED_KNOWLEDGE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUsedKnowledge()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRequiringFeature((Feature)otherEnd, msgs);
			case RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetProvidingFeature((Feature)otherEnd, msgs);
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
			case RequirementsPackage.SOFTWARE_INTERFACE__USED_KNOWLEDGE:
				return ((InternalEList<?>)getUsedKnowledge()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURE:
				return basicSetRequiringFeature(null, msgs);
			case RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE:
				return basicSetProvidingFeature(null, msgs);
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
			case RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURE:
				return eInternalContainer().eInverseRemove(this, RequirementsPackage.FEATURE__REQUIRED_SOFTWARE_INTERFACE, Feature.class, msgs);
			case RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE:
				return eInternalContainer().eInverseRemove(this, RequirementsPackage.FEATURE__PROVIDED_SOFTWARE_INTERFACES, Feature.class, msgs);
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
			case RequirementsPackage.SOFTWARE_INTERFACE__NAME:
				return getName();
			case RequirementsPackage.SOFTWARE_INTERFACE__DESCRIPTION:
				return getDescription();
			case RequirementsPackage.SOFTWARE_INTERFACE__IDENTIFIER:
				return getIdentifier();
			case RequirementsPackage.SOFTWARE_INTERFACE__USED_KNOWLEDGE:
				return getUsedKnowledge();
			case RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURE:
				return getRequiringFeature();
			case RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE:
				return getProvidingFeature();
			case RequirementsPackage.SOFTWARE_INTERFACE__DATA_TYPES:
				return getDataTypes();
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
			case RequirementsPackage.SOFTWARE_INTERFACE__NAME:
				setName((String)newValue);
				return;
			case RequirementsPackage.SOFTWARE_INTERFACE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case RequirementsPackage.SOFTWARE_INTERFACE__IDENTIFIER:
				setIdentifier((String)newValue);
				return;
			case RequirementsPackage.SOFTWARE_INTERFACE__USED_KNOWLEDGE:
				getUsedKnowledge().clear();
				getUsedKnowledge().addAll((Collection<? extends ScientificKnowledge>)newValue);
				return;
			case RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURE:
				setRequiringFeature((Feature)newValue);
				return;
			case RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE:
				setProvidingFeature((Feature)newValue);
				return;
			case RequirementsPackage.SOFTWARE_INTERFACE__DATA_TYPES:
				setDataTypes((String)newValue);
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
			case RequirementsPackage.SOFTWARE_INTERFACE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RequirementsPackage.SOFTWARE_INTERFACE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case RequirementsPackage.SOFTWARE_INTERFACE__IDENTIFIER:
				setIdentifier(IDENTIFIER_EDEFAULT);
				return;
			case RequirementsPackage.SOFTWARE_INTERFACE__USED_KNOWLEDGE:
				getUsedKnowledge().clear();
				return;
			case RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURE:
				setRequiringFeature((Feature)null);
				return;
			case RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE:
				setProvidingFeature((Feature)null);
				return;
			case RequirementsPackage.SOFTWARE_INTERFACE__DATA_TYPES:
				setDataTypes(DATA_TYPES_EDEFAULT);
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
			case RequirementsPackage.SOFTWARE_INTERFACE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RequirementsPackage.SOFTWARE_INTERFACE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case RequirementsPackage.SOFTWARE_INTERFACE__IDENTIFIER:
				return IDENTIFIER_EDEFAULT == null ? identifier != null : !IDENTIFIER_EDEFAULT.equals(identifier);
			case RequirementsPackage.SOFTWARE_INTERFACE__USED_KNOWLEDGE:
				return usedKnowledge != null && !usedKnowledge.isEmpty();
			case RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURE:
				return getRequiringFeature() != null;
			case RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE:
				return getProvidingFeature() != null;
			case RequirementsPackage.SOFTWARE_INTERFACE__DATA_TYPES:
				return DATA_TYPES_EDEFAULT == null ? dataTypes != null : !DATA_TYPES_EDEFAULT.equals(dataTypes);
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
		result.append(", dataTypes: ");
		result.append(dataTypes);
		result.append(')');
		return result.toString();
	}

} //SoftwareInterfaceImpl
