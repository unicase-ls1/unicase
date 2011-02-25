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
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceSetOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.workspace.test.WorkspaceTest;
import org.unicase.workspace.test.testmodel.TestElement;
import org.unicase.workspace.util.UnicaseCommand;

public class MultiReferenceSetOperationTest extends WorkspaceTest {

	@Test
	public void setValueToEmptyTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement element = getTestElement();
				TestElement oldValue = getTestElement();
				TestElement newValue = getTestElement();

				element.getReferences().add(oldValue);
				clearOperations();

				assertTrue(element.getReferences().size() == 1);
				assertTrue(element.getReferences().get(0).equals(oldValue));

				element.getReferences().set(0, newValue);

				assertTrue(element.getReferences().size() == 1);
				assertTrue(element.getReferences().get(0).equals(newValue));

				assertTrue(getProjectSpace().getOperations().size() == 1);
				assertTrue(getProjectSpace().getOperations().get(0) instanceof MultiReferenceSetOperation);
			}
		}.run();
	}

	@Test
	public void applyValueToEmptyTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();
				TestElement oldValue = getTestElement();
				testElement.getReferences().add(oldValue);
				TestElement newValue = getTestElement();
				assertTrue(testElement.getReferences().size() == 1);
				assertTrue(testElement.getReferences().get(0).equals(oldValue));

				MultiReferenceSetOperation operation = OperationsFactory.eINSTANCE.createMultiReferenceSetOperation();
				operation.setFeatureName("references");
				operation.setIndex(0);
				operation.setNewValue(newValue.getModelElementId());
				operation.setOldValue(oldValue.getModelElementId());
				operation.setModelElementId(testElement.getModelElementId());

				operation.apply(getProject());

				assertTrue(testElement.getReferences().size() == 1);
				assertTrue(testElement.getReferences().get(0).equals(newValue));
			}
		}.run();
	}

	@Test
	public void applyValueToEmptyWrongIndexTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();
				TestElement oldValue = getTestElement();
				testElement.getReferences().add(oldValue);
				TestElement newValue = getTestElement();

				assertTrue(testElement.getReferences().size() == 1);
				assertTrue(testElement.getReferences().get(0).equals(oldValue));

				MultiReferenceSetOperation operation = OperationsFactory.eINSTANCE.createMultiReferenceSetOperation();
				operation.setFeatureName("references");
				operation.setIndex(42);
				operation.setNewValue(newValue.getModelElementId());
				operation.setOldValue(oldValue.getModelElementId());
				operation.setModelElementId(testElement.getModelElementId());

				operation.apply(getProject());

				assertTrue(testElement.getReferences().size() == 1);
				assertTrue(testElement.getReferences().get(0).equals(oldValue));
			}
		}.run();
	}

	@Test
	public void applyValueToFilledTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();
				TestElement first = getTestElement();
				TestElement second = getTestElement();
				TestElement third = getTestElement();
				TestElement newValue = getTestElement();

				testElement.getReferences().addAll(Arrays.asList(first, second, third));
				assertTrue(testElement.getReferences().size() == 3);

				MultiReferenceSetOperation operation = OperationsFactory.eINSTANCE.createMultiReferenceSetOperation();
				operation.setFeatureName("references");
				operation.setIndex(1);
				operation.setNewValue(newValue.getModelElementId());
				operation.setOldValue(second.getModelElementId());
				operation.setModelElementId(testElement.getModelElementId());

				operation.apply(getProject());

				assertTrue(testElement.getReferences().size() == 3);
				assertTrue(testElement.getReferences().get(0).equals(first));
				assertTrue(testElement.getReferences().get(1).equals(newValue));
				assertTrue(testElement.getReferences().get(2).equals(third));
			}
		}.run();
	}

	@Test
	public void setAndReverseTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();
				TestElement oldValue = getTestElement();
				testElement.getReferences().add(oldValue);
				TestElement newValue = getTestElement();

				getProjectSpace().getOperations().clear();
				assertTrue(testElement.getReferences().size() == 1);
				assertTrue(testElement.getReferences().get(0).equals(oldValue));

				testElement.getReferences().set(0, newValue);

				assertTrue(testElement.getReferences().size() == 1);
				assertTrue(testElement.getReferences().get(0).equals(newValue));

				AbstractOperation operation = getProjectSpace().getOperations().get(0).reverse();
				operation.apply(getProject());

				assertTrue(testElement.getReferences().size() == 1);
				assertTrue(testElement.getReferences().get(0).equals(oldValue));
			}
		}.run();
	}
}
