/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model.changeTracking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.emfstore.client.model.changeTracking.notification.NotificationInfo;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.common.model.IdEObjectCollection;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.impl.ProjectImpl;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AttributeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.ContainmentType;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeSetOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceMoveOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsFactory;
import org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation;

/**
 * Converts an EMF notification to an Operation.
 * 
 * @author chodnick
 */
public final class NotificationToOperationConverter {

	private IdEObjectCollection project;

	/**
	 * Default constructor.
	 * 
	 * @param project
	 *            project
	 */
	public NotificationToOperationConverter(IdEObjectCollection project) {
		this.project = project;
	}

	/**
	 * Converts given notification to an operation. May return null if the
	 * notification signifies a no-op.
	 * 
	 * @param n
	 *            the notification to convert
	 * @return the operation or null
	 */
	// BEGIN COMPLEX CODE
	public AbstractOperation convert(NotificationInfo n) {

		if (n.isTouch() || n.isTransient() || !n.isValid()) {
			return null;
		}

		switch (n.getEventType()) {

		case Notification.SET:
			if (n.isAttributeNotification()) {
				return handleSetAttribute(n);
			} else {
				return handleSetReference(n);
			}

		case Notification.ADD:
			if (n.isAttributeNotification()) {
				return handleMultiAttribute(n);
			} else {
				return handleMultiReference(n);
			}

		case Notification.ADD_MANY:
			if (n.isAttributeNotification()) {
				return handleMultiAttribute(n);
			} else {
				return handleMultiReference(n);
			}

		case Notification.REMOVE:
			if (n.isAttributeNotification()) {
				return handleMultiAttribute(n);
			} else {
				return handleMultiReference(n);
			}

		case Notification.REMOVE_MANY:
			if (n.isAttributeNotification()) {
				return handleMultiAttribute(n);
			} else {
				return handleMultiReference(n);
			}

		case Notification.MOVE:
			if (n.isAttributeNotification()) {
				return handleAttributeMove(n);
			} else {
				return handleReferenceMove(n);
			}

		default:
			return null;
		}
	}

	// END COMPLEX CODE

	@SuppressWarnings("unchecked")
	private AbstractOperation handleMultiAttribute(NotificationInfo n) {
		MultiAttributeOperation operation = OperationsFactory.eINSTANCE.createMultiAttributeOperation();
		setCommonValues(project, operation, n.getNotifierModelElement());
		operation.setFeatureName(n.getAttribute().getName());
		operation.setAdd(n.isAddEvent() || n.isAddManyEvent());
		// operation.setIndex(n.getPosition());

		List<Object> list = null;

		switch (n.getEventType()) {

		case Notification.ADD:
			list = new ArrayList<Object>();
			operation.getIndexes().add(n.getPosition());
			list.add(n.getNewValue());
			break;
		case Notification.ADD_MANY:
			list = (List<Object>) n.getNewValue();
			for (int i = 0; i < list.size(); i++) {
				operation.getIndexes().add(n.getPosition() + i);
			}
			break;
		case Notification.REMOVE:
			list = new ArrayList<Object>();
			operation.getIndexes().add(n.getPosition());
			list.add(n.getOldValue());
			break;
		case Notification.REMOVE_MANY:
			list = (List<Object>) n.getOldValue();
			if (n.getNewValue() == null) {
				for (int i = 0; i < list.size(); i++) {
					operation.getIndexes().add(i);
				}
			} else {
				for (int value : ((int[]) n.getNewValue())) {
					operation.getIndexes().add(value);
				}
			}
			break;
		default:
			break;
		}

		for (Object valueElement : list) {
			operation.getReferencedValues().add(valueElement);
		}

		return operation;
	}

	@SuppressWarnings("unchecked")
	private AbstractOperation handleMultiReference(NotificationInfo n) {

		List<EObject> list = null;

		switch (n.getEventType()) {
		case Notification.ADD:
			list = new ArrayList<EObject>();
			list.add(n.getNewModelElementValue());
			break;
		case Notification.ADD_MANY:
			list = (List<EObject>) n.getNewValue();
			break;
		case Notification.REMOVE:
			list = new ArrayList<EObject>();
			list.add(n.getOldModelElementValue());
			break;
		case Notification.REMOVE_MANY:
			list = (List<EObject>) n.getOldValue();
			break;
		default:
			break;
		}

		boolean isAdd = n.isAddEvent() || n.isAddManyEvent();

		return createMultiReferenceOperation(project, n.getNotifierModelElement(), n.getReference(), list, isAdd,
			n.getPosition());
	}

	public static MultiReferenceOperation createMultiReferenceOperation(IdEObjectCollection collection,
		EObject modelElement, EReference reference, List<EObject> referencedElements, boolean isAdd, int position) {
		MultiReferenceOperation op = OperationsFactory.eINSTANCE.createMultiReferenceOperation();
		setCommonValues(collection, op, modelElement);
		setBidirectionalAndContainmentInfo(op, reference);
		op.setFeatureName(reference.getName());
		op.setAdd(isAdd);
		op.setIndex(position);
		List<ModelElementId> referencedModelElements = op.getReferencedModelElements();

		for (EObject valueElement : referencedElements) {
			ModelElementId id = collection.getModelElementId(valueElement);
			if (id == null) {
				id = collection.getDeletedModelElementId(valueElement);
			}
			if (id != null) {
				referencedModelElements.add(id);
			} else if (ModelUtil.getProject(valueElement) == collection) {
				throw new IllegalStateException("Element in Project does not have an ID: " + valueElement);
			}
			// ignore value elements outside of the current project, they are
			// not tracked
		}
		return op;

	}

