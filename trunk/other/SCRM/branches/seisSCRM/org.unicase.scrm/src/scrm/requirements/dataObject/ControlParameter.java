/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataObject;

import scrm.requirements.IRequirement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Control Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.dataObject.ControlParameter#getControlledProcess <em>Controlled Process</em>}</li>
 *   <li>{@link scrm.requirements.dataObject.ControlParameter#getFormat <em>Format</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.dataObject.DataObjectPackage#getControlParameter()
 * @model
 * @generated
 */
public interface ControlParameter extends IRequirement {
	/**
	 * Returns the value of the '<em><b>Controlled Process</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.dataProcess.Process#getControlParameters <em>Control Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controlled Process</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controlled Process</em>' reference.
	 * @see #setControlledProcess(scrm.requirements.dataProcess.Process)
	 * @see scrm.requirements.dataObject.DataObjectPackage#getControlParameter_ControlledProcess()
	 * @see scrm.requirements.dataProcess.Process#getControlParameters
	 * @model opposite="controlParameters"
	 * @generated
	 */
	scrm.requirements.dataProcess.Process getControlledProcess();

	/**
	 * Sets the value of the '{@link scrm.requirements.dataObject.ControlParameter#getControlledProcess <em>Controlled Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Controlled Process</em>' reference.
	 * @see #getControlledProcess()
	 * @generated
	 */
	void setControlledProcess(scrm.requirements.dataProcess.Process value);

	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see #setFormat(String)
	 * @see scrm.requirements.dataObject.DataObjectPackage#getControlParameter_Format()
	 * @model annotation="org.unicase.ui.meeditor position='left' priority='8'"
	 * @generated
	 */
	String getFormat();

	/**
	 * Sets the value of the '{@link scrm.requirements.dataObject.ControlParameter#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(String value);

} // ControlParameter
