/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;

/**
 * Caches a number of model elements from a project to be able to retrieve the elements by id without search.
 * 
 * @author koegel
 */
public class ModelElementCache extends ProjectAddDeleteObserver {

	private Map<ModelElementId, ModelElement> modelElementMap;

	/**
	 * Creates a cache for the given project. The cache will automatically maintain itself following changes in the
	 * project.
	 * 
	 * @param project the project of the cache.
	 */
	public ModelElementCache(Project project) {
		modelElementMap = new HashMap<ModelElementId, ModelElement>();
		TreeIterator<EObject> allContents = project.eAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (ModelPackage.eINSTANCE.getModelElement().isInstance(next)) {
				ModelElement modelElement = (ModelElement) next;
				modelElementMap.put(modelElement.getModelElementId(), modelElement);
			}
		}
		project.addProjectChangeObserver(this);
	}

	/**
	 * Returns whether the element is in the cache.
	 * 
	 * @param modelElementId the id of the element
	 * @return true if element is in cache
	 */
	public boolean contains(ModelElementId modelElementId) {
		return modelElementMap.containsKey(modelElementId);
	}

	/**
	 * Get a model element.
	 * 
	 * @param modelElementId the id of the element to get
	 * @return the model element
	 */
	public ModelElement getModelElement(ModelElementId modelElementId) {
		return modelElementMap.get(modelElementId);
	}

	/**
	 * Get all entries in the cache.
	 * 
	 * @return a set of {@link ModelElement}
	 */
	public Set<ModelElement> getEntries() {
		return new HashSet<ModelElement>(modelElementMap.values());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectAddDeleteObserver#notifyAdded(org.unicase.model.ModelElement)
	 */
	@Override
	public void notifyAdded(ModelElement modelElement) {
		this.modelElementMap.put(modelElement.getModelElementId(), modelElement);
		for (ModelElement child : modelElement.getAllContainedModelElements()) {
			this.modelElementMap.put(child.getModelElementId(), child);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectAddDeleteObserver#notifyDeleted(org.unicase.model.ModelElement)
	 */
	@Override
	public void notifyDeleted(ModelElement modelElement) {
		modelElementMap.remove(modelElement.getModelElementId());
		for (ModelElement child : modelElement.getAllContainedModelElements()) {
			modelElementMap.remove(child.getModelElementId());
		}
	}
}
