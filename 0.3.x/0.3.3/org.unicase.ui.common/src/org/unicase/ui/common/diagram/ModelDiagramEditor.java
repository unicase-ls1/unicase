/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.ui.common.diagram;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.diagram.impl.DiagramStoreException;
import org.unicase.ui.common.dnd.DragSourcePlaceHolder;

/**
 * @author denglerm This class is a superclass for the specific ModelDiagramEditor in each diagram.
 */
public class ModelDiagramEditor extends DiagramDocumentEditor {

	/**
	 * . The constructor
	 */
	public ModelDiagramEditor() {
		super(true);
	}

	/**
	 * Constructs a diagram editor with optional flyout palette.
	 * 
	 * @param hasFlyoutPalette creates a palette if true, else no palette
	 */
	public ModelDiagramEditor(boolean hasFlyoutPalette) {
		super(hasFlyoutPalette);
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		getEditingDomain().getCommandStack().execute(new RecordingCommand(getEditingDomain()) {

			@Override
			protected void doExecute() {
				try {
					((MEDiagram) ModelDiagramEditor.this.getDiagram().eContainer()).saveDiagramLayout();

				} catch (DiagramStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// WorkspaceManager.getProjectSpace(
				// (MEDiagram) ModelDiagramEditor.this
				// .getDiagram().eContainer()).save();
			}

		});
	}

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
	 * @generated NOT
	 * @see org.eclipse.ui.part.EditorPart#setInput(IEditorInput)
	 * @param input the editor input
	 */
	@Override
	public void setInput(IEditorInput input) {
		try {
			doSetInput(input, true);
		} catch (CoreException x) {
			x.printStackTrace(System.err);
			String title = x.getMessage();
			String msg = x.getMessage();
			Shell shell = getSite().getShell();
			ErrorDialog.openError(shell, title, msg, x.getStatus());
		}
	}

	/**
	 *Turned to always true as a fix. {@inheritDoc}
	 */
	// MD: Fix to better method
	@Override
	public boolean isDirty() {
		return true;
	}

}