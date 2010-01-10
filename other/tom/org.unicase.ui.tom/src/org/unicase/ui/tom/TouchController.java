package org.unicase.ui.tom;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.unicasecommon.diagram.part.ModelDiagramEditor;

public final class TouchController implements IPartListener{

	private static final TouchController instance = new TouchController();
	
	private boolean isActive;
	
	private IWorkbenchPage workbenchPage;
	private TouchDispatch dispatcher;
	private TouchVisualizer visualizer;
	private GestureInterpreter interpreter;
	
	private ModelDiagramEditor activeEditor;
	
	private TouchController() {

		dispatcher = TUIOTouchDispatch.getInstance();
		visualizer = new TouchVisualizer();
		interpreter = new GestureInterpreter(dispatcher);

		dispatcher.getSingleTouchNotifier().getAdapters().add(visualizer.getSingleTouchAdapter());
		dispatcher.getMultiTouchNotifier().getAdapters().add(visualizer.getMultiTouchAdapter());
	}

	public static TouchController getInstance() {
		return instance;
	}

	public void toggleMultiTouchMode() {
		if (isActive) {
			setActiveEditor(null);
			
			if (workbenchPage != null) {
				workbenchPage.removePartListener(this);
			}
			
			isActive = false;
		}else{
			IEditorPart activeEditor = Utility.getActiveEditor();
			IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			if (workbenchWindow != null) {
				workbenchPage = workbenchWindow.getActivePage();
				if (workbenchPage != null) {
					workbenchPage.addPartListener(this);
				}
			}
			
			if (activeEditor instanceof ModelDiagramEditor) {
				this.setActiveEditor((ModelDiagramEditor) activeEditor);
			}
			
			isActive = true;
		}
	}

	public boolean isActive() {
		return isActive;
	}

	public void pageClosed(IWorkbenchPage page) {
		if (!isActive) {
			return;
		}

		IEditorPart pageActiveEditor = page.getActiveEditor();
		
		if (pageActiveEditor instanceof ModelDiagramEditor) {
			if (getActiveEditor() == pageActiveEditor) {
				setActiveEditor(null);
			}
		}
		
	}

	public void pageOpened(IWorkbenchPage page) {
		IEditorPart editor = Utility.getActiveEditor();
		if (editor == null || !(editor instanceof ModelDiagramEditor)) {	 
			return;
		}
		
		this.setActiveEditor((ModelDiagramEditor) editor);
	}

	public void setActiveEditor(ModelDiagramEditor activeEditor) {
		this.activeEditor = activeEditor;
		
		dispatcher.setActiveEditor(activeEditor);
		visualizer.setActiveEditor(activeEditor);
		interpreter.setActiveEditor(activeEditor);
	}

	public ModelDiagramEditor getActiveEditor() {
		return activeEditor;
	}

	public void partActivated(IWorkbenchPart part) {
		//do nothing
	}

	public void partBroughtToTop(IWorkbenchPart part) {
		if (!isActive) {
			return;
		}
		
		IEditorPart pageActiveEditor = Utility.getActiveEditor();

		if (pageActiveEditor instanceof ModelDiagramEditor) {
			if (getActiveEditor() != pageActiveEditor) {
				setActiveEditor((ModelDiagramEditor) pageActiveEditor);	
			}
		}else{
			setActiveEditor(null);
		}
	}

	public void partClosed(IWorkbenchPart part) {
		if (!isActive) {
			return;
		}
		
		IEditorPart pageActiveEditor = Utility.getActiveEditor();

		if (pageActiveEditor instanceof ModelDiagramEditor) {
			if (getActiveEditor() != pageActiveEditor) {
				setActiveEditor((ModelDiagramEditor) pageActiveEditor);	
			}
		}else{
			setActiveEditor(null);
		}
	}

	public void partDeactivated(IWorkbenchPart part) {
		//do nothing
	}

	public void partOpened(IWorkbenchPart part) {
		if (!isActive) {
			return;
		}
		
		IEditorPart pageActiveEditor = Utility.getActiveEditor();

		if (pageActiveEditor instanceof ModelDiagramEditor) {
			if (getActiveEditor() != pageActiveEditor) {
				setActiveEditor((ModelDiagramEditor) pageActiveEditor);	
			}
		}else{
			setActiveEditor(null);
		}
	}
}
