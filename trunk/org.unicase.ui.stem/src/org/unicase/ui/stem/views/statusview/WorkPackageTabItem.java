/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.common.util.URLHelper;
import org.unicase.ui.common.util.URLSelectionListener;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * @author Shterev
 */
public class WorkPackageTabItem extends Composite {

	/**
	 * Default constructor.
	 * 
	 * @param parent the parent
	 * @param style the style
	 * @param workItem the workItem input.
	 * @param bg flag for the alternating background: 0 for white, anything else for colored;
	 */
	public WorkPackageTabItem(Composite parent, int style, WorkItem workItem, int bg) {
		super(parent, style);
		ProjectSpace projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
		GridLayoutFactory.fillDefaults().numColumns(2).spacing(0, 0).margins(5, 10).equalWidth(false).applyTo(this);
		if (bg != 0) {
			// setBackground(new Color(getDisplay(), 181, 213, 255));
			setBackground(new Color(getDisplay(), 233, 244, 255));
		} else {
			setBackground(new Color(getDisplay(), 255, 255, 255));
		}
		setBackgroundMode(SWT.INHERIT_FORCE);

		URLSelectionListener selectionListener = URLSelectionListener.getInstance(projectSpace);

		Composite name = URLHelper.getModelElementLink(this, workItem, projectSpace);
		// Link name = new Link(this, SWT.WRAP);
		GridDataFactory.fillDefaults().span(4, 1).grab(true, true).applyTo(name);
		// name.setText(URLHelper.getHTMLLinkForModelElement(workItem, projectSpace));
		// name.addSelectionListener(selectionListener);

		Link assignee = new Link(this, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(assignee);
		assignee.setText("Assig.: " + URLHelper.getHTMLLinkForModelElement(workItem.getAssignee(), projectSpace));
		assignee.addSelectionListener(selectionListener);

		Link tester = new Link(this, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(tester);
		tester.setText("Tester: " + URLHelper.getHTMLLinkForModelElement(workItem.getReviewer(), projectSpace));
		tester.addSelectionListener(selectionListener);

		Label priority = new Label(this, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(priority);
		priority.setText("Priority: " + workItem.getPriority());

		Label estimate = new Label(this, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(estimate);
		estimate.setText("Estimate: " + workItem.getEstimate());

		if (!workItem.getPredecessors().isEmpty()) {
			Label blocker = new Label(this, SWT.WRAP);
			GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(blocker);
			blocker.setText("Blocker: ");
			for (WorkItem wi : workItem.getPredecessors()) {
				Composite c = URLHelper.getModelElementLink(this, wi, projectSpace);
				GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(c);
			}
		}
	}

	/**
	 * Adds support for dropping items into this viewer via a user drag-and-drop operation.
	 * 
	 * @param operations a bitwise OR of the supported drag and drop operation types ( <code>DROP_COPY</code>,
	 *            <code>DROP_LINK</code>, and <code>DROP_MOVE</code>)
	 * @param transferTypes the transfer types that are supported by the drop operation
	 * @param listener the callback that will be invoked after the drag and drop operation finishes
	 * @see org.eclipse.swt.dnd.DND
	 */
	public void addDropSupport(int operations, Transfer[] transferTypes, final DropTargetListener listener) {
		DropTarget dropTarget = new DropTarget(this, operations);
		dropTarget.setTransfer(transferTypes);
		dropTarget.addDropListener(listener);
	}

}
