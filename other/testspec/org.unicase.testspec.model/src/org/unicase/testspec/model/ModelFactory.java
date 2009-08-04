/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.testspec.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.testspec.model.ModelPackage
 * @generated
 */
public interface ModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelFactory eINSTANCE = org.unicase.testspec.model.impl.ModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Test Protocol</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Protocol</em>'.
	 * @generated
	 */
	TestProtocol createTestProtocol();

	/**
	 * Returns a new object of class '<em>Logical Test Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Logical Test Case</em>'.
	 * @generated
	 */
	LogicalTestCase createLogicalTestCase();

	/**
	 * Returns a new object of class '<em>Test Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Step</em>'.
	 * @generated
	 */
	TestStep createTestStep();

	/**
	 * Returns a new object of class '<em>Input Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Parameter</em>'.
	 * @generated
	 */
	InputParameter createInputParameter();

	/**
	 * Returns a new object of class '<em>Output Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Parameter</em>'.
	 * @generated
	 */
	OutputParameter createOutputParameter();

	/**
	 * Returns a new object of class '<em>Concrete Input Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concrete Input Parameter</em>'.
	 * @generated
	 */
	ConcreteInputParameter createConcreteInputParameter();

	/**
	 * Returns a new object of class '<em>Concrete Output Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concrete Output Parameter</em>'.
	 * @generated
	 */
	ConcreteOutputParameter createConcreteOutputParameter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelPackage getModelPackage();

} //ModelFactory
