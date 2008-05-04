/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model;

import java.io.Serializable;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.model.organization.User;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * @implements Serializable
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.ModelElement#getName <em>Name</em>}</li>
 *   <li>{@link org.unicase.model.ModelElement#getDescription <em>Description</em>}</li>
 *   <li>{@link org.unicase.model.ModelElement#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.unicase.model.ModelElement#getReaderInfos <em>Reader Infos</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.ModelPackage#getModelElement()
 * @model abstract="true"
 * @generated
 */
public interface ModelElement extends EObject, Serializable {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.unicase.model.ModelPackage#getModelElement_Name()
	 * @model annotation="https://www.sysiphus.org/Visibility VisibilityValue='MANDATORY'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.unicase.model.ModelElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.unicase.model.ModelPackage#getModelElement_Description()
	 * @model annotation="http://www.sysiphus.org/Visibility VisibilityValue='VIEWWHENSET'"
	 *        annotation="http://www.unicase.org/view type='TEXT_AREA'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.unicase.model.ModelElement#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' containment reference.
	 * @see #setIdentifier(ModelElementId)
	 * @see org.unicase.model.ModelPackage#getModelElement_Identifier()
	 * @model containment="true" keys="id" required="true"
	 * @generated
	 */
	ModelElementId getIdentifier();

	/**
	 * Sets the value of the '{@link org.unicase.model.ModelElement#getIdentifier <em>Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' containment reference.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>Reader Infos</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.ReaderInfo}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reader Infos</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reader Infos</em>' containment reference list.
	 * @see org.unicase.model.ModelPackage#getModelElement_ReaderInfos()
	 * @model containment="true"
	 * @generated
	 */
	EList<ReaderInfo> getReaderInfos();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Project getProject();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addReader(User readerName);

} // ModelElement
