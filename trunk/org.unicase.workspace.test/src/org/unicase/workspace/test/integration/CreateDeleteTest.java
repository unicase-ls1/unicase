/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.integration;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.Test;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.util.SerializationException;

/**
 * @author Hodaie
 */

public class CreateDeleteTest extends IntegrationTestCase {

	private long randomSeed = 1;

	/**
	 * create a random ME and change one of its attributes.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void createAndChangeAttributeTest() throws SerializationException, EmfStoreException {
		System.out.println("CreateAndChangeAttributeTest");

		final TestHelper testHelper = new TestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = TestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				testHelper.doCreateAndChangeAttribute();

			}

		});

		commitChanges();
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject(), "CreateAndChangeAttributeTest"));

	}
	
	
	/**
	 * Create a random ME and change one of its references.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void createAndChangeRefTest() throws SerializationException, EmfStoreException {
		System.out.println("CreateAndChangeRefTest");

		final TestHelper testHelper = new TestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = TestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				testHelper.doCreateAndChangeRef();

			}

		});

		commitChanges();
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject(), "CreateAndChangeRefTest"));

	}
	
	
	/**
	 * Create a random ME. Change one of its non-containment references. Delete ME.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void createAndDeleteTest() throws SerializationException, EmfStoreException {
		System.out.println("CreateAndDeleteTest");
		final TestHelper testHelper = new TestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = TestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testHelper.doCreateAndDelete();
			}

		});

		commitChanges();
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject(), "CreateAndDeleteTest"));

	}
	
	/**
	 * Delete a random ME. Revert delete.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void deleteAndRevertDeleteTest() throws SerializationException, EmfStoreException {
		System.out.println("DeleteAndRevertDeleteTest");

		final TestHelper testHelper = new TestHelper(randomSeed, getTestProject());
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
	
	
	/**
	 * Delete a random ME.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void deleteTest() throws SerializationException, EmfStoreException {

		System.out.println("DeleteTest");
		final TestHelper testHelper = new TestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = TestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testHelper.doDelete();

			}

		});

		commitChanges();
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject(), "DeleteTest"));

	}



	

}
