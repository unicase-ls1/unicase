/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.meeditor.mecontrol;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.unicase.ui.test.meeditor.mecontrols.melinkcontrol.MEHyperlinkDeleteAdapterTest;
import org.unicase.ui.test.meeditor.mecontrols.melinkcontrol.MEMultiLinkControlTest;
import org.unicase.ui.test.meeditor.mecontrols.melinkcontrol.MESingleLinkControlTest;

/**
 * Suite base class for all the test cases involving MEControl.
 * 
 * @author Nitesh
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( { MEHyperlinkDeleteAdapterTest.class, MEMultiLinkControlTest.class, MESingleLinkControlTest.class,
	MeEnumControlTest.class, MEBoolControlTest.class, MEIntControlTest.class, MERichTextControlTest.class,
	METextControlTest.class, MEDateControlTest.class, MEDescriptionPageTest.class, MERichTextChangeRecordingTest.class,
	MEEditorListenerDetachedTest.class })
public class AllMEControlTests {
}
