/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.diagram.part;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.xmi.DOMHandler;
import org.eclipse.emf.ecore.xmi.DOMHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.unicase.papyrus.UMLModel;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

// dengler: review
/**
 * @author Helming, denglerm
 */
public class UMLModelDiagramResource extends ResourceImpl implements Resource, Resource.Factory, Resource.Internal,
	XMLResource {

	private boolean initialized;
	private EList<EObject> list;
	private UMLModel model;

	/**
	 * Constructor.
	 */
	public UMLModelDiagramResource() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param model the UMLModel to represent
	 */
	public UMLModelDiagramResource(UMLModel model) {
		super();
		this.model = model;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(Map<?, ?> options) throws IOException {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TreeIterator<EObject> getAllContents() {
		// do nothing
		return null;
	}

	/**
	 * Overriden to return the Package and the GMF Diagram on root level.
	 * 
	 * @return Package and the GMF Diagram on root level
	 */
	@Override
	public EList<EObject> getContents() {
		if (!initialized) {
			initialize();
			list = new BasicEList<EObject>();
			list.add(model);
			list.add(model.getGmfDiagram());
			initialized = true;
		}
		return list;
	}

	private void initialize() {
		// TODO: improve this, maybe move it
		boolean hasModelSetQuery = false;
		for (Object adapter : model.eResource().eAdapters()) {
			if (adapter instanceof UnicaseModelSetQueryAdapter) {
				hasModelSetQuery = true;
				break;
			}
		}

		if (!hasModelSetQuery) {
			model.eResource().eAdapters().add(new UnicaseModelSetQueryAdapter());
		}

		if (model.getGmfDiagram() == null) {
			UMLInitUtil.initialize(model);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EObject getEObject(String uriFragment) {
		// do nothing
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EList<Diagnostic> getErrors() {
		// do nothing
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResourceSet getResourceSet() {
		if (model.eResource() != null) {
			return model.eResource().getResourceSet();
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long getTimeStamp() {
		// do nothing
		return 0;
	}

	/**
	 * Forwards the URI of unicase Resource.
	 * 
	 * @return returns URI
	 */
	@Override
	public URI getURI() {
		if (model.eResource() != null) {
			return model.eResource().getURI();
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getURIFragment(EObject object) {
		String uriFragment = super.getURIFragment(object);
		return uriFragment;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EList<Diagnostic> getWarnings() {
		// do nothing
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isLoaded() {
		return model.eResource().isLoaded();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isModified() {
		// do nothing
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isTrackingModification() {
		return super.isTrackingModification();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void load(Map<?, ?> options) throws IOException {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(Map<?, ?> options) throws IOException {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setModified(boolean isModified) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTimeStamp(long timeStamp) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTrackingModification(boolean isTrackingModification) {
		model.eResource().setTrackingModification(isTrackingModification);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setURI(URI uri) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean eDeliver() {
		return model.eResource().eDeliver();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void eNotify(Notification notification) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void eSetDeliver(boolean deliver) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public Resource createResource(URI uri) {
		Resource resource = WorkspaceManager.getInstance().getCurrentWorkspace().eResource();
		ResourceSet rs = resource.getResourceSet();
		EObject object = rs.getEObject(uri, false);
		if (object instanceof UMLModel) {
			return new UMLModelDiagramResource((UMLModel) object);
		} else {
			throw new IllegalArgumentException("Only UMLModels supported");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void attached(EObject object) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NotificationChain basicSetResourceSet(ResourceSet resourceSet, NotificationChain notifications) {
		// do nothing
		return super.basicSetResourceSet(resourceSet, notifications);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void detached(EObject object) {
		// do nothing

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isLoading() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public DOMHelper getDOMHelper() {
		// do nothing
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<Object, Object> getDefaultLoadOptions() {
		// do nothing
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<Object, Object> getDefaultSaveOptions() {
		// do nothing
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<EObject, AnyType> getEObjectToExtensionMap() {
		// do nothing
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<EObject, String> getEObjectToIDMap() {
		// do nothing
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEncoding() {
		// do nothing
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getID(EObject object) {
		// do nothing
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<String, EObject> getIDToEObjectMap() {
		// do nothing
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getPublicId() {
		// do nothing
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getSystemId() {
		// do nothing
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getXMLVersion() {
		// do nothing
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void load(Node node, Map<?, ?> options) throws IOException {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public void load(InputSource inputSource, Map<?, ?> options) throws IOException {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public void save(Writer writer, Map<?, ?> options) throws IOException {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public Document save(Document document, Map<?, ?> options, DOMHandler handler) {
		// do nothing
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setDoctypeInfo(String publicId, String systemId) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public void setEncoding(String encoding) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public void setID(EObject object, String id) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public void setUseZip(boolean useZip) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public void setXMLVersion(String version) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean useZip() {
		// do nothing
		return super.useZip();
	}
}
