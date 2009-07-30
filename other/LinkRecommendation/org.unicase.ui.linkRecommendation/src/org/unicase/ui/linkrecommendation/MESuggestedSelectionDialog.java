/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.linkrecommendation;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.unicase.linkrecommendation.RecommendationManager;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.Activator;

/**
 * This Dialog represents the possibility to select an element from a list where the list is sorted and additional
 * information can be provided.
 * 
 * @author Henning Femmer
 */
public class MESuggestedSelectionDialog extends FilteredItemsSelectionDialog {

	// This element is the element to which similarity is calculated
	private ModelElement reference;

	// Needed for settings, but does not yet have a special purpose
	private static final String DIALOG_SETTINGS = "STANDARD_DIALOG_SETTING";

	// the elements of the dialog
	private Collection<ModelElement> resources;

	// maps modelElement.hashCode() to the similarity factor of the element
	private Map<ModelElement, Double> relevanceMap;

	private ILabelProvider labelProvider;

	/**
	 * The constructor.
	 * 
	 * @param shell The shell.
	 * @param multi Can multiple elments be selected?
	 * @param title The title of the dialog
	 * @param blockOnOpen block
	 * @param elements The elements, which can be selected.
	 * @param reference The element, to which the selection is made and to which other elements are compared.
	 */
	public MESuggestedSelectionDialog(Shell shell, boolean multi, String title, boolean blockOnOpen,
		Collection<ModelElement> elements, ModelElement reference) {
		super(shell, multi);
		this.reference = reference;
		setTitle(title);
		setBlockOnOpen(blockOnOpen);
		setInitialPattern("**", NONE);

		relevanceMap = new HashMap<ModelElement, Double>(elements.size());
		resources = elements;
		if (reference != null) {
			relevanceMap = RecommendationManager.getInstance().getMatchMap("words", reference, elements);
		}

		labelProvider = new RelevanceWrappedLabelProvider(relevanceMap);
		setListLabelProvider(labelProvider);
		setDetailsLabelProvider(new RelevanceDetailsLabelProvider());
	}

	/**
	 * Does nothing.
	 * 
	 * @param parent parent composite
	 * @return null
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#createExtendedContentArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createExtendedContentArea(Composite parent) {
		return null;
	}

	/**
	 * Creates and returns a ModelElementRecommendationAndNameFilter.
	 * 
	 * @return the filter
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#createFilter()
	 */
	@Override
	protected ItemsFilter createFilter() {
		return new BasicFilter();
	}

	/**
	 * Adds the elements to the content.
	 * 
	 * @param contentProvider AbstractContentProvider
	 * @param itemsFilter ItemsFilter
	 * @param progressMonitor ProgressMonitor
	 * @throws CoreException CoreException
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#fillContentProvider(org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.AbstractContentProvider,
	 *      org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter,
		IProgressMonitor progressMonitor) throws CoreException {

		progressMonitor.beginTask("Searching", resources.size());
		for (ModelElement me : resources) {
			contentProvider.add(me, itemsFilter);
			progressMonitor.worked(1);
		}
		progressMonitor.done();
	}

	/**
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#getDialogSettings()
	 * @return returns the settings
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
	 * Used to check duplicates.
	 * 
	 * @param item the item
	 * @return the ModelElement's name or the toString if element is not a ModelElement
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#getElementName(java.lang.Object)
	 */
	@Override
	public String getElementName(Object item) {

		if (item instanceof ModelElement) {
			return labelProvider.getText(item);
		} else {
			return item.toString();
		}
	}

	/**
	 * Compares the names of ModelElements.
	 * 
	 * @return a new RelevanceMapComparator
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#getItemsComparator()
	 */
	@Override
	protected Comparator<ModelElement> getItemsComparator() {
		return new RelevanceMapComparator();
	}

