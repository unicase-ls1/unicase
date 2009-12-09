package org.unicase.implementation.ui;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.implementation.operations.OperationsFactory;
import org.unicase.implementation.operations.PullUpOperation;
import org.unicase.implementation.operations.util.OperationHelper;

public class PullUpClassHandler extends OperationHandlerBase {

	@Override
	protected SemanticCompositeOperation initOperation(IStructuredSelection structuredSelection) {
		org.unicase.model.classes.Class superClass = SelectionHelper.getSelectedElement(structuredSelection);

		PullUpOperation operation = OperationsFactory.eINSTANCE.createPullUpOperation();
		operation.setSuperClass(OperationHelper.getId(superClass));

		return operation;
	}

}
