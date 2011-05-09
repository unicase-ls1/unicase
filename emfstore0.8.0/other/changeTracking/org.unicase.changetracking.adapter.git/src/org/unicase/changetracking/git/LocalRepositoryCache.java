package org.unicase.changetracking.git;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepository;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;

public class LocalRepositoryCache {

	
	private HashMap<String, Repository> cachedRepositories = new HashMap<String, Repository>();
	
	LocalRepositoryCache() {
	}
	private String getCanonicalPath(File f){
		String path;
		try {
			path = f.getCanonicalPath();
		} catch (IOException e) {
			path = f.getAbsolutePath();
		}
		return path;
	}
	public Repository getRepository(File gitDir){
		String path = getCanonicalPath(gitDir);
		
		if(cachedRepositories.containsKey(path)){
			return cachedRepositories.get(path);
		}
		FileRepository repo;
		try {
			repo = new FileRepository(gitDir);
		} catch (IOException e) {
			throw new UnexpectedGitException("Could not create git repository from file '" + path + "' due to an IOException",e);
		}
		cachedRepositories.put(path, repo);
		return repo;
	}

	public boolean hasRepository(File gitDir) {
		String path = getCanonicalPath(gitDir);
		return cachedRepositories.containsKey(path);
	}
	
	
}
