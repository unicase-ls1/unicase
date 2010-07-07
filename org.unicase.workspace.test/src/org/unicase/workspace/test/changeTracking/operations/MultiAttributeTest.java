/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.changeTracking.operations;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.workspace.test.WorkspaceTest;
import org.unicase.workspace.test.testmodel.TestElement;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Tests for MultiAttributes.
 * 
 * @author wesendon
 */
public class MultiAttributeTest extends WorkspaceTest {

	@Test
	public void addValueToEmptyTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();

				assertTrue(testElement.getStrings().size() == 0);

				MultiAttributeOperation operation = OperationsFactory.eINSTANCE.createMultiAttributeOperation();
				operation.setAdd(true);
				operation.setFeatureName("strings");
				operation.setIndex(0);
				operation.getReferencedValues().add("inserted");
				operation.setModelElementId(testElement.getModelElementId());

				operation.apply(getProject());

				assertTrue(testElement.getStrings().size() == 1);
				assertTrue(testElement.getStrings().get(0).equals("inserted"));
			}
		}.run();
	}

	@Test
	public void addValueToFilledTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();
				testElement.getStrings().add("first");

				assertTrue(testElement.getStrings().size() == 1);

				MultiAttributeOperation operation = OperationsFactory.eINSTANCE.createMultiAttributeOperation();
				operation.setAdd(true);
				operation.setFeatureName("strings");
				operation.setIndex(0);
				operation.getReferencedValues().add("inserted");
				operation.setModelElementId(testElement.getModelElementId());

				operation.apply(getProject());

				assertTrue(testElement.getStrings().size() == 2);
				assertTrue(testElement.getStrings().get(0).equals("inserted"));
				assertTrue(testElement.getStrings().get(1).equals("first"));
			}
		}.run();
	}

	@Test
	public void addMultipleValueToFilledTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();
				testElement.getStrings().add("first");

				assertTrue(testElement.getStrings().size() == 1);

				MultiAttributeOperation operation = OperationsFactory.eINSTANCE.createMultiAttributeOperation();
				operation.setAdd(true);
				operation.setFeatureName("strings");
				operation.setIndex(0);
				operation.getReferencedValues().add("inserted");
				operation.getReferencedValues().add("inserted2");
				operation.setModelElementId(testElement.getModelElementId());

				operation.apply(getProject());

				assertTrue(testElement.getStrings().size() == 3);
				assertTrue(testElement.getStrings().get(0).equals("inserted"));
				assertTrue(testElement.getStrings().get(1).equals("inserted2"));
				assertTrue(testElement.getStrings().get(2).equals("first"));
			}
		}.run();
	}

	@Test
	public void removeValueToEmptyTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();
				testElement.getStrings().add("first");

				assertTrue(testElement.getStrings().size() == 1);

				MultiAttributeOperation operation = OperationsFactory.eINSTANCE.createMultiAttributeOperation();
				operation.setAdd(false);
				operation.setFeatureName("strings");
				operation.setIndex(0);
				operation.getReferencedValues().add("inserted");
				operation.setModelElementId(testElement.getModelElementId());

				operation.apply(getProject());

				assertTrue(testElement.getStrings().size() == 0);
			}
		}.run();
	}

	// TODO
	@Test
	public void test() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();
				testElement.getStrings().add("first");
				testElement.getStrings().add("second");
				testElement.getStrings().add("third");

				System.out.println(testElement.getStrings());

				getProjectSpace().getOperations().clear();

				testElement.getStrings().removeAll(Arrays.asList("first", "third"));

				System.out.println(testElement.getStrings());
				plotOperations();

			}
		}.run();
	}
}
