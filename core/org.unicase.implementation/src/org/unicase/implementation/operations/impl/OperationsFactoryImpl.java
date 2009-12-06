/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.implementation.operations.ExtractSuperClassOperation;
import org.unicase.implementation.operations.InlineClassOperation;
import org.unicase.implementation.operations.OperationsFactory;
import org.unicase.implementation.operations.OperationsPackage;
import org.unicase.implementation.operations.PartitionAssociationOperation;
import org.unicase.implementation.operations.PushDownAttributeOperation;

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
			OperationsFactory theOperationsFactory = (OperationsFactory)EPackage.Registry.INSTANCE.getEFactory("operations"); 
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
			case OperationsPackage.INLINE_CLASS_OPERATION: return createInlineClassOperation();
			case OperationsPackage.PARTITION_ASSOCIATION_OPERATION: return createPartitionAssociationOperation();
			case OperationsPackage.PUSH_DOWN_ATTRIBUTE_OPERATION: return createPushDownAttributeOperation();
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
	public InlineClassOperation createInlineClassOperation() {
		InlineClassOperationImpl inlineClassOperation = new InlineClassOperationImpl();
		return inlineClassOperation;
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
	public PushDownAttributeOperation createPushDownAttributeOperation() {
		PushDownAttributeOperationImpl pushDownAttributeOperation = new PushDownAttributeOperationImpl();
		return pushDownAttributeOperation;
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
