
package org.unicase.unicase.modelgenerator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EPackage;
import org.unicase.metamodel.Project;
import org.unicase.modelgenerator.ModelGenerator;
import org.unicase.modelgenerator.util.ModelGeneratorConfiguration;
import org.unicase.modelgenerator.util.ModelGeneratorUtil;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;



public class CreateExampleProjectHandler  extends AbstractHandler implements IHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
				
		final String modelKey = "http://unicase.org/model";
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				final Project project = WorkspaceManager.getInstance().getCurrentWorkspace().createLocalProject("Generated Project", "Generated").getProject();
				final EPackage pckge = ModelGeneratorUtil.getModelPackage(modelKey);
				ModelGeneratorConfiguration config = new ModelGeneratorConfiguration(pckge, project, 5, 3);
				ModelGenerator.generateModel(config);
			}
		}.run(false);

		return null;
	}
}
