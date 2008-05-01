/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel.changemanagment;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.esmodel.changemanagment.ChangemanagmentPackage
 * @generated
 */
public interface ChangemanagmentFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ChangemanagmentFactory eINSTANCE = org.unicase.esmodel.changemanagment.impl.ChangemanagmentFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Tag Version Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tag Version Spec</em>'.
	 * @generated
	 */
	TagVersionSpec createTagVersionSpec();

	/**
	 * Returns a new object of class '<em>Date Version Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Date Version Spec</em>'.
	 * @generated
	 */
	DateVersionSpec createDateVersionSpec();

	/**
	 * Returns a new object of class '<em>Primary Version Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primary Version Spec</em>'.
	 * @generated
	 */
	PrimaryVersionSpec createPrimaryVersionSpec();

	/**
	 * Returns a new object of class '<em>Log Message</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Log Message</em>'.
	 * @generated
	 */
	LogMessage createLogMessage();

	/**
	 * Returns a new object of class '<em>Change Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Change Package</em>'.
	 * @generated
	 */
	ChangePackage createChangePackage();

	/**
	 * Returns a new object of class '<em>History Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>History Info</em>'.
	 * @generated
	 */
	HistoryInfo createHistoryInfo();

	/**
	 * Returns a new object of class '<em>Version</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Version</em>'.
	 * @generated
	 */
	Version createVersion();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ChangemanagmentPackage getChangemanagmentPackage();

} //ChangemanagmentFactory
