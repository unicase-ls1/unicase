package org.unicase.changetracking.git.commands;

import org.eclipse.jgit.lib.Repository;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.commands.CheckReleaseCommand;
import org.unicase.changetracking.exceptions.CancelledByUserException;
import org.unicase.changetracking.git.release.ReleaseChecker;
import org.unicase.changetracking.git.ui.LocalRepoFindHandler;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.model.changetracking.ChangeTrackingRelease;

public class GitCheckReleaseCommand extends CheckReleaseCommand{

	
	private ChangeTrackingRelease release;

	public GitCheckReleaseCommand(ChangeTrackingRelease r) {
		this.release = r;
	}
	
	@Override
	protected ChangeTrackingCommandResult doRun() {
		
		//Find the corresponding local repository
		Repository localRepo;
		try {
			localRepo = new LocalRepoFindHandler(release).find();
		} catch (CancelledByUserException e) {
			return cancelResult();
		}
		
		//Ask the user to refresh his repo
		boolean upToDate = true;
		if(localRepo != null){
			upToDate = UIUtil.askForRefreshing();
		}
		
		//Create a report
		setReport(ReleaseChecker.check(localRepo, release, upToDate));
		return successResult(null);
	}

}
