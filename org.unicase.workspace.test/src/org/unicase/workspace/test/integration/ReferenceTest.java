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
public class ReferenceTest extends IntegrationTestCase {

	private long randomSeed = 1;

	/**
	 * Takes a random ME (meA). Takes randomly one of its containment references. Creates a new ME matching containment
	 * reference type (meB). Adds created meB to meA's containment reference.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void containmentReferenceAddNewTest() throws SerializationException, EmfStoreException {
		System.out.println("ContainmentReferenceAddNewTest");

		final TestHelper testHelper = new TestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = TestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testHelper.doContainemntReferenceAddNew();
			}

		});

		commitChanges();
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject(), "ContainmentReferenceAddNewTest"));

	}
	
	
	/**
	 * Takes a random ME (meA). Takes randomly one of its containment references. Creates a new ME matching containment
	 * reference type (meB). Adds created meB to meA's containment reference.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void containmentRefTransitiveChange() throws SerializationException, EmfStoreException {
		System.out.println("ContainmentRefTransitiveChange");

		final TestHelper testHelper = new TestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = TestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testHelper.doContainmentRefTransitiveChange();
			}

		});

		commitChanges();
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject(), "ContainmentRefTransitiveChange"));

	}
	
	
	/**
	 * This move an element in a many reference list to another position.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void multiReferenceMoveTests() throws SerializationException, EmfStoreException {
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
	
	/**
	 * Select a random ME (meA). Select one of its non-containment references. Find an ME matching reference type (meB).
	 * Add meB to meA.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void nonContainmentReferenceAddTest() throws SerializationException, EmfStoreException {
		System.out.println("NonContainmentReferenceAddTest");
		final TestHelper testHelper = new TestHelper(randomSeed, getTestProject());
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

	/**
	 * Removes a referenced model element form a non-containment reference of a randomly selected ME.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void nonContainmentReferenceRemoveTest() throws SerializationException, EmfStoreException {
		System.out.println("NonContainmentReferenceRemoveTest");

		final TestHelper testHelper = new TestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = TestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testHelper.doNonContainmentReferenceRemove();
			}
		});

		commitChanges();
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject(), "NonContainmentReferenceRemoveTest"));

	}
	
	/**
	 * Takes a random ME (meA). Takes randomly one of its containment references. Finds an existing ME in project
	 * matching the reference type (meB). Adds meB to this reference of meA (moves meB from its old parent to meA).
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void containmentReferenceMoveTest() throws SerializationException, EmfStoreException {
		System.out.println("ContainmentReferenceMoveTest");
		final TestHelper testHelper = new TestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = TestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testHelper.doContainmentReferenceMove();
			}
		});

		commitChanges();
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject(), "ContainmentReferenceMoveTest"));

	}


}
