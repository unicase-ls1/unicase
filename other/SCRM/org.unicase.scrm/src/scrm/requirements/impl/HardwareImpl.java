/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import scrm.impl.SCRMModelElementImpl;

import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.ScientificKnowledge;

import scrm.requirements.Feature;
import scrm.requirements.Hardware;
import scrm.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hardware</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.impl.HardwareImpl#getUsedKnowledge <em>Used Knowledge</em>}</li>
 *   <li>{@link scrm.requirements.impl.HardwareImpl#getDependingFeature <em>Depending Feature</em>}</li>
 *   <li>{@link scrm.requirements.impl.HardwareImpl#getProcessor <em>Processor</em>}</li>
 *   <li>{@link scrm.requirements.impl.HardwareImpl#getPlatform <em>Platform</em>}</li>
 *   <li>{@link scrm.requirements.impl.HardwareImpl#getMemory <em>Memory</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HardwareImpl extends SCRMModelElementImpl implements Hardware {
	/**
	 * The default value of the '{@link #getProcessor() <em>Processor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessor()
	 * @generated
	 * @ordered
	 */
	protected static final String PROCESSOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProcessor() <em>Processor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessor()
	 * @generated
	 * @ordered
	 */
	protected String processor = PROCESSOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getPlatform() <em>Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatform()
	 * @generated
	 * @ordered
	 */
	protected static final String PLATFORM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPlatform() <em>Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatform()
	 * @generated
	 * @ordered
	 */
	protected String platform = PLATFORM_EDEFAULT;

	/**
	 * The default value of the '{@link #getMemory() <em>Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemory()
	 * @generated
	 * @ordered
	 */
	protected static final String MEMORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMemory() <em>Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemory()
	 * @generated
	 * @ordered
	 */
	protected String memory = MEMORY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HardwareImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.HARDWARE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScientificKnowledge getUsedKnowledge() {
		if (eContainerFeatureID() != RequirementsPackage.HARDWARE__USED_KNOWLEDGE) return null;
		return (ScientificKnowledge)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUsedKnowledge(ScientificKnowledge newUsedKnowledge, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newUsedKnowledge, RequirementsPackage.HARDWARE__USED_KNOWLEDGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsedKnowledge(ScientificKnowledge newUsedKnowledge) {
		if (newUsedKnowledge != eInternalContainer() || (eContainerFeatureID() != RequirementsPackage.HARDWARE__USED_KNOWLEDGE && newUsedKnowledge != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.HARDWARE__USED_KNOWLEDGE, newUsedKnowledge, newUsedKnowledge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getDependingFeature() {
		if (eContainerFeatureID() != RequirementsPackage.HARDWARE__DEPENDING_FEATURE) return null;
		return (Feature)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependingFeature(Feature newDependingFeature, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDependingFeature, RequirementsPackage.HARDWARE__DEPENDING_FEATURE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependingFeature(Feature newDependingFeature) {
		if (newDependingFeature != eInternalContainer() || (eContainerFeatureID() != RequirementsPackage.HARDWARE__DEPENDING_FEATURE && newDependingFeature != null)) {
			if (EcoreUtil.isAncestor(this, newDependingFeature))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDependingFeature != null)
				msgs = ((InternalEObject)newDependingFeature).eInverseAdd(this, RequirementsPackage.FEATURE__DEPENDENCIES, Feature.class, msgs);
			msgs = basicSetDependingFeature(newDependingFeature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.HARDWARE__DEPENDING_FEATURE, newDependingFeature, newDependingFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProcessor() {
		return processor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessor(String newProcessor) {
		String oldProcessor = processor;
		processor = newProcessor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.HARDWARE__PROCESSOR, oldProcessor, processor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlatform(String newPlatform) {
		String oldPlatform = platform;
		platform = newPlatform;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.HARDWARE__PLATFORM, oldPlatform, platform));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMemory() {
		return memory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemory(String newMemory) {
		String oldMemory = memory;
		memory = newMemory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.HARDWARE__MEMORY, oldMemory, memory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RequirementsPackage.HARDWARE__USED_KNOWLEDGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetUsedKnowledge((ScientificKnowledge)otherEnd, msgs);
			case RequirementsPackage.HARDWARE__DEPENDING_FEATURE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDependingFeature((Feature)otherEnd, msgs);
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
			case RequirementsPackage.HARDWARE__USED_KNOWLEDGE:
				return basicSetUsedKnowledge(null, msgs);
			case RequirementsPackage.HARDWARE__DEPENDING_FEATURE:
				return basicSetDependingFeature(null, msgs);
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
			case RequirementsPackage.HARDWARE__USED_KNOWLEDGE:
				return eInternalContainer().eInverseRemove(this, KnowledgePackage.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS, ScientificKnowledge.class, msgs);
			case RequirementsPackage.HARDWARE__DEPENDING_FEATURE:
				return eInternalContainer().eInverseRemove(this, RequirementsPackage.FEATURE__DEPENDENCIES, Feature.class, msgs);
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
			case RequirementsPackage.HARDWARE__USED_KNOWLEDGE:
				return getUsedKnowledge();
			case RequirementsPackage.HARDWARE__DEPENDING_FEATURE:
				return getDependingFeature();
			case RequirementsPackage.HARDWARE__PROCESSOR:
				return getProcessor();
			case RequirementsPackage.HARDWARE__PLATFORM:
				return getPlatform();
			case RequirementsPackage.HARDWARE__MEMORY:
				return getMemory();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RequirementsPackage.HARDWARE__USED_KNOWLEDGE:
				setUsedKnowledge((ScientificKnowledge)newValue);
				return;
			case RequirementsPackage.HARDWARE__DEPENDING_FEATURE:
				setDependingFeature((Feature)newValue);
				return;
			case RequirementsPackage.HARDWARE__PROCESSOR:
				setProcessor((String)newValue);
				return;
			case RequirementsPackage.HARDWARE__PLATFORM:
				setPlatform((String)newValue);
				return;
			case RequirementsPackage.HARDWARE__MEMORY:
				setMemory((String)newValue);
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
			case RequirementsPackage.HARDWARE__USED_KNOWLEDGE:
				setUsedKnowledge((ScientificKnowledge)null);
				return;
			case RequirementsPackage.HARDWARE__DEPENDING_FEATURE:
				setDependingFeature((Feature)null);
				return;
			case RequirementsPackage.HARDWARE__PROCESSOR:
				setProcessor(PROCESSOR_EDEFAULT);
				return;
			case RequirementsPackage.HARDWARE__PLATFORM:
				setPlatform(PLATFORM_EDEFAULT);
				return;
			case RequirementsPackage.HARDWARE__MEMORY:
				setMemory(MEMORY_EDEFAULT);
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
			case RequirementsPackage.HARDWARE__USED_KNOWLEDGE:
				return getUsedKnowledge() != null;
			case RequirementsPackage.HARDWARE__DEPENDING_FEATURE:
				return getDependingFeature() != null;
			case RequirementsPackage.HARDWARE__PROCESSOR:
				return PROCESSOR_EDEFAULT == null ? processor != null : !PROCESSOR_EDEFAULT.equals(processor);
			case RequirementsPackage.HARDWARE__PLATFORM:
				return PLATFORM_EDEFAULT == null ? platform != null : !PLATFORM_EDEFAULT.equals(platform);
			case RequirementsPackage.HARDWARE__MEMORY:
				return MEMORY_EDEFAULT == null ? memory != null : !MEMORY_EDEFAULT.equals(memory);
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
		result.append(" (processor: ");
		result.append(processor);
		result.append(", platform: ");
		result.append(platform);
		result.append(", memory: ");
		result.append(memory);
		result.append(')');
		return result.toString();
	}

} //HardwareImpl
