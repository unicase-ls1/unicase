package org.unicase.ui.visualization.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.ui.visualization.views.VisualizationView;
import org.unicase.ui.visualization.views.VisualizationView.ViewTypes;

/**
 * Show a type of view. See {@link ViewTypes}.
 * 
 * @author Julian Sommerfeldt
 *
 */
public class ShowView extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		VisualizationView view = (VisualizationView) HandlerUtil.getActivePart(event);
		String viewType = event.getParameter("org.unicase.ui.visualization.commands.showView.viewType");		
		if(viewType == null) view.showSunburstTreeView();
		else if(VisualizationView.ViewTypes.SUNBURST.toString().toLowerCase().equals(viewType.toLowerCase())) view.showSunburstTreeView();
		else if(VisualizationView.ViewTypes.HYPERBOLIC.toString().toLowerCase().equals(viewType.toLowerCase())) view.showHyperbolicTreeView();
		return null;
	}

}
