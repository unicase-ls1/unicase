package scrm.lists;

import java.util.Collection;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;

import scrm.SCRMDiagram;
import scrm.SCRMModelElement;

@SuppressWarnings("serial")
public class SCRMSpaceContainedModelElementsList<T extends SCRMModelElement> extends EObjectContainmentWithInverseEList.Resolving<T> {
	
	private SCRMDiagram diagram;
	
	public SCRMSpaceContainedModelElementsList(Class<? extends SCRMModelElement> dataClass,
			InternalEObject internalEObject, 
			int containmentFeatureID,
			int containerFeatureID) {
		super(dataClass, internalEObject, containmentFeatureID, containerFeatureID);
	}
	
	@Override
	public boolean add(T object) {
		if(diagram != null) {
			diagram.getElements().add(object);
		}
		return super.add(object);
	}
	
	@Override
	public void add(int index, T object) {
		if(diagram != null) {
			diagram.getElements().add(object);
		}
		super.add(index, object);
	}
	
	
	@Override
	public boolean addAll(Collection<? extends T> objects) {
		if(diagram != null) {
			diagram.getElements().addAll(objects);
		}
		return super.addAll(objects);
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends T> objects) {
		if(diagram != null) {
			diagram.getElements().addAll(objects);
		}
		return super.addAll(index, objects);
	}
	
	@Override
	public void clear() {
		if(diagram != null) {
			diagram.getElements().clear();
		}
		super.clear();
	}
	

	@Override
	public boolean remove(Object object) {
		if(diagram != null) {
			diagram.getElements().remove(object);
		}
		return super.remove(object);
	}

	@Override
	public T remove(int index) {
		T removedObject = super.remove(index); 
		if(diagram != null) {
			diagram.getElements().remove(removedObject);
		}
		return removedObject;
	}

	@Override
	public boolean removeAll(Collection<?> objects) {
		if(diagram != null) {
			diagram.getElements().removeAll(objects);
		}
		return super.removeAll(objects);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean retainAll(Collection<?> objects) {
		if(diagram != null) {
			diagram.getElements().retainAll(objects);
		}
		return super.retainAll(objects);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T set(int index, T object) {
		T oldObject = super.set(index, object);
		if(diagram != null) {
			diagram.getElements().remove(oldObject);
			diagram.getElements().add(object);
		}
		return oldObject;
	}
	
	public void setDiagram(SCRMDiagram diagram) {
		this.diagram = diagram;
	}
}
