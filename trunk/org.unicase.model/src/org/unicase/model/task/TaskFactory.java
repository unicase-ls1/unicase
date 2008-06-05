/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.task;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.model.task.TaskPackage
 * @generated
 */
public interface TaskFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TaskFactory eINSTANCE = org.unicase.model.task.impl.TaskFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Action Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Item</em>'.
	 * @generated
	 */
	ActionItem createActionItem();

	/**
	 * Returns a new object of class '<em>Work Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Work Package</em>'.
	 * @generated
	 */
	WorkPackage createWorkPackage();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TaskPackage getTaskPackage();

} //TaskFactory
