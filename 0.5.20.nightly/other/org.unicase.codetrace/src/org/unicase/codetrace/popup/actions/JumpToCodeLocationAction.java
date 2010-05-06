/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.codetrace.popup.actions;

import java.util.Iterator;


import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.IUpdate;
import org.eclipse.ui.texteditor.SimpleMarkerAnnotation;
import org.unicase.codetrace.CodetraceUtil;
import org.unicase.model.trace.CodeLocation;
import org.unicase.ui.meeditor.MEEditorInput;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Action executed when the user rightclicks on a code location marker and
 * selects "jump to code location". It will find the associated code location
 * (if it exists) and open it in MEEditor
 * @author jfinis
 */
public class JumpToCodeLocationAction extends Action implements IUpdate{
	
	/**
	 * The editor.
	 */
	private ITextEditor fEditor;
	
	/**
	 * The vertical ruler info.
	 */
	private IVerticalRulerInfo fRulerInfo;
	
	/**
	 * Standardconstructor, called by the action's delegate.
	 * @param editor text editor
	 * @param info vertical ruler information
	 */
	public JumpToCodeLocationAction(ITextEditor editor, IVerticalRulerInfo info) {
		fEditor = editor;
		fRulerInfo = info;
	}

	/**
	 * Returns the code location marker at the last line of mouse activity in the ruler
	 * or <code>null</code> if none.
	 * 
	 * @return code location marker associated with activity in the ruler or <code>null</code>
	 */
	@SuppressWarnings("unchecked")
	protected IMarker getSelectedLocationMarker() {
		IAnnotationModel annotationModel = fEditor.getDocumentProvider().getAnnotationModel(fEditor.getEditorInput());
		IDocument document = fEditor.getDocumentProvider().getDocument(fEditor.getEditorInput());
		
		//No annotation model? No markers.
		if (annotationModel == null){
			return null;
		}
		Iterator<Annotation> iterator = annotationModel.getAnnotationIterator();
		while (iterator.hasNext()) {
			Annotation annotation = iterator.next();
			
			//No marker annotation? Skip.
			if (!(annotation instanceof SimpleMarkerAnnotation)) {
				continue;
			}
			
			//Get marker and check if this is the correct one
			SimpleMarkerAnnotation markerAnnotation = (SimpleMarkerAnnotation) annotation;
			IMarker marker = markerAnnotation.getMarker();
			try {
				if (!marker.isSubtypeOf(CodetraceUtil.CODE_LOCATION_MARKER_ID)) {
					continue;
				}
				Position position = annotationModel.getPosition(markerAnnotation);
				int line = document.getLineOfOffset(position.getOffset());
				if (line == fRulerInfo.getLineOfLastMouseButtonActivity()) {
					return marker;
				}
				
			} catch (CoreException e) {
			} catch (BadLocationException e) {
			}
			
		}
		return null;
	}
	
	private IMarker selectedMarker;
	

	/**
	 * Tries to find the associated code location and open in in the MEEditor.
	 * 
	 * If no location is found, the marker is deleted.
	 */
	public void run() {
		selectedMarker = getSelectedLocationMarker();
		if (selectedMarker != null) {
			CodeLocation cl = CodetraceUtil.getLocationFromMarker(selectedMarker);
			if(cl == null){
				MessageDialog.openError(
					PlatformUI.getWorkbench().
					getActiveWorkbenchWindow().getShell(),
					"Error",
					"The associated code location could not be found. It was either deleted or its project is not checked out.");
				try {
					selectedMarker.delete();
				} catch (CoreException e) {
				}
				selectedMarker = null;
				return;
			}
			
			//Jump to the location in ME-Editor
			try {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new MEEditorInput(cl),
					"org.unicase.ui.meeditor", true);
			} catch (PartInitException e1) {
				WorkspaceUtil.logException("Could not switch to MEeditor to show associated code location.", e1);
			}
		}
	}

	/**
	 * Updates the enablement status, depending on the position of the click.
	 */
	public void update() {
		selectedMarker = getSelectedLocationMarker();
		boolean selected = (selectedMarker != null);
		setEnabled(selected);
		if(selected){
			setText("Jump to associated code location");
		} else {
			setText("Select code location to jump");
		}
	}
	
	/**
	 * Returns the editor this action was created for.
	 * 
	 * @return editor
	 */
	protected ITextEditor getEditor() {
		return fEditor;
	}
	
	/**
	 * Returns the vertical ruler information this action was created for.
	 * 
	 * @return vertical ruler information
	 */
	protected IVerticalRulerInfo getVerticalRulerInfo() {
		return fRulerInfo;
	}
}
