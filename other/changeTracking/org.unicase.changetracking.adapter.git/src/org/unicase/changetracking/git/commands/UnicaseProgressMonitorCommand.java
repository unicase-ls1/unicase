/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
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
