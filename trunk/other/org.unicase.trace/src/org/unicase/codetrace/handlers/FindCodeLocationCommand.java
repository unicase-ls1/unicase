/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.codetrace.handlers;


import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.unicase.codetrace.tracer.FoundLocation;
import org.unicase.codetrace.tracer.LocationFinder;
import org.unicase.codetrace.ui.TaskLocationLoader;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.trace.CodeLocation;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Command to find code location.
 * 
 * @author snogina
 */
public final class FindCodeLocationCommand  extends UnicaseCommand {
	
	private ModelElement link;

	/**
	 * Default constructor.
	 * 
	 * @param linkToCodeLocation the attached code location.
	 */
	public FindCodeLocationCommand(ModelElement linkToCodeLocation) {
		this.link = linkToCodeLocation;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doRun() {
		ModelElement codeLocationLink = link;
		if (codeLocationLink instanceof CodeLocation) {
			LocationFinder finder = LocationFinder.getInstance();
			FoundLocation location = finder.find((CodeLocation)codeLocationLink);
			if(location == null){
				System.out.println("No Code Location found.");
				return;
			}
			//change current perspective to the java perspective
			IWorkbench workbench = PlatformUI.getWorkbench();
			try {
				workbench.showPerspective("org.eclipse.jdt.ui.JavaPerspective", 
				workbench.getActiveWorkbenchWindow());
			} catch (WorkbenchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			IWorkbenchPage page  = workbench.getActiveWorkbenchWindow().getActivePage();
		
			TaskLocationLoader.openTaskLocation(location.getFile(), location.getLineNumber(), page);
		}

	}
}
