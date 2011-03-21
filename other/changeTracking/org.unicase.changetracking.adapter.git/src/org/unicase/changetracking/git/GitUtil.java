package org.unicase.changetracking.git;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.egit.core.IteratorService;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.IndexDiff;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.URIish;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitFactory;
import org.unicase.model.changetracking.git.GitRepository;

public final class GitUtil {

	private GitUtil(){}
	
	public static MutableObjectId stringToObjectId(String s) {
		MutableObjectId mo = new MutableObjectId();
		mo.fromString(s);
		return mo;
	}
	
	public static RefSpec getRefSpecFromGitBranch(GitBranch branch){
		return new RefSpec(Constants.R_HEADS + branch.getBranchName());
	}
	
	public static RevCommit getCommitByHash(String hash, Repository repo) {
		MutableObjectId objId = stringToObjectId(hash);
		RevWalk r = new RevWalk(repo);
		try {
			RevCommit c = r.parseCommit(objId);
			return c;
		} catch (MissingObjectException e) {
			throw new UnexpectedGitException(
					"Could not obtain a commit from a repository", e);
		} catch (IncorrectObjectTypeException e) {
			throw new UnexpectedGitException(
					"Could not obtain a commit from a repository", e);
		} catch (IOException e) {
			throw new UnexpectedGitException(
					"Could not obtain a commit from a repository", e);
		}

	}
	
	/**
	 * Checks whether there are no changes in the working directory
	 * and the index. This method is computationally intensive as it
	 * checks the whole repository. Cache the result rather than calling
	 * it more than once.
	 * 
	 * @param repository local repository to check
	 * @return true iff no changes exist in the index and the working directory
	 */
	public static boolean isIndexAndWorkDirClean(Repository repository){
		IndexDiff indexDiff;
		try {
			indexDiff = new IndexDiff(repository, Constants.HEAD,
					IteratorService.createInitialIterator(repository));
			indexDiff.diff();
		} catch (IOException e) {
			throw new UnexpectedGitException(
					"IO Exception while examining local repository", e);
		}
		
		return indexDiff.getAdded().isEmpty()
			&& indexDiff.getChanged().isEmpty()
			&& indexDiff.getMissing().isEmpty()
			&& indexDiff.getModified().isEmpty()
			&& indexDiff.getRemoved().isEmpty()
			&& indexDiff.getUntracked().isEmpty();
	}
	
	public static List<String> getModifications(Repository repository){
		IndexDiff indexDiff;
		try {
			indexDiff = new IndexDiff(repository, Constants.HEAD,
					IteratorService.createInitialIterator(repository));
			indexDiff.diff();
		} catch (IOException e) {
			throw new UnexpectedGitException(
					"IO Exception while examining local repository", e);
		}
		List<String> result = new ArrayList<String>();
		result.addAll(indexDiff.getAdded());
		result.addAll(indexDiff.getChanged());
		result.addAll(indexDiff.getModified());
		result.addAll(indexDiff.getRemoved());
		result.addAll(indexDiff.getUntracked());
		return result;
	}
	
	public static String getModificationsAsString(Repository repository, int max){
		List<String> mods = getModifications(repository);
		StringBuilder result = new StringBuilder();
		int count = 0;
		for(Iterator<String> it = mods.iterator();it.hasNext();){
			String s = it.next();
			result.append(s);
			if(it.hasNext()){
				result.append("\n");
			}
			if(++count >= max){
				result.append("... (" + (mods.size()-max) + " more)");
				break;
			}
		}
		return result.toString();
	}
	
	public static Iterable<RevCommit> getAllCommits(Repository repository) {
		try {
			RevWalk rw = new RevWalk(repository);
			for (Ref ref : repository.getAllRefs().values()) {
				try {
					rw.markStart(rw.parseCommit(ref.getObjectId()));
				} catch (IncorrectObjectTypeException notACommit) {
					continue;
				}
			}
			return rw;

		} catch (MissingObjectException e) {
			throw new UnexpectedGitException(e);
		} catch (IOException e) {
			throw new UnexpectedGitException(e);
		}
	}

	public static String getIdentifyingCommitHash(Repository repository) {
		RevCommit lastCommit = null;
		for (RevCommit c : getAllCommits(repository)) {
			lastCommit = c;
		}
		
		if(lastCommit == null)
			return null;
		
		return lastCommit.getId().getName();
	}
	
	public static GitRepository initGitRepoModelFromRepo(Repository repo){
		GitRepository gitRepoModel = GitFactory.eINSTANCE.createGitRepository();
		gitRepoModel.setIdentifyingCommitHash(getIdentifyingCommitHash(repo));
		return gitRepoModel;
	}
	
	public static URIish getUriFromRemote(GitRepository remote) throws URISyntaxException{
		return new URIish(remote.getUrl());
	}

	


	

}
