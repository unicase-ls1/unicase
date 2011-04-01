/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.navigator.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.util.ActionHelper;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * listener ActionClass for the DoublclickAction and the ALT Key.
 * 
 * @author helming .
 */
public class AltKeyDoubleClickAction extends Action implements IDoubleClickListener, Listener {

	private ColumnViewer viewer;
	private boolean isAltKeyPressed;
	private String classname;
	private static String meeditorid = "org.unicase.ui.meeditor";

	/**
	 * <pre>
	 *  1- Adds the listener to the collection of listeners who will be notified when
	 *  an event of the - given type occurs anywhere in a widget. The event type is (SWT.Alt) 
	 *  one of the event constants defined in class SWT. When the event does occur, the listener
	 *  is notified by sending it the handleEvent() message.
	 * </pre>
	 */
	public AltKeyDoubleClickAction() {

		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getDisplay().addFilter(SWT.KeyDown, this);
	}

	/**
	 * <pre>
	 * 1- Adds the listener to the collection of listeners who will be notified when
	 *  an event of the - given type occurs anywhere in a widget. The event type is (SWT.Alt) 
	 *  one of the event constants defined in class SWT. When the event
	 *  does occur, the listener is notified by sending it the handleEvent() message.
	 * 
	 * </pre>
	 * 
	 * @param sourceView the view that requested the open model element.
	 */
	public AltKeyDoubleClickAction(final String sourceView) {
		this();
		this.classname = sourceView;

	}

	/**
	 * <pre>
	 * 1- Adds the listener to the collection of listeners who will be notified when
	 *  an event of the - given type occurs anywhere in a widget. The event type is (SWT.Alt) 
	 *  one of the event constants defined in class SWT. When the event
	 *  does occur, the listener is notified by sending it the handleEvent() message.
	 * 
	 * 2- Adds a listener for double-clicks in this viewer. Has no effect if an identical
	 *  listener is already registered.
	 * 
	 * </pre>
	 * 
	 * @param viewer ColumnViewer the Viewer of the sourceView.
	 * @param sourceView the view that requested the open model element.
	 */
	public AltKeyDoubleClickAction(ColumnViewer viewer, final String sourceView) {
		this(sourceView);
		this.viewer = viewer;
		this.viewer.addDoubleClickListener(this);
	}

	/**
	 * This opens the selected model element.
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 * @see org.eclipse.emf.ecp.navigator.commands.AltKeyDoubleClickAction#openSelectedModelelement()
	 */
	@Override
	public void run() {
		// This method opens a model regardless of a pressed Alt-Key.
		openSelectedModelelement();
	}

	/**
	 * This method opens a model regardless of a pressed Alt-Key.
	 */
	private void openSelectedModelelement() {
		// the selected Object or null if selection is not an IStructuredSelection

		EObject me = ActionHelper.getSelectedModelelement();
		if (me == null) {
			return;
		}
		if (classname == null || classname.equals("")) {
			return;
		}
		ActionHelper.openModelElement(me, classname);
	}

	/**
	 * @param event {@link Event}.
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {

		// check keyCode for Alt.
		if (event.keyCode == SWT.ALT) {
			isAltKeyPressed = true;
		}
	}

	/**
	 * @param event {@link DoubleClickEvent} .
	 * @see org.eclipse.jface.viewers.IDoubleClickListener#doubleClick (org.eclipse.jface.viewers.DoubleClickEvent).
	 */
	public void doubleClick(DoubleClickEvent event) {
		if (isAltKeyPressed) {
			closeActiveMEEditor();
		}
		isAltKeyPressed = false;
		// open selected modelelment.
		run();

	}

	/**
	 * this method closes an active MEEditor.
	 */
	private void closeActiveMEEditor() {

		IWorkbenchWindow workbenchwindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		if (workbenchwindow != null) {

			IWorkbenchPage page = workbenchwindow.getActivePage();

			if (page != null) {

				IEditorPart editor = page.getActiveEditor();

				if (editor != null && editor.getSite().getId().equals(meeditorid)) {

					page.closeEditor(editor, true);

				}

			}

		}

	}

}
