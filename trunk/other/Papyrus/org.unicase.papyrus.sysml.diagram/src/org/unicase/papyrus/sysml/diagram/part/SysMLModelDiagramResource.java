/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.sysml.diagram.part;

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
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.uml2.uml.Type;
import org.unicase.papyrus.PapyrusFactory;
import org.unicase.papyrus.SysMLClass;
import org.unicase.papyrus.SysMLModel;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

// dengler: review
/**
 * @author Helming, denglerm, mharut
 */
public class SysMLModelDiagramResource extends ResourceImpl implements Resource, Resource.Factory, Resource.Internal,
	XMLResource {

	private boolean initialized;
	private EList<EObject> list;
	private SysMLModel model;
	private SysMLClass clazz;

	/**
	 * Constructor.
	 */
	public SysMLModelDiagramResource() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param model the SysMLModel to represent
	 */
	public SysMLModelDiagramResource(SysMLModel model) {
		super();
		this.model = model;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(Map<?, ?> options) throws IOException {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TreeIterator<EObject> getAllContents() {
		// nothing to do
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
			list.add(clazz != null ? clazz : model);
			list.add(clazz != null ? clazz.getGmfDiagram() : model.getGmfDiagram());
			initialized = true;
		}
		return list;
	}

	private void initialize() {
		// TODO: improve this, maybe move it to a centralized location

		// parametric diagrams also require a class in addition to the model
		new ECPCommand(model) {

			@Override
			protected void doRun() {
				switch (model.getDiagramType()) {
				case PARAMETRIC:
					for (Type type : model.getOwnedTypes()) {
						if (type instanceof SysMLClass) {
							clazz = (SysMLClass) type;
							break;
						}
					}
					if (clazz == null) {
						clazz = PapyrusFactory.eINSTANCE.createSysMLClass();
						clazz.setName("Parametric");
						model.getOwnedTypes().add(clazz);
					}
					break;
				default:
					break;
				}
			}

		}.run(true);

		if (clazz != null ? clazz.getGmfDiagram() == null : model.getGmfDiagram() == null) {
			SysMLInitUtil.initialize(clazz != null ? clazz : model);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EObject getEObject(String uriFragment) {
		// nothing to do
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EList<Diagnostic> getErrors() {
		// nothing to do
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResourceSet getResourceSet() {
		if (model.eResource() != null) {
			return model.eResource().getResourceSet();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long getTimeStamp() {
		// nothing to do
		return 0;
	}

	/**
	 * Forwards the URI of Unicase Resource.
	 * 
	 * @return returns URI
	 */
	@Override
	public URI getURI() {
		if (model.eResource() != null) {
			return model.eResource().getURI();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EList<Diagnostic> getWarnings() {
		// nothing to do
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
		// nothing to do
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isTrackingModification() {
		// JH has to be false, otherwise nullpointer
		return super.isTrackingModification();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void load(Map<?, ?> options) throws IOException {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(Map<?, ?> options) throws IOException {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setModified(boolean isModified) {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTimeStamp(long timeStamp) {
		// nothing to do
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
		// nothing to do
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
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void eSetDeliver(boolean deliver) {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	public Resource createResource(URI uri) {
		Resource resource = WorkspaceManager.getInstance().getCurrentWorkspace().eResource();
		ResourceSet rs = resource.getResourceSet();
		EObject object = rs.getEObject(uri, false);
		if (object instanceof SysMLModel) {
			return new SysMLModelDiagramResource((SysMLModel) object);
		} else {
			throw new IllegalArgumentException("Only SysMLModels supported");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void attached(EObject object) {
		// JH Implement this?
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NotificationChain basicSetResourceSet(ResourceSet resourceSet, NotificationChain notifications) {
		// JH Check what this is for. This is called and maybe causes trouble
		return super.basicSetResourceSet(resourceSet, notifications);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void detached(EObject object) {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isLoading() {
		// nothing to do
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public DOMHelper getDOMHelper() {
		// nothing to do
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<Object, Object> getDefaultLoadOptions() {
		// nothing to do
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<Object, Object> getDefaultSaveOptions() {
		// nothing to do
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<EObject, AnyType> getEObjectToExtensionMap() {
		// nothing to do
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<EObject, String> getEObjectToIDMap() {
		// nothing to do
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEncoding() {
		// nothing to do
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getID(EObject object) {
		// JH super?
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<String, EObject> getIDToEObjectMap() {
		// nothing to do
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getPublicId() {
		// nothing to do
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getSystemId() {
		// nothing to do
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getXMLVersion() {
		// nothing to do
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void load(Node node, Map<?, ?> options) throws IOException {
		// nothing to do

	}

	/**
	 * {@inheritDoc}
	 */
	public void load(InputSource inputSource, Map<?, ?> options) throws IOException {
		// nothing to do

	}

	/**
	 * {@inheritDoc}
	 */
	public void save(Writer writer, Map<?, ?> options) throws IOException {
		// nothing to do

	}

	/**
	 * {@inheritDoc}
	 */
	public Document save(Document document, Map<?, ?> options, DOMHandler handler) {
		// nothing to do
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setDoctypeInfo(String publicId, String systemId) {
		// nothing to do

	}

	/**
	 * {@inheritDoc}
	 */
	public void setEncoding(String encoding) {
		// nothing to do

	}

	/**
	 * {@inheritDoc}
	 */
	public void setID(EObject object, String id) {
		// nothing to do

	}

	/**
	 * {@inheritDoc}
	 */
	public void setUseZip(boolean useZip) {
		// nothing to do

	}

	/**
	 * {@inheritDoc}
	 */
	public void setXMLVersion(String version) {
		// nothing to do

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean useZip() {
		// nothing to do
		return super.useZip();
	}
}
