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

import scrm.impl.SCRMModelElementImpl;
import scrm.requirements.ComputionalHardware;
import scrm.requirements.Feature;
import scrm.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Computional Hardware</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.impl.ComputionalHardwareImpl#getDependingFeature <em>Depending Feature</em>}</li>
 *   <li>{@link scrm.requirements.impl.ComputionalHardwareImpl#getProcessor <em>Processor</em>}</li>
 *   <li>{@link scrm.requirements.impl.ComputionalHardwareImpl#getPlatform <em>Platform</em>}</li>
 *   <li>{@link scrm.requirements.impl.ComputionalHardwareImpl#getMemory <em>Memory</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComputionalHardwareImpl extends SCRMModelElementImpl implements
		ComputionalHardware {
	/**
	 * The cached value of the '{@link #getDependingFeature() <em>Depending Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependingFeature()
	 * @generated
	 * @ordered
	 */
	protected Feature dependingFeature;

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
	 * @generated NOT
	 */
	protected ComputionalHardwareImpl() {
		super();
		description = "Your software application does computation on what computing system.";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.COMPUTIONAL_HARDWARE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getDependingFeature() {
		if (dependingFeature != null && dependingFeature.eIsProxy()) {
			InternalEObject oldDependingFeature = (InternalEObject) dependingFeature;
			dependingFeature = (Feature) eResolveProxy(oldDependingFeature);
			if (dependingFeature != oldDependingFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							RequirementsPackage.COMPUTIONAL_HARDWARE__DEPENDING_FEATURE,
							oldDependingFeature, dependingFeature));
			}
		}
		return dependingFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetDependingFeature() {
		return dependingFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependingFeature(
			Feature newDependingFeature, NotificationChain msgs) {
		Feature oldDependingFeature = dependingFeature;
		dependingFeature = newDependingFeature;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
					this,
					Notification.SET,
					RequirementsPackage.COMPUTIONAL_HARDWARE__DEPENDING_FEATURE,
					oldDependingFeature, newDependingFeature);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependingFeature(Feature newDependingFeature) {
		if (newDependingFeature != dependingFeature) {
			NotificationChain msgs = null;
			if (dependingFeature != null)
				msgs = ((InternalEObject) dependingFeature).eInverseRemove(
						this,
						RequirementsPackage.FEATURE__COMPUTATIONAL_HARDWARE,
						Feature.class, msgs);
			if (newDependingFeature != null)
				msgs = ((InternalEObject) newDependingFeature).eInverseAdd(
						this,
						RequirementsPackage.FEATURE__COMPUTATIONAL_HARDWARE,
						Feature.class, msgs);
			msgs = basicSetDependingFeature(newDependingFeature, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					RequirementsPackage.COMPUTIONAL_HARDWARE__DEPENDING_FEATURE,
					newDependingFeature, newDependingFeature));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementsPackage.COMPUTIONAL_HARDWARE__PROCESSOR,
					oldProcessor, processor));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementsPackage.COMPUTIONAL_HARDWARE__PLATFORM,
					oldPlatform, platform));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementsPackage.COMPUTIONAL_HARDWARE__MEMORY,
					oldMemory, memory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementsPackage.COMPUTIONAL_HARDWARE__DEPENDING_FEATURE:
			if (dependingFeature != null)
				msgs = ((InternalEObject) dependingFeature).eInverseRemove(
						this,
						RequirementsPackage.FEATURE__COMPUTATIONAL_HARDWARE,
						Feature.class, msgs);
			return basicSetDependingFeature((Feature) otherEnd, msgs);
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
		case RequirementsPackage.COMPUTIONAL_HARDWARE__DEPENDING_FEATURE:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RequirementsPackage.COMPUTIONAL_HARDWARE__DEPENDING_FEATURE:
			if (resolve)
				return getDependingFeature();
			return basicGetDependingFeature();
		case RequirementsPackage.COMPUTIONAL_HARDWARE__PROCESSOR:
			return getProcessor();
		case RequirementsPackage.COMPUTIONAL_HARDWARE__PLATFORM:
			return getPlatform();
		case RequirementsPackage.COMPUTIONAL_HARDWARE__MEMORY:
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
		case RequirementsPackage.COMPUTIONAL_HARDWARE__DEPENDING_FEATURE:
			setDependingFeature((Feature) newValue);
			return;
		case RequirementsPackage.COMPUTIONAL_HARDWARE__PROCESSOR:
			setProcessor((String) newValue);
			return;
		case RequirementsPackage.COMPUTIONAL_HARDWARE__PLATFORM:
			setPlatform((String) newValue);
			return;
		case RequirementsPackage.COMPUTIONAL_HARDWARE__MEMORY:
			setMemory((String) newValue);
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
		case RequirementsPackage.COMPUTIONAL_HARDWARE__DEPENDING_FEATURE:
			setDependingFeature((Feature) null);
			return;
		case RequirementsPackage.COMPUTIONAL_HARDWARE__PROCESSOR:
			setProcessor(PROCESSOR_EDEFAULT);
			return;
		case RequirementsPackage.COMPUTIONAL_HARDWARE__PLATFORM:
			setPlatform(PLATFORM_EDEFAULT);
			return;
		case RequirementsPackage.COMPUTIONAL_HARDWARE__MEMORY:
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
		case RequirementsPackage.COMPUTIONAL_HARDWARE__DEPENDING_FEATURE:
			return dependingFeature != null;
		case RequirementsPackage.COMPUTIONAL_HARDWARE__PROCESSOR:
			return PROCESSOR_EDEFAULT == null ? processor != null
					: !PROCESSOR_EDEFAULT.equals(processor);
		case RequirementsPackage.COMPUTIONAL_HARDWARE__PLATFORM:
			return PLATFORM_EDEFAULT == null ? platform != null
					: !PLATFORM_EDEFAULT.equals(platform);
		case RequirementsPackage.COMPUTIONAL_HARDWARE__MEMORY:
			return MEMORY_EDEFAULT == null ? memory != null : !MEMORY_EDEFAULT
					.equals(memory);
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
		if (eIsProxy())
			return super.toString();

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

} //ComputionalHardwareImpl
