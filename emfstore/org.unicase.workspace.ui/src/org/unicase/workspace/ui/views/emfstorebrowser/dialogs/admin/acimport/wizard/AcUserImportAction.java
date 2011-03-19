/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin.acimport.wizard;

import org.eclipse.emf.emfstore.client.AdminBroker;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.unicase.workspace.ui.Activator;

/**
 * @author deser
 */
public class AcUserImportAction extends Action {

	private final AdminBroker broker;

	/**
	 * @param broker
	 *            The admin broker which is needed for the wizard.
	 */
	public AcUserImportAction(AdminBroker broker) {
		super("Import user or group");
		this.broker = broker;
		this.setImageDescriptor(Activator
				.getImageDescriptor("icons/importuser.png"));
		this.setToolTipText("Import user or group");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		AcUserImportWizard wizard = new AcUserImportWizard(broker);
		WizardDialog dialog = new WizardDialog(Display.getCurrent()
				.getActiveShell(), wizard);
		dialog.create();
		dialog.open();

		// We assume that every import was successful, because this is just used
		// to update views.
		notifyResult(true);
	}

}
