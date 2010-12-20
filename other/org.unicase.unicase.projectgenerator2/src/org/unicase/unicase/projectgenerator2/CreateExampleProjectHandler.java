
package org.unicase.unicase.projectgenerator2;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.unicase.projectgenerator2.ProjectGeneratorImpl;
import org.unicase.projectgenerator2.ProjectGeneratorUtil;


public class CreateExampleProjectHandler  extends AbstractHandler implements IHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		//final ProjectSpace projectSpace = ActionHelper.getProjectSpace(event);
		//projectSpace.getProject().getAllModelElements();
		
		
		String unicaseKey = "http://unicase.org/model";
		
		final EPackage pckge = ProjectGeneratorUtil.getModelPackage(unicaseKey);
		
		EObject rootElement = ProjectGeneratorUtil.createEObject(ProjectGeneratorUtil.getModelElementEClasses(pckge, "CompositeSection"));
		ProjectGeneratorImpl impl = new ProjectGeneratorImpl(pckge, 2, 5, 5);
		ProjectGeneratorAdapter adapter = new ProjectGeneratorAdapter(impl);
		adapter.setRootObject(rootElement);
		adapter.generateValues();
		return null;
	}
}
