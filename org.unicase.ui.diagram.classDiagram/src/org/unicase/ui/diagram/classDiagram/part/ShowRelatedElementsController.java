/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.unicase.model.classes.Class;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.diagram.util.CollectionFilter;
import org.unicase.ui.diagram.classDiagram.edit.commands.AddRelatedElementsCommand;
import org.unicase.ui.diagram.classDiagram.edit.parts.ClassEditPart;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;

/**
 * @author schroech
 */
public final class ShowRelatedElementsController {

	private static final Map<EditPartViewer, ShowRelatedElementsController> VIEWER_CONTROLLER_MAP = new HashMap<EditPartViewer, ShowRelatedElementsController>();

	private EditPartViewer editPartViewer;
	private final DiagramEditPart diagramEditPart;

	private ClassEditPart primaryClassEditPart;

	private boolean active;
	private boolean modeEnabled;
	private boolean modeKeyPressed;

	private final Map<EObject, ViewDescriptor> objectViewDescriptorMap = new HashMap<EObject, ViewDescriptor>();

	private SelectionChangeListener selectionChangeListener = new SelectionChangeListener();
	private ModifierKeyListener modifierKeyListener = new ModifierKeyListener();
	private ViewerDisposeListener viewerDisposeListener = new ViewerDisposeListener();

	/**
	 * @author schroech
	 */
	private class ModifierKeyListener implements KeyListener {

		public void keyPressed(KeyEvent e) {
			if (e.keyCode == SWT.ALT) {
				setModeKeyPressed(true);
			} else {
				setModeKeyPressed(false);
			}
		}

		public void keyReleased(KeyEvent e) {
			if (e.keyCode == SWT.ALT) {
				setModeKeyPressed(true);
			} else {
				setModeKeyPressed(false);
			}
		}

	}

	/**
	 * @author schroech
	 */
	private class ViewerDisposeListener implements DisposeListener {
		public void widgetDisposed(DisposeEvent e) {
			setEditPartViewer(null);
		}

	}

	/**
	 * Private class listening for selection change events on the edit policies
	 * host. Tracks the current selection and hides or shows classes in
	 * response.
	 * 
	 * @author schroech
	 */
	private class SelectionChangeListener implements ISelectionChangedListener {

		/**
		 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
		 */
		public void selectionChanged(SelectionChangedEvent event) {
			if (!active) {
				return;
			}

			try {
				handleSelectionChanged(event);
			} catch (IllegalStateException e) {
				setActive(false);
			}
		}

		private void handleSelectionChanged(SelectionChangedEvent event) {
			// BEGIN SANITY CHECKS
			if (getObjectViewDescriptorMap().size() == 0) {
				throw new IllegalStateException();
			}

			Object diagram = EditPartUtility.getElement(getDiagramEditPart());
			if (!(diagram instanceof MEDiagram)) {
				throw new IllegalStateException();
			}

			EditPart selectedEditPart = getSelectedEditPart(event);
			if (selectedEditPart == null) {
				throw new IllegalStateException();
			}

			Set<EditPart> editParts = getRelatedEditParts();
			if (editParts.size() == 0) {
				throw new IllegalStateException();
			}
			// END SANITY CHECKS

			if (!editParts.contains(selectedEditPart)) {
				selectedEditPart = getDiagramEditPart();
			}

			AddRelatedElementsCommand addCommand = createAddRelatedElementsCommand(
					selectedEditPart, editParts);

			getDiagramEditPart().getDiagramEditDomain()
					.getDiagramCommandStack().execute(addCommand);

			if (!(isModeEnabled() || modeKeyPressed)) {
				setActive(false);
			}
		}

		private AddRelatedElementsCommand createAddRelatedElementsCommand(
				EditPart selectedEditPart, Set<EditPart> editParts) {
			AddRelatedElementsCommand addCommand = null;
			if (selectedEditPart == getDiagramEditPart()) {
				addCommand = new AddRelatedElementsCommand(selectedEditPart,
						editParts, diagramEditPart);
			} else {
				if (isModeEnabled() || modeKeyPressed) {
					addCommand = new AddRelatedElementsCommand(
							selectedEditPart,
							Collections.singletonList(selectedEditPart),
							getDiagramEditPart());
				} else {
					editParts.remove(selectedEditPart);
					addCommand = new AddRelatedElementsCommand(
							selectedEditPart, editParts, getDiagramEditPart());
				}
			}
			return addCommand;
		}

		private EditPart getSelectedEditPart(SelectionChangedEvent event) {
			EditPart selectedEditPart = null;
			ISelection selection = event.getSelection();
			if (selection instanceof IStructuredSelection) {
				Object firstElement = ((IStructuredSelection) selection)
						.getFirstElement();
				if (firstElement instanceof EditPart) {
					selectedEditPart = (EditPart) firstElement;
				}
			}
			return selectedEditPart;
		}
	}

	/**
	 * @return The {@link EditPart}s related to the currently selected
	 *         {@link EditPart}
	 */
	public Set<EditPart> getRelatedEditParts() {
		Set<EObject> keySet = getObjectViewDescriptorMap().keySet();

		Set<EditPart> editParts = new HashSet<EditPart>();
		if (primaryClassEditPart != null) {
			editParts.addAll(EditPartUtility.findConnectionEditParts(
					primaryClassEditPart, keySet));
		}

		Set<EditPart> foundEditParts = EditPartUtility.findEditParts(
				getDiagramEditPart(), keySet);
		for (EditPart foundEditPart : foundEditParts) {
			if (foundEditPart instanceof ShapeNodeEditPart
					|| foundEditPart instanceof ConnectionNodeEditPart) {
				editParts.add(foundEditPart);
			}
		}

		return editParts;
	}

