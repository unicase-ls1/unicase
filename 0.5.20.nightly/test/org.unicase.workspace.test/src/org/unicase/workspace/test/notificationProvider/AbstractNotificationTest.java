/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.test.notificationProvider;

import java.net.URISyntaxException;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.metamodel.Project;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.test.SetupHelper;
import org.unicase.workspace.test.TestProjectEnum;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * An abstract class with common procedures for notification provider tests.
 * 
 * @author shterev
 */
public abstract class AbstractNotificationTest {
	private static boolean serverRunning;
	private SetupHelper setupHelper;
	private User shterevg;
	private User koegel;
	private User wesendon;
	private Usersession shterevgSession;
	private Usersession wesendonSession;
	private Usersession koegelSession;
	private User superUser;

	/**
	 * @return wesendon
	 */
	protected User getWesendon() {
		return wesendon;
	}

	/**
	 * @return koegel
	 */
	protected User getKoegel() {
		return koegel;
	}

	/**
	 * @return shterevg
	 */
	protected User getShterevg() {
		return shterevg;
	}

	/**
	 * @return super user
	 */
	protected User getSuperUser() {
		return superUser;
	}

	/**
	 * @return wesendonSession
	 */
	protected Usersession getWesendonSession() {
		return wesendonSession;
	}

	/**
	 * @return koegelSession
	 */
	protected Usersession getKoegelSession() {
		return koegelSession;
	}

	/**
	 * @return shterevgSession
	 */
	protected Usersession getShterevgSession() {
		return shterevgSession;
	}

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

		// set up a new workspace
		setupHelper = new SetupHelper(TestProjectEnum.SUPERMARKET);
		setupHelper.setupWorkSpace();
		setupHelper.setupTestProjectSpace();
		setupHelper.shareProject();
		final Project project = setupHelper.getTestProject();
		final ProjectSpace projectSpace = setupHelper.getTestProjectSpace();

		// generate Users
		new UnicaseCommand() {
			@Override
			public void doRun() {
				try {
					OrgUnitHelper.importACUsers(projectSpace);
				} catch (AccessControlException e) {
					e.printStackTrace();
				}
				setupHelper.commitChanges();
			}
		}.run();

		// load a reference for each user
		EList<User> users = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(),
			new BasicEList<User>());
		for (User user : users) {
			if (user.getName().equals("shterevg")) {
				shterevg = user;
			} else if (user.getName().equals("koegel")) {
				koegel = user;
			} else if (user.getName().equals("wesendon")) {
				wesendon = user;
			} else if (user.getName().equals("super")) {
				superUser = user;
			}
		}

		// create usersessions
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				wesendonSession = setupHelper.createUsersession(wesendon);
				koegelSession = setupHelper.createUsersession(koegel);
				shterevgSession = setupHelper.createUsersession(shterevg);
				// try {
				// wesendonSession.logIn();
				// shterevgSession.logIn();
				// koegelSession.logIn();
				// } catch (AccessControlException e) {
				// e.printStackTrace();
				// } catch (EmfStoreException e) {
				// e.printStackTrace();
				// }
			}
		}.run();

		// generate changes
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				generateChanges();
			}
		}.run();
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
	 *@return the setup helper.
	 */
	public SetupHelper getSetupHelper() {
		return setupHelper;
	}

	/**
	 * Generates the changes for this test.
	 */
	protected abstract void generateChanges();
}
