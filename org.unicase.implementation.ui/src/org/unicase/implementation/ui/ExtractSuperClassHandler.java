/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.ui;

// BEGIN IGNORE UNNECCESSARY IMPORT
import java.util.List;

import org.eclipse.emf.emfstore.internal.server.model.versioning.operations.semantic.SemanticCompositeOperation;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.unicase.implementation.operations.ExtractSuperClassOperation;
import org.unicase.implementation.operations.OperationsFactory;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.model.classes.Class;
import org.unicase.model.classes.Package;

/**
 * Handler for {@link ExtractSuperClassOperation}.
 * 
 * @author herrmi
 */
public class ExtractSuperClassHandler extends OperationHandlerBase {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected SemanticCompositeOperation initOperation(IStructuredSelection structuredSelection) {
		ExtractSuperClassOperation operation = OperationsFactory.eINSTANCE.createExtractSuperClassOperation();

		List<Class> subClasses = SelectionHelper.getSelectedElements(structuredSelection);
		operation.getSubClasses().addAll(OperationHelper.getIds(subClasses));

		Package targetPackage = subClasses.get(0).getParentPackage();
		if (targetPackage != null) {
			operation.setTargetPackage(OperationHelper.getId(targetPackage));
		}

		return operation;
	}

}
