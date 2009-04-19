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
import org.unicase.model.ModelElement;
import org.unicase.model.util.SerializationException;

/**
 * This take a random ME and deletes it.
 * 
 * @author zardosht
 * @author koegel
 */
public class DeleteTest extends IntegrationTestCase {

	private ModelElement me;
	

	
	/**
	 * Delete a random ME.
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void runTest() throws SerializationException, EmfStoreException {

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");

		me = TestHelper.getRandomME(getTestProject());
		

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				me.delete();

			}

		});
		
		commitChanges();
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject()));

	}

	

	
}
