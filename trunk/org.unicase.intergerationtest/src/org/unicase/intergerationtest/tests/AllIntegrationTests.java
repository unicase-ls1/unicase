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

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Hodaie
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	AttributeChangeTest.class,
	AttributeTransitiveChangeTest.class, 
	ContainmentReferenceAddNewTest.class,
	ContainmentReferenceMoveTest.class,
	CreateAndChangeAttributeTest.class,
	CreateAndChangeRefTest.class,
	CreateAndDeleteTest.class, 
	DeleteAndRevertDeleteTest.class,
	DeleteTest.class,
	MultiAttributeMoveTest.class,
	MultiReferenceMoveTest.class,
	NonContainmentReferenceAddTest.class,
	NonContainmentReferenceRemoveTest.class
})
public class AllIntegrationTests {

}
