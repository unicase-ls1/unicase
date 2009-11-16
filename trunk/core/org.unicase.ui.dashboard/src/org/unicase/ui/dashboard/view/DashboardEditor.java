/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.view;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.SharedHeaderFormEditor;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * The dashboard view.
 * 
 * @author Shterev
 */
public class DashboardEditor extends SharedHeaderFormEditor {

	/**
	 * The Id for the dashboard editor.
	 */
	public static final String ID = "org.unicase.workspace.ui.dashboard";

	private DashboardPage page;

	/**
	 * Default constructor.
	 */
	public DashboardEditor() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void addPages() {
		page = new DashboardPage(this, "1", "Main page");
		try {
			addPage(page);
		} catch (PartInitException e) {
			WorkspaceUtil.logException("Dashboard exception", e);
		}

	}

	/**
	 * Save is not allowed as the editor is only used as a view. {@inheritDoc}
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
	}

	/**
	 * Save is not allowed as the editor is only used as a view.
	 */
	@Override
	public void doSaveAs() {
	}

	/**
	 * Save is not allowed as the editor is only used as a view.
	 * 
	 * @return false
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(IEditorSite site, final IEditorInput eInput)
			throws PartInitException {
		super.init(site, eInput);
		if (eInput instanceof DashboardEditorInput) {
			setInput(eInput);
			final DashboardEditorInput input = (DashboardEditorInput) eInput;
			setPartName(input.getName());
			setTitleImage(input.getImageDescriptor().createImage());
		} else {
			throw new PartInitException(
					"The Dashboard can only function with a dashboard input.");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDirty() {
		// the dashboard cannot be edited and is never dirty
		return false;
	}

	/**
	 * Refreshes the editor.
	 */
	public void refresh() {
		addPages();
		removePage(0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {

		super.setFocus();
		page.setFocus();

	}

}
