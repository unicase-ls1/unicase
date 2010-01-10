package org.unicase.ui.tom.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.ui.IEditorPart;
import org.unicase.ui.tom.GestureInterpreter;
import org.unicase.ui.tom.Utility;
import org.unicase.ui.unicasecommon.diagram.part.ModelDiagramEditor;

public class DebugHandler extends AbstractHandler implements IHandler {

	private GestureInterpreter interpreter;

	public Object execute(ExecutionEvent event) throws ExecutionException {

//		GestureInterpreter gestureInterpreter = new GestureInterpreter();
//		CreateGesture createGesture = new CreateNodeGesture(null, null);
//		
//		gestureInterpreter.addGesture(createGesture);
//		createGesture.setCanExecute(true);
		IEditorPart editor = Utility.getActiveEditor();
		
		DiagramEditPart diagramEditPart = ((ModelDiagramEditor) editor).getDiagramEditPart();
		
		interpreter = new GestureInterpreter();
		
//		SelectGesture selectGesture = new Selec
//		AbstractGesture gesture = new CreateNodeGesture(dispatcher, diagramEditPart);
//		interpreter.addGesture(gesture);
//		
//		AbstractGesture secondGesture = new CreateNodeAndConnectionGesture(dispatcher, diagramEditPart);
//		interpreter.addGesture(secondGesture);
		
		return null;
	}
}