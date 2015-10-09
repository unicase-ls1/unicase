/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.merge;

import org.eclipse.emf.emfstore.internal.server.model.versioning.operations.AbstractOperation;

/**
 * Custom option for the merge dialog, which allows to create issues.
 * 
 * @author wesendon
 */
// FIXME: Access restriction
public class IssueOption { // extends CustomConflictOption {

	// private Conflict conflict;
	private AbstractOperation issueOperation;

	/**
	 * Default constructor.
	 */
	public IssueOption() {
		// super("Enter Name...");
	}

	// /**
	// * {@inheritDoc}
	// *
	// * @see
	// org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption#hasExtraOptionAction()
	// */
	// @Override
	// public boolean hasExtraOptionAction() {
	// return true;
	// }
	//
	// /**
	// * {@inheritDoc}
	// *
	// * @see
	// org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption#optionChosen()
	// */
	// @Override
	// public boolean optionChosen() {
	// String label = getOptionLabel();
	// InputDialog inputDialog = new
	// InputDialog(Display.getCurrent().getActiveShell(), "Create An Issue",
	// "Please enter a name for the issue:", (label == null) ? "" : label,
	// null);
	// inputDialog.setBlockOnOpen(true);
	// int open = inputDialog.open();
	// if (open == 0) {
	// setOptionLabel(inputDialog.getValue());
	// return true;
	// }
	// return false;
	// }
	//
	// /**
	// * {@inheritDoc}
	// *
	// * @see
	// org.unicase.workspace.ui.dialogs.merge.conflict.CustomConflictOption#getOptionPrefix()
	// */
	// @Override
	// public String getOptionPrefix() {
	// return "Create Issue: ";
	// }
	//
	// private void createOperation() {
	// Project project = conflict.getDecisionManager().getProject();
	// ConflictOption myOption =
	// conflict.getOptionOfType(OptionType.MyOperation);
	// List<AbstractOperation> myOperations = myOption.getOperations();
	// ConflictOption theirOption =
	// conflict.getOptionOfType(OptionType.TheirOperation);
	// List<AbstractOperation> theirOperations = theirOption.getOperations();
	//
	// ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(project);
	// EObject eContainer = project;
	// if (myOperations.size() > 0) {
	// EObject modelElement =
	// project.getModelElement(myOperations.get(0).getModelElementId());
	// if (modelElement != null) {
	// eContainer = modelElement;
	// }
	//
	// }
	//
	// CompositeOperationHandle compositeOperation =
	// projectSpace.beginCompositeOperation();
	//
	// MergingIssue mergeIssue = ChangeFactory.eINSTANCE.createMergingIssue();
	// mergeIssue.setName(getStrippedOptionLabel());
	// mergeIssue.setDescription(conflict.getConflictDescription().getResolvedDescription());
	// mergeIssue.setBaseVersion(conflict.getDecisionManager().getBaseVersion());
	// mergeIssue.setTargetVersion(conflict.getDecisionManager().getTargetVersion());
	//
	// addToContainer(mergeIssue, eContainer);
	//
	// assignTo(projectSpace, mergeIssue);
	//
	// addAnnotations(project, myOperations, theirOperations, mergeIssue);
	//
	// ChangePackageVisualizationHelper helper =
	// conflict.getDecisionManager().getChangePackageVisualizationHelper();
	//
	// createProposal(myOperations, mergeIssue, "My Changes", helper);
	//
	// createProposal(theirOperations, mergeIssue, "Changes from Repository",
	// helper);
	//
	// try {
	// compositeOperation.end("Created Merge Issue",
	// "Created a merge issue after updating from version "
	// + conflict.getDecisionManager().getBaseVersion().getIdentifier() + " to "
	// + conflict.getDecisionManager().getTargetVersion().getIdentifier() + ".",
	// ModelUtil.getProject(mergeIssue).getModelElementId(mergeIssue));
	// } catch (InvalidHandleException e) {
	// // fail silently
	// }
	//
	// List<AbstractOperation> ops = projectSpace.getOperations();
	// AbstractOperation ab = ops.get(ops.size() - 1);
	// issueOperation = EcoreUtil.copy(ab);
	// }
	//
	// private void addAnnotations(Project project, List<AbstractOperation>
	// myOperations,
	// List<AbstractOperation> theirOperations, MergingIssue mergeIssue) {
	// HashSet<ModelElementId> set = new HashSet<ModelElementId>();
	// for (AbstractOperation operation : myOperations) {
	// set.addAll(operation.getAllInvolvedModelElements());
	// }
	// for (AbstractOperation operation : theirOperations) {
	// set.addAll(operation.getAllInvolvedModelElements());
	// }
	// for (ModelElementId id : set) {
	// EObject modelElement = project.getModelElement(id);
	// if (modelElement instanceof UnicaseModelElement) {
	// EList<Annotation> annotations = ((UnicaseModelElement)
	// modelElement).getAnnotations();
	// if (!annotations.contains(mergeIssue)) {
	// annotations.add(mergeIssue);
	// }
	// }
	// }
	// }
	//
	// private void createProposal(List<AbstractOperation> myOperations,
	// MergingIssue mergeIssue, String name,
	// ChangePackageVisualizationHelper helper) {
	// MergingProposal myProposal =
	// ChangeFactory.eINSTANCE.createMergingProposal();
	// myProposal.setName(name);
	// String description = "";
	// for (AbstractOperation myOp : myOperations) {
	// description += helper.getDescription(myOp) + "\n\n";
	// myProposal.getPendingOperations().add(EcoreUtil.copy(myOp));
	// }
	// myProposal.setDescription(description);
	// // has to be added at the end, otherwise the addition of the change
	// operations isn't recorded.
	// mergeIssue.getProposals().add(myProposal);
	// }
	//
	// private void assignTo(ProjectSpace projectSpace, MergingIssue mergeIssue)
	// {
	// User user = null;
	// try {
	// user = OrgUnitHelper.getUser(projectSpace);
	// } catch (NoCurrentUserException e1) {
	// } catch (CannotMatchUserInProjectException e1) {
	// }
	// if (user != null) {
	// mergeIssue.setAssignee(user);
	// }
	//
	// EList<User> users = projectSpace.getProject().getAllModelElementsbyClass(
	// OrganizationPackage.eINSTANCE.getUser(), new BasicEList<User>());
	// for (User opponent : users) {
	// // match name by string, author from changepackage doesn't offer
	// // orgunitid
	// if
	// (opponent.getName().equals(conflict.getConflictContext().getOpponent()))
	// {
	// mergeIssue.getParticipants().add(opponent);
	// return;
	// }
	// }
	// }
	//
	// /**
	// * {@inheritDoc}
	// *
	// * @see
	// org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption#getOperations()
	// */
	// @Override
	// public List<AbstractOperation> getOperations() {
	// if (issueOperation == null) {
	// createOperation();
	// }
	// ArrayList<AbstractOperation> result = new ArrayList<AbstractOperation>();
	// if (issueOperation != null) {
	// result.add(issueOperation);
	// }
	// return result;
	// }
	//
	// private void addToContainer(UnicaseModelElement modelElement, EObject
	// eContainer) {
	// if (eContainer == null) {
	// throw new IllegalStateException("Couldn't add modelelement to project.");
	// }
	// if (eContainer instanceof LeafSection) {
	// ((LeafSection) eContainer).getModelElements().add(modelElement);
	// } else if (eContainer instanceof Project) {
	// ((Project) eContainer).getModelElements().add(modelElement);
	// } else {
	// addToContainer(modelElement, eContainer.eContainer());
	// }
	// }
	//
	// /**
	// * Sets the conflict.
	// *
	// * @param conflict conflict
	// */
	// public void setConflict(Conflict conflict) {
	// this.conflict = conflict;
	// }
}
