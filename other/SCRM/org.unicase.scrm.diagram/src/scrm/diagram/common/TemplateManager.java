package scrm.diagram.common;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
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
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Abstract class that provides basic functionality to
 * <ul>
 * <li>provide default templates to the user by copying
 * them from the bundle to the file system</li>
 * <li>save user-created templates to the file system</li>
 * <li>load any template from the file system into an 
 * <code>ECP Project</code></li>
 * </ul>
 * Subclasses have to implement a few methods to specify paths
 * to the original templates and the file system, to define explicitly
 * which elements should be saved in templates and what elements
 * should be opened after a template has been loaded.
 * 
 * @author mharut
 */
public abstract class TemplateManager {
	
	/**
	 * The default directory for saving and loading templates.
	 * 
	 * @see #getTemplateDirectoryPath()
	 */
	private File templateDirectory;
	
	/**
	 * The relative path the default templates should be saved to.
	 * 
	 * @see #getRelativeTemplatePath()
	 */
	private String relativeTemplatePath;
	
	/**
	 * The relative path to the predefined templates that shall be provided to the user.
	 * 
	 * @see #getRelativeFilePath()
	 */
	private final String relativeFilePath;
	
	/**
	 * The original elements from the most recent template loading process.
	 * 
	 * @see #getOriginalElements()
	 */
	private Set<EObject> originalElements;
	
	/**
	 * The copies of {@link #originalElements} from the most recent template
	 * loading process.
	 * 
	 * @see #getCopiedElements()
	 */
	private Set<EObject> copiedElements;
	
	/**
	 * The map from original elements to their copies from the most recent template
	 * loading process.
	 * 
	 * @see #getElementToCopy()
	 */
	private Map<EObject, EObject> elementToCopy;
	
	/**
	 * Sets the relative path to the template directory and initializes the handler.
	 * 
	 * @param relativeTemplatePath the relative path to the template directory
	 */
	protected TemplateManager(String relativeTemplatePath,
			String relativeFilePath) {
		this.relativeTemplatePath = relativeTemplatePath;
		this.relativeFilePath = relativeFilePath;
		init();
	}
	
	/**
	 * Initiates the handler by creating the default template directory
	 * and, if necessary, creating the predefined template files.
	 * 
	 * @see #createTemplateFiles()
	 */
	protected void init() {
		
		// create the template directory if necessary
		if(templateDirectory == null) {
			templateDirectory = new File(getTemplateDirectoryPath());
		}
		if(!templateDirectory.exists()) {
			templateDirectory.mkdirs();
		}
		
		try {
			// add all predefined templates to the file system that not already exist
			createTemplateFiles();
		} catch (IOException e) {
			WorkspaceUtil.logException("Failed to create template files", e);
		}
	}

	/**
	 * Creates all predefined template files that do not already exist, if there
	 * is a directory to save them to. The templates are copied beginning from a
	 * root file that is obtained by {@link #getRootTemplateFile()}. The file structure
	 * is maintained, i.e. directories are created if necessary.
	 * 
	 * @throws IOException if creation of any of the templates fails
	 */
	protected void createTemplateFiles() throws IOException {
		
		if(templateDirectory == null) {
			// no directory to copy to
			return;
		}
		
		File rootFile = getRootTemplateFile();
		if(rootFile == null) {
			// no template to copy
			return;
		}
		
		if(rootFile.isDirectory()) {
			// root is directory -> copy subfiles as well
			copyDirectoryContents(rootFile);
		} else {
			// root is a plain file -> only copy this file
			copyTemplate(rootFile);
		}
	}

	/**
	 * Obtains the root file that shall be copied to the template directory.
	 * 
	 * @return The root file of the copying process or <br>
	 * <code>null</code> if there are no files that shall be copied.
	 */
	protected abstract File getRootTemplateFile();
	