	/**
	 * @return The {@link Edge}s related to the currently selected
	 *         {@link EditPart}
	 */
	public Collection<? extends Edge> getRelatedEdges() {
		Set<Edge> edges = new HashSet<Edge>();
		Collection<ViewDescriptor> values = getObjectViewDescriptorMap()
				.values();
		Collection<ConnectionViewDescriptor> edgeDescriptors = CollectionFilter
				.filter(values, ConnectionViewDescriptor.class);
		for (ConnectionViewDescriptor connectionViewDescriptor : edgeDescriptors) {
			Object view = connectionViewDescriptor.getAdapter(View.class);
			if (view instanceof Edge) {
				edges.add((Edge) view);
			}
		}
		return edges;
	}

	/**
	 * @return The {@link EObject}s of the nodes related to the currently
	 *         selected {@link EditPart}
	 */
	public Collection<? extends EObject> getRelatedNodeElements() {
		Set<EObject> keySet = getObjectViewDescriptorMap().keySet();
		Collection<Class> classes = CollectionFilter
				.filter(keySet, Class.class);
		return classes;
	}

	private ShowRelatedElementsController(EditPartViewer editPartViewer) {
		this.setEditPartViewer(editPartViewer);

		EditPart contents = editPartViewer.getRootEditPart().getContents();
		if (!(contents instanceof DiagramEditPart)) {
			throw new IllegalArgumentException();
		}

		this.diagramEditPart = (DiagramEditPart) contents;

	}

	/**
	 * Each {@link ShowRelatedElementsController} is associated to one
	 * {@link EditPartViewer}. This method returns an existing
	 * {@link ShowRelatedElementsController} or creates a new one, if needed.
	 * 
	 * @param editPartViewer
	 *            The {@link EditPartViewer} whose
	 *            {@link ShowRelatedElementsController} should be returned;
	 * @return The matching {@link ShowRelatedElementsController}
	 */
	public static ShowRelatedElementsController getInstance(
			EditPartViewer editPartViewer) {
		ShowRelatedElementsController showRelatedElementsController = getViewerControllerMap()
				.get(editPartViewer);
		if (showRelatedElementsController == null) {
			showRelatedElementsController = new ShowRelatedElementsController(
					editPartViewer);
			getViewerControllerMap().put(editPartViewer,
					showRelatedElementsController);
		}
		return showRelatedElementsController;
	}

	private void startListening() {
		Runnable addListenersRunner = new Runnable() {
			public void run() {
				EditPartViewer viewer = getEditPartViewer();
				if (viewer == null) {
					return;
				}

				viewer.addSelectionChangedListener(selectionChangeListener);

				Control control = viewer.getControl();
				if (control == null) {
					return;
				}
				control.addKeyListener(modifierKeyListener);
				control.addDisposeListener(viewerDisposeListener);
			}
		};

		Display.getDefault().syncExec(addListenersRunner);
	}

	private void stopListening() {
		if (getEditPartViewer() == null) {
			return;
		}

		Runnable removeListenersRunner = new Runnable() {
			public void run() {
				EditPartViewer viewer = getEditPartViewer();
				if (viewer == null) {
					return;
				}

				viewer.removeSelectionChangedListener(selectionChangeListener);

				Control control = viewer.getControl();
				if (control == null) {
					return;
				}
				control.removeKeyListener(modifierKeyListener);
				control.removeDisposeListener(viewerDisposeListener);
			}
		};

		Display.getDefault().syncExec(removeListenersRunner);
	}

	private EditPartViewer getEditPartViewer() {
		return editPartViewer;
	}

	private static Map<EditPartViewer, ShowRelatedElementsController> getViewerControllerMap() {
		return VIEWER_CONTROLLER_MAP;
	}

	private void setModeKeyPressed(boolean modeKeyPressed) {
		this.modeKeyPressed = modeKeyPressed;
	}

	private boolean isModeKeyPressed() {
		return modeKeyPressed;
	}

	/**
	 * @return A {@link Map} containing a mapping from {@link EObject}s to
	 *         {@link ViewDescriptor}s for all temporary diagram objects.
	 */
	public Map<EObject, ViewDescriptor> getObjectViewDescriptorMap() {
		return objectViewDescriptorMap;
	}

	private DiagramEditPart getDiagramEditPart() {
		return diagramEditPart;
	}

	/**
	 * @param active
	 *            <code>true</code> if the "show related elements" mode is
	 *            active, <code>false</code> otherwise
	 */
	public void setActive(boolean active) {
		if (this.active != active) {
			this.active = active;
			if (active) {
				startListening();
			} else {
				stopListening();
			}
		}
	}

	/**
	 * @return <code>true</code> if the "show related elements" mode is active,
	 *         <code>false</code> otherwise
	 */
	public boolean isActive() {
		return active;
	}

	private void setEditPartViewer(EditPartViewer editPartViewer) {
		this.editPartViewer = editPartViewer;
	}

	/**
	 * @param modeEnabled
	 *            Set to <code>true</code> to enable discovery mode,
	 *            <code>false</code> otherwise.
	 */
	public void setModeEnabled(boolean modeEnabled) {
		this.modeEnabled = modeEnabled;
	}

	/**
	 * @return <code>true</code> if discovery mode is enabled,
	 *         <code>false</code> otherwise.
	 */
	public boolean isModeEnabled() {
		return modeEnabled;
	}
}
