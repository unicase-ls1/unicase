/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen. All rights
 * reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.common.commands;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.model.ECPModelelementContext;
import org.eclipse.emf.ecp.common.model.workSpaceModel.util.AssociationClassHelper;
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

	private final Set<EObject> toBeDeleted;
	private final ECPModelelementContext context;

	/**
	 * Default constructor.
	 * 
	 * @param element the model element to be deleted.
	 * @param context the model element context
	 */
	public DeleteModelElementCommand(EObject element, ECPModelelementContext context) {
		this(Collections.singleton(element), context);
	}

	/**
	 * Default constructor.
	 * 
	 * @param elements the model elements to be deleted.
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
		removeAnchestorDuplicates(toBeDeleted);

		// collect all association classes to be deleted
		Set<EObject> additionalMEs = new HashSet<EObject>();
		for (EObject eObject : toBeDeleted) {
			additionalMEs.addAll(AssociationClassHelper.getRelatedAssociationClassToDelete(eObject,
				context.getMetaModelElementContext()));
		}
		toBeDeleted.addAll(additionalMEs);
		// now delete
		if (askConfirmation()) {
			ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell());
			progressDialog.open();
			try {
				removeElementsWithoutRoot(toBeDeleted);

				Command deleteCommand = DeleteCommand.create(context.getEditingDomain(), toBeDeleted);
				context.getEditingDomain().getCommandStack().execute(deleteCommand);
			} finally {
				progressDialog.getProgressMonitor().done();
				progressDialog.close();
			}
		}
	}

	private void removeElementsWithoutRoot(Set<EObject> toBeDeleted) {
		HashSet<EObject> tmpRemove = new HashSet<EObject>();
		for (EObject obj : toBeDeleted) {
			if (obj.eContainer() == null) {
				obj.eResource().getContents().remove(obj);
				tmpRemove.add(obj);
			}
		}
		toBeDeleted.removeAll(tmpRemove);
	}

	private void removeAnchestorDuplicates(Set<EObject> toBeDeleted) {
		HashSet<EObject> toBeRemoved = new HashSet<EObject>();
		for (EObject obj : toBeDeleted) {
			if (parentIsContained(toBeDeleted, obj)) {
				toBeRemoved.add(obj);
			}
		}
		toBeDeleted.removeAll(toBeRemoved);
	}

	private boolean parentIsContained(Set<EObject> toBeDeleted, EObject obj) {
		EObject container = obj.eContainer();
		if (container == null) {
			return false;
		}
		if (toBeDeleted.contains(container)) {
			return true;
		}
		return parentIsContained(toBeDeleted, container);
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
