/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.sprintstatus;

import org.eclipse.emf.ecp.common.model.ECPWorkspaceManager;
import org.eclipse.emf.ecp.common.model.NoWorkspaceException;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.unicasecommon.common.URLSelectionListener;
import org.unicase.ui.unicasecommon.common.util.URLHelper;

/**
 * @author Shterev
 */
public class SprintStatusItem extends Composite {

	private static AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(
		new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	private static final int NAME_LIMIT = 30;

	/**
	 * Default constructor.
	 * 
	 * @param parent the parent
	 * @param style the style
	 * @param workItem the workItem input.
	 * @param bg flag for the alternating background: 0 for white, anything else for colored;
	 */
	public SprintStatusItem(Composite parent, int style, WorkItem workItem, int bg) {
		super(parent, style);
		ProjectSpace projectSpace;
		try {
			projectSpace = (ProjectSpace) ECPWorkspaceManager.getInstance().getWorkSpace().getActiveProject()
				.getRootObject();
		} catch (NoWorkspaceException e) {
			ModelUtil.logException("Failed to create SprintStatusItem!", e);
			return;
		}
		GridLayoutFactory.fillDefaults().numColumns(1).spacing(0, 0).equalWidth(false).applyTo(this);

		Composite header = new Composite(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).spacing(0, 0).applyTo(header);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(header);

		Composite content = new Composite(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).spacing(0, 0).margins(5, 10).equalWidth(false).applyTo(content);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(content);
		setBackgroundMode(SWT.INHERIT_FORCE);

		URLSelectionListener selectionListener = URLSelectionListener.getInstance(projectSpace);

		Control name = URLHelper.getModelElementLink(header, workItem, projectSpace, URLHelper.DEFAULT);
		// Link name = new Link(this, SWT.WRAP);
		GridDataFactory.fillDefaults().span(4, 1).grab(true, true).applyTo(name);
		// name.setText(URLHelper.getHTMLLinkForModelElement(workItem, projectSpace));
		// name.addSelectionListener(selectionListener);
		header.setBackground(new Color(getDisplay(), 239, 214, 148));
		header.setBackgroundMode(SWT.INHERIT_FORCE);
		if (bg != 0) {
			// setBackground(new Color(getDisplay(), 181, 213, 255)); macos selected blue
			// setBackground(new Color(getDisplay(), 233, 244, 255)); // light blue
			setBackground(new Color(getDisplay(), 251, 241, 158));
		} else {
			setBackground(new Color(getDisplay(), 255, 249, 202));
		}

		Link assignee = new Link(content, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(assignee);
		assignee.setText("Assig.: "
			+ URLHelper.getHTMLLinkForModelElement(workItem.getAssignee(), projectSpace, URLHelper.DEFAULT));
		assignee.addSelectionListener(selectionListener);

		Link tester = new Link(content, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(tester);
		tester.setText("Tester: "
			+ URLHelper.getHTMLLinkForModelElement(workItem.getReviewer(), projectSpace, URLHelper.DEFAULT));
		tester.addSelectionListener(selectionListener);

		Label priority = new Label(content, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(priority);
		priority.setText("Priority: " + workItem.getPriority());

		Label estimate = new Label(content, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(estimate);
		estimate.setText("Estimate: " + workItem.getEstimate());

		if (!workItem.getPredecessors().isEmpty()) {
			Label blocker = new Label(content, SWT.WRAP);
			GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(blocker);
			blocker.setText("Blocker: ");
			for (WorkItem wi : workItem.getPredecessors()) {
				Control c = URLHelper.getModelElementLink(content, wi, projectSpace, URLHelper.DEFAULT);
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
