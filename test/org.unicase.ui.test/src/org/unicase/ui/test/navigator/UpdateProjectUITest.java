/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.navigator;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.metamodel.Project;
import org.unicase.model.document.LeafSection;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.User;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.test.SetupHelper;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Class to test if a project is is updated correctly in a way that the project is successfully synchronized between the
 * UI and the UNICASE repository .
 */
public class UpdateProjectUITest extends MEEditorTest {

	private ProjectSpace projectSpace;
	private LeafSection leafSection;

	/**
	 * Setup the environment for testing by starting the server.
	 */
	@BeforeClass
	public static void beforeClass() {

		SetupHelper.startSever();
	}

	/**
	 * Creates a project "TestProject" in the workspace and then adds a new composite and a leaf section. Then it
	 * updates the server using UNICASE command. Then a check is performed to see if the project updated within the UI
	 * or Not.
	 */

	@Test
	public void updateProjectUpdate() {
		UITestCommon.openView(getBot(), "Unicase", "Unicase Navigator");
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
				projectSpace = currentWorkspace.getActiveProjectSpace();
				Project project = projectSpace.getProject();
				User user1 = OrganizationFactory.eINSTANCE.createUser();
				user1.setName("super");
				project.addModelElement(user1);
				Usersession usersession = UITestCommon.createUsersession(user1);
				User user2 = OrganizationFactory.eINSTANCE.createUser();
				user2.setName("Testuser");
				project.addModelElement(user2);
				try {
					usersession.logIn();
					projectSpace.shareProject(usersession);

				} catch (AccessControlException e1) {
					// TODO Auto-generated catch block
					// Do NOT catch all Exceptions ("catch (Exception e)")
					// Log AND handle Exceptions if possible
					//
					// You can just uncomment one of the lines below to log an exception:
					// logException will show the logged excpetion to the user
					// ModelUtil.logException(e1);
					// ModelUtil.logException("YOUR MESSAGE HERE", e1);
					// logWarning will only add the message to the error log
					// ModelUtil.logWarning("YOUR MESSAGE HERE", e1);
					// ModelUtil.logWarning("YOUR MESSAGE HERE");
					//			
					// If handling is not possible declare and rethrow Exception
				} catch (EmfStoreException e1) {
					// TODO Auto-generated catch block
					// Do NOT catch all Exceptions ("catch (Exception e)")
					// Log AND handle Exceptions if possible
					//
					// You can just uncomment one of the lines below to log an exception:
					// logException will show the logged excpetion to the user
					// ModelUtil.logException(e1);
					// ModelUtil.logException("YOUR MESSAGE HERE", e1);
					// logWarning will only add the message to the error log
					// ModelUtil.logWarning("YOUR MESSAGE HERE", e1);
					// ModelUtil.logWarning("YOUR MESSAGE HERE");
					//			
					// If handling is not possible declare and rethrow Exception
				}

				// TODO Auto-generated catch block

				// connectionManager.logIn(username, password, severInfo, clientVersionInfo);
				// connectionManager.logIn(username, password, severInfo, clientVersionInfo)

				// CompositeSection document = DocumentFactory.eINSTANCE.createCompositeSection();
				// document.setName("Requirements Document");

				// project.getModelElement
				// leafSection = DocumentFactory.eINSTANCE.createLeafSection();
				// leafSection.setName("LeafSection");
				// document.getSubsections().add(leafSection);
			}
		}.run();

		getBot().sleep(30000);
	}

	/**
	 * Create a project "TestProject" in the workspace and add a composite and a leaf section.
	 */

	@Test
	public void updateProjectChange() {
	}

	/**
	 *stops the server after doing the test.
	 */

	@AfterClass
	public static void afterClass() {
		SetupHelper.cleanupServer();
		SetupHelper.stopServer();

	}
}
