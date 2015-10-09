/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.ui.PlatformUI;

/**
 * Command to delete a modelelement.
 * 
 * @author helming
 * @author shterev
 */
public final class DeleteModelElementCommand {
	private final EObject me;
	private final ECPProject context;

	/**
	 * Default constructor.
	 * 
	 * @param opposite
	 *            the model element to be deleted.
	 * @param project
	 *            the model element context
	 */
	public DeleteModelElementCommand(EObject opposite, ECPProject project) {
		this.me = opposite;
		this.context = project;
	}

	/**
	 * {@inheritDoc}
	 */
	public void run() {

		AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		String modelElementName = adapterFactoryLabelProvider.getText(me);
		MessageDialog dialog = new MessageDialog(null, "Confirmation", null,
				"Do you really want to delete " + modelElementName + "?",
				MessageDialog.QUESTION, new String[] { "Yes", "No" }, 0);
		int result = dialog.open();
		if (result == MessageDialog.OK) {
			ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getShell());
			progressDialog.open();
			progressDialog.getProgressMonitor().beginTask(
					"Deleting " + modelElementName + "...", 100);
			progressDialog.getProgressMonitor().worked(20);

			try {
				context.getEditingDomain()
						.getCommandStack()
						.execute(
								DeleteCommand.create(
										context.getEditingDomain(), me));
			} finally {
				progressDialog.getProgressMonitor().done();
				progressDialog.close();
			}

		}

	}

}
