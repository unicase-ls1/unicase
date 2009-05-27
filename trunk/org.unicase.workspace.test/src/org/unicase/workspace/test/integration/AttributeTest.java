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
public class AttributeTest extends IntegrationTestCase {

	private long randomSeed = 1;

	/**
	 * Finds an attribute with isMany = true and moves elements inside this attribute.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void multiAttributeMoveTest() throws SerializationException, EmfStoreException {
		System.out.println("MultiAttributeMoveTest");

		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getSetupHelper().getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				testHelper.doMultiAttributeMove();
			}
		});

		getSetupHelper().commitChanges();
		assertTrue(IntegrationTestHelper.areEqual(getSetupHelper().getTestProject(), getSetupHelper().getCompareProject(), "MultiAttributeMoveTest"));

	}
	
	/**
	 * 1. Get a random model element form test project; 2. get randomly one of its attributes. 3. change the attribute
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void attributeChangeTest() throws SerializationException, EmfStoreException {
		System.out.println("AttributeChangeTest");

		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getSetupHelper().getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testHelper.doChangeAttribute();
			}

		});

		getSetupHelper().commitChanges();

		assertTrue(IntegrationTestHelper.areEqual(getSetupHelper().getTestProject(), getSetupHelper().getCompareProject(), "AttributeChangeTest"));

	}
	
	
	/**
	 * Change the same attribute on a randomly selected ME twice.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void attributeTransitiveChangeTest() throws SerializationException, EmfStoreException {
		System.out.println("AttributeTransitiveChangeTest");
		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getSetupHelper().getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testHelper.doAttributeTransitiveChange();

			}

		});

		getSetupHelper().commitChanges();
		assertTrue(IntegrationTestHelper.areEqual(getSetupHelper().getTestProject(), getSetupHelper().getCompareProject(), "AttributeTransitiveChangeTest"));

	}


}
