/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.iterationplanningview;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.task.ActivityType;
import org.unicase.ui.stem.Activator;
import org.unicase.ui.stem.views.statusview.NotAssigned;

/**
 * . LabelProvider for annotated model element column in IterationPlaningView
 * 
 * @author Helming
 */
public class WorkPackageColumnLabelProvider extends ColumnLabelProvider {

	private Image backlogImage;

	/**
	 * . Constructor
	 */
	public WorkPackageColumnLabelProvider() {
		super();
		backlogImage = Activator.getImageDescriptor("icons/backlog.png")
				.createImage();

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof Backlog || element instanceof NotAssigned) {
			return backlogImage;
		}
		if (element instanceof ActivityType) {
			return backlogImage;
		}

		return super.getImage(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {
		backlogImage.dispose();
		super.dispose();
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof NotAssigned) {
			return "Not Assigned";
		}
		if (element instanceof Backlog) {
			return "Backlog";
		}
		if (element instanceof ActivityType) {
			return ((ActivityType) element).getLiteral();
		}
		return super.getText(element);
	}

}
