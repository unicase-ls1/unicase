/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.eclipse.emf.emfstore.bowling;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>League</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.bowling.League#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.bowling.League#getPlayers <em>Players</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.emfstore.bowling.BowlingPackage#getLeague()
 * @model
 * @generated
 */
public interface League extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.emf.emfstore.bowling.BowlingPackage#getLeague_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.bowling.League#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Players</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.bowling.Player}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Players</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Players</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.bowling.BowlingPackage#getLeague_Players()
	 * @model containment="true" resolveProxies="true"
	 *        annotation="org.unicase.ui.meeditor priority='1' position='right'"
	 * @generated
	 */
	EList<Player> getPlayers();

} // League
