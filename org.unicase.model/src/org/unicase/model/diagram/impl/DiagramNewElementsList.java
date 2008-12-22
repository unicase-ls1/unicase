/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.model.diagram.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;

/**
 * This list should only be used with diagrams. I changes the behavior to add new elements on a diagram to the project
 * and to the diagram itself. Most of the methods forward to the elements list, which is the reference feature of the
 * according diagram.
 * 
 * @author helming
 */
@SuppressWarnings("serial")
public class DiagramNewElementsList extends BasicInternalEList<ModelElement> {

	private EList<ModelElement> elements;
	private Project project;

	/**
	 * default constructor.
	 * 
	 * @param elements The reference feature of the according diagram
	 * @param project The project of the diagram
	 */
	public DiagramNewElementsList(EList<ModelElement> elements, Project project) {
		super(ModelElement.class);
		this.elements = elements;
		this.project = project;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void move(int newPosition, ModelElement object) {
		elements.move(newPosition, object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelElement move(int newPosition, int oldPosition) {
		return elements.move(newPosition, oldPosition);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean add(ModelElement arg0) {
		boolean add = project.getModelElements().add(arg0);
		return add;
	}

	/**
	 * Adds the new modelelement to the project. There is no need to add it to the elements list, cause the diagram code
	 * does this additionally.
	 * 
	 * @param arg0 The position
	 * @param arg1 The new modelelement
	 */
	@Override
	public void add(int arg0, ModelElement arg1) {
		project.getModelElements().add(arg0, arg1);
	}

	/**
	 * Appends the new modelelements to the project. There is no need to add it to the elements list, cause the diagram
	 * code does this additionally.
	 * 
	 * @param arg0 The list of new modelelements
	 * @return true if the list changed as a result of the calls
	 */
	@Override
	public boolean addAll(Collection<? extends ModelElement> arg0) {
		return project.getModelElements().addAll(arg0);
	}

	/**
	 * Inserts the new modelelements to the project. There is no need to add it to the elements list, cause the diagram
	 * code does this additionally.
	 * 
	 * @param arg0 The position to insert
	 * @param arg1 The list of new modelelements
	 * @return true if the list changed as a result of the calls
	 */
	@Override
	public boolean addAll(int arg0, Collection<? extends ModelElement> arg1) {
		return project.getModelElements().addAll(arg0, arg1);
	}

	/**
	 * {@inheritDoc} Elements are not deleted from the project.
	 */
	@Override
	public void clear() {
		elements.clear();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains(Object arg0) {
		return elements.contains(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsAll(Collection<?> arg0) {
		return elements.containsAll(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelElement get(int arg0) {
		return elements.get(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int indexOf(Object arg0) {
		return elements.indexOf(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<ModelElement> iterator() {
		return elements.iterator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int lastIndexOf(Object arg0) {
		return elements.lastIndexOf(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ListIterator<ModelElement> listIterator() {
		return elements.listIterator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ListIterator<ModelElement> listIterator(int arg0) {
		return elements.listIterator(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean remove(Object arg0) {
		return elements.remove(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelElement remove(int arg0) {
		return elements.remove(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean removeAll(Collection<?> arg0) {
		return elements.removeAll(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean retainAll(Collection<?> arg0) {
		return elements.retainAll(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelElement set(int arg0, ModelElement arg1) {
		return elements.set(arg0, arg1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return elements.size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ModelElement> subList(int arg0, int arg1) {
		return elements.subList(arg0, arg1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] toArray() {
		return elements.toArray();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T[] toArray(T[] arg0) {
		return elements.toArray(arg0);
	}

}
