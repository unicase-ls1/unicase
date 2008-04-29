/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model;

import java.util.Collection;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.Project#getName <em>Name</em>}</li>
 *   <li>{@link org.unicase.model.Project#getDescription <em>Description</em>}</li>
 *   <li>{@link org.unicase.model.Project#getProjectElements <em>Project Elements</em>}</li>
 *   <li>{@link org.unicase.model.Project#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.ModelPackage#getProject()
 * @model
 * @generated NOT
 */
public interface Project extends EObject, IAdaptable {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.unicase.model.ModelPackage#getProject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.unicase.model.Project#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * @see org.unicase.model.ModelPackage#getProject_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.unicase.model.Project#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Project Elements</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.ModelElement}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.ModelElement#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Elements</em>' reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Elements</em>' reference list.
	 * @see org.unicase.model.ModelPackage#getProject_ProjectElements()
	 * @see org.unicase.model.ModelElement#getProject
	 * @model opposite="project"
	 * @generated
	 */
	EList<ModelElement> getProjectElements();

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' containment reference.
	 * @see #setIdentifier(ProjectId)
	 * @see org.unicase.model.ModelPackage#getProject_Identifier()
	 * @model containment="true"
	 * @generated
	 */
	ProjectId getIdentifier();

	/**
	 * Sets the value of the '{@link org.unicase.model.Project#getIdentifier <em>Identifier</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' containment reference.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(ProjectId value);

	Collection<ModelElement> getElementsByClass(
			Class<? extends EObject> elementType);

} // Project
