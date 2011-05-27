/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.unicase.changetracking.exceptions.MisuseException;
import org.unicase.changetracking.ui.UIUtil;

/**
 * Abstract base class for all UI command handlers.
 * Performs basic exception handling and
 * adds methods to abort the command.
 * 
 * @author jfinis
 * 
 */
public abstract class ChangeTrackingCommandHandler extends AbstractHandler {


	/**
	 * Method to be overwritten by subclasses.
	 * Performs the actual command
	 * @param event execution event
	 */
	protected abstract void doExecute(ExecutionEvent event);
	
	/**
	 * Aborts the command and shows an error message.
	 * @param message error message
	 */
	protected void abort(String message){
		throw new AbortedException(message);
	}
	
	/**
	 * Aborts the command, shows an error message,
	 * and logs the exception.
	 * @param e exception
	 */
	protected void abortCausedByException(Throwable e) {
		UIUtil.handleException(e);
		throw new AbortedException();
	}
	
	/**
	 * Executes the command.
	 * @param event execution event
	 * @return null
	 * @throws ExecutionException never
	 */
	public final Object execute(ExecutionEvent event) throws ExecutionException {
		try{
			doExecute(event);
		} catch (MisuseException m){
			UIUtil.errorMessage(m.getMessage());
		} catch (AbortedException e){
			if(e.getMessage() != null){
				UIUtil.errorMessage(e.getMessage());
			}
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (RuntimeException r){
			// END SUPRESS CATCH EXCEPTION
			UIUtil.handleException(r);
		}
		
		return null;
	}
	
	/**
	 * Exception which is thrown in case of an abortion.
	 * @author jfinis
	 *
	 */
	private static class AbortedException extends RuntimeException{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public AbortedException() {
			super();
		}

		public AbortedException(String message) {
			super(message);
		}
		
	}
	
	
}
