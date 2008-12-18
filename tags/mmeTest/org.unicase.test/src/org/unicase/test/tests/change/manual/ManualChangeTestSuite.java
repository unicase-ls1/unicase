package org.unicase.test.tests.change.manual;

import org.unicase.test.tests.change.ChangeTestSuite;
import org.unicase.test.tests.change.manual.testcases.AddSameMEToASingleNonContainmentRef;

public class ManualChangeTestSuite extends ChangeTestSuite {

	

	@Override
	public void initTestCases() {
		//BidirectionalNonContainmentReference bidirectionalRefTest = new BidirectionalNonContainmentReference(getTestProjectSpace(), "bidirectional ref", getTestProjectPrams());
		//getTestCases().add(bidirectionalRefTest);
		
		AddSameMEToASingleNonContainmentRef addSameMETest = new AddSameMEToASingleNonContainmentRef(getTestProjectSpace(), "bidirectional ref", getTestProjectPrams());
		getTestCases().add(addSameMETest);
		
	}

	
	
	@Override
	public void endTestSuite() {
		// TODO Auto-generated method stub
	}
	

}
