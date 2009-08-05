/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.changeTracking.notification.filter;

import java.util.List;

import org.unicase.workspace.changeTracking.notification.NotificationInfo;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecording;

/**
 * This class filters a SET / REMOVE pair that usually occurrs at the end of a delete notification chain. This pair
 * signifies containment break up. The parent REMOVEs the child from its containment array. The Child SETs it parent to
 * null; This filter removes the SET notification, as the parent REMOVE notification gives enough information about what
 * happened.
 * 
 * @author chodnick
 */

public class ContainmentRemovalFilter implements NotificationFilter {

	/**
	 * @param recording the recording to filter
	 * @see org.unicase.workspace.changeTracking.notification.filter.NotificationFilter#filter(org.unicase.workspace.changeTracking.notification.recording.NotificationRecording)
	 */
	public void filter(NotificationRecording recording) {

		// only interested in delete chains for this
		if (!recording.getHint().isDelete()) {
			return;
		}

		List<NotificationInfo> rec = recording.asMutableList();

		// we need at least two operations
		if (rec.size() < 2) {
			return;
		}

		NotificationInfo n1 = rec.get(rec.size() - 2);
		NotificationInfo n2 = rec.get(rec.size() - 1);

		// check event types
		if (!(n1.isSetEvent() && n2.isRemoveEvent())) {
			return;
		}

		// check that the child is really is removed
		// TODO: check for ID, not for identity
		if (n1.getNotifier() == n2.getOldValue()) {
			// check that the child SET goes to null
			if (n1.getNewValue() == null) {
				// check that remove was on a containment feature
				if (n2.isReferenceNotification() && n2.getReference().isContainment()) {
					// all checks passed, the set may go
					rec.remove(n1);
				}
			}

		}

	}

}
