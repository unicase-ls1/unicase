package org.unicase.changetracking.git;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jws.WebParam.Mode;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.egit.core.IteratorService;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
import org.eclipse.jgit.lib.IndexDiff;
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
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitFactory;
import org.unicase.model.changetracking.git.GitPackage;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.model.changetracking.git.GitRevision;
import org.unicase.util.UnicaseUtil;

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
	
	public static void addToProjectRelative(UnicaseModelElement toAdd, Project project, UnicaseModelElement relativeTo){
		placeRelative(toAdd,relativeTo);
	}

	public static void addToProjectRelative(UnicaseModelElement toAdd, UnicaseModelElement relativeTo) {
		if(!placeRelative(toAdd,relativeTo)){
			Project p = ModelUtil.getProject(relativeTo);
			if(p != null){
				p.addModelElement(toAdd);
			}
		}
		
	}
	
	
	/**
	 * @param newMEInstance {@link EObject} the new modelElement instance.
	 * @return EReference the Container
	 * @param parent The EObject to get containment references from
	 */
	public static EReference getPossibleContainingReference(final EObject newMEInstance, EObject parent) {
		// the value of the 'EAll Containments' reference list.
		List<EReference> eallcontainments = parent.eClass().getEAllContainments();
		EReference reference = null;
		for (EReference containmentitem : eallcontainments) {

			EClass eReferenceType = containmentitem.getEReferenceType();
			if (eReferenceType.isInstance(newMEInstance)) {
				reference = containmentitem;
				break;
			}
		}
		return reference;
	}
	
	private static boolean placeRelative(final EObject newMEInstance, EObject parent){
		EReference ref = getPossibleContainingReference(newMEInstance, parent);
		if(ref != null){
			Object r = parent.eGet(ref);
			if(ref.isMany()){
				((EList)r).add(newMEInstance);
				return true;
			}
			return false;
		} else if(parent.eContainer() != null){
			return placeRelative(newMEInstance,parent.eContainer());
		} else {
			return false;
		}
		
	}
	
	public static boolean putInto(final EObject newMEInstance, EObject parent){
		EReference ref = getPossibleContainingReference(newMEInstance, parent);
		if(ref != null){
			Object r = parent.eGet(ref);
			if(ref.isMany()){
				((EList)r).add(newMEInstance);
				return true;
			}
			return false;
		} else {
			return false;
		}
		
	}

	

}
