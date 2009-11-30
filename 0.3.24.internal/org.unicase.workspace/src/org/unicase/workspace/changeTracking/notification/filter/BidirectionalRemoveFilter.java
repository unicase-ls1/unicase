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

		for (int i = 0; i < rec.size() - 1; i++) {

			// TODO: check for IDs instead of object identity
			NotificationInfo n1 = rec.get(i);
			NotificationInfo n2 = rec.get(i + 1);

			// check if one feature is the opposite of the other
			if (n1.getReference().getEOpposite() != n2.getFeature() || (n2.getOldValue() != n1.getNotifier())) {
				continue;
			}

			// n:n operation, both are remove events
			if (n1.isRemoveEvent() && n2.isRemoveEvent()) {
				rec.remove(n1);
				i--;
			}

			// 1:n operation, one set one remove
			if (n1.isSetEvent() && n2.isRemoveEvent()) {
				rec.remove(n1);
				i--;
			}

			// n:1 operation, one remove one set
			if (n1.isRemoveEvent() && n2.isSetEvent()) {
				rec.remove(n1);
				i--;
			}

		}

	}

}
