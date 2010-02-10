/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor.mecontrols.issuecontrol;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.change.ChangeFactory;
import org.unicase.model.change.MergingIssue;
import org.unicase.model.change.MergingProposal;
import org.unicase.model.change.MergingSolution;
import org.unicase.model.rationale.Proposal;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.rationale.Solution;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MESingleLinkControl;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.impl.ProjectSpaceImpl;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Special widget for resolving MerginIssues.
 * 
 * @author wesendon
 */
public class MergingIssueResolutionControl extends MESingleLinkControl {

	/**
	 * Default constructor.
	 */
	public MergingIssueResolutionControl() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement) {
		if (!(modelElement instanceof MergingIssue)) {
			return DO_NOT_RENDER;
		}
		Object feature = itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EReference && !((EReference) feature).getName().equals("solution")) {
			return DO_NOT_RENDER;
		}

		return 3;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.meeditor.mecontrols.melinkcontrol.MESingleLinkControl#initActions()
	 */
	@Override
	protected List<Action> initActions() {
		ArrayList<Action> result = new ArrayList<Action>();
		result.add(new CreateMergingSolutionAction((MergingIssue) getModelElement()));
		return result;
	}

	/**
	 * Action to resolve an issue.
	 * 
	 * @author koegel
	 */
	private final class CreateMergingSolutionAction extends Action {

		private AdapterFactoryLabelProvider provider;
		private final MergingIssue mergingIssue;

		public CreateMergingSolutionAction(MergingIssue modelElement) {
			this.mergingIssue = modelElement;
			provider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
			setImageDescriptor(ImageDescriptor.createFromImage(provider.getImage(modelElement)));
			setToolTipText("Set and create MergingSolution");
		}

		@Override
		public void run() {
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					solveIssue();
				}

			}.run();
		}

		private void check(ModelElement element) {
			if (element.eContainer() == null) {
				mergingIssue.getProject().getModelElements().add(element);
			}
		}

		private void solveIssue() {
			ElementListSelectionDialog selectionDialog = new ElementListSelectionDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), provider);
			selectionDialog.setTitle("Select MergingSolution");
			selectionDialog.setMessage("Please select a Proposal to create a Solution for this Issue."
				+ "\n If you select a MergingProposal, the underlying Operations are applied.");
			selectionDialog.setElements(mergingIssue.getProposals().toArray(
				new Proposal[mergingIssue.getProposals().size()]));

			selectionDialog.setBlockOnOpen(true);
			if (!(selectionDialog.open() == Window.OK)) {
				return;
			}
			Object result = selectionDialog.getFirstResult();
			if (result instanceof MergingProposal) {
				MergingProposal proposal = (MergingProposal) result;
				MergingSolution solution = ChangeFactory.eINSTANCE.createMergingSolution();
				mergingIssue.setSolution(solution);
				solution.getUnderlyingProposals().add(proposal);
				check(solution);
				ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(mergingIssue);
				if (projectSpace != null) {
					((ProjectSpaceImpl) projectSpace).applyOperationsWithRecording(proposal.getPendingOperations(),
						true);
				}
			} else if (result instanceof Proposal) {
				Solution solution = RationaleFactory.eINSTANCE.createSolution();
				mergingIssue.setSolution(solution);
				solution.getUnderlyingProposals().add((Proposal) result);
				check(solution);
			}
		}
	}
}
