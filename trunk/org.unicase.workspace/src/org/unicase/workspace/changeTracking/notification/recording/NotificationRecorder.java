/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.changeTracking.notification.recording;

import org.eclipse.emf.common.notify.Notification;
import org.unicase.workspace.changeTracking.notification.NotificationInfo;

/**
 * A Notification recorder is meant to generate a NotificationRecording. To create the recording just repeatedly call
 * record() with incoming EMF notifications.
 * 
 * @author chodnick
 */
public class NotificationRecorder {

	private boolean recordingComplete;
	private NotificationRecording recording;

	/**
	 * Records a new EMF Notification.
	 * 
	 * @param n the notification to record
	 */
	public void record(Notification n) {

		if (recording == null || isRecordingComplete()) {
			newRecording();
		}

		recording.record(n);
		updateRecordingComplete();

	}

	/**
	 * Returns a completed notification recording, may throw IllegalStateException in case the recording is requested
	 * while recording still takes place, i.e. the EMF notification chain is not completed yet.
	 * 
	 * @return a completed notification recording if one is ready
	 */
	public NotificationRecording getRecording() {
		if (isRecordingComplete()) {
			return recording;
		} else {
			throw new IllegalStateException("trying to get a recording, that is not finished yet");
		}
	}

	/**
	 * Tries to stop an ongoing recording, useful only in context of delete operations, in which multiple EMF
	 * notification chains are recorded as a single sequence.
	 */
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
	 * Starts a new recording.
	 */
	public void newRecording() {
		newRecording(NotificationRecordingHint.DEFAULT);
	}

	/**
	 * Starts a new recording.
	 * 
	 * @param aHint the hint to use when creating the new recording.
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
	 * @return true if current recording is completed and closed, false otherwise
	 */
	public boolean isRecordingComplete() {
		return recordingComplete;
	}

}
