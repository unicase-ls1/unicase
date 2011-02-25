/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.changeTracking.notification;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.unicase.metamodel.ModelElement;

/**
 * Validates an EMF notification. Optionally generates a status message, describing potential problems.
 * 
 * @author chodnick
 */
final class NotificationValidator {

	private static NotificationValidator instance;

	/**
	 * Singleton access.
	 * 
	 * @return the validator instance
	 */
	public static NotificationValidator getInstance() {
		if (instance == null) {
			instance = new NotificationValidator();
		}
		return instance;
	}

	private NotificationValidator() {

	}

	/**
	 * Validates a notification and sets its valid flag and validationmessage string.
	 * 
	 * @param n the notification to validate
	 * @return
	 */
	protected void validate(NotificationInfo n) {

		if (n == null) {
			throw new IllegalArgumentException("NotificationInfo argument cannot be null");
		}

		// assume notification is valid, handlers will reset state and message, if something is wrong
		n.setValid(true);
		n.setValidationMessage("OK");

		// consider touch and transient notification to always be valid
		if (n.isTouch() || n.isTransient()) {
			return;
		}

		switch (n.getEventType()) {

		case Notification.SET:
			handleSetNotification(n);
			break;
		case Notification.ADD:
			handleAddNotification(n);
			break;
		case Notification.REMOVE:
			handleRemoveNotification(n);
			break;
		case Notification.ADD_MANY:
			handleAddManyNotification(n);
			break;
		case Notification.REMOVE_MANY:
			handleRemoveManyNotification(n);
			break;
		case Notification.UNSET:
			handleUnsetNotification(n);
			break;
		case Notification.MOVE:
			handleMoveNotification(n);
			break;
		default:
			handleUnknownNotification(n);
			break;
		}

	}

	private void handleUnknownNotification(NotificationInfo n) {
		n.setValid(false);
		n.setValidationMessage("Error: unknown notification event type. " + n.toString());
	}

	private void handleMoveNotification(NotificationInfo n) {

		// if (n.isAttributeNotification()) {
		// n.setValid(false);
		// n.setValidationMessage("MOVE notification on attribute feature with multiplicty"
		// + "greater 1 not supported yet!");
		// return;
		// }

		if (n.isReferenceNotification()) {
			// sanity checks
			if (n.getNewValue() == null || n.getOldValue() == null) {
				n.setValid(false);
				n.setValidationMessage("Null detected in oldValue or NewValue of move notification about: "
					+ n.getNotifier().getClass().getCanonicalName() + "-" + n.getReference().getName());
				return;
			}

			if (!(n.getNewValue() instanceof ModelElement)) {
				// non model element references must be marked transient

				n.setValid(false);
				n.setValidationMessage("Non-transient non-modelElement reference feature detected: "
					+ n.getNotifier().getClass().getCanonicalName() + "-" + n.getReference().getName());
				return;
			}

			if (!(n.getOldValue() instanceof Integer)) {
				n.setValid(false);
				n.setValidationMessage("Error with old position in move: not an Integer");
				return;
			}

		}

	}

	private void handleUnsetNotification(NotificationInfo n) {
		n.setValid(false);
		n.setValidationMessage("Cannot handle UNSET notifications");
	}

	private void handleRemoveManyNotification(NotificationInfo n) {

		// // attributes not allowed for REMOVE_MANY (yet)
		// if (n.isAttributeNotification()) {
		// n.setValid(false);
		// n.setValidationMessage("REMOVE_MANY on attribute feature with multiplicity greater"
		// + "than 1 not yet supported.");
		// return;
		// }

		// reference validation
		if (n.isReferenceNotification()) {

			// the new guys must come in a list
			if (!(n.getOldValue() instanceof List<?>)) {
				n.setValid(false);
				n.setValidationMessage("Non-List oldValue argument for REMOVE_MANY notification on: "
					+ n.getNotifier().getClass().getCanonicalName() + "-" + n.getReference().getName());
				return;
			}

			// new values must always be model elements
			if (!checkModelElementList((List<?>) n.getOldValue())) {
				n.setValid(false);
				n.setValidationMessage(n.getNotifier().getClass().getCanonicalName() + "-" + n.getReference().getName()
					+ " reference feature contains a non-model element.");
				return;
			}

			// checking up on EMF, the reference must have max multiplicity greater than 1...
			if (!n.getReference().isMany()) {
				n.setValid(false);
				n.setValidationMessage("Unkown notification state: REMOVE_MANY notification on reference "
					+ "feature with isMany==false");
				return;
			}

		}
	}

