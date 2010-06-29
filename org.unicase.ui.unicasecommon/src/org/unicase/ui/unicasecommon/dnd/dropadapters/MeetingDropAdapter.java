/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.dnd.dropadapters;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.widgets.Display;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.MeetingPackage;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.unicasecommon.common.wizards.WorkPackageReviewWizard;

/**
 * This is drop adapter for Meetings.
 * 
 * @author Hodaie
 */
public class MeetingDropAdapter extends UCDropAdapter {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.dnd.MEDropAdapter#drop(org.eclipse.swt.dnd.DropTargetEvent,
	 *      org.unicase.metamodel.UnicaseModelElement, java.util.List)
	 */
	@Override
	public void drop(DropTargetEvent event, ModelElement target, List<ModelElement> source) {

		UnicaseModelElement dropee = (UnicaseModelElement) source.get(0);
		if (dropee instanceof WorkPackage) {
			dropWorkPackageOnMeeting((Meeting) target, (WorkPackage) dropee);
		}
		super.drop(event, target, source);
	}

	private void dropWorkPackageOnMeeting(Meeting meeting, WorkPackage workPackage) {
		WorkPackageReviewWizard wizard = new WorkPackageReviewWizard();
		wizard.init(meeting, workPackage.getContainedWorkItems());
		WizardDialog dialog = new WizardDialog(Display.getCurrent().getActiveShell(), wizard);
		wizard.setWindowTitle("Workpackage review wizard.");
		dialog.create();
		dialog.open();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.unicasecommon.dnd.dropadapters.UCDropAdapter#isDropAdapterfor()
	 */
	@Override
	public EClass isDropAdapterfor() {
		return MeetingPackage.eINSTANCE.getMeeting();
	}
}
