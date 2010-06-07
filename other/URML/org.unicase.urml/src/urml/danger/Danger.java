/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package urml.danger;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.urml.UrmlModelElement;

import urml.usecase.Actor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Danger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link urml.danger.Danger#getTriggeringActors <em>Triggering Actors</em>}</li>
 *   <li>{@link urml.danger.Danger#getHarmedAssets <em>Harmed Assets</em>}</li>
 *   <li>{@link urml.danger.Danger#getMitigations <em>Mitigations</em>}</li>
 * </ul>
 * </p>
 *
 * @see urml.danger.DangerPackage#getDanger()
 * @model
 * @generated
 */
public interface Danger extends UrmlModelElement {
	/**
	 * Returns the value of the '<em><b>Triggering Actors</b></em>' reference list.
	 * The list contents are of type {@link urml.usecase.Actor}.
	 * It is bidirectional and its opposite is '{@link urml.usecase.Actor#getTriggeredDangers <em>Triggered Dangers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Triggering Actors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Triggering Actors</em>' reference list.
	 * @see urml.danger.DangerPackage#getDanger_TriggeringActors()
	 * @see urml.usecase.Actor#getTriggeredDangers
	 * @model opposite="triggeredDangers" keys="identifier"
	 * @generated
	 */
	EList<Actor> getTriggeringActors();

	/**
	 * Returns the value of the '<em><b>Harmed Assets</b></em>' reference list.
	 * The list contents are of type {@link urml.danger.Asset}.
	 * It is bidirectional and its opposite is '{@link urml.danger.Asset#getEndangeredBy <em>Endangered By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Harmed Assets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Harmed Assets</em>' reference list.
	 * @see urml.danger.DangerPackage#getDanger_HarmedAssets()
	 * @see urml.danger.Asset#getEndangeredBy
	 * @model opposite="endangeredBy" keys="identifier"
	 * @generated
	 */
	EList<Asset> getHarmedAssets();

	/**
	 * Returns the value of the '<em><b>Mitigations</b></em>' reference list.
	 * The list contents are of type {@link urml.danger.Mitigation}.
	 * It is bidirectional and its opposite is '{@link urml.danger.Mitigation#getMitigatedDangers <em>Mitigated Dangers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mitigations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mitigations</em>' reference list.
	 * @see urml.danger.DangerPackage#getDanger_Mitigations()
	 * @see urml.danger.Mitigation#getMitigatedDangers
	 * @model opposite="mitigatedDangers" keys="identifier"
	 * @generated
	 */
	EList<Mitigation> getMitigations();

} // Danger
