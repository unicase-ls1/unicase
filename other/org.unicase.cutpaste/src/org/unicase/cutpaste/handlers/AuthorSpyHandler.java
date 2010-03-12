/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.cutpaste.handlers;

import java.util.Date;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.util.ActionHelper;

/**
 * This class contains utility methods for dev.-purposes.
 * 
 * @author weiglt
 */
public class AuthorSpyHandler extends AbstractHandler {

	/**
	 * Executes the Button Command for "AuthorSpy" Gadget. Pops a MessageBox with author informations.
	 * 
	 * @param event The MouseClick Event
	 * @return null
	 * @throws ExecutionException ExecutionException
	 */
	public final Object execute(final ExecutionEvent event) throws ExecutionException {

		ModelElement me = ActionHelper.getModelElement(event);

		String author, creationDate;
		author = lookupAuthor(me);
		creationDate = lookupCreationDate(me);

		MessageDialog.openInformation(null, "w@iglt info_box", "Object has been created by: " + author
			+ " on the following date: " + creationDate + ". Rest: -> " + me.toString());
		return null;
	}

	private String lookupAuthor(final ModelElement me) {
		String creator = me.getCreator();
		return creator;
	}

	private String lookupCreationDate(final ModelElement me) {
		Date creation = me.getCreationDate();
		java.sql.Date formattedCreation = new java.sql.Date(creation.getTime());
		return formattedCreation.toString();
	}
}
