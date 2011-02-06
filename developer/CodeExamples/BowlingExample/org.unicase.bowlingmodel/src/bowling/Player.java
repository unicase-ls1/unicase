/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package bowling;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Player</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bowling.Player#getFirstname <em>Firstname</em>}</li>
 *   <li>{@link bowling.Player#getLastname <em>Lastname</em>}</li>
 *   <li>{@link bowling.Player#getStreet <em>Street</em>}</li>
 *   <li>{@link bowling.Player#getStreetnumber <em>Streetnumber</em>}</li>
 *   <li>{@link bowling.Player#getCity <em>City</em>}</li>
 *   <li>{@link bowling.Player#getDateOfBirth <em>Date Of Birth</em>}</li>
 *   <li>{@link bowling.Player#getHeight <em>Height</em>}</li>
 *   <li>{@link bowling.Player#isIsProfessional <em>Is Professional</em>}</li>
 *   <li>{@link bowling.Player#getGames <em>Games</em>}</li>
 *   <li>{@link bowling.Player#getPlayerlist <em>Playerlist</em>}</li>
 * </ul>
 * </p>
 *
 * @see bowling.BowlingPackage#getPlayer()
 * @model
 * @generated
 */
public interface Player extends EObject {
	/**
	 * Returns the value of the '<em><b>Firstname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Firstname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Firstname</em>' attribute.
	 * @see #setFirstname(String)
	 * @see bowling.BowlingPackage#getPlayer_Firstname()
	 * @model
	 * @generated
	 */
	String getFirstname();

	/**
	 * Sets the value of the '{@link bowling.Player#getFirstname <em>Firstname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Firstname</em>' attribute.
	 * @see #getFirstname()
	 * @generated
	 */
	void setFirstname(String value);

	/**
	 * Returns the value of the '<em><b>Lastname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lastname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lastname</em>' attribute.
	 * @see #setLastname(String)
	 * @see bowling.BowlingPackage#getPlayer_Lastname()
	 * @model
	 * @generated
	 */
	String getLastname();

	/**
	 * Sets the value of the '{@link bowling.Player#getLastname <em>Lastname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lastname</em>' attribute.
	 * @see #getLastname()
	 * @generated
	 */
	void setLastname(String value);

	/**
	 * Returns the value of the '<em><b>Street</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Street</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Street</em>' attribute.
	 * @see #setStreet(String)
	 * @see bowling.BowlingPackage#getPlayer_Street()
	 * @model
	 * @generated
	 */
	String getStreet();

	/**
	 * Sets the value of the '{@link bowling.Player#getStreet <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Street</em>' attribute.
	 * @see #getStreet()
	 * @generated
	 */
	void setStreet(String value);

	/**
	 * Returns the value of the '<em><b>Streetnumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Streetnumber</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Streetnumber</em>' attribute.
	 * @see #setStreetnumber(int)
	 * @see bowling.BowlingPackage#getPlayer_Streetnumber()
	 * @model
	 * @generated
	 */
	int getStreetnumber();

	/**
	 * Sets the value of the '{@link bowling.Player#getStreetnumber <em>Streetnumber</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Streetnumber</em>' attribute.
	 * @see #getStreetnumber()
	 * @generated
	 */
	void setStreetnumber(int value);

	/**
	 * Returns the value of the '<em><b>Date Of Birth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date Of Birth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date Of Birth</em>' attribute.
	 * @see #setDateOfBirth(Date)
	 * @see bowling.BowlingPackage#getPlayer_DateOfBirth()
	 * @model
	 * @generated
	 */
	Date getDateOfBirth();

	/**
	 * Sets the value of the '{@link bowling.Player#getDateOfBirth <em>Date Of Birth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date Of Birth</em>' attribute.
	 * @see #getDateOfBirth()
	 * @generated
	 */
	void setDateOfBirth(Date value);

	/**
	 * Returns the value of the '<em><b>City</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>City</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>City</em>' attribute.
	 * @see #setCity(String)
	 * @see bowling.BowlingPackage#getPlayer_City()
	 * @model
	 * @generated
	 */
	String getCity();

	/**
	 * Sets the value of the '{@link bowling.Player#getCity <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>City</em>' attribute.
	 * @see #getCity()
	 * @generated
	 */
	void setCity(String value);

	/**
	 * Returns the value of the '<em><b>Is Professional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Professional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Professional</em>' attribute.
	 * @see #setIsProfessional(boolean)
	 * @see bowling.BowlingPackage#getPlayer_IsProfessional()
	 * @model
	 * @generated
	 */
	boolean isIsProfessional();

	/**
	 * Sets the value of the '{@link bowling.Player#isIsProfessional <em>Is Professional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Professional</em>' attribute.
	 * @see #isIsProfessional()
	 * @generated
	 */
	void setIsProfessional(boolean value);

	/**
	 * Returns the value of the '<em><b>Games</b></em>' reference list.
	 * The list contents are of type {@link bowling.Game}.
	 * It is bidirectional and its opposite is '{@link bowling.Game#getPlayer <em>Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Games</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Games</em>' reference list.
	 * @see bowling.BowlingPackage#getPlayer_Games()
	 * @see bowling.Game#getPlayer
	 * @model opposite="player"
	 *        annotation="org.unicase.ui.meeditor position='right'"
	 * @generated
	 */
	EList<Game> getGames();

	/**
	 * Returns the value of the '<em><b>Playerlist</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link bowling.Playerlist#getPlayer <em>Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Playerlist</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Playerlist</em>' container reference.
	 * @see #setPlayerlist(Playerlist)
	 * @see bowling.BowlingPackage#getPlayer_Playerlist()
	 * @see bowling.Playerlist#getPlayer
	 * @model opposite="player" transient="false"
	 *        annotation="org.unicase.ui.meeditor position='right'"
	 * @generated
	 */
	Playerlist getPlayerlist();

	/**
	 * Sets the value of the '{@link bowling.Player#getPlayerlist <em>Playerlist</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Playerlist</em>' container reference.
	 * @see #getPlayerlist()
	 * @generated
	 */
	void setPlayerlist(Playerlist value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(double)
	 * @see bowling.BowlingPackage#getPlayer_Height()
	 * @model annotation="org.unicase.ui.meeditor digits='2'"
	 * @generated
	 */
	double getHeight();

	/**
	 * Sets the value of the '{@link bowling.Player#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(double value);

} // Player
