/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.release;

/**
 * This class depicts a problem which occurred during the
 * checking of a release.
 * 
 * A problem is either an error or a warning.
 * While an error makes release building impossible, a warning
 * just discourages it.
 * 
 * @author gex
 *
 */
public class Problem {
	
	/**
	 * The severity of a problem, either a warning or an error.
	 * 
	 * @author gex
	 *
	 */
	public static enum Severity{
		/**
		 * An ERROR prevents the release from being built.
		 */
		ERROR, 
		
		/**
		 * A warning does not prevent the build process but
		 * discourages it.
		 */
		WARNING;
	}

	private final Severity severity;
	private final String message;

	/**
	 * Default constructor.
	 * @param s problem severity.
	 * @param message problem message.
	 */
	public Problem(Severity s, String message){
		this.severity = s;
		this.message = message;
	}
	
	/**
	 * Returns the severity of the problem.
	 * @return severity
	 */
	public Severity getSeverity() {
		return severity;
	}

	/**
	 * Returns the problem message,
	 * stating the fact causing the problem
	 * and maybe a hint how to solve it. 
	 * The message will be displayed to the user.
	 * @return problem message.
	 */
	public String getMessage() {
		return message;
	}
}
