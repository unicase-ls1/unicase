/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Kögel
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment.changepackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackageFactory
 * @model kind="package"
 * @generated
 */
public interface ChangepackagePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "changepackage";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/esmodel/changemanagment/changepackage";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.emfstore.esmodel.changemanagment.changepackage";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ChangepackagePackage eINSTANCE = org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ChangepackagePackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESChangePackageImpl <em>ES Change Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESChangePackageImpl
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ChangepackagePackageImpl#getESChangePackage()
	 * @generated
	 */
	int ES_CHANGE_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_CHANGE_PACKAGE__OPERATIONS = 0;

	/**
	 * The number of structural features of the '<em>ES Change Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_CHANGE_PACKAGE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESAbstractOperation <em>ES Abstract Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESAbstractOperation
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ChangepackagePackageImpl#getESAbstractOperation()
	 * @generated
	 */
	int ES_ABSTRACT_OPERATION = 1;

	/**
	 * The number of structural features of the '<em>ES Abstract Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_ABSTRACT_OPERATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESOperationImpl <em>ES Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESOperationImpl
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ChangepackagePackageImpl#getESOperation()
	 * @generated
	 */
	int ES_OPERATION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_OPERATION__NAME = ES_ABSTRACT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_OPERATION__DESCRIPTION = ES_ABSTRACT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_OPERATION__OPERATIONS = ES_ABSTRACT_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>ES Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_OPERATION_FEATURE_COUNT = ES_ABSTRACT_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESEventImpl <em>ES Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESEventImpl
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ChangepackagePackageImpl#getESEvent()
	 * @generated
	 */
	int ES_EVENT = 3;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_EVENT__MODEL_ELEMENT_ID = ES_ABSTRACT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_EVENT__FEATURE_ID = ES_ABSTRACT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Model Element Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_EVENT__MODEL_ELEMENT_CLASS = ES_ABSTRACT_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>ES Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_EVENT_FEATURE_COUNT = ES_ABSTRACT_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESeAttributeEventImpl <em>ESe Attribute Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESeAttributeEventImpl
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ChangepackagePackageImpl#getESeAttributeEvent()
	 * @generated
	 */
	int ESE_ATTRIBUTE_EVENT = 4;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESE_ATTRIBUTE_EVENT__MODEL_ELEMENT_ID = ES_EVENT__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESE_ATTRIBUTE_EVENT__FEATURE_ID = ES_EVENT__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Model Element Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESE_ATTRIBUTE_EVENT__MODEL_ELEMENT_CLASS = ES_EVENT__MODEL_ELEMENT_CLASS;

	/**
	 * The feature id for the '<em><b>Previous State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESE_ATTRIBUTE_EVENT__PREVIOUS_STATE = ES_EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subsequent State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESE_ATTRIBUTE_EVENT__SUBSEQUENT_STATE = ES_EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>ESe Attribute Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESE_ATTRIBUTE_EVENT_FEATURE_COUNT = ES_EVENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESListEventImpl <em>ES List Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESListEventImpl
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ChangepackagePackageImpl#getESListEvent()
	 * @generated
	 */
	int ES_LIST_EVENT = 5;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_LIST_EVENT__MODEL_ELEMENT_ID = ES_EVENT__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_LIST_EVENT__FEATURE_ID = ES_EVENT__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Model Element Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_LIST_EVENT__MODEL_ELEMENT_CLASS = ES_EVENT__MODEL_ELEMENT_CLASS;

	/**
	 * The number of structural features of the '<em>ES List Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_LIST_EVENT_FEATURE_COUNT = ES_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESModifyElementEventImpl <em>ES Modify Element Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESModifyElementEventImpl
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ChangepackagePackageImpl#getESModifyElementEvent()
	 * @generated
	 */
	int ES_MODIFY_ELEMENT_EVENT = 6;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_MODIFY_ELEMENT_EVENT__MODEL_ELEMENT_ID = ES_EVENT__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_MODIFY_ELEMENT_EVENT__FEATURE_ID = ES_EVENT__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Model Element Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_MODIFY_ELEMENT_EVENT__MODEL_ELEMENT_CLASS = ES_EVENT__MODEL_ELEMENT_CLASS;

	/**
	 * The feature id for the '<em><b>Previous State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_MODIFY_ELEMENT_EVENT__PREVIOUS_STATE = ES_EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subsequent State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_MODIFY_ELEMENT_EVENT__SUBSEQUENT_STATE = ES_EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>ES Modify Element Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ES_MODIFY_ELEMENT_EVENT_FEATURE_COUNT = ES_EVENT_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESChangePackage <em>ES Change Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ES Change Package</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESChangePackage
	 * @generated
	 */
	EClass getESChangePackage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESChangePackage#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESChangePackage#getOperations()
	 * @see #getESChangePackage()
	 * @generated
	 */
	EReference getESChangePackage_Operations();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESAbstractOperation <em>ES Abstract Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ES Abstract Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESAbstractOperation
	 * @generated
	 */
	EClass getESAbstractOperation();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESOperation <em>ES Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ES Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESOperation
	 * @generated
	 */
	EClass getESOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESOperation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESOperation#getName()
	 * @see #getESOperation()
	 * @generated
	 */
	EAttribute getESOperation_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESOperation#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESOperation#getDescription()
	 * @see #getESOperation()
	 * @generated
	 */
	EAttribute getESOperation_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESOperation#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESOperation#getOperations()
	 * @see #getESOperation()
	 * @generated
	 */
	EReference getESOperation_Operations();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESEvent <em>ES Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ES Event</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESEvent
	 * @generated
	 */
	EClass getESEvent();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESEvent#getModelElementId <em>Model Element Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model Element Id</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESEvent#getModelElementId()
	 * @see #getESEvent()
	 * @generated
	 */
	EReference getESEvent_ModelElementId();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESEvent#getFeatureId <em>Feature Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Id</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESEvent#getFeatureId()
	 * @see #getESEvent()
	 * @generated
	 */
	EAttribute getESEvent_FeatureId();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESEvent#getModelElementClass <em>Model Element Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Element Class</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESEvent#getModelElementClass()
	 * @see #getESEvent()
	 * @generated
	 */
	EAttribute getESEvent_ModelElementClass();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESeAttributeEvent <em>ESe Attribute Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESe Attribute Event</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESeAttributeEvent
	 * @generated
	 */
	EClass getESeAttributeEvent();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESeAttributeEvent#getPreviousState <em>Previous State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Previous State</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESeAttributeEvent#getPreviousState()
	 * @see #getESeAttributeEvent()
	 * @generated
	 */
	EReference getESeAttributeEvent_PreviousState();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESeAttributeEvent#getSubsequentState <em>Subsequent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Subsequent State</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESeAttributeEvent#getSubsequentState()
	 * @see #getESeAttributeEvent()
	 * @generated
	 */
	EReference getESeAttributeEvent_SubsequentState();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESListEvent <em>ES List Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ES List Event</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESListEvent
	 * @generated
	 */
	EClass getESListEvent();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESModifyElementEvent <em>ES Modify Element Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ES Modify Element Event</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESModifyElementEvent
	 * @generated
	 */
	EClass getESModifyElementEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESModifyElementEvent#getPreviousState <em>Previous State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Previous State</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESModifyElementEvent#getPreviousState()
	 * @see #getESModifyElementEvent()
	 * @generated
	 */
	EAttribute getESModifyElementEvent_PreviousState();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESModifyElementEvent#getSubsequentState <em>Subsequent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subsequent State</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESModifyElementEvent#getSubsequentState()
	 * @see #getESModifyElementEvent()
	 * @generated
	 */
	EAttribute getESModifyElementEvent_SubsequentState();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ChangepackageFactory getChangepackageFactory();

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
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESChangePackageImpl <em>ES Change Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESChangePackageImpl
		 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ChangepackagePackageImpl#getESChangePackage()
		 * @generated
		 */
		EClass ES_CHANGE_PACKAGE = eINSTANCE.getESChangePackage();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ES_CHANGE_PACKAGE__OPERATIONS = eINSTANCE
				.getESChangePackage_Operations();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESAbstractOperation <em>ES Abstract Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ESAbstractOperation
		 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ChangepackagePackageImpl#getESAbstractOperation()
		 * @generated
		 */
		EClass ES_ABSTRACT_OPERATION = eINSTANCE.getESAbstractOperation();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESOperationImpl <em>ES Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESOperationImpl
		 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ChangepackagePackageImpl#getESOperation()
		 * @generated
		 */
		EClass ES_OPERATION = eINSTANCE.getESOperation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ES_OPERATION__NAME = eINSTANCE.getESOperation_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ES_OPERATION__DESCRIPTION = eINSTANCE
				.getESOperation_Description();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ES_OPERATION__OPERATIONS = eINSTANCE
				.getESOperation_Operations();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESEventImpl <em>ES Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESEventImpl
		 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ChangepackagePackageImpl#getESEvent()
		 * @generated
		 */
		EClass ES_EVENT = eINSTANCE.getESEvent();

		/**
		 * The meta object literal for the '<em><b>Model Element Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ES_EVENT__MODEL_ELEMENT_ID = eINSTANCE
				.getESEvent_ModelElementId();

		/**
		 * The meta object literal for the '<em><b>Feature Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ES_EVENT__FEATURE_ID = eINSTANCE.getESEvent_FeatureId();

		/**
		 * The meta object literal for the '<em><b>Model Element Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ES_EVENT__MODEL_ELEMENT_CLASS = eINSTANCE
				.getESEvent_ModelElementClass();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESeAttributeEventImpl <em>ESe Attribute Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESeAttributeEventImpl
		 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ChangepackagePackageImpl#getESeAttributeEvent()
		 * @generated
		 */
		EClass ESE_ATTRIBUTE_EVENT = eINSTANCE.getESeAttributeEvent();

		/**
		 * The meta object literal for the '<em><b>Previous State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESE_ATTRIBUTE_EVENT__PREVIOUS_STATE = eINSTANCE
				.getESeAttributeEvent_PreviousState();

		/**
		 * The meta object literal for the '<em><b>Subsequent State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESE_ATTRIBUTE_EVENT__SUBSEQUENT_STATE = eINSTANCE
				.getESeAttributeEvent_SubsequentState();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESListEventImpl <em>ES List Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESListEventImpl
		 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ChangepackagePackageImpl#getESListEvent()
		 * @generated
		 */
		EClass ES_LIST_EVENT = eINSTANCE.getESListEvent();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESModifyElementEventImpl <em>ES Modify Element Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESModifyElementEventImpl
		 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ChangepackagePackageImpl#getESModifyElementEvent()
		 * @generated
		 */
		EClass ES_MODIFY_ELEMENT_EVENT = eINSTANCE.getESModifyElementEvent();

		/**
		 * The meta object literal for the '<em><b>Previous State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ES_MODIFY_ELEMENT_EVENT__PREVIOUS_STATE = eINSTANCE
				.getESModifyElementEvent_PreviousState();

		/**
		 * The meta object literal for the '<em><b>Subsequent State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ES_MODIFY_ELEMENT_EVENT__SUBSEQUENT_STATE = eINSTANCE
				.getESModifyElementEvent_SubsequentState();

	}

} //ChangepackagePackage
