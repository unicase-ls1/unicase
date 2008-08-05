package org.unicase.model.task.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkPackage;


public class OpeningLinkTaxonomy {

	/**
	 * Get all openers of a modelelement. Includes Subelements.
	 * 
	 * @param me
	 *            the Modelelement
	 * @return a list of modelelements, the openers
	 */
	public ArrayList<ModelElement> getOpeneners(ModelElement me) {
		ArrayList<ModelElement> openers = new ArrayList<ModelElement>();
		EList<EObject> contents = me.eContents();
		for(EObject eObject:contents){
			if(eObject instanceof ModelElement){
				openers.add((ModelElement) eObject);
			}
		}
		for(ModelElement annotation: me.getAnnotations()){
			openers.add(annotation);
		}
		
		if(me instanceof WorkPackage){
			getWorkPackageOpeners((WorkPackage)me, openers);
		}
		
		return openers;
	}

	private void getWorkPackageOpeners(WorkPackage wp,
			ArrayList<ModelElement> openers) {
		openers.addAll(wp.getContainedWorkItems());
	}

	public ArrayList<ModelElement> getOpened(ModelElement modelElement) {
		ArrayList<ModelElement> opened = new ArrayList<ModelElement>();
		EObject container = modelElement.eContainer();
		if(container instanceof ModelElement){
			opened.add((ModelElement) container);
		}
		if(modelElement instanceof Annotation){
			Annotation annotation = (Annotation) modelElement;
			opened.addAll(annotation.getAnnotatedModelElements());
		}	
		return opened;
	}
	
	public List<ModelElement> getLeafOpeners(ModelElement modelElement){
		ArrayList<ModelElement> leafOpeners = new ArrayList<ModelElement>();
		ArrayList<ModelElement> openeners = getOpeneners(modelElement);
		for(ModelElement opener: openeners){
			if (opener instanceof Checkable){
				leafOpeners.add(opener);
			}
			leafOpeners.addAll(getLeafOpeners(modelElement)); 
		}
		return leafOpeners;
	}

}
