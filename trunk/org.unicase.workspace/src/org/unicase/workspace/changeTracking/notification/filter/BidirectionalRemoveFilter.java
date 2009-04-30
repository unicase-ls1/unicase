/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.changeTracking.notification.filter;

import java.util.List;

import org.unicase.workspace.changeTracking.notification.NotificationInfo;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecording;

/**
 * This class filters bidirectional remove operations from a NotificationRecording.
 * 
 * @author chodnick
 */
public class BidirectionalRemoveFilter implements NotificationFilter {
	/**
	 * @param recording the recording to filter
	 * @see org.unicase.workspace.changeTracking.notification.filter.NotificationFilter#filter(org.unicase.workspace.changeTracking.notification.recording.NotificationRecording)
	 */
	public void filter(NotificationRecording recording) {

		List<NotificationInfo> rec = recording.asMutableList();

		// bidirectional remove has 2 messages only remove on parent (usually second) and remove on child (usually
		// first)
		if (rec.size() != 2) {
			return;
		}

		NotificationInfo n1 = rec.get(0);
		NotificationInfo n2 = rec.get(1);
		// TODO: check for IDs instead of object identity
		if (n1.isRemoveEvent() && n2.isRemoveEvent() && (n2.getOldValue() == n1.getNotifier())) {
			rec.remove(n1);
		}

	}

}
