/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package bowling.impl;

import bowling.BowlingPackage;
import bowling.Matchup;
import bowling.Playerlist;
import bowling.Tournament;
import bowling.TournamentType;

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
 * An implementation of the model object '<em><b>Tournament</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bowling.impl.TournamentImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link bowling.impl.TournamentImpl#getType <em>Type</em>}</li>
 *   <li>{@link bowling.impl.TournamentImpl#getMatchups <em>Matchups</em>}</li>
 *   <li>{@link bowling.impl.TournamentImpl#getPlayerlist <em>Playerlist</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TournamentImpl extends EObjectImpl implements Tournament {
	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final TournamentType TYPE_EDEFAULT = TournamentType.AMATEUR;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TournamentType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMatchups() <em>Matchups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatchups()
	 * @generated
	 * @ordered
	 */
	protected EList<Matchup> matchups;

	/**
	 * The cached value of the '{@link #getPlayerlist() <em>Playerlist</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayerlist()
	 * @generated
	 * @ordered
	 */
	protected Playerlist playerlist;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TournamentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BowlingPackage.Literals.TOURNAMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.TOURNAMENT__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TournamentType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TournamentType newType) {
		TournamentType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.TOURNAMENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Matchup> getMatchups() {
		if (matchups == null) {
			matchups = new EObjectContainmentWithInverseEList<Matchup>(Matchup.class, this, BowlingPackage.TOURNAMENT__MATCHUPS, BowlingPackage.MATCHUP__TOURNAMENT);
		}
		return matchups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Playerlist getPlayerlist() {
		if (playerlist != null && playerlist.eIsProxy()) {
			InternalEObject oldPlayerlist = (InternalEObject)playerlist;
			playerlist = (Playerlist)eResolveProxy(oldPlayerlist);
			if (playerlist != oldPlayerlist) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BowlingPackage.TOURNAMENT__PLAYERLIST, oldPlayerlist, playerlist));
			}
		}
		return playerlist;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Playerlist basicGetPlayerlist() {
		return playerlist;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlayerlist(Playerlist newPlayerlist, NotificationChain msgs) {
		Playerlist oldPlayerlist = playerlist;
		playerlist = newPlayerlist;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BowlingPackage.TOURNAMENT__PLAYERLIST, oldPlayerlist, newPlayerlist);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlayerlist(Playerlist newPlayerlist) {
		if (newPlayerlist != playerlist) {
			NotificationChain msgs = null;
			if (playerlist != null)
				msgs = ((InternalEObject)playerlist).eInverseRemove(this, BowlingPackage.PLAYERLIST__TOURNAMENT, Playerlist.class, msgs);
			if (newPlayerlist != null)
				msgs = ((InternalEObject)newPlayerlist).eInverseAdd(this, BowlingPackage.PLAYERLIST__TOURNAMENT, Playerlist.class, msgs);
			msgs = basicSetPlayerlist(newPlayerlist, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.TOURNAMENT__PLAYERLIST, newPlayerlist, newPlayerlist));
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
			case BowlingPackage.TOURNAMENT__MATCHUPS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMatchups()).basicAdd(otherEnd, msgs);
			case BowlingPackage.TOURNAMENT__PLAYERLIST:
				if (playerlist != null)
					msgs = ((InternalEObject)playerlist).eInverseRemove(this, BowlingPackage.PLAYERLIST__TOURNAMENT, Playerlist.class, msgs);
				return basicSetPlayerlist((Playerlist)otherEnd, msgs);
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
			case BowlingPackage.TOURNAMENT__MATCHUPS:
				return ((InternalEList<?>)getMatchups()).basicRemove(otherEnd, msgs);
			case BowlingPackage.TOURNAMENT__PLAYERLIST:
				return basicSetPlayerlist(null, msgs);
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
			case BowlingPackage.TOURNAMENT__TITLE:
				return getTitle();
			case BowlingPackage.TOURNAMENT__TYPE:
				return getType();
			case BowlingPackage.TOURNAMENT__MATCHUPS:
				return getMatchups();
			case BowlingPackage.TOURNAMENT__PLAYERLIST:
				if (resolve) return getPlayerlist();
				return basicGetPlayerlist();
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
			case BowlingPackage.TOURNAMENT__TITLE:
				setTitle((String)newValue);
				return;
			case BowlingPackage.TOURNAMENT__TYPE:
				setType((TournamentType)newValue);
				return;
			case BowlingPackage.TOURNAMENT__MATCHUPS:
				getMatchups().clear();
				getMatchups().addAll((Collection<? extends Matchup>)newValue);
				return;
			case BowlingPackage.TOURNAMENT__PLAYERLIST:
				setPlayerlist((Playerlist)newValue);
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
			case BowlingPackage.TOURNAMENT__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case BowlingPackage.TOURNAMENT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case BowlingPackage.TOURNAMENT__MATCHUPS:
				getMatchups().clear();
				return;
			case BowlingPackage.TOURNAMENT__PLAYERLIST:
				setPlayerlist((Playerlist)null);
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
			case BowlingPackage.TOURNAMENT__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case BowlingPackage.TOURNAMENT__TYPE:
				return type != TYPE_EDEFAULT;
			case BowlingPackage.TOURNAMENT__MATCHUPS:
				return matchups != null && !matchups.isEmpty();
			case BowlingPackage.TOURNAMENT__PLAYERLIST:
				return playerlist != null;
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
		result.append(" (title: ");
		result.append(title);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //TournamentImpl
