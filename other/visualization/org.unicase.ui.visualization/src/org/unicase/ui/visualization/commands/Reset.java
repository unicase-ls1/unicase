/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.visualization.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.ui.visualization.views.VisualizationView;

/**
 * Resets the UI.
 * 
 * @author Julian Sommerfeldt
 *
 */
public class Reset extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		((VisualizationView) HandlerUtil.getActivePart(event)).reset();
		return null;
	}

}
