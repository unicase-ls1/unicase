package org.unicase.changetracking.vcs;

import org.eclipse.core.resources.IProject;
import org.unicase.changetracking.commands.BuildReleaseCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.commands.CheckReleaseCommand;
import org.unicase.changetracking.commands.CreateStreamCommand;
import org.unicase.changetracking.commands.CreateStreamFromCurrentBranchCommand;
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

public abstract class BasicVCSAdapter implements VCSAdapter{

	@Override
	public CreateStreamCommand createStreamFromCurrentBranch(
			IDecisionProvider decisionProvider, IProject workspaceProject) {
		return new CreateStreamFromCurrentBranchCommand(this, decisionProvider, workspaceProject);
	}
	
	private RuntimeException notSupported(String s){
		return new RuntimeException(new NotSupportedByAdapterException(s));
	}
	
	private ChangeTrackingCommand notSupportedCommand(final String s){
		return new ChangeTrackingCommand() {
			
			@Override
			protected ChangeTrackingCommandResult doRun() {
				throw notSupported(s);
			}
		};
	}
	
	@Override
	public ChangeTrackingCommand applyChangePackage(ChangePackage changePackage) {
		return notSupportedCommand("change package application");
	}
	
	@Override
	public BuildReleaseCommand buildRelease(ChangeTrackingRelease release,
			String tagName, ReleaseCheckReport checkReport) {
		return new BuildReleaseCommand() {
			
			@Override
			protected ChangeTrackingCommandResult doRun() {
				throw notSupported("release building");
			}
			
			@Override
			public boolean hadConflicts() {
				return false;
			}
		};
	}
	
	@Override
	public CheckReleaseCommand checkRelease(IDecisionProvider decisionProvider,
			ChangeTrackingRelease release) {
		return new CheckReleaseCommand() {
			
			@Override
			protected ChangeTrackingCommandResult doRun() {
				throw notSupported("release checking");
			}
		};
	}
	
	@Override
	public ChangeTrackingCommand createChangePackage(IProject localProject,
			WorkItem workItem, RepositoryLocation remoteRepo, String name,
			String shortDescription, String longDescription) {
		return notSupportedCommand("change package creation");
	}
	
	@Override
	public RepositoryLocation createRepositoryLocation(IProject workspaceProject)
			throws VCSException, CancelledByUserException {
		throw new NotSupportedByAdapterException("repository location creation");
	}
	
	@Override
	public RepositoryStream createRepositoryStream(IProject localProject,
			RepositoryLocation repoLocation) throws NotSupportedByAdapterException {
		throw new NotSupportedByAdapterException("repository stream creation");
	}
	
	@Override
	public RepositoryLocation findRepoLocation(IProject workspaceProject,
			Project unicaseProject) throws VCSException {
		throw new NotSupportedByAdapterException("repository location retrieval");
	}
	
	@Override
	public NameValidator getNameValidator() {
		return new NameValidator() {
			
			@Override
			public String isNewTagNameValid(String text, RepositoryLocation repoLoc) {
				return null;
			}
			
			@Override
			public String cleanName(String name) {
				return name;
			}
		};
	}
	
	@Override
	public String performEarlyCreateChangePackageChecks(IProject localProject)
			throws VCSException {
		return null;
	}
	
	
}
