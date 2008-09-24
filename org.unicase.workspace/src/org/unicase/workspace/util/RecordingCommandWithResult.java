package org.unicase.workspace.util;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

public abstract class RecordingCommandWithResult<T> extends RecordingCommand {
	
	private T result;
	
	public RecordingCommandWithResult(TransactionalEditingDomain domain) {
		super(domain);
	}

	@Override
	protected abstract void doExecute();
	
	public T getTypedResult() {
		return result;
	}
	
	protected void setTypedResult(T result) {
		this.result=result;
	}
	

}
