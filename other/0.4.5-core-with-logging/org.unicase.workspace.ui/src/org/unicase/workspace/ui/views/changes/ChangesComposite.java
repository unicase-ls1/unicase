/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.changes;

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
	 * @param changes
	 *            the new ChangePackages
	 */
	void setInput(List<ChangePackage> changes);

}
