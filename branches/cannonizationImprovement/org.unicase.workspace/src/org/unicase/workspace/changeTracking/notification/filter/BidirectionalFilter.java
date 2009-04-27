package org.unicase.workspace.changeTracking.notification.filter;

import java.util.List;

import org.unicase.workspace.changeTracking.notification.NotificationInfo;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecording;

public class BidirectionalFilter implements NotificationFilter {

	public void filter(NotificationRecording recording) {

		List<NotificationInfo> rec = recording.asMutableList();

		// we need at least 2 notifications to identify opposite operations
		if (rec.size() <= 1) {
			return;
		}

		// if an notification is the opposite notification of the previous one, we remove the first in sequence
		// the second one will stay. Currently the last notification in the recording is assumed to be the only
		// candidate for an opposite operation
		NotificationInfo oppositeCandidate = rec.get(rec.size() - 1);

		// note: loop skips the last item, for the last one we do not seek an opposite anymore
		for (int i = 0; i < rec.size() - 1; i++) {

			NotificationInfo n = rec.get(i);

			if (isBidirectionalOf(n, oppositeCandidate)) {
				// after the bidirectional is found, loop exits, only one opposite can be found
				rec.remove(i);
				return;
			}

		}

	}

	private boolean isBidirectionalOf(NotificationInfo n, NotificationInfo oppositeCandidate) {

		// fail fast algorithm

		// single reference set operations can have an opposite
		if (n.isReferenceNotification() && n.isSetEvent()) {
			return isSingleReferenceSetBidirectionalOf(n, oppositeCandidate);
		}

		// please note: we expect here, that the folder message comes first
		// meaning: folder says "I got a new child" then child says "I got a new parent"
		// should be changed, as it is now a.isBidirectionalOf(b) == b.isBidirectionalOf(a) is not guaranteed
		if (n.isReferenceNotification() && n.getReference().isMany() && (n.isAddEvent() || n.isRemoveEvent())) {
			return isMultiReferenceChangeBidirectionalOf(n, oppositeCandidate);
		}

		// in any other case, we don't assume a bidirectional match
		return false;

	}

	private boolean isMultiReferenceChangeBidirectionalOf(NotificationInfo n, NotificationInfo oppositeCandidate) {

		boolean featureMatch = oppositeCandidate.getFeature() == n.getReference().getEOpposite();
		boolean valueMatch = oppositeCandidate.getNotifier() == n.getNewValue();
		return featureMatch && valueMatch;

	}

	private boolean isSingleReferenceSetBidirectionalOf(NotificationInfo n, NotificationInfo oppositeCandidate) {

		// fail fast algorithm

		// only single reference set operations can have an opposite (of equal type)
		if (!(n.isReferenceNotification() && n.isSetEvent())) {
			return false;
		}

		if (!(oppositeCandidate.isReferenceNotification() && oppositeCandidate.isSetEvent())) {
			return false;
		}

		// now we know we have both single reference set operations
		// check if we have an non null opposite on each side
		if (n.getReference().getEOpposite() == null || oppositeCandidate.getReference().getEOpposite() == null) {
			return false;
		}

		// make sure the set features reference each other
		if (n.getReference().getEOpposite() != oppositeCandidate.getReference().getEOpposite()) {
			return false;
		}

		// if we say, "I changed from oppositeCandidate to null" and opposite says "I changed from you to x" that's a
		// hit
		if (n.getOldValue() == oppositeCandidate.getNotifier() && n.getNewValue() == null) {
			return true;
		}

		// if we say "I changed from null to oppositeCandidate" and opposite says "I changed from x to you" that's a hit

		if (n.getOldValue() == null && oppositeCandidate.getNotifier() == n.getNewValue()) {
			return true;
		}

		// in any other case, we don't assume an bidirectional match

		// why not?
		// in case a parent's children changed, the change will be a "set parent to x" message from the child,
		// potentially followed by a "added/removed from children" message from the parent, that is a legitimate
		// bidirectional partner

		return false;

	}

}
