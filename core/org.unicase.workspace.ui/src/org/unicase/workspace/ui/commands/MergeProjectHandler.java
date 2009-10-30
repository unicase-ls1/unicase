/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.Project;
import org.unicase.workspace.exceptions.ChangeConflictException;
import org.unicase.workspace.observers.ConflictResolver;
import org.unicase.workspace.ui.dialogs.MergeDialog;

/**
 * This is a ConflictResolver that shows a MergeDialog when triggered.
 * 
 * @author Shterev
 */
public class MergeProjectHandler implements ConflictResolver {

	private MergeDialog mergeDialog;

	/**
	 * Default constructor.
	 * 
	 * @param conflictException
	 *            the ChangeConflictException
	 */
	public MergeProjectHandler(ChangeConflictException conflictException) {
		this.mergeDialog = new MergeDialog(Display.getCurrent()
				.getActiveShell());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.ConflictResolver#getAcceptedMine()
	 */
	public List<AbstractOperation> getAcceptedMine() {
		ArrayList<AbstractOperation> ret = new ArrayList<AbstractOperation>();
		// ret.addAll(autoAcceptedMine);
		ret.addAll(mergeDialog.getAcceptedMine());
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.ConflictResolver#getAcceptedMine()
	 */
	public List<AbstractOperation> getRejectedTheirs() {
		return mergeDialog.getRejectedTheirs();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.ConflictResolver#getAcceptedMine()
	 */
	public boolean resolveConflicts(Project project,
			List<ChangePackage> theirChangePackages,
			ChangePackage myChangePackage) {
		mergeDialog.setChanges(myChangePackage, theirChangePackages);
		return (mergeDialog.open() == Window.OK);
	}
}
