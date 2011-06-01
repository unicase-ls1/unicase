/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.util;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal;
import org.eclipse.emf.emfstore.client.model.WorkspaceDataInternal;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;

/**
 * Helper for resource operations.
 * 
 * @author wesendon
 */
public final class ResourceHelper {

	private ResourceHelper() {
		// blub
	}

	/**
	 * Gets an element from a resource.
	 * 
	 * @param <T>
	 *            type of element
	 * @param absoluteFileName
	 *            filepath of resource
	 * @param type
	 *            .class from type
	 * @param options
	 *            resource options
	 * @param index
	 *            index of element in resource
	 * @return selected element
	 * @throws IOException
	 *             in case of failure
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T getElementFromResource(
			String absoluteFileName, Class<T> type, Map<?, ?> options, int index)
			throws IOException {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		// Resource resource =
		// resourceSet.getResource(URI.createFileURI(absoluteFileName), false);
		Resource resource = resourceSet.createResource(URI
				.createFileURI(absoluteFileName));
		if (options != null) {
			resource.load(options);
		} else {
			resource.load(ModelUtil.getResourceLoadOptions());
		}
		EList<EObject> directContents = resource.getContents();

		// sanity check
		if (directContents.size() != 1
				&& (!type.isInstance(directContents.get(0)))) {
			throw new IOException("File is corrupt, does not contain a "
					+ type.getName() + " .");
		}

		T object = (T) directContents.get(index);
		resource.getContents().remove(object);

		return object;
	}

	/**
	 * Gets an element from a resource.
	 * 
	 * @param <T>
	 *            type of element
	 * @param absoluteFileName
	 *            filepath of resource
	 * @param type
	 *            .class from type
	 * @param index
	 *            index of element in resource
	 * @return selected element
	 * @throws IOException
	 *             in case of failure
	 */
	public static <T extends EObject> T getElementFromResource(
			String absoluteFileName, Class<T> type, int index)
			throws IOException {
		return getElementFromResource(absoluteFileName, type, null, index);
	}

	/**
	 * Puts an element into a new resource.
	 * 
	 * @param <T>
	 *            element type
	 * @param element
	 *            The element to be put
	 * @param absoluteFileName
	 *            filepath of resource
	 * @throws IOException
	 *             in case of failure
	 */
	public static <T extends EObject> void putElementIntoNewResource(
			String absoluteFileName, T element) throws IOException {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI
				.createFileURI(absoluteFileName));
		resource.getContents().add(element);
		resource.save(null);
	}

	/**
	 * Puts an element into a new resource.
	 * 
	 * @param <T>
	 *            element type
	 * @param element
	 *            The element to be put
	 * @param absoluteFileName
	 *            filepath of resource
	 * @param project
	 *            the associated project
	 * @throws IOException
	 *             in case of failure
	 */
	public static <T extends EObject> void putElementIntoNewResourceWithProject(
			String absoluteFileName, T element, Project project)
			throws IOException {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI
				.createFileURI(absoluteFileName));
		resource.getContents().add(element);

		if (resource instanceof XMIResource) {
			XMIResource xmiResource = (XMIResource) resource;
			for (EObject modelElement : project.getAllModelElements()) {
				String modelElementId = project.getModelElementId(modelElement)
						.getId();
				xmiResource.setID(modelElement, modelElementId);
			}
		}

		resource.save(null);
	}

	/**
	 * Puts an element into a new resource.
	 * 
	 * @param <T>
	 *            element type
	 * @param workSpace
	 *            the workspace to be put
	 * @param absoluteFileName
	 *            filepath of resource
	 * @throws IOException
	 *             in case of failure
	 */
	public static <T extends EObject> void putWorkspaceIntoNewResource(
			String absoluteFileName, WorkspaceDataInternal workSpace)
			throws IOException {

		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI
				.createFileURI(absoluteFileName));
		resource.getContents().add(workSpace);

		if (resource instanceof XMIResource) {
			XMIResource xmiResource = (XMIResource) resource;

			for (ProjectSpaceDataInternal projectSpace : workSpace
					.getInternalProjectSpaces()) {
				Project project = projectSpace.getProject();
				TreeIterator<EObject> it = project.eAllContents();
				while (it.hasNext()) {
					EObject modelElement = it.next();
					String modelElementId = project.getModelElementId(
							modelElement).getId();
					xmiResource.setID(modelElement, modelElementId);
				}
			}
		}

		resource.save(null);
	}
}
