
package org.unicase.unicase.projectgenerator2;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EPackage;
import org.unicase.metamodel.Project;
import org.unicase.projectgenerator2.ProjectGeneratorImpl;
import org.unicase.projectgenerator2.util.ProjectGeneratorConfiguration;
import org.unicase.projectgenerator2.util.ProjectGeneratorUtil;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;



public class CreateExampleProjectHandler  extends AbstractHandler implements IHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
				
		final String modelKey = "http://unicase.org/model";
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				final Project project = WorkspaceManager.getInstance().getCurrentWorkspace().createLocalProject("Generated Project", "Generated").getProject();
				final EPackage pckge = ProjectGeneratorUtil.getModelPackage(modelKey);
				ProjectGeneratorConfiguration config = new ProjectGeneratorConfiguration(pckge, project, 5, 3);
				new ProjectGeneratorImpl().generateModel(config);
			}
		}.run(false);
		
		
	
		return null;
	}
}
