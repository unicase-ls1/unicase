/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.analyzer.iterator;

import org.eclipse.emf.ecore.EObject;

import org.unicase.emfstore.esmodel.ProjectId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Version Iterator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.analyzer.iterator.VersionIterator#getStepLength <em>Step Length</em>}</li>
 *   <li>{@link org.unicase.analyzer.iterator.VersionIterator#getProjectId <em>Project Id</em>}</li>
 *   <li>{@link org.unicase.analyzer.iterator.VersionIterator#isForward <em>Forward</em>}</li>
 *   <li>{@link org.unicase.analyzer.iterator.VersionIterator#isReturnProjectDataCopy <em>Return Project Data Copy</em>}</li>
 *   <li>{@link org.unicase.analyzer.iterator.VersionIterator#getVersionSpecQuery <em>Version Spec Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.analyzer.iterator.IteratorPackage#getVersionIterator()
 * @model
 * @generated
 */
public interface VersionIterator extends EObject {
	/**
	 * Returns the value of the '<em><b>Step Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Length</em>' attribute.
	 * @see #getStepLength()
	 * @generated
	 */
	void setStepLength(int value);

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
	 * @see org.unicase.analyzer.iterator.IteratorPackage#getVersionIterator_ProjectId()
	 * @model containment="true"
	 * @generated
	 */
	ProjectId getProjectId();

	/**
	 * Sets the value of the '{@link org.unicase.analyzer.iterator.VersionIterator#getProjectId <em>Project Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Id</em>' containment reference.
	 * @see #getProjectId()
	 * @generated
	 */
	void setProjectId(ProjectId value);

	/**
	 * Returns the value of the '<em><b>Forward</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forward</em>' attribute isn't clear,
	 * there really should be more of a description here...
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Forward</em>' attribute.
	 * @see #isForward()
	 * @generated
	 */
	void setForward(boolean value);

	/**
	 * Returns the value of the '<em><b>Return Project Data Copy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Project Data Copy</em>' attribute isn't clear,
	 * there really should be more of a description here...
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Project Data Copy</em>' attribute.
	 * @see #isReturnProjectDataCopy()
	 * @generated
	 */
	void setReturnProjectDataCopy(boolean value);

	/**
	 * Returns the value of the '<em><b>Version Spec Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version Spec Query</em>' containment reference isn't clear,
	 * there really should be more of a description here...
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Spec Query</em>' containment reference.
	 * @see #getVersionSpecQuery()
	 * @generated
	 */
	void setVersionSpecQuery(VersionSpecQuery value);

} // VersionIterator
