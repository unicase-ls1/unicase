/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.implementation.operations.ExtractClassOperation;
import org.unicase.implementation.operations.ExtractSuperClassOperation;
import org.unicase.implementation.operations.InlineClassOperation;
import org.unicase.implementation.operations.InlineSuperClassOperation;
import org.unicase.implementation.operations.OperationsFactory;
import org.unicase.implementation.operations.OperationsPackage;
import org.unicase.implementation.operations.PartitionAssociationOperation;
import org.unicase.implementation.operations.PullUpOperation;
import org.unicase.implementation.operations.PushDownOperation;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class OperationsFactoryImpl extends EFactoryImpl implements OperationsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static OperationsFactory init() {
		try {
			OperationsFactory theOperationsFactory = (OperationsFactory)EPackage.Registry.INSTANCE.getEFactory("http://unicase.org/operations"); 
			if (theOperationsFactory != null) {
				return theOperationsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OperationsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION: return createExtractSuperClassOperation();
			case OperationsPackage.INLINE_SUPER_CLASS_OPERATION: return createInlineSuperClassOperation();
			case OperationsPackage.EXTRACT_CLASS_OPERATION: return createExtractClassOperation();
			case OperationsPackage.INLINE_CLASS_OPERATION: return createInlineClassOperation();
			case OperationsPackage.PARTITION_ASSOCIATION_OPERATION: return createPartitionAssociationOperation();
			case OperationsPackage.PUSH_DOWN_OPERATION: return createPushDownOperation();
			case OperationsPackage.PULL_UP_OPERATION: return createPullUpOperation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExtractSuperClassOperation createExtractSuperClassOperation() {
		ExtractSuperClassOperationImpl extractSuperClassOperation = new ExtractSuperClassOperationImpl();
		return extractSuperClassOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InlineSuperClassOperation createInlineSuperClassOperation() {
		InlineSuperClassOperationImpl inlineSuperClassOperation = new InlineSuperClassOperationImpl();
		return inlineSuperClassOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InlineClassOperation createInlineClassOperation() {
		InlineClassOperationImpl inlineClassOperation = new InlineClassOperationImpl();
		return inlineClassOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExtractClassOperation createExtractClassOperation() {
		ExtractClassOperationImpl extractClassOperation = new ExtractClassOperationImpl();
		return extractClassOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PartitionAssociationOperation createPartitionAssociationOperation() {
		PartitionAssociationOperationImpl partitionAssociationOperation = new PartitionAssociationOperationImpl();
		return partitionAssociationOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PushDownOperation createPushDownOperation() {
		PushDownOperationImpl pushDownOperation = new PushDownOperationImpl();
		return pushDownOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PullUpOperation createPullUpOperation() {
		PullUpOperationImpl pullUpOperation = new PullUpOperationImpl();
		return pullUpOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsPackage getOperationsPackage() {
		return (OperationsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OperationsPackage getPackage() {
		return OperationsPackage.eINSTANCE;
	}

} // OperationsFactoryImpl
