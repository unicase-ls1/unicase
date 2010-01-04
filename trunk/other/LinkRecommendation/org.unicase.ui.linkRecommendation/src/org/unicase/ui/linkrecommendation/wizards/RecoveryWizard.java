/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.linkrecommendation.wizards;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.ui.linkrecommendation.wizards.RecoveryResultsPage.RecommendationTableElement;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * @author Henning Femmer
 */
public class RecoveryWizard extends Wizard implements IWorkbenchWizard {

	private ModelElement singleModelElement;
	private boolean isSingleModelElement;

	private Project selectedProject;
	private String projectName;

	private WelcomePage welcomePage;
	private TypeSelectionPage baseTypeSelectionPage;
	private TypeSelectionPage targetTypeSelectionPage;
	private LinkTypeSelectionPage linkTypeSelectionPage;
	private RecoveryResultsPage resPage;

	/**
	 * The constructor if suggestion is made for only one model element.
	 * 
	 * @param me the model element
	 */
	public RecoveryWizard(ModelElement me) {
		isSingleModelElement = true;
		singleModelElement = me;
		this.selectedProject = me.getProject();
	}

	/**
	 * The constructor if recommendation for entire project is to be made.
	 */
	public RecoveryWizard() {
		isSingleModelElement = false;
	}

	/**
	 * Safes the selected links.
	 * 
	 * @return true
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean performFinish() {
		Collection<RecommendationTableElement> links = resPage.getSelected();

		ProgressMonitorDialog dialog = new ProgressMonitorDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
			.getShell());
		dialog.setBlockOnOpen(false);
		dialog.open();
		dialog.getProgressMonitor().beginTask("Adding " + links.size() + " links to the project.", links.size());

		for (final RecommendationTableElement link : links) {
			dialog.getProgressMonitor().worked(1);

			new UnicaseCommand() {
				@Override
				protected void doRun() {
					Object object = link.getBase().eGet(link.getReference());
					if (link.getReference().isMany() && object instanceof EList<?>) {
						EList<EObject> eList = (EList<EObject>) object;
						eList.add(link.getTarget());
					} else if (!link.getReference().isMany()) {
						link.getBase().eSet(link.getReference(), link.getTarget());
					}
				}
			}.run();

		}

		dialog.close();

		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 */
	@Override
	public boolean canFinish() {
		return resPage.isElementsSelected();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#needsProgressMonitor()
	 */
	@Override
	public boolean needsProgressMonitor() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		if (!isSingleModelElement) {
			Object firstElement;
			if (!selection.isEmpty()) {
				firstElement = selection.getFirstElement();
				if (firstElement instanceof ProjectSpace) {
					selectedProject = ((ProjectSpace) firstElement).getProject();
					this.projectName = ((ProjectSpace) firstElement).getProjectName() + "\n"
						+ ((ProjectSpace) firstElement).getProjectDescription();
				} else {
					throw new IllegalArgumentException("No Project selected!");
				}
			} else {
				throw new IllegalArgumentException("Nothing selected!");
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {

		if (isSingleModelElement) {
			resPage = new RecoveryResultsPage(this.selectedProject);
			addPage(resPage);

			LinkedList<ModelElement> mes = new LinkedList<ModelElement>();
			mes.add(this.singleModelElement);
			resPage.setBaseElements(mes);
			resPage.setTargetClassRestrictionEnabled(false);
			resPage.setRelevantReferences(singleModelElement.eClass().getEAllReferences());
			resPage.calculateSuggestions();
		} else {
			welcomePage = new WelcomePage(this.projectName);
			addPage(welcomePage);

			baseTypeSelectionPage = new TypeSelectionPage("Please select the base types for link recovery.");
			addPage(baseTypeSelectionPage);

			linkTypeSelectionPage = new LinkTypeSelectionPage();
			addPage(linkTypeSelectionPage);

			targetTypeSelectionPage = new TypeSelectionPage("Please select the candidate types for link recovery.");
			addPage(targetTypeSelectionPage);

			resPage = new RecoveryResultsPage(this.selectedProject);
			addPage(resPage);
		}
	}

	/**
	 * Returns the result page.
	 * 
	 * @return the result page
	 */
	public RecoveryResultsPage getResultsPage() {
		return this.resPage;
	}
}
