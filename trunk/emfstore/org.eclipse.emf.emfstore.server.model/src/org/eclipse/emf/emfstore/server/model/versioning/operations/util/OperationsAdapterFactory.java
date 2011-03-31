/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.operations.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.model.IdentifiableElement;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.UniqueIdentifier;
import org.eclipse.emf.emfstore.server.model.versioning.operations.*;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AttributeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.DiagramLayoutOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.FeatureOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.ModelElementGroup;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeSetOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceMoveOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationGroup;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationId;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage
 * @generated
 */
public class OperationsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static OperationsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = OperationsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc --> This
	 * implementation returns <code>true</code> if the object is either the model's package or is an instance object of
	 * the model. <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationsSwitch<Adapter> modelSwitch = new OperationsSwitch<Adapter>() {
			@Override
			public Adapter caseAbstractOperation(AbstractOperation object) {
				return createAbstractOperationAdapter();
			}
			@Override
			public Adapter caseCompositeOperation(CompositeOperation object) {
				return createCompositeOperationAdapter();
			}
			@Override
			public Adapter caseFeatureOperation(FeatureOperation object) {
				return createFeatureOperationAdapter();
			}
			@Override
			public Adapter caseCreateDeleteOperation(CreateDeleteOperation object) {
				return createCreateDeleteOperationAdapter();
			}
			@Override
			public Adapter caseAttributeOperation(AttributeOperation object) {
				return createAttributeOperationAdapter();
			}
			@Override
			public Adapter caseMultiAttributeOperation(MultiAttributeOperation object) {
				return createMultiAttributeOperationAdapter();
			}
			@Override
			public Adapter caseMultiAttributeSetOperation(MultiAttributeSetOperation object) {
				return createMultiAttributeSetOperationAdapter();
			}
			@Override
			public Adapter caseMultiAttributeMoveOperation(MultiAttributeMoveOperation object) {
				return createMultiAttributeMoveOperationAdapter();
			}
			@Override
			public Adapter caseSingleReferenceOperation(SingleReferenceOperation object) {
				return createSingleReferenceOperationAdapter();
			}
			@Override
			public Adapter caseMultiReferenceSetOperation(MultiReferenceSetOperation object) {
				return createMultiReferenceSetOperationAdapter();
			}
			@Override
			public Adapter caseMultiReferenceOperation(MultiReferenceOperation object) {
				return createMultiReferenceOperationAdapter();
			}
			@Override
			public Adapter caseMultiReferenceMoveOperation(MultiReferenceMoveOperation object) {
				return createMultiReferenceMoveOperationAdapter();
			}
			@Override
			public Adapter caseReferenceOperation(ReferenceOperation object) {
				return createReferenceOperationAdapter();
			}
			@Override
			public Adapter caseDiagramLayoutOperation(DiagramLayoutOperation object) {
				return createDiagramLayoutOperationAdapter();
			}
			@Override
			public Adapter caseOperationId(OperationId object) {
				return createOperationIdAdapter();
			}
			@Override
			public Adapter caseOperationGroup(OperationGroup object) {
				return createOperationGroupAdapter();
			}
			@Override
			public Adapter caseModelElementGroup(ModelElementGroup object) {
				return createModelElementGroupAdapter();
			}
			@Override
			public Adapter caseEObjectToModelElementIdMap(Map.Entry<EObject, ModelElementId> object) {
				return createEObjectToModelElementIdMapAdapter();
			}
			@Override
			public Adapter caseIdentifiableElement(IdentifiableElement object) {
				return createIdentifiableElementAdapter();
			}
			@Override
			public Adapter caseUniqueIdentifier(UniqueIdentifier object) {
				return createUniqueIdentifierAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation <em>Abstract Operation</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation
	 * @generated
	 */
	public Adapter createAbstractOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation <em>Composite Operation</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation
	 * @generated
	 */
	public Adapter createCompositeOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.FeatureOperation <em>Feature Operation</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.FeatureOperation
	 * @generated
	 */
	public Adapter createFeatureOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation <em>Create Delete Operation</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation
	 * @generated
	 */
	public Adapter createCreateDeleteOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.AttributeOperation <em>Attribute Operation</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.AttributeOperation
	 * @generated
	 */
	public Adapter createAttributeOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeOperation <em>Multi Attribute Operation</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeOperation
	 * @generated
	 */
	public Adapter createMultiAttributeOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeSetOperation <em>Multi Attribute Set Operation</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so
	 * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeSetOperation
	 * @generated
	 */
	public Adapter createMultiAttributeSetOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation <em>Multi Attribute Move Operation</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so
	 * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation
	 * @generated
	 */
	public Adapter createMultiAttributeMoveOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation <em>Single Reference Operation</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation
	 * @generated
	 */
	public Adapter createSingleReferenceOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceOperation <em>Multi Reference Operation</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceOperation
	 * @generated
	 */
	public Adapter createMultiReferenceOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation <em>Multi Reference Set Operation</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so
	 * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation
	 * @generated
	 */
	public Adapter createMultiReferenceSetOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceMoveOperation <em>Multi Reference Move Operation</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so
	 * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceMoveOperation
	 * @generated
	 */
	public Adapter createMultiReferenceMoveOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation <em>Reference Operation</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation
	 * @generated
	 */
	public Adapter createReferenceOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.DiagramLayoutOperation <em>Diagram Layout Operation</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.DiagramLayoutOperation
	 * @generated
	 */
	public Adapter createDiagramLayoutOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.OperationId <em>Operation Id</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationId
	 * @generated
	 */
	public Adapter createOperationIdAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.OperationGroup <em>Operation Group</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationGroup
	 * @generated
	 */
	public Adapter createOperationGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.ModelElementGroup <em>Model Element Group</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.ModelElementGroup
	 * @generated
	 */
	public Adapter createModelElementGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EObject To Model Element Id Map</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so
	 * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createEObjectToModelElementIdMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.common.model.IdentifiableElement <em>Identifiable Element</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.common.model.IdentifiableElement
	 * @generated
	 */
	public Adapter createIdentifiableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.common.model.UniqueIdentifier <em>Unique Identifier</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.common.model.UniqueIdentifier
	 * @generated
	 */
	public Adapter createUniqueIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc --> This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // OperationsAdapterFactory
