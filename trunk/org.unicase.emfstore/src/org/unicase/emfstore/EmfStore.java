package org.unicase.emfstore;

import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.unicase.emfstore.storage.ResourceStorage;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;

public class EmfStore implements Runnable {

	private boolean doExit;
	
	public EmfStore(ResourceStorage storage, Properties properties) {
		
		this.doExit=false;
		
		URI resourceUri = storage.init(properties);
		ResourceSet resourceSet = new ResourceSetImpl();
		final Resource res = resourceSet.createResource(resourceUri);

		Project project = ModelPackage.eINSTANCE.getModelFactory()
				.createProject();
		project.setName("neuer test");
		res.getContents().add(project);

		try {
			res.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void run() {
		while (!doExit) {
			
		}
	}
	
	public void stop() {
		doExit=true;
	}

}
