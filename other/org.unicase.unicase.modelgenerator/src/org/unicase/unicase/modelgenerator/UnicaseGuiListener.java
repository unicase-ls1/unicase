package org.unicase.unicase.modelgenerator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.unicase.modelgenerator.IGuiListener;
import org.unicase.modelgenerator.ModelGeneratorGUI;
import org.unicase.workspace.util.UnicaseCommand;

public class UnicaseGuiListener implements IGuiListener{

	public void runInCommand(final ModelGeneratorGUI gui, final IProgressMonitor monitor) {
		new UnicaseCommand(){

			@Override
			protected void doRun() {
				gui.generateModel(monitor);
				
			}
			
		}.run(false);
		
	}

}
