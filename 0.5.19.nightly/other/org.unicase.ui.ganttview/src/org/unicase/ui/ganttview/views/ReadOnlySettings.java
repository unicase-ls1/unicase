/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.ganttview.views;

/**
 * @author max
 */
public class ReadOnlySettings extends UnicaseSettings {

	/**
	 * Override default behavior.
	 * 
	 * @return false
	 */
	@Override
	public boolean allowCheckpointResizing() {
		return false;
	}

	/**
	 * Override default behavior.
	 * 
	 * @return false
	 */
	@Override
	public boolean enableDragAndDrop() {
		return false;
	}

	/**
	 * Override default behavior.
	 * 
	 * @return false
	 */
	@Override
	public boolean enableResizing() {
		return false;
	}

	/**
	 * Override default behavior.
	 * 
	 * @return false
	 */
	@Override
	public boolean showDeleteMenuOption() {
		return false;
	}

	/**
	 * Override default behavior.
	 * 
	 * @return false
	 */
	@Override
	public boolean showPropertiesMenuOption() {
		return false;
	}

	/**
	 * Override default behavior.
	 * 
	 * @return false
	 */
	@Override
	public boolean showResizeDateTipOnBorders() {
		return false;
	}

}
