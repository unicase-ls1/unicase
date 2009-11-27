/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.implementation.operations;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.implementation.operations.OperationsPackage
 * @generated
 */
public interface OperationsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OperationsFactory eINSTANCE = org.unicase.implementation.operations.impl.OperationsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Extract Super Class Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extract Super Class Operation</em>'.
	 * @generated
	 */
	ExtractSuperClassOperation createExtractSuperClassOperation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OperationsPackage getOperationsPackage();

} //OperationsFactory
