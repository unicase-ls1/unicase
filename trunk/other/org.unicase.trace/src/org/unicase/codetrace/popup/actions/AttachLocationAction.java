/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.codetrace.popup.actions;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.unicase.codetrace.AttachLocationCommand;
import org.unicase.codetrace.tracer.LocationFinder;
import org.unicase.codetrace.ui.AttachCodeLocation;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.trace.CodeLocation;

/**
 * This action is executed when the user presses create code location in the context menu.
 * It creates a code location at the specified line and file and opens a dialog
 * to choose a model element to attach the code location to.
 * @author kterzieva
 * @author snogina
 * @author jfinis
 * 
 *
 */
public class AttachLocationAction implements IEditorActionDelegate {

	private IEditorPart editorPart;


	/**
	 * @see IActionDelegate#run(IAction)
	 * @param action ignore
	 */
	public void run(IAction action) {

		IEditorInput editorInput = editorPart.getEditorInput();
		ISelection selection = ((AbstractTextEditor) editorPart)
				.getSelectionProvider().getSelection();

		IResource resource = ResourceUtil.getResource(editorInput);
		int lineNumber = ((ITextSelection) selection).getStartLine();
		LocationFinder tf = LocationFinder.getInstance();
		UnicaseModelElement m = AttachCodeLocation.showChooseMEForCodeLocationDialog();
		CodeLocation tl = tf.createLocation(resource.getProject().getName(),
				resource.getProjectRelativePath().toString(), lineNumber + 1);
		
		new AttachLocationCommand(m,tl).run();

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
	 * @param view ignore
	 */

	public void init(IViewPart view) {
	}
	
	/**
	 * Sets editor.
	 * @param action ignore
	 * @param targetEditor the target editor
	 */
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		this.editorPart = targetEditor;
	}

}
