package org.unicase.model.task.util;

import org.unicase.model.ModelElement;

public class MEStateImpl implements MEState {

	public MEStateImpl(ModelElement modelElement) {
		
	}

	public void addBlocker(ModelElement me) {
		// TODO Auto-generated method stub

	}

	public void addModifiedChild(ModelElement me) {
		// TODO Auto-generated method stub

	}

	public void addOpener(ModelElement me) {
		// TODO Auto-generated method stub

	}

	public String getStatus() {
		// TODO Auto-generated method stub
		return MEState.CLOSED;
	}

	public boolean isRecursivlyModified() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeBlocker(ModelElement me) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeModifiedChild(ModelElement me) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeOpener(ModelElement me) {
		// TODO Auto-generated method stub
		return false;
	}

}
