/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.usecase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.urml.danger.impl.AssetImpl;
import org.unicase.model.urml.usecase.Actor;
import org.unicase.model.urml.usecase.UseCase;
import org.unicase.model.urml.usecase.UsecasePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Actor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.urml.usecase.impl.ActorImpl#getUseCases <em>Use Cases</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActorImpl extends AssetImpl implements Actor {
	/**
	 * The cached value of the '{@link #getUseCases() <em>Use Cases</em>}' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getUseCases()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> useCases;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsecasePackage.Literals.ACTOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCase> getUseCases() {
		if (useCases == null) {
			useCases = new EObjectWithInverseResolvingEList.ManyInverse<UseCase>(
					UseCase.class, this, UsecasePackage.ACTOR__USE_CASES,
					UsecasePackage.USE_CASE__ACTORS);
		}
		return useCases;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case UsecasePackage.ACTOR__USE_CASES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getUseCases())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case UsecasePackage.ACTOR__USE_CASES:
			return ((InternalEList<?>) getUseCases()).basicRemove(otherEnd,
					msgs);
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
		case UsecasePackage.ACTOR__USE_CASES:
			return getUseCases();
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
		case UsecasePackage.ACTOR__USE_CASES:
			getUseCases().clear();
			getUseCases().addAll((Collection<? extends UseCase>) newValue);
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
		case UsecasePackage.ACTOR__USE_CASES:
			getUseCases().clear();
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
		case UsecasePackage.ACTOR__USE_CASES:
			return useCases != null && !useCases.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String getDescriptionPlainText() {
		// TODO Auto-generated method stub
		return getDescription();
	}

} // ActorImpl
