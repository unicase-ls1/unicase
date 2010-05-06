/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.util;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.UUID;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * Implements a list for a containment reference that will automatically split into several resources and save them
 * whenever necessary ude to operations on the list. The containmentList is part of a root object that holds the
 * containment list. Elements added to the list will be saved to files in the given path with a randomly assigned names
 * and the given extension. The list does not support the set method.
 * 
 * @author koegel
 * @param <T>
 */
public class AutoSplitAndSaveResourceContainmentList<T extends EObject> implements List<T> {

	private static final String ROOT_NAME = "root";
	private static final int MAX_CAPACITY = 30;
	private final EList<T> list;
	private Resource currentResource;
	private int currentResourceElementCount;
	private final ResourceSet resourceSet;
	private final String path;
	private final String extension;
	private Resource rootResource;

	/**
	 * Constructor.
	 * 
	 * @param root parent element of list
	 * @param list the containment list
	 * @param resourceSet the resourceSet to create the resources in
	 * @param path the path for new resources
	 * @param extension the file extension for new resources
	 */
	public AutoSplitAndSaveResourceContainmentList(EObject root, EList<T> list, ResourceSet resourceSet, String path,
		String extension) {
		if (list == null || resourceSet == null || path == null || extension == null || root == null) {
			throw new IllegalArgumentException();
		}
		this.resourceSet = resourceSet;
		this.path = path;
		this.extension = extension;
		this.list = list;

		Resource eResource = root.eResource();
		if (eResource == null) {
			URI fileURI = URI.createFileURI(path + File.separatorChar + ROOT_NAME + extension);
			rootResource = resourceSet.createResource(fileURI);
			rootResource.getContents().add(root);
			saveResource(rootResource);
		} else {
			rootResource = eResource;
		}

		// init first resource
		initCurrentResource(resourceSet);
	}

	private void initCurrentResource(ResourceSet resourceSet) {
		currentResource = createRandomResource(resourceSet, this.path);
		currentResourceElementCount = 0;
	}

	private Resource createRandomResource(ResourceSet resourceSet, String path) {
		URI fileURI = URI.createFileURI(path + File.separatorChar + UUID.randomUUID().toString() + extension);
		return resourceSet.createResource(fileURI);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#add(int, java.lang.Object)
	 */
	public void add(int index, T element) {
		addToResource(element);
		list.add(index, element);
		saveResource(rootResource);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(T o) {
		addToResource(o);
		boolean result = list.add(o);
		saveResource(rootResource);
		return result;
	}

	private void addToResource(T o) {
		if (o.eResource() != null) {
			return;
		}
		if (currentResourceElementCount > MAX_CAPACITY) {
			currentResource = createRandomResource(resourceSet, path);
			currentResourceElementCount = 0;
		}
		currentResource.getContents().add(o);
		saveResource(currentResource);
		currentResourceElementCount += 1;
	}

	private void removeFromResource(EObject o) {
		Resource eResource = o.eResource();
		if (eResource == null) {
			return;
		}
		eResource.getContents().remove(o);
		saveResource(eResource);
		if (eResource == currentResource) {
			currentResourceElementCount -= 1;
		}
	}

	private void saveResource(Resource resource) {
		try {
			resource.save(null);
		} catch (Exception e) {
			String message = "Saving to resource failed!";
			ModelUtil.log(message, e, IStatus.ERROR);
			throw new IllegalStateException(message, e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#addAll(java.util.Collection)
	 */
	public boolean addAll(Collection<? extends T> c) {
		for (T element : c) {
			addToResource(element);
		}
		boolean result = list.addAll(c);
		saveResource(rootResource);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#addAll(int, java.util.Collection)
	 */
	public boolean addAll(int index, Collection<? extends T> c) {
		for (T element : c) {
			addToResource(element);
		}
		boolean result = list.addAll(index, c);
		saveResource(rootResource);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#clear()
	 */
	public void clear() {
		list.clear();
		File dir = new File(path);
		File[] listFiles = dir.listFiles();
		if (listFiles != null) {
			for (File file : listFiles) {
				if (file.isDirectory() || !file.getName().endsWith(extension)) {
					continue;
				}
				if (file.getName().endsWith(ROOT_NAME + extension)) {
					continue;
				}
				file.delete();
			}
		}
		initCurrentResource(resourceSet);
		saveResource(rootResource);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#contains(java.lang.Object)
	 */
	public boolean contains(Object o) {
		return list.contains(o);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#containsAll(java.util.Collection)
	 */
	public boolean containsAll(Collection<?> c) {
		return list.containsAll(c);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#get(int)
	 */
	public T get(int index) {
		return list.get(index);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#indexOf(java.lang.Object)
	 */
	public int indexOf(Object o) {
		return list.indexOf(o);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#isEmpty()
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#iterator()
	 */
	public Iterator<T> iterator() {
		return list.iterator();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#lastIndexOf(java.lang.Object)
	 */
	public int lastIndexOf(Object o) {
		return list.lastIndexOf(o);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#listIterator()
	 */
	public ListIterator<T> listIterator() {
		return list.listIterator();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#listIterator(int)
	 */
	public ListIterator<T> listIterator(int index) {
		return list.listIterator(index);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#remove(int)
	 */
	public T remove(int index) {
		T t = list.remove(index);
		removeFromResource(t);
		saveResource(rootResource);
		return t;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#remove(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public boolean remove(Object o) {
		boolean remove = list.remove(o);
		if (o instanceof EObject) {
			removeFromResource((T) o);
		}
		saveResource(rootResource);
		return remove;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#removeAll(java.util.Collection)
	 */
	@SuppressWarnings("unchecked")
	public boolean removeAll(Collection<?> c) {
		boolean result = list.removeAll(c);
		for (Object o : c) {
			if (o instanceof EObject) {
				removeFromResource((T) o);
			}
		}
		saveResource(rootResource);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#retainAll(java.util.Collection)
	 */
	@SuppressWarnings("unchecked")
	public boolean retainAll(Collection<?> c) {
		Set<Object> removedElements = new HashSet<Object>();
		removedElements.addAll(list);
		removedElements.removeAll(c);
		boolean result = list.retainAll(c);
		for (Object o : removedElements) {
			if (o instanceof EObject) {
				removeFromResource((T) o);
			}
		}
		saveResource(rootResource);
		return result;
	}

	/**
	 * Not implemented. Will throw exception on call.
	 * 
	 * @param index the index
	 * @param element the new element
	 * @return will always throw an exception
	 * @see java.util.List#set(int, java.lang.Object)
	 */
	public T set(int index, T element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#size()
	 */
	public int size() {
		return list.size();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#subList(int, int)
	 */
	public List<T> subList(int fromIndex, int toIndex) {
		return list.subList(fromIndex, toIndex);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#toArray()
	 */
	public Object[] toArray() {
		return list.toArray();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.List#toArray(T[])
	 */
	public <D> D[] toArray(D[] a) {
		return list.toArray(a);
	}

}
