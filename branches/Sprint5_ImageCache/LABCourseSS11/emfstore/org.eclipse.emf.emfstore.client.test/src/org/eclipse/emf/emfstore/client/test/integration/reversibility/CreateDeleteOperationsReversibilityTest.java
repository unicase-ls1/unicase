/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.test.integration.reversibility;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.emfstore.client.test.integration.forward.IntegrationTestHelper;
import org.eclipse.emf.emfstore.common.model.util.SerializationException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.Test;

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
	public void createAndChangeAttributeReversibilityTest() throws SerializationException, EmfStoreException {
		System.out.println("CreateAndChangeAttributeReversibilityTest");

		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				testHelper.doCreateAndChangeAttribute();
				getTestProjectSpace().revert();
			}

		});

		assertTrue(IntegrationTestHelper.areEqual(getTestProject(), getCompareProject(),
			"CreateAndChangeAttributeReversibilityTest"));

	}

	/**
	 * Create a random ME and change one of its attributes, then changes one of its references, then changes one of its
	 * attributes, and again changes one of its references.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void createAndMultipleChangeReversibilityTest() throws SerializationException, EmfStoreException {
		System.out.println("CreateAndMultipleChangeReversibilityTest");

		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				testHelper.doCreateAndMultipleChange();
				getTestProjectSpace().revert();
			}

		});

		assertTrue(IntegrationTestHelper.areEqual(getTestProject(), getCompareProject(),
			"CreateAndMultipleChangeReversibilityTest"));

	}

	/**
	 * Create a random ME and change one of its references.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void createAndChangeRefReversibilityTest() throws SerializationException, EmfStoreException {
		System.out.println("CreateAndChangeRefReversibilityTest");

		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				testHelper.doCreateAndChangeRef();
				getTestProjectSpace().revert();
			}

		});

		assertTrue(IntegrationTestHelper.areEqual(getTestProject(), getCompareProject(),
			"CreateAndChangeRefReversibilityTest"));

	}

	/**
	 * Create a random ME. Change one of its non-containment references. Delete ME.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void createChangeRefDeleteReversibilityTest() throws SerializationException, EmfStoreException {
		System.out.println("CreateChangeRefDeleteReversibilityTest");
		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testHelper.doCreateChangeRefDelete();
				getTestProjectSpace().revert();
			}

		});

		assertTrue(IntegrationTestHelper.areEqual(getTestProject(), getCompareProject(),
			"CreateChangeRefDeleteReversibilityTest"));

	}

	/**
	 * Create a random ME. Delete ME.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void createDeleteReversibilityTest() throws SerializationException, EmfStoreException {
		System.out.println("CreateDeleteReversibilityTest");
		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testHelper.doCreateDelete();
				getTestProjectSpace().revert();
			}

		});

		assertTrue(IntegrationTestHelper.areEqual(getTestProject(), getCompareProject(),
			"CreateDeleteReversibilityTest"));

	}

	/**
	 * Delete a random ME. Revert delete.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void deleteAndRevertDeleteReversibilityTest() throws SerializationException, EmfStoreException {
		System.out.println("DeleteAndRevertDeleteReversibilityTest");

		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				testHelper.doDeleteAndRevert();
				getTestProjectSpace().revert();
			}
		});

		assertTrue(IntegrationTestHelper.areEqual(getTestProject(), getCompareProject(),
			"DeleteAndRevertDeleteReversibilityTest"));
	}

	/**
	 * Delete a random ME.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void deleteReversibilityTest() throws SerializationException, EmfStoreException {

		System.out.println("DeleteReversibilityTest");
		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testHelper.doDelete();
				getTestProjectSpace().revert();
			}

		});

		assertTrue(IntegrationTestHelper.areEqual(getTestProject(), getCompareProject(), "DeleteReversibilityTest"));

	}

}
