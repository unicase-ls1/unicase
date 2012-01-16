/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.visualization.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.ui.visualization.tree.UnicaseNode;
import org.unicase.ui.visualization.tree.UnicaseTree.Coloring;
import org.unicase.ui.visualization.tree.UnicaseView;
import org.unicase.ui.visualization.views.VisualizationView;

/**
 * Set manually the color of a type.
 * 
 * @author Julian Sommerfeldt
 *
 */
public class SetTypeColor extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {		
		VisualizationView visualizationView = (VisualizationView) HandlerUtil.getActivePart(event);
		UnicaseView unicaseView = visualizationView.getView();
		if(unicaseView == null){
			return null;
		}
		if(!unicaseView.getUnicaseTree().getColoring().equals(Coloring.MANUALLY)) {
			MessageDialog.openWarning(HandlerUtil.getActiveShell(event), "No valid Coloring", "Please choose manually coloring to set type colors!");
			return null;
		}
		UnicaseNode node = unicaseView.getSelectedNode();
		if (node == null){
			MessageDialog.openWarning(HandlerUtil.getActiveShell(event), "No valid Node", "Please select a node first!");
			return null;
		}
		EClass clazz = node.getEObject().eClass();
		
		Shell shell = HandlerUtil.getActiveShell(event);
		ColorDialog dlg = new ColorDialog(shell);		
        dlg.setText("Color for: " + clazz.getName());

        RGB rgb = dlg.open();
        if (rgb != null) {
          Color color = new Color(shell.getDisplay(), rgb);          
          for(UnicaseView view : visualizationView.getViews()){
        	  view.getUnicaseTree().setColor(clazz, new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));          
          }
          visualizationView.repaintAndUpdateViews();
        }
		return null;
	}

}
