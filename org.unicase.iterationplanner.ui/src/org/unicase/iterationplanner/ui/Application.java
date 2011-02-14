package org.unicase.iterationplanner.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.iterationplanner.assigneerecommender.Assignee;
import org.unicase.iterationplanner.assigneerecommender.AssigneePool;
import org.unicase.iterationplanner.assigneerecommender.AssigneeRecommender;
import org.unicase.iterationplanner.assigneerecommender.TaskPool;
import org.unicase.iterationplanner.planner.AssigneeAvailabilityManager;
import org.unicase.iterationplanner.planner.AssigneeExpertise;
import org.unicase.iterationplanner.planner.IterationPlan;
import org.unicase.iterationplanner.planner.MyPlanner;
import org.unicase.iterationplanner.planner.PlannedTask;
import org.unicase.iterationplanner.planner.Planner;
import org.unicase.iterationplanner.planner.PlannerParameters;
import org.unicase.iterationplanner.planner.TaskPotentialAssigneeList;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

public class Application implements IApplication {

	private boolean unicase; 
	
	public Object start(IApplicationContext context) throws Exception {

		 //createTestData();

		startPlanning();

		return null;
	}



	private void startPlanning() throws Exception {
		System.out.println("Iteration Planner started!");

		unicase = true;
		Project project = getProject();
		System.out.println("retrieved project: " + WorkspaceManager.getProjectSpace(project).getProjectName());
		// init task pool
		TaskPool.getInstance().setTasksToPlan(getTasksToPlan(project));
		System.out.println("retrieved tasks: " + TaskPool.getInstance().getTasksToPlan().size() + " tasks.");

		// init assignee pool
		List<User> users = getAssignees(project);
		AssigneePool.getInstance().setAssignees(users);
		System.out.println("retrieved users: " + AssigneePool.getInstance().getAssignees().size() + " assignees.");

		// start assignee recommender
		AssigneeRecommender assigneeRecommender = new AssigneeRecommender();
		List<TaskPotentialAssigneeList> taskPotentialAssigneeLists = assigneeRecommender.getTaskPotenialAssigneeLists();

		// print assignee recommendation results
		outputAssigneeRecommendationResults(taskPotentialAssigneeLists);

		// prepare parameters for iteration planner
		int numOfIterations = 4;
		AssigneeAvailabilityManager assigneeAvailabilityManager = createAssigneeAvailabilityManager(numOfIterations,
			AssigneePool.getInstance().getAssignees());

		Random random = new Random(1234567256L);
		

		int populationSize = 10;
		int resultSize = 5;
		int maxNumOfGenerations = 10;
		int percentOfCrossOverChildren = 30;
		int precentOfMutants = 60;
		int percentOfClones = 10;
		int percentOfCrossOverParents = 30;
		int percentOfMutationCandidates = 30;
		int percentOfCloneCandidates = 30;
		int percentOfTasksToMutate = 10;
		
		double expertiesWeight = 1.0;
		double priorityWeight = 1.0;
		double developerLoadWeight = 1.0;
	
		PlannerParameters plannerParameters = new PlannerParameters(populationSize, resultSize, maxNumOfGenerations,
			percentOfCrossOverChildren, precentOfMutants, percentOfClones, percentOfCrossOverParents,
			percentOfMutationCandidates, percentOfCloneCandidates, percentOfTasksToMutate, random, expertiesWeight, priorityWeight, developerLoadWeight);


		// start planner
		Planner myPlanner = new MyPlanner(numOfIterations, taskPotentialAssigneeLists, assigneeAvailabilityManager, plannerParameters);
		List<IterationPlan> result = myPlanner.start();

		// output result
		outputIterationPlannerResults(result, myPlanner);
	}

