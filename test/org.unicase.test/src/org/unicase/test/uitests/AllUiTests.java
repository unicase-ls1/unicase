package org.unicase.test.uitests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { CreateProjectTest.class, DeleteProjectTest.class, CheckoutProjectTest.class,
	EditModelElementDescriptionTest.class, ImportProjectTest.class })
public class AllUiTests {
}
