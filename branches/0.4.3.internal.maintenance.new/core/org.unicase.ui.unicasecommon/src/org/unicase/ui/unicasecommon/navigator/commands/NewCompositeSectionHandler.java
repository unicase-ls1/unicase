/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.navigator.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.workspace.WorkspaceManager;

/**
 * @author Helming This is the handler to create a new CompositeSection
 */

public class NewCompositeSectionHandler extends AbstractHandler {

	private static final String NEW_COMPOSITESECTION_NAME = "new composite section";

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		UnicaseModelElement me = UnicaseActionHelper.getModelElement(event);
		if (me == null) {
			return null;
		}

		if (!(me instanceof CompositeSection)) {
			return null;
		}
		final CompositeSection compositeSection = (CompositeSection) me;

		final CompositeSection createCompositeSection = DocumentFactory.eINSTANCE.createCompositeSection();
		createCompositeSection.setName(NEW_COMPOSITESECTION_NAME);

		TransactionalEditingDomain domain = WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				compositeSection.getSubsections().add(createCompositeSection);
			}
		});

		ActionHelper.openModelElement(createCompositeSection, this.getClass().getName());

		return null;
	}

}
