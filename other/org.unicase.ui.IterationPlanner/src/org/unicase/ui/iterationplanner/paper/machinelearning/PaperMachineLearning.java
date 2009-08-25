/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.paper.machinelearning;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.ujmp.core.enums.FileFormat;
import org.ujmp.core.exceptions.MatrixException;
import org.unicase.analyzer.AnalyzerModelController;
import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.analyzer.exporters.CSVExporter;
import org.unicase.analyzer.exporters.ExportersFactory;
import org.unicase.analyzer.iterator.IteratorFactory;
import org.unicase.analyzer.iterator.VersionIterator;
import org.unicase.analyzer.iterator.VersionSpecQuery;
import org.unicase.analyzer.iterator.impl.VersionSpecQueryImpl;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.task.TaskPackage;
import org.unicase.ui.iterationplanner.Activator;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.test.SetupHelper;
import org.unicase.workspace.test.TestProjectEnum;

/**
 * @author Hodaie
 */
public class PaperMachineLearning {

	private Classification classification;





	public void start() {

		//use a project directly
		ProjectSpace projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces().get(0);
		Project project = projectSpace.getProject();
		
				
		List<ModelElement> workItems = new ArrayList<ModelElement>();
		List<EStructuralFeature> features = getOutputFeatures();
		
		ModelElementMatrix m = new ModelElementMatrix(workItems, features);

		classification = new Classification();
//		try {
//			classification.run();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			analyzeTriageAccuracy(m);
		} catch (EmfStoreException e) {
			e.printStackTrace();
		} catch (IteratorException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void analyzeTriageAccuracy(ModelElementMatrix m) throws EmfStoreException, IteratorException, IOException{
		//create a analyzer and let it go through revisions
		//listen to notifications about work items
		//on notifications regarding work items
		//   creat a new model element matrix (m) from all work items in new project state 
		//   create a new calssification for matrix m
		//   get accuracy of new classification
		//output: a csv file for [revision, accuracy] 
	 	// or 					 [number of work items, accuracy] ??    
		
		

		
		SetupHelper setupHelper = new SetupHelper(TestProjectEnum.NONE);
		setupHelper.loginServer();
		Usersession userSession = setupHelper.getUsersession();
		ConnectionManager connectionManager = WorkspaceManager.getInstance().getConnectionManager();


		List<ProjectInfo> projectList = connectionManager.getProjectList(userSession.getSessionId());
		ProjectInfo projectInfo = projectList.get(0);
		
		int stepLength = 1;
		VersionIterator projectIt = IteratorFactory.eINSTANCE.createVersionIterator();
		CSVExporter exporter = ExportersFactory.eINSTANCE.createCSVExporter();
		exporter.init(Activator.getDefault().getBundle().getLocation().replace("reference:file:", "") + "/Exports/export_test.dat",true);
		projectIt.setProjectId(projectInfo.getProjectId());
		projectIt.setStepLength(stepLength);
		
		
		projectIt.setDefault(true);
		projectIt.init(userSession);
		ArrayList<DataAnalyzer> analyzers = new ArrayList<DataAnalyzer>();
		analyzers.add(new TriageAccuracyAnalyzer(classification, m));
		@SuppressWarnings("unused")
		AnalyzerModelController anacontrol = new AnalyzerModelController(projectIt, analyzers, exporter);					

		
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
}
