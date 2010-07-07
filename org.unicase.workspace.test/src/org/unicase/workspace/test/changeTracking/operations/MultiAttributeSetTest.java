/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.changeTracking.operations;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
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
				clearOperations();

				assertTrue(element.getStrings().size() == 0);

				element.getStrings().set(0, "settedValue");

				assertTrue(element.getStrings().size() == 1);
				assertTrue(element.getStrings().get(0).equals("settedValue"));

				assertTrue(getProjectSpace().getOperations().size() == 1);
				assertTrue(getProjectSpace().getOperations().get(0) instanceof MultiAttributeSetOperation);
			}
		}.run();
	}

	@Test
	public void applyValueToEmptyTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();

				assertTrue(testElement.getStrings().size() == 0);

				MultiAttributeSetOperation operation = OperationsFactory.eINSTANCE.createMultiAttributeSetOperation();
				operation.setFeatureName("strings");
				operation.setIndex(0);
				operation.setNewValue("inserted");
				operation.setOldValue(null);
				operation.setModelElementId(testElement.getModelElementId());

				operation.apply(getProject());

				assertTrue(testElement.getStrings().size() == 1);
				assertTrue(testElement.getStrings().get(0).equals("inserted"));
			}
		}.run();
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
		}.run();
	}
}
