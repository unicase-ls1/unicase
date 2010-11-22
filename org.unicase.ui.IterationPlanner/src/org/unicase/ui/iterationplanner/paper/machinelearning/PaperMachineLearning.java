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

import java.io.IOException;
import java.net.URL;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.analyzer.AnalyzerFactory;
import org.unicase.analyzer.AnalyzerModelController;
import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.analyzer.exporters.CSVExporter;
import org.unicase.analyzer.exporters.ExportersFactory;
import org.unicase.analyzer.iterator.IteratorFactory;
import org.unicase.analyzer.iterator.VersionIterator;
import org.unicase.analyzer.iterator.VersionSpecQuery;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.Annotation;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.metamodel.Project;
import org.unicase.model.bug.BugReport;
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.Milestone;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
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
	public static boolean HISTORY_BASED = false;
	private static boolean HISTORY_BASED_ITERATE_ALL_REVISIONS = false;
	
	private EList<UnicaseModelElement> allWorkItems;
	private List<UnicaseModelElement> allWorkItemsWithAssignee;
	private List<UnicaseModelElement> allWorkItemsWithAnnotatedMEsAndAssignee;
	private ArrayList<UnicaseModelElement> allWorkItemsWithAnnotatedMEs;
	private ArrayList<UnicaseModelElement> allWorkItemsAnnotatingNonFRs;
	
	
	private Project project;
	private ProjectSpace projectSpace;

	private Classification classification;

	
	public void start() {
		classification = new Classification();
		projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
				.getProjectSpaces().get(0);
		project = projectSpace.getProject();
		
		if (HISTORY_BASED) {
			runHistoryBased();
		} else {
			runStateBased();
		}
	}

	private void runHistoryBased() {
		List<UnicaseModelElement> workItems = new ArrayList<UnicaseModelElement>();
		ModelElementMatrix m = new ModelElementMatrix(workItems,
				getOutputFeatures());
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

	private void runStateBased() {
		initWorkItems(project);
		List<UnicaseModelElement> relevantWorkItems = allWorkItemsWithAnnotatedMEsAndAssignee;
		ModelElementMatrix m = new ModelElementMatrix(relevantWorkItems,
				getOutputFeatures());
		System.out.println(m.getModelElements().size());

		
		try {
			classification.init(m);
			classification.runStateBasedClassification();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void analyzeTriageAccuracy(ModelElementMatrix m)
			throws EmfStoreException, IteratorException, IOException {

		SetupHelper setupHelper = new SetupHelper("");
		setupHelper.loginServer();
		Usersession userSession = setupHelper.getUsersession();
		ConnectionManager connectionManager = WorkspaceManager.getInstance()
				.getConnectionManager();

		List<ProjectInfo> projectList = connectionManager
				.getProjectList(userSession.getSessionId());
		ProjectInfo projectInfo = projectList.get(0);

		int stepLength = 1;
		VersionIterator projectIt = IteratorFactory.eINSTANCE
				.createVersionIterator();
		CSVExporter exporter = ExportersFactory.eINSTANCE.createCSVExporter();
		URL entry = Activator.getDefault().getBundle().getEntry("Exports");
		URL fileURL = FileLocator.toFileURL(entry);
		exporter.init(fileURL.getFile()
			+ projectSpace.getProjectName() + "ML", true);
		projectIt.setProjectId(projectInfo.getProjectId());
		projectIt.setStepLength(stepLength);

		if (HISTORY_BASED_ITERATE_ALL_REVISIONS) {
			// go through all revisions
			projectIt.setDefault(true);
		} else {
			// determine start and end version
			int startRevision = 1200;
			//int endRevision = 1500;
			int endRevision = projectInfo.getVersion().getIdentifier();
			projectIt.setVersionSpecQuery(getVersionSpecQuery(startRevision,
					endRevision));
			projectIt.setForward(true);
		}

		projectIt.init(userSession);
		ArrayList<DataAnalyzer> analyzers = new ArrayList<DataAnalyzer>();
		analyzers.add(new MachineLearningTriageAccuracyAnalyzer(classification, m));
		@SuppressWarnings("unused")
		AnalyzerModelController anacontrol = new AnalyzerModelController(
				projectIt, analyzers, exporter);

	}

	private VersionSpecQuery getVersionSpecQuery(int startRevision,
			int endRevision) {
		PrimaryVersionSpec startVer = VersioningFactory.eINSTANCE
				.createPrimaryVersionSpec();

		startVer.setIdentifier(startRevision);

		PrimaryVersionSpec endVer = VersioningFactory.eINSTANCE
				.createPrimaryVersionSpec();
		endVer.setIdentifier(endRevision);

		VersionSpecQuery versionQuery = IteratorFactory.eINSTANCE
				.createVersionSpecQuery();
		versionQuery.setStartVersion(startVer);
		versionQuery.setEndVersion(endVer);

		return versionQuery;
	}

	private List<EStructuralFeature> getOutputFeatures() {
		List<EStructuralFeature> result = new ArrayList<EStructuralFeature>();
		result.add(ModelPackage.eINSTANCE.getUnicaseModelElement_Name());
		result.add(ModelPackage.eINSTANCE.getUnicaseModelElement_Description());
		result.add(ModelPackage.eINSTANCE
				.getAnnotation_AnnotatedModelElements());
		result.add(TaskPackage.eINSTANCE.getWorkItem_Predecessors());
		result.add(TaskPackage.eINSTANCE.getWorkItem_Successors());
		result.add(TaskPackage.eINSTANCE.getWorkItem_Assignee());
		return result;
	}


	
	private void initWorkItems(Project project) {

		allWorkItems = project.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkItem(),
			new BasicEList<UnicaseModelElement>());

		allWorkItemsWithAssignee = new ArrayList<UnicaseModelElement>();
		allWorkItemsWithAnnotatedMEs = new ArrayList<UnicaseModelElement>();
		allWorkItemsWithAnnotatedMEsAndAssignee = new ArrayList<UnicaseModelElement>();
		for (UnicaseModelElement wi : allWorkItems) {
			if (!(wi instanceof WorkPackage || wi instanceof Milestone)) {
				if (((WorkItem) wi).getAssignee() != null) {
					allWorkItemsWithAssignee.add(wi);
				}
				if (((Annotation) wi).getAnnotatedModelElements().size() > 0) {
					allWorkItemsWithAnnotatedMEs.add(wi);
					if (((WorkItem) wi).getAssignee() != null) {
						allWorkItemsWithAnnotatedMEsAndAssignee.add(wi);
					}
				}

			}

		}

	}

}
