/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator.dialogs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.workSpaceModel.ECPProject;
import org.unicase.ui.common.dialogs.ModelElementSelectionDialog;

/**
 * Dialog to select model elements.
 * 
 * @author mkagel
 */
public class OpenMeShortcutDialog extends ModelElementSelectionDialog {

	/**
	 * The constructor.
	 * 
	 * @param project The project, which contains the model elements for listing
	 */
	public OpenMeShortcutDialog(ECPProject project) {
		super(project);
	}

	/**
	 * Fills the content provider with all elements matching the items filter.
	 * 
	 * @param contentProvider the content provider which gets added the items
	 * @param itemsFilter the used items filter
	 * @param progressMonitor a progress monitor stating the progress
	 */
	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter,
		IProgressMonitor progressMonitor) {

		progressMonitor.beginTask("Searching", getModelElements().size());
		for (EObject modelElement : getModelElements()) {
			ECPProject project = ECPWorkspaceManager.getECPProject(modelElement);
			if (!(project.isNonDomainElement(modelElement))) {
				contentProvider.add(modelElement, itemsFilter);
				progressMonitor.worked(1);
			}
		}
		progressMonitor.done();
	}
}
