/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.test.notificationProvider;

import java.net.URISyntaxException;
import java.util.Date;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.Project;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.bug.BugReport;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.Comment;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.test.SetupHelper;
import org.unicase.workspace.test.TestProjectEnum;
import org.unicase.workspace.util.OrgUnitHelper;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * An abstract class with common procedures for notification provider tests.
 * 
 * @author shterev
 */
public class AbstractNotificationProviderTest {
	private static boolean serverRunning;
	private SetupHelper setupHelper;
	private User shterevg;
	private User koegel;
	private User wesendon;
	private User naughton;
	private User helming;
	private User hodaie;
	private Usersession sessionShterevg;

	// private Usersession sessionWesendon;

	/**
	 * set up test project.
	 * 
	 * @throws URISyntaxException URISyntaxException
	 */
	@BeforeClass
	public static void init() throws URISyntaxException {
		if (serverRunning) {
			return;
		}

		SetupHelper.startSever();
		SetupHelper.addUserFileToServer(true);
		serverRunning = true;

	}

	/**
	 * Before every test import test project and share it on the server.
	 */
	@Before
	public void setup() {

		setupHelper = new SetupHelper(TestProjectEnum.SUPERMARKET);

		setupHelper.setupWorkSpace();

		setupHelper.setupTestProjectSpace();

		setupHelper.shareProject();

		final Project project = setupHelper.getTestProject();
		final ProjectSpace projectSpace = setupHelper.getTestProjectSpace();
		new UnicaseCommand() {
			@Override
			public void doRun() {
				try {
					projectSpace.setUsersession(setupHelper.getUsersession());
					OrgUnitHelper.importACUsers(projectSpace);
				} catch (AccessControlException e) {
					e.printStackTrace();
				}
				setupHelper.commitChanges();
			}
		}.run();
		EList<User> users = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(),
			new BasicEList<User>());
		for (User user : users) {
			if (user.getName().equals("shterevg")) {
				shterevg = user;
			} else if (user.getName().equals("koegel")) {
				koegel = user;
			} else if (user.getName().equals("wesendon")) {
				wesendon = user;
			} else if (user.getName().equals("hodaie")) {
				hodaie = user;
			} else if (user.getName().equals("helming")) {
				helming = user;
			} else if (user.getName().equals("naughton")) {
				naughton = user;
			}
		}

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				generateChanges(project);
				sessionShterevg = setupHelper.createUsersession(shterevg);
				// sessionWesendon = setupHelper.createUsersession(wesendon);
			}
		}.run();

	}

	/**
	 * Prints all users.
	 */
	@Test
	public void testUsers() {
		System.out.println(shterevg);
		System.out.println(koegel);
		System.out.println(wesendon);
		System.out.println(hodaie);
		System.out.println(helming);
		System.out.println(naughton);
	}

	/**
	 * Tests for null safety.
	 * 
	 * @throws EmfStoreException if it occurs on checkout
	 */
	@Test
	public void testNullSafety() throws EmfStoreException {
		ProjectInfo projectInfo = EsmodelFactory.eINSTANCE.createProjectInfo();
		ProjectId projectId = getSetupHelper().getTestProjectSpace().getProjectId();
		projectInfo.setProjectId((ProjectId) EcoreUtil.copy(projectId));
		getSetupHelper().getWorkSpace().checkout(sessionShterevg, projectInfo);
	}

	/**
	 * cleans server and workspace after tests are run.
	 */
	@After
	public void cleanUp() {
		setupHelper.cleanupWorkspace();

		SetupHelper.cleanupServer();
	}

	/**
	 * @return the testProject
	 */
	public Project getTestProject() {
		return setupHelper.getTestProject();
	}

	/**
	 *@return the setup helper.
	 */
	public SetupHelper getSetupHelper() {
		return setupHelper;
	}

	/**
	 * @param project
	 */
	private void generateChanges(final Project project) {
		WorkPackage workPackage = TaskFactory.eINSTANCE.createWorkPackage();
		project.addModelElement(workPackage);
		workPackage.setName("Test Sprint Alex");
		workPackage.setCreationDate(new Date());

		ActionItem actionItem1 = TaskFactory.eINSTANCE.createActionItem();
		workPackage.getContainedWorkItems().add(actionItem1);
		actionItem1.setName("Test AI 1");
		actionItem1.setCreationDate(new Date());
		actionItem1.setAssignee(shterevg);

		ActionItem actionItem2 = TaskFactory.eINSTANCE.createActionItem();
		workPackage.getContainedWorkItems().add(actionItem2);
		actionItem2.setName("Test AI 2");
		actionItem2.setCreationDate(new Date());
		actionItem2.setAssignee(shterevg);

		BugReport bugReport = BugFactory.eINSTANCE.createBugReport();
		workPackage.getContainedWorkItems().add(bugReport);
		bugReport.setName("Test BR 1");
		bugReport.setCreationDate(new Date());
		bugReport.setAssignee(shterevg);

		Issue issue1 = RationaleFactory.eINSTANCE.createIssue();
		workPackage.getContainedWorkItems().add(issue1);
		issue1.setName("Test Issue 1");
		issue1.setCreationDate(new Date());
		issue1.setAssignee(shterevg);

		setupHelper.commitChanges();

		BugReport bugReport2 = BugFactory.eINSTANCE.createBugReport();
		workPackage.getContainedWorkItems().add(bugReport2);
		bugReport2.setName("Test BR 2");
		bugReport2.setCreationDate(new Date());
		bugReport2.setAssignee(shterevg);

		Issue issue2 = RationaleFactory.eINSTANCE.createIssue();
		workPackage.getContainedWorkItems().add(issue2);
		issue2.setName("Test Issue 2");
		issue2.setCreationDate(new Date());
		issue2.setAssignee(shterevg);

		Issue issue3 = RationaleFactory.eINSTANCE.createIssue();
		workPackage.getContainedWorkItems().add(issue3);
		issue3.setName("Test Issue 3");
		issue3.setCreationDate(new Date());
		issue3.setAssignee(shterevg);

		bugReport2.setEstimate(20);
		actionItem1.setDescription("descr1");
		actionItem2.setDescription("descr2");
		actionItem2.setEffort(10);

		setupHelper.commitChanges();

		workPackage.setDescription("blaaa");
		workPackage.setDueDate(new Date());
		workPackage.setAssignee(shterevg);

		setupHelper.commitChanges();

		Comment comment1 = RationaleFactory.eINSTANCE.createComment();
		comment1.setName("Test comment 1");
		comment1.setCreationDate(new Date());
		comment1.setDescription("test descr");
		comment1.setSender(wesendon);
		comment1.getRecipients().add(shterevg);
		workPackage.getComments().add(comment1);

		Comment comment2 = RationaleFactory.eINSTANCE.createComment();
		comment2.setName("Test comment 2");
		comment2.setCreationDate(new Date());
		comment2.setDescription("test descr");
		actionItem1.getComments().add(comment2);

		setupHelper.commitChanges();

		Comment comment3 = RationaleFactory.eINSTANCE.createComment();
		comment3.setName("Test comment 3");
		comment3.setCreationDate(new Date());
		comment3.setDescription("test descr");
		comment2.getComments().add(comment3);

		Comment comment4 = RationaleFactory.eINSTANCE.createComment();
		comment4.setName("Test comment 4");
		comment4.setCreationDate(new Date());
		comment4.setDescription("test descr");
		comment2.getComments().add(comment4);

		Comment comment5 = RationaleFactory.eINSTANCE.createComment();
		comment5.setName("Test comment 5");
		comment5.setCreationDate(new Date());
		comment5.setDescription("test descr");
		comment3.getComments().add(comment5);

		setupHelper.commitChanges();

		Comment comment6 = RationaleFactory.eINSTANCE.createComment();
		comment3.getComments().add(comment6);
		comment6.getRecipients().add(shterevg);

		Issue issue4 = RationaleFactory.eINSTANCE.createIssue();
		issue4.setAssignee(shterevg);
		project.addModelElement(issue4);
		setupHelper.commitChanges();
	}
}
