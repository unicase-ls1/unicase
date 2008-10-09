/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.update;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.osgi.framework.Version;
import org.unicase.emfstore.EmfStoreImpl;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.VersionInfo;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.StorageException;

/**
 * @author schroech
 *
 */
public class UpdateController {


	private List<UpdateStep> updateSteps;
	private List<UpdateStep> necessaryUpdateSteps;

	
	/**
	 * @return A list of necessary update steps to upgrade from the model version to the emf store version
	 */
	public List<UpdateStep> getNecessaryUpdateSteps() {
		return necessaryUpdateSteps;
	}

	/**
	 * @param necessaryUpdateSteps list of necessary update steps
	 */
	public void setNecessaryUpdateSteps(List<UpdateStep> necessaryUpdateSteps) {
		this.necessaryUpdateSteps = necessaryUpdateSteps;
	}

	/**
	 * @return A list of all available update steps
	 */
	public List<UpdateStep> getUpdateSteps() {
		return updateSteps;
	}

	
	/**
	 * @param updateSteps 
	 * A list of all available update steps
	 */
	public void setUpdateSteps(List<UpdateStep> updateSteps) {
		this.updateSteps = updateSteps;
	}
	
	/**
	 * A fucking constructor.
	 */
	public UpdateController(){
		updateSteps = new ArrayList<UpdateStep>();
		necessaryUpdateSteps = new ArrayList<UpdateStep>();
		
		//Update from Version 0.0.4 to 0.0.5
//		updateSteps.add(new UpdateStepRenameFacilitator());
//		updateSteps.add(new UpdateStepRemoveAnnotationInstances());
//		updateSteps.add(new UpdateStepRemoveBugResolution());
//		updateSteps.add(new UpdateStepRemoveRefiningIssues());
//		updateSteps.add(new UpdateStepRemoveStepsToReproduce());
//		updateSteps.add(new UpdateStepRenameAssignedTo());
//		updateSteps.add(new UpdateStepRenameActionItemAssignedTo());
//		updateSteps.add(new UpdateStepRenamePackages());
//		updateSteps.add(new UpdateStepRemoveOrgUnit());
		
		//Update from Version 0.0.5 to 0.0.6
//		updateSteps.add(new UpdateStepRemoveAssociationTypeDependency());
//		updateSteps.add(new UpdateStepRenameAssociationTypeLiterals());
	}
	

	/**
	 * @param resource 
	 * The resource to update
	 * @throws FatalEmfStoreException
	 * Throws an {@link FatalEmfStoreException} if the {@link Resource} could not be saved
	 */
	public void updateResource(Resource resource) throws FatalEmfStoreException{
		
		EList<EObject> contents = resource.getContents();
		
		ServerSpace serverSpace = getServerSpace(contents);
		VersionInfo versionInformation = getVersionInformation(contents);
		
		Version sourceEMFStoreVersion;
		Version targetEMFStoreVersion;
		
		sourceEMFStoreVersion = versionInformation.getEmfStoreVersion();
		targetEMFStoreVersion = EmfStoreImpl.getModelVersion();
		
		Collections.sort(getUpdateSteps(), new Comparator<UpdateStep>(){
				public int compare(UpdateStep arg0, UpdateStep arg1) {
					int compare = arg0.getSourceVersion().compareTo(arg1.getSourceVersion());
					if (compare == 0) {
						compare = arg0.getTargetVersion().compareTo(arg1.getTargetVersion());
					}
					return compare; 
				}
		});
		
		
		for (UpdateStep updateStep : getUpdateSteps()) {
			if (updateStep.getTargetVersion().compareTo(sourceEMFStoreVersion) > 0) {
				if (updateStep.getTargetVersion().compareTo(targetEMFStoreVersion) <= 0) {
					if (updateStep instanceof ModelCleanupUpdateStep) {
						String updateMessage = "Your model version is outdated!\n" 
						+ "Please start the emf store version"
						+ updateStep.getSourceVersion() 
						+ "and perform all available "
						+ "updates before loading the model with emf store version "
						+ updateStep.getTargetVersion()
						+ ".";
						
						System.out.println(updateMessage);
					}else{
						getNecessaryUpdateSteps().add(updateStep);
					}
				}
			}
		}
		
		int numberOfUpdatedItems = 0;
		
		System.out.println("Starting updateÉ");
		for (ProjectHistory projectHistory : serverSpace.getProjects()) {
			for (UpdateStep updateStep : getNecessaryUpdateSteps()) {
				System.out.println("Performing update: " + updateStep.getTitle());
				System.out.println("Updating from version " 
						+ updateStep.getSourceVersion() 
						+ " to version " 
						+ updateStep.getTargetVersion());
								
				numberOfUpdatedItems += updateStep.updateProjectHistory(projectHistory);
			}
		}
		
		versionInformation.setEmfStoreVersion(EmfStoreImpl.getModelVersion());
		
		try {
			EList<Resource> resources = resource.getResourceSet().getResources();
			for (Resource currentResource : resources) {
				currentResource.save(null);
			}
			System.out.println("Successfully updated " + numberOfUpdatedItems + " items");
		} catch (IOException e) {
			throw new FatalEmfStoreException(StorageException.NOSAVE, e);
		}
	}

	private ServerSpace getServerSpace(EList<EObject> contents) {
		ServerSpace serverSpace = null;
		for (EObject content : contents) {
			if (content instanceof ServerSpace) {
				serverSpace = (ServerSpace) content;
				break;
			}
		}
		return serverSpace;
	}

	private VersionInfo getVersionInformation(EList<EObject> contents) {
		VersionInfo versionInformation = null;
		for (EObject content : contents) {
			if (content instanceof VersionInfo) {
				versionInformation = (VersionInfo) content;
				break;
			}	
		}
		return versionInformation;
	}
}
