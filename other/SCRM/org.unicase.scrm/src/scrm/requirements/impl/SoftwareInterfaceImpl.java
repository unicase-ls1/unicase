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
 *   <li>{@link scrm.requirements.impl.SoftwareInterfaceImpl#getUsedKnowledge <em>Used Knowledge</em>}</li>
 *   <li>{@link scrm.requirements.impl.SoftwareInterfaceImpl#getRequiringFeature <em>Requiring Feature</em>}</li>
 *   <li>{@link scrm.requirements.impl.SoftwareInterfaceImpl#getProvidingFeature <em>Providing Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SoftwareInterfaceImpl extends EObjectImpl implements SoftwareInterface {
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
			case RequirementsPackage.SOFTWARE_INTERFACE__USED_KNOWLEDGE:
				return getUsedKnowledge();
			case RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURE:
				return getRequiringFeature();
			case RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE:
				return getProvidingFeature();
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
				getUsedKnowledge().clear();
				getUsedKnowledge().addAll((Collection<? extends ScientificKnowledge>)newValue);
				return;
			case RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURE:
				setRequiringFeature((Feature)newValue);
				return;
			case RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE:
				setProvidingFeature((Feature)newValue);
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
				getUsedKnowledge().clear();
				return;
			case RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURE:
				setRequiringFeature((Feature)null);
				return;
			case RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE:
				setProvidingFeature((Feature)null);
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
				return usedKnowledge != null && !usedKnowledge.isEmpty();
			case RequirementsPackage.SOFTWARE_INTERFACE__REQUIRING_FEATURE:
				return getRequiringFeature() != null;
			case RequirementsPackage.SOFTWARE_INTERFACE__PROVIDING_FEATURE:
				return getProvidingFeature() != null;
		}
		return super.eIsSet(featureID);
	}

} //SoftwareInterfaceImpl
