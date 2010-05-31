/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.unicase.workspace.test.changeTracking.AllChangeTrackingTests;
import org.unicase.workspace.test.conflictDetection.AllConflictDetectionTests;
import org.unicase.workspace.test.integration.AllIntegrationTests;

/**
 * Runs all tests.
 * 
 * @author koegel
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( { AllChangeTrackingTests.class, AllConflictDetectionTests.class, AllIntegrationTests.class })
public class AllTests {

}
