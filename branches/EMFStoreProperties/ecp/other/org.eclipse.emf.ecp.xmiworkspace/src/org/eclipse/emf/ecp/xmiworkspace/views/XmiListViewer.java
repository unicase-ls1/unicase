/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.ecp.xmiworkspace.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.widgets.Composite;

/**
 * Shows a list where the user can select one or more items and
 * the list of the items can be retrieved with a simple method.
 * @author maierma, kraftm
 *
 */
public class XmiListViewer extends ListViewer {

	/**
	 * Map the indices to the values.
	 */
	private Map<Integer, String> contents;
	
	/**
	 * A count is needed for the mapping of the selection.
	 */
	private int count;
	
	/**
	 * Creates a new listviewer.
	 * @param parent Parent composite section this viewer is contained in.
	 */
	public XmiListViewer(Composite parent) {
		super(parent);
		count = 0;
		contents = new HashMap<Integer, String>();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(Object o) {
		super.add(o);
		
		synchronized(this) {
			contents.put(count, (String) o);
			count++;
		}
	}

	/**
	 * Retrieves the selection from the list and converts it in a simple list.
	 * @return List of the selection.
	 */
	public List<String> listGetSelection() {
		List<String> result = new ArrayList<String>();
		
		int[] intSelection = listGetSelectionIndices();
		for(int item: intSelection) {
			result.add(contents.get(item));
		}
		
		return result;
	}
}