	@SuppressWarnings("unused")
	private void createTestData() {
		WorkspaceManager.init();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				try {
					new TestDataGenerator();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.run();
		System.out.println("done!");
	}

	private void outputIterationPlannerResults(List<IterationPlan> result, Planner myPlanner) {
		for (int i = 0; i < result.size(); i++) {
			IterationPlan iterPlan = result.get(i);
			System.out.println("\n");
			System.out.println("======================================================");
			System.out.println("=================== Iteration Plan " + i + " =================");
			System.out.println("======================================================");
			System.out.println("Overall score: " + iterPlan.getScore());
			System.out.println("expertise score: " + myPlanner.getEvaluator().evaluateExpertise(iterPlan));
			System.out.println("task prio score: "
				+ myPlanner.getEvaluator().evaluteTaskPriorities(iterPlan));
			System.out.println("dev load score: "
				+ myPlanner.getEvaluator().evaluateAssigneeLoad(iterPlan));
			System.out.println();

			for (int j = 0; j < iterPlan.getNumOfIterations(); j++) {
				outputIteration(j, iterPlan.getAllPlannedTasksForIteration(j), "\t************************* Iteration "
					+ j + " *********************");
			}
			outputIteration(iterPlan.getBacklogNumber(), iterPlan.getAllPlannedTasksForIteration(iterPlan
				.getBacklogNumber()), "\t************************** Backlog ************************");
		}

	}

	private void outputIteration(int iterationNumber, Set<PlannedTask> plannedTasks, String title) {
		System.out.println();

		System.out.println(title);
		System.out.println("\t***********************************************************");
		int i = 1;
		for (PlannedTask plannedTask : plannedTasks) {
			System.out.printf("\t %d. %s (exp: %.3f) ----> %s (prio: %d, est: %d)%n", 
								i, plannedTask.getAssigneeExpertise().getAssignee(), 
								plannedTask.getAssigneeExpertise().getExpertise(), 
								plannedTask.getTask().getName(), 
								plannedTask.getTask().getPriority(), 
								plannedTask.getTask().getEstimate());
			i++;
		}
	}

	private AssigneeAvailabilityManager createAssigneeAvailabilityManager(int numOfIterations, List<Assignee> assignees) {
		AssigneeAvailabilityManager assigneeAvailabilityManager = new AssigneeAvailabilityManager(numOfIterations);
		for (int i = 0; i < numOfIterations; i++) {
			// assume every assignee is 40 hours available in an iteration.
			for (Assignee assignee : assignees) {
				assigneeAvailabilityManager.setAvailability(i, assignee, 20);
			}
		}

		return assigneeAvailabilityManager;
	}

	private void outputAssigneeRecommendationResults(List<TaskPotentialAssigneeList> taskPotentialAssigneeLists) {
		int i, j = 0;
		for (TaskPotentialAssigneeList tpaList : taskPotentialAssigneeLists) {
			i = 0;
			System.out.println(j + ". " + tpaList.getTask().getName());
			for (AssigneeExpertise ae : tpaList.getRecommendedAssignees()) {
				// System.out.println("\t\t\t" + i + ". " + ae.getAssignee().getOrgUnit().getName() + "\t\t%8"
				// + ae.getExpertise());
				System.out.printf("\t\t\t %d. %-20s \t %f \n", i, ae.getAssignee(), ae.getExpertise());
				i++;
			}
			j++;
		}
	}

	private Project getProject() {
		EList<ProjectSpace> projectSpaces = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces();
		if(unicase){
			return projectSpaces.get(0).getProject();
		}else{
			return projectSpaces.get(1).getProject();
		}
	}

	private List<User> getAssignees(Project project) {
		List<User> users = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(),
			new BasicEList<User>());
		return users;
	}

	private List<WorkItem> getTasksToPlan(Project project) {
		List<WorkItem> workItems = new ArrayList<WorkItem>();
		if(unicase){
			List<WorkPackage> workPackages = project.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkPackage(),
				new BasicEList<WorkPackage>());
			WorkPackage backLog = null;
			for (WorkPackage wp : workPackages) {
				if (wp.getName().equalsIgnoreCase("backlog") && wp.getAllContainedWorkItems().size() > 50) {
					// it looks we have multiple back logs :)
					backLog = wp;
				}
			}

			workItems = new ArrayList<WorkItem>();
			for (ModelElement me : backLog.getAllContainedModelElements()) {
				if (me instanceof Checkable && me instanceof WorkItem) {
					try {
						workItems.add((WorkItem) me);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			return workItems;
		}
		
		List<WorkItem> wis = project.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkItem(), new BasicEList<WorkItem>());
		for (WorkItem wi : wis) {
			if (wi instanceof Checkable && !((ActionItem)wi).isDone()) {
				try {
					workItems.add(wi);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return workItems;
	}

	public void stop() {

	}

}
