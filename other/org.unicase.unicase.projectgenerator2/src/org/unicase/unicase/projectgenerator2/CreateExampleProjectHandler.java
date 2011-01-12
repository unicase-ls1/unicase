
package org.unicase.unicase.projectgenerator2;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EPackage;
import org.unicase.projectgenerator2.ProjectGeneratorImpl;
import org.unicase.projectgenerator2.ProjectGeneratorUtil;



public class CreateExampleProjectHandler  extends AbstractHandler implements IHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
				
		String modelKey = "http://unicase.org/model";
		
		final EPackage pckge = ProjectGeneratorUtil.getModelPackage(modelKey);
		ProjectGeneratorImpl impl = new ProjectGeneratorImpl(pckge, 123, 5, 3);
		ProjectGeneratorAdapter adapter = new ProjectGeneratorAdapter(impl);
		adapter.generateValues();
	
		return null;
	}
}
