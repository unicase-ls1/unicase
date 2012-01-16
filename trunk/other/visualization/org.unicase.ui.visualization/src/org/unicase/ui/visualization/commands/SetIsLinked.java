/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

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
		for(UnicaseView view : ((VisualizationView) HandlerUtil.getActivePart(event)).getViews()){
			view.setIsLinked();	
		}
		return null;
	}

	@Override
	public void updateElement(UIElement element, @SuppressWarnings("rawtypes") Map parameters) {
		element.setChecked(true);
	}
}
