package org.unicase.changetracking.git.commands;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.unicase.workspace.util.UnicaseCommand;

public abstract class UnicaseProgressMonitorCommand extends UnicaseCommand implements IRunnableWithProgress{

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
