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
 * This class filters bidirectional "add many" operations from a NotificationRecording.
 * 
 * @author chodnick
 */
public class BidirectionalAddManyFilter implements NotificationFilter {
	/**
	 * @param recording the recording to Filter
	 * @see org.unicase.workspace.changeTracking.notification.filter.NotificationFilter#filter(org.unicase.workspace.changeTracking.notification.recording.NotificationRecording)
	 */
	public void filter(NotificationRecording recording) {

		List<NotificationInfo> rec = recording.asMutableList();

		// we look for 2 or more add messages followed by an add_many message
		if (rec.size() < 3) {
			return;
		}

		NotificationInfo nLast = rec.get(rec.size() - 1);

		if (!nLast.isAddManyEvent()) {
			return;
		}
		// TODO: check for IDs instead of identity
		// make sure each of the preceding messages is an add message referencing the notifier from nLast
		for (int i = 0; i < rec.size() - 1; i++) {
			NotificationInfo n = rec.get(i);
			if (!(n.isAddEvent() && n.getNewValue() == nLast.getNotifier())) {
				return;
			}
		}

		// here we know each preceding message was an opposite of the last add_many message,
		// it is safe to remove the add messages
		while (rec.size() > 1) {
			rec.remove(0);
		}

	}

}
