/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: groeber
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.views.historybrowserview;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;

/**
 * Handles registered Compare types for the extension point:
 * org.eclipse.emf.emfstore.client.ui.views.historybrowsercomparator
 * 
 * @author groeber
 */
public class HistoryCompare {

	// This is the ID of the extension point
	private final String HISTORY_COMPARE_ID = "org.eclipse.emf.emfstore.client.ui.views.historybrowsercomparator";

	/**
	 * This function tells you if there is a Comparator registered on the
	 * extension point
	 * 
	 * @return true if there is an extension or false if not
	 */
	public static boolean hasRegisteredExtensions() {
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(HISTORY_COMPARE_ID);
		return (config.length != 0);

	}

	/**
	 * This function calls {@link ICompare#compare(EObject e1, EObject e2)}and
	 * then {@link ICompare#display()} for all registered extensions.
	 * 
	 * @param e1
	 *            EObject one to compare
	 * @param e2
	 *            EObject two to compare
	 */
	public static void handleRegisteredExtensions(final EObject e1, final EObject e2) {
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(HISTORY_COMPARE_ID);
		try {
			for (IConfigurationElement e : config) {
				final Object o = e.createExecutableExtension("class");
				if (o instanceof ICompare) {
					ISafeRunnable runnable = new ISafeRunnable() {
						// @Override
						public void handleException(Throwable exception) {
							System.out.println("Exception in client");
						}

						// @Override
						public void run() throws Exception {
							ICompare extension = (ICompare) o;

							extension.compare(e1, e2);
							extension.display();

						}
					};
					SafeRunner.run(runnable);
				}
			}
		} catch (CoreException ex) {
			String message = "Error while instantiating compare provider!";
			ModelUtil.logWarning(message, ex);
		}
	}
}
