package scrm.diagram.part;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.Request;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.DiagramGraphicalViewerKeyHandler;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.DirectEditKeyHandler;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.navigator.resources.ProjectExplorer;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.IShowInTargetList;
import org.eclipse.ui.part.ShowInContext;
import org.unicase.ecp.model.ECPMetaModelElementContext;
import org.unicase.ecp.model.ECPModelelementContext;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.ModelElementContextListener;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.ecp.model.workSpaceModel.util.AssociationClassHelper;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.ui.common.dnd.DragSourcePlaceHolder;
import org.unicase.ui.meeditor.ModelElementChangeListener;
import org.unicase.workspace.util.WorkspaceUtil;

import scrm.SCRMDiagram;
import scrm.SCRMModelElement;
import scrm.ScrmPackage;
import scrm.diagram.commands.CreateViewCommand;
import scrm.diagram.common.DeleteFromDiagramAction;
import scrm.diagram.navigator.ScrmNavigatorItem;
import scrm.diagram.providers.ScrmModelingAssistantProvider;
import scrm.impl.DiagramStoreException;

/**
 * @generated
 */
public class ScrmDiagramEditor extends DiagramDocumentEditor implements
		IGotoMarker {

	/**
	 * The {@link FocusListener} for layout save commands.
	 */
	private FocusListener focusListener;

	/**
	 * The {@link ModelElementContext} {@link #modelElementContextListener}
	 * listens to.
	 */
	private ECPModelelementContext modelElementContext;

	/**
	 * The {@link ModelElementContextListener} to handle delete operations.
	 */
	private ModelElementContextListener modelElementContextListener;

	/**
	 * The {@link ModelElementChangeListener} to handle attribute changes.
	 */
	private ModelElementChangeListener modelElementChangeListener;

	/**
	 * @generated
	 */
	public static final String ID = "scrm.diagram.part.ScrmDiagramEditorID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String CONTEXT_ID = "scrm.diagram.ui.diagramContext"; //$NON-NLS-1$

	/**
	 * @generated NOT
	 */
	public ScrmDiagramEditor() {
		this(true);
	}

	/**
	 * @generated NOT
	 */
	public ScrmDiagramEditor(boolean hasFlyoutPalette) {
		super(hasFlyoutPalette);

		focusListener = new FocusListener() {
			public void focusGained(FocusEvent event) {
				try {
					// add association if they are not on the diagram
					syncDiagramView((SCRMDiagram) ScrmDiagramEditor.this
							.getDiagram().getElement());
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

	/**
	 * @generated NOT
	 */
	private void syncDiagramView(final SCRMDiagram diagram) {

		ECPModelelementContext context = getModelElementContext(diagram);

		if (context == null) {
			return;
		}

		final ECPMetaModelElementContext metaContext = context
				.getMetaModelElementContext();

		final LinkedList<EObject> elements = new LinkedList<EObject>();
		elements.addAll(diagram.getElements());
		new ECPCommand(diagram) {
			@Override
			protected void doRun() {
				for (EObject association : AssociationClassHelper
						.getRelatedAssociationClassToDrop(elements, elements,
								metaContext)) {
					// add reference to the element
					diagram.getElements().add((SCRMModelElement) association);
					// create the View for the element
					CreateViewCommand command = new CreateViewCommand(
							new EObjectAdapter(association),
							getDiagramEditPart(), null, getPreferencesHint());
					try {
						command.execute(getProgressMonitor(), null);
					} catch (ExecutionException e) {
						WorkspaceUtil
								.logException(
										"Could not create a view for the dropped content.",
										e);
					}
				}
			}
		}.run(true);
		// refresh all views to reorientate associations
		List<CanonicalEditPolicy> editPolicies = CanonicalEditPolicy
				.getRegisteredEditPolicies(diagram);
		for (Iterator<CanonicalEditPolicy> it = editPolicies.iterator(); it
				.hasNext();) {
			it.next().refresh();
		}
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		final SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagram().eContainer();
		new ECPCommand(scrmDiagram) {
			@Override
			protected void doRun() {
				try {
					scrmDiagram.saveDiagramLayout();
				} catch (DiagramStoreException e) {
					// dengler: handle exception
					WorkspaceUtil.logException("Saving diagram failed", e);
				}
			}
		}.run(true);
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		getDiagramGraphicalViewer().addDropTargetListener(
				new DropTargetListener(getDiagramGraphicalViewer(),
						LocalTransfer.getInstance()) {

					@Override
					protected Object getJavaObject(TransferData data) {
						return DragSourcePlaceHolder.getDragSource();
					}

				});
		getGraphicalViewer().getKeyHandler().put(
				KeyStroke.getPressed(SWT.DEL, 127, 0),
				new DeleteFromDiagramAction());

		registerFocusListener();
		registerModelElementListeners();
	}

	/**
	 * @generated NOT
	 */
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
				if (canDrop(mesDrop, (SCRMDiagram) getDiagram().getElement(),
						mesAdd)) {
					DropTarget target = (DropTarget) event.widget;
					org.eclipse.swt.graphics.Point location = target
							.getControl().toControl(event.x, event.y);
					x = location.x;
					y = location.y;
					return true;
				}
			}
			return false;
		}

		private boolean canDrop(List<EObject> elements, SCRMDiagram diagram,
				List<EObject> allowedElements) {
			if (!elements.isEmpty()) {
				for (EObject me : elements) {
					// do not add elements that are already added and check if
					// they are allowed for the diagram
					if (!diagram.getElements().contains(me)
							&& isAllowedType(diagram, me)
							&& !isContainmentCycle(diagram, me)) {
						allowedElements.add(me);
					}
				}
				if (!allowedElements.isEmpty()) {
					return true;
				}
			}
			return false;
		}

		private boolean isAllowedType(SCRMDiagram diagram, EObject dropee) {
			// get all registered contexts
			Set<IClientContext> clientContexts = ClientContextManager
					.getInstance().getClientContexts();
			// get all allowed types
			List<IElementType> allowedTypes = ScrmModelingAssistantProvider
					.getAllowedTypes(diagram.getDiagramType());
			for (IClientContext clientContext : clientContexts) {
				IElementType[] containedTypes = ElementTypeRegistry
						.getInstance().getElementTypes(clientContext);
				IElementType diagramType = ElementTypeRegistry.getInstance()
						.getElementType(diagram, clientContext);
				IElementType dropeeType = ElementTypeRegistry.getInstance()
						.getElementType(dropee, clientContext);
				boolean containedDropee = false;
				boolean containedDiagram = false;
				// checks all types in a given context if they contain the
				// diagram and the dropped element
				for (IElementType containedType : containedTypes) {
					if (containedType.equals(diagramType)) {
						containedDiagram = true;
					}
					if (containedType.equals(dropeeType)) {
						if (allowedTypes.contains(dropeeType)) {
							containedDropee = true;
						}
					}
				}
				if (containedDiagram && containedDropee) {
					return true;
				}
			}
			return false;
		}

		private boolean isContainmentCycle(SCRMDiagram diagram, EObject me) {
			EObject representedSpace = diagram.getRepresentedSpace();
			if (representedSpace == null) {
				return false;
			}
			EObject container = representedSpace;
			while (container != null) {
				if (me == container) {
					return true;
				}
				container = container.eContainer();
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

		@Override
		protected void handleDrop() {
			if (dropMessageCheck(mesDrop, mesAdd)) {
				final SCRMDiagram diagram = (SCRMDiagram) getDiagram()
						.getElement();
				ECPModelelementContext context = getModelElementContext(diagram);
				if (context == null) {
					return;
				}
				final ECPMetaModelElementContext metaContext = context
						.getMetaModelElementContext();
				if (metaContext == null) {
					return;
				}

				LinkedList<EObject> elements = new LinkedList<EObject>();
				elements.addAll(diagram.getElements());
				mesAdd.addAll(AssociationClassHelper
						.getRelatedAssociationClassToDrop(mesAdd, elements,
								metaContext));
				new ECPCommand(diagram) {

					@Override
					protected void doRun() {
						int counter = 0;
						for (EObject eObject : mesAdd) {
							if (!(eObject instanceof SCRMModelElement)) {
								continue;
							}
							SCRMModelElement scrmME = (SCRMModelElement) eObject;
							// add reference to the element
							diagram.getElements().add(scrmME);
							if (diagram.getRepresentedSpace() != null
									&& !diagram.getRepresentedSpace()
											.getContainedModelElements()
											.contains(scrmME)) {
								diagram.getRepresentedSpace()
										.getContainedModelElements()
										.add(scrmME);
							}
							// create the View for the element
							CreateViewCommand command = new CreateViewCommand(
									new EObjectAdapter(scrmME),
									getDiagramEditPart(), new Point(x + counter
											* 20, y + counter * 20),
									getPreferencesHint());
							try {
								command.execute(getProgressMonitor(), null);
							} catch (ExecutionException e) {
								WorkspaceUtil.logException("Drop failed!", e);
							}
							if (!(metaContext)
									.isAssociationClassElement(scrmME)) {
								counter++;
							}
						}
					}
				}.run(true);
			}
			mesDrop = null;
			mesAdd = null;
		}

		private boolean dropMessageCheck(List<EObject> elements,
				List<EObject> allowedElements) {
			if (allowedElements.size() != elements.size()) {
				// if not all elements could be added
				MessageDialog dialog = new MessageDialog(null, "Confirmation",
						null, "Only " + allowedElements.size() + " of "
								+ elements.size()
								+ " item(s) could be added. Add item(s)?",
						MessageDialog.QUESTION, new String[] { "Yes", "No" }, 0);
				return dialog.open() == MessageDialog.OK;
			} else {
				return true;
			}
		}

		protected abstract Object getJavaObject(TransferData data);
	}

	/**
	 * @generated NOT
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

		} catch (CoreException e) {
			// dengler: show in error log
			WorkspaceUtil.logException("Setting input failed!", e);
		}
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		super.selectionChanged(part, selection);
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		win.getShell().setText("Java - Eclipse Platform");
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void dispose() {
		super.dispose();
		// remove context- and change-listeners, if they were registered
		if (modelElementContext != null) {
			modelElementContext
					.removeModelElementContextListener(modelElementContextListener);
		}
		if (modelElementChangeListener != null) {
			modelElementChangeListener.remove();
		}
		deregisterFocusListener();
	}

	/**
	 * @generated NOT
	 */
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

	/**
	 * @generated NOT
	 */
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
	 * @generated NOT
	 */
	private void registerModelElementListeners() {

		SCRMDiagram diagram = (SCRMDiagram) getDiagram().getElement();

		// register listener for changes on the name attribute
		modelElementChangeListener = new ModelElementChangeListener(diagram) {

			@Override
			public void onChange(Notification msg) {
				if (msg.getEventType() == Notification.SET
						&& msg.getFeatureID(SCRMDiagram.class) == ScrmPackage.SCRM_DIAGRAM__NAME) {
					setPartName(msg.getNewStringValue());
				}
			}
		};

		// register modelElementContext listener for behavior upon deletion
		modelElementContext = getModelElementContext(diagram);

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
				Diagram diagram = ScrmDiagramEditor.this.getDiagram();
				if (diagram == null) {
					return;
				}
				EObject meDiagram = diagram.getElement();
				if (element == meDiagram
						|| !modelElementContext.contains(meDiagram)) {
					close(false);
				}
			}

		};

		modelElementContext
				.addModelElementContextListener(modelElementContextListener);
		;
	}

	/**
	 * @generated NOT
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
	 * @generated NOT
	 */
	@Override
	public boolean isDirty() {
		return false;
	}

	/**
	 * @generated
	 */
	protected String getContextID() {
		return CONTEXT_ID;
	}

	/**
	 * @generated NOT
	 */
	protected PaletteRoot createPaletteRoot(PaletteRoot existingPaletteRoot) {
		PaletteRoot root = super.createPaletteRoot(existingPaletteRoot);
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagram().getElement();
		new ScrmPaletteFactory(scrmDiagram).fillPalette(root);
		return root;
	}

	/**
	 * @generated
	 */
	protected PreferencesHint getPreferencesHint() {
		return ScrmDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

	/**
	 * @generated
	 */
	public String getContributorId() {
		return ScrmDiagramEditorPlugin.ID;
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class type) {
		if (type == IShowInTargetList.class) {
			return new IShowInTargetList() {
				public String[] getShowInTargetIds() {
					return new String[] { ProjectExplorer.VIEW_ID };
				}
			};
		}
		return super.getAdapter(type);
	}

	/**
	 * @generated
	 */
	protected IDocumentProvider getDocumentProvider(IEditorInput input) {
		if (input instanceof IFileEditorInput
				|| input instanceof URIEditorInput) {
			return ScrmDiagramEditorPlugin.getInstance().getDocumentProvider();
		}
		return super.getDocumentProvider(input);
	}

	/**
	 * @generated
	 */
	public TransactionalEditingDomain getEditingDomain() {
		IDocument document = getEditorInput() != null ? getDocumentProvider()
				.getDocument(getEditorInput()) : null;
		if (document instanceof IDiagramDocument) {
			return ((IDiagramDocument) document).getEditingDomain();
		}
		return super.getEditingDomain();
	}

	/**
	 * @generated
	 */
	protected void setDocumentProvider(IEditorInput input) {
		if (input instanceof IFileEditorInput
				|| input instanceof URIEditorInput) {
			setDocumentProvider(ScrmDiagramEditorPlugin.getInstance()
					.getDocumentProvider());
		} else {
			super.setDocumentProvider(input);
		}
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
		return true;
	}

	/**
	 * @generated
	 */
	public void doSaveAs() {
		performSaveAs(new NullProgressMonitor());
	}

	/**
	 * @generated
	 */
	protected void performSaveAs(IProgressMonitor progressMonitor) {
		Shell shell = getSite().getShell();
		IEditorInput input = getEditorInput();
		SaveAsDialog dialog = new SaveAsDialog(shell);
		IFile original = input instanceof IFileEditorInput ? ((IFileEditorInput) input)
				.getFile() : null;
		if (original != null) {
			dialog.setOriginalFile(original);
		}
		dialog.create();
		IDocumentProvider provider = getDocumentProvider();
		if (provider == null) {
			// editor has been programmatically closed while the dialog was open
			return;
		}
		if (provider.isDeleted(input) && original != null) {
			String message = NLS.bind(
					Messages.ScrmDiagramEditor_SavingDeletedFile,
					original.getName());
			dialog.setErrorMessage(null);
			dialog.setMessage(message, IMessageProvider.WARNING);
		}
		if (dialog.open() == Window.CANCEL) {
			if (progressMonitor != null) {
				progressMonitor.setCanceled(true);
			}
			return;
		}
		IPath filePath = dialog.getResult();
		if (filePath == null) {
			if (progressMonitor != null) {
				progressMonitor.setCanceled(true);
			}
			return;
		}
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IFile file = workspaceRoot.getFile(filePath);
		final IEditorInput newInput = new FileEditorInput(file);
		// Check if the editor is already open
		IEditorMatchingStrategy matchingStrategy = getEditorDescriptor()
				.getEditorMatchingStrategy();
		IEditorReference[] editorRefs = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage()
				.getEditorReferences();
		for (int i = 0; i < editorRefs.length; i++) {
			if (matchingStrategy.matches(editorRefs[i], newInput)) {
				MessageDialog.openWarning(shell,
						Messages.ScrmDiagramEditor_SaveAsErrorTitle,
						Messages.ScrmDiagramEditor_SaveAsErrorMessage);
				return;
			}
		}
		boolean success = false;
		try {
			provider.aboutToChange(newInput);
			getDocumentProvider(newInput).saveDocument(progressMonitor,
					newInput,
					getDocumentProvider().getDocument(getEditorInput()), true);
			success = true;
		} catch (CoreException x) {
			IStatus status = x.getStatus();
			if (status == null || status.getSeverity() != IStatus.CANCEL) {
				ErrorDialog.openError(shell,
						Messages.ScrmDiagramEditor_SaveErrorTitle,
						Messages.ScrmDiagramEditor_SaveErrorMessage,
						x.getStatus());
			}
		} finally {
			provider.changed(newInput);
			if (success) {
				setInput(newInput);
			}
		}
		if (progressMonitor != null) {
			progressMonitor.setCanceled(!success);
		}
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
		if (diagram == null || diagram.eResource() == null) {
			return StructuredSelection.EMPTY;
		}
		IFile file = WorkspaceSynchronizer.getFile(diagram.eResource());
		if (file != null) {
			ScrmNavigatorItem item = new ScrmNavigatorItem(diagram, file, false);
			return new StructuredSelection(item);
		}
		return StructuredSelection.EMPTY;
	}

	/**
	 * @generated NOT
	 */
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		IDiagramGraphicalViewer viewer = getDiagramGraphicalViewer();

		KeyHandler viewerKeyHandler = new DiagramGraphicalViewerKeyHandler(
				viewer).setParent(getKeyHandler());
		viewer.setKeyHandler(new OnEnterDirectEditKeyHandler(viewer)
				.setParent(viewerKeyHandler));

		DiagramEditorContextMenuProvider provider = new DiagramEditorContextMenuProvider(
				this, getDiagramGraphicalViewer());
		getDiagramGraphicalViewer().setContextMenu(provider);
		getSite().registerContextMenu(ActionIds.DIAGRAM_EDITOR_CONTEXT_MENU,
				provider, getDiagramGraphicalViewer());
	}

	private ECPModelelementContext getModelElementContext(EObject eObject) {
		if (eObject == null) {
			try {
				return ECPWorkspaceManager.getInstance().getWorkSpace()
						.getActiveProject();
			} catch (NoWorkspaceException e) {
				ModelUtil.logException(e);
				return null;
			}
		} else {
			return ECPWorkspaceManager.getECPProject(eObject);
		}
	}

}
