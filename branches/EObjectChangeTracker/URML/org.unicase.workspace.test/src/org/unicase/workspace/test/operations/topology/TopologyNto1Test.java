/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.operations.topology;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;

import java.util.List;

/**
 * Tests operations in n:1 topologies.
 * @author chodnick
 *
 */
public class TopologyNto1Test extends TopologyTest{

	/**
	 * Set a container from null to some value.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void setContainerFromNullToValue() throws UnsupportedOperationException, UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();

		getProject().addModelElement(section);
		getProject().addModelElement(useCase);

		clearOperations();

		useCase.setLeafSection(section);
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		SingleReferenceOperation op = (SingleReferenceOperation) operations.get(0);
		assertEquals(useCase.getModelElementId(), op.getModelElementId());
		assertEquals("leafSection", op.getFeatureName());
		assertNull(op.getOldValue());
		assertEquals(op.getNewValue(), section.getModelElementId());
		
		
	}
	
	/**
	 * Set a container from some value to null.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void setContainerFromValueToNull() throws UnsupportedOperationException, UnsupportedNotificationException {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();

		getProject().addModelElement(section);
		getProject().addModelElement(useCase);
		useCase.setLeafSection(section);
		assertTrue(section.getModelElements().contains(useCase));
		
		clearOperations();

		useCase.setLeafSection(null);
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		SingleReferenceOperation op = (SingleReferenceOperation) operations.get(0);
		assertEquals(useCase.getModelElementId(), op.getModelElementId());
		assertEquals("leafSection", op.getFeatureName());
		assertNull(op.getNewValue());
		assertEquals(op.getOldValue(), section.getModelElementId());
		
	}	
	
	/**
	 * Set a container from some value to some other value.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	/*
	@Test
	public void setContainerFromValueToOtherValueSameFeature() throws UnsupportedOperationException, UnsupportedNotificationException {

		LeafSection section1 = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection section2 = DocumentFactory.eINSTANCE.createLeafSection();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();

		getProject().addModelElement(section1);
		getProject().addModelElement(section2);
		getProject().addModelElement(useCase);
		useCase.setLeafSection(section1);
		
		assertTrue(section1.getModelElements().contains(useCase));
		
		clearOperations();

		useCase.setLeafSection(section2);
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof SingleReferenceOperation);
		SingleReferenceOperation op = (SingleReferenceOperation) operations.get(0);
		assertEquals(useCase.getModelElementId(), op.getModelElementId());
		assertEquals("leafSection", op.getFeatureName());
		assertNull(op.getNewValue());
		assertEquals(op.getOldValue(), section.getModelElementId());
		
	}		*/
	
}
