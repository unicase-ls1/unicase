/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.update;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.osgi.framework.Version;
import org.unicase.emfstore.EmfStoreImpl;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.VersionInfo;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.StorageException;
import org.unicase.emfstore.update.steps.UpdateStepWorkPackageDueDate;

/**
 * @author schroech
 */
public class UpdateController {

	private List<UpdateStep> updateSteps;
	private List<UpdateStep> necessaryUpdateSteps;

	private static final Log LOGGER = LogFactory.getLog(EmfStoreImpl.class);

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
	 * @param updateSteps A list of all available update steps
	 */
	public void setUpdateSteps(List<UpdateStep> updateSteps) {
		this.updateSteps = updateSteps;
	}

	/**
	 * Constructor.
	 */
	public UpdateController() {
		updateSteps = new ArrayList<UpdateStep>();
		necessaryUpdateSteps = new ArrayList<UpdateStep>();

		// Model reset here: cannot run these updaters without old model
		// Update from Version 0.0.4 to 0.0.5
		// updateSteps.add(new UpdateStepRenameFacilitator());
		// updateSteps.add(new UpdateStepRemoveAnnotationInstances());
		// updateSteps.add(new UpdateStepRemoveBugResolution());
		// updateSteps.add(new UpdateStepRemoveRefiningIssues());
		// updateSteps.add(new UpdateStepRemoveStepsToReproduce());
		// updateSteps.add(new UpdateStepRenameAssignedTo());
		// updateSteps.add(new UpdateStepRenameActionItemAssignedTo());
		// updateSteps.add(new UpdateStepRenamePackages());
		// updateSteps.add(new UpdateStepRemoveOrgUnit());

		// Model reset here: cannot run these updaters without old model
		// Update from Version 0.0.5 to 0.0.6
		// updateSteps.add(new UpdateStepRemoveAssociationTypeDependency());
		// updateSteps.add(new UpdateStepRenameAssociationTypeLiterals());
		updateSteps.add(new UpdateStepWorkPackageDueDate());
	}

	/**
	 * Update the server space.
	 * 
	 * @param serverSpace the server space to update
	 * @param versionInformation the current version info
	 * @throws FatalEmfStoreException Throws an {@link FatalEmfStoreException} if the {@link Resource} could not be
	 *             saved
	 */
	public void updateServerSpace(ServerSpace serverSpace, VersionInfo versionInformation)
		throws FatalEmfStoreException {

		Version sourceEMFStoreVersion = versionInformation.getEmfStoreVersion();
		Version targetEMFStoreVersion = EmfStoreImpl.getModelVersion();

		Collections.sort(getUpdateSteps(), new Comparator<UpdateStep>() {
			public int compare(UpdateStep arg0, UpdateStep arg1) {
				int compare = arg0.getSourceVersion().compareTo(arg1.getSourceVersion());
				if (compare == 0) {
					compare = arg0.getTargetVersion().compareTo(arg1.getTargetVersion());
				}
				return compare;
			}
		});

		UpdateStep previousUpdateStep = null;

		for (UpdateStep updateStep : getUpdateSteps()) {
			// if target > emf store source
			if (updateStep.getTargetVersion().compareTo(sourceEMFStoreVersion) > 0) {
				// if target < emf store target
				if (updateStep.getTargetVersion().compareTo(targetEMFStoreVersion) <= 0) {
					if (updateStep instanceof ModelCleanupUpdateStep) {
						StringBuilder stringBuilder = new StringBuilder();
						stringBuilder
							.append("Your model version is outdated!\n" + "Please start the emf store version");
						stringBuilder.append(updateStep.getSourceVersion());
						stringBuilder.append("and perform all available ");
						stringBuilder.append("updates before loading the model with emf store version ");
						stringBuilder.append(updateStep.getTargetVersion());
						stringBuilder.append(".");
						String updateMessage = stringBuilder.toString();
						System.out.println(updateMessage);
						throw new FatalEmfStoreException(updateMessage);
					} else {
						checkForMissingSteps(previousUpdateStep, updateStep);
						getNecessaryUpdateSteps().add(updateStep);
						previousUpdateStep = updateStep;
					}
				}
			}
		}

		int numberOfUpdatedItems = 0;

		if (getNecessaryUpdateSteps().size() > 0) {
			System.out.println("Starting updateÉ");
			for (ProjectHistory projectHistory : serverSpace.getProjects()) {
				for (UpdateStep updateStep : getNecessaryUpdateSteps()) {
					System.out.println("Performing update: " + updateStep.getTitle());
					System.out.println("Updating from version " + updateStep.getSourceVersion() + " to version "
						+ updateStep.getTargetVersion());

					numberOfUpdatedItems += updateStep.updateProjectHistory(projectHistory);
				}
			}
		}

		versionInformation.setEmfStoreVersion(EmfStoreImpl.getModelVersion());

		try {
			serverSpace.eResource().save(null);
		} catch (IOException e) {
			throw new FatalEmfStoreException(StorageException.NOSAVE, e);
		}

		if (getNecessaryUpdateSteps().size() > 0) {
			try {
				EList<Resource> resources = serverSpace.eResource().getResourceSet().getResources();
				for (Resource currentResource : resources) {
					currentResource.save(null);
				}
				System.out.println("Successfully updated " + numberOfUpdatedItems + " items");
			} catch (IOException e) {
				throw new FatalEmfStoreException(StorageException.NOSAVE, e);
			}
		}
	}

	private void checkForMissingSteps(UpdateStep previousUpdateStep, UpdateStep updateStep) {
		if (previousUpdateStep != null && !previousUpdateStep.getSourceVersion().equals(updateStep.getSourceVersion())) {
			if (previousUpdateStep.getTargetVersion().equals(updateStep.getSourceVersion())) {
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("Explicit update step from ");
				stringBuilder.append(previousUpdateStep.getTargetVersion());
				stringBuilder.append(" to ");
				stringBuilder.append(updateStep.getSourceVersion());
				stringBuilder.append(" is missing!");
				LOGGER.warn(stringBuilder.toString());
			}
		}
	}

}
