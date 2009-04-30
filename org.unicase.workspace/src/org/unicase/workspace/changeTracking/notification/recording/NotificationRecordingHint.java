/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.changeTracking.notification.recording;

/**
 * @author chodnick
 */
public final class NotificationRecordingHint {

	private static final int HINT_NONE = 0;
	private static final int HINT_MANUAL_STOP_OF_RECORDING = 1;
	private static final int HINT_DELETE = HINT_MANUAL_STOP_OF_RECORDING;
	private static final int HINT_ADD = 2;

	public static final NotificationRecordingHint DELETE = new NotificationRecordingHint(
		NotificationRecordingHint.HINT_DELETE);

	public static final NotificationRecordingHint ADD = new NotificationRecordingHint(
		NotificationRecordingHint.HINT_ADD);

	public static final NotificationRecordingHint DEFAULT = new NotificationRecordingHint(
		NotificationRecordingHint.HINT_NONE);

	private int hint;

	private NotificationRecordingHint(int hint) {
		this.hint = hint;
	}

	public boolean needsManualStopOfRecording() {
		return (hint & HINT_MANUAL_STOP_OF_RECORDING) > 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hint;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		NotificationRecordingHint other = (NotificationRecordingHint) obj;
		if (hint != other.hint) {
			return false;
		}
		return true;
	}
}
