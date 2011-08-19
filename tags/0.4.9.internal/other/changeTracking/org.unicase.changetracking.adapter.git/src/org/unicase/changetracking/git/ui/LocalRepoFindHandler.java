/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.ui;

import java.io.File;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.commands.ChangeTrackingCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.exceptions.CancelledByUserException;
import org.unicase.changetracking.exceptions.MisuseException;
import org.unicase.changetracking.git.Activator;
import org.unicase.changetracking.git.common.GitCloneOperation;
import org.unicase.changetracking.git.common.GitRepoFindUtil;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.changetracking.ui.UIUtil.RunnableWithResult;
import org.unicase.changetracking.ui.dialogs.AdvancedMessageDialog;
import org.unicase.changetracking.ui.dialogs.AdvancedMessageDialog.NoLocalRepoChoices;
import org.unicase.model.changetracking.Release;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.changetracking.Stream;
import org.unicase.model.changetracking.git.GitBranch;
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

		final RepositoryStream repoStream = stream.getRepositoryStream();
		if (repoStream == null) {
			return null;
		}
		if (!(repoStream instanceof GitBranch)) {
			return null;
		}

		final RepositoryLocation location = repoStream.getLocation();
		if (location == null) {
			return null;
		}
		if (!(location instanceof GitRepository)) {
			return null;
		}

		Repository repo = GitRepoFindUtil.findAssociatedLocalRepo((GitRepository) location);

		//If no repo is found, ask the user what to do.
		//Since this includes user interaction, it must be done in
		//the UI thread.
		if (repo == null) {
			// BEGIN COMPLEX CODE
			repo = UIUtil.runSyncInUI(new RunnableWithResult<Repository>() {
				// END COMPLEX CODE

				public Repository run() {
					//Ask the user what to do
					NoLocalRepoChoices userChoice = AdvancedMessageDialog.openNoLocalRepoFoundDialog(UIUtil.getActiveShell());
					
					//Process user choice
					switch (userChoice) {
					case CANCEL:
						throw new CancelledByUserException();
					case CLONE:
						//Choose target directory for cloning
						final File workdir = openFileChooser("Choose a directory to clone into", "Choose the working directory into which the remote repository will be cloned.", null);
						if(workdir == null){
							throw new CancelledByUserException();
						}

						//Execute the clone as change tracking command to get progress monitor and
						//exception handling support.
						ChangeTrackingCommandResult result = UIUtil.runCommand(new ChangeTrackingCommand() {
							@Override
							protected ChangeTrackingCommandResult doRun() {
								new GitCloneOperation((GitRepository) location, workdir, (GitBranch) repoStream, 60000).run(null);
								return successResult("Cloning completed successfully");
							}
						});

						//If cloning did not succeed, we cannot go on
						result.throwExceptionIfNotSuccessful();

						//Return the freshly cloned repository
						return Activator.REPO_CACHE.getRepository(new File(workdir, ".git"));
					case OPEN:
						Repository repo = chooseRepoLocation();
						if (repo == null) {
							throw new CancelledByUserException();
						}
						return repo;
					default:
						return null; // unreachable
					}
				}
			});
			
			//If the user has chosen a repo, we have to check if he has
			//really chosen a corresponding one.
			if(!GitRepoFindUtil.checkIfRepoCorrespondsToLocation(repo,(GitRepository)location)){
				throw new MisuseException("The repository you have selected does not correspond to the repository location of the release.");
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
		File selected = openFileChooser("Choose .git location", "Choose the .git directory of the local repository you want to use for release building.", new String[] { ".git" });

		if (selected != null) {
			//has the user selected a .git directory?
			if(selected.getName().equals(".git")){
				return Activator.REPO_CACHE.getRepository(selected);
			} else{
				//No! But maybe a working directory?
				File gitDir = new File(selected,".git");
				if(gitDir.exists()){
					return Activator.REPO_CACHE.getRepository(gitDir);
				} else {
					//User has neither selected a .git dir, nor a working
					//directory. Try again...
					UIUtil.errorMessage("Wrong directory","The directory you have chosen is neither a .git directory nor a working directory.");
					return chooseRepoLocation();
				}
			}
		} else {
			return null;
		}
	}

	private File openFileChooser(String text, String message, String[] filterExt) {
		DirectoryDialog fd = new DirectoryDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.OPEN);
		fd.setText(text);
		fd.setMessage(message);
		
		String selected = fd.open();
		if (selected == null) {
			return null;
		}
		return new File(selected);
	}
}
