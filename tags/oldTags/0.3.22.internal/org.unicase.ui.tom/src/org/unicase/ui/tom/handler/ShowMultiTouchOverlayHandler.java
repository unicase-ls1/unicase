package org.unicase.ui.tom.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.unicase.ui.tom.GestureInterpreter;
import org.unicase.ui.tom.TUIOTouchDispatch;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.TouchVisualizer;

public class ShowMultiTouchOverlayHandler extends AbstractHandler implements IHandler{

	private TouchDispatch dispatcher;
	private TouchVisualizer visualizer;
	private GestureInterpreter interpreter;

	public Object execute(ExecutionEvent event) throws ExecutionException {		
		
		dispatcher = TUIOTouchDispatch.getInstance();
		visualizer = new TouchVisualizer();
		interpreter = new GestureInterpreter(dispatcher);

		dispatcher.getAdapters().add(visualizer);
		
		return null;
	}
}
