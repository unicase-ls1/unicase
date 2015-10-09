/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.diagram.part;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.emfstore.internal.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.internal.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.DiagramGraphicalViewerKeyHandler;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.DirectEditKeyHandler;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.keys.model.ModelElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.unicasecommon.common.diagram.DeleteFromDiagramAction;
import org.unicase.ui.unicasecommon.diagram.commands.CreateViewCommand;

/**
 * @author denglerm This class is a superclass for the generated
 *         ModelDiagramEditor in each diagram.
 */
@SuppressWarnings("restriction")
public class UnicaseModelDiagramEditor extends DiagramDocumentEditor {

	/**
	 * The {@link FocusListener} for layout save commands.
	 */
	private FocusListener focusListener;

	/**
	 * The constructor.
	 */
	public UnicaseModelDiagramEditor() {
		this(true);
	}

	/**
	 * Constructs a diagram editor with optional flyout palette.
	 * 
	 * @param hasFlyoutPalette
	 *            creates a palette if true, else no palette
	 */
	public UnicaseModelDiagramEditor(boolean hasFlyoutPalette) {
		super(hasFlyoutPalette);

		focusListener = new FocusListener() {
			public void focusGained(FocusEvent event) {
				try {
					doSave(new NullProgressMonitor());
				} catch (IllegalStateException e) {
					// do nothing
					// We catch this exception in case we have been in an read
					// only transaction context
					// and tried to save the layout which is performed with a
					// read/write transaction
				}
			}

			public void focusLost(FocusEvent event) {
				try {
					doSave(new NullProgressMonitor());
				} catch (IllegalStateException e) {
					// do nothing
					// @see focusGained
				}
			}
		};

	}

	// dengler: document
	/**
	 * This method calls the MEDiagram's saveDiagramLayout method to save
	 * diagram elements and layout information. {@inheritDoc}
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		// new EMFStoreCommand() {
		// @Override
		// protected void doRun() {
		// try {
		// ((MEDiagram)
		// ModelDiagramEditor.this.getDiagram().eContainer()).saveDiagramLayout();
		// } catch (DiagramStoreException e) {
		// // dengler: handle exception
		// WorkspaceUtil.logException("Saving diagram failed", e);
		// }
		// }
		// }.run();
	}

	// dengler: document
	/**
	 * This method registers a Drag & drop listener and listeners for layout and
	 * focus change. Additionally the standard action for pressing the DEL key
	 * is changed to DeleteFromDiagram instead of GMF's DeleteFromModel.
	 */
	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		// getDiagramGraphicalViewer().addDropTargetListener(
		// new DropTargetListener(getDiagramGraphicalViewer(),
		// LocalTransfer.getInstance()) {
		//
		// @Override
		// protected Object getJavaObject(TransferData data) {
		// return DragSourcePlaceHolder.getDragSource();
		// }
		//
		// });
		getGraphicalViewer().getKeyHandler().put(
				KeyStroke.getPressed(SWT.DEL, 127, 0),
				new DeleteFromDiagramAction());

