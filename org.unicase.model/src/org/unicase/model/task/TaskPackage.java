/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
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
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.model.task.TaskFactory
 * @model kind="package"
 * @generated
 */
public interface TaskPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "task";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/task";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.task";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	TaskPackage eINSTANCE = org.unicase.model.task.impl.TaskPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.task.WorkItem <em>Work Item</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.task.WorkItem
	 * @see org.unicase.model.task.impl.TaskPackageImpl#getWorkItem()
	 * @generated
	 */
	int WORK_ITEM = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM__NAME = ModelPackage.ANNOTATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM__DESCRIPTION = ModelPackage.ANNOTATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM__IDENTIFIER = ModelPackage.ANNOTATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM__READER_INFOS = ModelPackage.ANNOTATION__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM__ANNOTATIONS = ModelPackage.ANNOTATION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM__INCOMING_DOCUMENT_REFERENCES = ModelPackage.ANNOTATION__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM__LEAF_SECTION = ModelPackage.ANNOTATION__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>Annotated Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM__ANNOTATED_MODEL_ELEMENTS = ModelPackage.ANNOTATION__ANNOTATED_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Containing Workpackage</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM__CONTAINING_WORKPACKAGE = ModelPackage.ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Associated Change Packages</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM__ASSOCIATED_CHANGE_PACKAGES = ModelPackage.ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Work Item</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_FEATURE_COUNT = ModelPackage.ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.model.task.impl.ActionItemImpl <em>Action Item</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.task.impl.ActionItemImpl
	 * @see org.unicase.model.task.impl.TaskPackageImpl#getActionItem()
	 * @generated
	 */
	int ACTION_ITEM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__NAME = WORK_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__DESCRIPTION = WORK_ITEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__IDENTIFIER = WORK_ITEM__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__READER_INFOS = WORK_ITEM__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__ANNOTATIONS = WORK_ITEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__INCOMING_DOCUMENT_REFERENCES = WORK_ITEM__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__LEAF_SECTION = WORK_ITEM__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>Annotated Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__ANNOTATED_MODEL_ELEMENTS = WORK_ITEM__ANNOTATED_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Containing Workpackage</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__CONTAINING_WORKPACKAGE = WORK_ITEM__CONTAINING_WORKPACKAGE;

	/**
	 * The feature id for the '<em><b>Associated Change Packages</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__ASSOCIATED_CHANGE_PACKAGES = WORK_ITEM__ASSOCIATED_CHANGE_PACKAGES;

	/**
	 * The feature id for the '<em><b>Assigned To</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__ASSIGNED_TO = WORK_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Due Date</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__DUE_DATE = WORK_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Done</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__DONE = WORK_ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Estimate</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__ESTIMATE = WORK_ITEM_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Action Item</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM_FEATURE_COUNT = WORK_ITEM_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.unicase.model.task.impl.WorkPackageImpl <em>Work Package</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.task.impl.WorkPackageImpl
	 * @see org.unicase.model.task.impl.TaskPackageImpl#getWorkPackage()
	 * @generated
	 */
	int WORK_PACKAGE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__READER_INFOS = ModelPackage.MODEL_ELEMENT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>Contained Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Work Package</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.model.task.ActionItem <em>Action Item</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Action Item</em>'.
	 * @see org.unicase.model.task.ActionItem
	 * @generated
	 */
	EClass getActionItem();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.task.ActionItem#getAssignedTo <em>Assigned To</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Assigned To</em>'.
	 * @see org.unicase.model.task.ActionItem#getAssignedTo()
	 * @see #getActionItem()
	 * @generated
	 */
	EReference getActionItem_AssignedTo();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.task.ActionItem#getDueDate <em>Due Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Due Date</em>'.
	 * @see org.unicase.model.task.ActionItem#getDueDate()
	 * @see #getActionItem()
	 * @generated
	 */
	EAttribute getActionItem_DueDate();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.model.task.ActionItem#isDone <em>Done</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Done</em>'.
	 * @see org.unicase.model.task.ActionItem#isDone()
	 * @see #getActionItem()
	 * @generated
	 */
	EAttribute getActionItem_Done();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.task.ActionItem#getEstimate <em>Estimate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Estimate</em>'.
	 * @see org.unicase.model.task.ActionItem#getEstimate()
	 * @see #getActionItem()
	 * @generated
	 */
	EAttribute getActionItem_Estimate();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.model.task.WorkPackage <em>Work Package</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Work Package</em>'.
	 * @see org.unicase.model.task.WorkPackage
	 * @generated
	 */
	EClass getWorkPackage();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.task.WorkPackage#getContainedModelElements <em>Contained Model Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contained Model Elements</em>'.
	 * @see org.unicase.model.task.WorkPackage#getContainedModelElements()
	 * @see #getWorkPackage()
	 * @generated
	 */
	EReference getWorkPackage_ContainedModelElements();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.model.task.WorkItem <em>Work Item</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Work Item</em>'.
	 * @see org.unicase.model.task.WorkItem
	 * @generated
	 */
	EClass getWorkItem();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.task.WorkItem#getContainingWorkpackage <em>Containing Workpackage</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the reference '<em>Containing Workpackage</em>'.
	 * @see org.unicase.model.task.WorkItem#getContainingWorkpackage()
	 * @see #getWorkItem()
	 * @generated
	 */
	EReference getWorkItem_ContainingWorkpackage();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.task.WorkItem#getAssociatedChangePackages <em>Associated Change Packages</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the reference list '<em>Associated Change Packages</em>'.
	 * @see org.unicase.model.task.WorkItem#getAssociatedChangePackages()
	 * @see #getWorkItem()
	 * @generated
	 */
	EReference getWorkItem_AssociatedChangePackages();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TaskFactory getTaskFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.model.task.impl.ActionItemImpl <em>Action Item</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.unicase.model.task.impl.ActionItemImpl
		 * @see org.unicase.model.task.impl.TaskPackageImpl#getActionItem()
		 * @generated
		 */
		EClass ACTION_ITEM = eINSTANCE.getActionItem();

		/**
		 * The meta object literal for the '<em><b>Assigned To</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_ITEM__ASSIGNED_TO = eINSTANCE
				.getActionItem_AssignedTo();

		/**
		 * The meta object literal for the '<em><b>Due Date</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_ITEM__DUE_DATE = eINSTANCE.getActionItem_DueDate();

		/**
		 * The meta object literal for the '<em><b>Done</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_ITEM__DONE = eINSTANCE.getActionItem_Done();

		/**
		 * The meta object literal for the '<em><b>Estimate</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_ITEM__ESTIMATE = eINSTANCE.getActionItem_Estimate();

		/**
		 * The meta object literal for the '{@link org.unicase.model.task.impl.WorkPackageImpl <em>Work Package</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.unicase.model.task.impl.WorkPackageImpl
		 * @see org.unicase.model.task.impl.TaskPackageImpl#getWorkPackage()
		 * @generated
		 */
		EClass WORK_PACKAGE = eINSTANCE.getWorkPackage();

		/**
		 * The meta object literal for the '<em><b>Contained Model Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS = eINSTANCE
				.getWorkPackage_ContainedModelElements();

		/**
		 * The meta object literal for the '{@link org.unicase.model.task.WorkItem <em>Work Item</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.task.WorkItem
		 * @see org.unicase.model.task.impl.TaskPackageImpl#getWorkItem()
		 * @generated
		 */
		EClass WORK_ITEM = eINSTANCE.getWorkItem();

		/**
		 * The meta object literal for the '<em><b>Containing Workpackage</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_ITEM__CONTAINING_WORKPACKAGE = eINSTANCE
				.getWorkItem_ContainingWorkpackage();

		/**
		 * The meta object literal for the '<em><b>Associated Change Packages</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_ITEM__ASSOCIATED_CHANGE_PACKAGES = eINSTANCE
				.getWorkItem_AssociatedChangePackages();

	}

} // TaskPackage
