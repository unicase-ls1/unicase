/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation.recommendationStrategies.updateableStrategies;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;

/**
 * This interface indiates that the implementing class can be updated with change packages.
 * 
 * @author Henning Femmer
 */
public interface Updateable {

	/**
	 * Updates the data of the strategy with a new ProjectAnalysisData object.
	 * 
	 * @param cp the change packages
	 */
	void updateStrategyData(ChangePackage cp);
}
