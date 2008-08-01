package org.unicase.ui.navigator.commands;

import java.util.EventObject;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.AbstractAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.widgets.Event;

public class UndoAction extends Action implements CommandStackListener {

	private CommandStack commandStack; 
	
	public UndoAction() {
		this.commandStack = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(
				"org.unicase.EditingDomain").getCommandStack();
		commandStack.addCommandStackListener(this);
		

	}

	public void commandStackChanged(EventObject event) {
		setEnabled(commandStack.canUndo());
	}
	

	@Override
	public void run() {
		if(commandStack.canUndo()){
			commandStack.undo();
		}
		

	}



}
