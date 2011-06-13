package scrm.diagram.common;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.LinkedHashMap;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EContentsEList.FeatureIterator;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.metamodel.Project;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.Configuration;
import scrm.SCRMDiagram;
import scrm.SCRMModelElement;
import scrm.ScrmFactory;
import scrm.ScrmPackage;
import scrm.impl.DiagramStoreException;

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
	private File templateDirectory;
	
	private static Integer UNSET_VALUE = -1;
	
	public static TemplateUtil instance = new TemplateUtil();
	
	
	/**
	 * Class should not be instantiated, as all methods should be accessed in 
	 * a static way.
	 */
	private TemplateUtil() {
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
			SCRMDiagram scrmDiagram) {
		List<EObject> allElements = new LinkedList<EObject>();
		allElements.add(scrmDiagram);
		for(EObject element : scrmDiagram.getElements()) {
			if(element instanceof SCRMDiagram) {
				if(!allElements.contains(element)) {
					allElements.addAll(gatherElementsToSave((SCRMDiagram) element));
				}
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
		final Resource templateResource = initializeResource(resourcePath);
		
		// load the specified resource
		templateResource.load(null);
		
		// check if the template is valid, i.e. if it contains a SCRMDiagram
		if(!isValid(templateResource))
			throw new IllegalArgumentException("Template file is invalid!");
		
		final Map<EObject, EObject> elementToCopy = new LinkedHashMap<EObject, EObject>(); 
			
		fillElementToCopyMap(templateResource, elementToCopy);
		
		// run command to add elements to project and diagram
		new ECPCommand(project) {

			@Override
			protected void doRun() {
				
				for(EObject eObject: elementToCopy.keySet()) {
					project.addModelElement(elementToCopy.get(eObject));
				}
				for(EObject originalElement : elementToCopy.keySet()) {
						updateReferences(originalElement, elementToCopy);
				}

			}

			private void updateReferences(EObject originalElement,
					Map<EObject, EObject> elementToCopy) {
				Map<EStructuralFeature, Object> featureToCopiedObject = new LinkedHashMap<EStructuralFeature, Object>();
				EObject copy = elementToCopy.get(originalElement);
				for(FeatureIterator<EObject> featIter = (FeatureIterator<EObject>) originalElement.eCrossReferences().iterator(); featIter.hasNext();) {
					EObject referencedObject = featIter.next();
					EStructuralFeature feature = featIter.feature();
					if(feature.isMany()) {
						if(elementToCopy.containsKey(referencedObject)) {
							if(featureToCopiedObject.containsKey(feature)) {
								((List) featureToCopiedObject.get(feature)).add(elementToCopy.get(referencedObject));
							} else {
								List<EObject> objectsToSet = new LinkedList<EObject>();
								objectsToSet.add(elementToCopy.get(referencedObject));
								featureToCopiedObject.put(feature, objectsToSet);
							}
						}
					} else {
						if(elementToCopy.containsKey(referencedObject)) {
							featureToCopiedObject.put(feature, elementToCopy.get(referencedObject));
						} else {
							featureToCopiedObject.put(feature, UNSET_VALUE);
						}
					}
				}
				for(EStructuralFeature feature : featureToCopiedObject.keySet()) {
					Object objectToSet = featureToCopiedObject.get(feature);
					if(objectToSet == UNSET_VALUE) {
						copy.eUnset(feature);
					} else {
						copy.eSet(feature, featureToCopiedObject.get(feature));
					}
				}
				
			}
			
		}.run(true);

		
		// open the newly created SCRMDiagram in the Diagram Editor
		ActionHelper.openModelElement(project.getModelElements().get(0), "");
		
	}
	
	private static void fillElementToCopyMap(
			Resource templateResource,
			Map<EObject, EObject> elementToCopy) {
		for(EObject templateContent : templateResource.getContents()) {
			EObject newElement = getCopy(templateContent, elementToCopy);
			elementToCopy.put(templateContent, newElement);
		}
	}

	private static EObject getCopy(EObject element,
			Map<EObject, EObject> elementToCopy) {
		EObject result;
		if(elementToCopy.containsKey(element)) {
			result = elementToCopy.get(element);
		} else {
			result = EcoreUtil.copy(element);
			elementToCopy.put(element, result);
		}
		return result;
	}

	private static SCRMDiagram copyDiagram(SCRMDiagram diagram) {
		SCRMDiagram diagramCopy = ScrmFactory.eINSTANCE.createSCRMDiagram();
		diagramCopy.setName(diagram.getName());
		diagramCopy.setDescription(diagram.getDescription());
		diagramCopy.setDiagramLayout(diagram.getDiagramLayout());
		return diagramCopy;
	}

	private static Collection<SCRMDiagram> filterDiagrams(
			Collection<EObject> contents) {
		List<SCRMDiagram> result = new LinkedList<SCRMDiagram>();
		for(EObject content : contents) {
			if(content instanceof SCRMDiagram) {
				result.add((SCRMDiagram) content);
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

}
