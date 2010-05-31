/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.conflictDetection;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.Project;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Tests conflict detection behaviour on attributes.
 * 
 * @author chodnick
 */
public class ConflictDetectionMultiReferenceTest extends ConflictDetectionTest {

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictAddAddSameObjectSameIndex() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				section1.getModelElements().add(actor1);
				section2.getModelElements().add(actor2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// same operations going on in both working copies, no conflicts expected
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddAddSameObjectSameIndexNonZero() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		final Actor dummy = RequirementFactory.eINSTANCE.createActor();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				section.getModelElements().add(dummy);

				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				section1.getModelElements().add(actor1);
				section2.getModelElements().add(actor2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// same operations going on in both working copies, no conflicts expected
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddAddSameObjectDifferentIndex() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		final Actor dummy = RequirementFactory.eINSTANCE.createActor();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(dummy);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());
		final Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				section1.getModelElements().add(actor1);
				section2.getModelElements().add(dummy2);
				section2.getModelElements().add(actor2);
			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		// index conflicts expected: op from project1 index-conflicts with both ops from project2
		assertEquals(2, cd.getConflictingIndexIntegrity(ops1, ops2).size());
		assertEquals(1, cd.getConflictingIndexIntegrity(ops2, ops1).size());

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetAddSameObjectSameIndex() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(actor);
				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				section1.getModelElements().add(actor1);
				actor2.setLeafSection(section2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		// no index conflict expected: the operations are perfect opposites
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		assertEquals(0, cd.getConflictingIndexIntegrity(ops1, ops2).size());

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetParentSetSameObjectSameIndex() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setLeafSection(section1);
				actor2.setLeafSection(section2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		// no index conflict expected: operations are identical
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		assertEquals(0, cd.getConflictingIndexIntegrity(ops1, ops2).size());

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetAddSameObjectDifferentIndex() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		final Actor dummy = RequirementFactory.eINSTANCE.createActor();

		section.setIdentifier("section");
		actor.setIdentifier("actor");
		dummy.setIdentifier("dummy");
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(actor);
				getProject().addModelElement(dummy);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());
		final Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				section1.getModelElements().add(actor1);
				section2.getModelElements().add(dummy2);
				actor2.setLeafSection(section2);

			}
		}.run();

		EList<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		EList<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		// ops1,ops2 not same as ops1,ops2
		// assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
		// .size());
		assertEquals(2, cd.getConflictingIndexIntegrity(ops1, ops2).size());
		assertEquals(1, cd.getConflictingIndexIntegrity(ops2, ops1).size());

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetParentSetSameObjectDifferentIndex() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		final Actor dummy = RequirementFactory.eINSTANCE.createActor();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(actor);
				getProject().addModelElement(dummy);

