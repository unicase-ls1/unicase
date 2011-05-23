/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.commands;

import org.unicase.model.changetracking.Stream;

/**
 * Abstract base class of all create stream commands.
 * 
 * Specifies a method to retrieve the created stream.
 * 
 * @author jfinis
 * 
 */
public abstract class CreateStreamCommand extends ChangeTrackingCommand {

	/**
	 * Returns the created stream. If the command was not completed
	 * successfully, the result of this method is undefined (i.e. might be null
	 * or a not correctly set-up stream).
	 * 
	 * @return created stream.
	 */
	public abstract Stream getCreatedStream();
}
