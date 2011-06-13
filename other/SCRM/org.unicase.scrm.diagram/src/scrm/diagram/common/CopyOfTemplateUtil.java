package scrm.diagram.common;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.Project;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.Configuration;
import scrm.SCRMDiagram;
import scrm.SCRMModelElement;

/**
 * @author mharut
 * 
 * Utility class to handle saving templates to and loading templates from files.
 * Any SCRMDiagram can be saved to a file (by copying it and all its elements to
 * a resource) and any already existing template can be loaded into a ECP project
 * (by copying the resource's contents into the project).<br>
 * The default directory can also be obtained by this class.
 */
final public class CopyOfTemplateUtil {
	
	/**
	 * The default directory for saving and loading templates.
	 * @see #getTemplateDirectoryPath()
	 */
	private static File templateDirectory;
	
	/**
	 * Class should not be instantiated, as all methods should be accessed in 
	 * a static way.
	 */
	private CopyOfTemplateUtil() {
		// nothing to do
	}
	
	/**
	 * Saves a SCRMDiagram as a template to the file specified by 
	 * <code>resourcePath</code>. To perform this operation, the diagram and 
	 * all its elements are copied to the Resource.
	 * 
	 * @param scrmDiagram the SCRMDiagram to save
	 * @param resourcePath the path to the file to save <code>scrmDiagram</code> to
	 * @throws IOException if there's a reference cycle in the diagrams to save
	 * @see #copyElements(EditingDomain, Collection)
	 */
	public static void doSave(SCRMDiagram scrmDiagram, String resourcePath) throws IOException {
		// initialize Resource to save to
		final Resource templateResource = initializeResource(resourcePath);
		
		// initialize elements that need to be saved
		Collection<EObject> elements = gatherElementsToSave(scrmDiagram);
		
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
		templateResource.save(null);
	}

	private static Collection<EObject> gatherElementsToSave(
			SCRMDiagram scrmDiagram) throws IOException {
		List<EObject> allElements = new LinkedList<EObject>();
		allElements.add(scrmDiagram);
		for(EObject element : scrmDiagram.getElements()) {
			if(element instanceof SCRMDiagram) {
				if(allElements.contains(element)) {
					throw new IOException("Cycle in template detected!");
				}
				allElements.addAll(gatherElementsToSave((SCRMDiagram) element));
			} else {
				allElements.add(element);
			}
		}
		List<EObject> result = new LinkedList<EObject>(allElements);
		for(EObject element : allElements) {
			EObject container = element.eContainer();
			if(allElements.contains(container)) {
				result.remove(element);
			}
		}
		return result;
	}

	/**
	 * Loads a template from the file specified by <code>resourcePath</code>.
	 * Loading includes copying all of the template's elements to the project,
	 * initializing the SCRMDiagram and opening it.
	 * 
	 * @param project the Project to load the template into
	 * @param resourcePath the path to the template to load from
	 * @throws IOException if the template file is invalid
	 * @see #copyElements(EditingDomain, Collection)
	 */
	public static void doLoad(final Project project, String resourcePath) throws IOException {
		// initialize Resource to load from
		Resource templateResource = initializeResource(resourcePath);
		
		// load the specified resource
		templateResource.load(null);
		
		// check if the template is valid, i.e. if it contains a SCRMDiagram
		if(!isValid(templateResource))
			throw new IOException("Template file is invalid!");
		
		// template file is valid -> SCRMDiagram is the first content
//		SCRMDiagram rootScrmDiagram = (SCRMDiagram) templateResource.getContents().get(0);
		
		// copy all elements from the template's SCRMDiagram
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(project);
		final List<SCRMModelElement> elementsCopy = new LinkedList<SCRMModelElement> 
					((Collection<SCRMModelElement>) copyElements(domain, templateResource.getContents()));
		
		
		// run command to add elements to project and diagram
		new ECPCommand(project) {

			@Override
			protected void doRun() {
				project.getModelElements().addAll(elementsCopy);
			}
			
		}.run(true);
		
		// open the newly created SCRMDiagram in the Diagram Editor
		ActionHelper.openModelElement(elementsCopy.get(0), "");
		
	}
	
	private static Collection<SCRMDiagram> filterSCRMDiagrams(
			SCRMDiagram scrmDiagram) {
		List<SCRMDiagram> result = new LinkedList<SCRMDiagram>();
		result.add(scrmDiagram);
		for(EObject element : scrmDiagram.getElements()) {
			if(element instanceof SCRMDiagram) {
				result.addAll(filterSCRMDiagrams((SCRMDiagram) element));
			}
		}
		return result;
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
