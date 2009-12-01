package org.unicase.ui.test.navigator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.unicase.ui.test.navigator.CheckoutProjectTest;
import org.unicase.ui.test.navigator.CreateProjectTest;
import org.unicase.ui.test.navigator.DeleteProjectTest;
import org.unicase.ui.test.navigator.ImportProjectTest;


@RunWith(Suite.class)
@Suite.SuiteClasses( { CreateProjectTest.class, DeleteProjectTest.class, CheckoutProjectTest.class, ImportProjectTest.class })
public class AllNavigatorTests {
}
