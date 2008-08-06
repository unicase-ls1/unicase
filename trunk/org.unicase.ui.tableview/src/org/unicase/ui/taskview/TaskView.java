/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.taskview;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.task.TaskPackage;

/**
 * A specialized TableView to display Action Items.
 * 
 * @author Florian Schneider
 * 
 */
public class TaskView extends ViewPart {

	private METableViewer viewer;

	@Override
	public void createPartControl(Composite parent) {
		FilteredItemProviderAdapterFactory adapterFactory = new FilteredItemProviderAdapterFactory();
		adapterFactory.setFilteredItemProvider(new EClassFilterItemProvider(
				adapterFactory, TaskPackage.eINSTANCE.getActionItem()));
		viewer = new METableViewer(parent, adapterFactory,
				TaskPackage.eINSTANCE.getActionItem());
	}

	@Override
	public void setFocus() {

	}

}
