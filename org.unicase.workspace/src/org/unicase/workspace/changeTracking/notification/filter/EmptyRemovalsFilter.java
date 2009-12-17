/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.changeTracking.notification.filter;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.unicase.workspace.changeTracking.notification.NotificationInfo;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecording;

/**
 * This class filters zero effect remove operations from a notification recording. An example of a zero effect remove is
 * a notification that [] changed to null.
 * 
 * @author chodnick
 */
public class EmptyRemovalsFilter implements NotificationFilter {

	/**
	 * @param recording the recording to filter
	 * @see org.unicase.workspace.changeTracking.notification.filter.NotificationFilter#filter(org.unicase.workspace.changeTracking.notification.recording.NotificationRecording)
	 */
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
