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

		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getSetupHelper().getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				testHelper.doCreateAndChangeAttribute();

			}

		});

		getSetupHelper().commitChanges();
		assertTrue(IntegrationTestHelper.areEqual(getSetupHelper().getTestProject(), getSetupHelper().getCompareProject(), "CreateAndChangeAttributeTest"));

	}

	/**
	 * Create a random ME and change one of its attributes, then changes one of its references, then changes one of its
	 * attributes, and again changes one of its references.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void createAndMultipleChangeTest() throws SerializationException, EmfStoreException {
		System.out.println("CreateAndMultipleChangeTest");

		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getSetupHelper().getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				testHelper.doCreateAndMultipleChange();

			}

		});

		getSetupHelper().commitChanges();
		assertTrue(IntegrationTestHelper.areEqual(getSetupHelper().getTestProject(), getSetupHelper().getCompareProject(), "CreateAndMultipleChangeTest"));

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

		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getSetupHelper().getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				testHelper.doCreateAndChangeRef();

			}

		});

		getSetupHelper().commitChanges();
		assertTrue(IntegrationTestHelper.areEqual(getSetupHelper().getTestProject(), getSetupHelper().getCompareProject(), "CreateAndChangeRefTest"));

	}

	/**
	 * Create a random ME. Change one of its non-containment references. Delete ME.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void createChangeRefDeleteTest() throws SerializationException, EmfStoreException {
		System.out.println("CreateChangeRefDeleteTest");
		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getSetupHelper().getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testHelper.doCreateChangeRefDelete();
			}

		});

		getSetupHelper().commitChanges();
		assertTrue(IntegrationTestHelper.areEqual(getSetupHelper().getTestProject(), getSetupHelper().getCompareProject(), "CreateChangeRefDeleteTest"));

	}

	/**
	 * Create a random ME. Delete ME.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void createDeleteTest() throws SerializationException, EmfStoreException {
		System.out.println("CreateDeleteTest");
		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getSetupHelper().getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testHelper.doCreateDelete();
			}

		});

		getSetupHelper().commitChanges();
		assertTrue(IntegrationTestHelper.areEqual(getSetupHelper().getTestProject(), getSetupHelper().getCompareProject(), "CreateDeleteTest"));

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

		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getSetupHelper().getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				testHelper.doDeleteAndRevert();
			}
		});

		getSetupHelper().commitChanges();
		assertTrue(IntegrationTestHelper.areEqual(getSetupHelper().getTestProject(), getSetupHelper().getCompareProject(), "DeleteAndRevertDeleteTest"));
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
		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getSetupHelper().getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testHelper.doDelete();

			}

		});

		getSetupHelper().commitChanges();
		assertTrue(IntegrationTestHelper.areEqual(getSetupHelper().getTestProject(), getSetupHelper().getCompareProject(), "DeleteTest"));

	}

}
