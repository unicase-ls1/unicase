package org.unicase.ui.tom.commands;


public interface Command {
	void execute();
	org.eclipse.gef.Request getRequest();
	org.eclipse.gef.commands.Command getCommand();
	org.eclipse.gef.Request createRequest();
}
