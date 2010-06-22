/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.test.testmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.workspace.test.testmodel.TestmodelPackage
 * @generated
 */
public interface TestmodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestmodelFactory eINSTANCE = org.unicase.workspace.test.testmodel.impl.TestmodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Test Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Element</em>'.
	 * @generated
	 */
	TestElement createTestElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TestmodelPackage getTestmodelPackage();

} //TestmodelFactory
