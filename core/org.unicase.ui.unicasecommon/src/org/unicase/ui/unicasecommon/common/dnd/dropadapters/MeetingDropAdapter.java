/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.dnd.dropadapters;

import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.widgets.Display;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.unicasecommon.common.wizards.WorkPackageReviewWizard;

/**
 * This is drop adapter for Meetings.
 * 
 * @author Hodaie
 */
public class MeetingDropAdapter extends MEDropAdapter {

	/**
	 * Constructor.
	 * 
	 * @param domain TransactionalEditingDomain
	 * @param viewer viewer
	 */
	public MeetingDropAdapter(TransactionalEditingDomain domain, StructuredViewer viewer) {
		super(domain, viewer);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.unicasecommon.common.dnd.dropadapters.MEDropAdapter#drop(org.eclipse.swt.dnd.DropTargetEvent,
	 *      org.unicase.metamodel.UnicaseModelElement, java.util.List)
	 */
	@Override
	public void drop(DropTargetEvent event, UnicaseModelElement target, List<UnicaseModelElement> source) {

		UnicaseModelElement dropee = source.get(0);
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
}
