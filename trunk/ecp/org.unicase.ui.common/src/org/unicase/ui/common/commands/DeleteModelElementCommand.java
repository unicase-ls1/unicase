/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.commands;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.ecp.model.ECPModelelementContext;
import org.unicase.ecp.model.workSpaceModel.util.AssociationClassHelper;

/**
 * Command to delete a modelelement.
 * 
 * @author helming
 * @author shterev
 */
public final class DeleteModelElementCommand {

	private final Set<EObject> toBeDeleted;
	private final ECPModelelementContext context;

	/**
	 * Default constructor.
	 * 
	 * @param opposite the model element to be deleted.
	 * @param context the model element context
	 */
	public DeleteModelElementCommand(EObject element, ECPModelelementContext context) {
		this(Collections.singleton(element), context);
	}

	/**
	 * Default constructor.
	 * 
	 * @param opposite the model elements to be deleted.
	 * @param context the model element context
	 */
	public DeleteModelElementCommand(Set<EObject> elements, ECPModelelementContext context) {
		this.toBeDeleted = elements;
		this.context = context;
	}

	/**
	 * {@inheritDoc}
	 */
	public void run() {
		// remove already contained model elements to prevent double deletes -> exception
		removeDoubleDeleteCandidates();
		// collect all association classes to be deleted
		Set<EObject> additionalMEs = new HashSet<EObject>();
		for (EObject eObject : toBeDeleted) {
			additionalMEs.addAll(AssociationClassHelper.getRelatedAssociationClassToDelete(eObject, context
				.getMetaModelElementContext()));
		}
		toBeDeleted.addAll(additionalMEs);
		// now delete
		if (askConfirmation()) {
			ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell());
			progressDialog.open();
			try {
				context.getEditingDomain().getCommandStack().execute(
					DeleteCommand.create(context.getEditingDomain(), toBeDeleted));
			} finally {
				progressDialog.getProgressMonitor().done();
				progressDialog.close();
			}
		}
	}

	private void removeDoubleDeleteCandidates() {
		Set<EObject> toBeDeletedTemp = new HashSet<EObject>();
		for (EObject toBeDeletedEObject : toBeDeleted) {
			for (EObject toBeDeletedEObject2 : toBeDeleted) {
				TreeIterator<EObject> iterator = toBeDeletedEObject.eAllContents();
				if (toBeDeletedEObject != toBeDeletedEObject2) {
					while (iterator.hasNext()) {
						EObject eObject = iterator.next();
						if (eObject == toBeDeletedEObject2) {
							toBeDeletedTemp.add(toBeDeletedEObject2);
							continue;
						}
					}
				}
			}
		}
		for (EObject eObject : toBeDeletedTemp) {
			toBeDeleted.remove(eObject);
		}
	}

	private boolean askConfirmation() {
		String question = null;
		if (toBeDeleted.size() == 1) {
			AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
			String modelElementName = adapterFactoryLabelProvider.getText(toBeDeleted.iterator().next());
			question = "Do you really want to delete the model element " + modelElementName + "?";
		} else {
			question = "Do you really want to delete these " + toBeDeleted.size() + " model elements?";
		}
		MessageDialog dialog = new MessageDialog(null, "Confirmation", null, question, MessageDialog.QUESTION,
			new String[] { "Yes", "No" }, 0);
		return dialog.open() == MessageDialog.OK;
	}
}
