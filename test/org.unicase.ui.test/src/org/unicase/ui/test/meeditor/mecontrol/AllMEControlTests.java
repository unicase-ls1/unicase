package org.unicase.ui.test.meeditor.mecontrol;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.unicase.ui.test.meeditor.mecontrol.MERichTextControlTest;


@RunWith(Suite.class)
@Suite.SuiteClasses( { MESingleLinkControlTest.class, MeEnumControlTest.class, MEDateControlTest.class,    MEBoolControlTest.class, MEIntControlTest.class, MERichTextControlTest.class, METextControlTest.class  })
public class AllMEControlTests {
}
