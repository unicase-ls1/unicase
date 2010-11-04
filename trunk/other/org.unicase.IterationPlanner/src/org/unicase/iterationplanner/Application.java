package org.unicase.iterationplanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.iterationplanner.assigneerecommendation.Assignee;
import org.unicase.iterationplanner.assigneerecommendation.AssigneeExpertise;
import org.unicase.iterationplanner.assigneerecommendation.AssigneePool;
import org.unicase.iterationplanner.assigneerecommendation.AssigneeRecommender;
import org.unicase.iterationplanner.assigneerecommendation.TaskPool;
import org.unicase.iterationplanner.assigneerecommendation.TaskPotentialAssigneeList;
import org.unicase.iterationplanner.planner.AssigneeAvailabilityManager;
import org.unicase.iterationplanner.planner.Evaluator;
import org.unicase.iterationplanner.planner.EvaluatorParameters;
import org.unicase.iterationplanner.planner.IterationPlan;
import org.unicase.iterationplanner.planner.PlannedTask;
import org.unicase.iterationplanner.planner.Planner;
import org.unicase.iterationplanner.planner.PlannerParameters;
import org.unicase.iterationplanner.planner.Selector;
import org.unicase.iterationplanner.planner.impl.MyEvaluator;
import org.unicase.iterationplanner.planner.impl.MyPlanner;
import org.unicase.iterationplanner.planner.impl.MySelector;
import org.unicase.iterationplanner.planner.impl.PlannerUtil;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

public class Application implements IApplication {

	public Object start(IApplicationContext context) throws Exception {

		// createTestData();

		startPlanning();

		// testGetIterationNumberProbabilistic();

		// testGetAssigneeProbabilistic();

		return null;
	}

	@SuppressWarnings("unused")
	private void testGetAssigneeProbabilistic() {
		Random random = new Random(1);
		System.out.println("Iteration Planner started!");

		Project project = getProject();
		System.out.println("retrieved project: " + WorkspaceManager.getProjectSpace(project).getProjectName());
		// init task pool
		TaskPool.getInstance().setTasksToPlan(getTasksToPlan(project));
		System.out.println("retrieved tasks: " + TaskPool.getInstance().getTasksToPlan().size() + " tasks.");

		// init assignee pool
		List<User> assignees = getAssignees(project);
		AssigneePool.getInstance().setAssignees(assignees);
		System.out.println("retrieved users: " + AssigneePool.getInstance().getAssignees().size() + " assignees.");

		// start assignee recommender
		AssigneeRecommender assigneeRecommender = new AssigneeRecommender();
		List<TaskPotentialAssigneeList> taskPotentialAssigneeLists = assigneeRecommender.getTaskPotenialAssigneeLists();

		// print assignee recommandation results
		outputAssigneeRecommendationResults(taskPotentialAssigneeLists);

		for (TaskPotentialAssigneeList tpal : taskPotentialAssigneeLists) {
			System.out.println();
			System.out.println("========================================================================");
			System.out.println(tpal.getTask().getWorkItem().getName());
			PlannerUtil.getInstance(random).getAssigneeProbabilistic(tpal.getRecommendedAssignees());
		}
	}

	@SuppressWarnings("unused")
	private void testGetIterationNumberProbabilistic() {
		Random random = new Random(1);

		for (int i = 0; i < 10; i++) {
			int numOfIterations = 4; // random.nextInt(5) + 1;
			int prio = random.nextInt(11);
			int iter = PlannerUtil.getInstance(random).testGetIterationNumberProbabilistic(prio, numOfIterations);
			System.out.println("prio: " + prio + "; num of iter: " + numOfIterations + "; iter: "
				+ (iter == numOfIterations ? "B" : iter));

		}
	}

