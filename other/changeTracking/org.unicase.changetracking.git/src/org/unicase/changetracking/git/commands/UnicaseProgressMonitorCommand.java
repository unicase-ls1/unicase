package org.unicase.changetracking.git.commands;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.unicase.workspace.util.UnicaseCommand;

public abstract class UnicaseProgressMonitorCommand extends UnicaseCommand{

	private IProgressMonitor progressMonitor;

	public void run(IProgressMonitor monitor) {
		this.progressMonitor = monitor;
		run(false);
	}
	
	protected IProgressMonitor getProgressMonitor(){
		if(progressMonitor == null){
			progressMonitor = new NullProgressMonitor();
		}
		return progressMonitor;
	}
	
}
