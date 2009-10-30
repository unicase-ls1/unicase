/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.util.traceabilityrecommendation.RecommendationManager;
import org.unicase.model.util.traceabilityrecommendation.selectionstrategies.ConstantThresholdSelection;
import org.unicase.ui.common.Activator;

/**
 * This Dialog represents the possibility to select an element from a list where the list is sorted and additional
 * information can be provided.
 * 
 * @author Henning Femmer
 */
public class MESuggestedSelectionDialog extends FilteredItemsSelectionDialog {

	// Needed for settings, but does not yet have a special purpose
	private static final String DIALOG_SETTINGS = "STANDARD_DIALOG_SETTING";

	// the elements of the dialog
	private Collection<UnicaseModelElement> candidates;

	// maps modelElement.hashCode() to the similarity factor of the element
	private Map<UnicaseModelElement, Double> relevanceMap;

	private RelevanceWrappedLabelProvider labelProvider;

	private RecommendationManager recMan;

	/**
	 * The constructor.
	 * 
	 * @param title The title of the dialog
	 * @param message the message displayed
	 * @param blockOnOpen block
	 * @param elements The elements, which can be selected.
	 * @param baseElement The element, to which the selection is made and to which other elements are compared.
	 * @param reference the reference for which this is used
	 */
	public MESuggestedSelectionDialog(String title, String message, boolean blockOnOpen,
		UnicaseModelElement baseElement, EReference reference, Collection<UnicaseModelElement> elements) {
		super(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), reference.isMany());
		setTitle(title);
		setMessage(message);
		setBlockOnOpen(blockOnOpen);
		setInitialPattern("**", NONE);

		relevanceMap = new HashMap<UnicaseModelElement, Double>(elements.size());
		candidates = elements;
		recMan = RecommendationManager.getInstance();

		if (recMan != null) {
			relevanceMap = recMan.getMatchMap(baseElement, reference, elements, new ConstantThresholdSelection(0));
		} else {
			relevanceMap = new HashMap<UnicaseModelElement, Double>();
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

		progressMonitor.beginTask("Searching", candidates.size());
		for (UnicaseModelElement me : candidates) {
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

		if (item instanceof UnicaseModelElement) {
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
	protected Comparator<UnicaseModelElement> getItemsComparator() {
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
	class RelevanceMapComparator implements Comparator<UnicaseModelElement> {
		/**
		 * If both elements got a suggestion their suggestion values are compared, the higher, the better. if just one
		 * got a suggestion, it is preferred. if none, alphabetical comparison is used. {@inheritDoc}
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		public int compare(UnicaseModelElement o1, UnicaseModelElement o2) {
			Double val1, val2;

			val1 = relevanceMap.get(o1);
			val2 = relevanceMap.get(o2);

			if (!isRelevant(val1) && !isRelevant(val2)) {
				String n1 = o1.getName();
				String n2 = o2.getName();
				if (n1 != null && n2 != null) {
					return o1.getName().compareToIgnoreCase(o2.getName());
				} else {
					return 0;
				}
			} else if (!isRelevant(val1)) {
				return 1;
			} else if (!isRelevant(val2)) {
				return -1;
			} else {
				return val2.compareTo(val1);
			}
		}

	}

	private boolean isRelevant(Double val) {
		return (val != null);
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
		 * @see org.unicase.ui.meeditor.mecontrols.MESuggestedSelectionDialog.DateDetailsLabelProvider#getText(java.lang.Object)
		 */
		@Override
		public String getText(Object element) {
			if (element instanceof UnicaseModelElement) {
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
			if (element instanceof UnicaseModelElement) {
				if (((UnicaseModelElement) element).getCreationDate() == null) {
					return "No creation data available.";
				} else {
					return "Created at " + ((UnicaseModelElement) element).getCreationDate().toString();
				}
			} else if (element == null) {
				return "No item selected.";
			} else {
				return "Multiple elements selected.";
			}
		}
	}
}
