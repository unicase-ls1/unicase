package org.unicase.emfstore.jdt;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.unicase.emfstore.jdt.exception.NoSuitableTeamSynchronizerException;

public class StandaloneMerger {

	private final Set<IFile> standaloneFilesToMerge;

	public StandaloneMerger(Set<IFile> standaloneFilesToMerge) {
		this.standaloneFilesToMerge = standaloneFilesToMerge;

		for (IFile standaloneFileToMerge : standaloneFilesToMerge) {
			IProject project = standaloneFileToMerge.getProject();
			try {
				ITeamSynchronizer teamSynchronizer = TeamSynchronizerRegistry.getTeamSynchronizer(project);

			} catch (NoSuitableTeamSynchronizerException e) {
				// ModelUtil.logException(e);
			}

		}
	}

}
