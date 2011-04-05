/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.iterator;

import java.util.Date;

import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.workspace.Usersession;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Time Iterator</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.analyzer.iterator.TimeIterator#getStartDate <em>Start Date</em>}</li>
 * <li>{@link org.unicase.analyzer.iterator.TimeIterator#getEndDate <em>End Date</em>}</li>
 * <li>{@link org.unicase.analyzer.iterator.TimeIterator#getStepLengthUnit <em>Step Length Unit</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.analyzer.iterator.IteratorPackage#getTimeIterator()
 * @model
 * @generated
 */
public interface TimeIterator extends VersionIterator {
	/**
	 * Returns the value of the '<em><b>Start Date</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Date</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Start Date</em>' attribute.
	 * @see #setStartDate(Date)
	 * @see org.unicase.analyzer.iterator.IteratorPackage#getTimeIterator_StartDate()
	 * @model
	 * @generated
	 */
	Date getStartDate();

	/**
	 * Sets the value of the '{@link org.unicase.analyzer.iterator.TimeIterator#getStartDate <em>Start Date</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Start Date</em>' attribute.
	 * @see #getStartDate()
	 * @generated
	 */
	void setStartDate(Date value);

	/**
	 * Returns the value of the '<em><b>End Date</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Date</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>End Date</em>' attribute.
	 * @see #setEndDate(Date)
	 * @see org.unicase.analyzer.iterator.IteratorPackage#getTimeIterator_EndDate()
	 * @model
	 * @generated
	 */
	Date getEndDate();

	/**
	 * Sets the value of the '{@link org.unicase.analyzer.iterator.TimeIterator#getEndDate <em>End Date</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>End Date</em>' attribute.
	 * @see #getEndDate()
	 * @generated
	 */
	void setEndDate(Date value);

	/**
	 * Returns the value of the '<em><b>Step Length Unit</b></em>' attribute. The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Length Unit</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Step Length Unit</em>' attribute.
	 * @see #setStepLengthUnit(int)
	 * @see org.unicase.analyzer.iterator.IteratorPackage#getTimeIterator_StepLengthUnit()
	 * @model default="1"
	 * @generated
	 */
	int getStepLengthUnit();

	/**
	 * Sets the value of the '{@link org.unicase.analyzer.iterator.TimeIterator#getStepLengthUnit
	 * <em>Step Length Unit</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Step Length Unit</em>' attribute.
	 * @see #getStepLengthUnit()
	 * @generated
	 */
	void setStepLengthUnit(int value);

	/**
	 * By default, the iterator will go through from version 0 to Head version, and the next() method will return the
	 * copy of ProjectAnalysisData instead of ProjectAnalysisData.
	 * 
	 * @param usersession the session id for authentication
	 * @param projectId the project id of the project to get
	 * @param stepLength the step length for the iterator to go through to the next
	 * @param stepLengthUnit the unit of time step length based on Calendar's static field, e.g. Calendar.SECOND
	 * @throws IteratorException if any error occurs
	 * @generated NOT
	 */
	void init(Usersession usersession, ProjectId projectId, int stepLength, int stepLengthUnit)
		throws IteratorException;

} // TimeIterator
