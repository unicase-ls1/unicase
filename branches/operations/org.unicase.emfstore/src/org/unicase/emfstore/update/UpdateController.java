package org.unicase.emfstore.update;

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
		
		updateSteps.add(new UpdateStepAssignableTransformation());
		
	}
	
	public Boolean updateIsNecessary(){
		return false;
	}

	public void updateResource(Resource resource){
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
		
		for (ProjectHistory projectHistory : serverSpace.getProjects()) {
			for (UpdateStep updateStep : getNecessaryUpdateSteps()) {
				updateStep.updateProjectHistory(projectHistory);
			}
		}		
	}
	
//	String[] namespaces = Platform.getExtensionRegistry().getNamespaces();
//	IExtension[] extensions = Platform.getExtensionRegistry().getExtensions("org.unicase.emfstore");
//	
//	for (IExtension extension : extensions) {
//		IConfigurationElement[] configurationElements = extension.getConfigurationElements();
//		for (IConfigurationElement configurationElement : configurationElements) {
//			String[] attributeNames = configurationElement.getAttributeNames();
//			for (String string : attributeNames) {
//				System.out.println(string);	
//			}
//					 
//		}
//	}
	
	
	

}
