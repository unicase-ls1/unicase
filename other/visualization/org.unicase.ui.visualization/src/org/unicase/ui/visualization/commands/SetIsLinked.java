package org.unicase.ui.visualization.commands;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.UIElement;
import org.unicase.ui.visualization.tree.UnicaseView;
import org.unicase.ui.visualization.views.VisualizationView;

/**
 * Change, if the view is linked to the navigator.
 * 
 * @author Julian Sommerfeldt
 *
 */
public class SetIsLinked extends AbstractHandler implements IElementUpdater {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		for(UnicaseView view : ((VisualizationView) HandlerUtil.getActivePart(event)).getViews()) view.setIsLinked();	
		return null;
	}

	@Override
	public void updateElement(UIElement element, @SuppressWarnings("rawtypes") Map parameters) {
		element.setChecked(true);
	}
}
