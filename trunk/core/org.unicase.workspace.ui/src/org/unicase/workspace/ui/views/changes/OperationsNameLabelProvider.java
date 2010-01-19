/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.changes;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.ui.common.decorators.OverlayImageDescriptor;

/**
 * Label provider for the operation column in the viewer.
 * 
 * @author Shterev
 */
// FIXME AS: Integrate both operation label providers since the name provider is
// obsolete
public class OperationsNameLabelProvider extends ColumnLabelProvider {
	private final ILabelProvider emfProvider;
	private ChangePackageVisualizationHelper visualizationHelper;
	private OperationColorLabelProvider opBackgroundLabelProvider;

	/**
	 * Default constructor.
	 * 
	 * @param emfProvider the default label provider.
	 * @param visualizationHelper the visualizationHelper
	 */
	public OperationsNameLabelProvider(ILabelProvider emfProvider, ChangePackageVisualizationHelper visualizationHelper) {
		this.emfProvider = emfProvider;
		this.visualizationHelper = visualizationHelper;
	}

	/**
	 * Default constructor.
	 * 
	 * @param emfProvider the default label provider.
	 * @param visualizationHelper the visualizationHelper
	 * @param opBackgroundLabelProvider the visualizationHelper
	 */
	public OperationsNameLabelProvider(ILabelProvider emfProvider,
		ChangePackageVisualizationHelper visualizationHelper, OperationColorLabelProvider opBackgroundLabelProvider) {
		this(emfProvider, visualizationHelper);
		this.opBackgroundLabelProvider = opBackgroundLabelProvider;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();
		if (element instanceof AbstractOperation) {
			AbstractOperation op = (AbstractOperation) element;
			String description = visualizationHelper.getDescription(op);
			int indexOfLF = description.indexOf("\n");
			if (indexOfLF > 0) {
				description = description.substring(0, indexOfLF) + " ...";
			}
			cell.setText(description);
			Image image = visualizationHelper.getImage(emfProvider, op);
			ImageDescriptor overlay = visualizationHelper.getOverlayImage(op);
			if (image != null && overlay != null) {
				OverlayImageDescriptor imageDescriptor = new OverlayImageDescriptor(image, overlay,
					OverlayImageDescriptor.LOWER_RIGHT);
				cell.setImage(imageDescriptor.createImage());
			}
			if (opBackgroundLabelProvider != null) {
				cell.setForeground(opBackgroundLabelProvider.getColor(op));
			}
		} else if (element instanceof ChangePackage) {
			ChangePackage cPackage = (ChangePackage) element;
			LogMessage logMessage = cPackage.getLogMessage();
			if (logMessage != null) {
				StringBuffer log = new StringBuffer();
				log.append("Log message: ");
				log.append(" \'");
				log.append(logMessage.getMessage());
				log.append("\' ");
				cell.setText(log.toString());
			} else {
				cell.setText(""); // No log message in case of commit change
				// tree
			}
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