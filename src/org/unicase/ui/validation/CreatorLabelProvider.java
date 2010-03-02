/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.unicase.metamodel.ModelElement;

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
			if (target instanceof ModelElement) {
				return ((ModelElement) target).getCreator();
			}
		}
		return super.getText(element);
	}

}
