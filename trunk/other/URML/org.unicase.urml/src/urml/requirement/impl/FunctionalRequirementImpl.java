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
import urml.requirement.FunctionalRequirement;
import urml.requirement.RequirementPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Functional Requirement</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link urml.requirement.impl.FunctionalRequirementImpl#getDetailedFeatures <em>Detailed Features</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class FunctionalRequirementImpl extends RequirementImpl implements FunctionalRequirement {
	/**
	 * The cached value of the '{@link #getDetailedFeatures() <em>Detailed Features</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDetailedFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFeature> detailedFeatures;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FunctionalRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementPackage.Literals.FUNCTIONAL_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AbstractFeature> getDetailedFeatures() {
		if (detailedFeatures == null) {
			detailedFeatures = new EObjectWithInverseResolvingEList.ManyInverse<AbstractFeature>(AbstractFeature.class,
				this, RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES,
				FeaturePackage.ABSTRACT_FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS);
		}
		return detailedFeatures;
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDetailedFeatures()).basicAdd(otherEnd, msgs);
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES:
			return ((InternalEList<?>) getDetailedFeatures()).basicRemove(otherEnd, msgs);
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES:
			return getDetailedFeatures();
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES:
			getDetailedFeatures().clear();
			getDetailedFeatures().addAll((Collection<? extends AbstractFeature>) newValue);
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES:
			getDetailedFeatures().clear();
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES:
			return detailedFeatures != null && !detailedFeatures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // FunctionalRequirementImpl
