/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.diagram;

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
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.diagram.impl.DiagramLoadException;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

// dengler: review
/**
 * @author Helming, denglerm
 */
public class MEDiagramResource extends ResourceImpl implements Resource, Resource.Factory, Resource.Internal,
	XMLResource {

	private boolean initialized;
	private MEDiagram meDiagram;
	private Diagram diagram;
	private EList<EObject> list;

	/**
	 * Constructor.
	 */
	public MEDiagramResource() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param meDiagram MEDiagram
	 */
	public MEDiagramResource(MEDiagram meDiagram) {
		super();
		this.meDiagram = meDiagram;
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
	 * Overriden to return the MEDiagram and the GMF Diagram on root level.
	 * 
	 * @return MEDiagram and the GMF Diagram on root level
	 */
	@Override
	public EList<EObject> getContents() {
		if (!initialized) {
			initialize();
			list = new BasicEList<EObject>();
			list.add(meDiagram);
			list.add(meDiagram.getGmfdiagram());
			initialized = true;
		}
		return list;
	}

	private void initialize() {

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				try {
					meDiagram.loadDiagramLayout();
				} catch (DiagramLoadException e) {
					if (!(e.getCause() instanceof NullPointerException)) {
						WorkspaceUtil.logException("Loading diagram layout failed", e);
					}
				}
			}
		}.run();
		if (meDiagram.getGmfdiagram() == null) {
			createNewGMFDiagram();

		}

	}

	private void createNewGMFDiagram() {
		String id = null;
		id = meDiagram.getType();

		if (id == null) {
			throw new RuntimeException("Unsupported diagram type");
		}
		// JH: Build switch for different diagram types
		diagram = ViewService.createDiagram(meDiagram, id, new PreferencesHint("org.unicase.ui.stateDiagram"));
		diagram.setElement(meDiagram);
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				meDiagram.setGmfdiagram(diagram);
			}
		}.run();
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
		if (meDiagram.eResource() != null) {
			return meDiagram.eResource().getResourceSet();
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
		if (meDiagram.eResource() != null) {
			return meDiagram.eResource().getURI();
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

		return meDiagram.eResource().isLoaded();
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
		meDiagram.eResource().setTrackingModification(isTrackingModification);
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
		return meDiagram.eResource().eDeliver();
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
		if (object instanceof MEDiagram) {
			return new MEDiagramResource((MEDiagram) object);
		} else {
			throw new IllegalArgumentException("Only MEDiagrams supported");
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
