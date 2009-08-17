/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.unicase.model.Project;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.task.Milestone;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.iterationplanner.core.IterationPlannerManager;
import org.unicase.ui.iterationplanner.evaluator.SimpleEvaluator;
import org.unicase.ui.iterationplanner.provider.ExpertiseMap;
import org.unicase.ui.iterationplanner.provider.ImperativeRelatedTasks;
import org.unicase.ui.iterationplanner.provider.TaskProvider;
import org.unicase.workspace.WorkspaceManager;

/**
 * This handler shows iteration planning wizard.
 * 
 * @author hodaie
 */
public class ShowIterationPlanningWizardHandler extends AbstractHandler {

	private List<User> assigneesWithMoreThan10Tasks;
	private List<User> assigneesWithAtLeastOneTask;
	private List<User> allAssignees;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		Project project = WorkspaceManager.getInstance().getCurrentWorkspace()
				.getActiveProjectSpace().getProject();

		List<User> assignees = getAssignees(project);
		List<WorkItem> workItems = getWorkItems(project);
		IterationPlannerManager planningManager = new IterationPlannerManager();
		planningManager.getAssigneeProvider().setAssignees(assignees);
		
		Map<WorkItem, ExpertiseMap> testSet = new HashMap<WorkItem, ExpertiseMap>();
		TaskProvider taskProvider = new TaskProvider(planningManager, new ImperativeRelatedTasks());
		for(WorkItem wi : workItems){
			ExpertiseMap expertiseMap = taskProvider.getExpertiseMap(wi);
			print(expertiseMap, wi);
			testSet.put(wi, expertiseMap);
			
		}
		
		((SimpleEvaluator)planningManager.getEvaluator()).computePercision(testSet);
		double firstPercision = ((SimpleEvaluator)planningManager.getEvaluator()).getFirstProposalPercision();
		double secondPercision = ((SimpleEvaluator)planningManager.getEvaluator()).getSecondProposalPercision();
		
		System.out.printf("first percision: %f%n", firstPercision);
		System.out.printf("scond percision: %f%n", secondPercision);

		return null;
	}

	private void print(ExpertiseMap expertiseMap, WorkItem wi) {
		System.out.println("=============================================================================");
		System.out.println(wi.getName());
		Iterator<Entry<User, Double>> iterator = expertiseMap.getExpertiseMap().entrySet().iterator();
		while(iterator.hasNext()){
			Entry<User, Double> next = iterator.next();
			System.out.printf("%-10s%40.1f%n", next.getKey().getName(),next.getValue());
		}
	}

	private List<WorkItem> getWorkItems(Project project) {
		List<WorkItem> result = new ArrayList<WorkItem>();
//		List<WorkPackage> workPackages = project
//		.getAllModelElementsbyClass(
//				TaskPackage.eINSTANCE.getWorkPackage(),
//				new BasicEList<WorkPackage>());
//		
//		
//		for(WorkPackage wp : workPackages){
//			if(wp.getName().equals("ASAP")){
//				result.addAll(getWorkItems(wp));
//			}else if(wp.getName().equals("Backlog")){
//				result.addAll(getWorkItems(wp));
//			}else if(wp.getName().equals("Sprint 33")){
//				result.addAll(getWorkItems(wp));
//			}else if(wp.getName().equals("Sprint 32")){
//				result.addAll(getWorkItems(wp));
//			}
//		}
		EList<WorkItem> allWorkItems = project.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkItem(), new BasicEList<WorkItem>());
		for(WorkItem wi : allWorkItems){
			if(!(wi instanceof WorkPackage || wi instanceof Milestone || wi.getAssignee() == null)){
				//if(assigneesWithMoreThan10Tasks.contains(wi.getAssignee())){
					result.add(wi);
				//}
				
			}
		}
		
		return result;
	}

	private List<WorkItem> getWorkItems(WorkPackage wp) {
		List<WorkItem> result = new ArrayList<WorkItem>();
		for(WorkItem wi : wp.getContainedWorkItems()){
		    if(wi instanceof WorkPackage){
		    	result.addAll(((WorkPackage) wi).getContainedWorkItems());
		    }else{
		    	result.add(wi);
		    }
		}
		
		return result;
	}

	private List<User> getAssignees(Project project) {
		List<User> result = new ArrayList<User>();
//		for (User assignee : project
//				.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE
//						.getUser(), new BasicEList<User>())) {
//			if (assignee.getName().equals("helming")) {
//				result.add(assignee);
//			} else if (assignee.getName().equals("liya")) {
//				result.add(assignee);
//			} else if (assignee.getName().equals("denglerm")) {
//				result.add(assignee);
//			} else if (assignee.getName().equals("shterevg")) {
//				result.add(assignee);
//			} else if (assignee.getName().equals("wesendon")) {
//				result.add(assignee);
//			} else if (assignee.getName().equals("koegel")) {
//				result.add(assignee);
//			} else if (assignee.getName().equals("hoechts")) {
//				result.add(assignee);
//			} else if (assignee.getName().equals("pfeifferc")) {
//				result.add(assignee);
//			} else if (assignee.getName().equals("barzalia")) {
//				result.add(assignee);
//			} else if (assignee.getName().equals("hodaie")) {
//				result.add(assignee);
//			}
//
//		}
		
		allAssignees = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(), new BasicEList<User>());
		assigneesWithAtLeastOneTask = new ArrayList<User>();
		assigneesWithMoreThan10Tasks = new ArrayList<User>();
		for(User assignee : allAssignees){
			if(assignee.getAssignments().size() > 0){
				assigneesWithAtLeastOneTask.add(assignee);
			}
			if(assignee.getAssignments().size() > 10){
				assigneesWithMoreThan10Tasks.add(assignee);
			}
		}
		
		
		result.addAll(assigneesWithMoreThan10Tasks);
		
		return result;
	}
}



