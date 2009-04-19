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
import org.unicase.workspace.exceptions.NoLocalChangesException;

/**
 * This move an element in a many reference list to another position.
 * 
 * @author zardosht
 */
public class MultiReferenceMoveTest  extends IntegrationTestCase {

	private ModelElement me;
	private EReference refToChange;

	

	/**
	 * This move an element in a many reference list to another position.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 * 
	 */
	@Test (expected = NoLocalChangesException.class)
	public void runTest() throws SerializationException, EmfStoreException {
		System.out.println("MultiReferenceMoveTests");
		
		me = TestHelper.getRandomME(getTestProject());
		refToChange = TestHelper.getRandomReference(me);

		while (refToChange == null || !refToChange.isMany()) {
			me = TestHelper.createRandomME();
			refToChange = TestHelper.getRandomReference(me);
		}

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				TestHelper.moveMultiReferenceValue(me, refToChange);
			}
		});
		
		commitChanges();
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject(), "MultiReferenceMoveTest"));

	}

	

}
