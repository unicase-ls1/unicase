/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

/**
 * Opener for the dashboard.
 * 
 * @author helming
 */
public class ModelElementOpener implements org.eclipse.emf.ecp.common.util.ModelElementOpener {
	/**
	 * default constructor.
	 */
	public ModelElementOpener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.util.ModelElementOpener#canOpen(org.eclipse.emf.ecore.EObject)
	 */
	public int canOpen(EObject modelElement) {
		if (modelElement instanceof ProjectSpace) {
			return 2;
		}
		return DONOTOPEN;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.util.ModelElementOpener#openModelElement(org.eclipse.emf.ecore.EObject)
	 */
	public void openModelElement(EObject modelElement) {
		if (modelElement instanceof ProjectSpace) {
			ProjectSpace projectSpace = (ProjectSpace) modelElement;
			UnicaseActionHelper.openDashboard(projectSpace);
			return;
		}

	}

}
