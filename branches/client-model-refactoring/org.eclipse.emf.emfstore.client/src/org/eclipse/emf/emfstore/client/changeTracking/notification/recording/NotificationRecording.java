/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.changeTracking.notification.recording;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.emfstore.client.Activator;
import org.eclipse.emf.emfstore.client.changeTracking.notification.NotificationInfo;
import org.eclipse.emf.emfstore.client.util.Configuration;

/**
 * A NotificationRecording is basically a list of EMF Notifications.
 * 
 * @author chodnick
 */
public class NotificationRecording {

	private List<NotificationInfo> chain = new LinkedList<NotificationInfo>();
	private NotificationRecordingHint hint;
	private Date date;

	/**
	 * @return currently set hint
	 */
	public NotificationRecordingHint getHint() {
		return hint;
	}

	/**
	 * @param hint
	 *            the hint to set
	 */
	public void setHint(NotificationRecordingHint hint) {
		this.hint = hint;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param n
	 *            the notification to add to the recording
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
	 * @param msg
	 *            first line message of the debug output
	 */
	public void debugLog(String msg) {

		Activator activator = Activator.getDefault();
		MultiStatus status = new MultiStatus(activator.getBundle()
				.getSymbolicName(), IStatus.OK, msg, null);

		LinkedList<Status> temp = new LinkedList<Status>();
		for (NotificationInfo n : chain) {
			temp.add(new Status(IStatus.OK, activator.getBundle()
					.getSymbolicName(), n.getDebugString()
					+ " ----------------------- " + n.toString()));
		}

		// make sure the list is reversed, so the events appear in the order
		// they arrived
		Collections.reverse(temp);
		for (Status s : temp) {
			status.add(s);
		}

		activator.getLog().log(status);

	}

	/**
	 * For debugging purposes. Will output to Eclipse Error Log.
	 */

	public void debugLog() {

		String hintType = "DEFAULT";

		if (getHint().equals(NotificationRecordingHint.DELETE)) {
			hintType = "DELETE";
		}

		// debug messages only in developer and internal release versions
		if (!Configuration.isReleaseVersion()) {
			debugLog("captured notification chain: " + hintType + " operation");
		}
	}

	/**
	 * Use to change the contents of the recording dynamically. For example in
	 * filters.
	 * 
	 * @return a mutable internal representation of the notifcations
	 */
	public List<NotificationInfo> asMutableList() {
		return chain;
	}
}
