/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.update;

import org.osgi.framework.Version;
import org.unicase.emfstore.esmodel.ProjectHistory;

/**
 * @author schroech
 */
public interface UpdateStep {

	/**
	 * @return The title of the update step, printed to the console during execution
	 */
	String getTitle();

	/**
	 * @return The emf store version from which this update step can update
	 */
	Version getSourceVersion();

	/**
	 * @return The emf store version to which this update step can update
	 */
	Version getTargetVersion();

	/**
	 * @param projectHistory The project history which is to be updated
	 * @return The number of model elements that were actually updated
	 */
	int updateProjectHistory(ProjectHistory projectHistory);
}
