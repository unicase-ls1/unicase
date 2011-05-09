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
 * A representation of the model object '<em><b>Tournament</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.bowling.Tournament#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.bowling.Tournament#getMatchups <em>Matchups</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.bowling.Tournament#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.bowling.Tournament#getLeague <em>League</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.bowling.BowlingPackage#getTournament()
 * @model
 * @generated
 */
public interface Tournament extends EObject {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.eclipse.emf.emfstore.bowling.BowlingPackage#getTournament_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.bowling.Tournament#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Matchups</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.bowling.Matchup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matchups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matchups</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.bowling.BowlingPackage#getTournament_Matchups()
	 * @model containment="true" resolveProxies="true"
	 *        annotation="org.unicase.ui.meeditor priority='1' position='right'"
	 * @generated
	 */
	EList<Matchup> getMatchups();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.emf.emfstore.bowling.TournamentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.emf.emfstore.bowling.TournamentType
	 * @see #setType(TournamentType)
	 * @see org.eclipse.emf.emfstore.bowling.BowlingPackage#getTournament_Type()
	 * @model
	 * @generated
	 */
	TournamentType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.bowling.Tournament#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.emf.emfstore.bowling.TournamentType
	 * @see #getType()
	 * @generated
	 */
	void setType(TournamentType value);

	/**
	 * Returns the value of the '<em><b>League</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>League</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>League</em>' reference.
	 * @see #setLeague(League)
	 * @see org.eclipse.emf.emfstore.bowling.BowlingPackage#getTournament_League()
	 * @model
	 * @generated
	 */
	League getLeague();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.bowling.Tournament#getLeague <em>League</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>League</em>' reference.
	 * @see #getLeague()
	 * @generated
	 */
	void setLeague(League value);

} // Tournament
