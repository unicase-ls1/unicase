/**
 * <copyright> </copyright> $Id$
 */
package urml.requirement.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import urml.danger.impl.MitigationImpl;
import urml.requirement.Requirement;
import urml.requirement.RequirementPackage;
import urml.service.Service;
import urml.service.ServicePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Requirement</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link urml.requirement.impl.RequirementImpl#getImplementingServices <em>Implementing Services</em>}</li>
 *   <li>{@link urml.requirement.impl.RequirementImpl#getSubRequirements <em>Sub Requirements</em>}</li>
 *   <li>{@link urml.requirement.impl.RequirementImpl#getParentRequirement <em>Parent Requirement</em>}</li>
 *   <li>{@link urml.requirement.impl.RequirementImpl#isTerminal <em>Terminal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RequirementImpl extends MitigationImpl implements Requirement {
	/**
	 * The cached value of the '{@link #getImplementingServices() <em>Implementing Services</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getImplementingServices()
	 * @generated
	 * @ordered
	 */
	protected EList<Service> implementingServices;

	/**
	 * The cached value of the '{@link #getSubRequirements() <em>Sub Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSubRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> subRequirements;

	/**
	 * The default value of the '{@link #isTerminal() <em>Terminal</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isTerminal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TERMINAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTerminal() <em>Terminal</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isTerminal()
	 * @generated
	 * @ordered
	 */
	protected boolean terminal = TERMINAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementPackage.Literals.REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Service> getImplementingServices() {
		if (implementingServices == null) {
			implementingServices = new EObjectWithInverseResolvingEList.ManyInverse<Service>(Service.class, this,
				RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES, ServicePackage.SERVICE__SATISFIED_REQUIREMENTS);
		}
		return implementingServices;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getSubRequirements() {
		if (subRequirements == null) {
			subRequirements = new EObjectContainmentWithInverseEList.Resolving<Requirement>(Requirement.class, this,
				RequirementPackage.REQUIREMENT__SUB_REQUIREMENTS, RequirementPackage.REQUIREMENT__PARENT_REQUIREMENT);
		}
		return subRequirements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement getParentRequirement() {
		if (eContainerFeatureID() != RequirementPackage.REQUIREMENT__PARENT_REQUIREMENT)
			return null;
		return (Requirement) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement basicGetParentRequirement() {
		if (eContainerFeatureID() != RequirementPackage.REQUIREMENT__PARENT_REQUIREMENT)
			return null;
		return (Requirement) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentRequirement(Requirement newParentRequirement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentRequirement,
			RequirementPackage.REQUIREMENT__PARENT_REQUIREMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentRequirement(Requirement newParentRequirement) {
		if (newParentRequirement != eInternalContainer()
			|| (eContainerFeatureID() != RequirementPackage.REQUIREMENT__PARENT_REQUIREMENT && newParentRequirement != null)) {
			if (EcoreUtil.isAncestor(this, newParentRequirement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentRequirement != null)
				msgs = ((InternalEObject) newParentRequirement).eInverseAdd(this,
					RequirementPackage.REQUIREMENT__SUB_REQUIREMENTS, Requirement.class, msgs);
			msgs = basicSetParentRequirement(newParentRequirement, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementPackage.REQUIREMENT__PARENT_REQUIREMENT,
				newParentRequirement, newParentRequirement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTerminal() {
		return terminal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTerminal(boolean newTerminal) {
		boolean oldTerminal = terminal;
		terminal = newTerminal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementPackage.REQUIREMENT__TERMINAL,
				oldTerminal, terminal));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getImplementingServices()).basicAdd(otherEnd,
				msgs);
		case RequirementPackage.REQUIREMENT__SUB_REQUIREMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSubRequirements()).basicAdd(otherEnd, msgs);
		case RequirementPackage.REQUIREMENT__PARENT_REQUIREMENT:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentRequirement((Requirement) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES:
			return ((InternalEList<?>) getImplementingServices()).basicRemove(otherEnd, msgs);
		case RequirementPackage.REQUIREMENT__SUB_REQUIREMENTS:
			return ((InternalEList<?>) getSubRequirements()).basicRemove(otherEnd, msgs);
		case RequirementPackage.REQUIREMENT__PARENT_REQUIREMENT:
			return basicSetParentRequirement(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case RequirementPackage.REQUIREMENT__PARENT_REQUIREMENT:
			return eInternalContainer().eInverseRemove(this, RequirementPackage.REQUIREMENT__SUB_REQUIREMENTS,
				Requirement.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES:
			return getImplementingServices();
		case RequirementPackage.REQUIREMENT__SUB_REQUIREMENTS:
			return getSubRequirements();
		case RequirementPackage.REQUIREMENT__PARENT_REQUIREMENT:
			if (resolve)
				return getParentRequirement();
			return basicGetParentRequirement();
		case RequirementPackage.REQUIREMENT__TERMINAL:
			return isTerminal();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES:
			getImplementingServices().clear();
			getImplementingServices().addAll((Collection<? extends Service>) newValue);
			return;
		case RequirementPackage.REQUIREMENT__SUB_REQUIREMENTS:
			getSubRequirements().clear();
			getSubRequirements().addAll((Collection<? extends Requirement>) newValue);
			return;
		case RequirementPackage.REQUIREMENT__PARENT_REQUIREMENT:
			setParentRequirement((Requirement) newValue);
			return;
		case RequirementPackage.REQUIREMENT__TERMINAL:
			setTerminal((Boolean) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES:
			getImplementingServices().clear();
			return;
		case RequirementPackage.REQUIREMENT__SUB_REQUIREMENTS:
			getSubRequirements().clear();
			return;
		case RequirementPackage.REQUIREMENT__PARENT_REQUIREMENT:
			setParentRequirement((Requirement) null);
			return;
		case RequirementPackage.REQUIREMENT__TERMINAL:
			setTerminal(TERMINAL_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES:
			return implementingServices != null && !implementingServices.isEmpty();
		case RequirementPackage.REQUIREMENT__SUB_REQUIREMENTS:
			return subRequirements != null && !subRequirements.isEmpty();
		case RequirementPackage.REQUIREMENT__PARENT_REQUIREMENT:
			return basicGetParentRequirement() != null;
		case RequirementPackage.REQUIREMENT__TERMINAL:
			return terminal != TERMINAL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (terminal: ");
		result.append(terminal);
		result.append(')');
		return result.toString();
	}

} // RequirementImpl
