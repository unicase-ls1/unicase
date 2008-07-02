/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.diagram.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;

public class DiagramNewElementsList implements EList<ModelElement> {

	private EList<ModelElement> elements;
	private Project project;

	public DiagramNewElementsList(EList<ModelElement> elements, Project project) {
		this.elements = elements;
		this.project = project;
	}

	public void move(int newPosition, ModelElement object) {
		elements.move(newPosition, object);
	}

	public ModelElement move(int newPosition, int oldPosition) {
		return elements.move(newPosition, oldPosition);
	}

	public boolean add(ModelElement arg0) {
		project.getModelElements().add(arg0);
		return elements.add(arg0);
	}

	public void add(int arg0, ModelElement arg1) {
		project.getModelElements().add(arg0, arg1);
		elements.add(arg0, arg1);
	}

	public boolean addAll(Collection<? extends ModelElement> arg0) {
		project.getModelElements().addAll(arg0);
		return elements.addAll(arg0);
	}

	public boolean addAll(int arg0, Collection<? extends ModelElement> arg1) {
		project.getModelElements().addAll(arg0, arg1);
		return elements.addAll(arg0, arg1);
	}

	public void clear() {
		elements.clear();
	}

	public boolean contains(Object arg0) {
		return elements.contains(arg0);
	}

	public boolean containsAll(Collection<?> arg0) {
		return elements.containsAll(arg0);
	}

	public ModelElement get(int arg0) {
		return elements.get(arg0);
	}

	public int indexOf(Object arg0) {
		return elements.indexOf(arg0);
	}

	public boolean isEmpty() {
		return elements.isEmpty();
	}

	public Iterator<ModelElement> iterator() {
		return elements.iterator();
	}

	public int lastIndexOf(Object arg0) {
		return elements.lastIndexOf(arg0);
	}

	public ListIterator<ModelElement> listIterator() {
		return elements.listIterator();
	}

	public ListIterator<ModelElement> listIterator(int arg0) {
		return elements.listIterator(arg0);
	}

	public boolean remove(Object arg0) {
		return elements.remove(arg0);
	}

	public ModelElement remove(int arg0) {
		// TODO Auto-generated method stub
		return elements.remove(arg0);
	}

	public boolean removeAll(Collection<?> arg0) {
		return elements.removeAll(arg0);
	}

	public boolean retainAll(Collection<?> arg0) {
		return elements.retainAll(arg0);
	}

	public ModelElement set(int arg0, ModelElement arg1) {
		return elements.set(arg0, arg1);
	}

	public int size() {
		return elements.size();
	}

	public List<ModelElement> subList(int arg0, int arg1) {
		return elements.subList(arg0, arg1);
	}

	public Object[] toArray() {
		return elements.toArray();
	}

	public <T> T[] toArray(T[] arg0) {
		return elements.toArray(arg0);
	}

}
