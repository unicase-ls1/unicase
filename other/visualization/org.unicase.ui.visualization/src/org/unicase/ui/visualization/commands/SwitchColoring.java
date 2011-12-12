package org.unicase.ui.visualization.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.ui.visualization.tree.UnicaseTree.Coloring;
import org.unicase.ui.visualization.views.VisualizationView;

/**
 * Switch between the {@link Coloring}.
 * 
 * @author Julian Sommerfeldt
 *
 */
public class SwitchColoring extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		VisualizationView visualizationView = (VisualizationView) HandlerUtil.getActivePart(event);			
		String coloringType = event.getParameter("org.unicase.ui.visualization.commands.switchColoring.coloringType");
		if(coloringType != null){
			Coloring coloring = Coloring.valueOf(coloringType);
			if(coloring != null){
				visualizationView.getView().getUnicaseTree().setColoring(coloring);
									
				if(coloring.equals(Coloring.TWO_VERSIONS)) visualizationView.showTwoVersionsView();
				
				visualizationView.repaintAndUpdateViews();
			}			
		}		
		return null;
	}

}
