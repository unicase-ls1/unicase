/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.task;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM__IDENTIFIER = ModelPackage.ANNOTATION__IDENTIFIER;

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
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM__STATE = ModelPackage.ANNOTATION__STATE;

	/**
	 * The feature id for the '<em><b>Annotated Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM__ANNOTATED_MODEL_ELEMENTS = ModelPackage.ANNOTATION__ANNOTATED_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Containing Workpackage</b></em>' container reference.
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
	 * The feature id for the '<em><b>Predecessors</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM__PREDECESSORS = ModelPackage.ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Successors</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM__SUCCESSORS = ModelPackage.ANNOTATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Work Item</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_FEATURE_COUNT = ModelPackage.ANNOTATION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.unicase.model.task.impl.ActionItemImpl <em>Action Item</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.task.impl.ActionItemImpl
	 * @see org.unicase.model.task.impl.TaskPackageImpl#getActionItem()
	 * @generated
	 */
	int ACTION_ITEM = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__IDENTIFIER = WORK_ITEM__IDENTIFIER;

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
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__STATE = WORK_ITEM__STATE;

	/**
	 * The feature id for the '<em><b>Annotated Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__ANNOTATED_MODEL_ELEMENTS = WORK_ITEM__ANNOTATED_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Containing Workpackage</b></em>' container reference.
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
	 * The feature id for the '<em><b>Predecessors</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__PREDECESSORS = WORK_ITEM__PREDECESSORS;

	/**
	 * The feature id for the '<em><b>Successors</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__SUCCESSORS = WORK_ITEM__SUCCESSORS;

	/**
	 * The feature id for the '<em><b>Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__CHECKED = WORK_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Assigned To</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__ASSIGNED_TO = WORK_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Due Date</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__DUE_DATE = WORK_ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Done</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__DONE = WORK_ITEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Estimate</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__ESTIMATE = WORK_ITEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM__ACTIVITY = WORK_ITEM_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Action Item</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ITEM_FEATURE_COUNT = WORK_ITEM_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.unicase.model.task.impl.WorkPackageImpl <em>Work Package</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.task.impl.WorkPackageImpl
	 * @see org.unicase.model.task.impl.TaskPackageImpl#getWorkPackage()
	 * @generated
	 */
	int WORK_PACKAGE = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__IDENTIFIER = WORK_ITEM__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__NAME = WORK_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__DESCRIPTION = WORK_ITEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__READER_INFOS = WORK_ITEM__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__ANNOTATIONS = WORK_ITEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__INCOMING_DOCUMENT_REFERENCES = WORK_ITEM__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__LEAF_SECTION = WORK_ITEM__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__STATE = WORK_ITEM__STATE;

	/**
	 * The feature id for the '<em><b>Annotated Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__ANNOTATED_MODEL_ELEMENTS = WORK_ITEM__ANNOTATED_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Containing Workpackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__CONTAINING_WORKPACKAGE = WORK_ITEM__CONTAINING_WORKPACKAGE;

	/**
	 * The feature id for the '<em><b>Associated Change Packages</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__ASSOCIATED_CHANGE_PACKAGES = WORK_ITEM__ASSOCIATED_CHANGE_PACKAGES;

	/**
	 * The feature id for the '<em><b>Predecessors</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__PREDECESSORS = WORK_ITEM__PREDECESSORS;

	/**
	 * The feature id for the '<em><b>Successors</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__SUCCESSORS = WORK_ITEM__SUCCESSORS;

	/**
	 * The feature id for the '<em><b>Contained Work Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__CONTAINED_WORK_ITEMS = WORK_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__START_DATE = WORK_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>End Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE__END_DATE = WORK_ITEM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Work Package</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PACKAGE_FEATURE_COUNT = WORK_ITEM_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.model.task.impl.MeetingImpl <em>Meeting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.task.impl.MeetingImpl
	 * @see org.unicase.model.task.impl.TaskPackageImpl#getMeeting()
	 * @generated
	 */
	int MEETING = 3;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING__READER_INFOS = ModelPackage.MODEL_ELEMENT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING__STATE = ModelPackage.MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING__LOCATION = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING__TIME = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Purpose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING__PURPOSE = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Facilitator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING__FACILITATOR = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Scribe</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING__SCRIBE = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Participants</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING__PARTICIPANTS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Information Exchange</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING__INFORMATION_EXCHANGE = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Discussed Action Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING__DISCUSSED_ACTION_ITEMS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Discussed Issues</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING__DISCUSSED_ISSUES = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Identified Action Items</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING__IDENTIFIED_ACTION_ITEMS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Meeting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link org.unicase.model.task.impl.MilestoneImpl <em>Milestone</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.task.impl.MilestoneImpl
	 * @see org.unicase.model.task.impl.TaskPackageImpl#getMilestone()
	 * @generated
	 */
	int MILESTONE = 4;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILESTONE__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILESTONE__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILESTONE__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILESTONE__READER_INFOS = ModelPackage.MODEL_ELEMENT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILESTONE__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILESTONE__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILESTONE__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILESTONE__STATE = ModelPackage.MODEL_ELEMENT__STATE;

	/**
	 * The number of structural features of the '<em>Milestone</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILESTONE_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.model.task.Checkable <em>Checkable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.task.Checkable
	 * @see org.unicase.model.task.impl.TaskPackageImpl#getCheckable()
	 * @generated
	 */
	int CHECKABLE = 5;

	/**
	 * The feature id for the '<em><b>Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKABLE__CHECKED = 0;

	/**
	 * The number of structural features of the '<em>Checkable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.model.task.ActivityType <em>Activity Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.task.ActivityType
	 * @see org.unicase.model.task.impl.TaskPackageImpl#getActivityType()
	 * @generated
	 */
	int ACTIVITY_TYPE = 6;

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
	 * Returns the meta object for the attribute '{@link org.unicase.model.task.ActionItem#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Activity</em>'.
	 * @see org.unicase.model.task.ActionItem#getActivity()
	 * @see #getActionItem()
	 * @generated
	 */
	EAttribute getActionItem_Activity();

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
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.task.WorkPackage#getContainedWorkItems <em>Contained Work Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contained Work Items</em>'.
	 * @see org.unicase.model.task.WorkPackage#getContainedWorkItems()
	 * @see #getWorkPackage()
	 * @generated
	 */
	EReference getWorkPackage_ContainedWorkItems();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.task.WorkPackage#getStartDate <em>Start Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Date</em>'.
	 * @see org.unicase.model.task.WorkPackage#getStartDate()
	 * @see #getWorkPackage()
	 * @generated
	 */
	EAttribute getWorkPackage_StartDate();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.task.WorkPackage#getEndDate <em>End Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Date</em>'.
	 * @see org.unicase.model.task.WorkPackage#getEndDate()
	 * @see #getWorkPackage()
	 * @generated
	 */
	EAttribute getWorkPackage_EndDate();

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
	 * Returns the meta object for the container reference '{@link org.unicase.model.task.WorkItem#getContainingWorkpackage <em>Containing Workpackage</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Workpackage</em>'.
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
	 * Returns the meta object for the reference '{@link org.unicase.model.task.WorkItem#getPredecessors <em>Predecessors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Predecessors</em>'.
	 * @see org.unicase.model.task.WorkItem#getPredecessors()
	 * @see #getWorkItem()
	 * @generated
	 */
	EReference getWorkItem_Predecessors();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.task.WorkItem#getSuccessors <em>Successors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Successors</em>'.
	 * @see org.unicase.model.task.WorkItem#getSuccessors()
	 * @see #getWorkItem()
	 * @generated
	 */
	EReference getWorkItem_Successors();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.task.Meeting <em>Meeting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meeting</em>'.
	 * @see org.unicase.model.task.Meeting
	 * @generated
	 */
	EClass getMeeting();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.task.Meeting#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.unicase.model.task.Meeting#getLocation()
	 * @see #getMeeting()
	 * @generated
	 */
	EAttribute getMeeting_Location();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.task.Meeting#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see org.unicase.model.task.Meeting#getTime()
	 * @see #getMeeting()
	 * @generated
	 */
	EAttribute getMeeting_Time();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.task.Meeting#getPurpose <em>Purpose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Purpose</em>'.
	 * @see org.unicase.model.task.Meeting#getPurpose()
	 * @see #getMeeting()
	 * @generated
	 */
	EAttribute getMeeting_Purpose();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.task.Meeting#getFacilitator <em>Facilitator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Facilitator</em>'.
	 * @see org.unicase.model.task.Meeting#getFacilitator()
	 * @see #getMeeting()
	 * @generated
	 */
	EReference getMeeting_Facilitator();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.task.Meeting#getScribe <em>Scribe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scribe</em>'.
	 * @see org.unicase.model.task.Meeting#getScribe()
	 * @see #getMeeting()
	 * @generated
	 */
	EReference getMeeting_Scribe();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.task.Meeting#getParticipants <em>Participants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Participants</em>'.
	 * @see org.unicase.model.task.Meeting#getParticipants()
	 * @see #getMeeting()
	 * @generated
	 */
	EReference getMeeting_Participants();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.task.Meeting#getInformationExchange <em>Information Exchange</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Information Exchange</em>'.
	 * @see org.unicase.model.task.Meeting#getInformationExchange()
	 * @see #getMeeting()
	 * @generated
	 */
	EAttribute getMeeting_InformationExchange();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.task.Meeting#getDiscussedActionItems <em>Discussed Action Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Discussed Action Items</em>'.
	 * @see org.unicase.model.task.Meeting#getDiscussedActionItems()
	 * @see #getMeeting()
	 * @generated
	 */
	EReference getMeeting_DiscussedActionItems();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.task.Meeting#getDiscussedIssues <em>Discussed Issues</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Discussed Issues</em>'.
	 * @see org.unicase.model.task.Meeting#getDiscussedIssues()
	 * @see #getMeeting()
	 * @generated
	 */
	EReference getMeeting_DiscussedIssues();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.task.Meeting#getIdentifiedActionItems <em>Identified Action Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identified Action Items</em>'.
	 * @see org.unicase.model.task.Meeting#getIdentifiedActionItems()
	 * @see #getMeeting()
	 * @generated
	 */
	EReference getMeeting_IdentifiedActionItems();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.task.Milestone <em>Milestone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Milestone</em>'.
	 * @see org.unicase.model.task.Milestone
	 * @generated
	 */
	EClass getMilestone();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.task.Checkable <em>Checkable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Checkable</em>'.
	 * @see org.unicase.model.task.Checkable
	 * @generated
	 */
	EClass getCheckable();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.task.Checkable#isChecked <em>Checked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checked</em>'.
	 * @see org.unicase.model.task.Checkable#isChecked()
	 * @see #getCheckable()
	 * @generated
	 */
	EAttribute getCheckable_Checked();

	/**
	 * Returns the meta object for enum '{@link org.unicase.model.task.ActivityType <em>Activity Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Activity Type</em>'.
	 * @see org.unicase.model.task.ActivityType
	 * @generated
	 */
	EEnum getActivityType();

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
		 * The meta object literal for the '<em><b>Activity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_ITEM__ACTIVITY = eINSTANCE.getActionItem_Activity();

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
		 * The meta object literal for the '<em><b>Contained Work Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_PACKAGE__CONTAINED_WORK_ITEMS = eINSTANCE
				.getWorkPackage_ContainedWorkItems();

		/**
		 * The meta object literal for the '<em><b>Start Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORK_PACKAGE__START_DATE = eINSTANCE
				.getWorkPackage_StartDate();

		/**
		 * The meta object literal for the '<em><b>End Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORK_PACKAGE__END_DATE = eINSTANCE.getWorkPackage_EndDate();

		/**
		 * The meta object literal for the '{@link org.unicase.model.task.WorkItem <em>Work Item</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.task.WorkItem
		 * @see org.unicase.model.task.impl.TaskPackageImpl#getWorkItem()
		 * @generated
		 */
		EClass WORK_ITEM = eINSTANCE.getWorkItem();

		/**
		 * The meta object literal for the '<em><b>Containing Workpackage</b></em>' container reference feature.
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

		/**
		 * The meta object literal for the '<em><b>Predecessors</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_ITEM__PREDECESSORS = eINSTANCE
				.getWorkItem_Predecessors();

		/**
		 * The meta object literal for the '<em><b>Successors</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_ITEM__SUCCESSORS = eINSTANCE.getWorkItem_Successors();

		/**
		 * The meta object literal for the '{@link org.unicase.model.task.impl.MeetingImpl <em>Meeting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.task.impl.MeetingImpl
		 * @see org.unicase.model.task.impl.TaskPackageImpl#getMeeting()
		 * @generated
		 */
		EClass MEETING = eINSTANCE.getMeeting();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEETING__LOCATION = eINSTANCE.getMeeting_Location();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEETING__TIME = eINSTANCE.getMeeting_Time();

		/**
		 * The meta object literal for the '<em><b>Purpose</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEETING__PURPOSE = eINSTANCE.getMeeting_Purpose();

		/**
		 * The meta object literal for the '<em><b>Facilitator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEETING__FACILITATOR = eINSTANCE.getMeeting_Facilitator();

		/**
		 * The meta object literal for the '<em><b>Scribe</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEETING__SCRIBE = eINSTANCE.getMeeting_Scribe();

		/**
		 * The meta object literal for the '<em><b>Participants</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEETING__PARTICIPANTS = eINSTANCE.getMeeting_Participants();

		/**
		 * The meta object literal for the '<em><b>Information Exchange</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEETING__INFORMATION_EXCHANGE = eINSTANCE
				.getMeeting_InformationExchange();

		/**
		 * The meta object literal for the '<em><b>Discussed Action Items</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEETING__DISCUSSED_ACTION_ITEMS = eINSTANCE
				.getMeeting_DiscussedActionItems();

		/**
		 * The meta object literal for the '<em><b>Discussed Issues</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEETING__DISCUSSED_ISSUES = eINSTANCE
				.getMeeting_DiscussedIssues();

		/**
		 * The meta object literal for the '<em><b>Identified Action Items</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEETING__IDENTIFIED_ACTION_ITEMS = eINSTANCE
				.getMeeting_IdentifiedActionItems();

		/**
		 * The meta object literal for the '{@link org.unicase.model.task.impl.MilestoneImpl <em>Milestone</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.task.impl.MilestoneImpl
		 * @see org.unicase.model.task.impl.TaskPackageImpl#getMilestone()
		 * @generated
		 */
		EClass MILESTONE = eINSTANCE.getMilestone();

		/**
		 * The meta object literal for the '{@link org.unicase.model.task.Checkable <em>Checkable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.task.Checkable
		 * @see org.unicase.model.task.impl.TaskPackageImpl#getCheckable()
		 * @generated
		 */
		EClass CHECKABLE = eINSTANCE.getCheckable();

		/**
		 * The meta object literal for the '<em><b>Checked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECKABLE__CHECKED = eINSTANCE.getCheckable_Checked();

		/**
		 * The meta object literal for the '{@link org.unicase.model.task.ActivityType <em>Activity Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.task.ActivityType
		 * @see org.unicase.model.task.impl.TaskPackageImpl#getActivityType()
		 * @generated
		 */
		EEnum ACTIVITY_TYPE = eINSTANCE.getActivityType();

	}

} // TaskPackage
