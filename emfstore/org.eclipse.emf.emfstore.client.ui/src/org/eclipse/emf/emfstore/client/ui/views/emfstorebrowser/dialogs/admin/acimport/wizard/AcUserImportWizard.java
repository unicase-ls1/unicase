/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin.acimport.wizard;

import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.emfstore.client.model.AdminBroker;
import org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin.acimport.ImportController;
import org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin.acimport.ImportItemWrapper;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.wizard.Wizard;

/**
 * @author deser, karakoc
 */
public class AcUserImportWizard extends Wizard {

	private ImportController importController;

	/**
	 * @param broker
	 *            the broker which creates new users or groups at the end of the
	 *            execution of this wizard.
	 */
	public AcUserImportWizard(AdminBroker broker) {
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
		ArrayList<ImportItemWrapper> wrappedOrgUnits = ((AcUserImportPageTwo) this
				.getPages()[1]).getCheckedItems();
		if (wrappedOrgUnits.size() > 0) {
			ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(
					getShell());
			progressMonitorDialog.open();
			progressMonitorDialog.getProgressMonitor().beginTask(
					"Importing users", IProgressMonitor.UNKNOWN);

			importController.importOrgUnits(wrappedOrgUnits);

			progressMonitorDialog.close();
			return true;
		} else {
			return false;
		}
	}

}
