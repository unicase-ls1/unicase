/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.model.requirement.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.impl.ModelElementImpl;
import org.unicase.model.requirement.Feature;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.UseCase;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Feature</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.requirement.impl.FeatureImpl#getDescribingUseCases <em>Describing Use Cases</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.FeatureImpl#getRefiningFeatures <em>Refining Features</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.FeatureImpl#getDetailingRequirements <em>Detailing Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureImpl extends ModelElementImpl implements Feature {
	/**
	 * The cached value of the '{@link #getDescribingUseCases() <em>Describing Use Cases</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescribingUseCases()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> describingUseCases;

	/**
	 * The cached value of the '{@link #getRefiningFeatures() <em>Refining Features</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRefiningFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> refiningFeatures;

	/**
	 * The cached value of the '{@link #getDetailingRequirements() <em>Detailing Requirements</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDetailingRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionalRequirement> detailingRequirements;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementPackage.Literals.FEATURE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCase> getDescribingUseCases() {
		if (describingUseCases == null) {
			describingUseCases = new EObjectWithInverseResolvingEList.ManyInverse<UseCase>(UseCase.class, this,
				RequirementPackage.FEATURE__DESCRIBING_USE_CASES, RequirementPackage.USE_CASE__DESCRIBED_FEATURES);
		}
		return describingUseCases;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getRefiningFeatures() {
		if (refiningFeatures == null) {
			refiningFeatures = new EObjectContainmentEList.Resolving<Feature>(Feature.class, this,
				RequirementPackage.FEATURE__REFINING_FEATURES);
		}
		return refiningFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionalRequirement> getDetailingRequirements() {
		if (detailingRequirements == null) {
			detailingRequirements = new EObjectWithInverseResolvingEList.ManyInverse<FunctionalRequirement>(
				FunctionalRequirement.class, this, RequirementPackage.FEATURE__DETAILING_REQUIREMENTS,
				RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES);
		}
		return detailingRequirements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementPackage.FEATURE__DESCRIBING_USE_CASES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDescribingUseCases()).basicAdd(otherEnd,
				msgs);
		case RequirementPackage.FEATURE__DETAILING_REQUIREMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDetailingRequirements()).basicAdd(otherEnd,
				msgs);
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
		case RequirementPackage.FEATURE__DESCRIBING_USE_CASES:
			return ((InternalEList<?>) getDescribingUseCases()).basicRemove(otherEnd, msgs);
		case RequirementPackage.FEATURE__REFINING_FEATURES:
			return ((InternalEList<?>) getRefiningFeatures()).basicRemove(otherEnd, msgs);
		case RequirementPackage.FEATURE__DETAILING_REQUIREMENTS:
			return ((InternalEList<?>) getDetailingRequirements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RequirementPackage.FEATURE__DESCRIBING_USE_CASES:
			return getDescribingUseCases();
		case RequirementPackage.FEATURE__REFINING_FEATURES:
			return getRefiningFeatures();
		case RequirementPackage.FEATURE__DETAILING_REQUIREMENTS:
			return getDetailingRequirements();
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
		case RequirementPackage.FEATURE__DESCRIBING_USE_CASES:
			getDescribingUseCases().clear();
			getDescribingUseCases().addAll((Collection<? extends UseCase>) newValue);
			return;
		case RequirementPackage.FEATURE__REFINING_FEATURES:
			getRefiningFeatures().clear();
			getRefiningFeatures().addAll((Collection<? extends Feature>) newValue);
			return;
		case RequirementPackage.FEATURE__DETAILING_REQUIREMENTS:
			getDetailingRequirements().clear();
			getDetailingRequirements().addAll((Collection<? extends FunctionalRequirement>) newValue);
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
		case RequirementPackage.FEATURE__DESCRIBING_USE_CASES:
			getDescribingUseCases().clear();
			return;
		case RequirementPackage.FEATURE__REFINING_FEATURES:
			getRefiningFeatures().clear();
			return;
		case RequirementPackage.FEATURE__DETAILING_REQUIREMENTS:
			getDetailingRequirements().clear();
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
		case RequirementPackage.FEATURE__DESCRIBING_USE_CASES:
			return describingUseCases != null && !describingUseCases.isEmpty();
		case RequirementPackage.FEATURE__REFINING_FEATURES:
			return refiningFeatures != null && !refiningFeatures.isEmpty();
		case RequirementPackage.FEATURE__DETAILING_REQUIREMENTS:
			return detailingRequirements != null && !detailingRequirements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // FeatureImpl
