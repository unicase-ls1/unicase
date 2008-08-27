package org.unicase.ui.common.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.MEDiagram;

public class OpenDiagramWithMEEditorHandler extends AbstractHandler  {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ModelElement me = ActionHelper.getSelectedModelElement();
		if(me instanceof MEDiagram){
			ActionHelper.openMEDiagram((MEDiagram) me, true);
		}
		
		return null;
	}

}
