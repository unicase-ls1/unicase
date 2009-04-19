/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.intergerationtest.tests;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.Test;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.intergerationtest.TestHelper;
import org.unicase.model.util.SerializationException;

/**
 * @author Hodaie
 */
public class NonContainmentReferenceAddTest extends IntegrationTestCase {

	
	private long randomSeed = 1;

	/**
	 * Select a random ME (meA). Select one of its non-containment references. Find an ME matching reference type (meB).
	 * Add meB to meA.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void runTest() throws SerializationException, EmfStoreException {
		System.out.println("NonContainmentReferenceAddTest");
		final TestHelper testHelper = new TestHelper(randomSeed , getTestProject());
		TransactionalEditingDomain domain = TestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testHelper.doNonContainmentReferenceAdd();
			}

		});

		commitChanges();
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject(), "NonContainmentReferenceAddTest"));
	}

}
