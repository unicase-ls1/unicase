/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package bowling.impl;

import bowling.BowlingPackage;
import bowling.Player;
import bowling.Playerlist;
import bowling.Tournament;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Playerlist</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bowling.impl.PlayerlistImpl#getName <em>Name</em>}</li>
 *   <li>{@link bowling.impl.PlayerlistImpl#getPlayer <em>Player</em>}</li>
 *   <li>{@link bowling.impl.PlayerlistImpl#getTournament <em>Tournament</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlayerlistImpl extends EObjectImpl implements Playerlist {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPlayer() <em>Player</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayer()
	 * @generated
	 * @ordered
	 */
	protected EList<Player> player;

	/**
	 * The cached value of the '{@link #getTournament() <em>Tournament</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTournament()
	 * @generated
	 * @ordered
	 */
	protected Tournament tournament;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlayerlistImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BowlingPackage.Literals.PLAYERLIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYERLIST__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Player> getPlayer() {
		if (player == null) {
			player = new EObjectContainmentWithInverseEList<Player>(Player.class, this, BowlingPackage.PLAYERLIST__PLAYER, BowlingPackage.PLAYER__PLAYERLIST);
		}
		return player;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tournament getTournament() {
		if (tournament != null && tournament.eIsProxy()) {
			InternalEObject oldTournament = (InternalEObject)tournament;
			tournament = (Tournament)eResolveProxy(oldTournament);
			if (tournament != oldTournament) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BowlingPackage.PLAYERLIST__TOURNAMENT, oldTournament, tournament));
			}
		}
		return tournament;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tournament basicGetTournament() {
		return tournament;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTournament(Tournament newTournament, NotificationChain msgs) {
		Tournament oldTournament = tournament;
		tournament = newTournament;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYERLIST__TOURNAMENT, oldTournament, newTournament);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTournament(Tournament newTournament) {
		if (newTournament != tournament) {
			NotificationChain msgs = null;
			if (tournament != null)
				msgs = ((InternalEObject)tournament).eInverseRemove(this, BowlingPackage.TOURNAMENT__PLAYERLIST, Tournament.class, msgs);
			if (newTournament != null)
				msgs = ((InternalEObject)newTournament).eInverseAdd(this, BowlingPackage.TOURNAMENT__PLAYERLIST, Tournament.class, msgs);
			msgs = basicSetTournament(newTournament, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYERLIST__TOURNAMENT, newTournament, newTournament));
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
			case BowlingPackage.PLAYERLIST__PLAYER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPlayer()).basicAdd(otherEnd, msgs);
			case BowlingPackage.PLAYERLIST__TOURNAMENT:
				if (tournament != null)
					msgs = ((InternalEObject)tournament).eInverseRemove(this, BowlingPackage.TOURNAMENT__PLAYERLIST, Tournament.class, msgs);
				return basicSetTournament((Tournament)otherEnd, msgs);
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
			case BowlingPackage.PLAYERLIST__PLAYER:
				return ((InternalEList<?>)getPlayer()).basicRemove(otherEnd, msgs);
			case BowlingPackage.PLAYERLIST__TOURNAMENT:
				return basicSetTournament(null, msgs);
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
			case BowlingPackage.PLAYERLIST__NAME:
				return getName();
			case BowlingPackage.PLAYERLIST__PLAYER:
				return getPlayer();
			case BowlingPackage.PLAYERLIST__TOURNAMENT:
				if (resolve) return getTournament();
				return basicGetTournament();
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
			case BowlingPackage.PLAYERLIST__NAME:
				setName((String)newValue);
				return;
			case BowlingPackage.PLAYERLIST__PLAYER:
				getPlayer().clear();
				getPlayer().addAll((Collection<? extends Player>)newValue);
				return;
			case BowlingPackage.PLAYERLIST__TOURNAMENT:
				setTournament((Tournament)newValue);
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
			case BowlingPackage.PLAYERLIST__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BowlingPackage.PLAYERLIST__PLAYER:
				getPlayer().clear();
				return;
			case BowlingPackage.PLAYERLIST__TOURNAMENT:
				setTournament((Tournament)null);
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
			case BowlingPackage.PLAYERLIST__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BowlingPackage.PLAYERLIST__PLAYER:
				return player != null && !player.isEmpty();
			case BowlingPackage.PLAYERLIST__TOURNAMENT:
				return tournament != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //PlayerlistImpl
