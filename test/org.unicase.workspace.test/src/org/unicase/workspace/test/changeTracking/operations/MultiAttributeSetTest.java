/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.changeTracking.operations;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeSetOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.workspace.test.WorkspaceTest;
import org.unicase.workspace.test.testmodel.TestElement;
import org.unicase.workspace.util.UnicaseCommand;

public class MultiAttributeSetTest extends WorkspaceTest {

	@Test
	public void setValueToEmptyTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement element = getTestElement();
				element.getStrings().add("oldValue");
				clearOperations();

				assertTrue(element.getStrings().size() == 1);

				element.getStrings().set(0, "settedValue");

				assertTrue(element.getStrings().size() == 1);
				assertTrue(element.getStrings().get(0).equals("settedValue"));

				assertTrue(getProjectSpace().getOperations().size() == 1);
				assertTrue(getProjectSpace().getOperations().get(0) instanceof MultiAttributeSetOperation);
			}
		}.run(false);
	}

	@Test
	public void applyValueToEmptyTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();
				testElement.getStrings().add("oldValue");
				assertTrue(testElement.getStrings().size() == 1);

				MultiAttributeSetOperation operation = OperationsFactory.eINSTANCE.createMultiAttributeSetOperation();
				operation.setFeatureName("strings");
				operation.setIndex(0);
				operation.setNewValue("inserted");
				operation.setOldValue("oldValue");
				operation.setModelElementId(testElement.getModelElementId());

				operation.apply(getProject());

				assertTrue(testElement.getStrings().size() == 1);
				assertTrue(testElement.getStrings().get(0).equals("inserted"));
			}
		}.run(false);
	}

	@Test
	public void applyValueToEmptyWrongIndexTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();
				testElement.getStrings().add("oldValue");
				assertTrue(testElement.getStrings().size() == 1);

				MultiAttributeSetOperation operation = OperationsFactory.eINSTANCE.createMultiAttributeSetOperation();
				operation.setFeatureName("strings");
				operation.setIndex(42);
				operation.setNewValue("inserted");
				operation.setOldValue("oldValue");
				operation.setModelElementId(testElement.getModelElementId());

				operation.apply(getProject());

				assertTrue(testElement.getStrings().size() == 1);
				assertTrue(testElement.getStrings().get(0).equals("oldValue"));
			}
		}.run(false);
	}

	@Test
	public void applyValueToFilledTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();
				testElement.getStrings().addAll(Arrays.asList("first", "second", "third"));
				assertTrue(testElement.getStrings().size() == 3);

				MultiAttributeSetOperation operation = OperationsFactory.eINSTANCE.createMultiAttributeSetOperation();
				operation.setFeatureName("strings");
				operation.setIndex(1);
				operation.setNewValue("inserted");
				operation.setOldValue("second");
				operation.setModelElementId(testElement.getModelElementId());

				operation.apply(getProject());

				assertTrue(testElement.getStrings().size() == 3);
				assertTrue(testElement.getStrings().get(0).equals("first"));
				assertTrue(testElement.getStrings().get(1).equals("inserted"));
				assertTrue(testElement.getStrings().get(2).equals("third"));
			}
		}.run(false);
	}

	@Test
	public void setAndReverseTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();
				testElement.getStrings().add("oldValue");

				getProjectSpace().getOperations().clear();
				assertTrue(testElement.getStrings().size() == 1);
				assertTrue(testElement.getStrings().get(0).equals("oldValue"));

				testElement.getStrings().set(0, "newValue");

				assertTrue(testElement.getStrings().size() == 1);
				assertTrue(testElement.getStrings().get(0).equals("newValue"));

				AbstractOperation operation = getProjectSpace().getOperations().get(0).reverse();
				operation.apply(getProject());

				assertTrue(testElement.getStrings().size() == 1);
				assertTrue(testElement.getStrings().get(0).equals("oldValue"));
			}
		}.run(false);
	}
}
