/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.changeTracking;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.DiagramLayoutOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.diagram.DiagramFactory;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.workspace.exceptions.UnknownNotificationImplementationException;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Helper class to parse operations from notifications.
 * 
 * @author koegel
 */
public final class OperationParser {

	/**
	 * Private constructor.
	 */
	private OperationParser() {
		// nothing to do
	}

	/**
	 * Create all neccessary operations for the notification. The created notifications will have the same effect on a
	 * model instance as the changes that triggered the notification.
	 * 
	 * @param notification the notification
	 * @param modelElement the model element the triggered the notification
	 * @return the list of operations
	 * @throws UnsupportedNotificationException if an unknown Notification occurs, that cannot be parsed
	 * @generated NOT
	 */
	public static List<AbstractOperation> parseOperations(final Notification notification, ModelElement modelElement)
		throws UnsupportedNotificationException {

		Object feature = notification.getFeature();
		Object newValue = notification.getNewValue();
		Object oldValue = notification.getOldValue();
		EAttribute attribute;
		EReference reference;
		// ignore non change notifications
		if (notification.isTouch()) {
			return new ArrayList<AbstractOperation>();
		}
		// parse attribute or reference from feature
		if (feature instanceof EAttribute) {
			attribute = (EAttribute) feature;
			reference = null;
		} else if (feature instanceof EReference) {
			reference = (EReference) feature;
			attribute = null;
		} else {
			throw new UnsupportedNotificationException("Notification contains unknown feature type: "
				+ feature.getClass().getCanonicalName());
		}
		// check if feature is transient
		if (isTransient(attribute, reference)) {
			return new ArrayList<AbstractOperation>();
		}

		switch (notification.getEventType()) {

		case Notification.SET:
			return handleSetNotification(notification, attribute, reference, modelElement, oldValue, newValue);
		case Notification.ADD:
			return handleAddNotification(notification, attribute, reference, modelElement, newValue);
		case Notification.REMOVE:
			return handleRemoveNotification(notification, attribute, reference, modelElement, oldValue);
			// check this
		case Notification.ADD_MANY:
			return handleAddManyNotification(notification, feature);
			// check this
		case Notification.REMOVE_MANY:
			return handleRemoveManyNotification(newValue);
			// check this
		case Notification.UNSET:
			return handleUnsetNotification(notification, feature);
			// check this
		case Notification.MOVE:
			return handleMoveNotification(notification, attribute, reference, modelElement, newValue, oldValue);
		default:
			throw new UnsupportedNotificationException("Unkown notification type: " + notification.getEventType());
		}
	}

	private static List<AbstractOperation> handleSetNotification(Notification notification, EAttribute attribute,
		EReference reference, ModelElement modelElement, Object oldValue, Object newValue)
		throws UnsupportedNotificationException {
		if (attribute != null) {
			if (isDiagramLayoutAttribute(attribute, modelElement)) {
				return makeList(createDiagramLayoutOperation(modelElement, attribute, newValue, oldValue));
			} else {
				return makeList(createAttributeOperation(modelElement, attribute, newValue, oldValue));
			}
		} else {
			return handleSetReference(notification, modelElement, reference, newValue, oldValue);
		}
	}

	private static List<AbstractOperation> handleAddNotification(final Notification notification, EAttribute attribute,
		EReference reference, ModelElement modelElement, Object newValue) throws UnsupportedNotificationException {
		if (attribute != null) {
			return makeList(createMultiAttributeOperation(notification, modelElement, newValue, attribute, true));
		} else {
			if (!(newValue instanceof ModelElement)) {
				// non model element references must be marked transient
				throw new UnsupportedNotificationException(
					"Non-transient non-modelElement reference feature detected: "
						+ modelElement.getClass().getCanonicalName() + "-" + reference.getName());
			}
			return handleChangeMultiReference(reference, modelElement, (ModelElement) newValue, notification, true);
		}
	}

	/**
	 * @param notification
	 * @param result
	 * @param feature
	 * @param oldValue
	 * @return
	 * @throws UnsupportedNotificationException
	 */
	private static List<AbstractOperation> handleRemoveNotification(final Notification notification,
		EAttribute attribute, EReference reference, ModelElement modelElement, Object oldValue)
		throws UnsupportedNotificationException {
		if (attribute != null) {
			return makeList(createMultiAttributeOperation(notification, modelElement, oldValue, attribute, false));
		} else {
			if (!(oldValue instanceof ModelElement)) {
				// non model element references must be marked transient
				throw new UnsupportedNotificationException(
					"Non-transient non-modelElement reference feature detected: "
						+ modelElement.getClass().getCanonicalName() + "-" + reference.getName());
			}
			return handleChangeMultiReference(reference, modelElement, (ModelElement) oldValue, notification, false);
		}
	}

