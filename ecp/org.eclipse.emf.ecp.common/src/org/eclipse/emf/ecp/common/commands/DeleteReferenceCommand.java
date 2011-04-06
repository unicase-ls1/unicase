/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.common.commands;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Command to delete a reference.
 * 
 * @author helming
 * @author shterev
 */
public final class DeleteReferenceCommand {
	private EReference reference;
	private EObject modelElement;
	private EObject opposite;
	private final EditingDomain editingDomain;

	/**
	 * Default constructor.
	 * 
	 * @param modelElement the initiating modelelement
	 * @param reference the reference
	 * @param opposite the element on the other side - the element to be removed.
	 * @param editingDomain the editing domain to execute the command.
	 */
	public DeleteReferenceCommand(EObject modelElement, EReference reference, EObject opposite,
		EditingDomain editingDomain) {
		this.modelElement = modelElement;
		this.reference = reference;
		this.opposite = opposite;
		this.editingDomain = editingDomain;
	}

	/**
	 * {@inheritDoc}
	 */
	public void run() {
		Object object = modelElement.eGet(reference);

		// TODO: Ask user in the following two cases if he really wants to delete the model element
		// if (reference.isContainer()) {
		// opposite.getProject().addModelElement(modelElement);
		// return;
		// }
		// if (reference.isContainment()) {
		// modelElement.getProject().addModelElement(opposite);
		// return;
		// }
		if (object instanceof EList<?>) {
			@SuppressWarnings("unchecked")
			EList<EObject> list = (EList<EObject>) object;
			RemoveCommand removeCommand = new RemoveCommand(editingDomain, list, opposite);
			editingDomain.getCommandStack().execute(removeCommand);
			return;
		} else {
			SetCommand setCommand = new SetCommand(editingDomain, modelElement, reference, null);
			editingDomain.getCommandStack().execute(setCommand);
			return;
		}

	}
}
