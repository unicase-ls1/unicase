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
 * @author fxulusoy, jfinis
 */
public final class LinkTrigger {
	
	/**
	 * The Application ID. It is used to lock UNICASE application to enable to
	 * run one instance of UNICASE.
	 */
	public static final String APPLICATION_ID = "org.unicase.link";
	
	/** 
	 * Prefix of UNICASE links. Example Link: <br/>
	 * unicase://localhost:1099/My-Project-1%_VDIRUdqAEd60k9Qw1XsJiA/ActionItem-1%_p-c0sNqAEd6PJoFq3iT2Rg 
	 */
	public static final String UNICASE_LINK_PREFIX = "unicase://";
	
	
	private String handedUrl;
	
	private static LinkTrigger instance; 
	
	private URLMessageHandler urlMessageHandler; 
	
	/**
	 * Constructor of LinkTrigger.
	 */
	private LinkTrigger() {
		urlMessageHandler = new URLMessageHandler();
	}

	/**
	 * Gets the singleton instance.
	 * @return the singleton
	 */
	public static LinkTrigger getInstance() {	
		if (instance == null) {
			instance = new LinkTrigger();
			instance.setup();
		}
		
		return instance;
	}
	
	/**
	 * Gets the URL handed to this eclipse instance on startup.
	 * If this eclipse instance wasn't started with a URL,
	 * this function will return null.
	 * @return The URL with which this eclipse instance was started.
	 */
	public String getHandedUrl(){
		return handedUrl;
	}
	
	/**
	 * Returns the URL Message handler of this LinkTrigger.
	 * The message handler implements the Observable interface
	 * and will notify any observers whenever a UNICASE URL is received.
	 * @return The url message handler associated with this LinTrigger
	 */
	public URLMessageHandler getUrlMessageHandler() {
		return urlMessageHandler;
	}
	
	/**
	 * Locks the application id and sets up a trigger to get arguments from
	 * other run attempts of UNICASE.
	 * 
	 * @return false if id was not locked. Otherwise, false
	 */
	private void setup() {
		boolean isAlreadyRunning = false;
		try {
			JUnique.acquireLock(APPLICATION_ID, getInstance().getUrlMessageHandler());
		} catch (AlreadyLockedException e) {
			// One instance of an UNICASE is already running.
			isAlreadyRunning = true;
		}
		String linkArgument = null;
		final String[] args = Platform.getCommandLineArgs();
		// Checks all arguments and get first one which starts with 
		// UNICASE link prefix (unicase://)
		for(int i=0; i < args.length; i++) {
			if(args[i].toLowerCase().startsWith(UNICASE_LINK_PREFIX)) {
				linkArgument = args[i];
				break;
			}
		}

		/* 
		 * if UNICASE is already running, we should send link argument from
		 * second instance to first one. Then, we should not let to run 
		 * second instance. Second instance should kill itself.
		 */ 
		if (isAlreadyRunning) {
			if (linkArgument != null) {
				JUnique.sendMessage(APPLICATION_ID, linkArgument);
				System.exit(-10);
			}
		} 
		/* If UNICASE is not running, we let this instance to run.  */ 
		else {
			/* 
			 * If it is started with link argument, we will open model 
			 * element which is defined in the link. Therefore, we assign
			 * link argument to the handledUrl variable. handledUrl will 
			 * be checked in link plugin to to open element.
			 */
			if (linkArgument != null) {
				handedUrl = linkArgument;
			} else {
				/*
				 * If there is not any argument, we let it run without 
				 * doing anything special.
				 */
			}
		}
	}

}


