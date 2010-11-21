/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ContainmentType;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.DiagramLayoutOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ModelElementGroup;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeSetOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceSetOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationGroup;
import org.unicase.emfstore.esmodel.versioning.operations.OperationId;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class OperationsFactoryImpl extends EFactoryImpl implements OperationsFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static OperationsFactory init() {
		try {
			OperationsFactory theOperationsFactory = (OperationsFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://unicase.org/esmodel/versioning/operations");
			if (theOperationsFactory != null) {
				return theOperationsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OperationsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OperationsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case OperationsPackage.COMPOSITE_OPERATION:
			return createCompositeOperation();
		case OperationsPackage.CREATE_DELETE_OPERATION:
			return createCreateDeleteOperation();
		case OperationsPackage.ATTRIBUTE_OPERATION:
			return createAttributeOperation();
		case OperationsPackage.MULTI_ATTRIBUTE_OPERATION:
			return createMultiAttributeOperation();
		case OperationsPackage.MULTI_ATTRIBUTE_SET_OPERATION:
			return createMultiAttributeSetOperation();
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION:
			return createMultiAttributeMoveOperation();
		case OperationsPackage.SINGLE_REFERENCE_OPERATION:
			return createSingleReferenceOperation();
		case OperationsPackage.MULTI_REFERENCE_OPERATION:
			return createMultiReferenceOperation();
		case OperationsPackage.MULTI_REFERENCE_SET_OPERATION:
			return createMultiReferenceSetOperation();
		case OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION:
			return createMultiReferenceMoveOperation();
		case OperationsPackage.DIAGRAM_LAYOUT_OPERATION:
			return createDiagramLayoutOperation();
		case OperationsPackage.OPERATION_ID:
			return createOperationId();
		case OperationsPackage.OPERATION_GROUP:
			return createOperationGroup();
		case OperationsPackage.MODEL_ELEMENT_GROUP:
			return createModelElementGroup();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case OperationsPackage.CONTAINMENT_TYPE:
			return createContainmentTypeFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case OperationsPackage.CONTAINMENT_TYPE:
			return convertContainmentTypeToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CompositeOperation createCompositeOperation() {
		CompositeOperationImpl compositeOperation = new CompositeOperationImpl();
		return compositeOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CreateDeleteOperation createCreateDeleteOperation() {
		CreateDeleteOperationImpl createDeleteOperation = new CreateDeleteOperationImpl();
		return createDeleteOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AttributeOperation createAttributeOperation() {
		AttributeOperationImpl attributeOperation = new AttributeOperationImpl();
		return attributeOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MultiAttributeOperation createMultiAttributeOperation() {
		MultiAttributeOperationImpl multiAttributeOperation = new MultiAttributeOperationImpl();
		return multiAttributeOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MultiAttributeSetOperation createMultiAttributeSetOperation() {
		MultiAttributeSetOperationImpl multiAttributeSetOperation = new MultiAttributeSetOperationImpl();
		return multiAttributeSetOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MultiAttributeMoveOperation createMultiAttributeMoveOperation() {
		MultiAttributeMoveOperationImpl multiAttributeMoveOperation = new MultiAttributeMoveOperationImpl();
		return multiAttributeMoveOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SingleReferenceOperation createSingleReferenceOperation() {
		SingleReferenceOperationImpl singleReferenceOperation = new SingleReferenceOperationImpl();
		return singleReferenceOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MultiReferenceOperation createMultiReferenceOperation() {
		MultiReferenceOperationImpl multiReferenceOperation = new MultiReferenceOperationImpl();
		return multiReferenceOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MultiReferenceSetOperation createMultiReferenceSetOperation() {
		MultiReferenceSetOperationImpl multiReferenceSetOperation = new MultiReferenceSetOperationImpl();
		return multiReferenceSetOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MultiReferenceMoveOperation createMultiReferenceMoveOperation() {
		MultiReferenceMoveOperationImpl multiReferenceMoveOperation = new MultiReferenceMoveOperationImpl();
		return multiReferenceMoveOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DiagramLayoutOperation createDiagramLayoutOperation() {
		DiagramLayoutOperationImpl diagramLayoutOperation = new DiagramLayoutOperationImpl();
		return diagramLayoutOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OperationId createOperationId() {
		OperationIdImpl operationId = new OperationIdImpl();
		return operationId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OperationGroup createOperationGroup() {
		OperationGroupImpl operationGroup = new OperationGroupImpl();
		return operationGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementGroup createModelElementGroup() {
		ModelElementGroupImpl modelElementGroup = new ModelElementGroupImpl();
		return modelElementGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ContainmentType createContainmentTypeFromString(EDataType eDataType, String initialValue) {
		ContainmentType result = ContainmentType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
				+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertContainmentTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OperationsPackage getOperationsPackage() {
		return (OperationsPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OperationsPackage getPackage() {
		return OperationsPackage.eINSTANCE;
	}

} // OperationsFactoryImpl
