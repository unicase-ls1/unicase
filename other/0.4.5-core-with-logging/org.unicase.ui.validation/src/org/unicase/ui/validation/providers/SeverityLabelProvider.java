/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.validation.providers;

import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.ui.validation.Activator;

/**
 * Label Provider to show the severity.
 * 
 * @author helming
 * @author pfeifferc
 */
public class SeverityLabelProvider extends ColumnLabelProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof IConstraintStatus) {
			IConstraintStatus constraint = (IConstraintStatus) element;
			int severity = constraint.getSeverity();
//			String imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
			switch (severity) {
			case IConstraintStatus.ERROR:
//				imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
//				break;
				return Activator.getImageDescriptor("icons/flag_red.png").createImage();
			case IConstraintStatus.WARNING:
//				imageName = ISharedImages.IMG_OBJS_WARN_TSK;
//				break;
				return Activator.getImageDescriptor("icons/flag_yellow.png").createImage();
			default:
//				imageName = ISharedImages.IMG_OBJS_INFO_TSK;
				return Activator.getImageDescriptor("icons/flag_blue.png").createImage();
			}
//			return PlatformUI.getWorkbench().getSharedImages().getImage(
//					imageName);

		}
		return super.getImage(element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof IConstraintStatus) {
			IConstraintStatus constraint = (IConstraintStatus) element;
			return "" + constraint.getSeverity();
		}
		return super.getText(element);
	}

}
