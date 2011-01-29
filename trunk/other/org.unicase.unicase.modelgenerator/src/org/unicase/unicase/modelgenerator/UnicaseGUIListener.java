package org.unicase.unicase.modelgenerator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.unicase.modelgenerator.ui.IGUIListener;
import org.unicase.modelgenerator.ui.ModelGeneratorGUI;
import org.unicase.workspace.util.UnicaseCommand;

public class UnicaseGUIListener implements IGUIListener{

	public void runInCommand(final ModelGeneratorGUI gui, final IProgressMonitor monitor) {
		new UnicaseCommand(){

			@Override
			protected void doRun() {
				gui.generateModel(monitor);
				
			}
			
		}.run(false);
		
	}

}
