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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Matchup</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bowling.impl.MatchupImpl#getGame <em>Game</em>}</li>
 *   <li>{@link bowling.impl.MatchupImpl#getTournament <em>Tournament</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MatchupImpl extends EObjectImpl implements Matchup {
	/**
	 * The cached value of the '{@link #getGame() <em>Game</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGame()
	 * @generated
	 * @ordered
	 */
	protected EList<Game> game;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MatchupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BowlingPackage.Literals.MATCHUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Game> getGame() {
		if (game == null) {
			game = new EObjectContainmentWithInverseEList<Game>(Game.class, this, BowlingPackage.MATCHUP__GAME, BowlingPackage.GAME__MATCHUP);
		}
		return game;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tournament getTournament() {
		if (eContainerFeatureID() != BowlingPackage.MATCHUP__TOURNAMENT) return null;
		return (Tournament)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTournament(Tournament newTournament, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTournament, BowlingPackage.MATCHUP__TOURNAMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTournament(Tournament newTournament) {
		if (newTournament != eInternalContainer() || (eContainerFeatureID() != BowlingPackage.MATCHUP__TOURNAMENT && newTournament != null)) {
			if (EcoreUtil.isAncestor(this, newTournament))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTournament != null)
				msgs = ((InternalEObject)newTournament).eInverseAdd(this, BowlingPackage.TOURNAMENT__MATCHUPS, Tournament.class, msgs);
			msgs = basicSetTournament(newTournament, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.MATCHUP__TOURNAMENT, newTournament, newTournament));
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
			case BowlingPackage.MATCHUP__GAME:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGame()).basicAdd(otherEnd, msgs);
			case BowlingPackage.MATCHUP__TOURNAMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
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
			case BowlingPackage.MATCHUP__GAME:
				return ((InternalEList<?>)getGame()).basicRemove(otherEnd, msgs);
			case BowlingPackage.MATCHUP__TOURNAMENT:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case BowlingPackage.MATCHUP__TOURNAMENT:
				return eInternalContainer().eInverseRemove(this, BowlingPackage.TOURNAMENT__MATCHUPS, Tournament.class, msgs);
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
			case BowlingPackage.MATCHUP__GAME:
				return getGame();
			case BowlingPackage.MATCHUP__TOURNAMENT:
				return getTournament();
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
			case BowlingPackage.MATCHUP__GAME:
				getGame().clear();
				getGame().addAll((Collection<? extends Game>)newValue);
				return;
			case BowlingPackage.MATCHUP__TOURNAMENT:
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
			case BowlingPackage.MATCHUP__GAME:
				getGame().clear();
				return;
			case BowlingPackage.MATCHUP__TOURNAMENT:
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
			case BowlingPackage.MATCHUP__GAME:
				return game != null && !game.isEmpty();
			case BowlingPackage.MATCHUP__TOURNAMENT:
				return getTournament() != null;
		}
		return super.eIsSet(featureID);
	}

} //MatchupImpl
