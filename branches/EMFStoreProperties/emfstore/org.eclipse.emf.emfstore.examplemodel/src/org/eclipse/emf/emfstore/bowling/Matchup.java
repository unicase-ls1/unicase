/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.eclipse.emf.emfstore.bowling;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Matchup</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.bowling.Matchup#getGames <em>Games</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.bowling.Matchup#getDate <em>Date</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.emfstore.bowling.BowlingPackage#getMatchup()
 * @model
 * @generated
 */
public interface Matchup extends EObject {
	/**
	 * Returns the value of the '<em><b>Games</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.bowling.Game}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.emfstore.bowling.Game#getMatchup
	 * <em>Matchup</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Games</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Games</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.bowling.BowlingPackage#getMatchup_Games()
	 * @see org.eclipse.emf.emfstore.bowling.Game#getMatchup
	 * @model opposite="matchup" containment="true" resolveProxies="true" upper="2"
	 *        annotation="org.unicase.ui.meeditor priority='1' position='right'"
	 * @generated
	 */
	EList<Game> getGames();

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see org.eclipse.emf.emfstore.bowling.BowlingPackage#getMatchup_Date()
	 * @model
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.bowling.Matchup#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

} // Matchup
