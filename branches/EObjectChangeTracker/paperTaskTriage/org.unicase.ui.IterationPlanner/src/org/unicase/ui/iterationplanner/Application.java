/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.ui.iterationplanner.paper.imperative.PaperImperative;
import org.unicase.ui.iterationplanner.paper.machinelearning.PaperMachineLearning;

/**
 * @author Hodaie
 */
public class Application implements IApplication {

	private static final boolean IMPERATIVE_APPROACH = false;

	// BEGIN SUPRESS CATCH EXCEPTION
	/**
	 * {@inheritDoc}
	 * 
	 * @throws Exception exception
	 */
	public Object start(IApplicationContext context) throws Exception {

		
		if (IMPERATIVE_APPROACH) {
			
			new PaperImperative().start();
		} else {
			new PaperMachineLearning().start();
		}
		return null;

	}

	/**
	 * {@inheritDoc}
	 */
	public void stop() {

	}

	// END SUPRESS CATCH BLOCK
}
