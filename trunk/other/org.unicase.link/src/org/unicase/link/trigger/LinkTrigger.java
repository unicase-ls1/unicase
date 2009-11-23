/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.trigger;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.widgets.Display;
import org.unicase.link.trigger.URLMessageHandler;

import it.sauronsoftware.junique.JUnique;
import it.sauronsoftware.junique.AlreadyLockedException;

/**
 * <code>LinkTrigger</code> is executed at the point of UNICASE loading. It
 * controls run attempts of the UNICASE. There should be always one running 
 * ins
 * tance of UNICASE. <br>There are two use cases: <br> 
 * 1-) UNICASE is not running and you click a UNCASE link.
 * <br>
 * UNICASE is opened and related model element is opened.<br><br>
 * 
 * 2-) UNICASE is running and you click a UNICASE link.
 * <br>
 * New instance of UNICASE is not opened. But, the clicked link is send to 
 * current running UNICASE instance.  
 * 
 * @author fxulusoy
 */
public class LinkTrigger {
	
	/**
	 * Constructor of LinkTrigger.
	 */
	private LinkTrigger() {
	}
	
	/**
	 * Locks the application id and sets up a trigger to get arguments from
	 * other run attempts of UNICASE.
	 * 
	 * @return true if id is not locked. Otherwise, false
	 */
	public static boolean setup() {
		boolean isRunning = false;
		String id = "org.unicase.link";
		try {
			JUnique.acquireLock(id, new URLMessageHandler());
			isRunning = true;
		} catch (AlreadyLockedException e) {
			// One instance of an application is still running.
			isRunning = false;
		}
		final String[] args = Platform.getCommandLineArgs();
		/* 
		 * if you run UNICASE in eclipse, eclipse adds two extra arguments.
		 * Therefore, our link argument is third argument. This can be different
		 * when we export UNICASE as a stand alone application.It wasn't tested
		 * yet. Because, I couldn't export UNICASE as stand alone application.
		*/ 
		if (args.length == 3) {
			if (isRunning) {
				final URLEvaluator uriEvaluator =  new URLEvaluator();
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						uriEvaluator.execute(args[2]);
					}
				});
			} else {
				JUnique.sendMessage(id, args[2]);
			}
		}
		return isRunning;
	}

}


