package org.unicase.changetracking.vcs;

import org.eclipse.core.resources.IProject;
import org.unicase.changetracking.commands.BuildReleaseCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommand;
import org.unicase.changetracking.commands.CheckReleaseCommand;
import org.unicase.changetracking.commands.CreateStreamCommand;
import org.unicase.changetracking.common.IDecisionProvider;
import org.unicase.changetracking.exceptions.CancelledByUserException;
import org.unicase.changetracking.exceptions.NotSupportedByAdapterException;
import org.unicase.changetracking.exceptions.VCSException;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.metamodel.Project;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.task.WorkItem;

public interface VCSAdapter {
	
	NameValidator getNameValidator();
	
	RepositoryLocation findRepoLocation(IProject workspaceProject, Project unicaseProject) throws VCSException;
	
	RepositoryLocation createRepositoryLocation(IProject workspaceProject) throws VCSException, CancelledByUserException;
	
	ChangeTrackingCommand createChangePackage(IProject localProject, WorkItem workItem, RepositoryLocation remoteRepo, String name, String shortDescription, String longDescription);

	CheckReleaseCommand checkRelease(IDecisionProvider decisionProvider, ChangeTrackingRelease release);
	
	BuildReleaseCommand buildRelease(ChangeTrackingRelease release, String tagName, ReleaseCheckReport checkReport);
	
	CreateStreamCommand createStreamFromCurrentBranch(IDecisionProvider decisionProvider, IProject workspaceProject);

	String performEarlyCreateChangePackageChecks(IProject localProject) throws VCSException;

	/**
	 * Creates and sets up a repository stream by examining a local project
	 * and using its current stream as stream. For a git project for example,
	 * the currently checked out branch will be taken to create the repository stream.
	 * The stream also gets linked to the repository location.
	 * 
	 * @param localProject
	 * @param repoLocation
	 * @return fully set-up repository stream matching the local project.
	 * @throws NotSupportedByAdapterException 
	 */
	RepositoryStream createRepositoryStream(IProject localProject, RepositoryLocation repoLocation) throws NotSupportedByAdapterException;

	ChangeTrackingCommand applyChangePackage(ChangePackage changePackage);

	boolean doesChangePackageNeedRepoLocation();
	
}
