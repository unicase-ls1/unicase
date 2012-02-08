/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.diagram.editors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.MultiRule;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.internal.EditorStatusCodes;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.diagram.activity.part.Messages;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorUtil;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.unicase.papyrus.diagram.part.UMLDocumentProvider;

/**
 * Document provider for Papyrus activity diagrams.
 * 
 * @author mharut
 */
public class UMLActivityDiagramDocumentProvider extends UMLDocumentProvider {

	/**
	 * {@inheritDoc}
	 */
	protected ElementInfo createElementInfo(Object element) throws CoreException {
		if (!(element instanceof FileEditorInput) && !(element instanceof URIEditorInput)) {
			throw new CoreException(new Status(IStatus.ERROR, UMLDiagramEditorPlugin.ID, 0, NLS.bind(
				Messages.UMLDocumentProvider_IncorrectInputError, new Object[] { element,
					"org.eclipse.ui.part.FileEditorInput", "org.eclipse.emf.common.ui.URIEditorInput" }), //$NON-NLS-1$ //$NON-NLS-2$ 
				null));
		}
		IEditorInput editorInput = (IEditorInput) element;
		IDiagramDocument document = (IDiagramDocument) createDocument(editorInput);

		ResourceSetInfo info = new ResourceSetInfo(document, editorInput);
		info.setModificationStamp(computeModificationStamp(info));
		info.fStatus = null;
		return info;
	}

	/**
	 * {@inheritDoc}
	 */
	protected IDocument createDocument(Object element) throws CoreException {
		if (!(element instanceof FileEditorInput) && !(element instanceof URIEditorInput)) {
			throw new CoreException(new Status(IStatus.ERROR, UMLDiagramEditorPlugin.ID, 0, NLS.bind(
				Messages.UMLDocumentProvider_IncorrectInputError, new Object[] { element,
					"org.eclipse.ui.part.FileEditorInput", "org.eclipse.emf.common.ui.URIEditorInput" }), //$NON-NLS-1$ //$NON-NLS-2$ 
				null));
		}
		IDocument document = createEmptyDocument();
		setDocumentContent(document, (IEditorInput) element);
		setupDocument(element, document);
		return document;
	}

