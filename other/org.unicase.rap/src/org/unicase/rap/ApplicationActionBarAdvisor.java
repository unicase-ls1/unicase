/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap;

import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

/**
 * Creates, adds and disposes actions for the menus and action bars of
 * each workbench window.
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	/**
	 * The constructor.
	 * 
	 * @param configurer Action bar configurer.
	 */
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

	/**
	 * {@inheritDoc}
	 */
    protected void makeActions(IWorkbenchWindow window) {
    }

	/**
	 * {@inheritDoc}
	 */
    protected void fillMenuBar(IMenuManager menuBar) {
    }
    
}


