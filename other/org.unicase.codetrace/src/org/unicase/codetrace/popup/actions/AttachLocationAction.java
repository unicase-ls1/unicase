/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.codetrace.popup.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.texteditor.ITextEditor;
import org.unicase.codetrace.AttachLocationCommand;
import org.unicase.codetrace.CodetraceUtil;
import org.unicase.codetrace.tracer.LocationFinder;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.trace.CodeLocation;
import org.unicase.ui.meeditor.MEEditorInput;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * This action is executed when the user presses "link code to unicase" in the context menu.
 * It creates a code location at the specified line and file and opens a dialog
 * to choose a model element to attach the code location to.
 * @author kterzieva
 * @author snogina
 * @author jfinis
 */
public class AttachLocationAction extends Action {

	/**
	 * The text editor.
	 */
	private ITextEditor editor;
	
	/**
	 * The vertical ruler info.
	 */
	private IVerticalRulerInfo rulerInfo;
	
	/**
	 * Default constructor, called by the action delegate.
	 * @param editor editor
	 * @param rulerInfo rulerInfo
	 */
	public AttachLocationAction(ITextEditor editor, IVerticalRulerInfo rulerInfo){
		this.editor = editor;
		this.rulerInfo = rulerInfo;
	}

	/**
	 * The run method does the job:
	 * 
	 * 1.) Is the editor dirty? If so ask the user to save. If he doesn't save, abort
	 * 2.) Get the line that was clicked on the ruler and the resource
	 * 3.) Open dialog for choosing a ModelElement to attach the location to (abort if none is chosen)
	 * 4.) Create the code location
	 * 5.) Attach it to the chosen ModelElement
	 * 6.) Open the Code Location in MEEditor
	 * 7.) Create a marker for the code location
	 */
	@Override
	public void run() {
		
		//Is the editor dirty? If so, save it first
		if(editor.isDirty()){
			PlatformUI.getWorkbench().saveAllEditors(true);
			
			//We cannot set markers on a dirty resource, this would lead to unexpected behavior.
			if(editor.isDirty()){
				MessageDialog.openError(
					PlatformUI.getWorkbench().
					getActiveWorkbenchWindow().getShell(),
					"Error",
					"Cannot link source code if the file is unsaved.\nPlease save first!");
				return;
			}
		}
	
		//Get the line and check if it's correct
		int line = rulerInfo.getLineOfLastMouseButtonActivity();
		if(line == -1){
			return;
		}
		line++;

		//Get the resource
		IResource resource = ResourceUtil.getResource(editor.getEditorInput());
		
		//No file? Abort! (This is impossible, I think)
		if(!(resource instanceof IFile)){
			WorkspaceUtil.log("Cannot attach a code location to a resource that is no file!", new Exception("Cannot attach a code location to a resource that is no file!"), IStatus.ERROR);
			return;
		}
		
		//Chose a model element for attaching
		UnicaseModelElement m = CodetraceUtil.showChooseMEForCodeLocationDialog();
		
		//No model element chosen? Abort!
		if(m == null){
			return;
		}
		
		//Create the location
		CodeLocation tl = LocationFinder.getInstance().createLocation(resource.getProject().getName(),
				resource.getProjectRelativePath().toString(), line);
		
		//Attach it
		new AttachLocationCommand(m,tl).run();
		
		//Open meeditor
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new MEEditorInput(tl),
				"org.unicase.ui.meeditor", true);
		} catch (PartInitException e1) {
			WorkspaceUtil.logException("Could not switch to MEeditor after creating a code location.", e1);
		}
		
		//Create a marker
		try {
			CodetraceUtil.createMarker(tl, (IFile) resource, line);
		} catch (CoreException e) {
			WorkspaceUtil.logException("Could not create marker for newly created code location.", e);
		}
		
	

	}

	/**
	 * {@inheritDoc}
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 * @param action 
	 * @param selection 
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}
	
	/**
	 * {@inheritDoc}
	 * does nothing.
	 * @param view ignore
	 */

	public void init(IViewPart view) {
	}
	
	/**
	 * does nothing.
	 * @param action ignore
	 * @param targetEditor the target editor
	 */
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
	}

}
