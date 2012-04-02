/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.model.changetracking.patch;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.unicase.model.changetracking.ChangetrackingPackage;

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
 * @see org.unicase.model.changetracking.patch.PatchFactory
 * @model kind="package"
 * @generated
 */
public interface PatchPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "patch";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/changetracking/patch";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.changetracking.patch";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PatchPackage eINSTANCE = org.unicase.model.changetracking.patch.impl.PatchPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.changetracking.patch.impl.PatchChangePackageImpl <em>Change Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.changetracking.patch.impl.PatchChangePackageImpl
	 * @see org.unicase.model.changetracking.patch.impl.PatchPackageImpl#getPatchChangePackage()
	 * @generated
	 */
	int PATCH_CHANGE_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_CHANGE_PACKAGE__NAME = ChangetrackingPackage.CHANGE_PACKAGE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_CHANGE_PACKAGE__DESCRIPTION = ChangetrackingPackage.CHANGE_PACKAGE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_CHANGE_PACKAGE__ANNOTATIONS = ChangetrackingPackage.CHANGE_PACKAGE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_CHANGE_PACKAGE__ATTACHMENTS = ChangetrackingPackage.CHANGE_PACKAGE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_CHANGE_PACKAGE__INCOMING_DOCUMENT_REFERENCES = ChangetrackingPackage.CHANGE_PACKAGE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_CHANGE_PACKAGE__STATE = ChangetrackingPackage.CHANGE_PACKAGE__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_CHANGE_PACKAGE__APPLIED_STEREOTYPE_INSTANCES = ChangetrackingPackage.CHANGE_PACKAGE__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_CHANGE_PACKAGE__COMMENTS = ChangetrackingPackage.CHANGE_PACKAGE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_CHANGE_PACKAGE__CREATION_DATE = ChangetrackingPackage.CHANGE_PACKAGE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_CHANGE_PACKAGE__CREATOR = ChangetrackingPackage.CHANGE_PACKAGE__CREATOR;

	/**
	 * The feature id for the '<em><b>Referring Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_CHANGE_PACKAGE__REFERRING_MODEL_ELEMENTS = ChangetrackingPackage.CHANGE_PACKAGE__REFERRING_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_CHANGE_PACKAGE__SHORT_DESCRIPTION = ChangetrackingPackage.CHANGE_PACKAGE__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_CHANGE_PACKAGE__FILE_NAME = ChangetrackingPackage.CHANGE_PACKAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>File Hash</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_CHANGE_PACKAGE__FILE_HASH = ChangetrackingPackage.CHANGE_PACKAGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>File ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_CHANGE_PACKAGE__FILE_ID = ChangetrackingPackage.CHANGE_PACKAGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>File Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_CHANGE_PACKAGE__FILE_SIZE = ChangetrackingPackage.CHANGE_PACKAGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>File Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_CHANGE_PACKAGE__FILE_TYPE = ChangetrackingPackage.CHANGE_PACKAGE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Change Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_CHANGE_PACKAGE_FEATURE_COUNT = ChangetrackingPackage.CHANGE_PACKAGE_FEATURE_COUNT + 5;


	/**
	 * Returns the meta object for class '{@link org.unicase.model.changetracking.patch.PatchChangePackage <em>Change Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change Package</em>'.
	 * @see org.unicase.model.changetracking.patch.PatchChangePackage
	 * @generated
	 */
	EClass getPatchChangePackage();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PatchFactory getPatchFactory();

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
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.unicase.model.changetracking.patch.impl.PatchChangePackageImpl <em>Change Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.changetracking.patch.impl.PatchChangePackageImpl
		 * @see org.unicase.model.changetracking.patch.impl.PatchPackageImpl#getPatchChangePackage()
		 * @generated
		 */
		EClass PATCH_CHANGE_PACKAGE = eINSTANCE.getPatchChangePackage();

	}

} //PatchPackage
