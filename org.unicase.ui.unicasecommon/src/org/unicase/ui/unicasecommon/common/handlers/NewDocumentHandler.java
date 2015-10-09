/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.internal.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.internal.client.model.util.EMFStoreCommand;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;

/**
 * . This is the handler to add a new Document to a ProjectSpace
 * 
 * @author Helming
 */
public class NewDocumentHandler extends AbstractHandler {

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		final IStructuredSelection ssel = (IStructuredSelection) selection;
		EObject eObject = (EObject) ssel.getFirstElement();
		if (!(eObject instanceof ProjectSpace)) {
			return null;
		}
		final ProjectSpace projectSpace = (ProjectSpace) eObject;

		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				CompositeSection compositeSection = DocumentFactory.eINSTANCE
						.createCompositeSection();
				compositeSection.setName("new Document");
				projectSpace.getProject().addModelElement(compositeSection);
			}
		}.run(true);

		return null;
	}
}
