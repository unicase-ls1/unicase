/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.util.UiUtil;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
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

		EObject eObject = UiUtil.getSelection(event);
		if (!(eObject instanceof ProjectSpace)) {
			return null;
		}
		final ProjectSpace projectSpace = (ProjectSpace) eObject;

		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				CompositeSection compositeSection = DocumentFactory.eINSTANCE.createCompositeSection();
				compositeSection.setName("new Document");
				projectSpace.getProject().addModelElement(compositeSection);
			}
		}.run(true);

		return null;
	}

}
