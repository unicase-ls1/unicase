/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.sysml.diagram.part;

import static org.eclipse.papyrus.core.Activator.log;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.emf.ecp.common.dnd.DragSourcePlaceHolder;
import org.eclipse.emf.ecp.common.model.ECPModelelementContext;
import org.eclipse.emf.ecp.common.model.ECPWorkspaceManager;
import org.eclipse.emf.ecp.common.model.ModelElementContextListener;
import org.eclipse.emf.ecp.common.model.NoWorkspaceException;
import org.eclipse.emf.ecp.editor.ModelElementChangeListener;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CommandStackListener;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.common.core.service.ProviderChangeEvent;
import org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.DiagramGraphicalViewerKeyHandler;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.DirectEditKeyHandler;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.PaletteToolTransferDragSourceListener;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServiceMultiException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.diagram.common.part.PapyrusPaletteContextMenuProvider;
import org.eclipse.papyrus.diagram.common.part.PapyrusPaletteViewer;
import org.eclipse.papyrus.diagram.common.service.PapyrusPaletteService;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.resources.ProjectExplorer;
import org.eclipse.ui.part.IShowInTargetList;
import org.eclipse.ui.part.ShowInContext;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.unicase.papyrus.PapyrusPackage;
import org.unicase.papyrus.SysMLModel;
import org.unicase.papyrus.diagram.services.UnicaseServicesRegistry;

/**
 * GMF-Diagram Editor that also implements {@link IMultiDiagramEditor} to support Papyrus diagrams.
 * 
 * @author mharut
 */
