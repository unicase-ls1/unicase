package org.unicase.ui.navigator.commands;

import java.util.EventObject;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;

public class RedoAction extends Action implements CommandStackListener {
	
	private CommandStack commandStack; 
	
	public RedoAction() {
		this.commandStack = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(
				"org.unicase.EditingDomain").getCommandStack();
		commandStack.addCommandStackListener(this);
		

	}

	public void commandStackChanged(EventObject event) {
		setEnabled(commandStack.canRedo());
	}
	

	@Override
	public void run() {
		TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(
		"org.unicase.EditingDomain").getCommandStack().redo();

	}



}
