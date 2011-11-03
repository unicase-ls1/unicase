/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.navigation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.urml.UrmlFactory;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.ui.urml.stakeholders.ChangeObserverAdapter;
import org.unicase.ui.urml.stakeholders.Publisher;

/**
 * Tracks the urml model elements for changes.
 * 
 * @author kterzieva
 */

public class ReviewCountPublisher extends Publisher {

	private static final EStructuralFeature REVIEWED_FEATURE = UrmlFactory.eINSTANCE.getUrmlPackage().getUrmlModelElement().getEStructuralFeature("reviewed");

	
	private Project project;
	private Map<EClass,Integer> reviewCounts = new HashMap<EClass, Integer>();
	private Map<EClass,Integer> allCounts = new HashMap<EClass, Integer>();
	private int reviewCount, allCount;


	private ChangeObserverAdapter observer;

	
	private void adjustReviewCount( EClass c, int delta){
		Integer i = reviewCounts.get(c);
		if(i == null){
			i = 0;
		}
		i+=delta;
		reviewCounts.put(c, i);
		reviewCount+=1;
	}
	
	private void adjustOverallCount( EClass c, int delta){
		Integer i = allCounts.get(c);
		if(i == null){
			i = 0;
		}
		i+=delta;
		allCounts.put(c, i);
		allCount+=1;
	}
	
	public void init(Project project){
		if(this.project != null){
			remove();
		}
		this.project = project;
		Collection<UrmlModelElement> urmlElements = project.getAllModelElementsbyClass(UrmlPackage.eINSTANCE
				.getUrmlModelElement(), new BasicEList<UrmlModelElement>());
		for(UrmlModelElement u : urmlElements){
			adjustOverallCount(u.eClass(),1);
			if(u.isReviewed()){
				adjustReviewCount(u.eClass(),1);
			}
		}
		
		notifyObservers();
		
		project.addProjectChangeObserver(observer = new ChangeObserverAdapter(){
			@Override
			public void modelElementAdded(Project project, EObject modelElement) {
				if(modelElement instanceof UrmlModelElement){
					UrmlModelElement u = (UrmlModelElement) modelElement;
					adjustOverallCount(u.eClass(), 1);
					if(u.isReviewed()){
						adjustReviewCount(u.eClass(), 1);
					}
					notifyObservers();
				}
			}
			
			@Override
			public void modelElementRemoved(Project project,
					EObject modelElement) {
				if(modelElement instanceof UrmlModelElement){
					UrmlModelElement u = (UrmlModelElement) modelElement;
					adjustOverallCount(u.eClass(), -1);
					if(u.isReviewed()){
						adjustReviewCount(u.eClass(), -1);
					}
					notifyObservers();
				}
			}
			
			@Override
			public void notify(Notification notification, Project project,
					EObject modelElement) {
				if (notification.getEventType() == Notification.RESOLVE) {
					return;
				}
				if(modelElement instanceof UnicaseModelElement){
					//if review check box was selected or deselected
					if ((notification.getFeature().equals(REVIEWED_FEATURE))) {
						if(!notification.getOldBooleanValue() && notification.getNewBooleanValue()){
							//false -> true
							adjustReviewCount(modelElement.eClass(), 1);
							notifyObservers();
						} else if(!notification.getOldBooleanValue() && notification.getNewBooleanValue()){
							//true -> false
							adjustReviewCount(modelElement.eClass(), -1);
							notifyObservers();
						} 
					}
				}
			}
		});
	}

	public void remove() {
		project.removeProjectChangeObserver(observer);
		project = null;
	}
	
	public Map<EClass, Integer> getAllCounts() {
		return allCounts;
	}
	
	public Map<EClass, Integer> getReviewCounts() {
		return reviewCounts;
	}
	
	public int getTotalCount() {
		return allCount;
	}
	
	public int getReviewCount() {
		return reviewCount;
	}

	public int getReviewCount(EClass c) {
		Integer i = reviewCounts.get(c);
		if(i == null){
			return 0;
		}
		return i;
	}
	
	public int getTotalCount(EClass c) {
		Integer i = allCounts.get(c);
		if(i == null){
			return 0;
		}
		return i;
	}



}
