/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workpackagetransfer.navigator.wizards;

import java.util.Comparator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.unicase.metamodel.Project;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.common.Activator;

/**
 * @author mkagel 
 * 
 * Dialog to choose the WorkPackage in which the WorkItems should be moved.
 *
 */
public class ChooseWorkPackagePage extends FilteredItemsSelectionDialog {
	
	private static final String DIALOG_SETTINGS = "STANDARD_DIALOG_SETTING";
	private EList<WorkPackage> workPackages;
	private AdapterFactoryLabelProvider labelProvider;
	
	/**
	 * The constructor.
	 * @param project the project from which the WorkPackes should be listed and selected
	 */
	public ChooseWorkPackagePage(Project project) {
		super(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),false);
		workPackages = project.getAllModelElementsbyClass(TaskPackage.Literals.WORK_PACKAGE,new BasicEList<WorkPackage>());
		
		
		labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		this.setListLabelProvider(labelProvider);
		this.setDetailsLabelProvider(labelProvider);

		
		this.setBlockOnOpen(true);
		this.setTitle("Choose target WorkPackage");
		this.setInitialPattern("**");
	}
	
	
	/**
	 * Does nothing.
	 * @param parent the parent
	 * @return null
	 */
	@Override
	protected Control createExtendedContentArea(Composite parent) {
		return null;
	}

	/**
	 * Returns a new instance of class WorkPackageFilter.
	 * @return new instance of class WorkPackageFilter
	 */
	@Override
	protected ItemsFilter createFilter() {
		return new WorkPackageFilter();
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

		progressMonitor.beginTask("Searching", workPackages.size());
		for (WorkPackage workPackage : workPackages) {
			contentProvider.add(workPackage, itemsFilter);
			progressMonitor.worked(1);
		}
		progressMonitor.done();
	}

	/**
	 * Gets the dialog settings.
	 * @return the dialog settings
	 */
	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = Activator.getDefault().getDialogSettings().getSection(DIALOG_SETTINGS);
		if (settings == null) {
			settings = Activator.getDefault().getDialogSettings().addNewSection(DIALOG_SETTINGS);
		}
		return settings;
	}

	/**
	 * Gets the name of an element by asking the labelProvider.
	 * @return the name as provided by the labelProvider
	 * @param item the element to get the name from
	 */
	@Override
	public String getElementName(Object item) {
		if (item instanceof WorkPackage) {
			return labelProvider.getText(item);
		} else {
			return item.toString();
		}
	}

	/**
	 * Returns an alphabetical comparator.
	 * @return an alphabetical comparator
	 */
	@Override
	protected Comparator<Object> getItemsComparator() {
		return new Comparator<Object>() {
	         public int compare(Object arg0, Object arg1) {
	            return arg0.toString().compareTo(arg1.toString());
	         }
	      };
	}

	/**
	 * Always returns Status.OK_STATUS.
	 * @return Status.OK_STATUS
	 * @param item an item
	 */
	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}
	
	/**
	 * 
	 * @author mkagel A simple filter class.
	 *
	 */
	class WorkPackageFilter extends ItemsFilter {

		/**
		 * @param item the item
		 * @return true
		 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter#isConsistentItem(java.lang.Object)
		 */
		@Override
		public boolean isConsistentItem(Object item) {
			return true;
		}

		/**
		 * Matches ModelElement's toString Methods.
		 * 
		 * @param item an WorkPackage
		 * @return bool
		 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter#matchItem(java.lang.Object)
		 */
		@Override
		public boolean matchItem(Object item) {
			String pattern = this.getPattern();
			String label = labelProvider.getText(item);
			if (pattern == null || pattern.equals("*") || pattern.equals("")) {
				return true;
			}

			return matches(label);
		}
		
	}

}
