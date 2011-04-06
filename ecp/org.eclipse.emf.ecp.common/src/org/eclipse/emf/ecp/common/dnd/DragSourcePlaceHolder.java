/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.common.dnd;

import java.util.List;

/**
 * This class is just a temporary location to hold dragSource in a DnD operation. Typically we should not have used such
 * a class to keep track of dragSource. Instead we should use a transfer class. But because of following I use it: 1.
 * Using a transfer is not guaranteed to work on all platforms and always. 2. On platforms other than windows dragSource
 * is not set until drop event fires, and we need dragSource during events like dragOver. 3. We are not planning to drop
 * something out of ECP environment, i.e. form ECP navigator on file system. This class is a singleton.
 * 
 * @author Hodaie
 */
public final class DragSourcePlaceHolder {

	private static Object dragSource;
	private static DragSourcePlaceHolder instance;

	private DragSourcePlaceHolder() {

	}

	/**
	 * Returns the singleton instance.
	 * 
	 * @return The DragSourcePlaceHolder instance
	 */
	public static DragSourcePlaceHolder getInstance() {
		if (instance == null) {
			instance = new DragSourcePlaceHolder();
		}
		return instance;
	}

	/**
	 * This method will be called from drag adaptors, in dragStart() event. This sets the drag source on which initially
	 * the drag started. This can be a single object of a collection.
	 * 
	 * @param dragSource the drag source
	 */
	@SuppressWarnings("rawtypes")
	public static void setDragSource(Object dragSource) {
		if ((dragSource instanceof List) && ((List) dragSource).size() == 0) {
			DragSourcePlaceHolder.dragSource = null;
		}
		DragSourcePlaceHolder.dragSource = dragSource;
	}

	/**
	 * This will be called from drop adaptors to get the drag source.
	 * 
	 * @return drag source; object(s) on which drag started
	 */
	public static Object getDragSource() {
		return dragSource;
	}

}
