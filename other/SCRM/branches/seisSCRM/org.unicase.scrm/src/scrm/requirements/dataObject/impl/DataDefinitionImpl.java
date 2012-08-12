/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataObject.impl;

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
import scrm.knowledge.Mathematical_GeophysicalModel;
import scrm.requirements.Interface;
import scrm.requirements.Requirement;
import scrm.requirements.RequirementSpace;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.dataObject.DataDefinition;
import scrm.requirements.dataObject.DataObjectPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.dataObject.impl.DataDefinitionImpl#getContainingRequirementSpace <em>Containing Requirement Space</em>}</li>
 *   <li>{@link scrm.requirements.dataObject.impl.DataDefinitionImpl#getDefinedRequirement <em>Defined Requirement</em>}</li>
 *   <li>{@link scrm.requirements.dataObject.impl.DataDefinitionImpl#getAccuracy <em>Accuracy</em>}</li>
 *   <li>{@link scrm.requirements.dataObject.impl.DataDefinitionImpl#getRange <em>Range</em>}</li>
 *   <li>{@link scrm.requirements.dataObject.impl.DataDefinitionImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link scrm.requirements.dataObject.impl.DataDefinitionImpl#getProvidedInterface <em>Provided Interface</em>}</li>
 *   <li>{@link scrm.requirements.dataObject.impl.DataDefinitionImpl#getRequiredInterface <em>Required Interface</em>}</li>
 *   <li>{@link scrm.requirements.dataObject.impl.DataDefinitionImpl#getDescribedModel <em>Described Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataDefinitionImpl extends SCRMModelElementImpl implements
		DataDefinition {
	/**
	 * The cached value of the '{@link #getDefinedRequirement() <em>Defined Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinedRequirement()
	 * @generated
	 * @ordered
	 */
	protected Requirement definedRequirement;

	/**
	 * The default value of the '{@link #getAccuracy() <em>Accuracy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccuracy()
	 * @generated
	 * @ordered
	 */
	protected static final String ACCURACY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAccuracy() <em>Accuracy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccuracy()
	 * @generated
	 * @ordered
	 */
	protected String accuracy = ACCURACY_EDEFAULT;

	/**
	 * The default value of the '{@link #getRange() <em>Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange()
	 * @generated
	 * @ordered
	 */
	protected static final String RANGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRange() <em>Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange()
	 * @generated
	 * @ordered
	 */
	protected String range = RANGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected String format = FORMAT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProvidedInterface() <em>Provided Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedInterface()
	 * @generated
	 * @ordered
	 */
	protected Interface providedInterface;

	/**
	 * The cached value of the '{@link #getRequiredInterface() <em>Required Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredInterface()
	 * @generated
	 * @ordered
	 */
	protected Interface requiredInterface;

	/**
	 * The cached value of the '{@link #getDescribedModel() <em>Described Model</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescribedModel()
	 * @generated
	 * @ordered
	 */
	protected EList<Mathematical_GeophysicalModel> describedModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataObjectPackage.Literals.DATA_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementSpace getContainingRequirementSpace() {
		if (eContainerFeatureID() != DataObjectPackage.DATA_DEFINITION__CONTAINING_REQUIREMENT_SPACE)
			return null;
		return (RequirementSpace) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementSpace basicGetContainingRequirementSpace() {
		if (eContainerFeatureID() != DataObjectPackage.DATA_DEFINITION__CONTAINING_REQUIREMENT_SPACE)
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
				DataObjectPackage.DATA_DEFINITION__CONTAINING_REQUIREMENT_SPACE,
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
				|| (eContainerFeatureID() != DataObjectPackage.DATA_DEFINITION__CONTAINING_REQUIREMENT_SPACE && newContainingRequirementSpace != null)) {
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
					DataObjectPackage.DATA_DEFINITION__CONTAINING_REQUIREMENT_SPACE,
					newContainingRequirementSpace,
					newContainingRequirementSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement getDefinedRequirement() {
		if (definedRequirement != null && definedRequirement.eIsProxy()) {
			InternalEObject oldDefinedRequirement = (InternalEObject) definedRequirement;
			definedRequirement = (Requirement) eResolveProxy(oldDefinedRequirement);
			if (definedRequirement != oldDefinedRequirement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							DataObjectPackage.DATA_DEFINITION__DEFINED_REQUIREMENT,
							oldDefinedRequirement, definedRequirement));
			}
		}
		return definedRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement basicGetDefinedRequirement() {
		return definedRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefinedRequirement(
			Requirement newDefinedRequirement, NotificationChain msgs) {
		Requirement oldDefinedRequirement = definedRequirement;
		definedRequirement = newDefinedRequirement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					DataObjectPackage.DATA_DEFINITION__DEFINED_REQUIREMENT,
					oldDefinedRequirement, newDefinedRequirement);
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
	public void setDefinedRequirement(Requirement newDefinedRequirement) {
		if (newDefinedRequirement != definedRequirement) {
			NotificationChain msgs = null;
			if (definedRequirement != null)
				msgs = ((InternalEObject) definedRequirement).eInverseRemove(
						this, RequirementsPackage.REQUIREMENT__HANDLING_DATA,
						Requirement.class, msgs);
			if (newDefinedRequirement != null)
				msgs = ((InternalEObject) newDefinedRequirement).eInverseAdd(
						this, RequirementsPackage.REQUIREMENT__HANDLING_DATA,
						Requirement.class, msgs);
			msgs = basicSetDefinedRequirement(newDefinedRequirement, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataObjectPackage.DATA_DEFINITION__DEFINED_REQUIREMENT,
					newDefinedRequirement, newDefinedRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAccuracy() {
		return accuracy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccuracy(String newAccuracy) {
		String oldAccuracy = accuracy;
		accuracy = newAccuracy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataObjectPackage.DATA_DEFINITION__ACCURACY, oldAccuracy,
					accuracy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRange() {
		return range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRange(String newRange) {
		String oldRange = range;
		range = newRange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataObjectPackage.DATA_DEFINITION__RANGE, oldRange, range));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormat(String newFormat) {
		String oldFormat = format;
		format = newFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataObjectPackage.DATA_DEFINITION__FORMAT, oldFormat,
					format));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getProvidedInterface() {
		if (providedInterface != null && providedInterface.eIsProxy()) {
			InternalEObject oldProvidedInterface = (InternalEObject) providedInterface;
			providedInterface = (Interface) eResolveProxy(oldProvidedInterface);
			if (providedInterface != oldProvidedInterface) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							DataObjectPackage.DATA_DEFINITION__PROVIDED_INTERFACE,
							oldProvidedInterface, providedInterface));
			}
		}
		return providedInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetProvidedInterface() {
		return providedInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProvidedInterface(
			Interface newProvidedInterface, NotificationChain msgs) {
		Interface oldProvidedInterface = providedInterface;
		providedInterface = newProvidedInterface;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					DataObjectPackage.DATA_DEFINITION__PROVIDED_INTERFACE,
					oldProvidedInterface, newProvidedInterface);
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
	public void setProvidedInterface(Interface newProvidedInterface) {
		if (newProvidedInterface != providedInterface) {
			NotificationChain msgs = null;
			if (providedInterface != null)
				msgs = ((InternalEObject) providedInterface).eInverseRemove(
						this, RequirementsPackage.INTERFACE__PROVIDING_DATA,
						Interface.class, msgs);
			if (newProvidedInterface != null)
				msgs = ((InternalEObject) newProvidedInterface).eInverseAdd(
						this, RequirementsPackage.INTERFACE__PROVIDING_DATA,
						Interface.class, msgs);
			msgs = basicSetProvidedInterface(newProvidedInterface, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataObjectPackage.DATA_DEFINITION__PROVIDED_INTERFACE,
					newProvidedInterface, newProvidedInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getRequiredInterface() {
		if (requiredInterface != null && requiredInterface.eIsProxy()) {
			InternalEObject oldRequiredInterface = (InternalEObject) requiredInterface;
			requiredInterface = (Interface) eResolveProxy(oldRequiredInterface);
			if (requiredInterface != oldRequiredInterface) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							DataObjectPackage.DATA_DEFINITION__REQUIRED_INTERFACE,
							oldRequiredInterface, requiredInterface));
			}
		}
		return requiredInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetRequiredInterface() {
		return requiredInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequiredInterface(
			Interface newRequiredInterface, NotificationChain msgs) {
		Interface oldRequiredInterface = requiredInterface;
		requiredInterface = newRequiredInterface;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					DataObjectPackage.DATA_DEFINITION__REQUIRED_INTERFACE,
					oldRequiredInterface, newRequiredInterface);
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
	public void setRequiredInterface(Interface newRequiredInterface) {
		if (newRequiredInterface != requiredInterface) {
			NotificationChain msgs = null;
			if (requiredInterface != null)
				msgs = ((InternalEObject) requiredInterface).eInverseRemove(
						this, RequirementsPackage.INTERFACE__REQUIRING_DATA,
						Interface.class, msgs);
			if (newRequiredInterface != null)
				msgs = ((InternalEObject) newRequiredInterface).eInverseAdd(
						this, RequirementsPackage.INTERFACE__REQUIRING_DATA,
						Interface.class, msgs);
			msgs = basicSetRequiredInterface(newRequiredInterface, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataObjectPackage.DATA_DEFINITION__REQUIRED_INTERFACE,
					newRequiredInterface, newRequiredInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mathematical_GeophysicalModel> getDescribedModel() {
		if (describedModel == null) {
			describedModel = new EObjectWithInverseResolvingEList.ManyInverse<Mathematical_GeophysicalModel>(
					Mathematical_GeophysicalModel.class,
					this,
					DataObjectPackage.DATA_DEFINITION__DESCRIBED_MODEL,
					KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__INVOLVED_DATA);
		}
		return describedModel;
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
		case DataObjectPackage.DATA_DEFINITION__CONTAINING_REQUIREMENT_SPACE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContainingRequirementSpace(
					(RequirementSpace) otherEnd, msgs);
		case DataObjectPackage.DATA_DEFINITION__DEFINED_REQUIREMENT:
			if (definedRequirement != null)
				msgs = ((InternalEObject) definedRequirement).eInverseRemove(
						this, RequirementsPackage.REQUIREMENT__HANDLING_DATA,
						Requirement.class, msgs);
			return basicSetDefinedRequirement((Requirement) otherEnd, msgs);
		case DataObjectPackage.DATA_DEFINITION__PROVIDED_INTERFACE:
			if (providedInterface != null)
				msgs = ((InternalEObject) providedInterface).eInverseRemove(
						this, RequirementsPackage.INTERFACE__PROVIDING_DATA,
						Interface.class, msgs);
			return basicSetProvidedInterface((Interface) otherEnd, msgs);
		case DataObjectPackage.DATA_DEFINITION__REQUIRED_INTERFACE:
			if (requiredInterface != null)
				msgs = ((InternalEObject) requiredInterface).eInverseRemove(
						this, RequirementsPackage.INTERFACE__REQUIRING_DATA,
						Interface.class, msgs);
			return basicSetRequiredInterface((Interface) otherEnd, msgs);
		case DataObjectPackage.DATA_DEFINITION__DESCRIBED_MODEL:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDescribedModel())
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
		case DataObjectPackage.DATA_DEFINITION__CONTAINING_REQUIREMENT_SPACE:
			return basicSetContainingRequirementSpace(null, msgs);
		case DataObjectPackage.DATA_DEFINITION__DEFINED_REQUIREMENT:
			return basicSetDefinedRequirement(null, msgs);
		case DataObjectPackage.DATA_DEFINITION__PROVIDED_INTERFACE:
			return basicSetProvidedInterface(null, msgs);
		case DataObjectPackage.DATA_DEFINITION__REQUIRED_INTERFACE:
			return basicSetRequiredInterface(null, msgs);
		case DataObjectPackage.DATA_DEFINITION__DESCRIBED_MODEL:
			return ((InternalEList<?>) getDescribedModel()).basicRemove(
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
		case DataObjectPackage.DATA_DEFINITION__CONTAINING_REQUIREMENT_SPACE:
			return eInternalContainer()
					.eInverseRemove(
							this,
							RequirementsPackage.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
							RequirementSpace.class, msgs);
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
		case DataObjectPackage.DATA_DEFINITION__CONTAINING_REQUIREMENT_SPACE:
			if (resolve)
				return getContainingRequirementSpace();
			return basicGetContainingRequirementSpace();
		case DataObjectPackage.DATA_DEFINITION__DEFINED_REQUIREMENT:
			if (resolve)
				return getDefinedRequirement();
			return basicGetDefinedRequirement();
		case DataObjectPackage.DATA_DEFINITION__ACCURACY:
			return getAccuracy();
		case DataObjectPackage.DATA_DEFINITION__RANGE:
			return getRange();
		case DataObjectPackage.DATA_DEFINITION__FORMAT:
			return getFormat();
		case DataObjectPackage.DATA_DEFINITION__PROVIDED_INTERFACE:
			if (resolve)
				return getProvidedInterface();
			return basicGetProvidedInterface();
		case DataObjectPackage.DATA_DEFINITION__REQUIRED_INTERFACE:
			if (resolve)
				return getRequiredInterface();
			return basicGetRequiredInterface();
		case DataObjectPackage.DATA_DEFINITION__DESCRIBED_MODEL:
			return getDescribedModel();
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
		case DataObjectPackage.DATA_DEFINITION__CONTAINING_REQUIREMENT_SPACE:
			setContainingRequirementSpace((RequirementSpace) newValue);
			return;
		case DataObjectPackage.DATA_DEFINITION__DEFINED_REQUIREMENT:
			setDefinedRequirement((Requirement) newValue);
			return;
		case DataObjectPackage.DATA_DEFINITION__ACCURACY:
			setAccuracy((String) newValue);
			return;
		case DataObjectPackage.DATA_DEFINITION__RANGE:
			setRange((String) newValue);
			return;
		case DataObjectPackage.DATA_DEFINITION__FORMAT:
			setFormat((String) newValue);
			return;
		case DataObjectPackage.DATA_DEFINITION__PROVIDED_INTERFACE:
			setProvidedInterface((Interface) newValue);
			return;
		case DataObjectPackage.DATA_DEFINITION__REQUIRED_INTERFACE:
			setRequiredInterface((Interface) newValue);
			return;
		case DataObjectPackage.DATA_DEFINITION__DESCRIBED_MODEL:
			getDescribedModel().clear();
			getDescribedModel()
					.addAll((Collection<? extends Mathematical_GeophysicalModel>) newValue);
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
		case DataObjectPackage.DATA_DEFINITION__CONTAINING_REQUIREMENT_SPACE:
			setContainingRequirementSpace((RequirementSpace) null);
			return;
		case DataObjectPackage.DATA_DEFINITION__DEFINED_REQUIREMENT:
			setDefinedRequirement((Requirement) null);
			return;
		case DataObjectPackage.DATA_DEFINITION__ACCURACY:
			setAccuracy(ACCURACY_EDEFAULT);
			return;
		case DataObjectPackage.DATA_DEFINITION__RANGE:
			setRange(RANGE_EDEFAULT);
			return;
		case DataObjectPackage.DATA_DEFINITION__FORMAT:
			setFormat(FORMAT_EDEFAULT);
			return;
		case DataObjectPackage.DATA_DEFINITION__PROVIDED_INTERFACE:
			setProvidedInterface((Interface) null);
			return;
		case DataObjectPackage.DATA_DEFINITION__REQUIRED_INTERFACE:
			setRequiredInterface((Interface) null);
			return;
		case DataObjectPackage.DATA_DEFINITION__DESCRIBED_MODEL:
			getDescribedModel().clear();
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
		case DataObjectPackage.DATA_DEFINITION__CONTAINING_REQUIREMENT_SPACE:
			return basicGetContainingRequirementSpace() != null;
		case DataObjectPackage.DATA_DEFINITION__DEFINED_REQUIREMENT:
			return definedRequirement != null;
		case DataObjectPackage.DATA_DEFINITION__ACCURACY:
			return ACCURACY_EDEFAULT == null ? accuracy != null
					: !ACCURACY_EDEFAULT.equals(accuracy);
		case DataObjectPackage.DATA_DEFINITION__RANGE:
			return RANGE_EDEFAULT == null ? range != null : !RANGE_EDEFAULT
					.equals(range);
		case DataObjectPackage.DATA_DEFINITION__FORMAT:
			return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT
					.equals(format);
		case DataObjectPackage.DATA_DEFINITION__PROVIDED_INTERFACE:
			return providedInterface != null;
		case DataObjectPackage.DATA_DEFINITION__REQUIRED_INTERFACE:
			return requiredInterface != null;
		case DataObjectPackage.DATA_DEFINITION__DESCRIBED_MODEL:
			return describedModel != null && !describedModel.isEmpty();
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
		result.append(" (accuracy: ");
		result.append(accuracy);
		result.append(", range: ");
		result.append(range);
		result.append(", format: ");
		result.append(format);
		result.append(')');
		return result.toString();
	}

} //DataDefinitionImpl
