/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.startup.plugins;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.startup.StartupListener;
import org.unicase.metamodel.Project;

/**
 * A emfstore startup listener which rerecord all operations of all projects on the server.
 * 
 * @author wesendon
 *
 */
public class RerecordListener implements StartupListener {

	/**
	 * {@inheritDoc}
	 */
	public void startedUp(List<ProjectHistory> projects) {
		if(false) {
			return;
		}
		if(projects.size()==0) {
			return;
		}
		for (ProjectHistory pH : projects) {
			ChangeReRecorder changeReRecorder = new ChangeReRecorder();
			System.out.println("Checking: " + pH.getProjectName());
			int i = 0;
			for (Version version : pH.getVersions()) {
				if (version.getPrimarySpec().getIdentifier() == 0) {
					changeReRecorder.init((Project) EcoreUtil.copy(version.getProjectState()));
				} else {
					i++;
					EList<AbstractOperation> operations = version.getChanges()
							.getOperations();

					List<AbstractOperation> convertOperations = changeReRecorder.convertOperations(version.getChanges()
							.getCopyOfOperations());
					
					operations.clear();
					operations.addAll(convertOperations);
					
					try {
						version.getChanges().eResource().save(null);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					Project project = version.getProjectState();
					if(project != null) {
						Resource eResource = project.eResource();
						eResource.getContents().clear();
						Project newProject = changeReRecorder.getProject();
						eResource.getContents().add(newProject);
						version.setProjectState(newProject);
						try {
							eResource.save(null);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				if(i==0) {
					continue;
				}
				System.out.print(".");
				if(i%30==0) {
					System.out.println(" i:"+i);
				}
			}
			System.out.println("\n"+pH.getProjectName()+" finished.");
			
		}
		
		for(Resource res : projects.get(0).eResource().getResourceSet().getResources()) {
			try {
				res.save(null);
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}

}
