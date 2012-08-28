/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Software Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.SoftwareInterface#getDataTypes <em>Data Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getSoftwareInterface()
 * @model
 * @generated
 */
public interface SoftwareInterface extends Interface {
	/**
	 * Returns the value of the '<em><b>Data Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Types</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Types</em>' attribute.
	 * @see #setDataTypes(String)
	 * @see scrm.requirements.RequirementsPackage#getSoftwareInterface_DataTypes()
	 * @model annotation="org.eclipse.emf.ecp.editor position='left' priority='5'"
	 * @generated
	 */
	String getDataTypes();

	/**
	 * Sets the value of the '{@link scrm.requirements.SoftwareInterface#getDataTypes <em>Data Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Types</em>' attribute.
	 * @see #getDataTypes()
	 * @generated
	 */
	void setDataTypes(String value);

} // SoftwareInterface
