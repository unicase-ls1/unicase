/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.unicase.metamodel.util.ModelElementChangeListener;
import org.unicase.model.urml.UrmlModelElement;

/**
 * Class for the handling the listener.
 * 
 * @author kterzieva
 */

public class ReviewController {

	private int lastModelElementIndex = -1;
	private List<UrmlModelElement> curContent = new ArrayList<UrmlModelElement>();
	private Map<ModelElementChangeListener, UrmlModelElement> listeners = new HashMap<ModelElementChangeListener, UrmlModelElement>();
	private TableViewer listViewer;
	private ReviewView reviewView;

	/**
	 * The constructor.
	 * 
	 * @param reviewView the view
	 * @param tableViewer the list viewer
	 */

	public ReviewController(ReviewView reviewView, TableViewer tableViewer) {
		this.listViewer = tableViewer;
		this.reviewView = reviewView;

	}

	/**
	 * Creates the listener for opening elements.
	 * 
	 * @param listViewer the list viewer
	 */

	public void createOpenListener(TableViewer listViewer) {
		listViewer.addOpenListener(new IOpenListener() {

			@Override
			// evtl own class
			public void open(OpenEvent event) {
				IStructuredSelection selection = ((IStructuredSelection) event.getSelection());

				Object o = selection.getFirstElement();
				if (o instanceof UrmlModelElement) {

					reviewView.openElement((UrmlModelElement) o);
					setLastSelectedElementIndex(getIndex((UrmlModelElement) o));
				}
			}
		});
	}

	private void setLastSelectedElementIndex(int index) {
		lastModelElementIndex = index;
	}

	/**
	 * Creates the listener for opening elements.
	 * 
	 * @param isUp defines the direction for opening the elements
	 * @return the selection listener
	 */

	public SelectionListener createUpDownListener(boolean isUp) {
		return new UpDownListener(isUp);
	}

	/**
	 * Get the index of an element.
	 * 
	 * @param el the urml model element
	 * @return index the index
	 */

	public int getIndex(UrmlModelElement el) {
		int index = 0;
		for (UrmlModelElement u : getCurContent()) {
			// search the element index
			if (u.equals(el)) {
				return index;
			}
			index++;
		}
		return -1;
	}


	/**
	 * Listener for handling presses of the up or down button.
	 * 
	 * @author kterzieva
	 */
	private class UpDownListener implements SelectionListener {

		private boolean isUp;

		public UpDownListener(boolean isUp) {
			this.isUp = isUp;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			int size = getCurContent().size();
			if (lastModelElementIndex == -1) {
				lastModelElementIndex = 0;
				listViewer.getTable().select(0);
			} else {
				if (isUp) {
					lastModelElementIndex = (lastModelElementIndex - 1 + size) % size;
				} else {
					lastModelElementIndex = (lastModelElementIndex + 1 + size) % size;
				}
				listViewer.getTable().deselectAll();
				listViewer.getTable().select(lastModelElementIndex);
				reviewView.openElement(getCurContent().get(lastModelElementIndex));
			}
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
		}
	}
	
	/**
	 * Removes all model element change listeners, which are added to the urml elements.
	 */
	public void dispose() {
		for(Entry<ModelElementChangeListener, UrmlModelElement> entry : getListeners().entrySet()){
			entry.getValue().removeModelElementChangeListener(entry.getKey());
		}
	}

	/**
	 * Sets the content(model elements) of the current element list. 
	 * @param curContent the content which is to set
	 */
	public void setCurContent(List<UrmlModelElement> curContent) {
		this.curContent = curContent;
	}

	/**
	 * Gets the current content of the list with model elements.
	 * @return curContent the content
	 */
	public List<UrmlModelElement> getCurContent() {
		return curContent;
	}

	/**
	 * Sets the listeners to the model elements.
	 * @param listeners the listener
	 */
	public void setListeners(Map<ModelElementChangeListener, UrmlModelElement> listeners) {
		this.listeners = listeners;
	}

	/**
	 * Gets the listener of the model elements.
	 * @return listeners the listener.
	 */
	public Map<ModelElementChangeListener, UrmlModelElement> getListeners() {
		return listeners;
	}
}
