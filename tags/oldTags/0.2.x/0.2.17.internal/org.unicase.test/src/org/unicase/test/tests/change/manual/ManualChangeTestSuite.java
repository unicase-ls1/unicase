package org.unicase.test.tests.change.manual;

import org.unicase.test.tests.change.ChangeTestSuite;
import org.unicase.test.tests.change.manual.testcases.BidirectionalNonContainmentReference;

public class ManualChangeTestSuite extends ChangeTestSuite {

	

	@Override
	public void initTestCases() {
		BidirectionalNonContainmentReference bidirectionalRefTest = new BidirectionalNonContainmentReference(getTestProjectSpace(), "bidirectional ref", getTestProjectPrams());
		getTestCases().add(bidirectionalRefTest);
	}

	
	
	@Override
	public void endTestSuite() {
		// TODO Auto-generated method stub
	}
	

}
