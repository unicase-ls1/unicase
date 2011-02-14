/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.codetrace;


import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.trace.CodeLocation;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * This class attaches a code location to a unicase model element.
 * This must be done in a UnicaseCommand.
 * @author jfinis
 *
 */
public class AttachLocationCommand extends UnicaseCommand {
	private UnicaseModelElement attachTo;
	private CodeLocation locationToAttach;
	
	/**
	 * The constructor.
	 * @param attachTo the unicase model element to that the code location will be attached 
	 * @param locationToAttach the code location which should be attached
	 */
	public AttachLocationCommand(UnicaseModelElement attachTo, CodeLocation locationToAttach){
		this.attachTo = attachTo;
		this.locationToAttach = locationToAttach;
	}
	
	/**
	 * 	Does the job.
	 */
	
	protected void doRun() {
		Project p = attachTo.getProject();

			final ProjectSpace projectSpace = WorkspaceManager
					.getProjectSpace(p);

			// Begin composite operation
			CompositeOperationHandle operationHandle = projectSpace.beginCompositeOperation();

			//Add the model element and link it
			p.addModelElement(locationToAttach);
			attachTo.getAttachments().add(locationToAttach);
			

			try {
				operationHandle.end("Attached code location",
						"Attached a code location to " + attachTo.getName() + ".", locationToAttach.getModelElementId());
			} catch (InvalidHandleException e) {
				WorkspaceUtil.logException("Composite Operation failed!", e);
			}


	}

}
