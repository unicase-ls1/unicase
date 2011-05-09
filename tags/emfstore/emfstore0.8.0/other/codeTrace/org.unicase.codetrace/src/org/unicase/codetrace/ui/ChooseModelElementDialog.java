/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.codetrace.ui;

import java.util.Comparator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.common.Activator;

/**
 * A dialog to select users or groups.
 * @author jfinis 
 * @author kterziewa
 */
public class ChooseModelElementDialog extends FilteredItemsSelectionDialog{
	private static final String DIALOG_SETTINGS = "STANDARD_DIALOG_SETTING";
	private EList<EObject> elements;
	private AdapterFactoryLabelProvider labelProvider;
	
	/**
	 * The constructor.
	 * {@inheritDoc}
	 * @param p the project from which the users / groups should be gathered
	 * @param message the message shown in the dialog.
	 */
	public ChooseModelElementDialog(Project p, String message){
		super(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),true);
		elements = p.getAllModelElementsbyClass(EcorePackage.Literals.EOBJECT,new BasicEList<EObject>());
		
		EList<EObject> elementsFiltered = new BasicEList<EObject>();
		if (elements != null) {
			for (EObject me : (EList<EObject>) elements) {
				if (me instanceof WorkItem){
					elementsFiltered.add(me);
				}
			}
		}
		elements = elementsFiltered;
		
		
				
		labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		setListLabelProvider(labelProvider);
		setDetailsLabelProvider(labelProvider);


		setBlockOnOpen(true);
		setInitialPattern("**", NONE);
		setMessage(message);
		setTitle("Add model element");
	}


	/**
	 * Does nothing.
	 * @param parent the parent
	 * @return null
	 */
	
	protected Control createExtendedContentArea(Composite parent) {
		return null;
	}

	/**
	 * Returns a new instance of class UserFilter.
	 * @return new instance of class UserFilter
	 */
	
	protected ItemsFilter createFilter() {
		return new UserFilter();
	}

	/**
	 * Fills the content provider with all elements matching the items filter.
	 * @param contentProvider the content provider which gets added the items
	 * @param itemsFilter the used items filter
	 * @param progressMonitor a progress monitor stating the progress
	 */
	
	protected void fillContentProvider(AbstractContentProvider contentProvider,
			ItemsFilter itemsFilter, IProgressMonitor progressMonitor) {

		progressMonitor.beginTask("Searching", elements.size());
		for (EObject me : elements) {
			contentProvider.add(me, itemsFilter);
			progressMonitor.worked(1);
		}
		progressMonitor.done();
		
	}

	/**
	 * Gets the dialog settings.
	 * @return the dialog settings
	 */
	
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
	
	public String getElementName(Object item) {
		if (item instanceof UnicaseModelElement) {
			return labelProvider.getText(item);
		} else {
			return item.toString();
		}
	}

	/**
	 * Returns an alphabetical comparator.
	 * @return an alphabetical comparator
	 */
	
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
	
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}
	
	/**
	 * 
	 * @author jfinis A simple filter class.
	 *
	 */
	class UserFilter extends ItemsFilter {
		/**
		 * Matches ModelElement's toString Methods.
		 * 
		 * @param item an item
		 * @return a bool
		 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter#matchItem(java.lang.Object)
		 */
		
		public boolean matchItem(Object item) {
			String pattern = this.getPattern();
			String label = labelProvider.getText(item);
			if (pattern == null || pattern.equals("*") || pattern.equals("")) {
				return true;
			}

			return matches(label);
		}

		/**
		 * @param item the item
		 * @return true
		 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter#isConsistentItem(java.lang.Object)
		 */
		
		public boolean isConsistentItem(Object item) {
			return true;
		}
	}
	
	
	
	
		
	}


