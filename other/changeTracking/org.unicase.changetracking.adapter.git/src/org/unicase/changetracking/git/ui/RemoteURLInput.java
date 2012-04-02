/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.ui;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.unicase.changetracking.exceptions.CancelledByUserException;

/**
 * Provides a window where the user can enter the URL of a remote repository.
 * 
 * @author jfinis
 * 
 */
public class RemoteURLInput {

	/**
	 * Shows the window where the user can enter the location of the remote
	 * repository. Blocks until the user is finished and returns the location.
	 * Throws an exception if the user cancelled the dialog.
	 * 
	 * @return selected URL
	 * @throws CancelledByUserException if the user cancels the dialog
	 */
	public String show() throws CancelledByUserException {

		InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(), "Repository Remote URL", "Enter the URL of the remote repository which should be associated with this local repository.", "", new InputValidator());
		dlg.setBlockOnOpen(true);
		dlg.open();
		if (dlg.getReturnCode() != Window.OK) {
			throw new CancelledByUserException();
		}
		String url = dlg.getValue();
		return url;

	}

	/**
	 * This class validates a String. It makes sure that the String is between 5
	 * and 8 characters
	 */
	class InputValidator implements IInputValidator {
		/**
		 * Validates the String. Returns null for no error, or an error message
		 * 
		 * @param newText the String to validate
		 * @return String
		 */
		public String isValid(String newText) {
			int len = newText.length();

			// Determine if input is too short or too long
			if (len < 1) {
				return "Enter a valid git url";
			}

			// Input must be OK
			return null;
		}
	}

}
