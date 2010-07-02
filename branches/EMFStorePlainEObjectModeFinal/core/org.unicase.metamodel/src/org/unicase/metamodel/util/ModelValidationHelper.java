/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.unicase.metamodel.Project;

/**
 * Helps with the validation of EMF models.
 * 
 * @author koegel
 */
public final class ModelValidationHelper {

	/**
	 * Private constructor.
	 */
	private ModelValidationHelper() {
		// nothing to do
	}

	/**
	 * Find dangling references in a resource.
	 * 
	 * @param resource the resource
	 * @return a list of dangling objects that are referenced but not contained in any resource
	 */
	public static List<EObject> findDanglingEObjects(Resource resource) {
		List<EObject> result = new ArrayList<EObject>();

		Iterator<EObject> allContentIterator = resource.getAllContents();
		while (allContentIterator.hasNext()) {
			EObject next = allContentIterator.next();
			EList<EObject> crossReferences = next.eCrossReferences();
			// check if all cross referenced objects are contained in a resource
			for (EObject crossReference : crossReferences) {
				if (crossReference.eResource() == null) {
					// dangling eobject found => add to result
					result.add(crossReference);
				}
			}
		}

		return result;
	}

	/**
	 * Check project for dangling references and fix them.
	 * 
	 * @param project the project (must be contained in a resource)
	 * @return false if no problems were found and nothing was fixed, true otherwise
	 */
	public static boolean checkAndFixProject(Project project) {
		if (project.eResource() == null) {
			throw new IllegalArgumentException("The given project is not contained in a resource.");
		}
		List<EObject> danglingEObjects = findDanglingEObjects(project);
		boolean result = false;
		if (danglingEObjects.size() > 0) {
			// FIXME MK: add log messages
			for (EObject object : danglingEObjects) {
				// TODO: EMFPlainEObjectTransition: ModelElement class check
				// if it is a lost model element add to project
				// if (object instanceof ModelElement) {
				project.addModelElement(object);
				result = true;
				// }
				// else add to resource
				// else {
				// Resource resource = project.eResource();
				// resource.getContents().add(object);
				// result = true;
				// }
			}
		}
		return result;
	}

	/**
	 * Find dangling references in a project.
	 * 
	 * @param project the project
	 * @return a list of dangling objects that are referenced but not contained in any resource
	 */
	public static List<EObject> findDanglingEObjects(Project project) {
		List<EObject> result = new ArrayList<EObject>();
		EList<EObject> allModelElements = project.getAllModelElements();
		for (EObject modelElement : allModelElements) {
			EList<EObject> crossReferences = modelElement.eCrossReferences();
			// check if all cross referenced objects are contained in a resource
			for (EObject crossReference : crossReferences) {
				if (crossReference.eResource() == null) {
					// dangling eobject found => add to result
					result.add(crossReference);
				}
			}
		}
		return result;
	}

}
