/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.intergerationtest.tests;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.EAttribute;
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
 *
 */
public class MultiAttributeMoveTest extends IntegrationTestCase {

	private ModelElement me;
	private EAttribute attributeToChange;
	private int tries;

	/**
	 * Finds an attribute with isMany = true and moves elements inside this attribute.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 * 
	 */
	@Test
	public void runTest() throws SerializationException, EmfStoreException {
		me = TestHelper.getRandomME(getTestProject());
		attributeToChange = TestHelper.getRandomAttribute(me);

		//since isMany() attributes are seldom, we just try for limited times to find one.
		while (attributeToChange == null || !attributeToChange.isMany()) {
			me = TestHelper.createRandomME();
			attributeToChange = TestHelper.getRandomAttribute(me);
			tries++;
			if (tries > 2000) {
				assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject()));
				return;
			}
		}

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				TestHelper.moveMultiAttributeValue(me, attributeToChange);
			}
		});
		
		commitChanges();
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject()));

	}


}