	private static List<AbstractOperation> handleAddManyNotification(Notification notification, Object feature) {
		// FIXME MK: implement
		// throw new UnsupportedOperationException();
		return new ArrayList<AbstractOperation>();
	}

	private static List<AbstractOperation> handleRemoveManyNotification(Object newValue) {
		// FIXME MK: implement
		List<AbstractOperation> result = new ArrayList<AbstractOperation>();
		if (newValue == null) {
			return result;
		}
		throw new UnsupportedOperationException();
	}

	private static List<AbstractOperation> handleUnsetNotification(Notification notification, Object feature)
		throws UnsupportedNotificationException {
		throw new UnsupportedNotificationException("Cannot handle unset exceptions");
	}

	private static List<AbstractOperation> handleMoveNotification(final Notification notification,
		EAttribute attribute, EReference reference, ModelElement modelElement, Object newValue, Object oldValue)
		throws UnsupportedNotificationException {

		if (attribute != null) {
			throw new UnsupportedNotificationException(
				"Move notification on attribute feature with multiplicty greater 1 not supported yet!");
		} else {
			// sanity checks
			if (!(newValue instanceof ModelElement)) {
				// non model element references must be marked transient
				throw new UnsupportedNotificationException(
					"Non-transient non-modelElement reference feature detected: "
						+ modelElement.getClass().getCanonicalName() + "-" + reference.getName());
			}
			if (!(oldValue instanceof Integer)) {
				throw new UnsupportedNotificationException("Error with old position in move: not an Integer");
			}
			return makeList(createMultiReferenceMoveOperation(notification, modelElement, reference,
				(ModelElement) newValue, (Integer) oldValue));
		}
	}

	private static List<AbstractOperation> handleSetReference(Notification notification, ModelElement modelElement,
		EReference reference, Object newValueObject, Object oldValueObject) throws UnsupportedNotificationException {

		// sanity check newValue and oldValue
		boolean newValIsNoME = newValueObject != null && !(newValueObject instanceof ModelElement);
		boolean oldValIsNoME = oldValueObject != null && !(oldValueObject instanceof ModelElement);
		if (newValIsNoME || oldValIsNoME) {
			// non model element references must be marked transient
			throw new UnsupportedNotificationException("Non-transient non-modelElement reference feature detected: "
				+ modelElement.getClass().getCanonicalName() + "-" + reference.getName());
		}
		ModelElement newValue = (ModelElement) newValueObject;
		ModelElement oldValue = (ModelElement) oldValueObject;

		// handle bidirectional notifications
		if (oppositeNotificationForSingleRefFollows(reference, notification, newValue, oldValue)) {
			return new ArrayList<AbstractOperation>();
		}

		// single reference set
		return makeList(createSingleReferenceOperation(modelElement, oldValue, reference, newValue));

	}

	private static List<AbstractOperation> handleChangeMultiReference(EReference reference, ModelElement modelElement,
		ModelElement valueModelElement, Notification notification, boolean isAdd)
		throws UnsupportedNotificationException {

		// sanity checks
		if (!reference.isMany()) {
			throw new UnsupportedNotificationException(
				"Unkown notification state: Add notification on reference feature with isMany==false");
		}

		// handle bidirectional notifications
		if (oppositeNotificationForMultiRefFollows(notification, valueModelElement, reference)) {
			return new ArrayList<AbstractOperation>();
		}

		return makeList(createMultiReferenceOperation(notification, reference, valueModelElement, modelElement, isAdd));
	}

	private static AttributeOperation createAttributeOperation(ModelElement modelElement, Object feature,
		Object newValue, Object oldValue) {
		EAttribute attribute = (EAttribute) feature;
		AttributeOperation attributeOperation = OperationsFactory.eINSTANCE.createAttributeOperation();
		attributeOperation.setClientDate(new Date());
		attributeOperation.setFeatureName(attribute.getName());
		attributeOperation.setModelElementId(modelElement.getModelElementId());
		attributeOperation.setNewValue(newValue);
		attributeOperation.setOldValue(oldValue);
		return attributeOperation;
	}

