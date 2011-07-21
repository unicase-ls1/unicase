package scrm.diagram.common;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.metamodel.Project;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.Configuration;
import scrm.SCRMDiagram;

/**
 * Utility class to handle saving templates to and loading templates from files.
 * Any SCRMDiagram can be saved to a file (by copying it and all its elements to
 * a resource) and any already existing template can be loaded into a ECP project
 * (by copying the resource's contents into the project).<br>
 * This class also provides the default directory to save to and load from.
 * 
 * @author mharut
 */
public class TemplateUtil {
	
	/**
	 * The default directory for saving and loading templates.
	 * @see #getTemplateDirectoryPath()
	 */
	private File templateDirectory;
	
	/**
	 * The singleton instance.
	 */
	private static TemplateUtil instance;
	
	
	/**
	 * Class should not be instantiated, as all methods should be accessed in 
	 * a static way.
	 */
	protected TemplateUtil() {
		if(templateDirectory == null) {
			templateDirectory = new File(Configuration.getWorkspaceDirectory() + "templates");
		}
		
		if(!templateDirectory.exists()) {
			templateDirectory.mkdirs();
		}
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
		@SuppressWarnings("unchecked")
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
	
	/**
	 * Gathers all <code>EObject</code>s from a root <code>SCRMDiagram</code>
	 * that need to be saved. This is done by traversing through all
	 * elements, handling contained <code>SCRMDiagram</code>s recursively.
	 * @param scrmDiagram the root diagram to obtain elements from
	 * @return All elements that need to be saved to the template.
	 */
	protected static Collection<EObject> gatherElementsToSave(
			SCRMDiagram scrmDiagram) {
		Set<EObject> allElements = new LinkedHashSet<EObject>();
		allElements.add(scrmDiagram);
		// gather all elements recursively
		for(EObject element : scrmDiagram.getElements()) {
			if(element instanceof SCRMDiagram) {
				SCRMDiagram containedDiagram = (SCRMDiagram) element;
				// only if this diagram wasn't traversed before
				if(!allElements.contains(element)) {
					allElements.addAll(gatherElementsToSave(containedDiagram));
				}
			} else {
				allElements.add(element);
			}
		}
		// compute the actual result: at first, all elements
		Set<EObject> result = new LinkedHashSet<EObject>(allElements);
		// remove elements, whose container is contained in allElements
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
	 */
	public static void doLoad(final Project project, String resourcePath) throws IOException {
		// initialize Resource to load from
		final Resource templateResource = initializeResource(resourcePath);
		
		// load the specified resource
		templateResource.load(null);
		
		// check if the template is valid, i.e. if it contains a SCRMDiagram at the right place
		if(!isValid(templateResource))
			throw new IOException("Template file is invalid!");
		
		final Map<EObject, EObject> elementToCopy = new LinkedHashMap<EObject, EObject>(); 
			
		fillElementToCopyMap(templateResource, elementToCopy);
		
		// run command to add elements to project and diagram
		new ECPCommand(project) {

			@Override
			protected void doRun() {
				
				SCRMDiagram rootDiagram = null;
				
				for(EObject eObject: elementToCopy.values()) {
					project.addModelElement(eObject);
					if(rootDiagram == null && eObject instanceof SCRMDiagram) {
						rootDiagram = (SCRMDiagram) eObject;
					}
				}
				for(EObject originalElement : elementToCopy.keySet()) {
					updateReferences(originalElement, elementToCopy);
				}
				
				// open the newly created SCRMDiagram in the Diagram Editor
				ActionHelper.openModelElement(rootDiagram, "");
			}

			@SuppressWarnings("unchecked")
			private void updateReferences(EObject originalElement,
					Map<EObject, EObject> elementToCopy) {

				EObject copy = elementToCopy.get(originalElement);
				
				for(EReference reference : originalElement.eClass().getEAllReferences()) {
					if(reference.isContainer()) {
						continue;
					}
					if(reference.isMany()) {
						Set<EObject> objectsToSet = new LinkedHashSet<EObject>();
						for(EObject containedObject : (List<EObject>) originalElement.eGet(reference)) {
							if(elementToCopy.containsKey(containedObject)) {
								objectsToSet.add(elementToCopy.get(containedObject));
							}
						}
						copy.eSet(reference, objectsToSet);
					} else {
						EObject referencedObject = (EObject) originalElement.eGet(reference);
						if(elementToCopy.containsKey(referencedObject)) {
							copy.eSet(reference, elementToCopy.get(referencedObject));
						} else {
							copy.eUnset(reference);
						}
					}
				}
			}
			
		}.run(true);
		
	}
	
	private static void fillElementToCopyMap(
			Resource templateResource,
			Map<EObject, EObject> elementToCopy) {
		for(TreeIterator<EObject> contentsIterator = templateResource.getAllContents(); contentsIterator.hasNext();) {
			EObject templateContent = contentsIterator.next();
			EObject copy = EcoreUtil.copy(templateContent);
			elementToCopy.put(templateContent, copy);
		}
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
			return copyCommand.getResult();
		} else {
			return Collections.EMPTY_LIST;
		}
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
	public String getTemplateDirectoryPath() {
		return templateDirectory.getAbsolutePath();
	}
	
	/**
	 * Obtain the singleton instance.
	 * If not already existent, this method will create an instance.
	 * @return The singleton <code>TemplateUtil</code> instance.
	 */
	public static TemplateUtil getInstance() {
		if(instance == null) {
			instance = new TemplateUtil();
		}
		return instance;
	}

}
