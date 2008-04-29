/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.esmodel.EsmodelPackage
 * @generated
 */
public interface EsmodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EsmodelFactory eINSTANCE = org.unicase.esmodel.impl.EsmodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Version</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Version</em>'.
	 * @generated
	 */
	Version createVersion();

	/**
	 * Returns a new object of class '<em>Project History</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project History</em>'.
	 * @generated
	 */
	ProjectHistory createProjectHistory();

	/**
	 * Returns a new object of class '<em>Change Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Change Package</em>'.
	 * @generated
	 */
	ChangePackage createChangePackage();

	/**
	 * Returns a new object of class '<em>Project Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Info</em>'.
	 * @generated
	 */
	ProjectInfo createProjectInfo();

	/**
	 * Returns a new object of class '<em>History Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>History Info</em>'.
	 * @generated
	 */
	HistoryInfo createHistoryInfo();

	/**
	 * Returns a new object of class '<em>Session Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Session Id</em>'.
	 * @generated
	 */
	SessionId createSessionId();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EsmodelPackage getEsmodelPackage();

} //EsmodelFactory
