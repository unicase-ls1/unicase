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
 * A representation of the model object '<em><b>Matchup</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bowling.Matchup#getGames <em>Games</em>}</li>
 *   <li>{@link bowling.Matchup#getTournament <em>Tournament</em>}</li>
 * </ul>
 * </p>
 *
 * @see bowling.BowlingPackage#getMatchup()
 * @model
 * @generated
 */
public interface Matchup extends EObject {
	/**
	 * Returns the value of the '<em><b>Games</b></em>' containment reference list.
	 * The list contents are of type {@link bowling.Game}.
	 * It is bidirectional and its opposite is '{@link bowling.Game#getMatchup <em>Matchup</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Games</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Games</em>' containment reference list.
	 * @see bowling.BowlingPackage#getMatchup_Games()
	 * @see bowling.Game#getMatchup
	 * @model opposite="matchup" containment="true" upper="2"
	 *        annotation="org.unicase.ui.meeditor position='left'"
	 * @generated
	 */
	EList<Game> getGames();

	/**
	 * Returns the value of the '<em><b>Tournament</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link bowling.Tournament#getMatchup <em>Matchup</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tournament</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tournament</em>' container reference.
	 * @see #setTournament(Tournament)
	 * @see bowling.BowlingPackage#getMatchup_Tournament()
	 * @see bowling.Tournament#getMatchup
	 * @model opposite="matchup" transient="false"
	 *        annotation="org.unicase.ui.meeditor position='right'"
	 * @generated
	 */
	Tournament getTournament();

	/**
	 * Sets the value of the '{@link bowling.Matchup#getTournament <em>Tournament</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tournament</em>' container reference.
	 * @see #getTournament()
	 * @generated
	 */
	void setTournament(Tournament value);

} // Matchup
