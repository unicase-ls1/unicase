package org.unicase.ui.test.emfStoreBrowser;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.unicase.ui.test.emfStoreBrowser.CheckoutProjectTest;
import org.unicase.ui.test.navigator.CreateProjectTest;
import org.unicase.ui.test.navigator.DeleteProjectTest;
import org.unicase.ui.test.navigator.ImportProjectTest;


@RunWith(Suite.class)
@Suite.SuiteClasses( { CheckoutProjectTest.class })
public class AllEmfStoreBrowserTests {
}
