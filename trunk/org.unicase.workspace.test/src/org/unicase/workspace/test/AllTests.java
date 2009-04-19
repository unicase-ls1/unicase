/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.unicase.workspace.test.operationTests.AttributeOperationTest;
import org.unicase.workspace.test.operationTests.CreateDeleteOperationTest;
import org.unicase.workspace.test.operationTests.MultiReferenceMoveOperationTest;
import org.unicase.workspace.test.operationTests.MultiReferenceOperationTest;
import org.unicase.workspace.test.operationTests.SingleReferenceOperationTest;
 
/**
 * Test Suite for running all tests of workspace.
 * @author koegel
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
  AttributeOperationTest.class,
  SingleReferenceOperationTest.class,
  MultiReferenceOperationTest.class,
  CreateDeleteOperationTest.class,
  MultiReferenceMoveOperationTest.class
})
public class AllTests {

}
