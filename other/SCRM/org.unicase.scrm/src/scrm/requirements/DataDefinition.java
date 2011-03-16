/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.DataDefinition#getDefinedRequirement <em>Defined Requirement</em>}</li>
 *   <li>{@link scrm.requirements.DataDefinition#getAccuracy <em>Accuracy</em>}</li>
 *   <li>{@link scrm.requirements.DataDefinition#getFormat <em>Format</em>}</li>
 *   <li>{@link scrm.requirements.DataDefinition#getRange <em>Range</em>}</li>
 *   <li>{@link scrm.requirements.DataDefinition#getDataType <em>Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getDataDefinition()
 * @model
 * @generated
 */
public interface DataDefinition extends Requirement {
	/**
	 * Returns the value of the '<em><b>Defined Requirement</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Requirement#getDefiningData <em>Defining Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defined Requirement</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defined Requirement</em>' container reference.
	 * @see #setDefinedRequirement(Requirement)
	 * @see scrm.requirements.RequirementsPackage#getDataDefinition_DefinedRequirement()
	 * @see scrm.requirements.Requirement#getDefiningData
	 * @model opposite="definingData" transient="false"
	 * @generated
	 */
	Requirement getDefinedRequirement();

	/**
	 * Sets the value of the '{@link scrm.requirements.DataDefinition#getDefinedRequirement <em>Defined Requirement</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defined Requirement</em>' container reference.
	 * @see #getDefinedRequirement()
	 * @generated
	 */
	void setDefinedRequirement(Requirement value);

	/**
	 * Returns the value of the '<em><b>Accuracy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accuracy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accuracy</em>' attribute.
	 * @see #setAccuracy(String)
	 * @see scrm.requirements.RequirementsPackage#getDataDefinition_Accuracy()
	 * @model
	 * @generated
	 */
	String getAccuracy();

	/**
	 * Sets the value of the '{@link scrm.requirements.DataDefinition#getAccuracy <em>Accuracy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accuracy</em>' attribute.
	 * @see #getAccuracy()
	 * @generated
	 */
	void setAccuracy(String value);

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
	 * @see scrm.requirements.RequirementsPackage#getDataDefinition_Format()
	 * @model
	 * @generated
	 */
	String getFormat();

	/**
	 * Sets the value of the '{@link scrm.requirements.DataDefinition#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(String value);

	/**
	 * Returns the value of the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range</em>' attribute.
	 * @see #setRange(String)
	 * @see scrm.requirements.RequirementsPackage#getDataDefinition_Range()
	 * @model
	 * @generated
	 */
	String getRange();

	/**
	 * Sets the value of the '{@link scrm.requirements.DataDefinition#getRange <em>Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' attribute.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(String value);

	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type</em>' attribute.
	 * @see #setDataType(String)
	 * @see scrm.requirements.RequirementsPackage#getDataDefinition_DataType()
	 * @model
	 * @generated
	 */
	String getDataType();

	/**
	 * Sets the value of the '{@link scrm.requirements.DataDefinition#getDataType <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type</em>' attribute.
	 * @see #getDataType()
	 * @generated
	 */
	void setDataType(String value);

} // DataDefinition
