/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.usecaseDiagram.application;

import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

/**
 * @generated
 */
public class DiagramEditorWorkbenchAdvisor extends WorkbenchAdvisor {
	/**
	 * @generated
	 */
	public static final String PERSPECTIVE_ID = "org.unicase.ui.diagram.usecaseDiagram.UseCasePerspective"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;
	}

	/**
	 * @generated
	 */
	public void initialize(IWorkbenchConfigurer configurer) {
		super.initialize(configurer);
		configurer.setSaveAndRestore(true);
	}

	/**
	 * @generated
	 */
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		return new org.unicase.ui.diagram.usecaseDiagram.application.DiagramEditorWorkbenchWindowAdvisor(
				configurer);
	}

}
