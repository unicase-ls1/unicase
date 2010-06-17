/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.unicase.emfstore.esmodel.provider.AbstractOperationCustomLabelProvider;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.provider.AbstractOperationItemProvider;

/**
 * Provider class for visualization of resolved/unresolved operations in the commitDialog.
 * 
 * @author Michael Kagel
 */
public class ActionItemResolvedOperationProvider extends AbstractOperationItemProvider implements
	AbstractOperationCustomLabelProvider {

	/**
	 * Constructor.
	 * 
	 * @param adapterFactory for necessary methods for getting modelElement names
	 */
	public ActionItemResolvedOperationProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * Checks if the attributeOperation is a resolved or unresolved operation, if this is true the method returns 1
	 * otherwise 0. {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.esmodel.provider.AbstractOperationCustomLabelProvider#canRender(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public int canRender(AbstractOperation operation) {
		if (operation instanceof AttributeOperation) {
			AttributeOperation attOp = (AttributeOperation) operation;
			if (attOp.getFeatureName().equals("resolved") && attOp.getNewValue() != null && attOp.getOldValue() != null
				&& !attOp.getNewValue().equals(attOp.getOldValue())) {
				return 1;
			}

		}
		return CANNOT_RENDER;
	}

	/**
	 * Manipulates the string of resolved/unresolved operations. {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.esmodel.provider.AbstractOperationCustomLabelProvider#getDescription(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public String getDescription(AbstractOperation operation) {
		AttributeOperation attOp = (AttributeOperation) operation;

		if ((Boolean) attOp.getNewValue()) {
			return "Resolved " + getModelElementClassAndName((attOp.getModelElementId()));
		} else {
			return "Unresolved " + getModelElementClassAndName((attOp.getModelElementId()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.esmodel.provider.AbstractOperationCustomLabelProvider#getImage(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public Object getImage(AbstractOperation operation) {
		return getResourceLocator().getImage("full/obj16/AttributeOperation.png");
	}

}
