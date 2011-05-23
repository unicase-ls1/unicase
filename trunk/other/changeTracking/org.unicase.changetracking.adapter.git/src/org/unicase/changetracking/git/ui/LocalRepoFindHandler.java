/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.ui;

import java.io.IOException;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepository;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.exceptions.CancelledByUserException;
import org.unicase.changetracking.git.common.GitRepoFindUtil;
import org.unicase.changetracking.ui.AdvancedMessageDialog;
import org.unicase.changetracking.ui.AdvancedMessageDialog.NoLocalRepoChoices;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.changetracking.Release;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.changetracking.Stream;
import org.unicase.model.changetracking.git.GitRepository;

/**
 * UI component for finding the local repository associated to a release. Asks
 * the user for cloning or specifying a location if the local repository is not
 * found in the workspace
 * 
 * @author jfinis
 * 
 */
public class LocalRepoFindHandler {

	private Release release;

	/**
	 * Default constructor.
	 * 
	 * @param release release for which to find the local repository
	 */
	public LocalRepoFindHandler(Release release) {
		this.release = release;
	}

	/**
	 * Tries to find the local repository in the workspace. If it cannot be
	 * found there, then the user is asked to either clone the repository or
	 * specify its location.
	 * 
	 * @return the found repository
	 * @throws CancelledByUserException if the user decided to cancel the
	 *             operation
	 */
	public Repository find() throws CancelledByUserException {
		Stream stream = release.getStream();
		if (stream == null) {
			return null;
		}

		RepositoryStream repoStream = stream.getRepositoryStream();
		if (repoStream == null) {
			return null;
		}

		RepositoryLocation location = repoStream.getLocation();
		if (location == null) {
			return null;
		}
		if (!(location instanceof GitRepository)) {
			return null;
		}

		Repository repo = GitRepoFindUtil.findAssociatedLocalRepo((GitRepository) location);
		if (repo == null) {
			NoLocalRepoChoices userChoice = AdvancedMessageDialog.openNoLocalRepoFoundDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
			switch (userChoice) {
			case CANCEL:
				throw new CancelledByUserException();
			case CLONE:
				UIUtil.handleException(new Exception("Cloning is not yet supported"));
				// FIXME: Implement cloning
				return null;
			case OPEN:
				repo = chooseRepoLocation();
				if (repo == null) {
					throw new CancelledByUserException();
				}
			default:
				break;
			}
		}

		return repo;

	}

	/**
	 * Opens a file chooser where the user can choose the location of the local
	 * repository.
	 * 
	 * @return the selected repository or null if the user pressed cancel.
	 */
	private Repository chooseRepoLocation() {
		FileDialog fd = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.OPEN);
		fd.setText("Choose .git location");
		String[] filterExt = { ".git" };
		fd.setFilterExtensions(filterExt);

		String selected = fd.open();
		if (selected != null) {
			try {
				return new FileRepository(selected);
			} catch (IOException e) {
				ModelUtil.logException(e);
				return null;
			}
		} else {
			return null;
		}
	}
}
