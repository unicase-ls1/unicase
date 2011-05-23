/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.commands;

/**
 * Abstract base class for all build release commands supplied by adapters.
 * 
 * @author jfinis
 * 
 */
public abstract class BuildReleaseCommand extends ChangeTrackingCommand {

	/**
	 * States if this command is a continued one after conflict resolution.
	 */
	private boolean isContinue;

	/**
	 * Must be overridden by subclasses and return whether conflicts happend
	 * during the build process.
	 * 
	 * @return whether conflicts happend.
	 */
	public abstract boolean hadConflicts();

	/**
	 * Sets the continue flag. This flag states if the command continues after a
	 * resolved conflict.
	 * 
	 * @param isContinue new value for the isContinue flag.
	 */
	public void setContinue(boolean isContinue) {
		this.isContinue = isContinue;
	}

	/**
	 * Returns whether this command has continued after a conflict resolution.
	 * 
	 * @return whether command is continued.
	 */
	public boolean isContinue() {
		return isContinue;
	}

}
