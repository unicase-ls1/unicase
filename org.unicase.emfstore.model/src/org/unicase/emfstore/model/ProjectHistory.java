/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.model.changemanagment.Version;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project History</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.model.ProjectHistory#getProjectId <em>Project Id</em>}</li>
 *   <li>{@link org.unicase.emfstore.model.ProjectHistory#getVersions <em>Versions</em>}</li>
 *   <li>{@link org.unicase.emfstore.model.ProjectHistory#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.unicase.emfstore.model.ProjectHistory#getProjectDescription <em>Project Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.model.EsmodelPackage#getProjectHistory()
 * @model
 * @generated
 */
public interface ProjectHistory extends EObject {
	/**
	 * Returns the value of the '<em><b>Project Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Id</em>' containment reference.
	 * @see #setProjectId(ProjectId)
	 * @see org.unicase.emfstore.model.EsmodelPackage#getProjectHistory_ProjectId()
	 * @model containment="true"
	 * @generated
	 */
	ProjectId getProjectId();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.model.ProjectHistory#getProjectId <em>Project Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Id</em>' containment reference.
	 * @see #getProjectId()
	 * @generated
	 */
	void setProjectId(ProjectId value);

	/**
	 * Returns the value of the '<em><b>Versions</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.emfstore.model.changemanagment.Version}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Versions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Versions</em>' containment reference list.
	 * @see org.unicase.emfstore.model.EsmodelPackage#getProjectHistory_Versions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Version> getVersions();

	/**
	 * Returns the value of the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Name</em>' attribute.
	 * @see #setProjectName(String)
	 * @see org.unicase.emfstore.model.EsmodelPackage#getProjectHistory_ProjectName()
	 * @model required="true"
	 * @generated
	 */
	String getProjectName();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.model.ProjectHistory#getProjectName <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Name</em>' attribute.
	 * @see #getProjectName()
	 * @generated
	 */
	void setProjectName(String value);

	/**
	 * Returns the value of the '<em><b>Project Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Description</em>' attribute.
	 * @see #setProjectDescription(String)
	 * @see org.unicase.emfstore.model.EsmodelPackage#getProjectHistory_ProjectDescription()
	 * @model required="true"
	 * @generated
	 */
	String getProjectDescription();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.model.ProjectHistory#getProjectDescription <em>Project Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Description</em>' attribute.
	 * @see #getProjectDescription()
	 * @generated
	 */
	void setProjectDescription(String value);

} // ProjectHistory
