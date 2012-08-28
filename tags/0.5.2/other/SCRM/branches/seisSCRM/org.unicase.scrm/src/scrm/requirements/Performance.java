/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Performance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.Performance#getHardware <em>Hardware</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getPerformance()
 * @model
 * @generated
 */
public interface Performance extends Requirement {
	/**
	 * Returns the value of the '<em><b>Hardware</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hardware</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hardware</em>' reference.
	 * @see #setHardware(Hardware)
	 * @see scrm.requirements.RequirementsPackage#getPerformance_Hardware()
	 * @model
	 * @generated
	 */
	Hardware getHardware();

	/**
	 * Sets the value of the '{@link scrm.requirements.Performance#getHardware <em>Hardware</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hardware</em>' reference.
	 * @see #getHardware()
	 * @generated
	 */
	void setHardware(Hardware value);

} // Performance
