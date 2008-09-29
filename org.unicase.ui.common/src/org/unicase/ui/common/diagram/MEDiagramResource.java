/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.common.diagram;

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
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.unicase.model.diagram.DiagramType;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.diagram.impl.DiagramLoadException;
import org.unicase.workspace.WorkspaceManager;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/**
 * 
 * @author Helming
 * 
 */
public class MEDiagramResource extends ResourceImpl implements Resource,
		Resource.Factory, Resource.Internal, XMLResource {

	private boolean initialized;
	private MEDiagram meDiagram;
	private Diagram diagram;
	private EList<EObject> list;

	/**
	 * . Constructor
	 */
	public MEDiagramResource() {
		super();
	}

	/**
	 * . Constructor
	 * 
	 * @param meDiagram
	 *            MEDiagram
	 */
	public MEDiagramResource(MEDiagram meDiagram) {
		super();
		this.meDiagram = meDiagram;
	}

	/**
	 * . {@inheritDoc}
	 */
	public void delete(Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * . {@inheritDoc}
	 */
	public TreeIterator<EObject> getAllContents() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Overriden to return the MEDiagram and the GMF Diagram on root level.
	 * 
	 * @return MEDiagram and the GMF Diagram on root level
	 */
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
	
		TransactionalEditingDomain domain = TransactionUtil
				.getEditingDomain(meDiagram);
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				try {
					meDiagram.loadDiagramLayout();
				} catch (DiagramLoadException e) {
					// JH Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		if (meDiagram.getGmfdiagram() == null) {
			createNewGMFDiagram();

		}

	}

	private void createNewGMFDiagram() {
		String id = null;
		if (meDiagram.getType().equals(DiagramType.USECASE_DIAGRAM)) {
			id = "UseCase";
		}
		if (meDiagram.getType().equals(DiagramType.CLASS_DIAGRAM)) {
			id = "Model";
		}
		if (meDiagram.getType().equals(DiagramType.COMPONENT_DIAGRAM)) {
			id = "Component";
		}
		if (id == null) {
			throw new RuntimeException("Unsupported diagram type");
		}
		// JH: Build switch for different diagram types
		diagram = ViewService.createDiagram(meDiagram, id, new PreferencesHint(
				"org.unicase.ui.componentDiagram"));
		diagram.setElement(meDiagram);
		TransactionalEditingDomain domain = TransactionUtil
				.getEditingDomain(meDiagram);
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				meDiagram.setGmfdiagram(diagram);

			}
		});
	}

	/**
	 * . {@inheritDoc}
	 */
	public EObject getEObject(String uriFragment) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public EList<Diagnostic> getErrors() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public ResourceSet getResourceSet() {
		return meDiagram.eResource().getResourceSet();
	}

	/**
	 * . {@inheritDoc}
	 */
	public long getTimeStamp() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Forwards the URI of unicase Resource.
	 * 
	 * @return returns URI
	 */
	public URI getURI() {
		return meDiagram.eResource().getURI();
	}

	/**
	 * . {@inheritDoc}
	 */
	public String getURIFragment(EObject object) {
		String uriFragment = super.getURIFragment(object);
		return uriFragment;
	}

	/**
	 * . {@inheritDoc}
	 */
	public EList<Diagnostic> getWarnings() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public boolean isLoaded() {

		return meDiagram.eResource().isLoaded();
	}

	/**
	 * . {@inheritDoc}
	 */
	public boolean isModified() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * . {@inheritDoc}
	 */
	public boolean isTrackingModification() {
		// JH has to be false, otherwise nullpointer
		return super.isTrackingModification();
	}

	/**
	 * . {@inheritDoc}
	 */
	public void load(Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	public void save(Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	public void setModified(boolean isModified) {
		// TODO Auto-generated method stub
		System.out.print("huha");

	}

	/**
	 * . {@inheritDoc}
	 */
	public void setTimeStamp(long timeStamp) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	public void setTrackingModification(boolean isTrackingModification) {
		meDiagram.eResource().setTrackingModification(isTrackingModification);
	}

	/**
	 * . {@inheritDoc}
	 */
	public void setURI(URI uri) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	public boolean eDeliver() {
		return meDiagram.eResource().eDeliver();
	}

	/**
	 * . {@inheritDoc}
	 */
	public void eNotify(Notification notification) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	public void eSetDeliver(boolean deliver) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	public Resource createResource(URI uri) {
		Resource resource = WorkspaceManager.getInstance()
				.getCurrentWorkspace().eResource();
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
	public void attached(EObject object) {
		// JH Implement this?
	}

	/**
	 * . {@inheritDoc}
	 */
	public NotificationChain basicSetResourceSet(ResourceSet resourceSet,
			NotificationChain notifications) {

		// JH Check what this is for. This is called and maybe causes trouble
		return super.basicSetResourceSet(resourceSet, notifications);

	}

	/**
	 * . {@inheritDoc}
	 */
	public void detached(EObject object) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
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
	public void load(InputSource inputSource, Map<?, ?> options)
			throws IOException {
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
	public Document save(Document document, Map<?, ?> options,
			DOMHandler handler) {
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
