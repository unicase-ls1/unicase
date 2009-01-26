package org.unicase.workspace.edit.views.changes;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;

/**
 * An interface for all types of chnages tree composites.
 * 
 * @author Shterev
 */
public interface ChangesComposite {

	/**
	 * Getter for the change packages.
	 * 
	 * @return input ChangePackages
	 */
	List<ChangePackage> getChangePackages();

	/**
	 * Sets the input for this composite.
	 * 
	 * @param changes the new ChangePackages
	 */
	void setInput(List<ChangePackage> changes);

}
