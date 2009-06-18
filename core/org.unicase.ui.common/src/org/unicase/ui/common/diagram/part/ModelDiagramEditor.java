/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.diagram.part;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.diagram.impl.DiagramStoreException;
import org.unicase.ui.common.diagram.DeleteFromDiagramAction;
import org.unicase.ui.common.dnd.DragSourcePlaceHolder;

/**
 * @author denglerm This class is a superclass for the generated ModelDiagramEditor in each diagram.
 */
public class ModelDiagramEditor extends DiagramDocumentEditor {

	/**
	 * The {@link FocusListener} for layout save commands.
	 */
	private FocusListener focusListener; 

	/**
	 * The {@link LayoutListener} for layout save commands.
	 */
	private LayoutListener layoutChangeListener;
	
	/**
	 * The constructor.
	 */
	public ModelDiagramEditor() {
		this(true);
	}

	/**
	 * Constructs a diagram editor with optional flyout palette.
	 * 
	 * @param hasFlyoutPalette creates a palette if true, else no palette
	 */
	public ModelDiagramEditor(boolean hasFlyoutPalette) {
		super(hasFlyoutPalette);

		focusListener = new FocusListener(){
			public void focusGained(FocusEvent event) {
				try {
					doSave(new NullProgressMonitor());	
				} catch (IllegalStateException e) {
					//do nothing
					//We catch this exception in case we have been in an read only transaction context 
					//and tried to save the layout which is performed with a read/write transaction
				}
			}
			
			public void focusLost(FocusEvent event) {
				try {
					doSave(new NullProgressMonitor());	
				} catch (IllegalStateException e) {
					//do nothing
					//@see focusGained
				}
			}
		};
		
		layoutChangeListener = new LayoutListener.Stub(){
			@Override
			public void postLayout(IFigure container) {
				doSave(new NullProgressMonitor());
			}
		};
	}
//dengler: document
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		getEditingDomain().getCommandStack().execute(new RecordingCommand(getEditingDomain()) {

			@Override
			protected void doExecute() {
				try {
					((MEDiagram) ModelDiagramEditor.this.getDiagram().eContainer()).saveDiagramLayout();

				} catch (DiagramStoreException e) {
					// dengler handle exception
					e.printStackTrace();
				}
			}

		});
	}
//dengler: document
	/**
	 * . {@inheritDoc}
	 */
	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		getDiagramGraphicalViewer().addDropTargetListener(
			new DropTargetListener(getDiagramGraphicalViewer(), LocalTransfer.getInstance()) {

				@Override
				protected Object getJavaObject(TransferData data) {
					return DragSourcePlaceHolder.getDragSource();
				}

			});
		getGraphicalViewer().getKeyHandler().put(KeyStroke.getPressed(SWT.DEL, 127, 0), new DeleteFromDiagramAction());	
		
		registerLayoutChangeListener();
		registerFocusListener();
	}

	/**
	 * @author denglerm This class implements the abstract DiagramDropTargetListener
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener
	 */
	private abstract class DropTargetListener extends DiagramDropTargetListener {

		public DropTargetListener(EditPartViewer viewer, Transfer xfer) {
			super(viewer, xfer);
		}

		@SuppressWarnings("unchecked")
		@Override
		protected List<EObject> getObjectsBeingDropped() {
			TransferData data = getCurrentEvent().currentDataType;
			Collection<URI> uris = new HashSet<URI>();

			Object transferedObject = getJavaObject(data);

			if (transferedObject instanceof List) {
				List<ModelElement> selection = (List<ModelElement>) transferedObject;
				for (Iterator it = selection.iterator(); it.hasNext();) {
					Object nextSelectedObject = it.next();
					if (nextSelectedObject instanceof IAdaptable) {
						IAdaptable adaptable = (IAdaptable) nextSelectedObject;
						nextSelectedObject = adaptable.getAdapter(EObject.class);
					}

					if (nextSelectedObject instanceof EObject) {
						EObject modelElement = (EObject) nextSelectedObject;
						Resource modelElementResource = modelElement.eResource();
						uris.add(modelElementResource.getURI().appendFragment(
							modelElementResource.getURIFragment(modelElement)));
					}
				}
			}

			List<EObject> result = new ArrayList<EObject>();
			for (Iterator<URI> it = uris.iterator(); it.hasNext();) {
				URI nextURI = it.next();
				EObject modelObject = getEditingDomain().getResourceSet().getEObject(nextURI, true);
				result.add(modelObject);
			}
			return result;
		}

		protected abstract Object getJavaObject(TransferData data);

	}

	/**
	 * @see org.eclipse.ui.part.EditorPart#setInput(IEditorInput)
	 * @param input the editor input
	 */
	@Override
	public void setInput(IEditorInput input) {
		try {
			doSetInput(input, true);
			IWorkbench wb = PlatformUI.getWorkbench();
			IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
			win.getSelectionService().addSelectionListener(this);

		} catch (CoreException x) {
			//dengler show in error log
			x.printStackTrace(System.err);
			String title = x.getMessage();
			String msg = x.getMessage();
			Shell shell = getSite().getShell();
			ErrorDialog.openError(shell, title, msg, x.getStatus());
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
		deregisterLayoutChangeListener();
	}

	private void deregisterLayoutChangeListener() {
		IFigure primaryLayer = getDiagramEditPart().getLayer(LayerConstants.PRIMARY_LAYER);

		primaryLayer.removeLayoutListener(layoutChangeListener);		
	}

	private void deregisterFocusListener(){
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
	
	
	private void registerFocusListener(){
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

	private void registerLayoutChangeListener(){
		IFigure primaryLayer = getDiagramEditPart().getLayer(LayerConstants.PRIMARY_LAYER);

		LayoutListener layoutChangeListener = new LayoutListener.Stub(){
			@Override
			public void postLayout(IFigure container) {
				try {
					doSave(new NullProgressMonitor());	
				} catch (IllegalStateException e) {
					//do nothing
					//We catch this exception in case we have been in an read only transaction context 
					//and tried to save the layout which is performed with a read/write transaction
				}
			}
		};

		primaryLayer.addLayoutListener(layoutChangeListener);	
	}
	
	/**
	 *	We implement our own save method, so return always false. {@inheritDoc}
	 */
	@Override
	public boolean isDirty() {
		return false;
	}
}