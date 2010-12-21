/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.reviewview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.unicase.model.urml.UrmlModelElement;


/**
 *  Class for the handling the index of the elements.
 * 
 * @author kterzieva
 */

public class IndexHandling {

	private int lastModelElementIndex = -1;
	// use set methods for changes
	private List<UrmlModelElement> curContent = new ArrayList<UrmlModelElement>();
	private TableViewer listViewer;
	private ReviewView view;

	/**
	 * The constructor.
	 * @param view the view
	 * @param listViewer the list viewer
	 */
	
	public IndexHandling(ReviewView view, TableViewer listViewer) {
		this.listViewer = listViewer;
		this.view = view;

	}
	
	/**
	 * Creates the listener for opening elements.
	 * @param listViewer the list viewer
	 */

	public void createOpenListener(TableViewer listViewer) {
		listViewer.addOpenListener(new IOpenListener() {

			@Override
			// evtl own class
			public void open(OpenEvent event) {
				IStructuredSelection selection =
				((IStructuredSelection)event.getSelection());
				
				Object o = selection.getFirstElement();
				if(o instanceof UrmlModelElement){
					//hier hat er gemekert, deswegen habe ich die umgezogene Methode static gemacht?das ging nicht :(
					//
					view.openElement((UrmlModelElement) o);
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
	 * @param isUp 
	 * @return the selection listener. 
	 */
	
	public SelectionListener createUpDownListener(boolean isUp) {
		return new UpDownListener(isUp);
	}
	
	/**
	 * Get the index of an element.
	 * @param el the urml model element
	 * @return index the index
	 */

	public int getIndex(UrmlModelElement el) {
		int index = 0;
		for (UrmlModelElement u : curContent) {
			// search the element index
			if (u.equals(el)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	/**
	 * Sets the input to the list viewer.
	 * @param collection the collection of the model elements
	 */
	public void setInput(Collection<UrmlModelElement> collection) {
		// save the elements in a separate lists for index element mapping
		curContent.clear();
		for (UrmlModelElement e : collection) {
			curContent.add(e);
		}
		listViewer.setInput(collection);
	}

	/**
	 * Listener for handling presses of the up or down button.
	 * @author kami
	 *
	 */
	private class UpDownListener implements SelectionListener {

		private boolean isUp;

		public UpDownListener(boolean isUp) {
			this.isUp = isUp;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			int size = curContent.size();
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
				view.openElement(curContent.get(lastModelElementIndex));
			}
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
		}
	}
}
