/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.intergerationtest.tests;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.Test;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.intergerationtest.TestHelper;
import org.unicase.model.ModelElement;
import org.unicase.model.util.SerializationException;

/**
 * @author zardosht
 */
public class ContainmentReferenceMoveTest extends IntegrationTestCase {

	private ModelElement me;
	private EReference refToChange;
	private ModelElement meToMove;

	/**
	 * Takes a random ME (meA). Takes randomly one of its containment references. Finds an existing ME in project
	 * matching the reference type (meB). Adds meB to this reference of meA (moves meB from its old parent to meA).
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void runTest() throws SerializationException, EmfStoreException {

		while (meToMove == null) {
			// get a random ME and one of its containment references (refToChange)
			me = TestHelper.getRandomME(getTestProject());
			refToChange = TestHelper.getRandomContainmentRef(me);

			// Maybe this ME does not have any containment references. Then choose another one.
			while (refToChange == null) {
				me = TestHelper.getRandomME(getTestProject());
				refToChange = TestHelper.getRandomContainmentRef(me);
			}
			// get a random ME matching refToChange. Also take care that meToMove is not the same as or an ancestor of
			// ME
			meToMove = TestHelper.getRandomMEofType(getTestProject(), refToChange.getEReferenceType());
			if (meToMove != null && (meToMove.equals(me) || EcoreUtil.isAncestor(meToMove, me))) {
				meToMove = null;
			}
		}

		doMove(me, refToChange, meToMove);

		commitChanges();
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject()));

	}

	private void doMove(final ModelElement me, EReference ref, final ModelElement meToMove) {

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				TestHelper.changeReference(me, refToChange, meToMove);
			}
		});
		
	}

}