	/**
	 * Copy all of <code>parentFile</code>'s contained files (and all their contained
	 * files recursively) to the default template directory.
	 *  
	 * @param parentFile the parent file initiating the copying process
	 * @throws IOException if creating any of the template files fails
	 */
	private void copyDirectoryContents(File parentFile) throws IOException {
		
		File[] templateFiles = parentFile.listFiles();
		
		// for all contained files..
		for(int i=0; i<templateFiles.length; i++) {
			
			File childFile = templateFiles[i];
			if(childFile.isDirectory()) {
				// file is directory -> create directory and copy contents
				createTemplateDirectory(childFile);
				copyDirectoryContents(childFile);
			} else {
				// file is plain file -> only copy it
				copyTemplate(childFile);
			}
		}
	}

	/**
	 * Copies a certain directory to the template path specified
	 * by {@link #getTemplateDirectoryPath()}. Does nothing if <code>fileToCopy
	 * </code> is not a directory, of if the directory already exists in the
	 * file system.
	 * 
	 * @param file the directory that shall be created in the file system  
	 * @throws IOException if creation of the directory fails
	 */
	private void createTemplateDirectory(File file) throws IOException {
		
		if(!file.isDirectory()) {
			// original file is no directory -> no directory to be created
			return;
		}
		
		String path = getTemplatePath(file);
		File copy = new File(path);
		
		// create the directory if not already existent
		if(!copy.exists()) {
			copy.mkdir();
		}
	}

	/**
	 * Copies an existing template to the corresponding path in the file system.
	 * Does nothing if the template already exists in the specified path
	 * or the original file is a directory.
	 * 
	 * @param template the template that shall be copied
	 * @throws IOException if creating the template's copy fails
	 */
	private void copyTemplate(File template) throws IOException {
		
		String path = getTemplatePath(template); 
		File templateCopy = new File(path);
		
		// don't replace files or copy directories here
		if(templateCopy.exists()) {
			return;
		} else if (template.isDirectory()) {
			return;
		}
		
		// initialize copying process
		FileReader reader = new FileReader(template);
		FileWriter writer = new FileWriter(templateCopy);
		int copy;
		
		// perform the copying
		while((copy = reader.read()) > -1) {
			writer.write(copy);
		}
		
		// close the streams 
		reader.close();
		writer.close();
		
	}
	
	/**
	 * Returns the path a template file is supposed to be copied to. This is the
	 * path to the corresponding copy of <code>file</code>'s parent directory.
	 * 
	 * @param file the original template file to receive the path to copy to for
	 * @return the path in the file system the file shall be copied to
	 * @throws IOException if receiving the path fails
	 */
	protected String getTemplatePath(File file) throws IOException {

		String originalPath = file.getCanonicalPath();
		
		// path of original file is cut after the relative template path
		int cutAt = originalPath.indexOf(relativeTemplatePath) + relativeTemplatePath.length();
		
		// path to copy to = default path + (original path after relative template path)
		return getTemplateDirectoryPath() + originalPath.substring(cutAt);
	}

