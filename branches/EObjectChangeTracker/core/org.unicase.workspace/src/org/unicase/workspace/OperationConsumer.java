package org.unicase.workspace;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

public interface OperationConsumer {

	void handleOperations(List<AbstractOperation> operations);

}
