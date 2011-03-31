/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.unicase.ui.validation.providers;

import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.viewers.ColumnLabelProvider;

/**
 * LbaleProvider for the Description Column.
 * 
 * @author helming
 */
public class DescriptionLabelProvider extends ColumnLabelProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof IConstraintStatus) {
			IConstraintStatus constraint = (IConstraintStatus) element;
			return constraint.getMessage();
		}
		return super.getText(element);
	}

}
