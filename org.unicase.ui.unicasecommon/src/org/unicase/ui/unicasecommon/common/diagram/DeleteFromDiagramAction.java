/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.diagram;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.EdgeImpl;
import org.eclipse.jface.action.Action;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.ui.unicasecommon.diagram.commands.CommandFactory;
import org.unicase.ui.unicasecommon.diagram.edit.parts.MEDiagramEditPart;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;

// dengler: clarify if deleted reference if case is necessary.
/**
 * @author denglerm This class implements the DeleteFromDiagram Action.
 */
public class DeleteFromDiagramAction extends Action {

	/**
	 * In case of a diagram node to be deleted: This method deletes the model
	 * element behind the node from the diagram's elements (done by
	 * DeleteFromDiagramCommand) list, but not from the project. In case of a
	 * diagram link to be deleted: The reference is deleted from the view _and_
	 * from the model.
	 * 
	 * @see org.eclipse.jface.action#run()
	 */
	@Override
	public void run() {
		EditPart selectedElement = (EditPart) UnicaseActionHelper
				.getSelection();
		CompoundCommand ccommand = new CompoundCommand("delete from diagram");
		View view = EditPartUtility.getView(selectedElement);
		DiagramEditPart rootEditPart = EditPartUtility
				.getDiagramEditPart(selectedElement);
		// if no element of the diagram has been selected
		if (rootEditPart == null) {
			return;
		}
		if (view instanceof Node) {
			ccommand.add(CommandFactory
					.createDeleteFromViewCommand(selectedElement));

		}
		rootEditPart.getDiagramEditDomain().getDiagramCommandStack()
				.execute(ccommand);

		// / Until I find out, while the Editpart is not notified in this case,
		// the following serves as a workaround
		if (view instanceof EdgeImpl) {
			((MEDiagramEditPart) rootEditPart).updateView();
		}
	}
}
