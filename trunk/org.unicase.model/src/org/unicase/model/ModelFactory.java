/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.model.ModelPackage
 * @generated
 */
public interface ModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelFactory eINSTANCE = org.unicase.model.impl.ModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Functional Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Functional Requirement</em>'.
	 * @generated
	 */
	FunctionalRequirement createFunctionalRequirement();

	/**
	 * Returns a new object of class '<em>Leaf Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Leaf Section</em>'.
	 * @generated
	 */
	LeafSection createLeafSection();

	/**
	 * Returns a new object of class '<em>Composite Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Section</em>'.
	 * @generated
	 */
	CompositeSection createCompositeSection();

	/**
	 * Returns a new object of class '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project</em>'.
	 * @generated
	 */
	Project createProject();

	/**
	 * Returns a new object of class '<em>Project Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Id</em>'.
	 * @generated
	 */
	ProjectId createProjectId();

	/**
	 * Returns a new object of class '<em>Element Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element Id</em>'.
	 * @generated
	 */
	ModelElementId createModelElementId();

	/**
	 * Returns a new object of class '<em>Reader Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reader Info</em>'.
	 * @generated
	 */
	ReaderInfo createReaderInfo();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelPackage getModelPackage();
	
	public Project createDummyProject();

} //ModelFactory
