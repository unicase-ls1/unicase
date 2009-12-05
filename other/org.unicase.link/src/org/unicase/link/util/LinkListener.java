/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.util;

import org.eclipse.core.runtime.Platform;
import org.unicase.link.handlers.URLMessageHandler;

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
public final class LinkListener {
	
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
	
	private static LinkListener instance; 
	
	private URLMessageHandler urlMessageHandler; 
	
	/**
	 * Constructor of LinkTrigger.
	 */
	private LinkListener() {
		urlMessageHandler = new URLMessageHandler();
	}

	/**
	 * Gets the singleton instance.
	 * @return the singleton
	 */
	public static LinkListener getInstance() {	
		if (instance == null) {
			instance = new LinkListener();
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
	 * Locks the application id and sets up a trigger to get arguments from
	 * other run attempts of UNICASE.
	 * 
	 * @return false if id was not locked. Otherwise, false
	 */
	private void setup() {
		try {
			JUnique.acquireLock(APPLICATION_ID, urlMessageHandler);
		} catch (AlreadyLockedException e) {
			// Another instance of eclipse is already running, do nothing.
			return;
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