	private static DiagramLayoutOperation createDiagramLayoutOperation(ModelElement modelElement, EAttribute attribute,
		Object newValue, Object oldValue) {
		DiagramLayoutOperation createDiagramLayoutOperation = OperationsFactory.eINSTANCE
			.createDiagramLayoutOperation();
		createDiagramLayoutOperation.setClientDate(new Date());
		createDiagramLayoutOperation.setFeatureName(attribute.getName());
		createDiagramLayoutOperation.setModelElementId((ModelElementId) EcoreUtil
			.copy(modelElement.getModelElementId()));
		createDiagramLayoutOperation.setNewValue(newValue);
		createDiagramLayoutOperation.setOldValue(oldValue);
		return createDiagramLayoutOperation;
	}

	private static SingleReferenceOperation createSingleReferenceOperation(ModelElement modelElement,
		ModelElement oldValue, EReference reference, ModelElement newValueME) {
		SingleReferenceOperation singleReferenceOperation = OperationsFactory.eINSTANCE
			.createSingleReferenceOperation();
		setCommonValues(singleReferenceOperation, modelElement);
		singleReferenceOperation.setFeatureName(reference.getName());
		setBidirectionalInfos(reference, singleReferenceOperation);
		if (oldValue != null) {
			singleReferenceOperation.setOldValue(oldValue.getModelElementId());
		}
		if (newValueME != null) {
			singleReferenceOperation.setNewValue(newValueME.getModelElementId());
		}
		return singleReferenceOperation;
	}

	private static MultiReferenceOperation createMultiReferenceOperation(Notification notification,
		EReference reference, ModelElement valueModelElement, ModelElement parent, boolean isAdd) {
		MultiReferenceOperation multiReferenceOperation = OperationsFactory.eINSTANCE.createMultiReferenceOperation();
		setCommonValues(multiReferenceOperation, parent);
		setBidirectionalInfos(reference, multiReferenceOperation);
		multiReferenceOperation.setFeatureName(reference.getName());
		multiReferenceOperation.setAdd(isAdd);
		multiReferenceOperation.setIndex(notification.getPosition());
		multiReferenceOperation.getReferencedModelElements().add(valueModelElement.getModelElementId());
		return multiReferenceOperation;
	}

	private static MultiReferenceMoveOperation createMultiReferenceMoveOperation(final Notification notification,
		ModelElement modelElement, EReference reference, ModelElement movedElement, Integer oldValue) {
		MultiReferenceMoveOperation multiReferenceMoveOperation = OperationsFactory.eINSTANCE
			.createMultiReferenceMoveOperation();
		setCommonValues(multiReferenceMoveOperation, modelElement);
		multiReferenceMoveOperation.setFeatureName(reference.getName());
		multiReferenceMoveOperation.setReferencedModelElementId(movedElement.getModelElementId());
		multiReferenceMoveOperation.setNewIndex(notification.getPosition());
		multiReferenceMoveOperation.setOldIndex(oldValue);
		return multiReferenceMoveOperation;
	}

	private static MultiAttributeOperation createMultiAttributeOperation(Notification notification,
		ModelElement modelElement, Object valueModelElement, EAttribute attribute, boolean isAdd) {
		MultiAttributeOperation multiAttributeOperation = OperationsFactory.eINSTANCE.createMultiAttributeOperation();
		setCommonValues(multiAttributeOperation, modelElement);
		multiAttributeOperation.setAdd(isAdd);
		multiAttributeOperation.setFeatureName(attribute.getName());
		multiAttributeOperation.setIndex(notification.getPosition());
		multiAttributeOperation.getValues().add(valueModelElement);
		return multiAttributeOperation;
	}

	private static void setCommonValues(AbstractOperation operation, ModelElement modelElement) {
		operation.setClientDate(new Date());
		operation.setModelElementId(modelElement.getModelElementId());
	}

	private static void setBidirectionalInfos(EReference reference, ReferenceOperation referenceOperation) {
		if (reference.getEOpposite() != null) {
			referenceOperation.setBidirectional(true);
			referenceOperation.setOppositeFeatureName(reference.getEOpposite().getName());
		} else {
			referenceOperation.setBidirectional(false);
		}
	}

