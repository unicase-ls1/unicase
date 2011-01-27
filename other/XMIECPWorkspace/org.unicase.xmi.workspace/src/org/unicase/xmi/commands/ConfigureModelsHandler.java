package org.unicase.xmi.commands;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;
import org.unicase.xmi.views.ConfigureModelsDialog;

public class ConfigureModelsHandler extends AbstractHandler{

	public Object execute(ExecutionEvent event) throws ExecutionException {
		// open dialog
		ConfigureModelsDialog dialog = new ConfigureModelsDialog(PlatformUI
			.getWorkbench().getDisplay().getActiveShell(), this);
		
		
		return null;
	}
	
	public void setModelList(List<String> list){
		
	}

}
