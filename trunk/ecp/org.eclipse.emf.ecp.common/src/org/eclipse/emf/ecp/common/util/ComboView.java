/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen. All rights
 * reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

/**
 * A combo view is a wrapper around a graphical SWT Combo element. It provides type-safe retrieval of the selected
 * element and allows to easily track selection changes. While a combo only allows String values, this view allows
 * arbitrary values in the model. The combo view is a wrapper for Combo, comparable to JFace wrappers (like TreeView
 * wrapping Tree). It supports LabelProviders but no ContentProviders. Only the text, not the image, is taken from the
 * label provider, since the Combo object does not support images.
 * 
 * @author jfinis
 * @param <T> the type of elements in the Combo.
 */
public class ComboView<T> {
	/**
	 * Listener to track selection changed events.
	 * 
	 * @author Jonas
	 * @param <T>
	 */
	public static interface IComboChangeListener<T> {
		/**
		 * called if the selection of the combobox is changed.
		 * @param newSelection the new selection
		 */
		void selectionChanged(T newSelection);
	}

	/**
	 * The SWT Combo element wrapped by this class.
	 */
	private final Combo combo;

	/**
	 * The index map, that associates indices with the objects behind them.
	 */
	private HashMap<Integer, T> map = new HashMap<Integer, T>();

	/**
	 * The element that was selected last.
	 */
	private T lastSelection;

	/**
	 * Selection listener for convenient selection change listening.
	 */
	private SelectionListener listener;

	/**
	 * The currently used label Provider.
	 */
	private ILabelProvider labelProvider;

	/**
	 * The list of listeners.
	 */
	private List<IComboChangeListener<? super T>> changeListeners = new ArrayList<IComboChangeListener<? super T>>();

	/**
	 * Default constructor creating a combo box set from a SWT combo element.
	 * 
	 * @param combo the combo element wrapped by this combo box set
	 */
	public ComboView(Combo combo) {
		this.combo = combo;
		listener = new SelectionAdapter() {

			/**
			 * saves the selection and fires an onSelectionChange event.
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				T newSelection = map.get(ComboView.this.combo.getSelectionIndex());
				if (newSelection != lastSelection) {
					lastSelection = newSelection;
					for (IComboChangeListener<? super T> listener : changeListeners) {
						listener.selectionChanged(newSelection);
					}
				}
			}
		};
		combo.addSelectionListener(listener);
	}

	/**
	 * Creates a new combo box set and the wrapped combo element.
	 * 
	 * @param parent the paren composite
	 * @param style the SWT style
	 */
	public ComboView(Composite parent, int style) {
		this(new Combo(parent, style));
	}

	/**
	 * Sets the input of this combo box. Will have the first element selected by default. and will not fire a selection
	 * changed event.
	 * 
	 * @param entries the entries shown in the combobox
	 */
	public void setInput(Collection<? extends T> entries) {
		setInput(entries, null, false);
	}

	/**
	 * Sets the input for this combo box You can set which of the entries is selected by choosing one as default entry.
	 * 
	 * @param entries entries in the box
	 * @param defaultEntry the default selected entry
	 * @param fireSelectionChangeEvents if a selection change event should be fired
	 */
	public void setInput(Collection<? extends T> entries, T defaultEntry, boolean fireSelectionChangeEvents) {
		String[] labels = new String[entries.size()];
		int selection = 0;
		int i = 0;
		for (T e : entries) {
			String label;
			if (labelProvider == null) {
				label = String.valueOf(e);
			} else {
				label = labelProvider.getText(e);
			}
			map.put(i, e);
			labels[i] = label;
			if (e.equals(defaultEntry)) {
				selection = i;
			}
			i++;
		}

		// If we do not want to fire selection change events, we make sure that the
		// selection does not change by setting it to the new value
		// Since the selection function checks for a changing selection, this will
		// suppress any change event.
		if (!fireSelectionChangeEvents) {
			lastSelection = map.get(selection);
		}
		combo.setItems(labels);
		combo.select(selection);
		listener.widgetSelected(null); // fire selection events

	}

	/**
	 * Returns the currently selected element.
	 * 
	 * @return the current selection
	 */
	public T getSelection() {
		// If the combo element is already disposed we return the last selection
		if (combo.isDisposed()) {
			return lastSelection;
		}
		int index = combo.getSelectionIndex();
		if (index == -1) {
			return null;
		}
		return map.get(index);
	}

	/**
	 * Sets the label provider to be used to display elements.
	 * 
	 * @param labelProvider label provider to be used.
	 */
	public void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}

	/**
	 * .
	 * 
	 * @return the currently used label provider.
	 */
	public ILabelProvider getLabelProvider() {
		return labelProvider;
	}

	/**
	 * Returns the combo element wrapped by this object.
	 * 
	 * @return the wrapped combo element
	 */
	public Combo getControl() {
		return combo;
	}

	/**
	 * Adds a listener that is notified whenever the selection changes.
	 * 
	 * @param listener the listener.
	 */
	public void addSelectionChangedListener(IComboChangeListener<? super T> listener) {
		changeListeners.add(listener);
	}

	/**
	 * Adds a listener that is notified whenever the selection changes.
	 * 
	 * @param listener the listener.
	 */
	public void removeSelectionChangedListener(IComboChangeListener<? super T> listener) {
		changeListeners.remove(listener);
	}

}
