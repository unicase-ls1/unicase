package org.unicase.papyrus.diagram.part;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.core.modelsetquery.impl.ModelSetQueryAdapter;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;

/**
 * A {@link ModelSetQueryAdapter} that only returns EObjects as reachable objects,
 * that are in the same project as the EObject in question.
 * 
 * @author mharut
 */
public class UnicaseModelSetQueryAdapter extends ModelSetQueryAdapter {
	
	public Collection<EObject> getReachableObjectsOfType(EObject object, EClassifier type) {
		Project project = ModelUtil.getProject(object);
		EList<EObject> result = new BasicEList<EObject>();
		if(type instanceof EClass) {
			project.getAllModelElementsbyClass((EClass) type, result);
		}
		return result;
		
	}

}
