/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.emfstore.esmodel.EsmodelPackage
 * @generated
 */
public interface EsmodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EsmodelFactory eINSTANCE = org.unicase.emfstore.esmodel.impl.EsmodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Project History</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project History</em>'.
	 * @generated
	 */
	ProjectHistory createProjectHistory();

	/**
	 * Returns a new object of class '<em>Project Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Info</em>'.
	 * @generated
	 */
	ProjectInfo createProjectInfo();

	/**
	 * Returns a new object of class '<em>Session Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Session Id</em>'.
	 * @generated
	 */
	SessionId createSessionId();

	/**
	 * Returns a new object of class '<em>Server Space</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Server Space</em>'.
	 * @generated
	 */
	ServerSpace createServerSpace();

	/**
	 * Returns a new object of class '<em>Project Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Id</em>'.
	 * @generated
	 */
	ProjectId createProjectId();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EsmodelPackage getEsmodelPackage();

} //EsmodelFactory