	/**
	 * @param item the Item to validate
	 * @return Status.OK_STATUS
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#validateItem(java.lang.Object)
	 */
	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}

	/**
	 * This class compares ModelElements with the similarityMap.
	 * 
	 * @author henning femmer
	 */
	class RelevanceMapComparator implements Comparator<ModelElement> {
		/**
		 * If both elements got a suggestion their suggestion values are compared, the higher, the better. if just one
		 * got a suggestion, it is preferred. if none, alphabetical comparison is used. {@inheritDoc}
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		public int compare(ModelElement o1, ModelElement o2) {
			Double val1, val2;

			val1 = relevanceMap.get(o1);
			val2 = relevanceMap.get(o2);

			if (val1 == null && val2 == null) {
				String n1 = o1.getName();
				String n2 = o2.getName();
				if (n1 != null && n2 != null) {
					return o1.getName().compareToIgnoreCase(o2.getName());
				} else {
					return 0;
				}
			} else if (val1 == null) {
				return 1;
			} else if (val2 == null) {
				return -1;
			} else {
				return val2.compareTo(val1);
			}
		}

	}

	/**
	 * This class represents a very basic filter.
	 * 
	 * @author henning femmer
	 */
	class BasicFilter extends ItemsFilter {
		/**
		 * Matches ModelElement's toString Methods.
		 * 
		 * @param item an item
		 * @return a bool
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

		/**
		 * @param item the item
		 * @return true
		 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter#isConsistentItem(java.lang.Object)
		 */
		@Override
		public boolean isConsistentItem(Object item) {
			return true;
		}
	}

	/**
	 * This label-provider returns the elements relevance and dateDetails.
	 * 
	 * @author henning femmer
	 */
	class RelevanceDetailsLabelProvider extends DateDetailsLabelProvider {
		/**
		 * Creates the details.
		 * 
		 * @param element the selected element
		 * @return a string with date details and relevance if provided
		 * @see org.unicase.ui.linkrecommendation.MESuggestedSelectionDialog.DateDetailsLabelProvider#getText(java.lang.Object)
		 */
		@Override
		public String getText(Object element) {
			if (element instanceof ModelElement) {
				String text = super.getText(element);
				Double sim = relevanceMap.get(element);
				if (sim != null) {
					text = "Relevance: " + sim + ". " + text;
				}
				return text;
			} else if (element == null) {
				return "No item selected.";
			} else {
				return "Multiple elements selected.";
			}
		}
	}

	/**
	 * This label-provider returns the elements date with certain details.
	 * 
	 * @author henning femmer
	 */
	class DateDetailsLabelProvider extends LabelProvider {

		/**
		 * @param element the element
		 * @return a string containing the DateDetails of the element
		 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
		 */
		@Override
		public String getText(Object element) {
			if (element instanceof ModelElement) {
				if (((ModelElement) element).getCreationDate() == null) {
					return "No creation data available.";
				} else {
					return "Created at " + ((ModelElement) element).getCreationDate().toString();
				}
			} else if (element == null) {
				return "No item selected.";
			} else {
				return "Multiple elements selected.";
			}
		}
	}

	/**
	 * Tried to create a fake history to push certain values to the top- No success.
	 * 
	 * @deprecated
	 * @author henning femmer
	 */
	@Deprecated
	private class FakeSelectionHistory extends SelectionHistory {
		/*
		 * @see
		 * org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.SelectionHistory#restoreItemFromMemento(org.eclipse.ui
		 * .IMemento)
		 */
		@Override
		protected Object restoreItemFromMemento(IMemento element) {
			return element.getString("resource"); //$NON-NLS-1$
		}

		/*
		 * @see
		 * org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.SelectionHistory#storeItemToMemento(java.lang.Object,
		 * org.eclipse.ui.IMemento)
		 */
		@Override
		protected void storeItemToMemento(Object item, IMemento element) {
			if (item instanceof ModelElement) {
				element.putString("resource", ((ModelElement) item).getName());
			} else if (item instanceof EList<?>) {
				EList<Object> eList = (EList<Object>) item;
				for (Object me : eList) {
					if (me instanceof ModelElement) {
						element.putString("resource", ((ModelElement) me).getName());
					}
				}
			} else {
				element.putString("resource", item.toString());
			}

		}

		/**
		 * This method was meant to push an element in the history, but is not working in this case.
		 * 
		 * @param item the item
		 * @param value the value
		 */
		public void pushValue(Object item, int value) {
			for (int i = 0; i < value; i++) {
				this.accessed(item);
			}
		}
	}
}
