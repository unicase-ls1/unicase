package org.unicase.emfstore.update;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;

public abstract class UpdateStepTransformClass extends UpdateStepImpl {

	public abstract EClass getTransformableEClass();	
	
	public abstract int updateModelElement(ModelElement modelElement);
	
	@Override
	public int updateProjectState(Project state) {
		int numberOfUpdatedItems = 0;
		EList<ModelElement> allModelElementsbyClass = state.getAllModelElementsbyClass(getTransformableEClass(), 
				new BasicEList<ModelElement>());
		for (ModelElement modelElement : allModelElementsbyClass) {
			numberOfUpdatedItems += updateModelElement(modelElement);
		}
		
		return numberOfUpdatedItems;
	}
}
