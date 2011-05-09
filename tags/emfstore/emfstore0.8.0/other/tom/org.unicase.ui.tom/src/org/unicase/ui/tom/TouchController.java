/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.unicasecommon.diagram.part.ModelDiagramEditor;

/**
 * The TouchController is the main controller of the TOM component. 
 * It controls the multi-touch mode and observes the active editor state.
 */
public final class TouchController implements IPartListener{

	/**
	 * The singleton instance. 
	 */
	private static final TouchController INSTANCE = new TouchController();
	
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

	/**
	 * Returns the singleton instance.
	 * @return The singleton instance 
	 */
	public static TouchController getInstance() {
		return INSTANCE;
	}

	/**
	 * Toggles the multi-touch mode.
	 */
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

	/**
	 * @return If the multi-touch mode is active
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * Notify the controller about closed workbench pages.
	 * @param page The IWorkbenchPage being closed
	 */
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

	/**
	 * Notify the controller about opened workbench pages.
	 * @param page The IWorkbenchPage being opened
	 */
	public void pageOpened(IWorkbenchPage page) {
		IEditorPart editor = Utility.getActiveEditor();
		if (editor == null || !(editor instanceof ModelDiagramEditor)) {	 
			return;
		}
		
		this.setActiveEditor((ModelDiagramEditor) editor);
	}

	/**
	 * Sets the active editor.
	 * @param activeEditor The new active editor
	 */
	public void setActiveEditor(ModelDiagramEditor activeEditor) {
		this.activeEditor = activeEditor;
		
		dispatcher.setActiveEditor(activeEditor);
		visualizer.setActiveEditor(activeEditor);
		interpreter.setActiveEditor(activeEditor);
	}

	/**
	 * @return The new active editor
	 */
	public ModelDiagramEditor getActiveEditor() {
		return activeEditor;
	}

	/**
	 * Notify the controller about parts being activated.
	 * @param part The new active part
	 */
	public void partActivated(IWorkbenchPart part) {
		//do nothing
	}

	/**
	 * Notify the controller about parts being brought to top.
	 * @param part The part being brought to top.
	 */
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

	/**
	 * Notify the controller about parts being closed.
	 * @param part The part being closed.
	 */
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

	/**
	 * Notify the controller about parts being deactivated.
	 * @param part The part being deactivated.
	 */
	public void partDeactivated(IWorkbenchPart part) {
		//do nothing
	}

	/**
	 * Notify the controller about parts being opened.
	 * @param part The part being opened.
	 */
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
