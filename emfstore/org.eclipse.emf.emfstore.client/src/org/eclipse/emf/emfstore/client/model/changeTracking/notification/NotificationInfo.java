/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model.changeTracking.notification;

import java.lang.reflect.Field;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.common.model.Project;

/**
 * NotificationInfo is a type safe wrapper for EMF Notifications. It wraps a org.eclipse.emf.common.notify.Notification
 * and implements a few additional getter methods
 * 
 * @author chodnick
 */

public class NotificationInfo implements Notification {

	private Notification notification;
	private boolean valid;
	private String validationMessage;

	/**
	 * The constructor needs the notification to wrap.
	 * 
	 * @param n the notification to wrap
	 */
	public NotificationInfo(Notification n) {
		this.notification = n;
		NotificationValidator.getInstance().validate(this);
	}

	/**
	 * @return the structural feature affected
	 */
	public EStructuralFeature getStructuralFeature() {

		if (getFeature() instanceof EStructuralFeature) {
			return (EStructuralFeature) getFeature();
		}

		return null;

	}

	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * @param valid the valid to set
	 */
	protected void setValid(boolean valid) {
		this.valid = valid;
	}

	/**
	 * @return the validationMessage
	 */
	public String getValidationMessage() {
		return validationMessage;
	}

	/**
	 * @param validationMessage the validationMessage to set
	 */
	protected void setValidationMessage(String validationMessage) {
		this.validationMessage = validationMessage;
	}

	/**
	 * @return whether this notification signals a change of an attribute value
	 */
	public boolean isAttributeNotification() {
		return notification.getFeature() instanceof EAttribute;
	}

	/**
	 * @return whether this notification signals a change of a reference value
	 */
	public boolean isReferenceNotification() {
		return notification.getFeature() instanceof EReference;
	}

	/**
	 * @return the EAttribute if the notification relates to an attribute, null otherwise
	 */
	public EAttribute getAttribute() {
		if (isAttributeNotification()) {
			return (EAttribute) notification.getFeature();
		}
		return null;
	}

	/**
	 * @return the EReference if the notification relates to a reference feature, null otherwise
	 */
	public EReference getReference() {
		if (isReferenceNotification()) {
			return (EReference) notification.getFeature();
		}
		return null;
	}

	/**
	 * @return true if the changed feature is marked transient, false otherwise
	 */
	public boolean isTransient() {
		return (isReferenceNotification() && getReference().isTransient())
			|| (isAttributeNotification() && getAttribute().isTransient());
	}

	/**
	 * @return true if the event is of type Notification.ADD, false otherwise
	 */
	public boolean isAddEvent() {
		return this.getEventType() == Notification.ADD;
	}

	/**
	 * @return true if the event is of type Notification.REMOVE, false otherwise
	 */

	public boolean isRemoveEvent() {
		return this.getEventType() == Notification.REMOVE;
	}

	/**
	 * @return true if the event is of type Notification.SET, false otherwise
	 */

	public boolean isSetEvent() {
		return this.getEventType() == Notification.SET;
	}

	/**
	 * @return true if the event is of type Notification.ADD_MANY, false otherwise
	 */

	public boolean isAddManyEvent() {
		return this.getEventType() == Notification.ADD_MANY;
	}

	/**
	 * @return true if the event is of type Notification.REMOVE_MANY, false otherwise
	 */

	public boolean isRemoveManyEvent() {
		return this.getEventType() == Notification.REMOVE_MANY;
	}

	/**
	 * @return true if the event is of type Notification.MOVE, false otherwise
	 */
	public boolean isMoveEvent() {
		return this.getEventType() == Notification.MOVE;
	}

	/**
	 * @return true if this notification is followed by more notifications in a chain, false if this is the last
	 *         notification of a chain
	 */

