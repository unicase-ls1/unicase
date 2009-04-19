/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.intergerationtest.tests;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.Test;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.intergerationtest.TestHelper;
import org.unicase.model.ModelElement;
import org.unicase.model.util.SerializationException;

/**
 *  
 * @author Hodaie
 */
public class CreateAndDeleteTest extends IntegrationTestCase {

	private ModelElement me;
	private EReference refToChange;
	private ModelElement meToReference;

	
	/**
	 * Create a random ME. Change one of its non-containment references. Delete ME.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 * 
	 */
	@Test
	public void runTest() throws SerializationException, EmfStoreException {
		
	
		while (meToReference == null) {
			me = TestHelper.createRandomME();
			refToChange = TestHelper.getRandomNonContainmentRef(me);
			while (refToChange == null) {
				me = TestHelper.createRandomME();
				refToChange = TestHelper.getRandomNonContainmentRef(me);
			}
			meToReference = TestHelper.getRandomMEofType(getTestProject(), refToChange.getEReferenceType());
		}
		
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				getTestProject().getModelElements().add(me);
				TestHelper.changeReference(me, refToChange, meToReference);
				me.delete();
			}

		});
		
		commitChanges();
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject()));

	}

	
}
