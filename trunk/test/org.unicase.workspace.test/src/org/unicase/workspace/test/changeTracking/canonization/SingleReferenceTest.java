/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.changeTracking.canonization;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.Project;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.requirement.UserTask;
import org.unicase.model.util.ModelUtil;

/**
 * Tests canonization of attribute operations.
 * 
 * @author chodnick
 */
public class SingleReferenceTest extends CanonizationTest {

	/**
	 * Tests canonization for consecutive attribute changes on a single feature.
	 * 
	 */
	@Test
	public void consecutiveNonContainmentReferenceChangeSingleFeature()  {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();
		Actor actor3 = RequirementFactory.eINSTANCE.createActor();
		
		getProject().addModelElement(useCase);
		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(actor3);
		
		useCase.setInitiatingActor(actor1);
		
		Project expectedProject = ModelUtil.clone(getProject());
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));
		
		clearOperations();
		
		useCase.setInitiatingActor(actor2);
		useCase.setInitiatingActor(actor1);
		useCase.setInitiatingActor(actor3);
		useCase.setInitiatingActor(actor1);

		assertSame(actor1, useCase.getInitiatingActor());
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		assertEquals(operations.size(), 1);
		
		AbstractOperation reverse = operations.get(0).reverse();
		reverse.apply(getProject());
		
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));
		
	}
	
	/**
	 * Tests canonization for consecutive attribute changes on a single feature.
	 * 
	 */
	@Test
	public void mixedNonContainmentReferenceChangeSingleFeature()  {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();
		Actor actor3 = RequirementFactory.eINSTANCE.createActor();
		
		getProject().addModelElement(useCase);
		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(actor3);
		
		useCase.setInitiatingActor(actor1);
		
		Project expectedProject = ModelUtil.clone(getProject());
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));
		
		clearOperations();
		
		useCase.setInitiatingActor(actor2);
		useCase.setName("some name");
		useCase.setDescription("old description");
		useCase.setInitiatingActor(actor1);
		useCase.setName("some other name");
		useCase.setInitiatingActor(actor3);
		useCase.setName("some new name");
		useCase.setInitiatingActor(actor1);
		useCase.setDescription("description");

		assertSame(actor1, useCase.getInitiatingActor());
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		// expect operations for change in name, description and initiating actor
		assertEquals(operations.size(), 3);
		
		for(int i=operations.size()-1; i>=0; i--){
			AbstractOperation reverse = (AbstractOperation)operations.get(i).reverse();
			reverse.apply(getProject());
		}
		
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));
		
	}	
	
	/**
	 * Tests canonization for consecutive attribute changes on a single feature.
	 * 
	 */
	@Test
	public void consecutiveNonContainmentReferenceChangeMultiFeature()  {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		UserTask userTask1 = RequirementFactory.eINSTANCE.createUserTask();
		UserTask userTask2 = RequirementFactory.eINSTANCE.createUserTask(); 
		
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();
		Actor actor3 = RequirementFactory.eINSTANCE.createActor();
		
		getProject().addModelElement(useCase);
		getProject().addModelElement(userTask1);
		getProject().addModelElement(userTask2);
		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(actor3);
		
		useCase.setInitiatingActor(actor1);
		useCase.setRealizedUserTask(userTask1);
		
		Project expectedProject = ModelUtil.clone(getProject());
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));
		
		clearOperations();
		
		useCase.setInitiatingActor(actor2);
		useCase.setRealizedUserTask(userTask2);
		useCase.setInitiatingActor(actor1);
		useCase.setRealizedUserTask(userTask1);
		useCase.setInitiatingActor(actor3);
		useCase.setRealizedUserTask(userTask2);
		useCase.setInitiatingActor(actor2);

		assertSame(actor2, useCase.getInitiatingActor());
		assertSame(userTask2, useCase.getRealizedUserTask());
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		assertEquals(operations.size(), 2);
		
		for(int i=operations.size()-1; i>=0; i--){
			AbstractOperation reverse = (AbstractOperation)operations.get(i).reverse();
			reverse.apply(getProject());
		}
		
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));
		
	}	
	
	/**
	 * Tests canonization for consecutive attribute changes on a single feature.
	 * 
	 */
	@Test
	public void mixedNonContainmentReferenceChangeMultiFeature()  {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		UserTask userTask1 = RequirementFactory.eINSTANCE.createUserTask();
		UserTask userTask2 = RequirementFactory.eINSTANCE.createUserTask(); 
		
		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();
		Actor actor3 = RequirementFactory.eINSTANCE.createActor();
		
		getProject().addModelElement(useCase);
		getProject().addModelElement(userTask1);
		getProject().addModelElement(userTask2);
		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		getProject().addModelElement(actor3);
		
		useCase.setInitiatingActor(actor1);
		useCase.setRealizedUserTask(userTask1);
		
		Project expectedProject = ModelUtil.clone(getProject());
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));
		
		clearOperations();
		
		useCase.setInitiatingActor(actor2);
		useCase.setRealizedUserTask(userTask2);
		useCase.setDescription("desc");
		useCase.setInitiatingActor(actor1);
		useCase.setRealizedUserTask(userTask1);
		useCase.setDescription("new description");
		useCase.setInitiatingActor(actor3);
		useCase.setRealizedUserTask(userTask2);
		useCase.setName("new name");
		useCase.setInitiatingActor(actor2);

		assertSame(actor2, useCase.getInitiatingActor());
		assertSame(userTask2, useCase.getRealizedUserTask());
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		// expect changes in name, description, initiating actor and realized user task
		assertEquals(operations.size(), 4);
		
		for(int i=operations.size()-1; i>=0; i--){
			AbstractOperation reverse = (AbstractOperation)operations.get(i).reverse();
			reverse.apply(getProject());
		}
		
		assertTrue(ModelUtil.areEqual(getProject(), expectedProject));
		
	}		
	

}
