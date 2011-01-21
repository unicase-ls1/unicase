/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package bowling.impl;

import bowling.BowlingPackage;
import bowling.Game;
import bowling.Matchup;
import bowling.Player;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Game</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bowling.impl.GameImpl#getDate <em>Date</em>}</li>
 *   <li>{@link bowling.impl.GameImpl#getFrames <em>Frames</em>}</li>
 *   <li>{@link bowling.impl.GameImpl#getSum <em>Sum</em>}</li>
 *   <li>{@link bowling.impl.GameImpl#getPlayer <em>Player</em>}</li>
 *   <li>{@link bowling.impl.GameImpl#getMatchup <em>Matchup</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GameImpl extends EObjectImpl implements Game {
	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFrames() <em>Frames</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrames()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> frames;

	/**
	 * The default value of the '{@link #getSum() <em>Sum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSum()
	 * @generated
	 * @ordered
	 */
	protected static final int SUM_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSum() <em>Sum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSum()
	 * @generated
	 * @ordered
	 */
	protected int sum = SUM_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPlayer() <em>Player</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayer()
	 * @generated
	 * @ordered
	 */
	protected Player player;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GameImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BowlingPackage.Literals.GAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.GAME__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getFrames() {
		if (frames == null) {
			frames = new EDataTypeUniqueEList<Integer>(Integer.class, this, BowlingPackage.GAME__FRAMES);
		}
		return frames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getSum() {
		int result = 0;
		for (int i : getFrames()) {
			result += i;
		}
		//sum = result;
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Player getPlayer() {
		if (player != null && player.eIsProxy()) {
			InternalEObject oldPlayer = (InternalEObject)player;
			player = (Player)eResolveProxy(oldPlayer);
			if (player != oldPlayer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BowlingPackage.GAME__PLAYER, oldPlayer, player));
			}
		}
		return player;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Player basicGetPlayer() {
		return player;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlayer(Player newPlayer, NotificationChain msgs) {
		Player oldPlayer = player;
		player = newPlayer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BowlingPackage.GAME__PLAYER, oldPlayer, newPlayer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlayer(Player newPlayer) {
		if (newPlayer != player) {
			NotificationChain msgs = null;
			if (player != null)
				msgs = ((InternalEObject)player).eInverseRemove(this, BowlingPackage.PLAYER__GAMES, Player.class, msgs);
			if (newPlayer != null)
				msgs = ((InternalEObject)newPlayer).eInverseAdd(this, BowlingPackage.PLAYER__GAMES, Player.class, msgs);
			msgs = basicSetPlayer(newPlayer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.GAME__PLAYER, newPlayer, newPlayer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Matchup getMatchup() {
		if (eContainerFeatureID() != BowlingPackage.GAME__MATCHUP) return null;
		return (Matchup)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatchup(Matchup newMatchup, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMatchup, BowlingPackage.GAME__MATCHUP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatchup(Matchup newMatchup) {
		if (newMatchup != eInternalContainer() || (eContainerFeatureID() != BowlingPackage.GAME__MATCHUP && newMatchup != null)) {
			if (EcoreUtil.isAncestor(this, newMatchup))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMatchup != null)
				msgs = ((InternalEObject)newMatchup).eInverseAdd(this, BowlingPackage.MATCHUP__GAMES, Matchup.class, msgs);
			msgs = basicSetMatchup(newMatchup, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.GAME__MATCHUP, newMatchup, newMatchup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BowlingPackage.GAME__PLAYER:
				if (player != null)
					msgs = ((InternalEObject)player).eInverseRemove(this, BowlingPackage.PLAYER__GAMES, Player.class, msgs);
				return basicSetPlayer((Player)otherEnd, msgs);
			case BowlingPackage.GAME__MATCHUP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMatchup((Matchup)otherEnd, msgs);
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
			case BowlingPackage.GAME__PLAYER:
				return basicSetPlayer(null, msgs);
			case BowlingPackage.GAME__MATCHUP:
				return basicSetMatchup(null, msgs);
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
			case BowlingPackage.GAME__MATCHUP:
				return eInternalContainer().eInverseRemove(this, BowlingPackage.MATCHUP__GAMES, Matchup.class, msgs);
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
			case BowlingPackage.GAME__DATE:
				return getDate();
			case BowlingPackage.GAME__FRAMES:
				return getFrames();
			case BowlingPackage.GAME__SUM:
				return getSum();
			case BowlingPackage.GAME__PLAYER:
				if (resolve) return getPlayer();
				return basicGetPlayer();
			case BowlingPackage.GAME__MATCHUP:
				return getMatchup();
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
			case BowlingPackage.GAME__DATE:
				setDate((Date)newValue);
				return;
			case BowlingPackage.GAME__FRAMES:
				getFrames().clear();
				getFrames().addAll((Collection<? extends Integer>)newValue);
				return;
			case BowlingPackage.GAME__PLAYER:
				setPlayer((Player)newValue);
				return;
			case BowlingPackage.GAME__MATCHUP:
				setMatchup((Matchup)newValue);
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
			case BowlingPackage.GAME__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case BowlingPackage.GAME__FRAMES:
				getFrames().clear();
				return;
			case BowlingPackage.GAME__PLAYER:
				setPlayer((Player)null);
				return;
			case BowlingPackage.GAME__MATCHUP:
				setMatchup((Matchup)null);
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
			case BowlingPackage.GAME__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case BowlingPackage.GAME__FRAMES:
				return frames != null && !frames.isEmpty();
			case BowlingPackage.GAME__SUM:
				return sum != SUM_EDEFAULT;
			case BowlingPackage.GAME__PLAYER:
				return player != null;
			case BowlingPackage.GAME__MATCHUP:
				return getMatchup() != null;
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
		result.append(" (date: ");
		result.append(date);
		result.append(", frames: ");
		result.append(frames);
		result.append(", sum: ");
		result.append(sum);
		result.append(')');
		return result.toString();
	}

} //GameImpl
