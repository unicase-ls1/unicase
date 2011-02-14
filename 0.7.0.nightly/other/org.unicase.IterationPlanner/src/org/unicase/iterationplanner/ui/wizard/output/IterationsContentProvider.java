package org.unicase.iterationplanner.ui.wizard.output;

import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class IterationsContentProvider extends AdapterFactoryContentProvider {

	private List<Iteration> iterations;
	@SuppressWarnings("unused")
	private int backlogNumber;

	public IterationsContentProvider(int backlogNumber, AdapterFactory adapterFactory) {
		super(adapterFactory);
		this.backlogNumber = backlogNumber;
	}

	@Override
	public Object[] getChildren(Object object) {
		if(object instanceof Iteration){
			return ((Iteration) object).getPlannedTasks().toArray();
		}
		return null;
	}

	@Override
	public Object[] getElements(Object object) {
		return this.iterations.toArray();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if(newInput != null){
			this.iterations = (List<Iteration>) newInput;
		}
	
	}

	@Override
	public boolean hasChildren(Object object) {
		return object instanceof Iteration;
	}
	
	
	
	

}
