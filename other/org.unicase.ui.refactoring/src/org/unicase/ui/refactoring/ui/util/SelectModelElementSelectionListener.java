/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.ui.util;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.metamodel.Project;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.ui.refactoring.ui.wizards.AbstractRefactoringWizard;
import org.unicase.workspace.WorkspaceManager;

/**
 * @author pfeifferc
 */
public class SelectModelElementSelectionListener implements SelectionListener {

	private AbstractRefactoringWizard refactoringWizard;

	/**
	 * The constructor.
	 * 
	 * @param refactoringWizard the
	 */
	public SelectModelElementSelectionListener(AbstractRefactoringWizard refactoringWizard) {
		this.refactoringWizard = refactoringWizard;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		AdapterFactoryLabelProvider provider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(refactoringWizard.getShell(), provider);
		Project project = WorkspaceManager.getProjectSpace(refactoringWizard.getInvalidModelElement()).getProject();
		EList<OrgUnit> users = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(),
			new BasicEList<OrgUnit>());
		dialog.setElements(users.toArray());
		dialog.setMultipleSelection(false);
		dialog.open();
		if (dialog.getReturnCode() == Status.OK) {
			// if (dialog.getFirstResult() instanceof OrgUnit) {
			// functionalRequirementCreatable.setStakeholder((OrgUnit) dialog.getFirstResult());
			// }
			// setLinks();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		// nothing to do
	}
}
