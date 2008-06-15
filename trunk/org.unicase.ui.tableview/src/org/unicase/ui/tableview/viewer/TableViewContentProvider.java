package org.unicase.ui.tableview.viewer;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.model.ModelElement;

/**
 * 
 * @author Hodaie
 * 
 * 
 */
public class TableViewContentProvider implements IStructuredContentProvider {

	/**
	 * . ({@inheritDoc})
	 * 
	 */
	public Object[] getElements(Object inputElement) {

		return (ModelElement[]) inputElement;

	}

	/**
	 * . ({@inheritDoc})
	 * 
	 */
	public void dispose() {

	}

	/**
	 * . ({@inheritDoc})
	 * 
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

}
