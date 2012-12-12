package scrm.lists;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.BasicInternalEList;

import scrm.SCRMDiagram;
import scrm.SCRMModelElement;
import scrm.SCRMSpace;

@SuppressWarnings("serial")
public class SCRMDiagramNewElementsList extends BasicInternalEList<SCRMModelElement> {

	private EList<SCRMModelElement> elements;
	private SCRMDiagram owningDiagram;
	private EObject container;
	
	public SCRMDiagramNewElementsList(EList<SCRMModelElement> elements, SCRMDiagram owningDiagram, EObject container) {
		super(SCRMModelElement.class);
		this.elements = elements;
		this.owningDiagram = owningDiagram;
		setContainer(container);
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
		List<EObject> containedObjects = getContainmentList();
		if(containedObjects != null) {
			containedObjects.add(object);
			return true;
		}
		return false;
	}
	
	@Override
	public void add(int index, SCRMModelElement object) {
		List<EObject> containedObjects = getContainmentList();
		if(containedObjects != null) {
			containedObjects.add(index, object);
		}
	}
	
	@Override
	public boolean addAll(Collection<? extends SCRMModelElement> objects) {
		List<EObject> containedObjects = getContainmentList();
		if(containedObjects != null) {
			containedObjects.addAll(objects);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends SCRMModelElement> objects) {
		List<EObject> containedObjects = getContainmentList();
		if(containedObjects != null) {
			containedObjects.addAll(index, objects);
			return true;
		}
		return false;
	}
	
	private List getContainmentList() {
		if(container == null) {
			return null;
		}
		if(container == owningDiagram.eContainer()) {
			EStructuralFeature containingFeature = owningDiagram.eContainingFeature();
			Object referencedObject = container.eGet(containingFeature);
			if(referencedObject != null && referencedObject instanceof List) {
				return (List) referencedObject;
			}
		} else if(container instanceof SCRMSpace) {
			return ((SCRMSpace) container).getContainedModelElements();
		}
		return null;
	}
	
//	@Override
//	public void clear() {
//		elements.clear();
//	}
//	
//	@Override
//	public boolean contains(Object object) {
//		return elements.contains(object);
//	}
//	
//	@Override
//	public boolean containsAll(Collection<?> objects) {
//		return elements.containsAll(objects);
//	}
//
//	@Override
//	public boolean isEmpty() {
//		return elements.isEmpty();
//	}
//	
//	@Override
//	public boolean remove(Object object) {
//		return elements.remove(object);
//	}
//
//	@Override
//	public SCRMModelElement remove(int index) {
//		throw new UnsupportedOperationException();
//	}
//
//	@Override
//	public boolean removeAll(Collection<?> objects) {
//		return elements.removeAll(objects);
//	}
//
//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//	public boolean retainAll(Collection<?> objects) {
//		return elements.retainAll(objects);
//	}
//
//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//	public int size() {
//		return elements.size();
//	}


	public void setContainer(EObject container) {
		this.container = container;
	}
	
}
