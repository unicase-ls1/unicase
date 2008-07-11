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
import org.unicase.workspace.WorkspaceManager;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class MEDiagramResource extends ResourceImpl implements Resource,
		Resource.Factory, Resource.Internal, XMLResource {

	boolean initialized = false;
	MEDiagram meDiagram;
	Diagram diagram;
	EList<EObject> list;

	public MEDiagramResource() {
		super();
	}

	public MEDiagramResource(MEDiagram meDiagram) {
		super();
		this.meDiagram = meDiagram;
	}

	public void delete(Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub
	}

	public TreeIterator<EObject> getAllContents() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Overriden to return the MEDiagram and the GMF Diagram on root level.
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
		if (meDiagram.getGmfdiagram() == null) {
			String id = null;
			if(meDiagram.getType().equals(DiagramType.USECASE_DIAGRAM)){
				id="UseCase";
			}
			if(meDiagram.getType().equals(DiagramType.CLASS_DIAGRAM)){
				id="Model";
			}
			if(id==null){
				throw new RuntimeException("Unsupported diagram type");
			}
			// JH: Build switch for different diagram types
			diagram = ViewService.createDiagram(meDiagram, id,
					new PreferencesHint("org.unicase.ui.componentDiagram"));
			diagram.setElement(meDiagram);
			TransactionalEditingDomain domain = TransactionUtil
					.getEditingDomain(meDiagram);
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				protected void doExecute() {
					meDiagram.setGmfdiagram(diagram);

				}
			});
		}

	}

	public EObject getEObject(String uriFragment) {
		// TODO Auto-generated method stub
		return null;
	}

	public EList<Diagnostic> getErrors() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResourceSet getResourceSet() {
		return meDiagram.eResource().getResourceSet();
	}

	public long getTimeStamp() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Forwards the URI of unicase Resource.
	 */
	public URI getURI() {
		return meDiagram.eResource().getURI();
	}

	public String getURIFragment(EObject object) {
		String uriFragment = super.getURIFragment(object);
		return uriFragment;
	}

	public EList<Diagnostic> getWarnings() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isLoaded() {

		return meDiagram.eResource().isLoaded();
	}

	public boolean isModified() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isTrackingModification() {
		// JH has to be false, otherwise nullpointer
		return super.isTrackingModification();
	}

	public void load(Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub

	}

	public void save(Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub

	}

	public void setModified(boolean isModified) {
		// TODO Auto-generated method stub
		System.out.print("huha");

	}

	public void setTimeStamp(long timeStamp) {
		// TODO Auto-generated method stub

	}

	public void setTrackingModification(boolean isTrackingModification) {
		meDiagram.eResource().setTrackingModification(isTrackingModification);
	}

	public void setURI(URI uri) {
		// TODO Auto-generated method stub

	}

	public boolean eDeliver() {
		return meDiagram.eResource().eDeliver();
	}

	public void eNotify(Notification notification) {
		// TODO Auto-generated method stub

	}

	public void eSetDeliver(boolean deliver) {
		// TODO Auto-generated method stub

	}

	public Resource createResource(URI uri) {
		EObject object = WorkspaceManager.getInstance().getCurrentWorkspace()
				.eResource().getEObject(uri.toString());
		if (object instanceof MEDiagram) {
			return new MEDiagramResource((MEDiagram) object);
		} else {
			throw new IllegalArgumentException("Only MEDiagrams supported");
		}
	}

	public void attached(EObject object) {
		// JH Implement this?
	}

	public NotificationChain basicSetResourceSet(ResourceSet resourceSet,
			NotificationChain notifications) {

		// JH Check what this is for. This is called and maybe causes trouble
		return super.basicSetResourceSet(resourceSet, notifications);

	}

	public void detached(EObject object) {
		// TODO Auto-generated method stub

	}

	public boolean isLoading() {
		// TODO Auto-generated method stub
		return false;
	}

	public DOMHelper getDOMHelper() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<Object, Object> getDefaultLoadOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<Object, Object> getDefaultSaveOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<EObject, AnyType> getEObjectToExtensionMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<EObject, String> getEObjectToIDMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getID(EObject object) {
		// JH super?
		return null;
	}

	public Map<String, EObject> getIDToEObjectMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPublicId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSystemId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getXMLVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	public void load(Node node, Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub

	}

	public void load(InputSource inputSource, Map<?, ?> options)
			throws IOException {
		// TODO Auto-generated method stub

	}

	public void save(Writer writer, Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub

	}

	public Document save(Document document, Map<?, ?> options,
			DOMHandler handler) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDoctypeInfo(String publicId, String systemId) {
		// TODO Auto-generated method stub

	}

	public void setEncoding(String encoding) {
		// TODO Auto-generated method stub

	}

	public void setID(EObject object, String id) {
		// TODO Auto-generated method stub

	}

	public void setUseZip(boolean useZip) {
		// TODO Auto-generated method stub

	}

	public void setXMLVersion(String version) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean useZip() {
		// TODO Auto-generated method stub
		return super.useZip();
	}

}
