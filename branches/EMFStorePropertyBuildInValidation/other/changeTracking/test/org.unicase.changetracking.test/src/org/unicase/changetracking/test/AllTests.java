package org.unicase.changetracking.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.unicase.changetracking.test.cases.CloneTest;
import org.unicase.changetracking.test.cases.PushTest;
import org.unicase.changetracking.test.cases.SelectivePullTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        CloneTest.class,
        PushTest.class,
        SelectivePullTest.class
})
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$

		//$JUnit-END$
		return suite;
	}

}
