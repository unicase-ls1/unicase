package org.unicase.ui.tom.commands;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.internal.commands.SendToBackCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author schroech
 *
 */
public class OrderBackCommand extends AbstractCommand {

	private final GraphicalEditPart targetEditPart;

	/**
	 * @param diagramEditPart
	 * @param targetEditPart
	 */
	public OrderBackCommand(DiagramEditPart diagramEditPart,
			GraphicalEditPart targetEditPart) {
		super(diagramEditPart);
		this.targetEditPart = targetEditPart;
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.commands.AbstractCommand#createRequest()
	*/
	@Override
	protected Request createRequest() {
		return null;
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.commands.AbstractCommand#getCommand()
	*/
	@SuppressWarnings("restriction")
	@Override
	public Command getCommand() {
		Object model = targetEditPart.getModel();
		if (!(model instanceof View)) {
			return null;
		}
		SendToBackCommand command = new SendToBackCommand(
				getDiagramEditPart().getEditingDomain(),
				(View)model);
		
		return new ICommandProxy(command);
	}

}
