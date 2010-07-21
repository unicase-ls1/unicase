/**
 * <copyright> </copyright> $Id$
 */
package urml.danger;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.urml.UrmlModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Mitigation</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link urml.danger.Mitigation#getMitigatedDangers <em>Mitigated Dangers</em>}</li>
 * </ul>
 * </p>
 *
 * @see urml.danger.DangerPackage#getMitigation()
 * @model abstract="true"
 * @generated
 */
public interface Mitigation extends UrmlModelElement {
	/**
	 * Returns the value of the '<em><b>Mitigated Dangers</b></em>' reference list.
	 * The list contents are of type {@link urml.danger.Danger}.
	 * It is bidirectional and its opposite is '{@link urml.danger.Danger#getMitigations <em>Mitigations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mitigated Dangers</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mitigated Dangers</em>' reference list.
	 * @see urml.danger.DangerPackage#getMitigation_MitigatedDangers()
	 * @see urml.danger.Danger#getMitigations
	 * @model opposite="mitigations" keys="identifier"
	 * @generated
	 */
	EList<Danger> getMitigatedDangers();

} // Mitigation
