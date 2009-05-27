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
package org.unicase.workspace.test.operations.reversibility;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Hodaie
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	AttributeOperationsReversibilityTest.class,
	ReferenceOperationsReversibilityTest.class,
	CreateDeleteOperationsReversibilityTest.class, 
	})
public class AllOperationReversibilityTests {

}
