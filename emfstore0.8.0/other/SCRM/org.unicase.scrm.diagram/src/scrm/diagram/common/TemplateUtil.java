package scrm.diagram.common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.metamodel.Project;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.util.WorkspaceUtil;


import scrm.SCRMDiagram;
import scrm.SCRMModelElement;
import scrm.ScrmFactory;

/**
 * @author mharut
 * 
 * Utility class to handle saving templates to and loading templates from files.
 * Any SCRMDiagram can be saved to a file (by copying it and all its elements to
 * a resource) and any already existing template can be loaded into a ECP project
 * (by copying the resource's contents into the project).<br>
 * The default directory can also be obtained by this class.
 */
final public class TemplateUtil {
	
	/**
	 * The default directory for saving and loading templates.
	 * @see #getTemplateDirectoryPath()
	 */
	private static File templateDirectory;
	
	/**
	 * Class should not be instantiated, as all methods should be accessed in 
	 * a static way.
	 */
	private TemplateUtil() {
		// nothing to do
	}
	
	/**
	 * Saves a SCRMDiagram as a template to the file specified by 
	 * <code>resourcePath</code>. To perform this operation, the diagram and 
	 * all its elements are copied to the Resource.
	 * 
	 * @param scrmDiagram the SCRMDiagram to save
	 * @param resourcePath the path to the file to save <code>scrmDiagram</code> to
	 * @see #copyElements(EditingDomain, Collection)
	 */
	public static void doSave(SCRMDiagram scrmDiagram, String resourcePath) {
		// initialize Resource to save to
		final Resource templateResource = initializeResource(resourcePath);
		
		// initialize elements that need to be saved
		Collection<EObject> elements = new ArrayList<EObject>();
		elements.add(scrmDiagram);
		elements.addAll(scrmDiagram.getElements());
		
		// copy all these elements
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(scrmDiagram);
		final Collection<EObject> copies = (Collection<EObject>) copyElements(domain, elements);
		
		// command to add the SCRMDiagram and all its elements to the resource
		new AbstractCommand() {

			public void execute() {
				templateResource.getContents().addAll(copies);
			}

			public void redo() {
				if(!templateResource.getContents().containsAll(copies)) {
					templateResource.getContents().addAll(copies);
				}
			}
			
		}.execute();
		
		// save the resource to the file system
		try {
			templateResource.save(null);
		} catch (IOException e) {
			WorkspaceUtil.logException("Saving SCRM template failed!", e);
		}
	}

	/**
	 * Loads a template from the file specified by <code>resourcePath</code>.
	 * Loading includes copying all of the template's elements to the project,
	 * initializing the SCRMDiagram and opening it.
	 * 
	 * @param project the Project to load the template into
	 * @param resourcePath the path to the template to load from
	 * @see #copyElements(EditingDomain, Collection)
	 */
	public static void doLoad(final Project project, String resourcePath) {
		// initialize Resource to load from
		Resource templateResource = initializeResource(resourcePath);
		
		// load the specified resource
		try {
			templateResource.load(null);
		} catch (IOException e) {
			WorkspaceUtil.logException("Loading SCRM template failed!", e);
		}
		
		// check if the template is valid, i.e. if it contains a SCRMDiagram
		if(!isValid(templateResource))
			throw new IllegalArgumentException("Template file is invalid!");
		
		// template file is valid -> SCRMDiagram is the first content
		SCRMDiagram resourceScrmDiagram = (SCRMDiagram) templateResource.getContents().get(0);
		
		// copy all elements from the template's SCRMDiagram
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(project);
		final Collection<SCRMModelElement> elementsCopy = (Collection<SCRMModelElement>) copyElements(domain, 
				resourceScrmDiagram.getElements());
		
		// initialize the new SCRMDiagram that shall use the template
		final SCRMDiagram newScrmDiagram = ScrmFactory.eINSTANCE.createSCRMDiagram();
		newScrmDiagram.setName(resourceScrmDiagram.getName());
		newScrmDiagram.setDescription(resourceScrmDiagram.getDescription());
		newScrmDiagram.setDiagramLayout(resourceScrmDiagram.getDiagramLayout());
				
		// run command to add elements to project and diagram
		new ECPCommand(project) {

			@Override
			protected void doRun() {
				project.addModelElement(newScrmDiagram);
				for(EObject element : elementsCopy) {
					project.addModelElement(element);
				}
				newScrmDiagram.getElements().addAll(elementsCopy);
			}
			
		}.run(true);
		
		// open the newly created SCRMDiagram in the Diagram Editor
		ActionHelper.openModelElement(newScrmDiagram, "");
		
	}
	
	/**
	 * Creates a ResourceSet and in it a Resource from the path 
	 * specified by <code>resourcePath</code>.
	 * 
	 * @param resourcePath the path to the Resource 
	 * @return the created Resource
	 */
	private static Resource initializeResource(String resourcePath) {
		ResourceSet templateSet = new ResourceSetImpl();
		URI templateUri = URI.createFileURI(resourcePath);
		return templateSet.createResource(templateUri);
	}
	
	/**
	 * Creates copies of all the EObjects specified by <code>elements</code>,
	 * including their attributes and references between them.
	 * 
	 * @param domain the EditingDomain
	 * @param elements the elements to copy
	 * @return all copied elements
	 */
	private static Collection<?> copyElements(EditingDomain domain,
			Collection<?> elements) {
		Command copyCommand = CopyCommand.create(domain, elements);
		if(copyCommand.canExecute()) {
			copyCommand.execute();
		}
		
		return copyCommand.getResult();
	}

	/**
	 * Checks whether <code>resource</code> is a valid template or not.
	 * A Resource is valid, if the first content is a SCRMDiagram.
	 * 
	 * @param resource the Resource to check
	 * @return <code>true</code> if <code>resource</code> is a valid template,<br>
	 * <code>false</code> otherwise. 
	 */
	private static boolean isValid(Resource resource) {
		if(resource.getContents().isEmpty()) {
			return false;
		}
		if(!(resource.getContents().get(0) instanceof SCRMDiagram)) {
			return false;
		}
		return true;
	}
	
	/**
	 * Obtains the absolute path to the default template directory as a sub-directory
	 * of the ECP workspace directory. If the directory doesn't exist, it's created.
	 * 
	 * @return the absolute path to the default template directory 
	 * @see Configuration#getWorkspaceDirectory()
	 */
	public static String getTemplateDirectoryPath() {
		
		if(templateDirectory == null) {
			templateDirectory = new File(Configuration.getWorkspaceDirectory() + "templates");
		}
		
		if(!templateDirectory.exists()) {
			templateDirectory.mkdirs();
		}
		
		return templateDirectory.getAbsolutePath();
	}

}
