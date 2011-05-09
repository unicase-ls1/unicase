package org.unicase.changetracking.git;

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
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.metamodel.Project;
import org.unicase.model.changetracking.git.GitPackage;
import org.unicase.model.changetracking.git.GitRepository;

/**
 * Class for finding all kinds of repos in different situations, like:
 * 
 * - Finding all local git repos in the workspace
 * - Finding the local repo in the workspace which matches a remote repo
 * - Finding the remote repo in a unicase project which matches a local repo
 * - Find the local repo that contains a specific file/folder
 * 
 * This class is a singleton which is contained in the Activator.
 * 
 * @author jfinis
 *
 */
public class GitRepoFindUtil {
	
	private GitRepoFindUtil(){}
	
	private static Repository findRepositoryHelper(File file){
		
		//This is no dir? Try parent instead!
		if(!file.isDirectory()){
			return findRepositoryHelper(file.getParentFile());
		}
		
		File gitFolder = new File(file,".git");
		
		if(gitFolder.exists()){
			if(!gitFolder.isDirectory()){
				throw new UnexpectedGitException("Found a .git file that is no directory: " + gitFolder.getAbsolutePath());
			}
		
			//We found the git directory! Retrieve from cache
			Repository repo = Activator.REPO_CACHE.getRepository(gitFolder);
			return repo;
		
		
		} else {
			File parent = file.getParentFile();
			if(parent == null){
				return null;
			} else {
				return findRepositoryHelper(parent);
			}
		}
		
		
	}
	
	public static Repository findRepository(File f){
		try {
			//If repo is in cache, retrieve it from there, otherwise try to find the git folder.
			File canonFile = f.getAbsoluteFile().getCanonicalFile();
			return findRepositoryHelper(canonFile);
		} catch (IOException e) {
			throw new UnexpectedGitException("Could not canonicalize file",e);
		}
	}
	
	public static GitRepository findRemoteInProject(Repository localRepo, Project project){
		List<GitRepository> l = project.getAllModelElementsbyClass(GitPackage.eINSTANCE.getGitRepository(), new BasicEList<GitRepository>());
		if(l.isEmpty()){
			return null;
		}
		return findCorrespondingRemoteRepository(localRepo, l);
	}
	
	public static boolean hasProjectRemote(Repository localRepo, Project project){
		return findRemoteInProject(localRepo, project) != null;
	}
	
	private static GitRepository findCorrespondingRemoteRepository(Repository repo, Collection<GitRepository> remotes){
		RevWalk revWalk = new RevWalk(repo);
		for(GitRepository remote: remotes){
			try {
				RevCommit c = revWalk.parseCommit(GitUtil.stringToObjectId(remote.getIdentifyingCommitHash()));
				if(c != null){
					return remote;
				}
			} catch (MissingObjectException e) {
			} catch (IncorrectObjectTypeException e) {
			} catch (IOException e) {
			}
			
		}
		return null;
	}
	
	
	private static MutableObjectId parseObjectId(GitRepository remoteRepo){
		if(!ObjectId.isId(remoteRepo.getIdentifyingCommitHash())){
			throw new UnexpectedGitException("The identifying hash of the remote repository is no valid SHA-1 hash representation.");
		}
		return GitUtil.stringToObjectId(remoteRepo.getIdentifyingCommitHash());
	}
	
	private static void checkAndAddDir(File directory, HashMap<String,File> list){
		File gitDir = new File(directory,".git");
		if(gitDir.exists() && gitDir.isDirectory()){
			list.put(gitDir.getAbsolutePath(),gitDir);
		}
	}
	
	public static Collection<File> findReposInWorkspace(){
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		HashMap<String, File> result = new HashMap<String,File>();
		IProject[] projects = root.getProjects();
		for(IProject p : projects){
			File projectFile = p.getLocation().toFile();
			checkAndAddDir(projectFile, result);
			checkAndAddDir(projectFile.getParentFile(), result);
		}
		return result.values();
		
	}

	public static Repository findAssociatedLocalRepo(GitRepository remoteRepo) {
		MutableObjectId identifyingHash = parseObjectId(remoteRepo);
		Collection<File> repos = findReposInWorkspace();
		for(File repoFile: repos){
			Repository repo = Activator.REPO_CACHE.getRepository(repoFile);
			RevWalk rw = new RevWalk(repo);
			try {
				RevCommit rc = rw.parseCommit(identifyingHash);
				if(rc != null){
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
}
