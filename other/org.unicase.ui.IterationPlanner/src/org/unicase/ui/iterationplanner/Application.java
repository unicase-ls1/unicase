/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.task.TaskPackage;
import org.unicase.ui.iterationplanner.provider.Classification;
import org.unicase.ui.iterationplanner.util.ModelElementMatrix;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Hodaie
 */
public class Application implements IApplication {

	// BEGIN SUPRESS CATCH EXCEPTION
	/**
	 * {@inheritDoc}
	 * 
	 * @throws Exception exception
	 */
	public Object start(IApplicationContext context) throws Exception {

		System.out.println("Hello Java!");

		ProjectSpace projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces().get(0);
		Project project = projectSpace.getProject();

		List<ModelElement> workItems = project.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkItem(),
			new BasicEList<ModelElement>());

		List<EStructuralFeature> features = getOutputFeatures();

		ModelElementMatrix m = new ModelElementMatrix(workItems, features);

		Classification classification = new Classification(m);
		try {
			classification.run();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	private List<EStructuralFeature> getOutputFeatures() {
		List<EStructuralFeature> result = new ArrayList<EStructuralFeature>();
		result.add(ModelPackage.eINSTANCE.getModelElement_Name());
		result.add(ModelPackage.eINSTANCE.getModelElement_Description());
		result.add(ModelPackage.eINSTANCE.getAnnotation_AnnotatedModelElements());
		result.add(TaskPackage.eINSTANCE.getWorkItem_Predecessors());
		result.add(TaskPackage.eINSTANCE.getWorkItem_Successors());
		result.add(TaskPackage.eINSTANCE.getWorkItem_Assignee());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void stop() {

	}

	// END SUPRESS CATCH BLOCK
}
