/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.changeTracking.notification.filter;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.unicase.workspace.changeTracking.notification.NotificationInfo;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecording;

/**
 * This class filters bidirectional "add many" operations from a NotificationRecording.
 * 
 * @author chodnick
 */
public class BidirectionalAddManyFilter implements NotificationFilter {
	/**
	 * @param recording the recording to Filter
	 * @see org.unicase.workspace.changeTracking.notification.filter.NotificationFilter#filter(org.unicase.workspace.changeTracking.notification.recording.NotificationRecording)
	 */
	@SuppressWarnings("unchecked")
	public void filter(NotificationRecording recording) {

		List<NotificationInfo> rec = recording.asMutableList();

		if (rec.size() < 2) {
			return;
		}

		NotificationInfo nLast = rec.get(rec.size() - 1);

		if (!nLast.isAddManyEvent()) {
			return;
		}

		List<EObject> addedElems = null;
		if (nLast.getNewValue() instanceof List) {
			addedElems = (List<EObject>) nLast.getNewValue();
		} else {
			// should never happen, ADD_MANY always provides a list of what was added
			return;
		}
		// TODO: check for IDs instead of identity

		if (nLast.getReference().isContainment()) {
			// containment feature has been added to, which means former parents might be announcing
			// that they lost children (in virtue of a SET (1:1), REMOVE (1:n) or REMOVE_MANY (1:n)
			// strategy is to keep only the children announcing their new parents, thus preserving
			// the "former parent" info, if any
			for (Iterator<NotificationInfo> it = rec.iterator(); it.hasNext();) {
				NotificationInfo n = it.next();
				if (n.isRemoveEvent()) {
					it.remove();
				} else if (n.isRemoveManyEvent()) {
					it.remove();
				} else if (n.isSetEvent()) {
					// some parent announcing the loss of its 1:1 child?
					if (n.getNewValue() == null && addedElems.contains(n.getOldValue())) {
						it.remove();
					}
				}
			}

		}
		// non containment feature has been added to
		else {
			filterNonContainment(recording);
		}

	}

	private void filterNonContainment(NotificationRecording recording) {

		List<NotificationInfo> rec = recording.asMutableList();
		NotificationInfo nLast = rec.get(rec.size() - 1);
		// n:n case make sure each of the preceding messages is an add message referencing the notifier from nLast
		if (rec.get(0).isAddEvent()) {
			for (int i = 0; i < rec.size() - 1; i++) {
				NotificationInfo n = rec.get(i);
				if (!(n.isAddEvent() && n.getNewValue() == nLast.getNotifier())) {
					return;
				}
			}

		}
		// n:1 case make sure each of the preceding messages is a set message referencing the notifier from nLast
		else if (rec.get(0).isSetEvent()) {
			for (int i = 0; i < rec.size() - 1; i++) {
				NotificationInfo n = rec.get(i);
				if (!(n.isSetEvent() && n.getNewValue() == nLast.getNotifier())) {
					return;
				}
			}

		}
		// unknown case, we should never get here
		else {
			return;
		}

		// here we know each preceding message was an opposite of the last add_many message,
		// it is safe to remove the add/set messages
		while (rec.size() > 1) {
			rec.remove(0);
		}

	}

}
