/**
 * <copyright> </copyright> $Id$
 */
package urml.danger;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Procedural Mitigation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link urml.danger.ProceduralMitigation#getMitigationProcedure <em>Mitigation Procedure</em>}</li>
 * </ul>
 * </p>
 * 
 * @see urml.danger.DangerPackage#getProceduralMitigation()
 * @model
 * @generated
 */
public interface ProceduralMitigation extends Mitigation {
	/**
	 * Returns the value of the '<em><b>Mitigation Procedure</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mitigation Procedure</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Mitigation Procedure</em>' attribute.
	 * @see #setMitigationProcedure(String)
	 * @see urml.danger.DangerPackage#getProceduralMitigation_MitigationProcedure()
	 * @model
	 * @generated
	 */
	String getMitigationProcedure();

	/**
	 * Sets the value of the '{@link urml.danger.ProceduralMitigation#getMitigationProcedure
	 * <em>Mitigation Procedure</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Mitigation Procedure</em>' attribute.
	 * @see #getMitigationProcedure()
	 * @generated
	 */
	void setMitigationProcedure(String value);

} // ProceduralMitigation
