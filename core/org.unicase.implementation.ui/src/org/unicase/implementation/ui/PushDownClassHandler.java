package org.unicase.implementation.ui;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.implementation.operations.OperationsFactory;
import org.unicase.implementation.operations.PushDownOperation;
import org.unicase.implementation.operations.util.OperationHelper;

public class PushDownClassHandler extends OperationHandlerBase {

	@Override
	protected SemanticCompositeOperation initOperation(IStructuredSelection structuredSelection) {
		org.unicase.model.classes.Class superClass = SelectionHelper.getSelectedElement(structuredSelection);

		PushDownOperation operation = OperationsFactory.eINSTANCE.createPushDownOperation();
		operation.setSuperClass(OperationHelper.getId(superClass));

		return operation;
	}

}
