/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen. All rights
 * reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.navigator.wizards;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.emf.ecp.common.model.ECPWorkspaceManager;
import org.eclipse.emf.ecp.common.model.NoWorkspaceException;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace;
import org.eclipse.emf.ecp.common.utilities.ActionHelper;
import org.eclipse.emf.ecp.navigator.Activator;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.emfstore.common.CommonUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

/**
 * @author Hodaie This is implementation of New Model Element wizard. This wizard is show through
 *         "Add new model element..." command in context menu of Navigator (only on right click on LeafSection). The
 *         wizard shows a tree of model packages and their classes. The user can select a Model Element type in this
 *         tree and on finish the model element is created, added to Leaf- or CompositeSection and opend for editing.
 */
public class NewModelElementWizard extends Wizard implements IWorkbenchWizard {

	/**
	 * . Through this field, the ModelTreePage tells the wizard which model element type is selected
	 */
	private EClass newMEType;

	/**
	 * Through this field, the ModelTreePage tells the wizard if it's ready to finish, i.e. if the selection a model
	 * element is and not a package.
	 */
	private boolean treePageCompleted;
	private EObject selectedEObject;

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public void addPages() {

		ModelTreePage treePage = new ModelTreePage("ModelTreePage", selectedEObject.eClass());
		addPage(treePage);

	}

	/**
	 * . ({@inheritDoc}) This method creates a model element instance from selected type, adds it to Leaf- or
	 * CompositeSection, and opens it.
	 */
	@Override
	public boolean performFinish() {
		final EObject newMEInstance;
		if (selectedEObject != null && newMEType != null) {
			// 1.create ME
			EPackage ePackage = newMEType.getEPackage();
			newMEInstance = ePackage.getEFactoryInstance().create(newMEType);
			ECPProject tryProject = null;
			try {
				tryProject = ECPWorkspaceManager.getInstance().getWorkSpace().getProject(selectedEObject);
			} catch (NoWorkspaceException e1) {
				Activator.getDefault().logException(e1.getMessage(), e1);
				return false;
			}
			final ECPProject project = tryProject;
			if (project != null && selectedEObject.equals(project.getRootObject())) {
				new ECPCommand(selectedEObject) {
					@Override
					protected void doRun() {
						project.addModelElementToRoot(newMEInstance);
					}
				}.run(true);

			} else {
				final EReference possibleContainingReference = CommonUtil.getPossibleContainingReference(newMEInstance,
					selectedEObject);
				if (possibleContainingReference != null && possibleContainingReference.isMany()) {
					ECPWorkspace workSpace;
					try {
						workSpace = ECPWorkspaceManager.getInstance().getWorkSpace();
						Command create = AddCommand.create(workSpace.getProject(selectedEObject).getEditingDomain(),
							selectedEObject, possibleContainingReference, newMEInstance);
						workSpace.getProject(selectedEObject).getEditingDomain().getCommandStack().execute(create);
					} catch (NoWorkspaceException e) {
						Activator.getDefault().logException(e.getMessage(), e);
					}
				}
			}
			// 3.open the newly created ME
			ActionHelper.openModelElement(newMEInstance, this.getClass().getName());
		}

		return true;
	}

	/**
	 * . ({@inheritDoc})
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// get the in navigator selected ME
		Object o;
		if (!selection.isEmpty()) {
			o = selection.getFirstElement();
			if (o instanceof EObject) {
				selectedEObject = (EObject) o;
			}
		}

	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public boolean canFinish() {
		return treePageCompleted;

	}

	/**
	 * @see newMEType
	 * @param newMEType The ME type that was in ModelTreePage selected.
	 */
	public void setNewMEType(EClass newMEType) {
		this.newMEType = newMEType;
	}

	/**
	 * @see treePageCompeleted
	 * @param treePageCompleted If ModelTreePage is complete (i.e. its selection is a ME)
	 */
	public void setTreePageCompleted(boolean treePageCompleted) {
		this.treePageCompleted = treePageCompleted;
	}

}
