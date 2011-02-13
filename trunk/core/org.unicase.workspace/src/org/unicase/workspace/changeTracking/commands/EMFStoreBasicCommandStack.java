package org.unicase.workspace.changeTracking.commands;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;

public class EMFStoreBasicCommandStack extends BasicCommandStack implements EMFStoreCommandStack {

	private EMFStoreCommandNotifier notifier;
	private Command currentCommand;

	public EMFStoreBasicCommandStack() {
		super();
		notifier = new EMFStoreCommandNotifier();
	}

	@Override
	protected void handleError(Exception exception) {
		notifier.notifiyListenersAboutCommandFailed(currentCommand, exception);
		currentCommand = null;
		super.handleError(exception);
	}

	@Override
	public void execute(Command command) {

		if (currentCommand == null) {
			currentCommand = command;
			notifier.notifiyListenersAboutStart(command);
		}
		super.execute(command);
		if (currentCommand == command) {
			// check again if command was really completed.
			if (mostRecentCommand == command) {
				notifier.notifiyListenersAboutCommandCompleted(command);
			}
			currentCommand = null;
		}
	}

	@Override
	public void addCommandStackObserver(CommandObserver observer) {
		notifier.addCommandStackObserver(observer);
	}

	@Override
	public void removeCommandStackObserver(CommandObserver observer) {
		notifier.removeCommandStackObserver(observer);
	}

}
