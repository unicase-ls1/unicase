/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.unicase.workspace.test.SetupHelper;
import org.unicase.workspace.test.TestProjectEnum;

import java.net.URISyntaxException;

/**
 * @author Hodaie
 */
public abstract class IntegrationTest {

	private static boolean serverRunning;
	private SetupHelper setupHelper;
	
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
		serverRunning = true;

		

	}

	/**
	 * Before every test import test project and share it on the server.
	 */
	@Before
	public void setup() {
		
		setupHelper = new SetupHelper(TestProjectEnum.UNICASE);

		setupHelper.setupWorkSpace();
		
		setupHelper.setupTestProjectSpace();
		
		setupHelper.shareProject();

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
	 * @return the setupHelper
	 */
	public SetupHelper getSetupHelper() {
		return setupHelper;
	}

}
