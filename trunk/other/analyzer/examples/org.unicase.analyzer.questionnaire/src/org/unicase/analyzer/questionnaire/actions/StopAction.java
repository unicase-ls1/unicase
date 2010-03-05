/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.questionnaire.actions;

import java.util.ArrayList;
import java.util.HashSet;
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
import org.unicase.analyzer.questionnaire.wizards.CreateDeleteMEWizard;
import org.unicase.analyzer.questionnaire.wizards.EvaluationWizard;
import org.unicase.analyzer.questionnaire.wizards.MEChoiceWizard;
import org.unicase.analyzer.questionnaire.wizards.QuestionnaireManager;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author liya
 */
public class StopAction implements IWorkbenchWindowActionDelegate {

	private EvaluationWizard wizard;
	private boolean selectionOpen;
	private MEChoiceWizard meWizard;
	private List<ModelElementId> changedElements;

	private IWorkbenchPage activePage;
	private List<ModelElementId> deletedElements;
	private List<ModelElementId> createdElements;
	private CreateDeleteMEWizard createWizard;
	private Random rand;

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
		createWizard = new CreateDeleteMEWizard();
		createWizard.init(window.getWorkbench(), null);
		selectionOpen = false;
		rand = new Random(QuestionnaireManager.getInstance().getVersion());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		QuestionnaireManager questionnaireManager = QuestionnaireManager.getInstance();
		questionnaireManager.stopViews();
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
			try {
				generateDataForCreateDeleteQuestion();
				generateDataForCreateDeleteQuestion();
			} catch (RuntimeException e) {
				// ignore error in create delete generation
				WorkspaceUtil.logException("create delete went wrong", e);
			}
			if (questionnaireManager.getCreatedDeleteMENames() != null
				&& questionnaireManager.getCreatedDeleteMENames().size() > 0) {
				// createWizard.setIndex(0);
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getShell(), createWizard);
				wizardDialog.create();
				wizardDialog.open();
			}

			// generateDataForCreateDeleteQuestion();
			// if (questionnaireManager.getCreatedDeleteMENames() != null
			// && questionnaireManager.getCreatedDeleteMENames().size() > 0) {
			// // createWizard.setIndex(1);
			// WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
			// .getShell(), createWizard);
			// wizardDialog.create();
			// wizardDialog.open();
			// }

			WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell(), wizard);
			wizardDialog.create();
			wizardDialog.open();
			this.changedElements = null;
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
			if (changedElements == null) {
				extractElementsFromCP(questionnaireManager);
			}

			if (changedElements.size() == 0) {
				while (!questionnaireManager.getMEisComplete()) {
					questionnaireManager.addMEResult(-2);
				}
				run(null);
				return;
			}

			ModelElementId id = changedElements.get(rand.nextInt(changedElements.size()));
			changedElements.remove(id);

			ModelElement leftME = project.getModelElement(id);
			ModelElement rightME = preProject.getModelElement(id);
			if (leftME == null || rightME == null) {
				this.run(null);
				return;
			}

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

	private void extractElementsFromCP(QuestionnaireManager questionnaireManager) {
		ChangePackage changePackage = questionnaireManager.getChangePackage();
		Set<ModelElementId> changedIds = changePackage.getAllInvolvedModelElements();
		Set<ModelElementId> deletedIds = new HashSet<ModelElementId>();
		Set<ModelElementId> createdIds = new HashSet<ModelElementId>();

		for (AbstractOperation operation : changePackage.getOperations()) {
			if (operation instanceof CreateDeleteOperation) {
				CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation) operation;
				Set<ModelElement> allContainedModelElements = createDeleteOperation.getModelElement()
					.getAllContainedModelElements();
				allContainedModelElements.add(createDeleteOperation.getModelElement());
				for (ModelElement element : allContainedModelElements) {
					changedIds.remove(element.getModelElementId());
					if (element instanceof MEDiagram) {
						continue;
					}
					if (createDeleteOperation.isDelete()) {
						deletedIds.add(element.getModelElementId());
					} else {
						createdIds.add(element.getModelElementId());
					}
				}
			}
		}
		Project project = QuestionnaireManager.getInstance().getProject();
		Project preProject = QuestionnaireManager.getInstance().getPreProject();
		Set<ModelElementId> toRemove = new HashSet<ModelElementId>();
		for (ModelElementId id : changedIds) {
			if (project.getModelElement(id) == null || preProject.getModelElement(id) == null) {
				toRemove.remove(id);
			}

		}
		changedIds.removeAll(toRemove);

		createdElements = new ArrayList<ModelElementId>(createdIds);
		deletedElements = new ArrayList<ModelElementId>(deletedIds);
		changedElements = new ArrayList<ModelElementId>(changedIds);
	}

	public void generateDataForCreateDeleteQuestion() {

		boolean fake = rand.nextBoolean();
		if (changedElements == null || changedElements.size() < 1) {
			fake = false;
		}
		boolean delete = rand.nextBoolean();
		if (delete && deletedElements.size() < 1) {
			delete = false;
		}
		QuestionnaireManager questionnaireManager = QuestionnaireManager.getInstance();
		Project project = questionnaireManager.getProject();
		Project preProject = questionnaireManager.getPreProject();
		if (fake) {
			ModelElementId modelElementId = changedElements.get(rand.nextInt(changedElements.size()));
			changedElements.remove(modelElementId);
			ModelElement modelElement = project.getModelElement(modelElementId);
			questionnaireManager.addCreateDeleteData(modelElement.eClass().getName() + ": \"" + modelElement.getName()
				+ "\"", QuestionnaireManager.NONE);
			return;
		} else if (delete) {
			ModelElementId modelElementId = deletedElements.get(rand.nextInt(deletedElements.size()));
			ModelElement modelElement = preProject.getModelElement(modelElementId);
			deletedElements.remove(modelElementId);
			questionnaireManager.addCreateDeleteData(modelElement.eClass().getName() + ": \"" + modelElement.getName()
				+ "\"", QuestionnaireManager.DELETED);
			return;
		} else if (createdElements.size() > 0) {
			ModelElementId modelElementId = createdElements.get(rand.nextInt(createdElements.size()));
			ModelElement modelElement = project.getModelElement(modelElementId);
			createdElements.remove(modelElementId);
			questionnaireManager.addCreateDeleteData(modelElement.eClass().getName() + ": \"" + modelElement.getName()
				+ "\"", QuestionnaireManager.CREATED);
			return;
		}
		questionnaireManager.getCreateDeleteResults().add("-2");
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
