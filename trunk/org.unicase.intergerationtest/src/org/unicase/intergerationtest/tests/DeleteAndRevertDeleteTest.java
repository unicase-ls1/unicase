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
import org.unicase.workspace.exceptions.NoLocalChangesException;

/**
 * 
 * @author Hodaie
 *
 */
public class DeleteAndRevertDeleteTest extends IntegrationTestCase  {

	

	private long randomSeed = 1;

	/**
	 * Delete a random ME. Revert delete.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 * 
	 */
	@Test (expected = NoLocalChangesException.class)
	public void runTest() throws SerializationException, EmfStoreException {
		System.out.println("DeleteAndRevertDeleteTest");
	
		final TestHelper testHelper = new TestHelper(randomSeed , getTestProject());
		TransactionalEditingDomain domain = TestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				testHelper.doDeleteAndRevert();
			}
		});
		
		commitChanges();
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject(), "DeleteAndRevertDeleteTest"));
	}

	

}
