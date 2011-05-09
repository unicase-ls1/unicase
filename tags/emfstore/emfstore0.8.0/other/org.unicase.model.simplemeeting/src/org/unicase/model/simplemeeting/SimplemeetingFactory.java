/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.simplemeeting;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.model.simplemeeting.SimplemeetingPackage
 * @generated
 */
public interface SimplemeetingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimplemeetingFactory eINSTANCE = org.unicase.model.simplemeeting.impl.SimplemeetingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Simple Meeting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Meeting</em>'.
	 * @generated
	 */
	SimpleMeeting createSimpleMeeting();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SimplemeetingPackage getSimplemeetingPackage();

} //SimplemeetingFactory