	/**
	 * Saves a rootEObject as a template to the file specified by 
	 * <code>resourcePath</code>. To perform this operation, all elements that require
	 * saving are gathered by {@link #gatherElementsToSave(EObject)} and afterwards
	 * saved to the file system using EMF's <code>Resource</code>s 
	 * 
	 * @param rootEObject the EObject the saving process is initiated from
	 * @param resourcePath the path to the file to save the template to
	 * @see #gatherElementsToSave(EObject)
	 * @see #copyElements(EditingDomain, Collection)
	 */
	public void doSave(EObject rootEObject, String resourcePath) {
		
		// initialize resource to save to
		final Resource templateResource = initializeResource(resourcePath);
		
		// initialize elements that need to be saved
		Collection<EObject> elements = gatherElementsToSave(rootEObject);
		
		// copy all these elements
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(rootEObject);
		@SuppressWarnings("unchecked")
		final Collection<EObject> copies = (Collection<EObject>) copyElements(domain, elements);
		
		// create and execute command to add all copied elements to the resource
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
			WorkspaceUtil.logException("Template resource couldn't be saved", e);
		}
	}
	
	/**
	 * Gather all elements that require saving to the template from
	 * the provided root EObject and return it as a collection.
	 * This method is supposed to be implemented by subclasses.
	 * @param rootEObject the root object to obtain elements from
	 * @return All elements that need to be saved to the template.
	 */
	protected abstract Collection<EObject> gatherElementsToSave(EObject rootEObject);

	/**
	 * Loads a template from the file specified by <code>resourcePath</code>.
	 * Loading includes copying all of the template's elements (references included) 
	 * to <code>project</code> and opening all elements as specified by
	 * {@link #getElementsToOpen()}. The loading process also sets the collections
	 * {@link #originalElements} and {@link #copiedElements} as well as the 
	 * {@link #elementToCopy} map.
	 * 
	 * @param project the Project to copy the template's contents into
	 * @param resourcePath the path specifying the template to load from
	 * @throws IOException if the template file is invalid
	 * @see #fillElementToCopyMap(Resource)
	 */
	public void doLoad(final Project project, String resourcePath) throws IOException {
		
		// initialize Resource to load from
		final Resource templateResource = initializeResource(resourcePath);
		
		// load the specified resource
		templateResource.load(null);
		
		if(!isValid(templateResource)) {
			// prohibit invalid templates
			throw new IOException("Template file is invalid!");
		}
		
		// initialize/replace fields
		originalElements = new LinkedHashSet<EObject>();
		copiedElements = new LinkedHashSet<EObject>();
		elementToCopy = new LinkedHashMap<EObject, EObject>();
		
		// copy elements and put them in the map
		fillElementToCopyMap(templateResource);
		
		// create and run command to add copies to project and resolve references 
		new ECPCommand(project) {

			@Override
			protected void doRun() {
				
				// add all copies to the project
				for(EObject eObject: elementToCopy.values()) {
					project.addModelElement(eObject);
				}
				
				// update all references between the copies
				for(EObject originalElement : elementToCopy.keySet()) {
					updateReferences(originalElement);
				}
				
				// open all specified elements
				for(EObject eObject : getElementsToOpen()) {
					ActionHelper.openModelElement(eObject, "");
				}
			}

		}.run(true);
		
	}
	
	/**
	 * Returns all the elements that shall be opened after loading a template.
	 * These elements should be somehow retrieved from {@link #copiedElements}.

	 * @return All elements that shall be opened as a collection.
	 */
	protected abstract Collection<EObject> getElementsToOpen();
	
	/**
	 * Copies all of <code>resource</code>'s contents, adds all contents to
	 * {@link #originalElements}, all copies to {@link #copiedElements} and maps every
	 * content to its copy in {@link #elementToCopy}.
	 * 
	 * @param resource the <code>Resource</code> to copy the contents from
	 */
	protected void fillElementToCopyMap(Resource resource) {
		
		for(Iterator<EObject> it = resource.getAllContents(); it.hasNext();) {
			// obtain original element
			EObject templateContent = it.next();
			originalElements.add(templateContent);
			
			// copy it (note: references excluded on purpose, they are updated later)
			EObject copy = EcoreUtil.copy(templateContent);
			copiedElements.add(copy);
			
			// add it to the map
			elementToCopy.put(templateContent, copy);
		}
	}
	
	/**
	 * Updates all references of the copy corresponding to <code>originalElement</code>.
	 * To update the references, all references of <code>originalElement</code> are
	 * traversed and replaced by their corresponding copies. This includes containment
	 * references. Referenced objects that don't appear in the <code>elementToCopy</code>
	 * map are ignored.
	 * 
	 * @param originalElement the element whose copy's references shall be updated
	 * @param elementToCopy the map mapping originals to copies
	 */
	@SuppressWarnings("unchecked")
	protected void updateReferences(EObject originalElement) {

		// obtain the corresponding copy
		EObject copy = elementToCopy.get(originalElement);
		
		for(EReference reference : originalElement.eClass().getEAllReferences()) {
			// ignore container references, they are covered by containment references
			if(reference.isContainer()) {
				continue;
			}
			
			if(reference.isMany()) {
				Set<EObject> objectsToSet = new LinkedHashSet<EObject>();
				// add all elements that are both referenced and copied
				for(EObject containedObject : (Collection<EObject>) originalElement.eGet(reference)) {
					if(elementToCopy.containsKey(containedObject)) {
						objectsToSet.add(elementToCopy.get(containedObject));
					}
				}
				copy.eSet(reference, objectsToSet);
			} else {
				EObject referencedObject = (EObject) originalElement.eGet(reference);
				// set the reference only if the referenced object was copied as well
				if(elementToCopy.containsKey(referencedObject)) {
					copy.eSet(reference, elementToCopy.get(referencedObject));
				} else {
					copy.eUnset(reference);
				}
			}
		}
	}
	
	/**
	 * Creates a resource in a new resource set from the path 
	 * specified by <code>resourcePath</code>.
	 * 
	 * @param resourcePath the path to the <code>Resource</code> 
	 * @return the created <code>Resource</code>
	 */
	private static Resource initializeResource(String resourcePath) {
		ResourceSet templateSet = new ResourceSetImpl();
		URI templateUri = URI.createFileURI(resourcePath);
		return templateSet.createResource(templateUri);
	}
	
	/**
	 * Creates copies of all the <code>EObject</code>s specified by <code>elements</code>,
	 * including their attributes and references between them.
	 * 
	 * @param domain the elements' <code>EditingDomain</code>
	 * @param elements the elements that shall be copied
	 * @return all copied elements as a collection
	 */
	protected Collection<?> copyElements(EditingDomain domain,
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
	 * This method is supposed to be extended in subclasses.
	 * 
	 * @param resource the <code>Resource</code> to check
	 * @return <code>true</code> if <code>resource</code> is a valid template,<br>
	 * <code>false</code> otherwise. 
	 */
	protected boolean isValid(Resource resource) {
		if(resource.getContents().isEmpty()) {
			return false;
		}
		return true;
	}
	
	/**
	 * Obtains the absolute path to the default template directory as a 
	 * sub-directory of the ECP workspace directory. If the directory
	 * doesn't exist, it is created.
	 * 
	 * @return the absolute path to the default template directory 
	 * @see Configuration#getWorkspaceDirectory()
	 */
	public String getTemplateDirectoryPath() {
		return Configuration.getWorkspaceDirectory() + relativeTemplatePath;
	}
	
	/**
	 * Returns the relative path to which templates shall be saved to or loaded from by default.
	 * The absolute path to the directory can be received by {@link #getTemplateDirectoryPath()}.
	 * 
	 * @return the relative path of the template directory
	 * @see #getTemplateDirectoryPath()
	 */
	public final String getRelativeTemplatePath() {
		return relativeTemplatePath;
	}
	
	/**
	 * Returns the relative path to the file or directory that shall be provided to the user.
	 * 
	 * @return the relative path to the predefined template(s)
	 */
	public final String getRelativeFilePath() {
		return relativeFilePath;
	}
	
	/**
	 * Returns all of the original elements that were loaded in the most recent loading process.
	 * Will return an empty set if no loading process has taken place yet.
	 * 
	 * @return all original elements from the last loading process as a set
	 */
	public final Set<EObject> getOriginalElements() {
		if(originalElements==null) {
			return Collections.emptySet();
		}
		return originalElements;
	}
	
	/**
	 * Returns all copies of the original elements that were loaded in the most recent loading process.
	 * Will return an empty set if no loading process has taken place yet.
	 * 
	 * @return all copies from the last loading process as a set
	 */
	public final Set<EObject> getCopiedElements() {
		if(copiedElements == null) {
			return Collections.emptySet();
		}
		return copiedElements;
	}
	
	/**
	 * Returns the mapping from original elements to copies from the most recent loading process.
	 * Will return an empty map if no loading process has taken place yet.
	 * 
	 * @return the map from original elements to their copies
	 */
	public final Map<EObject, EObject> getElementToCopy() {
		if(elementToCopy == null) {
			return Collections.emptyMap();
		}
		return elementToCopy;
	}

}
