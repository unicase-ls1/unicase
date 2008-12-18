/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.navigator.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelFactory;
import org.unicase.model.Section;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.workspace.WorkspaceManager;

/**
 * 
 * @author Helming
 * This is the handler to create a new CompositeSection
 *
 */

public class NewCompositeSectionHandler extends AbstractHandler  {

	private static final String NEW_COMPOSITESECTION_NAME = "new composite section";
	
	/**.
	 * {@inheritDoc}}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		
		ModelElement me = ActionHelper.getModelElement(event);
		if (me == null) {
			return null;
		}
		
		if (!(me instanceof Section)) {
			return null;
		}
		final Section compositeSection = (Section) me;

		final Section createCompositeSection = ModelFactory.eINSTANCE
				.createSection();
		createCompositeSection.setName(NEW_COMPOSITESECTION_NAME);

		TransactionalEditingDomain domain = WorkspaceManager.getInstance()
				.getCurrentWorkspace().getEditingDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				compositeSection.getModelElements().add(createCompositeSection);
			}
		});

		ActionHelper.openModelElement(createCompositeSection, this.getClass().getName());

		return null;
	}

}
