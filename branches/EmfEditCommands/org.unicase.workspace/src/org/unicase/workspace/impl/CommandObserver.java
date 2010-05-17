package org.unicase.workspace.impl;

import org.eclipse.emf.common.command.Command;

public interface CommandObserver {

	void commandEnded(Command command);

	void commandStarted(Command command);

	void commandFailed(Command command);

}
