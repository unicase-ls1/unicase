/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.editor;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecp.common.dialogs.ModelElementSelectionDialog;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

/**
 * This dialog represents the possibility to select an element from a list where the list is sorted and additional
 * information can be provided.
 * 
 * @author Henning Femmer
 */
public class MESuggestedSelectionDialog extends ModelElementSelectionDialog {

	// maps modelElement.hashCode() to the similarity factor of the element
	private Map<EObject, Double> relevanceMap;

	// private RelevanceWrappedLabelProvider labelProvider;

	// private RecommendationManager recMan;

	private Label label;
	private boolean warning;

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
	public MESuggestedSelectionDialog(String title, String message, boolean blockOnOpen, EObject baseElement,
		EReference reference, Collection<EObject> elements) {

		super(reference.isMany());

		setTitle(title);
		setMessage(message);
		setBlockOnOpen(blockOnOpen);

		relevanceMap = new HashMap<EObject, Double>(elements.size());
		setModelElements(elements);
		// TODO: Reactivate
		// recMan = RecommendationManager.getInstance();
		//
		// if (recMan != null) {
		// relevanceMap = recMan.getMatchMap(baseElement, reference, elements, new ConstantThresholdSelection(0));
		// } else {
		relevanceMap = new HashMap<EObject, Double>();
		// }

		setLabelProvider(new RelevanceWrappedLabelProvider(relevanceMap));
		setListLabelProvider(getLabelProvider());
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
		if (warning) {
			label = new Label(parent, SWT.WRAP);
			label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
			label.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			label
				.setText("This work item does not annotate any model elements. For assignee recommendation to work fine, you should first link this work item with a model element (preferably a functional requirement).");
			return label;
		}
		return null;
	}

	/**
	 * Compares the names of ModelElements.
	 * 
	 * @return a new RelevanceMapComparator
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#getItemsComparator()
	 */
	@Override
	protected Comparator<EObject> getItemsComparator() {
		return new RelevanceMapComparator();
	}

	/**
	 * This class compares ModelElements with the similarityMap.
	 * 
	 * @author henning femmer
	 */
	class RelevanceMapComparator implements Comparator<EObject> {
		/**
		 * If both elements got a suggestion their suggestion values are compared, the higher, the better. if just one
		 * got a suggestion, it is preferred. if none, alphabetical comparison is used. {@inheritDoc}
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		public int compare(EObject o1, EObject o2) {
			Double val1, val2;
			ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
				composedAdapterFactory);
			String name1 = adapterFactoryLabelProvider.getText(o1);
			String name2 = adapterFactoryLabelProvider.getText(o2);

			val1 = relevanceMap.get(o1);
			val2 = relevanceMap.get(o2);

			adapterFactoryLabelProvider.dispose();
			composedAdapterFactory.dispose();

			if (!isRelevant(val1) && !isRelevant(val2)) {

				if (name1 != null && name2 != null) {
					return name1.compareToIgnoreCase(name2);
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
	 * This label-provider returns the elements relevance and dateDetails.
	 * 
	 * @author henning femmer
	 */
	class RelevanceDetailsLabelProvider extends LabelProvider {
		/**
		 * Creates the details.
		 * 
		 * @param element the selected element
		 * @return a string with date details and relevance if provided
		 * @see org.eclipse.emf.ecp.editor.MESuggestedSelectionDialog.DateDetailsLabelProvider#getText(java.lang.Object)
		 */
		@Override
		public String getText(Object element) {
			if (element instanceof EObject) {
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

}
