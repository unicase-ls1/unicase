/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.diagram.part;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.AbstractDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.internal.util.DiagramIOUtil;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResourceFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;

/**
 * @author denglerm This class serves as a superclass for the generated ModelDocumentProvider in each diagram plugin.
 */
@SuppressWarnings("restriction")
public class ModelDocumentProvider extends AbstractDocumentProvider implements IDiagramDocumentProvider {

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
		if (element instanceof FileEditorInput) {
			IStorage storage = ((FileEditorInput) element).getStorage();
			Diagram diagram = DiagramIOUtil.load(domain, storage, true, getProgressMonitor());
			document.setContent(diagram);
		} else if (element instanceof URIEditorInput) {
			URI uri = ((URIEditorInput) element).getURI();
			Resource resource = null;
			try {
				// resource = domain.getResourceSet().getResource(
				// uri.trimFragment(), false);
				resource = domain.getResourceSet().createResource(uri, "MEDiagram");
				if (!resource.isLoaded()) {
					try {
						Map options = new HashMap(GMFResourceFactory.getDefaultLoadOptions());
						// @see 171060
						// options.put(org.eclipse.emf.ecore.xmi.XMLResource.
						// OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
						resource.load(options);
					} catch (IOException e) {
						resource.unload();
						throw e;
					}
				}
				// if (uri.fragment() != null) {
				// EObject rootElement = resource.getEObject(uri.fragment());
				// if (rootElement instanceof Diagram) {
				// document.setContent((Diagram) rootElement);
				// return;
				// }
				// } else {
				for (Iterator it = resource.getContents().iterator(); it.hasNext();) {
					Object rootElement = it.next();
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
	 * {@inheritDoc}
	 */
	@Override
	protected IDocument createDocument(Object element) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite)
		throws CoreException {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IRunnableContext getOperationRunner(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public IEditorInput createInputWithEditingDomain(IEditorInput editorInput, TransactionalEditingDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public IDiagramDocument getDiagramDocument(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

}
