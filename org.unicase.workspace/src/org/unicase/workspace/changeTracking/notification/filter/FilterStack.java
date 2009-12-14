/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.changeTracking.notification.filter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.unicase.workspace.changeTracking.notification.recording.NotificationRecording;

/**
 * This class filters a notification recording according to predefined stacks of filters. Available stacks are created
 * as static properties for easy reference.
 * 
 * @author chodnick
 */
public final class FilterStack implements NotificationFilter {

	private static final NotificationFilter[] DEFAULT_STACK = {
	//
		new TouchFilter(),
		//
		new TransientFilter(),
		//
		new EmptyRemovalsFilter()
	//
	// new BidirectionalAddManyFilter(),
	//
	// new GenericBidirectionalFilter()
	};

	/**
	 * The default filter stack.
	 */
	public static final NotificationFilter DEFAULT = new FilterStack(DEFAULT_STACK);

	private List<NotificationFilter> filterList;

	private FilterStack(NotificationFilter[] filters) {
		filterList = new LinkedList<NotificationFilter>();
		Collections.addAll(filterList, filters);
	}

	/**
	 * @param recording the recording to filter
	 * @see org.unicase.workspace.changeTracking.notification.filter.NotificationFilter#filter(org.unicase.workspace.changeTracking.notification.recording.NotificationRecording)
	 */
	public void filter(NotificationRecording recording) {
		for (NotificationFilter f : filterList) {
			f.filter(recording);
		}
	}

}
