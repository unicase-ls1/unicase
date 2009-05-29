/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.changeTracking.notification.recording;

import java.util.LinkedList;
import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.ModelElement;
import org.unicase.workspace.changeTracking.OperationParser;
import org.unicase.workspace.changeTracking.notification.NotificationInfo;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;

/**
 * HelperClass: Generates Operations from a notification recording.
 * 
 * @author chodnik
 */
public final class OperationGenerator {

	/**
	 * Private constuctor.
	 */
	private OperationGenerator() {
		// nothing to do
	}

	/**
	 * Generates Operations from a notification recording.
	 * 
	 * @param recording the notification recording
	 * @return a list of abstract operations
	 * @throws UnsupportedNotificationException if the recording contains notifications that can not be processed by
	 *             this generator.
	 */
	public static List<AbstractOperation> generateFromRecording(NotificationRecording recording)
		throws UnsupportedNotificationException {

		LinkedList<AbstractOperation> ops = new LinkedList<AbstractOperation>();
		List<NotificationInfo> rec = recording.asMutableList();

		for (NotificationInfo n : rec) {

			if (n.getNotifier() instanceof ModelElement) {
				ops.addAll(OperationParser.parseOperations(n, (ModelElement) n.getNotifier()));
			} else {
				throw new UnsupportedNotificationException("notification comes from a non-modelelement!");
			}

		}

		return ops;

	}
}
