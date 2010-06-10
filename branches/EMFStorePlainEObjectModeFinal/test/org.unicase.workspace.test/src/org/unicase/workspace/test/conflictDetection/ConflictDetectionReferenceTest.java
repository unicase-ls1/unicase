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
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.rationale.Solution;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.requirement.UserTask;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Tests conflict detection behaviour on attributes.
 * 
 * @author chodnick
 */
public class ConflictDetectionReferenceTest extends ConflictDetectionTest {

	/**
	 * Tests if overwriting of references is detected as conflict.
	 */
	@Test
	public void conflictSingleReference() {

		final LeafSection section1 = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection section2 = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section1);
				getProject().addModelElement(section2);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		final Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setLeafSection((LeafSection) getProject().getModelElement(section1.getModelElementId()));
				actor2.setLeafSection((LeafSection) project2.getModelElement(section2.getModelElementId()));

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if overwriting of single references is detected as conflict.
	 */
	@Test
	public void noConflictSingleReferenceSameValue() {

		final LeafSection section1 = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection section2 = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section1);
				getProject().addModelElement(section2);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		final Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		// attention: same structure is being built here, should not conflict
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setLeafSection((LeafSection) getProject().getModelElement(section1.getModelElementId()));
				actor2.setLeafSection((LeafSection) project2.getModelElement(section1.getModelElementId()));

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(0, conflicts.size());

	}

	/**
	 * Tests if overwriting of references is detected as conflict.
	 */
	@Test
	public void noConflictSingleReferenceUnrelated() {

		final LeafSection section1 = DocumentFactory.eINSTANCE.createLeafSection();
		final UserTask task = RequirementFactory.eINSTANCE.createUserTask();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {

				getProject().addModelElement(section1);
				getProject().addModelElement(task);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		final Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setLeafSection((LeafSection) getProject().getModelElement(section1.getModelElementId()));
				actor2.setInitiatedUserTask((UserTask) project2.getModelElement(task.getModelElementId()));

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if overwriting of references is detected as conflict.
	 */
	@Test
	public void conflictSingleReferenceOpposite() {

		final Issue issue = RationaleFactory.eINSTANCE.createIssue();
		final Solution solution1 = RationaleFactory.eINSTANCE.createSolution();
		final Solution solution2 = RationaleFactory.eINSTANCE.createSolution();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(issue);
				getProject().addModelElement(solution1);
				getProject().addModelElement(solution2);

				getProjectSpace().getOperations().clear();

			}
		}.run();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Issue issue1 = (Issue) getProject().getModelElement(issue.getModelElementId());
		final Issue issue2 = (Issue) project2.getModelElement(issue.getModelElementId());
		final Solution solution22 = (Solution) project2.getModelElement(solution2.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				issue1.setSolution((Solution) getProject().getModelElement(solution1.getModelElementId()));
				solution22.setIssue(issue2);

			}
		}.run();
		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(1, conflicts.size());

	}

	/**
	 * Tests if overwriting of references is detected as conflict.
	 */
	@Test
	public void noConflictSingleReferenceOppositeSameValue() {

		final Issue issue = RationaleFactory.eINSTANCE.createIssue();
		final Solution solution = RationaleFactory.eINSTANCE.createSolution();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(issue);
				getProject().addModelElement(solution);

				getProjectSpace().getOperations().clear();

			}
		}.run();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Issue issue1 = (Issue) getProject().getModelElement(issue.getModelElementId());
		final Issue issue2 = (Issue) project2.getModelElement(issue.getModelElementId());
		final Solution solution2 = (Solution) project2.getModelElement(solution.getModelElementId());
		final Solution solution1 = (Solution) getProject().getModelElement(solution.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				issue1.setSolution(solution1);
				solution2.setIssue(issue2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(0, conflicts.size());

	}

	/**
	 * Tests if overwriting of references is detected as conflict.
	 */
	@Test
	public void noConflictSingleReferenceOppositeUnrelated() {

		final Issue issue = RationaleFactory.eINSTANCE.createIssue();
		final Solution solution = RationaleFactory.eINSTANCE.createSolution();
		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(issue);
				getProject().addModelElement(solution);
				getProject().addModelElement(section);

				getProjectSpace().getOperations().clear();

			}
		}.run();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Issue issue1 = (Issue) getProject().getModelElement(issue.getModelElementId());
		final Solution solution1 = (Solution) getProject().getModelElement(solution.getModelElementId());
		final Issue issue2 = (Issue) project2.getModelElement(issue.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				issue1.setSolution(solution1);
				issue2.setLeafSection(section2);
			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(0, conflicts.size());

	}

	/**
	 * Tests if overwriting of single references is detected as conflict.
	 */
	@Test
	public void conflictSingleMultiReference() {

		final LeafSection section1 = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection section2 = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section1);
				getProject().addModelElement(section2);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());
		final LeafSection section22 = (LeafSection) project2.getModelElement(section2.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setLeafSection((LeafSection) getProject().getModelElement(section1.getModelElementId()));
				section22.getModelElements().add(actor2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(1, conflicts.size());

	}

	/**
	 * Tests if overwriting of single references is detected as conflict.
	 */
	@Test
	public void noConflictSingleMultiReferenceSameValue() {

		final LeafSection section1 = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection section2 = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section1);
				getProject().addModelElement(section2);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());
		final LeafSection section12 = (LeafSection) project2.getModelElement(section1.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {

				actor1.setLeafSection((LeafSection) getProject().getModelElement(section1.getModelElementId()));
				section12.getModelElements().add(actor2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(0, conflicts.size());

	}

	/**
	 * Tests if overwriting of references is detected as conflict.
	 */
	@Test
	public void noConflictSingleMultiReferenceUnrelated() {

		final LeafSection section1 = DocumentFactory.eINSTANCE.createLeafSection();
		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section1);
				getProject().addModelElement(useCase);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		final Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setLeafSection((LeafSection) getProject().getModelElement(section1.getModelElementId()));
				actor2.getInitiatedUseCases().add(((UseCase) project2.getModelElement(useCase.getModelElementId())));

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if overwriting of references is detected as conflict.
	 */
	@Test
	public void conflictSingleReferenceBothOpposite() {

		final Issue issue = RationaleFactory.eINSTANCE.createIssue();
		final Solution solution1 = RationaleFactory.eINSTANCE.createSolution();
		final Solution solution2 = RationaleFactory.eINSTANCE.createSolution();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(issue);
				getProject().addModelElement(solution1);
				getProject().addModelElement(solution2);

				getProjectSpace().getOperations().clear();

			}
		}.run();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Issue issue1 = (Issue) getProject().getModelElement(issue.getModelElementId());
		final Issue issue2 = (Issue) project2.getModelElement(issue.getModelElementId());
		final Solution solution11 = (Solution) getProject().getModelElement(solution1.getModelElementId());
		final Solution solution22 = (Solution) project2.getModelElement(solution2.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				solution11.setIssue(issue1);
				solution22.setIssue(issue2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(1, conflicts.size());

	}

	/**
	 * Tests if overwriting of references is detected as conflict.
	 */
	@Test
	public void noConflictSingleReferenceBothOppositeSameValue() {

		final Issue issue = RationaleFactory.eINSTANCE.createIssue();
		final Solution solution1 = RationaleFactory.eINSTANCE.createSolution();
		final Solution solution2 = RationaleFactory.eINSTANCE.createSolution();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(issue);
				getProject().addModelElement(solution1);
				getProject().addModelElement(solution2);

				getProjectSpace().getOperations().clear();

			}
		}.run();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Issue issue1 = (Issue) getProject().getModelElement(issue.getModelElementId());
		final Issue issue2 = (Issue) project2.getModelElement(issue.getModelElementId());
		final Solution solution11 = (Solution) getProject().getModelElement(solution1.getModelElementId());
		final Solution solution12 = (Solution) project2.getModelElement(solution1.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				solution11.setIssue(issue1);
				solution12.setIssue(issue2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(0, conflicts.size());

	}

	/**
	 * Tests if overwriting of references is detected as conflict.
	 */
	@Test
	public void noConflictSingleReferenceBothOppositeUnrelated() {

		final Issue issue1 = RationaleFactory.eINSTANCE.createIssue();
		final Issue issue2 = RationaleFactory.eINSTANCE.createIssue();
		final Solution solution1 = RationaleFactory.eINSTANCE.createSolution();
		final Solution solution2 = RationaleFactory.eINSTANCE.createSolution();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(issue1);
				getProject().addModelElement(issue2);
				getProject().addModelElement(solution1);
				getProject().addModelElement(solution2);

				getProjectSpace().getOperations().clear();

			}
		}.run();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Issue issue11 = (Issue) getProject().getModelElement(issue1.getModelElementId());
		final Issue issue22 = (Issue) project2.getModelElement(issue2.getModelElementId());
		final Solution solution11 = (Solution) getProject().getModelElement(solution1.getModelElementId());
		final Solution solution22 = (Solution) project2.getModelElement(solution2.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				solution11.setIssue(issue11);
				solution22.setIssue(issue22);

			}
		}.run();
		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(0, conflicts.size());

	}

	/**
	 * Tests if overwriting of single references is detected as conflict.
	 */
	@Test
	public void conflictMultiMultiReferenceBothOpposite() {

		final LeafSection section1 = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection section2 = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section1);
				getProject().addModelElement(section2);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());
		final LeafSection section11 = (LeafSection) getProject().getModelElement(section1.getModelElementId());
		final LeafSection section22 = (LeafSection) project2.getModelElement(section2.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				section11.getModelElements().add(actor1);
				section22.getModelElements().add(actor2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(1, conflicts.size());

	}

	/**
	 * Tests if overwriting of single references is detected as conflict.
	 */
	@Test
	public void noConflictMultiMultiReferenceSameChange() {

		final LeafSection section1 = DocumentFactory.eINSTANCE.createLeafSection();
		final LeafSection section2 = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section1);
				getProject().addModelElement(section2);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());
		final LeafSection section11 = (LeafSection) getProject().getModelElement(section1.getModelElementId());
		final LeafSection section12 = (LeafSection) project2.getModelElement(section1.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				section11.getModelElements().add(actor1);
				section12.getModelElements().add(actor2);

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(0, conflicts.size());

	}

	/**
	 * Tests if overwriting of references is detected as conflict.
	 */
	@Test
	public void noConflictMultiMultiReferenceUnrelated() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(useCase);
				getProject().addModelElement(actor);

				getProjectSpace().getOperations().clear();

			}
		}.run();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		final Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());
		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				section1.getModelElements().add(actor1);
				actor2.getInitiatedUseCases().add(((UseCase) project2.getModelElement(useCase.getModelElementId())));

			}
		}.run();

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 0);

	}

}
