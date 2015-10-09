/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard;

import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.ui.util.ECPModelElementOpener;
import org.eclipse.emf.emfstore.internal.client.model.ProjectSpace;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

/**
 * Opener for the dashboard.
 * 
 * @author helming
 */
public class ModelElementOpener implements ECPModelElementOpener {
	/**
	 * default constructor.
	 */
	public ModelElementOpener() {
		// TODO Auto-generated constructor stub
	}

	public void openModelElement(Object element, ECPProject ecpProject) {
		if (element instanceof ProjectSpace) {
			ProjectSpace projectSpace = (ProjectSpace) element;
			UnicaseActionHelper.openDashboard(projectSpace);
			return;
		}
	}

}
