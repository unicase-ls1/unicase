/**
 * <copyright> </copyright> $Id$
 */
package urml.danger;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.urml.UrmlModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Danger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link urml.danger.Danger#getTriggeringAssets <em>Triggering Assets</em>}</li>
 *   <li>{@link urml.danger.Danger#getHarmedAssets <em>Harmed Assets</em>}</li>
 *   <li>{@link urml.danger.Danger#getHarmedClasses <em>Harmed Classes</em>}</li>
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
	 * Returns the value of the '<em><b>Triggering Assets</b></em>' reference list.
	 * The list contents are of type {@link urml.danger.Asset}.
	 * It is bidirectional and its opposite is '{@link urml.danger.Asset#getTriggeredDangers <em>Triggered Dangers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Triggering Assets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Triggering Assets</em>' reference list.
	 * @see urml.danger.DangerPackage#getDanger_TriggeringAssets()
	 * @see urml.danger.Asset#getTriggeredDangers
	 * @model opposite="triggeredDangers" keys="identifier"
	 * @generated
	 */
	EList<Asset> getTriggeringAssets();

	/**
	 * Returns the value of the '<em><b>Harmed Assets</b></em>' reference list.
	 * The list contents are of type {@link urml.danger.Asset}.
	 * It is bidirectional and its opposite is '{@link urml.danger.Asset#getHarmingDangers <em>Harming Dangers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Harmed Assets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Harmed Assets</em>' reference list.
	 * @see urml.danger.DangerPackage#getDanger_HarmedAssets()
	 * @see urml.danger.Asset#getHarmingDangers
	 * @model opposite="harmingDangers" keys="identifier"
	 * @generated
	 */
	EList<Asset> getHarmedAssets();

	/**
	 * Returns the value of the '<em><b>Harmed Classes</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.classes.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Harmed Classes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Harmed Classes</em>' reference list.
	 * @see urml.danger.DangerPackage#getDanger_HarmedClasses()
	 * @model keys="identifier"
	 * @generated
	 */
	EList<org.unicase.model.classes.Class> getHarmedClasses();

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
