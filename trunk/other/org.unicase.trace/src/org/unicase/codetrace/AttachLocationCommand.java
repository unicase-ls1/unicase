package org.unicase.codetrace;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.unicase.codetrace.ui.AttachCodeLocation;
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
	public AttachLocationCommand(UnicaseModelElement attachTo, CodeLocation locationToAttach){
		this.attachTo = attachTo;
		this.locationToAttach = locationToAttach;
	}

	@Override
	protected void doRun() {
		Project p = attachTo.getProject();
		try {
			final ProjectSpace projectSpace = WorkspaceManager
					.getProjectSpace(p);

			// Begin composite operation
			CompositeOperationHandle operationHandle = projectSpace.beginCompositeOperation();

			p.addModelElement(locationToAttach);
			attachTo.getAttachments().add(locationToAttach);
			

			try {
				operationHandle.end("Attached code location",
						"Attached a code location to " + attachTo.getName() + ".", locationToAttach.getModelElementId());
			} catch (InvalidHandleException e) {
				WorkspaceUtil.logException("Composite Operation failed!", e);
			}

		} catch (Throwable t) {
			t.printStackTrace();
		}

	}

}
