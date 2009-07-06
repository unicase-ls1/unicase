/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.task.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkPackage;

/**
 * Taxonomy to define opening links.
 * 
 * @author helming
 * 
 */
public class OpeningLinkTaxonomy {

	/**
	 * Get all openers of a modelelement. Includes Subelements.
	 * zardosht: I had to implement this method with a set<> because it 
	 * returned many duplicate opener instances. The other methods that 
	 * worked with method should have set<> implementation accordingly.
	 * @param me
	 *            the Modelelement
	 * @return a list of modelelements, the openers
	 */
	public Set<ModelElement> getOpeners(ModelElement me) {
		Set<ModelElement> openers = new HashSet<ModelElement>();
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
	
	/**.
	 * zardosht: I thought that we need also a transitive concept of opener.
	 * This concept is implemented in this method and is used in status view.
	 * @param me The source modelelement
	 * @return all openers recursive collected
	 */
	public Set<ModelElement> getOpenersRecursive(ModelElement me) {
		Set<ModelElement> openers = new HashSet<ModelElement>();
		EList<EObject> contents = me.eContents();
		for(EObject eObject:contents){
			if(eObject instanceof ModelElement){
				openers.add((ModelElement) eObject);
				openers.addAll(getOpenersRecursive((ModelElement) eObject));
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
			Set<ModelElement> openers) {
		openers.addAll(wp.getContainedWorkItems());
	}
	/**
	 * Returns all elements which are opened by the source model element. That
	 * means, they are connected with the source by a opening link. The target
	 * element has not to be open until the source is open or blocked.
	 * 
	 * @param modelElement
	 *            The source modelelement
	 * @return all opened modelelements
	 */
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
	/**
	 * Returns all leaf openers, that means all checkables which causes the source to be open.
	 * @param modelElement the source
	 * @return a set of modelelement
	 */
	public Set<ModelElement> getLeafOpeners(ModelElement modelElement){
		Set<ModelElement> leafOpeners = new HashSet<ModelElement>();
		Set<ModelElement> openeners = getOpeners(modelElement);
		for(ModelElement opener: openeners){
			if (opener instanceof Checkable){
				leafOpeners.add(opener);
			}
			leafOpeners.addAll(getLeafOpeners(modelElement)); 
		}
		return leafOpeners;
	}

}
