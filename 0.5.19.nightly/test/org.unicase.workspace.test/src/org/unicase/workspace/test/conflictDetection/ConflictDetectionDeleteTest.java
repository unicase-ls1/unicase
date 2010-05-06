/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.conflictDetection;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.Project;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.bug.BugReport;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.task.Milestone;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.ProjectSpace;

/**
 * Tests conflict detection behaviour on attributes.
 * 
 * @author chodnick
 */
public class ConflictDetectionDeleteTest extends ConflictDetectionTest {

	/**
	 * Tests if deleting an object is detected as conflict.
	 */
	@Test
	public void conflictDelete() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		actor.setName("old name");

		getProject().addModelElement(section);
		section.getModelElements().add(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		getProject().deleteModelElement(actor1);
		actor2.setName("change to the deleted object on another working copy");

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if deleting an object is detected as conflict.
	 */
	@Test
	public void conflictDeleteAttributeChangesInDeltree() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		actor.setName("old name");

		getProject().addModelElement(section);
		section.getModelElements().add(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		getProject().deleteModelElement(section1);
		actor2.setName("change to object inside deltree on another working copy");

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if deleting an object is detected as conflict.
	 */
	@Test
	public void conflictDeleteAttributeChangesInDelObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		getProject().addModelElement(section);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		getProject().deleteModelElement(section1);
		section2.setName("change to object inside deltree on another working copy");

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if deleting an object is detected as conflict.
	 */
	@Test
	public void noConflictDeleteUnrelated() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		actor1.setName("change to unrelated object on another working copy");
		project2.deleteModelElement(section2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if deleting an object is detected as conflict.
	 */
	@Test
	public void conflictDeleteContainmentChangesInDeltree() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		WorkPackage pack = TaskFactory.eINSTANCE.createWorkPackage();
		BugReport br = BugFactory.eINSTANCE.createBugReport();

		getProject().addModelElement(section);
		getProject().addModelElement(pack);
		getProject().addModelElement(br);

		section.getModelElements().add(pack);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		BugReport br1 = (BugReport) getProject().getModelElement(br.getModelElementId());
		WorkPackage pack1 = (WorkPackage) getProject().getModelElement(pack.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		br1.setContainingWorkpackage(pack1);
		project2.deleteModelElement(section2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if deleting an object is detected as conflict.
	 */
	@Test
	public void conflictDeleteNonContainmentChangesInDeltree() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Milestone mileStone = TaskFactory.eINSTANCE.createMilestone();

		getProject().addModelElement(section);
		getProject().addModelElement(useCase);
		getProject().addModelElement(mileStone);

		section.getModelElements().add(useCase);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Milestone mileStone1 = (Milestone) getProject().getModelElement(mileStone.getModelElementId());
		UseCase useCase1 = (UseCase) getProject().getModelElement(useCase.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		useCase1.getAnnotations().add(mileStone1);
		project2.deleteModelElement(section2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		// technically no conflict, since annotated milestone will not be deleted,
		// but there is no way to tell containment from non-containment changes,
		// therefore it is expected that this will be detected as a hard conflict
		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if deleting an object is detected as conflict.
	 */
	@Test
	public void conflictDeleteMoveChangesInDeltree() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		WorkPackage pack = TaskFactory.eINSTANCE.createWorkPackage();
		BugReport br1 = BugFactory.eINSTANCE.createBugReport();
		BugReport br2 = BugFactory.eINSTANCE.createBugReport();

		getProject().addModelElement(section);
		getProject().addModelElement(pack);
		getProject().addModelElement(br1);

		br1.setContainingWorkpackage(pack);
		br2.setContainingWorkpackage(pack);
		assertEquals(pack.getContainedWorkItems().get(0), br1);
		assertEquals(pack.getContainedWorkItems().get(1), br2);

		section.getModelElements().add(pack);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		WorkPackage pack1 = (WorkPackage) getProject().getModelElement(pack.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		pack1.getContainedWorkItems().move(1, 0);
		project2.deleteModelElement(section2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		// a move change is a change... from users perspective it should not be lost, probably..
		// currently considered to be a hard conflict, because the user should know
		assertEquals(conflicts.size(), 1);

	}

}
