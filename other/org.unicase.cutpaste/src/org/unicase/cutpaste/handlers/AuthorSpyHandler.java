package org.unicase.cutpaste.handlers;

import java.util.Date;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.util.ActionHelper;

public class AuthorSpyHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
				
		ModelElement me = ActionHelper.getModelElement(event);
				
		String author, creationDate;
		author = lookupAuthor(me);
		creationDate = lookupCreationDate(me);
		
		MessageDialog.openInformation(
				null,
				"w@iglt info_box",
				"Object has been created by: "+author+" on the following date: "+creationDate+".") ;
		return null;
	}
	
	public String lookupAuthor(final ModelElement me) {
		String creator = me.getCreator();
		return creator;
	}
	public String lookupCreationDate(final ModelElement me) {
		Date creation = me.getCreationDate();
		java.sql.Date formattedCreation = new java.sql.Date(creation.getTime()); 
		return formattedCreation.toString();
	}
}
