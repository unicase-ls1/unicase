/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepository;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;

/**
 * Cache for local repositories.
 * 
 * Maintained for speed reason since the re-creation of a repository takes much
 * time.
 * 
 * The cache is a singleton. The instance is stored in the activator.
 * 
 * @author jfinis
 * 
 */
public class LocalRepositoryCache {

	/**
	 * Mapping from canonical absolute path to repository.
	 */
	private HashMap<String, Repository> cachedRepositories = new HashMap<String, Repository>();

	/**
	 * Default constructor.
	 */
	LocalRepositoryCache() {}

	/**
	 * retrieves the canonical path of a file.
	 * 
	 * @param f a file
	 * @return canonical path
	 */
	private String getCanonicalPath(File f) {
		String path;
		try {
			path = f.getCanonicalPath();
		} catch (IOException e) {
			path = f.getAbsolutePath();
		}
		return path;
	}

	/**
	 * Returns the repository corresponding to a '.git' directory which contains
	 * a repository. If the input file is no such .git directory, an
	 * UnexpectedGitException is thrown.
	 * 
	 * @param gitDir .git repository directory
	 * @return corresponding repository
	 */
	public Repository getRepository(File gitDir) {
		String path = getCanonicalPath(gitDir);

		if (cachedRepositories.containsKey(path)) {
			return cachedRepositories.get(path);
		}
		FileRepository repo;
		try {
			repo = new FileRepository(gitDir);
		} catch (IOException e) {
			throw new UnexpectedGitException("Could not create git repository from file '" + path + "' due to an IOException", e);
		}
		cachedRepositories.put(path, repo);
		return repo;
	}

	/**
	 * Whether the cache contains an entry for a specific .git directory.
	 * 
	 * @param gitDir .git directory
	 * @return whether the cache contains an entry for that directory
	 */
	public boolean hasRepository(File gitDir) {
		String path = getCanonicalPath(gitDir);
		return cachedRepositories.containsKey(path);
	}

}
