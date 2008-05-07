/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel;

import org.eclipse.emf.ecore.EObject;
import org.unicase.esmodel.changemanagment.PrimaryVersionSpec;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.esmodel.ProjectInfo#getName <em>Name</em>}</li>
 *   <li>{@link org.unicase.esmodel.ProjectInfo#getDescription <em>Description</em>}</li>
 *   <li>{@link org.unicase.esmodel.ProjectInfo#getProjectId <em>Project Id</em>}</li>
 *   <li>{@link org.unicase.esmodel.ProjectInfo#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.esmodel.EsmodelPackage#getProjectInfo()
 * @model
 * @generated
 */
public interface ProjectInfo extends EObject {
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
	 * @see org.unicase.esmodel.EsmodelPackage#getProjectInfo_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.unicase.esmodel.ProjectInfo#getName <em>Name</em>}' attribute.
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
	 * @see org.unicase.esmodel.EsmodelPackage#getProjectInfo_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.unicase.esmodel.ProjectInfo#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Project Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Id</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Id</em>' reference.
	 * @see #setProjectId(ProjectId)
	 * @see org.unicase.esmodel.EsmodelPackage#getProjectInfo_ProjectId()
	 * @model required="true"
	 * @generated
	 */
	ProjectId getProjectId();

	/**
	 * Sets the value of the '{@link org.unicase.esmodel.ProjectInfo#getProjectId <em>Project Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Id</em>' reference.
	 * @see #getProjectId()
	 * @generated
	 */
	void setProjectId(ProjectId value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' containment reference.
	 * @see #setVersion(PrimaryVersionSpec)
	 * @see org.unicase.esmodel.EsmodelPackage#getProjectInfo_Version()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PrimaryVersionSpec getVersion();

	/**
	 * Sets the value of the '{@link org.unicase.esmodel.ProjectInfo#getVersion <em>Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' containment reference.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(PrimaryVersionSpec value);

} // ProjectInfo
