/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package bowling;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Playerlist</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bowling.Playerlist#getName <em>Name</em>}</li>
 *   <li>{@link bowling.Playerlist#getPlayer <em>Player</em>}</li>
 * </ul>
 * </p>
 *
 * @see bowling.BowlingPackage#getPlayerlist()
 * @model
 * @generated
 */
public interface Playerlist extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see bowling.BowlingPackage#getPlayerlist_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link bowling.Playerlist#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Player</b></em>' containment reference list.
	 * The list contents are of type {@link bowling.Player}.
	 * It is bidirectional and its opposite is '{@link bowling.Player#getPlayerlist <em>Playerlist</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Player</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Player</em>' containment reference list.
	 * @see bowling.BowlingPackage#getPlayerlist_Player()
	 * @see bowling.Player#getPlayerlist
	 * @model opposite="playerlist" containment="true"
	 *        annotation="org.unicase.ui.meeditor position='right' priority='0'"
	 * @generated
	 */
	EList<Player> getPlayer();

} // Playerlist
