/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.intergerationtest.tests;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.Test;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.intergerationtest.TestHelper;
import org.unicase.model.ModelElement;
import org.unicase.model.util.SerializationException;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Hodaie
 *
 */
public class NonContainmentReferenceRemoveTest  extends IntegrationTestCase {

	private ModelElement me;
	private ModelElement meToRemove;
	private EReference refToChange;

	
/**
 * Removes a referenced model element form a non-containment reference of a randomly selected ME.
 * @throws EmfStoreException EmfStoreException
 * @throws SerializationException SerializationException
 */
	@Test
	public void runTest() throws SerializationException, EmfStoreException {
		System.out.println("NonContainmentReferenceRemoveTest");
		
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				doRemoveNonContainmentRef();
			}
		});
		
		commitChanges();
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject(), "NonContainmentReferenceRemoveTest"));

	}

	@SuppressWarnings("unchecked")
	private void doRemoveNonContainmentRef() {
		me = TestHelper.getRandomME(getTestProject());

		while (me.eCrossReferences().size() < 1) {
			me = TestHelper.getRandomME(getTestProject());
		}

	
		int indexToRemove = TestHelper.getRandomPosition(me.eCrossReferences().size());
		meToRemove = (ModelElement) me.eCrossReferences().get(indexToRemove);

		refToChange = findReference(me, meToRemove);

		Object object = me.eGet(refToChange);
		if (refToChange.isMany()) {
			EList<EObject> eList = (EList<EObject>) object;
			eList.remove(meToRemove);
		} else {
			me.eSet(refToChange, null);
		}

	}

	@SuppressWarnings("unchecked")
	private EReference findReference(ModelElement modelElement, ModelElement referencedME) {

		List<EReference> refsMatchingReferencedME = new ArrayList<EReference>();
		for (EReference ref : modelElement.eClass().getEAllReferences()) {
			if (!(ref.isContainer() || ref.isContainment())
				&& (ref.getEReferenceType().equals(referencedME.eClass()) || ref.getEReferenceType().isSuperTypeOf(
					referencedME.eClass()))) {
				refsMatchingReferencedME.add(ref);
			}
		}

		if (refsMatchingReferencedME.size() == 1) {
			return refsMatchingReferencedME.get(0);
		}

		for (EReference ref : refsMatchingReferencedME) {
			Object object = me.eGet(ref);
			if (object == null) {
				continue;
			}
			if (ref.isMany()) {
				EList<EObject> eList = (EList<EObject>) object;
				if (eList.contains(referencedME)) {
					return ref;
				}
			} else {
				if (me.eGet(ref).equals(referencedME)) {
					return ref;
				}
			}
		}

		return null;

	}


}
