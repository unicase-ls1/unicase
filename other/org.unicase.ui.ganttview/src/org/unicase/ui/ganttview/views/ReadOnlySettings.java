package org.unicase.ui.ganttview.views;

import org.eclipse.nebula.widgets.ganttchart.DefaultSettings;

public class ReadOnlySettings extends DefaultSettings {

	@Override
	public boolean allowCheckpointResizing() {
		return false;
	}

	@Override
	public boolean enableDragAndDrop() {
		return false;
	}

	@Override
	public boolean enableResizing() {
		return false;
	}

	@Override
	public boolean showDeleteMenuOption() {
		return false;
	}

	@Override
	public boolean showPropertiesMenuOption() {
		return false;
	}

	@Override
	public boolean showResizeDateTipOnBorders() {
		return false;
	}
}
