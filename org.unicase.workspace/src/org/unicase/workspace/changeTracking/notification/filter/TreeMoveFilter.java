package org.unicase.workspace.changeTracking.notification.filter;

import java.util.List;

import org.unicase.workspace.changeTracking.notification.NotificationInfo;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecording;

public class TreeMoveFilter implements NotificationFilter {

	public void filter(NotificationRecording recording) {

		List<NotificationInfo> rec = recording.asMutableList();

		if (rec.size() != 3) {
			return;
		}

		NotificationInfo n1 = rec.get(0);
		NotificationInfo n2 = rec.get(1);
		NotificationInfo n3 = rec.get(2);
		// TODO: check for IDs instead of identity
		// TODO: check for containmentfeature
		// TODO: check for movement to different containmentfeature (4 ops)
		if (n1.isRemoveEvent() && n2.isSetEvent() && n3.isAddEvent()) {
			if (n1.getOldValue() == n2.getNotifier() && n2.getNotifier() == n3.getNewValue()) {
				rec.remove(n1);
				rec.remove(n3);
			}
		}

	}

}
