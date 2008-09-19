/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.emfstore.esmodel.versioning.operations.*;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AtomicOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateOperation;
import org.unicase.emfstore.esmodel.versioning.operations.DeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OperationsFactoryImpl extends EFactoryImpl implements
		OperationsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case OperationsPackage.ABSTRACT_OPERATION:
			return createAbstractOperation();
		case OperationsPackage.COMPOSITE_OPERATION:
			return createCompositeOperation();
		case OperationsPackage.CREATE_OPERATION:
			return createCreateOperation();
		case OperationsPackage.DELETE_OPERATION:
			return createDeleteOperation();
		case OperationsPackage.ATOMIC_OPERATION:
			return createAtomicOperation();
		case OperationsPackage.REFERENCE_OPERATION:
			return createReferenceOperation();
		case OperationsPackage.ATTRIBUTE_OPERATION:
			return createAttributeOperation();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractOperation createAbstractOperation() {
		AbstractOperationImpl abstractOperation = new AbstractOperationImpl();
		return abstractOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeOperation createCompositeOperation() {
		CompositeOperationImpl compositeOperation = new CompositeOperationImpl();
		return compositeOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateOperation createCreateOperation() {
		CreateOperationImpl createOperation = new CreateOperationImpl();
		return createOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteOperation createDeleteOperation() {
		DeleteOperationImpl deleteOperation = new DeleteOperationImpl();
		return deleteOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicOperation createAtomicOperation() {
		AtomicOperationImpl atomicOperation = new AtomicOperationImpl();
		return atomicOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceOperation createReferenceOperation() {
		ReferenceOperationImpl referenceOperation = new ReferenceOperationImpl();
		return referenceOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeOperation createAttributeOperation() {
		AttributeOperationImpl attributeOperation = new AttributeOperationImpl();
		return attributeOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsPackage getOperationsPackage() {
		return (OperationsPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OperationsPackage getPackage() {
		return OperationsPackage.eINSTANCE;
	}

} //OperationsFactoryImpl
