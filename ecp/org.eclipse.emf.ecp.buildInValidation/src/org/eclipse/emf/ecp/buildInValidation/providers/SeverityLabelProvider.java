/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen. All rights
 * reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.buildInValidation.providers;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecp.buildInValidation.Activator;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * Label Provider to show the severity.
 * 
 * @author Carmen Carlan
 */
public class SeverityLabelProvider extends ColumnLabelProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof IStatus) {
			IStatus constraint = (IStatus) element;
			int severity = constraint.getSeverity();
			switch (severity) {
			case IStatus.ERROR:
				return Activator.getImageDescriptor("icons/flag_red.png")
						.createImage();
			case IStatus.WARNING:
				return Activator.getImageDescriptor("icons/flag_yellow.png")
						.createImage();
			default:
				return Activator.getImageDescriptor("icons/flag_blue.png")
						.createImage();
			}
		}
		return super.getImage(element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof IStatus) {
			IStatus constraint = (IStatus) element;
			int severity = constraint.getSeverity();
			switch (severity) {
			case IStatus.ERROR:
				return "ERROR";
			case IStatus.WARNING:
				return "WARNING";
			case IStatus.INFO:
				return "INFO";
			case IStatus.OK:
				return "OK";
			}
		}
		return super.getText(element);
	}

}
