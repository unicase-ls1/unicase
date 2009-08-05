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
 * This class filters bidirectional "add many" operations from a NotificationRecording.
 * 
 * @author chodnick
 */
public class BidirectionalRemoveManyFilter implements NotificationFilter {
	/**
	 * @param recording the recording to Filter
	 * @see org.unicase.workspace.changeTracking.notification.filter.NotificationFilter#filter(org.unicase.workspace.changeTracking.notification.recording.NotificationRecording)
	 */
	public void filter(NotificationRecording recording) {

		List<NotificationInfo> rec = recording.asMutableList();

		// we look for 1 or more set/remove messages followed by an REMOVE_MANY message
		if (rec.size() < 2) {
			return;
		}

		// any REMOVE_MANY message within the queue is a candidate
		// a list of messages directly preceding it, might be opposites, that need to be filtered

		for (int i = 0; i < rec.size(); i++) {

			// only interested in remove many events
			if (!rec.get(i).isRemoveManyEvent()) {
				continue;
			}
			NotificationInfo nLast = rec.get(i);

			int j = i - 1;
			while (j >= 0) {
				NotificationInfo n = rec.get(j);

				// check if one feature is the opposite of the other
				if (n.getReference().getEOpposite() != nLast.getFeature()) {
					break;
				}

				// n:n case, REMOVE messages can be deleted if referencing our REMOVE_MANY on opposite
				if (n.isRemoveEvent() && n.getOldValue() == nLast.getNotifier()) {
					rec.remove(j);
					// n:1 case SET messages can be deleted if referencing our REMOVE_MANY on opposite
					// nLast
				} else if ((n.isSetEvent() && n.getOldValue() == nLast.getNotifier() && n.getNewValue() == null)) {
					rec.remove(j);
				} else {
					break;
				}
				i--;
				j--;
			}
		}

	}
}
