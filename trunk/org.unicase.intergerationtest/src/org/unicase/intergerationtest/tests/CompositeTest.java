/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.intergerationtest.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.Test;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.intergerationtest.TestHelper;
import org.unicase.model.util.SerializationException;

/**
 * Runs a random set of operations.
 * 
 * @author hodaie
 */
public class CompositeTest extends IntegrationTestCase {

	private long randomSeed = 1;
	private int numOfTests = 13;

	private boolean testAll;
	private int maxTimesToRunATestCase = 3;
	private int randomSelectIterations = 10;
	private int testAllIterations = 10;

	private TestHelper testHelper;

	/**
	 * Runs a random set of operations.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void runTest() throws SerializationException, EmfStoreException {
		System.out.println("CompositeTest");

		TransactionalEditingDomain domain = TestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				doTest();

			}

		});

		commitChanges();
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject(), "CompositeTest"));

	}

	private void doTest() {
		testHelper = new TestHelper(randomSeed, getTestProject());

		if (testAll) {

			for (int i = 0; i < testAllIterations; i++) {
				testAll();
			}

		} else {

			for (int i = 0; i < randomSelectIterations; i++) {
				randomSelectTest();
			}

		}
	}

	private void randomSelectTest() {
		List<Integer> testsToRun = new ArrayList<Integer>();
		for (int i = 0; i < numOfTests; i++) {
			testsToRun.add(new Integer(i));
		}

		Integer testToRun = testHelper.getRandomPosition(testsToRun.size());

		int timesToRun = testHelper.getRandomPosition(maxTimesToRunATestCase);
		// make sure the test runs at least once
		if (timesToRun == 0) {
			timesToRun += 1;
		}

		runTestCase(testToRun, timesToRun);

	}

	private void testAll() {
		List<Integer> testsToRun = new ArrayList<Integer>();
		for (int i = 0; i < numOfTests; i++) {
			testsToRun.add(new Integer(i));
		}

		for (int j = 0; j < numOfTests; j++) {
			Integer testToRun = testHelper.getRandomPosition(testsToRun.size());
			int timesToRun = testHelper.getRandomPosition(maxTimesToRunATestCase);
			// make sure the test runs at least once
			if (timesToRun == 0) {
				timesToRun += 1;
			}
			runTestCase(testToRun, timesToRun);
			testsToRun.remove(testToRun);
		}

	}

	private void runTestCase(Integer testToRun, int timesToRun) {

		for (int i = 0; i < timesToRun; i++) {
			switch (testToRun.intValue()) {
			case 0:
				// Delete test
				testHelper.doDelete();
				break;

			case 1:
				// CreateAndDelete test
				testHelper.doCreateAndDelete();
				break;

			case 2:
				// MultiReferenceMove
				testHelper.doMultiReferenceMove();
				break;

			case 3:
				// ContainmentReferenceMove
				testHelper.doContainmentReferenceMove();
				break;

			case 4:
				// NonContainmentReferenceRemove
				testHelper.doNonContainmentReferenceRemove();
				break;

			case 5:
				// AttributeTransitiveChange
				testHelper.doAttributeTransitiveChange();
				break;

			case 6:
				// MultiAttributeMove
				testHelper.doMultiAttributeMove();
				break;

			case 7:
				// AttributeChange
				testHelper.doChangeAttribute();
				break;

			case 8:
				// DeleteAndRevertDelete
				testHelper.doDeleteAndRevert();
				break;

			case 9:
				// CreateAndChangeRef
				testHelper.doCreateAndChangeRef();
				break;

			case 10:
				// CreateAndChangeAttribute
				testHelper.doCreateAndChangeAttribute();
				break;

			case 11:
				// NonContainmentReferenceAdd
				testHelper.doNonContainmentReferenceAdd();
				break;

			case 12:
				// ContainmentReferenceAddNew
				testHelper.doContainemntReferenceAddNew();
				break;

			default:
				break;

			}
		}

	}

	/**
	 * @param testAll the testAll to set
	 */
	public void setTestAll(boolean testAll) {
		this.testAll = testAll;
	}

	/**
	 * @return the testAll
	 */
	public boolean isTestAll() {
		return testAll;
	}

	/**
	 * @param testAllIterations the testAllIterations to set
	 */
	public void setTestAllIterations(int testAllIterations) {
		this.testAllIterations = testAllIterations;
	}

	/**
	 * @return the testAllIterations
	 */
	public int getTestAllIterations() {
		return testAllIterations;
	}

	/**
	 * @param randomSelectIterations the randomSelectIterations to set
	 */
	public void setRandomSelectIterations(int randomSelectIterations) {
		this.randomSelectIterations = randomSelectIterations;
	}

	/**
	 * @return the randomSelectIterations
	 */
	public int getRandomSelectIterations() {
		return randomSelectIterations;
	}

	/**
	 * @param maxTimesToRunATestCase the maxTimesToRunATestCase to set
	 */
	public void setMaxTimesToRunATestCase(int maxTimesToRunATestCase) {
		this.maxTimesToRunATestCase = maxTimesToRunATestCase;
	}

	/**
	 * @return the maxTimesToRunATestCase
	 */
	public int getMaxTimesToRunATestCase() {
		return maxTimesToRunATestCase;
	}

}
