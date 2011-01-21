package org.unicase.unicase.modelgenerator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EPackage;
import org.unicase.metamodel.Project;
import org.unicase.modelgenerator.ModelGenerator;
import org.unicase.modelgenerator.common.ModelGeneratorConfiguration;
import org.unicase.modelgenerator.common.ModelGeneratorUtil;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Handler for the "Generate Project" context menu command.
 * The command is available no matter what is selected.
 * This handler creates a project and generates children from
 * the package defined in <code>MODEL_KEY</code>, where width
 * and depth are defined in <code>WIDTH</code> and <code>DEPTH</code>.
 */
public class GenerateProjectHandler extends AbstractHandler implements IHandler {
	
	/**
	 * The NsURI of the EPackage to generate EObjects from.
	 */
	private final String MODEL_KEY = "http://unicase.org/model";
	
	/**
	 * The maximum number of children for each EObject.
	 */
	private final int WIDTH = 3;
	
	/**
	 * The maximum hierarchy depth of the project.
	 */
	private final int DEPTH = 3;

	/**
	 * ({@inheritDoc})
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
				
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				final Project project = WorkspaceManager.getInstance().getCurrentWorkspace().createLocalProject("Generated Project", "Generated").getProject();
				final EPackage pckge = ModelGeneratorUtil.getEPackage(MODEL_KEY);
				ModelGeneratorConfiguration config = new ModelGeneratorConfiguration(pckge, project, WIDTH, DEPTH);
				ModelGenerator.generateModel(config);
			}
		}.run(false);

		return null;
	}
}
