package org.unicase.link.arghandler;

import org.eclipse.ui.PlatformUI;
import org.eclipse.jface.dialogs.MessageDialog;


public class SampleArgsHandler implements IArgsHandler {

	public SampleArgsHandler() {
	}

	@Override
	public void handleArguments(String args) {
		//StrBuilder stringBuilder= new StrBuilder();
		//stringBuilder.appendWithSeparators(args," + ");
		MessageDialog.openInformation(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), "Incomming Args",
				"Incomming: " + args);
	}

}
