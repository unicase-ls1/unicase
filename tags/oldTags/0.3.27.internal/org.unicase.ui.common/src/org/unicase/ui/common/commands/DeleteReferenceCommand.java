/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.commands;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;

/**
 * Command to delete a reference.
 * 
 * @author helming
 * @author shterev
 */
public final class DeleteReferenceCommand extends RecordingCommand {
	private EReference reference;
	private ModelElement modelElement;
	private ModelElement opposite;

	/**
	 * Default constructor.
	 * 
	 * @param domain the domain
	 * @param modelElement the initiating {@link ModelElement}
	 * @param reference the reference
	 * @param opposite the element on the other side - the element to be removed.
	 */
	public DeleteReferenceCommand(TransactionalEditingDomain domain, ModelElement modelElement, EReference reference,
		ModelElement opposite) {
		super(domain);
		this.modelElement = modelElement;
		this.reference = reference;
		this.opposite = opposite;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doExecute() {
		Object object = modelElement.eGet(reference);

		if (reference.isContainer()) {
			opposite.getProject().addModelElement(modelElement);
			return;
		}
		if (reference.isContainment()) {
			modelElement.getProject().addModelElement(opposite);
			return;
		}

		if (object instanceof EList<?>) {
			@SuppressWarnings("unchecked")
			EList<EObject> list = (EList<EObject>) object;
			list.remove(opposite);
			return;
		} else {
			modelElement.eSet(reference, null);
			return;
		}

	}
}