/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.intergerationtest.tests;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
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
public class ContainmentReferenceAddNewTest extends IntegrationTestCase {

	private ModelElement me;
	private EReference refToChange;
	private EObject newInstance;

	/**
	 * Takes a random ME (meA). Takes randomly one of its containment references. Creates a new ME matching containment
	 * reference type (meB). Adds created meB to meA's containment reference.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void runTest() throws SerializationException, EmfStoreException {

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				doAddTest();
			}

		});

		commitChanges();
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject()));

	}

	@SuppressWarnings("unchecked")
	private void doAddTest() {

		// get a random ME and one of its containment references
		me = TestHelper.getRandomME(getTestProject());
		refToChange = TestHelper.getRandomContainmentRef(me);

		// Maybe this ME does not have any containment references. Then choose another one.
		while (refToChange == null) {
			me = TestHelper.getRandomME(getTestProject());
			refToChange = TestHelper.getRandomContainmentRef(me);
		}

		EClass refType = refToChange.getEReferenceType();

		// create a new instance of reference type
		newInstance = TestHelper.createInstance(refType);

		if (newInstance == null) {
			throw new IllegalStateException("could not create a model element of specified type.");
		}

		Object object = me.eGet(refToChange);
		if (refToChange.isMany()) {
			EList<EObject> eList = (EList<EObject>) object;

			if (eList == null) {
				throw new IllegalStateException("Null list return for feature " + refToChange.getName() + " on "
					+ me.getName());

			} else {
				int position = TestHelper.getRandomPosition(eList.size());
				eList.add(position, newInstance);
			}

		} else {
			me.eSet(refToChange, newInstance);
		}

	}

}
