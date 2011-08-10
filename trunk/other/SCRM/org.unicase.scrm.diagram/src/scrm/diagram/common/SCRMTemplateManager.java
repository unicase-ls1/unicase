package scrm.diagram.common;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.Bundle;
import org.unicase.workspace.util.WorkspaceUtil;

import scrm.SCRMDiagram;


/**
 * Extension to manage providing, saving and loading SCRM templates. Default
 * templates are copied from {@link #relativeTemplatePath} in the bundle
 * to the corresponding path in the file system. A different path can be specified by
 * creating new instances with {@link #SCRMTemplateManager(String, String)}. To save an 
 * <code>SCRMDiagram</code>, all its elements and sub-diagrams are added to the
 * template. Loading a template will open all <code>SCRMDiagram</code>s
 * contained in the template.
 * 
 * @author mharut
 */
public class SCRMTemplateManager extends TemplateManager {
	
	/**
	 * The relative template path used by this template manager.
	 */
	public static final String relativeTemplatePath = "SCRMTemplates";
	
	public static final String[] templateFileExtensions = {".scrm"};
	
	/**
	 * Default constructor, uses {@link #relativeTemplatePath} as both, template directory
	 * and relative path to the predefined templates. 
	 */
	public SCRMTemplateManager() {
		super(relativeTemplatePath, relativeTemplatePath);
	}
	
	/**
	 * Uses <code>relativeTemplatePath</code> as the relative path to the template
	 * directory and <code>relativeFilePath</code> to specify a file or directory
	 * in the org.unicase.scrm.diagram bundle to provide to the user.
	 * 
	 * @param relativeTemplatePath the template directory's relative path
	 * @param relativeFilePath the relative path in the bundle to the template file 
	 */
	public SCRMTemplateManager(String relativeTemplatePath, String relativeFilePath) {
		super(relativeTemplatePath, relativeFilePath);
	}

	/**
	 * Returns the directory in the scrm.diagram bundle specified by
	 * {@link #getRelativeTemplatePath()}. Returns null if the file doesn't exist.
	 * 
	 * @see scrm.diagram.common.TemplateManager#getRootTemplateFile()
	 */
	@Override
	protected File getRootTemplateFile() {
		
		// obtain the file by searching the bundle
		Bundle bundle = Platform.getBundle("org.unicase.scrm.diagram");
		URL templateURL = bundle.getEntry("/" + getRelativeFilePath());
		if(templateURL == null) {
			// no specified file
			return null;
		}
		try {
			// locate the file and return it
			return new File(FileLocator.toFileURL(templateURL).toURI());
		} catch (URISyntaxException e) {
			WorkspaceUtil.logException("Failed to locate SCRM template files", e);
		} catch (IOException e) {
			WorkspaceUtil.logException("Failed to locate SCRM template files", e);
		}
		// locating the file failed
		return null;
	}

	
	/**
	 * Gathers all <code>EObject</code>s from a root <code>SCRMDiagram</code>
	 * that need to be saved. This is done by traversing through all
	 * elements, handling contained <code>SCRMDiagram</code>s recursively.
	 * 
	 * @see scrm.diagram.common.TemplateManager#getElementsToSave(EObject)
	 */
	@Override
	protected Collection<EObject> getElementsToSave(EObject rootEObject) {
		
		if(!(rootEObject instanceof SCRMDiagram)) {
			// cannot save other templates than SCRM templates
			throw new IllegalArgumentException("Object to save has to be of type SCRMDiagram");
		}
		
		SCRMDiagram scrmDiagram = (SCRMDiagram) rootEObject;
		Set<EObject> allElements = new LinkedHashSet<EObject>();
		allElements.add(scrmDiagram);
		
		// gather all elements recursively
		for(EObject element : scrmDiagram.getElements()) {
			if(element instanceof SCRMDiagram) {
				SCRMDiagram containedDiagram = (SCRMDiagram) element;
				// only if this diagram wasn't traversed before
				if(!allElements.contains(element)) {
					allElements.addAll(getElementsToSave(containedDiagram));
				}
			} else {
				allElements.add(element);
			}
		}
		// compute the actual result: at first, all elements
		Set<EObject> result = new LinkedHashSet<EObject>(allElements);
		
		// remove elements, whose container is contained in allElements (they appear anyways)
		for(EObject element : allElements) {
			EObject container = element.eContainer();
			if(allElements.contains(container)) {
				result.remove(element);
			}
		}
		return result;
	}

	/**
	 * Returns all <code>SCRMDiagram</code>s that were loaded into the project.
	 * 
	 * @see scrm.diagram.common.TemplateManager#getElementsToOpen()
	 */
	@Override
	protected List<EObject> getElementsToOpen() {
		
		List<EObject> result = new LinkedList<EObject>();
		// add all SCRMDiagrams that were copied
		for(EObject eObject : getCopiedElements()) {
			if(eObject instanceof SCRMDiagram) {
				result.add(eObject);
			}
		}
		return result;
	}

	@Override
	public String[] getTemplateFileExtensions() {
		return templateFileExtensions;
	}
	
}
