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
 * This class filters bidirectional set operations from a NotificationRecording.
 * 
 * @author chodnick
 */
public class BidirectionalSetFilter implements NotificationFilter {

	/**
	 * @param recording the recording to filter
	 * @see org.unicase.workspace.changeTracking.notification.filter.NotificationFilter#filter(org.unicase.workspace.changeTracking.notification.recording.NotificationRecording)
	 */
	public void filter(NotificationRecording recording) {

		List<NotificationInfo> rec = recording.asMutableList();

		// possible 1:1 case
		if (rec.size() == 2) {
			NotificationInfo n1 = rec.get(0);
			NotificationInfo n2 = rec.get(1);

			if (n1.isSetEvent() && n2.isSetEvent() && n1.isReferenceNotification() && n2.isReferenceNotification()
				&& n1.getReference().getEOpposite() == n2.getReference()) {
				// keep only the second set, this is a bidirectional 1 to 1 case
				rec.remove(n1);
				return;
			}

		}

		// 1:n bidirectional SET has 3 messages, REMOVE from old, ADD to new, SET on child
		if (rec.size() != 3) {
			return;
		}

		// TODO: check for IDs instead of identity
		NotificationInfo n1 = rec.get(0);
		NotificationInfo n2 = rec.get(1);
		NotificationInfo n3 = rec.get(2);

		// 1:n set operation test, an remove an add and a set are going on
		// make sure sequence is remove from old, add to new, reset child pointer
		if (!(n1.isRemoveEvent() && n2.isAddEvent() && n3.isSetEvent())) {
			return;
		}
		// make sure the remove and add actually refer to the child
		if (n1.getOldValue() != n3.getNotifier() || n2.getNewValue() != n3.getNotifier()) {
			return;
		}

		// make sure the child is setting from old to new
		if (n3.getOldValue() == n1.getNotifier() && n3.getNewValue() == n2.getNotifier()) {
			// all prerequisites met
			rec.remove(n1);
			rec.remove(n2);
		}
	}

}