	private static boolean oppositeNotificationForSingleRefFollows(EReference reference, Notification notification,
		ModelElement newValue, ModelElement oldValue) {
		// sanity checks
		if (reference.getEOpposite() == null) {
			return false;
		}

		// check if opposite feature
		Notification nextNotification;
		try {
			nextNotification = getNextNotification(notification);
		} catch (UnknownNotificationImplementationException e) {
			return false;
		}
		if (nextNotification == null || nextNotification.getFeature() != reference.getEOpposite()) {
			return false;
		}

		// check if values match
		if (newValue == null && nextNotification.getNotifier() == oldValue) {
			return true;
		} else if (oldValue == null && nextNotification.getNotifier() == newValue) {
			return true;
		}
		return false;
	}

	private static boolean oppositeNotificationForMultiRefFollows(Notification notification,
		ModelElement valueModelElement, EReference reference) {
		if (reference.getEOpposite() == null) {
			return false;
		}

		List<Notification> nextNotifications = getNextNotifications(notification);
		if (nextNotifications.size() < 1) {
			return false;
		}

		Notification nextNotification = nextNotifications.get(nextNotifications.size() - 1);
		boolean featureMatch = nextNotification.getFeature() == reference.getEOpposite();
		boolean valueMatch = nextNotification.getNotifier() == valueModelElement;
		return featureMatch && valueMatch;
	}

	/**
	 * Get private field next from Notification. Returns the follow up notification of a notification in case a
	 * bidrectional feature is changed
	 * 
	 * @param notification the notification
	 * @return the follow-up notification or null if there is none
	 */
	private static Notification getNextNotification(Notification notification)
		throws UnknownNotificationImplementationException {
		if (!(notification instanceof NotificationImpl)) {
			throw new UnknownNotificationImplementationException(notification);
		}
		try {
			Field declaredField = NotificationImpl.class.getDeclaredField("next");
			declaredField.setAccessible(true);
			Object object = declaredField.get(notification);
			Notification nextNotification = (Notification) object;

			return nextNotification;
			// exception handling will only log error since this is
			// not fatal if it fails, it just results in redundant
			// operations being created.
		} catch (SecurityException e) {
			WorkspaceUtil.logException("Access to next field of notification failed.", e);
			throw new UnknownNotificationImplementationException(notification, e);
		} catch (NoSuchFieldException e) {
			WorkspaceUtil.logException("Access to next field of notification failed.", e);
			throw new UnknownNotificationImplementationException(notification, e);
		} catch (IllegalArgumentException e) {
			WorkspaceUtil.logException("Access to next field of notification failed.", e);
			throw new UnknownNotificationImplementationException(notification, e);
		} catch (IllegalAccessException e) {
			WorkspaceUtil.logException("Access to next field of notification failed.", e);
			throw new UnknownNotificationImplementationException(notification, e);
		}
	}

	private static List<Notification> getNextNotifications(Notification notification) {
		List<Notification> result = new ArrayList<Notification>();
		Notification currentNotification;
		try {
			currentNotification = getNextNotification(notification);
		} catch (UnknownNotificationImplementationException e) {
			return result;
		}
		while (currentNotification != null) {
			result.add(currentNotification);
			try {
				currentNotification = getNextNotification(currentNotification);
			} catch (UnknownNotificationImplementationException e) {
				return result;
			}
		}
		return result;
	}

	private static boolean isDiagramLayoutAttribute(EAttribute attribute, ModelElement modelElement) {
		DiagramPackage diagramPackage = DiagramFactory.eINSTANCE.getDiagramPackage();
		boolean isLayoutAttribute = attribute.getName().equals(diagramPackage.getMEDiagram_DiagramLayout().getName());
		boolean isDiagramInstance = diagramPackage.getMEDiagram().isInstance(modelElement);
		return isLayoutAttribute && isDiagramInstance;
	}

	private static boolean isTransient(EAttribute attribute, EReference reference)
		throws UnsupportedNotificationException {
		if (attribute != null) {
			return attribute.isTransient();
		} else if (reference != null) {
			return reference.isTransient();
		} else {
			throw new UnsupportedNotificationException("Unkown feature class");
		}
	}

	private static List<AbstractOperation> makeList(AbstractOperation operation) {
		List<AbstractOperation> result = new ArrayList<AbstractOperation>();
		result.add(operation);
		return result;
	}

}