	private void handleAddManyNotification(NotificationInfo n) {

		// TODO add validation
		// // attributes not allowed for ADD_MANY (yet)
		// if (n.isAttributeNotification()) {
		// n.setValid(false);
		// n.setValidationMessage("ADD_MANY on attribute feature with multiplicity greater than 1 not yet supported.");
		// return;
		// }

		// reference validation
		if (n.isReferenceNotification()) {

			// the new guys must come in a list
			if (!(n.getNewValue() instanceof List<?>)) {
				n.setValid(false);
				n.setValidationMessage("Non-List newValue argument for ADD_MANY notification on: "
					+ n.getNotifier().getClass().getCanonicalName() + "-" + n.getReference().getName());
				return;
			}

			// new values must always be model elements
			if (!checkModelElementList((List<?>) n.getNewValue())) {
				n.setValid(false);
				n.setValidationMessage(n.getNotifier().getClass().getCanonicalName() + "-" + n.getReference().getName()
					+ " reference feature contains a non-model element.");
				return;
			}

			// checking up on EMF, the reference must have max multiplicity greater than 1...
			if (!n.getReference().isMany()) {
				n.setValid(false);
				n.setValidationMessage("Unkown notification state: ADD_MANY notification on reference "
					+ "feature with isMany==false");
				return;
			}

		}

	}

	private void handleRemoveNotification(NotificationInfo n) {

		// validation for REMOVE reference
		if (n.isReferenceNotification()) {

			// non model element references must be marked transient
			if (!(n.getOldValue() instanceof ModelElement)) {
				n.setValid(false);
				n.setValidationMessage("Non-transient non-modelElement reference feature detected: "
					+ n.getNotifier().getClass().getCanonicalName() + "-" + n.getReference().getName());
				return;

			}

			// checking up on EMF...
			if (!n.getReference().isMany()) {
				n.setValid(false);
				n.setValidationMessage("Unkown notification state: REMOVE notification on reference "
					+ "feature with isMany==false");
			}

		}

		// no validation for REMOVE attribute

	}

	private void handleAddNotification(NotificationInfo n) {

		// validation for ADD reference
		if (n.isReferenceNotification()) {

			// non model element references must be marked transient
			if (!(n.getNewValue() instanceof ModelElement)) {
				n.setValid(false);
				n.setValidationMessage("Non-transient non-modelElement reference feature detected: "
					+ n.getNotifier().getClass().getCanonicalName() + "-" + n.getReference().getName());
				return;

			}

			// checking up on EMF...
			if (!n.getReference().isMany()) {
				n.setValid(false);
				n.setValidationMessage("Unkown notification state: ADD notification on reference "
					+ "feature with isMany==false");
			}

		}

		// no validation for ADD attribute

	}

	private void handleSetNotification(NotificationInfo n) {

		// validation for SET reference

		if (n.isReferenceNotification()) {

			// sanity check newValue and oldValue must be ModelElements or null
			Object newValueObject = n.getNewValue();
			Object oldValueObject = n.getOldValue();

			boolean newValIsNoME = newValueObject != null && !(newValueObject instanceof ModelElement);
			boolean oldValIsNoME = oldValueObject != null && !(oldValueObject instanceof ModelElement);
			if (newValIsNoME || oldValIsNoME) {
				// non model element references must be marked transient
				n.setValid(false);
				n.setValidationMessage("Non-transient non-modelElement reference feature detected: "
					+ n.getNotifier().getClass().getCanonicalName() + "-" + n.getReference().getName());
				return;
			}

		}

		// no validation for SET attribute

	}

	private boolean checkModelElementList(List<?> aList) {

		for (Object value : aList) {
			if (!(value instanceof ModelElement)) {
				return false;
			}
		}

		return true;

	}

}
