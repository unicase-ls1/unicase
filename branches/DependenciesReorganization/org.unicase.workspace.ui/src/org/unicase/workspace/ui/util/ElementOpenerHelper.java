/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.util;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Allows to open model elements from workspace ui.
 * 
 * @author emueller
 * @author wesendon
 */
public class ElementOpenerHelper {

	/**
	 * Opens model element from worspace.ui.
	 * 
	 * @param me modelelement
	 * @param sourceView source view
	 */
	public static void openModelElement(final EObject me, final String sourceView) {
		IConfigurationElement[] modelelementopener = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.common.modelelementopener");
		ModelElementOpener bestCandidate = null;
		int bestValue = -1;
		for (IConfigurationElement element : modelelementopener) {
			try {
				ModelElementOpener modelelementOpener = (ModelElementOpener) element.createExecutableExtension("class");
				int value = modelelementOpener.canOpen(me);
				if (value > bestValue) {
					bestCandidate = modelelementOpener;
					bestValue = value;
				}
			} catch (CoreException e) {
				WorkspaceUtil.logException(e.getMessage(), e);
			}
		}

		try {
			bestCandidate.openModelElement(me);
		} catch (RuntimeException e) {
			WorkspaceUtil.logException(e.getMessage(), e);
		}
	}
}