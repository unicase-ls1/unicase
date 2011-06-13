package scrm.lists;

import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.unicase.metamodel.Project;

import scrm.SCRMModelElement;
import scrm.SCRMSpace;

@SuppressWarnings("serial")
public class SCRMDiagramNewElementsList extends BasicInternalEList<SCRMModelElement> {

	private EList<SCRMModelElement> elements;
	private SCRMSpace containingSpace;
	private Project project;
	
	public SCRMDiagramNewElementsList(EList<SCRMModelElement> elements, EObject container) {
		super(SCRMModelElement.class);
		this.elements = elements;
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
		if(project != null) {
			return project.getModelElements().add(object);
		} else if (containingSpace != null) {
			return containingSpace.getContainedModelElements().add(object);
		}
		return false;
	}
	
	@Override
	public void add(int index, SCRMModelElement object) {
		if(project != null) {
			project.getModelElements().add(index, object);
		} else if (containingSpace != null) {
			containingSpace.getContainedModelElements().add(index, object);
		}
	}
	
	@Override
	public boolean addAll(Collection<? extends SCRMModelElement> objects) {
		if(project != null) {
			return project.getModelElements().addAll(objects);
		} else if (containingSpace != null) {
			return containingSpace.getContainedModelElements().addAll(objects);
		}
		return false;
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends SCRMModelElement> objects) {
		if(project != null) {
			return project.getModelElements().addAll(index, objects);
		} else if (containingSpace != null) {
			return containingSpace.getContainedModelElements().addAll(index, objects);
		}
		return false;
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
		if(container instanceof Project) {
			project = (Project) container;
			containingSpace = null;
		} else if (container instanceof SCRMSpace) {
			containingSpace = (SCRMSpace) container;
			project = null;
		}
	}
	
}
