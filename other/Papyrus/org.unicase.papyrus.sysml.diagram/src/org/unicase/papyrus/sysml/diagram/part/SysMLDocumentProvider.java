/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.sysml.diagram.part;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.AbstractDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResourceFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.sysml.diagram.parametric.part.Messages;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;

/**
 * Abstract document provider superclass for all Papyrus SysML document providers.
 * 
 * @author mharut
 */
public abstract class SysMLDocumentProvider extends AbstractDocumentProvider implements IDiagramDocumentProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.AbstractDocumentProvider#createEmptyDocument()
	 */
	@Override
	protected IDocument createEmptyDocument() {
		DiagramDocument document = new DiagramDocument();
		document.setEditingDomain((TransactionalEditingDomain) WorkspaceManager.getInstance().getCurrentWorkspace()
			.getEditingDomain());
		return document;
	}

	/**
	 * This method sets the diagram content.
	 * 
	 * @param document The document whose content should be set
	 * @param element The new content element
	 * @throws CoreException if an exceptional error occurs
	 */
	@SuppressWarnings("unchecked")
	protected void setDocumentContent(IDocument document, IEditorInput element) throws CoreException {
		IDiagramDocument diagramDocument = (IDiagramDocument) document;
		TransactionalEditingDomain domain = diagramDocument.getEditingDomain();
		if (element instanceof URIEditorInput) {
			URI uri = ((URIEditorInput) element).getURI();
			Resource resource = null;
			try {
				resource = domain.getResourceSet().createResource(uri, "SysMLModel");
				if (!resource.isLoaded()) {
					try {
						Map<String, Boolean> options = new HashMap<String, Boolean>(
							GMFResourceFactory.getDefaultLoadOptions());
						// @see 171060
						// options.put(org.eclipse.emf.ecore.xmi.XMLResource.OPTION_RECORD_UNKNOWN_FEATURE,
						// Boolean.TRUE);
						resource.load(options);
					} catch (IOException e) {
						resource.unload();
						throw e;
					}
				}
				for (Iterator<EObject> it = resource.getContents().iterator(); it.hasNext();) {
					EObject rootElement = it.next();
					if (rootElement instanceof Diagram) {
						document.setContent(rootElement);
						return;
					}
				}
				// }
				throw new RuntimeException("Diagram is not present in resource");
			} catch (IOException e) {
				String msg = e.getLocalizedMessage();
				CoreException thrownExcp = new CoreException(new Status(IStatus.ERROR, "org.unicase.ui.common", 0,
					msg != null ? msg : "Error loading diagram", e));
				throw thrownExcp;

			}

		} else {
			throw new CoreException(new Status(IStatus.ERROR, "org.unicase.ui.common", 0, NLS.bind(
				"Incorrect editor input", new Object[] { element,
					"org.eclipse.ui.part.FileEditorInput", "org.eclipse.emf.common.ui.URIEditorInput" }), //$NON-NLS-1$ //$NON-NLS-2$ 
				null));
		}
	}

	/**
	 * Sets up the given document as it would be provided for the given element. The content of the document is not
	 * changed. This default implementation is empty. Subclasses may reimplement.
	 * 
	 * @param element the blue-print element
	 * @param document the document to set up
	 * @generated
	 */
	protected void setupDocument(Object element, IDocument document) {
		// for subclasses
	}

	/**
	 * @generated
	 */
	public boolean isDeleted(Object element) {
		IDiagramDocument document = getDiagramDocument(element);
		if (document != null) {
			Resource diagramResource = document.getDiagram().eResource();
			if (diagramResource != null) {
				IFile file = WorkspaceSynchronizer.getFile(diagramResource);
				return file == null || file.getLocation() == null || !file.getLocation().toFile().exists();
			}
		}
		return super.isDeleted(element);
	}

	/**
	 * @generated
	 */
	public ResourceSetInfo getResourceSetInfo(Object editorInput) {
		return (ResourceSetInfo) super.getElementInfo(editorInput);
	}

	/**
	 * @generated
	 */
	protected void doValidateState(Object element, Object computationContext) throws CoreException {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			Collection<IFile> files2Validate = new ArrayList<IFile>();
			for (Iterator<Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
				Resource nextResource = (Resource) it.next();
				IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if (file != null && file.isReadOnly()) {
					files2Validate.add(file);
				}
			}
			ResourcesPlugin.getWorkspace().validateEdit(
				(IFile[]) files2Validate.toArray(new IFile[files2Validate.size()]), computationContext);
		}

		super.doValidateState(element, computationContext);
	}

	/**
	 * @generated
	 */
	protected void updateCache(Object element) throws CoreException {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			for (Iterator<Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
				Resource nextResource = (Resource) it.next();
				IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if (file != null && file.isReadOnly()) {
					info.setReadOnly(true);
					info.setModifiable(false);
					return;
				}
			}
			info.setReadOnly(false);
			info.setModifiable(true);
			return;
		}
	}

	/**
	 * @generated
	 */
	protected long computeModificationStamp(ResourceSetInfo info) {
		int result = 0;
		for (Iterator<Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
			Resource nextResource = (Resource) it.next();
			IFile file = WorkspaceSynchronizer.getFile(nextResource);
			if (file != null) {
				if (file.getLocation() != null) {
					result += file.getLocation().toFile().lastModified();
				} else {
					result += file.getModificationStamp();
				}
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected void handleElementChanged(ResourceSetInfo info, Resource changedResource, IProgressMonitor monitor) {
		IFile file = WorkspaceSynchronizer.getFile(changedResource);
		if (file != null) {
			try {
				file.refreshLocal(IResource.DEPTH_INFINITE, monitor);
			} catch (CoreException ex) {
				WorkspaceUtil.logException(Messages.SysmlDocumentProvider_handleElementContentChanged, ex);
				// Error message to log was initially taken from
				// org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.internal.l10n.EditorMessages.FileDocumentProvider_handleElementContentChanged
			}
		}
		changedResource.unload();

		fireElementContentAboutToBeReplaced(info.getEditorInput());
		removeUnchangedElementListeners(info.getEditorInput(), info);
		info.fStatus = null;
		try {
			setDocumentContent(info.fDocument, info.getEditorInput());
		} catch (CoreException e) {
			info.fStatus = e.getStatus();
		}
		if (!info.fCanBeSaved) {
			info.setModificationStamp(computeModificationStamp(info));
		}
		addUnchangedElementListeners(info.getEditorInput(), info);
		fireElementContentReplaced(info.getEditorInput());
	}

	/**
	 * @generated
	 */
	protected void handleElementMoved(IEditorInput input, URI uri) {
		if (input instanceof FileEditorInput) {
			IFile newFile = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(URI.decode(uri.path())).removeFirstSegments(1));
			fireElementMoved(input, newFile == null ? null : new FileEditorInput(newFile));
			return;
		}
		fireElementMoved(input, new URIEditorInput(uri));
	}

	/**
	 * @generated
	 */
	protected class ResourceSetInfo extends ElementInfo {

		/**
		 * @generated
		 */
		private long myModificationStamp = IResource.NULL_STAMP;

		/**
		 * @generated
		 */
		private WorkspaceSynchronizer mySynchronizer;

		/**
		 * @generated
		 */
		private Collection<Resource> myUnSynchronizedResources = new ArrayList<Resource>();

		/**
		 * @generated
		 */
		private IDiagramDocument myDocument;

		/**
		 * @generated
		 */
		private IEditorInput myEditorInput;

		/**
		 * @generated
		 */
		private boolean myUpdateCache = true;

		/**
		 * @generated
		 */
		private boolean myModifiable = false;

		/**
		 * @generated
		 */
		private boolean myReadOnly = true;

		/**
		 * @generated
		 */
		private ResourceSetModificationListener myResourceSetListener;

		/**
		 * @generated
		 */
		public ResourceSetInfo(IDiagramDocument document, IEditorInput editorInput) {
			super(document);
			myDocument = document;
			myEditorInput = editorInput;
			startResourceListening();
			myResourceSetListener = new ResourceSetModificationListener(this);
			getResourceSet().eAdapters().add(myResourceSetListener);
		}

		/**
		 * @generated
		 */
		public long getModificationStamp() {
			return myModificationStamp;
		}

		/**
		 * @generated
		 */
		public void setModificationStamp(long modificationStamp) {
			myModificationStamp = modificationStamp;
		}

		/**
		 * @generated
		 */
		public TransactionalEditingDomain getEditingDomain() {
			return myDocument.getEditingDomain();
		}

		/**
		 * @generated
		 */
		public ResourceSet getResourceSet() {
			return getEditingDomain().getResourceSet();
		}

		/**
		 * @generated
		 */
		public Iterator<Resource> getLoadedResourcesIterator() {
			return new ArrayList<Resource>(getResourceSet().getResources()).iterator();
		}

		/**
		 * @generated
		 */
		public IEditorInput getEditorInput() {
			return myEditorInput;
		}

		/**
		 * @generated NOT
		 */
		public void dispose() {
			stopResourceListening();
			getResourceSet().eAdapters().remove(myResourceSetListener);
			// for (Iterator/*<org.eclipse.emf.ecore.resource.Resource>*/it = getLoadedResourcesIterator(); it
			// .hasNext();) {
			// Resource resource = (Resource) it.next();
			// resource.unload();
			// }
		}

		/**
		 * @generated
		 */
		public boolean isSynchronized() {
			return myUnSynchronizedResources.size() == 0;
		}

		/**
		 * @generated
		 */
		public void setUnSynchronized(Resource resource) {
			myUnSynchronizedResources.add(resource);
		}

		/**
		 * @generated
		 */
		public void setSynchronized(Resource resource) {
			myUnSynchronizedResources.remove(resource);
		}

		/**
		 * @generated
		 */
		public final void stopResourceListening() {
			mySynchronizer.dispose();
			mySynchronizer = null;
		}

		/**
		 * @generated
		 */
		public final void startResourceListening() {
			mySynchronizer = new WorkspaceSynchronizer(getEditingDomain(), new SynchronizerDelegate());
		}

		/**
		 * @generated
		 */
		public boolean isUpdateCache() {
			return myUpdateCache;
		}

		/**
		 * @generated
		 */
		public void setUpdateCache(boolean update) {
			myUpdateCache = update;
		}

		/**
		 * @generated
		 */
		public boolean isModifiable() {
			return myModifiable;
		}

		/**
		 * @generated
		 */
		public void setModifiable(boolean modifiable) {
			myModifiable = modifiable;
		}

		/**
		 * @generated
		 */
		public boolean isReadOnly() {
			return myReadOnly;
		}

		/**
		 * @generated
		 */
		public void setReadOnly(boolean readOnly) {
			myReadOnly = readOnly;
		}

		/**
		 * @generated
		 */
		private class SynchronizerDelegate implements WorkspaceSynchronizer.Delegate {

			/**
			 * @generated
			 */
			public void dispose() {
			}

			/**
			 * @generated
			 */
			public boolean handleResourceChanged(final Resource resource) {
				synchronized (ResourceSetInfo.this) {
					if (ResourceSetInfo.this.fCanBeSaved) {
						ResourceSetInfo.this.setUnSynchronized(resource);
						return true;
					}
				}
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						handleElementChanged(ResourceSetInfo.this, resource, null);
					}
				});
				return true;
			}

			/**
			 * @generated
			 */
			public boolean handleResourceDeleted(Resource resource) {
				synchronized (ResourceSetInfo.this) {
					if (ResourceSetInfo.this.fCanBeSaved) {
						ResourceSetInfo.this.setUnSynchronized(resource);
						return true;
					}
				}
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						fireElementDeleted(ResourceSetInfo.this.getEditorInput());
					}
				});
				return true;
			}

			/**
			 * @generated
			 */
			public boolean handleResourceMoved(Resource resource, final URI newURI) {
				synchronized (ResourceSetInfo.this) {
					if (ResourceSetInfo.this.fCanBeSaved) {
						ResourceSetInfo.this.setUnSynchronized(resource);
						return true;
					}
				}
				if (myDocument.getDiagram().eResource() == resource) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							handleElementMoved(ResourceSetInfo.this.getEditorInput(), newURI);
						}
					});
				} else {
					handleResourceDeleted(resource);
				}
				return true;
			}

		}

	}

	/**
	 * @generated
	 */
	private class ResourceSetModificationListener extends EContentAdapter {

		/**
		 * @generated
		 */
		private NotificationFilter myModifiedFilter;

		/**
		 * @generated
		 */
		private ResourceSetInfo myInfo;

		/**
		 * @generated
		 */
		public ResourceSetModificationListener(ResourceSetInfo info) {
			myInfo = info;
			myModifiedFilter = NotificationFilter.createEventTypeFilter(Notification.SET)
				.or(NotificationFilter.createEventTypeFilter(Notification.UNSET))
				.and(NotificationFilter.createFeatureFilter(Resource.class, Resource.RESOURCE__IS_MODIFIED));
		}

		/**
		 * @generated
		 */
		public void notifyChanged(Notification notification) {
			if (notification.getNotifier() instanceof ResourceSet) {
				super.notifyChanged(notification);
			}
			if (!notification.isTouch() && myModifiedFilter.matches(notification)) {
				if (notification.getNotifier() instanceof Resource) {
					Resource resource = (Resource) notification.getNotifier();
					if (resource.isLoaded()) {
						boolean modified = false;
						for (Iterator<Resource> it = myInfo.getLoadedResourcesIterator(); it.hasNext() && !modified;) {
							Resource nextResource = (Resource) it.next();
							if (nextResource.isLoaded()) {
								modified = nextResource.isModified();
							}
						}
						boolean dirtyStateChanged = false;
						synchronized (myInfo) {
							if (modified != myInfo.fCanBeSaved) {
								myInfo.fCanBeSaved = modified;
								dirtyStateChanged = true;
							}
							if (!resource.isModified()) {
								myInfo.setSynchronized(resource);
							}
						}
						if (dirtyStateChanged) {
							fireElementDirtyStateChanged(myInfo.getEditorInput(), modified);

							if (!modified) {
								myInfo.setModificationStamp(computeModificationStamp(myInfo));
							}
						}
					}
				}
			}
		}

	}

}
