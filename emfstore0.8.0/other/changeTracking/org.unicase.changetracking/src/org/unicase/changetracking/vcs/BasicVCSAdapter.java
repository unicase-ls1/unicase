package org.unicase.changetracking.vcs;

import org.eclipse.core.resources.IProject;
import org.unicase.changetracking.commands.CreateStreamCommand;
import org.unicase.changetracking.commands.CreateStreamFromCurrentBranchCommand;
import org.unicase.changetracking.common.IDecisionProvider;

public abstract class BasicVCSAdapter implements VCSAdapter{

	@Override
	public CreateStreamCommand createStreamFromCurrentBranch(
			IDecisionProvider decisionProvider, IProject workspaceProject) {
		return new CreateStreamFromCurrentBranchCommand(this, decisionProvider, workspaceProject);
	}
}
