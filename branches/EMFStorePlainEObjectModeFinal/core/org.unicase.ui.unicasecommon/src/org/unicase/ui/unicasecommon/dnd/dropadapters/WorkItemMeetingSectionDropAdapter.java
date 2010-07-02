/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.dnd.dropadapters;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.meeting.MeetingPackage;
import org.unicase.model.meeting.WorkItemMeetingSection;
import org.unicase.model.task.WorkItem;

/**
 * This is the drop adapter for WorkItemMeetingSections.
 * 
 * @author Hodaie
 */
public class WorkItemMeetingSectionDropAdapter extends UCDropAdapter {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.dnd.MEDropAdapter#drop(org.eclipse.swt.dnd.DropTargetEvent,
	 *      org.unicase.metamodel.UnicaseModelElement, java.util.List)
	 */
	@Override
	public void drop(DropTargetEvent event, EObject target, List<EObject> source) {
		UnicaseModelElement dropee = (UnicaseModelElement) source.get(0);
		if (dropee instanceof WorkItem) {
			dropWorkItemOnMeetingSection((WorkItemMeetingSection) target, source);

		} else {
			super.drop(event, target, source);
		}

	}

	private void dropWorkItemOnMeetingSection(final WorkItemMeetingSection target, final List<EObject> source) {

		for (EObject me : source) {
			if (me instanceof WorkItem) {
				target.getIncludedWorkItems().add((WorkItem) me);
			}
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.unicasecommon.dnd.dropadapters.UCDropAdapter#isDropAdapterfor()
	 */
	@Override
	public EClass isDropAdapterfor() {
		return MeetingPackage.eINSTANCE.getWorkItemMeetingSection();
	}

}
