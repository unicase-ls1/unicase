package org.unicase.ui.tom.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.ui.IEditorPart;
import org.unicase.ui.common.diagram.ModelDiagramEditor;
import org.unicase.ui.tom.TUIOTouchDispatch;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.TouchVisualizer;
import org.unicase.ui.tom.Utility;
import org.unicase.ui.tom.gestures.CreateNodeAndConnectionGesture;
import org.unicase.ui.tom.gestures.CreateNodeGesture;
import org.unicase.ui.tom.gestures.Gesture;
import org.unicase.ui.tom.gestures.GestureInterpreter;
import org.unicase.ui.tom.gestures.MoveCanvasGesture;
import org.unicase.ui.tom.gestures.MoveConnectionBendpointGesture;
import org.unicase.ui.tom.gestures.MoveNodeGesture;

public class ShowMultiTouchOverlayHandler extends AbstractHandler implements IHandler{

	private TouchDispatch dispatcher;
	private TouchVisualizer visualizer;
	private GestureInterpreter interpreter;

	public Object execute(ExecutionEvent event) throws ExecutionException {		

		IEditorPart editor = Utility.getActiveEditor();	
		if (editor == null){
			return null;
		}
		
		DiagramEditPart diagramEditPart = ((ModelDiagramEditor) editor).getDiagramEditPart();
		
		dispatcher = TUIOTouchDispatch.getInstance();
		visualizer = new TouchVisualizer();
		interpreter = new GestureInterpreter(dispatcher);

		dispatcher.getAdapters().add(visualizer);
		
		Gesture gesture = new CreateNodeGesture(dispatcher, diagramEditPart);
		interpreter.addGesture(gesture);
		
		Gesture createNodeAndConnectionGesture = new CreateNodeAndConnectionGesture(dispatcher, diagramEditPart);
		interpreter.addGesture(createNodeAndConnectionGesture);
		
		Gesture moveGesture = new MoveNodeGesture(dispatcher, diagramEditPart);
		interpreter.addGesture(moveGesture);
		
		Gesture moveConnectionBendpointGesture = new MoveConnectionBendpointGesture(dispatcher, diagramEditPart);
		interpreter.addGesture(moveConnectionBendpointGesture);
		
		Gesture moveCanvasGesture = new MoveCanvasGesture(dispatcher, diagramEditPart);
		interpreter.addGesture(moveCanvasGesture);
		
		return null;
	}
}
