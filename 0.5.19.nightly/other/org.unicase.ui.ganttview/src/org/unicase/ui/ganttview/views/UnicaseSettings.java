/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.ganttview.views;

import org.eclipse.nebula.widgets.ganttchart.DefaultSettings;

/**
 * @author max
 */
public class UnicaseSettings extends DefaultSettings {

	private int itemHeight = 12;
	private int eventSpacer = 16;
	private int headerHeight = 25;

	/**
	 * Override default behavior.
	 * 
	 * @return HeaderDayHeight
	 */
	@Override
	public int getHeaderDayHeight() {
		return 0;
	}

	/**
	 * Override default behavior.
	 * 
	 * @return HeaderMonthHeight
	 */
	@Override
	public int getHeaderMonthHeight() {
		return this.headerHeight;
	}

	/**
	 * Override default behavior.
	 * 
	 * @return EventHeight
	 */
	@Override
	public int getEventHeight() {
		return this.itemHeight;
	}

	/**
	 * Override default behavior.
	 * 
	 * @return EventSpacer
	 */
	@Override
	public int getEventSpacer() {
		return eventSpacer;
	}

	/**
	 * Override default behavior.
	 * 
	 * @return EventsBottomSpacer
	 */
	@Override
	public int getEventsBottomSpacer() {
		return 0;
	}

	/**
	 * Override default behavior.
	 * 
	 * @return EventsTopSpacer
	 */
	@Override
	public int getEventsTopSpacer() {
		return 0;
	}
}
