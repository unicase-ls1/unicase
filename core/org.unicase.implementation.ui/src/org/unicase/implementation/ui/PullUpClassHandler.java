/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.ui;

import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.SemanticCompositeOperation;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.unicase.implementation.operations.OperationsFactory;
import org.unicase.implementation.operations.PullUpOperation;
import org.unicase.implementation.operations.util.OperationHelper;

/**
 * Handler for {@link PullUpOperation} when the target class is selected.
 * 
 * @author herrmi
 */
public class PullUpClassHandler extends OperationHandlerBase {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected SemanticCompositeOperation initOperation(IStructuredSelection structuredSelection) {
		org.unicase.model.classes.Class superClass = SelectionHelper.getSelectedElement(structuredSelection);

		PullUpOperation operation = OperationsFactory.eINSTANCE.createPullUpOperation();
		operation.setSuperClass(OperationHelper.getId(superClass));

		return operation;
	}

}
