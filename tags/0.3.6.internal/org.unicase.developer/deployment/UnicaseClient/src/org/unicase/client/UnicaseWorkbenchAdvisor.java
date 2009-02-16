/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.client;

import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

/**
 * Workbench advisor for unicase.
 * @author naughton
 *
 */
public class UnicaseWorkbenchAdvisor extends WorkbenchAdvisor {

	private static final String PERSPECTIVE_ID = "org.unicase.client.UnicasePerspective";

    /** 
     * {@inheritDoc}
     * @see org.eclipse.ui.application.WorkbenchAdvisor#createWorkbenchWindowAdvisor(org.eclipse.ui.application.IWorkbenchWindowConfigurer)
     */
    @Override
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new UnicaseWorkbenchWindowAdvisor(configurer);
    }

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.ui.application.WorkbenchAdvisor#getInitialWindowPerspectiveId()
	 */
	@Override
	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;
	}
}
