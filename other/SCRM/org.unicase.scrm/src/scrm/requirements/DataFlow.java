/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.DataFlow#getSpecifiedProcess <em>Specified Process</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getDataFlow()
 * @model
 * @generated
 */
public interface DataFlow extends Requirement {
	/**
	 * Returns the value of the '<em><b>Specified Process</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Process#getDataFlow <em>Data Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specified Process</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specified Process</em>' container reference.
	 * @see #setSpecifiedProcess(scrm.requirements.Process)
	 * @see scrm.requirements.RequirementsPackage#getDataFlow_SpecifiedProcess()
	 * @see scrm.requirements.Process#getDataFlow
	 * @model opposite="dataFlow" transient="false"
	 * @generated
	 */
	scrm.requirements.Process getSpecifiedProcess();

	/**
	 * Sets the value of the '{@link scrm.requirements.DataFlow#getSpecifiedProcess <em>Specified Process</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specified Process</em>' container reference.
	 * @see #getSpecifiedProcess()
	 * @generated
	 */
	void setSpecifiedProcess(scrm.requirements.Process value);

} // DataFlow
