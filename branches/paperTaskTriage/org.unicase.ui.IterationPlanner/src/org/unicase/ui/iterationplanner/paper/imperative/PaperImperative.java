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
package org.unicase.ui.iterationplanner.paper.imperative;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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
import org.unicase.metamodel.Project;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.task.Milestone;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.iterationplanner.Activator;
import org.unicase.ui.iterationplanner.core.IterationPlannerManager;
import org.unicase.ui.iterationplanner.evaluator.SimpleEvaluator;
import org.unicase.ui.iterationplanner.provider.AssigneeProvider;
import org.unicase.ui.iterationplanner.provider.ExpertiseMap;
import org.unicase.ui.iterationplanner.provider.ImperativeAssigneePrediction;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.test.SetupHelper;

/**
 * @author Hodaie
 */
public class PaperImperative {

	public static boolean HISTORY_BASED = true;
	private static boolean HISTORY_BASED_ITERATE_ALL_REVISIONS = false;

	private List<OrgUnit> assigneesWithMoreThan10Tasks;
	private List<OrgUnit> assigneesWithAtLeastOneTask;
	private List<OrgUnit> allAssignees;

	private EList<WorkItem> allWorkItems;
	private List<WorkItem> allWorkItemsWithAssignee;
	private List<WorkItem> allWorkItemsWithAnnotatedMEsAndAssignee;
	private ArrayList<WorkItem> allWorkItemsWithAnnotatedMEs;
	private ArrayList<WorkItem> allWorkItemsAnnotatingNonFRs;

