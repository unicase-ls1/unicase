/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.codetrace.ui;

/**
 * Search active project and give all his model elements in user dialog
 * @author kterzieva
 * @author snogina
 * @author jfinis
 * 
 */

import org.eclipse.jface.window.Window;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * Utility class for attaching code locations.
 * @author kterziewa
 * @author snogina
 *
 */
public final class AttachCodeLocation {
	
	/**
	 * Utility Class.
	 */
	private AttachCodeLocation(){}

	private static Project getActiveProject() {
		final ProjectSpace ps = WorkspaceManager.getInstance()
				.getCurrentWorkspace().getActiveProjectSpace();
		if (ps.getProject() != null) {
			return ps.getProject();
		} else {
			System.out.println("Project was not found!");
			return null;
		}

	}

	/**
	 * Shows a dialog to select a model element to attach a code location to.
	 * @return the chosen model element
	 */
	public static UnicaseModelElement showChooseMEForCodeLocationDialog() {
		ChooseModelElementDialog cmed = new ChooseModelElementDialog(
				getActiveProject(), "Choose Model Element for code location!");
		if (cmed.open() == Window.OK) {
			Object[] result = cmed.getResult();

			if (result.length > 0) {
				for (Object o : result) {
					if (o instanceof UnicaseModelElement ) {
						return (UnicaseModelElement)o;
					}
				}
			}
		}
		
		return null;

	}
}