public abstract class SysMLDiagramEditor extends DiagramDocumentEditor implements IProviderChangeListener,
	IMultiDiagramEditor {

	/**
	 * The {@link ModelElementContext} {@link #modelElementContextListener} listens to.
	 */
	private ECPModelelementContext modelElementContext;

	/**
	 * The {@link ModelElementContextListener} to handle delete operations.
	 */
	private ModelElementContextListener modelElementContextListener;

	/**
	 * The {@link ModelElementChangeListener} to handle name changes.
	 */
	private ModelElementChangeListener modelElementChangeListener;

	private ServicesRegistry servicesRegistry;

	private IPropertySheetPage tabbedPropertySheetPage;

	/**
	 * @generated
	 */
	public SysMLDiagramEditor() {
		this(true);
	}

	public SysMLDiagramEditor(boolean hasFlyoutPalette) {
		super(hasFlyoutPalette);

		PapyrusPaletteService.getInstance().addProviderChangeListener(this);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setInput(IEditorInput input) {
		try {
			doSetInput(input, true);
			IWorkbench wb = PlatformUI.getWorkbench();
			IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
			win.getSelectionService().addSelectionListener(this);

		} catch (CoreException x) {
			// dengler: show in error log
			WorkspaceUtil.logException("Set diagram content failed", x);
		}
	}

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

		final Diagram diagram = getDiagram();

		new ECPCommand(diagram) {

			@Override
			protected void doRun() {
				diagram.setName(((SysMLModel) diagram.getElement()).getName());
			}

		}.run(true);

		registerFocusListener();
		registerModelElementListeners();
	}

	private abstract class DropTargetListener extends DiagramDropTargetListener {
		private List<EObject> mesDrop, mesAdd;
		private int x, y;

		public DropTargetListener(EditPartViewer viewer, Transfer xfer) {
			super(viewer, xfer);
		}

		@Override
		public boolean isEnabled(DropTargetEvent event) {
			setEnablementDeterminedByCommand(false);
			if (super.isEnabled(event)) {
				mesAdd = new LinkedList<EObject>();
				// FIXME
				// if (DNDHelper.canDrop(mesDrop, (UMLModel) getDiagram().getElement(), mesAdd)) {
				DropTarget target = (DropTarget) event.widget;
				org.eclipse.swt.graphics.Point location = target.getControl().toControl(event.x, event.y);
				x = location.x;
				y = location.y;
				return true;
				// }
			}
			return false;
		}

		@Override
		protected List<EObject> getObjectsBeingDropped() {
			TransferData data = getCurrentEvent().currentDataType;
			Object transferedObject = getJavaObject(data);
			mesDrop = new ArrayList<EObject>();
			if (transferedObject instanceof List<?>) {
				List<?> selection = (List<?>) transferedObject;
				for (Iterator<?> it = selection.iterator(); it.hasNext();) {
					Object nextSelectedObject = it.next();
					if (nextSelectedObject instanceof EObject) {
						mesDrop.add((EObject) nextSelectedObject);
					}
				}
			}
			return mesDrop;
		}

		// FIXME
		// @Override
		// protected void handleDrop() {
		// if (DNDHelper.dropMessageCheck(mesDrop, mesAdd)) {
		// final ECPModelelementContext context = DNDHelper.getECPModelelementContext();
		// final Package pckge = (Package) getDiagram().getElement();
		// if (context == null) {
		// return;
		// }
		// LinkedList<EObject> elements = new LinkedList<EObject>();
		// elements.addAll(getDiagram().getChildren());
		// mesAdd.addAll(AssociationClassHelper.getRelatedAssociationClassToDrop(mesAdd, elements, context
		// .getMetaModelElementContext()));
		// new UnicaseCommand() {
		//
		// @Override
		// protected void doRun() {
		// int counter = 0;
		// for (EObject pe : mesAdd) {
		// // add reference to the element
		// pckge.getPackagedElements().add((PackageableElement) pe);
		// // create the View for the element
		// CreateViewCommand command = new CreateViewCommand(new EObjectAdapter(pe),
		// getDiagramEditPart(), new Point(x + counter * 20, y + counter * 20),
		// getPreferencesHint());
		// try {
		// command.execute(getProgressMonitor(), null);
		// } catch (ExecutionException e) {
		// ModelUtil.logException("Could not create a view for the droped content.", e);
		// }
		// if (!context.getMetaModelElementContext().isAssociationClassElement(pe)) {
		// counter++;
		// }
		// }
		// }
		// }.run();
		// }
		// mesDrop = null;
		// mesAdd = null;
		// }

		protected abstract Object getJavaObject(TransferData data);
	}

	/**
	 * @generated
	 */
	protected PaletteRoot createPaletteRoot(PaletteRoot existingPaletteRoot) {
		PaletteRoot paletteRoot;
		if (existingPaletteRoot == null) {
			paletteRoot = PapyrusPaletteService.getInstance().createPalette(this, getDefaultPaletteContent());
		} else {
			PapyrusPaletteService.getInstance().updatePalette(existingPaletteRoot, this, getDefaultPaletteContent());
			paletteRoot = existingPaletteRoot;
		}
		PapyrusPaletteService.getInstance().getProviders();
		applyCustomizationsToPalette(paletteRoot);
		return paletteRoot;
	}

	/**
	 * @generated
	 */
	public Object getAdapter(java.lang.Class type) {
		if (type == IShowInTargetList.class) {
			return new IShowInTargetList() {
				public String[] getShowInTargetIds() {
					return new String[] { ProjectExplorer.VIEW_ID };
				}
			};
		}

		if (type == ServicesRegistry.class) {
			return getServicesRegistry();
		}

		return super.getAdapter(type);
	}

	/**
	 * @generated
	 */
	public TransactionalEditingDomain getEditingDomain() {
		IDocument document = getEditorInput() != null ? getDocumentProvider().getDocument(getEditorInput()) : null;
		if (document instanceof IDiagramDocument) {
			return ((IDiagramDocument) document).getEditingDomain();
		}
		return super.getEditingDomain();
	}

	/**
	 * @generated
	 */
	public void gotoMarker(IMarker marker) {
		MarkerNavigationService.getInstance().gotoMarker(this, marker);
	}

	/**
	 * @generated
	 */
	public boolean isSaveAsAllowed() {
		return false;
	}

	/**
	 * @generated
	 */
	public void doSaveAs() {
	}

	/**
	 * @generated
	 */
	public ShowInContext getShowInContext() {
		return new ShowInContext(getEditorInput(), getNavigatorSelection());
	}

	/**
	 * @generated
	 */
	private ISelection getNavigatorSelection() {
		IDiagramDocument document = getDiagramDocument();
		if (document == null) {
			return StructuredSelection.EMPTY;
		}
		Diagram diagram = document.getDiagram();
		if (diagram != null) {
			return new StructuredSelection(diagram);
		}
		return StructuredSelection.EMPTY;
	}

	/**
	 * @generated
	 */
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		IDiagramGraphicalViewer viewer = getDiagramGraphicalViewer();

		KeyHandler viewerKeyHandler = new DiagramGraphicalViewerKeyHandler(viewer).setParent(getKeyHandler());
		viewer.setKeyHandler(new OnEnterDirectEditKeyHandler(viewer).setParent(viewerKeyHandler));
	}

	/**
	 * @generated
	 */
	protected void configureDiagramEditDomain() {
		super.configureDiagramEditDomain();
		getDiagramEditDomain().getDiagramCommandStack().addCommandStackListener(new CommandStackListener() {

			public void commandStackChanged(EventObject event) {
				firePropertyChange(IEditorPart.PROP_DIRTY);
			}
		});
	}

	/**
	 * @generated
	 */
	public void doSave(IProgressMonitor progressMonitor) {
	}

	/**
	 * @generated
	 */
	public boolean isDirty() {
		return false;
	}

	/**
	 * @generated
	 */
	public void providerChanged(ProviderChangeEvent event) {
		// update the palette if the palette service has changed
		if (PapyrusPaletteService.getInstance().equals(event.getSource())) {
			PapyrusPaletteService.getInstance().updatePalette(getPaletteViewer().getPaletteRoot(), this,
				getDefaultPaletteContent());
		}
	}

	/**
	 * @generated
	 */
	public void dispose() {
		super.dispose();

		PapyrusPaletteService.getInstance().removeProviderChangeListener(this);

		if (modelElementChangeListener != null) {
			modelElementChangeListener.remove();
		}

		if (modelElementContext != null) {
			modelElementContext.removeModelElementContextListener(modelElementContextListener);
		}

		deregisterFocusListener();

		if (servicesRegistry != null) {
			try {
				servicesRegistry.disposeRegistry();
			} catch (ServiceMultiException e) {
				log.error(e);
			}
		}
	}

	private void deregisterFocusListener() {
		IDiagramGraphicalViewer diagramGraphicalViewer = getDiagramGraphicalViewer();
		if (diagramGraphicalViewer == null) {
			return;

		}
	}

	private void registerFocusListener() {
		IDiagramGraphicalViewer diagramGraphicalViewer = getDiagramGraphicalViewer();
		if (diagramGraphicalViewer == null) {
			return;

		}
	}

	/**
	 * @generated NOT
	 */
	private void registerModelElementListeners() {

		Diagram diagram = getDiagram();

		// register listener for changes on the name attribute
		modelElementChangeListener = new ModelElementChangeListener(diagram) {

			@Override
			public void onChange(Notification msg) {
				if (msg.getEventType() == Notification.SET
					&& (msg.getFeatureID(SysMLModel.class) == PapyrusPackage.UML_MODEL__NAME || msg
						.getFeatureID(Diagram.class) == NotationPackage.DIAGRAM__NAME)) {
					setPartName(msg.getNewStringValue());
				}
			}
		};

		// register modelElementContext listener for behavior upon deletion
		modelElementContext = null;
		if (diagram == null) {
			try {
				modelElementContext = ECPWorkspaceManager.getInstance().getWorkSpace().getActiveProject();
			} catch (NoWorkspaceException e) {
				WorkspaceUtil.logException("Failed to retrieve context!", e);
			}
		} else {
			modelElementContext = ECPWorkspaceManager.getECPProject(diagram.getElement());
		}

		if (modelElementContext == null) {
			return;
		}

		// initialize a listener that will close this editor if the MEDiagram,
		// its container or its context gets deleted
		modelElementContextListener = new ModelElementContextListener() {

			@Override
			public void onContextDeleted() {
				close(false);
			}

			@Override
			public void onModelElementDeleted(EObject element) {
				Diagram diagram = SysMLDiagramEditor.this.getDiagram();
				if (diagram == null) {
					return;
				}
				EObject umlDiagram = diagram.getElement();
				if (element == umlDiagram || !modelElementContext.contains(umlDiagram)) {
					close(false);
				}
			}

		};

		modelElementContext.addModelElementContextListener(modelElementContextListener);
	}

	/**
	 * @generated
	 */
	protected PaletteViewer getPaletteViewer() {
		return getEditDomain().getPaletteViewer();
	}

	/**
	 * @generated
	 */
	protected PaletteViewer constructPaletteViewer() {
		return new PapyrusPaletteViewer();
	}

	/**
	 * @generated
	 */
	@Override
	public GraphicalViewer getGraphicalViewer() {
		return super.getGraphicalViewer();
	}

	/**
	 * @generated
	 */
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		super.selectionChanged(part, selection);
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		win.getShell().setText("Java - Eclipse Platform");
	}

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

	public ServicesRegistry getServicesRegistry() {
		if (servicesRegistry == null) {
			createServicesRegistry();
		}
		return servicesRegistry;
	}

	private void createServicesRegistry() {
		try {
			servicesRegistry = new UnicaseServicesRegistry("org.unicase.papyrus", getDiagram().getElement());
			servicesRegistry.startRegistry();
		} catch (ServiceException e) {
			// Show log and error
			log.error(e.getMessage(), e);
		}
	}

	public void setEditorInput(IEditorInput newInput) {
		setInputWithNotify(newInput);
		setPartName(newInput.getName());
	}

	public IEditorPart getActiveEditor() {
		return this;
	}

	public IPropertySheetPage getPropertySheetPage() {
		if (this.tabbedPropertySheetPage == null) {
			this.tabbedPropertySheetPage = new TabbedPropertySheetPage(this);
		}
		return tabbedPropertySheetPage;
	}

	public DiagramEditDomain getDiagramEditDomain() {
		return (DiagramEditDomain) super.getDiagramEditDomain();
	}

	protected PaletteViewerProvider createPaletteViewerProvider() {
		getEditDomain().setPaletteRoot(createPaletteRoot(null));
		return new PaletteViewerProvider(getEditDomain()) {

			/**
			 * Override to provide the additional behavior for the tools. Will intialize with a PaletteEditPartFactory
			 * that has a TrackDragger that understand how to handle the mouseDoubleClick event for shape creation
			 * tools. Also will initialize the palette with a defaultTool that is the SelectToolEx that undestands how
			 * to handle the enter key which will result in the creation of the shape also.
			 */
			protected void configurePaletteViewer(PaletteViewer viewer) {
				super.configurePaletteViewer(viewer);

				// customize menu...
				viewer.setContextMenu(new PapyrusPaletteContextMenuProvider(viewer));

				// Add a transfer drag target listener that is supported on
				// palette template entries whose template is a creation tool.
				// This will enable drag and drop of the palette shape creation
				// tools.
				viewer.addDragSourceListener(new PaletteToolTransferDragSourceListener(viewer));
				viewer.setCustomizer(createPaletteCustomizer());
			}

			public PaletteViewer createPaletteViewer(Composite parent) {
				PaletteViewer pViewer = constructPaletteViewer();
				pViewer.createControl(parent);
				configurePaletteViewer(pViewer);
				hookPaletteViewer(pViewer);
				return pViewer;
			}

		};
	}

}
