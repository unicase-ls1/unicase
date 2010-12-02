/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.navigator.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.workspace.WorkspaceManager;

/**
 * @author Helming This handler adds a new LeafSection to selected CompositeSection
 */
public class NewLeafSection extends AbstractHandler {

	private static final String NEW_LEAFSECTION_NAME = "new leaf section";

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		EObject eObject = ActionHelper.getModelElement(event);
		if (eObject == null) {
			return null;
		}

		if (!(eObject instanceof CompositeSection)) {
			return null;
		}

		final CompositeSection compositeSection = (CompositeSection) eObject;

		final LeafSection createLeafSection = DocumentFactory.eINSTANCE.createLeafSection();

		createLeafSection.setName(NEW_LEAFSECTION_NAME);

		TransactionalEditingDomain domain = WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				compositeSection.getSubsections().add(createLeafSection);
			}
		});

		UnicaseActionHelper.openModelElement(createLeafSection, this.getClass().getName());

		return null;
	}

}
