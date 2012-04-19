/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.ui;

import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.SemanticCompositeOperation;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.unicase.implementation.operations.ExtractClassOperation;
import org.unicase.implementation.operations.OperationsFactory;
import org.unicase.implementation.operations.util.OperationHelper;

/**
 * Handler for {@link ExtractClassOperation} when the context class is selected.
 * 
 * @author herrmama
 * @author $Author$
 * @version $Rev$
 * @levd.rating RED Rev:
 */
public class ExtractClassClassHandler extends OperationHandlerBase {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected SemanticCompositeOperation initOperation(IStructuredSelection structuredSelection) {
		org.unicase.model.classes.Class contextClass = SelectionHelper.getSelectedElement(structuredSelection);

		ExtractClassOperation operation = OperationsFactory.eINSTANCE.createExtractClassOperation();
		operation.setContextClass(OperationHelper.getId(contextClass));
		org.unicase.model.classes.Package targetPackage = contextClass.getParentPackage();
		if (targetPackage != null) {
			operation.setTargetPackage(OperationHelper.getId(targetPackage));
		}

		return operation;
	}

}
