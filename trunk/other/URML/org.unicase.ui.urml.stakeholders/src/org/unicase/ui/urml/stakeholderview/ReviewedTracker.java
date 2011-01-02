/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview;

import java.util.Collection;
import java.util.Observable;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.ecp.model.workSpaceModel.ECPProject;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.requirement.Requirement;
import org.unicase.ui.urml.stakeholderview.reviewview.input.UrmlTreeHandler;

/**
 * Tracks the urml model elements changes. 
 * @author kterzieva
 *
 */

public class ReviewedTracker extends Observable {

	private ECPProject project;
//	private List<Observer> obs;
	private Collection<Requirement> requirements;
	
	
	/**
	 * .
	 * @param project .
	 */
	public ReviewedTracker(ECPProject project){
		this.project = project;
	}
	
	/**
	 * .
	 */
	public void createListeners(){
		Collection<EObject> urmlElements = project.getAllModelElementsbyClass(UrmlPackage.eINSTANCE.getUrmlModelElement(), new BasicEList<EObject>());
		for (EObject eo: urmlElements){
			UrmlModelElement urml = (UrmlModelElement) eo;
			ReviewedListener revListener = new ReviewedListener(this, urml);
			urml.addModelElementChangeListener(revListener);
		}
	}
	
	/**
	 * Gets the number of elements in a project which are reviewed.
	 * @return the value of the elements which are reviewed.
	 */
	public int getReviewedElements() {
		requirements = UrmlTreeHandler.getRequirementsFromProject(project);
		int reviewed = 0;
		for (Requirement r : requirements){
			if (r.isReviewed()){
				reviewed++;
				
			}
		}
		return reviewed;
	}
	
	/**
	 * .
	 * @return the number of the elements in a project which are unreviewed.
	 */
	public int getUnreviewedElements() {
		requirements = UrmlTreeHandler.getRequirementsFromProject(project);
		int unreviewed = 0;
		for (Requirement r : requirements){
			if (!r.isReviewed()){
				unreviewed++;
			}
		}
		return unreviewed;
	}
	
	/**
	 * Updates the observers.
	 */
	public void recalculate(){
		this.setChanged();
		this.notifyObservers();
	}

}