	private ProjectSpace projectSpace;
	private Project project;

	
	public void start() {

		projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces().get(0);
		project = getProject();

		if (HISTORY_BASED) {
			try {
				runHistoryBased();
			} catch (IteratorException e) {
				e.printStackTrace();
			} catch (EmfStoreException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

			runStateBased();

		}

	}

	private VersionSpecQuery getVersionSpecQuery(int startRevision, int endRevision) {
		PrimaryVersionSpec startVer = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		startVer.setIdentifier(startRevision);

		PrimaryVersionSpec endVer = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		endVer.setIdentifier(endRevision);

		VersionSpecQuery versionQuery = IteratorFactory.eINSTANCE.createVersionSpecQuery();
		versionQuery.setStartVersion(startVer);
		versionQuery.setEndVersion(endVer);

		return versionQuery;
	}

	/**
	 * @throws EmfStoreException
	 * @throws IOException
	 * @throws IteratorException
	 */
	private void runHistoryBased() throws EmfStoreException, IOException, IteratorException {

		SetupHelper setupHelper = new SetupHelper("");
		setupHelper.loginServer();
		Usersession userSession = setupHelper.getUsersession();
		ConnectionManager connectionManager = WorkspaceManager.getInstance().getConnectionManager();

		List<ProjectInfo> projectList = connectionManager.getProjectList(userSession.getSessionId());
		ProjectInfo projectInfo = projectList.get(0);

		int stepLength = 1;
		VersionIterator projectIt = IteratorFactory.eINSTANCE.createVersionIterator();
		CSVExporter exporter = ExportersFactory.eINSTANCE.createCSVExporter();
		URL entry = Activator.getDefault().getBundle().getEntry("Exports");
		URL fileURL = FileLocator.toFileURL(entry);
		exporter.init(fileURL.getFile()
			+ projectSpace.getProjectName() + "Imperative", true);
		projectIt.setProjectId(projectInfo.getProjectId());
		projectIt.setStepLength(stepLength);

		if (HISTORY_BASED_ITERATE_ALL_REVISIONS) {
			// go through all revisions
			projectIt.setDefault(true);
		} else {
			// determine start and end version
			int startRevision = 4500;
			//int endRevision = 1500;
			int endRevision = projectInfo.getVersion().getIdentifier();
			projectIt.setVersionSpecQuery(getVersionSpecQuery(startRevision, endRevision));
		}

		projectIt.setForward(true);
		projectIt.init(userSession);
		ArrayList<DataAnalyzer> analyzers = new ArrayList<DataAnalyzer>();

		IterationPlannerManager planningManager = new IterationPlannerManager();
		AssigneeProvider assigneeProvider = new AssigneeProvider(planningManager, new ImperativeAssigneePrediction());
		analyzers.add(new ImperativeTriageAccuracyAnalyzer(assigneeProvider));
		@SuppressWarnings("unused")
		AnalyzerModelController anacontrol = new AnalyzerModelController(projectIt, analyzers, exporter);

	}

	/**
	 * @throws IteratorException
	 * @throws EmfStoreException
	 * @throws IOException
	 */
	private void runStateBased() {
		initAssignees(project);
		initWorkItems(project);
		List<WorkItem> workItems = allWorkItemsWithAnnotatedMEsAndAssignee;
		List<OrgUnit> assignees = allAssignees;
		IterationPlannerManager planningManager = new IterationPlannerManager();

		AssigneeProvider assigneeProvider = new AssigneeProvider(planningManager, new ImperativeAssigneePrediction());
		assigneeProvider.setAssignees(assignees);
		System.out.println("Assignees");
		System.out.println("==========");
		for(OrgUnit assignee : assignees){
			System.out.println(assignee.getName());
		}
		
		Map<WorkItem, ExpertiseMap> testSet = new HashMap<WorkItem, ExpertiseMap>();
		for (WorkItem wi : workItems) {
			ExpertiseMap expertiseMap = assigneeProvider.getExpertiseMap(wi);
			print(expertiseMap, wi);
			testSet.put(wi, expertiseMap);

		}

		((SimpleEvaluator) planningManager.getEvaluator()).computeAccuracy(testSet);
		double firstPercision = ((SimpleEvaluator) planningManager.getEvaluator()).getFirstProposalPercision();
		double secondPercision = ((SimpleEvaluator) planningManager.getEvaluator()).getSecondProposalPercision();

		System.out.printf("first percision: %f%n", firstPercision);
		System.out.printf("scond percision: %f%n", secondPercision);

		System.out.println("num of work items: " + allWorkItems.size());
		System.out.println("num of WIsWithAnnotatedMEs: " + allWorkItemsWithAnnotatedMEs.size());
		System.out.println("num of WIsWithAssignee: " + allWorkItemsWithAssignee.size());
		System.out.println("num of WIsWithAnnotatedMEsAndAssignee: " + allWorkItemsWithAnnotatedMEsAndAssignee.size());
		

	}

	/**
	 * @return
	 */
	private Project getProject() {
		Project project = projectSpace.getProject();
		return project;
	}

	private void print(ExpertiseMap expertiseMap, WorkItem wi) {
		System.out.println("=============================================================================");
		System.out.println(wi.getName() + " ----> " + wi.getAssignee().getName() + " ("
			+ expertiseMap.sortByExpertise().get(0).getKey().getName() + ")");
		Iterator<Entry<OrgUnit, Double>> iterator = expertiseMap.getIterator();
		while (iterator.hasNext()) {
			Entry<OrgUnit, Double> next = iterator.next();
			System.out.printf("%-10s%40.1f%n", next.getKey().getName(), next.getValue());
		}
	}

	private void initWorkItems(Project project) {

		allWorkItems = project.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkItem(),
			new BasicEList<WorkItem>());

		allWorkItemsWithAssignee = new ArrayList<WorkItem>();
		allWorkItemsWithAnnotatedMEs = new ArrayList<WorkItem>();
		allWorkItemsWithAnnotatedMEsAndAssignee = new ArrayList<WorkItem>();
		for (WorkItem wi : allWorkItems) {
			if (!(wi instanceof WorkPackage || wi instanceof Milestone)) {
				if (wi.getAssignee() != null) {
					allWorkItemsWithAssignee.add(wi);
				}
				if (wi.getAnnotatedModelElements().size() > 0) {
					allWorkItemsWithAnnotatedMEs.add(wi);
					if (wi.getAssignee() != null) {
						allWorkItemsWithAnnotatedMEsAndAssignee.add(wi);
					}
				}

			}

		}

	}

	private List<WorkItem> getWorkItems(WorkPackage wp) {
		List<WorkItem> result = new ArrayList<WorkItem>();
		for (WorkItem wi : wp.getContainedWorkItems()) {
			if (wi instanceof WorkPackage) {
				result.addAll(((WorkPackage) wi).getContainedWorkItems());
			} else {
				result.add(wi);
			}
		}

		return result;
	}

	private void initAssignees(Project project) {
		allAssignees = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getOrgUnit(),
			new BasicEList<OrgUnit>());
		assigneesWithAtLeastOneTask = new ArrayList<OrgUnit>();
		assigneesWithMoreThan10Tasks = new ArrayList<OrgUnit>();
		for (OrgUnit assignee : allAssignees) {
			if (assignee.getAssignments().size() > 0) {
				assigneesWithAtLeastOneTask.add(assignee);
			}
			if (assignee.getAssignments().size() > 10) {
				assigneesWithMoreThan10Tasks.add(assignee);
			}
		}

	}
}
