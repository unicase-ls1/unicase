/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.analyzer;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;

import org.unicase.model.Project;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project Analysis Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.analyzer.ProjectAnalysisData#getProjectState <em>Project State</em>}</li>
 *   <li>{@link org.unicase.analyzer.ProjectAnalysisData#getChangePackages <em>Change Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.analyzer.AnalyzerPackage#getProjectAnalysisData()
 * @model
 * @generated
 */
public interface ProjectAnalysisData extends EObject {
	/**
	 * Returns the value of the '<em><b>Project State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project State</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project State</em>' containment reference.
	 * @see #setProjectState(Project)
	 * @see org.unicase.analyzer.AnalyzerPackage#getProjectAnalysisData_ProjectState()
	 * @model containment="true"
	 * @generated
	 */
	Project getProjectState();

	/**
	 * Sets the value of the '{@link org.unicase.analyzer.ProjectAnalysisData#getProjectState <em>Project State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project State</em>' containment reference.
	 * @see #getProjectState()
	 * @generated
	 */
	void setProjectState(Project value);

	/**
	 * Returns the value of the '<em><b>Change Packages</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.emfstore.esmodel.versioning.ChangePackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Change Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Change Packages</em>' containment reference list.
	 * @see org.unicase.analyzer.AnalyzerPackage#getProjectAnalysisData_ChangePackages()
	 * @model containment="true"
	 * @generated
	 */
	EList<ChangePackage> getChangePackages();

} // ProjectAnalysisData
