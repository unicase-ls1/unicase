package org.unicase.iterationplanner.ui.wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.progress.IProgressConstants;
import org.unicase.iterationplanner.assigneeRecommender.AssigneeExpertise;
import org.unicase.iterationplanner.assigneeRecommender.AssigneeRecommender;
import org.unicase.iterationplanner.assigneeRecommender.TaskPotentialAssigneeList;
import org.unicase.iterationplanner.assigneerecommender.Assignee;
import org.unicase.iterationplanner.assigneerecommender.AssigneePool;
import org.unicase.iterationplanner.assigneerecommender.TaskPool;
import org.unicase.iterationplanner.assigneerecommender.UnicaseAssigneeRecommender;
import org.unicase.iterationplanner.planner.AbstractPlanner;
import org.unicase.iterationplanner.planner.AssigneeAvailabilityManager;
import org.unicase.iterationplanner.planner.IIterationPlan;
import org.unicase.iterationplanner.planner.IPlannedTask;
import org.unicase.iterationplanner.planner.PlannerFactory;
import org.unicase.iterationplanner.planner.PlannerParameters;
import org.unicase.iterationplanner.ui.wizard.input.UserAvailability;
import org.unicase.iterationplanner.ui.wizard.output.IterationPlanningOutputWizard;
import org.unicase.metamodel.Project;
import org.unicase.model.organization.User;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.WorkItem;

public class PlannerController {

	private AbstractPlanner planner;
	private List<IIterationPlan> result;

	private int numOfIterations;
	private List<FunctionalRequirement> requirements;
	private List<WorkItem> workItems;
	private List<UserAvailability> userAvailabilities;
	private Project project;

	public PlannerController(Project project) {
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
		// reqs is a faltenned list of requirements
		for (FunctionalRequirement req : reqs) {
			if (req.getRefinedRequirement() == null) {
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

		final Job job = new Job("Planning Iterations") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				System.out.println("Iteration AbstractPlanner started!");

				// init task pool
				TaskPool.getInstance().setTasksToPlan(getWorkItemsToPlan());
				System.out.println("retrieved tasks: " + TaskPool.getInstance().getTasksToPlan().size() + " tasks.");

				// init assignee pool
				AssigneePool.getInstance().setAssignees(getAssignees());
				System.out.println("retrieved users: " + AssigneePool.getInstance().getAssignees().size()
					+ " assignees.");

				// start assignee recommender
				AssigneeRecommender assigneeRecommender = new UnicaseAssigneeRecommender();
				List<TaskPotentialAssigneeList> taskPotentialAssigneeLists = assigneeRecommender
					.getTaskPotenialAssigneeLists();

				// print assignee recommendation results
				outputAssigneeRecommendationResults(taskPotentialAssigneeLists);

				// prepare parameters for iteration planner
				AssigneeAvailabilityManager assigneeAvailabilityManager = createAssigneeAvailabilityManager(AssigneePool
					.getInstance().getAssignees());

				Random random = new Random(1234567256L);
				PlannerParameters plannerParameters = getPlannerParameters(random);

				planner = PlannerFactory.getInstance().getShiftDownPlanner(numOfIterations, taskPotentialAssigneeLists, assigneeAvailabilityManager, plannerParameters);
				//planner = PlannerFactory.getInstance().getRandomPlanner(numOfIterations, taskPotentialAssigneeLists, assigneeAvailabilityManager, plannerParameters);
				result = planner.start();

//				if (isModal(this)) {
//					// The progress dialog is still open so
//					// just open the message
//					showResults();
//				} else {
					setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
					setProperty(IProgressConstants.ACTION_PROPERTY, getOpenOutputWizardAction());
//				}
				return Status.OK_STATUS;

			}
		};

		job.setUser(true);
		job.schedule(); // start as soon as possible

	}

