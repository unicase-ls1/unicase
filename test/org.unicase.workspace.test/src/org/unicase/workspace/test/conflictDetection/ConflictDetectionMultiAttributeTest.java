/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.conflictDetection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation;
import org.unicase.workspace.test.testmodel.TestElement;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Conflicttests for MultiAttribute, -Set and -Move operations.
 * 
 * @author wesendon
 */
public class ConflictDetectionMultiAttributeTest extends ConflictDetectionTest {

	private TestElement getFilledTestElement(int count) {
		TestElement testElement = getTestElement();
		for (int i = 0; i < count; i++) {
			testElement.getStrings().add("value" + i);
		}
		return testElement;
	}

	private AbstractOperation checkAndGetOperation(Class<MultiAttributeOperation> clazz) {
		assertEquals(getProjectSpace().getOperations().size(), 1);
		assertTrue(clazz.isInstance(getProjectSpace().getOperations().get(0)));
		AbstractOperation operation = getProjectSpace().getOperations().get(0);
		clearOperations();
		assertEquals(getProjectSpace().getOperations().size(), 0);
		return operation;
	}

	private boolean doConflict(AbstractOperation removeOp, AbstractOperation addOp) {
		return getConflictDetectionStrategy().doConflict(addOp, removeOp);
	}

	/**
	 * Remove vs add.
	 */
	@Test
	public void multiAttRemoveVsAdd() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getFilledTestElement(3);
				clearOperations();

				testElement.getStrings().remove(0);
				AbstractOperation removeOp = checkAndGetOperation(MultiAttributeOperation.class);

				testElement.getStrings().add(1, "inserted");
				AbstractOperation addOp = checkAndGetOperation(MultiAttributeOperation.class);

				assertEquals(doConflict(removeOp, addOp), true);
				assertEquals(doConflict(addOp, removeOp), true);
			}
		}.run(false);
	}

	/**
	 * Add vs add.
	 */
	@Test
	public void multiAttAddVsAdd() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getFilledTestElement(3);
				clearOperations();

				testElement.getStrings().add(0, "inserted1");
				AbstractOperation add1 = checkAndGetOperation(MultiAttributeOperation.class);

				testElement.getStrings().add(1, "inserted2");
				AbstractOperation add2 = checkAndGetOperation(MultiAttributeOperation.class);

				assertEquals(doConflict(add1, add2), true);
				assertEquals(doConflict(add2, add1), true);
			}
		}.run(false);
	}

	/**
	 * remove vs remove.
	 */
	@Test
	public void multiAttRemoveVsRemove() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getFilledTestElement(3);
				clearOperations();

				testElement.getStrings().remove(2);
				AbstractOperation remove1 = checkAndGetOperation(MultiAttributeOperation.class);

				testElement.getStrings().remove(1);
				AbstractOperation remove2 = checkAndGetOperation(MultiAttributeOperation.class);

				assertEquals(doConflict(remove1, remove2), true);
				assertEquals(doConflict(remove2, remove1), true);
			}
		}.run(false);
	}
}
