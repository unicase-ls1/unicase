package org.unicase.changetracking.git.commands;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jgit.errors.AmbiguousObjectException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.unicase.changetracking.git.GitUtil;
import org.unicase.changetracking.git.GitWrapper;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitBranchChangePackage;
import org.unicase.model.changetracking.git.GitFactory;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.model.task.WorkItem;

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
		GitUtil.addToProjectRelative(branch, workItem);
		
		//Create Change Package model element
		GitBranchChangePackage changePackage = GitFactory.eINSTANCE.createGitBranchChangePackage();
		changePackage.setName(name);
		changePackage.setDescription(longDescription);
		changePackage.setShortDescription(shortDescription);
		changePackage.setBranch(branch);
		GitUtil.addToProjectRelative(changePackage, branch);
		
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

	


}