	protected void showResults() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				getOpenOutputWizardAction().run();
			}
		});
	}

	protected Action getOpenOutputWizardAction() {
		return new Action("View reservation status") {
			@Override
			public void run() {
				openOutPutWizard(result.get(0), planner);
			}
		};

	}

	private void openOutPutWizard(IIterationPlan iterationPlan, AbstractPlanner planner) {
		IterationPlanningOutputWizard outputWizard = new IterationPlanningOutputWizard(iterationPlan, planner);
		WizardDialog dialog = new WizardDialog(Display.getCurrent().getActiveShell(), outputWizard);
		dialog.open();
	}

	public boolean isModal(Job job) {
		Boolean isModal = (Boolean) job.getProperty(IProgressConstants.PROPERTY_IN_DIALOG);
		if (isModal == null)
			return false;
		return isModal.booleanValue();
	}

	@SuppressWarnings("unused")
	private void outputIterationPlannerResults(List<IIterationPlan> result, AbstractPlanner myPlanner) {
		for (int i = 0; i < result.size(); i++) {
			IIterationPlan iterPlan = result.get(i);
			System.out.println("\n");
			System.out.println("======================================================");
			System.out.println("=================== Iteration Plan " + i + " =================");
			System.out.println("======================================================");
			System.out.println("Overall score: " + iterPlan.getScore());
			System.out.println("expertise score: " + myPlanner.getEvaluator().evaluateExpertise(iterPlan));
			System.out.println("task prio score: " + myPlanner.getEvaluator().evaluteTaskPriorities(iterPlan));
			System.out.println("dev load score: " + myPlanner.getEvaluator().evaluateAssigneeLoad(iterPlan));
			System.out.println();

			for (int j = 0; j < iterPlan.getNumOfIterations(); j++) {
				outputIteration(j, iterPlan.getAllPlannedTasksForIteration(j), "\t************************* Iteration "
					+ j + " *********************");
			}
			outputIteration(iterPlan.getBacklogNumber(), iterPlan.getAllPlannedTasksForIteration(iterPlan
				.getBacklogNumber()), "\t************************** Backlog ************************");
		}

	}

	private void outputIteration(int iterationNumber, Set<IPlannedTask> plannedTasks, String title) {
		System.out.println();

		System.out.println(title);
		System.out.println("\t***********************************************************");
		int i = 1;
		for (IPlannedTask plannedTask : plannedTasks) {
			System.out.printf("\t %d. %s (exp: %.3f) ----> %s (prio: %d, est: %d)%n", i, plannedTask
				.getAssigneeExpertise().getAssignee(), plannedTask.getAssigneeExpertise().getExpertise(), plannedTask
				.getTask().getName(), plannedTask.getTask().getPriority(), plannedTask.getTask()
				.getEstimate());
			i++;
		}
	}

	private PlannerParameters getPlannerParameters(Random random) {
		int populationSize = 50;
		int resultSize = 5;
		int maxNumOfGenerations = 10;
		int percentOfCrossOverChildren = 70;
		int precentOfMutants = 15;
		int percentOfClones = 15;
		int percentOfCrossOverParents = 30;
		int percentOfMutationCandidates = 30;
		int percentOfCloneCandidates = 30;
		int percentOfTasksToMutate = 10;
		
		//evaluator parameters
		double expertiseWeight = 1.0;
		double priorityWeight = 1.0;
		double developerLoadWeight = 1.0;
		

		PlannerParameters plannerParameters = new PlannerParameters(populationSize, resultSize, maxNumOfGenerations,
			percentOfCrossOverChildren, precentOfMutants, percentOfClones, percentOfCrossOverParents,
			percentOfMutationCandidates, percentOfCloneCandidates, percentOfTasksToMutate, random, expertiseWeight, priorityWeight, developerLoadWeight);
		return plannerParameters;
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
		for (UserAvailability ua : userAvailabilities) {
			if (ua.getUser().equals(assignee.getOrgUnit())) {
				return ua.getAvailability(iterNumber);
			}
		}
		return 0;
	}

	private List<User> getAssignees() {
		List<User> assignees = new ArrayList<User>();
		for (UserAvailability ua : userAvailabilities) {
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

}
