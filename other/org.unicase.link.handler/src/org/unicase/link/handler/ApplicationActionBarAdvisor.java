/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.handler;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
/**
 * TODO: javadoc.
 * @author -insert author-
 *
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	/**
	 * TODO: javadoc.
	 * @param configurer -insert doc-
	 */
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    /**
     * TODO: javadoc.
     * @param window -insert doc-
     */
    protected void makeActions(IWorkbenchWindow window) {
    }

    /**
     * TODO: javadoc.
     * @param menuBar -insert doc-
     */
    protected void fillMenuBar(IMenuManager menuBar) {
    }
    
}
