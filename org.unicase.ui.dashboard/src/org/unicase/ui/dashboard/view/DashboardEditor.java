/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.view;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.emfstore.internal.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.internal.client.model.util.WorkspaceUtil;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.SharedHeaderFormEditor;

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
	public void init(IEditorSite site, final IEditorInput eInput) throws PartInitException {
		super.init(site, eInput);
		if (eInput instanceof DashboardEditorInput) {
			setInput(eInput);
			final DashboardEditorInput input = (DashboardEditorInput) eInput;
			setPartName(input.getName());
			setTitleImage(input.getImageDescriptor().createImage());
		} else {
			throw new PartInitException("The Dashboard can only function with a dashboard input.");
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

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.MultiPageEditorPart#getAdapter(java.lang.Class)
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		if (adapter.equals(ProjectSpace.class)) {
			return page.getProjectSpace();
		} else if (adapter.equals(Project.class)) {
			return page.getProjectSpace().getProject();
		}
		return super.getAdapter(adapter);
	}

}
