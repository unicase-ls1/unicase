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
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
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

		LeafSection section1 = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection section2 = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section1);
		getProject().addModelElement(section2);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		ModelElementId actorId = ModelUtil.getProject(actor).getModelElementId(actor);
		ModelElementId section1Id = ModelUtil.getProject(section1).getModelElementId(section1);
		ModelElementId section2Id = ModelUtil.getProject(section2).getModelElementId(section2);

		Actor actor1 = (Actor) getProject().getModelElementId(actorId);
		Actor actor2 = (Actor) project2.getModelElementId(actorId);

		actor1.setLeafSection((LeafSection) getProject().getModelElementId(section1Id));
		actor2.setLeafSection((LeafSection) project2.getModelElementId(section2Id));

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

		LeafSection section1 = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection section2 = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section1);
		getProject().addModelElement(section2);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		ModelElementId actorId = ModelUtil.getProject(actor).getModelElementId(actor);
		ModelElementId section1Id = ModelUtil.getProject(section1).getModelElementId(section1);
		ModelElementId section2Id = ModelUtil.getProject(section2).getModelElementId(section2);

		Actor actor1 = (Actor) getProject().getModelElementId(actorId);
		Actor actor2 = (Actor) project2.getModelElementId(actorId);

		// attention: same structure is being built here, should not conflict
		actor1.setLeafSection((LeafSection) getProject().getModelElementId(section1Id));
		actor2.setLeafSection((LeafSection) project2.getModelElementId(section1Id));

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

		LeafSection section1 = DocumentFactory.eINSTANCE.createLeafSection();
		UserTask task = RequirementFactory.eINSTANCE.createUserTask();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section1);
		getProject().addModelElement(task);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		ModelElementId actorId = ModelUtil.getProject(actor).getModelElementId(actor);
		ModelElementId section1Id = ModelUtil.getProject(section1).getModelElementId(section1);
		ModelElementId taskId = ModelUtil.getProject(task).getModelElementId(task);

		Actor actor1 = (Actor) getProject().getModelElementId(actorId);
		Actor actor2 = (Actor) project2.getModelElementId(actorId);

		actor1.setLeafSection((LeafSection) getProject().getModelElementId(section1Id));
		actor2.setInitiatedUserTask((UserTask) project2.getModelElementId(taskId));

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

		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		Solution solution1 = RationaleFactory.eINSTANCE.createSolution();
		Solution solution2 = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue);
		getProject().addModelElement(solution1);
		getProject().addModelElement(solution2);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		ModelElementId issueId = ModelUtil.getProject(issue).getModelElementId(issue);
		ModelElementId solution2Id = ModelUtil.getProject(solution2).getModelElementId(solution2);
		ModelElementId solution1Id = ModelUtil.getProject(solution1).getModelElementId(solution1);

		Issue issue1 = (Issue) getProject().getModelElementId(issueId);
		Issue issue2 = (Issue) project2.getModelElementId(issueId);
		Solution solution22 = (Solution) project2.getModelElementId(solution2Id);

		issue1.setSolution((Solution) getProject().getModelElementId(solution1Id));
		solution22.setIssue(issue2);

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

		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		Solution solution = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue);
		getProject().addModelElement(solution);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		ModelElementId issueId = ModelUtil.getProject(issue).getModelElementId(issue);
		ModelElementId solutionId = ModelUtil.getProject(solution).getModelElementId(solution);

		Issue issue1 = (Issue) getProject().getModelElementId(issueId);
		Issue issue2 = (Issue) project2.getModelElementId(issueId);
		Solution solution2 = (Solution) project2.getModelElementId(solutionId);
		Solution solution1 = (Solution) getProject().getModelElementId(solutionId);

		issue1.setSolution(solution1);
		solution2.setIssue(issue2);

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

		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		Solution solution = RationaleFactory.eINSTANCE.createSolution();
		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		getProject().addModelElement(issue);
		getProject().addModelElement(solution);
		getProject().addModelElement(section);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		ModelElementId issueId = ModelUtil.getProject(issue).getModelElementId(issue);
		ModelElementId sectionId = ModelUtil.getProject(section).getModelElementId(section);
		ModelElementId solutionId = ModelUtil.getProject(solution).getModelElementId(solution);

		Issue issue1 = (Issue) getProject().getModelElementId(issueId);
		Solution solution1 = (Solution) getProject().getModelElementId(solutionId);
		Issue issue2 = (Issue) project2.getModelElementId(issueId);
		LeafSection section2 = (LeafSection) project2.getModelElementId(sectionId);

		issue1.setSolution(solution1);
		issue2.setLeafSection(section2);

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

		LeafSection section1 = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection section2 = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section1);
		getProject().addModelElement(section2);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		ModelElementId actorId = ModelUtil.getProject(actor).getModelElementId(actor);
		ModelElementId section1Id = ModelUtil.getProject(section1).getModelElementId(section1);
		ModelElementId section2Id = ModelUtil.getProject(section2).getModelElementId(section2);

		Actor actor1 = (Actor) getProject().getModelElementId(actorId);
		Actor actor2 = (Actor) project2.getModelElementId(actorId);
		LeafSection section22 = (LeafSection) project2.getModelElementId(section2Id);

		actor1.setLeafSection((LeafSection) getProject().getModelElementId(section1Id));
		section22.getModelElements().add(actor2);

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

		LeafSection section1 = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection section2 = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section1);
		getProject().addModelElement(section2);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		ModelElementId actorId = ModelUtil.getProject(actor).getModelElementId(actor);
		ModelElementId section1Id = ModelUtil.getProject(section1).getModelElementId(section1);
		ModelElementId section2Id = ModelUtil.getProject(section2).getModelElementId(section2);

		Actor actor1 = (Actor) getProject().getModelElementId(actorId);
		Actor actor2 = (Actor) project2.getModelElementId(actorId);
		LeafSection section12 = (LeafSection) project2.getModelElementId(section1Id);

		actor1.setLeafSection((LeafSection) getProject().getModelElementId(section1Id));
		section12.getModelElements().add(actor2);

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

		LeafSection section1 = DocumentFactory.eINSTANCE.createLeafSection();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section1);
		getProject().addModelElement(useCase);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		ModelElementId actorId = ModelUtil.getProject(actor).getModelElementId(actor);
		ModelElementId section1Id = ModelUtil.getProject(section1).getModelElementId(section1);
		ModelElementId useCaseId = ModelUtil.getProject(useCase).getModelElementId(useCase);

		Actor actor1 = (Actor) getProject().getModelElementId(actorId);
		Actor actor2 = (Actor) project2.getModelElementId(actorId);

		actor1.setLeafSection((LeafSection) getProject().getModelElementId(section1Id));
		actor2.getInitiatedUseCases().add(((UseCase) project2.getModelElementId(useCaseId)));

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

		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		Solution solution1 = RationaleFactory.eINSTANCE.createSolution();
		Solution solution2 = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue);
		getProject().addModelElement(solution1);
		getProject().addModelElement(solution2);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		ModelElementId issueId = ModelUtil.getProject(issue).getModelElementId(issue);
		ModelElementId solution1Id = ModelUtil.getProject(solution1).getModelElementId(solution1);
		ModelElementId solution2Id = ModelUtil.getProject(solution2).getModelElementId(solution2);

		Issue issue1 = (Issue) getProject().getModelElementId(issueId);
		Issue issue2 = (Issue) project2.getModelElementId(issueId);
		Solution solution11 = (Solution) getProject().getModelElementId(solution1Id);
		Solution solution22 = (Solution) project2.getModelElementId(solution2Id);

		solution11.setIssue(issue1);
		solution22.setIssue(issue2);

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

		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		Solution solution1 = RationaleFactory.eINSTANCE.createSolution();
		Solution solution2 = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue);
		getProject().addModelElement(solution1);
		getProject().addModelElement(solution2);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		ModelElementId issueId = ModelUtil.getProject(issue).getModelElementId(issue);
		ModelElementId solution1Id = ModelUtil.getProject(solution1).getModelElementId(solution1);

		Issue issue1 = (Issue) getProject().getModelElementId(issueId);
		Issue issue2 = (Issue) project2.getModelElementId(issueId);
		Solution solution11 = (Solution) getProject().getModelElementId(solution1Id);
		Solution solution12 = (Solution) project2.getModelElementId(solution1Id);

		solution11.setIssue(issue1);
		solution12.setIssue(issue2);

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

		Issue issue1 = RationaleFactory.eINSTANCE.createIssue();
		Issue issue2 = RationaleFactory.eINSTANCE.createIssue();
		Solution solution1 = RationaleFactory.eINSTANCE.createSolution();
		Solution solution2 = RationaleFactory.eINSTANCE.createSolution();

		getProject().addModelElement(issue1);
		getProject().addModelElement(issue2);
		getProject().addModelElement(solution1);
		getProject().addModelElement(solution2);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		ModelElementId issue1Id = ModelUtil.getProject(issue1).getModelElementId(issue1);
		ModelElementId issue2Id = ModelUtil.getProject(issue2).getModelElementId(issue2);
		ModelElementId solution1Id = ModelUtil.getProject(solution1).getModelElementId(solution1);
		ModelElementId solution2Id = ModelUtil.getProject(solution2).getModelElementId(solution2);

		Issue issue11 = (Issue) getProject().getModelElementId(issue1Id);
		Issue issue22 = (Issue) project2.getModelElementId(issue2Id);
		Solution solution11 = (Solution) getProject().getModelElementId(solution1Id);
		Solution solution22 = (Solution) project2.getModelElementId(solution2Id);

		solution11.setIssue(issue11);
		solution22.setIssue(issue22);

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

		LeafSection section1 = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection section2 = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section1);
		getProject().addModelElement(section2);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		ModelElementId actorId = ModelUtil.getProject(actor).getModelElementId(actor);
		ModelElementId section1Id = ModelUtil.getProject(section1).getModelElementId(section1);
		ModelElementId section2Id = ModelUtil.getProject(section2).getModelElementId(section2);

		Actor actor1 = (Actor) getProject().getModelElementId(actorId);
		Actor actor2 = (Actor) project2.getModelElementId(actorId);
		LeafSection section11 = (LeafSection) getProject().getModelElementId(section1Id);
		LeafSection section22 = (LeafSection) project2.getModelElementId(section2Id);

		section11.getModelElements().add(actor1);
		section22.getModelElements().add(actor2);

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

		LeafSection section1 = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection section2 = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section1);
		getProject().addModelElement(section2);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		ModelElementId actorId = ModelUtil.getProject(actor).getModelElementId(actor);
		ModelElementId section1Id = ModelUtil.getProject(section1).getModelElementId(section1);
		ModelElementId section2Id = ModelUtil.getProject(section2).getModelElementId(section2);

		Actor actor1 = (Actor) getProject().getModelElementId(actorId);
		Actor actor2 = (Actor) project2.getModelElementId(actorId);
		LeafSection section11 = (LeafSection) getProject().getModelElementId(section1Id);
		LeafSection section12 = (LeafSection) project2.getModelElementId(section1Id);

		section11.getModelElements().add(actor1);
		section12.getModelElements().add(actor2);

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

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(useCase);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		ModelElementId actorId = ModelUtil.getProject(actor).getModelElementId(actor);
		ModelElementId sectionId = ModelUtil.getProject(section).getModelElementId(section);
		ModelElementId useCaseId = ModelUtil.getProject(useCase).getModelElementId(useCase);

		Actor actor1 = (Actor) getProject().getModelElementId(actorId);
		Actor actor2 = (Actor) project2.getModelElementId(actorId);
		LeafSection section1 = (LeafSection) getProject().getModelElementId(sectionId);

		section1.getModelElements().add(actor1);
		actor2.getInitiatedUseCases().add(((UseCase) project2.getModelElementId(useCaseId)));

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 0);

	}

}
