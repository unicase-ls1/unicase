/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.provider;

import org.eclipse.emf.emfstore.client.ui.views.changes.DefaultOperationLabelProvider;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AttributeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.provider.AbstractOperationItemProvider;

/**
 * Provider class for visualization of resolved/unresolved operations in the commitDialog.
 * 
 * @author Michael Kagel
 */
public class ActionItemResolvedOperationProvider extends DefaultOperationLabelProvider {

	/**
	 * Checks if the attributeOperation is a resolved or unresolved operation, if this is true the method returns 1
	 * otherwise 0. {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.esmodel.provider.AbstractOperationCustomLabelProvider#canRender(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	@Override
	public int canRender(AbstractOperation operation) {
		if (operation instanceof AttributeOperation) {
			AttributeOperation attOp = (AttributeOperation) operation;
			if (attOp.getFeatureName().equals("resolved") && attOp.getNewValue() != null && attOp.getOldValue() != null
				&& !attOp.getNewValue().equals(attOp.getOldValue())) {
				return 1;
			}

		}
		return 0;
	}

	/**
	 * Manipulates the string of resolved/unresolved operations. {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.esmodel.provider.AbstractOperationCustomLabelProvider#getDescription(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	@Override
	public String getDescription(AbstractOperation operation) {
		AttributeOperation attOp = (AttributeOperation) operation;

		if ((Boolean) attOp.getNewValue()) {
			return "Resolved " + AbstractOperationItemProvider.getModelElementClassAndName((attOp.getModelElementId()));
		} else {
			return "Unresolved "
				+ AbstractOperationItemProvider.getModelElementClassAndName((attOp.getModelElementId()));
		}
	}

}