		registerFocusListener();
	}

	/**
	 * @author denglerm This class implements the abstract
	 *         DiagramDropTargetListener The superclass uses a
	 *         DropObjectsRequest to obtain a dnd command from the Drag&Drop
	 *         policy in
	 * @link org.unicase.ui.common.diagram.edit.parts.MEDiagramEditPart. To set
	 *       the dropped objects field within the request the superclass calls
	 *       the getObjectsBeingDropped() method of this class.
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener
	 */
	private abstract class DropTargetListener extends DiagramDropTargetListener {
		private List<ModelElement> mesDrop, mesAdd;
		private int x, y;

		public DropTargetListener(EditPartViewer viewer, Transfer xfer) {
			super(viewer, xfer);
		}

		@Override
		public boolean isEnabled(DropTargetEvent event) {
			setEnablementDeterminedByCommand(false);
			if (super.isEnabled(event)) {
				if (!mesDrop.isEmpty()) {
					MEDiagram diagram = (MEDiagram) getDiagram().getElement();
					mesAdd = new ArrayList<ModelElement>();
					for (ModelElement me : mesDrop) {
						// do not add elements that are already added and check
						// if they are allowed for the diagram
						if (!diagram.getElements().contains(me)
								&& isAllowedType(diagram, me)) {
							mesAdd.add(me);
						}
					}
					if (!mesAdd.isEmpty()) {
						DropTarget target = (DropTarget) event.widget;
						org.eclipse.swt.graphics.Point location = target
								.getControl().toControl(event.x, event.y);
						x = location.x;
						y = location.y;
						return true;
					}
				}
			}
			return false;
		}

		@SuppressWarnings("unchecked")
		private boolean isAllowedType(MEDiagram diagram, ModelElement dropee) {
			// get all registered contexts
			Set<IClientContext> clientContexts = ClientContextManager
					.getInstance().getClientContexts();
			for (IClientContext clientContext : clientContexts) {
				IElementType[] containedTypes = ElementTypeRegistry
						.getInstance().getElementTypes(clientContext);
				IElementType diagramType = ElementTypeRegistry.getInstance()
						.getElementType(diagram, clientContext);
				IElementType dropeeType = ElementTypeRegistry.getInstance()
						.getElementType((EClass) dropee, clientContext);
				boolean containedDropee = false;
				boolean containedDiagram = false;
				// checks all types in a given context if they contain the
				// diagram and the dropped element
				for (IElementType containedType : containedTypes) {
					if (containedType.equals(diagramType)) {
						containedDiagram = true;
					}
					if (containedType.equals(dropeeType)) {
						containedDropee = true;
					}
				}
				if (containedDiagram && containedDropee) {
					return true;
				}
			}
			return false;
		}

		@Override
		protected List<ModelElement> getObjectsBeingDropped() {
			TransferData data = getCurrentEvent().currentDataType;
			Object transferedObject = getJavaObject(data);
			mesDrop = new ArrayList<ModelElement>();
			if (transferedObject instanceof List) {
				List<?> selection = (List<?>) transferedObject;
				for (Iterator<?> it = selection.iterator(); it.hasNext();) {
					Object nextSelectedObject = it.next();
					if (nextSelectedObject instanceof ModelElement) {
						mesDrop.add((ModelElement) nextSelectedObject);
					}
				}
			}
			return mesDrop;
		}

		@Override
		protected void handleDrop() {
			int messageResult;
			if (mesAdd.size() != mesDrop.size()) {
				// if not all elements could be added
				MessageDialog dialog = new MessageDialog(null, "Confirmation",
						null, "Only " + mesAdd.size() + " of " + mesDrop.size()
								+ " item(s) could be added. Add item(s)?",
						MessageDialog.QUESTION, new String[] { "Yes", "No" }, 0);
				messageResult = dialog.open();
			} else {
				messageResult = MessageDialog.OK;
			}
			if (messageResult == MessageDialog.OK) {
				new EMFStoreCommand() {

					@Override
					protected void doRun() {
						int counter = 0;
						for (ModelElement me : mesAdd) {
							// add reference to the element
							((MEDiagram) getDiagram().getElement())
									.getElements()
									.add((UnicaseModelElement) me);
							// create the View for the element
							CreateViewCommand command = new CreateViewCommand(
									new EObjectAdapter((EObject) me),
									getDiagramEditPart(), new Point(x + counter
											* 20, y + counter * 20),
									getPreferencesHint());
							try {
								command.execute(getProgressMonitor(), null);
							} catch (ExecutionException e) {
								ModelUtil
										.logException(
												"Could not create a view for the droped content.",
												e);
							}
							counter++;
						}
					}
				}.run();
			}
			mesDrop = null;
			mesAdd = null;
		}

		protected abstract Object getJavaObject(TransferData data);
	}

	/**
	 * @see org.eclipse.ui.part.EditorPart#setInput(IEditorInput)
	 * @param input
	 *            the editor input
	 */
	@Override
	public void setInput(IEditorInput input) {
		try {
			doSetInput(input, true);
			IWorkbench wb = PlatformUI.getWorkbench();
			IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
			win.getSelectionService().addSelectionListener(this);
			this.setTitleImage(new AdapterFactoryLabelProvider(
					new ComposedAdapterFactory(
							ComposedAdapterFactory.Descriptor.Registry.INSTANCE))
					.getImage(this.getDiagram().getElement()));

		} catch (CoreException x) {
			// dengler: show in error log
			WorkspaceUtil.logException("Set diagram content failed", x);
		}
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		super.selectionChanged(part, selection);
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		win.getShell().setText("Java - Eclipse Platform");
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();

		deregisterFocusListener();
	}

	private void deregisterFocusListener() {
		IDiagramGraphicalViewer diagramGraphicalViewer = getDiagramGraphicalViewer();
		if (diagramGraphicalViewer == null) {
			return;

		}
		Control control = diagramGraphicalViewer.getControl();
		if (control == null) {
			return;
		}
		control.removeFocusListener(focusListener);
	}

	private void registerFocusListener() {
		IDiagramGraphicalViewer diagramGraphicalViewer = getDiagramGraphicalViewer();
		if (diagramGraphicalViewer == null) {
			return;

		}
		Control control = diagramGraphicalViewer.getControl();
		if (control == null) {
			return;
		}
		control.addFocusListener(focusListener);
	}

	/**
	 * @author schroech
	 */
	private class OnEnterDirectEditKeyHandler extends DirectEditKeyHandler {

		public OnEnterDirectEditKeyHandler(GraphicalViewer viewer) {
			super(viewer);
		}

		@Override
		public boolean keyPressed(KeyEvent event) {
			if (isEnterKey(event)) {
				// Create a Direct Edit Request and cache the character typed
				Request request = new Request(RequestConstants.REQ_DIRECT_EDIT);
				getFocusPart().performRequest(request);
				return true;
			}
			return super.keyPressed(event);
		}

		private boolean isEnterKey(KeyEvent event) {
			if (event.keyCode == 13) {
				return true;
			}
			return false;
		}

	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor#configureGraphicalViewer()
	 */
	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		IDiagramGraphicalViewer viewer = getDiagramGraphicalViewer();

		KeyHandler viewerKeyHandler = new DiagramGraphicalViewerKeyHandler(
				viewer).setParent(getKeyHandler());
		viewer.setKeyHandler(new OnEnterDirectEditKeyHandler(viewer)
				.setParent(viewerKeyHandler));
	}

	/**
	 * We implement our own save method, so return always false. {@inheritDoc}
	 */
	@Override
	public boolean isDirty() {
		return false;
	}
}