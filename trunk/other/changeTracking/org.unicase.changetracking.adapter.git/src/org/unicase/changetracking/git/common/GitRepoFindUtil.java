/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.common;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.unicase.changetracking.exceptions.VCSException;
import org.unicase.changetracking.git.Activator;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.metamodel.Project;
import org.unicase.model.changetracking.git.GitPackage;
import org.unicase.model.changetracking.git.GitRepository;

/**
 * Utility class for finding git repositories. Can be used to retrieve local
 * repositories or repository locations in different situations, like:
 * 
 * - Finding all local git repos in the workspace - Finding the local repo in
 * the workspace which matches a Git repo location - Finding the Git repo
 * location in a unicase project which matches a local repo - Find the local
 * repo that contains a specific file/folder
 * 
 * @author jfinis
 * 
 */
public final class GitRepoFindUtil {

	/**
	 * Util class.
	 */
	private GitRepoFindUtil() {}

	/**
	 * Helper method which walks the directory hierarchy upwards, looking for a
	 * .git folder. Returns the repository contained in that .git folder.
	 * 
	 * @param file start of the search
	 * @return git repository in the hierarchy of the start file or null if no
	 *         such repository exists.
	 */
	private static Repository findRepositoryHelper(File file) {

		// This is no dir? Try parent instead!
		if (!file.isDirectory()) {
			return findRepositoryHelper(file.getParentFile());
		}

		File gitFolder = new File(file, ".git");

		if (gitFolder.exists()) {
			if (!gitFolder.isDirectory()) {
				throw new UnexpectedGitException("Found a .git file that is no directory: " + gitFolder.getAbsolutePath());
			}

			// We found the git directory! Retrieve from cache
			Repository repo = Activator.REPO_CACHE.getRepository(gitFolder);
			return repo;

		} else {
			File parent = file.getParentFile();
			if (parent == null) {
				return null;
			} else {
				return findRepositoryHelper(parent);
			}
		}

	}

	/**
	 * Finds the repository associated to a specific file. This means that the
	 * directory hierarchy is searched upwards until a .git directory is found.
	 * If no such directory is found in the hierarchy, then the file is not
	 * under Git version control and null is returned.
	 * 
	 * @param f file which is under Git version control
	 * @return the correspondent Git repo or null if file is not under Git
	 *         version control
	 */
	public static Repository findRepository(File f) {
		try {
			// If repo is in cache, retrieve it from there, otherwise try to
			// find the git folder.
			File canonFile = f.getAbsoluteFile().getCanonicalFile();
			return findRepositoryHelper(canonFile);
		} catch (IOException e) {
			throw new UnexpectedGitException("Could not canonicalize file", e);
		}
	}

	/**
	 * Finds a repository location, which is correspondent to a local
	 * repository, in a unicase project. This is done by retrieving all Git
	 * repository locations from the unicase project and then checking which of
	 * them is correspondent.
	 * 
	 * Note that this method assumes that only one repository location in the
	 * project corresponds to the local repository. If this is not true, the
	 * method will return only one of the correspondent repositories. Which one
	 * is undefined.
	 * 
	 * If no correspondent repository location is contained in the unicase
	 * project, then null is returned.
	 * 
	 * @param localRepo local git repository
	 * @param project unicase project
	 * @return the repo location in the unicase project which corresponds to the
	 *         local repository, or null if no such location exists.
	 */
	public static GitRepository findRepoLocationInProject(Repository localRepo, Project project) {
		List<GitRepository> l = project.getAllModelElementsbyClass(GitPackage.eINSTANCE.getGitRepository(), new BasicEList<GitRepository>());
		if (l.isEmpty()) {
			return null;
		}
		return findCorrespondingRepoLocation(localRepo, l);
	}

	/**
	 * Checks if a unicase project contains a repo location matching a local
	 * repository.
	 * 
	 * @param localRepo local git repository
	 * @param project unicase project
	 * @return whether a repo location correspondent to the local repository
	 *         exists in the unicase project.
	 */
	public static boolean hasProjectRepoLocation(Repository localRepo, Project project) {
		return findRepoLocationInProject(localRepo, project) != null;
	}

