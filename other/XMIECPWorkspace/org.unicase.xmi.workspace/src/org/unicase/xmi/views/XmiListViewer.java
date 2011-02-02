package org.unicase.xmi.views;

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
	private int count = 0;
	
	/**
	 * Creates a new listviewer.
	 * @param parent Parent composite section this viewer is contained in.
	 */
	public XmiListViewer(Composite parent) {
		super(parent);
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
