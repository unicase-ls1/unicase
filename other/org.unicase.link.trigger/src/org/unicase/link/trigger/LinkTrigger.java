/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.trigger;

import org.eclipse.core.runtime.Platform;
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
public final class LinkTrigger {
	
	/**
	 * The Application ID. It is used to lock UNICASE application to enable to
	 * run one instance of UNICASE.
	 */
	public static final String APPLICATION_ID = "org.unicase.link";
	
	/**
	 * Constructor of LinkTrigger.
	 */
	private LinkTrigger() {
	}
	
	private static String handedUrl = null;
	
	public static String getHandedUrl(){
		return handedUrl;
	}
	/**
	 * Locks the application id and sets up a trigger to get arguments from
	 * other run attempts of UNICASE.
	 * 
	 * @return true if id is not locked. Otherwise, false
	 */
	public static boolean setup() {
		boolean isRunning = false;
		try {
			JUnique.acquireLock(APPLICATION_ID, new URLMessageHandler());
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
				handedUrl = args[2];
			} else {
				JUnique.sendMessage(APPLICATION_ID, args[2]);
			}
		}
		return isRunning;
	}

}


