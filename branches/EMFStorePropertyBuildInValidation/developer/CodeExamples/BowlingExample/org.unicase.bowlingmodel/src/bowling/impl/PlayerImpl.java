/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package bowling.impl;

import bowling.BowlingPackage;
import bowling.Game;
import bowling.Player;
import bowling.Playerlist;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Player</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bowling.impl.PlayerImpl#getFirstname <em>Firstname</em>}</li>
 *   <li>{@link bowling.impl.PlayerImpl#getLastname <em>Lastname</em>}</li>
 *   <li>{@link bowling.impl.PlayerImpl#getStreet <em>Street</em>}</li>
 *   <li>{@link bowling.impl.PlayerImpl#getStreetnumber <em>Streetnumber</em>}</li>
 *   <li>{@link bowling.impl.PlayerImpl#getCity <em>City</em>}</li>
 *   <li>{@link bowling.impl.PlayerImpl#getDateOfBirth <em>Date Of Birth</em>}</li>
 *   <li>{@link bowling.impl.PlayerImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link bowling.impl.PlayerImpl#isIsProfessional <em>Is Professional</em>}</li>
 *   <li>{@link bowling.impl.PlayerImpl#getGame <em>Game</em>}</li>
 *   <li>{@link bowling.impl.PlayerImpl#getPlayerlist <em>Playerlist</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlayerImpl extends EObjectImpl implements Player {
	/**
	 * The default value of the '{@link #getFirstname() <em>Firstname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstname()
	 * @generated
	 * @ordered
	 */
	protected static final String FIRSTNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFirstname() <em>Firstname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstname()
	 * @generated
	 * @ordered
	 */
	protected String firstname = FIRSTNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastname() <em>Lastname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastname()
	 * @generated
	 * @ordered
	 */
	protected static final String LASTNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastname() <em>Lastname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastname()
	 * @generated
	 * @ordered
	 */
	protected String lastname = LASTNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStreet() <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreet()
	 * @generated
	 * @ordered
	 */
	protected static final String STREET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStreet() <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreet()
	 * @generated
	 * @ordered
	 */
	protected String street = STREET_EDEFAULT;

	/**
	 * The default value of the '{@link #getStreetnumber() <em>Streetnumber</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreetnumber()
	 * @generated
	 * @ordered
	 */
	protected static final int STREETNUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStreetnumber() <em>Streetnumber</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreetnumber()
	 * @generated
	 * @ordered
	 */
	protected int streetnumber = STREETNUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getCity() <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCity()
	 * @generated
	 * @ordered
	 */
	protected static final String CITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCity() <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCity()
	 * @generated
	 * @ordered
	 */
	protected String city = CITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getDateOfBirth() <em>Date Of Birth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateOfBirth()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_OF_BIRTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDateOfBirth() <em>Date Of Birth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateOfBirth()
	 * @generated
	 * @ordered
	 */
	protected Date dateOfBirth = DATE_OF_BIRTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final double HEIGHT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected double height = HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsProfessional() <em>Is Professional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsProfessional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PROFESSIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsProfessional() <em>Is Professional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsProfessional()
	 * @generated
	 * @ordered
	 */
	protected boolean isProfessional = IS_PROFESSIONAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGame() <em>Game</em>}' reference list.
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
	protected PlayerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BowlingPackage.Literals.PLAYER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstname(String newFirstname) {
		String oldFirstname = firstname;
		firstname = newFirstname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYER__FIRSTNAME, oldFirstname, firstname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastname(String newLastname) {
		String oldLastname = lastname;
		lastname = newLastname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYER__LASTNAME, oldLastname, lastname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStreet(String newStreet) {
		String oldStreet = street;
		street = newStreet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYER__STREET, oldStreet, street));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStreetnumber() {
		return streetnumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStreetnumber(int newStreetnumber) {
		int oldStreetnumber = streetnumber;
		streetnumber = newStreetnumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYER__STREETNUMBER, oldStreetnumber, streetnumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCity() {
		return city;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCity(String newCity) {
		String oldCity = city;
		city = newCity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYER__CITY, oldCity, city));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDateOfBirth(Date newDateOfBirth) {
		Date oldDateOfBirth = dateOfBirth;
		dateOfBirth = newDateOfBirth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYER__DATE_OF_BIRTH, oldDateOfBirth, dateOfBirth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(double newHeight) {
		double oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYER__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsProfessional() {
		return isProfessional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsProfessional(boolean newIsProfessional) {
		boolean oldIsProfessional = isProfessional;
		isProfessional = newIsProfessional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYER__IS_PROFESSIONAL, oldIsProfessional, isProfessional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Game> getGame() {
		if (game == null) {
			game = new EObjectWithInverseResolvingEList<Game>(Game.class, this, BowlingPackage.PLAYER__GAME, BowlingPackage.GAME__PLAYER);
		}
		return game;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Playerlist getPlayerlist() {
		if (eContainerFeatureID() != BowlingPackage.PLAYER__PLAYERLIST) return null;
		return (Playerlist)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlayerlist(Playerlist newPlayerlist, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPlayerlist, BowlingPackage.PLAYER__PLAYERLIST, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlayerlist(Playerlist newPlayerlist) {
		if (newPlayerlist != eInternalContainer() || (eContainerFeatureID() != BowlingPackage.PLAYER__PLAYERLIST && newPlayerlist != null)) {
			if (EcoreUtil.isAncestor(this, newPlayerlist))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPlayerlist != null)
				msgs = ((InternalEObject)newPlayerlist).eInverseAdd(this, BowlingPackage.PLAYERLIST__PLAYER, Playerlist.class, msgs);
			msgs = basicSetPlayerlist(newPlayerlist, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYER__PLAYERLIST, newPlayerlist, newPlayerlist));
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
			case BowlingPackage.PLAYER__GAME:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGame()).basicAdd(otherEnd, msgs);
			case BowlingPackage.PLAYER__PLAYERLIST:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
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
			case BowlingPackage.PLAYER__GAME:
				return ((InternalEList<?>)getGame()).basicRemove(otherEnd, msgs);
			case BowlingPackage.PLAYER__PLAYERLIST:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case BowlingPackage.PLAYER__PLAYERLIST:
				return eInternalContainer().eInverseRemove(this, BowlingPackage.PLAYERLIST__PLAYER, Playerlist.class, msgs);
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
			case BowlingPackage.PLAYER__FIRSTNAME:
				return getFirstname();
			case BowlingPackage.PLAYER__LASTNAME:
				return getLastname();
			case BowlingPackage.PLAYER__STREET:
				return getStreet();
			case BowlingPackage.PLAYER__STREETNUMBER:
				return getStreetnumber();
			case BowlingPackage.PLAYER__CITY:
				return getCity();
			case BowlingPackage.PLAYER__DATE_OF_BIRTH:
				return getDateOfBirth();
			case BowlingPackage.PLAYER__HEIGHT:
				return getHeight();
			case BowlingPackage.PLAYER__IS_PROFESSIONAL:
				return isIsProfessional();
			case BowlingPackage.PLAYER__GAME:
				return getGame();
			case BowlingPackage.PLAYER__PLAYERLIST:
				return getPlayerlist();
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
			case BowlingPackage.PLAYER__FIRSTNAME:
				setFirstname((String)newValue);
				return;
			case BowlingPackage.PLAYER__LASTNAME:
				setLastname((String)newValue);
				return;
			case BowlingPackage.PLAYER__STREET:
				setStreet((String)newValue);
				return;
			case BowlingPackage.PLAYER__STREETNUMBER:
				setStreetnumber((Integer)newValue);
				return;
			case BowlingPackage.PLAYER__CITY:
				setCity((String)newValue);
				return;
			case BowlingPackage.PLAYER__DATE_OF_BIRTH:
				setDateOfBirth((Date)newValue);
				return;
			case BowlingPackage.PLAYER__HEIGHT:
				setHeight((Double)newValue);
				return;
			case BowlingPackage.PLAYER__IS_PROFESSIONAL:
				setIsProfessional((Boolean)newValue);
				return;
			case BowlingPackage.PLAYER__GAME:
				getGame().clear();
				getGame().addAll((Collection<? extends Game>)newValue);
				return;
			case BowlingPackage.PLAYER__PLAYERLIST:
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
			case BowlingPackage.PLAYER__FIRSTNAME:
				setFirstname(FIRSTNAME_EDEFAULT);
				return;
			case BowlingPackage.PLAYER__LASTNAME:
				setLastname(LASTNAME_EDEFAULT);
				return;
			case BowlingPackage.PLAYER__STREET:
				setStreet(STREET_EDEFAULT);
				return;
			case BowlingPackage.PLAYER__STREETNUMBER:
				setStreetnumber(STREETNUMBER_EDEFAULT);
				return;
			case BowlingPackage.PLAYER__CITY:
				setCity(CITY_EDEFAULT);
				return;
			case BowlingPackage.PLAYER__DATE_OF_BIRTH:
				setDateOfBirth(DATE_OF_BIRTH_EDEFAULT);
				return;
			case BowlingPackage.PLAYER__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case BowlingPackage.PLAYER__IS_PROFESSIONAL:
				setIsProfessional(IS_PROFESSIONAL_EDEFAULT);
				return;
			case BowlingPackage.PLAYER__GAME:
				getGame().clear();
				return;
			case BowlingPackage.PLAYER__PLAYERLIST:
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
			case BowlingPackage.PLAYER__FIRSTNAME:
				return FIRSTNAME_EDEFAULT == null ? firstname != null : !FIRSTNAME_EDEFAULT.equals(firstname);
			case BowlingPackage.PLAYER__LASTNAME:
				return LASTNAME_EDEFAULT == null ? lastname != null : !LASTNAME_EDEFAULT.equals(lastname);
			case BowlingPackage.PLAYER__STREET:
				return STREET_EDEFAULT == null ? street != null : !STREET_EDEFAULT.equals(street);
			case BowlingPackage.PLAYER__STREETNUMBER:
				return streetnumber != STREETNUMBER_EDEFAULT;
			case BowlingPackage.PLAYER__CITY:
				return CITY_EDEFAULT == null ? city != null : !CITY_EDEFAULT.equals(city);
			case BowlingPackage.PLAYER__DATE_OF_BIRTH:
				return DATE_OF_BIRTH_EDEFAULT == null ? dateOfBirth != null : !DATE_OF_BIRTH_EDEFAULT.equals(dateOfBirth);
			case BowlingPackage.PLAYER__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case BowlingPackage.PLAYER__IS_PROFESSIONAL:
				return isProfessional != IS_PROFESSIONAL_EDEFAULT;
			case BowlingPackage.PLAYER__GAME:
				return game != null && !game.isEmpty();
			case BowlingPackage.PLAYER__PLAYERLIST:
				return getPlayerlist() != null;
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
		result.append(" (firstname: ");
		result.append(firstname);
		result.append(", lastname: ");
		result.append(lastname);
		result.append(", street: ");
		result.append(street);
		result.append(", streetnumber: ");
		result.append(streetnumber);
		result.append(", city: ");
		result.append(city);
		result.append(", dateOfBirth: ");
		result.append(dateOfBirth);
		result.append(", height: ");
		result.append(height);
		result.append(", isProfessional: ");
		result.append(isProfessional);
		result.append(')');
		return result.toString();
	}

} //PlayerImpl
