package org.unicase.ui.tom.commands;

import java.util.Collections;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.unicasecommon.diagram.util.CommandUtility;

public class SwitchConnectionEndsCommand extends AbstractCommand {

	private final ConnectionEditPart targetEditPart;

	public SwitchConnectionEndsCommand(DiagramEditPart diagramEditPart,
			ConnectionEditPart targetEditPart) {
		super(diagramEditPart);
		this.targetEditPart = targetEditPart;
	}

	@Override
	public Command getCommand() {
		SetConnectionEndsCommand switchConnectionEndsCommand = new SetConnectionEndsCommand(getDiagramEditPart().getEditingDomain(), "Switch connection ends"); 
		switchConnectionEndsCommand.setEdgeAdaptor(getTargetEditPart());
		EditPart sourceEditPart = getTargetEditPart().getSource();
		EditPart targetEditPart = getTargetEditPart().getTarget();
		
		switchConnectionEndsCommand.setNewSourceAdaptor(targetEditPart);
		switchConnectionEndsCommand.setNewTargetAdaptor(sourceEditPart);
		
		ICommandProxy commandProxy = new ICommandProxy(switchConnectionEndsCommand);
		Command canonicalModeCommands = CommandUtility.wrapInToggleCanonicalModeCommands(commandProxy, Collections.singleton(getDiagramEditPart()));
		return canonicalModeCommands;
	}

	public ConnectionEditPart getTargetEditPart() {
		return targetEditPart;
	}

	@Override
	protected Request createRequest() {
		return null;
	}

}
