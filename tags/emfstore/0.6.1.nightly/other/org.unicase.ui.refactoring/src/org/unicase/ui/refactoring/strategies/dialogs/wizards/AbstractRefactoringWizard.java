/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.wizards;

import java.util.ArrayList;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.wizard.Wizard;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.AbstractRefactoringWizardPage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * The abstract class for refactoring wizards.
 * 
 * @author pfeifferc
 */
public abstract class AbstractRefactoringWizard extends Wizard implements IPageChangedListener {

	/**
	 * The validation constraint status.
	 */
	private IConstraintStatus status;

	/**
	 * Child model elements to be created.
	 */
	private ArrayList<ModelElement> childModelElementsCreated;

	/**
	 * Child model elements to be referenced.
	 */
	private ArrayList<ModelElement> childModelElementsReferenced;

	/**
	 * Parent model elements to be created.
	 */
	private ArrayList<ModelElement> parentModelElementsCreated;

	/**
	 * Parent model elements to be referenced.
	 */
	private ArrayList<ModelElement> parentModelElementsReferenced;

	/**
	 * @param status the
	 */
	public AbstractRefactoringWizard(IConstraintStatus status) {
		this.status = status;
		childModelElementsCreated = new ArrayList<ModelElement>();
		childModelElementsReferenced = new ArrayList<ModelElement>();
		parentModelElementsCreated = new ArrayList<ModelElement>();
		parentModelElementsReferenced = new ArrayList<ModelElement>();
	}

	/**
	 * @return the constraint status
	 */
	public IConstraintStatus getConstraintStatus() {
		return status;
	}

	/**
	 * @return the invalid model element
	 */
	public ModelElement getInvalidModelElement() {
		return (ModelElement) status.getTarget();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IPageChangedListener#pageChanged(org.eclipse.jface.dialogs.PageChangedEvent)
	 */
	public void pageChanged(PageChangedEvent event) {
		((AbstractRefactoringWizardPage) event.getSelectedPage()).pageSelected();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canFinish() {
		return getPages()[getPageCount() - 1] == getContainer().getCurrentPage();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		return true;
	}

	/**
	 * @return the child model elements that were referenced
	 */
	public ArrayList<ModelElement> getChildModelElements() {
		return childModelElementsReferenced;
	}

	/**
	 * @return the parent model elements that were referenced
	 */
	public ArrayList<ModelElement> getParentModelElements() {
		return parentModelElementsReferenced;
	}

	/**
	 * @return the child model elements that were created
	 */
	public ArrayList<ModelElement> getChildModelElementsCreated() {
		return childModelElementsCreated;
	}

	/**
	 * @return the parent model elements that were created
	 */
	public ArrayList<ModelElement> getParentModelElementsCreated() {
		return parentModelElementsCreated;
	}

	/**
	 * @return the total size
	 */
	public int getTotalNumberOfElements() {
		return childModelElementsReferenced.size() + parentModelElementsReferenced.size();
	}

	/**
	 * @return the project space
	 */
	public ProjectSpace getProjectSpace() {
		return WorkspaceManager.getProjectSpace(getInvalidModelElement());
	}

	/**
	 * Add a model element to the project space.
	 * 
	 * @param modelElement the
	 */
	public void addModelElement(final ModelElement modelElement) {
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProjectSpace().getProject().addModelElement(modelElement);
			}
		}.run();
	}

	/**
	 * @return the provider
	 */
	public AdapterFactoryLabelProvider getLabelProvider() {
		AdapterFactoryLabelProvider provider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		return provider;
	}

}
