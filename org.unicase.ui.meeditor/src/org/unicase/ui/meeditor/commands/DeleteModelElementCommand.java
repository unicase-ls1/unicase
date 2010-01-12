/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Command to delete a modelelement.
 * 
 * @author helming
 * @author shterev
 */
public final class DeleteModelElementCommand extends UnicaseCommand {
	private final ModelElement me;

	/**
	 * Default constructor.
	 * 
	 * @param me the {@link ModelElement} to be deleted.
	 */
	public DeleteModelElementCommand(ModelElement me) {
		this.me = me;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doRun() {
		if (closeEditor(me)) {
			AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
			String modelElementName = adapterFactoryLabelProvider.getText(me);
			MessageDialog dialog = new MessageDialog(null, "Confirmation", null, "Do you really want to delete "
				+ modelElementName + "?", MessageDialog.QUESTION, new String[] { "Yes", "No" }, 0);
			int result = dialog.open();
			if (result == MessageDialog.OK) {
				ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell());
				progressDialog.open();
				progressDialog.getProgressMonitor().beginTask("Deleting " + modelElementName + "...", 100);
				progressDialog.getProgressMonitor().worked(20);

				try {
					me.delete();
				} finally {
					progressDialog.getProgressMonitor().done();
					progressDialog.close();
				}

			}
		}
	}

	private boolean closeEditor(ModelElement me) {

		boolean result = true;

		// we could find editors with this ME as input
		// but we don't want to have a dependency on meeditor plug-in
		// Therefore we have no access to MEEditorInput class
		IEditorReference[] openEditors = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
			.getEditorReferences();

		List<IEditorReference> toCloseEditors = new ArrayList<IEditorReference>();
		for (int i = 0; i < openEditors.length; i++) {
			try {

				IEditorInput editorInput = openEditors[i].getEditorInput();

				if (editorInput instanceof URIEditorInput) {
					ModelElement modelElement = WorkspaceUtil.getModelElementByUri(((URIEditorInput) editorInput)
						.getURI());
					if (modelElement != null && modelElement.equals(me)) {
						toCloseEditors.add(openEditors[i]);
					}
				}

			} catch (PartInitException e) {
				DialogHandler.showExceptionDialog(e);
				result = false;
			}
		}

		if (toCloseEditors.size() > 0) {
			result = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditors(
				toCloseEditors.toArray(new IEditorReference[toCloseEditors.size()]), true);

		}

		return result;
	}
}
