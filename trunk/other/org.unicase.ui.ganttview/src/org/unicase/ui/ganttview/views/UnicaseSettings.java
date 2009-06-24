package org.unicase.ui.ganttview.views;

import org.eclipse.nebula.widgets.ganttchart.DefaultSettings;

public class UnicaseSettings extends DefaultSettings {

	private int itemHeight = 12;
	private int eventSpacer = 16;
	private int headerHeight = 25;

	@Override
	public int getHeaderDayHeight() {
		return 0;
		// return this.headerHeight;
		// return (int) (this.headerHeight * 0.5);
	}

	@Override
	public int getHeaderMonthHeight() {
		return this.headerHeight;
		// return 0;
		// return (int) (this.headerHeight * 0.5);
	}

	@Override
	public int getEventHeight() {
		return this.itemHeight;
	}

	@Override
	public int getEventSpacer() {
		return eventSpacer;
	}

	@Override
	public int getEventsBottomSpacer() {
		return 0;
		// return this.getEventSpacer();
	}

	@Override
	public int getEventsTopSpacer() {
		return 0;
		// return this.getEventSpacer();
	}

	// public void setEventHeight(int itemHeight) {
	// this.itemHeight = itemHeight;
	// }
	//
	// public void setHeaderHeight(int headerHeight) {
	// this.headerHeight = headerHeight;
	// }

}
