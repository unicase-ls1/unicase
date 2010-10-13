package org.unicase.iterationplanner;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.iterationplanner.assigneerecommendation.AssigneeExpertise;
import org.unicase.iterationplanner.assigneerecommendation.AssigneePool;
import org.unicase.iterationplanner.assigneerecommendation.AssigneeRecommender;
import org.unicase.iterationplanner.assigneerecommendation.TaskPool;
import org.unicase.iterationplanner.assigneerecommendation.TaskPotentialAssigneeList;
import org.unicase.metamodel.Project;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

public class Application implements IApplication {

	public Object start(IApplicationContext context) throws Exception {
		System.out.println("Iteration Planner started!");

		Project project = getProject();
		// init task pool
		TaskPool.getInstance().setTasksToPlan(getTasksToPlan(project));

		// init assignee pool
		AssigneePool.getInstance().setAssignees(getAssignees(project));

		// start assignee recommender
		AssigneeRecommender assigneeRecommender = new AssigneeRecommender();

		// print results
		int i, j = 0;
		List<TaskPotentialAssigneeList> taskAssignees = assigneeRecommender.getTaskAssignees();
		for (TaskPotentialAssigneeList ta : taskAssignees) {
			i = 0;
			System.out.println(j + ". " + ta.getTask().getWorkItem().getName());
			for (AssigneeExpertise ae : ta.getRecommendedAssignees()) {
				// System.out.println("\t\t\t" + i + ". " + ae.getAssignee().getOrgUnit().getName() + "\t\t%8"
				// + ae.getExpertise());
				System.out.printf("\t\t\t %d. %-20s \t %f \n", i, ae.getAssignee().getOrgUnit().getName(), ae
					.getExpertise());
				i++;
			}
			j++;
		}

		return null;
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
		for (WorkItem me : backLog.getAllContainedWorkItems()) {
			if (me instanceof Checkable) {
				try {
					workItems.add(me);
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
