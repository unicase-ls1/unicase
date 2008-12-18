package org.unicase.ui.tom;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.FreeformViewport;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.common.diagram.ModelDiagramEditor;
import org.unicase.ui.tom.notifications.TouchAdapterImpl;
import org.unicase.ui.tom.touches.Touch;

public class TouchVisualizer extends TouchAdapterImpl implements IPageListener{

	private Map<Touch,TouchFigure> touchMap;

	private FreeformViewport freeformViewport;
	private Shell shell;
	private Viewport canvasViewport;

	private ModelDiagramEditor activeEditor;

	public TouchVisualizer() {

		touchMap = new HashMap<Touch, TouchFigure>();

		hookEditor();

		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWorkbenchWindow != null) {
			activeWorkbenchWindow.addPageListener(this);
		}
	}

	private void reset(){
		removeAllTouches();

		activeEditor = null;
		freeformViewport = null;
		canvasViewport = null;
		shell = null;
	}

	private void hookEditor(){

		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWorkbenchWindow == null) {
			return;
		}

		IEditorPart editor = activeWorkbenchWindow.getActivePage().getActiveEditor();

		if (editor == null
				|| !(editor instanceof ModelDiagramEditor)) {	 
			return;
		}

		activeEditor = (ModelDiagramEditor) editor;

		shell = activeEditor.getSite().getShell();

		FigureCanvas canvas;
		ModelDiagramEditor activeModelDiagramEditor;
		GraphicalViewer graphicalViewer;

		activeModelDiagramEditor = (ModelDiagramEditor) activeEditor;
		graphicalViewer = (GraphicalViewer)activeModelDiagramEditor.getAdapter(GraphicalViewer.class);
		if (graphicalViewer != null) {
			canvas = (FigureCanvas)graphicalViewer.getControl();

			LightweightSystem activeLightweightSystem = canvas.getLightweightSystem();
			IFigure rootFigure = activeLightweightSystem.getRootFigure();

			if (rootFigure != null) {
				freeformViewport = (FreeformViewport) rootFigure.getChildren().get(0);
			}

			if (canvas != null) {
				canvasViewport = canvas.getViewport();
			}
		}
	}

	private void addTouch(Touch addedTouch){

		TouchFigure touchFigure = new TouchFigure(addedTouch);

		touchMap.put(addedTouch,touchFigure);
		freeformViewport.add(touchFigure);

		Rectangle clientArea = canvasViewport.getClientArea();

		Point point = new Point(
				addedTouch.getX()-touchFigure.getSize().width/2+clientArea.x,
				addedTouch.getY()-touchFigure.getSize().height/2+clientArea.y);

		//		System.out.println("Touch added: " + point);

		touchFigure.setLocation(point);
	}

	private void removeAllTouches() {
		for (TouchFigure touchFigure : touchMap.values()) {
			freeformViewport.remove(touchFigure);
		}
		touchMap.clear();
	}

	private void removeTouch(Touch removedTouch){
		TouchFigure touchFigure = touchMap.get(removedTouch);
		freeformViewport.remove(touchFigure);
		touchMap.remove(removedTouch);
	}

	private class TouchFigure extends Ellipse {

		public TouchFigure(Touch touch){
			super();

			setMaximumSize(new Dimension(20,20));
			setMinimumSize(new Dimension(20,20));

			setSize(new Dimension(20,20));

			setBackgroundColor(org.eclipse.draw2d.ColorConstants.lightGreen);
		}

	}

	public void handleTouchAdded(Touch addedTouch){

		//		Display current = Display.getDefault();
		//
		//		if (current == null) {
		//			return;
		//		}
		//
		//		RunnableWithResult<org.eclipse.swt.graphics.Rectangle> runnable 
		//			= new RunnableWithResult.Impl<org.eclipse.swt.graphics.Rectangle>(){
		//			public void run() {
		//				setResult(shell.getBounds());
		//			}
		//		};
		//
		//		current.syncExec(runnable);
		//
		//		org.eclipse.swt.graphics.Rectangle result = runnable.getResult();

		//		if (result.contains(addedTouch.getPosition().getSWTPoint())) {
		addTouch(addedTouch);
		//		}
	}

	public void handleTouchChanged(Touch changedTouch) {
		TouchFigure touchFigure = touchMap.get(changedTouch);
		if (touchFigure == null) {
			return;
		}
		org.eclipse.draw2d.geometry.Rectangle clientArea = canvasViewport.getClientArea();

		//		Point location = canvasViewport.getLocation();
		//		canvasViewport.translateToAbsolute(location);

		Point point = new Point(
				changedTouch.getX()-touchFigure.getSize().width/2 + clientArea.x,
				changedTouch.getY()-touchFigure.getSize().height/2 + clientArea.y);

		//System.out.println("Touch changed: " + point);

		touchFigure.setLocation(point);
	}

	public void handleTouchRemoved(Touch removedTouch) {
		removeTouch(removedTouch);		
	}

	public void pageActivated(IWorkbenchPage page) {
		// TODO Auto-generated method stub

	}

	public void pageClosed(IWorkbenchPage page) {
		System.out.println("Page closed");
		reset();
	}

	public void pageOpened(IWorkbenchPage page) {
		System.out.println("Page opened");
		hookEditor();
	}
}
