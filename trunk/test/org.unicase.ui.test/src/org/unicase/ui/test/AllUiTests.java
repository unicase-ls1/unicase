package org.unicase.ui.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.unicase.ui.test.meeditor.AllMeeditorTests;
import org.unicase.ui.test.navigator.AllNavigatorTests;


@RunWith(Suite.class)
@Suite.SuiteClasses( { AllNavigatorTests.class, AllMeeditorTests.class })
public class AllUiTests {
}
