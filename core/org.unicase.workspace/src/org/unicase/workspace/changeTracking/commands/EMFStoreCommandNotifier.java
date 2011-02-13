package org.unicase.workspace.changeTracking.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.unicase.metamodel.util.ModelUtil;

public class EMFStoreCommandNotifier {

	private List<CommandObserver> commandObservers;

	public EMFStoreCommandNotifier() {
		super();
		commandObservers = new ArrayList<CommandObserver>();
	}

	protected void notifiyListenersAboutStart(Command command) {
		for (CommandObserver commandObservers : this.commandObservers) {
			try {
				commandObservers.commandStarted(command);
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				// END SUPRESS CATCH EXCEPTION
				ModelUtil.logWarning("Command Observer threw exception", e);
			}
		}
	}

	protected void notifiyListenersAboutCommandFailed(Command command, Exception exception) {
		for (CommandObserver commandObservers : this.commandObservers) {
			try {
				commandObservers.commandFailed(command, exception);
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				// END SUPRESS CATCH EXCEPTION
				ModelUtil.logWarning("Command Observer threw exception", e);
			}
		}
	}

	protected void notifiyListenersAboutCommandCompleted(Command command) {
		for (CommandObserver commandObservers : this.commandObservers) {
			try {
				commandObservers.commandCompleted(command);
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				// END SUPRESS CATCH EXCEPTION
				ModelUtil.logWarning("Command Observer threw exception", e);
			}
		}
	}

	/**
	 * Add a command stack observer.
	 * 
	 * @param observer the observer
	 */
	public void addCommandStackObserver(CommandObserver observer) {
		commandObservers.add(observer);
	}

	/**
	 * Remove COmmand stack observer.
	 * 
	 * @param observer the observer
	 */
	public void removeCommandStackObserver(CommandObserver observer) {
		commandObservers.remove(observer);
	}

}