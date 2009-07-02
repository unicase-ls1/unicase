/**
 * <copyright> Copyright (c) 2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogSettings;
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

	public MESuggestedSelectionDialog(Shell shell, boolean multi, String title, boolean blockOnOpen,
		Collection<ModelElement> elements, ModelElement reference) {
		super(shell, multi);
		this.setDetailsLabelProvider(new RelevanceDetailsLabelProvider());
		this.reference = reference;
		this.setTitle(title);
		this.setBlockOnOpen(blockOnOpen);
		this.setElements(elements);
		this.setInitialPattern("**", NONE);
		this.setListLabelProvider(new RelevanceWrappedLabelProvider(relevanceMap));
	}

	/**
	 * Sets the elements of the list.
	 * 
	 * @param elements the elements of the list.
	 */
	public void setElements(Collection<ModelElement> elements) {
		relevanceMap = new HashMap<ModelElement, Double>(elements.size());
		resources = elements;

		if (reference != null) {
			relevanceMap = RecommendationManager.getInstance().getMatchMap("dummy", reference, elements);
		}
	}

	/**
	 * Creates a List and adds it underneath the regular list
	 * 
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#createExtendedContentArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createExtendedContentArea(Composite parent) {
		return null;
	}

	/**
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#createFilter()
	 */
	@Override
	protected ItemsFilter createFilter() {
		return new ModelElementRecommendationAndNameFilter();
	}

	/**
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
	 * Used to check duplicates
	 * 
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#getElementName(java.lang.Object)
	 */
	@Override
	public String getElementName(Object item) {
		if (item instanceof ModelElement)
			return ((ModelElement) item).getName();
		else
			return item.toString();
	}

	/**
	 * Compares the names of ModelElements
	 * 
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#getItemsComparator()
	 */
	@Override
	protected Comparator<ModelElement> getItemsComparator() {
		return new ElementSimilarityComparator();
	}

	/**
	 * Is not very restrictive...
	 * 
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#validateItem(java.lang.Object)
	 */
	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}

	/**
	 * This class compares ModelElements with the similarityMap
	 * 
	 * @author henning femmer
	 */
	class ElementSimilarityComparator implements Comparator<ModelElement> {
		/**
		 * If both elements got a suggestion their suggestion values are compared, the higher, the better. if just one
		 * got a suggestion, it is preferred. if none, alphabetical comparison is used. {@inheritDoc}
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		public int compare(ModelElement o1, ModelElement o2) {
			Double val1 = relevanceMap.get(o1);
			Double val2 = relevanceMap.get(o2);

			if (val1 == null && val2 == null)
				return o1.getName().compareToIgnoreCase(o2.getName());
			else if (val1 == null)
				return 1;
			else if (val2 == null)
				return -1;
			else
				return val2.compareTo(val1);
		}

	}

	/**
	 * This class represents a filter by the ModelElement's name.
	 * 
	 * @author henning femmer
	 */
	class ModelElementRecommendationAndNameFilter extends ItemsFilter {
		@Override
		public boolean matchItem(Object item) {
			if (item instanceof ModelElement) {
				// this should be the regular case, since all elements are ModelElements

				// sometime elements don't have a name and cause bad nullpointerexceptions...
				if (((ModelElement) item).getName() != null) {
					return matches(((ModelElement) item).getName());
				} else {
					return false;
				}
			} else
				return matches(item.toString());
		}

		@Override
		public boolean isConsistentItem(Object item) {
			return (item != null);
		}
	}

	/**
	 * This label-provider returns the elements similarityRate
	 * 
	 * @author henning femmer
	 */
	class RelevanceDetailsLabelProvider extends DateDetailsLabelProvider {
		@Override
		public String getText(Object element) {
			if (element instanceof ModelElement) {
				String text = super.getText(element);

				Double sim = relevanceMap.get(element);
				if (sim != null)
					text = "Relevance: " + sim + ". " + text;
				return text;
			} else if (element == null) {
				return "No item selected.";
			} else {
				return "Multiple elements selected.";
			}
		}
	}

	/**
	 * This label-provider returns the elements date with certain details
	 * 
	 * @author henning femmer
	 */
	class DateDetailsLabelProvider extends LabelProvider {

		/**
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
	 * Tried to create a fake history to push certain values to the top No success.
	 * 
	 * @author henning femmer
	 */
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
			} else if (item instanceof EList) {
				EList<EObject> eList = (EList<EObject>) item;
				for (EObject me : eList) {
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
		 * @param item
		 * @param value
		 */
		protected void pushValue(Object item, int value) {
			for (int i = 0; i < value; i++) {
				this.accessed(item);
			}
		}
	}
}
