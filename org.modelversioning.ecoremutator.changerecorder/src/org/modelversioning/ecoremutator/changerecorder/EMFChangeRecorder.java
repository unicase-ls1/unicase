/**
 * <copyright>
 *
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * </copyright>
 */

package org.modelversioning.ecoremutator.changerecorder;

import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowPulldownDelegate;

/**
 * The action delegate for recording EMF resources.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 */
public class EMFChangeRecorder implements IWorkbenchWindowPulldownDelegate {

	private IWorkbenchWindow window;

	@Override
	public void run(IAction action) {
		if (action instanceof RecordChangesAction) {
			action.run();
		} else {
			MessageDialog.openInformation(window.getShell(),
					"No editor selected",
					"Please select an opened editor to record changes "
							+ "from the drop down list. If the drop down "
							+ "is empty, open an editor first");
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// noop
	}

	@Override
	public void dispose() {
		// noop
	}

	@Override
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}

	@Override
	public Menu getMenu(Control parent) {
		MenuManager manager = new MenuManager();
		for (IWorkbenchPage page : window.getPages()) {
			for (IEditorReference ref : page.getEditorReferences()) {
				final IEditorPart editor = ref.getEditor(true);
				Object adapter = editor
						.getAdapter(IEditingDomainProvider.class);
				if (adapter != null
						&& adapter instanceof IEditingDomainProvider) {
					IEditingDomainProvider editingDomainProvider = (IEditingDomainProvider) adapter;
					manager.add(new RecordChangesAction(editor,
							editingDomainProvider));
				}
			}
		}
		return manager.createContextMenu(parent);
	}
}