	public boolean hasNext() {

		if (!(notification instanceof NotificationImpl)) {
			return false;
		}

		try {
			Field declaredField = NotificationImpl.class.getDeclaredField("next");
			declaredField.setAccessible(true);
			Object object = declaredField.get(notification);
			Notification nextNotification = (Notification) object;

			if (nextNotification == null) {
				return false;
			}

			// notifications from project are never propagated, thus considered nonexistent
			// however, they themselves might have followups
			if (nextNotification.getNotifier() instanceof Project) {
				NotificationInfo nextNextInfo = new NotificationInfo(nextNotification);
				return nextNextInfo.hasNext();
			} else {
				return true;
			}

			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (RuntimeException e) {
			WorkspaceUtil.logException("Access to next field of notification failed.", e);
			// END SUPRESS CATCH EXCEPTION
		} catch (IllegalAccessException e) {
			WorkspaceUtil.logException("Access to next field of notification failed.", e);
		} catch (NoSuchFieldException e) {
			WorkspaceUtil.logException("Access to next field of notification failed.", e);
		}
		return false;

	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getEventType()
	 */
	public int getEventType() {
		return notification.getEventType();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getFeature()
	 */
	public Object getFeature() {
		return notification.getFeature();
	}

	/**
	 * @param expectedClass @see org.eclipse.emf.common.notify.Notification#getFeatureID(java.lang.Class)
	 * @return @see org.eclipse.emf.common.notify.Notification#getFeatureID(java.lang.Class)
	 */
	public int getFeatureID(Class<?> expectedClass) {
		return notification.getFeatureID(expectedClass);
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getNewBooleanValue()
	 */

	public boolean getNewBooleanValue() {
		return notification.getNewBooleanValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getNewByteValue()
	 */
	public byte getNewByteValue() {
		return notification.getNewByteValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getNewCharValue()
	 */
	public char getNewCharValue() {
		return notification.getNewCharValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getNewDoubleValue()
	 */

	public double getNewDoubleValue() {
		return notification.getNewDoubleValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getNewFloatValue()
	 */
	public float getNewFloatValue() {
		return notification.getNewFloatValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getNewIntValue()
	 */
	public int getNewIntValue() {
		return notification.getNewIntValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getNewLongValue()
	 */
	public long getNewLongValue() {
		return notification.getNewLongValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getNewShortValue()
	 */
	public short getNewShortValue() {
		return notification.getNewShortValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getNewStringValue()
	 */
	public String getNewStringValue() {
		return notification.getNewStringValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getNewValue()
	 */
	public Object getNewValue() {
		return notification.getNewValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getNewValue()
	 */
	public EObject getNewModelElementValue() {
		return (EObject) notification.getNewValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getNotifier()
	 */
	public Object getNotifier() {
		return notification.getNotifier();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getOldBooleanValue()
	 */
	public boolean getOldBooleanValue() {
		return notification.getOldBooleanValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getOldByteValue()
	 */
	public byte getOldByteValue() {
		return notification.getOldByteValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getOldCharValue()
	 */
	public char getOldCharValue() {
		return notification.getOldCharValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getOldDoubleValue()
	 */
	public double getOldDoubleValue() {
		return notification.getOldDoubleValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getOldFloatValue()
	 */
	public float getOldFloatValue() {
		return notification.getOldFloatValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getOldIntValue()
	 */
	public int getOldIntValue() {
		return notification.getOldIntValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getOldLongValue()
	 */
	public long getOldLongValue() {
		return notification.getOldLongValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getOldShortValue()
	 */
	public short getOldShortValue() {
		return notification.getOldShortValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getOldStringValue()
	 */
	public String getOldStringValue() {
		return notification.getOldStringValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getOldValue()
	 */
	public Object getOldValue() {
		return notification.getOldValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getOldValue()
	 */
	public EObject getOldModelElementValue() {
		return (EObject) notification.getOldValue();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getPosition()
	 */
	public int getPosition() {
		return notification.getPosition();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#isReset()
	 */
	public boolean isReset() {
		return notification.isReset();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#isTouch()
	 */
	public boolean isTouch() {
		return notification.isTouch();
	}

	/**
	 * @param notification @see
	 *            org.eclipse.emf.common.notify.Notification#merge(org.eclipse.emf.common.notify.Notification)
	 * @return @see org.eclipse.emf.common.notify.Notification#merge(org.eclipse.emf.common.notify.Notification)
	 */
	public boolean merge(Notification notification) {
		return notification.merge(notification);
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#wasSet()
	 */
	public boolean wasSet() {
		return notification.wasSet();
	}

	/**
	 * @return @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return notification.toString();
	}

	/**
	 * @return @see org.eclipse.emf.common.notify.Notification#getNotifier()
	 */
	public EObject getNotifierModelElement() {
		return (EObject) notification.getNotifier();
	}

	/**
	 * @return a string useful for debugging only
	 */
	public String getDebugString() {
		StringBuilder sb = new StringBuilder();
		// handle type

		if (isAddEvent()) {
			sb.append("ADD");
		} else if (isSetEvent()) {
			sb.append("SET");
		} else if (isAddManyEvent()) {
			sb.append("ADD_MANY");
		} else if (isRemoveEvent()) {
			sb.append("REMOVE");
		} else if (isRemoveManyEvent()) {
			sb.append("REMOVE_MANY");
		} else if (isMoveEvent()) {
			sb.append("MOVE");
		} else {
			sb.append(getEventType());
		}

		sb.append(" val: " + getValidationMessage());
		EObject n = (EObject) notification.getNotifier();

		sb.append(" / on: " + extractName(n));
		sb.append(".");
		if (isAttributeNotification()) {
			sb.append(getAttribute().getName());
		} else if (isReferenceNotification()) {
			sb.append(getReference().getName());
		}
		sb.append(" / old: ");
		if (getOldValue() instanceof EObject) {
			sb.append(extractName((EObject) getOldValue()));
		} else {
			sb.append(getOldValue());
		}
		sb.append(" / new: ");
		if (getNewValue() instanceof EObject) {
			sb.append(extractName((EObject) getNewValue()));
		} else {
			sb.append(getNewValue());
		}

		return sb.toString();

	}

	private String extractName(EObject o) {

		if (o == null) {
			return null;
		}

		EStructuralFeature f = o.eClass().getEStructuralFeature("name");
		if (f != null && o.eGet(f) != null) {
			return "'" + (String) o.eGet(f) + "'";
		} else {
			return o.eClass().getName();
		}

	}

}
