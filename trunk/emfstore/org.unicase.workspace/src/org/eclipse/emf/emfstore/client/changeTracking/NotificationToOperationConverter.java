/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.changeTracking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.emfstore.client.changeTracking.notification.NotificationInfo;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ContainmentType;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeSetOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceSetOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.impl.ProjectImpl;
import org.unicase.metamodel.util.ModelUtil;

/**
 * Converts an EMF notification to an Operation.
 * 
 * @author chodnick
 */
public final class NotificationToOperationConverter {

	private Project project;

	/**
	 * Default constructor.
	 * 
	 * @param project project
	 */
	public NotificationToOperationConverter(Project project) {
		this.project = project;
	}

	/**
	 * Converts given notification to an operation. May return null if the notification signifies a no-op.
	 * 
	 * @param n the notification to convert
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
		setCommonValues(operation, n.getNotifierModelElement());
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

		MultiReferenceOperation op = OperationsFactory.eINSTANCE.createMultiReferenceOperation();
		setCommonValues(op, n.getNotifierModelElement());
		setBidirectionalAndContainmentInfo(op, n.getReference());
		op.setFeatureName(n.getReference().getName());
		op.setAdd(n.isAddEvent() || n.isAddManyEvent());
		op.setIndex(n.getPosition());
		List<ModelElementId> referencedModelElements = op.getReferencedModelElements();

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

		for (EObject valueElement : list) {
			ModelElementId id = project.getModelElementId(valueElement);
			if (id == null) {
				id = ((ProjectImpl) project).getDeletedModelElementId(valueElement);
			}
			if (id != null) {
				referencedModelElements.add(id);
			} else if (ModelUtil.getProject(valueElement) == project) {
				throw new IllegalStateException("Element in Project does not have an ID: " + valueElement);
			}
			// ignore value elements outside of the current project, they are not tracked
		}
		return op;

	}

	private AbstractOperation handleReferenceMove(NotificationInfo n) {

		MultiReferenceMoveOperation op = OperationsFactory.eINSTANCE.createMultiReferenceMoveOperation();
		setCommonValues(op, n.getNotifierModelElement());
		op.setFeatureName(n.getReference().getName());
		op.setReferencedModelElementId(project.getModelElementId(n.getNewModelElementValue()));
		op.setNewIndex(n.getPosition());
		op.setOldIndex((Integer) n.getOldValue());

		return op;
	}

	private AbstractOperation handleAttributeMove(NotificationInfo n) {
		MultiAttributeMoveOperation operation = OperationsFactory.eINSTANCE.createMultiAttributeMoveOperation();
		setCommonValues(operation, n.getNotifierModelElement());
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

			setCommonValues(op, n.getNotifierModelElement());
			op.setFeatureName(n.getAttribute().getName());
			op.setNewValue(n.getNewValue());
			op.setOldValue(n.getOldValue());
			return op;
		} else {

			MultiAttributeSetOperation setOperation = OperationsFactory.eINSTANCE.createMultiAttributeSetOperation();
			setCommonValues(setOperation, n.getNotifierModelElement());
			setOperation.setFeatureName(n.getAttribute().getName());
			setOperation.setNewValue(n.getNewValue());
			setOperation.setOldValue(n.getOldValue());
			setOperation.setIndex(n.getPosition());

			return setOperation;
		}
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
			SingleReferenceOperation op = OperationsFactory.eINSTANCE.createSingleReferenceOperation();
			setCommonValues(op, (EObject) n.getNotifier());
			op.setFeatureName(n.getReference().getName());
			setBidirectionalAndContainmentInfo(op, n.getReference());

			if (n.getOldValue() != null) {
				op.setOldValue(oldModelElementId);
			}

			if (n.getNewValue() != null) {
				op.setNewValue(newModelElementId);
			}

			return op;

		} else {
			MultiReferenceSetOperation setOperation = OperationsFactory.eINSTANCE.createMultiReferenceSetOperation();
			setCommonValues(setOperation, (EObject) n.getNotifier());
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
	private void setCommonValues(AbstractOperation operation, EObject modelElement) {
		operation.setClientDate(new Date());
		ModelElementId id = project.getModelElementId(modelElement);
		if (id == null) {
			id = ((ProjectImpl) project).getDeletedModelElementId(modelElement);
		}
		if (id == null) {
			throw new IllegalStateException("Model element doesn't have an ID.");
		}
		operation.setModelElementId(id);
	}

	private void setBidirectionalAndContainmentInfo(ReferenceOperation referenceOperation, EReference reference) {
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
		// FIXME: HACK to check if attribute is the layout of a diagram
		boolean isLayoutAttribute = attribute.getName().equals("diagramLayout");
		return isLayoutAttribute;
	}

}
