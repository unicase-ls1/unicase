/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.testspec;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.model.testspec.TestspecPackage
 * @generated
 */
public interface TestspecFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	TestspecFactory eINSTANCE = org.unicase.model.testspec.impl.TestspecFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Test Protocol</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Test Protocol</em>'.
     * @generated
     */
	TestProtocol createTestProtocol();

	/**
     * Returns a new object of class '<em>Test Case</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Test Case</em>'.
     * @generated
     */
	TestCase createTestCase();

	/**
     * Returns a new object of class '<em>Test Step</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Test Step</em>'.
     * @generated
     */
	TestStep createTestStep();

	/**
     * Returns a new object of class '<em>Test Step Input</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Test Step Input</em>'.
     * @generated
     */
	TestStepInput createTestStepInput();

	/**
     * Returns a new object of class '<em>Test Step Output</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Test Step Output</em>'.
     * @generated
     */
	TestStepOutput createTestStepOutput();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	TestspecPackage getTestspecPackage();

} //TestspecFactory
