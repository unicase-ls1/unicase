package org.unicase.workspace.changeTracking.notification.filter;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.unicase.workspace.changeTracking.notification.NotificationInfo;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecording;

public class EmptyRemovalsFilter implements NotificationFilter {

	public void filter(NotificationRecording recording) {

		List<NotificationInfo> rec = recording.asMutableList();

		for (Iterator<NotificationInfo> it = rec.iterator(); it.hasNext();) {
			NotificationInfo n = it.next();
			if (n.isRemoveManyEvent() && n.getNewValue() == null && n.getOldValue() instanceof Collection<?>
				&& ((Collection<?>) n.getOldValue()).isEmpty()) {
				it.remove();
			}
		}

	}
}
