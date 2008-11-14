package org.unicase.test.tests.changetests.randomchange;

import org.unicase.test.tests.changetests.ChangeTestCase;

public class RandomChangeTestCase extends ChangeTestCase {

	private boolean isCompareTest;
	private boolean isChangePackageTest;
	
	public RandomChangeTestCase(String testName, long randomSeed) {
		super(testName, randomSeed);
		
	}

	public void setCompareTest(boolean isCompareTest) {
		this.isCompareTest = isCompareTest;
	}

	public boolean isCompareTest() {
		return isCompareTest;
	}

	public void setChangePackageTest(boolean isChangePackageTest) {
		this.isChangePackageTest = isChangePackageTest;
	}

	public boolean isChangePackageTest() {
		return isChangePackageTest;
	}
	
	

	
}
