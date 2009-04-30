package org.unicase.workspace.changeTracking.notification;

import java.lang.reflect.Field;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.unicase.workspace.util.WorkspaceUtil;

public class NotificationInfo implements Notification {

	private Notification notification;

	public NotificationInfo(Notification n) {
		this.notification = n;
	}

	/**
	 * the added value of this class additional descriptor and info methods
	 */

	public boolean isAttributeNotification() {
		return notification.getFeature() instanceof EAttribute;
	}

	public boolean isReferenceNotification() {
		return notification.getFeature() instanceof EReference;
	}

	public EAttribute getAttribute() {
		if (isAttributeNotification()) {
			return (EAttribute) notification.getFeature();
		}
		return null;
	}

	public EReference getReference() {
		if (isReferenceNotification()) {
			return (EReference) notification.getFeature();
		}
		return null;
	}

	public boolean isTransient() {
		return (isReferenceNotification() && getReference().isTransient())
			|| (isAttributeNotification() && getAttribute().isTransient());
	}

	public boolean isAddEvent() {
		return this.getEventType() == Notification.ADD;
	}

	public boolean isRemoveEvent() {
		return this.getEventType() == Notification.REMOVE;
	}

	public boolean isSetEvent() {
		return this.getEventType() == Notification.SET;
	}

	public boolean isAddManyEvent() {
		return this.getEventType() == Notification.ADD_MANY;
	}

	public boolean isRemoveManyEvent() {
		return this.getEventType() == Notification.REMOVE_MANY;
	}

	public boolean hasNext() {

		if (!(notification instanceof NotificationImpl)) {
			return false;
		}

		try {
			Field declaredField = NotificationImpl.class.getDeclaredField("next");
			declaredField.setAccessible(true);
			Object object = declaredField.get(notification);
			Notification nextNotification = (Notification) object;

			return nextNotification != null;

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
	 * delegate methods, use eclipse to generate them for you...
	 */

	public int getEventType() {
		return notification.getEventType();
	}

	public Object getFeature() {
		return notification.getFeature();
	}

	public int getFeatureID(Class<?> expectedClass) {
		return notification.getFeatureID(expectedClass);
	}

	public boolean getNewBooleanValue() {
		return notification.getNewBooleanValue();
	}

	public byte getNewByteValue() {
		return notification.getNewByteValue();
	}

	public char getNewCharValue() {
		return notification.getNewCharValue();
	}

	public double getNewDoubleValue() {
		return notification.getNewDoubleValue();
	}

	public float getNewFloatValue() {
		return notification.getNewFloatValue();
	}

	public int getNewIntValue() {
		return notification.getNewIntValue();
	}

	public long getNewLongValue() {
		return notification.getNewLongValue();
	}

	public short getNewShortValue() {
		return notification.getNewShortValue();
	}

	public String getNewStringValue() {
		return notification.getNewStringValue();
	}

	public Object getNewValue() {
		return notification.getNewValue();
	}

	public Object getNotifier() {
		return notification.getNotifier();
	}

	public boolean getOldBooleanValue() {
		return notification.getOldBooleanValue();
	}

	public byte getOldByteValue() {
		return notification.getOldByteValue();
	}

	public char getOldCharValue() {
		return notification.getOldCharValue();
	}

	public double getOldDoubleValue() {
		return notification.getOldDoubleValue();
	}

	public float getOldFloatValue() {
		return notification.getOldFloatValue();
	}

	public int getOldIntValue() {
		return notification.getOldIntValue();
	}

	public long getOldLongValue() {
		return notification.getOldLongValue();
	}

	public short getOldShortValue() {
		return notification.getOldShortValue();
	}

	public String getOldStringValue() {
		return notification.getOldStringValue();
	}

	public Object getOldValue() {
		return notification.getOldValue();
	}

	public int getPosition() {
		return notification.getPosition();
	}

	public boolean isReset() {
		return notification.isReset();
	}

	public boolean isTouch() {
		return notification.isTouch();
	}

	public boolean merge(Notification notification) {
		return notification.merge(notification);
	}

	public boolean wasSet() {
		return notification.wasSet();
	}

	@Override
	public String toString() {
		return notification.toString();
	}

}
