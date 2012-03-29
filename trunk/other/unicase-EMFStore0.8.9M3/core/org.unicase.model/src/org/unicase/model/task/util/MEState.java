/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.util;

import org.unicase.model.UnicaseModelElement;

/**
 * Interface for MEState. An meestate element calculates the state for a modelelement.
 * 
 * @author helming
 */
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
	 * Returns the current status of a {@link UnicaseModelElement}.
	 * 
	 * @return the status
	 */
	String getStatus();

	/**
	 * If a subelement of the ME is modified or recursive modified itself.
	 * 
	 * @return <code>true</code> if a subelement is modified or recursively modified
	 */
	boolean isRecursivlyModified();

	/**
	 * Adds a child which is modified or recursive modified in the reference list for caching.
	 * 
	 * @param me the modified subelement.
	 */
	void addModifiedChild(UnicaseModelElement me);

	/**
	 * Removes a child which is no longer modified or recursive modified in the reference list for caching.
	 * 
	 * @param me subelement, which is no longer modified.
	 * @return <code>true</code> if the remove modelelement was in the reference list of modified subelements.
	 */
	boolean removeModifiedChild(UnicaseModelElement me);

	/**
	 * Removes a modelelement from the opener list.
	 * 
	 * @param me the modelelement
	 */
	void removeOpener(UnicaseModelElement me);

	/**
	 * Adds a modelelement to the opener list.
	 * 
	 * @param me the modelelement
	 */
	void addOpener(UnicaseModelElement me);

	/**
	 * Removes a modelelement from the blocker list.
	 * 
	 * @param me the modelelement
	 */
	void removeBlocker(UnicaseModelElement me);

	/**
	 * Adds a modelelement to the blocker list.
	 * 
	 * @param me the modelelement
	 */
	void addBlocker(UnicaseModelElement me);

} // MEState
