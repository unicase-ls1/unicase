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
 * This class filters bidirectional add operations from a NotificationRecording.
 * 
 * @author chodnick
 */
public class GenericBidirectionalFilter implements NotificationFilter {

	/**
	 * @param recording the recording to filter
	 * @see org.unicase.workspace.changeTracking.notification.filter.NotificationFilter#filter(org.unicase.workspace.changeTracking.notification.recording.NotificationRecording)
	 */
	public void filter(NotificationRecording recording) {

		List<NotificationInfo> rec = recording.asMutableList();

		// check for each message if the bidirectional partner is coming up, if it is, discard the message
		for (int i = 0; i < rec.size() - 1; i++) {
			NotificationInfo n = rec.get(i);
			if (n.isReferenceNotification() && n.getReference().getEOpposite() != null) {

				// check for opposites on single reference notifications

				for (int j = i + 1; j < rec.size(); j++) {
					if (isOppositeOf(n, rec.get(j))) {
						rec.remove(i);
						i--;
						break;
					}
				}

				/*
				 * NotificationInfo last = rec.get(rec.size() - 1); NotificationInfo next = rec.get(i + 1); if
				 * (isOppositeOf(n, last) || isOppositeOf(n, next)) { rec.remove(i); i--; }
				 */

			}

		}

	}

	private boolean isOppositeOf(NotificationInfo n, NotificationInfo m) {

		if (n.getReference().getEOpposite() == m.getFeature()) {

			if (n.isSetEvent()) {

				if (n.getNewValue() == null && m.getNotifier() == n.getOldValue()) {
					return true;
				} else if (n.getOldValue() == null && m.getNotifier() == n.getNewValue()) {
					return true;
				}
			} else if (n.isAddEvent()) {

				if (n.getNewValue() == m.getNotifier()) {
					return true;
				}

			} else if (n.isRemoveEvent()) {
				if (m.isRemoveManyEvent() && n.getOldValue() == m.getNotifier()) {
					return true;
				}
				return false;

				// generic case not valid any more to maintain index consistency during reverse operations
				/*
				 * if (n.getOldValue() == m.getNotifier()) { return true; }
				 */
			}

		}
		return false;

	}
}
