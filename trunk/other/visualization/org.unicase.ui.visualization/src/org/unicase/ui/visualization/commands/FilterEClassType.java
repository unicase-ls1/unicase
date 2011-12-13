package org.unicase.ui.visualization.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.ui.visualization.views.VisualizationView;

/**
 * 
 * @author Julian Sommerfeldt
 *
 */
public class FilterEClassType extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		new WizardDialog(HandlerUtil.getActiveShell(event), new FilterEClassTypeWizard((VisualizationView) HandlerUtil.getActivePart(event))).open();
		return null;
	}
}
