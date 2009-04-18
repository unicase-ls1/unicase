/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.intergerationtest.tests;

import org.junit.BeforeClass;
import org.unicase.intergerationtest.TestHelper;
import org.unicase.workspace.ProjectSpace;

/**
 * @author Hodaie
 *
 */
public abstract class IntegrationTestCase {
	
	private static ProjectSpace testProjectSpace;
	private static ProjectSpace compareProjectSpace;
	
	/**
	 * set up test project.
	 */
	@BeforeClass
	public static void setup(){
		if(testProjectSpace != null){
			return;
		}
		
		testProjectSpace = TestHelper.createEmptyProjectSpace("test");
		
	}

	

	/**
	 * @return the testProjectSpace
	 */
	public ProjectSpace getTestProjectSpace() {
		return testProjectSpace;
	}

	

	/**
	 * @return the compareProjectSpace
	 */
	public ProjectSpace getCompareProjectSpace() {
		return compareProjectSpace;
	}

}
