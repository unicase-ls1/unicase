package org.unicase.changetracking.git.commands;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egit.core.EclipseGitProgressTransformer;
import org.eclipse.egit.core.securestorage.EGitSecureStore;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jgit.api.CheckoutCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.errors.AmbiguousObjectException;
import org.eclipse.jgit.errors.UnmergedPathException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.RefSpec;
import org.unicase.changetracking.git.Activator;
import org.unicase.changetracking.git.GitPushBuilder;
import org.unicase.changetracking.git.GitPushOperation;
import org.unicase.changetracking.git.GitRepoFindUtil;
import org.unicase.changetracking.git.GitWrapper;
import org.unicase.changetracking.git.Test;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.changetracking.ChangetrackingFactory;
import org.unicase.model.changetracking.Stream;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitBranchChangePackage;
import org.unicase.model.changetracking.git.GitFactory;
import org.unicase.model.changetracking.git.GitPackage;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.model.task.WorkItem;
import org.unicase.workspace.util.UnicaseCommand;

public class GitCreateChangePackageCommand extends UnicaseProgressMonitorCommand {

	
	private final Repository myRepository;
	private final String myName;
	private final WorkItem myWorkItem;
	private final GitRepository myRemoteRepo;
	private String myShortDescription;
	private String myLongDescription;
	private CredentialsProvider myCredentials;

	public GitCreateChangePackageCommand(Repository r, WorkItem workItem, GitRepository remoteRepo, String name, String shortDescription, String longDescription, CredentialsProvider credentials){
		this.myRepository = r;
		this.myName = name;
		this.myShortDescription = shortDescription;
		this.myLongDescription = longDescription;
		this.myWorkItem = workItem;
		this.myRemoteRepo = remoteRepo;
		this.myCredentials = credentials;
	}
	@Override
	protected void doRun() {
		createChangePackage(myRepository, myWorkItem,myRemoteRepo, myName, myShortDescription, myLongDescription, myCredentials);
	}
	
	/*
	 * Usecase 1: The user creates a new change package
	 */
	public void createChangePackage(Repository repo, WorkItem workItem, GitRepository remoteRepo, String name, String shortDescription, String longDescription, CredentialsProvider credentials){
		//Init progress Monitor 
		IProgressMonitor progressMonitor = getProgressMonitor();
		progressMonitor.beginTask("Creating Change Package", 6);
		progressMonitor.subTask("Checking requirements");
		GitWrapper git = new GitWrapper(repo);
	
		try{
		
		
		//Check repository state
		if(!repo.getRepositoryState().canCommit()){
			throw new UnexpectedGitException("The local repository is in a state which does not allow committing");
		}
		
		
		//Retrieve project
		Project p = ModelUtil.getProject(workItem);
		if(p == null){
			throw new UnexpectedGitException("The supplied work item does not belong to a project");
		}
		
		//check that no branch with that name already exists
		try {
			ObjectId objId = repo.resolve(name);
			if(objId != null){
				throw new UnexpectedGitException("A branch named'" + name + "' already exists");
			}
		} catch (AmbiguousObjectException e1) {
			throw new UnexpectedGitException(e1);
		} catch (IOException e1) {
			throw new UnexpectedGitException(e1);
		}
		
		//Create and checkout a new branch
		git.checkout(name, true);
		progressMonitor.worked(1);
		progressMonitor.subTask("Creating and linking model elements");
				
		//Create and attach git branch
		GitBranch branch = GitFactory.eINSTANCE.createGitBranch();
		branch.setBranchName(name);
		branch.setName(name);
		branch.setLocation(remoteRepo);
		addToProjectRelative(branch, p, workItem);
		
		//Create Change Package model element
		GitBranchChangePackage changePackage = GitFactory.eINSTANCE.createGitBranchChangePackage();
		changePackage.setName(name);
		changePackage.setDescription(longDescription);
		changePackage.setShortDescription(shortDescription);
		changePackage.setBranch(branch);
		addToProjectRelative(changePackage, p, branch);
		
		//Attach change package to work item
		workItem.getAttachments().add(changePackage);
		
		
		//Adding all files
		progressMonitor.worked(1);
		progressMonitor.subTask("Adding...");
		
		git.addAllFiles();
		
		progressMonitor.worked(1);
		progressMonitor.subTask("Committing...");
		
		//Commit changes
		git.commit(shortDescription, longDescription);
		
		progressMonitor.worked(1);
		progressMonitor.subTask("Pushing new branch to remote repository...");
	
		//Push to remote repo
		//GitPushOperation pushOp = new GitPushBuilder(repo, remoteRepo, credentials).build(name);
		//pushOp.run(progressMonitor);

		//Test.gitPushTest();
		} finally {
			progressMonitor.done();
		}
		
		
//		//FIXME make push work
//		//Push the git branch
//		try {
//			git.push().setRefSpecs(new RefSpec("refs/head/" + name)).setRemote("https://gexicide@github.com/gexicide/testor.git").call();
//		} catch (JGitInternalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidRemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	/**
	 * Adds a model element to a project, relative to a work item in that project.
	 * @param toAdd element to be added.
	 * @param project project to add the model element to.
	 * @param workItem starting point for the relative placement of the object to be added
	 */
	private void addToProjectRelative(EObject toAdd, Project project,
			EObject workItem) {
		//TODO: Implement relative placement
		project.addModelElement(toAdd);
	}
	


}
