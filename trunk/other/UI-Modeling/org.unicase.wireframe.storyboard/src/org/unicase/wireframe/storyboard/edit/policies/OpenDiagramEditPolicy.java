/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.wireframe.storyboard.edit.policies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecp.common.utilities.ActionHelper;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.wireframe.Panel;
import org.unicase.wireframe.storyboard.part.Messages;

/**
 * Policy that will open the corresponding wireframe diagram when trying to open a {@link Panel} inside a storyboard
 * diagram. If no diagram exists, one will be created.
 * 
 * @author mharut
 * @generated NOT
 */
public class OpenDiagramEditPolicy extends OpenEditPolicy {

	protected Command getOpenCommand(Request request) {
		EditPart targetEditPart = getTargetEditPart(request);
		if (!(targetEditPart.getModel() instanceof View)) {
			return null;
		}
		View view = (View) targetEditPart.getModel();

		if (!(view.getElement() instanceof Panel)) {
			return null;
		}

		Panel panel = (Panel) view.getElement();

		return new ICommandProxy(new OpenDiagramCommand(panel));
	}

	private static class OpenDiagramCommand extends AbstractTransactionalCommand {

		private final Panel panel;

		OpenDiagramCommand(Panel panel) {
			// editing domain is taken for original diagram,
			// if we open diagram from another file, we should use another editing domain
			super(TransactionUtil.getEditingDomain(panel), Messages.CommandName_OpenDiagram, null);
			this.panel = panel;
		}

		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
			ActionHelper.openModelElement(panel, null);
			return CommandResult.newOKCommandResult();
		}
	}

}
