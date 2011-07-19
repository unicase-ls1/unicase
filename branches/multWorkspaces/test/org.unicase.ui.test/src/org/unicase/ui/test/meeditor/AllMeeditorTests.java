/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.meeditor;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.unicase.ui.test.meeditor.mecontrol.AllMEControlTests;
import org.unicase.ui.test.meeditor.mecontrols.melinkcontrol.AllMELinkControlTests;
import org.unicase.ui.test.model.attachment.AllMEAttachmentsTests;
import org.unicase.ui.test.unicasecommon.meeditor.mecontrols.uccontrol.AllUseCaseStepsTests;

/**
 * Suite class for all the test cases for MEEditor.
 * 
 * @author Nitesh
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( { AllMEControlTests.class, AllMELinkControlTests.class, AllMEAttachmentsTests.class,
	AllUseCaseStepsTests.class })
public class AllMeeditorTests {
}
