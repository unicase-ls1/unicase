/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.operations.reversibility;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.Test;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.util.SerializationException;
import org.unicase.workspace.test.integration.IntegrationTestHelper;

/**
 * @author Hodaie
 */

public class CreateDeleteOperationsReversibilityTest extends OperationsReversibilityTest {

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

		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				testHelper.doCreateAndChangeAttribute();
				getTestProjectSpace().revert();
			}

		});

		
		assertTrue(IntegrationTestHelper.areEqual(getTestProject(), getCompareProject(), "CreateAndChangeAttributeTest"));

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

		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				testHelper.doCreateAndMultipleChange();
				getTestProjectSpace().revert();
			}

		});

		
		assertTrue(IntegrationTestHelper.areEqual(getTestProject(), getCompareProject(), "CreateAndMultipleChangeTest"));

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

		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				testHelper.doCreateAndChangeRef();
				getTestProjectSpace().revert();
			}

		});

		
		assertTrue(IntegrationTestHelper.areEqual(getTestProject(), getCompareProject(), "CreateAndChangeRefTest"));

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
		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testHelper.doCreateChangeRefDelete();
				getTestProjectSpace().revert();
			}

		});

	
		assertTrue(IntegrationTestHelper.areEqual(getTestProject(), getCompareProject(), "CreateChangeRefDeleteTest"));

	}

	/**
	 * Create a random ME. Delete ME.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void createDeleteTest() throws SerializationException, EmfStoreException {
		System.out.println("CreateDeleteOperationsReversibilityTest");
		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testHelper.doCreateDelete();
				getTestProjectSpace().revert();
			}

		});

		
		assertTrue(IntegrationTestHelper.areEqual(getTestProject(), getCompareProject(), "CreateDeleteOperationsReversibilityTest"));

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

		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				testHelper.doDeleteAndRevert();
				getTestProjectSpace().revert();
			}
		});

		
		assertTrue(IntegrationTestHelper.areEqual(getTestProject(), getCompareProject(), "DeleteAndRevertDeleteTest"));
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
		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testHelper.doDelete();
				getTestProjectSpace().revert();
			}

		});

		
		assertTrue(IntegrationTestHelper.areEqual(getTestProject(), getCompareProject(), "DeleteTest"));

	}

}
