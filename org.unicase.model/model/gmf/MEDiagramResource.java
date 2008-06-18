package org.unicase.model.diagram.part;

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
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.unicase.model.classes.Class;
import org.unicase.model.classes.ClassesFactory;
import org.unicase.model.diagram.DiagramFactory;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.diagram.edit.parts.ModelEditPartFactory;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;


public class MEDiagramResource extends ResourceImpl implements Resource , Resource.Factory, Resource.Internal, XMLResource{

	ResourceSet resourceSet;
	boolean initialized = false;
	public void delete(Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub

	}

	public TreeIterator<EObject> getAllContents() {
		// TODO Auto-generated method stub
		return null;
	}

	public EList<EObject> getContents() {
		if(!initialized){
			initialize();
			initialized=true;
		}
	
		
		return super.getContents();
	}

	private void initialize() {
		Class class1 = ClassesFactory.eINSTANCE.createClass();
		class1.setName("Max");
		
		MEDiagram meDiagram = DiagramFactory.eINSTANCE.createMEDiagram();
		meDiagram.getElements().add(class1);
		Workspace workspace = WorkspaceManager.getInstance()
		.getCurrentWorkspace();
//		workspace.getProjectSpaces().get(0).getProject().addModelElement(meDiagram);
//		workspace.getProjectSpaces().get(0).getProject().addModelElement(fr);
		//JH: Check why isnt it MEDiagram
		Diagram diagram = ViewService.createDiagram(
				meDiagram,"Model",
				ModelDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		super.getContents().add(diagram);
		super.getContents().add(meDiagram);
//		super.getContents().add(class1);
		diagram.setElement(meDiagram);
	
	
//		meDiagram.setGmfdiagram(diagram);
		
//		EList<EObject> list = new BasicEList<EObject>();
//		list.add(diagram);
		ResourceSet resourceSet = 	this.getResourceSet();
		TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);
//		TransactionalEditingDomain transactionalEditingDomain = TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(resourceSet);
		
		
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
		if (resourceSet==null){
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

	public long getTimeStamp() {
		// TODO Auto-generated method stub
		return 0;
	}

	public URI getURI() {
		return URI.createDeviceURI("URI");
	}

	public String getURIFragment(EObject object) {
		return "URI-Fragment";
	}

	public EList<Diagnostic> getWarnings() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isLoaded() {
		
		return true;
	}

	public boolean isModified() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isTrackingModification() {
		// TODO Auto-generated method stub
		return false;
	}

	public void load(Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub

	}

	

	public void save(Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub

	}

	

	public void setModified(boolean isModified) {
		// TODO Auto-generated method stub

	}

	public void setTimeStamp(long timeStamp) {
		// TODO Auto-generated method stub

	}

	public void setTrackingModification(boolean isTrackingModification) {
		// TODO Auto-generated method stub

	}

	public void setURI(URI uri) {
		// TODO Auto-generated method stub

	}



	

	public boolean eDeliver() {
		// TODO Auto-generated method stub
		return false;
	}

	public void eNotify(Notification notification) {
		// TODO Auto-generated method stub

	}

	public void eSetDeliver(boolean deliver) {
		// TODO Auto-generated method stub

	}

	public Resource createResource(URI uri) {
		return new MEDiagramResource();
	}

	public void attached(EObject object) {
		// TODO Auto-generated method stub
		
	}

	public NotificationChain basicSetResourceSet(ResourceSet resourceSet,
			NotificationChain notifications) {
		// TODO Auto-generated method stub
		return null;
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
		return "MyID";
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
