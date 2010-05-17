package org.unicase.workspace.impl;

import org.eclipse.emf.common.command.Command;

public class CommandObserverImpl implements CommandObserver {

	Command command;

	@Override
	public void commandEnded(Command command) {
		this.command = command;

	}

	@Override
	public void commandStarted(Command command) {
		this.command = command;

	}

	@Override
	public void commandFailed(Command command) {
		this.command = command;

	}

}
