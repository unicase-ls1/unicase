/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.conflict.options;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Display;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.change.ChangeFactory;
import org.unicase.model.change.MergingIssue;
import org.unicase.model.change.MergingProposal;
import org.unicase.model.document.LeafSection;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.ui.common.util.CannotMatchUserInProjectException;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.conflict.CustomConflictOption;
import org.unicase.workspace.ui.views.changes.ChangePackageVisualizationHelper;
import org.unicase.workspace.util.NoCurrentUserException;

public class IssueOption extends CustomConflictOption {

	private Conflict conflict;
	private AbstractOperation issueOperation;

	public IssueOption() {
		super("Enter Name...");
	}

	@Override
	public boolean hasExtraOptionAction() {
		return true;
	}

	@Override
	public boolean optionChosen() {
		String label = getOptionLabel();
		InputDialog inputDialog = new InputDialog(Display.getCurrent()
				.getActiveShell(), "Issue Name",
				"Please enter a name for the issue", (label == null) ? ""
						: label, null);
		inputDialog.setBlockOnOpen(true);
		int open = inputDialog.open();
		if (open == 0) {
			setOptionLabel(inputDialog.getValue());
			return true;
		}
		return false;
	}

	@Override
	public String getOptionPrefix() {
		return "Create Issue: ";
	}

	@Override
	public boolean hasExtraResultAction() {
		return false;
	}

	public void createOperation() {
		Project project = conflict.getDecisionManager().getProject();
		ConflictOption myOption = conflict
				.getOptionOfType(OptionType.MyOperation);
		List<AbstractOperation> myOperations = myOption.getOperations();
		ConflictOption theirOption = conflict
				.getOptionOfType(OptionType.TheirOperation);
		List<AbstractOperation> theirOperations = theirOption.getOperations();

		ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(project);
		EObject eContainer = project;
		if (myOperations.size() > 0) {
			ModelElement modelElement = project.getModelElement(myOperations
					.get(0).getModelElementId());
			if (modelElement != null) {
				eContainer = modelElement;
			}

		}

		CompositeOperationHandle compositeOperation = projectSpace
				.beginCompositeOperation();

		MergingIssue mergeIssue = ChangeFactory.eINSTANCE.createMergingIssue();
		mergeIssue.setName(getStrippedOptionLabel());
		mergeIssue.setDescription(conflict.getConflictDescription()
				.getResolvedDescription());
		mergeIssue.setBaseVersion(conflict.getDecisionManager()
				.getBaseVersion());
		mergeIssue.setTargetVersion(conflict.getDecisionManager()
				.getTargetVersion());

		addToContainer(mergeIssue, eContainer);

		assignTo(projectSpace, mergeIssue);

		ChangePackageVisualizationHelper helper = conflict.getDecisionManager()
				.getChangePackageVisualizationHelper();

		createProposal(myOperations, mergeIssue, "My Changes", helper);

		createProposal(theirOperations, mergeIssue, "Changes from Repository",
				helper);

		try {
			compositeOperation.end("Created Merge Issue",
					"Created a merge issue after updating from version "
							+ conflict.getDecisionManager().getBaseVersion()
									.getIdentifier()
							+ " to "
							+ conflict.getDecisionManager().getTargetVersion()
									.getIdentifier() + ".", mergeIssue
							.getModelElementId());
		} catch (InvalidHandleException e) {
			// fail silently
		}

		List<AbstractOperation> ops = projectSpace.getOperations();
		AbstractOperation ab = ops.get(ops.size() - 1);
		issueOperation = (AbstractOperation) EcoreUtil.copy(ab);
	}

	private void createProposal(List<AbstractOperation> myOperations,
			MergingIssue mergeIssue, String name,
			ChangePackageVisualizationHelper helper) {
		MergingProposal myProposal = ChangeFactory.eINSTANCE
				.createMergingProposal();
		mergeIssue.getProposals().add(myProposal);
		myProposal.setName(name);
		String description = "";
		for (AbstractOperation myOp : myOperations) {
			description += helper.getDescription(myOp) + "\n\n";
			myProposal.getPendingOperations().add(
					(AbstractOperation) EcoreUtil.copy(myOp));
		}
		myProposal.setDescription(description);
	}

	private void assignTo(ProjectSpace projectSpace, MergingIssue mergeIssue) {
		User user = null;
		try {
			user = OrgUnitHelper.getUser(projectSpace);
		} catch (NoCurrentUserException e1) {
		} catch (CannotMatchUserInProjectException e1) {
		}
		if (user != null) {
			mergeIssue.setAssignee(user);
		}

		EList<User> users = projectSpace.getProject()
				.getAllModelElementsbyClass(
						OrganizationPackage.eINSTANCE.getUser(),
						new BasicEList<User>());
		for (User opponent : users) {
			// match name by string, author from changepackage doesn't offer
			// orgunitid
			if (opponent.getName().equals(
					conflict.getConflictContext().getOpponent())) {
				mergeIssue.getParticipants().add(opponent);
				return;
			}
		}
	}

	@Override
	public List<AbstractOperation> getOperations() {
		if (issueOperation == null) {
			createOperation();
		}
		ArrayList<AbstractOperation> result = new ArrayList<AbstractOperation>();
		if (issueOperation != null) {
			result.add(issueOperation);
		}
		return result;
	}

	private void addToContainer(UnicaseModelElement modelElement,
			EObject eContainer) {
		if (eContainer == null) {
			throw new IllegalStateException(
					"Couldn't add modelelement to project.");
		}
		if (eContainer instanceof LeafSection) {
			((LeafSection) eContainer).getModelElements().add(modelElement);
		} else if (eContainer instanceof Project) {
			((Project) eContainer).getModelElements().add(modelElement);
		} else {
			addToContainer(modelElement, eContainer.eContainer());
		}
	}

	public void setConflict(Conflict conflict) {
		this.conflict = conflict;
	}
}