	private AbstractOperation handleReferenceMove(NotificationInfo n) {

		MultiReferenceMoveOperation op = OperationsFactory.eINSTANCE.createMultiReferenceMoveOperation();
		setCommonValues(project, op, n.getNotifierModelElement());
		op.setFeatureName(n.getReference().getName());
		op.setReferencedModelElementId(project.getModelElementId(n.getNewModelElementValue()));
		op.setNewIndex(n.getPosition());
		op.setOldIndex((Integer) n.getOldValue());

		return op;
	}

	private AbstractOperation handleAttributeMove(NotificationInfo n) {
		MultiAttributeMoveOperation operation = OperationsFactory.eINSTANCE.createMultiAttributeMoveOperation();
		setCommonValues(project, operation, n.getNotifierModelElement());
		operation.setFeatureName(n.getAttribute().getName());
		operation.setNewIndex(n.getPosition());
		operation.setOldIndex((Integer) n.getOldValue());
		operation.setReferencedValue(n.getNewValue());
		return operation;
	}

	private AbstractOperation handleSetAttribute(NotificationInfo n) {

		if (!n.getAttribute().isMany()) {
			AttributeOperation op = null;
			// special handling for diagram layout changes
			if (isDiagramLayoutAttribute(n.getAttribute(), n.getNotifierModelElement())) {
				op = OperationsFactory.eINSTANCE.createDiagramLayoutOperation();
			} else {
				op = OperationsFactory.eINSTANCE.createAttributeOperation();
			}

			setCommonValues(project, op, n.getNotifierModelElement());
			op.setFeatureName(n.getAttribute().getName());
			op.setNewValue(n.getNewValue());
			op.setOldValue(n.getOldValue());
			return op;
		} else {

			MultiAttributeSetOperation setOperation = OperationsFactory.eINSTANCE.createMultiAttributeSetOperation();
			setCommonValues(project, setOperation, n.getNotifierModelElement());
			setOperation.setFeatureName(n.getAttribute().getName());
			setOperation.setNewValue(n.getNewValue());
			setOperation.setOldValue(n.getOldValue());
			setOperation.setIndex(n.getPosition());

			return setOperation;
		}
	}

	public static SingleReferenceOperation createSingleReferenceOperation(IdEObjectCollection collection,
		ModelElementId oldReference, ModelElementId newReference, EReference reference, EObject modelElement) {

		SingleReferenceOperation op = OperationsFactory.eINSTANCE.createSingleReferenceOperation();
		setCommonValues(collection, op, modelElement);
		op.setFeatureName(reference.getName());
		setBidirectionalAndContainmentInfo(op, reference);

		op.setOldValue(oldReference);
		op.setNewValue(newReference);

		return op;
	}

	private AbstractOperation handleSetReference(NotificationInfo n) {

		ModelElementId oldModelElementId = project.getModelElementId(n.getOldModelElementValue());
		ModelElementId newModelElementId = project.getModelElementId(n.getNewModelElementValue());

		if (oldModelElementId == null) {
			oldModelElementId = ((ProjectImpl) project).getDeletedModelElementId(n.getOldModelElementValue());
		}

		if (newModelElementId == null) {
			newModelElementId = ((ProjectImpl) project).getDeletedModelElementId(n.getNewModelElementValue());
		}

		if (!n.getReference().isMany()) {
			return createSingleReferenceOperation(project, oldModelElementId, newModelElementId, n.getReference(),
				n.getNotifierModelElement());
		} else {
			MultiReferenceSetOperation setOperation = OperationsFactory.eINSTANCE.createMultiReferenceSetOperation();
			setCommonValues(project, setOperation, (EObject) n.getNotifier());
			setOperation.setFeatureName(n.getReference().getName());
			setBidirectionalAndContainmentInfo(setOperation, n.getReference());

			setOperation.setIndex(n.getPosition());

			if (n.getOldValue() != null) {
				setOperation.setOldValue(oldModelElementId);
			}

			if (n.getNewValue() != null) {
				setOperation.setNewValue(newModelElementId);
			}

			return setOperation;
		}
	}

	// utility methods
	private static void setCommonValues(IdEObjectCollection collection, AbstractOperation operation,
		EObject modelElement) {
		operation.setClientDate(new Date());
		ModelElementId id = collection.getModelElementId(modelElement);
		if (id == null) {
			id = collection.getDeletedModelElementId(modelElement);
		}
		if (id == null) {
			WorkspaceUtil.handleException(new IllegalStateException("Model Element does not have an ID: "
				+ modelElement));
		}
		operation.setModelElementId(id);
	}

	private static void setBidirectionalAndContainmentInfo(ReferenceOperation referenceOperation, EReference reference) {
		if (reference.getEOpposite() != null) {
			referenceOperation.setBidirectional(true);
			referenceOperation.setOppositeFeatureName(reference.getEOpposite().getName());
		} else {
			referenceOperation.setBidirectional(false);
		}
		if (reference.isContainer()) {
			referenceOperation.setContainmentType(ContainmentType.CONTAINER);
		}
		if (reference.isContainment()) {
			referenceOperation.setContainmentType(ContainmentType.CONTAINMENT);
		}
	}

	private boolean isDiagramLayoutAttribute(EAttribute attribute, EObject modelElement) {
		// FIXME: to check if attribute is the layout of a diagram
		boolean isLayoutAttribute = attribute.getName().equals("diagramLayout");
		return isLayoutAttribute;
	}

}
