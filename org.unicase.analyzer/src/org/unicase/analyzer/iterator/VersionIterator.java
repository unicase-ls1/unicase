/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.iterator;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.connectionmanager.ConnectionManager;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Version Iterator</b></em>'.
 * 
 * @implements Iterator<ProjectAnalysisData> <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.analyzer.iterator.VersionIterator#getStepLength <em>Step Length</em>}</li>
 *   <li>{@link org.unicase.analyzer.iterator.VersionIterator#getProjectId <em>Project Id</em>}</li>
 *   <li>{@link org.unicase.analyzer.iterator.VersionIterator#isForward <em>Forward</em>}</li>
 *   <li>{@link org.unicase.analyzer.iterator.VersionIterator#isReturnProjectDataCopy <em>Return Project Data Copy</em>}</li>
 *   <li>{@link org.unicase.analyzer.iterator.VersionIterator#getVersionSpecQuery <em>Version Spec Query</em>}</li>
 *   <li>{@link org.unicase.analyzer.iterator.VersionIterator#isDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.analyzer.iterator.IteratorPackage#getVersionIterator()
 * @model
 * @generated
 */
public interface VersionIterator extends EObject, Iterator<ProjectAnalysisData> {
	/**
	 * Returns the value of the '<em><b>Step Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Length</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Length</em>' attribute.
	 * @see #setStepLength(int)
	 * @see org.unicase.analyzer.iterator.IteratorPackage#getVersionIterator_StepLength()
	 * @model
	 * @generated
	 */
	int getStepLength();

	/**
	 * Sets the value of the '{@link org.unicase.analyzer.iterator.VersionIterator#getStepLength <em>Step Length</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Length</em>' attribute.
	 * @see #getStepLength()
	 * @generated
	 */
	void setStepLength(int value);

	/**
	 * Returns the value of the '<em><b>Project Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Id</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Id</em>' containment reference.
	 * @see #setProjectId(ProjectId)
	 * @see org.unicase.analyzer.iterator.IteratorPackage#getVersionIterator_ProjectId()
	 * @model containment="true"
	 * @generated
	 */
	ProjectId getProjectId();

	/**
	 * Sets the value of the '{@link org.unicase.analyzer.iterator.VersionIterator#getProjectId <em>Project Id</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Id</em>' containment reference.
	 * @see #getProjectId()
	 * @generated
	 */
	void setProjectId(ProjectId value);

	/**
	 * Returns the value of the '<em><b>Forward</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forward</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forward</em>' attribute.
	 * @see #setForward(boolean)
	 * @see org.unicase.analyzer.iterator.IteratorPackage#getVersionIterator_Forward()
	 * @model
	 * @generated
	 */
	boolean isForward();

	/**
	 * Sets the value of the '{@link org.unicase.analyzer.iterator.VersionIterator#isForward <em>Forward</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Forward</em>' attribute.
	 * @see #isForward()
	 * @generated
	 */
	void setForward(boolean value);

	/**
	 * Returns the value of the '<em><b>Return Project Data Copy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Project Data Copy</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Project Data Copy</em>' attribute.
	 * @see #setReturnProjectDataCopy(boolean)
	 * @see org.unicase.analyzer.iterator.IteratorPackage#getVersionIterator_ReturnProjectDataCopy()
	 * @model
	 * @generated
	 */
	boolean isReturnProjectDataCopy();

	/**
	 * Sets the value of the '{@link org.unicase.analyzer.iterator.VersionIterator#isReturnProjectDataCopy <em>Return Project Data Copy</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Project Data Copy</em>' attribute.
	 * @see #isReturnProjectDataCopy()
	 * @generated
	 */
	void setReturnProjectDataCopy(boolean value);

	/**
	 * Returns the value of the '<em><b>Version Spec Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version Spec Query</em>' containment reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version Spec Query</em>' containment reference.
	 * @see #setVersionSpecQuery(VersionSpecQuery)
	 * @see org.unicase.analyzer.iterator.IteratorPackage#getVersionIterator_VersionSpecQuery()
	 * @model containment="true"
	 * @generated
	 */
	VersionSpecQuery getVersionSpecQuery();

	/**
	 * Sets the value of the '{@link org.unicase.analyzer.iterator.VersionIterator#getVersionSpecQuery <em>Version Spec Query</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Spec Query</em>' containment reference.
	 * @see #getVersionSpecQuery()
	 * @generated
	 */
	void setVersionSpecQuery(VersionSpecQuery value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(boolean)
	 * @see org.unicase.analyzer.iterator.IteratorPackage#getVersionIterator_Default()
	 * @model
	 * @generated
	 */
	boolean isDefault();

	/**
	 * Sets the value of the '{@link org.unicase.analyzer.iterator.VersionIterator#isDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #isDefault()
	 * @generated
	 */
	void setDefault(boolean value);

	public boolean hasNext();

	public ProjectAnalysisData next();

	public void remove();

	/**
	 * By default, the iterator will go through from version 0 to Head version, and the next() method will return the
	 * copy of ProjectAnalysisData instead of ProjectAnalysisData.
	 * 
	 * @param usersession the session id for authentication
	 * @param projectId the project id of the project to get
	 * @param stepLength the step length for the iterator to go through to the next
	 * @throws IteratorException if any error occurs
	 * @generated NOT
	 */

	void init(Usersession usersession, ProjectId projectId, int stepLength) throws IteratorException;

	/**
	 * @param usersession the session id for authentication
	 * @param projectId the project id of the project to get
	 * @param stepLength the step length for the iterator to go through to the next
	 * @param versionSpecQuery the version query for the iterator from start till the end
	 * @param isForward the direction for the iterator go through, either forward(true) or backward(false) However,
	 *            doesn't work for backward currently, will be solved in the near future
	 * @param returnProjectDataCopy the next() method will return the copy of ProjectAnalysisData when it is set to true
	 * @throws IteratorException if any error occurs
	 * @generated NOT
	 */

	void init(Usersession usersession, ProjectId projectId, int stepLength, VersionSpecQuery versionSpecQuery,
		boolean isForward, boolean returnProjectDataCopy) throws IteratorException;

	/**
	 * Initialize the iterator, have to set at least ProjectId and StepLength to start the iterator, or choose to use
	 * other init() methods.
	 * 
	 * @param usersession got after login
	 * @throws IteratorException if any error occurs
	 */
	void init(Usersession usersession) throws IteratorException;

	/**
	 * @return the connectionManager
	 */
	ConnectionManager getConnectionManager();

	/**
	 * @return the usersession
	 */
	Usersession getUsersession();
} // VersionIterator
