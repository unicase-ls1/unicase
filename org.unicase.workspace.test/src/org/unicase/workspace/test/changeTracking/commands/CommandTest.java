/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.test.changeTracking.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.command.CopyToClipboardCommand;
import org.eclipse.emf.edit.command.CutToClipboardCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.Test;
import org.unicase.ecpemfstorebridge.EMFStoreModelelementContext;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.DocumentPackage;
import org.unicase.model.document.LeafSection;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.Comment;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;
import org.unicase.workspace.test.WorkspaceTest;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Tests for the command recording to detect deletes, cuts and copies.
 * 
 * @author koegel
 */
public class CommandTest extends WorkspaceTest {

	/**
	 * Tests the copy to clipboard and paste from clipboard command.
	 */
	@Test
	public void copyAndPasteFromClipboardCommand() {

		final LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		leafSection.getModelElements().add(actor);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(leafSection);
			}
		}.run();

		TransactionalEditingDomain editingDomain = Configuration.getEditingDomain();

		// copy to clipboard
		Collection<ModelElement> toCopy = new ArrayList<ModelElement>();
		toCopy.add(actor);
		Command copyCommand = editingDomain.createCommand(CopyToClipboardCommand.class, new CommandParameter(null,
			null, toCopy));
		editingDomain.getCommandStack().execute(copyCommand);

		// paste from clipboard
		Command pasteCommand = editingDomain.createCommand(PasteFromClipboardCommand.class, new CommandParameter(
			leafSection, DocumentPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS, Collections.emptyList(),
			CommandParameter.NO_INDEX));

		editingDomain.getCommandStack().execute(pasteCommand);

		ModelElement copyOfActor = leafSection.getModelElements().get(1);

		assertTrue(actor.getModelElementId().equals(actor.getModelElementId()));
		assertTrue(!copyOfActor.getModelElementId().equals(actor.getModelElementId()));
	}

	/**
	 * Tests to delete a workpackage with a containec command with a recipient. This test also the removal o
	 * unicdirectional cross references
	 */
	@Test
	public void testDeleteWithUnidirectionalCrossReference() {
		final CompositeSection createCompositeSection = DocumentFactory.eINSTANCE.createCompositeSection();
		final LeafSection createLeafSection = DocumentFactory.eINSTANCE.createLeafSection();
		final WorkPackage createWorkPackage = TaskFactory.eINSTANCE.createWorkPackage();
		final ActionItem createActionItem = TaskFactory.eINSTANCE.createActionItem();
		final Comment createComment = RationaleFactory.eINSTANCE.createComment();
		final User createUser = OrganizationFactory.eINSTANCE.createUser();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(createCompositeSection);
				createCompositeSection.getSubsections().add(createLeafSection);
				createLeafSection.getModelElements().add(createWorkPackage);
				createLeafSection.getModelElements().add(createUser);
				createWorkPackage.getContainedWorkItems().add(createActionItem);
				createActionItem.getComments().add(createComment);
				createComment.getRecipients().add(createUser);

			}
		}.run();

		Command delete = DeleteCommand.create(Configuration.getEditingDomain(), createWorkPackage);
		Configuration.getEditingDomain().getCommandStack().execute(delete);

		assertEquals(0, createComment.getRecipients().size());

	}

	/**
	 * Tests the copy and paste commands.
	 */
	@Test
	public void copyAndPasteCommand() {

		final LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		leafSection.getModelElements().add(actor);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(leafSection);
			}
		}.run();

		TransactionalEditingDomain editingDomain = Configuration.getEditingDomain();

		// copy
		CopyCommand.Helper helper = new CopyCommand.Helper();
		CopyCommand command = (CopyCommand) editingDomain.createCommand(CopyCommand.class, new CommandParameter(actor,
			null, helper));
		editingDomain.getCommandStack().execute(command);

		// paste
		Actor copyOfActor = (Actor) helper.get(actor);

		Collection<Actor> toPaste = new ArrayList<Actor>();
		toPaste.add(copyOfActor);

		Command pasteCommand = editingDomain.createCommand(AddCommand.class, new CommandParameter(leafSection,
			DocumentPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS, toPaste, CommandParameter.NO_INDEX));

		editingDomain.getCommandStack().execute(pasteCommand);

		ModelElement copyOfActorRead = leafSection.getModelElements().get(1);

		assertTrue(actor.getModelElementId().equals(actor.getModelElementId()));
		assertTrue(!actor.getModelElementId().equals(copyOfActorRead.getModelElementId()));

	}

	/**
	 * Tests the copy to clipboard and paste from clipboard command.
	 */
	@Test
	public void copyAndPasteFromClipboardCommandDirectCreation() {

		final LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		leafSection.getModelElements().add(actor);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(leafSection);
			}
		}.run();

		TransactionalEditingDomain editingDomain = Configuration.getEditingDomain();

		// copy
		Command command = CopyToClipboardCommand.create(editingDomain, actor);
		editingDomain.getCommandStack().execute(command);

		// paste
		Command pasteCommand = PasteFromClipboardCommand.create(editingDomain, leafSection,
			DocumentPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS, CommandParameter.NO_INDEX);
		editingDomain.getCommandStack().execute(pasteCommand);

		ModelElement copyOfActorRead = leafSection.getModelElements().get(1);

		assertTrue(actor.getModelElementId().equals(actor.getModelElementId()));
		assertTrue(!actor.getModelElementId().equals(copyOfActorRead.getModelElementId()));
	}

	/**
	 * Tests the copy and paste commands.
	 */
	@Test
	public void copyAndPasteCommandDirectCreation() {

		final LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		leafSection.getModelElements().add(actor);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(leafSection);
			}
		}.run();

		TransactionalEditingDomain editingDomain = Configuration.getEditingDomain();

		// copy
		Command command = CopyCommand.create(editingDomain, actor);
		editingDomain.getCommandStack().execute(command);

		// paste
		Actor copyOfActor = (Actor) command.getResult().toArray()[0];

		Collection<Actor> toPaste = new ArrayList<Actor>();
		toPaste.add(copyOfActor);

		Command pasteCommand = AddCommand.create(editingDomain, leafSection,
			DocumentPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS, toPaste, CommandParameter.NO_INDEX);

		editingDomain.getCommandStack().execute(pasteCommand);

		ModelElement copyOfActorRead = leafSection.getModelElements().get(1);

		assertTrue(actor.getModelElementId().equals(actor.getModelElementId()));
		assertTrue(!actor.getModelElementId().equals(copyOfActorRead.getModelElementId()));

	}

	/**
	 * check element deletion tracking.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void deleteCommandTest() throws UnsupportedOperationException, UnsupportedNotificationException {

		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(useCase);
				clearOperations();
			}
		}.run();

		Command deleteCommand = DeleteCommand.create(Configuration.getEditingDomain(), useCase);
		Configuration.getEditingDomain().getCommandStack().execute(deleteCommand);

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof CreateDeleteOperation);
		CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation) operation;

		assertEquals(useCase.getModelElementId(), createDeleteOperation.getModelElementId());
		assertEquals(useCase.getModelElementId(), createDeleteOperation.getModelElement().getModelElementId());
		assertEquals(0, createDeleteOperation.getSubOperations().size());
		assertEquals(true, createDeleteOperation.isDelete());
	}

	/**
	 * check complex element deletion tracking.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	// BEGIN COMPLEX CODE
	public void complexDeleteCommandTest() throws UnsupportedOperationException, UnsupportedNotificationException {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		final Actor oldActor = RequirementFactory.eINSTANCE.createActor();
		final Actor newActor = RequirementFactory.eINSTANCE.createActor();
		final Actor otherActor = RequirementFactory.eINSTANCE.createActor();

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				section.getModelElements().add(useCase);
				section.getModelElements().add(oldActor);
				getProject().addModelElement(newActor);
				getProject().addModelElement(otherActor);
				useCase.setInitiatingActor(oldActor);
				useCase.getParticipatingActors().add(newActor);
				useCase.getParticipatingActors().add(otherActor);
				assertEquals(true, getProject().contains(useCase));
				assertEquals(getProject(), useCase.getProject());
				clearOperations();
			}
		}.run();

		Command deleteCommand = DeleteCommand.create(Configuration.getEditingDomain(), useCase);
		Configuration.getEditingDomain().getCommandStack().execute(deleteCommand);

		assertEquals(false, getProject().contains(useCase));
		assertEquals(null, useCase.eContainer());

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof CreateDeleteOperation);
		CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation) operation;
		assertEquals(true, createDeleteOperation.isDelete());
		assertEquals(useCase.getModelElementId(), createDeleteOperation.getModelElementId());
		assertEquals(useCase.getModelElementId(), createDeleteOperation.getModelElement().getModelElementId());
		EList<ReferenceOperation> subOperations = createDeleteOperation.getSubOperations();

		assertEquals(8, subOperations.size());
		AbstractOperation suboperation0 = subOperations.get(0);
		AbstractOperation suboperation1 = subOperations.get(1);
		AbstractOperation suboperation2 = subOperations.get(2);
		AbstractOperation suboperation3 = subOperations.get(3);
		AbstractOperation suboperation4 = subOperations.get(4);
		AbstractOperation suboperation5 = subOperations.get(5);
		AbstractOperation suboperation6 = subOperations.get(6);
		AbstractOperation suboperation7 = subOperations.get(7);

		assertEquals(true, suboperation0 instanceof SingleReferenceOperation);
		assertEquals(true, suboperation1 instanceof MultiReferenceOperation);
		assertEquals(true, suboperation2 instanceof SingleReferenceOperation);
		assertEquals(true, suboperation3 instanceof MultiReferenceOperation);
		assertEquals(true, suboperation4 instanceof MultiReferenceOperation);
		assertEquals(true, suboperation5 instanceof MultiReferenceOperation);
		assertEquals(true, suboperation6 instanceof MultiReferenceOperation);
		assertEquals(true, suboperation7 instanceof MultiReferenceOperation);

		SingleReferenceOperation mrSuboperation0 = (SingleReferenceOperation) suboperation0;
		MultiReferenceOperation mrSuboperation1 = (MultiReferenceOperation) suboperation1;
		MultiReferenceOperation mrSuboperation2 = (MultiReferenceOperation) suboperation3;
		SingleReferenceOperation mrSuboperation3 = (SingleReferenceOperation) suboperation2;
		MultiReferenceOperation mrSuboperation4 = (MultiReferenceOperation) suboperation5;
		MultiReferenceOperation mrSuboperation5 = (MultiReferenceOperation) suboperation4;
		MultiReferenceOperation mrSuboperation6 = (MultiReferenceOperation) suboperation6;
		MultiReferenceOperation mrSuboperation7 = (MultiReferenceOperation) suboperation7;

		assertEquals(useCase.getModelElementId(), mrSuboperation0.getModelElementId());
		assertEquals("leafSection", mrSuboperation0.getFeatureName());
		assertEquals(section.getModelElementId(), mrSuboperation0.getOldValue());
		assertEquals(null, mrSuboperation0.getNewValue());

		assertEquals("modelElements", mrSuboperation1.getFeatureName());
		assertEquals(0, mrSuboperation1.getIndex());
		assertEquals(section.getModelElementId(), mrSuboperation1.getModelElementId());
		assertEquals("leafSection", mrSuboperation1.getOppositeFeatureName());
		assertEquals(false, mrSuboperation1.isAdd());
		assertEquals(true, mrSuboperation1.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements3 = mrSuboperation1.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements3.size());
		EList<ModelElementId> referencedModelElements3 = mrSuboperation1.getReferencedModelElements();
		assertEquals(1, referencedModelElements3.size());
		assertEquals(useCase.getModelElementId(), referencedModelElements3.get(0));

		assertEquals(oldActor.getModelElementId(), mrSuboperation3.getOldValue());
		assertEquals(null, mrSuboperation3.getNewValue());
		assertEquals("initiatingActor", mrSuboperation3.getFeatureName());
		assertEquals(useCase.getModelElementId(), mrSuboperation3.getModelElementId());
		assertEquals("initiatedUseCases", mrSuboperation3.getOppositeFeatureName());
		assertEquals(true, mrSuboperation3.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements = mrSuboperation3.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements.size());
		assertEquals(oldActor.getModelElementId(), otherInvolvedModelElements.iterator().next());

		assertEquals("initiatedUseCases", mrSuboperation2.getFeatureName());
		assertEquals(0, mrSuboperation2.getIndex());
		assertEquals(oldActor.getModelElementId(), mrSuboperation2.getModelElementId());
		assertEquals("initiatingActor", mrSuboperation2.getOppositeFeatureName());
		assertEquals(false, mrSuboperation2.isAdd());
		assertEquals(true, mrSuboperation2.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements0 = mrSuboperation2.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements0.size());
		EList<ModelElementId> referencedModelElements0 = mrSuboperation2.getReferencedModelElements();
		assertEquals(1, referencedModelElements0.size());
		assertEquals(useCase.getModelElementId(), referencedModelElements0.get(0));

		assertEquals("participatingActors", mrSuboperation5.getFeatureName());
		assertEquals(0, mrSuboperation5.getIndex());
		assertEquals(useCase.getModelElementId(), mrSuboperation5.getModelElementId());
		assertEquals("participatedUseCases", mrSuboperation5.getOppositeFeatureName());
		assertEquals(false, mrSuboperation5.isAdd());
		assertEquals(true, mrSuboperation5.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements2 = mrSuboperation5.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements2.size());
		EList<ModelElementId> referencedModelElements = mrSuboperation5.getReferencedModelElements();
		assertEquals(1, referencedModelElements.size());
		assertEquals(newActor.getModelElementId(), referencedModelElements.get(0));

		assertEquals(newActor.getModelElementId(), mrSuboperation4.getModelElementId());
		assertEquals("participatedUseCases", mrSuboperation4.getFeatureName());
		assertEquals(false, mrSuboperation4.isAdd());
		assertEquals(1, mrSuboperation4.getReferencedModelElements().size());
		assertEquals(useCase.getModelElementId(), mrSuboperation4.getReferencedModelElements().get(0));

		assertEquals("participatingActors", mrSuboperation6.getFeatureName());
		assertEquals(0, mrSuboperation6.getIndex());
		assertEquals(useCase.getModelElementId(), mrSuboperation6.getModelElementId());
		assertEquals("participatedUseCases", mrSuboperation6.getOppositeFeatureName());
		assertEquals(false, mrSuboperation6.isAdd());
		assertEquals(true, mrSuboperation6.isBidirectional());
		Set<ModelElementId> otherInvolvedModelElements2b = mrSuboperation6.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements2b.size());
		EList<ModelElementId> referencedModelElements2b = mrSuboperation6.getReferencedModelElements();
		assertEquals(1, referencedModelElements2b.size());
		assertEquals(otherActor.getModelElementId(), referencedModelElements2b.get(0));

		assertEquals(otherActor.getModelElementId(), mrSuboperation7.getModelElementId());
		assertEquals("participatedUseCases", mrSuboperation7.getFeatureName());
		assertEquals(false, mrSuboperation7.isAdd());
		assertEquals(1, mrSuboperation7.getReferencedModelElements().size());
		assertEquals(useCase.getModelElementId(), mrSuboperation7.getReferencedModelElements().get(0));

	}

	/**
	 * Tests the copy to clipboard and paste from clipboard command.
	 */
	@Test
	public void cutAndPasteFromClipboardCommand() {

		final LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		leafSection.getModelElements().add(actor);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(leafSection);
			}
		}.run();

		TransactionalEditingDomain editingDomain = Configuration.getEditingDomain();

		// cut to clipboard
		Collection<Actor> toCut = new ArrayList<Actor>();
		toCut.add(actor);
		Command copyCommand = editingDomain.createCommand(CutToClipboardCommand.class, new CommandParameter(
			leafSection, DocumentPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS, toCut));

		editingDomain.getCommandStack().execute(copyCommand);

		assertEquals(0, leafSection.getModelElements().size());
		assertTrue(editingDomain.getCommandStack().canUndo());

		// undo the cut command
		editingDomain.getCommandStack().undo();

		assertEquals(1, leafSection.getModelElements().size());
		assertTrue(editingDomain.getCommandStack().canRedo());

		// redo the cut command
		editingDomain.getCommandStack().redo();

		assertEquals(0, leafSection.getModelElements().size());

		// paste from clipboard
		Command pasteCommand = editingDomain.createCommand(PasteFromClipboardCommand.class, new CommandParameter(
			leafSection, DocumentPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS, Collections.emptyList(),
			CommandParameter.NO_INDEX));

		editingDomain.getCommandStack().execute(pasteCommand);

		Actor pastedActor = (Actor) leafSection.getModelElements().get(0);

		// assert that the ids are not equal
		assertTrue(actor.getModelElementId().equals(pastedActor.getModelElementId()));
		assertEquals(1, leafSection.getModelElements().size());

		// undo the paste command
		editingDomain.getCommandStack().undo();

		assertEquals(0, leafSection.getModelElements().size());

		// redo the paste command
		editingDomain.getCommandStack().redo();

		Actor pastedActor2 = (Actor) leafSection.getModelElements().get(0);

		assertTrue(actor.getModelElementId().equals(pastedActor2.getModelElementId()));
		assertEquals(1, leafSection.getModelElements().size());
	}

	/**
	 * Tests the cut to clipboard and paste from clipboard command.
	 */
	@Test
	public void cutAndPasteFromClipboardCommand_DirectCreation() {

		final LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		leafSection.getModelElements().add(actor);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(leafSection);
			}
		}.run();

		TransactionalEditingDomain editingDomain = Configuration.getEditingDomain();

		// copy to clipboard
		Command cutCommand = CutToClipboardCommand.create(editingDomain, leafSection,
			DocumentPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS, actor);

		if (cutCommand.canExecute()) {
			editingDomain.getCommandStack().execute(cutCommand);
		} else {
			fail("Command not executable");
		}
		assertEquals(0, leafSection.getModelElements().size());
		assertTrue(editingDomain.getCommandStack().canUndo());

		// undo the cut command
		editingDomain.getCommandStack().undo();
		assertEquals(1, leafSection.getModelElements().size());
		assertTrue(editingDomain.getCommandStack().canRedo());

		// redo the cut command
		editingDomain.getCommandStack().redo();
		assertEquals(0, leafSection.getModelElements().size());

		// paste from clipboard
		Command pasteCommand = PasteFromClipboardCommand.create(editingDomain, leafSection,
			DocumentPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS, CommandParameter.NO_INDEX);

		if (pasteCommand.canExecute()) {
			editingDomain.getCommandStack().execute(pasteCommand);

			Actor pastedActor = (Actor) leafSection.getModelElements().get(0);

			assertTrue(actor.getModelElementId().equals(pastedActor.getModelElementId()));
			assertEquals(1, leafSection.getModelElements().size());
		} else {
			fail("Command not executable");
		}

		// undo the paste command
		editingDomain.getCommandStack().undo();
		assertEquals(0, leafSection.getModelElements().size());

		// redo the paste command
		editingDomain.getCommandStack().redo();
		Actor pastedActor = (Actor) leafSection.getModelElements().get(0);
		assertTrue(actor.getModelElementId().equals(pastedActor.getModelElementId()));
		assertEquals(1, leafSection.getModelElements().size());

	}

	/**
	 * Might be no problem in runtime??!! Please have a look at it.
	 */
	@Test
	public void testFunnyIssue() {

		final LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		leafSection.getModelElements().add(actor);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(leafSection);
			}
		}.run();

		final TransactionalEditingDomain editingDomain = Configuration.getEditingDomain();

		// cut to clipboard
		Command cutCommand = CutToClipboardCommand.create(editingDomain, leafSection,
			DocumentPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS, actor);

		if (cutCommand.canExecute()) {
			editingDomain.getCommandStack().execute(cutCommand);
		} else {
			fail("Command not executable");
		}
		assertEquals(0, leafSection.getModelElements().size());
		assertTrue(editingDomain.getCommandStack().canUndo());

		// undo the command
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				editingDomain.getCommandStack().undo();
			}
		}.run();
		// does not work but is strange anyway
		// assertTrue(editingDomain.getCommandStack().canRedo());
	}

	/**
	 * Tests remove command.
	 */
	@Test
	public void removeCommand_DirectCreation() {

		final LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		leafSection.getModelElements().add(actor);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(leafSection);
			}
		}.run();

		final TransactionalEditingDomain editingDomain = Configuration.getEditingDomain();

		// remove
		Command removeCommand = RemoveCommand.create(editingDomain, leafSection,
			DocumentPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS, actor);
		if (removeCommand.canExecute()) {
			editingDomain.getCommandStack().execute(removeCommand);
		} else {
			fail("Command not executable");
		}
		assertEquals(0, leafSection.getModelElements().size());
		assertTrue(editingDomain.getCommandStack().canUndo());

		// undo the command
		editingDomain.getCommandStack().undo();
		assertEquals(1, leafSection.getModelElements().size());
		assertTrue(editingDomain.getCommandStack().canRedo());

		// redo the command
		editingDomain.getCommandStack().redo();
		assertEquals(0, leafSection.getModelElements().size());

	}

	/**
	 * Tests the remove command.
	 */
	@Test
	public void removeCommand() {
		final LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		leafSection.getModelElements().add(actor);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(leafSection);
			}
		}.run();

		final TransactionalEditingDomain editingDomain = Configuration.getEditingDomain();

		// remove
		Collection<Actor> toRemove = new ArrayList<Actor>();
		toRemove.add(actor);
		Command copyCommand = editingDomain.createCommand(RemoveCommand.class, new CommandParameter(leafSection,
			DocumentPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS, toRemove));
		if (copyCommand.canExecute()) {
			editingDomain.getCommandStack().execute(copyCommand);
		} else {
			fail("Command not executable");
		}

		assertEquals(0, leafSection.getModelElements().size());
		assertTrue(editingDomain.getCommandStack().canUndo());

		// undo the command
		editingDomain.getCommandStack().undo();
		assertEquals(1, leafSection.getModelElements().size());
		assertTrue(editingDomain.getCommandStack().canRedo());

		// redo the command
		editingDomain.getCommandStack().redo();
		assertEquals(0, leafSection.getModelElements().size());
	}

	/**
	 * Tests delete command.
	 */
	@Test
	public void deleteCommand_DirectCreation() {

		final LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		leafSection.getModelElements().add(actor);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(leafSection);
			}
		}.run();

		final TransactionalEditingDomain editingDomain = Configuration.getEditingDomain();

		// delete
		Collection<Actor> toDelete = new ArrayList<Actor>();
		toDelete.add(actor);
		Command command = DeleteCommand.create(editingDomain, toDelete);
		if (command.canExecute()) {
			editingDomain.getCommandStack().execute(command);
		} else {
			fail("Command not executable");
		}
		assertEquals(0, leafSection.getModelElements().size());
		assertTrue(editingDomain.getCommandStack().canUndo());

		// undo the command
		editingDomain.getCommandStack().undo();
		assertEquals(1, leafSection.getModelElements().size());
		assertTrue(editingDomain.getCommandStack().canRedo());

		// redo the command
		editingDomain.getCommandStack().redo();
		assertEquals(0, leafSection.getModelElements().size());

	}

	/**
	 * Tests the delete command.
	 */
	@Test
	public void deleteCommand() {
		final LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		leafSection.getModelElements().add(actor);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(leafSection);
				clearOperations();
			}
		}.run();

		assertEquals(0, getProjectSpace().getOperations().size());
		final TransactionalEditingDomain editingDomain = Configuration.getEditingDomain();

		// delete
		Collection<Actor> toDelete = new ArrayList<Actor>();
		toDelete.add(actor);
		Command command = editingDomain.createCommand(DeleteCommand.class, new CommandParameter(leafSection,
			DocumentPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS, toDelete));
		if (command.canExecute()) {
			editingDomain.getCommandStack().execute(command);
		} else {
			fail("Command not executable");
		}

		assertEquals(0, leafSection.getModelElements().size());
		assertTrue(editingDomain.getCommandStack().canUndo());
		assertEquals(1, getProjectSpace().getOperations().size());

		// undo the command
		// command.undo();
		editingDomain.getCommandStack().undo();

		assertEquals(1, leafSection.getModelElements().size());
		// assertEquals(0, getProjectSpace().getOperations().size());
		assertTrue(editingDomain.getCommandStack().canRedo());

		// redo the command
		editingDomain.getCommandStack().redo();
		assertEquals(0, leafSection.getModelElements().size());
		// assertEquals(1, getProjectSpace().getOperations().size());
	}

	@Test
	public void cutAndPasteFromClipboardCommandComplex() {

		final LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();
		final WorkPackage workPackage = TaskFactory.eINSTANCE.createWorkPackage();
		User user = OrganizationFactory.eINSTANCE.createUser();

		workPackage.setName("Sprint1");
		workPackage.setAssignee(user);
		final ActionItem ai1 = TaskFactory.eINSTANCE.createActionItem();
		ai1.setName("AI1");
		ai1.setContainingWorkpackage(workPackage);
		final ActionItem ai2 = TaskFactory.eINSTANCE.createActionItem();
		ai2.setName("AI2");
		ai2.setContainingWorkpackage(workPackage);
		leafSection.getModelElements().add(workPackage);
		leafSection.getModelElements().add(user);
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(leafSection);
				clearOperations();
			}
		}.run();

		TransactionalEditingDomain editingDomain = Configuration.getEditingDomain();

		// cut the element
		Command command = CutToClipboardCommand.create(editingDomain, workPackage);
		editingDomain.getCommandStack().execute(command);

		assertTrue(Configuration.getEditingDomain().getClipboard().contains(workPackage));
		assertEquals(1, leafSection.getAllContainedModelElements().size());

		assertTrue(getProject().getAllModelElements().contains(workPackage));

		Command pasteCommand = PasteFromClipboardCommand.create(editingDomain, leafSection,
			DocumentPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS, CommandParameter.NO_INDEX);
		editingDomain.getCommandStack().execute(pasteCommand);

		assertEquals(4, leafSection.getAllContainedModelElements().size());
		assertTrue(getProject().getAllModelElements().contains(workPackage));

		assertEquals(2, getProjectSpace().getOperations().size());

	}

	@Test
	public void testGetEditingDomain() {
		final LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		leafSection.getModelElements().add(actor);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(leafSection);
				clearOperations();
			}
		}.run();

		assertEquals(0, getProjectSpace().getOperations().size());

		TransactionalEditingDomain editingDomain = Configuration.getEditingDomain();

		EditingDomain domain1 = AdapterFactoryEditingDomain.getEditingDomainFor(actor);
		assertSame(editingDomain, domain1);
		assertNotNull(domain1);
		assertNotNull(editingDomain);
	}

	/**
	 * Tests the delete from unicase delete command.
	 */
	@Test
	public void deleteByUnicaseDeleteCommand() {
		final LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		leafSection.getModelElements().add(actor);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(leafSection);
				clearOperations();
			}
		}.run();

		assertEquals(0, getProjectSpace().getOperations().size());
		final TransactionalEditingDomain editingDomain = Configuration.getEditingDomain();
		// delete
		editingDomain.getCommandStack().execute(
			DeleteCommand.create((new EMFStoreModelelementContext(actor)).getEditingDomain(), actor));

		assertEquals(0, leafSection.getModelElements().size());
		assertTrue(editingDomain.getCommandStack().canUndo());
		assertEquals(1, getProjectSpace().getOperations().size());

		// undo the command
		// command.undo();
		editingDomain.getCommandStack().undo();

		assertEquals(1, leafSection.getModelElements().size());
		// assertEquals(0, getProjectSpace().getOperations().size());
		assertTrue(editingDomain.getCommandStack().canRedo());

		// redo the command
		editingDomain.getCommandStack().redo();
		assertEquals(0, leafSection.getModelElements().size());
		// assertEquals(1, getProjectSpace().getOperations().size());
	}

	@Test
	public void moveToWorkpackageCommand() {
		final LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();
		final WorkPackage sourceWorkPackage = TaskFactory.eINSTANCE.createWorkPackage();
		final ActionItem actionItem = TaskFactory.eINSTANCE.createActionItem();
		actionItem.setName("Move me anywhere you want!");
		actionItem.setContainingWorkpackage(sourceWorkPackage);
		final WorkPackage targetWorkpackage = TaskFactory.eINSTANCE.createWorkPackage();
		targetWorkpackage.setName("target workpackage");
		leafSection.getModelElements().add(sourceWorkPackage);
		leafSection.getModelElements().add(targetWorkpackage);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProject().addModelElement(leafSection);
			}
		}.run();
		assertEquals(2, leafSection.getContainedElements().size());
		assertEquals(1, sourceWorkPackage.getContainedElements().size());
		assertEquals(0, targetWorkpackage.getContainedElements().size());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				clearOperations();
				// commented out in order to avoid dependency on branch
				// org.unicase.ui.workpackagetransfer.WorkItemTransferOperator.moveWorkItems(sourceWorkPackage
				// .getAllContainedWorkItems(), targetWorkpackage, sourceWorkPackage);
			}
		}.run();

		assertEquals(2, leafSection.getContainedElements().size());
		assertEquals(0, sourceWorkPackage.getContainedElements().size());
		assertEquals(1, targetWorkpackage.getContainedElements().size());
		assertEquals(1, getProjectSpace().getOperations().size());
	}
}
