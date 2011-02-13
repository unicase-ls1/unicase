package org.unicase.workspace.changeTracking.commands;

public interface EMFStoreCommandStack {
	/**
	 * Add a command stack observer.
	 * 
	 * @param observer the observer
	 */
	public void addCommandStackObserver(CommandObserver observer);

	/**
	 * Remove COmmand stack observer.
	 * 
	 * @param observer the observer
	 */
	public void removeCommandStackObserver(CommandObserver observer);
}
