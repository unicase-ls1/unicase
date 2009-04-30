package org.unicase.workspace.changeTracking.notification.filter;

import java.util.List;

import org.unicase.workspace.changeTracking.notification.NotificationInfo;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecording;

public class BidirectionalAddFilter implements NotificationFilter {

	public void filter(NotificationRecording recording) {

		List<NotificationInfo> rec = recording.asMutableList();

		// bidirectional remove has 2 messages only remove on parent (usually second) and remove on child (usually
		// first)
		if (rec.size() != 2) {
			return;
		}

		NotificationInfo n1 = rec.get(0);
		NotificationInfo n2 = rec.get(1);
		// TODO: check for IDs instead of identity
		if (n1.isAddEvent() && n2.isAddEvent() && (n1.getNewValue() == n2.getNotifier())) {
			rec.remove(n1);
		}

	}

}
