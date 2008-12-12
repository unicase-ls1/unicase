package org.unicase.ui.tom.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.unicase.ui.tom.gestures.CreateGesture;
import org.unicase.ui.tom.gestures.CreateNodeGesture;
import org.unicase.ui.tom.gestures.GestureInterpreter;

public class DebugHandler extends AbstractHandler implements IHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {

		GestureInterpreter gestureInterpreter = new GestureInterpreter();
		CreateGesture createGesture = new CreateNodeGesture(null, null);
		
		gestureInterpreter.addGesture(createGesture);
		createGesture.setCanExecute(true);
		
		return null;
	}

}
