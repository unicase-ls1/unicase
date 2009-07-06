package org.unicase.ui.tom.commands;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;

public class CreateViewCommand extends AbstractCommand {

	CreateViewCommand(DiagramEditPart editor) {
		super(editor);
		// TODO Auto-generated constructor stub
	}

	public void execute() {
		/*
		ObjectAdapter objectAdapter = new ObjectAdapter();
		objectAdapter.setObject(ModelElementTypes.Class_2001);

		CreateViewAndOptionallyElementCommand createViewAndOptionallyElementCommand = new CreateViewAndOptionallyElementCommand(objectAdapter, diagramEditPart, null, diagramPreferencesHint);
		diagramEditPart.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(createViewAndOptionallyElementCommand));
		 */

	}

	public Request createRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	public Command getCommand() {
		// TODO Auto-generated method stub
		return null;
	}

}
