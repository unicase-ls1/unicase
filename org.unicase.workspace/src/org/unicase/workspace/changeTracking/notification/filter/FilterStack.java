package org.unicase.workspace.changeTracking.notification.filter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.unicase.workspace.changeTracking.notification.recording.NotificationRecording;

public class FilterStack implements NotificationFilter {

	private static NotificationFilter[] DEFAULT_STACK = { new TouchFilter(), new TransientFilter(),
		new BidirectionalRemoveFilter(), new BidirectionalAddFilter(), new BidirectionalAddManyFilter(),
		new TreeMoveFilter(), new EmptyRemovalsFilter() };

	public static NotificationFilter DEFAULT = new FilterStack(DEFAULT_STACK);

	private List<NotificationFilter> filterList;

	private FilterStack(NotificationFilter[] filters) {
		filterList = new LinkedList<NotificationFilter>();
		Collections.addAll(filterList, filters);
	}

	public void filter(NotificationRecording recording) {
		for (NotificationFilter f : filterList) {
			f.filter(recording);
		}
	}

}
