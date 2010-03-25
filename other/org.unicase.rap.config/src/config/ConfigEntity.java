/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package config;

import org.eclipse.emf.common.util.EMap;

import org.unicase.metamodel.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link config.ConfigEntity#getProperties <em>Properties</em>}</li>
 *   <li>{@link config.ConfigEntity#getAssociatedProjectIdentifier <em>Associated Project Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see config.ConfigPackage#getConfigEntity()
 * @model
 * @generated
 */
public interface ConfigEntity extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.Object},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' map.
	 * @see config.ConfigPackage#getConfigEntity_Properties()
	 * @model mapType="config.StringToObject<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EJavaObject>"
	 * @generated
	 */
	EMap<String, Object> getProperties();

	/**
	 * Returns the value of the '<em><b>Associated Project Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Project Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Project Identifier</em>' attribute.
	 * @see #setAssociatedProjectIdentifier(String)
	 * @see config.ConfigPackage#getConfigEntity_AssociatedProjectIdentifier()
	 * @model
	 * @generated
	 */
	String getAssociatedProjectIdentifier();

	/**
	 * Sets the value of the '{@link config.ConfigEntity#getAssociatedProjectIdentifier <em>Associated Project Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Associated Project Identifier</em>' attribute.
	 * @see #getAssociatedProjectIdentifier()
	 * @generated
	 */
	void setAssociatedProjectIdentifier(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getConfigFilename();

} // ConfigEntity
