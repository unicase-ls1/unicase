/**
 * <copyright> </copyright> $Id$
 */
package urml.danger;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.urml.UrmlModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Asset</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link urml.danger.Asset#getTriggeredDangers <em>Triggered Dangers</em>}</li>
 *   <li>{@link urml.danger.Asset#getHarmingDangers <em>Harming Dangers</em>}</li>
 * </ul>
 * </p>
 *
 * @see urml.danger.DangerPackage#getAsset()
 * @model abstract="true"
 * @generated
 */
public interface Asset extends UrmlModelElement {
	/**
	 * Returns the value of the '<em><b>Triggered Dangers</b></em>' reference list.
	 * The list contents are of type {@link urml.danger.Danger}.
	 * It is bidirectional and its opposite is '{@link urml.danger.Danger#getTriggeringAssets <em>Triggering Assets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Triggered Dangers</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Triggered Dangers</em>' reference list.
	 * @see urml.danger.DangerPackage#getAsset_TriggeredDangers()
	 * @see urml.danger.Danger#getTriggeringAssets
	 * @model opposite="triggeringAssets" keys="identifier"
	 * @generated
	 */
	EList<Danger> getTriggeredDangers();

	/**
	 * Returns the value of the '<em><b>Harming Dangers</b></em>' reference list.
	 * The list contents are of type {@link urml.danger.Danger}.
	 * It is bidirectional and its opposite is '{@link urml.danger.Danger#getHarmedAssets <em>Harmed Assets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Harming Dangers</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Harming Dangers</em>' reference list.
	 * @see urml.danger.DangerPackage#getAsset_HarmingDangers()
	 * @see urml.danger.Danger#getHarmedAssets
	 * @model opposite="harmedAssets" keys="identifier"
	 * @generated
	 */
	EList<Danger> getHarmingDangers();

} // Asset
