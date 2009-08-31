/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.questionnaire.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.unicase.analyzer.questionnaire.wizards.EvaluationWizard;
import org.unicase.analyzer.questionnaire.wizards.MEChoiceWizard;
import org.unicase.analyzer.questionnaire.wizards.QuestionnaireManager;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.ui.common.util.ActionHelper;

/**
 * @author liya
 */
public class StopAction implements IWorkbenchWindowActionDelegate {

	private EvaluationWizard wizard;
	private boolean selectionOpen;
	private MEChoiceWizard meWizard;
	private List<ModelElementId> idList;

	private IWorkbenchPage activePage;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#dispose()
	 */
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#init(org.eclipse.ui.IWorkbenchWindow)
	 */
	public void init(IWorkbenchWindow window) {
		wizard = new EvaluationWizard();
		wizard.init(window.getWorkbench(), null);
		meWizard = new MEChoiceWizard();
		meWizard.init(window.getWorkbench(), null);
		selectionOpen = false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		QuestionnaireManager questionnaireManager = QuestionnaireManager.getInstance();
		selectionOpen = questionnaireManager.isSelectionOpen();
		if (questionnaireManager.isFirstTime()) {
			questionnaireManager.setFirstTime(false);
			long time = questionnaireManager.getTime();
			if (time != -1) {
				long timeDiff = System.currentTimeMillis() - time;
				questionnaireManager.setTime(timeDiff);
			}
		}

		if (questionnaireManager.getMEisComplete()) {

			WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell(), wizard);
			wizardDialog.create();
			wizardDialog.open();
			this.idList = null;
			// this.selectionOpen = false;
			questionnaireManager.setSelectionOpen(false);
			return;
		} else if (this.selectionOpen) {
			WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell(), meWizard);
			wizardDialog.create();
			wizardDialog.open();
			// this.selectionOpen = false;
			questionnaireManager.setSelectionOpen(false);
			this.run(null);
			return;
		} else {
			Project project = questionnaireManager.getProject();
			Project preProject = questionnaireManager.getPreProject();
			if (idList == null) {

				ChangePackage changePackage = questionnaireManager.getChangePackage();
				Set<ModelElementId> ids = changePackage.getAllInvolvedModelElements();

				for (AbstractOperation operation : changePackage.getOperations()) {
					if (operation instanceof CreateDeleteOperation) {
						CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation) operation;
						Set<ModelElement> allContainedModelElements = createDeleteOperation.getModelElement()
							.getAllContainedModelElements();
						allContainedModelElements.add(createDeleteOperation.getModelElement());
						for (ModelElement element : allContainedModelElements) {
							ids.remove(element.getModelElementId());
						}
					}
				}

				idList = new ArrayList<ModelElementId>(ids);
			}
			if (idList.size() == 0) {
				while (!questionnaireManager.getMEisComplete()) {
					questionnaireManager.addMEResult(-2);
				}
				run(null);
				return;
			}
			Random rand = new Random();
			ModelElementId id = idList.get(rand.nextInt(idList.size()));
			idList.remove(id);

			ModelElement leftME = project.getModelElement(id);

			ModelElement rightME = preProject.getModelElement(id);

			// if (activeEditor != null) {
			// activeEditor.getSite().getPage().closeAllEditors(false);
			// }
			if (activePage != null) {
				activePage.closeAllEditors(false);
			}

			boolean left = rand.nextBoolean();
			questionnaireManager.setLeft(left);
			if (left) {
				ActionHelper.openModelElement(leftME, "HAHA");// after commit
				ActionHelper.openModelElement(rightME, "HAHA");// before commit
			} else {
				ActionHelper.openModelElement(rightME, "HAHA");// before commit
				ActionHelper.openModelElement(leftME, "HAHA");// after commit
			}
			activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

			// activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			// this.selectionOpen = true;
			questionnaireManager.setSelectionOpen(true);
			return;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