	/**
	 * @generated
	 */
	public long getModificationStamp(Object element) {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			return computeModificationStamp(info);
		}
		return super.getModificationStamp(element);
	}

	/**
	 * @generated
	 */
	public boolean isReadOnly(Object element) {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			if (info.isUpdateCache()) {
				try {
					updateCache(element);
				} catch (CoreException ex) {
					UMLDiagramEditorPlugin.getInstance().logError(Messages.UMLDocumentProvider_isModifiable, ex);
				}
			}
			return info.isReadOnly();
		}
		return super.isReadOnly(element);
	}

	/**
	 * @generated
	 */
	public boolean isModifiable(Object element) {
		if (!isStateValidated(element)) {
			if (element instanceof FileEditorInput || element instanceof URIEditorInput) {
				return true;
			}
		}
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			if (info.isUpdateCache()) {
				try {
					updateCache(element);
				} catch (CoreException ex) {
					UMLDiagramEditorPlugin.getInstance().logError(Messages.UMLDocumentProvider_isModifiable, ex);
				}
			}
			return info.isModifiable();
		}
		return super.isModifiable(element);
	}

	/**
	 * @generated
	 */
	protected void doUpdateStateCache(Object element) throws CoreException {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			info.setUpdateCache(true);
		}
		super.doUpdateStateCache(element);
	}

	/**
	 * @generated
	 */
	public boolean isSynchronized(Object element) {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			return info.isSynchronized();
		}
		return super.isSynchronized(element);
	}

	/**
	 * @generated
	 */
	protected ISchedulingRule getResetRule(Object element) {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			Collection/* <org.eclipse.core.runtime.jobs.ISchedulingRule> */rules = new ArrayList/*
																							 * <org.eclipse.core.runtime.
																							 * jobs.ISchedulingRule>
																							 */();
			for (Iterator/* <org.eclipse.emf.ecore.resource.Resource> */it = info.getLoadedResourcesIterator(); it
				.hasNext();) {
				Resource nextResource = (Resource) it.next();
				IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if (file != null) {
					rules.add(ResourcesPlugin.getWorkspace().getRuleFactory().modifyRule(file));
				}
			}
			return new MultiRule((ISchedulingRule[]) rules.toArray(new ISchedulingRule[rules.size()]));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected ISchedulingRule getSaveRule(Object element) {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			Collection/* <org.eclipse.core.runtime.jobs.ISchedulingRule> */rules = new ArrayList/*
																							 * <org.eclipse.core.runtime.
																							 * jobs.ISchedulingRule>
																							 */();
			for (Iterator/* <org.eclipse.emf.ecore.resource.Resource> */it = info.getLoadedResourcesIterator(); it
				.hasNext();) {
				Resource nextResource = (Resource) it.next();
				IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if (file != null) {
					rules.add(computeSchedulingRule(file));
				}
			}
			return new MultiRule((ISchedulingRule[]) rules.toArray(new ISchedulingRule[rules.size()]));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected ISchedulingRule getSynchronizeRule(Object element) {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			Collection/* <org.eclipse.core.runtime.jobs.ISchedulingRule> */rules = new ArrayList/*
																							 * <org.eclipse.core.runtime.
																							 * jobs.ISchedulingRule>
																							 */();
			for (Iterator/* <org.eclipse.emf.ecore.resource.Resource> */it = info.getLoadedResourcesIterator(); it
				.hasNext();) {
				Resource nextResource = (Resource) it.next();
				IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if (file != null) {
					rules.add(ResourcesPlugin.getWorkspace().getRuleFactory().refreshRule(file));
				}
			}
			return new MultiRule((ISchedulingRule[]) rules.toArray(new ISchedulingRule[rules.size()]));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected ISchedulingRule getValidateStateRule(Object element) {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			Collection/* <org.eclipse.core.runtime.jobs.ISchedulingRule> */files = new ArrayList/*
																							 * <org.eclipse.core.runtime.
																							 * jobs.ISchedulingRule>
																							 */();
			for (Iterator/* <org.eclipse.emf.ecore.resource.Resource> */it = info.getLoadedResourcesIterator(); it
				.hasNext();) {
				Resource nextResource = (Resource) it.next();
				IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if (file != null) {
					files.add(file);
				}
			}
			return ResourcesPlugin.getWorkspace().getRuleFactory()
				.validateEditRule((IFile[]) files.toArray(new IFile[files.size()]));
		}
		return null;
	}

	/**
	 * @generated
	 */
	private ISchedulingRule computeSchedulingRule(IResource toCreateOrModify) {
		if (toCreateOrModify.exists())
			return ResourcesPlugin.getWorkspace().getRuleFactory().modifyRule(toCreateOrModify);

		IResource parent = toCreateOrModify;
		do {
			toCreateOrModify = parent;
			parent = toCreateOrModify.getParent();
		} while (parent != null && !parent.exists());

		return ResourcesPlugin.getWorkspace().getRuleFactory().createRule(toCreateOrModify);
	}

	/**
	 * @generated
	 */
	protected void doSynchronize(Object element, IProgressMonitor monitor) throws CoreException {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			for (Iterator/* <org.eclipse.emf.ecore.resource.Resource> */it = info.getLoadedResourcesIterator(); it
				.hasNext();) {
				Resource nextResource = (Resource) it.next();
				handleElementChanged(info, nextResource, monitor);
			}
			return;
		}
		super.doSynchronize(element, monitor);
	}

	/**
	 * @generated
	 */
	protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite)
		throws CoreException {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			if (!overwrite && !info.isSynchronized()) {
				throw new CoreException(new Status(IStatus.ERROR, UMLDiagramEditorPlugin.ID,
					IResourceStatus.OUT_OF_SYNC_LOCAL, Messages.UMLDocumentProvider_UnsynchronizedFileSaveError, null));
			}
			info.stopResourceListening();
			fireElementStateChanging(element);
			try {
				monitor.beginTask(Messages.UMLDocumentProvider_SaveDiagramTask, info.getResourceSet().getResources()
					.size() + 1); // "Saving diagram"
				for (Iterator/* <org.eclipse.emf.ecore.resource.Resource> */it = info.getLoadedResourcesIterator(); it
					.hasNext();) {
					Resource nextResource = (Resource) it.next();
					monitor.setTaskName(NLS.bind(Messages.UMLDocumentProvider_SaveNextResourceTask,
						nextResource.getURI()));
					if (nextResource.isLoaded() && !info.getEditingDomain().isReadOnly(nextResource)) {
						try {
							nextResource.save(UMLDiagramEditorUtil.getSaveOptions());
						} catch (IOException e) {
							fireElementStateChangeFailed(element);
							throw new CoreException(new Status(IStatus.ERROR, UMLDiagramEditorPlugin.ID,
								EditorStatusCodes.RESOURCE_FAILURE, e.getLocalizedMessage(), null));
						}
					}
					monitor.worked(1);
				}
				monitor.done();
				info.setModificationStamp(computeModificationStamp(info));
			} catch (RuntimeException x) {
				fireElementStateChangeFailed(element);
				throw x;
			} finally {
				info.startResourceListening();
			}
		} else {
			URI newResoruceURI;
			List affectedFiles = null;
			if (element instanceof FileEditorInput) {
				IFile newFile = ((FileEditorInput) element).getFile();
				affectedFiles = Collections.singletonList(newFile);
				newResoruceURI = URI.createPlatformResourceURI(newFile.getFullPath().toString(), true);
			} else if (element instanceof URIEditorInput) {
				newResoruceURI = ((URIEditorInput) element).getURI();
			} else {
				fireElementStateChangeFailed(element);
				throw new CoreException(new Status(IStatus.ERROR, UMLDiagramEditorPlugin.ID, 0, NLS.bind(
					Messages.UMLDocumentProvider_IncorrectInputError, new Object[] { element,
						"org.eclipse.ui.part.FileEditorInput", "org.eclipse.emf.common.ui.URIEditorInput" }), //$NON-NLS-1$ //$NON-NLS-2$ 
					null));
			}
			if (false == document instanceof IDiagramDocument) {
				fireElementStateChangeFailed(element);
				throw new CoreException(
					new Status(
						IStatus.ERROR,
						UMLDiagramEditorPlugin.ID,
						0,
						"Incorrect document used: " + document + " instead of org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument", null)); //$NON-NLS-1$ //$NON-NLS-2$
			}
			IDiagramDocument diagramDocument = (IDiagramDocument) document;
			final Resource newResource = diagramDocument.getEditingDomain().getResourceSet()
				.createResource(newResoruceURI);
			final Diagram diagramCopy = (Diagram) EcoreUtil.copy(diagramDocument.getDiagram());
			try {
				new AbstractTransactionalCommand(diagramDocument.getEditingDomain(), NLS.bind(
					Messages.UMLDocumentProvider_SaveAsOperation, diagramCopy.getName()), affectedFiles) {
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {
						newResource.getContents().add(diagramCopy);
						return CommandResult.newOKCommandResult();
					}
				}.execute(monitor, null);
				newResource.save(UMLDiagramEditorUtil.getSaveOptions());
			} catch (ExecutionException e) {
				fireElementStateChangeFailed(element);
				throw new CoreException(new Status(IStatus.ERROR, UMLDiagramEditorPlugin.ID, 0,
					e.getLocalizedMessage(), null));
			} catch (IOException e) {
				fireElementStateChangeFailed(element);
				throw new CoreException(new Status(IStatus.ERROR, UMLDiagramEditorPlugin.ID, 0,
					e.getLocalizedMessage(), null));
			}
			newResource.unload();
		}
	}

	/**
	 * @generated
	 */
	protected void disposeElementInfo(Object element, ElementInfo info) {
		if (info instanceof ResourceSetInfo) {
			ResourceSetInfo resourceSetInfo = (ResourceSetInfo) info;
			resourceSetInfo.dispose();
		}
		super.disposeElementInfo(element, info);
	}

	/**
	 * @generated
	 */
	public IEditorInput createInputWithEditingDomain(IEditorInput editorInput, TransactionalEditingDomain domain) {
		return editorInput;
	}

	/**
	 * @generated
	 */
	public IDiagramDocument getDiagramDocument(Object element) {
		IDocument doc = getDocument(element);
		if (doc instanceof IDiagramDocument) {
			return (IDiagramDocument) doc;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected IRunnableContext getOperationRunner(IProgressMonitor monitor) {
		return null;
	}
}
