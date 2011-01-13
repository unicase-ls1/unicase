/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecp.model.workSpaceModel;

import org.eclipse.emf.ecore.EObject;

/**
 * Listens to any change in a project.
 * 
 * @author helming
 */
public interface ECPProjectListener {
	/**
	 * called if a project changes.
	 */
	void projectChanged();

	/**
	 * Called if a modelelement gets deleted.
	 * 
	 * @param eobject the deleted eobject
	 */
	void modelelementDeleted(EObject eobject);

	/**
	 * called if the project gets deleted.
	 */
	void projectDeleted();

}
