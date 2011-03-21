package org.unicase.changetracking.commands;


public abstract class BuildReleaseCommand extends ChangeTrackingCommand {

	private boolean isContinue;
	
	public abstract boolean hadConflicts();

	public void setContinue(boolean isContinue) {
		this.isContinue = isContinue;
	}

	public boolean isContinue() {
		return isContinue;
	}
	
}
