package org.unicase.unicase.modelgenerator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.modelgenerator.ModelGenerator;
import org.unicase.modelgenerator.common.ModelGeneratorConfiguration;
import org.unicase.modelgenerator.common.ModelGeneratorUtil;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;



public class GenerateProjectHandler extends AbstractHandler implements IHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
				
		final String modelKey = "http://unicase.org/model";
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				final Project project = WorkspaceManager.getInstance().getCurrentWorkspace().createLocalProject("Generated Project", "Generated").getProject();
				final EPackage pckge = ModelGeneratorUtil.getEPackage(modelKey);
				EObject rootObject = project;
//				for(EClass ec : ModelGeneratorUtil.getAllModelElementEClasses(pckge))
//					if(ec.getName().equals("CompositeSection"))
//						rootObject = EcoreUtil.create(ec);
				ModelGeneratorConfiguration config = new ModelGeneratorConfiguration(pckge, rootObject);
				ModelGenerator.generateModel(config);
//				project.addModelElement(rootObject);
			}
		}.run(false);

		return null;
	}
}
