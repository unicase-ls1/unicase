/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.diagram.part;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecp.editor.internal.e3.ECPCommand;
import org.eclipse.emf.emfstore.internal.client.model.ESWorkspaceProviderImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.AbstractDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.internal.util.DiagramIOUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.diagram.impl.DiagramLoadException;

/**
 * @author denglerm This class serves as a superclass for the generated
 *         ModelDocumentProvider in each diagram plugin.
 */
@SuppressWarnings("restriction")
public abstract class ModelDocumentProvider extends AbstractDocumentProvider
		implements IDiagramDocumentProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.AbstractDocumentProvider#createEmptyDocument()
	 */
	@Override
	final protected IDocument createEmptyDocument() {
		DiagramDocument document = new DiagramDocument();
		document.setEditingDomain((TransactionalEditingDomain) ESWorkspaceProviderImpl
				.getInstance().getInternalWorkspace().getEditingDomain());
		return document;
	}

	/**
	 * This method sets the diagram content.
	 * 
	 * @param document
	 *            The document whose content should be set
	 * @param element
	 *            The new content element
	 * @throws CoreException
	 *             if an exceptional error occurs
	 */
	final protected void setDocumentContent(IDocument document,
			IEditorInput element) throws CoreException {
		IDiagramDocument diagramDocument = (IDiagramDocument) document;
		TransactionalEditingDomain domain = diagramDocument.getEditingDomain();
		if (element instanceof FileEditorInput) {
			IStorage storage = ((FileEditorInput) element).getStorage();
			Diagram diagram = DiagramIOUtil.load(domain, storage, true,
					getProgressMonitor());
			document.setContent(diagram);
		} else if (element instanceof URIEditorInput) {
			URI uri = ((URIEditorInput) element).getURI();
			Diagram diagram = null;
			Resource resource = ESWorkspaceProviderImpl.getInstance()
					.getInternalWorkspace().eResource();
			ResourceSet rs = resource.getResourceSet();
			EObject object = rs.getEObject(uri, false);
			if (object != null) {
				diagram = extractDiagram(object);
			}
			if (diagram != null) {
				document.setContent(diagram);
				return;
			}
			throw new RuntimeException("Diagram is not present in resource");
		} else {
			throw new CoreException(
					new Status(
							IStatus.ERROR,
							"org.unicase.ui.common",
							0,
							NLS.bind(
									"Incorrect editor input",
									new Object[] {
											element,
											"org.eclipse.ui.part.FileEditorInput", "org.eclipse.emf.common.ui.URIEditorInput" }), //$NON-NLS-1$ //$NON-NLS-2$ 
							null));
		}
	}

	private Diagram extractDiagram(EObject object) {
		if (object instanceof MEDiagram) {
			final MEDiagram diagram = (MEDiagram) object;
			// legacy support
			new ECPCommand(diagram, null) {

				@Override
				protected void doRun() {
					try {
						diagram.loadDiagramLayout();
					} catch (DiagramLoadException e) {
						// do nothing
					}
				}

			}.run(true);

			if (diagram.getGmfdiagram() == null) {
				String id = diagram.getType();
				if (id == null) {
					throw new RuntimeException("Unsupported diagram type");
				}
				// JH: Build switch for different diagram types
				final Diagram result = ViewService.createDiagram(diagram, id,
						getPreferencesHint());
				if (result == null) {
					return null;
				}
				result.setElement(diagram);
				new ECPCommand(diagram, ESWorkspaceProviderImpl.getInstance()
						.getInternalWorkspace().getEditingDomain()) {
					@Override
					protected void doRun() {
						diagram.setGmfdiagram(result);
					}
				}.run(true);
			}

			return diagram.getGmfdiagram();
		}
		return null;
	}

	/**
	 * @return the {@link PreferencesHint} for the diagram
	 */
	protected abstract PreferencesHint getPreferencesHint();
}
