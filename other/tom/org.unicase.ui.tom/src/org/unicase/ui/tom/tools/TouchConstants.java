/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.tools;

/**
 * @author schroech
 *
 */
public final class TouchConstants {

	private TouchConstants() {	
	}
	
	/**
	 * The width added to the boundary box of a polyline during hit testing.  
	 */
	public static final int POLYLINE_TOLERANCE = 30;
	/**
	 * The diameter of a touch.
	 */
	public static final int TOUCH_DIAMETER = 30;
	/**
	 * The diameter of a multi touch.
	 */
	public static final int MULTITOUCH_DIAMETER = 90;
	/**
	 * The maximum distance a touch can move until it is no longer considered static.
	 */
	public static final int TOUCH_MOVEMENT_THRESHOLD = 10;
	
	
	
}
