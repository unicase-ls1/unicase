/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.dnd.dropadapters;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.meeting.IssueMeetingSection;
import org.unicase.model.meeting.MeetingPackage;
import org.unicase.model.rationale.Issue;

/**
 * This is the drop adapter for WorkItemMeetingSections.
 * 
 * @author Hodaie
 */
public class IssueMeetingDiscussionSectionDropAdapter extends UCDropAdapter {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.dnd.MEDropAdapter#drop(org.eclipse.swt.dnd.DropTargetEvent,
	 *      org.unicase.metamodel.UnicaseModelElement, java.util.List)
	 */
	@Override
	public void drop(DropTargetEvent event, EObject target, List<EObject> source) {
		UnicaseModelElement dropee = (UnicaseModelElement) source.get(0);
		if (dropee instanceof Issue) {
			((IssueMeetingSection) target).getIncludedIssues().add((Issue) dropee);
		} else {
			super.drop(event, target, source);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.unicasecommon.dnd.dropadapters.UCDropAdapter#isDropAdapterfor()
	 */
	@Override
	public EClass isDropAdapterfor() {
		return MeetingPackage.eINSTANCE.getIssueMeetingSection();
	}

}
