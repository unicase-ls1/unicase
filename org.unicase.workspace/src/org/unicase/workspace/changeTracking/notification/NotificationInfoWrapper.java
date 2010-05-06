package org.unicase.workspace.changeTracking.notification;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.ModelElementId;

public class NotificationInfoWrapper extends NotificationInfo {

	private ModelElementId id;

	public NotificationInfoWrapper(Notification n, EObject modelElement, ModelElementId deletedElementId) {
		super(n, modelElement);
	}

	public ModelElementId getId() {
		return id;
	}

}
