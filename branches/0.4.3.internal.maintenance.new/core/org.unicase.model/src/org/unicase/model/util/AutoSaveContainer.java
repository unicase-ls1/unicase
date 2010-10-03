/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.util;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;

/**
 * Container for a containment tree of {@link EObject} with one root, that will automatically save upon any change in
 * any of the objects in the containment tree. The container will use a set of files with the given extension in the
 * given path to store the containment tree. It will also automatically adjust the size of the files to maintain an
 * adequate speed.
 * 
 * @author koegel
 * @param <T> the type of the containers root.
 */
public class AutoSaveContainer<T extends EObject> extends EContentAdapter {

	private static final int DEFAULT_MAX_FILESIZE = 50000;
	private String path;
	private final String extension;

	/**
	 * Filename of the container root.
	 */
	public static final String ROOT_FILENAME = "ROOT";
	private final EClass rootClass;
	private ResourceSet resourceSet;
	private EClass classToTrack;
	private long maxFileSize;
	private Resource currentResource;
	private boolean initialized;
	private final AutoSaveContainerExceptionHandler exceptionHandler;
	private T rootObject;

	/**
	 * Constructor.
	 * 
	 * @param rootClass the class of the root object
	 * @param path the path where to save the files of the contents to
	 * @param extension the extension of the files
	 * @param exceptionHandler handler in case of exceptions
	 */
	public AutoSaveContainer(EClass rootClass, String path, String extension,
		AutoSaveContainerExceptionHandler exceptionHandler) {
		this.rootClass = rootClass;
		this.exceptionHandler = exceptionHandler;
		if (rootClass.isAbstract()) {
			throw new IllegalArgumentException("Root Class cannot be abstract!");
		}
		this.path = path;
		if (!this.path.endsWith(File.separator)) {
			this.path = this.path + File.separator;
		}
		this.extension = extension;
		this.classToTrack = EcorePackage.eINSTANCE.getEObject();
		this.setMaxFileSize(DEFAULT_MAX_FILESIZE);
		initialized = false;
		resourceSet = new ResourceSetImpl();
	}

	/**
	 * Add initial content to the container.
	 * 
	 * @param root the root object
	 * @throws AutoSaveContainerInitilizationException if the init fails
	 */
	public void initWithRoot(T root) throws AutoSaveContainerInitilizationException {
		if (!rootClass.isInstance(root)) {
			throw new AutoSaveContainerInitilizationException("Root is not of the correct type. It should be of type "
				+ rootClass.getName());
		}
		String rootFilePath = path + ROOT_FILENAME + extension;
		File workspaceFile = new File(rootFilePath);
		if (workspaceFile.exists()) {
			throw new AutoSaveContainerInitilizationException("A resource with content already exists!");
		}
		rootObject = root;
		URI fileURI = URI.createFileURI(rootFilePath);
		Resource rootResource = resourceSet.createResource(fileURI);
		rootResource.getContents().add(root);
		TreeIterator<EObject> iterator = root.eAllContents();
		Set<Resource> resourcesToSave = new HashSet<Resource>();
		while (iterator.hasNext()) {
			EObject next = iterator.next();
			resourcesToSave.add(addToResource(next));
		}
		for (Resource resource : resourcesToSave) {
			try {
				resource.save(null);
			} catch (IOException e) {
				throw new AutoSaveContainerInitilizationException("Saving initial root failed!", e);
			}
		}
		root.eAdapters().add(this);
	}

	/**
	 * Set the class to track. Only instances of this class will be tracked and put to resources and persisted.
	 * 
	 * @param classToTrack the EClass
	 */
	public void setClassToTrack(EClass classToTrack) {
		checkForInit();
		this.classToTrack = classToTrack;
	}

	/**
	 * Set the resource set for all resources of the container.
	 * 
	 * @param resourceSet the resourceSet to set
	 */
	public void setResourceSet(ResourceSet resourceSet) {
		checkForInit();
		this.resourceSet = resourceSet;
	}

	private void checkForInit() {
		if (this.initialized) {
			throw new IllegalStateException("This method can only be called before calling init!");
		}
	}

