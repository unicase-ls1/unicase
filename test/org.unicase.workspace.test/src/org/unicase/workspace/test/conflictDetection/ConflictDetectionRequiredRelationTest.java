/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.conflictDetection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Test;
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.rationale.Solution;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.requirement.UserTask;

/**
 * Tests conflict detection behaviour on attributes.
 * 
 * @author chodnick
 */
public class ConflictDetectionRequiredRelationTest extends ConflictDetectionTest {

	/**
	 * Tests requires & requiring relation.
	 */
	@Test
	public void requireCreateByAdd() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		getProject().addModelElement(section);
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProjectSpace().getOperations().clear();

		section.getModelElements().add(actor);

		List<AbstractOperation> ops = getProjectSpace().getLocalOperations().getOperations();

		// ops are [Create actor], [add actor to section]
		AbstractOperation createActor = ops.get(0);
		AbstractOperation addActor = ops.get(1);

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		assertEquals(1, cd.getRequired(ops, addActor).size());
		assertSame(cd.getRequired(ops, addActor).get(0), createActor);

		assertEquals(1, cd.getRequiring(ops, createActor).size());
		assertSame(cd.getRequiring(ops, createActor).get(0), addActor);

	}

	/**
	 * Tests requires & requiring relation.
	 */
	@Test
	public void requireCreateByRemove() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		getProject().addModelElement(section);
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProjectSpace().getOperations().clear();

		section.getModelElements().add(actor);
		section.getModelElements().remove(actor);

		List<AbstractOperation> ops = getProjectSpace().getLocalOperations().getOperations();

		// ops are [Create actor], [add actor to section], [remove actor from section]
		AbstractOperation createActor = ops.get(0);
		AbstractOperation addActor = ops.get(1);
		AbstractOperation removeActor = ops.get(2);

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		assertEquals(2, cd.getRequired(ops, removeActor).size());
		assertSame(cd.getRequired(ops, removeActor).get(0), createActor);
		assertSame(cd.getRequired(ops, removeActor).get(1), addActor);

		assertEquals(0, cd.getRequiring(ops, removeActor).size());

		assertEquals(1, cd.getRequiring(ops, addActor).size());
		assertSame(cd.getRequiring(ops, addActor).get(0), removeActor);

		assertEquals(2, cd.getRequiring(ops, createActor).size());
		assertSame(cd.getRequiring(ops, createActor).get(0), addActor);
		assertSame(cd.getRequiring(ops, createActor).get(1), removeActor);

	}

	/**
	 * Tests requires & requiring relation.
	 */
	@Test
	public void requireCreateByMove() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		section.getModelElements().add(dummy);

		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProjectSpace().getOperations().clear();

		section.getModelElements().add(actor);
		section.getModelElements().move(0, actor);

		List<AbstractOperation> ops = getProjectSpace().getLocalOperations().getOperations();

		// ops are [Create actor], [add actor to section], [move actor in section]
		AbstractOperation createActor = ops.get(0);
		AbstractOperation addActor = ops.get(1);
		AbstractOperation moveActor = ops.get(2);

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		assertEquals(2, cd.getRequired(ops, moveActor).size());
		assertSame(cd.getRequired(ops, moveActor).get(0), createActor);
		assertSame(cd.getRequired(ops, moveActor).get(1), addActor);

		assertEquals(0, cd.getRequiring(ops, moveActor).size());

		assertEquals(1, cd.getRequiring(ops, addActor).size());
		assertSame(cd.getRequiring(ops, addActor).get(0), moveActor);

		assertEquals(2, cd.getRequiring(ops, createActor).size());
		assertSame(cd.getRequiring(ops, createActor).get(0), addActor);
		assertSame(cd.getRequiring(ops, createActor).get(1), moveActor);

	}

	/**
	 * Tests requires & requiring relation.
	 */
	@Test
	public void requireCreateByAttributeChange() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		getProject().addModelElement(section);

		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProjectSpace().getOperations().clear();

		section.getModelElements().add(actor);
		actor.setName("this is a new name");

		List<AbstractOperation> ops = getProjectSpace().getLocalOperations().getOperations();

		// ops are [Create actor], [add actor to section], [rename actor]
		AbstractOperation createActor = ops.get(0);
		AbstractOperation addActor = ops.get(1);
		AbstractOperation nameActor = ops.get(2);

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		assertEquals(1, cd.getRequired(ops, nameActor).size());
		assertSame(cd.getRequired(ops, nameActor).get(0), createActor);

		assertEquals(0, cd.getRequiring(ops, nameActor).size());

		assertEquals(0, cd.getRequiring(ops, addActor).size());

		assertEquals(2, cd.getRequiring(ops, createActor).size());
		assertSame(cd.getRequiring(ops, createActor).get(0), addActor);
		assertSame(cd.getRequiring(ops, createActor).get(1), nameActor);

	}

	/**
	 * Tests requires & requiring relation.
	 */
	@Test
	public void requireCreateByReferenceChange() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		UserTask task = RequirementFactory.eINSTANCE.createUserTask();

		getProject().addModelElement(section);
		getProject().addModelElement(task);

		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProjectSpace().getOperations().clear();

		section.getModelElements().add(actor);
		actor.setInitiatedUserTask(task);

		List<AbstractOperation> ops = getProjectSpace().getLocalOperations().getOperations();

		// ops are [Create actor], [add actor to section], [task actor]
		AbstractOperation createActor = ops.get(0);
		AbstractOperation addActor = ops.get(1);
		AbstractOperation taskActor = ops.get(2);

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		assertEquals(1, cd.getRequired(ops, taskActor).size());
		assertSame(cd.getRequired(ops, taskActor).get(0), createActor);

		assertEquals(0, cd.getRequiring(ops, taskActor).size());

		assertEquals(0, cd.getRequiring(ops, addActor).size());

		assertEquals(2, cd.getRequiring(ops, createActor).size());
		assertSame(cd.getRequiring(ops, createActor).get(0), addActor);
		assertSame(cd.getRequiring(ops, createActor).get(1), taskActor);

	}

	/**
	 * Tests requires & requiring relation.
	 */
	@Test
	public void requireCreateByMultiChange() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();

		getProject().addModelElement(section);
		getProject().addModelElement(useCase);

		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProjectSpace().getOperations().clear();

		section.getModelElements().add(actor);
		actor.getInitiatedUseCases().add(useCase);

		List<AbstractOperation> ops = getProjectSpace().getLocalOperations().getOperations();

		// ops are [Create actor], [add actor to section], [add usecase to actor]
		AbstractOperation createActor = ops.get(0);
		AbstractOperation addActor = ops.get(1);
		AbstractOperation caseActor = ops.get(2);

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		assertEquals(1, cd.getRequired(ops, caseActor).size());
		assertSame(cd.getRequired(ops, caseActor).get(0), createActor);

		assertEquals(0, cd.getRequiring(ops, caseActor).size());

		assertEquals(0, cd.getRequiring(ops, addActor).size());

		assertEquals(2, cd.getRequiring(ops, createActor).size());
		assertSame(cd.getRequiring(ops, createActor).get(0), addActor);
		assertSame(cd.getRequiring(ops, createActor).get(1), caseActor);

	}

	/**
	 * Tests requires & requiring relation.
	 */
	@Test
	public void requireCreateByIndirectChange() {

		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		Solution solution1 = RationaleFactory.eINSTANCE.createSolution();
		Solution solution2 = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue);
		getProject().addModelElement(solution2);
		issue.setSolution(solution2);

		getProjectSpace().getOperations().clear();
		getProject().addModelElement(solution1);
		issue.setSolution(solution1);
		issue.setSolution(solution2);

		List<AbstractOperation> ops = getProjectSpace().getLocalOperations().getOperations();

		// ops are [create solution1], [set solution 1], [set solution 2]
		AbstractOperation createSolution1 = ops.get(0);
		AbstractOperation setSolution1 = ops.get(1);
		AbstractOperation setSolution2 = ops.get(2);

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		assertEquals(0, cd.getRequired(ops, setSolution2).size());
		assertEquals(1, cd.getRequiring(ops, createSolution1).size());
		assertSame(cd.getRequiring(ops, createSolution1).get(0), setSolution1);

	}

	/**
	 * Tests requires & requiring relation.
	 */
	@Test
	public void requireCreateByDelete() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		getProject().addModelElement(section);
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProjectSpace().getOperations().clear();

		section.getModelElements().add(actor);
		actor.setName("name");
		getProject().deleteModelElement(actor);

		List<AbstractOperation> ops = getProjectSpace().getLocalOperations().getOperations();

		// ops are [create actor], [addActor], [nameActor], [delete actor]
		AbstractOperation createActor = ops.get(0);
		AbstractOperation addActor = ops.get(1);
		AbstractOperation nameActor = ops.get(2);
		AbstractOperation deleteActor = ops.get(3);

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		assertEquals(1, cd.getRequired(ops, deleteActor).size());
		assertSame(cd.getRequired(ops, deleteActor).get(0), createActor);

		assertEquals(1, cd.getRequired(ops, nameActor).size());
		assertSame(cd.getRequired(ops, nameActor).get(0), createActor);

		assertEquals(1, cd.getRequired(ops, addActor).size());
		assertSame(cd.getRequired(ops, addActor).get(0), createActor);

		assertEquals(3, cd.getRequiring(ops, createActor).size());
		assertSame(cd.getRequiring(ops, createActor).get(0), addActor);
		assertSame(cd.getRequiring(ops, createActor).get(1), nameActor);
		assertSame(cd.getRequiring(ops, createActor).get(2), deleteActor);

	}

	/**
	 * Tests requires & requiring relation.
	 */
	@Test
	public void requireCreateByChangeInDeletree() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProjectSpace().getOperations().clear();

		getProject().addModelElement(section);
		section.getModelElements().add(actor);
		actor.setName("name");
		getProject().deleteModelElement(section);

		List<AbstractOperation> ops = getProjectSpace().getLocalOperations().getOperations();

		// ops are [create section], [create actor], [add actor], [name actor], [delete section]
		AbstractOperation createSection = ops.get(0);
		AbstractOperation createActor = ops.get(1);
		AbstractOperation addActor = ops.get(2);
		AbstractOperation nameActor = ops.get(3);
		AbstractOperation deleteSection = ops.get(4);

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		assertEquals(0, cd.getRequired(ops, createSection).size());
		assertEquals(0, cd.getRequired(ops, createActor).size());

		assertEquals(2, cd.getRequired(ops, addActor).size());
		assertSame(cd.getRequired(ops, addActor).get(0), createSection);
		assertSame(cd.getRequired(ops, addActor).get(1), createActor);

		assertEquals(1, cd.getRequired(ops, nameActor).size());
		assertSame(cd.getRequired(ops, nameActor).get(0), createActor);

		assertEquals(1, cd.getRequired(ops, deleteSection).size());
		assertSame(cd.getRequired(ops, deleteSection).get(0), createSection);

		assertEquals(2, cd.getRequiring(ops, createSection).size());
		assertSame(cd.getRequiring(ops, createSection).get(0), addActor);
		assertSame(cd.getRequiring(ops, createSection).get(1), deleteSection);

	}

	/**
	 * Tests requires & requiring relation.
	 */
	@Test
	public void requireSingleRefByMove() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();

		actor.setLeafSection(section);
		section.getModelElements().move(0, actor);

		List<AbstractOperation> ops = getProjectSpace().getLocalOperations().getOperations();

		// ops are [add actor to section], [move actor in section]
		AbstractOperation addActor = ops.get(0);
		AbstractOperation moveActor = ops.get(1);

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		assertEquals(1, cd.getRequired(ops, moveActor).size());
		assertSame(cd.getRequired(ops, moveActor).get(0), addActor);

		assertEquals(0, cd.getRequiring(ops, moveActor).size());

		assertEquals(1, cd.getRequiring(ops, addActor).size());
		assertSame(cd.getRequiring(ops, addActor).get(0), moveActor);

	}

	/**
	 * Tests requires & requiring relation.
	 */
	@Test
	public void requireSingleRefByRemove() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();

		actor.setLeafSection(section);
		section.getModelElements().remove(actor);

		List<AbstractOperation> ops = getProjectSpace().getLocalOperations().getOperations();

		// ops are [add actor to section], [remove actor from section]
		AbstractOperation addActor = ops.get(0);
		AbstractOperation removeActor = ops.get(1);

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		assertEquals(1, cd.getRequired(ops, removeActor).size());
		assertSame(cd.getRequired(ops, removeActor).get(0), addActor);

		assertEquals(0, cd.getRequiring(ops, removeActor).size());

		assertEquals(1, cd.getRequiring(ops, addActor).size());
		assertSame(cd.getRequiring(ops, addActor).get(0), removeActor);

	}

	/**
	 * Tests requires & requiring relation.
	 */
	@Test
	public void requireSingleRefByIndirectRemove() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection section2 = DocumentFactory.eINSTANCE.createLeafSection();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(section2);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();

		actor.setLeafSection(section);
		section2.getModelElements().add(actor);

		List<AbstractOperation> ops = getProjectSpace().getLocalOperations().getOperations();

		// ops are [add actor to section], [composite remove/add actor to section2]
		AbstractOperation addActor = ops.get(0);
		AbstractOperation relocateActor = ops.get(1);

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		// the remove inside the relocation needs the add
		assertEquals(1, cd.getRequired(ops, relocateActor).size());
		assertSame(cd.getRequired(ops, relocateActor).get(0), addActor);

		assertEquals(0, cd.getRequiring(ops, relocateActor).size());

		assertEquals(1, cd.getRequiring(ops, addActor).size());
		assertSame(cd.getRequiring(ops, addActor).get(0), relocateActor);

	}

}
