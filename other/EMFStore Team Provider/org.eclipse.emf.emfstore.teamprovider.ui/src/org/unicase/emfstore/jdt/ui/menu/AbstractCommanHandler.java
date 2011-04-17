/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.unicase.emfstore.jdt.ui.menu;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.unicase.emfstore.jdt.configuration.ConfigurationManager;
import org.unicase.emfstore.jdt.ui.decorator.EMFStoreJDTEntryDecorator;

/**
 * Common handler, that provides all handler the possibility to refresh the UI.
 * 
 * @author Adrian Staudt
 */
public abstract class AbstractCommanHandler extends AbstractHandler {

	/**
	 * Updates the UI.
	 * 
	 * @param file The location where the update should be performed.
	 */
	protected void refreshUI(IFile file) {
		// refresh UI
		try {
			file.getProject().getFile(ConfigurationManager.EMFSTORECONF)
				.refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());
			file.getProject().refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());
		} catch (CoreException e) {
			ModelUtil.logException(e);
		}

		EMFStoreJDTEntryDecorator.refreshDecorator();
	}

}
