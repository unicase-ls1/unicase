/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.workspace.edit.views.changes;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.ui.common.decorators.OverlayImageDescriptor;

/**
 * Label provider for the operation column in the viewer.
 * 
 * @author Shterev
 */
public class OperationsDescLabelProvider extends ColumnLabelProvider {
	private final ILabelProvider emfProvider;
	private ChangePackageVisualizationHelper visualizationHelper;

	/**
	 * Default constructor.
	 * 
	 * @param emfProvider the default label provider.
	 * @param visualizationHelper the visualizationHelper
	 */
	public OperationsDescLabelProvider(ILabelProvider emfProvider, ChangePackageVisualizationHelper visualizationHelper) {
		this.emfProvider = emfProvider;
		this.visualizationHelper = visualizationHelper;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();
		if (element instanceof AbstractOperation) {
			AbstractOperation op = (AbstractOperation) element;
			cell.setText(op.getDescription());
			Image image = visualizationHelper.getImage(emfProvider, op);
			ImageDescriptor overlay = visualizationHelper.getOverlayImage(op);
			if (image != null && overlay != null) {
				OverlayImageDescriptor imageDescriptor = new OverlayImageDescriptor(image, overlay,
					OverlayImageDescriptor.LOWER_RIGHT);
				cell.setImage(imageDescriptor.createImage());
			}
		} else {
			cell.setText("");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getToolTipText(Object element) {
		if (element instanceof AbstractOperation) {
			AbstractOperation operation = (AbstractOperation) element;
			String desc = operation.getDescription();
			return (desc != null ? desc : "No description");
		}
		return "Change package";
	}
}