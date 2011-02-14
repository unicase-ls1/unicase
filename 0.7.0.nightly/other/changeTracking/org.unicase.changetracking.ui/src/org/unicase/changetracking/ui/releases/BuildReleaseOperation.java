package org.unicase.changetracking.ui.releases;

import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.unicase.changetracking.git.commands.GitBuildReleaseCommand;
import org.unicase.changetracking.ui.UIUtil;

public class BuildReleaseOperation {

	private static final String JAVA_PERSPECTIVE_ID = "org.eclipse.jdt.ui.JavaPerspective";
	private boolean isContinueing;
	private GitBuildReleaseCommand command;

	public BuildReleaseOperation(GitBuildReleaseCommand command, boolean isContinueing) {
		this.command = command;
		this.isContinueing = isContinueing;
	}
	
	public void run(){
		command.setContinue(isContinueing);
		UIUtil.runProgressMonitorCommand(command, "Release was built successfully.");
		if(command.hadConflict()){
			try {
				PlatformUI.getWorkbench().showPerspective(JAVA_PERSPECTIVE_ID, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
			} catch (WorkbenchException e) {
			}
		}
	}
}
