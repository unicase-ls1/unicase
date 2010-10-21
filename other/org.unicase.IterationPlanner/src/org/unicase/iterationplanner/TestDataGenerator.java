package org.unicase.iterationplanner;

import java.io.IOException;
import java.util.ArrayList;

import org.unicase.metamodel.Project;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.User;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.UnkownProjectException;

public class TestDataGenerator {

	private final Project project;
	private final WorkPackage backlog;
	private final WorkPackage done;
	private ArrayList<User> developers;

	public TestDataGenerator() {
		//
		ProjectSpace projSpace = WorkspaceManager.getInstance().getCurrentWorkspace().createLocalProject("testProject",
			"description");
		project = projSpace.getProject();
		backlog = TaskPackage.eINSTANCE.getTaskFactory().createWorkPackage();
		done = TaskPackage.eINSTANCE.getTaskFactory().createWorkPackage();

		project.addModelElement(backlog);
		project.addModelElement(done);

		createDevelopers();

		for (int i = 0; i < 4; i++) {
			createRootReqs("requirement" + i);
		}

		try {
			WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpace(project).exportProject(
				"C:\\users\\zardosht\\Desktop\\testProj.ucp");
		} catch (UnkownProjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void createDevelopers() {
		// TODO create 4 devs
		developers = new ArrayList<User>();
		for (int i = 0; i < 4; i++) {
			User dev = OrganizationFactory.eINSTANCE.createUser();
			project.addModelElement(dev);
			dev.setName("dev" + i);
			developers.add(dev);
		}

	}

	private void createRootReqs(String name) {
		FunctionalRequirement req = RequirementPackage.eINSTANCE.getRequirementFactory().createFunctionalRequirement();
		project.addModelElement(req);
		req.setName(name);
		createSubReq(req);
	}

	private void createSubReq(FunctionalRequirement rootReq) {
		for (int i = 0; i < 4; i++) {
			FunctionalRequirement subReq = RequirementPackage.eINSTANCE.getRequirementFactory()
				.createFunctionalRequirement();
			rootReq.getRefiningRequirements().add(subReq);
			subReq.setName(rootReq.getName() + "." + i);
			createLeafReq(subReq, i);
			createTasks(subReq, i);
		}

	}

	private void createLeafReq(FunctionalRequirement parentReq, int parenReqId) {
		for (int i = 0; i < 6; i++) {
			FunctionalRequirement leafReq = RequirementPackage.eINSTANCE.getRequirementFactory()
				.createFunctionalRequirement();
			parentReq.getRefiningRequirements().add(leafReq);
			leafReq.setName(parentReq.getName() + "." + i);
		}

	}

	private void createTasks(FunctionalRequirement subReq, int subReqId) {

		for (int j = 0; j < subReq.getRefiningRequirements().size(); j++) {
			FunctionalRequirement leafReq = subReq.getRefiningRequirements().get(j);
			ActionItem task = TaskFactory.eINSTANCE.createActionItem();
			project.addModelElement(task);
			task.setName("do " + leafReq.getName());
			leafReq.getAnnotations().add(task);
		}
		for (int k = 0; k < subReq.getRefiningRequirements().size() - 2; k++) {
			FunctionalRequirement leafReq = subReq.getRefiningRequirements().get(k);
			ActionItem task = (ActionItem) leafReq.getAnnotations().get(0);
			task.setDone(true);
			if (k == subReq.getRefiningRequirements().size() - 4) {
				task.setAssignee(developers.get((subReqId + 1) % 4));
			} else if (k == subReq.getRefiningRequirements().size() - 3) {
				task.setAssignee(developers.get((subReqId + 2) % 4));
			} else {
				task.setAssignee(developers.get(subReqId));
			}
		}

	}
}