				getProjectSpace().getOperations().clear();
			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());
		final Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setLeafSection(section1);

				section2.getModelElements().add(dummy2);
				actor2.setLeafSection(section2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		// assertEquals(cd.getConflictingIndexIntegrity(ops2, ops1).size(), cd.getConflictingIndexIntegrity(ops1, ops2)
		// .size());
		assertEquals(2, cd.getConflictingIndexIntegrity(ops1, ops2).size());
		assertEquals(1, cd.getConflictingIndexIntegrity(ops2, ops1).size());

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddAddDifferentObjectSameIndex() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		final Actor dummy = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(actor);
				getProject().addModelElement(dummy);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				section1.getModelElements().add(actor1);
				section2.getModelElements().add(dummy2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// obviously an index-integrity conflict
		assertEquals(conflicts.size(), 1);

		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());
		assertEquals(0, cd.getConflicting(ops2, ops1).size());

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddAddDifferentObjectDifferentIndex() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		final Actor dummy = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(actor);
				getProject().addModelElement(dummy);

				getProjectSpace().getOperations().clear();

			}
		}.run();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				section1.getModelElements().add(actor1);
				section2.getModelElements().add(actor2);
				section2.getModelElements().add(dummy2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// obviously an index-integrity conflict
		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetAddDifferentObjectSameIndex() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		final Actor dummy = RequirementFactory.eINSTANCE.createActor();
		new UnicaseCommand() {

			@Override
			protected void doRun() {

				getProject().addModelElement(section);
				getProject().addModelElement(actor);
				getProject().addModelElement(dummy);

				getProjectSpace().getOperations().clear();

			}
		}.run();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setLeafSection(section1);
				section2.getModelElements().add(dummy2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetAddDifferentObjectDifferentIndex() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		final Actor dummy = RequirementFactory.eINSTANCE.createActor();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(actor);
				getProject().addModelElement(dummy);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setLeafSection(section1);
				section2.getModelElements().add(actor2);
				section2.getModelElements().add(dummy2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		assertEquals(1, cd.getConflictingIndexIntegrity(ops2, ops1).size());

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetParentSetDifferentObjectSameIndex() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		final Actor dummy = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(actor);
				getProject().addModelElement(dummy);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setLeafSection(section1);
				dummy2.setLeafSection(section2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// obviously an index-integrity conflict
		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetParentSetDifferentObjectDifferentIndex() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		final Actor dummy = RequirementFactory.eINSTANCE.createActor();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(actor);
				getProject().addModelElement(dummy);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setLeafSection(section1);
				section2.getModelElements().add(actor2);
				section2.getModelElements().add(dummy2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		assertEquals(cd.getConflictingIndexIntegrity(ops2, ops1).size(), cd.getConflictingIndexIntegrity(ops1, ops2)
			.size());
		assertEquals(1, cd.getConflictingIndexIntegrity(ops1, ops2).size());

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddRemoveSameObject() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				section1.getModelElements().add(actor1);
				section2.getModelElements().add(actor2);
				section2.getModelElements().remove(actor2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// hard conflict between add and remove, serialization matters
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddParentSetRemoveSameObject() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(otherSection);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		final LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				section1.getModelElements().add(actor1);
				section2.getModelElements().add(actor2);
				actor2.setLeafSection(otherSection2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// hard conflict between add and remove, serialization matters
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddRemoveIndirectlySameObject() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(otherSection);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		final LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				section1.getModelElements().add(actor1);
				section2.getModelElements().add(actor2);
				otherSection2.getModelElements().add(actor2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// hard conflict between add and remove, serialization matters
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetAddParentSetRemoveSameObject() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(otherSection);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		final LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setLeafSection(section1);
				actor2.setLeafSection(section2);
				actor2.setLeafSection(otherSection2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// hard conflict between add and remove, serialization matters
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetAddRemoveIndirectlySameObject() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(otherSection);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		final LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setLeafSection(section1);
				actor2.setLeafSection(section2);
				otherSection2.getModelElements().add(actor2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// hard conflict between add and remove, serialization matters
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetAddRemoveSameObject() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setLeafSection(section1);
				actor2.setLeafSection(section2);
				section2.getModelElements().remove(actor2);

			}
		}.run();
		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// hard conflict between add and remove, serialization matters
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetAddIndirectRemoveSameObject() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(otherSection);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		final LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setLeafSection(section1);
				actor2.setLeafSection(section2);
				otherSection2.getModelElements().add(actor2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// hard conflict between add and remove, serialization matters
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddIndirectRemoveSameObject() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(otherSection);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		final LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				section1.getModelElements().add(actor1);
				section2.getModelElements().add(actor2);
				otherSection2.getModelElements().add(actor2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// hard conflict between add and remove, serialization matters
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictRemoveRemoveSameObject() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(otherSection);
				getProject().addModelElement(actor);

				actor.setLeafSection(section);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				section1.getModelElements().remove(actor1);
				section2.getModelElements().remove(actor2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		// no index conflict
		Set<AbstractOperation> indexConflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		assertEquals(indexConflicts.size(), 0);
		// no hard conflict
		Set<AbstractOperation> hardConflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(hardConflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictRemoveRemoveIndirectlySameObject() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(otherSection);
				getProject().addModelElement(actor);

				actor.setLeafSection(section);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				section1.getModelElements().remove(actor1);
				otherSection2.getModelElements().add(actor2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetRemoveRemoveIndirectlySameObject() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(otherSection);
				getProject().addModelElement(actor);

				actor.setLeafSection(section);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setLeafSection(section1);
				otherSection2.getModelElements().add(actor2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetRemoveParentSetRemoveSameObject() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection anotherSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(otherSection);
				getProject().addModelElement(anotherSection);
				getProject().addModelElement(actor);

				actor.setLeafSection(section);

				getProjectSpace().getOperations().clear();
			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection otherSection1 = (LeafSection) getProject().getModelElement(otherSection.getModelElementId());
		final LeafSection anotherSection2 = (LeafSection) project2.getModelElement(anotherSection.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setLeafSection(otherSection1);
				actor2.setLeafSection(anotherSection2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		assertEquals(conflicts.size(), 0);

		// a hard conflict, though. serialization matters
		Set<AbstractOperation> hardConflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(hardConflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictRemoveIndirectlyRemoveIndirectlySameObject() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(otherSection);
				getProject().addModelElement(actor);

				actor.setLeafSection(section);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection otherSection1 = (LeafSection) getProject().getModelElement(otherSection.getModelElementId());
		final LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				otherSection1.getModelElements().add(actor1);
				otherSection2.getModelElements().add(actor2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// index conflict expected, implicitly actor gets a new parent in each copy
		// since that op has no index
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetRemoveRemoveSameObject() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(otherSection);
				getProject().addModelElement(actor);

				actor.setLeafSection(section);

				getProjectSpace().getOperations().clear();
			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection otherSection1 = (LeafSection) getProject().getModelElement(otherSection.getModelElementId());
		final LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setLeafSection(otherSection1);
				otherSection2.getModelElements().remove(actor2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddMoveSameObject() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		final Actor dummy = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				section.getModelElements().add(dummy);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				section1.getModelElements().add(actor1);
				section2.getModelElements().add(actor2);
				section2.getModelElements().move(0, actor2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		// index conflict arises: if the add happens before the move, the move will work
		// if it does after the move, the move could be ineffective
		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetAddMoveSameObject() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		final Actor dummy = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(actor);
				section.getModelElements().add(dummy);

				getProjectSpace().getOperations().clear();
			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setLeafSection(section1);
				section2.getModelElements().add(actor2);
				section2.getModelElements().move(0, actor2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		// index conflict arises: if the add happens before the move, the move will work
		// if it does after the move, the move could be ineffective
		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictRemoveMoveSameObject() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		final Actor dummy = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(actor);
				section.getModelElements().add(dummy);
				section.getModelElements().add(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				section1.getModelElements().remove(actor1);
				section2.getModelElements().move(0, actor2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		// no index conflict arises: the element is gone in any serialization
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetRemoveMoveSameObject() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor dummy = RequirementFactory.eINSTANCE.createActor();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(otherSection);
				getProject().addModelElement(actor);
				section.getModelElements().add(dummy);
				section.getModelElements().add(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		final LeafSection otherSection1 = (LeafSection) getProject().getModelElement(otherSection.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setLeafSection(otherSection1);
				section2.getModelElements().move(0, actor2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		// no index conflict arises: if the section change happens before the move, the move will work
		// if it does after the move, the move could be ineffective. In either case the item is gone.
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictRemoveIndirectlyMoveSameObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);
		section.getModelElements().add(dummy);
		section.getModelElements().add(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection otherSection1 = (LeafSection) getProject().getModelElement(otherSection.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		otherSection1.getModelElements().add(actor1);
		section2.getModelElements().move(0, actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		// no index conflict arises: if the section change happens before the move, the move will work
		// if it does after the move, the move could be ineffective. In either case the change is gone.
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictMoveMoveSameObjectDifferentIndex() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy1 = RequirementFactory.eINSTANCE.createActor();
		Actor dummy2 = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);

		section.getModelElements().add(dummy1);
		section.getModelElements().add(dummy2);

		section.getModelElements().add(actor);
		assertEquals(section.getModelElements().get(2), actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().move(1, actor1);
		section2.getModelElements().move(0, actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		// an index conflict arises: result depends on which move comes last
		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictMoveMoveSameObjectSameIndex() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy1 = RequirementFactory.eINSTANCE.createActor();
		Actor dummy2 = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);

		section.getModelElements().add(dummy1);
		section.getModelElements().add(dummy2);

		section.getModelElements().add(actor);
		assertEquals(section.getModelElements().get(2), actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().move(1, actor1);
		section2.getModelElements().move(1, actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		// no index conflict arises: operations are identical
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddRemoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();
		Actor anotherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(anotherDummy);

		section.getModelElements().add(anotherDummy);
		section.getModelElements().add(otherDummy);
		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor otherDummy2 = (Actor) project2.getModelElement(otherDummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().add(2, actor1);
		section2.getModelElements().remove(otherDummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// an index-integrity conflict (the remove index:1 is smaller than the add index:2, thus the added item
		// ends up somewhere else, depending on serialization)
		assertEquals(1, conflicts.size());

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictAddRemoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);

		section.getModelElements().add(otherDummy);
		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().add(0, actor1);
		section2.getModelElements().remove(dummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict (the change happens at the boundary)
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddParentSetRemoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);

		section.getModelElements().add(otherDummy);
		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		section1.getModelElements().add(1, actor1);
		dummy2.setLeafSection(otherSection2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictAddParentSetRemoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);

		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);

		section.getModelElements().add(otherDummy);
		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().add(1, actor1);
		dummy2.setLeafSection(otherSection2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict (the change happens at the boundary)
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictParentSetAddRemoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);

		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		actor1.setLeafSection(section1);
		section2.getModelElements().remove(dummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict (outcome does not depend on serialization)
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictParentSetAddRemoveIndirectlyDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);

		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		actor1.setLeafSection(section1);
		otherSection2.getModelElements().add(dummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict (outcome does not depend on serialization)
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictParentSetAddParentSetRemoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);

		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		actor1.setLeafSection(section1);
		dummy2.setLeafSection(otherSection2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict (outcome does not depend on serialization)
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void nnoConflictAddParentSetRemoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);

		section.getModelElements().add(otherDummy);
		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		section1.getModelElements().add(actor1);
		dummy2.setLeafSection(otherSection2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// potential index-integrity conflict: it is unknown where dummy was located, worst case (before actor1
		// insertion point) anticipated
		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictAddRemoveIndirectlyDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(otherSection);

		section.getModelElements().add(otherDummy);
		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		section1.getModelElements().add(actor1);
		otherSection2.getModelElements().add(dummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// potential index-integrity conflict: it is unknown where dummy was located, worst case (before actor1
		// insertion point) anticipated
		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictRemoveRemoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(otherSection);

		section.getModelElements().add(otherDummy);
		section.getModelElements().add(actor);
		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().remove(actor1);
		section2.getModelElements().remove(dummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict: result independent of serialization
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictRemoveParentSetRemoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(otherSection);

		section.getModelElements().add(otherDummy);
		section.getModelElements().add(actor);
		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		section1.getModelElements().remove(actor1);
		otherSection2.getModelElements().add(dummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict: result independent of serialization
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictRemoveRemoveIndirectlyDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(otherSection);

		section.getModelElements().add(otherDummy);
		section.getModelElements().add(actor);
		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		section1.getModelElements().remove(actor1);
		otherSection2.getModelElements().add(dummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict: result independent of serialization
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictParentSetRemoveRemoveIndirectlyDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection anotherSection = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(anotherSection);

		section.getModelElements().add(otherDummy);
		section.getModelElements().add(actor);
		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection anotherSection1 = (LeafSection) getProject().getModelElement(anotherSection.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		actor1.setLeafSection(anotherSection1);
		otherSection2.getModelElements().add(dummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict: result independent of serialization
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictParentSetRemoveParentSetRemoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection anotherSection = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(anotherSection);

		section.getModelElements().add(otherDummy);
		section.getModelElements().add(actor);
		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection anotherSection1 = (LeafSection) getProject().getModelElement(anotherSection.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		actor1.setLeafSection(anotherSection1);
		dummy2.setLeafSection(otherSection2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict: result independent of serialization
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictRemoveIndirectlyRemoveIndirectlyDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection anotherSection = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(anotherSection);

		section.getModelElements().add(otherDummy);
		section.getModelElements().add(actor);
		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection anotherSection1 = (LeafSection) getProject().getModelElement(anotherSection.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		anotherSection1.getModelElements().add(actor1);
		otherSection2.getModelElements().add(dummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict: result independent of serialization
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddMoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();
		Actor anotherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(anotherDummy);

		section.getModelElements().add(dummy);
		section.getModelElements().add(otherDummy);
		section.getModelElements().add(anotherDummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor anotherDummy2 = (Actor) project2.getModelElement(anotherDummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().add(1, actor1);
		section2.getModelElements().move(1, anotherDummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// index-integrity conflict: result dependent on serialization
		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictAddMoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();
		Actor anotherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(anotherDummy);

		section.getModelElements().add(dummy);
		section.getModelElements().add(otherDummy);
		section.getModelElements().add(anotherDummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor anotherDummy2 = (Actor) project2.getModelElement(anotherDummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().add(0, actor1);
		section2.getModelElements().move(1, anotherDummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict: result independent of serialization
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetAddMoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();
		Actor anotherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(anotherDummy);

		section.getModelElements().add(dummy);
		section.getModelElements().add(otherDummy);
		section.getModelElements().add(anotherDummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor anotherDummy2 = (Actor) project2.getModelElement(anotherDummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		actor1.setLeafSection(section1);
		section2.getModelElements().move(1, anotherDummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// potential index-integrity conflict: if the move went to the index where actor1 ends up in
		// there would be a problem. The index is unknown, since the single ref op does not save it.
		// Since relation of these indices cannot be found prior to looking at the feature, a conflict is assumed
		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetAddMoveDifferentObjectBoundary() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();
		Actor anotherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(anotherDummy);

		// section.getModelElements().add(dummy);
		section.getModelElements().add(actor);
		section.getModelElements().add(otherDummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor dummy1 = (Actor) getProject().getModelElement(dummy.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());
		Actor anotherDummy2 = (Actor) project2.getModelElement(anotherDummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		dummy1.setLeafSection(section1);
		anotherDummy2.setLeafSection(section2);
		section2.getModelElements().move(section2.getModelElements().size() - 1, actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// two reasons to conflict: 1. two competing adds by parent, 2. add and move might (actually do) affect the same
		// index
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), 2);
		assertEquals(cd.getConflictingIndexIntegrity(ops2, ops1).size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictRemoveMoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();
		Actor anotherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(anotherDummy);

		section.getModelElements().add(actor);
		section.getModelElements().add(dummy);
		section.getModelElements().add(otherDummy);
		section.getModelElements().add(anotherDummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor anotherDummy2 = (Actor) project2.getModelElement(anotherDummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().remove(actor1);
		section2.getModelElements().move(1, anotherDummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// index-integrity conflict: result dependent on serialization
		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictRemoveMoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();
		Actor anotherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(anotherDummy);

		section.getModelElements().add(actor);
		section.getModelElements().add(dummy);
		section.getModelElements().add(otherDummy);
		section.getModelElements().add(anotherDummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor anotherDummy2 = (Actor) project2.getModelElement(anotherDummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().remove(actor1);
		section2.getModelElements().move(0, anotherDummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict: result independent of serialization
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictRemoveMoveDifferentObjectSameIndex() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();
		Actor anotherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(anotherDummy);

		section.getModelElements().add(actor);
		section.getModelElements().add(dummy);
		section.getModelElements().add(otherDummy);
		section.getModelElements().add(anotherDummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor dummy1 = (Actor) getProject().getModelElement(dummy.getModelElementId());
		Actor anotherDummy2 = (Actor) project2.getModelElement(anotherDummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().remove(dummy1);
		section2.getModelElements().move(1, anotherDummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict: result independent of serialization
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetRemoveMoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();
		Actor anotherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(anotherDummy);

		section.getModelElements().add(actor);
		section.getModelElements().add(dummy);
		section.getModelElements().add(otherDummy);
		section.getModelElements().add(anotherDummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor dummy1 = (Actor) getProject().getModelElement(dummy.getModelElementId());
		Actor anotherDummy2 = (Actor) project2.getModelElement(anotherDummy.getModelElementId());

		LeafSection otherSection1 = (LeafSection) getProject().getModelElement(otherSection.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		dummy1.setLeafSection(otherSection1);
		section2.getModelElements().move(1, anotherDummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict: result independent of serialization
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictParentSetRemoveMoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();
		Actor anotherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(anotherDummy);

		section.getModelElements().add(actor);
		section.getModelElements().add(dummy);
		section.getModelElements().add(otherDummy);
		section.getModelElements().add(anotherDummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor anotherDummy2 = (Actor) project2.getModelElement(anotherDummy.getModelElementId());

		LeafSection otherSection1 = (LeafSection) getProject().getModelElement(otherSection.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		actor1.setLeafSection(otherSection1);
		section2.getModelElements().move(1, anotherDummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// index-integrity conflict: result dependent of serialization (anotherDummy could end up on 1 or on 0)
		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictRemoveIndirectlyMoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();
		Actor anotherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(anotherDummy);

		section.getModelElements().add(actor);
		section.getModelElements().add(dummy);
		section.getModelElements().add(otherDummy);
		section.getModelElements().add(anotherDummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor dummy1 = (Actor) getProject().getModelElement(dummy.getModelElementId());
		Actor anotherDummy2 = (Actor) project2.getModelElement(anotherDummy.getModelElementId());

		LeafSection otherSection1 = (LeafSection) getProject().getModelElement(otherSection.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		otherSection1.getModelElements().add(dummy1);
		section2.getModelElements().move(1, anotherDummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict: result independent of serialization
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictRemoveIndirectlyMoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();
		Actor anotherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(anotherDummy);

		section.getModelElements().add(actor);
		section.getModelElements().add(dummy);
		section.getModelElements().add(otherDummy);
		section.getModelElements().add(anotherDummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor anotherDummy2 = (Actor) project2.getModelElement(anotherDummy.getModelElementId());

		LeafSection otherSection1 = (LeafSection) getProject().getModelElement(otherSection.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		otherSection1.getModelElements().add(actor1);
		section2.getModelElements().move(1, anotherDummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// index-integrity conflict: result dependent on serialization
		assertEquals(1, conflicts.size());

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictMoveMoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();
		Actor anotherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(anotherDummy);

		section.getModelElements().add(actor);
		section.getModelElements().add(dummy);
		section.getModelElements().add(otherDummy);
		section.getModelElements().add(anotherDummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor anotherDummy2 = (Actor) project2.getModelElement(anotherDummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().move(1, actor1);
		section2.getModelElements().move(1, anotherDummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// index-integrity conflict: result dependent on serialization
		assertEquals(1, conflicts.size());

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictMoveMoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();
		Actor anotherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(anotherDummy);

		section.getModelElements().add(actor);
		section.getModelElements().add(dummy);
		section.getModelElements().add(otherDummy);
		section.getModelElements().add(anotherDummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor anotherDummy2 = (Actor) project2.getModelElement(anotherDummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().move(2, actor1);
		section2.getModelElements().move(0, anotherDummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict: result independent of serialization
		assertEquals(0, conflicts.size());

	}

}
