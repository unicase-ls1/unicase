package org.unicase.workspace.impl;

import java.util.ArrayList;
import java.util.List;

import org.unicase.workspace.EObjectChangeObserver;
import org.unicase.workspace.OperationConsumer;

public abstract class AbstractEObjectChangeObserver implements EObjectChangeObserver {

	protected List<OperationConsumer> operationConsumer = new ArrayList<OperationConsumer>();

	public void addOperationConsumer(OperationConsumer operationConsumer) {
		this.operationConsumer.add(operationConsumer);
	}

	public void removeOperationConsumer(OperationConsumer operationConsumer) {
		this.operationConsumer.remove(operationConsumer);
	}

}
