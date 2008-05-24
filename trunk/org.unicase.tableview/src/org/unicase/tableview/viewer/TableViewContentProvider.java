package org.unicase.tableview.viewer;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.model.ModelElement;


/**
 * 
 * @author Hodaie
 *
 * 
 */
public class TableViewContentProvider implements IStructuredContentProvider	{
	
	/**.
	 * ({@inheritDoc})
	 * 
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		
		return (ModelElement[])inputElement;
		
	}

	/**.
	 * ({@inheritDoc})
	 * 
	 */
	@Override
	public void dispose() {
			
	}

	
	/**.
	 *({@inheritDoc})
	 * 
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				
	}

}
