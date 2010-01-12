package org.unicase.ui.unicasecommon.navigator.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.unicase.ui.unicasecommon.navigator.TreeView;

/**
 * This is the handler to collapse all items in UNICASE navigator.
 * 
 * @author fxulusoy
 */
public class CollapseAllHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		TreeView.getTreeViewer().collapseAll();
		return null;
	}

}