	@SuppressWarnings("unused")
	private void startPlanning() throws Exception {
		System.out.println("Iteration Planner started!");

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

		// print assignee recommandation results
		outputAssigneeRecommendationResults(taskPotentialAssigneeLists);

		// prepare parameters for iteration planner
		int numOfIterations = 3;
		AssigneeAvailabilityManager assigneeAvailabilityManager = createAssigneeAvailabilityManager(numOfIterations,
			AssigneePool.getInstance().getAssignees());

		Random random = new Random(1234567256L);
		double expertiesWeight = 1.0;
		double priorityWeight = 1.0;
		double developerLoadWeight = 1.0;
		EvaluatorParameters evaluationParameters = new EvaluatorParameters(expertiesWeight, priorityWeight,
			developerLoadWeight, random);
		Evaluator iterationPlanEvaluator = new MyEvaluator(evaluationParameters);

		int populationSize = 50;
		int resultSize = 5;
		int maxNumOfGenerations = 50;
		int percentOfCrossOverChildren = 70;
		int precentOfMutants = 20;
		int percentOfClones = 10;
		int percentOfCrossOverParents = 30;
		int percentOfMutationCandidates = 30;
		int percentOfCloneCandidates = 30;
		int percentOfTasksToMutate = 10;
	
		PlannerParameters plannerParameters = new PlannerParameters(populationSize, resultSize, maxNumOfGenerations,
			percentOfCrossOverChildren, precentOfMutants, percentOfClones, percentOfCrossOverParents,
			percentOfMutationCandidates, percentOfCloneCandidates, percentOfTasksToMutate, random);

		Selector selector = new MySelector(plannerParameters.getRandom());

		// start planner
		Planner myPlanner = new MyPlanner(numOfIterations, taskPotentialAssigneeLists, assigneeAvailabilityManager,
			iterationPlanEvaluator, selector, plannerParameters);
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
			System.out.println("expertise score: " + myPlanner.getIterationPlanEvaluator().evaluateExpertise(iterPlan));
			System.out.println("task prio score: "
				+ myPlanner.getIterationPlanEvaluator().evaluteTaskPriorities(iterPlan));
			System.out.println("dev load score: "
				+ myPlanner.getIterationPlanEvaluator().evaluateAssigneeLoad(iterPlan));
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
			System.out.println("\t" + i + ". " + plannedTask.getAssigneeExpertise().getAssignee() + " ---> "
				+ plannedTask.getTask().getWorkItem().getName() + " (prio: " + plannedTask.getTask().getPriority()
				+ ")");
			i++;
		}
	}

	private AssigneeAvailabilityManager createAssigneeAvailabilityManager(int numOfIterations, List<Assignee> assignees) {
		AssigneeAvailabilityManager assigneeAvailabilityManager = new AssigneeAvailabilityManager(numOfIterations);
		for (int i = 0; i < numOfIterations; i++) {
			// assume every assignee is 40 hours available in an iteration.
			for (Assignee assignee : assignees) {
				assigneeAvailabilityManager.setAvailability(i, assignee, 40);
			}
		}

		return assigneeAvailabilityManager;
	}

	private void outputAssigneeRecommendationResults(List<TaskPotentialAssigneeList> taskPotentialAssigneeLists) {
		int i, j = 0;
		for (TaskPotentialAssigneeList tpaList : taskPotentialAssigneeLists) {
			i = 0;
			System.out.println(j + ". " + tpaList.getTask().getWorkItem().getName());
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
		return projectSpaces.get(0).getProject();
	}

	private List<User> getAssignees(Project project) {
		List<User> users = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(),
			new BasicEList<User>());
		return users;
	}

	private List<WorkItem> getTasksToPlan(Project project) {
		List<WorkPackage> workPackages = project.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkPackage(),
			new BasicEList<WorkPackage>());
		WorkPackage backLog = null;
		for (WorkPackage wp : workPackages) {
			if (wp.getName().equalsIgnoreCase("backlog") && wp.getAllContainedWorkItems().size() > 50) {
				// it looks we have multiple back logs :)
				backLog = wp;
			}
		}

		List<WorkItem> workItems = new ArrayList<WorkItem>();
		for (ModelElement me : backLog.getAllContainedModelElements()) {
			if (me instanceof Checkable && me instanceof WorkItem) {
				try {
					workItems.add((WorkItem) me);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		// final Random random = new Random(1);
		// final List<WorkItem> result = new ArrayList<WorkItem>();
		// for (int i = 0; i < 150; i++) {
		// int index = random.nextInt(workItems.size());
		// result.add(workItems.get(index));
		// workItems.remove(index);
		// }
		// new UnicaseCommand() {
		//
		// @Override
		// protected void doRun() {
		// for (int j = 0; j < result.size(); j++) {
		// result.get(j).setEstimate(random.nextInt(11)); //
		// result.get(j).setPriority(random.nextInt(11));
		// }
		// }
		// }.run();
		//
		// return result;
		return workItems;
	}

	public void stop() {

	}

}
