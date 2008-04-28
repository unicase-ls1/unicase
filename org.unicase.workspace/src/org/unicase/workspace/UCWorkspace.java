package org.unicase.workspace;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.unicase.model.Project;
import org.unicase.model.ProjectId;

public class UCWorkspace {
	
	private PrimaryVersionSpec baseVersion;
	private ProjectId projectId;
	private SessionId sessionId;
	
	private Resource resource;
	private UCConnectionManager connectionManager;
	
	
	
	public UCWorkspace(SessionId sessionId, ProjectId projectId,
			PrimaryVersionSpec version, Resource resource, UCConnectionManager connectionManager) {
		this.sessionId=sessionId;
		this.projectId=projectId;
		this.baseVersion=version;
		this.resource=resource;
		this.connectionManager=connectionManager;
	}

	public void update(PrimaryVersionSpec primaryVersionSpec) {
		
	}
	
	public void commit() {
		throw new NoSuchMethodError();
	}
	
	public void revert() {
		
	}
	
	public Project getProject() {
		 EList<EObject> directContents = resource.getContents();
		    
		    for (EObject obj:directContents){
		      if (obj instanceof Project){
		        return (Project)obj;
		      }
		    }
		return null;
	}
	
	
	//dummy methods
	 private Project loadProject(String path)
	  {
	    //TODO: returns the first project instance in the model up to now - this behavior should be reviewed
	    ResourceSet resourceSet = new ResourceSetImpl();
	    URI fileURI = URI.createFileURI(path);
	    Resource ecoreResource = resourceSet.getResource(fileURI, true);
	    
	    EList<EObject> directContents = ecoreResource.getContents();
	    
	    for (EObject obj:directContents){
	      if (obj instanceof Project){
	        return (Project)obj;
	      }
	    }
	    return null;
	  }

	  private void saveProject(Project p, String path)
	  {
	    // create new resource to save the model into
	    ResourceSet resourceSet = new ResourceSetImpl();
//	    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
//	      "*", new  XMLResourceFactoryImpl());
	    URI resourceURI = URI.createFileURI(path);
	    Resource ecoreResource = resourceSet.createResource(resourceURI);
	    // add root element of the model to the resource
	    ecoreResource.getContents().add(p);

	    // save the resource
	    Map<Object, Object> saveOptions = new HashMap<Object, Object>();
	    saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
	    try
	    {
	      ecoreResource.save(saveOptions);
	    }
	    catch (IOException e)
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	  }

	 
	
	
}
