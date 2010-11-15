package org.unicase.iterationplanner.ui.wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
import org.unicase.iterationplanner.ui.wizard.input.UserAvailability;
import org.unicase.metamodel.Project;
import org.unicase.model.organization.User;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.WorkItem;

public class PlannerBridge {
	
	private int numOfIterations;
	private List<FunctionalRequirement> requirements;
	private List<WorkItem> workItems;
	private List<UserAvailability> userAvailabilities;
	private Project project; 
	
	public PlannerBridge(Project project){
		this.project = project; 
	}


	public Project getProject() {
		return project;
	}


	public int getNumOfIteations() {
		return numOfIterations == 0 ? 1 : numOfIterations;
	}

	public void setNumOfIteations(int numOfIterations) {
		this.numOfIterations = numOfIterations;
	}


	public void setRequirements(List<FunctionalRequirement> reqs) {
		this.requirements = new ArrayList<FunctionalRequirement>();
		//reqs is a faltenned list of requirements
		for(FunctionalRequirement req : reqs){
			if(req.getRefinedRequirement() == null){
				requirements.add(req);
			}
		}
	}


	public void setWorkItems(List<WorkItem> workItemsToPlan) {
		this.workItems = workItemsToPlan;
	}


	public void setAssignees(List<UserAvailability> userAvailabilities) {
		this.userAvailabilities = userAvailabilities;
	}


	public void startPlanner() {
		System.out.println("Iteration Planner started!");

		// init task pool
		TaskPool.getInstance().setTasksToPlan(getWorkItemsToPlan());
		System.out.println("retrieved tasks: " + TaskPool.getInstance().getTasksToPlan().size() + " tasks.");

		// init assignee pool
		
		AssigneePool.getInstance().setAssignees(getAssignees());
		System.out.println("retrieved users: " + AssigneePool.getInstance().getAssignees().size() + " assignees.");

		// start assignee recommender
		AssigneeRecommender assigneeRecommender = new AssigneeRecommender();
		List<TaskPotentialAssigneeList> taskPotentialAssigneeLists = assigneeRecommender.getTaskPotenialAssigneeLists();

		// print assignee recommendation results
		outputAssigneeRecommendationResults(taskPotentialAssigneeLists);

		// prepare parameters for iteration planner
		AssigneeAvailabilityManager assigneeAvailabilityManager = createAssigneeAvailabilityManager(AssigneePool.getInstance().getAssignees());

		Random random = new Random(1234567256L);
		EvaluatorParameters evaluationParameters = getEvaluatioParameters(random);
		Evaluator iterationPlanEvaluator = new MyEvaluator(evaluationParameters);

		PlannerParameters plannerParameters = getPlannerParameters(random);

		Selector selector = new MySelector(plannerParameters.getRandom());

		// start planner
		Planner myPlanner = new MyPlanner(numOfIterations, taskPotentialAssigneeLists, assigneeAvailabilityManager,
			iterationPlanEvaluator, selector, plannerParameters);
		List<IterationPlan> result = myPlanner.start();

		// output result
		outputIterationPlannerResults(result, myPlanner);
	
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
			System.out.printf("\t %d. %s (exp: %.3f) ----> %s (prio: %d, est: %d)%n", 
								i, plannedTask.getAssigneeExpertise().getAssignee(), 
								plannedTask.getAssigneeExpertise().getExpertise(), 
								plannedTask.getTask().getWorkItem().getName(), 
								plannedTask.getTask().getPriority(), 
								plannedTask.getTask().getEstimate());
			i++;
		}
	}


	private PlannerParameters getPlannerParameters(Random random) {
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
	
		PlannerParameters plannerParameters = new PlannerParameters(populationSize, resultSize, maxNumOfGenerations,
			percentOfCrossOverChildren, precentOfMutants, percentOfClones, percentOfCrossOverParents,
			percentOfMutationCandidates, percentOfCloneCandidates, percentOfTasksToMutate, random);
		return plannerParameters;
	}


	private EvaluatorParameters getEvaluatioParameters(Random random) {
		double expertiesWeight = 1.0;
		double priorityWeight = 1.0;
		double developerLoadWeight = 1.0;
		EvaluatorParameters evaluationParameters = new EvaluatorParameters(expertiesWeight, priorityWeight,
			developerLoadWeight, random);
		return evaluationParameters;
	}


	private AssigneeAvailabilityManager createAssigneeAvailabilityManager(List<Assignee> assignees) {
		AssigneeAvailabilityManager assigneeAvailabilityManager = new AssigneeAvailabilityManager(numOfIterations);
		for (int i = 0; i < numOfIterations; i++) {
			// assume every assignee is 40 hours available in an iteration.
			for (Assignee assignee : assignees) {
				assigneeAvailabilityManager.setAvailability(i, assignee, getAvailability(assignee, i));
			}
		}

		return assigneeAvailabilityManager;
	}

	private int getAvailability(Assignee assignee, int iterNumber) {
		for(UserAvailability ua : userAvailabilities){
			if(ua.getUser().equals(assignee.getOrgUnit())){
				return ua.getAvailability(iterNumber);
			}
		}
		return 0;
	}


	private List<User> getAssignees() {
		List<User> assignees = new ArrayList<User>();
		for(UserAvailability ua : userAvailabilities){
			assignees.add(ua.getUser());
		}
		return assignees;
	}


	private List<WorkItem> getWorkItemsToPlan() {
		return workItems;
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

	
	
}
