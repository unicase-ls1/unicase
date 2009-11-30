/*******************************************************************************
 * Copyright (c) 2007, 2008 OnPositive Technologies (http://www.onpositive.com/) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     OnPositive Technologies (http://www.onpositive.com/) - initial API and implementation
 *******************************************************************************/
package com.onpositive.richtexteditor.model;


/**
 * @author kor
 *
 */
public class Logger {

	private static ILogger logger;
	
	/**
	 * @return logger
	 */
	public static ILogger getLogger() {
		return logger;
	}

	/**
	 * @param logger logger instance;
	 */
	public static void setLogger(ILogger logger) {
		Logger.logger = logger;
	}

	/**
	 * @param exception exception to log
	 */
	public static void log(Throwable exception){
		if (logger!=null){
			logger.log(exception);
		}
		else{			
			exception.printStackTrace();
		}
	}
	
	/**
	 * @param message message
	 */
	public static void log(String message){
		if (logger!=null){
			logger.log(message);
		}
		else{
			System.err.println(message);
		}
	}
}
