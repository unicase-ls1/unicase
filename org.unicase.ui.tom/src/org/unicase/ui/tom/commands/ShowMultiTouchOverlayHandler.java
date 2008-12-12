package org.unicase.ui.tom.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.common.diagram.ModelDiagramEditor;
import org.unicase.ui.tom.TUIOTouchDispatch;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.TouchVisualizer;
import org.unicase.ui.tom.gestures.AbstractGesture;
import org.unicase.ui.tom.gestures.CreateNodeAndConnectionGesture;
import org.unicase.ui.tom.gestures.CreateNodeGesture;
import org.unicase.ui.tom.gestures.GestureInterpreter;

public class ShowMultiTouchOverlayHandler extends AbstractHandler implements IHandler{

	private TouchDispatch dispatcher;
	private TouchVisualizer visualizer;
	private GestureInterpreter interpreter;

	public Object execute(ExecutionEvent event) throws ExecutionException {		
		IEditorPart editor = null; 
				
		RunnableWithResult<IEditorPart> runnableWithResult 
		= new RunnableWithResult.Impl<IEditorPart>(){
			public void run(){
				try {
					IWorkbench workbench = PlatformUI.getWorkbench();
					IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
					IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
					IEditorPart activeEditor = activePage.getActiveEditor();
					setResult(activeEditor);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		final Display current = Display.getDefault();
		if (current != null) {
			current.syncExec(runnableWithResult);
		}
	
		editor = runnableWithResult.getResult();
	
		if (editor == null){
			return null;
		}
		
		DiagramEditPart diagramEditPart = ((ModelDiagramEditor) editor).getDiagramEditPart();
		
		dispatcher = TUIOTouchDispatch.getInstance();
		visualizer = new TouchVisualizer();
		interpreter = new GestureInterpreter(dispatcher);

		dispatcher.getAdapters().add(visualizer);
		
		AbstractGesture gesture = new CreateNodeGesture(dispatcher, diagramEditPart);
		interpreter.addGesture(gesture);
		
		AbstractGesture secondGesture = new CreateNodeAndConnectionGesture(dispatcher, diagramEditPart);
		interpreter.addGesture(secondGesture);
		
		return null;
	}
}
