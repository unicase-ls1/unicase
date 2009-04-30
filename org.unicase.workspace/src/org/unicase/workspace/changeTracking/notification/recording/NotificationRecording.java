/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.changeTracking.notification.recording;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.unicase.workspace.changeTracking.notification.NotificationInfo;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * A NotificationRecording is basically a list of EMF Notifications.
 * 
 * @author chodnick
 */
public class NotificationRecording {

	private List<NotificationInfo> chain = new LinkedList<NotificationInfo>();
	private NotificationRecordingHint hint;

	/**
	 * @return currently set hint
	 */
	public NotificationRecordingHint getHint() {
		return hint;
	}

	/**
	 * @param hint the hint to set
	 */
	public void setHint(NotificationRecordingHint hint) {
		this.hint = hint;
	}

	/**
	 * @param n the notification to add to the recording
	 */
	public void record(Notification n) {
		chain.add(new NotificationInfo(n));
	}

	/**
	 * @return the last recorded notification or null if the recording is empty
	 */
	public NotificationInfo getLastRecorded() {
		if (empty()) {
			return null;
		}
		return chain.get(chain.size() - 1);
	}

	/**
	 * @return if the recording is empty
	 */
	public boolean empty() {
		return chain.size() == 0;
	}

	/**
	 * For debugging purposes. Will output to Eclipse Error Log.
	 * 
	 * @param msg first line message of the debug output
	 */
	public void debugLog(String msg) {

		WorkspaceUtil.log(msg, null, 0);
		for (Notification n : chain) {
			WorkspaceUtil.log(n.toString(), null, 0);
		}
		WorkspaceUtil.log("end ------------------------------------------------", null, 0);

	}

	/**
	 * For debugging purposes. Will output to Eclipse Error Log.
	 */

	public void debugLog() {

		String hintType = "DEFAULT";

		if (getHint().equals(NotificationRecordingHint.CREATE)) {
			hintType = "CREATE";
		}
		if (getHint().equals(NotificationRecordingHint.DELETE)) {
			hintType = "DELETE";
		}

		debugLog("notification recording log - captured notifications follow - this is a " + hintType + " operation");
	}

	/**
	 * Use to change the contents of the recording dynamically. For example in filters.
	 * 
	 * @return a mutable internal representation of the notifcations
	 */
	public List<NotificationInfo> asMutableList() {
		return chain;
	}
}
