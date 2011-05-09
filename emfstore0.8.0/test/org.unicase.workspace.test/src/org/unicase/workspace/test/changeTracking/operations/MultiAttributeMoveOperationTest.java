/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.changeTracking.operations;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation;
import org.junit.Test;
import org.unicase.workspace.test.WorkspaceTest;
import org.unicase.workspace.test.testmodel.TestElement;

/**
 * Tests for multiattributemove operations.
 * 
 * @author wesendon
 */
public class MultiAttributeMoveOperationTest extends WorkspaceTest {

	/**
	 * Simple move element.
	 */
	@Test
	public void moveTest() {
		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();
				testElement.getStrings().add("first");
				testElement.getStrings().add("second");
				testElement.getStrings().add("third");

				getProjectSpace().getOperations().clear();

				testElement.getStrings().move(0, 2);

				assertTrue(testElement.getStrings().get(0).equals("third"));
				assertTrue(testElement.getStrings().get(1).equals("first"));
				assertTrue(testElement.getStrings().get(2).equals("second"));
			}
		}.run(false);
	}

	/**
	 * Move and validate operation.
	 */
	@Test
	public void moveAndOperationTest() {
		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();
				testElement.getStrings().add("first");
				testElement.getStrings().add("second");

				getProjectSpace().getOperations().clear();

				testElement.getStrings().move(0, 1);

				assertTrue(testElement.getStrings().get(0).equals("second"));
				assertTrue(testElement.getStrings().get(1).equals("first"));
				assertTrue(getProjectSpace().getOperations().size() == 1);
				AbstractOperation tmp = getProjectSpace().getOperations().get(0);
				assertTrue(tmp instanceof MultiAttributeMoveOperation);
				MultiAttributeMoveOperation operation = (MultiAttributeMoveOperation) tmp;
				assertTrue(operation.getNewIndex() == 0);
				assertTrue(operation.getOldIndex() == 1);
				assertTrue(operation.getReferencedValue().equals("second"));
			}
		}.run(false);
	}

	/**
	 * Move and reverse.
	 */
	@Test
	public void moveAndReverseTest() {
		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();
				testElement.getStrings().add("first");
				testElement.getStrings().add("second");
				getProjectSpace().getOperations().clear();

				assertTrue(testElement.getStrings().size() == 2);
				assertTrue(testElement.getStrings().get(0).equals("first"));
				assertTrue(testElement.getStrings().get(1).equals("second"));

				testElement.getStrings().move(0, 1);
				assertTrue(testElement.getStrings().size() == 2);
				assertTrue(testElement.getStrings().get(0).equals("second"));
				assertTrue(testElement.getStrings().get(1).equals("first"));

				AbstractOperation operation = getProjectSpace().getOperations().get(0).reverse();
				operation.apply(getProject());
				assertTrue(testElement.getStrings().size() == 2);
				assertTrue(testElement.getStrings().get(0).equals("first"));
				assertTrue(testElement.getStrings().get(1).equals("second"));
			}
		}.run(false);
	}
}
