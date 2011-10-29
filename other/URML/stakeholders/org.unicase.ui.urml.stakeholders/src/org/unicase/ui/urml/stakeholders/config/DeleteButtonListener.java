package org.unicase.ui.urml.stakeholders.config;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.urml.StakeholderRole;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Listener of the manage role dialog buttons.
 * 
 * @author kterzieva
 */
public class DeleteButtonListener implements Listener {

	private TableViewer tableViewer;
	private Shell shell;
	private Project activeProject;

	/**
	 * 
	 */

	/**
	 * @param manageRolesDialog
	 */
	DeleteButtonListener( TableViewer tableViewer, Shell s, Project activeProject) {
		this.tableViewer = tableViewer;
		this.shell = s;
		this.activeProject = activeProject;
	}

	public void handleEvent(Event event) {
		TableItem[] select = tableViewer.getTable().getSelection();
		for (TableItem t1 : select) {
			if (t1.getData() instanceof UnicaseModelElement) {
				final StakeholderRole role = (StakeholderRole) t1.getData();
				boolean b = MessageDialog.openConfirm(
						shell,
						"Delete " + role.getName(),
						"Are you sure you want to delete " + role.getName()
								+ "?");
				if (b) {
					//Remove from displayed list
					@SuppressWarnings("unchecked")
					List<UnicaseModelElement> list = (List<UnicaseModelElement>) tableViewer.getInput();
					list.remove(role);
					tableViewer.refresh();
					
					new UnicaseCommand() {
						@Override
						protected void doRun() {
							activeProject.deleteModelElement(role);
						}
					}.run();

				}
			}
		}

	}
}