package scrm.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.unicase.metamodel.Project;

import scrm.SCRMModelElement;

@SuppressWarnings("serial")
public class SCRMDiagramNewElementsList extends BasicInternalEList<SCRMModelElement> {

	private EList<SCRMModelElement> elements;
	private Project project;
	
	public SCRMDiagramNewElementsList(EList<SCRMModelElement> elements, Project project) {
		super(SCRMModelElement.class);
		this.elements = elements;
		this.project = project;
	}
	
	@Override
	public void move(int newPosition, SCRMModelElement object) {
		elements.move(newPosition, object);
	}

	@Override
	public SCRMModelElement move(int newPosition, int oldPosition) {
		return elements.move(newPosition, oldPosition);
	}
	
	@Override
	public boolean add(SCRMModelElement object) {
		return project.getModelElements().add(object);
	}
	
	@Override
	public void add(int index, SCRMModelElement object) {
		project.getModelElements().add(index, object);
	}
	
	@Override
	public boolean addAll(Collection<? extends SCRMModelElement> objects) {
		return project.getModelElements().addAll(objects);
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends SCRMModelElement> objects) {
		return project.getModelElements().addAll(index, objects);
	}
	
	@Override
	public void clear() {
		elements.clear();
	}
	
	@Override
	public boolean contains(Object object) {
		return elements.contains(object);
	}
	
	@Override
	public boolean containsAll(Collection<?> objects) {
		return elements.containsAll(objects);
	}

	@Override
	public SCRMModelElement get(int index) {
		return elements.get(index);
	}
	
	@Override
	public int indexOf(Object object) {
		return elements.indexOf(object);
	}
	
	@Override
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	@Override
	public Iterator<SCRMModelElement> iterator() {
		return elements.iterator();
	}

	@Override
	public int lastIndexOf(Object object) {
		return elements.lastIndexOf(object);
	}

	@Override
	public ListIterator<SCRMModelElement> listIterator() {
		return elements.listIterator();
	}

	@Override
	public ListIterator<SCRMModelElement> listIterator(int index) {
		return elements.listIterator(index);
	}

	@Override
	public boolean remove(Object object) {
		return elements.remove(object);
	}

	@Override
	public SCRMModelElement remove(int index) {
		return elements.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> objects) {
		return elements.removeAll(objects);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean retainAll(Collection<?> objects) {
		return elements.retainAll(objects);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SCRMModelElement set(int index, SCRMModelElement object) {
		return elements.set(index, object);
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
	public List<SCRMModelElement> subList(int arg0, int arg1) {
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
	public <T> T[] toArray(T[] a) {
		return elements.toArray(a);
	}
	
}
