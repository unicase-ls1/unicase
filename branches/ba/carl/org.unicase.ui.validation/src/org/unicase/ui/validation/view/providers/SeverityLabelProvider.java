/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.validation.view.providers;

import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.ui.validation.constraints.ConstraintHelper;

/**
 * Label Provider to show the severity.
 * 
 * @author helming
 * @author pfeifferc
 */
public class SeverityLabelProvider extends ColumnLabelProvider {

	/**
	 * Default constructor.
	 */
	public SeverityLabelProvider() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof IConstraintStatus) {
			IConstraintStatus constraint = (IConstraintStatus) element;
			return ConstraintHelper.getInstance().getImageForSeverity(constraint.getSeverity());
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
