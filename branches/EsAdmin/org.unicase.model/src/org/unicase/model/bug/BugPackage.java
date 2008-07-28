/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.bug;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.unicase.model.ModelPackage;
import org.unicase.model.task.TaskPackage;

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
 * @see org.unicase.model.bug.BugFactory
 * @model kind="package"
 * @generated
 */
public interface BugPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "bug";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/bug";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.bug";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	BugPackage eINSTANCE = org.unicase.model.bug.impl.BugPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.bug.impl.BugReportImpl <em>Report</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.bug.impl.BugReportImpl
	 * @see org.unicase.model.bug.impl.BugPackageImpl#getBugReport()
	 * @generated
	 */
	int BUG_REPORT = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUG_REPORT__IDENTIFIER = TaskPackage.WORK_ITEM__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUG_REPORT__NAME = TaskPackage.WORK_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUG_REPORT__DESCRIPTION = TaskPackage.WORK_ITEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUG_REPORT__READER_INFOS = TaskPackage.WORK_ITEM__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUG_REPORT__ANNOTATIONS = TaskPackage.WORK_ITEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUG_REPORT__INCOMING_DOCUMENT_REFERENCES = TaskPackage.WORK_ITEM__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUG_REPORT__LEAF_SECTION = TaskPackage.WORK_ITEM__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>Annotated Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUG_REPORT__ANNOTATED_MODEL_ELEMENTS = TaskPackage.WORK_ITEM__ANNOTATED_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Containing Workpackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUG_REPORT__CONTAINING_WORKPACKAGE = TaskPackage.WORK_ITEM__CONTAINING_WORKPACKAGE;

	/**
	 * The feature id for the '<em><b>Associated Change Packages</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUG_REPORT__ASSOCIATED_CHANGE_PACKAGES = TaskPackage.WORK_ITEM__ASSOCIATED_CHANGE_PACKAGES;

	/**
	 * The feature id for the '<em><b>Steps To Reproduce</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUG_REPORT__STEPS_TO_REPRODUCE = TaskPackage.WORK_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUG_REPORT__STATUS = TaskPackage.WORK_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Assigned To</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUG_REPORT__ASSIGNED_TO = TaskPackage.WORK_ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resolution</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUG_REPORT__RESOLUTION = TaskPackage.WORK_ITEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUG_REPORT__SEVERITY = TaskPackage.WORK_ITEM_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Report</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUG_REPORT_FEATURE_COUNT = TaskPackage.WORK_ITEM_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.unicase.model.bug.impl.BugResolutionImpl <em>Resolution</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.bug.impl.BugResolutionImpl
	 * @see org.unicase.model.bug.impl.BugPackageImpl#getBugResolution()
	 * @generated
	 */
	int BUG_RESOLUTION = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUG_RESOLUTION__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUG_RESOLUTION__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUG_RESOLUTION__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUG_RESOLUTION__READER_INFOS = ModelPackage.MODEL_ELEMENT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUG_RESOLUTION__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUG_RESOLUTION__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUG_RESOLUTION__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>Resoultion Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUG_RESOLUTION__RESOULTION_TYPE = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resolution</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUG_RESOLUTION_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.model.bug.BugStatus <em>Status</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.bug.BugStatus
	 * @see org.unicase.model.bug.impl.BugPackageImpl#getBugStatus()
	 * @generated
	 */
	int BUG_STATUS = 2;

	/**
	 * The meta object id for the '{@link org.unicase.model.bug.Severity <em>Severity</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.bug.Severity
	 * @see org.unicase.model.bug.impl.BugPackageImpl#getSeverity()
	 * @generated
	 */
	int SEVERITY = 3;

	/**
	 * The meta object id for the '{@link org.unicase.model.bug.ResolutionType <em>Resolution Type</em>}' enum.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.unicase.model.bug.ResolutionType
	 * @see org.unicase.model.bug.impl.BugPackageImpl#getResolutionType()
	 * @generated
	 */
	int RESOLUTION_TYPE = 4;

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.model.bug.BugReport <em>Report</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Report</em>'.
	 * @see org.unicase.model.bug.BugReport
	 * @generated
	 */
	EClass getBugReport();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.bug.BugReport#getStepsToReproduce
	 * <em>Steps To Reproduce</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference list '
	 *         <em>Steps To Reproduce</em>'.
	 * @see org.unicase.model.bug.BugReport#getStepsToReproduce()
	 * @see #getBugReport()
	 * @generated
	 */
	EReference getBugReport_StepsToReproduce();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.model.bug.BugReport#getStatus <em>Status</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.unicase.model.bug.BugReport#getStatus()
	 * @see #getBugReport()
	 * @generated
	 */
	EAttribute getBugReport_Status();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.bug.BugReport#getAssignedTo <em>Assigned To</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assigned To</em>'.
	 * @see org.unicase.model.bug.BugReport#getAssignedTo()
	 * @see #getBugReport()
	 * @generated
	 */
	EReference getBugReport_AssignedTo();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.bug.BugReport#getResolution <em>Resolution</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resolution</em>'.
	 * @see org.unicase.model.bug.BugReport#getResolution()
	 * @see #getBugReport()
	 * @generated
	 */
	EReference getBugReport_Resolution();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.bug.BugReport#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.unicase.model.bug.BugReport#getSeverity()
	 * @see #getBugReport()
	 * @generated
	 */
	EAttribute getBugReport_Severity();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.model.bug.BugResolution <em>Resolution</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Resolution</em>'.
	 * @see org.unicase.model.bug.BugResolution
	 * @generated
	 */
	EClass getBugResolution();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.bug.BugResolution#getResoultionType <em>Resoultion Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resoultion Type</em>'.
	 * @see org.unicase.model.bug.BugResolution#getResoultionType()
	 * @see #getBugResolution()
	 * @generated
	 */
	EAttribute getBugResolution_ResoultionType();

	/**
	 * Returns the meta object for enum '{@link org.unicase.model.bug.BugStatus <em>Status</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Status</em>'.
	 * @see org.unicase.model.bug.BugStatus
	 * @generated
	 */
	EEnum getBugStatus();

	/**
	 * Returns the meta object for enum '{@link org.unicase.model.bug.Severity <em>Severity</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Severity</em>'.
	 * @see org.unicase.model.bug.Severity
	 * @generated
	 */
	EEnum getSeverity();

	/**
	 * Returns the meta object for enum '{@link org.unicase.model.bug.ResolutionType <em>Resolution Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Resolution Type</em>'.
	 * @see org.unicase.model.bug.ResolutionType
	 * @generated
	 */
	EEnum getResolutionType();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BugFactory getBugFactory();

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
		 * The meta object literal for the '{@link org.unicase.model.bug.impl.BugReportImpl <em>Report</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.bug.impl.BugReportImpl
		 * @see org.unicase.model.bug.impl.BugPackageImpl#getBugReport()
		 * @generated
		 */
		EClass BUG_REPORT = eINSTANCE.getBugReport();

		/**
		 * The meta object literal for the '<em><b>Steps To Reproduce</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUG_REPORT__STEPS_TO_REPRODUCE = eINSTANCE
				.getBugReport_StepsToReproduce();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUG_REPORT__STATUS = eINSTANCE.getBugReport_Status();

		/**
		 * The meta object literal for the '<em><b>Assigned To</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUG_REPORT__ASSIGNED_TO = eINSTANCE
				.getBugReport_AssignedTo();

		/**
		 * The meta object literal for the '<em><b>Resolution</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUG_REPORT__RESOLUTION = eINSTANCE.getBugReport_Resolution();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUG_REPORT__SEVERITY = eINSTANCE.getBugReport_Severity();

		/**
		 * The meta object literal for the '{@link org.unicase.model.bug.impl.BugResolutionImpl <em>Resolution</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.unicase.model.bug.impl.BugResolutionImpl
		 * @see org.unicase.model.bug.impl.BugPackageImpl#getBugResolution()
		 * @generated
		 */
		EClass BUG_RESOLUTION = eINSTANCE.getBugResolution();

		/**
		 * The meta object literal for the '<em><b>Resoultion Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUG_RESOLUTION__RESOULTION_TYPE = eINSTANCE
				.getBugResolution_ResoultionType();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.model.bug.BugStatus <em>Status</em>}' enum. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.bug.BugStatus
		 * @see org.unicase.model.bug.impl.BugPackageImpl#getBugStatus()
		 * @generated
		 */
		EEnum BUG_STATUS = eINSTANCE.getBugStatus();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.model.bug.Severity <em>Severity</em>}' enum. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.bug.Severity
		 * @see org.unicase.model.bug.impl.BugPackageImpl#getSeverity()
		 * @generated
		 */
		EEnum SEVERITY = eINSTANCE.getSeverity();

		/**
		 * The meta object literal for the '{@link org.unicase.model.bug.ResolutionType <em>Resolution Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.bug.ResolutionType
		 * @see org.unicase.model.bug.impl.BugPackageImpl#getResolutionType()
		 * @generated
		 */
		EEnum RESOLUTION_TYPE = eINSTANCE.getResolutionType();

	}

} // BugPackage
