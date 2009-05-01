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
 * Filters containment change notifications. A containment change will typically generate 3 or more notifications. The
 * old parent is going to detach, the child is going to reattach to the new parent, the new parent is going to attach
 * the child. This filter tries to sustain only the child notification.
 * 
 * @author chodnick
 */
public class ContainmentChangeFilter implements NotificationFilter {

	/**
	 * @param recording the recording to filter
	 * @see org.unicase.workspace.changeTracking.notification.filter.NotificationFilter#filter(org.unicase.workspace.changeTracking.notification.recording.NotificationRecording)
	 */
	public void filter(NotificationRecording recording) {

		List<NotificationInfo> rec = recording.asMutableList();

		if (rec.size() == 3) {
			filterSameContainmentFeature(recording);
		}

		if (rec.size() == 4) {
			filterDifferentContainmentFeature(recording);
		}

	}

	private void filterSameContainmentFeature(NotificationRecording recording) {

		List<NotificationInfo> rec = recording.asMutableList();

		NotificationInfo n1 = rec.get(0);
		NotificationInfo n2 = rec.get(1);
		NotificationInfo n3 = rec.get(2);
		// TODO: check for IDs instead of identity
		// TODO: check for containmentfeature
		if (n1.isRemoveEvent() && n2.isSetEvent() && n3.isAddEvent()) {
			if (n1.getOldValue() == n2.getNotifier() && n2.getNotifier() == n3.getNewValue()) {
				rec.remove(n1);
				rec.remove(n3);
			}
		}

	}

	private void filterDifferentContainmentFeature(NotificationRecording recording) {

		List<NotificationInfo> rec = recording.asMutableList();

		NotificationInfo n1 = rec.get(0);
		NotificationInfo n2 = rec.get(1);
		NotificationInfo n3 = rec.get(2);
		NotificationInfo n4 = rec.get(3);

		// TODO: check for IDs instead of identity
		// TODO: check for containmentfeature

		if (n1.isRemoveEvent() && n2.isSetEvent() && n3.isSetEvent() && n4.isAddEvent()) {
			if (n1.getOldValue() == n2.getNotifier() && n2.getNotifier() == n3.getNotifier()
				&& n2.getNotifier() == n4.getNewValue() && n2.getNewValue() == null && n3.getOldValue() == null) {
				rec.remove(n1);
				rec.remove(n4);
			}
		}

	}

}
