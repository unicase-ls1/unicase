package org.unicase.workspace.changeTracking.notification.filter;

import org.unicase.workspace.changeTracking.notification.recording.NotificationRecording;

public interface NotificationFilter {

	void filter(NotificationRecording recording);

}
