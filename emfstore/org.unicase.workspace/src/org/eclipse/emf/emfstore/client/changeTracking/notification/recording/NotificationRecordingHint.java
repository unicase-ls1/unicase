/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.changeTracking.notification.recording;

/**
 * @author chodnick
 */
public final class NotificationRecordingHint {

	private static final int HINT_NONE = 0;
	private static final int HINT_MANUAL_STOP_OF_RECORDING = 1;
	private static final int HINT_DELETE = HINT_MANUAL_STOP_OF_RECORDING;

	/**
	 * Hints, that the recording is representing a delete operation.
	 */
	public static final NotificationRecordingHint DELETE = new NotificationRecordingHint(
		NotificationRecordingHint.HINT_DELETE);

	/**
	 * Hints, that the recording is representing a default operation. Which is the usual case.
	 */

	public static final NotificationRecordingHint DEFAULT = new NotificationRecordingHint(
		NotificationRecordingHint.HINT_NONE);

	private int hint;

	private NotificationRecordingHint(int hint) {
		this.hint = hint;
	}

	/**
	 * Returns whether a recording with this hint needs to be stopped manually, or will be stopped by recognition of the
	 * end of a notification chain. This is usually true for the DELETE hint only.
	 * 
	 * @return true if the recording needs to be stopped manually, because it spans multiple EMF notification chains
	 */
	public boolean needsManualStopOfRecording() {
		return (hint & HINT_MANUAL_STOP_OF_RECORDING) > 0;
	}

	/**
	 * Returns whether the notification recording represents a delete chain.
	 * 
	 * @return true if recording is a delete chain, false otherwise.
	 */
	public boolean isDelete() {
		return (hint & HINT_DELETE) > 0;
	}

}
