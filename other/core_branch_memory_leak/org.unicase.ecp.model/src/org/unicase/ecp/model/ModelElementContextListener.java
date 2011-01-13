/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecp.model;

/**
 * Listens to the changes of a context.
 * 
 * @author helming
 */
public abstract class ModelElementContextListener {
	/**
	 * Called if the model element is deleted.
	 */
	public abstract void onModelElementDeleted();

	/**
	 * Called if the context is deleted.
	 */
	public abstract void onContextDeleted();
}
