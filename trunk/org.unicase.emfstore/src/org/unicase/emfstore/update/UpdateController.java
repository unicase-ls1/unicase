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
import org.unicase.emfstore.EmfStore;
import org.unicase.emfstore.EmfStoreImpl;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.VersionInfo;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.StorageException;

public class UpdateController {

	protected List<UpdateStep> updateSteps;
	protected List<UpdateStep> necessaryUpdateSteps;
	
	public List<UpdateStep> getNecessaryUpdateSteps() {
		return necessaryUpdateSteps;
	}

	public void setNecessaryUpdateSteps(List<UpdateStep> necessaryUpdateSteps) {
		this.necessaryUpdateSteps = necessaryUpdateSteps;
	}

	public List<UpdateStep> getUpdateSteps() {
		return updateSteps;
	}

	public void setUpdateSteps(List<UpdateStep> updateSteps) {
		this.updateSteps = updateSteps;
	}

	public int getModelVersion() {
		return modelVersion;
	}

	public void setModelVersion(int modelVersion) {
		this.modelVersion = modelVersion;
	}

	protected int modelVersion;
	
	public UpdateController(){
		updateSteps = new ArrayList<UpdateStep>();
		necessaryUpdateSteps = new ArrayList<UpdateStep>(); 
		
		updateSteps.add(new UpdateStepAssignableTransformation());
		
	}
	
	public Boolean updateIsNecessary(){
		return false;
	}

	public void updateResource(Resource resource) throws FatalEmfStoreException{
		System.out.println("Updating model…");
		
		ServerSpace serverSpace = null; 
		EList<EObject> contents = resource.getContents();
		for (EObject content : contents) {
			if (content instanceof ServerSpace) {
				serverSpace = (ServerSpace) content;
				break;
			}
		}
		
		VersionInfo versionInformation = null;
		for (EObject content : contents) {
			if (content instanceof VersionInfo) {
				versionInformation = (VersionInfo) content;
				break;
			}	
		}
		
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
					getNecessaryUpdateSteps().add(updateStep);
				}
			}
		}
		
		int numberOfUpdatedItems = 0;
		
		System.out.println("Starting update…");
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
			serverSpace.save();
			System.out.println("Successfully updated " + numberOfUpdatedItems + " items");
		} catch (IOException e) {
			throw new FatalEmfStoreException(StorageException.NOSAVE, e);
		}
	}
}
