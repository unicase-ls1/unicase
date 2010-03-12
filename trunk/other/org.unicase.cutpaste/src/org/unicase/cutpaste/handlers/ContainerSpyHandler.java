/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.cutpaste.handlers;

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
public class ContainerSpyHandler extends AbstractHandler {

	/**
	 * Executes the Button Command for "ContainerSpy" Gadget. Pops a MessageBox with ME container informations.
	 * 
	 * @param event The MouseClick Event
	 * @return null
	 * @throws ExecutionException ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		ModelElement me = ActionHelper.getModelElement(event);

		String containerObject;
		containerObject = me.getContainerModelElement().toString();

		MessageDialog.openInformation(null, "w@iglt info_box", "Container is: " + containerObject + ".");
		return null;
	}

}