	/**
	 * Finds a Git repository location correspondent to a local repository. The
	 * set of remote repositories to be searched is taken as parameter. It is
	 * assumed that only ONE of the repositories in the is correspondent to the
	 * local repository. Therefore, the search is aborted after the first
	 * correspondent repository is found.
	 * 
	 * @param repo local repository
	 * @param remotes list of remote repositories
	 * @return the repository which is correspondent to the local one or null,
	 *         if none of the remote repositories is correspondent to the local
	 *         one.
	 */
	private static GitRepository findCorrespondingRepoLocation(Repository repo, Collection<GitRepository> remotes) {
		RevWalk revWalk = new RevWalk(repo);
		for (GitRepository remote : remotes) {
			try {
				RevCommit c = revWalk.parseCommit(GitUtil.stringToObjectId(remote.getIdentifyingCommitHash()));
				if (c != null) {
					return remote;
				}
			} catch (MissingObjectException e) {} catch (IncorrectObjectTypeException e) {} catch (IOException e) {}

		}
		return null;
	}

	private static MutableObjectId parseObjectId(GitRepository remoteRepo) {
		if (!ObjectId.isId(remoteRepo.getIdentifyingCommitHash())) {
			throw new UnexpectedGitException("The identifying hash of the remote repository is no valid SHA-1 hash representation.");
		}
		return GitUtil.stringToObjectId(remoteRepo.getIdentifyingCommitHash());
	}

	private static void checkAndAddDir(File directory, HashMap<String, File> list) {
		File gitDir = new File(directory, ".git");
		if (gitDir.exists() && gitDir.isDirectory()) {
			list.put(gitDir.getAbsolutePath(), gitDir);
		}
	}

	/**
	 * Finds all git repository directories (.git dirs) in the workspace.
	 * Returns them as a collection of files.
	 * 
	 * @return all .git directories in the workspace
	 */
	public static Collection<File> findReposInWorkspace() {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		HashMap<String, File> result = new HashMap<String, File>();
		IProject[] projects = root.getProjects();
		for (IProject p : projects) {
			File projectFile = p.getLocation().toFile();
			checkAndAddDir(projectFile, result);
			checkAndAddDir(projectFile.getParentFile(), result);
		}
		return result.values();

	}

	/**
	 * Finds a local repository residing in the workspace and being
	 * correspondent to a repository location. Returns null if no such local
	 * repository exists in the workspace
	 * 
	 * @param remoteRepo repository location
	 * @return local repository in the workspace correspondent to the location
	 *         or null if no such repository exists in the workspace
	 */
	public static Repository findAssociatedLocalRepo(GitRepository remoteRepo) {
		MutableObjectId identifyingHash = parseObjectId(remoteRepo);
		Collection<File> repos = findReposInWorkspace();
		for (File repoFile : repos) {
			Repository repo = Activator.REPO_CACHE.getRepository(repoFile);
			RevWalk rw = new RevWalk(repo);
			try {
				RevCommit rc = rw.parseCommit(identifyingHash);
				if (rc != null) {
					return repo;
				}
			} catch (MissingObjectException e) {
				continue;
			} catch (IncorrectObjectTypeException e) {
				throw new UnexpectedGitException(e);
			} catch (IOException e) {
				throw new UnexpectedGitException(e);
			}
		}
		return null;

	}
	

	/**
	 * For a set of workspace projects, this method finds the Git repository under
	 * which all these projects are versioned. If one of the projects is not
	 * versioned with Git, or any two projects are versioned with different repositories,
	 * then a {@link VCSException} is thrown.
	 * @param projects set of workspace projects.
	 * @return the Git repo with which the projects are versioned
	 * @throws VCSException if a project is not under git version control or the repositories differ between projects
	 */
	public static Repository findRepoForProjects(IProject... projects) throws VCSException {
		Repository repo = null;
		if(projects.length == 0){
			throw new VCSException("Cannot find a repo for an empty set of projects");
		}
		for(IProject p : projects){
			Repository curRepo = GitRepoFindUtil.findRepository(p.getLocation().toFile());
			
			//Not under version control? Error!
			if (curRepo == null) {
				throw new VCSException("The project '" + p.getName() + "' is not under Git version control.");
			}
			
			//Different repo than the other ones? Error!
			if(repo != null && curRepo != repo){
				throw new VCSException("The selected projects use different Git repositories. All projects must use the same repository in order to be processed together.");
			}
		
			repo = curRepo;
		}
		return repo;
	}
}
