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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ContainmentType;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.impl.EObjectToModelElementIdMapImpl;
import org.unicase.metamodel.util.ModelUtil;
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

		switch (n.getEventType()) {

		case Notification.SET:
			if (n.isAttributeNotification()) {
				return handleSetAttribute(n);
			} else {
				return handleSetReference(n);
			}

		case Notification.ADD:
			if (n.isAttributeNotification()) {
				// not supported
				return null;
			} else {
				return handleMultiReference(n);
			}

		case Notification.ADD_MANY:
			if (n.isAttributeNotification()) {
				// not supported
				return null;
			} else {
				return handleMultiReference(n);
			}

		case Notification.REMOVE:
			if (n.isAttributeNotification()) {
				// not supported
				return null;
			} else {
				return handleMultiReference(n);
			}

		case Notification.REMOVE_MANY:
			if (n.isAttributeNotification()) {
				// not supported
				return null;
			} else {
				return handleMultiReference(n);
			}

		case Notification.MOVE:
			return handleMove(n);

		default:
			return null;

		}
	}

	@SuppressWarnings("unchecked")
	private static AbstractOperation handleMultiReference(NotificationInfo n) {

		MultiReferenceOperation op = OperationsFactory.eINSTANCE.createMultiReferenceOperation();
		setCommonValues(op, n);
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
			Project project = ModelUtil.getProject(valueElement);
			// TODO: EMFPlainEObjectTransition
			if (project != null && !(valueElement instanceof EObjectToModelElementIdMapImpl)) {
				referencedModelElements.add(project.getModelElementId(valueElement));
			} else {
				if (n.getEventType() == Notification.REMOVE) {
					// try to retrieve project via a possibly related parent element
					if (n.getNotifierModelElement() != null) {
						EObject parent = n.getNotifierModelElement();
						project = ModelUtil.getProject(parent);
						referencedModelElements.add(project.getModelElementId(valueElement));
					}
				}
			}
		}
		return op;

	}

	private static AbstractOperation handleMove(NotificationInfo n) {

		MultiReferenceMoveOperation op = OperationsFactory.eINSTANCE.createMultiReferenceMoveOperation();
		setCommonValues(op, n);
		op.setFeatureName(n.getReference().getName());
		op.setReferencedModelElementId(ModelUtil.getProject(n.getNewModelElementValue()).getModelElementId(
			n.getNewModelElementValue()));
		op.setNewIndex(n.getPosition());
		op.setOldIndex((Integer) n.getOldValue());

		return op;
	}

	private static AbstractOperation handleSetAttribute(NotificationInfo n) {

		AttributeOperation op = null;

		// special handling for diagram layout changes
		if (isDiagramLayoutAttribute(n.getAttribute())) {
			op = OperationsFactory.eINSTANCE.createDiagramLayoutOperation();
		} else {
			op = OperationsFactory.eINSTANCE.createAttributeOperation();
		}

		setCommonValues(op, n);
		op.setFeatureName(n.getAttribute().getName());
		op.setNewValue(n.getNewValue());
		op.setOldValue(n.getOldValue());
		return op;

	}

	private static AbstractOperation handleSetReference(NotificationInfo n) {

		SingleReferenceOperation op = OperationsFactory.eINSTANCE.createSingleReferenceOperation();
		setCommonValues(op, n);
		op.setFeatureName(n.getReference().getName());
		setBidirectionalAndContainmentInfo(op, n.getReference());

		// ModelUtil.getProject(n.getOldModelElementValue());
		if (n.getOldValue() != null) {
			EObject obj = (EObject) n.getOldValue();
			Project p = ModelUtil.getProject(obj);

			if (p != null) {
				op.setOldValue(p.getModelElementId(obj));
			} else {
				// try to retrieve project elsewise in case of deleted element
				// has no container
				p = ModelUtil.getProject(n.getNotifierModelElement());
				ModelElementId id = p.getModelElementId(obj);
				op.setOldValue(id);
			}
		}

		if (n.getNewValue() != null) {
			// TOOD op.setNewValue(n.getNewModelElementValueId());
			EObject obj = (EObject) n.getNewValue();
			Project p = ModelUtil.getProject(obj);

			if (p != null) {
				op.setNewValue(p.getModelElementId(obj));
			}
		}
		return op;

	}

	// utility methods
	private static void setCommonValues(AbstractOperation operation, NotificationInfo n) {
		operation.setClientDate(new Date());
		EObject modelElement = n.getNotifierModelElement();
		Project p = ModelUtil.getProject(modelElement);
		if (p != null) {
			operation.setModelElementId(p.getModelElementId(modelElement));
		} else {
			// TODO: EMFStore
			// try to retrieve project via old parent
			if (n.getOldValue() != null && n.getOldValue() instanceof EObject) {
				p = ModelUtil.getProject((EObject) n.getOldValue());
				operation.setModelElementId(p.getModelElementId(modelElement));
			}
		}
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

	private static boolean isDiagramLayoutAttribute(EAttribute attribute) {
		// FIXME: HACK to check if attribute is the layout of a diagram
		boolean isLayoutAttribute = attribute.getName().equals("diagramLayout");
		return isLayoutAttribute;
	}

}
