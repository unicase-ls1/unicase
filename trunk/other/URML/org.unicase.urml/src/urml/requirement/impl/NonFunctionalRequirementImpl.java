/**
 * <copyright> </copyright> $Id$
 */
package urml.requirement.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import urml.feature.AbstractFeature;
import urml.feature.FeaturePackage;
import urml.requirement.NonFunctionalRequirement;
import urml.requirement.RequirementPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Non Functional Requirement</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link urml.requirement.impl.NonFunctionalRequirementImpl#getConstrainedFeatures <em>Constrained Features</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class NonFunctionalRequirementImpl extends RequirementImpl implements NonFunctionalRequirement {
	/**
	 * The cached value of the '{@link #getConstrainedFeatures() <em>Constrained Features</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConstrainedFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFeature> constrainedFeatures;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected NonFunctionalRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementPackage.Literals.NON_FUNCTIONAL_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AbstractFeature> getConstrainedFeatures() {
		if (constrainedFeatures == null) {
			constrainedFeatures = new EObjectWithInverseResolvingEList.ManyInverse<AbstractFeature>(
				AbstractFeature.class, this, RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FEATURES,
				FeaturePackage.ABSTRACT_FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS);
		}
		return constrainedFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FEATURES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getConstrainedFeatures()).basicAdd(otherEnd,
				msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FEATURES:
			return ((InternalEList<?>) getConstrainedFeatures()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FEATURES:
			return getConstrainedFeatures();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FEATURES:
			getConstrainedFeatures().clear();
			getConstrainedFeatures().addAll((Collection<? extends AbstractFeature>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FEATURES:
			getConstrainedFeatures().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FEATURES:
			return constrainedFeatures != null && !constrainedFeatures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // NonFunctionalRequirementImpl
