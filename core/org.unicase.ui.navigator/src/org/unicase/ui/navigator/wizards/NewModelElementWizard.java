/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator.wizards;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.unicase.ecpemfstorebridge.EMFStoreModelelementContext;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.UnicaseCommand;

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
		final ModelElement newMEInstance;
		if (selectedEObject != null && newMEType != null) {
			// 1.create ME
			EPackage ePackage = newMEType.getEPackage();
			newMEInstance = (ModelElement) ePackage.getEFactoryInstance().create(newMEType);
			if (selectedEObject instanceof ProjectSpace) {
				new UnicaseCommand() {
					@Override
					protected void doRun() {
						((ProjectSpace) selectedEObject).getProject().addModelElement(newMEInstance);

					}
				}.run();

			} else {
				final EReference possibleContainingReference = ModelUtil.getPossibleContainingReference(newMEInstance,
					selectedEObject);
				if (possibleContainingReference != null && possibleContainingReference.isMany()) {
					new UnicaseCommand() {
						@SuppressWarnings("unchecked")
						@Override
						protected void doRun() {
							Object object = selectedEObject.eGet(possibleContainingReference);
							EList<EObject> eList = (EList<EObject>) object;
							eList.add(newMEInstance);

						}
					}.run();
				}
			}
			// 3.open the newly created ME
			ActionHelper.openModelElement(newMEInstance, this.getClass().getName(), new EMFStoreModelelementContext(
				newMEInstance));
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
