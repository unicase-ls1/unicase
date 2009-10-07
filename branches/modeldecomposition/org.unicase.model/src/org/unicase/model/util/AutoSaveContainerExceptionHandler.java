/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.util;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Handles exceptions of {@link AutoSaveContainer}.
 * 
 * @author koegel
 */
public interface AutoSaveContainerExceptionHandler {

	/**
	 * Handle an IOException on save.
	 * 
	 * @param object the object that was about to be saved.
	 * @param resource the resource that was about to be saved.
	 * @param exception the {@link IOException} that occured
	 */
	void handleExceptionOnSave(EObject object, Resource resource, IOException exception);

}
