/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.templates.dialogs.wizards;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.wizard.Wizard;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.refactoring.templates.AbstractRefactoringStrategy;
import org.unicase.ui.refactoring.templates.dialogs.wizards.pages.AbstractRefactoringWizardPage;
import org.unicase.ui.validation.refactoring.RefactoringResult;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * The abstract class for refactoring wizards.
 * 
 * @author pfeifferc
 */
public abstract class AbstractRefactoringWizard extends Wizard implements IPageChangedListener {

	private AbstractRefactoringStrategy abstractRefactoringStrategy;
	
	private RefactoringResult refactoringResult;

	/**
	 * @param abstractRefactoringStrategy the
	 */
	public AbstractRefactoringWizard(AbstractRefactoringStrategy abstractRefactoringStrategy) {
		this.abstractRefactoringStrategy = abstractRefactoringStrategy;
	}

	/**
	 * @return the constraint status
	 */
	public IConstraintStatus getConstraintStatus() {
		return abstractRefactoringStrategy.getConstraintStatus();
	}

	/**
	 * @return the invalid model element
	 */
	public UnicaseModelElement getInvalidModelElement() {
		return (UnicaseModelElement) getConstraintStatus().getTarget();
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
		return ((AbstractRefactoringWizardPage) getContainer().getCurrentPage()).canFinish();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		return ((AbstractRefactoringWizardPage) getContainer().getCurrentPage()).performFinish();
	}

	/**
	 * @return the child model elements that were referenced
	 */
	public List<EObject> getChildModelElements() {
		return abstractRefactoringStrategy.getChildModelElements();
	}

	/**
	 * @return the parent model elements that were referenced
	 */
	public List<EObject> getParentModelElements() {
		return abstractRefactoringStrategy.getParentModelElements();
	}

	/**
	 * @return the child model elements that were created
	 */
	public List<EObject> getChildModelElementsCreated() {
		return abstractRefactoringStrategy.getChildModelElementsCreated();
	}

	/**
	 * @return the parent model elements that were created
	 */
	public List<EObject> getParentModelElementsCreated() {
		return abstractRefactoringStrategy.getParentModelElementsCreated();
	}

	/**
	 * @return the total size
	 */
	public int getTotalNumberOfElements() {
		return getChildModelElements().size() + getParentModelElements().size();
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

	/**
	 * @return result
	 */
	public RefactoringResult getRefactoringResult() {
		return refactoringResult;
	}

	/**
	 * @param refactoringResult the
	 */
	public void setRefactoringResult(RefactoringResult refactoringResult) {
		this.refactoringResult = refactoringResult;
	}
}
