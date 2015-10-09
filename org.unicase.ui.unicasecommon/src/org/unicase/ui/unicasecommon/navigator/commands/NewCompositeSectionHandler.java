/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.navigator.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.internal.client.model.util.EMFStoreCommand;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

/**
 * @author Helming This is the handler to create a new CompositeSection
 */

public class NewCompositeSectionHandler extends AbstractHandler {

	private static final String NEW_COMPOSITESECTION_NAME = "new composite section";

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		EObject me = UnicaseActionHelper.getModelElement(event);
		if (me == null) {
			return null;
		}

		if (!(me instanceof CompositeSection)) {
			return null;
		}
		final CompositeSection compositeSection = (CompositeSection) me;

		final CompositeSection createCompositeSection = DocumentFactory.eINSTANCE
				.createCompositeSection();
		createCompositeSection.setName(NEW_COMPOSITESECTION_NAME);

		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				compositeSection.getSubsections().add(createCompositeSection);
			}
		}.run(true);

		UnicaseActionHelper.openModelElement(createCompositeSection, this
				.getClass().getName());

		return null;
	}

}
