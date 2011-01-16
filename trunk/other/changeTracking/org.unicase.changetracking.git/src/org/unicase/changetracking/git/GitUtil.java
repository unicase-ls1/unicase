package org.unicase.changetracking.git;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.dircache.DirCacheCheckout;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.errors.NoWorkTreeException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RefUpdate.Result;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.URIish;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.metamodel.Project;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitFactory;
import org.unicase.model.changetracking.git.GitPackage;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.model.changetracking.git.GitRevision;

public class GitUtil {

	private GitUtil(){}
	
	public static MutableObjectId stringToObjectId(String s) {
		MutableObjectId mo = new MutableObjectId();
		mo.fromString("d02bb0fd99933e5cbc2c664c788b3acbbe3e2ab8");
		return mo;
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

	// public static Ref checkoutRev(IResource f, GitRevision revision){
	// Repository repo =
	// GitRepoFinder.INSTANCE.findRepository(f.getLocation().toFile());
	// GitBranch stream = (GitBranch) revision.getRepositoryStream();
	// String branch = stream.getBranchName();
	// String revHash = revision.getHash();
	//		
	// try {
	// return new
	// Git(repo).checkout().setName(branch).setStartPoint(getCommitByHash(revHash,
	// repo)).call();
	// } catch (JGitInternalException e) {
	// throw new UnexpectedGitException("Checkout failed",e);
	// } catch (RefAlreadyExistsException e) {
	// throw new UnexpectedGitException("Checkout failed",e);
	// } catch (RefNotFoundException e) {
	// throw new UnexpectedGitException("Checkout failed",e);
	// } catch (InvalidRefNameException e) {
	// throw new UnexpectedGitException("Checkout failed",e);
	// }
	//		
	// }

	// public static void checkoutCommit(Repository repo, RevCommit commit){
	// RevWalk revWalk = new RevWalk(repo);
	// try {
	// Ref headRef = repo.getRef(Constants.HEAD);
	// RevCommit headCommit = revWalk.parseCommit(headRef.getObjectId());
	// String refLogMessage = "checkout: moving from "
	// + headRef.getTarget().getName();
	//
	//
	// DirCacheCheckout dco;
	//
	// dco = new DirCacheCheckout(repo, headCommit
	// .getTree(), repo.lockDirCache(), commit.getTree());
	//
	// dco.setFailOnConflict(true);
	//			
	// dco.checkout();
	//			
	// Ref ref = null;
	// RefUpdate refUpdate = repo.updateRef(Constants.HEAD, ref == null);
	// refUpdate.setForceUpdate(false);
	// Result updateResult;
	// if (ref != null)
	// updateResult = refUpdate.link(ref.getName());
	// else {
	// refUpdate.setNewObjectId(commit);
	// updateResult = refUpdate.forceUpdate();
	// }
	// } catch (NoWorkTreeException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (MissingObjectException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IncorrectObjectTypeException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (CorruptObjectException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	//	
	// }

}