	/**
	 * Initialize the Container. This will start the automatic saving of resources for all contents of the containment
	 * tree of the root object.
	 * 
	 * @return the root node of the container.
	 * @throws AutoSaveContainerInitilizationException if init fails
	 */
	@SuppressWarnings("unchecked")
	public T init() throws AutoSaveContainerInitilizationException {
		String rootFilePath = path + ROOT_FILENAME + extension;
		File workspaceFile = new File(rootFilePath);
		Resource rootResource;
		if (!workspaceFile.exists()) {
			URI fileURI = URI.createFileURI(rootFilePath);
			rootObject = (T) rootClass.getEPackage().getEFactoryInstance().create(rootClass);
			rootResource = resourceSet.createResource(fileURI);
			rootResource.getContents().add(rootObject);
		} else {
			rootResource = resourceSet.getResource(URI.createFileURI(rootFilePath), true);
			EList<EObject> directContents = rootResource.getContents();
			if (directContents.size() != 1) {
				throw new AutoSaveContainerInitilizationException("Root resource contains more than one root object: "
					+ rootFilePath);
			}
			rootObject = (T) directContents.get(0);
		}
		save(rootObject);
		rootObject.eAdapters().add(this);
		this.initialized = true;
		return rootObject;
	}

	private boolean needsTracking(Object object) {
		return classToTrack.isInstance(object) || rootClass.isInstance(object);
	}

	private Resource createRandomResource(ResourceSet resourceSet, String path) {
		URI fileURI = URI.createFileURI(path + UUID.randomUUID().toString() + extension);
		return resourceSet.createResource(fileURI);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		if (notification.isTouch()) {
			return;
		}
		Object notifier = notification.getNotifier();
		if (needsTracking(notifier) && notifier instanceof EObject) {
			EObject changeObject = (EObject) notifier;
			save(changeObject);
		}
	}

	private void save(EObject changeObject) {
		Resource eResource = changeObject.eResource();
		if (currentResource == null) {
			currentResource = eResource;
		}
		try {
			eResource.save(null);
		} catch (IOException e) {
			exceptionHandler.handleExceptionOnSave(changeObject, eResource, e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#addAdapter(org.eclipse.emf.common.notify.Notifier)
	 */
	@Override
	protected void addAdapter(Notifier notifier) {
		super.addAdapter(notifier);
		if (needsTracking(notifier)) {
			EObject addedObject = (EObject) notifier;
			addToResource(addedObject);
			save(addedObject);
		}
	}

	private Resource addToResource(EObject addedObject) {
		Resource oldResource = addedObject.eResource();
		if (resourceIsFull(oldResource)) {
			Resource resource;
			if (currentResource != null && !resourceIsFull(currentResource)) {
				resource = currentResource;
			} else {
				resource = createRandomResource(resourceSet, path);
				currentResource = resource;
			}
			resource.getContents().add(addedObject);
			return resource;
		}
		return oldResource;
	}

	private boolean resourceIsFull(Resource oldResource) {
		URI oldUri = oldResource.getURI();
		if (!oldUri.isFile()) {
			throw new IllegalStateException("Container contains Objects that are not part of a file resource.");
		}
		String oldFileName = oldUri.toFileString();
		return new File(oldFileName).length() > this.maxFileSize;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#removeAdapter(org.eclipse.emf.common.notify.Notifier)
	 */
	@Override
	protected void removeAdapter(Notifier notifier) {
		super.removeAdapter(notifier);
		if (needsTracking(notifier) && !isContainedInRoot(notifier)) {
			EObject removedObject = (EObject) notifier;
			Resource oldResource = removedObject.eResource();
			if (oldResource == null) {
				return;
			}
			EList<EObject> contents = oldResource.getContents();
			contents.remove(removedObject);
			if (contents.size() < 1) {
				URI oldUri = oldResource.getURI();
				if (!oldUri.isFile()) {
					throw new IllegalStateException("Container contains Objects that are not part of a file resource.");
				}
				String oldFileName = oldUri.toFileString();
				new File(oldFileName).delete();
			}
		}
	}

	private boolean isContainedInRoot(Notifier notifier) {
		if (!(notifier instanceof EObject)) {
			return false;
		}
		EObject currentObject = (EObject) notifier;
		while (currentObject.eContainer() != null) {
			currentObject = currentObject.eContainer();
		}
		return currentObject == rootObject;
	}

	/**
	 * Set the maximum file size for the resource files.
	 * 
	 * @param maxFileSize the maxFileSize to set
	 */
	public void setMaxFileSize(long maxFileSize) {
		checkForInit();
		this.maxFileSize = maxFileSize;
	}

	/**
	 * Destructs the container. Will leave the files untouched, but no longer track changes and save them.
	 */
	public void destroy() {
		rootObject.eAdapters().remove(this);
		this.classToTrack = null;
		this.currentResource = null;
		this.path = null;
		this.resourceSet = null;
		this.rootObject = null;
	}
}
