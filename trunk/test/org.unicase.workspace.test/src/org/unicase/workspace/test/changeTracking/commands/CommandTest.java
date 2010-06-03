/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.test.changeTracking.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.command.CopyToClipboardCommand;
import org.eclipse.emf.edit.command.CutToClipboardCommand;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.Test;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.DocumentPackage;
import org.unicase.model.document.LeafSection;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.User;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.Configuration;
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

	@Test
	public void cutAndPasteFromClipboardCommand() {

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

			}
		}.run();

		TransactionalEditingDomain editingDomain = Configuration.getEditingDomain();

		// cut the element
		Command command = CutToClipboardCommand.create(editingDomain, workPackage);
		editingDomain.getCommandStack().execute(command);

		assertTrue(Configuration.getEditingDomain().getClipboard().contains(workPackage));
		assertEquals(1, leafSection.getAllContainedModelElements().size());
		// This should fail in case if the workpackage is still in the project's list of element!
		assertTrue(!getProject().getAllModelElements().contains(workPackage));

		Command pasteCommand = PasteFromClipboardCommand.create(editingDomain, leafSection,
			DocumentPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS, CommandParameter.NO_INDEX);
		editingDomain.getCommandStack().execute(pasteCommand);

		assertEquals(4, leafSection.getAllContainedModelElements().size());
		assertTrue(getProject().getAllModelElements().contains(workPackage));

	}

}
