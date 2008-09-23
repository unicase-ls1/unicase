package org.unicase.workspace.util;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;

/**
 * Notifies the UI that a list of changes will be automatically merged with the current model state. 
 */
public interface UpdateObserver {
	
	/**
	 * @param changePackages a list of change packages
	 * @return if an update clearance is set
	 */
	boolean inspectChanges(List<ChangePackage> changePackages);
	
}
