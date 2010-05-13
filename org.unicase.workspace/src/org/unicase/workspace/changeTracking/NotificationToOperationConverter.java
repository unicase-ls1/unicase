/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.changeTracking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ContainmentType;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.workspace.changeTracking.notification.NotificationInfo;

/**
 * Converts an EMF notification to an Operation.
 * 
 * @author chodnick
 */
public final class NotificationToOperationConverter {

	// hide constructor, this class should be used statically only
	private NotificationToOperationConverter() {

	}

	/**
	 * Converts given notification to an operation. May return null if the notification signifies a no-op.
	 * 
	 * @param n the notification to convert
	 * @return the operation or null
	 */
	public static AbstractOperation convert(NotificationInfo n) {

		if (n.isTouch() || n.isTransient() || !n.isValid()) {
			return null;
		}

		System.out.println(n);

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
			return handleMove(n);

		default:
			return null;

		}
	}

	private static AbstractOperation handleMultiAttribute(NotificationInfo n) {
		return null;
	}

	@SuppressWarnings("unchecked")
	private static AbstractOperation handleMultiReference(NotificationInfo n) {

		MultiReferenceOperation op = OperationsFactory.eINSTANCE.createMultiReferenceOperation();
		setCommonValues(op, n.getNotifierModelElement());
		setBidirectionalAndContainmentInfo(op, n.getReference());
		op.setFeatureName(n.getReference().getName());
		op.setAdd(n.isAddEvent() || n.isAddManyEvent());
		op.setIndex(n.getPosition());
		List<ModelElementId> referencedModelElements = op.getReferencedModelElements();

		List<ModelElement> list = null;

		switch (n.getEventType()) {

		case Notification.ADD:
			list = new ArrayList<ModelElement>();
			list.add(n.getNewModelElementValue());
			break;
		case Notification.ADD_MANY:
			list = (List<ModelElement>) n.getNewValue();
			break;
		case Notification.REMOVE:
			list = new ArrayList<ModelElement>();
			list.add(n.getOldModelElementValue());
			break;
		case Notification.REMOVE_MANY:
			list = (List<ModelElement>) n.getOldValue();
			break;
		default:
			break;
		}

		for (ModelElement valueElement : list) {
			referencedModelElements.add(valueElement.getModelElementId());
		}
		return op;

	}

	private static AbstractOperation handleMove(NotificationInfo n) {

		MultiReferenceMoveOperation op = OperationsFactory.eINSTANCE.createMultiReferenceMoveOperation();
		setCommonValues(op, n.getNotifierModelElement());
		op.setFeatureName(n.getReference().getName());
		op.setReferencedModelElementId(n.getNewModelElementValue().getModelElementId());
		op.setNewIndex(n.getPosition());
		op.setOldIndex((Integer) n.getOldValue());

		return op;
	}

	private static AbstractOperation handleSetAttribute(NotificationInfo n) {

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

	}

	private static AbstractOperation handleSetReference(NotificationInfo n) {

		SingleReferenceOperation op = OperationsFactory.eINSTANCE.createSingleReferenceOperation();
		setCommonValues(op, (ModelElement) n.getNotifier());
		op.setFeatureName(n.getReference().getName());
		setBidirectionalAndContainmentInfo(op, n.getReference());

		if (n.getOldValue() != null) {
			op.setOldValue(n.getOldModelElementValue().getModelElementId());
		}

		if (n.getNewValue() != null) {
			op.setNewValue(n.getNewModelElementValue().getModelElementId());
		}
		return op;

	}

	// utility methods
	private static void setCommonValues(AbstractOperation operation, ModelElement modelElement) {
		operation.setClientDate(new Date());
		operation.setModelElementId(modelElement.getModelElementId());
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

	private static boolean isDiagramLayoutAttribute(EAttribute attribute, ModelElement modelElement) {
		// FIXME: HACK to check if attribute is the layout of a diagram
		boolean isLayoutAttribute = attribute.getName().equals("diagramLayout");
		return isLayoutAttribute;
	}

}
