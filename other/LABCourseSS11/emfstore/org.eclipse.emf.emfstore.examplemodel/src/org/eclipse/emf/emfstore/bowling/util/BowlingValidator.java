/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.emfstore.bowling.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.emf.emfstore.bowling.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.emfstore.bowling.BowlingPackage
 * @generated
 */
public class BowlingValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final BowlingValidator INSTANCE = new BowlingValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.emf.emfstore.bowling";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Name' of 'Player'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PLAYER__HAS_NAME = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Street' of 'Player'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PLAYER__HAS_STREET = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Date Of Birth' of 'Player'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PLAYER__HAS_DATE_OF_BIRTH = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Correct Street Number' of 'Player'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PLAYER__HAS_CORRECT_STREET_NUMBER = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Telephon' of 'Player'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PLAYER__HAS_TELEPHON = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Height' of 'Player'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PLAYER__HAS_HEIGHT = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Is Available' of 'Player'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PLAYER__HAS_IS_AVAILABLE = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Notes' of 'Player'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PLAYER__HAS_NOTES = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Game' of 'Player'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PLAYER__HAS_GAME = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Tounament Pro' of 'Tournament'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TOURNAMENT__HAS_TOUNAMENT_PRO = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has League' of 'Tournament'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TOURNAMENT__HAS_LEAGUE = 11;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 11;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BowlingValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return BowlingPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case BowlingPackage.PLAYER:
				return validatePlayer((Player)value, diagnostics, context);
			case BowlingPackage.LEAGUE:
				return validateLeague((League)value, diagnostics, context);
			case BowlingPackage.TOURNAMENT:
				return validateTournament((Tournament)value, diagnostics, context);
			case BowlingPackage.MATCHUP:
				return validateMatchup((Matchup)value, diagnostics, context);
			case BowlingPackage.GAME:
				return validateGame((Game)value, diagnostics, context);
			case BowlingPackage.TOURNAMENT_TYPE:
				return validateTournamentType((TournamentType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlayer(Player player, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(player, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(player, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(player, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(player, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(player, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(player, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(player, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(player, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(player, diagnostics, context);
		if (result || diagnostics != null) result &= validatePlayer_hasName(player, diagnostics, context);
		if (result || diagnostics != null) result &= validatePlayer_hasStreet(player, diagnostics, context);
		if (result || diagnostics != null) result &= validatePlayer_hasDateOfBirth(player, diagnostics, context);
		if (result || diagnostics != null) result &= validatePlayer_hasCorrectStreetNumber(player, diagnostics, context);
		if (result || diagnostics != null) result &= validatePlayer_hasTelephon(player, diagnostics, context);
		if (result || diagnostics != null) result &= validatePlayer_hasHeight(player, diagnostics, context);
		if (result || diagnostics != null) result &= validatePlayer_hasIsAvailable(player, diagnostics, context);
		if (result || diagnostics != null) result &= validatePlayer_hasNotes(player, diagnostics, context);
		if (result || diagnostics != null) result &= validatePlayer_hasGame(player, diagnostics, context);
		return result;
	}

	/**
	 * Validates the hasName constraint of '<em>Player</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlayer_hasName(Player player, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return player.hasName(diagnostics, context);
	}

	/**
	 * Validates the hasStreet constraint of '<em>Player</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlayer_hasStreet(Player player, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return player.hasStreet(diagnostics, context);
	}

	/**
	 * Validates the hasDateOfBirth constraint of '<em>Player</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlayer_hasDateOfBirth(Player player, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return player.hasDateOfBirth(diagnostics, context);
	}

	/**
	 * Validates the hasCorrectStreetNumber constraint of '<em>Player</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlayer_hasCorrectStreetNumber(Player player, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return player.hasCorrectStreetNumber(diagnostics, context);
	}

	/**
	 * Validates the hasTelephon constraint of '<em>Player</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlayer_hasTelephon(Player player, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return player.hasTelephon(diagnostics, context);
	}

	/**
	 * Validates the hasHeight constraint of '<em>Player</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlayer_hasHeight(Player player, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return player.hasHeight(diagnostics, context);
	}

	/**
	 * Validates the hasIsAvailable constraint of '<em>Player</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlayer_hasIsAvailable(Player player, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return player.hasIsAvailable(diagnostics, context);
	}

	/**
	 * Validates the hasNotes constraint of '<em>Player</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlayer_hasNotes(Player player, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return player.hasNotes(diagnostics, context);
	}

	/**
	 * Validates the hasGame constraint of '<em>Player</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlayer_hasGame(Player player, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return player.hasGame(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLeague(League league, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(league, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTournament(Tournament tournament, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(tournament, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(tournament, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(tournament, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(tournament, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(tournament, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(tournament, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(tournament, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(tournament, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(tournament, diagnostics, context);
		if (result || diagnostics != null) result &= validateTournament_hasTounamentPro(tournament, diagnostics, context);
		if (result || diagnostics != null) result &= validateTournament_hasLeague(tournament, diagnostics, context);
		return result;
	}

	/**
	 * Validates the hasTounamentPro constraint of '<em>Tournament</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTournament_hasTounamentPro(Tournament tournament, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return tournament.hasTounamentPro(diagnostics, context);
	}

	/**
	 * Validates the hasLeague constraint of '<em>Tournament</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTournament_hasLeague(Tournament tournament, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return tournament.hasLeague(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMatchup(Matchup matchup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(matchup, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGame(Game game, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(game, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTournamentType(TournamentType tournamentType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //BowlingValidator
