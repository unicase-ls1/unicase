/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge.impl;

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

import scrm.knowledge.Assumption;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.MathematicalModel;
import scrm.knowledge.NumericalMethod;

import scrm.requirements.IRequirement;
import scrm.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assumption</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.knowledge.impl.AssumptionImpl#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link scrm.knowledge.impl.AssumptionImpl#getDependingModel <em>Depending Model</em>}</li>
 *   <li>{@link scrm.knowledge.impl.AssumptionImpl#getDependingMethod <em>Depending Method</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssumptionImpl extends EObjectImpl implements Assumption {
	/**
	 * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<IRequirement> requirements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssumptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KnowledgePackage.Literals.ASSUMPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IRequirement> getRequirements() {
		if (requirements == null) {
			requirements = new EObjectWithInverseResolvingEList.ManyInverse<IRequirement>(IRequirement.class, this, KnowledgePackage.ASSUMPTION__REQUIREMENTS, RequirementsPackage.IREQUIREMENT__USED_KNOWLEDGE);
		}
		return requirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MathematicalModel getDependingModel() {
		if (eContainerFeatureID() != KnowledgePackage.ASSUMPTION__DEPENDING_MODEL) return null;
		return (MathematicalModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependingModel(MathematicalModel newDependingModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDependingModel, KnowledgePackage.ASSUMPTION__DEPENDING_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependingModel(MathematicalModel newDependingModel) {
		if (newDependingModel != eInternalContainer() || (eContainerFeatureID() != KnowledgePackage.ASSUMPTION__DEPENDING_MODEL && newDependingModel != null)) {
			if (EcoreUtil.isAncestor(this, newDependingModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDependingModel != null)
				msgs = ((InternalEObject)newDependingModel).eInverseAdd(this, KnowledgePackage.MATHEMATICAL_MODEL__DEPENDENCIES, MathematicalModel.class, msgs);
			msgs = basicSetDependingModel(newDependingModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KnowledgePackage.ASSUMPTION__DEPENDING_MODEL, newDependingModel, newDependingModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericalMethod getDependingMethod() {
		if (eContainerFeatureID() != KnowledgePackage.ASSUMPTION__DEPENDING_METHOD) return null;
		return (NumericalMethod)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependingMethod(NumericalMethod newDependingMethod, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDependingMethod, KnowledgePackage.ASSUMPTION__DEPENDING_METHOD, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependingMethod(NumericalMethod newDependingMethod) {
		if (newDependingMethod != eInternalContainer() || (eContainerFeatureID() != KnowledgePackage.ASSUMPTION__DEPENDING_METHOD && newDependingMethod != null)) {
			if (EcoreUtil.isAncestor(this, newDependingMethod))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDependingMethod != null)
				msgs = ((InternalEObject)newDependingMethod).eInverseAdd(this, KnowledgePackage.NUMERICAL_METHOD__DEPENDENCIES, NumericalMethod.class, msgs);
			msgs = basicSetDependingMethod(newDependingMethod, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KnowledgePackage.ASSUMPTION__DEPENDING_METHOD, newDependingMethod, newDependingMethod));
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
			case KnowledgePackage.ASSUMPTION__REQUIREMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequirements()).basicAdd(otherEnd, msgs);
			case KnowledgePackage.ASSUMPTION__DEPENDING_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDependingModel((MathematicalModel)otherEnd, msgs);
			case KnowledgePackage.ASSUMPTION__DEPENDING_METHOD:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDependingMethod((NumericalMethod)otherEnd, msgs);
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
			case KnowledgePackage.ASSUMPTION__REQUIREMENTS:
				return ((InternalEList<?>)getRequirements()).basicRemove(otherEnd, msgs);
			case KnowledgePackage.ASSUMPTION__DEPENDING_MODEL:
				return basicSetDependingModel(null, msgs);
			case KnowledgePackage.ASSUMPTION__DEPENDING_METHOD:
				return basicSetDependingMethod(null, msgs);
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
			case KnowledgePackage.ASSUMPTION__DEPENDING_MODEL:
				return eInternalContainer().eInverseRemove(this, KnowledgePackage.MATHEMATICAL_MODEL__DEPENDENCIES, MathematicalModel.class, msgs);
			case KnowledgePackage.ASSUMPTION__DEPENDING_METHOD:
				return eInternalContainer().eInverseRemove(this, KnowledgePackage.NUMERICAL_METHOD__DEPENDENCIES, NumericalMethod.class, msgs);
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
			case KnowledgePackage.ASSUMPTION__REQUIREMENTS:
				return getRequirements();
			case KnowledgePackage.ASSUMPTION__DEPENDING_MODEL:
				return getDependingModel();
			case KnowledgePackage.ASSUMPTION__DEPENDING_METHOD:
				return getDependingMethod();
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
			case KnowledgePackage.ASSUMPTION__REQUIREMENTS:
				getRequirements().clear();
				getRequirements().addAll((Collection<? extends IRequirement>)newValue);
				return;
			case KnowledgePackage.ASSUMPTION__DEPENDING_MODEL:
				setDependingModel((MathematicalModel)newValue);
				return;
			case KnowledgePackage.ASSUMPTION__DEPENDING_METHOD:
				setDependingMethod((NumericalMethod)newValue);
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
			case KnowledgePackage.ASSUMPTION__REQUIREMENTS:
				getRequirements().clear();
				return;
			case KnowledgePackage.ASSUMPTION__DEPENDING_MODEL:
				setDependingModel((MathematicalModel)null);
				return;
			case KnowledgePackage.ASSUMPTION__DEPENDING_METHOD:
				setDependingMethod((NumericalMethod)null);
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
			case KnowledgePackage.ASSUMPTION__REQUIREMENTS:
				return requirements != null && !requirements.isEmpty();
			case KnowledgePackage.ASSUMPTION__DEPENDING_MODEL:
				return getDependingModel() != null;
			case KnowledgePackage.ASSUMPTION__DEPENDING_METHOD:
				return getDependingMethod() != null;
		}
		return super.eIsSet(featureID);
	}

} //AssumptionImpl
