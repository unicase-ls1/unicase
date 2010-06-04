/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.changeTracking;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.unicase.workspace.test.caching.AllCachingTests;
import org.unicase.workspace.test.changeTracking.canonization.AllCanonizationTests;
import org.unicase.workspace.test.changeTracking.commands.AllCommandTests;
import org.unicase.workspace.test.changeTracking.notification.recording.AllNotificationTests;
import org.unicase.workspace.test.changeTracking.operations.AllOperationTests;
import org.unicase.workspace.test.changeTracking.topology.AllTopologyTests;

/**
 * Test Suite for running all tests of workspace.
 * 
 * @author chodnick
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( { AllNotificationTests.class, AllOperationTests.class, AllTopologyTests.class,
	AllCanonizationTests.class, AllCachingTests.class, AllCommandTests.class })
public class AllChangeTrackingTests {

}
