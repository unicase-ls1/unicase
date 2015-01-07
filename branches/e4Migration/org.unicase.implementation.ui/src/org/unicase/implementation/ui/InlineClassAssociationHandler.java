/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.ui;
// BEGIN IGNORE UNNECCESSARY IMPORT
import org.eclipse.emf.emfstore.internal.server.model.versioning.operations.semantic.SemanticCompositeOperation;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.unicase.implementation.operations.InlineClassOperation;
import org.unicase.implementation.operations.OperationsFactory;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.model.classes.Association;

/**
 * Handler for {@link InlineClassOperation} when the composition to be inlined is selected.
 * 
 * @author herrmi
 */
public class InlineClassAssociationHandler extends OperationHandlerBase {

	@Override
	protected SemanticCompositeOperation initOperation(IStructuredSelection structuredSelection) {
		Association association = SelectionHelper.getSelectedElement(structuredSelection);
		org.unicase.model.classes.Class inlineClass = association.getTarget();

		InlineClassOperation operation = OperationsFactory.eINSTANCE.createInlineClassOperation();
		operation.setAssociation(OperationHelper.getId(association));
		if (inlineClass != null) {
			operation.setInlineClass(OperationHelper.getId(inlineClass));
		}

		return operation;
	}

}
