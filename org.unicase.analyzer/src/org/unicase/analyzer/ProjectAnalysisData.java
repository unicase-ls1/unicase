/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.metamodel.Project;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Project Analysis Data</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.analyzer.ProjectAnalysisData#getProjectState <em>Project State</em>}</li>
 *   <li>{@link org.unicase.analyzer.ProjectAnalysisData#getChangePackages <em>Change Packages</em>}</li>
 *   <li>{@link org.unicase.analyzer.ProjectAnalysisData#getPrimaryVersionSpec <em>Primary Version Spec</em>}</li>
 *   <li>{@link org.unicase.analyzer.ProjectAnalysisData#getProjectId <em>Project Id</em>}</li>
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
	 * If the meaning of the '<em>Project State</em>' containment reference isn't clear, there really should be more of
	 * a description here...
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * If the meaning of the '<em>Change Packages</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Change Packages</em>' containment reference list.
	 * @see org.unicase.analyzer.AnalyzerPackage#getProjectAnalysisData_ChangePackages()
	 * @model containment="true"
	 * @generated
	 */
	EList<ChangePackage> getChangePackages();

	/**
	 * Returns the value of the '<em><b>Primary Version Spec</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Version Spec</em>' containment reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Version Spec</em>' containment reference.
	 * @see #setPrimaryVersionSpec(PrimaryVersionSpec)
	 * @see org.unicase.analyzer.AnalyzerPackage#getProjectAnalysisData_PrimaryVersionSpec()
	 * @model containment="true"
	 * @generated
	 */
	PrimaryVersionSpec getPrimaryVersionSpec();

	/**
	 * Sets the value of the '{@link org.unicase.analyzer.ProjectAnalysisData#getPrimaryVersionSpec <em>Primary Version Spec</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Version Spec</em>' containment reference.
	 * @see #getPrimaryVersionSpec()
	 * @generated
	 */
	void setPrimaryVersionSpec(PrimaryVersionSpec value);

	/**
	 * Returns the value of the '<em><b>Project Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Id</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Id</em>' reference.
	 * @see #setProjectId(ProjectId)
	 * @see org.unicase.analyzer.AnalyzerPackage#getProjectAnalysisData_ProjectId()
	 * @model
	 * @generated
	 */
	ProjectId getProjectId();

	/**
	 * Sets the value of the '{@link org.unicase.analyzer.ProjectAnalysisData#getProjectId <em>Project Id</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Id</em>' reference.
	 * @see #getProjectId()
	 * @generated
	 */
	void setProjectId(ProjectId value);

} // ProjectAnalysisData
