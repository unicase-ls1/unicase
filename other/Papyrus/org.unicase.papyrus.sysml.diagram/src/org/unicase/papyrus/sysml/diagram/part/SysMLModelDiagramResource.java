/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
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
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.DOMHandler;
import org.eclipse.emf.ecore.xmi.DOMHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.unicase.papyrus.PapyrusFactory;
import org.unicase.papyrus.SysMLClass;
import org.unicase.papyrus.SysMLModel;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

// dengler: review
/**
 * @author Helming, denglerm
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
	 * . {@inheritDoc}
	 */
	@Override
	public void delete(Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public TreeIterator<EObject> getAllContents() {
		// TODO Auto-generated method stub
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
		// TODO: improve this, maybe move it
		boolean hasModelSetQuery = false;
		for(Object adapter : model.eResource().eAdapters()) {
			if(adapter instanceof UnicaseModelSetQueryAdapter) {
				hasModelSetQuery = true;
				break;
			}
		}
		
		if(!hasModelSetQuery) {
			model.eResource().eAdapters().add(new UnicaseModelSetQueryAdapter());
		}
		
		new ECPCommand(model) {

			@Override
			protected void doRun() {
				switch(model.getDiagramType()) {
				case PARAMETRIC:
					clazz = PapyrusFactory.eINSTANCE.createSysMLClass();
					clazz.setName("Parametric");
					model.getOwnedTypes().add(clazz);
					break;
				default:
				}
			}
			
		}.run(true);

		if(clazz != null ? clazz.getGmfDiagram() == null : model.getGmfDiagram() == null) {
			SysMLInitUtil.initialize(clazz != null ? clazz : model);
		}
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public EObject getEObject(String uriFragment) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public EList<Diagnostic> getErrors() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public ResourceSet getResourceSet() {
		if (model.eResource() != null) {
			return model.eResource().getResourceSet();
		} else {
			// evil hack
			return new ResourceSetImpl();
		}
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public long getTimeStamp() {
		// TODO Auto-generated method stub
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
			// evil hack
			ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
			Resource resource = resourceSetImpl.createResource(URI.createURI("blaaaaaa"));
			return resource.getURI();
		}
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public String getURIFragment(EObject object) {
		String uriFragment = super.getURIFragment(object);
		return uriFragment;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public EList<Diagnostic> getWarnings() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public boolean isLoaded() {

		return model.eResource().isLoaded();
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public boolean isModified() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public boolean isTrackingModification() {
		// JH has to be false, otherwise nullpointer
		return super.isTrackingModification();
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void load(Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void save(Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void setModified(boolean isModified) {
		// TODO Auto-generated method stub
		System.out.print("huha");

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void setTimeStamp(long timeStamp) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void setTrackingModification(boolean isTrackingModification) {
		model.eResource().setTrackingModification(isTrackingModification);
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void setURI(URI uri) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public boolean eDeliver() {
		return model.eResource().eDeliver();
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void eNotify(Notification notification) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void eSetDeliver(boolean deliver) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
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
	 * . {@inheritDoc}
	 */
	@Override
	public void attached(EObject object) {
		// JH Implement this?
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public NotificationChain basicSetResourceSet(ResourceSet resourceSet, NotificationChain notifications) {

		// JH Check what this is for. This is called and maybe causes trouble
		return super.basicSetResourceSet(resourceSet, notifications);

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void detached(EObject object) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public boolean isLoading() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * . {@inheritDoc}
	 */
	public DOMHelper getDOMHelper() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public Map<Object, Object> getDefaultLoadOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public Map<Object, Object> getDefaultSaveOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public Map<EObject, AnyType> getEObjectToExtensionMap() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public Map<EObject, String> getEObjectToIDMap() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public String getEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public String getID(EObject object) {
		// JH super?
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public Map<String, EObject> getIDToEObjectMap() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public String getPublicId() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public String getSystemId() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public String getXMLVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public void load(Node node, Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	public void load(InputSource inputSource, Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	public void save(Writer writer, Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	public Document save(Document document, Map<?, ?> options, DOMHandler handler) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public void setDoctypeInfo(String publicId, String systemId) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	public void setEncoding(String encoding) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	public void setID(EObject object, String id) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	public void setUseZip(boolean useZip) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	public void setXMLVersion(String version) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public boolean useZip() {
		// TODO Auto-generated method stub
		return super.useZip();
	}
}
