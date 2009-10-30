/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.notificationProvider;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.bug.BugReport;
import org.unicase.ui.dashboard.notificationProviders.TaskNotificationProvider;
import org.unicase.workspace.ProjectSpace;

/**
 * Tests the TaskNotificationProvider.
 * 
 * @author shterev
 */
public class TaskNotificationTest extends AbstractNotificationTest {

	/**
	 * {@inheritDoc}
	 * 
	 * @throws EmfStoreException
	 */
	@Override
	protected void generateChanges() {
		BugReport bugReport1 = BugFactory.eINSTANCE.createBugReport();
		BugReport bugReport2 = BugFactory.eINSTANCE.createBugReport();
		BugReport bugReport3 = BugFactory.eINSTANCE.createBugReport();
		getSetupHelper().getTestProject().addModelElement(bugReport1);
		getSetupHelper().getTestProject().addModelElement(bugReport2);
		getSetupHelper().getTestProject().addModelElement(bugReport3);
		bugReport1.setAssignee(getSuperUser());
		bugReport2.setAssignee(getSuperUser());
		getSetupHelper().commitChanges();
		bugReport1.setName("bla");
		bugReport3.setReviewer(getSuperUser());
		getSetupHelper().commitChanges();
	}

	/**
	 * Tests for exceptions.
	 * 
	 * @throws EmfStoreException if any.
	 */
	@Test
	public void test() throws EmfStoreException {
		// final ProjectInfo projectInfo = (ProjectInfo) EcoreUtil.copy(getSetupHelper().getTestProjectSpace()
		// .getProjectInfo());
		final ProjectId projectId = (ProjectId) EcoreUtil.copy(getSetupHelper().getTestProjectSpace().getProjectId());

		final PrimaryVersionSpec initialVersionSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		initialVersionSpec.setIdentifier(0);

		// ProjectSpace projectSpace = new UnicaseCommandWithResult<ProjectSpace>() {
		//
		// @Override
		// protected ProjectSpace doRun() {
		// ProjectSpace projectSpace = null;
		// try {
		// projectSpace = getSetupHelper().getWorkSpace().checkout(getSetupHelper().getUsersession(),
		// projectInfo, initialVersionSpec);
		// } catch (EmfStoreException e) {
		// e.printStackTrace();
		// }
		// return projectSpace;
		//
		// }
		// }.run();

		ProjectSpace projectSpace = getSetupHelper().getTestProjectSpace();

		PrimaryVersionSpec headVersionSpec = projectSpace.resolveVersionSpec(VersionSpec.HEAD_VERSION);
		HistoryQuery query = VersioningFactory.eINSTANCE.createHistoryQuery();
		query.setSource(initialVersionSpec);
		query.setTarget(headVersionSpec);
		query.setIncludeChangePackage(true);

		List<HistoryInfo> historyInfos = getSetupHelper().getUsersession().getHistoryInfo(projectId, query);

		Collections.reverse(historyInfos);

		TaskNotificationProvider taskNotificationProvider = new TaskNotificationProvider();

		List<ESNotification> notifications = taskNotificationProvider.provideNotifications(projectSpace,
			new ArrayList<ChangePackage>(), "super");
		assertTrue(notifications.size() == 0);

		for (HistoryInfo hi : historyInfos) {
			if (hi.getChangePackage() != null) {
				hi.getChangePackage().setLogMessage(hi.getLogMessage());
			}
		}

		List<ChangePackage> changePackages = new ArrayList<ChangePackage>();
		for (HistoryInfo hi : historyInfos) {
			List<ESNotification> notifications2 = taskNotificationProvider.provideNotifications(projectSpace, Arrays
				.asList(hi.getChangePackage()), "super");
			changePackages.add(hi.getChangePackage());
			assertTrue(notifications2.size() <= 1);
		}

		taskNotificationProvider = new TaskNotificationProvider();
		List<ESNotification> notifications3 = taskNotificationProvider.provideNotifications(projectSpace,
			changePackages, "super");
		assertTrue(notifications3.size() == 2);
	}
}
