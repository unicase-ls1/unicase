/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hardware</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.Hardware#getDependingFeature <em>Depending Feature</em>}</li>
 *   <li>{@link scrm.requirements.Hardware#getProcessor <em>Processor</em>}</li>
 *   <li>{@link scrm.requirements.Hardware#getPlatform <em>Platform</em>}</li>
 *   <li>{@link scrm.requirements.Hardware#getMemory <em>Memory</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getHardware()
 * @model
 * @generated
 */
public interface Hardware extends IRequirement {
	/**
	 * Returns the value of the '<em><b>Depending Feature</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depending Feature</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depending Feature</em>' reference.
	 * @see #setDependingFeature(Feature)
	 * @see scrm.requirements.RequirementsPackage#getHardware_DependingFeature()
	 * @see scrm.requirements.Feature#getDependencies
	 * @model opposite="dependencies"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='15'"
	 * @generated
	 */
	Feature getDependingFeature();

	/**
	 * Sets the value of the '{@link scrm.requirements.Hardware#getDependingFeature <em>Depending Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depending Feature</em>' reference.
	 * @see #getDependingFeature()
	 * @generated
	 */
	void setDependingFeature(Feature value);

	/**
	 * Returns the value of the '<em><b>Processor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processor</em>' attribute.
	 * @see #setProcessor(String)
	 * @see scrm.requirements.RequirementsPackage#getHardware_Processor()
	 * @model annotation="org.unicase.ui.meeditor position='left' priority='5'"
	 * @generated
	 */
	String getProcessor();

	/**
	 * Sets the value of the '{@link scrm.requirements.Hardware#getProcessor <em>Processor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processor</em>' attribute.
	 * @see #getProcessor()
	 * @generated
	 */
	void setProcessor(String value);

	/**
	 * Returns the value of the '<em><b>Platform</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Platform</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Platform</em>' attribute.
	 * @see #setPlatform(String)
	 * @see scrm.requirements.RequirementsPackage#getHardware_Platform()
	 * @model annotation="org.unicase.ui.meeditor position='left' priority='6'"
	 * @generated
	 */
	String getPlatform();

	/**
	 * Sets the value of the '{@link scrm.requirements.Hardware#getPlatform <em>Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Platform</em>' attribute.
	 * @see #getPlatform()
	 * @generated
	 */
	void setPlatform(String value);

	/**
	 * Returns the value of the '<em><b>Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory</em>' attribute.
	 * @see #setMemory(String)
	 * @see scrm.requirements.RequirementsPackage#getHardware_Memory()
	 * @model annotation="org.unicase.ui.meeditor position='left' priority='7'"
	 * @generated
	 */
	String getMemory();

	/**
	 * Sets the value of the '{@link scrm.requirements.Hardware#getMemory <em>Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Memory</em>' attribute.
	 * @see #getMemory()
	 * @generated
	 */
	void setMemory(String value);

} // Hardware
