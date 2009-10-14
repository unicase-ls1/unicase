/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.test;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;

/**
 * Tests for the model element cache.
 * 
 * @author koegel
 *
 */
public class ModelElementCacheTest {

	private Project project;

	/**
	 * Setup the project and its cache.
	 * 
	 */
	@Before
	public void setUp() {
		project = ModelFactory.eINSTANCE.createProject();
	}

	/**
	 * Test to add elements.
	 */
	@Test
	public void testAddingElements() {
		FunctionalRequirement fr1 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr2 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr21 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr22 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr212 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		fr2.getRefiningRequirements().add(fr21);
		fr2.getRefiningRequirements().add(fr22);
		fr21.getRefiningRequirements().add(fr212);
		
		project.addModelElement(fr1);
		assertEquals(true, project.contains(fr1));
		assertEquals(fr1, project.getModelElement(fr1.getModelElementId()));

		project.addModelElement(fr2);
		assertEquals(true, project.contains(fr2));
		assertEquals(fr2, project.getModelElement(fr2.getModelElementId()));
		assertEquals(true, project.contains(fr21));
		assertEquals(fr21, project.getModelElement(fr21.getModelElementId()));
		assertEquals(true, project.contains(fr22));
		assertEquals(fr22, project.getModelElement(fr22.getModelElementId()));
		assertEquals(true, project.contains(fr2));
		assertEquals(fr212, project.getModelElement(fr212.getModelElementId()));
		
	}

	/**
	 * Test Deleting elements.
	 */
	@Test
	public void testDeletingElements() {
		FunctionalRequirement fr1 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr2 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr21 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr22 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr212 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		fr2.getRefiningRequirements().add(fr21);
		fr2.getRefiningRequirements().add(fr22);
		fr21.getRefiningRequirements().add(fr212);
		project.addModelElement(fr1);
		assertEquals(true, project.contains(fr1));
		assertEquals(fr1, project.getModelElement(fr1.getModelElementId()));
		project.addModelElement(fr2);
		assertEquals(true, project.contains(fr2));
		assertEquals(fr2, project.getModelElement(fr2.getModelElementId()));
		assertEquals(true, project.contains(fr21));
		assertEquals(fr21, project.getModelElement(fr21.getModelElementId()));
		assertEquals(true, project.contains(fr22));
		assertEquals(fr22, project.getModelElement(fr22.getModelElementId()));
		assertEquals(true, project.contains(fr2));
		assertEquals(fr212, project.getModelElement(fr212.getModelElementId()));
		
		fr1.delete();
		assertEquals(false, project.contains(fr1));
		assertEquals(true, project.contains(fr2));
		assertEquals(fr2, project.getModelElement(fr2.getModelElementId()));
		assertEquals(true, project.contains(fr21));
		assertEquals(fr21, project.getModelElement(fr21.getModelElementId()));
		assertEquals(true, project.contains(fr22));
		assertEquals(fr22, project.getModelElement(fr22.getModelElementId()));
		assertEquals(true, project.contains(fr2));
		assertEquals(fr212, project.getModelElement(fr212.getModelElementId()));
		
		fr21.delete();
		assertEquals(false, project.contains(fr21));
		assertEquals(false, project.contains(fr212));
		assertEquals(true, project.contains(fr2));
		assertEquals(fr2, project.getModelElement(fr2.getModelElementId()));
		assertEquals(true, project.contains(fr22));
		assertEquals(fr22, project.getModelElement(fr22.getModelElementId()));
		
		fr2.delete();
		assertEquals(false, project.contains(fr1));
		assertEquals(false, project.contains(fr2));
		assertEquals(false, project.contains(fr21));
		assertEquals(false, project.contains(fr22));
		assertEquals(false, project.contains(fr212));
		
	}
	
	/**
	 * Test moving elements.
	 */
	@Test
	public void testMovingElements() {
		FunctionalRequirement fr1 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr2 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr21 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr22 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr212 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		fr2.getRefiningRequirements().add(fr21);
		fr2.getRefiningRequirements().add(fr22);
		fr21.getRefiningRequirements().add(fr212);
		project.addModelElement(fr1);
		assertEquals(true, project.contains(fr1));
		assertEquals(fr1, project.getModelElement(fr1.getModelElementId()));
		project.addModelElement(fr2);
		assertEquals(true, project.contains(fr2));
		assertEquals(fr2, project.getModelElement(fr2.getModelElementId()));
		assertEquals(true, project.contains(fr21));
		assertEquals(fr21, project.getModelElement(fr21.getModelElementId()));
		assertEquals(true, project.contains(fr22));
		assertEquals(fr22, project.getModelElement(fr22.getModelElementId()));
		assertEquals(true, project.contains(fr2));
		assertEquals(fr212, project.getModelElement(fr212.getModelElementId()));
		
		fr212.setRefinedRequirement(fr22);
		fr212.getRefiningRequirements().add(fr1);
		fr212.setRefinedRequirement(fr2);
		
		
		assertEquals(true, project.contains(fr2));
		assertEquals(fr2, project.getModelElement(fr2.getModelElementId()));
		assertEquals(true, project.contains(fr21));
		assertEquals(fr21, project.getModelElement(fr21.getModelElementId()));
		assertEquals(true, project.contains(fr22));
		assertEquals(fr22, project.getModelElement(fr22.getModelElementId()));
		assertEquals(true, project.contains(fr2));
		assertEquals(fr212, project.getModelElement(fr212.getModelElementId()));
	}
	
	/**
	 * Test changing elements without delete or add.
	 */
	@Test
	public void testChangingElements() {
		FunctionalRequirement fr1 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr2 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr21 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr22 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement fr212 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		fr2.getRefiningRequirements().add(fr21);
		fr2.getRefiningRequirements().add(fr22);
		fr21.getRefiningRequirements().add(fr212);
		project.addModelElement(fr1);
		assertEquals(true, project.contains(fr1));
		assertEquals(fr1, project.getModelElement(fr1.getModelElementId()));
		project.addModelElement(fr2);
		assertEquals(true, project.contains(fr2));
		assertEquals(fr2, project.getModelElement(fr2.getModelElementId()));
		assertEquals(true, project.contains(fr21));
		assertEquals(fr21, project.getModelElement(fr21.getModelElementId()));
		assertEquals(true, project.contains(fr22));
		assertEquals(fr22, project.getModelElement(fr22.getModelElementId()));
		assertEquals(true, project.contains(fr2));
		assertEquals(fr212, project.getModelElement(fr212.getModelElementId()));
		fr1.setName("fr1");
		fr22.setName("fr22");
		ActionItem actionItem = TaskFactory.eINSTANCE.createActionItem();
		project.addModelElement(actionItem);
		actionItem.getAnnotatedModelElements().add(fr212);
		actionItem.getAnnotatedModelElements().add(fr2);	
		assertEquals(true, project.contains(fr2));
		assertEquals(fr2, project.getModelElement(fr2.getModelElementId()));
		assertEquals(true, project.contains(fr21));
		assertEquals(fr21, project.getModelElement(fr21.getModelElementId()));
		assertEquals(true, project.contains(fr22));
		assertEquals(fr22, project.getModelElement(fr22.getModelElementId()));
		assertEquals(true, project.contains(fr2));
		assertEquals(fr212, project.getModelElement(fr212.getModelElementId()));		
	}


	
	
}
