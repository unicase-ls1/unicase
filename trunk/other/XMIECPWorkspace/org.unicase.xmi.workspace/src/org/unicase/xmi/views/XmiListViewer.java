package org.unicase.xmi.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.widgets.Composite;

public class XmiListViewer extends ListViewer {

	/**
	 * Map the indices to the values.
	 */
	private Map<Integer, String> contents;
	private int count = 0;
	
	public XmiListViewer(Composite parent) {
		super(parent);
		contents = new HashMap<Integer, String>();
	}
	
	@Override
	public void add(Object o) {
		super.add(o);
		
		synchronized(this) {
			contents.put(count, (String) o);
			count++;
		}
	}

	public List<String> listGetSelection() {
		List<String> result = new ArrayList<String>();
		
		int[] intSelection = listGetSelectionIndices();
		for(int item: intSelection) {
			result.add(contents.get(item));
		}
		
		return result;
	}
}
