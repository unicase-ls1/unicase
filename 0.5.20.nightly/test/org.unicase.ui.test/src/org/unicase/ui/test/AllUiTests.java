/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.unicase.ui.test.meeditor.AllMeeditorTests;
import org.unicase.ui.test.navigator.AllNavigatorTests;


@RunWith(Suite.class)
@Suite.SuiteClasses( { AllMeeditorTests.class , AllNavigatorTests.class})
public class AllUiTests {
}
