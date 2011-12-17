package org.unicase.ui.visualization.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.ui.visualization.views.VisualizationView;

public class Reset extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		((VisualizationView) HandlerUtil.getActivePart(event)).reset();
		return null;
	}

}
