/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.taskview;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;

/**
 * A specialized TableView to display FooBars.
 * 
 * @author schneidf
 * 
 */
public class TaskView extends ViewPart {

	private METableViewer viewer;

	@Override
	public void createPartControl(Composite parent) {
		viewer = new METableViewer<ActionItem>(TaskFactory.eINSTANCE
				.createActionItem(), parent);
	}

	@Override
	public void setFocus() {
		viewer.updateInput();
	}

}
