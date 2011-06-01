package org.eclipse.emf.emfstore.client.changeTracking;

import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;

public interface OperationRecorderListener {

	void operationRecorded(AbstractOperation operation);

}
