/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
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

/**
 * @author schroech
 *
 */
public class SwitchConnectionEndsCommand extends AbstractCommand {

	private final ConnectionEditPart targetEditPart;

	/**
	 * Default constructor. 
	 * @param diagramEditPart The diagram edit part
	 * @param targetEditPart THe target edit part
	 */
	public SwitchConnectionEndsCommand(DiagramEditPart diagramEditPart,
			ConnectionEditPart targetEditPart) {
		super(diagramEditPart);
		this.targetEditPart = targetEditPart;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.commands.AbstractCommand#getCommand()
	 */
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

	/**
	 * @return The target edit part
	 */
	public ConnectionEditPart getTargetEditPart() {
		return targetEditPart;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.commands.AbstractCommand#createRequest()
	 */
	@Override
	protected Request createRequest() {
		return null;
	}

}
