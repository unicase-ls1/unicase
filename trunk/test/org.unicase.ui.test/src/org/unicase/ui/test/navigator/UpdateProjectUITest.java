/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.navigator;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.test.SetupHelper;

/**
 * Class to test if a project is is updated correctly in a way that the project is successfully synchronized between the
 * UI and the UNICASE repository .
 */
public class UpdateProjectUITest extends MEEditorTest {
	/**
	 * Setup the environment for testing.
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
		getBot().sleep(1000);
	}

	/**
	 * Create a project "TestProject" in the workspace and add a composite and a leaf section.
	 */

	@Test
	public void updateProjectChange() {
	}

	/**
	 *stops the server after the caring out the test.
	 */

	@AfterClass
	public static void afterClass() {
		SetupHelper.stopServer();

	}
}
