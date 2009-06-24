package org.unicase.ui.ganttview.views;


public class ReadOnlySettings extends UnicaseSettings {

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
