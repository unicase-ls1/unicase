/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workpackagetransfer.navigator.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.unicase.ecpemfstorebridge.EMFStoreModelelementContext;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.common.dialogs.ModelElementSelectionDialog;

/**
 * @author mkagel 
 * 
 * Dialog to choose the WorkPackage in which the WorkItems should be moved.
 *
 */
public class ChooseWorkPackagePage extends ModelElementSelectionDialog { 
	
	private static final String DIALOG_TITLE = "Select target WorkPackage";
	private static final String DIALOG_MESSAGE = "Enter workpackage name";
	
	private List<WorkPackage> excludeWorkPackages;
	
	
	/**
	 * The constructor.
	 * @param project the project from which the WorkPackes should be listed and selected
	 * @param sourceWorkPackage from which the WorkItems come from 
	 */
	public ChooseWorkPackagePage(Project project, WorkPackage sourceWorkPackage) {
		super(new EMFStoreModelelementContext(sourceWorkPackage), TaskPackage.Literals.WORK_PACKAGE, false);
		excludeWorkPackages = getExcludeWorkPackages(sourceWorkPackage);
				
		this.setBlockOnOpen(true);
		this.setTitle(DIALOG_TITLE);
		this.setMessage(DIALOG_MESSAGE);
	}
	
	private List<WorkPackage> getExcludeWorkPackages(WorkPackage sourceWorkPackage) {
		List<WorkPackage> result = new ArrayList<WorkPackage>();
		
		result.add(sourceWorkPackage);
		List<WorkItem> workItems = sourceWorkPackage.getAllContainedWorkItems();
		for(WorkItem workItem : workItems) {
			if(workItem instanceof WorkPackage) {
				result.add((WorkPackage)workItem);
			}
		}
				
		return result;
	}

	/**
	 * Fills the content provider with all elements matching the items filter.
	 * @param contentProvider the content provider which gets added the items
	 * @param itemsFilter the used items filter
	 * @param progressMonitor a progress monitor stating the progress
	 */
	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter,
		IProgressMonitor progressMonitor) {

		progressMonitor.beginTask("Searching", getModelElements().size());
		for (EObject workPackage : getModelElements()) {
			if(!excludeWorkPackages.contains(workPackage)) {
				contentProvider.add(workPackage, itemsFilter);
			}
			progressMonitor.worked(1);
		}
		progressMonitor.done();
	}

}
