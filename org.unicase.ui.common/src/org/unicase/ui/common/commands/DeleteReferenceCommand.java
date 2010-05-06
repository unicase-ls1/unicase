/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.commands;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Command to delete a reference.
 * 
 * @author helming
 * @author shterev
 */
public final class DeleteReferenceCommand extends UnicaseCommand {
	private EReference reference;
	private EObject modelElement;
	private EObject opposite;

	/**
	 * Default constructor.
	 * 
	 * @param modelElement the initiating {@link ModelElement}
	 * @param reference the reference
	 * @param opposite the element on the other side - the element to be removed.
	 */
	public DeleteReferenceCommand(EObject modelElement, EReference reference, EObject opposite) {
		this.modelElement = modelElement;
		this.reference = reference;
		this.opposite = opposite;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doRun() {
		Object object = modelElement.eGet(reference);

		if (reference.isContainer()) {
			ModelUtil.getProject(opposite).addModelElement(modelElement);
			return;
		}
		if (reference.isContainment()) {
			ModelUtil.getProject(modelElement).addModelElement(opposite);
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