/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.review;

import java.util.Collection;
import java.util.Observable;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.Project;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.UrmlPackage;

/**
 * Tracks the urml model elements for changes.
 * 
 * @author kterzieva
 */

public class ReviewedTracker extends Observable {

	private Project project;

	/**
	 * The construct.
	 * 
	 * @param project the project whose elements will be tracked
	 */
	public ReviewedTracker(Project project) {
		this.project = project;
	}

	/**
	 * .
	 */
	public void createListeners() {
		Collection<EObject> urmlElements = project.getAllModelElementsbyClass(UrmlPackage.eINSTANCE
			.getUrmlModelElement(), new BasicEList<EObject>());
		for (EObject eo : urmlElements) {
			UrmlModelElement urml = (UrmlModelElement) eo;
			ReviewedListener revListener = new ReviewedListener(this, urml);
			urml.addModelElementChangeListener(revListener);
		}
	}

	/**
	 * Gets the number of elements in a project which are reviewed.
	 * 
	 * @param selectReviewed defines which elements are get. Only if it is true, the number of the reviewed elements
	 *            will be return.
	 * @return the value of the elements which are reviewed.
	 */
//	public int getReviewedElements(boolean selectReviewed) {
//		urmlElements = UrmlTreeHandler.getRequirementsFromProject(project);
//		int reviewed = 0;
//		for (UrmlModelElement r : urmlElements) {
//			if (r.isReviewed() == selectReviewed) {
//				reviewed++;
//			}
//		}
//		return reviewed;
//	}

	/**
	 * Updates the observers.
	 */
	public void recalculate() {
		this.setChanged();
		this.notifyObservers();
	}

}
