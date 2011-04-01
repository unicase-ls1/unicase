/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.unicase.emfstore.jdt.eclipseworkspace.emfstore;

import java.util.List;

import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.ui.commands.UpdateProjectVersionHandler;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;

/**
 * You can update to a certain project version. This is implemented by the super class. But the user shouldn't see a
 * dialog with the changes that will be done, and at the end no dash board should be opned.
 * 
 * @author Adrian Staudt
 */
public class EMFStoreJDTUpdateProjectVersionHandler extends UpdateProjectVersionHandler {

	/**
	 * All changes are getting accepted, without asking the user. {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.ui.commands.UpdateProjectVersionHandler#inspectChanges(org.eclipse.emf.emfstore.client.model.ProjectSpace,
	 *      java.util.List)
	 */
	@Override
	public boolean inspectChanges(ProjectSpace projectSpace, List<ChangePackage> changePackages) {
		return true;
	}

	/**
	 * The dash board will not be opened. {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.ui.commands.UpdateProjectVersionHandler#updateCompleted()
	 */
	@Override
	public void updateCompleted(ProjectSpace projectSpace) {
		// don't show anything
	}
}
