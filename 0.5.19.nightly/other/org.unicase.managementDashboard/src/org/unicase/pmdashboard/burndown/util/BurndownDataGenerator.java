/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.pmdashboard.burndown.util;

import java.io.IOException;
import java.util.Calendar;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.analyzer.iterator.IteratorFactory;
import org.unicase.analyzer.iterator.TimeIterator;
import org.unicase.analyzer.iterator.VersionSpecQuery;
import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.emfstore.esmodel.versioning.DateVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;

import org.unicase.pmdashboard.burndown.BurndownData;
import org.unicase.pmdashboard.burndown.BurndownDay;
import org.unicase.pmdashboard.burndown.BurndownFactory;
import org.unicase.pmdashboard.burndown.impl.BurndownFactoryImpl;

/**
 * Generates all objects that contain information needed by the BurndownChart for WorkPackages.
 * @author andy
 *
 */
public final class BurndownDataGenerator {

	private static BurndownDataGenerator instance;
	private static Resource dataResource;
	
	private static final String FILENAME = "burndownData";
	private static final int STEPLENGTH = 1;
	private static final int STEPUNIT = Calendar.DATE;
	
	/**
	 * @return the instance of this singleton class
	 */
	public static BurndownDataGenerator getInstance() {
		if(instance == null) {
			return new BurndownDataGenerator();
		} else {
			return instance;
		}
	}
	
	/**
	 * loads all saved data or creates the EMF resource, if not existent.
	 */
	private BurndownDataGenerator() {
		ResourceSet resourceSet = new ResourceSetImpl();
		
		URI resourceURI = URI.createFileURI(Configuration.getPluginDataBaseDirectory().concat(FILENAME));
		
		// when demand loading is on, there is an exception if the resource doesn't exist
		dataResource = resourceSet.getResource(resourceURI, false);
		
		// if the resource is null, it didn't exist by now and we create it
		if(dataResource == null) {
			dataResource = resourceSet.createResource(resourceURI);
		}
	}
	
	/**
	 * Calculates the sprint's amounts of open tasks and the remaining estimates for each day of the sprint. 
	 * @param modelElement the WorkPackage, that's days should be completed  
	 * @return all days for the sprint containing all necessary information for the chart
	 * @throws IteratorException if the project can't be iterated
	 * @throws IOException if resource couldn't be saved
	 */
	public BurndownData getBurndownData(ModelElement modelElement) throws IteratorException, IOException {
		BurndownData result;
		
//		result = getStoredBurndownData(modelElement);
//		
//		// look if the sprint is already stored
//		if(result == null) {
//			// if not, create new data
			
			
			result = BurndownFactory.eINSTANCE.createBurndownData();
			result.setParentElementId(modelElement.getModelElementId());
			
			dataResource.getContents().add(result);
//		}
		
//		completeDays(modelElement, result);
		
		dataResource.save(null);
		
		return result;
	}
	
	/**
	 * Builds the TimeIterator for the sprint.
	 * @param sprint
	 * @return iterator over the sprint's days
	 * @throws IteratorException
	 */
	private TimeIterator getTimeIterator(WorkPackage sprint) throws IteratorException {
		ProjectSpace projectSpace =WorkspaceManager.getInstance().getProjectSpace(sprint);

		DateVersionSpec start = VersioningFactory.eINSTANCE.createDateVersionSpec();
		start.setDate(sprint.getStartDate());
		
		DateVersionSpec end = VersioningFactory.eINSTANCE.createDateVersionSpec();
		end.setDate(sprint.getDueDate());
		
		VersionSpecQuery specQuery = IteratorFactory.eINSTANCE.createVersionSpecQuery();
		specQuery.setStartVersion(start);
		specQuery.setEndVersion(end);
		
		TimeIterator result = IteratorFactory.eINSTANCE.createTimeIterator();
		result.init(	projectSpace.getUsersession(),
						projectSpace.getProjectId(),
						STEPLENGTH,
						STEPUNIT,
						specQuery,
						true,
						false
					);
		return result;
	}
	
	private static ProjectSpace getProjectSpace(WorkPackage sprint) {
		WorkspaceManager.getInstance();
		return WorkspaceManager.getProjectSpace(sprint);
	}
	
	private static WorkPackage sprintAsWorkPackage(BurndownData sprint, ProjectSpace project) {
		return (WorkPackage) project.getProject().getModelElement(sprint.getParentElementId());
	}
	
	/**
	 * Adds missing days (and the contained information) to the BurndownData of a WorkPackage.
	 * @param sprint 
	 * @param target
	 * @param sprintIterator
	 * @return was the data updated?
	 * @throws IteratorException 
	 */
	private boolean completeDays(WorkPackage sprint, BurndownData target) throws IteratorException {
		TimeIterator steps = this.getTimeIterator(sprint);
		
		// TODO don't generate the already stored days
		Calendar currentDate = Calendar.getInstance();
		currentDate.setTime(sprint.getStartDate());
		
		BurndownFactory dayFactory = new BurndownFactoryImpl();
		
		while(steps.hasNext()) {
			Project stepProject = steps.next().getProjectState();
			
			BurndownDay day = dayFactory.createBurndownDay();
			day.setDate(currentDate.getTime());
			
			// the cast must work, otherwise there's a programming error
			WorkPackage stepWorkPackage = (WorkPackage) stepProject.getModelElement(sprint.getModelElementId());
			
			day.setRemainingEstimate(stepWorkPackage.getRemainingEstimate());
			day.setOpenTaskCount(stepWorkPackage.getAllTasks() - stepWorkPackage.getClosedTasks());
			
			dataResource.getContents().add(day);
			target.getDays().add(day);
			currentDate.add(STEPUNIT, STEPLENGTH);
		}
		
		return true;
	}
	
	/**
	 * searches for already stored BurndownData for a sprint.
	 * @param sprint that's data is searched for
	 * @return stored BurndownData for the sprint or null, if nothing is stored
	 */
	private BurndownData getStoredBurndownData(WorkPackage sprint) {
		EList<EObject> directContents = dataResource.getContents();
		
		for(EObject object : directContents) {
			if(object.getClass() == BurndownData.class) {
				if(sprintAsWorkPackage((BurndownData) object, getProjectSpace(sprint)) == sprint.getModelElementId()) {
					return (BurndownData) object;
				}
			}
		}
		
		return null;
	}
}
