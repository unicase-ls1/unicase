/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.operations;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.emfstore.common.model.ModelPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsFactory
 * @model kind="package"
 * @generated
 */
public interface OperationsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "operations";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/emf/emfstore/server/model/versioning/operations";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.emf.emfstore.server.model.versioning.operations";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	OperationsPackage eINSTANCE = org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl
		.init();

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.AbstractOperationImpl
	 * <em>Abstract Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.AbstractOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getAbstractOperation()
	 * @generated
	 */
	int ABSTRACT_OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OPERATION__IDENTIFIER = ModelPackage.IDENTIFIABLE_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OPERATION__NAME = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OPERATION__DESCRIPTION = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OPERATION__MODEL_ELEMENT_ID = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OPERATION__ACCEPTED = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OPERATION__CLIENT_DATE = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Abstract Operation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OPERATION_FEATURE_COUNT = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.CompositeOperationImpl
	 * <em>Composite Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.CompositeOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getCompositeOperation()
	 * @generated
	 */
	int COMPOSITE_OPERATION = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__IDENTIFIER = ABSTRACT_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__NAME = ABSTRACT_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__DESCRIPTION = ABSTRACT_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__MODEL_ELEMENT_ID = ABSTRACT_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__ACCEPTED = ABSTRACT_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__CLIENT_DATE = ABSTRACT_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Sub Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__SUB_OPERATIONS = ABSTRACT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Main Operation</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__MAIN_OPERATION = ABSTRACT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Composite Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__COMPOSITE_NAME = ABSTRACT_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Composite Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION = ABSTRACT_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Reversed</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__REVERSED = ABSTRACT_OPERATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Composite Operation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION_FEATURE_COUNT = ABSTRACT_OPERATION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.FeatureOperationImpl
	 * <em>Feature Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.FeatureOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getFeatureOperation()
	 * @generated
	 */
	int FEATURE_OPERATION = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION__IDENTIFIER = ABSTRACT_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION__NAME = ABSTRACT_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION__DESCRIPTION = ABSTRACT_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION__MODEL_ELEMENT_ID = ABSTRACT_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION__ACCEPTED = ABSTRACT_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION__CLIENT_DATE = ABSTRACT_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION__FEATURE_NAME = ABSTRACT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Operation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION_FEATURE_COUNT = ABSTRACT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.CreateDeleteOperationImpl
	 * <em>Create Delete Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.CreateDeleteOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getCreateDeleteOperation()
	 * @generated
	 */
	int CREATE_DELETE_OPERATION = 3;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATE_DELETE_OPERATION__IDENTIFIER = ABSTRACT_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATE_DELETE_OPERATION__NAME = ABSTRACT_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATE_DELETE_OPERATION__DESCRIPTION = ABSTRACT_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATE_DELETE_OPERATION__MODEL_ELEMENT_ID = ABSTRACT_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATE_DELETE_OPERATION__ACCEPTED = ABSTRACT_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATE_DELETE_OPERATION__CLIENT_DATE = ABSTRACT_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Delete</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATE_DELETE_OPERATION__DELETE = ABSTRACT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATE_DELETE_OPERATION__MODEL_ELEMENT = ABSTRACT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sub Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATE_DELETE_OPERATION__SUB_OPERATIONS = ABSTRACT_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>EObject To Id Map</b></em>' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATE_DELETE_OPERATION__EOBJECT_TO_ID_MAP = ABSTRACT_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Create Delete Operation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATE_DELETE_OPERATION_FEATURE_COUNT = ABSTRACT_OPERATION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.AttributeOperationImpl
	 * <em>Attribute Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.AttributeOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getAttributeOperation()
	 * @generated
	 */
	int ATTRIBUTE_OPERATION = 4;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION__IDENTIFIER = FEATURE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION__NAME = FEATURE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION__DESCRIPTION = FEATURE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION__MODEL_ELEMENT_ID = FEATURE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION__ACCEPTED = FEATURE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION__CLIENT_DATE = FEATURE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION__FEATURE_NAME = FEATURE_OPERATION__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION__OLD_VALUE = FEATURE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION__NEW_VALUE = FEATURE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute Operation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_FEATURE_COUNT = FEATURE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiAttributeOperationImpl
	 * <em>Multi Attribute Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiAttributeOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getMultiAttributeOperation()
	 * @generated
	 */
	int MULTI_ATTRIBUTE_OPERATION = 5;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION__IDENTIFIER = FEATURE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION__NAME = FEATURE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION__DESCRIPTION = FEATURE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION__MODEL_ELEMENT_ID = FEATURE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION__ACCEPTED = FEATURE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION__CLIENT_DATE = FEATURE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION__FEATURE_NAME = FEATURE_OPERATION__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Add</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION__ADD = FEATURE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Indexes</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION__INDEXES = FEATURE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referenced Values</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION__REFERENCED_VALUES = FEATURE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Multi Attribute Operation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION_FEATURE_COUNT = FEATURE_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiAttributeSetOperationImpl
	 * <em>Multi Attribute Set Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiAttributeSetOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getMultiAttributeSetOperation()
	 * @generated
	 */
	int MULTI_ATTRIBUTE_SET_OPERATION = 6;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_SET_OPERATION__IDENTIFIER = FEATURE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_SET_OPERATION__NAME = FEATURE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_SET_OPERATION__DESCRIPTION = FEATURE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_SET_OPERATION__MODEL_ELEMENT_ID = FEATURE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_SET_OPERATION__ACCEPTED = FEATURE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_SET_OPERATION__CLIENT_DATE = FEATURE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_SET_OPERATION__FEATURE_NAME = FEATURE_OPERATION__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_SET_OPERATION__INDEX = FEATURE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_SET_OPERATION__OLD_VALUE = FEATURE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_SET_OPERATION__NEW_VALUE = FEATURE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Multi Attribute Set Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_SET_OPERATION_FEATURE_COUNT = FEATURE_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiAttributeMoveOperationImpl
	 * <em>Multi Attribute Move Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiAttributeMoveOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getMultiAttributeMoveOperation()
	 * @generated
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION = 7;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION__IDENTIFIER = FEATURE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION__NAME = FEATURE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION__DESCRIPTION = FEATURE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION__MODEL_ELEMENT_ID = FEATURE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION__ACCEPTED = FEATURE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION__CLIENT_DATE = FEATURE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION__FEATURE_NAME = FEATURE_OPERATION__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Old Index</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION__OLD_INDEX = FEATURE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Index</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION__NEW_INDEX = FEATURE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referenced Value</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION__REFERENCED_VALUE = FEATURE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Multi Attribute Move Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION_FEATURE_COUNT = FEATURE_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.ReferenceOperationImpl
	 * <em>Reference Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.ReferenceOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getReferenceOperation()
	 * @generated
	 */
	int REFERENCE_OPERATION = 12;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION__IDENTIFIER = FEATURE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION__NAME = FEATURE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION__DESCRIPTION = FEATURE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION__MODEL_ELEMENT_ID = FEATURE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION__ACCEPTED = FEATURE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION__CLIENT_DATE = FEATURE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION__FEATURE_NAME = FEATURE_OPERATION__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Bidirectional</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION__BIDIRECTIONAL = FEATURE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Opposite Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION__OPPOSITE_FEATURE_NAME = FEATURE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Containment Type</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION__CONTAINMENT_TYPE = FEATURE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Reference Operation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION_FEATURE_COUNT = FEATURE_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.SingleReferenceOperationImpl
	 * <em>Single Reference Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.SingleReferenceOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getSingleReferenceOperation()
	 * @generated
	 */
	int SINGLE_REFERENCE_OPERATION = 8;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__IDENTIFIER = REFERENCE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__NAME = REFERENCE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__DESCRIPTION = REFERENCE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__MODEL_ELEMENT_ID = REFERENCE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__ACCEPTED = REFERENCE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__CLIENT_DATE = REFERENCE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__FEATURE_NAME = REFERENCE_OPERATION__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Bidirectional</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__BIDIRECTIONAL = REFERENCE_OPERATION__BIDIRECTIONAL;

	/**
	 * The feature id for the '<em><b>Opposite Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__OPPOSITE_FEATURE_NAME = REFERENCE_OPERATION__OPPOSITE_FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Containment Type</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__CONTAINMENT_TYPE = REFERENCE_OPERATION__CONTAINMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__OLD_VALUE = REFERENCE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__NEW_VALUE = REFERENCE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Single Reference Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION_FEATURE_COUNT = REFERENCE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiReferenceOperationImpl
	 * <em>Multi Reference Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiReferenceOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getMultiReferenceOperation()
	 * @generated
	 */
	int MULTI_REFERENCE_OPERATION = 10;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiReferenceSetOperationImpl
	 * <em>Multi Reference Set Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiReferenceSetOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getMultiReferenceSetOperation()
	 * @generated
	 */
	int MULTI_REFERENCE_SET_OPERATION = 9;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_SET_OPERATION__IDENTIFIER = REFERENCE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_SET_OPERATION__NAME = REFERENCE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_SET_OPERATION__DESCRIPTION = REFERENCE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_SET_OPERATION__MODEL_ELEMENT_ID = REFERENCE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_SET_OPERATION__ACCEPTED = REFERENCE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_SET_OPERATION__CLIENT_DATE = REFERENCE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_SET_OPERATION__FEATURE_NAME = REFERENCE_OPERATION__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Bidirectional</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_SET_OPERATION__BIDIRECTIONAL = REFERENCE_OPERATION__BIDIRECTIONAL;

	/**
	 * The feature id for the '<em><b>Opposite Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_SET_OPERATION__OPPOSITE_FEATURE_NAME = REFERENCE_OPERATION__OPPOSITE_FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Containment Type</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_SET_OPERATION__CONTAINMENT_TYPE = REFERENCE_OPERATION__CONTAINMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_SET_OPERATION__INDEX = REFERENCE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_SET_OPERATION__OLD_VALUE = REFERENCE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_SET_OPERATION__NEW_VALUE = REFERENCE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Multi Reference Set Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_SET_OPERATION_FEATURE_COUNT = REFERENCE_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__IDENTIFIER = REFERENCE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__NAME = REFERENCE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__DESCRIPTION = REFERENCE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__MODEL_ELEMENT_ID = REFERENCE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__ACCEPTED = REFERENCE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__CLIENT_DATE = REFERENCE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__FEATURE_NAME = REFERENCE_OPERATION__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Bidirectional</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__BIDIRECTIONAL = REFERENCE_OPERATION__BIDIRECTIONAL;

	/**
	 * The feature id for the '<em><b>Opposite Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__OPPOSITE_FEATURE_NAME = REFERENCE_OPERATION__OPPOSITE_FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Containment Type</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__CONTAINMENT_TYPE = REFERENCE_OPERATION__CONTAINMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Add</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__ADD = REFERENCE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__INDEX = REFERENCE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referenced Model Elements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__REFERENCED_MODEL_ELEMENTS = REFERENCE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Multi Reference Operation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION_FEATURE_COUNT = REFERENCE_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiReferenceMoveOperationImpl
	 * <em>Multi Reference Move Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiReferenceMoveOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getMultiReferenceMoveOperation()
	 * @generated
	 */
	int MULTI_REFERENCE_MOVE_OPERATION = 11;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION__IDENTIFIER = FEATURE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION__NAME = FEATURE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION__DESCRIPTION = FEATURE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION__MODEL_ELEMENT_ID = FEATURE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION__ACCEPTED = FEATURE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION__CLIENT_DATE = FEATURE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION__FEATURE_NAME = FEATURE_OPERATION__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Old Index</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION__OLD_INDEX = FEATURE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Index</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION__NEW_INDEX = FEATURE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referenced Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION__REFERENCED_MODEL_ELEMENT_ID = FEATURE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Multi Reference Move Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION_FEATURE_COUNT = FEATURE_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.DiagramLayoutOperationImpl
	 * <em>Diagram Layout Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.DiagramLayoutOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getDiagramLayoutOperation()
	 * @generated
	 */
	int DIAGRAM_LAYOUT_OPERATION = 13;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LAYOUT_OPERATION__IDENTIFIER = ATTRIBUTE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LAYOUT_OPERATION__NAME = ATTRIBUTE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LAYOUT_OPERATION__DESCRIPTION = ATTRIBUTE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LAYOUT_OPERATION__MODEL_ELEMENT_ID = ATTRIBUTE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LAYOUT_OPERATION__ACCEPTED = ATTRIBUTE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LAYOUT_OPERATION__CLIENT_DATE = ATTRIBUTE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LAYOUT_OPERATION__FEATURE_NAME = ATTRIBUTE_OPERATION__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LAYOUT_OPERATION__OLD_VALUE = ATTRIBUTE_OPERATION__OLD_VALUE;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LAYOUT_OPERATION__NEW_VALUE = ATTRIBUTE_OPERATION__NEW_VALUE;

	/**
	 * The number of structural features of the '<em>Diagram Layout Operation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LAYOUT_OPERATION_FEATURE_COUNT = ATTRIBUTE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationIdImpl <em>Operation Id</em>}'
	 * class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationIdImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getOperationId()
	 * @generated
	 */
	int OPERATION_ID = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_ID__ID = ModelPackage.UNIQUE_IDENTIFIER__ID;

	/**
	 * The number of structural features of the '<em>Operation Id</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_ID_FEATURE_COUNT = ModelPackage.UNIQUE_IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationGroupImpl
	 * <em>Operation Group</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationGroupImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getOperationGroup()
	 * @generated
	 */
	int OPERATION_GROUP = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_GROUP__NAME = 0;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_GROUP__OPERATIONS = 1;

	/**
	 * The number of structural features of the '<em>Operation Group</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_GROUP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.ModelElementGroupImpl
	 * <em>Model Element Group</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.ModelElementGroupImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getModelElementGroup()
	 * @generated
	 */
	int MODEL_ELEMENT_GROUP = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_GROUP__NAME = 0;

	/**
	 * The feature id for the '<em><b>Model Elements</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_GROUP__MODEL_ELEMENTS = 1;

	/**
	 * The number of structural features of the '<em>Model Element Group</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_GROUP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.EObjectToModelElementIdMapImpl
	 * <em>EObject To Model Element Id Map</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.EObjectToModelElementIdMapImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getEObjectToModelElementIdMap()
	 * @generated
	 */
	int EOBJECT_TO_MODEL_ELEMENT_ID_MAP = 17;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EOBJECT_TO_MODEL_ELEMENT_ID_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EOBJECT_TO_MODEL_ELEMENT_ID_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EObject To Model Element Id Map</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EOBJECT_TO_MODEL_ELEMENT_ID_MAP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.ContainmentType
	 * <em>Containment Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.ContainmentType
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getContainmentType()
	 * @generated
	 */
	int CONTAINMENT_TYPE = 18;

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation <em>Abstract Operation</em>}
	 * '.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Abstract Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation
	 * @generated
	 */
	EClass getAbstractOperation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation#getName <em>Name</em>}'.
	 * <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation#getName()
	 * @see #getAbstractOperation()
	 * @generated
	 */
	EAttribute getAbstractOperation_Name();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation#getDescription
	 * <em>Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation#getDescription()
	 * @see #getAbstractOperation()
	 * @generated
	 */
	EAttribute getAbstractOperation_Description();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation#getModelElementId
	 * <em>Model Element Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Model Element Id</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation#getModelElementId()
	 * @see #getAbstractOperation()
	 * @generated
	 */
	EReference getAbstractOperation_ModelElementId();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation#isAccepted
	 * <em>Accepted</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Accepted</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation#isAccepted()
	 * @see #getAbstractOperation()
	 * @generated
	 */
	EAttribute getAbstractOperation_Accepted();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation#getClientDate
	 * <em>Client Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Client Date</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation#getClientDate()
	 * @see #getAbstractOperation()
	 * @generated
	 */
	EAttribute getAbstractOperation_ClientDate();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation
	 * <em>Composite Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Composite Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation
	 * @generated
	 */
	EClass getCompositeOperation();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation#getSubOperations
	 * <em>Sub Operations</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Sub Operations</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation#getSubOperations()
	 * @see #getCompositeOperation()
	 * @generated
	 */
	EReference getCompositeOperation_SubOperations();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation#getMainOperation
	 * <em>Main Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Main Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation#getMainOperation()
	 * @see #getCompositeOperation()
	 * @generated
	 */
	EReference getCompositeOperation_MainOperation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation#getCompositeName
	 * <em>Composite Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Composite Name</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation#getCompositeName()
	 * @see #getCompositeOperation()
	 * @generated
	 */
	EAttribute getCompositeOperation_CompositeName();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation#getCompositeDescription
	 * <em>Composite Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Composite Description</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation#getCompositeDescription()
	 * @see #getCompositeOperation()
	 * @generated
	 */
	EAttribute getCompositeOperation_CompositeDescription();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation#isReversed
	 * <em>Reversed</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Reversed</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation#isReversed()
	 * @see #getCompositeOperation()
	 * @generated
	 */
	EAttribute getCompositeOperation_Reversed();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.FeatureOperation <em>Feature Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Feature Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.FeatureOperation
	 * @generated
	 */
	EClass getFeatureOperation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.FeatureOperation#getFeatureName
	 * <em>Feature Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.FeatureOperation#getFeatureName()
	 * @see #getFeatureOperation()
	 * @generated
	 */
	EAttribute getFeatureOperation_FeatureName();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation
	 * <em>Create Delete Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Create Delete Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation
	 * @generated
	 */
	EClass getCreateDeleteOperation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation#isDelete
	 * <em>Delete</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Delete</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation#isDelete()
	 * @see #getCreateDeleteOperation()
	 * @generated
	 */
	EAttribute getCreateDeleteOperation_Delete();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation#getModelElement
	 * <em>Model Element</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Model Element</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation#getModelElement()
	 * @see #getCreateDeleteOperation()
	 * @generated
	 */
	EReference getCreateDeleteOperation_ModelElement();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation#getSubOperations
	 * <em>Sub Operations</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Sub Operations</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation#getSubOperations()
	 * @see #getCreateDeleteOperation()
	 * @generated
	 */
	EReference getCreateDeleteOperation_SubOperations();

	/**
	 * Returns the meta object for the map '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation#getEObjectToIdMap
	 * <em>EObject To Id Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the map '<em>EObject To Id Map</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation#getEObjectToIdMap()
	 * @see #getCreateDeleteOperation()
	 * @generated
	 */
	EReference getCreateDeleteOperation_EObjectToIdMap();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.AttributeOperation
	 * <em>Attribute Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Attribute Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.AttributeOperation
	 * @generated
	 */
	EClass getAttributeOperation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.AttributeOperation#getOldValue
	 * <em>Old Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Old Value</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.AttributeOperation#getOldValue()
	 * @see #getAttributeOperation()
	 * @generated
	 */
	EAttribute getAttributeOperation_OldValue();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.AttributeOperation#getNewValue
	 * <em>New Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>New Value</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.AttributeOperation#getNewValue()
	 * @see #getAttributeOperation()
	 * @generated
	 */
	EAttribute getAttributeOperation_NewValue();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeOperation
	 * <em>Multi Attribute Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Multi Attribute Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeOperation
	 * @generated
	 */
	EClass getMultiAttributeOperation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeOperation#isAdd <em>Add</em>}'.
	 * <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Add</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeOperation#isAdd()
	 * @see #getMultiAttributeOperation()
	 * @generated
	 */
	EAttribute getMultiAttributeOperation_Add();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeOperation#getIndexes
	 * <em>Indexes</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Indexes</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeOperation#getIndexes()
	 * @see #getMultiAttributeOperation()
	 * @generated
	 */
	EAttribute getMultiAttributeOperation_Indexes();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeOperation#getReferencedValues
	 * <em>Referenced Values</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Referenced Values</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeOperation#getReferencedValues()
	 * @see #getMultiAttributeOperation()
	 * @generated
	 */
	EAttribute getMultiAttributeOperation_ReferencedValues();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeSetOperation
	 * <em>Multi Attribute Set Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Multi Attribute Set Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeSetOperation
	 * @generated
	 */
	EClass getMultiAttributeSetOperation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeSetOperation#getIndex
	 * <em>Index</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeSetOperation#getIndex()
	 * @see #getMultiAttributeSetOperation()
	 * @generated
	 */
	EAttribute getMultiAttributeSetOperation_Index();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeSetOperation#getOldValue
	 * <em>Old Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Old Value</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeSetOperation#getOldValue()
	 * @see #getMultiAttributeSetOperation()
	 * @generated
	 */
	EAttribute getMultiAttributeSetOperation_OldValue();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeSetOperation#getNewValue
	 * <em>New Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>New Value</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeSetOperation#getNewValue()
	 * @see #getMultiAttributeSetOperation()
	 * @generated
	 */
	EAttribute getMultiAttributeSetOperation_NewValue();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation
	 * <em>Multi Attribute Move Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Multi Attribute Move Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation
	 * @generated
	 */
	EClass getMultiAttributeMoveOperation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation#getOldIndex
	 * <em>Old Index</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Old Index</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation#getOldIndex()
	 * @see #getMultiAttributeMoveOperation()
	 * @generated
	 */
	EAttribute getMultiAttributeMoveOperation_OldIndex();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation#getNewIndex
	 * <em>New Index</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>New Index</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation#getNewIndex()
	 * @see #getMultiAttributeMoveOperation()
	 * @generated
	 */
	EAttribute getMultiAttributeMoveOperation_NewIndex();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation#getReferencedValue
	 * <em>Referenced Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Referenced Value</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation#getReferencedValue()
	 * @see #getMultiAttributeMoveOperation()
	 * @generated
	 */
	EAttribute getMultiAttributeMoveOperation_ReferencedValue();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation
	 * <em>Single Reference Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Single Reference Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation
	 * @generated
	 */
	EClass getSingleReferenceOperation();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation#getOldValue
	 * <em>Old Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Old Value</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation#getOldValue()
	 * @see #getSingleReferenceOperation()
	 * @generated
	 */
	EReference getSingleReferenceOperation_OldValue();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation#getNewValue
	 * <em>New Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>New Value</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation#getNewValue()
	 * @see #getSingleReferenceOperation()
	 * @generated
	 */
	EReference getSingleReferenceOperation_NewValue();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceOperation
	 * <em>Multi Reference Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Multi Reference Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceOperation
	 * @generated
	 */
	EClass getMultiReferenceOperation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceOperation#isAdd <em>Add</em>}'.
	 * <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Add</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceOperation#isAdd()
	 * @see #getMultiReferenceOperation()
	 * @generated
	 */
	EAttribute getMultiReferenceOperation_Add();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceOperation#getIndex
	 * <em>Index</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceOperation#getIndex()
	 * @see #getMultiReferenceOperation()
	 * @generated
	 */
	EAttribute getMultiReferenceOperation_Index();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceOperation#getReferencedModelElements
	 * <em>Referenced Model Elements</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Referenced Model Elements</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceOperation#getReferencedModelElements()
	 * @see #getMultiReferenceOperation()
	 * @generated
	 */
	EReference getMultiReferenceOperation_ReferencedModelElements();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation
	 * <em>Multi Reference Set Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Multi Reference Set Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation
	 * @generated
	 */
	EClass getMultiReferenceSetOperation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation#getIndex
	 * <em>Index</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation#getIndex()
	 * @see #getMultiReferenceSetOperation()
	 * @generated
	 */
	EAttribute getMultiReferenceSetOperation_Index();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation#getOldValue
	 * <em>Old Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Old Value</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation#getOldValue()
	 * @see #getMultiReferenceSetOperation()
	 * @generated
	 */
	EReference getMultiReferenceSetOperation_OldValue();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation#getNewValue
	 * <em>New Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>New Value</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation#getNewValue()
	 * @see #getMultiReferenceSetOperation()
	 * @generated
	 */
	EReference getMultiReferenceSetOperation_NewValue();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceMoveOperation
	 * <em>Multi Reference Move Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Multi Reference Move Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceMoveOperation
	 * @generated
	 */
	EClass getMultiReferenceMoveOperation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceMoveOperation#getOldIndex
	 * <em>Old Index</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Old Index</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceMoveOperation#getOldIndex()
	 * @see #getMultiReferenceMoveOperation()
	 * @generated
	 */
	EAttribute getMultiReferenceMoveOperation_OldIndex();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceMoveOperation#getNewIndex
	 * <em>New Index</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>New Index</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceMoveOperation#getNewIndex()
	 * @see #getMultiReferenceMoveOperation()
	 * @generated
	 */
	EAttribute getMultiReferenceMoveOperation_NewIndex();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceMoveOperation#getReferencedModelElementId
	 * <em>Referenced Model Element Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Referenced Model Element Id</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceMoveOperation#getReferencedModelElementId()
	 * @see #getMultiReferenceMoveOperation()
	 * @generated
	 */
	EReference getMultiReferenceMoveOperation_ReferencedModelElementId();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation
	 * <em>Reference Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Reference Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation
	 * @generated
	 */
	EClass getReferenceOperation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation#isBidirectional
	 * <em>Bidirectional</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Bidirectional</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation#isBidirectional()
	 * @see #getReferenceOperation()
	 * @generated
	 */
	EAttribute getReferenceOperation_Bidirectional();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation#getOppositeFeatureName
	 * <em>Opposite Feature Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Opposite Feature Name</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation#getOppositeFeatureName()
	 * @see #getReferenceOperation()
	 * @generated
	 */
	EAttribute getReferenceOperation_OppositeFeatureName();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation#getContainmentType
	 * <em>Containment Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Containment Type</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation#getContainmentType()
	 * @see #getReferenceOperation()
	 * @generated
	 */
	EAttribute getReferenceOperation_ContainmentType();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.DiagramLayoutOperation
	 * <em>Diagram Layout Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Diagram Layout Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.DiagramLayoutOperation
	 * @generated
	 */
	EClass getDiagramLayoutOperation();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.OperationId <em>Operation Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Operation Id</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationId
	 * @generated
	 */
	EClass getOperationId();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.OperationGroup <em>Operation Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Operation Group</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationGroup
	 * @generated
	 */
	EClass getOperationGroup();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.OperationGroup#getName <em>Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationGroup#getName()
	 * @see #getOperationGroup()
	 * @generated
	 */
	EAttribute getOperationGroup_Name();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.OperationGroup#getOperations
	 * <em>Operations</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Operations</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationGroup#getOperations()
	 * @see #getOperationGroup()
	 * @generated
	 */
	EReference getOperationGroup_Operations();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.ModelElementGroup
	 * <em>Model Element Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Model Element Group</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.ModelElementGroup
	 * @generated
	 */
	EClass getModelElementGroup();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.ModelElementGroup#getName <em>Name</em>}'.
	 * <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.ModelElementGroup#getName()
	 * @see #getModelElementGroup()
	 * @generated
	 */
	EAttribute getModelElementGroup_Name();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.ModelElementGroup#getModelElements
	 * <em>Model Elements</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Model Elements</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.ModelElementGroup#getModelElements()
	 * @see #getModelElementGroup()
	 * @generated
	 */
	EReference getModelElementGroup_ModelElements();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EObject To Model Element Id Map</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>EObject To Model Element Id Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="org.eclipse.emf.ecore.EObject" valueType="org.eclipse.emf.emfstore.common.model.ModelElementId"
	 *        valueContainment="true" valueResolveProxies="true"
	 * @generated
	 */
	EClass getEObjectToModelElementIdMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEObjectToModelElementIdMap()
	 * @generated
	 */
	EReference getEObjectToModelElementIdMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEObjectToModelElementIdMap()
	 * @generated
	 */
	EReference getEObjectToModelElementIdMap_Value();

	/**
	 * Returns the meta object for enum '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.ContainmentType <em>Containment Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Containment Type</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.ContainmentType
	 * @generated
	 */
	EEnum getContainmentType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OperationsFactory getOperationsFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.AbstractOperationImpl
		 * <em>Abstract Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.AbstractOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getAbstractOperation()
		 * @generated
		 */
		EClass ABSTRACT_OPERATION = eINSTANCE.getAbstractOperation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ABSTRACT_OPERATION__NAME = eINSTANCE.getAbstractOperation_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ABSTRACT_OPERATION__DESCRIPTION = eINSTANCE.getAbstractOperation_Description();

		/**
		 * The meta object literal for the '<em><b>Model Element Id</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_OPERATION__MODEL_ELEMENT_ID = eINSTANCE.getAbstractOperation_ModelElementId();

		/**
		 * The meta object literal for the '<em><b>Accepted</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ABSTRACT_OPERATION__ACCEPTED = eINSTANCE.getAbstractOperation_Accepted();

		/**
		 * The meta object literal for the '<em><b>Client Date</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ABSTRACT_OPERATION__CLIENT_DATE = eINSTANCE.getAbstractOperation_ClientDate();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.CompositeOperationImpl
		 * <em>Composite Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.CompositeOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getCompositeOperation()
		 * @generated
		 */
		EClass COMPOSITE_OPERATION = eINSTANCE.getCompositeOperation();

		/**
		 * The meta object literal for the '<em><b>Sub Operations</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMPOSITE_OPERATION__SUB_OPERATIONS = eINSTANCE.getCompositeOperation_SubOperations();

		/**
		 * The meta object literal for the '<em><b>Main Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMPOSITE_OPERATION__MAIN_OPERATION = eINSTANCE.getCompositeOperation_MainOperation();

		/**
		 * The meta object literal for the '<em><b>Composite Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMPOSITE_OPERATION__COMPOSITE_NAME = eINSTANCE.getCompositeOperation_CompositeName();

		/**
		 * The meta object literal for the '<em><b>Composite Description</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION = eINSTANCE.getCompositeOperation_CompositeDescription();

		/**
		 * The meta object literal for the '<em><b>Reversed</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMPOSITE_OPERATION__REVERSED = eINSTANCE.getCompositeOperation_Reversed();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.FeatureOperationImpl
		 * <em>Feature Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.FeatureOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getFeatureOperation()
		 * @generated
		 */
		EClass FEATURE_OPERATION = eINSTANCE.getFeatureOperation();

		/**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FEATURE_OPERATION__FEATURE_NAME = eINSTANCE.getFeatureOperation_FeatureName();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.CreateDeleteOperationImpl
		 * <em>Create Delete Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.CreateDeleteOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getCreateDeleteOperation()
		 * @generated
		 */
		EClass CREATE_DELETE_OPERATION = eINSTANCE.getCreateDeleteOperation();

		/**
		 * The meta object literal for the '<em><b>Delete</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CREATE_DELETE_OPERATION__DELETE = eINSTANCE.getCreateDeleteOperation_Delete();

		/**
		 * The meta object literal for the '<em><b>Model Element</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CREATE_DELETE_OPERATION__MODEL_ELEMENT = eINSTANCE.getCreateDeleteOperation_ModelElement();

		/**
		 * The meta object literal for the '<em><b>Sub Operations</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CREATE_DELETE_OPERATION__SUB_OPERATIONS = eINSTANCE.getCreateDeleteOperation_SubOperations();

		/**
		 * The meta object literal for the '<em><b>EObject To Id Map</b></em>' map feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CREATE_DELETE_OPERATION__EOBJECT_TO_ID_MAP = eINSTANCE.getCreateDeleteOperation_EObjectToIdMap();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.AttributeOperationImpl
		 * <em>Attribute Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.AttributeOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getAttributeOperation()
		 * @generated
		 */
		EClass ATTRIBUTE_OPERATION = eINSTANCE.getAttributeOperation();

		/**
		 * The meta object literal for the '<em><b>Old Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_OPERATION__OLD_VALUE = eINSTANCE.getAttributeOperation_OldValue();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_OPERATION__NEW_VALUE = eINSTANCE.getAttributeOperation_NewValue();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiAttributeOperationImpl
		 * <em>Multi Attribute Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiAttributeOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getMultiAttributeOperation()
		 * @generated
		 */
		EClass MULTI_ATTRIBUTE_OPERATION = eINSTANCE.getMultiAttributeOperation();

		/**
		 * The meta object literal for the '<em><b>Add</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MULTI_ATTRIBUTE_OPERATION__ADD = eINSTANCE.getMultiAttributeOperation_Add();

		/**
		 * The meta object literal for the '<em><b>Indexes</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MULTI_ATTRIBUTE_OPERATION__INDEXES = eINSTANCE.getMultiAttributeOperation_Indexes();

		/**
		 * The meta object literal for the '<em><b>Referenced Values</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MULTI_ATTRIBUTE_OPERATION__REFERENCED_VALUES = eINSTANCE
			.getMultiAttributeOperation_ReferencedValues();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiAttributeSetOperationImpl
		 * <em>Multi Attribute Set Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiAttributeSetOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getMultiAttributeSetOperation()
		 * @generated
		 */
		EClass MULTI_ATTRIBUTE_SET_OPERATION = eINSTANCE.getMultiAttributeSetOperation();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MULTI_ATTRIBUTE_SET_OPERATION__INDEX = eINSTANCE.getMultiAttributeSetOperation_Index();

		/**
		 * The meta object literal for the '<em><b>Old Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MULTI_ATTRIBUTE_SET_OPERATION__OLD_VALUE = eINSTANCE.getMultiAttributeSetOperation_OldValue();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MULTI_ATTRIBUTE_SET_OPERATION__NEW_VALUE = eINSTANCE.getMultiAttributeSetOperation_NewValue();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiAttributeMoveOperationImpl
		 * <em>Multi Attribute Move Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiAttributeMoveOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getMultiAttributeMoveOperation()
		 * @generated
		 */
		EClass MULTI_ATTRIBUTE_MOVE_OPERATION = eINSTANCE.getMultiAttributeMoveOperation();

		/**
		 * The meta object literal for the '<em><b>Old Index</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MULTI_ATTRIBUTE_MOVE_OPERATION__OLD_INDEX = eINSTANCE.getMultiAttributeMoveOperation_OldIndex();

		/**
		 * The meta object literal for the '<em><b>New Index</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MULTI_ATTRIBUTE_MOVE_OPERATION__NEW_INDEX = eINSTANCE.getMultiAttributeMoveOperation_NewIndex();

		/**
		 * The meta object literal for the '<em><b>Referenced Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MULTI_ATTRIBUTE_MOVE_OPERATION__REFERENCED_VALUE = eINSTANCE
			.getMultiAttributeMoveOperation_ReferencedValue();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.SingleReferenceOperationImpl
		 * <em>Single Reference Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.SingleReferenceOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getSingleReferenceOperation()
		 * @generated
		 */
		EClass SINGLE_REFERENCE_OPERATION = eINSTANCE.getSingleReferenceOperation();

		/**
		 * The meta object literal for the '<em><b>Old Value</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SINGLE_REFERENCE_OPERATION__OLD_VALUE = eINSTANCE.getSingleReferenceOperation_OldValue();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SINGLE_REFERENCE_OPERATION__NEW_VALUE = eINSTANCE.getSingleReferenceOperation_NewValue();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiReferenceOperationImpl
		 * <em>Multi Reference Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiReferenceOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getMultiReferenceOperation()
		 * @generated
		 */
		EClass MULTI_REFERENCE_OPERATION = eINSTANCE.getMultiReferenceOperation();

		/**
		 * The meta object literal for the '<em><b>Add</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MULTI_REFERENCE_OPERATION__ADD = eINSTANCE.getMultiReferenceOperation_Add();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MULTI_REFERENCE_OPERATION__INDEX = eINSTANCE.getMultiReferenceOperation_Index();

		/**
		 * The meta object literal for the '<em><b>Referenced Model Elements</b></em>' containment reference list
		 * feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MULTI_REFERENCE_OPERATION__REFERENCED_MODEL_ELEMENTS = eINSTANCE
			.getMultiReferenceOperation_ReferencedModelElements();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiReferenceSetOperationImpl
		 * <em>Multi Reference Set Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiReferenceSetOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getMultiReferenceSetOperation()
		 * @generated
		 */
		EClass MULTI_REFERENCE_SET_OPERATION = eINSTANCE.getMultiReferenceSetOperation();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MULTI_REFERENCE_SET_OPERATION__INDEX = eINSTANCE.getMultiReferenceSetOperation_Index();

		/**
		 * The meta object literal for the '<em><b>Old Value</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MULTI_REFERENCE_SET_OPERATION__OLD_VALUE = eINSTANCE.getMultiReferenceSetOperation_OldValue();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MULTI_REFERENCE_SET_OPERATION__NEW_VALUE = eINSTANCE.getMultiReferenceSetOperation_NewValue();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiReferenceMoveOperationImpl
		 * <em>Multi Reference Move Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiReferenceMoveOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getMultiReferenceMoveOperation()
		 * @generated
		 */
		EClass MULTI_REFERENCE_MOVE_OPERATION = eINSTANCE.getMultiReferenceMoveOperation();

		/**
		 * The meta object literal for the '<em><b>Old Index</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MULTI_REFERENCE_MOVE_OPERATION__OLD_INDEX = eINSTANCE.getMultiReferenceMoveOperation_OldIndex();

		/**
		 * The meta object literal for the '<em><b>New Index</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MULTI_REFERENCE_MOVE_OPERATION__NEW_INDEX = eINSTANCE.getMultiReferenceMoveOperation_NewIndex();

		/**
		 * The meta object literal for the '<em><b>Referenced Model Element Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MULTI_REFERENCE_MOVE_OPERATION__REFERENCED_MODEL_ELEMENT_ID = eINSTANCE
			.getMultiReferenceMoveOperation_ReferencedModelElementId();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.ReferenceOperationImpl
		 * <em>Reference Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.ReferenceOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getReferenceOperation()
		 * @generated
		 */
		EClass REFERENCE_OPERATION = eINSTANCE.getReferenceOperation();

		/**
		 * The meta object literal for the '<em><b>Bidirectional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REFERENCE_OPERATION__BIDIRECTIONAL = eINSTANCE.getReferenceOperation_Bidirectional();

		/**
		 * The meta object literal for the '<em><b>Opposite Feature Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REFERENCE_OPERATION__OPPOSITE_FEATURE_NAME = eINSTANCE.getReferenceOperation_OppositeFeatureName();

		/**
		 * The meta object literal for the '<em><b>Containment Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REFERENCE_OPERATION__CONTAINMENT_TYPE = eINSTANCE.getReferenceOperation_ContainmentType();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.DiagramLayoutOperationImpl
		 * <em>Diagram Layout Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.DiagramLayoutOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getDiagramLayoutOperation()
		 * @generated
		 */
		EClass DIAGRAM_LAYOUT_OPERATION = eINSTANCE.getDiagramLayoutOperation();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationIdImpl
		 * <em>Operation Id</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationIdImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getOperationId()
		 * @generated
		 */
		EClass OPERATION_ID = eINSTANCE.getOperationId();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationGroupImpl
		 * <em>Operation Group</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationGroupImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getOperationGroup()
		 * @generated
		 */
		EClass OPERATION_GROUP = eINSTANCE.getOperationGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute OPERATION_GROUP__NAME = eINSTANCE.getOperationGroup_Name();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OPERATION_GROUP__OPERATIONS = eINSTANCE.getOperationGroup_Operations();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.ModelElementGroupImpl
		 * <em>Model Element Group</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.ModelElementGroupImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getModelElementGroup()
		 * @generated
		 */
		EClass MODEL_ELEMENT_GROUP = eINSTANCE.getModelElementGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MODEL_ELEMENT_GROUP__NAME = eINSTANCE.getModelElementGroup_Name();

		/**
		 * The meta object literal for the '<em><b>Model Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MODEL_ELEMENT_GROUP__MODEL_ELEMENTS = eINSTANCE.getModelElementGroup_ModelElements();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.EObjectToModelElementIdMapImpl
		 * <em>EObject To Model Element Id Map</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.EObjectToModelElementIdMapImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getEObjectToModelElementIdMap()
		 * @generated
		 */
		EClass EOBJECT_TO_MODEL_ELEMENT_ID_MAP = eINSTANCE.getEObjectToModelElementIdMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EOBJECT_TO_MODEL_ELEMENT_ID_MAP__KEY = eINSTANCE.getEObjectToModelElementIdMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EOBJECT_TO_MODEL_ELEMENT_ID_MAP__VALUE = eINSTANCE.getEObjectToModelElementIdMap_Value();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.ContainmentType <em>Containment Type</em>}
		 * ' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.ContainmentType
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl#getContainmentType()
		 * @generated
		 */
		EEnum CONTAINMENT_TYPE = eINSTANCE.getContainmentType();

	}

} // OperationsPackage
