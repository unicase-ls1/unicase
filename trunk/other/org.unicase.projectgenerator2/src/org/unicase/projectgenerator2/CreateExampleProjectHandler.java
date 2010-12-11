
package org.unicase.projectgenerator2;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.unicase.metamodel.Project;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

public class CreateExampleProjectHandler  extends AbstractHandler implements IHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		//final ProjectSpace projectSpace = ActionHelper.getProjectSpace(event);
		//projectSpace.getProject().getAllModelElements();
		
		
		String unicaseKey = "http://unicase.org/model";
		
		final EPackage pckge = ProjectGeneratorUtil.getModelPackage(unicaseKey);
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				final Project project = WorkspaceManager.getInstance().getCurrentWorkspace().createLocalProject("Generated Project", "Generated").getProject();
				EClass clazz = ProjectGeneratorUtil.getModelElementEClasses(pckge, "CompositeSection");
				EObject rootElement = clazz.getEPackage().getEFactoryInstance().create(clazz);
				ProjectGeneratorImpl impl = new ProjectGeneratorImpl(pckge, 2, 5, 5);
				impl.setRoot(rootElement);
				impl.generateValues();
				project.addModelElement(impl.getRootObject());
			}

		}.run();
		return null;
	}
}
