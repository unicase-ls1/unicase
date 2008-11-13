package org.unicase.test.tests.changetests.randomchange.testcases;

import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;

/**
 * 
 * This is a change package test. 
 * It creates randomly a ME A, changes one of its non-containment references.
 * The expected change package should contain two operations
 *   - a create operation: created A
 *   - a change operation: either A.ref changed to B or B.oppositeRef changed to A
 * 
 * @author Hodaie
 *
 */
public class CreateAndChangeRefTest extends RandomChangeTestCase {

	public CreateAndChangeRefTest(String testName, long randomSeed) {
		super(testName, randomSeed);
	
	}

	@Override
	public void runTest() {
		
	}

	
}
