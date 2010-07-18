/**
 * <copyright> </copyright> $Id$
 */
package urml.usecase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.requirement.Step;
import org.unicase.model.urml.impl.UrmlModelElementImpl;

import urml.usecase.Actor;
import urml.usecase.UseCase;
import urml.usecase.UsecasePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Use Case</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link urml.usecase.impl.UseCaseImpl#getSteps <em>Steps</em>}</li>
 * <li>{@link urml.usecase.impl.UseCaseImpl#getActors <em>Actors</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class UseCaseImpl extends UrmlModelElementImpl implements UseCase {
	/**
	 * The cached value of the '{@link #getSteps() <em>Steps</em>}' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSteps()
	 * @generated
	 * @ordered
	 */
	protected EList<Step> steps;

	/**
	 * The cached value of the '{@link #getActors() <em>Actors</em>}' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getActors()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> actors;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected UseCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsecasePackage.Literals.USE_CASE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Step> getSteps() {
		if (steps == null) {
			steps = new EObjectContainmentEList.Resolving<Step>(Step.class, this, UsecasePackage.USE_CASE__STEPS);
		}
		return steps;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Actor> getActors() {
		if (actors == null) {
			actors = new EObjectWithInverseResolvingEList.ManyInverse<Actor>(Actor.class, this,
				UsecasePackage.USE_CASE__ACTORS, UsecasePackage.ACTOR__USE_CASES);
		}
		return actors;
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
		case UsecasePackage.USE_CASE__ACTORS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getActors()).basicAdd(otherEnd, msgs);
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
		case UsecasePackage.USE_CASE__STEPS:
			return ((InternalEList<?>) getSteps()).basicRemove(otherEnd, msgs);
		case UsecasePackage.USE_CASE__ACTORS:
			return ((InternalEList<?>) getActors()).basicRemove(otherEnd, msgs);
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
		case UsecasePackage.USE_CASE__STEPS:
			return getSteps();
		case UsecasePackage.USE_CASE__ACTORS:
			return getActors();
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
		case UsecasePackage.USE_CASE__STEPS:
			getSteps().clear();
			getSteps().addAll((Collection<? extends Step>) newValue);
			return;
		case UsecasePackage.USE_CASE__ACTORS:
			getActors().clear();
			getActors().addAll((Collection<? extends Actor>) newValue);
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
		case UsecasePackage.USE_CASE__STEPS:
			getSteps().clear();
			return;
		case UsecasePackage.USE_CASE__ACTORS:
			getActors().clear();
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
		case UsecasePackage.USE_CASE__STEPS:
			return steps != null && !steps.isEmpty();
		case UsecasePackage.USE_CASE__ACTORS:
			return actors != null && !actors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // UseCaseImpl
