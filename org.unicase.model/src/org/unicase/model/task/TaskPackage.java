/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.task;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.unicase.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.model.task.TaskFactory
 * @model kind="package"
 * @generated
 */
public interface TaskPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "task";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/task";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.task";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TaskPackage eINSTANCE = org.unicase.model.task.impl.TaskPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.task.impl.ActionItemImpl <em>Action Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.task.impl.ActionItemImpl
	 * @see org.unicase.model.task.impl.TaskPackageImpl#getActionItem()
	 * @generated
	 */
	int ACTION_ITEM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__READER_INFOS = ModelPackage.MODEL_ELEMENT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Action Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__ACTION_ITEMS = ModelPackage.MODEL_ELEMENT__ACTION_ITEMS;

	/**
	 * The feature id for the '<em><b>Assigned To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__ASSIGNED_TO = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Due Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__DUE_DATE = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Done</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__DONE = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Estimate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__ESTIMATE = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Action Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link org.unicase.model.task.ActionItem <em>Action Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Item</em>'.
	 * @see org.unicase.model.task.ActionItem
	 * @generated
	 */
	EClass getActionItem();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.task.ActionItem#getAssignedTo <em>Assigned To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Assigned To</em>'.
	 * @see org.unicase.model.task.ActionItem#getAssignedTo()
	 * @see #getActionItem()
	 * @generated
	 */
	EReference getActionItem_AssignedTo();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.task.ActionItem#getDueDate <em>Due Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Due Date</em>'.
	 * @see org.unicase.model.task.ActionItem#getDueDate()
	 * @see #getActionItem()
	 * @generated
	 */
	EAttribute getActionItem_DueDate();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.task.ActionItem#isDone <em>Done</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Done</em>'.
	 * @see org.unicase.model.task.ActionItem#isDone()
	 * @see #getActionItem()
	 * @generated
	 */
	EAttribute getActionItem_Done();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.task.ActionItem#getEstimate <em>Estimate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Estimate</em>'.
	 * @see org.unicase.model.task.ActionItem#getEstimate()
	 * @see #getActionItem()
	 * @generated
	 */
	EAttribute getActionItem_Estimate();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TaskFactory getTaskFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.model.task.impl.ActionItemImpl <em>Action Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.task.impl.ActionItemImpl
		 * @see org.unicase.model.task.impl.TaskPackageImpl#getActionItem()
		 * @generated
		 */
		EClass ACTION_ITEM = eINSTANCE.getActionItem();

		/**
		 * The meta object literal for the '<em><b>Assigned To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_ITEM__ASSIGNED_TO = eINSTANCE.getActionItem_AssignedTo();

		/**
		 * The meta object literal for the '<em><b>Due Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_ITEM__DUE_DATE = eINSTANCE.getActionItem_DueDate();

		/**
		 * The meta object literal for the '<em><b>Done</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_ITEM__DONE = eINSTANCE.getActionItem_Done();

		/**
		 * The meta object literal for the '<em><b>Estimate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_ITEM__ESTIMATE = eINSTANCE.getActionItem_Estimate();

	}

} //TaskPackage
