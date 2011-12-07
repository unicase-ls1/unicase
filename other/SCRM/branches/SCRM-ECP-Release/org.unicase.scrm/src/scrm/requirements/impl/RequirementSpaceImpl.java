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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import scrm.SCRMDiagram;
import scrm.SCRMModelElement;
import scrm.ScrmPackage;
import scrm.impl.SCRMModelElementImpl;
import scrm.lists.SCRMSpaceContainedModelElementsList;

import scrm.requirements.IRequirement;
import scrm.requirements.RequirementSpace;
import scrm.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.impl.RequirementSpaceImpl#getRepresentingDiagram <em>Representing Diagram</em>}</li>
 *   <li>{@link scrm.requirements.impl.RequirementSpaceImpl#getContainingRequirementSpace <em>Containing Requirement Space</em>}</li>
 *   <li>{@link scrm.requirements.impl.RequirementSpaceImpl#getContainedInformationofRequirements <em>Contained Informationof Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementSpaceImpl extends SCRMModelElementImpl implements
		RequirementSpace {
	/**
	 * The cached value of the '{@link #getRepresentingDiagram() <em>Representing Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresentingDiagram()
	 * @generated
	 * @ordered
	 */
	protected SCRMDiagram representingDiagram;

	/**
	 * The cached value of the '{@link #getContainedInformationofRequirements() <em>Contained Informationof Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedInformationofRequirements()
	 * @generated NOT: custom type
	 * @ordered
	 */
	protected SCRMSpaceContainedModelElementsList<SCRMModelElement> containedInformationofRequirements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementSpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.REQUIREMENT_SPACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementSpace getContainingRequirementSpace() {
		if (eContainerFeatureID() != RequirementsPackage.REQUIREMENT_SPACE__CONTAINING_REQUIREMENT_SPACE)
			return null;
		return (RequirementSpace) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementSpace basicGetContainingRequirementSpace() {
		if (eContainerFeatureID() != RequirementsPackage.REQUIREMENT_SPACE__CONTAINING_REQUIREMENT_SPACE)
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
				RequirementsPackage.REQUIREMENT_SPACE__CONTAINING_REQUIREMENT_SPACE,
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
				|| (eContainerFeatureID() != RequirementsPackage.REQUIREMENT_SPACE__CONTAINING_REQUIREMENT_SPACE && newContainingRequirementSpace != null)) {
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
					RequirementsPackage.REQUIREMENT_SPACE__CONTAINING_REQUIREMENT_SPACE,
					newContainingRequirementSpace,
					newContainingRequirementSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT: custom type
	 */
	public SCRMSpaceContainedModelElementsList<SCRMModelElement> getContainedInformationofRequirements() {
		if (containedInformationofRequirements == null) {
			containedInformationofRequirements = new SCRMSpaceContainedModelElementsList<SCRMModelElement>(
					IRequirement.class,
					this,
					RequirementsPackage.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
					RequirementsPackage.IREQUIREMENT__CONTAINING_REQUIREMENT_SPACE);
			containedInformationofRequirements
					.setDiagram(getRepresentingDiagram());
		}
		return containedInformationofRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCRMDiagram getRepresentingDiagram() {
		if (representingDiagram != null && representingDiagram.eIsProxy()) {
			InternalEObject oldRepresentingDiagram = (InternalEObject) representingDiagram;
			representingDiagram = (SCRMDiagram) eResolveProxy(oldRepresentingDiagram);
			if (representingDiagram != oldRepresentingDiagram) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							RequirementsPackage.REQUIREMENT_SPACE__REPRESENTING_DIAGRAM,
							oldRepresentingDiagram, representingDiagram));
			}
		}
		return representingDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCRMDiagram basicGetRepresentingDiagram() {
		return representingDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepresentingDiagram(
			SCRMDiagram newRepresentingDiagram, NotificationChain msgs) {
		SCRMDiagram oldRepresentingDiagram = representingDiagram;
		representingDiagram = newRepresentingDiagram;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
					this,
					Notification.SET,
					RequirementsPackage.REQUIREMENT_SPACE__REPRESENTING_DIAGRAM,
					oldRepresentingDiagram, newRepresentingDiagram);
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
	 * @generated NOT: update diagram in containment list
	 */
	public void setRepresentingDiagram(SCRMDiagram newRepresentingDiagram) {
		if (newRepresentingDiagram != representingDiagram) {
			getContainedInformationofRequirements().setDiagram(
					newRepresentingDiagram);
			NotificationChain msgs = null;
			if (representingDiagram != null)
				msgs = ((InternalEObject) representingDiagram).eInverseRemove(
						this, ScrmPackage.SCRM_DIAGRAM__REPRESENTED_SPACE,
						SCRMDiagram.class, msgs);
			if (newRepresentingDiagram != null)
				msgs = ((InternalEObject) newRepresentingDiagram).eInverseAdd(
						this, ScrmPackage.SCRM_DIAGRAM__REPRESENTED_SPACE,
						SCRMDiagram.class, msgs);
			msgs = basicSetRepresentingDiagram(newRepresentingDiagram, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					RequirementsPackage.REQUIREMENT_SPACE__REPRESENTING_DIAGRAM,
					newRepresentingDiagram, newRepresentingDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT: implemented abstract operation
	 */
	public EList<SCRMModelElement> getContainedModelElements() {
		return getContainedInformationofRequirements();
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
		case RequirementsPackage.REQUIREMENT_SPACE__REPRESENTING_DIAGRAM:
			if (representingDiagram != null)
				msgs = ((InternalEObject) representingDiagram).eInverseRemove(
						this, ScrmPackage.SCRM_DIAGRAM__REPRESENTED_SPACE,
						SCRMDiagram.class, msgs);
			return basicSetRepresentingDiagram((SCRMDiagram) otherEnd, msgs);
		case RequirementsPackage.REQUIREMENT_SPACE__CONTAINING_REQUIREMENT_SPACE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContainingRequirementSpace(
					(RequirementSpace) otherEnd, msgs);
		case RequirementsPackage.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getContainedInformationofRequirements())
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
		case RequirementsPackage.REQUIREMENT_SPACE__REPRESENTING_DIAGRAM:
			return basicSetRepresentingDiagram(null, msgs);
		case RequirementsPackage.REQUIREMENT_SPACE__CONTAINING_REQUIREMENT_SPACE:
			return basicSetContainingRequirementSpace(null, msgs);
		case RequirementsPackage.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS:
			return ((InternalEList<?>) getContainedInformationofRequirements())
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
		case RequirementsPackage.REQUIREMENT_SPACE__CONTAINING_REQUIREMENT_SPACE:
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
		case RequirementsPackage.REQUIREMENT_SPACE__REPRESENTING_DIAGRAM:
			if (resolve)
				return getRepresentingDiagram();
			return basicGetRepresentingDiagram();
		case RequirementsPackage.REQUIREMENT_SPACE__CONTAINING_REQUIREMENT_SPACE:
			if (resolve)
				return getContainingRequirementSpace();
			return basicGetContainingRequirementSpace();
		case RequirementsPackage.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS:
			return getContainedInformationofRequirements();
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
		case RequirementsPackage.REQUIREMENT_SPACE__REPRESENTING_DIAGRAM:
			setRepresentingDiagram((SCRMDiagram) newValue);
			return;
		case RequirementsPackage.REQUIREMENT_SPACE__CONTAINING_REQUIREMENT_SPACE:
			setContainingRequirementSpace((RequirementSpace) newValue);
			return;
		case RequirementsPackage.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS:
			getContainedInformationofRequirements().clear();
			getContainedInformationofRequirements().addAll(
					(Collection<? extends IRequirement>) newValue);
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
		case RequirementsPackage.REQUIREMENT_SPACE__REPRESENTING_DIAGRAM:
			setRepresentingDiagram((SCRMDiagram) null);
			return;
		case RequirementsPackage.REQUIREMENT_SPACE__CONTAINING_REQUIREMENT_SPACE:
			setContainingRequirementSpace((RequirementSpace) null);
			return;
		case RequirementsPackage.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS:
			getContainedInformationofRequirements().clear();
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
		case RequirementsPackage.REQUIREMENT_SPACE__REPRESENTING_DIAGRAM:
			return representingDiagram != null;
		case RequirementsPackage.REQUIREMENT_SPACE__CONTAINING_REQUIREMENT_SPACE:
			return basicGetContainingRequirementSpace() != null;
		case RequirementsPackage.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS:
			return containedInformationofRequirements != null
					&& !containedInformationofRequirements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == IRequirement.class) {
			switch (derivedFeatureID) {
			case RequirementsPackage.REQUIREMENT_SPACE__CONTAINING_REQUIREMENT_SPACE:
				return RequirementsPackage.IREQUIREMENT__CONTAINING_REQUIREMENT_SPACE;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == IRequirement.class) {
			switch (baseFeatureID) {
			case RequirementsPackage.IREQUIREMENT__CONTAINING_REQUIREMENT_SPACE:
				return RequirementsPackage.REQUIREMENT_SPACE__CONTAINING_REQUIREMENT_SPACE;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //RequirementSpaceImpl
