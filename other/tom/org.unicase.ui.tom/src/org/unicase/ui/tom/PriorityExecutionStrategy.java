package org.unicase.ui.tom;

import java.util.List;

import org.unicase.ui.tom.gestures.Gesture;

public class PriorityExecutionStrategy extends GestureExecutionStrategy {

	public PriorityExecutionStrategy(List<Gesture> gestures) {
		super(gestures);
	}

	@Override
	public List<Gesture> getExecutableGestures() {
		
		return null;
	}

}
