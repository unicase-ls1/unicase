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
 * This move an element in a many reference list to another position.
 * 
 * @author zardosht
 */
public class MultiReferenceMoveTest extends IntegrationTestCase {

	private long randomSeed = 1;

	/**
	 * This move an element in a many reference list to another position.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void runTest() throws SerializationException, EmfStoreException {
		System.out.println("MultiReferenceMoveTests");
		final TestHelper testHelper = new TestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = TestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				testHelper.doMultiReferenceMove();
			}
		});

		commitChanges();
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject(), "MultiReferenceMoveTest"));

	}

}
