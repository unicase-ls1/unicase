/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.sprintstatus;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.ModelElement;
import org.unicase.model.task.TaskPackage;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.stem.Activator;
import org.unicase.workspace.util.EventUtil;

/**
 * @author Shterev
 */
public class SprintStatusView extends ViewPart {

	/**
	 * ID for this view.
	 */
	public static final String ID = "org.unicase.ui.stem.views.sprintstatus.SprintStatusView";

	private ModelElement input;

	private SprintStatusComposite statusComposite;

	/**
	 * Constructor.
	 */
	public SprintStatusView() {
		this.input = null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {

		statusComposite = new SprintStatusComposite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(statusComposite);

		IActionBars bars = getViewSite().getActionBars();
		IToolBarManager menuManager = bars.getToolBarManager();
		Action refresh = new Action() {
			@Override
			public void run() {
				setInput(input);
			}
		};
		refresh.setImageDescriptor(Activator.getImageDescriptor("/icons/refresh.png"));
		refresh.setToolTipText("Refresh");
		menuManager.add(refresh);

	}

	/**
	 * Refresh top composite and tabs based on input.
	 */
	public void refreshView() {
		if (input == null) {
			return;
		}

		if (TaskPackage.eINSTANCE.getWorkPackage().isInstance(input) && statusComposite != null) {
			statusComposite.setInput(input);
		}
	}

	/**
	 * Set input to the view. currently input is set using drag and drop on top composite. Later we implement a context
	 * menu command for it too.
	 * 
	 * @param me input model element
	 */
	public void setInput(ModelElement me) {
		ModelElement newInput = me;
		if (newInput == null) {
			newInput = ActionHelper.getSelectedModelElement();
		}
		if (input == null || newInput != null) {
			input = newInput;
		}
		statusComposite.setFocus();
		refreshView();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		EventUtil.logFocusEvent(ID);
		getViewSite().getPart().setFocus();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		statusComposite.dispose();
		super.dispose();
	}
}
