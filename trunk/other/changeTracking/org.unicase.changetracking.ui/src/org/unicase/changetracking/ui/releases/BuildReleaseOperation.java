package org.unicase.changetracking.ui.releases;

import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.unicase.changetracking.commands.BuildReleaseCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.ui.Activator;
import org.unicase.changetracking.ui.UIUtil;

public class BuildReleaseOperation {

	private static final String JAVA_PERSPECTIVE_ID = "org.eclipse.jdt.ui.JavaPerspective";
	private boolean isContinueing;
	private BuildReleaseCommand command;

	public BuildReleaseOperation(BuildReleaseCommand command, boolean isContinueing) {
		this.command = command;
		this.isContinueing = isContinueing;
	}
	
	public ChangeTrackingCommandResult run(){
		command.setContinue(isContinueing);
		ChangeTrackingCommandResult result = UIUtil.runCommand(command);
		if(command.hadConflicts()){
			Activator.setLastConflictingCommand(command);
			try {
				PlatformUI.getWorkbench().showPerspective(JAVA_PERSPECTIVE_ID, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
			} catch (WorkbenchException e) {
			}
		} else {
			Activator.setLastConflictingCommand(null);
		}
		return result;
	}
}
