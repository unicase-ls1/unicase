/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin;

import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.wizard.Wizard;
import org.unicase.workspace.AdminBroker;
import org.unicase.workspace.ui.views.emfstorebrowser.acimport.ImportController;
import org.unicase.workspace.ui.views.emfstorebrowser.acimport.ImportWrapper;

/**
 * @author deser, karakoc
 */
public class AcUserImportWizard extends Wizard {

	private ImportController importController;
	private ListViewer listViewer;

	/**
	 * @param broker
	 *            the broker which creates new users or groups at the end of the
	 *            execution of this wizard.
	 * @param listViewer
	 *            listViewer
	 */
	public AcUserImportWizard(AdminBroker broker, ListViewer listViewer) {
		this.listViewer = listViewer;
		importController = new ImportController(broker);
		this.setWindowTitle("Import new users");
	}

	/**
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		super.addPage(new AcUserImportPageOne());
		super.addPage(new AcUserImportPageTwo());
	}

	/**
	 * @return the current import controller (e.g. LDAP, CSV)
	 */
	public ImportController getController() {
		return importController;
	}

	/**
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 * @return a boolean which indicates, if there are items selected or not.
	 */
	@Override
	public boolean performFinish() {
		ArrayList<ImportWrapper> wrappedOrgUnits = ((AcUserImportPageTwo) this
				.getPages()[1]).getCheckedItems();
		if (wrappedOrgUnits.size() > 0) {
			ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(
					getShell());
			progressMonitorDialog.open();
			progressMonitorDialog.getProgressMonitor().beginTask(
					"Importing users", IProgressMonitor.UNKNOWN);

			importController.importOrgUnits(wrappedOrgUnits);
			this.listViewer.refresh();

			progressMonitorDialog.close();
			return true;
		} else {
			return false;
		}
	}

}
