/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.usecase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.model.usecase.ActorStep;
import org.unicase.model.usecase.SystemStep;
import org.unicase.model.usecase.UseCase;
import org.unicase.model.usecase.UsecasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.usecase.impl.UseCaseImpl#getActorSteps <em>Actor Steps</em>}</li>
 *   <li>{@link org.unicase.model.usecase.impl.UseCaseImpl#getSystemSteps <em>System Steps</em>}</li>
 *   <li>{@link org.unicase.model.usecase.impl.UseCaseImpl#getPrecon <em>Precon</em>}</li>
 *   <li>{@link org.unicase.model.usecase.impl.UseCaseImpl#getPostcon <em>Postcon</em>}</li>
 *   <li>{@link org.unicase.model.usecase.impl.UseCaseImpl#getRul <em>Rul</em>}</li>
 *   <li>{@link org.unicase.model.usecase.impl.UseCaseImpl#getExc <em>Exc</em>}</li>
 *   <li>{@link org.unicase.model.usecase.impl.UseCaseImpl#getSync <em>Sync</em>}</li>
 *   <li>{@link org.unicase.model.usecase.impl.UseCaseImpl#getUseCases <em>Use Cases</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UseCaseImpl extends org.unicase.model.requirement.impl.UseCaseImpl implements UseCase {
	/**
	 * The cached value of the '{@link #getActorSteps() <em>Actor Steps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActorSteps()
	 * @generated
	 * @ordered
	 */
	protected EList<ActorStep> actorSteps;

	/**
	 * The cached value of the '{@link #getSystemSteps() <em>System Steps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemSteps()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemStep> systemSteps;

	/**
	 * The default value of the '{@link #getPrecon() <em>Precon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecon()
	 * @generated
	 * @ordered
	 */
	protected static final String PRECON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrecon() <em>Precon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecon()
	 * @generated
	 * @ordered
	 */
	protected String precon = PRECON_EDEFAULT;

	/**
	 * The default value of the '{@link #getPostcon() <em>Postcon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostcon()
	 * @generated
	 * @ordered
	 */
	protected static final String POSTCON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPostcon() <em>Postcon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostcon()
	 * @generated
	 * @ordered
	 */
	protected String postcon = POSTCON_EDEFAULT;

	/**
	 * The default value of the '{@link #getRul() <em>Rul</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRul()
	 * @generated
	 * @ordered
	 */
	protected static final String RUL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRul() <em>Rul</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRul()
	 * @generated
	 * @ordered
	 */
	protected String rul = RUL_EDEFAULT;

	/**
	 * The default value of the '{@link #getExc() <em>Exc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExc()
	 * @generated
	 * @ordered
	 */
	protected static final String EXC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExc() <em>Exc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExc()
	 * @generated
	 * @ordered
	 */
	protected String exc = EXC_EDEFAULT;

	/**
	 * The default value of the '{@link #getSync() <em>Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSync()
	 * @generated
	 * @ordered
	 */
	protected static final String SYNC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSync() <em>Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSync()
	 * @generated
	 * @ordered
	 */
	protected String sync = SYNC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUseCases() <em>Use Cases</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseCases()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> useCases;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsecasePackage.Literals.USE_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActorStep> getActorSteps() {
		if (actorSteps == null) {
			actorSteps = new EObjectContainmentWithInverseEList.Resolving<ActorStep>(ActorStep.class, this, UsecasePackage.USE_CASE__ACTOR_STEPS, UsecasePackage.ACTOR_STEP__USE_CASE);
		}
		return actorSteps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemStep> getSystemSteps() {
		if (systemSteps == null) {
			systemSteps = new EObjectContainmentWithInverseEList.Resolving<SystemStep>(SystemStep.class, this, UsecasePackage.USE_CASE__SYSTEM_STEPS, UsecasePackage.SYSTEM_STEP__USE_CASE);
		}
		return systemSteps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrecon() {
		return precon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrecon(String newPrecon) {
		String oldPrecon = precon;
		precon = newPrecon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE__PRECON, oldPrecon, precon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPostcon() {
		return postcon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostcon(String newPostcon) {
		String oldPostcon = postcon;
		postcon = newPostcon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE__POSTCON, oldPostcon, postcon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRul() {
		return rul;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRul(String newRul) {
		String oldRul = rul;
		rul = newRul;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE__RUL, oldRul, rul));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExc() {
		return exc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExc(String newExc) {
		String oldExc = exc;
		exc = newExc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE__EXC, oldExc, exc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSync() {
		return sync;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSync(String newSync) {
		String oldSync = sync;
		sync = newSync;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE__SYNC, oldSync, sync));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCase> getUseCases() {
		if (useCases == null) {
			useCases = new EObjectResolvingEList<UseCase>(UseCase.class, this, UsecasePackage.USE_CASE__USE_CASES);
		}
		return useCases;
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
			case UsecasePackage.USE_CASE__ACTOR_STEPS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getActorSteps()).basicAdd(otherEnd, msgs);
			case UsecasePackage.USE_CASE__SYSTEM_STEPS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSystemSteps()).basicAdd(otherEnd, msgs);
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
			case UsecasePackage.USE_CASE__ACTOR_STEPS:
				return ((InternalEList<?>)getActorSteps()).basicRemove(otherEnd, msgs);
			case UsecasePackage.USE_CASE__SYSTEM_STEPS:
				return ((InternalEList<?>)getSystemSteps()).basicRemove(otherEnd, msgs);
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
			case UsecasePackage.USE_CASE__ACTOR_STEPS:
				return getActorSteps();
			case UsecasePackage.USE_CASE__SYSTEM_STEPS:
				return getSystemSteps();
			case UsecasePackage.USE_CASE__PRECON:
				return getPrecon();
			case UsecasePackage.USE_CASE__POSTCON:
				return getPostcon();
			case UsecasePackage.USE_CASE__RUL:
				return getRul();
			case UsecasePackage.USE_CASE__EXC:
				return getExc();
			case UsecasePackage.USE_CASE__SYNC:
				return getSync();
			case UsecasePackage.USE_CASE__USE_CASES:
				return getUseCases();
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
			case UsecasePackage.USE_CASE__ACTOR_STEPS:
				getActorSteps().clear();
				getActorSteps().addAll((Collection<? extends ActorStep>)newValue);
				return;
			case UsecasePackage.USE_CASE__SYSTEM_STEPS:
				getSystemSteps().clear();
				getSystemSteps().addAll((Collection<? extends SystemStep>)newValue);
				return;
			case UsecasePackage.USE_CASE__PRECON:
				setPrecon((String)newValue);
				return;
			case UsecasePackage.USE_CASE__POSTCON:
				setPostcon((String)newValue);
				return;
			case UsecasePackage.USE_CASE__RUL:
				setRul((String)newValue);
				return;
			case UsecasePackage.USE_CASE__EXC:
				setExc((String)newValue);
				return;
			case UsecasePackage.USE_CASE__SYNC:
				setSync((String)newValue);
				return;
			case UsecasePackage.USE_CASE__USE_CASES:
				getUseCases().clear();
				getUseCases().addAll((Collection<? extends UseCase>)newValue);
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
			case UsecasePackage.USE_CASE__ACTOR_STEPS:
				getActorSteps().clear();
				return;
			case UsecasePackage.USE_CASE__SYSTEM_STEPS:
				getSystemSteps().clear();
				return;
			case UsecasePackage.USE_CASE__PRECON:
				setPrecon(PRECON_EDEFAULT);
				return;
			case UsecasePackage.USE_CASE__POSTCON:
				setPostcon(POSTCON_EDEFAULT);
				return;
			case UsecasePackage.USE_CASE__RUL:
				setRul(RUL_EDEFAULT);
				return;
			case UsecasePackage.USE_CASE__EXC:
				setExc(EXC_EDEFAULT);
				return;
			case UsecasePackage.USE_CASE__SYNC:
				setSync(SYNC_EDEFAULT);
				return;
			case UsecasePackage.USE_CASE__USE_CASES:
				getUseCases().clear();
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
			case UsecasePackage.USE_CASE__ACTOR_STEPS:
				return actorSteps != null && !actorSteps.isEmpty();
			case UsecasePackage.USE_CASE__SYSTEM_STEPS:
				return systemSteps != null && !systemSteps.isEmpty();
			case UsecasePackage.USE_CASE__PRECON:
				return PRECON_EDEFAULT == null ? precon != null : !PRECON_EDEFAULT.equals(precon);
			case UsecasePackage.USE_CASE__POSTCON:
				return POSTCON_EDEFAULT == null ? postcon != null : !POSTCON_EDEFAULT.equals(postcon);
			case UsecasePackage.USE_CASE__RUL:
				return RUL_EDEFAULT == null ? rul != null : !RUL_EDEFAULT.equals(rul);
			case UsecasePackage.USE_CASE__EXC:
				return EXC_EDEFAULT == null ? exc != null : !EXC_EDEFAULT.equals(exc);
			case UsecasePackage.USE_CASE__SYNC:
				return SYNC_EDEFAULT == null ? sync != null : !SYNC_EDEFAULT.equals(sync);
			case UsecasePackage.USE_CASE__USE_CASES:
				return useCases != null && !useCases.isEmpty();
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (precon: ");
		result.append(precon);
		result.append(", postcon: ");
		result.append(postcon);
		result.append(", rul: ");
		result.append(rul);
		result.append(", exc: ");
		result.append(exc);
		result.append(", sync: ");
		result.append(sync);
		result.append(')');
		return result.toString();
	}

} //UseCaseImpl
