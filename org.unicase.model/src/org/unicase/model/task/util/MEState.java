/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.model.task.util;

import org.unicase.model.ModelElement;



public interface MEState {
	
	/**
	 * String for the Status open.
	 */
	String OPEN = "Open";

	/**
	 * String for the Status closed.
	 */
	String CLOSED = "Closed";

	/**
	 * String for the Status blocked.
	 */
	String BLOCKED = "Blocked";

	/**
	 * Returns the current status of a {@link ModelElement}.
	 * 
	 * @return the status
	 */
	String getStatus();

	/**
	 * If a subelement of the ME is modified or recursive modified itself.
	 * 
	 * @return <code>true</code> if a subelement is modified or recursively
	 *         modified
	 */
	boolean isRecursivlyModified();

	/**
	 * Adds a child which is modified or recursive modified in the reference
	 * list for caching.
	 * 
	 * @param me
	 *            the modified subelement.
	 */
	void addModifiedChild(ModelElement me);

	/**
	 * Removes a child which is no longer modified or recursive modified in the
	 * reference list for caching.
	 * 
	 * @param me
	 *            subelement, which is no longer modified.
	 * @return <code>true</code> if the remove modelelement was in the
	 *         reference list of modified subelements.
	 */
	boolean removeModifiedChild(ModelElement me);

	boolean removeOpener(ModelElement me);

	void addOpener(ModelElement me);

	boolean removeBlocker(ModelElement me);

	void addBlocker(ModelElement me);


	

} // MEState
