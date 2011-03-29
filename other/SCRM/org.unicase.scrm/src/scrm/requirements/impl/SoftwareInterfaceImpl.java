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
 *   <li>{@link scrm.requirements.impl.SoftwareInterfaceImpl#getUsedKnowledge <em>Used Knowledge</em>}</li>
 *   <li>{@link scrm.requirements.impl.SoftwareInterfaceImpl#getProvidingFeature <em>Providing Feature</em>}</li>
 *   <li>{@link scrm.requirements.impl.SoftwareInterfaceImpl#getRequiringFeatures <em>Requiring Features</em>}</li>
 *   <li>{@link scrm.requirements.impl.SoftwareInterfaceImpl#getDataTypes <em>Data Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SoftwareInterfaceImpl extends SCRMModelElementImpl implements SoftwareInterface {
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
	public ScientificKnowledge getUsedKnowledge() {
		if (eContainerFeatureID() != RequirementsPackage.SOFTWARE_INTERFACE__USED_KNOWLEDGE) return null;
		return (ScientificKnowledge)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUsedKnowledge(ScientificKnowledge newUsedKnowledge, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newUsedKnowledge, RequirementsPackage.SOFTWARE_INTERFACE__USED_KNOWLEDGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsedKnowledge(ScientificKnowledge newUsedKnowledge) {
		if (newUsedKnowledge != eInternalContainer() || (eContainerFeatureID() != RequirementsPackage.SOFTWARE_INTERFACE__USED_KNOWLEDGE && newUsedKnowledge != null)) {
			if (EcoreUtil.isAncestor(this, newUsedKnowledge))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newUsedKnowledge != null)
				msgs = ((InternalEObject)newUsedKnowledge).eInverseAdd(this, KnowledgePackage.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS, ScientificKnowledge.class, msgs);
			msgs = basicSetUsedKnowledge(newUsedKnowledge, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.SOFTWARE_INTERFACE__USED_KNOWLEDGE, newUsedKnowledge, newUsedKnowledge));
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
				msgs = ((InternalEObject)newProvidingFeature).eInverseAdd(this, RequirementsPackage.FEATURE__PROVIDED_INTERFACES, Feature.class, msgs);
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
	public EList<Feature> getRequiringFeatures() {
		if (requiringFeatures == null) {
			requiringFeatures = new EObjectWithInverseResolvingEList.ManyInverse<Feature>(Feature.class, this, RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURES, RequirementsPackage.FEATURE__REQUIRED_INTERFACES);
		}
		return requiringFeatures;
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
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetUsedKnowledge((ScientificKnowledge)otherEnd, msgs);
			case RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetProvidingFeature((Feature)otherEnd, msgs);
			case RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequiringFeatures()).basicAdd(otherEnd, msgs);
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
				return basicSetUsedKnowledge(null, msgs);
			case RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE:
				return basicSetProvidingFeature(null, msgs);
			case RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURES:
				return ((InternalEList<?>)getRequiringFeatures()).basicRemove(otherEnd, msgs);
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
			case RequirementsPackage.SOFTWARE_INTERFACE__USED_KNOWLEDGE:
				return eInternalContainer().eInverseRemove(this, KnowledgePackage.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS, ScientificKnowledge.class, msgs);
			case RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE:
				return eInternalContainer().eInverseRemove(this, RequirementsPackage.FEATURE__PROVIDED_INTERFACES, Feature.class, msgs);
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
			case RequirementsPackage.SOFTWARE_INTERFACE__USED_KNOWLEDGE:
				return getUsedKnowledge();
			case RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE:
				return getProvidingFeature();
			case RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURES:
				return getRequiringFeatures();
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
			case RequirementsPackage.SOFTWARE_INTERFACE__USED_KNOWLEDGE:
				setUsedKnowledge((ScientificKnowledge)newValue);
				return;
			case RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE:
				setProvidingFeature((Feature)newValue);
				return;
			case RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURES:
				getRequiringFeatures().clear();
				getRequiringFeatures().addAll((Collection<? extends Feature>)newValue);
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
			case RequirementsPackage.SOFTWARE_INTERFACE__USED_KNOWLEDGE:
				setUsedKnowledge((ScientificKnowledge)null);
				return;
			case RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE:
				setProvidingFeature((Feature)null);
				return;
			case RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURES:
				getRequiringFeatures().clear();
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
			case RequirementsPackage.SOFTWARE_INTERFACE__USED_KNOWLEDGE:
				return getUsedKnowledge() != null;
			case RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE:
				return getProvidingFeature() != null;
			case RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURES:
				return requiringFeatures != null && !requiringFeatures.isEmpty();
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
		result.append(" (dataTypes: ");
		result.append(dataTypes);
		result.append(')');
		return result.toString();
	}

} //SoftwareInterfaceImpl
