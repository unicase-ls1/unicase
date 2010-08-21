package org.unicase.ui.urml.hypergraph.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.ui.urml.hypergraph.HypergraphView;

/**
 * Handler updates {@link HypergraphView} autoRefresh so that selection events are (not) handled.
 * 
 * @author Michael Haeger
 */
public class AutoRefreshHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		HypergraphView view = (HypergraphView) HandlerUtil.getActivePart(event);
		ToolItem item = (ToolItem) ((Event) event.getTrigger()).widget;
		view.setAutoRefresh(item.getSelection());
		return null;
	}
}
