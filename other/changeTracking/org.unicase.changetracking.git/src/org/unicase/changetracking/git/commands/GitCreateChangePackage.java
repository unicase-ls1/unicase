package org.unicase.changetracking.git.commands;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jgit.api.CheckoutCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.errors.AmbiguousObjectException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.RefSpec;
import org.unicase.changetracking.git.Activator;
import org.unicase.changetracking.git.GitRepoFindUtil;
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

public class GitCreateChangePackage extends UnicaseCommand {

	
	private final IResource myResource;
	private final String myName;
	private final WorkItem myWorkItem;
	private final GitRepository myRemoteRepo;

	public GitCreateChangePackage(IResource r, String name, WorkItem workItem, GitRepository remoteRepo){
		this.myResource = r;
		this.myName = name;
		this.myWorkItem = workItem;
		this.myRemoteRepo = remoteRepo;
	}
	@Override
	protected void doRun() {
		createChangePackage(myResource, myName, myWorkItem,myRemoteRepo);
	}
	
	/*
	 * Usecase 1: The user creates a new change package
	 */
	public void createChangePackage(IResource r, String name, WorkItem workItem, GitRepository remoteRepo){
		//Find a git repo
		Repository repo = GitRepoFindUtil.findRepository(r.getLocation().toFile());
		Git git = new Git(repo);
		
		if(repo == null){
			throw new UnexpectedGitException("The selected resource is not in any git repository");
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
		CheckoutCommand command = git.checkout().setName(name).setCreateBranch(true);
		try {
			command.call();
		} catch (JGitInternalException e) {
			throw new UnexpectedGitException("Could not create new branch",e);
		} catch (RefAlreadyExistsException e) {
			throw new UnexpectedGitException("Could not create new branch",e);
		} catch (RefNotFoundException e) {
			throw new UnexpectedGitException("Could not create new branch",e);
		} catch (InvalidRefNameException e) {
			throw new UnexpectedGitException("Could not create new branch",e);
		}
		

		
		
		//Create and attach git branch
		GitBranch branch = GitFactory.eINSTANCE.createGitBranch();
		branch.setBranchName(name);
		branch.setName(name);
		branch.setLocation(remoteRepo);
		addToProjectRelative(branch, p, workItem);
		
		//Create Change Package model element
		GitBranchChangePackage changePackage = GitFactory.eINSTANCE.createGitBranchChangePackage();
		changePackage.setName(name);
		changePackage.setBranch(branch);
		addToProjectRelative(changePackage, p, branch);
		
		//Attach change package to work item
		workItem.getAttachments().add(changePackage);
		
		//FIXME make push work
		//Push the git branch
		try {
			git.push().setRefSpecs(new RefSpec("refs/head/" + name)).setRemote("https://gexicide@github.com/gexicide/testor.git").call();
		} catch (JGitInternalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidRemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
