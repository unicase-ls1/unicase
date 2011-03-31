/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.views.changes;

import java.util.HashMap;

import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

/**
 * Provides proper coloring for given AbstractOperations according to their OperationState.
 * 
 * @author Shterev
 */
public class OperationColorLabelProvider {

	private HashMap<AbstractOperation, OperationState> map;

	/**
	 * Default constructor.
	 * 
	 * @param map mapping between {@link AbstractOperation}s and {@link OperationState}s
	 */
	public OperationColorLabelProvider(HashMap<AbstractOperation, OperationState> map) {
		this.map = map;
	}

	/**
	 * @param op the abstract operation
	 * @return the color for this op
	 */
	public Color getColor(AbstractOperation op) {
		OperationState state = map.get(op);
		Display display = Display.getCurrent();
		if (state != null) {
			if (state.getPreviewState() == OperationState.ACCEPTED) {
				return display.getSystemColor(SWT.COLOR_GREEN);
			} else if (state.getPreviewState() == OperationState.REJECTED) {
				return display.getSystemColor(SWT.COLOR_RED);
			}
		}
		return display.getSystemColor(SWT.COLOR_BLACK);
	}

}
