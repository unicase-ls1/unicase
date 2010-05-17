package org.unicase.workspace.impl;

import org.eclipse.emf.common.command.Command;

public interface CommandStackChangedListener {

	void commandStarted(Command command);

	void commandEnded(Command command);

	void addCommandStackListener(CommandObserver command);

	void removeCommandStackListener(CommandObserver command);

}
