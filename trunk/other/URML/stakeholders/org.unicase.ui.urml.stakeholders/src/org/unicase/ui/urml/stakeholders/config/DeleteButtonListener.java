/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.urml.stakeholders.config;

import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Listener of a delete button. It allows the deletion of arbitrary unicase model 
 * elements included from the list shown within the dialog.
 * @author kterzieva
 */
public class DeleteButtonListener implements Listener {

	private TableViewer tableViewer;
	private Shell shell;
	private Project activeProject;
	
	/**
	 * The construct.
	 * @param tableViewer the viewer, which shows the list of the current avalaible model elements
	 * @param shell the shell
	 * @param activeProject the current active project
	 */
	public DeleteButtonListener(TableViewer tableViewer, Shell shell, Project activeProject) {
		this.tableViewer = tableViewer;
		this.shell = shell;
		this.activeProject = activeProject;
	}

	/**
	 * Allows the deletion of a specific model element by selecting the model element
	 * and the delete button on the dialog. 
	 * {@inheritDoc}
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		TableItem[] select = tableViewer.getTable().getSelection();
		for (TableItem t1 : select) {
			if (t1.getData() instanceof UnicaseModelElement) {
				final UnicaseModelElement elem = (UnicaseModelElement) t1.getData();
				boolean toBeDeleted = MessageDialog.openConfirm(shell,
						"Delete " + elem.getName(),
						"Are you sure you want to delete " + elem.getName()
								+ "?");
				if (toBeDeleted) {
					// Remove from displayed list
					@SuppressWarnings("unchecked")
					List<UnicaseModelElement> list = (List<UnicaseModelElement>) tableViewer
							.getInput();
					list.remove(elem);
					tableViewer.refresh();

					new UnicaseCommand() {
						@Override
						protected void doRun() {
							activeProject.deleteModelElement(elem);
						}
					}.run();

				}
			}
		}

	}
}