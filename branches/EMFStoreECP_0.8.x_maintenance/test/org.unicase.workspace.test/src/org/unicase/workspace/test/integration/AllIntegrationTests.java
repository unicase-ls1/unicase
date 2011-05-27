/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.integration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.unicase.workspace.test.integration.forward.AllForwardIntegrationTests;
import org.unicase.workspace.test.integration.reversibility.AllReversibilityIntegrationTests;

/**
 * @author Hodaie
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( { AllForwardIntegrationTests.class, AllReversibilityIntegrationTests.class })
public class AllIntegrationTests {

}
