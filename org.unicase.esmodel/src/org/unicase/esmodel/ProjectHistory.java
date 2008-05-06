/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.unicase.esmodel.changemanagment.Version;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project History</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.esmodel.ProjectHistory#getVersions <em>Versions</em>}</li>
 *   <li>{@link org.unicase.esmodel.ProjectHistory#getProjectInfo <em>Project Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.esmodel.EsmodelPackage#getProjectHistory()
 * @model
 * @generated
 */
public interface ProjectHistory extends EObject {
	/**
	 * Returns the value of the '<em><b>Versions</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.esmodel.changemanagment.Version}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Versions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Versions</em>' containment reference list.
	 * @see org.unicase.esmodel.EsmodelPackage#getProjectHistory_Versions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Version> getVersions();

	/**
	 * Returns the value of the '<em><b>Project Info</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Info</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Info</em>' reference.
	 * @see #setProjectInfo(ProjectInfo)
	 * @see org.unicase.esmodel.EsmodelPackage#getProjectHistory_ProjectInfo()
	 * @model required="true"
	 * @generated
	 */
	ProjectInfo getProjectInfo();

	/**
	 * Sets the value of the '{@link org.unicase.esmodel.ProjectHistory#getProjectInfo <em>Project Info</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Info</em>' reference.
	 * @see #getProjectInfo()
	 * @generated
	 */
	void setProjectInfo(ProjectInfo value);

} // ProjectHistory
