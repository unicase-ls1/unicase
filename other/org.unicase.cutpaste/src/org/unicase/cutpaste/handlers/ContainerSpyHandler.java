package org.unicase.cutpaste.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.util.ActionHelper;

public class ContainerSpyHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
				
		ModelElement me = ActionHelper.getModelElement(event);
				
		String containerObject;
		containerObject = me.getContainerModelElement().toString();
		
		MessageDialog.openInformation(
				null,
				"w@iglt info_box",
				"Container is: "+containerObject+".") ;
		return null;
	}
	
}
