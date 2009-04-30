/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.changeTracking.notification.recording;

import org.eclipse.emf.common.notify.Notification;
import org.unicase.workspace.changeTracking.notification.NotificationInfo;

/**
 * @author chodnick
 */
public class NotificationRecorder {

	private boolean recordingComplete;
	private NotificationRecording recording;

	/**
	 * 
	 */
	public void record(Notification n) {

		if (recording == null || isRecordingComplete()) {
			newRecording();
		}

		recording.record(n);
		updateRecordingComplete();

	}

	public NotificationRecording getRecording() {
		if (isRecordingComplete()) {
			return recording;
		} else {
			throw new IllegalStateException("trying to get a recording, that is not finished yet");
		}
	}

	public void stopRecording() {
		if (recording == null || recording.empty()) {
			throw new IllegalStateException("trying to close an empty recording");
		}
		if (lastNotificationHasFollowUps()) {
			throw new IllegalStateException(
				"trying to close a recording, even though its last notification has followups");
		}
		recordingComplete = true;
	}

	private void updateRecordingComplete() {
		recordingComplete = !(recording == null || recording.empty()
			|| recording.getHint().needsManualStopOfRecording() || lastNotificationHasFollowUps());
	}

	private boolean lastNotificationHasFollowUps() {
		if (recording == null) {
			return false;
		}
		return notificationHasFollowUps(recording.getLastRecorded());
	}

	private boolean notificationHasFollowUps(NotificationInfo n) {

		return n.hasNext();

	}

	/**
	 * 
	 */
	public void newRecording() {
		newRecording(NotificationRecordingHint.DEFAULT);
	}

	/**
	 * @param aHint
	 */
	public void newRecording(NotificationRecordingHint aHint) {

		if (recording != null && !isRecordingComplete()) {
			throw new IllegalStateException(
				"trying to create new notification chain, even though there is an uncompleted chain present");
		}

		recording = new NotificationRecording();
		recording.setHint(aHint);

		recordingComplete = false;
	}

	/**
	 * @return
	 */
	public boolean isRecordingComplete() {
		return recordingComplete;
	}

}
