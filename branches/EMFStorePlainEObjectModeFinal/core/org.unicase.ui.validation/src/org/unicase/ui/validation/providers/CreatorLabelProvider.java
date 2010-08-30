/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.validation.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.viewers.ColumnLabelProvider;

/**
 * LabelProvider for the Creator Column.
 * 
 * @author helming
 */
public class CreatorLabelProvider extends ColumnLabelProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof IConstraintStatus) {
			EObject target = ((IConstraintStatus) element).getTarget();
			if (target instanceof EObject) {
				// TODO: EM
				return "getCreator() not yet implemened for plain EObjects mode!";
				// return ((EObject) target).getCreator();
			}
		}
		return super.getText(element);
	}

}
